/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : searchBkbcFrtVO.java
*@FileTitle : searchBkbcFrtVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.22
*@LastModifier : 박성호
*@LastVersion : 1.0
* 2009.10.22 박성호 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo;

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
 * @author 박성호
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class searchBkbcFrtVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<searchBkbcFrtVO> models = new ArrayList<searchBkbcFrtVO>();
	
	/* Column Info */
	private String frtChkCnt = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String frtCltFlg = null;
	/* Column Info */
	private String evntUsrId = null;
	/* Column Info */
	private String cgoEvntNm = null;
	/* Column Info */
	private String frtChk = null;
	/* Column Info */
	private String cgorTeamCd = null;
	/* Column Info */
	private String eventOfcCd = null;
	/* Column Info */
	private String blNo = null;
	/* Column Info */
	private String evntDt = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public searchBkbcFrtVO() {}

	public searchBkbcFrtVO(String ibflag, String pagerows, String frtChk, String frtChkCnt, String blNo, String cgoEvntNm, String cgorTeamCd, String evntDt, String eventOfcCd, String evntUsrId, String frtCltFlg) {
		this.frtChkCnt = frtChkCnt;
		this.ibflag = ibflag;
		this.frtCltFlg = frtCltFlg;
		this.evntUsrId = evntUsrId;
		this.cgoEvntNm = cgoEvntNm;
		this.frtChk = frtChk;
		this.cgorTeamCd = cgorTeamCd;
		this.eventOfcCd = eventOfcCd;
		this.blNo = blNo;
		this.evntDt = evntDt;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("frt_chk_cnt", getFrtChkCnt());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("frt_clt_flg", getFrtCltFlg());
		this.hashColumns.put("evnt_usr_id", getEvntUsrId());
		this.hashColumns.put("cgo_evnt_nm", getCgoEvntNm());
		this.hashColumns.put("frt_chk", getFrtChk());
		this.hashColumns.put("cgor_team_cd", getCgorTeamCd());
		this.hashColumns.put("event_ofc_cd", getEventOfcCd());
		this.hashColumns.put("bl_no", getBlNo());
		this.hashColumns.put("evnt_dt", getEvntDt());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("frt_chk_cnt", "frtChkCnt");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("frt_clt_flg", "frtCltFlg");
		this.hashFields.put("evnt_usr_id", "evntUsrId");
		this.hashFields.put("cgo_evnt_nm", "cgoEvntNm");
		this.hashFields.put("frt_chk", "frtChk");
		this.hashFields.put("cgor_team_cd", "cgorTeamCd");
		this.hashFields.put("event_ofc_cd", "eventOfcCd");
		this.hashFields.put("bl_no", "blNo");
		this.hashFields.put("evnt_dt", "evntDt");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return frtChkCnt
	 */
	public String getFrtChkCnt() {
		return this.frtChkCnt;
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
	 * @return frtCltFlg
	 */
	public String getFrtCltFlg() {
		return this.frtCltFlg;
	}
	
	/**
	 * Column Info
	 * @return evntUsrId
	 */
	public String getEvntUsrId() {
		return this.evntUsrId;
	}
	
	/**
	 * Column Info
	 * @return cgoEvntNm
	 */
	public String getCgoEvntNm() {
		return this.cgoEvntNm;
	}
	
	/**
	 * Column Info
	 * @return frtChk
	 */
	public String getFrtChk() {
		return this.frtChk;
	}
	
	/**
	 * Column Info
	 * @return cgorTeamCd
	 */
	public String getCgorTeamCd() {
		return this.cgorTeamCd;
	}
	
	/**
	 * Column Info
	 * @return eventOfcCd
	 */
	public String getEventOfcCd() {
		return this.eventOfcCd;
	}
	
	/**
	 * Column Info
	 * @return blNo
	 */
	public String getBlNo() {
		return this.blNo;
	}
	
	/**
	 * Column Info
	 * @return evntDt
	 */
	public String getEvntDt() {
		return this.evntDt;
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
	 * @param frtChkCnt
	 */
	public void setFrtChkCnt(String frtChkCnt) {
		this.frtChkCnt = frtChkCnt;
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
	 * @param frtCltFlg
	 */
	public void setFrtCltFlg(String frtCltFlg) {
		this.frtCltFlg = frtCltFlg;
	}
	
	/**
	 * Column Info
	 * @param evntUsrId
	 */
	public void setEvntUsrId(String evntUsrId) {
		this.evntUsrId = evntUsrId;
	}
	
	/**
	 * Column Info
	 * @param cgoEvntNm
	 */
	public void setCgoEvntNm(String cgoEvntNm) {
		this.cgoEvntNm = cgoEvntNm;
	}
	
	/**
	 * Column Info
	 * @param frtChk
	 */
	public void setFrtChk(String frtChk) {
		this.frtChk = frtChk;
	}
	
	/**
	 * Column Info
	 * @param cgorTeamCd
	 */
	public void setCgorTeamCd(String cgorTeamCd) {
		this.cgorTeamCd = cgorTeamCd;
	}
	
	/**
	 * Column Info
	 * @param eventOfcCd
	 */
	public void setEventOfcCd(String eventOfcCd) {
		this.eventOfcCd = eventOfcCd;
	}
	
	/**
	 * Column Info
	 * @param blNo
	 */
	public void setBlNo(String blNo) {
		this.blNo = blNo;
	}
	
	/**
	 * Column Info
	 * @param evntDt
	 */
	public void setEvntDt(String evntDt) {
		this.evntDt = evntDt;
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
		setFrtChkCnt(JSPUtil.getParameter(request, "frt_chk_cnt", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setFrtCltFlg(JSPUtil.getParameter(request, "frt_clt_flg", ""));
		setEvntUsrId(JSPUtil.getParameter(request, "evnt_usr_id", ""));
		setCgoEvntNm(JSPUtil.getParameter(request, "cgo_evnt_nm", ""));
		setFrtChk(JSPUtil.getParameter(request, "frt_chk", ""));
		setCgorTeamCd(JSPUtil.getParameter(request, "cgor_team_cd", ""));
		setEventOfcCd(JSPUtil.getParameter(request, "event_ofc_cd", ""));
		setBlNo(JSPUtil.getParameter(request, "bl_no", ""));
		setEvntDt(JSPUtil.getParameter(request, "evnt_dt", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return searchBkbcFrtVO[]
	 */
	public searchBkbcFrtVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return searchBkbcFrtVO[]
	 */
	public searchBkbcFrtVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		searchBkbcFrtVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] frtChkCnt = (JSPUtil.getParameter(request, prefix	+ "frt_chk_cnt", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] frtCltFlg = (JSPUtil.getParameter(request, prefix	+ "frt_clt_flg", length));
			String[] evntUsrId = (JSPUtil.getParameter(request, prefix	+ "evnt_usr_id", length));
			String[] cgoEvntNm = (JSPUtil.getParameter(request, prefix	+ "cgo_evnt_nm", length));
			String[] frtChk = (JSPUtil.getParameter(request, prefix	+ "frt_chk", length));
			String[] cgorTeamCd = (JSPUtil.getParameter(request, prefix	+ "cgor_team_cd", length));
			String[] eventOfcCd = (JSPUtil.getParameter(request, prefix	+ "event_ofc_cd", length));
			String[] blNo = (JSPUtil.getParameter(request, prefix	+ "bl_no", length));
			String[] evntDt = (JSPUtil.getParameter(request, prefix	+ "evnt_dt", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new searchBkbcFrtVO();
				if (frtChkCnt[i] != null)
					model.setFrtChkCnt(frtChkCnt[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (frtCltFlg[i] != null)
					model.setFrtCltFlg(frtCltFlg[i]);
				if (evntUsrId[i] != null)
					model.setEvntUsrId(evntUsrId[i]);
				if (cgoEvntNm[i] != null)
					model.setCgoEvntNm(cgoEvntNm[i]);
				if (frtChk[i] != null)
					model.setFrtChk(frtChk[i]);
				if (cgorTeamCd[i] != null)
					model.setCgorTeamCd(cgorTeamCd[i]);
				if (eventOfcCd[i] != null)
					model.setEventOfcCd(eventOfcCd[i]);
				if (blNo[i] != null)
					model.setBlNo(blNo[i]);
				if (evntDt[i] != null)
					model.setEvntDt(evntDt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getsearchBkbcFrtVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return searchBkbcFrtVO[]
	 */
	public searchBkbcFrtVO[] getsearchBkbcFrtVOs(){
		searchBkbcFrtVO[] vos = (searchBkbcFrtVO[])models.toArray(new searchBkbcFrtVO[models.size()]);
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
		this.frtChkCnt = this.frtChkCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.frtCltFlg = this.frtCltFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.evntUsrId = this.evntUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cgoEvntNm = this.cgoEvntNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.frtChk = this.frtChk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cgorTeamCd = this.cgorTeamCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eventOfcCd = this.eventOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo = this.blNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.evntDt = this.evntDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
