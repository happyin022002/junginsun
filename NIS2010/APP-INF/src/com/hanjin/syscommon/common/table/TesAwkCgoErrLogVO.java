/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : TesAwkCgoErrLogVO.java
*@FileTitle : TesAwkCgoErrLogVO
*Open Issues :
*Change history :
*@LastModifyDate : 2013.03.21
*@LastModifier : 
*@LastVersion : 1.0
* 2013.03.21  
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

public class TesAwkCgoErrLogVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<TesAwkCgoErrLogVO> models = new ArrayList<TesAwkCgoErrLogVO>();
	
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String tmlAwkCgoErrTpCd = null;
	/* Column Info */
	private String creUsrId = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String errLogRmk = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String tmlAwkCgoErrLogSeq = null;
	/* Column Info */
	private String updUsrId = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public TesAwkCgoErrLogVO() {}

	public TesAwkCgoErrLogVO(String ibflag, String pagerows, String tmlAwkCgoErrLogSeq, String tmlAwkCgoErrTpCd, String errLogRmk, String creUsrId, String creDt, String updUsrId, String updDt) {
		this.updDt = updDt;
		this.tmlAwkCgoErrTpCd = tmlAwkCgoErrTpCd;
		this.creUsrId = creUsrId;
		this.ibflag = ibflag;
		this.errLogRmk = errLogRmk;
		this.creDt = creDt;
		this.tmlAwkCgoErrLogSeq = tmlAwkCgoErrLogSeq;
		this.updUsrId = updUsrId;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("tml_awk_cgo_err_tp_cd", getTmlAwkCgoErrTpCd());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("err_log_rmk", getErrLogRmk());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("tml_awk_cgo_err_log_seq", getTmlAwkCgoErrLogSeq());
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
		this.hashFields.put("tml_awk_cgo_err_tp_cd", "tmlAwkCgoErrTpCd");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("err_log_rmk", "errLogRmk");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("tml_awk_cgo_err_log_seq", "tmlAwkCgoErrLogSeq");
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
	 * @return tmlAwkCgoErrTpCd
	 */
	public String getTmlAwkCgoErrTpCd() {
		return this.tmlAwkCgoErrTpCd;
	}
	
	/**
	 * Column Info
	 * @return creUsrId
	 */
	public String getCreUsrId() {
		return this.creUsrId;
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
	 * @return tmlAwkCgoErrLogSeq
	 */
	public String getTmlAwkCgoErrLogSeq() {
		return this.tmlAwkCgoErrLogSeq;
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
	 * @param tmlAwkCgoErrTpCd
	 */
	public void setTmlAwkCgoErrTpCd(String tmlAwkCgoErrTpCd) {
		this.tmlAwkCgoErrTpCd = tmlAwkCgoErrTpCd;
	}
	
	/**
	 * Column Info
	 * @param creUsrId
	 */
	public void setCreUsrId(String creUsrId) {
		this.creUsrId = creUsrId;
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
	 * @param tmlAwkCgoErrLogSeq
	 */
	public void setTmlAwkCgoErrLogSeq(String tmlAwkCgoErrLogSeq) {
		this.tmlAwkCgoErrLogSeq = tmlAwkCgoErrLogSeq;
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
		setTmlAwkCgoErrTpCd(JSPUtil.getParameter(request, prefix + "tml_awk_cgo_err_tp_cd", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setErrLogRmk(JSPUtil.getParameter(request, prefix + "err_log_rmk", ""));
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
		setTmlAwkCgoErrLogSeq(JSPUtil.getParameter(request, prefix + "tml_awk_cgo_err_log_seq", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return TesAwkCgoErrLogVO[]
	 */
	public TesAwkCgoErrLogVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return TesAwkCgoErrLogVO[]
	 */
	public TesAwkCgoErrLogVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		TesAwkCgoErrLogVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] tmlAwkCgoErrTpCd = (JSPUtil.getParameter(request, prefix	+ "tml_awk_cgo_err_tp_cd", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] errLogRmk = (JSPUtil.getParameter(request, prefix	+ "err_log_rmk", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] tmlAwkCgoErrLogSeq = (JSPUtil.getParameter(request, prefix	+ "tml_awk_cgo_err_log_seq", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new TesAwkCgoErrLogVO();
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (tmlAwkCgoErrTpCd[i] != null)
					model.setTmlAwkCgoErrTpCd(tmlAwkCgoErrTpCd[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (errLogRmk[i] != null)
					model.setErrLogRmk(errLogRmk[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (tmlAwkCgoErrLogSeq[i] != null)
					model.setTmlAwkCgoErrLogSeq(tmlAwkCgoErrLogSeq[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getTesAwkCgoErrLogVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return TesAwkCgoErrLogVO[]
	 */
	public TesAwkCgoErrLogVO[] getTesAwkCgoErrLogVOs(){
		TesAwkCgoErrLogVO[] vos = (TesAwkCgoErrLogVO[])models.toArray(new TesAwkCgoErrLogVO[models.size()]);
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
		this.tmlAwkCgoErrTpCd = this.tmlAwkCgoErrTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.errLogRmk = this.errLogRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tmlAwkCgoErrLogSeq = this.tmlAwkCgoErrLogSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
