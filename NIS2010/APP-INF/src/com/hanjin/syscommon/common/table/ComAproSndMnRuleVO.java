/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : ComAproSndMnRuleVO.java
*@FileTitle : ComAproSndMnRuleVO
*Open Issues :
*Change history :
*@LastModifyDate : 2013.03.13
*@LastModifier : 
*@LastVersion : 1.0
* 2013.03.13  
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

public class ComAproSndMnRuleVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<ComAproSndMnRuleVO> models = new ArrayList<ComAproSndMnRuleVO>();
	
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String deltFlg = null;
	/* Column Info */
	private String cfmDt = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String deltDt = null;
	/* Column Info */
	private String cfmFlg = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String exeRowKnt = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String exeActTpCd = null;
	/* Column Info */
	private String srcCtnt = null;
	/* Column Info */
	private String subSysId = null;
	/* Column Info */
	private String updUsrId = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public ComAproSndMnRuleVO() {}

	public ComAproSndMnRuleVO(String ibflag, String pagerows, String srcCtnt, String subSysId, String exeActTpCd, String cfmFlg, String cfmDt, String deltFlg, String deltDt, String exeRowKnt, String creUsrId, String creDt, String updUsrId, String updDt) {
		this.updDt = updDt;
		this.deltFlg = deltFlg;
		this.cfmDt = cfmDt;
		this.creDt = creDt;
		this.deltDt = deltDt;
		this.cfmFlg = cfmFlg;
		this.pagerows = pagerows;
		this.exeRowKnt = exeRowKnt;
		this.ibflag = ibflag;
		this.creUsrId = creUsrId;
		this.exeActTpCd = exeActTpCd;
		this.srcCtnt = srcCtnt;
		this.subSysId = subSysId;
		this.updUsrId = updUsrId;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("delt_flg", getDeltFlg());
		this.hashColumns.put("cfm_dt", getCfmDt());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("delt_dt", getDeltDt());
		this.hashColumns.put("cfm_flg", getCfmFlg());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("exe_row_knt", getExeRowKnt());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("exe_act_tp_cd", getExeActTpCd());
		this.hashColumns.put("src_ctnt", getSrcCtnt());
		this.hashColumns.put("sub_sys_id", getSubSysId());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("delt_flg", "deltFlg");
		this.hashFields.put("cfm_dt", "cfmDt");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("delt_dt", "deltDt");
		this.hashFields.put("cfm_flg", "cfmFlg");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("exe_row_knt", "exeRowKnt");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("exe_act_tp_cd", "exeActTpCd");
		this.hashFields.put("src_ctnt", "srcCtnt");
		this.hashFields.put("sub_sys_id", "subSysId");
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
	 * @return deltFlg
	 */
	public String getDeltFlg() {
		return this.deltFlg;
	}
	
	/**
	 * Column Info
	 * @return cfmDt
	 */
	public String getCfmDt() {
		return this.cfmDt;
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
	 * @return deltDt
	 */
	public String getDeltDt() {
		return this.deltDt;
	}
	
	/**
	 * Column Info
	 * @return cfmFlg
	 */
	public String getCfmFlg() {
		return this.cfmFlg;
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
	 * @return exeRowKnt
	 */
	public String getExeRowKnt() {
		return this.exeRowKnt;
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
	 * @return exeActTpCd
	 */
	public String getExeActTpCd() {
		return this.exeActTpCd;
	}
	
	/**
	 * Column Info
	 * @return srcCtnt
	 */
	public String getSrcCtnt() {
		return this.srcCtnt;
	}
	
	/**
	 * Column Info
	 * @return subSysId
	 */
	public String getSubSysId() {
		return this.subSysId;
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
	 * @param deltFlg
	 */
	public void setDeltFlg(String deltFlg) {
		this.deltFlg = deltFlg;
	}
	
	/**
	 * Column Info
	 * @param cfmDt
	 */
	public void setCfmDt(String cfmDt) {
		this.cfmDt = cfmDt;
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
	 * @param deltDt
	 */
	public void setDeltDt(String deltDt) {
		this.deltDt = deltDt;
	}
	
	/**
	 * Column Info
	 * @param cfmFlg
	 */
	public void setCfmFlg(String cfmFlg) {
		this.cfmFlg = cfmFlg;
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
	 * @param exeRowKnt
	 */
	public void setExeRowKnt(String exeRowKnt) {
		this.exeRowKnt = exeRowKnt;
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
	 * @param exeActTpCd
	 */
	public void setExeActTpCd(String exeActTpCd) {
		this.exeActTpCd = exeActTpCd;
	}
	
	/**
	 * Column Info
	 * @param srcCtnt
	 */
	public void setSrcCtnt(String srcCtnt) {
		this.srcCtnt = srcCtnt;
	}
	
	/**
	 * Column Info
	 * @param subSysId
	 */
	public void setSubSysId(String subSysId) {
		this.subSysId = subSysId;
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
		setDeltFlg(JSPUtil.getParameter(request, prefix + "delt_flg", ""));
		setCfmDt(JSPUtil.getParameter(request, prefix + "cfm_dt", ""));
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
		setDeltDt(JSPUtil.getParameter(request, prefix + "delt_dt", ""));
		setCfmFlg(JSPUtil.getParameter(request, prefix + "cfm_flg", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setExeRowKnt(JSPUtil.getParameter(request, prefix + "exe_row_knt", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setExeActTpCd(JSPUtil.getParameter(request, prefix + "exe_act_tp_cd", ""));
		setSrcCtnt(JSPUtil.getParameter(request, prefix + "src_ctnt", ""));
		setSubSysId(JSPUtil.getParameter(request, prefix + "sub_sys_id", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return ComAproSndMnRuleVO[]
	 */
	public ComAproSndMnRuleVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return ComAproSndMnRuleVO[]
	 */
	public ComAproSndMnRuleVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		ComAproSndMnRuleVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] deltFlg = (JSPUtil.getParameter(request, prefix	+ "delt_flg", length));
			String[] cfmDt = (JSPUtil.getParameter(request, prefix	+ "cfm_dt", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] deltDt = (JSPUtil.getParameter(request, prefix	+ "delt_dt", length));
			String[] cfmFlg = (JSPUtil.getParameter(request, prefix	+ "cfm_flg", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] exeRowKnt = (JSPUtil.getParameter(request, prefix	+ "exe_row_knt", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] exeActTpCd = (JSPUtil.getParameter(request, prefix	+ "exe_act_tp_cd", length));
			String[] srcCtnt = (JSPUtil.getParameter(request, prefix	+ "src_ctnt", length));
			String[] subSysId = (JSPUtil.getParameter(request, prefix	+ "sub_sys_id", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			
			for (int i = 0; i < length; i++) {
				model = new ComAproSndMnRuleVO();
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (deltFlg[i] != null)
					model.setDeltFlg(deltFlg[i]);
				if (cfmDt[i] != null)
					model.setCfmDt(cfmDt[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (deltDt[i] != null)
					model.setDeltDt(deltDt[i]);
				if (cfmFlg[i] != null)
					model.setCfmFlg(cfmFlg[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (exeRowKnt[i] != null)
					model.setExeRowKnt(exeRowKnt[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (exeActTpCd[i] != null)
					model.setExeActTpCd(exeActTpCd[i]);
				if (srcCtnt[i] != null)
					model.setSrcCtnt(srcCtnt[i]);
				if (subSysId[i] != null)
					model.setSubSysId(subSysId[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getComAproSndMnRuleVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return ComAproSndMnRuleVO[]
	 */
	public ComAproSndMnRuleVO[] getComAproSndMnRuleVOs(){
		ComAproSndMnRuleVO[] vos = (ComAproSndMnRuleVO[])models.toArray(new ComAproSndMnRuleVO[models.size()]);
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
		this.deltFlg = this.deltFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cfmDt = this.cfmDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.deltDt = this.deltDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cfmFlg = this.cfmFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.exeRowKnt = this.exeRowKnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.exeActTpCd = this.exeActTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.srcCtnt = this.srcCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.subSysId = this.subSysId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
