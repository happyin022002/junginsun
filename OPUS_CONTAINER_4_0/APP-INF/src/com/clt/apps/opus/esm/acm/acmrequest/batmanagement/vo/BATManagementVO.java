/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : BATManagementVO.java
*@FileTitle : BATManagementVO
*Open Issues :
*Change history :
*@LastModifyDate : 2012.06.05
*@LastModifier : 김봉균
*@LastVersion : 1.0
* 2012.06.05 김봉균
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.acm.acmrequest.batmanagement.vo;

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
 * @author 김봉균
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class BATManagementVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;

	private Collection<BATManagementVO> models = new ArrayList<BATManagementVO>();

	/* Column Info */
	private String creUsrId = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String statTm = null;
	/* Column Info */
	private String usrId = null;
	/* Column Info */
	private String batItmNm = null;
	/* Column Info */
	private String statDt = null;
	/* Column Info */
	private String commTpCd = null;
	/* Column Info */
	private String nCnt = null;
	/* Column Info */
	private String batDesc = null;
	/* Column Info */
	private String comCnt = null;
	/* Column Info */
	private String totBkgCnt = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();

	public BATManagementVO() {}

	public BATManagementVO(String ibflag, String pagerows, String batItmNm, String creUsrId, String commTpCd, String nCnt, String totBkgCnt, String comCnt, String statDt, String statTm, String batDesc, String usrId) {
		this.creUsrId = creUsrId;
		this.ibflag = ibflag;
		this.statTm = statTm;
		this.usrId = usrId;
		this.batItmNm = batItmNm;
		this.statDt = statDt;
		this.commTpCd = commTpCd;
		this.nCnt = nCnt;
		this.batDesc = batDesc;
		this.comCnt = comCnt;
		this.totBkgCnt = totBkgCnt;
		this.pagerows = pagerows;
	}

	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("stat_tm", getStatTm());
		this.hashColumns.put("usr_id", getUsrId());
		this.hashColumns.put("bat_itm_nm", getBatItmNm());
		this.hashColumns.put("stat_dt", getStatDt());
		this.hashColumns.put("comm_tp_cd", getCommTpCd());
		this.hashColumns.put("n_cnt", getNCnt());
		this.hashColumns.put("bat_desc", getBatDesc());
		this.hashColumns.put("com_cnt", getComCnt());
		this.hashColumns.put("tot_bkg_cnt", getTotBkgCnt());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}

	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("stat_tm", "statTm");
		this.hashFields.put("usr_id", "usrId");
		this.hashFields.put("bat_itm_nm", "batItmNm");
		this.hashFields.put("stat_dt", "statDt");
		this.hashFields.put("comm_tp_cd", "commTpCd");
		this.hashFields.put("n_cnt", "nCnt");
		this.hashFields.put("bat_desc", "batDesc");
		this.hashFields.put("com_cnt", "comCnt");
		this.hashFields.put("tot_bkg_cnt", "totBkgCnt");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}

	/**
	 * Column Info
	 * @return creUsrId
	 */
	public String getCreUsrId() {
		return this.creUsrId;
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
	 * @return statTm
	 */
	public String getStatTm() {
		return this.statTm;
	}

	/**
	 * Column Info
	 * @return usrId
	 */
	public String getUsrId() {
		return this.usrId;
	}

	/**
	 * Column Info
	 * @return batItmNm
	 */
	public String getBatItmNm() {
		return this.batItmNm;
	}

	/**
	 * Column Info
	 * @return statDt
	 */
	public String getStatDt() {
		return this.statDt;
	}

	/**
	 * Column Info
	 * @return commTpCd
	 */
	public String getCommTpCd() {
		return this.commTpCd;
	}

	/**
	 * Column Info
	 * @return nCnt
	 */
	public String getNCnt() {
		return this.nCnt;
	}

	/**
	 * Column Info
	 * @return batDesc
	 */
	public String getBatDesc() {
		return this.batDesc;
	}

	/**
	 * Column Info
	 * @return comCnt
	 */
	public String getComCnt() {
		return this.comCnt;
	}

	/**
	 * Column Info
	 * @return totBkgCnt
	 */
	public String getTotBkgCnt() {
		return this.totBkgCnt;
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
	 * @param creUsrId
	 */
	public void setCreUsrId(String creUsrId) {
		this.creUsrId = creUsrId;
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
	 * @param statTm
	 */
	public void setStatTm(String statTm) {
		this.statTm = statTm;
	}

	/**
	 * Column Info
	 * @param usrId
	 */
	public void setUsrId(String usrId) {
		this.usrId = usrId;
	}

	/**
	 * Column Info
	 * @param batItmNm
	 */
	public void setBatItmNm(String batItmNm) {
		this.batItmNm = batItmNm;
	}

	/**
	 * Column Info
	 * @param statDt
	 */
	public void setStatDt(String statDt) {
		this.statDt = statDt;
	}

	/**
	 * Column Info
	 * @param commTpCd
	 */
	public void setCommTpCd(String commTpCd) {
		this.commTpCd = commTpCd;
	}

	/**
	 * Column Info
	 * @param nCnt
	 */
	public void setNCnt(String nCnt) {
		this.nCnt = nCnt;
	}

	/**
	 * Column Info
	 * @param batDesc
	 */
	public void setBatDesc(String batDesc) {
		this.batDesc = batDesc;
	}

	/**
	 * Column Info
	 * @param comCnt
	 */
	public void setComCnt(String comCnt) {
		this.comCnt = comCnt;
	}

	/**
	 * Column Info
	 * @param totBkgCnt
	 */
	public void setTotBkgCnt(String totBkgCnt) {
		this.totBkgCnt = totBkgCnt;
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
		fromRequest(request,"");
	}

	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request, String prefix) {
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setStatTm(JSPUtil.getParameter(request, prefix + "stat_tm", ""));
		setUsrId(JSPUtil.getParameter(request, prefix + "usr_id", ""));
		setBatItmNm(JSPUtil.getParameter(request, prefix + "bat_itm_nm", ""));
		setStatDt(JSPUtil.getParameter(request, prefix + "stat_dt", ""));
		setCommTpCd(JSPUtil.getParameter(request, prefix + "comm_tp_cd", ""));
		setNCnt(JSPUtil.getParameter(request, prefix + "n_cnt", ""));
		setBatDesc(JSPUtil.getParameter(request, prefix + "bat_desc", ""));
		setComCnt(JSPUtil.getParameter(request, prefix + "com_cnt", ""));
		setTotBkgCnt(JSPUtil.getParameter(request, prefix + "tot_bkg_cnt", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return BATManagementVO[]
	 */
	public BATManagementVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다.
	 * @param request
	 * @param prefix
	 * @return BATManagementVO[]
	 */
	public BATManagementVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		BATManagementVO model = null;

		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;

		try {
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] statTm = (JSPUtil.getParameter(request, prefix	+ "stat_tm", length));
			String[] usrId = (JSPUtil.getParameter(request, prefix	+ "usr_id", length));
			String[] batItmNm = (JSPUtil.getParameter(request, prefix	+ "bat_itm_nm", length));
			String[] statDt = (JSPUtil.getParameter(request, prefix	+ "stat_dt", length));
			String[] commTpCd = (JSPUtil.getParameter(request, prefix	+ "comm_tp_cd", length));
			String[] nCnt = (JSPUtil.getParameter(request, prefix	+ "n_cnt", length));
			String[] batDesc = (JSPUtil.getParameter(request, prefix	+ "bat_desc", length));
			String[] comCnt = (JSPUtil.getParameter(request, prefix	+ "com_cnt", length));
			String[] totBkgCnt = (JSPUtil.getParameter(request, prefix	+ "tot_bkg_cnt", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));

			for (int i = 0; i < length; i++) {
				model = new BATManagementVO();
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (statTm[i] != null)
					model.setStatTm(statTm[i]);
				if (usrId[i] != null)
					model.setUsrId(usrId[i]);
				if (batItmNm[i] != null)
					model.setBatItmNm(batItmNm[i]);
				if (statDt[i] != null)
					model.setStatDt(statDt[i]);
				if (commTpCd[i] != null)
					model.setCommTpCd(commTpCd[i]);
				if (nCnt[i] != null)
					model.setNCnt(nCnt[i]);
				if (batDesc[i] != null)
					model.setBatDesc(batDesc[i]);
				if (comCnt[i] != null)
					model.setComCnt(comCnt[i]);
				if (totBkgCnt[i] != null)
					model.setTotBkgCnt(totBkgCnt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getBATManagementVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return BATManagementVO[]
	 */
	public BATManagementVO[] getBATManagementVOs(){
		BATManagementVO[] vos = (BATManagementVO[])models.toArray(new BATManagementVO[models.size()]);
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
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.statTm = this.statTm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usrId = this.usrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.batItmNm = this.batItmNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.statDt = this.statDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.commTpCd = this.commTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.nCnt = this.nCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.batDesc = this.batDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.comCnt = this.comCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totBkgCnt = this.totBkgCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
