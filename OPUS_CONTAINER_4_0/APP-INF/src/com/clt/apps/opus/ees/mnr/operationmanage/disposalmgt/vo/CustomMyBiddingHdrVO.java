/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : CustomMyBiddingHdrVO.java
*@FileTitle : CustomMyBiddingHdrVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.18
*@LastModifier : 김완규
*@LastVersion : 1.0
* 2010.02.18 김완규 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.ees.mnr.operationmanage.disposalmgt.vo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 김완규
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class CustomMyBiddingHdrVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<CustomMyBiddingHdrVO> models = new ArrayList<CustomMyBiddingHdrVO>();
	
	/* Column Info */
	private String dispUtTpNm = null;
	/* Column Info */
	private String partUtAmt = null;
	/* Column Info */
	private String dispPkupPeriod = null;
	/* Column Info */
	private String currCd = null;
	/* Column Info */
	private String mnrDispRmk = null;
	/* Column Info */
	private String dispNo = null;
	/* Column Info */
	private String leftTime = null;
	/* Column Info */
	private String dispCfmQty = null;
	/* Column Info */
	private String dispQty = null;
	/* Column Info */
	private String aproDt = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String partDispQty = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String dispStDt = null;
	/* Column Info */
	private String biddingStatus = null;
	/* Column Info */
	private String dispUtTpCd = null;
	/* Column Info */
	private String fileSeq = null;
	/* Column Info */
	private String dispUtPrc = null;
	/* Column Info */
	private String dispEndDt = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public CustomMyBiddingHdrVO() {}

	public CustomMyBiddingHdrVO(String ibflag, String pagerows, String partUtAmt, String dispPkupPeriod, String currCd, String mnrDispRmk, String dispNo, String leftTime, String dispQty, String aproDt, String partDispQty, String dispStDt, String biddingStatus, String dispUtPrc, String fileSeq, String dispEndDt, String dispCfmQty, String dispUtTpCd, String dispUtTpNm) {
		this.dispUtTpNm = dispUtTpNm;
		this.partUtAmt = partUtAmt;
		this.dispPkupPeriod = dispPkupPeriod;
		this.currCd = currCd;
		this.mnrDispRmk = mnrDispRmk;
		this.dispNo = dispNo;
		this.leftTime = leftTime;
		this.dispCfmQty = dispCfmQty;
		this.dispQty = dispQty;
		this.aproDt = aproDt;
		this.pagerows = pagerows;
		this.partDispQty = partDispQty;
		this.ibflag = ibflag;
		this.dispStDt = dispStDt;
		this.biddingStatus = biddingStatus;
		this.dispUtTpCd = dispUtTpCd;
		this.fileSeq = fileSeq;
		this.dispUtPrc = dispUtPrc;
		this.dispEndDt = dispEndDt;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("disp_ut_tp_nm", getDispUtTpNm());
		this.hashColumns.put("part_ut_amt", getPartUtAmt());
		this.hashColumns.put("disp_pkup_period", getDispPkupPeriod());
		this.hashColumns.put("curr_cd", getCurrCd());
		this.hashColumns.put("mnr_disp_rmk", getMnrDispRmk());
		this.hashColumns.put("disp_no", getDispNo());
		this.hashColumns.put("left_time", getLeftTime());
		this.hashColumns.put("disp_cfm_qty", getDispCfmQty());
		this.hashColumns.put("disp_qty", getDispQty());
		this.hashColumns.put("apro_dt", getAproDt());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("part_disp_qty", getPartDispQty());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("disp_st_dt", getDispStDt());
		this.hashColumns.put("bidding_status", getBiddingStatus());
		this.hashColumns.put("disp_ut_tp_cd", getDispUtTpCd());
		this.hashColumns.put("file_seq", getFileSeq());
		this.hashColumns.put("disp_ut_prc", getDispUtPrc());
		this.hashColumns.put("disp_end_dt", getDispEndDt());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("disp_ut_tp_nm", "dispUtTpNm");
		this.hashFields.put("part_ut_amt", "partUtAmt");
		this.hashFields.put("disp_pkup_period", "dispPkupPeriod");
		this.hashFields.put("curr_cd", "currCd");
		this.hashFields.put("mnr_disp_rmk", "mnrDispRmk");
		this.hashFields.put("disp_no", "dispNo");
		this.hashFields.put("left_time", "leftTime");
		this.hashFields.put("disp_cfm_qty", "dispCfmQty");
		this.hashFields.put("disp_qty", "dispQty");
		this.hashFields.put("apro_dt", "aproDt");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("part_disp_qty", "partDispQty");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("disp_st_dt", "dispStDt");
		this.hashFields.put("bidding_status", "biddingStatus");
		this.hashFields.put("disp_ut_tp_cd", "dispUtTpCd");
		this.hashFields.put("file_seq", "fileSeq");
		this.hashFields.put("disp_ut_prc", "dispUtPrc");
		this.hashFields.put("disp_end_dt", "dispEndDt");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return dispUtTpNm
	 */
	public String getDispUtTpNm() {
		return this.dispUtTpNm;
	}
	
	/**
	 * Column Info
	 * @return partUtAmt
	 */
	public String getPartUtAmt() {
		return this.partUtAmt;
	}
	
	/**
	 * Column Info
	 * @return dispPkupPeriod
	 */
	public String getDispPkupPeriod() {
		return this.dispPkupPeriod;
	}
	
	/**
	 * Column Info
	 * @return currCd
	 */
	public String getCurrCd() {
		return this.currCd;
	}
	
	/**
	 * Column Info
	 * @return mnrDispRmk
	 */
	public String getMnrDispRmk() {
		return this.mnrDispRmk;
	}
	
	/**
	 * Column Info
	 * @return dispNo
	 */
	public String getDispNo() {
		return this.dispNo;
	}
	
	/**
	 * Column Info
	 * @return leftTime
	 */
	public String getLeftTime() {
		return this.leftTime;
	}
	
	/**
	 * Column Info
	 * @return dispCfmQty
	 */
	public String getDispCfmQty() {
		return this.dispCfmQty;
	}
	
	/**
	 * Column Info
	 * @return dispQty
	 */
	public String getDispQty() {
		return this.dispQty;
	}
	
	/**
	 * Column Info
	 * @return aproDt
	 */
	public String getAproDt() {
		return this.aproDt;
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
	 * @return partDispQty
	 */
	public String getPartDispQty() {
		return this.partDispQty;
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
	 * @return dispStDt
	 */
	public String getDispStDt() {
		return this.dispStDt;
	}
	
	/**
	 * Column Info
	 * @return biddingStatus
	 */
	public String getBiddingStatus() {
		return this.biddingStatus;
	}
	
	/**
	 * Column Info
	 * @return dispUtTpCd
	 */
	public String getDispUtTpCd() {
		return this.dispUtTpCd;
	}
	
	/**
	 * Column Info
	 * @return fileSeq
	 */
	public String getFileSeq() {
		return this.fileSeq;
	}
	
	/**
	 * Column Info
	 * @return dispUtPrc
	 */
	public String getDispUtPrc() {
		return this.dispUtPrc;
	}
	
	/**
	 * Column Info
	 * @return dispEndDt
	 */
	public String getDispEndDt() {
		return this.dispEndDt;
	}
	

	/**
	 * Column Info
	 * @param dispUtTpNm
	 */
	public void setDispUtTpNm(String dispUtTpNm) {
		this.dispUtTpNm = dispUtTpNm;
	}
	
	/**
	 * Column Info
	 * @param partUtAmt
	 */
	public void setPartUtAmt(String partUtAmt) {
		this.partUtAmt = partUtAmt;
	}
	
	/**
	 * Column Info
	 * @param dispPkupPeriod
	 */
	public void setDispPkupPeriod(String dispPkupPeriod) {
		this.dispPkupPeriod = dispPkupPeriod;
	}
	
	/**
	 * Column Info
	 * @param currCd
	 */
	public void setCurrCd(String currCd) {
		this.currCd = currCd;
	}
	
	/**
	 * Column Info
	 * @param mnrDispRmk
	 */
	public void setMnrDispRmk(String mnrDispRmk) {
		this.mnrDispRmk = mnrDispRmk;
	}
	
	/**
	 * Column Info
	 * @param dispNo
	 */
	public void setDispNo(String dispNo) {
		this.dispNo = dispNo;
	}
	
	/**
	 * Column Info
	 * @param leftTime
	 */
	public void setLeftTime(String leftTime) {
		this.leftTime = leftTime;
	}
	
	/**
	 * Column Info
	 * @param dispCfmQty
	 */
	public void setDispCfmQty(String dispCfmQty) {
		this.dispCfmQty = dispCfmQty;
	}
	
	/**
	 * Column Info
	 * @param dispQty
	 */
	public void setDispQty(String dispQty) {
		this.dispQty = dispQty;
	}
	
	/**
	 * Column Info
	 * @param aproDt
	 */
	public void setAproDt(String aproDt) {
		this.aproDt = aproDt;
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
	 * @param partDispQty
	 */
	public void setPartDispQty(String partDispQty) {
		this.partDispQty = partDispQty;
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
	 * @param dispStDt
	 */
	public void setDispStDt(String dispStDt) {
		this.dispStDt = dispStDt;
	}
	
	/**
	 * Column Info
	 * @param biddingStatus
	 */
	public void setBiddingStatus(String biddingStatus) {
		this.biddingStatus = biddingStatus;
	}
	
	/**
	 * Column Info
	 * @param dispUtTpCd
	 */
	public void setDispUtTpCd(String dispUtTpCd) {
		this.dispUtTpCd = dispUtTpCd;
	}
	
	/**
	 * Column Info
	 * @param fileSeq
	 */
	public void setFileSeq(String fileSeq) {
		this.fileSeq = fileSeq;
	}
	
	/**
	 * Column Info
	 * @param dispUtPrc
	 */
	public void setDispUtPrc(String dispUtPrc) {
		this.dispUtPrc = dispUtPrc;
	}
	
	/**
	 * Column Info
	 * @param dispEndDt
	 */
	public void setDispEndDt(String dispEndDt) {
		this.dispEndDt = dispEndDt;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setDispUtTpNm(JSPUtil.getParameter(request, "disp_ut_tp_nm", ""));
		setPartUtAmt(JSPUtil.getParameter(request, "part_ut_amt", ""));
		setDispPkupPeriod(JSPUtil.getParameter(request, "disp_pkup_period", ""));
		setCurrCd(JSPUtil.getParameter(request, "curr_cd", ""));
		setMnrDispRmk(JSPUtil.getParameter(request, "mnr_disp_rmk", ""));
		setDispNo(JSPUtil.getParameter(request, "disp_no", ""));
		setLeftTime(JSPUtil.getParameter(request, "left_time", ""));
		setDispCfmQty(JSPUtil.getParameter(request, "disp_cfm_qty", ""));
		setDispQty(JSPUtil.getParameter(request, "disp_qty", ""));
		setAproDt(JSPUtil.getParameter(request, "apro_dt", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setPartDispQty(JSPUtil.getParameter(request, "part_disp_qty", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setDispStDt(JSPUtil.getParameter(request, "disp_st_dt", ""));
		setBiddingStatus(JSPUtil.getParameter(request, "bidding_status", ""));
		setDispUtTpCd(JSPUtil.getParameter(request, "disp_ut_tp_cd", ""));
		setFileSeq(JSPUtil.getParameter(request, "file_seq", ""));
		setDispUtPrc(JSPUtil.getParameter(request, "disp_ut_prc", ""));
		setDispEndDt(JSPUtil.getParameter(request, "disp_end_dt", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return CustomMyBiddingHdrVO[]
	 */
	public CustomMyBiddingHdrVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return CustomMyBiddingHdrVO[]
	 */
	public CustomMyBiddingHdrVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		CustomMyBiddingHdrVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] dispUtTpNm = (JSPUtil.getParameter(request, prefix	+ "disp_ut_tp_nm", length));
			String[] partUtAmt = (JSPUtil.getParameter(request, prefix	+ "part_ut_amt", length));
			String[] dispPkupPeriod = (JSPUtil.getParameter(request, prefix	+ "disp_pkup_period", length));
			String[] currCd = (JSPUtil.getParameter(request, prefix	+ "curr_cd", length));
			String[] mnrDispRmk = (JSPUtil.getParameter(request, prefix	+ "mnr_disp_rmk", length));
			String[] dispNo = (JSPUtil.getParameter(request, prefix	+ "disp_no", length));
			String[] leftTime = (JSPUtil.getParameter(request, prefix	+ "left_time", length));
			String[] dispCfmQty = (JSPUtil.getParameter(request, prefix	+ "disp_cfm_qty", length));
			String[] dispQty = (JSPUtil.getParameter(request, prefix	+ "disp_qty", length));
			String[] aproDt = (JSPUtil.getParameter(request, prefix	+ "apro_dt", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] partDispQty = (JSPUtil.getParameter(request, prefix	+ "part_disp_qty", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] dispStDt = (JSPUtil.getParameter(request, prefix	+ "disp_st_dt", length));
			String[] biddingStatus = (JSPUtil.getParameter(request, prefix	+ "bidding_status", length));
			String[] dispUtTpCd = (JSPUtil.getParameter(request, prefix	+ "disp_ut_tp_cd", length));
			String[] fileSeq = (JSPUtil.getParameter(request, prefix	+ "file_seq", length));
			String[] dispUtPrc = (JSPUtil.getParameter(request, prefix	+ "disp_ut_prc", length));
			String[] dispEndDt = (JSPUtil.getParameter(request, prefix	+ "disp_end_dt", length));
			
			for (int i = 0; i < length; i++) {
				model = new CustomMyBiddingHdrVO();
				if (dispUtTpNm[i] != null)
					model.setDispUtTpNm(dispUtTpNm[i]);
				if (partUtAmt[i] != null)
					model.setPartUtAmt(partUtAmt[i]);
				if (dispPkupPeriod[i] != null)
					model.setDispPkupPeriod(dispPkupPeriod[i]);
				if (currCd[i] != null)
					model.setCurrCd(currCd[i]);
				if (mnrDispRmk[i] != null)
					model.setMnrDispRmk(mnrDispRmk[i]);
				if (dispNo[i] != null)
					model.setDispNo(dispNo[i]);
				if (leftTime[i] != null)
					model.setLeftTime(leftTime[i]);
				if (dispCfmQty[i] != null)
					model.setDispCfmQty(dispCfmQty[i]);
				if (dispQty[i] != null)
					model.setDispQty(dispQty[i]);
				if (aproDt[i] != null)
					model.setAproDt(aproDt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (partDispQty[i] != null)
					model.setPartDispQty(partDispQty[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (dispStDt[i] != null)
					model.setDispStDt(dispStDt[i]);
				if (biddingStatus[i] != null)
					model.setBiddingStatus(biddingStatus[i]);
				if (dispUtTpCd[i] != null)
					model.setDispUtTpCd(dispUtTpCd[i]);
				if (fileSeq[i] != null)
					model.setFileSeq(fileSeq[i]);
				if (dispUtPrc[i] != null)
					model.setDispUtPrc(dispUtPrc[i]);
				if (dispEndDt[i] != null)
					model.setDispEndDt(dispEndDt[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getCustomMyBiddingHdrVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return CustomMyBiddingHdrVO[]
	 */
	public CustomMyBiddingHdrVO[] getCustomMyBiddingHdrVOs(){
		CustomMyBiddingHdrVO[] vos = (CustomMyBiddingHdrVO[])models.toArray(new CustomMyBiddingHdrVO[models.size()]);
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
		this.dispUtTpNm = this.dispUtTpNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.partUtAmt = this.partUtAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dispPkupPeriod = this.dispPkupPeriod .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.currCd = this.currCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnrDispRmk = this.mnrDispRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dispNo = this.dispNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.leftTime = this.leftTime .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dispCfmQty = this.dispCfmQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dispQty = this.dispQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aproDt = this.aproDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.partDispQty = this.partDispQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dispStDt = this.dispStDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.biddingStatus = this.biddingStatus .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dispUtTpCd = this.dispUtTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fileSeq = this.fileSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dispUtPrc = this.dispUtPrc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dispEndDt = this.dispEndDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
