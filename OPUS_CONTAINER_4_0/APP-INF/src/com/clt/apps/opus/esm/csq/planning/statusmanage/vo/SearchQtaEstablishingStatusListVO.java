/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : SearchQtaEstablishingStatusListVO.java
*@FileTitle : SearchQtaEstablishingStatusListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2013.09.03
*@LastModifier : 최윤성
*@LastVersion : 1.0
* 2013.09.03 최윤성 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.csq.planning.statusmanage.vo;

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
 * @author 최윤성
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SearchQtaEstablishingStatusListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchQtaEstablishingStatusListVO> models = new ArrayList<SearchQtaEstablishingStatusListVO>();
	
	/* Column Info */
	private String qtaStepCd = null;
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String ofcVwCd = null;
	/* Column Info */
	private String teamCd = null;
	/* Column Info */
	private String trdCd = null;
	/* Column Info */
	private String qtaStepDesc = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String csqVerStsDesc = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String csqVerStsCd = null;
	/* Column Info */
	private String qtaVerNo = null;
	/* Column Info */
	private String convDirCd = null;
	/* Column Info */
	private String creOfcCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SearchQtaEstablishingStatusListVO() {}

	public SearchQtaEstablishingStatusListVO(String ibflag, String pagerows, String qtaStepCd, String qtaStepDesc, String ofcVwCd, String csqVerStsCd, String csqVerStsDesc, String qtaVerNo, String teamCd, String trdCd, String convDirCd, String creOfcCd, String updDt) {
		this.qtaStepCd = qtaStepCd;
		this.updDt = updDt;
		this.ofcVwCd = ofcVwCd;
		this.teamCd = teamCd;
		this.trdCd = trdCd;
		this.qtaStepDesc = qtaStepDesc;
		this.pagerows = pagerows;
		this.csqVerStsDesc = csqVerStsDesc;
		this.ibflag = ibflag;
		this.csqVerStsCd = csqVerStsCd;
		this.qtaVerNo = qtaVerNo;
		this.convDirCd = convDirCd;
		this.creOfcCd = creOfcCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("qta_step_cd", getQtaStepCd());
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("ofc_vw_cd", getOfcVwCd());
		this.hashColumns.put("team_cd", getTeamCd());
		this.hashColumns.put("trd_cd", getTrdCd());
		this.hashColumns.put("qta_step_desc", getQtaStepDesc());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("csq_ver_sts_desc", getCsqVerStsDesc());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("csq_ver_sts_cd", getCsqVerStsCd());
		this.hashColumns.put("qta_ver_no", getQtaVerNo());
		this.hashColumns.put("conv_dir_cd", getConvDirCd());
		this.hashColumns.put("cre_ofc_cd", getCreOfcCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("qta_step_cd", "qtaStepCd");
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("ofc_vw_cd", "ofcVwCd");
		this.hashFields.put("team_cd", "teamCd");
		this.hashFields.put("trd_cd", "trdCd");
		this.hashFields.put("qta_step_desc", "qtaStepDesc");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("csq_ver_sts_desc", "csqVerStsDesc");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("csq_ver_sts_cd", "csqVerStsCd");
		this.hashFields.put("qta_ver_no", "qtaVerNo");
		this.hashFields.put("conv_dir_cd", "convDirCd");
		this.hashFields.put("cre_ofc_cd", "creOfcCd");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return qtaStepCd
	 */
	public String getQtaStepCd() {
		return this.qtaStepCd;
	}
	
	/**
	 * Column Info
	 * @return updDt
	 */
	public String getUpdDt() {
		return this.updDt;
	}
	
	/**
	 * Column Info
	 * @return ofcVwCd
	 */
	public String getOfcVwCd() {
		return this.ofcVwCd;
	}
	
	/**
	 * Column Info
	 * @return teamCd
	 */
	public String getTeamCd() {
		return this.teamCd;
	}
	
	/**
	 * Column Info
	 * @return trdCd
	 */
	public String getTrdCd() {
		return this.trdCd;
	}
	
	/**
	 * Column Info
	 * @return qtaStepDesc
	 */
	public String getQtaStepDesc() {
		return this.qtaStepDesc;
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
	 * @return csqVerStsDesc
	 */
	public String getCsqVerStsDesc() {
		return this.csqVerStsDesc;
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
	 * @return csqVerStsCd
	 */
	public String getCsqVerStsCd() {
		return this.csqVerStsCd;
	}
	
	/**
	 * Column Info
	 * @return qtaVerNo
	 */
	public String getQtaVerNo() {
		return this.qtaVerNo;
	}
	
	/**
	 * Column Info
	 * @return convDirCd
	 */
	public String getConvDirCd() {
		return this.convDirCd;
	}
	
	/**
	 * Column Info
	 * @return creOfcCd
	 */
	public String getCreOfcCd() {
		return this.creOfcCd;
	}
	

	/**
	 * Column Info
	 * @param qtaStepCd
	 */
	public void setQtaStepCd(String qtaStepCd) {
		this.qtaStepCd = qtaStepCd;
	}
	
	/**
	 * Column Info
	 * @param updDt
	 */
	public void setUpdDt(String updDt) {
		this.updDt = updDt;
	}
	
	/**
	 * Column Info
	 * @param ofcVwCd
	 */
	public void setOfcVwCd(String ofcVwCd) {
		this.ofcVwCd = ofcVwCd;
	}
	
	/**
	 * Column Info
	 * @param teamCd
	 */
	public void setTeamCd(String teamCd) {
		this.teamCd = teamCd;
	}
	
	/**
	 * Column Info
	 * @param trdCd
	 */
	public void setTrdCd(String trdCd) {
		this.trdCd = trdCd;
	}
	
	/**
	 * Column Info
	 * @param qtaStepDesc
	 */
	public void setQtaStepDesc(String qtaStepDesc) {
		this.qtaStepDesc = qtaStepDesc;
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
	 * @param csqVerStsDesc
	 */
	public void setCsqVerStsDesc(String csqVerStsDesc) {
		this.csqVerStsDesc = csqVerStsDesc;
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
	 * @param csqVerStsCd
	 */
	public void setCsqVerStsCd(String csqVerStsCd) {
		this.csqVerStsCd = csqVerStsCd;
	}
	
	/**
	 * Column Info
	 * @param qtaVerNo
	 */
	public void setQtaVerNo(String qtaVerNo) {
		this.qtaVerNo = qtaVerNo;
	}
	
	/**
	 * Column Info
	 * @param convDirCd
	 */
	public void setConvDirCd(String convDirCd) {
		this.convDirCd = convDirCd;
	}
	
	/**
	 * Column Info
	 * @param creOfcCd
	 */
	public void setCreOfcCd(String creOfcCd) {
		this.creOfcCd = creOfcCd;
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
		setQtaStepCd(JSPUtil.getParameter(request, prefix + "qta_step_cd", ""));
		setUpdDt(JSPUtil.getParameter(request, prefix + "upd_dt", ""));
		setOfcVwCd(JSPUtil.getParameter(request, prefix + "ofc_vw_cd", ""));
		setTeamCd(JSPUtil.getParameter(request, prefix + "team_cd", ""));
		setTrdCd(JSPUtil.getParameter(request, prefix + "trd_cd", ""));
		setQtaStepDesc(JSPUtil.getParameter(request, prefix + "qta_step_desc", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setCsqVerStsDesc(JSPUtil.getParameter(request, prefix + "csq_ver_sts_desc", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setCsqVerStsCd(JSPUtil.getParameter(request, prefix + "csq_ver_sts_cd", ""));
		setQtaVerNo(JSPUtil.getParameter(request, prefix + "qta_ver_no", ""));
		setConvDirCd(JSPUtil.getParameter(request, prefix + "conv_dir_cd", ""));
		setCreOfcCd(JSPUtil.getParameter(request, prefix + "cre_ofc_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchQtaEstablishingStatusListVO[]
	 */
	public SearchQtaEstablishingStatusListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchQtaEstablishingStatusListVO[]
	 */
	public SearchQtaEstablishingStatusListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchQtaEstablishingStatusListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] qtaStepCd = (JSPUtil.getParameter(request, prefix	+ "qta_step_cd", length));
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] ofcVwCd = (JSPUtil.getParameter(request, prefix	+ "ofc_vw_cd", length));
			String[] teamCd = (JSPUtil.getParameter(request, prefix	+ "team_cd", length));
			String[] trdCd = (JSPUtil.getParameter(request, prefix	+ "trd_cd", length));
			String[] qtaStepDesc = (JSPUtil.getParameter(request, prefix	+ "qta_step_desc", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] csqVerStsDesc = (JSPUtil.getParameter(request, prefix	+ "csq_ver_sts_desc", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] csqVerStsCd = (JSPUtil.getParameter(request, prefix	+ "csq_ver_sts_cd", length));
			String[] qtaVerNo = (JSPUtil.getParameter(request, prefix	+ "qta_ver_no", length));
			String[] convDirCd = (JSPUtil.getParameter(request, prefix	+ "conv_dir_cd", length));
			String[] creOfcCd = (JSPUtil.getParameter(request, prefix	+ "cre_ofc_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchQtaEstablishingStatusListVO();
				if (qtaStepCd[i] != null)
					model.setQtaStepCd(qtaStepCd[i]);
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (ofcVwCd[i] != null)
					model.setOfcVwCd(ofcVwCd[i]);
				if (teamCd[i] != null)
					model.setTeamCd(teamCd[i]);
				if (trdCd[i] != null)
					model.setTrdCd(trdCd[i]);
				if (qtaStepDesc[i] != null)
					model.setQtaStepDesc(qtaStepDesc[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (csqVerStsDesc[i] != null)
					model.setCsqVerStsDesc(csqVerStsDesc[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (csqVerStsCd[i] != null)
					model.setCsqVerStsCd(csqVerStsCd[i]);
				if (qtaVerNo[i] != null)
					model.setQtaVerNo(qtaVerNo[i]);
				if (convDirCd[i] != null)
					model.setConvDirCd(convDirCd[i]);
				if (creOfcCd[i] != null)
					model.setCreOfcCd(creOfcCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchQtaEstablishingStatusListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchQtaEstablishingStatusListVO[]
	 */
	public SearchQtaEstablishingStatusListVO[] getSearchQtaEstablishingStatusListVOs(){
		SearchQtaEstablishingStatusListVO[] vos = (SearchQtaEstablishingStatusListVO[])models.toArray(new SearchQtaEstablishingStatusListVO[models.size()]);
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
		this.qtaStepCd = this.qtaStepCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcVwCd = this.ofcVwCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.teamCd = this.teamCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trdCd = this.trdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.qtaStepDesc = this.qtaStepDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.csqVerStsDesc = this.csqVerStsDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.csqVerStsCd = this.csqVerStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.qtaVerNo = this.qtaVerNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.convDirCd = this.convDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creOfcCd = this.creOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
