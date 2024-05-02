/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SearchNonTPBListVO.java
*@FileTitle : SearchNonTPBListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.20
*@LastModifier : 박성진
*@LastVersion : 1.0
* 2009.10.20 박성진 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esd.tpb.statusinquiry.performanceinquiry.vo;

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
 * @author 박성진
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SearchNonTPBListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchNonTPBListVO> models = new ArrayList<SearchNonTPBListVO>();
	
	/* Column Info */
	private String tesCnt = null;
	/* Column Info */
	private String userOfcCd = null;
	/* Column Info */
	private String sDateType = null;
	/* Column Info */
	private String sEdate = null;
	/* Column Info */
	private String ifOfcCd = null;
	/* Column Info */
	private String mnrRatio = null;
	/* Column Info */
	private String sSdate = null;
	/* Column Info */
	private String totalRatio = null;
	/* Column Info */
	private String sIfOfcCd = null;
	/* Column Info */
	private String sIfCtrlCd = null;
	/* Column Info */
	private String sOfcCdForRhq = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String trsCnt = null;
	/* Column Info */
	private String cdType = null;
	/* Column Info */
	private String tesRatio = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String sRhqCdForRhq = null;
	/* Column Info */
	private String mnrCnt = null;
	/* Column Info */
	private String trsRatio = null;
	/* Column Info */
	private String sIfRhqCd = null;
	/* Column Info */
	private String totalCnt = null;
	/* Column Info */
	private String sOfficeLevel = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SearchNonTPBListVO() {}

	public SearchNonTPBListVO(String ibflag, String pagerows, String sOfficeLevel, String sRhqCdForRhq, String sOfcCdForRhq, String sSdate, String sEdate, String sIfRhqCd, String sIfCtrlCd, String sIfOfcCd, String sDateType, String userOfcCd, String ifOfcCd, String cdType, String totalCnt, String totalRatio, String tesCnt, String tesRatio, String trsCnt, String trsRatio, String mnrCnt, String mnrRatio) {
		this.tesCnt = tesCnt;
		this.userOfcCd = userOfcCd;
		this.sDateType = sDateType;
		this.sEdate = sEdate;
		this.ifOfcCd = ifOfcCd;
		this.mnrRatio = mnrRatio;
		this.sSdate = sSdate;
		this.totalRatio = totalRatio;
		this.sIfOfcCd = sIfOfcCd;
		this.sIfCtrlCd = sIfCtrlCd;
		this.sOfcCdForRhq = sOfcCdForRhq;
		this.pagerows = pagerows;
		this.trsCnt = trsCnt;
		this.cdType = cdType;
		this.tesRatio = tesRatio;
		this.ibflag = ibflag;
		this.sRhqCdForRhq = sRhqCdForRhq;
		this.mnrCnt = mnrCnt;
		this.trsRatio = trsRatio;
		this.sIfRhqCd = sIfRhqCd;
		this.totalCnt = totalCnt;
		this.sOfficeLevel = sOfficeLevel;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("tes_cnt", getTesCnt());
		this.hashColumns.put("user_ofc_cd", getUserOfcCd());
		this.hashColumns.put("s_date_type", getSDateType());
		this.hashColumns.put("s_edate", getSEdate());
		this.hashColumns.put("if_ofc_cd", getIfOfcCd());
		this.hashColumns.put("mnr_ratio", getMnrRatio());
		this.hashColumns.put("s_sdate", getSSdate());
		this.hashColumns.put("total_ratio", getTotalRatio());
		this.hashColumns.put("s_if_ofc_cd", getSIfOfcCd());
		this.hashColumns.put("s_if_ctrl_cd", getSIfCtrlCd());
		this.hashColumns.put("s_ofc_cd_for_rhq", getSOfcCdForRhq());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("trs_cnt", getTrsCnt());
		this.hashColumns.put("cd_type", getCdType());
		this.hashColumns.put("tes_ratio", getTesRatio());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("s_rhq_cd_for_rhq", getSRhqCdForRhq());
		this.hashColumns.put("mnr_cnt", getMnrCnt());
		this.hashColumns.put("trs_ratio", getTrsRatio());
		this.hashColumns.put("s_if_rhq_cd", getSIfRhqCd());
		this.hashColumns.put("total_cnt", getTotalCnt());
		this.hashColumns.put("s_office_level", getSOfficeLevel());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("tes_cnt", "tesCnt");
		this.hashFields.put("user_ofc_cd", "userOfcCd");
		this.hashFields.put("s_date_type", "sDateType");
		this.hashFields.put("s_edate", "sEdate");
		this.hashFields.put("if_ofc_cd", "ifOfcCd");
		this.hashFields.put("mnr_ratio", "mnrRatio");
		this.hashFields.put("s_sdate", "sSdate");
		this.hashFields.put("total_ratio", "totalRatio");
		this.hashFields.put("s_if_ofc_cd", "sIfOfcCd");
		this.hashFields.put("s_if_ctrl_cd", "sIfCtrlCd");
		this.hashFields.put("s_ofc_cd_for_rhq", "sOfcCdForRhq");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("trs_cnt", "trsCnt");
		this.hashFields.put("cd_type", "cdType");
		this.hashFields.put("tes_ratio", "tesRatio");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("s_rhq_cd_for_rhq", "sRhqCdForRhq");
		this.hashFields.put("mnr_cnt", "mnrCnt");
		this.hashFields.put("trs_ratio", "trsRatio");
		this.hashFields.put("s_if_rhq_cd", "sIfRhqCd");
		this.hashFields.put("total_cnt", "totalCnt");
		this.hashFields.put("s_office_level", "sOfficeLevel");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return tesCnt
	 */
	public String getTesCnt() {
		return this.tesCnt;
	}
	
	/**
	 * Column Info
	 * @return userOfcCd
	 */
	public String getUserOfcCd() {
		return this.userOfcCd;
	}
	
	/**
	 * Column Info
	 * @return sDateType
	 */
	public String getSDateType() {
		return this.sDateType;
	}
	
	/**
	 * Column Info
	 * @return sEdate
	 */
	public String getSEdate() {
		return this.sEdate;
	}
	
	/**
	 * Column Info
	 * @return ifOfcCd
	 */
	public String getIfOfcCd() {
		return this.ifOfcCd;
	}
	
	/**
	 * Column Info
	 * @return mnrRatio
	 */
	public String getMnrRatio() {
		return this.mnrRatio;
	}
	
	/**
	 * Column Info
	 * @return sSdate
	 */
	public String getSSdate() {
		return this.sSdate;
	}
	
	/**
	 * Column Info
	 * @return totalRatio
	 */
	public String getTotalRatio() {
		return this.totalRatio;
	}
	
	/**
	 * Column Info
	 * @return sIfOfcCd
	 */
	public String getSIfOfcCd() {
		return this.sIfOfcCd;
	}
	
	/**
	 * Column Info
	 * @return sIfCtrlCd
	 */
	public String getSIfCtrlCd() {
		return this.sIfCtrlCd;
	}
	
	/**
	 * Column Info
	 * @return sOfcCdForRhq
	 */
	public String getSOfcCdForRhq() {
		return this.sOfcCdForRhq;
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
	 * @return trsCnt
	 */
	public String getTrsCnt() {
		return this.trsCnt;
	}
	
	/**
	 * Column Info
	 * @return cdType
	 */
	public String getCdType() {
		return this.cdType;
	}
	
	/**
	 * Column Info
	 * @return tesRatio
	 */
	public String getTesRatio() {
		return this.tesRatio;
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
	 * @return sRhqCdForRhq
	 */
	public String getSRhqCdForRhq() {
		return this.sRhqCdForRhq;
	}
	
	/**
	 * Column Info
	 * @return mnrCnt
	 */
	public String getMnrCnt() {
		return this.mnrCnt;
	}
	
	/**
	 * Column Info
	 * @return trsRatio
	 */
	public String getTrsRatio() {
		return this.trsRatio;
	}
	
	/**
	 * Column Info
	 * @return sIfRhqCd
	 */
	public String getSIfRhqCd() {
		return this.sIfRhqCd;
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
	 * @return sOfficeLevel
	 */
	public String getSOfficeLevel() {
		return this.sOfficeLevel;
	}
	

	/**
	 * Column Info
	 * @param tesCnt
	 */
	public void setTesCnt(String tesCnt) {
		this.tesCnt = tesCnt;
	}
	
	/**
	 * Column Info
	 * @param userOfcCd
	 */
	public void setUserOfcCd(String userOfcCd) {
		this.userOfcCd = userOfcCd;
	}
	
	/**
	 * Column Info
	 * @param sDateType
	 */
	public void setSDateType(String sDateType) {
		this.sDateType = sDateType;
	}
	
	/**
	 * Column Info
	 * @param sEdate
	 */
	public void setSEdate(String sEdate) {
		this.sEdate = sEdate;
	}
	
	/**
	 * Column Info
	 * @param ifOfcCd
	 */
	public void setIfOfcCd(String ifOfcCd) {
		this.ifOfcCd = ifOfcCd;
	}
	
	/**
	 * Column Info
	 * @param mnrRatio
	 */
	public void setMnrRatio(String mnrRatio) {
		this.mnrRatio = mnrRatio;
	}
	
	/**
	 * Column Info
	 * @param sSdate
	 */
	public void setSSdate(String sSdate) {
		this.sSdate = sSdate;
	}
	
	/**
	 * Column Info
	 * @param totalRatio
	 */
	public void setTotalRatio(String totalRatio) {
		this.totalRatio = totalRatio;
	}
	
	/**
	 * Column Info
	 * @param sIfOfcCd
	 */
	public void setSIfOfcCd(String sIfOfcCd) {
		this.sIfOfcCd = sIfOfcCd;
	}
	
	/**
	 * Column Info
	 * @param sIfCtrlCd
	 */
	public void setSIfCtrlCd(String sIfCtrlCd) {
		this.sIfCtrlCd = sIfCtrlCd;
	}
	
	/**
	 * Column Info
	 * @param sOfcCdForRhq
	 */
	public void setSOfcCdForRhq(String sOfcCdForRhq) {
		this.sOfcCdForRhq = sOfcCdForRhq;
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
	 * @param trsCnt
	 */
	public void setTrsCnt(String trsCnt) {
		this.trsCnt = trsCnt;
	}
	
	/**
	 * Column Info
	 * @param cdType
	 */
	public void setCdType(String cdType) {
		this.cdType = cdType;
	}
	
	/**
	 * Column Info
	 * @param tesRatio
	 */
	public void setTesRatio(String tesRatio) {
		this.tesRatio = tesRatio;
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
	 * @param sRhqCdForRhq
	 */
	public void setSRhqCdForRhq(String sRhqCdForRhq) {
		this.sRhqCdForRhq = sRhqCdForRhq;
	}
	
	/**
	 * Column Info
	 * @param mnrCnt
	 */
	public void setMnrCnt(String mnrCnt) {
		this.mnrCnt = mnrCnt;
	}
	
	/**
	 * Column Info
	 * @param trsRatio
	 */
	public void setTrsRatio(String trsRatio) {
		this.trsRatio = trsRatio;
	}
	
	/**
	 * Column Info
	 * @param sIfRhqCd
	 */
	public void setSIfRhqCd(String sIfRhqCd) {
		this.sIfRhqCd = sIfRhqCd;
	}
	
	/**
	 * Column Info
	 * @param totalCnt
	 */
	public void setTotalCnt(String totalCnt) {
		this.totalCnt = totalCnt;
	}
	
	/**
	 * Column Info
	 * @param sOfficeLevel
	 */
	public void setSOfficeLevel(String sOfficeLevel) {
		this.sOfficeLevel = sOfficeLevel;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setTesCnt(JSPUtil.getParameter(request, "tes_cnt", ""));
		setUserOfcCd(JSPUtil.getParameter(request, "user_ofc_cd", ""));
		setSDateType(JSPUtil.getParameter(request, "s_date_type", ""));
		setSEdate(JSPUtil.getParameter(request, "s_edate", ""));
		setIfOfcCd(JSPUtil.getParameter(request, "if_ofc_cd", ""));
		setMnrRatio(JSPUtil.getParameter(request, "mnr_ratio", ""));
		setSSdate(JSPUtil.getParameter(request, "s_sdate", ""));
		setTotalRatio(JSPUtil.getParameter(request, "total_ratio", ""));
		setSIfOfcCd(JSPUtil.getParameter(request, "s_if_ofc_cd", ""));
		setSIfCtrlCd(JSPUtil.getParameter(request, "s_if_ctrl_cd", ""));
		setSOfcCdForRhq(JSPUtil.getParameter(request, "s_ofc_cd_for_rhq", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setTrsCnt(JSPUtil.getParameter(request, "trs_cnt", ""));
		setCdType(JSPUtil.getParameter(request, "cd_type", ""));
		setTesRatio(JSPUtil.getParameter(request, "tes_ratio", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setSRhqCdForRhq(JSPUtil.getParameter(request, "s_rhq_cd_for_rhq", ""));
		setMnrCnt(JSPUtil.getParameter(request, "mnr_cnt", ""));
		setTrsRatio(JSPUtil.getParameter(request, "trs_ratio", ""));
		setSIfRhqCd(JSPUtil.getParameter(request, "s_if_rhq_cd", ""));
		setTotalCnt(JSPUtil.getParameter(request, "total_cnt", ""));
		setSOfficeLevel(JSPUtil.getParameter(request, "s_office_level", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchNonTPBListVO[]
	 */
	public SearchNonTPBListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchNonTPBListVO[]
	 */
	public SearchNonTPBListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchNonTPBListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] tesCnt = (JSPUtil.getParameter(request, prefix	+ "tes_cnt", length));
			String[] userOfcCd = (JSPUtil.getParameter(request, prefix	+ "user_ofc_cd", length));
			String[] sDateType = (JSPUtil.getParameter(request, prefix	+ "s_date_type", length));
			String[] sEdate = (JSPUtil.getParameter(request, prefix	+ "s_edate", length));
			String[] ifOfcCd = (JSPUtil.getParameter(request, prefix	+ "if_ofc_cd", length));
			String[] mnrRatio = (JSPUtil.getParameter(request, prefix	+ "mnr_ratio", length));
			String[] sSdate = (JSPUtil.getParameter(request, prefix	+ "s_sdate", length));
			String[] totalRatio = (JSPUtil.getParameter(request, prefix	+ "total_ratio", length));
			String[] sIfOfcCd = (JSPUtil.getParameter(request, prefix	+ "s_if_ofc_cd", length));
			String[] sIfCtrlCd = (JSPUtil.getParameter(request, prefix	+ "s_if_ctrl_cd", length));
			String[] sOfcCdForRhq = (JSPUtil.getParameter(request, prefix	+ "s_ofc_cd_for_rhq", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] trsCnt = (JSPUtil.getParameter(request, prefix	+ "trs_cnt", length));
			String[] cdType = (JSPUtil.getParameter(request, prefix	+ "cd_type", length));
			String[] tesRatio = (JSPUtil.getParameter(request, prefix	+ "tes_ratio", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] sRhqCdForRhq = (JSPUtil.getParameter(request, prefix	+ "s_rhq_cd_for_rhq", length));
			String[] mnrCnt = (JSPUtil.getParameter(request, prefix	+ "mnr_cnt", length));
			String[] trsRatio = (JSPUtil.getParameter(request, prefix	+ "trs_ratio", length));
			String[] sIfRhqCd = (JSPUtil.getParameter(request, prefix	+ "s_if_rhq_cd", length));
			String[] totalCnt = (JSPUtil.getParameter(request, prefix	+ "total_cnt", length));
			String[] sOfficeLevel = (JSPUtil.getParameter(request, prefix	+ "s_office_level", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchNonTPBListVO();
				if (tesCnt[i] != null)
					model.setTesCnt(tesCnt[i]);
				if (userOfcCd[i] != null)
					model.setUserOfcCd(userOfcCd[i]);
				if (sDateType[i] != null)
					model.setSDateType(sDateType[i]);
				if (sEdate[i] != null)
					model.setSEdate(sEdate[i]);
				if (ifOfcCd[i] != null)
					model.setIfOfcCd(ifOfcCd[i]);
				if (mnrRatio[i] != null)
					model.setMnrRatio(mnrRatio[i]);
				if (sSdate[i] != null)
					model.setSSdate(sSdate[i]);
				if (totalRatio[i] != null)
					model.setTotalRatio(totalRatio[i]);
				if (sIfOfcCd[i] != null)
					model.setSIfOfcCd(sIfOfcCd[i]);
				if (sIfCtrlCd[i] != null)
					model.setSIfCtrlCd(sIfCtrlCd[i]);
				if (sOfcCdForRhq[i] != null)
					model.setSOfcCdForRhq(sOfcCdForRhq[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (trsCnt[i] != null)
					model.setTrsCnt(trsCnt[i]);
				if (cdType[i] != null)
					model.setCdType(cdType[i]);
				if (tesRatio[i] != null)
					model.setTesRatio(tesRatio[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (sRhqCdForRhq[i] != null)
					model.setSRhqCdForRhq(sRhqCdForRhq[i]);
				if (mnrCnt[i] != null)
					model.setMnrCnt(mnrCnt[i]);
				if (trsRatio[i] != null)
					model.setTrsRatio(trsRatio[i]);
				if (sIfRhqCd[i] != null)
					model.setSIfRhqCd(sIfRhqCd[i]);
				if (totalCnt[i] != null)
					model.setTotalCnt(totalCnt[i]);
				if (sOfficeLevel[i] != null)
					model.setSOfficeLevel(sOfficeLevel[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchNonTPBListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchNonTPBListVO[]
	 */
	public SearchNonTPBListVO[] getSearchNonTPBListVOs(){
		SearchNonTPBListVO[] vos = (SearchNonTPBListVO[])models.toArray(new SearchNonTPBListVO[models.size()]);
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
		this.tesCnt = this.tesCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.userOfcCd = this.userOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sDateType = this.sDateType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sEdate = this.sEdate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ifOfcCd = this.ifOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnrRatio = this.mnrRatio .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sSdate = this.sSdate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totalRatio = this.totalRatio .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sIfOfcCd = this.sIfOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sIfCtrlCd = this.sIfCtrlCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sOfcCdForRhq = this.sOfcCdForRhq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trsCnt = this.trsCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cdType = this.cdType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tesRatio = this.tesRatio .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sRhqCdForRhq = this.sRhqCdForRhq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnrCnt = this.mnrCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trsRatio = this.trsRatio .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sIfRhqCd = this.sIfRhqCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totalCnt = this.totalCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sOfficeLevel = this.sOfficeLevel .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
