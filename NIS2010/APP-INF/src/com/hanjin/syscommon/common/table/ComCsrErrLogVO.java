/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : ComCsrErrLogVO.java
*@FileTitle : ComCsrErrLogVO
*Open Issues :
*Change history :
*@LastModifyDate : 2013.03.08
*@LastModifier : 
*@LastVersion : 1.0
* 2013.03.08  
* 1.0 Creation
=========================================================*/

package com.hanjin.syscommon.common.table;

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
 * @author 
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class ComCsrErrLogVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<ComCsrErrLogVO> models = new ArrayList<ComCsrErrLogVO>();
	
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String csrErrTpCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String errLogRmk = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String csrErrLogSeq = null;
	/* Column Info */
	private String updUsrId = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public ComCsrErrLogVO() {}

	public ComCsrErrLogVO(String ibflag, String pagerows, String csrErrLogSeq, String csrErrTpCd, String errLogRmk, String creUsrId, String creDt, String updUsrId, String updDt) {
		this.updDt = updDt;
		this.creUsrId = creUsrId;
		this.csrErrTpCd = csrErrTpCd;
		this.ibflag = ibflag;
		this.errLogRmk = errLogRmk;
		this.creDt = creDt;
		this.csrErrLogSeq = csrErrLogSeq;
		this.updUsrId = updUsrId;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("csr_err_tp_cd", getCsrErrTpCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("err_log_rmk", getErrLogRmk());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("csr_err_log_seq", getCsrErrLogSeq());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("csr_err_tp_cd", "csrErrTpCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("err_log_rmk", "errLogRmk");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("csr_err_log_seq", "csrErrLogSeq");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("pagerows", "pagerows");
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
	 * @return creUsrId
	 */
	public String getCreUsrId() {
		return this.creUsrId;
	}
	
	/**
	 * Column Info
	 * @return csrErrTpCd
	 */
	public String getCsrErrTpCd() {
		return this.csrErrTpCd;
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
	 * @return errLogRmk
	 */
	public String getErrLogRmk() {
		return this.errLogRmk;
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
	 * @return csrErrLogSeq
	 */
	public String getCsrErrLogSeq() {
		return this.csrErrLogSeq;
	}
	
	/**
	 * Column Info
	 * @return updUsrId
	 */
	public String getUpdUsrId() {
		return this.updUsrId;
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
	 * @param updDt
	 */
	public void setUpdDt(String updDt) {
		this.updDt = updDt;
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
	 * @param csrErrTpCd
	 */
	public void setCsrErrTpCd(String csrErrTpCd) {
		this.csrErrTpCd = csrErrTpCd;
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
	 * @param errLogRmk
	 */
	public void setErrLogRmk(String errLogRmk) {
		this.errLogRmk = errLogRmk;
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
	 * @param csrErrLogSeq
	 */
	public void setCsrErrLogSeq(String csrErrLogSeq) {
		this.csrErrLogSeq = csrErrLogSeq;
	}
	
	/**
	 * Column Info
	 * @param updUsrId
	 */
	public void setUpdUsrId(String updUsrId) {
		this.updUsrId = updUsrId;
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
		fromRequest(request,"");
	}

	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request, String prefix) {
		setUpdDt(JSPUtil.getParameter(request, prefix + "upd_dt", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setCsrErrTpCd(JSPUtil.getParameter(request, prefix + "csr_err_tp_cd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setErrLogRmk(JSPUtil.getParameter(request, prefix + "err_log_rmk", ""));
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
		setCsrErrLogSeq(JSPUtil.getParameter(request, prefix + "csr_err_log_seq", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return ComCsrErrLogVO[]
	 */
	public ComCsrErrLogVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return ComCsrErrLogVO[]
	 */
	public ComCsrErrLogVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		ComCsrErrLogVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] csrErrTpCd = (JSPUtil.getParameter(request, prefix	+ "csr_err_tp_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] errLogRmk = (JSPUtil.getParameter(request, prefix	+ "err_log_rmk", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] csrErrLogSeq = (JSPUtil.getParameter(request, prefix	+ "csr_err_log_seq", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new ComCsrErrLogVO();
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (csrErrTpCd[i] != null)
					model.setCsrErrTpCd(csrErrTpCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (errLogRmk[i] != null)
					model.setErrLogRmk(errLogRmk[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (csrErrLogSeq[i] != null)
					model.setCsrErrLogSeq(csrErrLogSeq[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getComCsrErrLogVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return ComCsrErrLogVO[]
	 */
	public ComCsrErrLogVO[] getComCsrErrLogVOs(){
		ComCsrErrLogVO[] vos = (ComCsrErrLogVO[])models.toArray(new ComCsrErrLogVO[models.size()]);
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
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.csrErrTpCd = this.csrErrTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.errLogRmk = this.errLogRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.csrErrLogSeq = this.csrErrLogSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
