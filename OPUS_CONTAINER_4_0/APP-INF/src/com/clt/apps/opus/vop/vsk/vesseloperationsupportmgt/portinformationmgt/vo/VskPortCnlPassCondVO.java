/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : VskPortCnlPassCondVO.java
*@FileTitle : VskPortCnlPassCondVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.02
*@LastModifier : 김종옥
*@LastVersion : 1.0
* 2009.11.02 김종옥 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.vop.vsk.vesseloperationsupportmgt.portinformationmgt.vo;

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
 * @author 김종옥
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class VskPortCnlPassCondVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<VskPortCnlPassCondVO> models = new ArrayList<VskPortCnlPassCondVO>();
	
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String scgExptLmtHrmnt = null;
	/* Column Info */
	private String cnlRmk = null;
	/* Column Info */
	private String creDt = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String portSeq = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String locCd = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String svcScpBndCd = null;
	/* Column Info */
	private String scgFmLmtHrmnt = null;
	/* Column Info */
	private String cnlTzSeqCd = null;
	/* Column Info */
	private String scgToLmtHrmnt = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String lmtTmScgRto = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public VskPortCnlPassCondVO() {}

	public VskPortCnlPassCondVO(String ibflag, String pagerows, String locCd, String portSeq, String svcScpBndCd, String cnlTzSeqCd, String scgExptLmtHrmnt, String scgFmLmtHrmnt, String scgToLmtHrmnt, String lmtTmScgRto, String cnlRmk, String creUsrId, String creDt, String updUsrId, String updDt) {
		this.updDt = updDt;
		this.scgExptLmtHrmnt = scgExptLmtHrmnt;
		this.cnlRmk = cnlRmk;
		this.creDt = creDt;
		this.pagerows = pagerows;
		this.portSeq = portSeq;
		this.ibflag = ibflag;
		this.locCd = locCd;
		this.creUsrId = creUsrId;
		this.svcScpBndCd = svcScpBndCd;
		this.scgFmLmtHrmnt = scgFmLmtHrmnt;
		this.cnlTzSeqCd = cnlTzSeqCd;
		this.scgToLmtHrmnt = scgToLmtHrmnt;
		this.updUsrId = updUsrId;
		this.lmtTmScgRto = lmtTmScgRto;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("scg_expt_lmt_hrmnt", getScgExptLmtHrmnt());
		this.hashColumns.put("cnl_rmk", getCnlRmk());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("port_seq", getPortSeq());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("loc_cd", getLocCd());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("svc_scp_bnd_cd", getSvcScpBndCd());
		this.hashColumns.put("scg_fm_lmt_hrmnt", getScgFmLmtHrmnt());
		this.hashColumns.put("cnl_tz_seq_cd", getCnlTzSeqCd());
		this.hashColumns.put("scg_to_lmt_hrmnt", getScgToLmtHrmnt());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("lmt_tm_scg_rto", getLmtTmScgRto());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("scg_expt_lmt_hrmnt", "scgExptLmtHrmnt");
		this.hashFields.put("cnl_rmk", "cnlRmk");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("port_seq", "portSeq");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("loc_cd", "locCd");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("svc_scp_bnd_cd", "svcScpBndCd");
		this.hashFields.put("scg_fm_lmt_hrmnt", "scgFmLmtHrmnt");
		this.hashFields.put("cnl_tz_seq_cd", "cnlTzSeqCd");
		this.hashFields.put("scg_to_lmt_hrmnt", "scgToLmtHrmnt");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("lmt_tm_scg_rto", "lmtTmScgRto");
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
	 * @return scgExptLmtHrmnt
	 */
	public String getScgExptLmtHrmnt() {
		return this.scgExptLmtHrmnt;
	}
	
	/**
	 * Column Info
	 * @return cnlRmk
	 */
	public String getCnlRmk() {
		return this.cnlRmk;
	}
	
	/**
	 * Column Info
	 * @return creDt
	 */
	public String getCreDt() {
		return this.creDt;
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
	 * @return portSeq
	 */
	public String getPortSeq() {
		return this.portSeq;
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
	 * @return locCd
	 */
	public String getLocCd() {
		return this.locCd;
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
	 * @return svcScpBndCd
	 */
	public String getSvcScpBndCd() {
		return this.svcScpBndCd;
	}
	
	/**
	 * Column Info
	 * @return scgFmLmtHrmnt
	 */
	public String getScgFmLmtHrmnt() {
		return this.scgFmLmtHrmnt;
	}
	
	/**
	 * Column Info
	 * @return cnlTzSeqCd
	 */
	public String getCnlTzSeqCd() {
		return this.cnlTzSeqCd;
	}
	
	/**
	 * Column Info
	 * @return scgToLmtHrmnt
	 */
	public String getScgToLmtHrmnt() {
		return this.scgToLmtHrmnt;
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
	 * @return lmtTmScgRto
	 */
	public String getLmtTmScgRto() {
		return this.lmtTmScgRto;
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
	 * @param scgExptLmtHrmnt
	 */
	public void setScgExptLmtHrmnt(String scgExptLmtHrmnt) {
		this.scgExptLmtHrmnt = scgExptLmtHrmnt;
	}
	
	/**
	 * Column Info
	 * @param cnlRmk
	 */
	public void setCnlRmk(String cnlRmk) {
		this.cnlRmk = cnlRmk;
	}
	
	/**
	 * Column Info
	 * @param creDt
	 */
	public void setCreDt(String creDt) {
		this.creDt = creDt;
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
	 * @param portSeq
	 */
	public void setPortSeq(String portSeq) {
		this.portSeq = portSeq;
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
	 * @param locCd
	 */
	public void setLocCd(String locCd) {
		this.locCd = locCd;
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
	 * @param svcScpBndCd
	 */
	public void setSvcScpBndCd(String svcScpBndCd) {
		this.svcScpBndCd = svcScpBndCd;
	}
	
	/**
	 * Column Info
	 * @param scgFmLmtHrmnt
	 */
	public void setScgFmLmtHrmnt(String scgFmLmtHrmnt) {
		this.scgFmLmtHrmnt = scgFmLmtHrmnt;
	}
	
	/**
	 * Column Info
	 * @param cnlTzSeqCd
	 */
	public void setCnlTzSeqCd(String cnlTzSeqCd) {
		this.cnlTzSeqCd = cnlTzSeqCd;
	}
	
	/**
	 * Column Info
	 * @param scgToLmtHrmnt
	 */
	public void setScgToLmtHrmnt(String scgToLmtHrmnt) {
		this.scgToLmtHrmnt = scgToLmtHrmnt;
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
	 * @param lmtTmScgRto
	 */
	public void setLmtTmScgRto(String lmtTmScgRto) {
		this.lmtTmScgRto = lmtTmScgRto;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setUpdDt(JSPUtil.getParameter(request, "upd_dt", ""));
		setScgExptLmtHrmnt(JSPUtil.getParameter(request, "scg_expt_lmt_hrmnt", ""));
		setCnlRmk(JSPUtil.getParameter(request, "cnl_rmk", ""));
		setCreDt(JSPUtil.getParameter(request, "cre_dt", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setPortSeq(JSPUtil.getParameter(request, "port_seq", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setLocCd(JSPUtil.getParameter(request, "loc_cd", ""));
		setCreUsrId(JSPUtil.getParameter(request, "cre_usr_id", ""));
		setSvcScpBndCd(JSPUtil.getParameter(request, "svc_scp_bnd_cd", ""));
		setScgFmLmtHrmnt(JSPUtil.getParameter(request, "scg_fm_lmt_hrmnt", ""));
		setCnlTzSeqCd(JSPUtil.getParameter(request, "cnl_tz_seq_cd", ""));
		setScgToLmtHrmnt(JSPUtil.getParameter(request, "scg_to_lmt_hrmnt", ""));
		setUpdUsrId(JSPUtil.getParameter(request, "upd_usr_id", ""));
		setLmtTmScgRto(JSPUtil.getParameter(request, "lmt_tm_scg_rto", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return VskPortCnlPassCondVO[]
	 */
	public VskPortCnlPassCondVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return VskPortCnlPassCondVO[]
	 */
	public VskPortCnlPassCondVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		VskPortCnlPassCondVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] scgExptLmtHrmnt = (JSPUtil.getParameter(request, prefix	+ "scg_expt_lmt_hrmnt", length));
			String[] cnlRmk = (JSPUtil.getParameter(request, prefix	+ "cnl_rmk", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] portSeq = (JSPUtil.getParameter(request, prefix	+ "port_seq", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] locCd = (JSPUtil.getParameter(request, prefix	+ "loc_cd", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] svcScpBndCd = (JSPUtil.getParameter(request, prefix	+ "svc_scp_bnd_cd", length));
			String[] scgFmLmtHrmnt = (JSPUtil.getParameter(request, prefix	+ "scg_fm_lmt_hrmnt", length));
			String[] cnlTzSeqCd = (JSPUtil.getParameter(request, prefix	+ "cnl_tz_seq_cd", length));
			String[] scgToLmtHrmnt = (JSPUtil.getParameter(request, prefix	+ "scg_to_lmt_hrmnt", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] lmtTmScgRto = (JSPUtil.getParameter(request, prefix	+ "lmt_tm_scg_rto", length));
			
			for (int i = 0; i < length; i++) {
				model = new VskPortCnlPassCondVO();
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (scgExptLmtHrmnt[i] != null)
					model.setScgExptLmtHrmnt(scgExptLmtHrmnt[i]);
				if (cnlRmk[i] != null)
					model.setCnlRmk(cnlRmk[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (portSeq[i] != null)
					model.setPortSeq(portSeq[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (locCd[i] != null)
					model.setLocCd(locCd[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (svcScpBndCd[i] != null)
					model.setSvcScpBndCd(svcScpBndCd[i]);
				if (scgFmLmtHrmnt[i] != null)
					model.setScgFmLmtHrmnt(scgFmLmtHrmnt[i]);
				if (cnlTzSeqCd[i] != null)
					model.setCnlTzSeqCd(cnlTzSeqCd[i]);
				if (scgToLmtHrmnt[i] != null)
					model.setScgToLmtHrmnt(scgToLmtHrmnt[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (lmtTmScgRto[i] != null)
					model.setLmtTmScgRto(lmtTmScgRto[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getVskPortCnlPassCondVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return VskPortCnlPassCondVO[]
	 */
	public VskPortCnlPassCondVO[] getVskPortCnlPassCondVOs(){
		VskPortCnlPassCondVO[] vos = (VskPortCnlPassCondVO[])models.toArray(new VskPortCnlPassCondVO[models.size()]);
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
		this.scgExptLmtHrmnt = this.scgExptLmtHrmnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnlRmk = this.cnlRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.portSeq = this.portSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.locCd = this.locCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.svcScpBndCd = this.svcScpBndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scgFmLmtHrmnt = this.scgFmLmtHrmnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnlTzSeqCd = this.cnlTzSeqCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scgToLmtHrmnt = this.scgToLmtHrmnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lmtTmScgRto = this.lmtTmScgRto .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
