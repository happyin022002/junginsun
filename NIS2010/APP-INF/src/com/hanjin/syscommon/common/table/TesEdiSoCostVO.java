/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : TesEdiSoCostVO.java
*@FileTitle : TesEdiSoCostVO
*Open Issues :
*Change history :
*@LastModifyDate : 2012.01.19
*@LastModifier : 
*@LastVersion : 1.0
* 2012.01.19  
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

public class TesEdiSoCostVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<TesEdiSoCostVO> models = new ArrayList<TesEdiSoCostVO>();
	
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String psaChgTpCd = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String psaChgClssN2ndCd = null;
	/* Column Info */
	private String vndrTrfDesc = null;
	/* Page Number */
	private String pagerows = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String psaChgClssN1stCd = null;
	/* Column Info */
	private String ydCd = null;
	/* Column Info */
	private String vndrSeq = null;
	/* Column Info */
	private String lgsCostCd = null;
	/* Column Info */
	private String psaChgCateCd = null;
	/* Column Info */
	private String updUsrId = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public TesEdiSoCostVO() {}

	public TesEdiSoCostVO(String ibflag, String pagerows, String vndrSeq, String vndrTrfDesc, String lgsCostCd, String creUsrId, String creDt, String updUsrId, String updDt, String psaChgCateCd, String psaChgClssN1stCd, String psaChgClssN2ndCd, String psaChgTpCd, String ydCd) {
		this.updDt = updDt;
		this.psaChgTpCd = psaChgTpCd;
		this.creDt = creDt;
		this.psaChgClssN2ndCd = psaChgClssN2ndCd;
		this.vndrTrfDesc = vndrTrfDesc;
		this.pagerows = pagerows;
		this.ibflag = ibflag;
		this.creUsrId = creUsrId;
		this.psaChgClssN1stCd = psaChgClssN1stCd;
		this.ydCd = ydCd;
		this.vndrSeq = vndrSeq;
		this.lgsCostCd = lgsCostCd;
		this.psaChgCateCd = psaChgCateCd;
		this.updUsrId = updUsrId;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("psa_chg_tp_cd", getPsaChgTpCd());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("psa_chg_clss_n2nd_cd", getPsaChgClssN2ndCd());
		this.hashColumns.put("vndr_trf_desc", getVndrTrfDesc());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("psa_chg_clss_n1st_cd", getPsaChgClssN1stCd());
		this.hashColumns.put("yd_cd", getYdCd());
		this.hashColumns.put("vndr_seq", getVndrSeq());
		this.hashColumns.put("lgs_cost_cd", getLgsCostCd());
		this.hashColumns.put("psa_chg_cate_cd", getPsaChgCateCd());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("psa_chg_tp_cd", "psaChgTpCd");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("psa_chg_clss_n2nd_cd", "psaChgClssN2ndCd");
		this.hashFields.put("vndr_trf_desc", "vndrTrfDesc");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("psa_chg_clss_n1st_cd", "psaChgClssN1stCd");
		this.hashFields.put("yd_cd", "ydCd");
		this.hashFields.put("vndr_seq", "vndrSeq");
		this.hashFields.put("lgs_cost_cd", "lgsCostCd");
		this.hashFields.put("psa_chg_cate_cd", "psaChgCateCd");
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
	 * @return psaChgTpCd
	 */
	public String getPsaChgTpCd() {
		return this.psaChgTpCd;
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
	 * @return psaChgClssN2ndCd
	 */
	public String getPsaChgClssN2ndCd() {
		return this.psaChgClssN2ndCd;
	}
	
	/**
	 * Column Info
	 * @return vndrTrfDesc
	 */
	public String getVndrTrfDesc() {
		return this.vndrTrfDesc;
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
	 * @return psaChgClssN1stCd
	 */
	public String getPsaChgClssN1stCd() {
		return this.psaChgClssN1stCd;
	}
	
	/**
	 * Column Info
	 * @return ydCd
	 */
	public String getYdCd() {
		return this.ydCd;
	}
	
	/**
	 * Column Info
	 * @return vndrSeq
	 */
	public String getVndrSeq() {
		return this.vndrSeq;
	}
	
	/**
	 * Column Info
	 * @return lgsCostCd
	 */
	public String getLgsCostCd() {
		return this.lgsCostCd;
	}
	
	/**
	 * Column Info
	 * @return psaChgCateCd
	 */
	public String getPsaChgCateCd() {
		return this.psaChgCateCd;
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
	 * @param psaChgTpCd
	 */
	public void setPsaChgTpCd(String psaChgTpCd) {
		this.psaChgTpCd = psaChgTpCd;
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
	 * @param psaChgClssN2ndCd
	 */
	public void setPsaChgClssN2ndCd(String psaChgClssN2ndCd) {
		this.psaChgClssN2ndCd = psaChgClssN2ndCd;
	}
	
	/**
	 * Column Info
	 * @param vndrTrfDesc
	 */
	public void setVndrTrfDesc(String vndrTrfDesc) {
		this.vndrTrfDesc = vndrTrfDesc;
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
	 * @param psaChgClssN1stCd
	 */
	public void setPsaChgClssN1stCd(String psaChgClssN1stCd) {
		this.psaChgClssN1stCd = psaChgClssN1stCd;
	}
	
	/**
	 * Column Info
	 * @param ydCd
	 */
	public void setYdCd(String ydCd) {
		this.ydCd = ydCd;
	}
	
	/**
	 * Column Info
	 * @param vndrSeq
	 */
	public void setVndrSeq(String vndrSeq) {
		this.vndrSeq = vndrSeq;
	}
	
	/**
	 * Column Info
	 * @param lgsCostCd
	 */
	public void setLgsCostCd(String lgsCostCd) {
		this.lgsCostCd = lgsCostCd;
	}
	
	/**
	 * Column Info
	 * @param psaChgCateCd
	 */
	public void setPsaChgCateCd(String psaChgCateCd) {
		this.psaChgCateCd = psaChgCateCd;
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
		setPsaChgTpCd(JSPUtil.getParameter(request, prefix + "psa_chg_tp_cd", ""));
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
		setPsaChgClssN2ndCd(JSPUtil.getParameter(request, prefix + "psa_chg_clss_n2nd_cd", ""));
		setVndrTrfDesc(JSPUtil.getParameter(request, prefix + "vndr_trf_desc", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setPsaChgClssN1stCd(JSPUtil.getParameter(request, prefix + "psa_chg_clss_n1st_cd", ""));
		setYdCd(JSPUtil.getParameter(request, prefix + "yd_cd", ""));
		setVndrSeq(JSPUtil.getParameter(request, prefix + "vndr_seq", ""));
		setLgsCostCd(JSPUtil.getParameter(request, prefix + "lgs_cost_cd", ""));
		setPsaChgCateCd(JSPUtil.getParameter(request, prefix + "psa_chg_cate_cd", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return TesEdiSoCostVO[]
	 */
	public TesEdiSoCostVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return TesEdiSoCostVO[]
	 */
	public TesEdiSoCostVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		TesEdiSoCostVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] psaChgTpCd = (JSPUtil.getParameter(request, prefix	+ "psa_chg_tp_cd", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] psaChgClssN2ndCd = (JSPUtil.getParameter(request, prefix	+ "psa_chg_clss_n2nd_cd", length));
			String[] vndrTrfDesc = (JSPUtil.getParameter(request, prefix	+ "vndr_trf_desc", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] psaChgClssN1stCd = (JSPUtil.getParameter(request, prefix	+ "psa_chg_clss_n1st_cd", length));
			String[] ydCd = (JSPUtil.getParameter(request, prefix	+ "yd_cd", length));
			String[] vndrSeq = (JSPUtil.getParameter(request, prefix	+ "vndr_seq", length));
			String[] lgsCostCd = (JSPUtil.getParameter(request, prefix	+ "lgs_cost_cd", length));
			String[] psaChgCateCd = (JSPUtil.getParameter(request, prefix	+ "psa_chg_cate_cd", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			
			for (int i = 0; i < length; i++) {
				model = new TesEdiSoCostVO();
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (psaChgTpCd[i] != null)
					model.setPsaChgTpCd(psaChgTpCd[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (psaChgClssN2ndCd[i] != null)
					model.setPsaChgClssN2ndCd(psaChgClssN2ndCd[i]);
				if (vndrTrfDesc[i] != null)
					model.setVndrTrfDesc(vndrTrfDesc[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (psaChgClssN1stCd[i] != null)
					model.setPsaChgClssN1stCd(psaChgClssN1stCd[i]);
				if (ydCd[i] != null)
					model.setYdCd(ydCd[i]);
				if (vndrSeq[i] != null)
					model.setVndrSeq(vndrSeq[i]);
				if (lgsCostCd[i] != null)
					model.setLgsCostCd(lgsCostCd[i]);
				if (psaChgCateCd[i] != null)
					model.setPsaChgCateCd(psaChgCateCd[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getTesEdiSoCostVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return TesEdiSoCostVO[]
	 */
	public TesEdiSoCostVO[] getTesEdiSoCostVOs(){
		TesEdiSoCostVO[] vos = (TesEdiSoCostVO[])models.toArray(new TesEdiSoCostVO[models.size()]);
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
		this.psaChgTpCd = this.psaChgTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.psaChgClssN2ndCd = this.psaChgClssN2ndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrTrfDesc = this.vndrTrfDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.psaChgClssN1stCd = this.psaChgClssN1stCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ydCd = this.ydCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrSeq = this.vndrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lgsCostCd = this.lgsCostCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.psaChgCateCd = this.psaChgCateCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
