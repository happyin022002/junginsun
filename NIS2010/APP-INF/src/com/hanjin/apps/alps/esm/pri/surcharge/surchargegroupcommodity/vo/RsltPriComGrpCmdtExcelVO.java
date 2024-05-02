/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : RsltPriComGrpCmdtExcelVO.java
*@FileTitle : RsltPriComGrpCmdtExcelVO
*Open Issues :
*Change history :
*@LastModifyDate : 2015.06.19
*@LastModifier : 
*@LastVersion : 1.0
* 2015.06.19  
* 1.0 Creation
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

public class RsltPriComGrpCmdtExcelVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<RsltPriComGrpCmdtExcelVO> models = new ArrayList<RsltPriComGrpCmdtExcelVO>();
	
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String scgGrpCmdtSeq = null;
	/* Column Info */
	private String deltFlg = null;
	/* Column Info */
	private String svcScpCd = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String scgGrpCmdtDesc = null;
	/* Column Info */
	private String chgCd = null;
	/* Column Info */
	private String scgGrpCmdtCd = null;
	/* Page Number */
	private String pagerows = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String effDt = null;
	/* Column Info */
	private String cmdtCd = null;
	/* Column Info */
	private String nonCgoNosFlg = null;
	/* Column Info */
	private String cmdtDes = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public RsltPriComGrpCmdtExcelVO() {}

	public RsltPriComGrpCmdtExcelVO(String ibflag, String pagerows, String svcScpCd, String chgCd, String scgGrpCmdtSeq, String scgGrpCmdtCd, String scgGrpCmdtDesc, String deltFlg, String creDt, String cmdtCd, String nonCgoNosFlg, String effDt, String updDt, String cmdtDes) {
		this.updDt = updDt;
		this.scgGrpCmdtSeq = scgGrpCmdtSeq;
		this.deltFlg = deltFlg;
		this.svcScpCd = svcScpCd;
		this.creDt = creDt;
		this.scgGrpCmdtDesc = scgGrpCmdtDesc;
		this.chgCd = chgCd;
		this.scgGrpCmdtCd = scgGrpCmdtCd;
		this.pagerows = pagerows;
		this.ibflag = ibflag;
		this.effDt = effDt;
		this.cmdtCd = cmdtCd;
		this.nonCgoNosFlg = nonCgoNosFlg;
		this.cmdtDes = cmdtDes;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("scg_grp_cmdt_seq", getScgGrpCmdtSeq());
		this.hashColumns.put("delt_flg", getDeltFlg());
		this.hashColumns.put("svc_scp_cd", getSvcScpCd());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("scg_grp_cmdt_desc", getScgGrpCmdtDesc());
		this.hashColumns.put("chg_cd", getChgCd());
		this.hashColumns.put("scg_grp_cmdt_cd", getScgGrpCmdtCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("eff_dt", getEffDt());
		this.hashColumns.put("cmdt_cd", getCmdtCd());
		this.hashColumns.put("non_cgo_nos_flg", getNonCgoNosFlg());
		this.hashColumns.put("cmdt_des", getCmdtDes());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("scg_grp_cmdt_seq", "scgGrpCmdtSeq");
		this.hashFields.put("delt_flg", "deltFlg");
		this.hashFields.put("svc_scp_cd", "svcScpCd");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("scg_grp_cmdt_desc", "scgGrpCmdtDesc");
		this.hashFields.put("chg_cd", "chgCd");
		this.hashFields.put("scg_grp_cmdt_cd", "scgGrpCmdtCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("eff_dt", "effDt");
		this.hashFields.put("cmdt_cd", "cmdtCd");
		this.hashFields.put("non_cgo_nos_flg", "nonCgoNosFlg");
		this.hashFields.put("cmdt_des", "cmdtDes");
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
	 * @return deltFlg
	 */
	public String getDeltFlg() {
		return this.deltFlg;
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
	 * @return scgGrpCmdtDesc
	 */
	public String getScgGrpCmdtDesc() {
		return this.scgGrpCmdtDesc;
	}
	
	/**
	 * Column Info
	 * @return chgCd
	 */
	public String getChgCd() {
		return this.chgCd;
	}
	
	/**
	 * Column Info
	 * @return scgGrpCmdtCd
	 */
	public String getScgGrpCmdtCd() {
		return this.scgGrpCmdtCd;
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
	 * @return cmdtCd
	 */
	public String getCmdtCd() {
		return this.cmdtCd;
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
	 * @param deltFlg
	 */
	public void setDeltFlg(String deltFlg) {
		this.deltFlg = deltFlg;
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
	 * @param scgGrpCmdtDesc
	 */
	public void setScgGrpCmdtDesc(String scgGrpCmdtDesc) {
		this.scgGrpCmdtDesc = scgGrpCmdtDesc;
	}
	
	/**
	 * Column Info
	 * @param chgCd
	 */
	public void setChgCd(String chgCd) {
		this.chgCd = chgCd;
	}
	
	/**
	 * Column Info
	 * @param scgGrpCmdtCd
	 */
	public void setScgGrpCmdtCd(String scgGrpCmdtCd) {
		this.scgGrpCmdtCd = scgGrpCmdtCd;
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
	 * @param cmdtCd
	 */
	public void setCmdtCd(String cmdtCd) {
		this.cmdtCd = cmdtCd;
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
		setDeltFlg(JSPUtil.getParameter(request, prefix + "delt_flg", ""));
		setSvcScpCd(JSPUtil.getParameter(request, prefix + "svc_scp_cd", ""));
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
		setScgGrpCmdtDesc(JSPUtil.getParameter(request, prefix + "scg_grp_cmdt_desc", ""));
		setChgCd(JSPUtil.getParameter(request, prefix + "chg_cd", ""));
		setScgGrpCmdtCd(JSPUtil.getParameter(request, prefix + "scg_grp_cmdt_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setEffDt(JSPUtil.getParameter(request, prefix + "eff_dt", ""));
		setCmdtCd(JSPUtil.getParameter(request, prefix + "cmdt_cd", ""));
		setNonCgoNosFlg(JSPUtil.getParameter(request, prefix + "non_cgo_nos_flg", ""));
		setCmdtDes(JSPUtil.getParameter(request, prefix + "cmdt_des", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return RsltPriComGrpCmdtExcelVO[]
	 */
	public RsltPriComGrpCmdtExcelVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return RsltPriComGrpCmdtExcelVO[]
	 */
	public RsltPriComGrpCmdtExcelVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		RsltPriComGrpCmdtExcelVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] scgGrpCmdtSeq = (JSPUtil.getParameter(request, prefix	+ "scg_grp_cmdt_seq", length));
			String[] deltFlg = (JSPUtil.getParameter(request, prefix	+ "delt_flg", length));
			String[] svcScpCd = (JSPUtil.getParameter(request, prefix	+ "svc_scp_cd", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] scgGrpCmdtDesc = (JSPUtil.getParameter(request, prefix	+ "scg_grp_cmdt_desc", length));
			String[] chgCd = (JSPUtil.getParameter(request, prefix	+ "chg_cd", length));
			String[] scgGrpCmdtCd = (JSPUtil.getParameter(request, prefix	+ "scg_grp_cmdt_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] effDt = (JSPUtil.getParameter(request, prefix	+ "eff_dt", length));
			String[] cmdtCd = (JSPUtil.getParameter(request, prefix	+ "cmdt_cd", length));
			String[] nonCgoNosFlg = (JSPUtil.getParameter(request, prefix	+ "non_cgo_nos_flg", length));
			String[] cmdtDes = (JSPUtil.getParameter(request, prefix	+ "cmdt_des", length));
			
			for (int i = 0; i < length; i++) {
				model = new RsltPriComGrpCmdtExcelVO();
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (scgGrpCmdtSeq[i] != null)
					model.setScgGrpCmdtSeq(scgGrpCmdtSeq[i]);
				if (deltFlg[i] != null)
					model.setDeltFlg(deltFlg[i]);
				if (svcScpCd[i] != null)
					model.setSvcScpCd(svcScpCd[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (scgGrpCmdtDesc[i] != null)
					model.setScgGrpCmdtDesc(scgGrpCmdtDesc[i]);
				if (chgCd[i] != null)
					model.setChgCd(chgCd[i]);
				if (scgGrpCmdtCd[i] != null)
					model.setScgGrpCmdtCd(scgGrpCmdtCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (effDt[i] != null)
					model.setEffDt(effDt[i]);
				if (cmdtCd[i] != null)
					model.setCmdtCd(cmdtCd[i]);
				if (nonCgoNosFlg[i] != null)
					model.setNonCgoNosFlg(nonCgoNosFlg[i]);
				if (cmdtDes[i] != null)
					model.setCmdtDes(cmdtDes[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getRsltPriComGrpCmdtExcelVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return RsltPriComGrpCmdtExcelVO[]
	 */
	public RsltPriComGrpCmdtExcelVO[] getRsltPriComGrpCmdtExcelVOs(){
		RsltPriComGrpCmdtExcelVO[] vos = (RsltPriComGrpCmdtExcelVO[])models.toArray(new RsltPriComGrpCmdtExcelVO[models.size()]);
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
		this.deltFlg = this.deltFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.svcScpCd = this.svcScpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scgGrpCmdtDesc = this.scgGrpCmdtDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chgCd = this.chgCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scgGrpCmdtCd = this.scgGrpCmdtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.effDt = this.effDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmdtCd = this.cmdtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.nonCgoNosFlg = this.nonCgoNosFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmdtDes = this.cmdtDes .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
