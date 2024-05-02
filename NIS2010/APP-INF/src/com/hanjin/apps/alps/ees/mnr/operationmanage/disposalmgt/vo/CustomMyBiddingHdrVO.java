/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : CustomMyBiddingHdrVO.java
*@FileTitle : CustomMyBiddingHdrVO
*Open Issues :
*Change history :
*@LastModifyDate : 2011.01.20
*@LastModifier : 박명신
*@LastVersion : 1.0
* 2011.01.20 박명신 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.ees.mnr.operationmanage.disposalmgt.vo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.hanjin.framework.component.common.AbstractValueObject;
import com.hanjin.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 박명신
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
	private String dispBultnDt = null;
	/* Column Info */
	private String aproDt = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String partDispQty = null;
	/* Column Info */
	private String dispStDt = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String biddingStatus = null;
	/* Column Info */
	private String dispUtTpCd = null;
	/* Column Info */
	private String dispUtPrc = null;
	/* Column Info */
	private String fileSeq = null;
	/* Column Info */
	private String dispEndDt = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public CustomMyBiddingHdrVO() {}

	public CustomMyBiddingHdrVO(String ibflag, String pagerows, String dispUtTpNm, String partUtAmt, String dispPkupPeriod, String currCd, String mnrDispRmk, String dispNo, String leftTime, String dispCfmQty, String dispQty, String aproDt, String partDispQty, String dispStDt, String biddingStatus, String dispUtTpCd, String fileSeq, String dispUtPrc, String dispEndDt, String dispBultnDt) {
		this.dispUtTpNm = dispUtTpNm;
		this.partUtAmt = partUtAmt;
		this.dispPkupPeriod = dispPkupPeriod;
		this.currCd = currCd;
		this.mnrDispRmk = mnrDispRmk;
		this.dispNo = dispNo;
		this.leftTime = leftTime;
		this.dispCfmQty = dispCfmQty;
		this.dispQty = dispQty;
		this.dispBultnDt = dispBultnDt;
		this.aproDt = aproDt;
		this.pagerows = pagerows;
		this.partDispQty = partDispQty;
		this.dispStDt = dispStDt;
		this.ibflag = ibflag;
		this.biddingStatus = biddingStatus;
		this.dispUtTpCd = dispUtTpCd;
		this.dispUtPrc = dispUtPrc;
		this.fileSeq = fileSeq;
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
		this.hashColumns.put("disp_bultn_dt", getDispBultnDt());
		this.hashColumns.put("apro_dt", getAproDt());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("part_disp_qty", getPartDispQty());
		this.hashColumns.put("disp_st_dt", getDispStDt());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("bidding_status", getBiddingStatus());
		this.hashColumns.put("disp_ut_tp_cd", getDispUtTpCd());
		this.hashColumns.put("disp_ut_prc", getDispUtPrc());
		this.hashColumns.put("file_seq", getFileSeq());
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
		this.hashFields.put("disp_bultn_dt", "dispBultnDt");
		this.hashFields.put("apro_dt", "aproDt");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("part_disp_qty", "partDispQty");
		this.hashFields.put("disp_st_dt", "dispStDt");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("bidding_status", "biddingStatus");
		this.hashFields.put("disp_ut_tp_cd", "dispUtTpCd");
		this.hashFields.put("disp_ut_prc", "dispUtPrc");
		this.hashFields.put("file_seq", "fileSeq");
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
	 * @return dispBultnDt
	 */
	public String getDispBultnDt() {
		return this.dispBultnDt;
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
	 * Column Info
	 * @return dispStDt
	 */
	public String getDispStDt() {
		return this.dispStDt;
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
	 * @return dispUtPrc
	 */
	public String getDispUtPrc() {
		return this.dispUtPrc;
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
	 * @param dispBultnDt
	 */
	public void setDispBultnDt(String dispBultnDt) {
		this.dispBultnDt = dispBultnDt;
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
	 * Column Info
	 * @param dispStDt
	 */
	public void setDispStDt(String dispStDt) {
		this.dispStDt = dispStDt;
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
	 * @param dispUtPrc
	 */
	public void setDispUtPrc(String dispUtPrc) {
		this.dispUtPrc = dispUtPrc;
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
		fromRequest(request,"");
	}

	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request, String prefix) {
		setDispUtTpNm(JSPUtil.getParameter(request, prefix + "disp_ut_tp_nm", ""));
		setPartUtAmt(JSPUtil.getParameter(request, prefix + "part_ut_amt", ""));
		setDispPkupPeriod(JSPUtil.getParameter(request, prefix + "disp_pkup_period", ""));
		setCurrCd(JSPUtil.getParameter(request, prefix + "curr_cd", ""));
		setMnrDispRmk(JSPUtil.getParameter(request, prefix + "mnr_disp_rmk", ""));
		setDispNo(JSPUtil.getParameter(request, prefix + "disp_no", ""));
		setLeftTime(JSPUtil.getParameter(request, prefix + "left_time", ""));
		setDispCfmQty(JSPUtil.getParameter(request, prefix + "disp_cfm_qty", ""));
		setDispQty(JSPUtil.getParameter(request, prefix + "disp_qty", ""));
		setDispBultnDt(JSPUtil.getParameter(request, prefix + "disp_bultn_dt", ""));
		setAproDt(JSPUtil.getParameter(request, prefix + "apro_dt", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setPartDispQty(JSPUtil.getParameter(request, prefix + "part_disp_qty", ""));
		setDispStDt(JSPUtil.getParameter(request, prefix + "disp_st_dt", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setBiddingStatus(JSPUtil.getParameter(request, prefix + "bidding_status", ""));
		setDispUtTpCd(JSPUtil.getParameter(request, prefix + "disp_ut_tp_cd", ""));
		setDispUtPrc(JSPUtil.getParameter(request, prefix + "disp_ut_prc", ""));
		setFileSeq(JSPUtil.getParameter(request, prefix + "file_seq", ""));
		setDispEndDt(JSPUtil.getParameter(request, prefix + "disp_end_dt", ""));
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
			String[] dispBultnDt = (JSPUtil.getParameter(request, prefix	+ "disp_bultn_dt", length));
			String[] aproDt = (JSPUtil.getParameter(request, prefix	+ "apro_dt", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] partDispQty = (JSPUtil.getParameter(request, prefix	+ "part_disp_qty", length));
			String[] dispStDt = (JSPUtil.getParameter(request, prefix	+ "disp_st_dt", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] biddingStatus = (JSPUtil.getParameter(request, prefix	+ "bidding_status", length));
			String[] dispUtTpCd = (JSPUtil.getParameter(request, prefix	+ "disp_ut_tp_cd", length));
			String[] dispUtPrc = (JSPUtil.getParameter(request, prefix	+ "disp_ut_prc", length));
			String[] fileSeq = (JSPUtil.getParameter(request, prefix	+ "file_seq", length));
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
				if (dispBultnDt[i] != null)
					model.setDispBultnDt(dispBultnDt[i]);
				if (aproDt[i] != null)
					model.setAproDt(aproDt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (partDispQty[i] != null)
					model.setPartDispQty(partDispQty[i]);
				if (dispStDt[i] != null)
					model.setDispStDt(dispStDt[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (biddingStatus[i] != null)
					model.setBiddingStatus(biddingStatus[i]);
				if (dispUtTpCd[i] != null)
					model.setDispUtTpCd(dispUtTpCd[i]);
				if (dispUtPrc[i] != null)
					model.setDispUtPrc(dispUtPrc[i]);
				if (fileSeq[i] != null)
					model.setFileSeq(fileSeq[i]);
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
		this.dispBultnDt = this.dispBultnDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aproDt = this.aproDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.partDispQty = this.partDispQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dispStDt = this.dispStDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.biddingStatus = this.biddingStatus .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dispUtTpCd = this.dispUtTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dispUtPrc = this.dispUtPrc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fileSeq = this.fileSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dispEndDt = this.dispEndDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
