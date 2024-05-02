/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ImpendingTBMainClaimVO.java
*@FileTitle : ImpendingTBMainClaimVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.30
*@LastModifier : 진윤오
*@LastVersion : 1.0
* 2009.11.30 진윤오 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.cps.cni.containercargoclaim.claimmain.vo;

import java.lang.reflect.Field;
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
 * @author 진윤오
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class ImpendingTBMainClaimVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<ImpendingTBMainClaimVO> models = new ArrayList<ImpendingTBMainClaimVO>();
	
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String tmBarDt = null;
	/* Column Info */
	private String cgoClmStsCd = null;
	/* Column Info */
	private String clmtClmPtyNm = null;
	/* Column Info */
	private String usrEml = null;
	/* Column Info */
	private String cgoClmNo = null;
	/* Column Info */
	private String hdlrOfcCd = null;
	/* Column Info */
	private String clmAreaCd = null;
	/* Column Info */
	private String cgoClmDivCd = null;
	/* Column Info */
	private String hdlrUsrId = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public ImpendingTBMainClaimVO() {}

	public ImpendingTBMainClaimVO(String ibflag, String pagerows, String tmBarDt, String cgoClmDivCd, String cgoClmNo, String clmAreaCd, String hdlrOfcCd, String hdlrUsrId, String cgoClmStsCd, String clmtClmPtyNm, String usrEml) {
		this.ibflag = ibflag;
		this.tmBarDt = tmBarDt;
		this.cgoClmStsCd = cgoClmStsCd;
		this.clmtClmPtyNm = clmtClmPtyNm;
		this.usrEml = usrEml;
		this.cgoClmNo = cgoClmNo;
		this.hdlrOfcCd = hdlrOfcCd;
		this.clmAreaCd = clmAreaCd;
		this.cgoClmDivCd = cgoClmDivCd;
		this.hdlrUsrId = hdlrUsrId;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("tm_bar_dt", getTmBarDt());
		this.hashColumns.put("cgo_clm_sts_cd", getCgoClmStsCd());
		this.hashColumns.put("clmt_clm_pty_nm", getClmtClmPtyNm());
		this.hashColumns.put("usr_eml", getUsrEml());
		this.hashColumns.put("cgo_clm_no", getCgoClmNo());
		this.hashColumns.put("hdlr_ofc_cd", getHdlrOfcCd());
		this.hashColumns.put("clm_area_cd", getClmAreaCd());
		this.hashColumns.put("cgo_clm_div_cd", getCgoClmDivCd());
		this.hashColumns.put("hdlr_usr_id", getHdlrUsrId());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("tm_bar_dt", "tmBarDt");
		this.hashFields.put("cgo_clm_sts_cd", "cgoClmStsCd");
		this.hashFields.put("clmt_clm_pty_nm", "clmtClmPtyNm");
		this.hashFields.put("usr_eml", "usrEml");
		this.hashFields.put("cgo_clm_no", "cgoClmNo");
		this.hashFields.put("hdlr_ofc_cd", "hdlrOfcCd");
		this.hashFields.put("clm_area_cd", "clmAreaCd");
		this.hashFields.put("cgo_clm_div_cd", "cgoClmDivCd");
		this.hashFields.put("hdlr_usr_id", "hdlrUsrId");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
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
	 * @return tmBarDt
	 */
	public String getTmBarDt() {
		return this.tmBarDt;
	}
	
	/**
	 * Column Info
	 * @return cgoClmStsCd
	 */
	public String getCgoClmStsCd() {
		return this.cgoClmStsCd;
	}
	
	/**
	 * Column Info
	 * @return clmtClmPtyNm
	 */
	public String getClmtClmPtyNm() {
		return this.clmtClmPtyNm;
	}
	
	/**
	 * Column Info
	 * @return usrEml
	 */
	public String getUsrEml() {
		return this.usrEml;
	}
	
	/**
	 * Column Info
	 * @return cgoClmNo
	 */
	public String getCgoClmNo() {
		return this.cgoClmNo;
	}
	
	/**
	 * Column Info
	 * @return hdlrOfcCd
	 */
	public String getHdlrOfcCd() {
		return this.hdlrOfcCd;
	}
	
	/**
	 * Column Info
	 * @return clmAreaCd
	 */
	public String getClmAreaCd() {
		return this.clmAreaCd;
	}
	
	/**
	 * Column Info
	 * @return cgoClmDivCd
	 */
	public String getCgoClmDivCd() {
		return this.cgoClmDivCd;
	}
	
	/**
	 * Column Info
	 * @return hdlrUsrId
	 */
	public String getHdlrUsrId() {
		return this.hdlrUsrId;
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
	 * @param ibflag
	 */
	public void setIbflag(String ibflag) {
		this.ibflag = ibflag;
	}
	
	/**
	 * Column Info
	 * @param tmBarDt
	 */
	public void setTmBarDt(String tmBarDt) {
		this.tmBarDt = tmBarDt;
	}
	
	/**
	 * Column Info
	 * @param cgoClmStsCd
	 */
	public void setCgoClmStsCd(String cgoClmStsCd) {
		this.cgoClmStsCd = cgoClmStsCd;
	}
	
	/**
	 * Column Info
	 * @param clmtClmPtyNm
	 */
	public void setClmtClmPtyNm(String clmtClmPtyNm) {
		this.clmtClmPtyNm = clmtClmPtyNm;
	}
	
	/**
	 * Column Info
	 * @param usrEml
	 */
	public void setUsrEml(String usrEml) {
		this.usrEml = usrEml;
	}
	
	/**
	 * Column Info
	 * @param cgoClmNo
	 */
	public void setCgoClmNo(String cgoClmNo) {
		this.cgoClmNo = cgoClmNo;
	}
	
	/**
	 * Column Info
	 * @param hdlrOfcCd
	 */
	public void setHdlrOfcCd(String hdlrOfcCd) {
		this.hdlrOfcCd = hdlrOfcCd;
	}
	
	/**
	 * Column Info
	 * @param clmAreaCd
	 */
	public void setClmAreaCd(String clmAreaCd) {
		this.clmAreaCd = clmAreaCd;
	}
	
	/**
	 * Column Info
	 * @param cgoClmDivCd
	 */
	public void setCgoClmDivCd(String cgoClmDivCd) {
		this.cgoClmDivCd = cgoClmDivCd;
	}
	
	/**
	 * Column Info
	 * @param hdlrUsrId
	 */
	public void setHdlrUsrId(String hdlrUsrId) {
		this.hdlrUsrId = hdlrUsrId;
	}
	
	/**
	 * Page Number
	 * @param pagerows
	 */
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setTmBarDt(JSPUtil.getParameter(request, "tm_bar_dt", ""));
		setCgoClmStsCd(JSPUtil.getParameter(request, "cgo_clm_sts_cd", ""));
		setClmtClmPtyNm(JSPUtil.getParameter(request, "clmt_clm_pty_nm", ""));
		setUsrEml(JSPUtil.getParameter(request, "usr_eml", ""));
		setCgoClmNo(JSPUtil.getParameter(request, "cgo_clm_no", ""));
		setHdlrOfcCd(JSPUtil.getParameter(request, "hdlr_ofc_cd", ""));
		setClmAreaCd(JSPUtil.getParameter(request, "clm_area_cd", ""));
		setCgoClmDivCd(JSPUtil.getParameter(request, "cgo_clm_div_cd", ""));
		setHdlrUsrId(JSPUtil.getParameter(request, "hdlr_usr_id", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return ImpendingTBMainClaimVO[]
	 */
	public ImpendingTBMainClaimVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return ImpendingTBMainClaimVO[]
	 */
	public ImpendingTBMainClaimVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		ImpendingTBMainClaimVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] tmBarDt = (JSPUtil.getParameter(request, prefix	+ "tm_bar_dt", length));
			String[] cgoClmStsCd = (JSPUtil.getParameter(request, prefix	+ "cgo_clm_sts_cd", length));
			String[] clmtClmPtyNm = (JSPUtil.getParameter(request, prefix	+ "clmt_clm_pty_nm", length));
			String[] usrEml = (JSPUtil.getParameter(request, prefix	+ "usr_eml", length));
			String[] cgoClmNo = (JSPUtil.getParameter(request, prefix	+ "cgo_clm_no", length));
			String[] hdlrOfcCd = (JSPUtil.getParameter(request, prefix	+ "hdlr_ofc_cd", length));
			String[] clmAreaCd = (JSPUtil.getParameter(request, prefix	+ "clm_area_cd", length));
			String[] cgoClmDivCd = (JSPUtil.getParameter(request, prefix	+ "cgo_clm_div_cd", length));
			String[] hdlrUsrId = (JSPUtil.getParameter(request, prefix	+ "hdlr_usr_id", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new ImpendingTBMainClaimVO();
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (tmBarDt[i] != null)
					model.setTmBarDt(tmBarDt[i]);
				if (cgoClmStsCd[i] != null)
					model.setCgoClmStsCd(cgoClmStsCd[i]);
				if (clmtClmPtyNm[i] != null)
					model.setClmtClmPtyNm(clmtClmPtyNm[i]);
				if (usrEml[i] != null)
					model.setUsrEml(usrEml[i]);
				if (cgoClmNo[i] != null)
					model.setCgoClmNo(cgoClmNo[i]);
				if (hdlrOfcCd[i] != null)
					model.setHdlrOfcCd(hdlrOfcCd[i]);
				if (clmAreaCd[i] != null)
					model.setClmAreaCd(clmAreaCd[i]);
				if (cgoClmDivCd[i] != null)
					model.setCgoClmDivCd(cgoClmDivCd[i]);
				if (hdlrUsrId[i] != null)
					model.setHdlrUsrId(hdlrUsrId[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getImpendingTBMainClaimVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return ImpendingTBMainClaimVO[]
	 */
	public ImpendingTBMainClaimVO[] getImpendingTBMainClaimVOs(){
		ImpendingTBMainClaimVO[] vos = (ImpendingTBMainClaimVO[])models.toArray(new ImpendingTBMainClaimVO[models.size()]);
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
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tmBarDt = this.tmBarDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cgoClmStsCd = this.cgoClmStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.clmtClmPtyNm = this.clmtClmPtyNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usrEml = this.usrEml .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cgoClmNo = this.cgoClmNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hdlrOfcCd = this.hdlrOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.clmAreaCd = this.clmAreaCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cgoClmDivCd = this.cgoClmDivCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hdlrUsrId = this.hdlrUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
