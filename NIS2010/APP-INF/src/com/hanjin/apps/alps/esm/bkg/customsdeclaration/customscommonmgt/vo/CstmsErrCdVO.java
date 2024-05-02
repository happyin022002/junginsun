/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : CstmsErrCdVO.java
*@FileTitle : CstmsErrCdVO
*Open Issues :
*Change history :
*@LastModifyDate : 2012.05.08
*@LastModifier : 
*@LastVersion : 1.0
* 2012.05.08  
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.customsdeclaration.customscommonmgt.vo;

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
 * @author 
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class CstmsErrCdVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<CstmsErrCdVO> models = new ArrayList<CstmsErrCdVO>();
	
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String frmCstmsErrCd = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String chkCntCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String cstmsErrCd = null;
	/* Column Info */
	private String errTpCtnt = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String errCdDesc = null;
	/* Column Info */
	private String frmErrCdDesc = null;
	/* Column Info */
	private String cntCd = null;
	/* Column Info */
	private String userId = null;
	/* Column Info */
	private String chkCstmsErrCd = null;
	/* Column Info */
	private String frmCntCd = null;
	/* Column Info */
	private String updUsrId = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public CstmsErrCdVO() {}

	public CstmsErrCdVO(String ibflag, String pagerows, String cntCd, String cstmsErrCd, String errCdDesc, String errTpCtnt, String creUsrId, String creDt, String updUsrId, String updDt, String userId, String frmCntCd, String frmCstmsErrCd, String frmErrCdDesc, String chkCntCd, String chkCstmsErrCd) {
		this.updDt = updDt;
		this.frmCstmsErrCd = frmCstmsErrCd;
		this.creDt = creDt;
		this.chkCntCd = chkCntCd;
		this.pagerows = pagerows;
		this.cstmsErrCd = cstmsErrCd;
		this.errTpCtnt = errTpCtnt;
		this.ibflag = ibflag;
		this.creUsrId = creUsrId;
		this.errCdDesc = errCdDesc;
		this.frmErrCdDesc = frmErrCdDesc;
		this.cntCd = cntCd;
		this.userId = userId;
		this.chkCstmsErrCd = chkCstmsErrCd;
		this.frmCntCd = frmCntCd;
		this.updUsrId = updUsrId;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("frm_cstms_err_cd", getFrmCstmsErrCd());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("chk_cnt_cd", getChkCntCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("cstms_err_cd", getCstmsErrCd());
		this.hashColumns.put("err_tp_ctnt", getErrTpCtnt());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("err_cd_desc", getErrCdDesc());
		this.hashColumns.put("frm_err_cd_desc", getFrmErrCdDesc());
		this.hashColumns.put("cnt_cd", getCntCd());
		this.hashColumns.put("user_id", getUserId());
		this.hashColumns.put("chk_cstms_err_cd", getChkCstmsErrCd());
		this.hashColumns.put("frm_cnt_cd", getFrmCntCd());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("frm_cstms_err_cd", "frmCstmsErrCd");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("chk_cnt_cd", "chkCntCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("cstms_err_cd", "cstmsErrCd");
		this.hashFields.put("err_tp_ctnt", "errTpCtnt");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("err_cd_desc", "errCdDesc");
		this.hashFields.put("frm_err_cd_desc", "frmErrCdDesc");
		this.hashFields.put("cnt_cd", "cntCd");
		this.hashFields.put("user_id", "userId");
		this.hashFields.put("chk_cstms_err_cd", "chkCstmsErrCd");
		this.hashFields.put("frm_cnt_cd", "frmCntCd");
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
	 * @return frmCstmsErrCd
	 */
	public String getFrmCstmsErrCd() {
		return this.frmCstmsErrCd;
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
	 * @return chkCntCd
	 */
	public String getChkCntCd() {
		return this.chkCntCd;
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
	 * @return cstmsErrCd
	 */
	public String getCstmsErrCd() {
		return this.cstmsErrCd;
	}
	
	/**
	 * Column Info
	 * @return errTpCtnt
	 */
	public String getErrTpCtnt() {
		return this.errTpCtnt;
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
	 * @return errCdDesc
	 */
	public String getErrCdDesc() {
		return this.errCdDesc;
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
	 * @return cntCd
	 */
	public String getCntCd() {
		return this.cntCd;
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
	 * @return chkCstmsErrCd
	 */
	public String getChkCstmsErrCd() {
		return this.chkCstmsErrCd;
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
	 * @param frmCstmsErrCd
	 */
	public void setFrmCstmsErrCd(String frmCstmsErrCd) {
		this.frmCstmsErrCd = frmCstmsErrCd;
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
	 * @param chkCntCd
	 */
	public void setChkCntCd(String chkCntCd) {
		this.chkCntCd = chkCntCd;
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
	 * @param cstmsErrCd
	 */
	public void setCstmsErrCd(String cstmsErrCd) {
		this.cstmsErrCd = cstmsErrCd;
	}
	
	/**
	 * Column Info
	 * @param errTpCtnt
	 */
	public void setErrTpCtnt(String errTpCtnt) {
		this.errTpCtnt = errTpCtnt;
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
	 * @param errCdDesc
	 */
	public void setErrCdDesc(String errCdDesc) {
		this.errCdDesc = errCdDesc;
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
	 * @param cntCd
	 */
	public void setCntCd(String cntCd) {
		this.cntCd = cntCd;
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
	 * @param chkCstmsErrCd
	 */
	public void setChkCstmsErrCd(String chkCstmsErrCd) {
		this.chkCstmsErrCd = chkCstmsErrCd;
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
		setFrmCstmsErrCd(JSPUtil.getParameter(request, prefix + "frm_cstms_err_cd", ""));
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
		setChkCntCd(JSPUtil.getParameter(request, prefix + "chk_cnt_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setCstmsErrCd(JSPUtil.getParameter(request, prefix + "cstms_err_cd", ""));
		setErrTpCtnt(JSPUtil.getParameter(request, prefix + "err_tp_ctnt", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setErrCdDesc(JSPUtil.getParameter(request, prefix + "err_cd_desc", ""));
		setFrmErrCdDesc(JSPUtil.getParameter(request, prefix + "frm_err_cd_desc", ""));
		setCntCd(JSPUtil.getParameter(request, prefix + "cnt_cd", ""));
		setUserId(JSPUtil.getParameter(request, prefix + "user_id", ""));
		setChkCstmsErrCd(JSPUtil.getParameter(request, prefix + "chk_cstms_err_cd", ""));
		setFrmCntCd(JSPUtil.getParameter(request, prefix + "frm_cnt_cd", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
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
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] frmCstmsErrCd = (JSPUtil.getParameter(request, prefix	+ "frm_cstms_err_cd", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] chkCntCd = (JSPUtil.getParameter(request, prefix	+ "chk_cnt_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] cstmsErrCd = (JSPUtil.getParameter(request, prefix	+ "cstms_err_cd", length));
			String[] errTpCtnt = (JSPUtil.getParameter(request, prefix	+ "err_tp_ctnt", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] errCdDesc = (JSPUtil.getParameter(request, prefix	+ "err_cd_desc", length));
			String[] frmErrCdDesc = (JSPUtil.getParameter(request, prefix	+ "frm_err_cd_desc", length));
			String[] cntCd = (JSPUtil.getParameter(request, prefix	+ "cnt_cd", length));
			String[] userId = (JSPUtil.getParameter(request, prefix	+ "user_id", length));
			String[] chkCstmsErrCd = (JSPUtil.getParameter(request, prefix	+ "chk_cstms_err_cd", length));
			String[] frmCntCd = (JSPUtil.getParameter(request, prefix	+ "frm_cnt_cd", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			
			for (int i = 0; i < length; i++) {
				model = new CstmsErrCdVO();
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (frmCstmsErrCd[i] != null)
					model.setFrmCstmsErrCd(frmCstmsErrCd[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (chkCntCd[i] != null)
					model.setChkCntCd(chkCntCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (cstmsErrCd[i] != null)
					model.setCstmsErrCd(cstmsErrCd[i]);
				if (errTpCtnt[i] != null)
					model.setErrTpCtnt(errTpCtnt[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (errCdDesc[i] != null)
					model.setErrCdDesc(errCdDesc[i]);
				if (frmErrCdDesc[i] != null)
					model.setFrmErrCdDesc(frmErrCdDesc[i]);
				if (cntCd[i] != null)
					model.setCntCd(cntCd[i]);
				if (userId[i] != null)
					model.setUserId(userId[i]);
				if (chkCstmsErrCd[i] != null)
					model.setChkCstmsErrCd(chkCstmsErrCd[i]);
				if (frmCntCd[i] != null)
					model.setFrmCntCd(frmCntCd[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
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
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.frmCstmsErrCd = this.frmCstmsErrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chkCntCd = this.chkCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cstmsErrCd = this.cstmsErrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.errTpCtnt = this.errTpCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.errCdDesc = this.errCdDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.frmErrCdDesc = this.frmErrCdDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntCd = this.cntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.userId = this.userId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chkCstmsErrCd = this.chkCstmsErrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.frmCntCd = this.frmCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
