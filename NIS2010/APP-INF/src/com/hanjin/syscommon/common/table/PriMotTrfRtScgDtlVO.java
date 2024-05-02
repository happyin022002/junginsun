/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : PriMotTrfRtScgDtlVO.java
*@FileTitle : PriMotTrfRtScgDtlVO
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

public class PriMotTrfRtScgDtlVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<PriMotTrfRtScgDtlVO> models = new ArrayList<PriMotTrfRtScgDtlVO>();
	
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String motTrfSeq = null;
	/* Column Info */
	private String creUsrId = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String svcScpCd = null;
	/* Column Info */
	private String motTrfChgCd = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String scgSeq = null;
	/* Column Info */
	private String motTrfChgAmt = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String rtSeq = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public PriMotTrfRtScgDtlVO() {}

	public PriMotTrfRtScgDtlVO(String ibflag, String pagerows, String svcScpCd, String motTrfSeq, String rtSeq, String scgSeq, String motTrfChgCd, String motTrfChgAmt, String creUsrId, String creDt, String updUsrId, String updDt) {
		this.updDt = updDt;
		this.motTrfSeq = motTrfSeq;
		this.creUsrId = creUsrId;
		this.ibflag = ibflag;
		this.svcScpCd = svcScpCd;
		this.motTrfChgCd = motTrfChgCd;
		this.creDt = creDt;
		this.scgSeq = scgSeq;
		this.motTrfChgAmt = motTrfChgAmt;
		this.updUsrId = updUsrId;
		this.rtSeq = rtSeq;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("mot_trf_seq", getMotTrfSeq());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("svc_scp_cd", getSvcScpCd());
		this.hashColumns.put("mot_trf_chg_cd", getMotTrfChgCd());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("scg_seq", getScgSeq());
		this.hashColumns.put("mot_trf_chg_amt", getMotTrfChgAmt());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("rt_seq", getRtSeq());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("mot_trf_seq", "motTrfSeq");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("svc_scp_cd", "svcScpCd");
		this.hashFields.put("mot_trf_chg_cd", "motTrfChgCd");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("scg_seq", "scgSeq");
		this.hashFields.put("mot_trf_chg_amt", "motTrfChgAmt");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("rt_seq", "rtSeq");
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
	 * @return motTrfSeq
	 */
	public String getMotTrfSeq() {
		return this.motTrfSeq;
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
	 * @return svcScpCd
	 */
	public String getSvcScpCd() {
		return this.svcScpCd;
	}
	
	/**
	 * Column Info
	 * @return motTrfChgCd
	 */
	public String getMotTrfChgCd() {
		return this.motTrfChgCd;
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
	 * @return scgSeq
	 */
	public String getScgSeq() {
		return this.scgSeq;
	}
	
	/**
	 * Column Info
	 * @return motTrfChgAmt
	 */
	public String getMotTrfChgAmt() {
		return this.motTrfChgAmt;
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
	 * @param updDt
	 */
	public void setUpdDt(String updDt) {
		this.updDt = updDt;
	}
	
	/**
	 * Column Info
	 * @param motTrfSeq
	 */
	public void setMotTrfSeq(String motTrfSeq) {
		this.motTrfSeq = motTrfSeq;
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
	 * @param svcScpCd
	 */
	public void setSvcScpCd(String svcScpCd) {
		this.svcScpCd = svcScpCd;
	}
	
	/**
	 * Column Info
	 * @param motTrfChgCd
	 */
	public void setMotTrfChgCd(String motTrfChgCd) {
		this.motTrfChgCd = motTrfChgCd;
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
	 * @param scgSeq
	 */
	public void setScgSeq(String scgSeq) {
		this.scgSeq = scgSeq;
	}
	
	/**
	 * Column Info
	 * @param motTrfChgAmt
	 */
	public void setMotTrfChgAmt(String motTrfChgAmt) {
		this.motTrfChgAmt = motTrfChgAmt;
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
		setMotTrfSeq(JSPUtil.getParameter(request, prefix + "mot_trf_seq", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setSvcScpCd(JSPUtil.getParameter(request, prefix + "svc_scp_cd", ""));
		setMotTrfChgCd(JSPUtil.getParameter(request, prefix + "mot_trf_chg_cd", ""));
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
		setScgSeq(JSPUtil.getParameter(request, prefix + "scg_seq", ""));
		setMotTrfChgAmt(JSPUtil.getParameter(request, prefix + "mot_trf_chg_amt", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setRtSeq(JSPUtil.getParameter(request, prefix + "rt_seq", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return PriMotTrfRtScgDtlVO[]
	 */
	public PriMotTrfRtScgDtlVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return PriMotTrfRtScgDtlVO[]
	 */
	public PriMotTrfRtScgDtlVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		PriMotTrfRtScgDtlVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] motTrfSeq = (JSPUtil.getParameter(request, prefix	+ "mot_trf_seq", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] svcScpCd = (JSPUtil.getParameter(request, prefix	+ "svc_scp_cd", length));
			String[] motTrfChgCd = (JSPUtil.getParameter(request, prefix	+ "mot_trf_chg_cd", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] scgSeq = (JSPUtil.getParameter(request, prefix	+ "scg_seq", length));
			String[] motTrfChgAmt = (JSPUtil.getParameter(request, prefix	+ "mot_trf_chg_amt", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] rtSeq = (JSPUtil.getParameter(request, prefix	+ "rt_seq", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new PriMotTrfRtScgDtlVO();
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (motTrfSeq[i] != null)
					model.setMotTrfSeq(motTrfSeq[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (svcScpCd[i] != null)
					model.setSvcScpCd(svcScpCd[i]);
				if (motTrfChgCd[i] != null)
					model.setMotTrfChgCd(motTrfChgCd[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (scgSeq[i] != null)
					model.setScgSeq(scgSeq[i]);
				if (motTrfChgAmt[i] != null)
					model.setMotTrfChgAmt(motTrfChgAmt[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (rtSeq[i] != null)
					model.setRtSeq(rtSeq[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getPriMotTrfRtScgDtlVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return PriMotTrfRtScgDtlVO[]
	 */
	public PriMotTrfRtScgDtlVO[] getPriMotTrfRtScgDtlVOs(){
		PriMotTrfRtScgDtlVO[] vos = (PriMotTrfRtScgDtlVO[])models.toArray(new PriMotTrfRtScgDtlVO[models.size()]);
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
		this.motTrfSeq = this.motTrfSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.svcScpCd = this.svcScpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.motTrfChgCd = this.motTrfChgCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scgSeq = this.scgSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.motTrfChgAmt = this.motTrfChgAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rtSeq = this.rtSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
