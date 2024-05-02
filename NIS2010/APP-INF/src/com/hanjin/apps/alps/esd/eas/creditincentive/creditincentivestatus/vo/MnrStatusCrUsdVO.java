/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : MnrStatusCrUsdVO.java
*@FileTitle : MnrStatusCrUsdVO
*Open Issues :
*Change history :
*@LastModifyDate : 2016.06.16
*@LastModifier : 신동일
*@LastVersion : 1.0
* 2016.06.16 신동일 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esd.eas.creditincentive.creditincentivestatus.vo;

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
 * @author 신동일
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class MnrStatusCrUsdVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<MnrStatusCrUsdVO> models = new ArrayList<MnrStatusCrUsdVO>();
	
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String crUsdSeq = null;
	/* Column Info */
	private String crUsdOfcCd = null;
	/* Column Info */
	private String deltFlg = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String crIssNo = null;
	/* Column Info */
	private String atchFlg = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String atchFileLnkId = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String crUsdAmt = null;
	/* Column Info */
	private String crSumUsdAmt = null;
	/* Column Info */
	private String crUsdRsn = null;
	/* Column Info */
	private String crUsdDt = null;
	/* Column Info */
	private String updUsrId = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public MnrStatusCrUsdVO() {}

	public MnrStatusCrUsdVO(String ibflag, String pagerows, String crIssNo, String crUsdSeq, String crUsdOfcCd, String crUsdDt, String crUsdAmt, String crSumUsdAmt, String atchFlg, String atchFileLnkId, String crUsdRsn, String deltFlg, String creUsrId, String creDt, String updUsrId, String updDt) {
		this.updDt = updDt;
		this.crUsdSeq = crUsdSeq;
		this.crUsdOfcCd = crUsdOfcCd;
		this.deltFlg = deltFlg;
		this.creDt = creDt;
		this.crIssNo = crIssNo;
		this.atchFlg = atchFlg;
		this.pagerows = pagerows;
		this.atchFileLnkId = atchFileLnkId;
		this.ibflag = ibflag;
		this.creUsrId = creUsrId;
		this.crUsdAmt = crUsdAmt;
		this.crSumUsdAmt = crSumUsdAmt;
		this.crUsdRsn = crUsdRsn;
		this.crUsdDt = crUsdDt;
		this.updUsrId = updUsrId;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("cr_usd_seq", getCrUsdSeq());
		this.hashColumns.put("cr_usd_ofc_cd", getCrUsdOfcCd());
		this.hashColumns.put("delt_flg", getDeltFlg());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("cr_iss_no", getCrIssNo());
		this.hashColumns.put("atch_flg", getAtchFlg());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("atch_file_lnk_id", getAtchFileLnkId());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("cr_usd_amt", getCrUsdAmt());
		this.hashColumns.put("cr_sum_usd_amt", getCrSumUsdAmt());
		this.hashColumns.put("cr_usd_rsn", getCrUsdRsn());
		this.hashColumns.put("cr_usd_dt", getCrUsdDt());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("cr_usd_seq", "crUsdSeq");
		this.hashFields.put("cr_usd_ofc_cd", "crUsdOfcCd");
		this.hashFields.put("delt_flg", "deltFlg");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("cr_iss_no", "crIssNo");
		this.hashFields.put("atch_flg", "atchFlg");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("atch_file_lnk_id", "atchFileLnkId");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("cr_usd_amt", "crUsdAmt");
		this.hashFields.put("cr_sum_usd_amt", "crSumUsdAmt");
		this.hashFields.put("cr_usd_rsn", "crUsdRsn");
		this.hashFields.put("cr_usd_dt", "crUsdDt");
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
	 * @return crUsdSeq
	 */
	public String getCrUsdSeq() {
		return this.crUsdSeq;
	}
	
	/**
	 * Column Info
	 * @return crUsdOfcCd
	 */
	public String getCrUsdOfcCd() {
		return this.crUsdOfcCd;
	}
	
	/**
	 * Column Info
	 * @return deltFlg
	 */
	public String getDeltFlg() {
		return this.deltFlg;
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
	 * @return crIssNo
	 */
	public String getCrIssNo() {
		return this.crIssNo;
	}
	
	/**
	 * Column Info
	 * @return atchFlg
	 */
	public String getAtchFlg() {
		return this.atchFlg;
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
	 * @return atchFileLnkId
	 */
	public String getAtchFileLnkId() {
		return this.atchFileLnkId;
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
	 * @return creUsrId
	 */
	public String getCreUsrId() {
		return this.creUsrId;
	}
	
	/**
	 * Column Info
	 * @return crUsdAmt
	 */
	public String getCrUsdAmt() {
		return this.crUsdAmt;
	}
	
	/**
	 * Column Info
	 * @return crSumUsdAmt
	 */
	public String getCrSumUsdAmt() {
		return this.crSumUsdAmt;
	}
	
	/**
	 * Column Info
	 * @return crUsdRsn
	 */
	public String getCrUsdRsn() {
		return this.crUsdRsn;
	}
	
	/**
	 * Column Info
	 * @return crUsdDt
	 */
	public String getCrUsdDt() {
		return this.crUsdDt;
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
	 * @param crUsdSeq
	 */
	public void setCrUsdSeq(String crUsdSeq) {
		this.crUsdSeq = crUsdSeq;
	}
	
	/**
	 * Column Info
	 * @param crUsdOfcCd
	 */
	public void setCrUsdOfcCd(String crUsdOfcCd) {
		this.crUsdOfcCd = crUsdOfcCd;
	}
	
	/**
	 * Column Info
	 * @param deltFlg
	 */
	public void setDeltFlg(String deltFlg) {
		this.deltFlg = deltFlg;
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
	 * @param crIssNo
	 */
	public void setCrIssNo(String crIssNo) {
		this.crIssNo = crIssNo;
	}
	
	/**
	 * Column Info
	 * @param atchFlg
	 */
	public void setAtchFlg(String atchFlg) {
		this.atchFlg = atchFlg;
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
	 * @param atchFileLnkId
	 */
	public void setAtchFileLnkId(String atchFileLnkId) {
		this.atchFileLnkId = atchFileLnkId;
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
	 * @param creUsrId
	 */
	public void setCreUsrId(String creUsrId) {
		this.creUsrId = creUsrId;
	}
	
	/**
	 * Column Info
	 * @param crUsdAmt
	 */
	public void setCrUsdAmt(String crUsdAmt) {
		this.crUsdAmt = crUsdAmt;
	}
	
	/**
	 * Column Info
	 * @param crSumUsdAmt
	 */
	public void setCrSumUsdAmt(String crSumUsdAmt) {
		this.crSumUsdAmt = crSumUsdAmt;
	}
	
	/**
	 * Column Info
	 * @param crUsdRsn
	 */
	public void setCrUsdRsn(String crUsdRsn) {
		this.crUsdRsn = crUsdRsn;
	}
	
	/**
	 * Column Info
	 * @param crUsdDt
	 */
	public void setCrUsdDt(String crUsdDt) {
		this.crUsdDt = crUsdDt;
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
		setCrUsdSeq(JSPUtil.getParameter(request, prefix + "cr_usd_seq", ""));
		setCrUsdOfcCd(JSPUtil.getParameter(request, prefix + "cr_usd_ofc_cd", ""));
		setDeltFlg(JSPUtil.getParameter(request, prefix + "delt_flg", ""));
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
		setCrIssNo(JSPUtil.getParameter(request, prefix + "cr_iss_no", ""));
		setAtchFlg(JSPUtil.getParameter(request, prefix + "atch_flg", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setAtchFileLnkId(JSPUtil.getParameter(request, prefix + "atch_file_lnk_id", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setCrUsdAmt(JSPUtil.getParameter(request, prefix + "cr_usd_amt", ""));
		setCrSumUsdAmt(JSPUtil.getParameter(request, prefix + "cr_sum_usd_amt", ""));
		setCrUsdRsn(JSPUtil.getParameter(request, prefix + "cr_usd_rsn", ""));
		setCrUsdDt(JSPUtil.getParameter(request, prefix + "cr_usd_dt", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return MnrStatusCrUsdVO[]
	 */
	public MnrStatusCrUsdVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return MnrStatusCrUsdVO[]
	 */
	public MnrStatusCrUsdVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		MnrStatusCrUsdVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] crUsdSeq = (JSPUtil.getParameter(request, prefix	+ "cr_usd_seq", length));
			String[] crUsdOfcCd = (JSPUtil.getParameter(request, prefix	+ "cr_usd_ofc_cd", length));
			String[] deltFlg = (JSPUtil.getParameter(request, prefix	+ "delt_flg", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] crIssNo = (JSPUtil.getParameter(request, prefix	+ "cr_iss_no", length));
			String[] atchFlg = (JSPUtil.getParameter(request, prefix	+ "atch_flg", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] atchFileLnkId = (JSPUtil.getParameter(request, prefix	+ "atch_file_lnk_id", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] crUsdAmt = (JSPUtil.getParameter(request, prefix	+ "cr_usd_amt", length));
			String[] crSumUsdAmt = (JSPUtil.getParameter(request, prefix	+ "cr_sum_usd_amt", length));
			String[] crUsdRsn = (JSPUtil.getParameter(request, prefix	+ "cr_usd_rsn", length));
			String[] crUsdDt = (JSPUtil.getParameter(request, prefix	+ "cr_usd_dt", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			
			for (int i = 0; i < length; i++) {
				model = new MnrStatusCrUsdVO();
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (crUsdSeq[i] != null)
					model.setCrUsdSeq(crUsdSeq[i]);
				if (crUsdOfcCd[i] != null)
					model.setCrUsdOfcCd(crUsdOfcCd[i]);
				if (deltFlg[i] != null)
					model.setDeltFlg(deltFlg[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (crIssNo[i] != null)
					model.setCrIssNo(crIssNo[i]);
				if (atchFlg[i] != null)
					model.setAtchFlg(atchFlg[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (atchFileLnkId[i] != null)
					model.setAtchFileLnkId(atchFileLnkId[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (crUsdAmt[i] != null)
					model.setCrUsdAmt(crUsdAmt[i]);
				if (crSumUsdAmt[i] != null)
					model.setCrSumUsdAmt(crSumUsdAmt[i]);
				if (crUsdRsn[i] != null)
					model.setCrUsdRsn(crUsdRsn[i]);
				if (crUsdDt[i] != null)
					model.setCrUsdDt(crUsdDt[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getMnrStatusCrUsdVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return MnrStatusCrUsdVO[]
	 */
	public MnrStatusCrUsdVO[] getMnrStatusCrUsdVOs(){
		MnrStatusCrUsdVO[] vos = (MnrStatusCrUsdVO[])models.toArray(new MnrStatusCrUsdVO[models.size()]);
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
		this.crUsdSeq = this.crUsdSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.crUsdOfcCd = this.crUsdOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.deltFlg = this.deltFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.crIssNo = this.crIssNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.atchFlg = this.atchFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.atchFileLnkId = this.atchFileLnkId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.crUsdAmt = this.crUsdAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.crSumUsdAmt = this.crSumUsdAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.crUsdRsn = this.crUsdRsn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.crUsdDt = this.crUsdDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
