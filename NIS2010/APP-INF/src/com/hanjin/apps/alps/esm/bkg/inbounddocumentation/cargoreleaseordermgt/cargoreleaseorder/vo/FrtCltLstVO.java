/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : FrtCltLstVO.java
*@FileTitle : FrtCltLstVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.01.07
*@LastModifier : 박성호
*@LastVersion : 1.0
* 2010.01.07 박성호 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo;

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
 * @author 박성호
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class FrtCltLstVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<FrtCltLstVO> models = new ArrayList<FrtCltLstVO>();
	
	/* Column Info */
	private String evntOfcCd = null;
	/* Column Info */
	private String cgoEvntNm = null;
	/* Column Info */
	private String oblRdemFlg = null;
	/* Column Info */
	private String blNo = null;
	/* Page Number */
	private String pagerows = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String frtChkCnt = null;
	/* Column Info */
	private String frtCltFlg = null;
	/* Column Info */
	private String evntUsrId = null;
	/* Column Info */
	private String frtChk = null;
	/* Column Info */
	private String cntCd = null;
	/* Column Info */
	private String cgorTeamCd = null;
	/* Column Info */
	private String hisSeq = null;
	/* Column Info */
	private String usChk = null;
	/* Column Info */
	private String evntDt = null;
	/* Column Info */
	private String caChk = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public FrtCltLstVO() {}

	public FrtCltLstVO(String ibflag, String pagerows, String blNo, String cgoEvntNm, String cgorTeamCd, String evntDt, String evntOfcCd, String evntUsrId, String frtCltFlg, String oblRdemFlg, String frtChk, String frtChkCnt, String usChk, String cntCd, String hisSeq, String caChk) {
		this.evntOfcCd = evntOfcCd;
		this.cgoEvntNm = cgoEvntNm;
		this.oblRdemFlg = oblRdemFlg;
		this.blNo = blNo;
		this.pagerows = pagerows;
		this.ibflag = ibflag;
		this.frtChkCnt = frtChkCnt;
		this.frtCltFlg = frtCltFlg;
		this.evntUsrId = evntUsrId;
		this.frtChk = frtChk;
		this.cntCd = cntCd;
		this.cgorTeamCd = cgorTeamCd;
		this.hisSeq = hisSeq;
		this.usChk = usChk;
		this.evntDt = evntDt;
		this.caChk = caChk;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("evnt_ofc_cd", getEvntOfcCd());
		this.hashColumns.put("cgo_evnt_nm", getCgoEvntNm());
		this.hashColumns.put("obl_rdem_flg", getOblRdemFlg());
		this.hashColumns.put("bl_no", getBlNo());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("frt_chk_cnt", getFrtChkCnt());
		this.hashColumns.put("frt_clt_flg", getFrtCltFlg());
		this.hashColumns.put("evnt_usr_id", getEvntUsrId());
		this.hashColumns.put("frt_chk", getFrtChk());
		this.hashColumns.put("cnt_cd", getCntCd());
		this.hashColumns.put("cgor_team_cd", getCgorTeamCd());
		this.hashColumns.put("his_seq", getHisSeq());
		this.hashColumns.put("us_chk", getUsChk());
		this.hashColumns.put("evnt_dt", getEvntDt());
		this.hashColumns.put("ca_chk", getCaChk());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("evnt_ofc_cd", "evntOfcCd");
		this.hashFields.put("cgo_evnt_nm", "cgoEvntNm");
		this.hashFields.put("obl_rdem_flg", "oblRdemFlg");
		this.hashFields.put("bl_no", "blNo");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("frt_chk_cnt", "frtChkCnt");
		this.hashFields.put("frt_clt_flg", "frtCltFlg");
		this.hashFields.put("evnt_usr_id", "evntUsrId");
		this.hashFields.put("frt_chk", "frtChk");
		this.hashFields.put("cnt_cd", "cntCd");
		this.hashFields.put("cgor_team_cd", "cgorTeamCd");
		this.hashFields.put("his_seq", "hisSeq");
		this.hashFields.put("us_chk", "usChk");
		this.hashFields.put("evnt_dt", "evntDt");
		this.hashFields.put("ca_chk", "caChk");
		return this.hashFields;
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
	 * @return oblRdemFlg
	 */
	public String getOblRdemFlg() {
		return this.oblRdemFlg;
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
	 * VO Data Value( C:Creation, U:Update, D:Delete )
	 * @return ibflag
	 */
	public String getIbflag() {
		return this.ibflag;
	}
	
	/**
	 * Column Info
	 * @return frtChkCnt
	 */
	public String getFrtChkCnt() {
		return this.frtChkCnt;
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
	 * @return frtChk
	 */
	public String getFrtChk() {
		return this.frtChk;
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
	 * @return caChk
	 */
	public String getCaChk() {
		return this.caChk;
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
	 * @param oblRdemFlg
	 */
	public void setOblRdemFlg(String oblRdemFlg) {
		this.oblRdemFlg = oblRdemFlg;
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
	 * VO Data Value( C:Creation, U:Update, D:Delete )
	 * @param ibflag
	 */
	public void setIbflag(String ibflag) {
		this.ibflag = ibflag;
	}
	
	/**
	 * Column Info
	 * @param frtChkCnt
	 */
	public void setFrtChkCnt(String frtChkCnt) {
		this.frtChkCnt = frtChkCnt;
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
	 * @param frtChk
	 */
	public void setFrtChk(String frtChk) {
		this.frtChk = frtChk;
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
	 * Column Info
	 * @param caChk
	 */
	public void setCaChk(String caChk) {
		this.caChk = caChk;
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
		setEvntOfcCd(JSPUtil.getParameter(request, prefix + "evnt_ofc_cd", ""));
		setCgoEvntNm(JSPUtil.getParameter(request, prefix + "cgo_evnt_nm", ""));
		setOblRdemFlg(JSPUtil.getParameter(request, prefix + "obl_rdem_flg", ""));
		setBlNo(JSPUtil.getParameter(request, prefix + "bl_no", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setFrtChkCnt(JSPUtil.getParameter(request, prefix + "frt_chk_cnt", ""));
		setFrtCltFlg(JSPUtil.getParameter(request, prefix + "frt_clt_flg", ""));
		setEvntUsrId(JSPUtil.getParameter(request, prefix + "evnt_usr_id", ""));
		setFrtChk(JSPUtil.getParameter(request, prefix + "frt_chk", ""));
		setCntCd(JSPUtil.getParameter(request, prefix + "cnt_cd", ""));
		setCgorTeamCd(JSPUtil.getParameter(request, prefix + "cgor_team_cd", ""));
		setHisSeq(JSPUtil.getParameter(request, prefix + "his_seq", ""));
		setUsChk(JSPUtil.getParameter(request, prefix + "us_chk", ""));
		setEvntDt(JSPUtil.getParameter(request, prefix + "evnt_dt", ""));
		setCaChk(JSPUtil.getParameter(request, prefix + "ca_chk", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return FrtCltLstVO[]
	 */
	public FrtCltLstVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return FrtCltLstVO[]
	 */
	public FrtCltLstVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		FrtCltLstVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] evntOfcCd = (JSPUtil.getParameter(request, prefix	+ "evnt_ofc_cd", length));
			String[] cgoEvntNm = (JSPUtil.getParameter(request, prefix	+ "cgo_evnt_nm", length));
			String[] oblRdemFlg = (JSPUtil.getParameter(request, prefix	+ "obl_rdem_flg", length));
			String[] blNo = (JSPUtil.getParameter(request, prefix	+ "bl_no", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] frtChkCnt = (JSPUtil.getParameter(request, prefix	+ "frt_chk_cnt", length));
			String[] frtCltFlg = (JSPUtil.getParameter(request, prefix	+ "frt_clt_flg", length));
			String[] evntUsrId = (JSPUtil.getParameter(request, prefix	+ "evnt_usr_id", length));
			String[] frtChk = (JSPUtil.getParameter(request, prefix	+ "frt_chk", length));
			String[] cntCd = (JSPUtil.getParameter(request, prefix	+ "cnt_cd", length));
			String[] cgorTeamCd = (JSPUtil.getParameter(request, prefix	+ "cgor_team_cd", length));
			String[] hisSeq = (JSPUtil.getParameter(request, prefix	+ "his_seq", length));
			String[] usChk = (JSPUtil.getParameter(request, prefix	+ "us_chk", length));
			String[] evntDt = (JSPUtil.getParameter(request, prefix	+ "evnt_dt", length));
			String[] caChk = (JSPUtil.getParameter(request, prefix	+ "ca_chk", length));
			
			for (int i = 0; i < length; i++) {
				model = new FrtCltLstVO();
				if (evntOfcCd[i] != null)
					model.setEvntOfcCd(evntOfcCd[i]);
				if (cgoEvntNm[i] != null)
					model.setCgoEvntNm(cgoEvntNm[i]);
				if (oblRdemFlg[i] != null)
					model.setOblRdemFlg(oblRdemFlg[i]);
				if (blNo[i] != null)
					model.setBlNo(blNo[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (frtChkCnt[i] != null)
					model.setFrtChkCnt(frtChkCnt[i]);
				if (frtCltFlg[i] != null)
					model.setFrtCltFlg(frtCltFlg[i]);
				if (evntUsrId[i] != null)
					model.setEvntUsrId(evntUsrId[i]);
				if (frtChk[i] != null)
					model.setFrtChk(frtChk[i]);
				if (cntCd[i] != null)
					model.setCntCd(cntCd[i]);
				if (cgorTeamCd[i] != null)
					model.setCgorTeamCd(cgorTeamCd[i]);
				if (hisSeq[i] != null)
					model.setHisSeq(hisSeq[i]);
				if (usChk[i] != null)
					model.setUsChk(usChk[i]);
				if (evntDt[i] != null)
					model.setEvntDt(evntDt[i]);
				if (caChk[i] != null)
					model.setCaChk(caChk[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getFrtCltLstVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return FrtCltLstVO[]
	 */
	public FrtCltLstVO[] getFrtCltLstVOs(){
		FrtCltLstVO[] vos = (FrtCltLstVO[])models.toArray(new FrtCltLstVO[models.size()]);
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
		this.evntOfcCd = this.evntOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cgoEvntNm = this.cgoEvntNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oblRdemFlg = this.oblRdemFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo = this.blNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.frtChkCnt = this.frtChkCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.frtCltFlg = this.frtCltFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.evntUsrId = this.evntUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.frtChk = this.frtChk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntCd = this.cntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cgorTeamCd = this.cgorTeamCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hisSeq = this.hisSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usChk = this.usChk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.evntDt = this.evntDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.caChk = this.caChk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
