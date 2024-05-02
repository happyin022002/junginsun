/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : CstmsClrVO.java
*@FileTitle : CstmsClrVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.01.07
*@LastModifier : 
*@LastVersion : 1.0
* 2010.01.07  
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo;

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
 * @author
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class CstmsClrVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<CstmsClrVO> models = new ArrayList<CstmsClrVO>();
	
	/* Column Info */
	private String cstmsLocCd = null;
	/* Column Info */
	private String cstmsClrCd = null;
	/* Column Info */
	private String evntOfcCd = null;
	/* Column Info */
	private String cgoEvntNm = null;
	/* Column Info */
	private String cstmsChk = null;
	/* Column Info */
	private String blNo = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String cstmsChkCnt = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String evntUsrId = null;
	/* Column Info */
	private String cntCd = null;
	/* Column Info */
	private String cgorTeamCd = null;
	/* Column Info */
	private String hisSeq = null;
	/* Column Info */
	private String cstmsDsPoCd = null;
	/* Column Info */
	private String usChk = null;
	/* Column Info */
	private String evntDt = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public CstmsClrVO() {}

	public CstmsClrVO(String ibflag, String pagerows, String blNo, String cgoEvntNm, String cgorTeamCd, String cstmsClrCd, String cstmsDsPoCd, String cstmsLocCd, String evntDt, String evntOfcCd, String evntUsrId, String cstmsChk, String cstmsChkCnt, String usChk, String cntCd, String hisSeq) {
		this.cstmsLocCd = cstmsLocCd;
		this.cstmsClrCd = cstmsClrCd;
		this.evntOfcCd = evntOfcCd;
		this.cgoEvntNm = cgoEvntNm;
		this.cstmsChk = cstmsChk;
		this.blNo = blNo;
		this.pagerows = pagerows;
		this.cstmsChkCnt = cstmsChkCnt;
		this.ibflag = ibflag;
		this.evntUsrId = evntUsrId;
		this.cntCd = cntCd;
		this.cgorTeamCd = cgorTeamCd;
		this.hisSeq = hisSeq;
		this.cstmsDsPoCd = cstmsDsPoCd;
		this.usChk = usChk;
		this.evntDt = evntDt;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("cstms_loc_cd", getCstmsLocCd());
		this.hashColumns.put("cstms_clr_cd", getCstmsClrCd());
		this.hashColumns.put("evnt_ofc_cd", getEvntOfcCd());
		this.hashColumns.put("cgo_evnt_nm", getCgoEvntNm());
		this.hashColumns.put("cstms_chk", getCstmsChk());
		this.hashColumns.put("bl_no", getBlNo());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("cstms_chk_cnt", getCstmsChkCnt());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("evnt_usr_id", getEvntUsrId());
		this.hashColumns.put("cnt_cd", getCntCd());
		this.hashColumns.put("cgor_team_cd", getCgorTeamCd());
		this.hashColumns.put("his_seq", getHisSeq());
		this.hashColumns.put("cstms_ds_po_cd", getCstmsDsPoCd());
		this.hashColumns.put("us_chk", getUsChk());
		this.hashColumns.put("evnt_dt", getEvntDt());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("cstms_loc_cd", "cstmsLocCd");
		this.hashFields.put("cstms_clr_cd", "cstmsClrCd");
		this.hashFields.put("evnt_ofc_cd", "evntOfcCd");
		this.hashFields.put("cgo_evnt_nm", "cgoEvntNm");
		this.hashFields.put("cstms_chk", "cstmsChk");
		this.hashFields.put("bl_no", "blNo");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("cstms_chk_cnt", "cstmsChkCnt");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("evnt_usr_id", "evntUsrId");
		this.hashFields.put("cnt_cd", "cntCd");
		this.hashFields.put("cgor_team_cd", "cgorTeamCd");
		this.hashFields.put("his_seq", "hisSeq");
		this.hashFields.put("cstms_ds_po_cd", "cstmsDsPoCd");
		this.hashFields.put("us_chk", "usChk");
		this.hashFields.put("evnt_dt", "evntDt");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return cstmsLocCd
	 */
	public String getCstmsLocCd() {
		return this.cstmsLocCd;
	}
	
	/**
	 * Column Info
	 * @return cstmsClrCd
	 */
	public String getCstmsClrCd() {
		return this.cstmsClrCd;
	}
	
	/**
	 * Column Info
	 * @return evntOfcCd
	 */
	public String getEvntOfcCd() {
		return this.evntOfcCd;
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
	 * @return cstmsChk
	 */
	public String getCstmsChk() {
		return this.cstmsChk;
	}
	
	/**
	 * Column Info
	 * @return blNo
	 */
	public String getBlNo() {
		return this.blNo;
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
	 * @return cstmsChkCnt
	 */
	public String getCstmsChkCnt() {
		return this.cstmsChkCnt;
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
	 * @return evntUsrId
	 */
	public String getEvntUsrId() {
		return this.evntUsrId;
	}
	
	/**
	 * Column Info
	 * @return cntCd
	 */
	public String getCntCd() {
		return this.cntCd;
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
	 * @return hisSeq
	 */
	public String getHisSeq() {
		return this.hisSeq;
	}
	
	/**
	 * Column Info
	 * @return cstmsDsPoCd
	 */
	public String getCstmsDsPoCd() {
		return this.cstmsDsPoCd;
	}
	
	/**
	 * Column Info
	 * @return usChk
	 */
	public String getUsChk() {
		return this.usChk;
	}
	
	/**
	 * Column Info
	 * @return evntDt
	 */
	public String getEvntDt() {
		return this.evntDt;
	}
	

	/**
	 * Column Info
	 * @param cstmsLocCd
	 */
	public void setCstmsLocCd(String cstmsLocCd) {
		this.cstmsLocCd = cstmsLocCd;
	}
	
	/**
	 * Column Info
	 * @param cstmsClrCd
	 */
	public void setCstmsClrCd(String cstmsClrCd) {
		this.cstmsClrCd = cstmsClrCd;
	}
	
	/**
	 * Column Info
	 * @param evntOfcCd
	 */
	public void setEvntOfcCd(String evntOfcCd) {
		this.evntOfcCd = evntOfcCd;
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
	 * @param cstmsChk
	 */
	public void setCstmsChk(String cstmsChk) {
		this.cstmsChk = cstmsChk;
	}
	
	/**
	 * Column Info
	 * @param blNo
	 */
	public void setBlNo(String blNo) {
		this.blNo = blNo;
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
	 * @param cstmsChkCnt
	 */
	public void setCstmsChkCnt(String cstmsChkCnt) {
		this.cstmsChkCnt = cstmsChkCnt;
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
	 * @param evntUsrId
	 */
	public void setEvntUsrId(String evntUsrId) {
		this.evntUsrId = evntUsrId;
	}
	
	/**
	 * Column Info
	 * @param cntCd
	 */
	public void setCntCd(String cntCd) {
		this.cntCd = cntCd;
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
	 * @param hisSeq
	 */
	public void setHisSeq(String hisSeq) {
		this.hisSeq = hisSeq;
	}
	
	/**
	 * Column Info
	 * @param cstmsDsPoCd
	 */
	public void setCstmsDsPoCd(String cstmsDsPoCd) {
		this.cstmsDsPoCd = cstmsDsPoCd;
	}
	
	/**
	 * Column Info
	 * @param usChk
	 */
	public void setUsChk(String usChk) {
		this.usChk = usChk;
	}
	
	/**
	 * Column Info
	 * @param evntDt
	 */
	public void setEvntDt(String evntDt) {
		this.evntDt = evntDt;
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
		setCstmsLocCd(JSPUtil.getParameter(request, prefix + "cstms_loc_cd", ""));
		setCstmsClrCd(JSPUtil.getParameter(request, prefix + "cstms_clr_cd", ""));
		setEvntOfcCd(JSPUtil.getParameter(request, prefix + "evnt_ofc_cd", ""));
		setCgoEvntNm(JSPUtil.getParameter(request, prefix + "cgo_evnt_nm", ""));
		setCstmsChk(JSPUtil.getParameter(request, prefix + "cstms_chk", ""));
		setBlNo(JSPUtil.getParameter(request, prefix + "bl_no", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setCstmsChkCnt(JSPUtil.getParameter(request, prefix + "cstms_chk_cnt", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setEvntUsrId(JSPUtil.getParameter(request, prefix + "evnt_usr_id", ""));
		setCntCd(JSPUtil.getParameter(request, prefix + "cnt_cd", ""));
		setCgorTeamCd(JSPUtil.getParameter(request, prefix + "cgor_team_cd", ""));
		setHisSeq(JSPUtil.getParameter(request, prefix + "his_seq", ""));
		setCstmsDsPoCd(JSPUtil.getParameter(request, prefix + "cstms_ds_po_cd", ""));
		setUsChk(JSPUtil.getParameter(request, prefix + "us_chk", ""));
		setEvntDt(JSPUtil.getParameter(request, prefix + "evnt_dt", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return CstmsClrVO[]
	 */
	public CstmsClrVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return CstmsClrVO[]
	 */
	public CstmsClrVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		CstmsClrVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] cstmsLocCd = (JSPUtil.getParameter(request, prefix	+ "cstms_loc_cd", length));
			String[] cstmsClrCd = (JSPUtil.getParameter(request, prefix	+ "cstms_clr_cd", length));
			String[] evntOfcCd = (JSPUtil.getParameter(request, prefix	+ "evnt_ofc_cd", length));
			String[] cgoEvntNm = (JSPUtil.getParameter(request, prefix	+ "cgo_evnt_nm", length));
			String[] cstmsChk = (JSPUtil.getParameter(request, prefix	+ "cstms_chk", length));
			String[] blNo = (JSPUtil.getParameter(request, prefix	+ "bl_no", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] cstmsChkCnt = (JSPUtil.getParameter(request, prefix	+ "cstms_chk_cnt", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] evntUsrId = (JSPUtil.getParameter(request, prefix	+ "evnt_usr_id", length));
			String[] cntCd = (JSPUtil.getParameter(request, prefix	+ "cnt_cd", length));
			String[] cgorTeamCd = (JSPUtil.getParameter(request, prefix	+ "cgor_team_cd", length));
			String[] hisSeq = (JSPUtil.getParameter(request, prefix	+ "his_seq", length));
			String[] cstmsDsPoCd = (JSPUtil.getParameter(request, prefix	+ "cstms_ds_po_cd", length));
			String[] usChk = (JSPUtil.getParameter(request, prefix	+ "us_chk", length));
			String[] evntDt = (JSPUtil.getParameter(request, prefix	+ "evnt_dt", length));
			
			for (int i = 0; i < length; i++) {
				model = new CstmsClrVO();
				if (cstmsLocCd[i] != null)
					model.setCstmsLocCd(cstmsLocCd[i]);
				if (cstmsClrCd[i] != null)
					model.setCstmsClrCd(cstmsClrCd[i]);
				if (evntOfcCd[i] != null)
					model.setEvntOfcCd(evntOfcCd[i]);
				if (cgoEvntNm[i] != null)
					model.setCgoEvntNm(cgoEvntNm[i]);
				if (cstmsChk[i] != null)
					model.setCstmsChk(cstmsChk[i]);
				if (blNo[i] != null)
					model.setBlNo(blNo[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (cstmsChkCnt[i] != null)
					model.setCstmsChkCnt(cstmsChkCnt[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (evntUsrId[i] != null)
					model.setEvntUsrId(evntUsrId[i]);
				if (cntCd[i] != null)
					model.setCntCd(cntCd[i]);
				if (cgorTeamCd[i] != null)
					model.setCgorTeamCd(cgorTeamCd[i]);
				if (hisSeq[i] != null)
					model.setHisSeq(hisSeq[i]);
				if (cstmsDsPoCd[i] != null)
					model.setCstmsDsPoCd(cstmsDsPoCd[i]);
				if (usChk[i] != null)
					model.setUsChk(usChk[i]);
				if (evntDt[i] != null)
					model.setEvntDt(evntDt[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getCstmsClrVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return CstmsClrVO[]
	 */
	public CstmsClrVO[] getCstmsClrVOs(){
		CstmsClrVO[] vos = (CstmsClrVO[])models.toArray(new CstmsClrVO[models.size()]);
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
		this.cstmsLocCd = this.cstmsLocCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cstmsClrCd = this.cstmsClrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.evntOfcCd = this.evntOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cgoEvntNm = this.cgoEvntNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cstmsChk = this.cstmsChk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo = this.blNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cstmsChkCnt = this.cstmsChkCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.evntUsrId = this.evntUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntCd = this.cntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cgorTeamCd = this.cgorTeamCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hisSeq = this.hisSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cstmsDsPoCd = this.cstmsDsPoCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usChk = this.usChk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.evntDt = this.evntDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
