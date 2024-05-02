/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : SOCostInfoVO.java
*@FileTitle : SOCostInfoVO
*Open Issues :
*Change history :
*@LastModifyDate : 2014.12.05
*@LastModifier : 
*@LastVersion : 1.0
* 2014.12.05  
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esd.sce.copmanage.copsearch.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.hanjin.framework.component.common.AbstractValueObject;
import com.hanjin.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SearchSOCostInfoVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchSOCostInfoVO> models = new ArrayList<SearchSOCostInfoVO>();
	
	/* Column Info */
	private String soDt = null;
	/* Column Info */
	private String copNo = null;
	/* Column Info */
	private String soNum = null;
	/* Column Info */
	private String vndrAbbrNmAct = null;
	/* Column Info */
	private String ctrlOfcCd = null;
	/* Column Info */
	private String fmTo = null;
	/* Page Number */
	private String pagerows = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String costActGrpSeq = null;
	/* Column Info */
	private String userId = null;
	/* Column Info */
	private String soRmk2 = null;
	/* Column Info */
	private String woNo = null;
	/* Column Info */
	private String soRmk3 = null;
	/* Column Info */
	private String spHNo = null;
	/* Column Info */
	private String vndrAbbrNm = null;
	/* Column Info */
	private String trspSoStsCd = null;
	/* Column Info */
	private String soRmk1 = null;
	/* Column Info */
	private String trspSoSts = null;
	/* Column Info */
	private String woDt = null;
	/* Column Info */
	private String costActGrpNm = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public SearchSOCostInfoVO() {}

	public SearchSOCostInfoVO(String ibflag, String pagerows, String soDt, String copNo, String soNum, String ctrlOfcCd, String fmTo, String costActGrpSeq, String userId, String soRmk2, String woNo, String soRmk3, String spHNo, String vndrAbbrNm, String soRmk1, String woDt, String trspSoSts, String trspSoStsCd, String costActGrpNm, String vndrAbbrNmAct) {
		this.soDt = soDt;
		this.copNo = copNo;
		this.soNum = soNum;
		this.vndrAbbrNmAct = vndrAbbrNmAct;
		this.ctrlOfcCd = ctrlOfcCd;
		this.fmTo = fmTo;
		this.pagerows = pagerows;
		this.ibflag = ibflag;
		this.costActGrpSeq = costActGrpSeq;
		this.userId = userId;
		this.soRmk2 = soRmk2;
		this.woNo = woNo;
		this.soRmk3 = soRmk3;
		this.spHNo = spHNo;
		this.vndrAbbrNm = vndrAbbrNm;
		this.trspSoStsCd = trspSoStsCd;
		this.soRmk1 = soRmk1;
		this.trspSoSts = trspSoSts;
		this.woDt = woDt;
		this.costActGrpNm = costActGrpNm;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("so_dt", getSoDt());
		this.hashColumns.put("cop_no", getCopNo());
		this.hashColumns.put("so_num", getSoNum());
		this.hashColumns.put("vndr_abbr_nm_act", getVndrAbbrNmAct());
		this.hashColumns.put("ctrl_ofc_cd", getCtrlOfcCd());
		this.hashColumns.put("fm_to", getFmTo());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cost_act_grp_seq", getCostActGrpSeq());
		this.hashColumns.put("user_id", getUserId());
		this.hashColumns.put("so_rmk2", getSoRmk2());
		this.hashColumns.put("wo_no", getWoNo());
		this.hashColumns.put("so_rmk3", getSoRmk3());
		this.hashColumns.put("sp_h_no", getSpHNo());
		this.hashColumns.put("vndr_abbr_nm", getVndrAbbrNm());
		this.hashColumns.put("trsp_so_sts_cd", getTrspSoStsCd());
		this.hashColumns.put("so_rmk1", getSoRmk1());
		this.hashColumns.put("trsp_so_sts", getTrspSoSts());
		this.hashColumns.put("wo_dt", getWoDt());
		this.hashColumns.put("cost_act_grp_nm", getCostActGrpNm());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("so_dt", "soDt");
		this.hashFields.put("cop_no", "copNo");
		this.hashFields.put("so_num", "soNum");
		this.hashFields.put("vndr_abbr_nm_act", "vndrAbbrNmAct");
		this.hashFields.put("ctrl_ofc_cd", "ctrlOfcCd");
		this.hashFields.put("fm_to", "fmTo");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cost_act_grp_seq", "costActGrpSeq");
		this.hashFields.put("user_id", "userId");
		this.hashFields.put("so_rmk2", "soRmk2");
		this.hashFields.put("wo_no", "woNo");
		this.hashFields.put("so_rmk3", "soRmk3");
		this.hashFields.put("sp_h_no", "spHNo");
		this.hashFields.put("vndr_abbr_nm", "vndrAbbrNm");
		this.hashFields.put("trsp_so_sts_cd", "trspSoStsCd");
		this.hashFields.put("so_rmk1", "soRmk1");
		this.hashFields.put("trsp_so_sts", "trspSoSts");
		this.hashFields.put("wo_dt", "woDt");
		this.hashFields.put("cost_act_grp_nm", "costActGrpNm");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return soDt
	 */
	public String getSoDt() {
		return this.soDt;
	}
	
	/**
	 * Column Info
	 * @return copNo
	 */
	public String getCopNo() {
		return this.copNo;
	}
	
	/**
	 * Column Info
	 * @return soNum
	 */
	public String getSoNum() {
		return this.soNum;
	}
	
	/**
	 * Column Info
	 * @return vndrAbbrNmAct
	 */
	public String getVndrAbbrNmAct() {
		return this.vndrAbbrNmAct;
	}
	
	/**
	 * Column Info
	 * @return ctrlOfcCd
	 */
	public String getCtrlOfcCd() {
		return this.ctrlOfcCd;
	}
	
	/**
	 * Column Info
	 * @return fmTo
	 */
	public String getFmTo() {
		return this.fmTo;
	}
	
	/**
	 * Page Number
	 * @return pagerows
	 */
	public String getPagerows() {
		return this.pagerows;
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
	 * @return costActGrpSeq
	 */
	public String getCostActGrpSeq() {
		return this.costActGrpSeq;
	}
	
	/**
	 * Column Info
	 * @return userId
	 */
	public String getUserId() {
		return this.userId;
	}
	
	/**
	 * Column Info
	 * @return soRmk2
	 */
	public String getSoRmk2() {
		return this.soRmk2;
	}
	
	/**
	 * Column Info
	 * @return woNo
	 */
	public String getWoNo() {
		return this.woNo;
	}
	
	/**
	 * Column Info
	 * @return soRmk3
	 */
	public String getSoRmk3() {
		return this.soRmk3;
	}
	
	/**
	 * Column Info
	 * @return spHNo
	 */
	public String getSpHNo() {
		return this.spHNo;
	}
	
	/**
	 * Column Info
	 * @return vndrAbbrNm
	 */
	public String getVndrAbbrNm() {
		return this.vndrAbbrNm;
	}
	
	/**
	 * Column Info
	 * @return trspSoStsCd
	 */
	public String getTrspSoStsCd() {
		return this.trspSoStsCd;
	}
	
	/**
	 * Column Info
	 * @return soRmk1
	 */
	public String getSoRmk1() {
		return this.soRmk1;
	}
	
	/**
	 * Column Info
	 * @return trspSoSts
	 */
	public String getTrspSoSts() {
		return this.trspSoSts;
	}
	
	/**
	 * Column Info
	 * @return woDt
	 */
	public String getWoDt() {
		return this.woDt;
	}
	
	/**
	 * Column Info
	 * @return costActGrpNm
	 */
	public String getCostActGrpNm() {
		return this.costActGrpNm;
	}
	

	/**
	 * Column Info
	 * @param soDt
	 */
	public void setSoDt(String soDt) {
		this.soDt = soDt;
	}
	
	/**
	 * Column Info
	 * @param copNo
	 */
	public void setCopNo(String copNo) {
		this.copNo = copNo;
	}
	
	/**
	 * Column Info
	 * @param soNum
	 */
	public void setSoNum(String soNum) {
		this.soNum = soNum;
	}
	
	/**
	 * Column Info
	 * @param vndrAbbrNmAct
	 */
	public void setVndrAbbrNmAct(String vndrAbbrNmAct) {
		this.vndrAbbrNmAct = vndrAbbrNmAct;
	}
	
	/**
	 * Column Info
	 * @param ctrlOfcCd
	 */
	public void setCtrlOfcCd(String ctrlOfcCd) {
		this.ctrlOfcCd = ctrlOfcCd;
	}
	
	/**
	 * Column Info
	 * @param fmTo
	 */
	public void setFmTo(String fmTo) {
		this.fmTo = fmTo;
	}
	
	/**
	 * Page Number
	 * @param pagerows
	 */
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
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
	 * @param costActGrpSeq
	 */
	public void setCostActGrpSeq(String costActGrpSeq) {
		this.costActGrpSeq = costActGrpSeq;
	}
	
	/**
	 * Column Info
	 * @param userId
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	/**
	 * Column Info
	 * @param soRmk2
	 */
	public void setSoRmk2(String soRmk2) {
		this.soRmk2 = soRmk2;
	}
	
	/**
	 * Column Info
	 * @param woNo
	 */
	public void setWoNo(String woNo) {
		this.woNo = woNo;
	}
	
	/**
	 * Column Info
	 * @param soRmk3
	 */
	public void setSoRmk3(String soRmk3) {
		this.soRmk3 = soRmk3;
	}
	
	/**
	 * Column Info
	 * @param spHNo
	 */
	public void setSpHNo(String spHNo) {
		this.spHNo = spHNo;
	}
	
	/**
	 * Column Info
	 * @param vndrAbbrNm
	 */
	public void setVndrAbbrNm(String vndrAbbrNm) {
		this.vndrAbbrNm = vndrAbbrNm;
	}
	
	/**
	 * Column Info
	 * @param trspSoStsCd
	 */
	public void setTrspSoStsCd(String trspSoStsCd) {
		this.trspSoStsCd = trspSoStsCd;
	}
	
	/**
	 * Column Info
	 * @param soRmk1
	 */
	public void setSoRmk1(String soRmk1) {
		this.soRmk1 = soRmk1;
	}
	
	/**
	 * Column Info
	 * @param trspSoSts
	 */
	public void setTrspSoSts(String trspSoSts) {
		this.trspSoSts = trspSoSts;
	}
	
	/**
	 * Column Info
	 * @param woDt
	 */
	public void setWoDt(String woDt) {
		this.woDt = woDt;
	}
	
	/**
	 * Column Info
	 * @param costActGrpNm
	 */
	public void setCostActGrpNm(String costActGrpNm) {
		this.costActGrpNm = costActGrpNm;
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
		setSoDt(JSPUtil.getParameter(request, prefix + "so_dt", ""));
		setCopNo(JSPUtil.getParameter(request, prefix + "cop_no", ""));
		setSoNum(JSPUtil.getParameter(request, prefix + "so_num", ""));
		setVndrAbbrNmAct(JSPUtil.getParameter(request, prefix + "vndr_abbr_nm_act", ""));
		setCtrlOfcCd(JSPUtil.getParameter(request, prefix + "ctrl_ofc_cd", ""));
		setFmTo(JSPUtil.getParameter(request, prefix + "fm_to", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setCostActGrpSeq(JSPUtil.getParameter(request, prefix + "cost_act_grp_seq", ""));
		setUserId(JSPUtil.getParameter(request, prefix + "user_id", ""));
		setSoRmk2(JSPUtil.getParameter(request, prefix + "so_rmk2", ""));
		setWoNo(JSPUtil.getParameter(request, prefix + "wo_no", ""));
		setSoRmk3(JSPUtil.getParameter(request, prefix + "so_rmk3", ""));
		setSpHNo(JSPUtil.getParameter(request, prefix + "sp_h_no", ""));
		setVndrAbbrNm(JSPUtil.getParameter(request, prefix + "vndr_abbr_nm", ""));
		setTrspSoStsCd(JSPUtil.getParameter(request, prefix + "trsp_so_sts_cd", ""));
		setSoRmk1(JSPUtil.getParameter(request, prefix + "so_rmk1", ""));
		setTrspSoSts(JSPUtil.getParameter(request, prefix + "trsp_so_sts", ""));
		setWoDt(JSPUtil.getParameter(request, prefix + "wo_dt", ""));
		setCostActGrpNm(JSPUtil.getParameter(request, prefix + "cost_act_grp_nm", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SOCostInfoVO[]
	 */
	public SearchSOCostInfoVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SOCostInfoVO[]
	 */
	public SearchSOCostInfoVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchSOCostInfoVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] soDt = (JSPUtil.getParameter(request, prefix	+ "so_dt", length));
			String[] copNo = (JSPUtil.getParameter(request, prefix	+ "cop_no", length));
			String[] soNum = (JSPUtil.getParameter(request, prefix	+ "so_num", length));
			String[] vndrAbbrNmAct = (JSPUtil.getParameter(request, prefix	+ "vndr_abbr_nm_act", length));
			String[] ctrlOfcCd = (JSPUtil.getParameter(request, prefix	+ "ctrl_ofc_cd", length));
			String[] fmTo = (JSPUtil.getParameter(request, prefix	+ "fm_to", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] costActGrpSeq = (JSPUtil.getParameter(request, prefix	+ "cost_act_grp_seq", length));
			String[] userId = (JSPUtil.getParameter(request, prefix	+ "user_id", length));
			String[] soRmk2 = (JSPUtil.getParameter(request, prefix	+ "so_rmk2", length));
			String[] woNo = (JSPUtil.getParameter(request, prefix	+ "wo_no", length));
			String[] soRmk3 = (JSPUtil.getParameter(request, prefix	+ "so_rmk3", length));
			String[] spHNo = (JSPUtil.getParameter(request, prefix	+ "sp_h_no", length));
			String[] vndrAbbrNm = (JSPUtil.getParameter(request, prefix	+ "vndr_abbr_nm", length));
			String[] trspSoStsCd = (JSPUtil.getParameter(request, prefix	+ "trsp_so_sts_cd", length));
			String[] soRmk1 = (JSPUtil.getParameter(request, prefix	+ "so_rmk1", length));
			String[] trspSoSts = (JSPUtil.getParameter(request, prefix	+ "trsp_so_sts", length));
			String[] woDt = (JSPUtil.getParameter(request, prefix	+ "wo_dt", length));
			String[] costActGrpNm = (JSPUtil.getParameter(request, prefix	+ "cost_act_grp_nm", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchSOCostInfoVO();
				if (soDt[i] != null)
					model.setSoDt(soDt[i]);
				if (copNo[i] != null)
					model.setCopNo(copNo[i]);
				if (soNum[i] != null)
					model.setSoNum(soNum[i]);
				if (vndrAbbrNmAct[i] != null)
					model.setVndrAbbrNmAct(vndrAbbrNmAct[i]);
				if (ctrlOfcCd[i] != null)
					model.setCtrlOfcCd(ctrlOfcCd[i]);
				if (fmTo[i] != null)
					model.setFmTo(fmTo[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (costActGrpSeq[i] != null)
					model.setCostActGrpSeq(costActGrpSeq[i]);
				if (userId[i] != null)
					model.setUserId(userId[i]);
				if (soRmk2[i] != null)
					model.setSoRmk2(soRmk2[i]);
				if (woNo[i] != null)
					model.setWoNo(woNo[i]);
				if (soRmk3[i] != null)
					model.setSoRmk3(soRmk3[i]);
				if (spHNo[i] != null)
					model.setSpHNo(spHNo[i]);
				if (vndrAbbrNm[i] != null)
					model.setVndrAbbrNm(vndrAbbrNm[i]);
				if (trspSoStsCd[i] != null)
					model.setTrspSoStsCd(trspSoStsCd[i]);
				if (soRmk1[i] != null)
					model.setSoRmk1(soRmk1[i]);
				if (trspSoSts[i] != null)
					model.setTrspSoSts(trspSoSts[i]);
				if (woDt[i] != null)
					model.setWoDt(woDt[i]);
				if (costActGrpNm[i] != null)
					model.setCostActGrpNm(costActGrpNm[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchSOCostInfoVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SOCostInfoVO[]
	 */
	public SearchSOCostInfoVO[] getSearchSOCostInfoVOs(){
		SearchSOCostInfoVO[] vos = (SearchSOCostInfoVO[])models.toArray(new SearchSOCostInfoVO[models.size()]);
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
		this.soDt = this.soDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.copNo = this.copNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.soNum = this.soNum .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrAbbrNmAct = this.vndrAbbrNmAct .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrlOfcCd = this.ctrlOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmTo = this.fmTo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costActGrpSeq = this.costActGrpSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.userId = this.userId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.soRmk2 = this.soRmk2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.woNo = this.woNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.soRmk3 = this.soRmk3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.spHNo = this.spHNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrAbbrNm = this.vndrAbbrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trspSoStsCd = this.trspSoStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.soRmk1 = this.soRmk1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trspSoSts = this.trspSoSts .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.woDt = this.woDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costActGrpNm = this.costActGrpNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
