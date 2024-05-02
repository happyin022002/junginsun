/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : RsltPriScgGrpCmdtDtlVO.java
*@FileTitle : RsltPriScgGrpCmdtDtlVO
*Open Issues :
*Change history :
*@LastModifyDate : 2016.02.02
*@LastModifier : 
*@LastVersion : 1.0
* 2016.02.02  
* 1.0 Creation
=========================================================
* 2016.02.04 전지예 [CHM-201640066] TPW Non-Cargo NOS 체크 권한 로직 부여 Request by Hye-In Ahn
=========================================================*/

package com.hanjin.apps.alps.esm.pri.surcharge.surchargegroupcommodity.vo;

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
 * @author 
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class RsltPriScgGrpCmdtDtlVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<RsltPriScgGrpCmdtDtlVO> models = new ArrayList<RsltPriScgGrpCmdtDtlVO>();
	
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String scgGrpCmdtSeq = null;
	/* Column Info */
	private String svcScpCd = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String nonCgoNosAuth = null;
	/* Column Info */
	private String chgCd = null;
	/* Page Number */
	private String pagerows = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String effDt = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String cmdtCd = null;
	/* Column Info */
	private String scgGrpCmdtDtlSeq = null;
	/* Column Info */
	private String nonCgoNosFlg = null;
	/* Column Info */
	private String cmdtDes = null;
	/* Column Info */
	private String expDt = null;
	/* Column Info */
	private String updUsrId = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public RsltPriScgGrpCmdtDtlVO() {}

	public RsltPriScgGrpCmdtDtlVO(String ibflag, String pagerows, String svcScpCd, String chgCd, String scgGrpCmdtSeq, String scgGrpCmdtDtlSeq, String cmdtCd, String nonCgoNosFlg, String effDt, String expDt, String creUsrId, String creDt, String updUsrId, String updDt, String cmdtDes, String nonCgoNosAuth) {
		this.updDt = updDt;
		this.scgGrpCmdtSeq = scgGrpCmdtSeq;
		this.svcScpCd = svcScpCd;
		this.creDt = creDt;
		this.nonCgoNosAuth = nonCgoNosAuth;
		this.chgCd = chgCd;
		this.pagerows = pagerows;
		this.ibflag = ibflag;
		this.effDt = effDt;
		this.creUsrId = creUsrId;
		this.cmdtCd = cmdtCd;
		this.scgGrpCmdtDtlSeq = scgGrpCmdtDtlSeq;
		this.nonCgoNosFlg = nonCgoNosFlg;
		this.cmdtDes = cmdtDes;
		this.expDt = expDt;
		this.updUsrId = updUsrId;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("scg_grp_cmdt_seq", getScgGrpCmdtSeq());
		this.hashColumns.put("svc_scp_cd", getSvcScpCd());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("non_cgo_nos_auth", getNonCgoNosAuth());
		this.hashColumns.put("chg_cd", getChgCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("eff_dt", getEffDt());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("cmdt_cd", getCmdtCd());
		this.hashColumns.put("scg_grp_cmdt_dtl_seq", getScgGrpCmdtDtlSeq());
		this.hashColumns.put("non_cgo_nos_flg", getNonCgoNosFlg());
		this.hashColumns.put("cmdt_des", getCmdtDes());
		this.hashColumns.put("exp_dt", getExpDt());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("scg_grp_cmdt_seq", "scgGrpCmdtSeq");
		this.hashFields.put("svc_scp_cd", "svcScpCd");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("non_cgo_nos_auth", "nonCgoNosAuth");
		this.hashFields.put("chg_cd", "chgCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("eff_dt", "effDt");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("cmdt_cd", "cmdtCd");
		this.hashFields.put("scg_grp_cmdt_dtl_seq", "scgGrpCmdtDtlSeq");
		this.hashFields.put("non_cgo_nos_flg", "nonCgoNosFlg");
		this.hashFields.put("cmdt_des", "cmdtDes");
		this.hashFields.put("exp_dt", "expDt");
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
	 * @return scgGrpCmdtSeq
	 */
	public String getScgGrpCmdtSeq() {
		return this.scgGrpCmdtSeq;
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
	 * @return nonCgoNosAuth
	 */
	public String getNonCgoNosAuth() {
		return this.nonCgoNosAuth;
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
	 * @return effDt
	 */
	public String getEffDt() {
		return this.effDt;
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
	 * @return cmdtCd
	 */
	public String getCmdtCd() {
		return this.cmdtCd;
	}
	
	/**
	 * Column Info
	 * @return scgGrpCmdtDtlSeq
	 */
	public String getScgGrpCmdtDtlSeq() {
		return this.scgGrpCmdtDtlSeq;
	}
	
	/**
	 * Column Info
	 * @return nonCgoNosFlg
	 */
	public String getNonCgoNosFlg() {
		return this.nonCgoNosFlg;
	}
	
	/**
	 * Column Info
	 * @return cmdtDes
	 */
	public String getCmdtDes() {
		return this.cmdtDes;
	}
	
	/**
	 * Column Info
	 * @return expDt
	 */
	public String getExpDt() {
		return this.expDt;
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
	 * @param scgGrpCmdtSeq
	 */
	public void setScgGrpCmdtSeq(String scgGrpCmdtSeq) {
		this.scgGrpCmdtSeq = scgGrpCmdtSeq;
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
	 * @param nonCgoNosAuth
	 */
	public void setNonCgoNosAuth(String nonCgoNosAuth) {
		this.nonCgoNosAuth = nonCgoNosAuth;
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
	 * @param effDt
	 */
	public void setEffDt(String effDt) {
		this.effDt = effDt;
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
	 * @param cmdtCd
	 */
	public void setCmdtCd(String cmdtCd) {
		this.cmdtCd = cmdtCd;
	}
	
	/**
	 * Column Info
	 * @param scgGrpCmdtDtlSeq
	 */
	public void setScgGrpCmdtDtlSeq(String scgGrpCmdtDtlSeq) {
		this.scgGrpCmdtDtlSeq = scgGrpCmdtDtlSeq;
	}
	
	/**
	 * Column Info
	 * @param nonCgoNosFlg
	 */
	public void setNonCgoNosFlg(String nonCgoNosFlg) {
		this.nonCgoNosFlg = nonCgoNosFlg;
	}
	
	/**
	 * Column Info
	 * @param cmdtDes
	 */
	public void setCmdtDes(String cmdtDes) {
		this.cmdtDes = cmdtDes;
	}
	
	/**
	 * Column Info
	 * @param expDt
	 */
	public void setExpDt(String expDt) {
		this.expDt = expDt;
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
		setScgGrpCmdtSeq(JSPUtil.getParameter(request, prefix + "scg_grp_cmdt_seq", ""));
		setSvcScpCd(JSPUtil.getParameter(request, prefix + "svc_scp_cd", ""));
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
		setNonCgoNosAuth(JSPUtil.getParameter(request, prefix + "non_cgo_nos_auth", ""));
		setChgCd(JSPUtil.getParameter(request, prefix + "chg_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setEffDt(JSPUtil.getParameter(request, prefix + "eff_dt", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setCmdtCd(JSPUtil.getParameter(request, prefix + "cmdt_cd", ""));
		setScgGrpCmdtDtlSeq(JSPUtil.getParameter(request, prefix + "scg_grp_cmdt_dtl_seq", ""));
		setNonCgoNosFlg(JSPUtil.getParameter(request, prefix + "non_cgo_nos_flg", ""));
		setCmdtDes(JSPUtil.getParameter(request, prefix + "cmdt_des", ""));
		setExpDt(JSPUtil.getParameter(request, prefix + "exp_dt", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return RsltPriScgGrpCmdtDtlVO[]
	 */
	public RsltPriScgGrpCmdtDtlVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return RsltPriScgGrpCmdtDtlVO[]
	 */
	public RsltPriScgGrpCmdtDtlVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		RsltPriScgGrpCmdtDtlVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] scgGrpCmdtSeq = (JSPUtil.getParameter(request, prefix	+ "scg_grp_cmdt_seq", length));
			String[] svcScpCd = (JSPUtil.getParameter(request, prefix	+ "svc_scp_cd", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] nonCgoNosAuth = (JSPUtil.getParameter(request, prefix	+ "non_cgo_nos_auth", length));
			String[] chgCd = (JSPUtil.getParameter(request, prefix	+ "chg_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] effDt = (JSPUtil.getParameter(request, prefix	+ "eff_dt", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] cmdtCd = (JSPUtil.getParameter(request, prefix	+ "cmdt_cd", length));
			String[] scgGrpCmdtDtlSeq = (JSPUtil.getParameter(request, prefix	+ "scg_grp_cmdt_dtl_seq", length));
			String[] nonCgoNosFlg = (JSPUtil.getParameter(request, prefix	+ "non_cgo_nos_flg", length));
			String[] cmdtDes = (JSPUtil.getParameter(request, prefix	+ "cmdt_des", length));
			String[] expDt = (JSPUtil.getParameter(request, prefix	+ "exp_dt", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			
			for (int i = 0; i < length; i++) {
				model = new RsltPriScgGrpCmdtDtlVO();
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (scgGrpCmdtSeq[i] != null)
					model.setScgGrpCmdtSeq(scgGrpCmdtSeq[i]);
				if (svcScpCd[i] != null)
					model.setSvcScpCd(svcScpCd[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (nonCgoNosAuth[i] != null)
					model.setNonCgoNosAuth(nonCgoNosAuth[i]);
				if (chgCd[i] != null)
					model.setChgCd(chgCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (effDt[i] != null)
					model.setEffDt(effDt[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (cmdtCd[i] != null)
					model.setCmdtCd(cmdtCd[i]);
				if (scgGrpCmdtDtlSeq[i] != null)
					model.setScgGrpCmdtDtlSeq(scgGrpCmdtDtlSeq[i]);
				if (nonCgoNosFlg[i] != null)
					model.setNonCgoNosFlg(nonCgoNosFlg[i]);
				if (cmdtDes[i] != null)
					model.setCmdtDes(cmdtDes[i]);
				if (expDt[i] != null)
					model.setExpDt(expDt[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getRsltPriScgGrpCmdtDtlVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return RsltPriScgGrpCmdtDtlVO[]
	 */
	public RsltPriScgGrpCmdtDtlVO[] getRsltPriScgGrpCmdtDtlVOs(){
		RsltPriScgGrpCmdtDtlVO[] vos = (RsltPriScgGrpCmdtDtlVO[])models.toArray(new RsltPriScgGrpCmdtDtlVO[models.size()]);
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
		this.scgGrpCmdtSeq = this.scgGrpCmdtSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.svcScpCd = this.svcScpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.nonCgoNosAuth = this.nonCgoNosAuth .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chgCd = this.chgCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.effDt = this.effDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmdtCd = this.cmdtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scgGrpCmdtDtlSeq = this.scgGrpCmdtDtlSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.nonCgoNosFlg = this.nonCgoNosFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmdtDes = this.cmdtDes .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.expDt = this.expDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
