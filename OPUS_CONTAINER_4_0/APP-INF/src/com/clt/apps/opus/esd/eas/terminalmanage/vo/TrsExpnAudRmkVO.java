/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : TrsExpnAudRmkVO.java
*@FileTitle : TrsExpnAudRmkVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.26
*@LastModifier : 양봉준
*@LastVersion : 1.0
* 2009.11.26 양봉준 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esd.eas.terminalmanage.vo;

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
 * @author 양봉준
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class TrsExpnAudRmkVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<TrsExpnAudRmkVO> models = new ArrayList<TrsExpnAudRmkVO>();
	
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String rmkCtntSeq = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String easExpnTpCd = null;
	/* Column Info */
	private String rmkCtnt = null;
	/* Column Info */
	private String blNo = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String opCode = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String creOfcCd = null;
	/* Column Info */
	private String updUsrId = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public TrsExpnAudRmkVO() {}

	public TrsExpnAudRmkVO(String ibflag, String pagerows, String opCode, String bkgNo, String easExpnTpCd, String rmkCtntSeq, String blNo, String rmkCtnt, String creOfcCd, String creUsrId, String creDt, String updUsrId, String updDt) {
		this.updDt = updDt;
		this.rmkCtntSeq = rmkCtntSeq;
		this.creDt = creDt;
		this.easExpnTpCd = easExpnTpCd;
		this.rmkCtnt = rmkCtnt;
		this.blNo = blNo;
		this.pagerows = pagerows;
		this.opCode = opCode;
		this.ibflag = ibflag;
		this.bkgNo = bkgNo;
		this.creUsrId = creUsrId;
		this.creOfcCd = creOfcCd;
		this.updUsrId = updUsrId;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("rmk_ctnt_seq", getRmkCtntSeq());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("eas_expn_tp_cd", getEasExpnTpCd());
		this.hashColumns.put("rmk_ctnt", getRmkCtnt());
		this.hashColumns.put("bl_no", getBlNo());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("op_code", getOpCode());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("cre_ofc_cd", getCreOfcCd());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("rmk_ctnt_seq", "rmkCtntSeq");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("eas_expn_tp_cd", "easExpnTpCd");
		this.hashFields.put("rmk_ctnt", "rmkCtnt");
		this.hashFields.put("bl_no", "blNo");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("op_code", "opCode");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("cre_ofc_cd", "creOfcCd");
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
	 * @return rmkCtntSeq
	 */
	public String getRmkCtntSeq() {
		return this.rmkCtntSeq;
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
	 * @return easExpnTpCd
	 */
	public String getEasExpnTpCd() {
		return this.easExpnTpCd;
	}
	
	/**
	 * Column Info
	 * @return rmkCtnt
	 */
	public String getRmkCtnt() {
		return this.rmkCtnt;
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
	 * @return opCode
	 */
	public String getOpCode() {
		return this.opCode;
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
	 * @return creOfcCd
	 */
	public String getCreOfcCd() {
		return this.creOfcCd;
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
	 * @param rmkCtntSeq
	 */
	public void setRmkCtntSeq(String rmkCtntSeq) {
		this.rmkCtntSeq = rmkCtntSeq;
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
	 * @param easExpnTpCd
	 */
	public void setEasExpnTpCd(String easExpnTpCd) {
		this.easExpnTpCd = easExpnTpCd;
	}
	
	/**
	 * Column Info
	 * @param rmkCtnt
	 */
	public void setRmkCtnt(String rmkCtnt) {
		this.rmkCtnt = rmkCtnt;
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
	 * @param opCode
	 */
	public void setOpCode(String opCode) {
		this.opCode = opCode;
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
	 * @param creOfcCd
	 */
	public void setCreOfcCd(String creOfcCd) {
		this.creOfcCd = creOfcCd;
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
		setUpdDt(JSPUtil.getParameter(request, "upd_dt", ""));
		setRmkCtntSeq(JSPUtil.getParameter(request, "rmk_ctnt_seq", ""));
		setCreDt(JSPUtil.getParameter(request, "cre_dt", ""));
		setEasExpnTpCd(JSPUtil.getParameter(request, "eas_expn_tp_cd", ""));
		setRmkCtnt(JSPUtil.getParameter(request, "rmk_ctnt", ""));
		setBlNo(JSPUtil.getParameter(request, "bl_no", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setOpCode(JSPUtil.getParameter(request, "op_code", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setBkgNo(JSPUtil.getParameter(request, "bkg_no", ""));
		setCreUsrId(JSPUtil.getParameter(request, "cre_usr_id", ""));
		setCreOfcCd(JSPUtil.getParameter(request, "cre_ofc_cd", ""));
		setUpdUsrId(JSPUtil.getParameter(request, "upd_usr_id", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return TrsExpnAudRmkVO[]
	 */
	public TrsExpnAudRmkVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return TrsExpnAudRmkVO[]
	 */
	public TrsExpnAudRmkVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		TrsExpnAudRmkVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] rmkCtntSeq = (JSPUtil.getParameter(request, prefix	+ "rmk_ctnt_seq", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] easExpnTpCd = (JSPUtil.getParameter(request, prefix	+ "eas_expn_tp_cd", length));
			String[] rmkCtnt = (JSPUtil.getParameter(request, prefix	+ "rmk_ctnt", length));
			String[] blNo = (JSPUtil.getParameter(request, prefix	+ "bl_no", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] opCode = (JSPUtil.getParameter(request, prefix	+ "op_code", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] creOfcCd = (JSPUtil.getParameter(request, prefix	+ "cre_ofc_cd", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			
			for (int i = 0; i < length; i++) {
				model = new TrsExpnAudRmkVO();
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (rmkCtntSeq[i] != null)
					model.setRmkCtntSeq(rmkCtntSeq[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (easExpnTpCd[i] != null)
					model.setEasExpnTpCd(easExpnTpCd[i]);
				if (rmkCtnt[i] != null)
					model.setRmkCtnt(rmkCtnt[i]);
				if (blNo[i] != null)
					model.setBlNo(blNo[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (opCode[i] != null)
					model.setOpCode(opCode[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (creOfcCd[i] != null)
					model.setCreOfcCd(creOfcCd[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getTrsExpnAudRmkVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return TrsExpnAudRmkVO[]
	 */
	public TrsExpnAudRmkVO[] getTrsExpnAudRmkVOs(){
		TrsExpnAudRmkVO[] vos = (TrsExpnAudRmkVO[])models.toArray(new TrsExpnAudRmkVO[models.size()]);
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
		this.rmkCtntSeq = this.rmkCtntSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.easExpnTpCd = this.easExpnTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rmkCtnt = this.rmkCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo = this.blNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.opCode = this.opCode .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creOfcCd = this.creOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
