/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : CstmsErrCdVO.java
*@FileTitle : CstmsErrCdVO
*Open Issues :
*Change history :
*@LastModifyDate : 2016.01.20
*@LastModifier : 이종길
*@LastVersion : 1.0
* 2016.01.20 이종길 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.customsdeclaration.customscommonmgt.vo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 이종길
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class CstmsErrCdVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<CstmsErrCdVO> models = new ArrayList<CstmsErrCdVO>();
	
	/* Page Number */
	private String pagerows = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String frmCstmsErrCd = null;
	/* Column Info */
	private String frmCntCd = null;
	/* Column Info */
	private String cntCd = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String userId = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String cstmsErrCd = null;
	/* Column Info */
	private String frmErrCdDesc = null;
	/* Column Info */
	private String chkCstmsErrCd = null;
	/* Column Info */
	private String chkCntCd = null;
	/* Column Info */
	private String dupChkRst = null;
	/* Column Info */
	private String errCdDesc = null;
	/* Column Info */
	private String errTpCtnt = null;
	/* Column Info */
	private String updDt = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public CstmsErrCdVO() {}

	public CstmsErrCdVO(String ibflag, String pagerows, String cntCd, String cstmsErrCd, String errCdDesc, String errTpCtnt, String creUsrId, String creDt, String updUsrId, String updDt, String userId, String frmCntCd, String frmCstmsErrCd, String frmErrCdDesc, String chkCntCd, String chkCstmsErrCd, String dupChkRst) {
		this.pagerows = pagerows;
		this.ibflag = ibflag;
		this.frmCstmsErrCd = frmCstmsErrCd;
		this.frmCntCd = frmCntCd;
		this.cntCd = cntCd;
		this.updUsrId = updUsrId;
		this.userId = userId;
		this.creUsrId = creUsrId;
		this.creDt = creDt;
		this.cstmsErrCd = cstmsErrCd;
		this.frmErrCdDesc = frmErrCdDesc;
		this.chkCstmsErrCd = chkCstmsErrCd;
		this.chkCntCd = chkCntCd;
		this.dupChkRst = dupChkRst;
		this.errCdDesc = errCdDesc;
		this.errTpCtnt = errTpCtnt;
		this.updDt = updDt;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("frm_cstms_err_cd", getFrmCstmsErrCd());
		this.hashColumns.put("frm_cnt_cd", getFrmCntCd());
		this.hashColumns.put("cnt_cd", getCntCd());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("user_id", getUserId());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("cstms_err_cd", getCstmsErrCd());
		this.hashColumns.put("frm_err_cd_desc", getFrmErrCdDesc());
		this.hashColumns.put("chk_cstms_err_cd", getChkCstmsErrCd());
		this.hashColumns.put("chk_cnt_cd", getChkCntCd());
		this.hashColumns.put("dup_chk_rst", getDupChkRst());
		this.hashColumns.put("err_cd_desc", getErrCdDesc());
		this.hashColumns.put("err_tp_ctnt", getErrTpCtnt());
		this.hashColumns.put("upd_dt", getUpdDt());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("frm_cstms_err_cd", "frmCstmsErrCd");
		this.hashFields.put("frm_cnt_cd", "frmCntCd");
		this.hashFields.put("cnt_cd", "cntCd");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("user_id", "userId");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("cstms_err_cd", "cstmsErrCd");
		this.hashFields.put("frm_err_cd_desc", "frmErrCdDesc");
		this.hashFields.put("chk_cstms_err_cd", "chkCstmsErrCd");
		this.hashFields.put("chk_cnt_cd", "chkCntCd");
		this.hashFields.put("dup_chk_rst", "dupChkRst");
		this.hashFields.put("err_cd_desc", "errCdDesc");
		this.hashFields.put("err_tp_ctnt", "errTpCtnt");
		this.hashFields.put("upd_dt", "updDt");
		return this.hashFields;
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
	 * @return frmCstmsErrCd
	 */
	public String getFrmCstmsErrCd() {
		return this.frmCstmsErrCd;
	}
	
	/**
	 * Column Info
	 * @return frmCntCd
	 */
	public String getFrmCntCd() {
		return this.frmCntCd;
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
	 * @return updUsrId
	 */
	public String getUpdUsrId() {
		return this.updUsrId;
	}
	
	/**
	 * Column Info
	 * @return userId
	 */
	public String getUserId() {
		return this.userId;
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
	 * @return creDt
	 */
	public String getCreDt() {
		return this.creDt;
	}
	
	/**
	 * Column Info
	 * @return cstmsErrCd
	 */
	public String getCstmsErrCd() {
		return this.cstmsErrCd;
	}
	
	/**
	 * Column Info
	 * @return frmErrCdDesc
	 */
	public String getFrmErrCdDesc() {
		return this.frmErrCdDesc;
	}
	
	/**
	 * Column Info
	 * @return chkCstmsErrCd
	 */
	public String getChkCstmsErrCd() {
		return this.chkCstmsErrCd;
	}
	
	/**
	 * Column Info
	 * @return chkCntCd
	 */
	public String getChkCntCd() {
		return this.chkCntCd;
	}
	
	/**
	 * Column Info
	 * @return dupChkRst
	 */
	public String getDupChkRst() {
		return this.dupChkRst;
	}
	
	/**
	 * Column Info
	 * @return errCdDesc
	 */
	public String getErrCdDesc() {
		return this.errCdDesc;
	}
	
	/**
	 * Column Info
	 * @return errTpCtnt
	 */
	public String getErrTpCtnt() {
		return this.errTpCtnt;
	}
	
	/**
	 * Column Info
	 * @return updDt
	 */
	public String getUpdDt() {
		return this.updDt;
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
	 * @param frmCstmsErrCd
	 */
	public void setFrmCstmsErrCd(String frmCstmsErrCd) {
		this.frmCstmsErrCd = frmCstmsErrCd;
	}
	
	/**
	 * Column Info
	 * @param frmCntCd
	 */
	public void setFrmCntCd(String frmCntCd) {
		this.frmCntCd = frmCntCd;
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
	 * @param updUsrId
	 */
	public void setUpdUsrId(String updUsrId) {
		this.updUsrId = updUsrId;
	}
	
	/**
	 * Column Info
	 * @param userId
	 */
	public void setUserId(String userId) {
		this.userId = userId;
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
	 * @param creDt
	 */
	public void setCreDt(String creDt) {
		this.creDt = creDt;
	}
	
	/**
	 * Column Info
	 * @param cstmsErrCd
	 */
	public void setCstmsErrCd(String cstmsErrCd) {
		this.cstmsErrCd = cstmsErrCd;
	}
	
	/**
	 * Column Info
	 * @param frmErrCdDesc
	 */
	public void setFrmErrCdDesc(String frmErrCdDesc) {
		this.frmErrCdDesc = frmErrCdDesc;
	}
	
	/**
	 * Column Info
	 * @param chkCstmsErrCd
	 */
	public void setChkCstmsErrCd(String chkCstmsErrCd) {
		this.chkCstmsErrCd = chkCstmsErrCd;
	}
	
	/**
	 * Column Info
	 * @param chkCntCd
	 */
	public void setChkCntCd(String chkCntCd) {
		this.chkCntCd = chkCntCd;
	}
	
	/**
	 * Column Info
	 * @param dupChkRst
	 */
	public void setDupChkRst(String dupChkRst) {
		this.dupChkRst = dupChkRst;
	}
	
	/**
	 * Column Info
	 * @param errCdDesc
	 */
	public void setErrCdDesc(String errCdDesc) {
		this.errCdDesc = errCdDesc;
	}
	
	/**
	 * Column Info
	 * @param errTpCtnt
	 */
	public void setErrTpCtnt(String errTpCtnt) {
		this.errTpCtnt = errTpCtnt;
	}
	
	/**
	 * Column Info
	 * @param updDt
	 */
	public void setUpdDt(String updDt) {
		this.updDt = updDt;
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
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setFrmCstmsErrCd(JSPUtil.getParameter(request, prefix + "frm_cstms_err_cd", ""));
		setFrmCntCd(JSPUtil.getParameter(request, prefix + "frm_cnt_cd", ""));
		setCntCd(JSPUtil.getParameter(request, prefix + "cnt_cd", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setUserId(JSPUtil.getParameter(request, prefix + "user_id", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
		setCstmsErrCd(JSPUtil.getParameter(request, prefix + "cstms_err_cd", ""));
		setFrmErrCdDesc(JSPUtil.getParameter(request, prefix + "frm_err_cd_desc", ""));
		setChkCstmsErrCd(JSPUtil.getParameter(request, prefix + "chk_cstms_err_cd", ""));
		setChkCntCd(JSPUtil.getParameter(request, prefix + "chk_cnt_cd", ""));
		setDupChkRst(JSPUtil.getParameter(request, prefix + "dup_chk_rst", ""));
		setErrCdDesc(JSPUtil.getParameter(request, prefix + "err_cd_desc", ""));
		setErrTpCtnt(JSPUtil.getParameter(request, prefix + "err_tp_ctnt", ""));
		setUpdDt(JSPUtil.getParameter(request, prefix + "upd_dt", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return CstmsErrCdVO[]
	 */
	public CstmsErrCdVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return CstmsErrCdVO[]
	 */
	public CstmsErrCdVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		CstmsErrCdVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] frmCstmsErrCd = (JSPUtil.getParameter(request, prefix	+ "frm_cstms_err_cd", length));
			String[] frmCntCd = (JSPUtil.getParameter(request, prefix	+ "frm_cnt_cd", length));
			String[] cntCd = (JSPUtil.getParameter(request, prefix	+ "cnt_cd", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] userId = (JSPUtil.getParameter(request, prefix	+ "user_id", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] cstmsErrCd = (JSPUtil.getParameter(request, prefix	+ "cstms_err_cd", length));
			String[] frmErrCdDesc = (JSPUtil.getParameter(request, prefix	+ "frm_err_cd_desc", length));
			String[] chkCstmsErrCd = (JSPUtil.getParameter(request, prefix	+ "chk_cstms_err_cd", length));
			String[] chkCntCd = (JSPUtil.getParameter(request, prefix	+ "chk_cnt_cd", length));
			String[] dupChkRst = (JSPUtil.getParameter(request, prefix	+ "dup_chk_rst", length));
			String[] errCdDesc = (JSPUtil.getParameter(request, prefix	+ "err_cd_desc", length));
			String[] errTpCtnt = (JSPUtil.getParameter(request, prefix	+ "err_tp_ctnt", length));
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			
			for (int i = 0; i < length; i++) {
				model = new CstmsErrCdVO();
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (frmCstmsErrCd[i] != null)
					model.setFrmCstmsErrCd(frmCstmsErrCd[i]);
				if (frmCntCd[i] != null)
					model.setFrmCntCd(frmCntCd[i]);
				if (cntCd[i] != null)
					model.setCntCd(cntCd[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (userId[i] != null)
					model.setUserId(userId[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (cstmsErrCd[i] != null)
					model.setCstmsErrCd(cstmsErrCd[i]);
				if (frmErrCdDesc[i] != null)
					model.setFrmErrCdDesc(frmErrCdDesc[i]);
				if (chkCstmsErrCd[i] != null)
					model.setChkCstmsErrCd(chkCstmsErrCd[i]);
				if (chkCntCd[i] != null)
					model.setChkCntCd(chkCntCd[i]);
				if (dupChkRst[i] != null)
					model.setDupChkRst(dupChkRst[i]);
				if (errCdDesc[i] != null)
					model.setErrCdDesc(errCdDesc[i]);
				if (errTpCtnt[i] != null)
					model.setErrTpCtnt(errTpCtnt[i]);
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getCstmsErrCdVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return CstmsErrCdVO[]
	 */
	public CstmsErrCdVO[] getCstmsErrCdVOs(){
		CstmsErrCdVO[] vos = (CstmsErrCdVO[])models.toArray(new CstmsErrCdVO[models.size()]);
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
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.frmCstmsErrCd = this.frmCstmsErrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.frmCntCd = this.frmCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntCd = this.cntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.userId = this.userId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cstmsErrCd = this.cstmsErrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.frmErrCdDesc = this.frmErrCdDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chkCstmsErrCd = this.chkCstmsErrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chkCntCd = this.chkCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dupChkRst = this.dupChkRst .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.errCdDesc = this.errCdDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.errTpCtnt = this.errTpCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
