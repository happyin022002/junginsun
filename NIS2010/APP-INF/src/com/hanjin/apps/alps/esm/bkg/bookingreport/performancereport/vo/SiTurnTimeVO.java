/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : SiTurnTimeVO.java
*@FileTitle : SiTurnTimeVO
*Open Issues :
*Change history :
*@LastModifyDate : 2011.11.16
*@LastModifier : 
*@LastVersion : 1.0
* 2011.11.16  
* 1.0 Creation
* 2011.11.22 정선용 [CHM-201114286-01] DPCS-SI Turn Time레포트 및 Draft B/L전송후 Amendment S/I PIC변경관련 개발요구사항 송부
* 2012.01.05 정선용 [CHM-201115236-01] DPCS S/I Turn Time Report 수정 요청
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.vo;

import java.lang.reflect.Field;
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
 * @author 
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SiTurnTimeVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SiTurnTimeVO> models = new ArrayList<SiTurnTimeVO>();
	
	/* Column Info */
	private String tvvd = null;
	/* Column Info */
	private String bkgOfcCd = null;
	/* Column Info */
	private String toDt = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String ordTp = null;
	/* Column Info */
	private String fmDt = null;
	/* Column Info */
	private String srAmdTpCd = null;
	/* Column Info */
	private String atndUsrId = null;
	/* Column Info */
	private String rgnOfcCd = null;
	/* Column Info */
	private String siSts = null;
	/* Column Info */
	private String srNo = null;
	/* Page Number */
	private String pagerows = null;
	/* Page Number */
	private String dpcsOfcCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SiTurnTimeVO() {}

	public SiTurnTimeVO(String ibflag, String pagerows, String dpcsOfcCd, String fmDt, String toDt, String siSts, String srNo, String rgnOfcCd, String bkgOfcCd, String srAmdTpCd, String atndUsrId, String tvvd, String ordTp) {
		this.tvvd = tvvd;
		this.bkgOfcCd = bkgOfcCd;
		this.toDt = toDt;
		this.ibflag = ibflag;
		this.ordTp = ordTp;
		this.fmDt = fmDt;
		this.srAmdTpCd = srAmdTpCd;
		this.atndUsrId = atndUsrId;
		this.rgnOfcCd = rgnOfcCd;
		this.siSts = siSts;
		this.srNo = srNo;
		this.pagerows = pagerows;
		this.dpcsOfcCd = dpcsOfcCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("tvvd", getTvvd());
		this.hashColumns.put("bkg_ofc_cd", getBkgOfcCd());
		this.hashColumns.put("to_dt", getToDt());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("ord_tp", getOrdTp());
		this.hashColumns.put("fm_dt", getFmDt());
		this.hashColumns.put("sr_amd_tp_cd", getSrAmdTpCd());
		this.hashColumns.put("atnd_usr_id", getAtndUsrId());
		this.hashColumns.put("rgn_ofc_cd", getRgnOfcCd());
		this.hashColumns.put("si_sts", getSiSts());
		this.hashColumns.put("sr_no", getSrNo());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("dpcs_ofc_cd", getDpcsOfcCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("tvvd", "tvvd");
		this.hashFields.put("bkg_ofc_cd", "bkgOfcCd");
		this.hashFields.put("to_dt", "toDt");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("ord_tp", "ordTp");
		this.hashFields.put("fm_dt", "fmDt");
		this.hashFields.put("sr_amd_tp_cd", "srAmdTpCd");
		this.hashFields.put("atnd_usr_id", "atndUsrId");
		this.hashFields.put("rgn_ofc_cd", "rgnOfcCd");
		this.hashFields.put("si_sts", "siSts");
		this.hashFields.put("sr_no", "srNo");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("dpcs_ofc_cd", "dpcsOfcCd");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return tvvd
	 */
	public String getTvvd() {
		return this.tvvd;
	}
	
	/**
	 * Column Info
	 * @return bkgOfcCd
	 */
	public String getBkgOfcCd() {
		return this.bkgOfcCd;
	}
	
	/**
	 * Column Info
	 * @return toDt
	 */
	public String getToDt() {
		return this.toDt;
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
	 * @return ordTp
	 */
	public String getOrdTp() {
		return this.ordTp;
	}
	
	/**
	 * Column Info
	 * @return fmDt
	 */
	public String getFmDt() {
		return this.fmDt;
	}
	
	/**
	 * Column Info
	 * @return srAmdTpCd
	 */
	public String getSrAmdTpCd() {
		return this.srAmdTpCd;
	}
	
	/**
	 * Column Info
	 * @return atndUsrId
	 */
	public String getAtndUsrId() {
		return this.atndUsrId;
	}
	
	/**
	 * Column Info
	 * @return rgnOfcCd
	 */
	public String getRgnOfcCd() {
		return this.rgnOfcCd;
	}
	
	/**
	 * Column Info
	 * @return siSts
	 */
	public String getSiSts() {
		return this.siSts;
	}
	
	/**
	 * Column Info
	 * @return srNo
	 */
	public String getSrNo() {
		return this.srNo;
	}
	
	/**
	 * Page Number
	 * @return pagerows
	 */
	public String getPagerows() {
		return this.pagerows;
	}
	
	/**
	 * Page Number
	 * @return dpcsOfcCd
	 */
	public String getDpcsOfcCd() {
		return this.dpcsOfcCd;
	}
	

	/**
	 * Column Info
	 * @param tvvd
	 */
	public void setTvvd(String tvvd) {
		this.tvvd = tvvd;
	}
	
	/**
	 * Column Info
	 * @param bkgOfcCd
	 */
	public void setBkgOfcCd(String bkgOfcCd) {
		this.bkgOfcCd = bkgOfcCd;
	}
	
	/**
	 * Column Info
	 * @param toDt
	 */
	public void setToDt(String toDt) {
		this.toDt = toDt;
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
	 * @param ordTp
	 */
	public void setOrdTp(String ordTp) {
		this.ordTp = ordTp;
	}
	
	/**
	 * Column Info
	 * @param fmDt
	 */
	public void setFmDt(String fmDt) {
		this.fmDt = fmDt;
	}
	
	/**
	 * Column Info
	 * @param srAmdTpCd
	 */
	public void setSrAmdTpCd(String srAmdTpCd) {
		this.srAmdTpCd = srAmdTpCd;
	}
	
	/**
	 * Column Info
	 * @param atndUsrId
	 */
	public void setAtndUsrId(String atndUsrId) {
		this.atndUsrId = atndUsrId;
	}
	
	/**
	 * Column Info
	 * @param rgnOfcCd
	 */
	public void setRgnOfcCd(String rgnOfcCd) {
		this.rgnOfcCd = rgnOfcCd;
	}
	
	/**
	 * Column Info
	 * @param siSts
	 */
	public void setSiSts(String siSts) {
		this.siSts = siSts;
	}
	
	/**
	 * Column Info
	 * @param srNo
	 */
	public void setSrNo(String srNo) {
		this.srNo = srNo;
	}
	
	/**
	 * Page Number
	 * @param pagerows
	 */
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
	}
	
	/**
	 * Page Number
	 * @param dpcsOfcCd
	 */
	public void setDpcsOfcCd(String dpcsOfcCd) {
		this.dpcsOfcCd = dpcsOfcCd;
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
		setTvvd(JSPUtil.getParameter(request, prefix + "tvvd", ""));
		setBkgOfcCd(JSPUtil.getParameter(request, prefix + "bkg_ofc_cd", ""));
		setToDt(JSPUtil.getParameter(request, prefix + "to_dt", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setOrdTp(JSPUtil.getParameter(request, prefix + "ord_tp", ""));
		setFmDt(JSPUtil.getParameter(request, prefix + "fm_dt", ""));
		setSrAmdTpCd(JSPUtil.getParameter(request, prefix + "sr_amd_tp_cd", ""));
		setAtndUsrId(JSPUtil.getParameter(request, prefix + "atnd_usr_id", ""));
		setRgnOfcCd(JSPUtil.getParameter(request, prefix + "rgn_ofc_cd", ""));
		setSiSts(JSPUtil.getParameter(request, prefix + "si_sts", ""));
		setSrNo(JSPUtil.getParameter(request, prefix + "sr_no", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setDpcsOfcCd(JSPUtil.getParameter(request, prefix + "dpcs_ofc_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SiTurnTimeVO[]
	 */
	public SiTurnTimeVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SiTurnTimeVO[]
	 */
	public SiTurnTimeVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SiTurnTimeVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] tvvd = (JSPUtil.getParameter(request, prefix	+ "tvvd", length));
			String[] bkgOfcCd = (JSPUtil.getParameter(request, prefix	+ "bkg_ofc_cd", length));
			String[] toDt = (JSPUtil.getParameter(request, prefix	+ "to_dt", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] ordTp = (JSPUtil.getParameter(request, prefix	+ "ord_tp", length));
			String[] fmDt = (JSPUtil.getParameter(request, prefix	+ "fm_dt", length));
			String[] srAmdTpCd = (JSPUtil.getParameter(request, prefix	+ "sr_amd_tp_cd", length));
			String[] atndUsrId = (JSPUtil.getParameter(request, prefix	+ "atnd_usr_id", length));
			String[] rgnOfcCd = (JSPUtil.getParameter(request, prefix	+ "rgn_ofc_cd", length));
			String[] siSts = (JSPUtil.getParameter(request, prefix	+ "si_sts", length));
			String[] srNo = (JSPUtil.getParameter(request, prefix	+ "sr_no", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] dpcsOfcCd = (JSPUtil.getParameter(request, prefix	+ "dpcs_ofc_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new SiTurnTimeVO();
				if (tvvd[i] != null)
					model.setTvvd(tvvd[i]);
				if (bkgOfcCd[i] != null)
					model.setBkgOfcCd(bkgOfcCd[i]);
				if (toDt[i] != null)
					model.setToDt(toDt[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (ordTp[i] != null)
					model.setOrdTp(ordTp[i]);
				if (fmDt[i] != null)
					model.setFmDt(fmDt[i]);
				if (srAmdTpCd[i] != null)
					model.setSrAmdTpCd(srAmdTpCd[i]);
				if (atndUsrId[i] != null)
					model.setAtndUsrId(atndUsrId[i]);
				if (rgnOfcCd[i] != null)
					model.setRgnOfcCd(rgnOfcCd[i]);
				if (siSts[i] != null)
					model.setSiSts(siSts[i]);
				if (srNo[i] != null)
					model.setSrNo(srNo[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (dpcsOfcCd[i] != null)
					model.setDpcsOfcCd(dpcsOfcCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSiTurnTimeVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SiTurnTimeVO[]
	 */
	public SiTurnTimeVO[] getSiTurnTimeVOs(){
		SiTurnTimeVO[] vos = (SiTurnTimeVO[])models.toArray(new SiTurnTimeVO[models.size()]);
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
		this.tvvd = this.tvvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgOfcCd = this.bkgOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toDt = this.toDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ordTp = this.ordTp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmDt = this.fmDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.srAmdTpCd = this.srAmdTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.atndUsrId = this.atndUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rgnOfcCd = this.rgnOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.siSts = this.siSts .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.srNo = this.srNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dpcsOfcCd = this.dpcsOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
