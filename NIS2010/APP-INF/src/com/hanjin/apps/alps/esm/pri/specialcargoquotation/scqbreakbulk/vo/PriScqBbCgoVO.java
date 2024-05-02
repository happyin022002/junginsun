/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : PriScqBbCgoVO.java
*@FileTitle : PriScqBbCgoVO
*Open Issues :
*Change history :
*@LastModifyDate : 2015.04.20
*@LastModifier : 송호진
*@LastVersion : 1.0
* 2015.04.20 송호진 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.pri.specialcargoquotation.scqbreakbulk.vo;

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

public class PriScqBbCgoVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<PriScqBbCgoVO> models = new ArrayList<PriScqBbCgoVO>();
	
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String grsWgt = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String ttlDimWdt = null;
	/* Column Info */
	private String cmdtCd = null;
	/* Column Info */
	private String cmdtNm = null;
	/* Column Info */
	private String grsWgtVw = null;
	/* Column Info */
	private String scqRqstNo = null;
	/* Column Info */
	private String scqVerNo = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String ttlDimWdtVw = null;
	/* Column Info */
	private String ttlDimLen = null;
	/* Column Info */
	private String ttlDimHgt = null;
	/* Column Info */
	private String ttlDimHgtVw = null;
	/* Column Info */
	private String wgtUtCd = null;
	/* Column Info */
	private String cgoSeq = null;
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String ttlDimLenVw = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public PriScqBbCgoVO() {}

	public PriScqBbCgoVO(String ibflag, String pagerows, String scqRqstNo, String scqVerNo, String cgoSeq, String cmdtCd, String ttlDimLen, String ttlDimWdt, String ttlDimHgt, String grsWgt, String ttlDimLenVw, String ttlDimWdtVw, String ttlDimHgtVw, String grsWgtVw, String wgtUtCd, String creUsrId, String creDt, String updUsrId, String updDt, String cmdtNm) {
		this.pagerows = pagerows;
		this.grsWgt = grsWgt;
		this.ibflag = ibflag;
		this.ttlDimWdt = ttlDimWdt;
		this.cmdtCd = cmdtCd;
		this.cmdtNm = cmdtNm;
		this.grsWgtVw = grsWgtVw;
		this.scqRqstNo = scqRqstNo;
		this.scqVerNo = scqVerNo;
		this.updUsrId = updUsrId;
		this.creUsrId = creUsrId;
		this.creDt = creDt;
		this.ttlDimWdtVw = ttlDimWdtVw;
		this.ttlDimLen = ttlDimLen;
		this.ttlDimHgt = ttlDimHgt;
		this.ttlDimHgtVw = ttlDimHgtVw;
		this.wgtUtCd = wgtUtCd;
		this.cgoSeq = cgoSeq;
		this.updDt = updDt;
		this.ttlDimLenVw = ttlDimLenVw;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("grs_wgt", getGrsWgt());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("ttl_dim_wdt", getTtlDimWdt());
		this.hashColumns.put("cmdt_cd", getCmdtCd());
		this.hashColumns.put("cmdt_nm", getCmdtNm());
		this.hashColumns.put("grs_wgt_vw", getGrsWgtVw());
		this.hashColumns.put("scq_rqst_no", getScqRqstNo());
		this.hashColumns.put("scq_ver_no", getScqVerNo());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("ttl_dim_wdt_vw", getTtlDimWdtVw());
		this.hashColumns.put("ttl_dim_len", getTtlDimLen());
		this.hashColumns.put("ttl_dim_hgt", getTtlDimHgt());
		this.hashColumns.put("ttl_dim_hgt_vw", getTtlDimHgtVw());
		this.hashColumns.put("wgt_ut_cd", getWgtUtCd());
		this.hashColumns.put("cgo_seq", getCgoSeq());
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("ttl_dim_len_vw", getTtlDimLenVw());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("grs_wgt", "grsWgt");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("ttl_dim_wdt", "ttlDimWdt");
		this.hashFields.put("cmdt_cd", "cmdtCd");
		this.hashFields.put("cmdt_nm", "cmdtNm");
		this.hashFields.put("grs_wgt_vw", "grsWgtVw");
		this.hashFields.put("scq_rqst_no", "scqRqstNo");
		this.hashFields.put("scq_ver_no", "scqVerNo");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("ttl_dim_wdt_vw", "ttlDimWdtVw");
		this.hashFields.put("ttl_dim_len", "ttlDimLen");
		this.hashFields.put("ttl_dim_hgt", "ttlDimHgt");
		this.hashFields.put("ttl_dim_hgt_vw", "ttlDimHgtVw");
		this.hashFields.put("wgt_ut_cd", "wgtUtCd");
		this.hashFields.put("cgo_seq", "cgoSeq");
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("ttl_dim_len_vw", "ttlDimLenVw");
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
	 * @return grsWgt
	 */
	public String getGrsWgt() {
		return this.grsWgt;
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
	 * @return ttlDimWdt
	 */
	public String getTtlDimWdt() {
		return this.ttlDimWdt;
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
	 * @return cmdtNm
	 */
	public String getCmdtNm() {
		return this.cmdtNm;
	}
	
	/**
	 * Column Info
	 * @return grsWgtVw
	 */
	public String getGrsWgtVw() {
		return this.grsWgtVw;
	}
	
	/**
	 * Column Info
	 * @return scqRqstNo
	 */
	public String getScqRqstNo() {
		return this.scqRqstNo;
	}
	
	/**
	 * Column Info
	 * @return scqVerNo
	 */
	public String getScqVerNo() {
		return this.scqVerNo;
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
	 * @return ttlDimWdtVw
	 */
	public String getTtlDimWdtVw() {
		return this.ttlDimWdtVw;
	}
	
	/**
	 * Column Info
	 * @return ttlDimLen
	 */
	public String getTtlDimLen() {
		return this.ttlDimLen;
	}
	
	/**
	 * Column Info
	 * @return ttlDimHgt
	 */
	public String getTtlDimHgt() {
		return this.ttlDimHgt;
	}
	
	/**
	 * Column Info
	 * @return ttlDimHgtVw
	 */
	public String getTtlDimHgtVw() {
		return this.ttlDimHgtVw;
	}
	
	/**
	 * Column Info
	 * @return wgtUtCd
	 */
	public String getWgtUtCd() {
		return this.wgtUtCd;
	}
	
	/**
	 * Column Info
	 * @return cgoSeq
	 */
	public String getCgoSeq() {
		return this.cgoSeq;
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
	 * @return ttlDimLenVw
	 */
	public String getTtlDimLenVw() {
		return this.ttlDimLenVw;
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
	 * @param grsWgt
	 */
	public void setGrsWgt(String grsWgt) {
		this.grsWgt = grsWgt;
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
	 * @param ttlDimWdt
	 */
	public void setTtlDimWdt(String ttlDimWdt) {
		this.ttlDimWdt = ttlDimWdt;
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
	 * @param cmdtNm
	 */
	public void setCmdtNm(String cmdtNm) {
		this.cmdtNm = cmdtNm;
	}
	
	/**
	 * Column Info
	 * @param grsWgtVw
	 */
	public void setGrsWgtVw(String grsWgtVw) {
		this.grsWgtVw = grsWgtVw;
	}
	
	/**
	 * Column Info
	 * @param scqRqstNo
	 */
	public void setScqRqstNo(String scqRqstNo) {
		this.scqRqstNo = scqRqstNo;
	}
	
	/**
	 * Column Info
	 * @param scqVerNo
	 */
	public void setScqVerNo(String scqVerNo) {
		this.scqVerNo = scqVerNo;
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
	 * @param ttlDimWdtVw
	 */
	public void setTtlDimWdtVw(String ttlDimWdtVw) {
		this.ttlDimWdtVw = ttlDimWdtVw;
	}
	
	/**
	 * Column Info
	 * @param ttlDimLen
	 */
	public void setTtlDimLen(String ttlDimLen) {
		this.ttlDimLen = ttlDimLen;
	}
	
	/**
	 * Column Info
	 * @param ttlDimHgt
	 */
	public void setTtlDimHgt(String ttlDimHgt) {
		this.ttlDimHgt = ttlDimHgt;
	}
	
	/**
	 * Column Info
	 * @param ttlDimHgtVw
	 */
	public void setTtlDimHgtVw(String ttlDimHgtVw) {
		this.ttlDimHgtVw = ttlDimHgtVw;
	}
	
	/**
	 * Column Info
	 * @param wgtUtCd
	 */
	public void setWgtUtCd(String wgtUtCd) {
		this.wgtUtCd = wgtUtCd;
	}
	
	/**
	 * Column Info
	 * @param cgoSeq
	 */
	public void setCgoSeq(String cgoSeq) {
		this.cgoSeq = cgoSeq;
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
	 * @param ttlDimLenVw
	 */
	public void setTtlDimLenVw(String ttlDimLenVw) {
		this.ttlDimLenVw = ttlDimLenVw;
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
		setGrsWgt(JSPUtil.getParameter(request, prefix + "grs_wgt", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setTtlDimWdt(JSPUtil.getParameter(request, prefix + "ttl_dim_wdt", ""));
		setCmdtCd(JSPUtil.getParameter(request, prefix + "cmdt_cd", ""));
		setCmdtNm(JSPUtil.getParameter(request, prefix + "cmdt_nm", ""));
		setGrsWgtVw(JSPUtil.getParameter(request, prefix + "grs_wgt_vw", ""));
		setScqRqstNo(JSPUtil.getParameter(request, prefix + "scq_rqst_no", ""));
		setScqVerNo(JSPUtil.getParameter(request, prefix + "scq_ver_no", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
		setTtlDimWdtVw(JSPUtil.getParameter(request, prefix + "ttl_dim_wdt_vw", ""));
		setTtlDimLen(JSPUtil.getParameter(request, prefix + "ttl_dim_len", ""));
		setTtlDimHgt(JSPUtil.getParameter(request, prefix + "ttl_dim_hgt", ""));
		setTtlDimHgtVw(JSPUtil.getParameter(request, prefix + "ttl_dim_hgt_vw", ""));
		setWgtUtCd(JSPUtil.getParameter(request, prefix + "wgt_ut_cd", ""));
		setCgoSeq(JSPUtil.getParameter(request, prefix + "cgo_seq", ""));
		setUpdDt(JSPUtil.getParameter(request, prefix + "upd_dt", ""));
		setTtlDimLenVw(JSPUtil.getParameter(request, prefix + "ttl_dim_len_vw", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return PriScqBbCgoVO[]
	 */
	public PriScqBbCgoVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return PriScqBbCgoVO[]
	 */
	public PriScqBbCgoVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		PriScqBbCgoVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] grsWgt = (JSPUtil.getParameter(request, prefix	+ "grs_wgt", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] ttlDimWdt = (JSPUtil.getParameter(request, prefix	+ "ttl_dim_wdt", length));
			String[] cmdtCd = (JSPUtil.getParameter(request, prefix	+ "cmdt_cd", length));
			String[] cmdtNm = (JSPUtil.getParameter(request, prefix	+ "cmdt_nm", length));
			String[] grsWgtVw = (JSPUtil.getParameter(request, prefix	+ "grs_wgt_vw", length));
			String[] scqRqstNo = (JSPUtil.getParameter(request, prefix	+ "scq_rqst_no", length));
			String[] scqVerNo = (JSPUtil.getParameter(request, prefix	+ "scq_ver_no", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] ttlDimWdtVw = (JSPUtil.getParameter(request, prefix	+ "ttl_dim_wdt_vw", length));
			String[] ttlDimLen = (JSPUtil.getParameter(request, prefix	+ "ttl_dim_len", length));
			String[] ttlDimHgt = (JSPUtil.getParameter(request, prefix	+ "ttl_dim_hgt", length));
			String[] ttlDimHgtVw = (JSPUtil.getParameter(request, prefix	+ "ttl_dim_hgt_vw", length));
			String[] wgtUtCd = (JSPUtil.getParameter(request, prefix	+ "wgt_ut_cd", length));
			String[] cgoSeq = (JSPUtil.getParameter(request, prefix	+ "cgo_seq", length));
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] ttlDimLenVw = (JSPUtil.getParameter(request, prefix	+ "ttl_dim_len_vw", length));
			
			for (int i = 0; i < length; i++) {
				model = new PriScqBbCgoVO();
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (grsWgt[i] != null)
					model.setGrsWgt(grsWgt[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (ttlDimWdt[i] != null)
					model.setTtlDimWdt(ttlDimWdt[i]);
				if (cmdtCd[i] != null)
					model.setCmdtCd(cmdtCd[i]);
				if (cmdtNm[i] != null)
					model.setCmdtNm(cmdtNm[i]);
				if (grsWgtVw[i] != null)
					model.setGrsWgtVw(grsWgtVw[i]);
				if (scqRqstNo[i] != null)
					model.setScqRqstNo(scqRqstNo[i]);
				if (scqVerNo[i] != null)
					model.setScqVerNo(scqVerNo[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (ttlDimWdtVw[i] != null)
					model.setTtlDimWdtVw(ttlDimWdtVw[i]);
				if (ttlDimLen[i] != null)
					model.setTtlDimLen(ttlDimLen[i]);
				if (ttlDimHgt[i] != null)
					model.setTtlDimHgt(ttlDimHgt[i]);
				if (ttlDimHgtVw[i] != null)
					model.setTtlDimHgtVw(ttlDimHgtVw[i]);
				if (wgtUtCd[i] != null)
					model.setWgtUtCd(wgtUtCd[i]);
				if (cgoSeq[i] != null)
					model.setCgoSeq(cgoSeq[i]);
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (ttlDimLenVw[i] != null)
					model.setTtlDimLenVw(ttlDimLenVw[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getPriScqBbCgoVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return PriScqBbCgoVO[]
	 */
	public PriScqBbCgoVO[] getPriScqBbCgoVOs(){
		PriScqBbCgoVO[] vos = (PriScqBbCgoVO[])models.toArray(new PriScqBbCgoVO[models.size()]);
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
		this.grsWgt = this.grsWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ttlDimWdt = this.ttlDimWdt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmdtCd = this.cmdtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmdtNm = this.cmdtNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.grsWgtVw = this.grsWgtVw .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scqRqstNo = this.scqRqstNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scqVerNo = this.scqVerNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ttlDimWdtVw = this.ttlDimWdtVw .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ttlDimLen = this.ttlDimLen .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ttlDimHgt = this.ttlDimHgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ttlDimHgtVw = this.ttlDimHgtVw .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wgtUtCd = this.wgtUtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cgoSeq = this.cgoSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ttlDimLenVw = this.ttlDimLenVw .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
