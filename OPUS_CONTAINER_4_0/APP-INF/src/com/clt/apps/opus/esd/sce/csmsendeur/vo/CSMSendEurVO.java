/*=========================================================
 *Copyright(c) 2016 CyberLogitec
 *@FileName : CSMSendEurVO.java
 *@FileTitle : CSMSendEurVO
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2016.06.17
 *@LastModifier : 
 *@LastVersion : 1.0
 * 2016.06.17  
 * 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esd.sce.csmsendeur.vo;

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
 * @author
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class CSMSendEurVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;

	private Collection<CSMSendEurVO> models = new ArrayList<CSMSendEurVO>();

	/* Column Info */
	private String actRcvNo = null;
	/* Column Info */
	private String bkgNo = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String actDt = null;
	/* Column Info */
	private String cntrNo = null;
	/* Column Info */
	private String isMultiRows = null;
	/* Column Info */
	private String nodCd = null;
	/* Column Info */
	private String actRcvDt = null;
	/* Column Info */
	private String actStsMapgCd = null;
	/* Column Info */
	private String actUmchTpCd = null;
	/* Column Info */
	private String csmCntCd = null;
	/* Page Number */
	private String pagerows = null;

	/* 테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/* 테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();

	public CSMSendEurVO() {
	}

	public CSMSendEurVO(String ibflag, String pagerows, String actRcvNo, String bkgNo, String actDt, String cntrNo, String csmCntCd, String isMultiRows, String nodCd, String actRcvDt, String actStsMapgCd, String actUmchTpCd) {
		this.actRcvNo = actRcvNo;
		this.bkgNo = bkgNo;
		this.ibflag = ibflag;
		this.actDt = actDt;
		this.cntrNo = cntrNo;
		this.isMultiRows = isMultiRows;
		this.nodCd = nodCd;
		this.actRcvDt = actRcvDt;
		this.actStsMapgCd = actStsMapgCd;
		this.actUmchTpCd = actUmchTpCd;
		this.csmCntCd = csmCntCd;
		this.pagerows = pagerows;
	}

	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * 
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues() {
		this.hashColumns.put("act_rcv_no", getActRcvNo());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("act_dt", getActDt());
		this.hashColumns.put("cntr_no", getCntrNo());
		this.hashColumns.put("is_multi_rows", getIsMultiRows());
		this.hashColumns.put("nod_cd", getNodCd());
		this.hashColumns.put("act_rcv_dt", getActRcvDt());
		this.hashColumns.put("act_sts_mapg_cd", getActStsMapgCd());
		this.hashColumns.put("act_umch_tp_cd", getActUmchTpCd());
		this.hashColumns.put("csm_cnt_cd", getCsmCntCd());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}

	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환
	 * 
	 * @return
	 */
	public HashMap<String, String> getFieldNames() {
		this.hashFields.put("act_rcv_no", "actRcvNo");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("act_dt", "actDt");
		this.hashFields.put("cntr_no", "cntrNo");
		this.hashFields.put("is_multi_rows", "isMultiRows");
		this.hashFields.put("nod_cd", "nodCd");
		this.hashFields.put("act_rcv_dt", "actRcvDt");
		this.hashFields.put("act_sts_mapg_cd", "actStsMapgCd");
		this.hashFields.put("act_umch_tp_cd", "actUmchTpCd");
		this.hashFields.put("csm_cnt_cd", "csmCntCd");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}

	/**
	 * Column Info
	 * 
	 * @return actRcvNo
	 */
	public String getActRcvNo() {
		return this.actRcvNo;
	}

	/**
	 * Column Info
	 * 
	 * @return bkgNo
	 */
	public String getBkgNo() {
		return this.bkgNo;
	}

	/**
	 * VO Data Value( C:Creation, U:Update, D:Delete )
	 * 
	 * @return ibflag
	 */
	public String getIbflag() {
		return this.ibflag;
	}

	/**
	 * Column Info
	 * 
	 * @return actDt
	 */
	public String getActDt() {
		return this.actDt;
	}

	/**
	 * Column Info
	 * 
	 * @return cntrNo
	 */
	public String getCntrNo() {
		return this.cntrNo;
	}

	/**
	 * Column Info
	 * 
	 * @return isMultiRows
	 */
	public String getIsMultiRows() {
		return this.isMultiRows;
	}

	/**
	 * Column Info
	 * 
	 * @return nodCd
	 */
	public String getNodCd() {
		return this.nodCd;
	}

	/**
	 * Column Info
	 * 
	 * @return actRcvDt
	 */
	public String getActRcvDt() {
		return this.actRcvDt;
	}

	/**
	 * Column Info
	 * 
	 * @return actStsMapgCd
	 */
	public String getActStsMapgCd() {
		return this.actStsMapgCd;
	}

	/**
	 * Column Info
	 * 
	 * @return actUmchTpCd
	 */
	public String getActUmchTpCd() {
		return this.actUmchTpCd;
	}

	/**
	 * Column Info
	 * 
	 * @return csmCntCd
	 */
	public String getCsmCntCd() {
		return this.csmCntCd;
	}

	/**
	 * Page Number
	 * 
	 * @return pagerows
	 */
	public String getPagerows() {
		return this.pagerows;
	}

	/**
	 * Column Info
	 * 
	 * @param actRcvNo
	 */
	public void setActRcvNo(String actRcvNo) {
		this.actRcvNo = actRcvNo;
	}

	/**
	 * Column Info
	 * 
	 * @param bkgNo
	 */
	public void setBkgNo(String bkgNo) {
		this.bkgNo = bkgNo;
	}

	/**
	 * VO Data Value( C:Creation, U:Update, D:Delete )
	 * 
	 * @param ibflag
	 */
	public void setIbflag(String ibflag) {
		this.ibflag = ibflag;
	}

	/**
	 * Column Info
	 * 
	 * @param actDt
	 */
	public void setActDt(String actDt) {
		this.actDt = actDt;
	}

	/**
	 * Column Info
	 * 
	 * @param cntrNo
	 */
	public void setCntrNo(String cntrNo) {
		this.cntrNo = cntrNo;
	}

	/**
	 * Column Info
	 * 
	 * @param isMultiRows
	 */
	public void setIsMultiRows(String isMultiRows) {
		this.isMultiRows = isMultiRows;
	}

	/**
	 * Column Info
	 * 
	 * @param nodCd
	 */
	public void setNodCd(String nodCd) {
		this.nodCd = nodCd;
	}

	/**
	 * Column Info
	 * 
	 * @param actRcvDt
	 */
	public void setActRcvDt(String actRcvDt) {
		this.actRcvDt = actRcvDt;
	}

	/**
	 * Column Info
	 * 
	 * @param actStsMapgCd
	 */
	public void setActStsMapgCd(String actStsMapgCd) {
		this.actStsMapgCd = actStsMapgCd;
	}

	/**
	 * Column Info
	 * 
	 * @param actUmchTpCd
	 */
	public void setActUmchTpCd(String actUmchTpCd) {
		this.actUmchTpCd = actUmchTpCd;
	}

	/**
	 * Column Info
	 * 
	 * @param csmCntCd
	 */
	public void setCsmCntCd(String csmCntCd) {
		this.csmCntCd = csmCntCd;
	}

	/**
	 * Page Number
	 * 
	 * @param pagerows
	 */
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
	}

	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * 
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		fromRequest(request, "");
	}

	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * 
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request, String prefix) {
		setActRcvNo(JSPUtil.getParameter(request, prefix + "act_rcv_no", ""));
		setBkgNo(JSPUtil.getParameter(request, prefix + "bkg_no", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setActDt(JSPUtil.getParameter(request, prefix + "act_dt", ""));
		setCntrNo(JSPUtil.getParameter(request, prefix + "cntr_no", ""));
		setIsMultiRows(JSPUtil.getParameter(request, prefix + "is_multi_rows", ""));
		setNodCd(JSPUtil.getParameter(request, prefix + "nod_cd", ""));
		setActRcvDt(JSPUtil.getParameter(request, prefix + "act_rcv_dt", ""));
		setActStsMapgCd(JSPUtil.getParameter(request, prefix + "act_sts_mapg_cd", ""));
		setActUmchTpCd(JSPUtil.getParameter(request, prefix + "act_umch_tp_cd", ""));
		setCsmCntCd(JSPUtil.getParameter(request, prefix + "csm_cnt_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * 
	 * @param request
	 * @return CSMSendEurVO[]
	 */
	public CSMSendEurVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다.
	 * 
	 * @param request
	 * @param prefix
	 * @return CSMSendEurVO[]
	 */
	public CSMSendEurVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		CSMSendEurVO model = null;

		String[] tmp = request.getParameterValues(prefix + "ibflag");
		if (tmp == null)
			return null;

		int length = request.getParameterValues(prefix + "ibflag").length;

		try {
			String[] actRcvNo = (JSPUtil.getParameter(request, prefix + "act_rcv_no", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix + "bkg_no", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix + "ibflag", length));
			String[] actDt = (JSPUtil.getParameter(request, prefix + "act_dt", length));
			String[] cntrNo = (JSPUtil.getParameter(request, prefix + "cntr_no", length));
			String[] isMultiRows = (JSPUtil.getParameter(request, prefix + "is_multi_rows", length));
			String[] nodCd = (JSPUtil.getParameter(request, prefix + "nod_cd", length));
			String[] actRcvDt = (JSPUtil.getParameter(request, prefix + "act_rcv_dt", length));
			String[] actStsMapgCd = (JSPUtil.getParameter(request, prefix + "act_sts_mapg_cd", length));
			String[] actUmchTpCd = (JSPUtil.getParameter(request, prefix + "act_umch_tp_cd", length));
			String[] csmCntCd = (JSPUtil.getParameter(request, prefix + "csm_cnt_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix + "pagerows", length));

			for (int i = 0; i < length; i++) {
				model = new CSMSendEurVO();
				if (actRcvNo[i] != null)
					model.setActRcvNo(actRcvNo[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (actDt[i] != null)
					model.setActDt(actDt[i]);
				if (cntrNo[i] != null)
					model.setCntrNo(cntrNo[i]);
				if (isMultiRows[i] != null)
					model.setIsMultiRows(isMultiRows[i]);
				if (nodCd[i] != null)
					model.setNodCd(nodCd[i]);
				if (actRcvDt[i] != null)
					model.setActRcvDt(actRcvDt[i]);
				if (actStsMapgCd[i] != null)
					model.setActStsMapgCd(actStsMapgCd[i]);
				if (actUmchTpCd[i] != null)
					model.setActUmchTpCd(actUmchTpCd[i]);
				if (csmCntCd[i] != null)
					model.setCsmCntCd(csmCntCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getCSMSendEurVOs();
	}

	/**
	 * VO 배열을 반환
	 * 
	 * @return CSMSendEurVO[]
	 */
	public CSMSendEurVO[] getCSMSendEurVOs() {
		CSMSendEurVO[] vos = (CSMSendEurVO[]) models.toArray(new CSMSendEurVO[models.size()]);
		return vos;
	}

	/**
	 * VO Class의 내용을 String으로 변환
	 */
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
	}

	/**
	 * 포맷팅된 문자열에서 특수문자 제거("-","/",",",":")
	 */
	public void unDataFormat() {
		this.actRcvNo = this.actRcvNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actDt = this.actDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo = this.cntrNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.isMultiRows = this.isMultiRows.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.nodCd = this.nodCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actRcvDt = this.actRcvDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actStsMapgCd = this.actStsMapgCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actUmchTpCd = this.actUmchTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.csmCntCd = this.csmCntCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
