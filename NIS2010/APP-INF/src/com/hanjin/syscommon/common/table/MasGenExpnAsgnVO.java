/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : MasGenExpnAsgnVO.java
*@FileTitle : MasGenExpnAsgnVO
*Open Issues :
*Change history :
*@LastModifyDate : 2017.08.04
*@LastModifier : 
*@LastVersion : 1.0
* 2017.08.04  
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
 * @author 
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class MasGenExpnAsgnVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<MasGenExpnAsgnVO> models = new ArrayList<MasGenExpnAsgnVO>();
	
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String hoQtaRto = null;
	/* Column Info */
	private String ofcCd = null;
	/* Column Info */
	private String rlaneCd = null;
	/* Column Info */
	private String skdVoyNo = null;
	/* Column Info */
	private String expnTtl = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String vslCd = null;
	/* Column Info */
	private String iocCd = null;
	/* Column Info */
	private String ownExpnAmt = null;
	/* Column Info */
	private String adjExpnTtl = null;
	/* Column Info */
	private String lodQta = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String trdCd = null;
	/* Column Info */
	private String hoExpnAmt = null;
	/* Column Info */
	private String ownQtaRto = null;
	/* Column Info */
	private String dirCd = null;
	/* Column Info */
	private String updDt = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public MasGenExpnAsgnVO() {}

	public MasGenExpnAsgnVO(String ibflag, String pagerows, String trdCd, String rlaneCd, String iocCd, String vslCd, String skdVoyNo, String dirCd, String ofcCd, String lodQta, String hoExpnAmt, String ownExpnAmt, String hoQtaRto, String ownQtaRto, String expnTtl, String creUsrId, String creDt, String updUsrId, String updDt, String adjExpnTtl) {
		this.pagerows = pagerows;
		this.hoQtaRto = hoQtaRto;
		this.ofcCd = ofcCd;
		this.rlaneCd = rlaneCd;
		this.skdVoyNo = skdVoyNo;
		this.expnTtl = expnTtl;
		this.ibflag = ibflag;
		this.vslCd = vslCd;
		this.iocCd = iocCd;
		this.ownExpnAmt = ownExpnAmt;
		this.adjExpnTtl = adjExpnTtl;
		this.lodQta = lodQta;
		this.updUsrId = updUsrId;
		this.creUsrId = creUsrId;
		this.creDt = creDt;
		this.trdCd = trdCd;
		this.hoExpnAmt = hoExpnAmt;
		this.ownQtaRto = ownQtaRto;
		this.dirCd = dirCd;
		this.updDt = updDt;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ho_qta_rto", getHoQtaRto());
		this.hashColumns.put("ofc_cd", getOfcCd());
		this.hashColumns.put("rlane_cd", getRlaneCd());
		this.hashColumns.put("skd_voy_no", getSkdVoyNo());
		this.hashColumns.put("expn_ttl", getExpnTtl());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("vsl_cd", getVslCd());
		this.hashColumns.put("ioc_cd", getIocCd());
		this.hashColumns.put("own_expn_amt", getOwnExpnAmt());
		this.hashColumns.put("adj_expn_ttl", getAdjExpnTtl());
		this.hashColumns.put("lod_qta", getLodQta());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("trd_cd", getTrdCd());
		this.hashColumns.put("ho_expn_amt", getHoExpnAmt());
		this.hashColumns.put("own_qta_rto", getOwnQtaRto());
		this.hashColumns.put("dir_cd", getDirCd());
		this.hashColumns.put("upd_dt", getUpdDt());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ho_qta_rto", "hoQtaRto");
		this.hashFields.put("ofc_cd", "ofcCd");
		this.hashFields.put("rlane_cd", "rlaneCd");
		this.hashFields.put("skd_voy_no", "skdVoyNo");
		this.hashFields.put("expn_ttl", "expnTtl");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("vsl_cd", "vslCd");
		this.hashFields.put("ioc_cd", "iocCd");
		this.hashFields.put("own_expn_amt", "ownExpnAmt");
		this.hashFields.put("adj_expn_ttl", "adjExpnTtl");
		this.hashFields.put("lod_qta", "lodQta");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("trd_cd", "trdCd");
		this.hashFields.put("ho_expn_amt", "hoExpnAmt");
		this.hashFields.put("own_qta_rto", "ownQtaRto");
		this.hashFields.put("dir_cd", "dirCd");
		this.hashFields.put("upd_dt", "updDt");
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
	 * @return hoQtaRto
	 */
	public String getHoQtaRto() {
		return this.hoQtaRto;
	}
	
	/**
	 * Column Info
	 * @return ofcCd
	 */
	public String getOfcCd() {
		return this.ofcCd;
	}
	
	/**
	 * Column Info
	 * @return rlaneCd
	 */
	public String getRlaneCd() {
		return this.rlaneCd;
	}
	
	/**
	 * Column Info
	 * @return skdVoyNo
	 */
	public String getSkdVoyNo() {
		return this.skdVoyNo;
	}
	
	/**
	 * Column Info
	 * @return expnTtl
	 */
	public String getExpnTtl() {
		return this.expnTtl;
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
	 * @return vslCd
	 */
	public String getVslCd() {
		return this.vslCd;
	}
	
	/**
	 * Column Info
	 * @return iocCd
	 */
	public String getIocCd() {
		return this.iocCd;
	}
	
	/**
	 * Column Info
	 * @return ownExpnAmt
	 */
	public String getOwnExpnAmt() {
		return this.ownExpnAmt;
	}
	
	/**
	 * Column Info
	 * @return adjExpnTtl
	 */
	public String getAdjExpnTtl() {
		return this.adjExpnTtl;
	}
	
	/**
	 * Column Info
	 * @return lodQta
	 */
	public String getLodQta() {
		return this.lodQta;
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
	 * @return trdCd
	 */
	public String getTrdCd() {
		return this.trdCd;
	}
	
	/**
	 * Column Info
	 * @return hoExpnAmt
	 */
	public String getHoExpnAmt() {
		return this.hoExpnAmt;
	}
	
	/**
	 * Column Info
	 * @return ownQtaRto
	 */
	public String getOwnQtaRto() {
		return this.ownQtaRto;
	}
	
	/**
	 * Column Info
	 * @return dirCd
	 */
	public String getDirCd() {
		return this.dirCd;
	}
	
	/**
	 * Column Info
	 * @return updDt
	 */
	public String getUpdDt() {
		return this.updDt;
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
	 * @param hoQtaRto
	 */
	public void setHoQtaRto(String hoQtaRto) {
		this.hoQtaRto = hoQtaRto;
	}
	
	/**
	 * Column Info
	 * @param ofcCd
	 */
	public void setOfcCd(String ofcCd) {
		this.ofcCd = ofcCd;
	}
	
	/**
	 * Column Info
	 * @param rlaneCd
	 */
	public void setRlaneCd(String rlaneCd) {
		this.rlaneCd = rlaneCd;
	}
	
	/**
	 * Column Info
	 * @param skdVoyNo
	 */
	public void setSkdVoyNo(String skdVoyNo) {
		this.skdVoyNo = skdVoyNo;
	}
	
	/**
	 * Column Info
	 * @param expnTtl
	 */
	public void setExpnTtl(String expnTtl) {
		this.expnTtl = expnTtl;
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
	 * @param vslCd
	 */
	public void setVslCd(String vslCd) {
		this.vslCd = vslCd;
	}
	
	/**
	 * Column Info
	 * @param iocCd
	 */
	public void setIocCd(String iocCd) {
		this.iocCd = iocCd;
	}
	
	/**
	 * Column Info
	 * @param ownExpnAmt
	 */
	public void setOwnExpnAmt(String ownExpnAmt) {
		this.ownExpnAmt = ownExpnAmt;
	}
	
	/**
	 * Column Info
	 * @param adjExpnTtl
	 */
	public void setAdjExpnTtl(String adjExpnTtl) {
		this.adjExpnTtl = adjExpnTtl;
	}
	
	/**
	 * Column Info
	 * @param lodQta
	 */
	public void setLodQta(String lodQta) {
		this.lodQta = lodQta;
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
	 * @param trdCd
	 */
	public void setTrdCd(String trdCd) {
		this.trdCd = trdCd;
	}
	
	/**
	 * Column Info
	 * @param hoExpnAmt
	 */
	public void setHoExpnAmt(String hoExpnAmt) {
		this.hoExpnAmt = hoExpnAmt;
	}
	
	/**
	 * Column Info
	 * @param ownQtaRto
	 */
	public void setOwnQtaRto(String ownQtaRto) {
		this.ownQtaRto = ownQtaRto;
	}
	
	/**
	 * Column Info
	 * @param dirCd
	 */
	public void setDirCd(String dirCd) {
		this.dirCd = dirCd;
	}
	
	/**
	 * Column Info
	 * @param updDt
	 */
	public void setUpdDt(String updDt) {
		this.updDt = updDt;
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
		setHoQtaRto(JSPUtil.getParameter(request, prefix + "ho_qta_rto", ""));
		setOfcCd(JSPUtil.getParameter(request, prefix + "ofc_cd", ""));
		setRlaneCd(JSPUtil.getParameter(request, prefix + "rlane_cd", ""));
		setSkdVoyNo(JSPUtil.getParameter(request, prefix + "skd_voy_no", ""));
		setExpnTtl(JSPUtil.getParameter(request, prefix + "expn_ttl", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setVslCd(JSPUtil.getParameter(request, prefix + "vsl_cd", ""));
		setIocCd(JSPUtil.getParameter(request, prefix + "ioc_cd", ""));
		setOwnExpnAmt(JSPUtil.getParameter(request, prefix + "own_expn_amt", ""));
		setAdjExpnTtl(JSPUtil.getParameter(request, prefix + "adj_expn_ttl", ""));
		setLodQta(JSPUtil.getParameter(request, prefix + "lod_qta", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
		setTrdCd(JSPUtil.getParameter(request, prefix + "trd_cd", ""));
		setHoExpnAmt(JSPUtil.getParameter(request, prefix + "ho_expn_amt", ""));
		setOwnQtaRto(JSPUtil.getParameter(request, prefix + "own_qta_rto", ""));
		setDirCd(JSPUtil.getParameter(request, prefix + "dir_cd", ""));
		setUpdDt(JSPUtil.getParameter(request, prefix + "upd_dt", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return MasGenExpnAsgnVO[]
	 */
	public MasGenExpnAsgnVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return MasGenExpnAsgnVO[]
	 */
	public MasGenExpnAsgnVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		MasGenExpnAsgnVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] hoQtaRto = (JSPUtil.getParameter(request, prefix	+ "ho_qta_rto", length));
			String[] ofcCd = (JSPUtil.getParameter(request, prefix	+ "ofc_cd", length));
			String[] rlaneCd = (JSPUtil.getParameter(request, prefix	+ "rlane_cd", length));
			String[] skdVoyNo = (JSPUtil.getParameter(request, prefix	+ "skd_voy_no", length));
			String[] expnTtl = (JSPUtil.getParameter(request, prefix	+ "expn_ttl", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] vslCd = (JSPUtil.getParameter(request, prefix	+ "vsl_cd", length));
			String[] iocCd = (JSPUtil.getParameter(request, prefix	+ "ioc_cd", length));
			String[] ownExpnAmt = (JSPUtil.getParameter(request, prefix	+ "own_expn_amt", length));
			String[] adjExpnTtl = (JSPUtil.getParameter(request, prefix	+ "adj_expn_ttl", length));
			String[] lodQta = (JSPUtil.getParameter(request, prefix	+ "lod_qta", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] trdCd = (JSPUtil.getParameter(request, prefix	+ "trd_cd", length));
			String[] hoExpnAmt = (JSPUtil.getParameter(request, prefix	+ "ho_expn_amt", length));
			String[] ownQtaRto = (JSPUtil.getParameter(request, prefix	+ "own_qta_rto", length));
			String[] dirCd = (JSPUtil.getParameter(request, prefix	+ "dir_cd", length));
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			
			for (int i = 0; i < length; i++) {
				model = new MasGenExpnAsgnVO();
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (hoQtaRto[i] != null)
					model.setHoQtaRto(hoQtaRto[i]);
				if (ofcCd[i] != null)
					model.setOfcCd(ofcCd[i]);
				if (rlaneCd[i] != null)
					model.setRlaneCd(rlaneCd[i]);
				if (skdVoyNo[i] != null)
					model.setSkdVoyNo(skdVoyNo[i]);
				if (expnTtl[i] != null)
					model.setExpnTtl(expnTtl[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (vslCd[i] != null)
					model.setVslCd(vslCd[i]);
				if (iocCd[i] != null)
					model.setIocCd(iocCd[i]);
				if (ownExpnAmt[i] != null)
					model.setOwnExpnAmt(ownExpnAmt[i]);
				if (adjExpnTtl[i] != null)
					model.setAdjExpnTtl(adjExpnTtl[i]);
				if (lodQta[i] != null)
					model.setLodQta(lodQta[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (trdCd[i] != null)
					model.setTrdCd(trdCd[i]);
				if (hoExpnAmt[i] != null)
					model.setHoExpnAmt(hoExpnAmt[i]);
				if (ownQtaRto[i] != null)
					model.setOwnQtaRto(ownQtaRto[i]);
				if (dirCd[i] != null)
					model.setDirCd(dirCd[i]);
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getMasGenExpnAsgnVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return MasGenExpnAsgnVO[]
	 */
	public MasGenExpnAsgnVO[] getMasGenExpnAsgnVOs(){
		MasGenExpnAsgnVO[] vos = (MasGenExpnAsgnVO[])models.toArray(new MasGenExpnAsgnVO[models.size()]);
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
		this.hoQtaRto = this.hoQtaRto .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcCd = this.ofcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rlaneCd = this.rlaneCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdVoyNo = this.skdVoyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.expnTtl = this.expnTtl .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslCd = this.vslCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.iocCd = this.iocCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ownExpnAmt = this.ownExpnAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.adjExpnTtl = this.adjExpnTtl .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lodQta = this.lodQta .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trdCd = this.trdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hoExpnAmt = this.hoExpnAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ownQtaRto = this.ownQtaRto .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dirCd = this.dirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
