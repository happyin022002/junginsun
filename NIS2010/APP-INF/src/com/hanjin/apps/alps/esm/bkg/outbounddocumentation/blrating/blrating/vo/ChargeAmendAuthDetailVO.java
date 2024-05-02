/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : ChargeAmendAuthDetailVO.java
*@FileTitle : ChargeAmendAuthDetailVO
*Open Issues :
*Change history :
*@LastModifyDate : 2015.01.19
*@LastModifier : 김진주
*@LastVersion : 1.0
* 2015.01.19 김진주 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.outbounddocumentation.blrating.blrating.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.hanjin.framework.component.common.AbstractValueObject;
import com.hanjin.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 김진주
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class ChargeAmendAuthDetailVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<ChargeAmendAuthDetailVO> models = new ArrayList<ChargeAmendAuthDetailVO>();
	
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String chgRtSeq = null;
	/* Column Info */
	private String crntChgAmt = null;
	/* Column Info */
	private String amdChgAmt = null;
	/* Column Info */
	private String diffChgAmt = null;
	/* Column Info */
	private String currCd = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String ratUtCd = null;
	/* Column Info */
	private String chgCd = null;
	/* Page Number */
	private String pagerows = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String chgAmdSeq = null;
	/* Column Info */
	private String updUsrId = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public ChargeAmendAuthDetailVO() {}

	public ChargeAmendAuthDetailVO(String ibflag, String pagerows, String bkgNo, String chgAmdSeq, String chgRtSeq, String chgCd, String currCd, String ratUtCd, String crntChgAmt, String amdChgAmt, String diffChgAmt, String creUsrId, String creDt, String updUsrId, String updDt) {
		this.updDt = updDt;
		this.chgRtSeq = chgRtSeq;
		this.crntChgAmt = crntChgAmt;
		this.amdChgAmt = amdChgAmt;
		this.diffChgAmt = diffChgAmt;
		this.currCd = currCd;
		this.creDt = creDt;
		this.ratUtCd = ratUtCd;
		this.chgCd = chgCd;
		this.pagerows = pagerows;
		this.ibflag = ibflag;
		this.bkgNo = bkgNo;
		this.creUsrId = creUsrId;
		this.chgAmdSeq = chgAmdSeq;
		this.updUsrId = updUsrId;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("chg_rt_seq", getChgRtSeq());
		this.hashColumns.put("crnt_chg_amt", getCrntChgAmt());
		this.hashColumns.put("amd_chg_amt", getAmdChgAmt());
		this.hashColumns.put("diff_chg_amt", getDiffChgAmt());
		this.hashColumns.put("curr_cd", getCurrCd());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("rat_ut_cd", getRatUtCd());
		this.hashColumns.put("chg_cd", getChgCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("chg_amd_seq", getChgAmdSeq());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("chg_rt_seq", "chgRtSeq");
		this.hashFields.put("crnt_chg_amt", "crntChgAmt");
		this.hashFields.put("amd_chg_amt", "amdChgAmt");
		this.hashFields.put("diff_chg_amt", "diffChgAmt");
		this.hashFields.put("curr_cd", "currCd");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("rat_ut_cd", "ratUtCd");
		this.hashFields.put("chg_cd", "chgCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("chg_amd_seq", "chgAmdSeq");
		this.hashFields.put("upd_usr_id", "updUsrId");
		return this.hashFields;
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
	 * @return chgRtSeq
	 */
	public String getChgRtSeq() {
		return this.chgRtSeq;
	}
	
	/**
	 * Column Info
	 * @return crntChgAmt
	 */
	public String getCrntChgAmt() {
		return this.crntChgAmt;
	}
	
	/**
	 * Column Info
	 * @return amdChgAmt
	 */
	public String getAmdChgAmt() {
		return this.amdChgAmt;
	}
	
	/**
	 * Column Info
	 * @return diffChgAmt
	 */
	public String getDiffChgAmt() {
		return this.diffChgAmt;
	}
	
	/**
	 * Column Info
	 * @return currCd
	 */
	public String getCurrCd() {
		return this.currCd;
	}
	
	/**
	 * Column Info
	 * @return creDt
	 */
	public String getCreDt() {
		return this.creDt;
	}
	
	/**
	 * Column Info
	 * @return ratUtCd
	 */
	public String getRatUtCd() {
		return this.ratUtCd;
	}
	
	/**
	 * Column Info
	 * @return chgCd
	 */
	public String getChgCd() {
		return this.chgCd;
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
	 * @return bkgNo
	 */
	public String getBkgNo() {
		return this.bkgNo;
	}
	
	/**
	 * Column Info
	 * @return creUsrId
	 */
	public String getCreUsrId() {
		return this.creUsrId;
	}
	
	/**
	 * Column Info
	 * @return chgAmdSeq
	 */
	public String getChgAmdSeq() {
		return this.chgAmdSeq;
	}
	
	/**
	 * Column Info
	 * @return updUsrId
	 */
	public String getUpdUsrId() {
		return this.updUsrId;
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
	 * @param chgRtSeq
	 */
	public void setChgRtSeq(String chgRtSeq) {
		this.chgRtSeq = chgRtSeq;
	}
	
	/**
	 * Column Info
	 * @param crntChgAmt
	 */
	public void setCrntChgAmt(String crntChgAmt) {
		this.crntChgAmt = crntChgAmt;
	}
	
	/**
	 * Column Info
	 * @param amdChgAmt
	 */
	public void setAmdChgAmt(String amdChgAmt) {
		this.amdChgAmt = amdChgAmt;
	}
	
	/**
	 * Column Info
	 * @param diffChgAmt
	 */
	public void setDiffChgAmt(String diffChgAmt) {
		this.diffChgAmt = diffChgAmt;
	}
	
	/**
	 * Column Info
	 * @param currCd
	 */
	public void setCurrCd(String currCd) {
		this.currCd = currCd;
	}
	
	/**
	 * Column Info
	 * @param creDt
	 */
	public void setCreDt(String creDt) {
		this.creDt = creDt;
	}
	
	/**
	 * Column Info
	 * @param ratUtCd
	 */
	public void setRatUtCd(String ratUtCd) {
		this.ratUtCd = ratUtCd;
	}
	
	/**
	 * Column Info
	 * @param chgCd
	 */
	public void setChgCd(String chgCd) {
		this.chgCd = chgCd;
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
	 * @param bkgNo
	 */
	public void setBkgNo(String bkgNo) {
		this.bkgNo = bkgNo;
	}
	
	/**
	 * Column Info
	 * @param creUsrId
	 */
	public void setCreUsrId(String creUsrId) {
		this.creUsrId = creUsrId;
	}
	
	/**
	 * Column Info
	 * @param chgAmdSeq
	 */
	public void setChgAmdSeq(String chgAmdSeq) {
		this.chgAmdSeq = chgAmdSeq;
	}
	
	/**
	 * Column Info
	 * @param updUsrId
	 */
	public void setUpdUsrId(String updUsrId) {
		this.updUsrId = updUsrId;
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
		setUpdDt(JSPUtil.getParameter(request, prefix + "upd_dt", ""));
		setChgRtSeq(JSPUtil.getParameter(request, prefix + "chg_rt_seq", ""));
		setCrntChgAmt(JSPUtil.getParameter(request, prefix + "crnt_chg_amt", ""));
		setAmdChgAmt(JSPUtil.getParameter(request, prefix + "amd_chg_amt", ""));
		setDiffChgAmt(JSPUtil.getParameter(request, prefix + "diff_chg_amt", ""));
		setCurrCd(JSPUtil.getParameter(request, prefix + "curr_cd", ""));
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
		setRatUtCd(JSPUtil.getParameter(request, prefix + "rat_ut_cd", ""));
		setChgCd(JSPUtil.getParameter(request, prefix + "chg_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setBkgNo(JSPUtil.getParameter(request, prefix + "bkg_no", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setChgAmdSeq(JSPUtil.getParameter(request, prefix + "chg_amd_seq", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return ChgAmdAuthDtlVO[]
	 */
	public ChargeAmendAuthDetailVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return ChgAmdAuthDtlVO[]
	 */
	public ChargeAmendAuthDetailVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		ChargeAmendAuthDetailVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] chgRtSeq = (JSPUtil.getParameter(request, prefix	+ "chg_rt_seq", length));
			String[] crntChgAmt = (JSPUtil.getParameter(request, prefix	+ "crnt_chg_amt", length));
			String[] amdChgAmt = (JSPUtil.getParameter(request, prefix	+ "amd_chg_amt", length));
			String[] diffChgAmt = (JSPUtil.getParameter(request, prefix	+ "diff_chg_amt", length));
			String[] currCd = (JSPUtil.getParameter(request, prefix	+ "curr_cd", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] ratUtCd = (JSPUtil.getParameter(request, prefix	+ "rat_ut_cd", length));
			String[] chgCd = (JSPUtil.getParameter(request, prefix	+ "chg_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] chgAmdSeq = (JSPUtil.getParameter(request, prefix	+ "chg_amd_seq", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			
			for (int i = 0; i < length; i++) {
				model = new ChargeAmendAuthDetailVO();
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (chgRtSeq[i] != null)
					model.setChgRtSeq(chgRtSeq[i]);
				if (crntChgAmt[i] != null)
					model.setCrntChgAmt(crntChgAmt[i]);
				if (amdChgAmt[i] != null)
					model.setAmdChgAmt(amdChgAmt[i]);
				if (diffChgAmt[i] != null)
					model.setDiffChgAmt(diffChgAmt[i]);
				if (currCd[i] != null)
					model.setCurrCd(currCd[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (ratUtCd[i] != null)
					model.setRatUtCd(ratUtCd[i]);
				if (chgCd[i] != null)
					model.setChgCd(chgCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (chgAmdSeq[i] != null)
					model.setChgAmdSeq(chgAmdSeq[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getChargeAmendAuthDetailVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return ChgAmdAuthDtlVO[]
	 */
	public ChargeAmendAuthDetailVO[] getChargeAmendAuthDetailVOs(){
		ChargeAmendAuthDetailVO[] vos = (ChargeAmendAuthDetailVO[])models.toArray(new ChargeAmendAuthDetailVO[models.size()]);
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
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chgRtSeq = this.chgRtSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.crntChgAmt = this.crntChgAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.amdChgAmt = this.amdChgAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.diffChgAmt = this.diffChgAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.currCd = this.currCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ratUtCd = this.ratUtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chgCd = this.chgCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chgAmdSeq = this.chgAmdSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
