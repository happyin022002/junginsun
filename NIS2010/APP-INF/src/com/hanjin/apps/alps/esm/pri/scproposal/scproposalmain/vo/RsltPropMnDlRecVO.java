/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : RsltPropMnDlRecVO.java
*@FileTitle : RsltPropMnDlRecVO
*Open Issues :
*Change history :
*@LastModifyDate : 2015.09.08
*@LastModifier : 최성환
*@LastVersion : 1.0
* 2015.09.08 최성환 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.pri.scproposal.scproposalmain.vo;

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
 * @author 최성환
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class RsltPropMnDlRecVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<RsltPropMnDlRecVO> models = new ArrayList<RsltPropMnDlRecVO>();
	
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String amdtSeq = null;
	/* Column Info */
	private String prntScrnEvntSeq = null;
	/* Column Info */
	private String scrnEvntSeq = null;
	/* Column Info */
	private String creDt = null;
	/* Page Number */
	private String pagerows = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String scrnOpnGdt = null;
	/* Column Info */
	private String spPrnEvntTpCd = null;
	/* Column Info */
	private String propNo = null;
	/* Column Info */
	private String spScrnEvntPgmCd = null;
	/* Column Info */
	private String scNo = null;
	/* Column Info */
	private String creOfcCd = null;
	/* Column Info */
	private String lginUsrIp = null;
	/* Column Info */
	private String updUsrId = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public RsltPropMnDlRecVO() {}

	public RsltPropMnDlRecVO(String ibflag, String pagerows, String scNo, String scrnEvntSeq, String prntScrnEvntSeq, String propNo, String amdtSeq, String lginUsrIp, String scrnOpnGdt, String spPrnEvntTpCd, String spScrnEvntPgmCd, String creUsrId, String creOfcCd, String creDt, String updUsrId, String updDt) {
		this.updDt = updDt;
		this.amdtSeq = amdtSeq;
		this.prntScrnEvntSeq = prntScrnEvntSeq;
		this.scrnEvntSeq = scrnEvntSeq;
		this.creDt = creDt;
		this.pagerows = pagerows;
		this.ibflag = ibflag;
		this.creUsrId = creUsrId;
		this.scrnOpnGdt = scrnOpnGdt;
		this.spPrnEvntTpCd = spPrnEvntTpCd;
		this.propNo = propNo;
		this.spScrnEvntPgmCd = spScrnEvntPgmCd;
		this.scNo = scNo;
		this.creOfcCd = creOfcCd;
		this.lginUsrIp = lginUsrIp;
		this.updUsrId = updUsrId;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("amdt_seq", getAmdtSeq());
		this.hashColumns.put("prnt_scrn_evnt_seq", getPrntScrnEvntSeq());
		this.hashColumns.put("scrn_evnt_seq", getScrnEvntSeq());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("scrn_opn_gdt", getScrnOpnGdt());
		this.hashColumns.put("sp_prn_evnt_tp_cd", getSpPrnEvntTpCd());
		this.hashColumns.put("prop_no", getPropNo());
		this.hashColumns.put("sp_scrn_evnt_pgm_cd", getSpScrnEvntPgmCd());
		this.hashColumns.put("sc_no", getScNo());
		this.hashColumns.put("cre_ofc_cd", getCreOfcCd());
		this.hashColumns.put("lgin_usr_ip", getLginUsrIp());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("amdt_seq", "amdtSeq");
		this.hashFields.put("prnt_scrn_evnt_seq", "prntScrnEvntSeq");
		this.hashFields.put("scrn_evnt_seq", "scrnEvntSeq");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("scrn_opn_gdt", "scrnOpnGdt");
		this.hashFields.put("sp_prn_evnt_tp_cd", "spPrnEvntTpCd");
		this.hashFields.put("prop_no", "propNo");
		this.hashFields.put("sp_scrn_evnt_pgm_cd", "spScrnEvntPgmCd");
		this.hashFields.put("sc_no", "scNo");
		this.hashFields.put("cre_ofc_cd", "creOfcCd");
		this.hashFields.put("lgin_usr_ip", "lginUsrIp");
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
	 * @return amdtSeq
	 */
	public String getAmdtSeq() {
		return this.amdtSeq;
	}
	
	/**
	 * Column Info
	 * @return prntScrnEvntSeq
	 */
	public String getPrntScrnEvntSeq() {
		return this.prntScrnEvntSeq;
	}
	
	/**
	 * Column Info
	 * @return scrnEvntSeq
	 */
	public String getScrnEvntSeq() {
		return this.scrnEvntSeq;
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
	 * @return scrnOpnGdt
	 */
	public String getScrnOpnGdt() {
		return this.scrnOpnGdt;
	}
	
	/**
	 * Column Info
	 * @return spPrnEvntTpCd
	 */
	public String getSpPrnEvntTpCd() {
		return this.spPrnEvntTpCd;
	}
	
	/**
	 * Column Info
	 * @return propNo
	 */
	public String getPropNo() {
		return this.propNo;
	}
	
	/**
	 * Column Info
	 * @return spScrnEvntPgmCd
	 */
	public String getSpScrnEvntPgmCd() {
		return this.spScrnEvntPgmCd;
	}
	
	/**
	 * Column Info
	 * @return scNo
	 */
	public String getScNo() {
		return this.scNo;
	}
	
	/**
	 * Column Info
	 * @return creOfcCd
	 */
	public String getCreOfcCd() {
		return this.creOfcCd;
	}
	
	/**
	 * Column Info
	 * @return lginUsrIp
	 */
	public String getLginUsrIp() {
		return this.lginUsrIp;
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
	 * @param amdtSeq
	 */
	public void setAmdtSeq(String amdtSeq) {
		this.amdtSeq = amdtSeq;
	}
	
	/**
	 * Column Info
	 * @param prntScrnEvntSeq
	 */
	public void setPrntScrnEvntSeq(String prntScrnEvntSeq) {
		this.prntScrnEvntSeq = prntScrnEvntSeq;
	}
	
	/**
	 * Column Info
	 * @param scrnEvntSeq
	 */
	public void setScrnEvntSeq(String scrnEvntSeq) {
		this.scrnEvntSeq = scrnEvntSeq;
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
	 * @param scrnOpnGdt
	 */
	public void setScrnOpnGdt(String scrnOpnGdt) {
		this.scrnOpnGdt = scrnOpnGdt;
	}
	
	/**
	 * Column Info
	 * @param spPrnEvntTpCd
	 */
	public void setSpPrnEvntTpCd(String spPrnEvntTpCd) {
		this.spPrnEvntTpCd = spPrnEvntTpCd;
	}
	
	/**
	 * Column Info
	 * @param propNo
	 */
	public void setPropNo(String propNo) {
		this.propNo = propNo;
	}
	
	/**
	 * Column Info
	 * @param spScrnEvntPgmCd
	 */
	public void setSpScrnEvntPgmCd(String spScrnEvntPgmCd) {
		this.spScrnEvntPgmCd = spScrnEvntPgmCd;
	}
	
	/**
	 * Column Info
	 * @param scNo
	 */
	public void setScNo(String scNo) {
		this.scNo = scNo;
	}
	
	/**
	 * Column Info
	 * @param creOfcCd
	 */
	public void setCreOfcCd(String creOfcCd) {
		this.creOfcCd = creOfcCd;
	}
	
	/**
	 * Column Info
	 * @param lginUsrIp
	 */
	public void setLginUsrIp(String lginUsrIp) {
		this.lginUsrIp = lginUsrIp;
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
		setAmdtSeq(JSPUtil.getParameter(request, prefix + "amdt_seq", ""));
		setPrntScrnEvntSeq(JSPUtil.getParameter(request, prefix + "prnt_scrn_evnt_seq", ""));
		setScrnEvntSeq(JSPUtil.getParameter(request, prefix + "scrn_evnt_seq", ""));
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setScrnOpnGdt(JSPUtil.getParameter(request, prefix + "scrn_opn_gdt", ""));
		setSpPrnEvntTpCd(JSPUtil.getParameter(request, prefix + "sp_prn_evnt_tp_cd", ""));
		setPropNo(JSPUtil.getParameter(request, prefix + "prop_no", ""));
		setSpScrnEvntPgmCd(JSPUtil.getParameter(request, prefix + "sp_scrn_evnt_pgm_cd", ""));
		setScNo(JSPUtil.getParameter(request, prefix + "sc_no", ""));
		setCreOfcCd(JSPUtil.getParameter(request, prefix + "cre_ofc_cd", ""));
		setLginUsrIp(JSPUtil.getParameter(request, prefix + "lgin_usr_ip", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return RsltPropMnDlRecVO[]
	 */
	public RsltPropMnDlRecVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return RsltPropMnDlRecVO[]
	 */
	public RsltPropMnDlRecVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		RsltPropMnDlRecVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] amdtSeq = (JSPUtil.getParameter(request, prefix	+ "amdt_seq", length));
			String[] prntScrnEvntSeq = (JSPUtil.getParameter(request, prefix	+ "prnt_scrn_evnt_seq", length));
			String[] scrnEvntSeq = (JSPUtil.getParameter(request, prefix	+ "scrn_evnt_seq", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] scrnOpnGdt = (JSPUtil.getParameter(request, prefix	+ "scrn_opn_gdt", length));
			String[] spPrnEvntTpCd = (JSPUtil.getParameter(request, prefix	+ "sp_prn_evnt_tp_cd", length));
			String[] propNo = (JSPUtil.getParameter(request, prefix	+ "prop_no", length));
			String[] spScrnEvntPgmCd = (JSPUtil.getParameter(request, prefix	+ "sp_scrn_evnt_pgm_cd", length));
			String[] scNo = (JSPUtil.getParameter(request, prefix	+ "sc_no", length));
			String[] creOfcCd = (JSPUtil.getParameter(request, prefix	+ "cre_ofc_cd", length));
			String[] lginUsrIp = (JSPUtil.getParameter(request, prefix	+ "lgin_usr_ip", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			
			for (int i = 0; i < length; i++) {
				model = new RsltPropMnDlRecVO();
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (amdtSeq[i] != null)
					model.setAmdtSeq(amdtSeq[i]);
				if (prntScrnEvntSeq[i] != null)
					model.setPrntScrnEvntSeq(prntScrnEvntSeq[i]);
				if (scrnEvntSeq[i] != null)
					model.setScrnEvntSeq(scrnEvntSeq[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (scrnOpnGdt[i] != null)
					model.setScrnOpnGdt(scrnOpnGdt[i]);
				if (spPrnEvntTpCd[i] != null)
					model.setSpPrnEvntTpCd(spPrnEvntTpCd[i]);
				if (propNo[i] != null)
					model.setPropNo(propNo[i]);
				if (spScrnEvntPgmCd[i] != null)
					model.setSpScrnEvntPgmCd(spScrnEvntPgmCd[i]);
				if (scNo[i] != null)
					model.setScNo(scNo[i]);
				if (creOfcCd[i] != null)
					model.setCreOfcCd(creOfcCd[i]);
				if (lginUsrIp[i] != null)
					model.setLginUsrIp(lginUsrIp[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getRsltPropMnDlRecVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return RsltPropMnDlRecVO[]
	 */
	public RsltPropMnDlRecVO[] getRsltPropMnDlRecVOs(){
		RsltPropMnDlRecVO[] vos = (RsltPropMnDlRecVO[])models.toArray(new RsltPropMnDlRecVO[models.size()]);
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
		this.amdtSeq = this.amdtSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prntScrnEvntSeq = this.prntScrnEvntSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scrnEvntSeq = this.scrnEvntSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scrnOpnGdt = this.scrnOpnGdt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.spPrnEvntTpCd = this.spPrnEvntTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.propNo = this.propNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.spScrnEvntPgmCd = this.spScrnEvntPgmCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scNo = this.scNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creOfcCd = this.creOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lginUsrIp = this.lginUsrIp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
