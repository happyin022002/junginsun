/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : PriMotTrfRtVO.java
*@FileTitle : PriMotTrfRtVO
*Open Issues :
*Change history :
*@LastModifyDate : 2014.04.25
*@LastModifier : 송호진
*@LastVersion : 1.0
* 2014.04.25 송호진 
* 1.0 Creation
=========================================================*/

package com.hanjin.syscommon.common.table;

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
 * @author 송호진
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class PriMotTrfRtVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<PriMotTrfRtVO> models = new ArrayList<PriMotTrfRtVO>();
	
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String svcScpCd = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String motTrfOrgCd = null;
	/* Column Info */
	private String rtSeq = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String motTrfSeq = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String motTrfCmdtTpCd = null;
	/* Column Info */
	private String motTrfCntrSzCd = null;
	/* Column Info */
	private String motTrfRmk = null;
	/* Column Info */
	private String motTrfDestCd = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String motTrfCntrTpCd = null;
	/* Column Info */
	private String motTrfRtAmt = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public PriMotTrfRtVO() {}

	public PriMotTrfRtVO(String ibflag, String pagerows, String svcScpCd, String motTrfSeq, String rtSeq, String motTrfOrgCd, String motTrfDestCd, String motTrfCntrTpCd, String motTrfCmdtTpCd, String motTrfCntrSzCd, String motTrfRtAmt, String motTrfRmk, String creUsrId, String creDt, String updUsrId, String updDt) {
		this.updDt = updDt;
		this.svcScpCd = svcScpCd;
		this.creDt = creDt;
		this.motTrfOrgCd = motTrfOrgCd;
		this.rtSeq = rtSeq;
		this.pagerows = pagerows;
		this.motTrfSeq = motTrfSeq;
		this.ibflag = ibflag;
		this.creUsrId = creUsrId;
		this.motTrfCmdtTpCd = motTrfCmdtTpCd;
		this.motTrfCntrSzCd = motTrfCntrSzCd;
		this.motTrfRmk = motTrfRmk;
		this.motTrfDestCd = motTrfDestCd;
		this.updUsrId = updUsrId;
		this.motTrfCntrTpCd = motTrfCntrTpCd;
		this.motTrfRtAmt = motTrfRtAmt;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("svc_scp_cd", getSvcScpCd());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("mot_trf_org_cd", getMotTrfOrgCd());
		this.hashColumns.put("rt_seq", getRtSeq());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("mot_trf_seq", getMotTrfSeq());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("mot_trf_cmdt_tp_cd", getMotTrfCmdtTpCd());
		this.hashColumns.put("mot_trf_cntr_sz_cd", getMotTrfCntrSzCd());
		this.hashColumns.put("mot_trf_rmk", getMotTrfRmk());
		this.hashColumns.put("mot_trf_dest_cd", getMotTrfDestCd());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("mot_trf_cntr_tp_cd", getMotTrfCntrTpCd());
		this.hashColumns.put("mot_trf_rt_amt", getMotTrfRtAmt());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("svc_scp_cd", "svcScpCd");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("mot_trf_org_cd", "motTrfOrgCd");
		this.hashFields.put("rt_seq", "rtSeq");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("mot_trf_seq", "motTrfSeq");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("mot_trf_cmdt_tp_cd", "motTrfCmdtTpCd");
		this.hashFields.put("mot_trf_cntr_sz_cd", "motTrfCntrSzCd");
		this.hashFields.put("mot_trf_rmk", "motTrfRmk");
		this.hashFields.put("mot_trf_dest_cd", "motTrfDestCd");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("mot_trf_cntr_tp_cd", "motTrfCntrTpCd");
		this.hashFields.put("mot_trf_rt_amt", "motTrfRtAmt");
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
	 * @return svcScpCd
	 */
	public String getSvcScpCd() {
		return this.svcScpCd;
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
	 * @return motTrfOrgCd
	 */
	public String getMotTrfOrgCd() {
		return this.motTrfOrgCd;
	}
	
	/**
	 * Column Info
	 * @return rtSeq
	 */
	public String getRtSeq() {
		return this.rtSeq;
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
	 * @return motTrfSeq
	 */
	public String getMotTrfSeq() {
		return this.motTrfSeq;
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
	 * @return motTrfCmdtTpCd
	 */
	public String getMotTrfCmdtTpCd() {
		return this.motTrfCmdtTpCd;
	}
	
	/**
	 * Column Info
	 * @return motTrfCntrSzCd
	 */
	public String getMotTrfCntrSzCd() {
		return this.motTrfCntrSzCd;
	}
	
	/**
	 * Column Info
	 * @return motTrfRmk
	 */
	public String getMotTrfRmk() {
		return this.motTrfRmk;
	}
	
	/**
	 * Column Info
	 * @return motTrfDestCd
	 */
	public String getMotTrfDestCd() {
		return this.motTrfDestCd;
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
	 * @return motTrfCntrTpCd
	 */
	public String getMotTrfCntrTpCd() {
		return this.motTrfCntrTpCd;
	}
	
	/**
	 * Column Info
	 * @return motTrfRtAmt
	 */
	public String getMotTrfRtAmt() {
		return this.motTrfRtAmt;
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
	 * @param svcScpCd
	 */
	public void setSvcScpCd(String svcScpCd) {
		this.svcScpCd = svcScpCd;
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
	 * @param motTrfOrgCd
	 */
	public void setMotTrfOrgCd(String motTrfOrgCd) {
		this.motTrfOrgCd = motTrfOrgCd;
	}
	
	/**
	 * Column Info
	 * @param rtSeq
	 */
	public void setRtSeq(String rtSeq) {
		this.rtSeq = rtSeq;
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
	 * @param motTrfSeq
	 */
	public void setMotTrfSeq(String motTrfSeq) {
		this.motTrfSeq = motTrfSeq;
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
	 * @param motTrfCmdtTpCd
	 */
	public void setMotTrfCmdtTpCd(String motTrfCmdtTpCd) {
		this.motTrfCmdtTpCd = motTrfCmdtTpCd;
	}
	
	/**
	 * Column Info
	 * @param motTrfCntrSzCd
	 */
	public void setMotTrfCntrSzCd(String motTrfCntrSzCd) {
		this.motTrfCntrSzCd = motTrfCntrSzCd;
	}
	
	/**
	 * Column Info
	 * @param motTrfRmk
	 */
	public void setMotTrfRmk(String motTrfRmk) {
		this.motTrfRmk = motTrfRmk;
	}
	
	/**
	 * Column Info
	 * @param motTrfDestCd
	 */
	public void setMotTrfDestCd(String motTrfDestCd) {
		this.motTrfDestCd = motTrfDestCd;
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
	 * @param motTrfCntrTpCd
	 */
	public void setMotTrfCntrTpCd(String motTrfCntrTpCd) {
		this.motTrfCntrTpCd = motTrfCntrTpCd;
	}
	
	/**
	 * Column Info
	 * @param motTrfRtAmt
	 */
	public void setMotTrfRtAmt(String motTrfRtAmt) {
		this.motTrfRtAmt = motTrfRtAmt;
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
		setSvcScpCd(JSPUtil.getParameter(request, prefix + "svc_scp_cd", ""));
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
		setMotTrfOrgCd(JSPUtil.getParameter(request, prefix + "mot_trf_org_cd", ""));
		setRtSeq(JSPUtil.getParameter(request, prefix + "rt_seq", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setMotTrfSeq(JSPUtil.getParameter(request, prefix + "mot_trf_seq", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setMotTrfCmdtTpCd(JSPUtil.getParameter(request, prefix + "mot_trf_cmdt_tp_cd", ""));
		setMotTrfCntrSzCd(JSPUtil.getParameter(request, prefix + "mot_trf_cntr_sz_cd", ""));
		setMotTrfRmk(JSPUtil.getParameter(request, prefix + "mot_trf_rmk", ""));
		setMotTrfDestCd(JSPUtil.getParameter(request, prefix + "mot_trf_dest_cd", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setMotTrfCntrTpCd(JSPUtil.getParameter(request, prefix + "mot_trf_cntr_tp_cd", ""));
		setMotTrfRtAmt(JSPUtil.getParameter(request, prefix + "mot_trf_rt_amt", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return PriMotTrfRtVO[]
	 */
	public PriMotTrfRtVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return PriMotTrfRtVO[]
	 */
	public PriMotTrfRtVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		PriMotTrfRtVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] svcScpCd = (JSPUtil.getParameter(request, prefix	+ "svc_scp_cd", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] motTrfOrgCd = (JSPUtil.getParameter(request, prefix	+ "mot_trf_org_cd", length));
			String[] rtSeq = (JSPUtil.getParameter(request, prefix	+ "rt_seq", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] motTrfSeq = (JSPUtil.getParameter(request, prefix	+ "mot_trf_seq", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] motTrfCmdtTpCd = (JSPUtil.getParameter(request, prefix	+ "mot_trf_cmdt_tp_cd", length));
			String[] motTrfCntrSzCd = (JSPUtil.getParameter(request, prefix	+ "mot_trf_cntr_sz_cd", length));
			String[] motTrfRmk = (JSPUtil.getParameter(request, prefix	+ "mot_trf_rmk", length));
			String[] motTrfDestCd = (JSPUtil.getParameter(request, prefix	+ "mot_trf_dest_cd", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] motTrfCntrTpCd = (JSPUtil.getParameter(request, prefix	+ "mot_trf_cntr_tp_cd", length));
			String[] motTrfRtAmt = (JSPUtil.getParameter(request, prefix	+ "mot_trf_rt_amt", length));
			
			for (int i = 0; i < length; i++) {
				model = new PriMotTrfRtVO();
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (svcScpCd[i] != null)
					model.setSvcScpCd(svcScpCd[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (motTrfOrgCd[i] != null)
					model.setMotTrfOrgCd(motTrfOrgCd[i]);
				if (rtSeq[i] != null)
					model.setRtSeq(rtSeq[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (motTrfSeq[i] != null)
					model.setMotTrfSeq(motTrfSeq[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (motTrfCmdtTpCd[i] != null)
					model.setMotTrfCmdtTpCd(motTrfCmdtTpCd[i]);
				if (motTrfCntrSzCd[i] != null)
					model.setMotTrfCntrSzCd(motTrfCntrSzCd[i]);
				if (motTrfRmk[i] != null)
					model.setMotTrfRmk(motTrfRmk[i]);
				if (motTrfDestCd[i] != null)
					model.setMotTrfDestCd(motTrfDestCd[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (motTrfCntrTpCd[i] != null)
					model.setMotTrfCntrTpCd(motTrfCntrTpCd[i]);
				if (motTrfRtAmt[i] != null)
					model.setMotTrfRtAmt(motTrfRtAmt[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getPriMotTrfRtVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return PriMotTrfRtVO[]
	 */
	public PriMotTrfRtVO[] getPriMotTrfRtVOs(){
		PriMotTrfRtVO[] vos = (PriMotTrfRtVO[])models.toArray(new PriMotTrfRtVO[models.size()]);
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
		this.svcScpCd = this.svcScpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.motTrfOrgCd = this.motTrfOrgCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rtSeq = this.rtSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.motTrfSeq = this.motTrfSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.motTrfCmdtTpCd = this.motTrfCmdtTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.motTrfCntrSzCd = this.motTrfCntrSzCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.motTrfRmk = this.motTrfRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.motTrfDestCd = this.motTrfDestCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.motTrfCntrTpCd = this.motTrfCntrTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.motTrfRtAmt = this.motTrfRtAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
