/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : OblRdemVO.java
*@FileTitle : OblRdemVO
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

public class OblRdemVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<OblRdemVO> models = new ArrayList<OblRdemVO>();
	
	/* Column Info */
	private String oblChk = null;
	/* Column Info */
	private String evntOfcCd = null;
	/* Column Info */
	private String cgoEvntNm = null;
	/* Column Info */
	private String oblRdemFlg = null;
	/* Column Info */
	private String blNo = null;
	/* Column Info */
	private String oblClrCd = null;
	/* Column Info */
	private String oblChkCnt = null;
	/* Page Number */
	private String pagerows = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String oblLocCd = null;
	/* Column Info */
	private String evntUsrId = null;
	/* Column Info */
	private String cntCd = null;
	/* Column Info */
	private String cgorTeamCd = null;
	/* Column Info */
	private String oblDsPoCd = null;
	/* Column Info */
	private String hisSeq = null;
	/* Column Info */
	private String usChk = null;
	/* Column Info */
	private String evntDt = null;
	/* Column Info */
	private String caChk = null;
	/* Column Info */
	private String fobCaChk = null;
	/* Column Info */
	private String podCaChk = null;
	
	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public OblRdemVO() {}

	public OblRdemVO(String ibflag, String pagerows, String blNo, String cgoEvntNm, String cgorTeamCd, String oblClrCd, String oblDsPoCd, String oblLocCd, String evntDt, String evntOfcCd, String evntUsrId, String oblRdemFlg, String oblChk, String oblChkCnt, String usChk, String cntCd, String hisSeq, String caChk, String fobCaChk, String podCaChk) {
		this.oblChk = oblChk;
		this.evntOfcCd = evntOfcCd;
		this.cgoEvntNm = cgoEvntNm;
		this.oblRdemFlg = oblRdemFlg;
		this.blNo = blNo;
		this.oblClrCd = oblClrCd;
		this.oblChkCnt = oblChkCnt;
		this.pagerows = pagerows;
		this.ibflag = ibflag;
		this.oblLocCd = oblLocCd;
		this.evntUsrId = evntUsrId;
		this.cntCd = cntCd;
		this.cgorTeamCd = cgorTeamCd;
		this.oblDsPoCd = oblDsPoCd;
		this.hisSeq = hisSeq;
		this.usChk = usChk;
		this.evntDt = evntDt;
		this.caChk = caChk;
		this.fobCaChk = fobCaChk;
		this.podCaChk = podCaChk;		
		
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("obl_chk", getOblChk());
		this.hashColumns.put("evnt_ofc_cd", getEvntOfcCd());
		this.hashColumns.put("cgo_evnt_nm", getCgoEvntNm());
		this.hashColumns.put("obl_rdem_flg", getOblRdemFlg());
		this.hashColumns.put("bl_no", getBlNo());
		this.hashColumns.put("obl_clr_cd", getOblClrCd());
		this.hashColumns.put("obl_chk_cnt", getOblChkCnt());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("obl_loc_cd", getOblLocCd());
		this.hashColumns.put("evnt_usr_id", getEvntUsrId());
		this.hashColumns.put("cnt_cd", getCntCd());
		this.hashColumns.put("cgor_team_cd", getCgorTeamCd());
		this.hashColumns.put("obl_ds_po_cd", getOblDsPoCd());
		this.hashColumns.put("his_seq", getHisSeq());
		this.hashColumns.put("us_chk", getUsChk());
		this.hashColumns.put("evnt_dt", getEvntDt());
		this.hashColumns.put("ca_chk", getCaChk());
		this.hashColumns.put("fob_ca_chk", getFobCaChk());
		this.hashColumns.put("pod_ca_chk", getPodCaChk());		
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("obl_chk", "oblChk");
		this.hashFields.put("evnt_ofc_cd", "evntOfcCd");
		this.hashFields.put("cgo_evnt_nm", "cgoEvntNm");
		this.hashFields.put("obl_rdem_flg", "oblRdemFlg");
		this.hashFields.put("bl_no", "blNo");
		this.hashFields.put("obl_clr_cd", "oblClrCd");
		this.hashFields.put("obl_chk_cnt", "oblChkCnt");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("obl_loc_cd", "oblLocCd");
		this.hashFields.put("evnt_usr_id", "evntUsrId");
		this.hashFields.put("cnt_cd", "cntCd");
		this.hashFields.put("cgor_team_cd", "cgorTeamCd");
		this.hashFields.put("obl_ds_po_cd", "oblDsPoCd");
		this.hashFields.put("his_seq", "hisSeq");
		this.hashFields.put("us_chk", "usChk");
		this.hashFields.put("evnt_dt", "evntDt");
		this.hashFields.put("ca_chk", "caChk");
		this.hashFields.put("fob_ca_chk", "fobCaChk");
		this.hashFields.put("pod_ca_chk", "podCaChk");		
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return oblChk
	 */
	public String getOblChk() {
		return this.oblChk;
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
	 * Column Info
	 * @return oblClrCd
	 */
	public String getOblClrCd() {
		return this.oblClrCd;
	}
	
	/**
	 * Column Info
	 * @return oblChkCnt
	 */
	public String getOblChkCnt() {
		return this.oblChkCnt;
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
	 * @return oblLocCd
	 */
	public String getOblLocCd() {
		return this.oblLocCd;
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
	 * @return oblDsPoCd
	 */
	public String getOblDsPoCd() {
		return this.oblDsPoCd;
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
	 * @return fobCaChk
	 */
	public String getFobCaChk() {
		return this.fobCaChk;
	}

	/**
	 * Column Info
	 * @return podCaChk
	 */
	public String getPodCaChk() {
		return this.podCaChk;
	}
	

	/**
	 * Column Info
	 * @param oblChk
	 */
	public void setOblChk(String oblChk) {
		this.oblChk = oblChk;
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
	 * Column Info
	 * @param oblClrCd
	 */
	public void setOblClrCd(String oblClrCd) {
		this.oblClrCd = oblClrCd;
	}
	
	/**
	 * Column Info
	 * @param oblChkCnt
	 */
	public void setOblChkCnt(String oblChkCnt) {
		this.oblChkCnt = oblChkCnt;
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
	 * @param oblLocCd
	 */
	public void setOblLocCd(String oblLocCd) {
		this.oblLocCd = oblLocCd;
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
	 * @param oblDsPoCd
	 */
	public void setOblDsPoCd(String oblDsPoCd) {
		this.oblDsPoCd = oblDsPoCd;
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
	 * Column Info
	 * @param fobCaChk
	 */
	public void setFobCaChk(String fobCaChk) {
		this.fobCaChk = fobCaChk;
	}

	/**
	 * Column Info
	 * @param podCaChk
	 */
	public void setPodCaChk(String podCaChk) {
		this.podCaChk = podCaChk;
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
		setOblChk(JSPUtil.getParameter(request, prefix + "obl_chk", ""));
		setEvntOfcCd(JSPUtil.getParameter(request, prefix + "evnt_ofc_cd", ""));
		setCgoEvntNm(JSPUtil.getParameter(request, prefix + "cgo_evnt_nm", ""));
		setOblRdemFlg(JSPUtil.getParameter(request, prefix + "obl_rdem_flg", ""));
		setBlNo(JSPUtil.getParameter(request, prefix + "bl_no", ""));
		setOblClrCd(JSPUtil.getParameter(request, prefix + "obl_clr_cd", ""));
		setOblChkCnt(JSPUtil.getParameter(request, prefix + "obl_chk_cnt", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setOblLocCd(JSPUtil.getParameter(request, prefix + "obl_loc_cd", ""));
		setEvntUsrId(JSPUtil.getParameter(request, prefix + "evnt_usr_id", ""));
		setCntCd(JSPUtil.getParameter(request, prefix + "cnt_cd", ""));
		setCgorTeamCd(JSPUtil.getParameter(request, prefix + "cgor_team_cd", ""));
		setOblDsPoCd(JSPUtil.getParameter(request, prefix + "obl_ds_po_cd", ""));
		setHisSeq(JSPUtil.getParameter(request, prefix + "his_seq", ""));
		setUsChk(JSPUtil.getParameter(request, prefix + "us_chk", ""));
		setEvntDt(JSPUtil.getParameter(request, prefix + "evnt_dt", ""));
		setCaChk(JSPUtil.getParameter(request, prefix + "ca_chk", ""));
		setFobCaChk(JSPUtil.getParameter(request, prefix + "fob_ca_chk", ""));
		setPodCaChk(JSPUtil.getParameter(request, prefix + "pod_ca_chk", ""));		
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return OblRdemVO[]
	 */
	public OblRdemVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return OblRdemVO[]
	 */
	public OblRdemVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		OblRdemVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] oblChk = (JSPUtil.getParameter(request, prefix	+ "obl_chk", length));
			String[] evntOfcCd = (JSPUtil.getParameter(request, prefix	+ "evnt_ofc_cd", length));
			String[] cgoEvntNm = (JSPUtil.getParameter(request, prefix	+ "cgo_evnt_nm", length));
			String[] oblRdemFlg = (JSPUtil.getParameter(request, prefix	+ "obl_rdem_flg", length));
			String[] blNo = (JSPUtil.getParameter(request, prefix	+ "bl_no", length));
			String[] oblClrCd = (JSPUtil.getParameter(request, prefix	+ "obl_clr_cd", length));
			String[] oblChkCnt = (JSPUtil.getParameter(request, prefix	+ "obl_chk_cnt", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] oblLocCd = (JSPUtil.getParameter(request, prefix	+ "obl_loc_cd", length));
			String[] evntUsrId = (JSPUtil.getParameter(request, prefix	+ "evnt_usr_id", length));
			String[] cntCd = (JSPUtil.getParameter(request, prefix	+ "cnt_cd", length));
			String[] cgorTeamCd = (JSPUtil.getParameter(request, prefix	+ "cgor_team_cd", length));
			String[] oblDsPoCd = (JSPUtil.getParameter(request, prefix	+ "obl_ds_po_cd", length));
			String[] hisSeq = (JSPUtil.getParameter(request, prefix	+ "his_seq", length));
			String[] usChk = (JSPUtil.getParameter(request, prefix	+ "us_chk", length));
			String[] evntDt = (JSPUtil.getParameter(request, prefix	+ "evnt_dt", length));
			String[] caChk = (JSPUtil.getParameter(request, prefix	+ "ca_chk", length));
			String[] fobCaChk = (JSPUtil.getParameter(request, prefix	+ "fob_ca_chk", length));
			String[] podCaChk = (JSPUtil.getParameter(request, prefix	+ "pod_ca_chk", length));
			
			for (int i = 0; i < length; i++) {
				model = new OblRdemVO();
				if (oblChk[i] != null)
					model.setOblChk(oblChk[i]);
				if (evntOfcCd[i] != null)
					model.setEvntOfcCd(evntOfcCd[i]);
				if (cgoEvntNm[i] != null)
					model.setCgoEvntNm(cgoEvntNm[i]);
				if (oblRdemFlg[i] != null)
					model.setOblRdemFlg(oblRdemFlg[i]);
				if (blNo[i] != null)
					model.setBlNo(blNo[i]);
				if (oblClrCd[i] != null)
					model.setOblClrCd(oblClrCd[i]);
				if (oblChkCnt[i] != null)
					model.setOblChkCnt(oblChkCnt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (oblLocCd[i] != null)
					model.setOblLocCd(oblLocCd[i]);
				if (evntUsrId[i] != null)
					model.setEvntUsrId(evntUsrId[i]);
				if (cntCd[i] != null)
					model.setCntCd(cntCd[i]);
				if (cgorTeamCd[i] != null)
					model.setCgorTeamCd(cgorTeamCd[i]);
				if (oblDsPoCd[i] != null)
					model.setOblDsPoCd(oblDsPoCd[i]);
				if (hisSeq[i] != null)
					model.setHisSeq(hisSeq[i]);
				if (usChk[i] != null)
					model.setUsChk(usChk[i]);
				if (evntDt[i] != null)
					model.setEvntDt(evntDt[i]);
				if (caChk[i] != null)
					model.setCaChk(caChk[i]);
				if (fobCaChk[i] != null)
					model.setFobCaChk(fobCaChk[i]);
				if (podCaChk[i] != null)
					model.setPodCaChk(podCaChk[i]);
				
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getOblRdemVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return OblRdemVO[]
	 */
	public OblRdemVO[] getOblRdemVOs(){
		OblRdemVO[] vos = (OblRdemVO[])models.toArray(new OblRdemVO[models.size()]);
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
		this.oblChk = this.oblChk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.evntOfcCd = this.evntOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cgoEvntNm = this.cgoEvntNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oblRdemFlg = this.oblRdemFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo = this.blNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oblClrCd = this.oblClrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oblChkCnt = this.oblChkCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oblLocCd = this.oblLocCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.evntUsrId = this.evntUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntCd = this.cntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cgorTeamCd = this.cgorTeamCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oblDsPoCd = this.oblDsPoCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hisSeq = this.hisSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usChk = this.usChk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.evntDt = this.evntDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.caChk = this.caChk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fobCaChk = this.fobCaChk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCaChk = this.podCaChk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");		
	}
}
