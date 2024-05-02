/*=========================================================
*Copyright(c) 2017 Hipluscard
*@FileName : PriSpInqRecVO.java
*@FileTitle : PriSpInqRecVO
*Open Issues :
*Change history :
*@LastModifyDate : 2017.12.27
*@LastModifier : 송민석
*@LastVersion : 1.0
* 2017.12.27 송민석 
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
 * @author 송민석
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class PriSpInqRecVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<PriSpInqRecVO> models = new ArrayList<PriSpInqRecVO>();
	
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String scrnOpnGdt = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String lginUsrIp = null;
	/* Column Info */
	private String creOfcCd = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String amdtSeq = null;
	/* Column Info */
	private String spScrnEvntPgmCd = null;
	/* Column Info */
	private String scrnEvntSeq = null;
	/* Column Info */
	private String prntScrnEvntSeq = null;
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String propNo = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public PriSpInqRecVO() {}

	public PriSpInqRecVO(String ibflag, String pagerows, String scrnEvntSeq, String propNo, String amdtSeq, String lginUsrIp, String scrnOpnGdt, String spScrnEvntPgmCd, String creUsrId, String creOfcCd, String creDt, String updUsrId, String updDt, String prntScrnEvntSeq) {
		this.pagerows = pagerows;
		this.scrnOpnGdt = scrnOpnGdt;
		this.ibflag = ibflag;
		this.lginUsrIp = lginUsrIp;
		this.creOfcCd = creOfcCd;
		this.updUsrId = updUsrId;
		this.creUsrId = creUsrId;
		this.creDt = creDt;
		this.amdtSeq = amdtSeq;
		this.spScrnEvntPgmCd = spScrnEvntPgmCd;
		this.scrnEvntSeq = scrnEvntSeq;
		this.prntScrnEvntSeq = prntScrnEvntSeq;
		this.updDt = updDt;
		this.propNo = propNo;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("scrn_opn_gdt", getScrnOpnGdt());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("lgin_usr_ip", getLginUsrIp());
		this.hashColumns.put("cre_ofc_cd", getCreOfcCd());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("amdt_seq", getAmdtSeq());
		this.hashColumns.put("sp_scrn_evnt_pgm_cd", getSpScrnEvntPgmCd());
		this.hashColumns.put("scrn_evnt_seq", getScrnEvntSeq());
		this.hashColumns.put("prnt_scrn_evnt_seq", getPrntScrnEvntSeq());
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("prop_no", getPropNo());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("scrn_opn_gdt", "scrnOpnGdt");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("lgin_usr_ip", "lginUsrIp");
		this.hashFields.put("cre_ofc_cd", "creOfcCd");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("amdt_seq", "amdtSeq");
		this.hashFields.put("sp_scrn_evnt_pgm_cd", "spScrnEvntPgmCd");
		this.hashFields.put("scrn_evnt_seq", "scrnEvntSeq");
		this.hashFields.put("prnt_scrn_evnt_seq", "prntScrnEvntSeq");
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("prop_no", "propNo");
		return this.hashFields;
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
	 * @return scrnOpnGdt
	 */
	public String getScrnOpnGdt() {
		return this.scrnOpnGdt;
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
	 * @return lginUsrIp
	 */
	public String getLginUsrIp() {
		return this.lginUsrIp;
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
	 * @return updUsrId
	 */
	public String getUpdUsrId() {
		return this.updUsrId;
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
	 * @return creDt
	 */
	public String getCreDt() {
		return this.creDt;
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
	 * @return spScrnEvntPgmCd
	 */
	public String getSpScrnEvntPgmCd() {
		return this.spScrnEvntPgmCd;
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
	 * @return prntScrnEvntSeq
	 */
	public String getPrntScrnEvntSeq() {
		return this.prntScrnEvntSeq;
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
	 * @return propNo
	 */
	public String getPropNo() {
		return this.propNo;
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
	 * @param scrnOpnGdt
	 */
	public void setScrnOpnGdt(String scrnOpnGdt) {
		this.scrnOpnGdt = scrnOpnGdt;
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
	 * @param lginUsrIp
	 */
	public void setLginUsrIp(String lginUsrIp) {
		this.lginUsrIp = lginUsrIp;
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
	 * @param updUsrId
	 */
	public void setUpdUsrId(String updUsrId) {
		this.updUsrId = updUsrId;
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
	 * @param creDt
	 */
	public void setCreDt(String creDt) {
		this.creDt = creDt;
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
	 * @param spScrnEvntPgmCd
	 */
	public void setSpScrnEvntPgmCd(String spScrnEvntPgmCd) {
		this.spScrnEvntPgmCd = spScrnEvntPgmCd;
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
	 * @param prntScrnEvntSeq
	 */
	public void setPrntScrnEvntSeq(String prntScrnEvntSeq) {
		this.prntScrnEvntSeq = prntScrnEvntSeq;
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
	 * @param propNo
	 */
	public void setPropNo(String propNo) {
		this.propNo = propNo;
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
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setScrnOpnGdt(JSPUtil.getParameter(request, prefix + "scrn_opn_gdt", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setLginUsrIp(JSPUtil.getParameter(request, prefix + "lgin_usr_ip", ""));
		setCreOfcCd(JSPUtil.getParameter(request, prefix + "cre_ofc_cd", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
		setAmdtSeq(JSPUtil.getParameter(request, prefix + "amdt_seq", ""));
		setSpScrnEvntPgmCd(JSPUtil.getParameter(request, prefix + "sp_scrn_evnt_pgm_cd", ""));
		setScrnEvntSeq(JSPUtil.getParameter(request, prefix + "scrn_evnt_seq", ""));
		setPrntScrnEvntSeq(JSPUtil.getParameter(request, prefix + "prnt_scrn_evnt_seq", ""));
		setUpdDt(JSPUtil.getParameter(request, prefix + "upd_dt", ""));
		setPropNo(JSPUtil.getParameter(request, prefix + "prop_no", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return PriSpInqRecVO[]
	 */
	public PriSpInqRecVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return PriSpInqRecVO[]
	 */
	public PriSpInqRecVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		PriSpInqRecVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] scrnOpnGdt = (JSPUtil.getParameter(request, prefix	+ "scrn_opn_gdt", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] lginUsrIp = (JSPUtil.getParameter(request, prefix	+ "lgin_usr_ip", length));
			String[] creOfcCd = (JSPUtil.getParameter(request, prefix	+ "cre_ofc_cd", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] amdtSeq = (JSPUtil.getParameter(request, prefix	+ "amdt_seq", length));
			String[] spScrnEvntPgmCd = (JSPUtil.getParameter(request, prefix	+ "sp_scrn_evnt_pgm_cd", length));
			String[] scrnEvntSeq = (JSPUtil.getParameter(request, prefix	+ "scrn_evnt_seq", length));
			String[] prntScrnEvntSeq = (JSPUtil.getParameter(request, prefix	+ "prnt_scrn_evnt_seq", length));
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] propNo = (JSPUtil.getParameter(request, prefix	+ "prop_no", length));
			
			for (int i = 0; i < length; i++) {
				model = new PriSpInqRecVO();
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (scrnOpnGdt[i] != null)
					model.setScrnOpnGdt(scrnOpnGdt[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (lginUsrIp[i] != null)
					model.setLginUsrIp(lginUsrIp[i]);
				if (creOfcCd[i] != null)
					model.setCreOfcCd(creOfcCd[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (amdtSeq[i] != null)
					model.setAmdtSeq(amdtSeq[i]);
				if (spScrnEvntPgmCd[i] != null)
					model.setSpScrnEvntPgmCd(spScrnEvntPgmCd[i]);
				if (scrnEvntSeq[i] != null)
					model.setScrnEvntSeq(scrnEvntSeq[i]);
				if (prntScrnEvntSeq[i] != null)
					model.setPrntScrnEvntSeq(prntScrnEvntSeq[i]);
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (propNo[i] != null)
					model.setPropNo(propNo[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getPriSpInqRecVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return PriSpInqRecVO[]
	 */
	public PriSpInqRecVO[] getPriSpInqRecVOs(){
		PriSpInqRecVO[] vos = (PriSpInqRecVO[])models.toArray(new PriSpInqRecVO[models.size()]);
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
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scrnOpnGdt = this.scrnOpnGdt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lginUsrIp = this.lginUsrIp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creOfcCd = this.creOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.amdtSeq = this.amdtSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.spScrnEvntPgmCd = this.spScrnEvntPgmCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scrnEvntSeq = this.scrnEvntSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prntScrnEvntSeq = this.prntScrnEvntSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.propNo = this.propNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
