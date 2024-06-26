/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : SpeRltAtrcRsltAddVO.java
*@FileTitle : SpeRltAtrcRsltAddVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.01
*@LastModifier : 남궁진호
*@LastVersion : 1.0
* 2010.02.01 남궁진호 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esd.spe.serviceproviderresultmanage.serviceproviderrelationshipattractivenessresult.vo;

import java.lang.reflect.Field;
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
 * @author 남궁진호
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

@SuppressWarnings("unused")
public class SpeRltAtrcRsltAddVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SpeRltAtrcRsltAddVO> models = new ArrayList<SpeRltAtrcRsltAddVO>();
	
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String raGrpCd = null;
	/* Column Info */
	private String creDt = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String raScre = null;
	/* Column Info */
	private String raGrpNm = null;
	/* Column Info */
	private String atrcToHjsScre = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String egIdSeq = null;
	/* Column Info */
	private String vndrSeq = null;
	/* Column Info */
	private String egId = null;
	/* Column Info */
	private String evYr = null;
	/* Column Info */
	private String atrcToSpScre = null;
	/* Column Info */
	private String updUsrId = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SpeRltAtrcRsltAddVO() {}

	public SpeRltAtrcRsltAddVO(String ibflag, String pagerows, String vndrSeq, String evYr, String atrcToHjsScre, String atrcToSpScre, String raScre, String raGrpCd, String raGrpNm, String creUsrId, String creDt, String updUsrId, String updDt, String egId, String egIdSeq) {
		this.updDt = updDt;
		this.raGrpCd = raGrpCd;
		this.creDt = creDt;
		this.pagerows = pagerows;
		this.raScre = raScre;
		this.raGrpNm = raGrpNm;
		this.atrcToHjsScre = atrcToHjsScre;
		this.ibflag = ibflag;
		this.creUsrId = creUsrId;
		this.egIdSeq = egIdSeq;
		this.vndrSeq = vndrSeq;
		this.egId = egId;
		this.evYr = evYr;
		this.atrcToSpScre = atrcToSpScre;
		this.updUsrId = updUsrId;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("ra_grp_cd", getRaGrpCd());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ra_scre", getRaScre());
		this.hashColumns.put("ra_grp_nm", getRaGrpNm());
		this.hashColumns.put("atrc_to_hjs_scre", getAtrcToHjsScre());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("eg_id_seq", getEgIdSeq());
		this.hashColumns.put("vndr_seq", getVndrSeq());
		this.hashColumns.put("eg_id", getEgId());
		this.hashColumns.put("ev_yr", getEvYr());
		this.hashColumns.put("atrc_to_sp_scre", getAtrcToSpScre());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("ra_grp_cd", "raGrpCd");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ra_scre", "raScre");
		this.hashFields.put("ra_grp_nm", "raGrpNm");
		this.hashFields.put("atrc_to_hjs_scre", "atrcToHjsScre");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("eg_id_seq", "egIdSeq");
		this.hashFields.put("vndr_seq", "vndrSeq");
		this.hashFields.put("eg_id", "egId");
		this.hashFields.put("ev_yr", "evYr");
		this.hashFields.put("atrc_to_sp_scre", "atrcToSpScre");
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
	 * @return raGrpCd
	 */
	public String getRaGrpCd() {
		return this.raGrpCd;
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
	 * @return raScre
	 */
	public String getRaScre() {
		return this.raScre;
	}
	
	/**
	 * Column Info
	 * @return raGrpNm
	 */
	public String getRaGrpNm() {
		return this.raGrpNm;
	}
	
	/**
	 * Column Info
	 * @return atrcToHjsScre
	 */
	public String getAtrcToHjsScre() {
		return this.atrcToHjsScre;
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
	 * @return egIdSeq
	 */
	public String getEgIdSeq() {
		return this.egIdSeq;
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
	 * @return egId
	 */
	public String getEgId() {
		return this.egId;
	}
	
	/**
	 * Column Info
	 * @return evYr
	 */
	public String getEvYr() {
		return this.evYr;
	}
	
	/**
	 * Column Info
	 * @return atrcToSpScre
	 */
	public String getAtrcToSpScre() {
		return this.atrcToSpScre;
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
	 * @param raGrpCd
	 */
	public void setRaGrpCd(String raGrpCd) {
		this.raGrpCd = raGrpCd;
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
	 * @param raScre
	 */
	public void setRaScre(String raScre) {
		this.raScre = raScre;
	}
	
	/**
	 * Column Info
	 * @param raGrpNm
	 */
	public void setRaGrpNm(String raGrpNm) {
		this.raGrpNm = raGrpNm;
	}
	
	/**
	 * Column Info
	 * @param atrcToHjsScre
	 */
	public void setAtrcToHjsScre(String atrcToHjsScre) {
		this.atrcToHjsScre = atrcToHjsScre;
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
	 * @param egIdSeq
	 */
	public void setEgIdSeq(String egIdSeq) {
		this.egIdSeq = egIdSeq;
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
	 * @param egId
	 */
	public void setEgId(String egId) {
		this.egId = egId;
	}
	
	/**
	 * Column Info
	 * @param evYr
	 */
	public void setEvYr(String evYr) {
		this.evYr = evYr;
	}
	
	/**
	 * Column Info
	 * @param atrcToSpScre
	 */
	public void setAtrcToSpScre(String atrcToSpScre) {
		this.atrcToSpScre = atrcToSpScre;
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
		setRaGrpCd(JSPUtil.getParameter(request, prefix + "ra_grp_cd", ""));
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setRaScre(JSPUtil.getParameter(request, prefix + "ra_scre", ""));
		setRaGrpNm(JSPUtil.getParameter(request, prefix + "ra_grp_nm", ""));
		setAtrcToHjsScre(JSPUtil.getParameter(request, prefix + "atrc_to_hjs_scre", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setEgIdSeq(JSPUtil.getParameter(request, prefix + "eg_id_seq", ""));
		setVndrSeq(JSPUtil.getParameter(request, prefix + "vndr_seq", ""));
		setEgId(JSPUtil.getParameter(request, prefix + "eg_id", ""));
		setEvYr(JSPUtil.getParameter(request, prefix + "ev_yr", ""));
		setAtrcToSpScre(JSPUtil.getParameter(request, prefix + "atrc_to_sp_scre", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SpeRltAtrcRsltAddVO[]
	 */
	public SpeRltAtrcRsltAddVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SpeRltAtrcRsltAddVO[]
	 */
	public SpeRltAtrcRsltAddVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SpeRltAtrcRsltAddVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] raGrpCd = (JSPUtil.getParameter(request, prefix	+ "ra_grp_cd", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] raScre = (JSPUtil.getParameter(request, prefix	+ "ra_scre", length));
			String[] raGrpNm = (JSPUtil.getParameter(request, prefix	+ "ra_grp_nm", length));
			String[] atrcToHjsScre = (JSPUtil.getParameter(request, prefix	+ "atrc_to_hjs_scre", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] egIdSeq = (JSPUtil.getParameter(request, prefix	+ "eg_id_seq", length));
			String[] vndrSeq = (JSPUtil.getParameter(request, prefix	+ "vndr_seq", length));
			String[] egId = (JSPUtil.getParameter(request, prefix	+ "eg_id", length));
			String[] evYr = (JSPUtil.getParameter(request, prefix	+ "ev_yr", length));
			String[] atrcToSpScre = (JSPUtil.getParameter(request, prefix	+ "atrc_to_sp_scre", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			
			for (int i = 0; i < length; i++) {
				model = new SpeRltAtrcRsltAddVO();
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (raGrpCd[i] != null)
					model.setRaGrpCd(raGrpCd[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (raScre[i] != null)
					model.setRaScre(raScre[i]);
				if (raGrpNm[i] != null)
					model.setRaGrpNm(raGrpNm[i]);
				if (atrcToHjsScre[i] != null)
					model.setAtrcToHjsScre(atrcToHjsScre[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (egIdSeq[i] != null)
					model.setEgIdSeq(egIdSeq[i]);
				if (vndrSeq[i] != null)
					model.setVndrSeq(vndrSeq[i]);
				if (egId[i] != null)
					model.setEgId(egId[i]);
				if (evYr[i] != null)
					model.setEvYr(evYr[i]);
				if (atrcToSpScre[i] != null)
					model.setAtrcToSpScre(atrcToSpScre[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSpeRltAtrcRsltAddVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SpeRltAtrcRsltAddVO[]
	 */
	public SpeRltAtrcRsltAddVO[] getSpeRltAtrcRsltAddVOs(){
		SpeRltAtrcRsltAddVO[] vos = (SpeRltAtrcRsltAddVO[])models.toArray(new SpeRltAtrcRsltAddVO[models.size()]);
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
		this.raGrpCd = this.raGrpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.raScre = this.raScre .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.raGrpNm = this.raGrpNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.atrcToHjsScre = this.atrcToHjsScre .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.egIdSeq = this.egIdSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrSeq = this.vndrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.egId = this.egId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.evYr = this.evYr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.atrcToSpScre = this.atrcToSpScre .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
