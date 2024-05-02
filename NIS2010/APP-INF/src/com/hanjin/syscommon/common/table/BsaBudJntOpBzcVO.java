/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : BsaBudJntOpBzcVO.java
*@FileTitle : BsaBudJntOpBzcVO
*Open Issues :
*Change history :
*@LastModifyDate : 2011.01.24
*@LastModifier : 이행지
*@LastVersion : 1.0
* 2011.01.24 이행지 
* 1.0 Creation
=========================================================*/

package com.hanjin.syscommon.common.table;

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
 * @author 이행지
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class BsaBudJntOpBzcVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<BsaBudJntOpBzcVO> models = new ArrayList<BsaBudJntOpBzcVO>();
	
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String bsaFmDt = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String vopCd = null;
	/* Column Info */
	private String trdCd = null;
	/* Column Info */
	private String rlaneCd = null;
	/* Column Info */
	private String joDesc = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String vslCapa = null;
	/* Column Info */
	private String bsaCapa = null;
	/* Column Info */
	private String hjsBsaBfrSubCapa = null;
	/* Column Info */
	private String creUsrId = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String vvdCd = null;
	/* Column Info */
	private String bsaToDt = null;
	/* Column Info */
	private String dirCd = null;
	/* Column Info */
	private String bsaSeq = null;
	/* Column Info */
	private String fnlHjsBsaCapa = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String ownrVslWgt = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public BsaBudJntOpBzcVO() {}

	public BsaBudJntOpBzcVO(String ibflag, String pagerows, String trdCd, String rlaneCd, String dirCd, String vopCd, String vslCapa, String bsaSeq, String vvdCd, String bsaFmDt, String bsaToDt, String bsaCapa, String fnlHjsBsaCapa, String hjsBsaBfrSubCapa, String joDesc, String ownrVslWgt, String creUsrId, String creDt, String updUsrId, String updDt) {
		this.updDt = updDt;
		this.bsaFmDt = bsaFmDt;
		this.creDt = creDt;
		this.vopCd = vopCd;
		this.trdCd = trdCd;
		this.rlaneCd = rlaneCd;
		this.joDesc = joDesc;
		this.pagerows = pagerows;
		this.vslCapa = vslCapa;
		this.bsaCapa = bsaCapa;
		this.hjsBsaBfrSubCapa = hjsBsaBfrSubCapa;
		this.creUsrId = creUsrId;
		this.ibflag = ibflag;
		this.vvdCd = vvdCd;
		this.bsaToDt = bsaToDt;
		this.dirCd = dirCd;
		this.bsaSeq = bsaSeq;
		this.fnlHjsBsaCapa = fnlHjsBsaCapa;
		this.updUsrId = updUsrId;
		this.ownrVslWgt = ownrVslWgt;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("bsa_fm_dt", getBsaFmDt());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("vop_cd", getVopCd());
		this.hashColumns.put("trd_cd", getTrdCd());
		this.hashColumns.put("rlane_cd", getRlaneCd());
		this.hashColumns.put("jo_desc", getJoDesc());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("vsl_capa", getVslCapa());
		this.hashColumns.put("bsa_capa", getBsaCapa());
		this.hashColumns.put("hjs_bsa_bfr_sub_capa", getHjsBsaBfrSubCapa());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("vvd_cd", getVvdCd());
		this.hashColumns.put("bsa_to_dt", getBsaToDt());
		this.hashColumns.put("dir_cd", getDirCd());
		this.hashColumns.put("bsa_seq", getBsaSeq());
		this.hashColumns.put("fnl_hjs_bsa_capa", getFnlHjsBsaCapa());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("ownr_vsl_wgt", getOwnrVslWgt());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("bsa_fm_dt", "bsaFmDt");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("vop_cd", "vopCd");
		this.hashFields.put("trd_cd", "trdCd");
		this.hashFields.put("rlane_cd", "rlaneCd");
		this.hashFields.put("jo_desc", "joDesc");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("vsl_capa", "vslCapa");
		this.hashFields.put("bsa_capa", "bsaCapa");
		this.hashFields.put("hjs_bsa_bfr_sub_capa", "hjsBsaBfrSubCapa");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("vvd_cd", "vvdCd");
		this.hashFields.put("bsa_to_dt", "bsaToDt");
		this.hashFields.put("dir_cd", "dirCd");
		this.hashFields.put("bsa_seq", "bsaSeq");
		this.hashFields.put("fnl_hjs_bsa_capa", "fnlHjsBsaCapa");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("ownr_vsl_wgt", "ownrVslWgt");
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
	 * @return bsaFmDt
	 */
	public String getBsaFmDt() {
		return this.bsaFmDt;
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
	 * @return vopCd
	 */
	public String getVopCd() {
		return this.vopCd;
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
	 * @return rlaneCd
	 */
	public String getRlaneCd() {
		return this.rlaneCd;
	}
	
	/**
	 * Column Info
	 * @return joDesc
	 */
	public String getJoDesc() {
		return this.joDesc;
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
	 * @return vslCapa
	 */
	public String getVslCapa() {
		return this.vslCapa;
	}
	
	/**
	 * Column Info
	 * @return bsaCapa
	 */
	public String getBsaCapa() {
		return this.bsaCapa;
	}
	
	/**
	 * Column Info
	 * @return hjsBsaBfrSubCapa
	 */
	public String getHjsBsaBfrSubCapa() {
		return this.hjsBsaBfrSubCapa;
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
	 * @return vvdCd
	 */
	public String getVvdCd() {
		return this.vvdCd;
	}
	
	/**
	 * Column Info
	 * @return bsaToDt
	 */
	public String getBsaToDt() {
		return this.bsaToDt;
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
	 * @return bsaSeq
	 */
	public String getBsaSeq() {
		return this.bsaSeq;
	}
	
	/**
	 * Column Info
	 * @return fnlHjsBsaCapa
	 */
	public String getFnlHjsBsaCapa() {
		return this.fnlHjsBsaCapa;
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
	 * @return ownrVslWgt
	 */
	public String getOwnrVslWgt() {
		return this.ownrVslWgt;
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
	 * @param bsaFmDt
	 */
	public void setBsaFmDt(String bsaFmDt) {
		this.bsaFmDt = bsaFmDt;
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
	 * @param vopCd
	 */
	public void setVopCd(String vopCd) {
		this.vopCd = vopCd;
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
	 * @param rlaneCd
	 */
	public void setRlaneCd(String rlaneCd) {
		this.rlaneCd = rlaneCd;
	}
	
	/**
	 * Column Info
	 * @param joDesc
	 */
	public void setJoDesc(String joDesc) {
		this.joDesc = joDesc;
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
	 * @param vslCapa
	 */
	public void setVslCapa(String vslCapa) {
		this.vslCapa = vslCapa;
	}
	
	/**
	 * Column Info
	 * @param bsaCapa
	 */
	public void setBsaCapa(String bsaCapa) {
		this.bsaCapa = bsaCapa;
	}
	
	/**
	 * Column Info
	 * @param hjsBsaBfrSubCapa
	 */
	public void setHjsBsaBfrSubCapa(String hjsBsaBfrSubCapa) {
		this.hjsBsaBfrSubCapa = hjsBsaBfrSubCapa;
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
	 * @param vvdCd
	 */
	public void setVvdCd(String vvdCd) {
		this.vvdCd = vvdCd;
	}
	
	/**
	 * Column Info
	 * @param bsaToDt
	 */
	public void setBsaToDt(String bsaToDt) {
		this.bsaToDt = bsaToDt;
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
	 * @param bsaSeq
	 */
	public void setBsaSeq(String bsaSeq) {
		this.bsaSeq = bsaSeq;
	}
	
	/**
	 * Column Info
	 * @param fnlHjsBsaCapa
	 */
	public void setFnlHjsBsaCapa(String fnlHjsBsaCapa) {
		this.fnlHjsBsaCapa = fnlHjsBsaCapa;
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
	 * @param ownrVslWgt
	 */
	public void setOwnrVslWgt(String ownrVslWgt) {
		this.ownrVslWgt = ownrVslWgt;
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
		setBsaFmDt(JSPUtil.getParameter(request, prefix + "bsa_fm_dt", ""));
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
		setVopCd(JSPUtil.getParameter(request, prefix + "vop_cd", ""));
		setTrdCd(JSPUtil.getParameter(request, prefix + "trd_cd", ""));
		setRlaneCd(JSPUtil.getParameter(request, prefix + "rlane_cd", ""));
		setJoDesc(JSPUtil.getParameter(request, prefix + "jo_desc", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setVslCapa(JSPUtil.getParameter(request, prefix + "vsl_capa", ""));
		setBsaCapa(JSPUtil.getParameter(request, prefix + "bsa_capa", ""));
		setHjsBsaBfrSubCapa(JSPUtil.getParameter(request, prefix + "hjs_bsa_bfr_sub_capa", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setVvdCd(JSPUtil.getParameter(request, prefix + "vvd_cd", ""));
		setBsaToDt(JSPUtil.getParameter(request, prefix + "bsa_to_dt", ""));
		setDirCd(JSPUtil.getParameter(request, prefix + "dir_cd", ""));
		setBsaSeq(JSPUtil.getParameter(request, prefix + "bsa_seq", ""));
		setFnlHjsBsaCapa(JSPUtil.getParameter(request, prefix + "fnl_hjs_bsa_capa", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setOwnrVslWgt(JSPUtil.getParameter(request, prefix + "ownr_vsl_wgt", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return BsaBudJntOpBzcVO[]
	 */
	public BsaBudJntOpBzcVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return BsaBudJntOpBzcVO[]
	 */
	public BsaBudJntOpBzcVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		BsaBudJntOpBzcVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] bsaFmDt = (JSPUtil.getParameter(request, prefix	+ "bsa_fm_dt", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] vopCd = (JSPUtil.getParameter(request, prefix	+ "vop_cd", length));
			String[] trdCd = (JSPUtil.getParameter(request, prefix	+ "trd_cd", length));
			String[] rlaneCd = (JSPUtil.getParameter(request, prefix	+ "rlane_cd", length));
			String[] joDesc = (JSPUtil.getParameter(request, prefix	+ "jo_desc", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] vslCapa = (JSPUtil.getParameter(request, prefix	+ "vsl_capa", length));
			String[] bsaCapa = (JSPUtil.getParameter(request, prefix	+ "bsa_capa", length));
			String[] hjsBsaBfrSubCapa = (JSPUtil.getParameter(request, prefix	+ "hjs_bsa_bfr_sub_capa", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] vvdCd = (JSPUtil.getParameter(request, prefix	+ "vvd_cd", length));
			String[] bsaToDt = (JSPUtil.getParameter(request, prefix	+ "bsa_to_dt", length));
			String[] dirCd = (JSPUtil.getParameter(request, prefix	+ "dir_cd", length));
			String[] bsaSeq = (JSPUtil.getParameter(request, prefix	+ "bsa_seq", length));
			String[] fnlHjsBsaCapa = (JSPUtil.getParameter(request, prefix	+ "fnl_hjs_bsa_capa", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] ownrVslWgt = (JSPUtil.getParameter(request, prefix	+ "ownr_vsl_wgt", length));
			
			for (int i = 0; i < length; i++) {
				model = new BsaBudJntOpBzcVO();
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (bsaFmDt[i] != null)
					model.setBsaFmDt(bsaFmDt[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (vopCd[i] != null)
					model.setVopCd(vopCd[i]);
				if (trdCd[i] != null)
					model.setTrdCd(trdCd[i]);
				if (rlaneCd[i] != null)
					model.setRlaneCd(rlaneCd[i]);
				if (joDesc[i] != null)
					model.setJoDesc(joDesc[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (vslCapa[i] != null)
					model.setVslCapa(vslCapa[i]);
				if (bsaCapa[i] != null)
					model.setBsaCapa(bsaCapa[i]);
				if (hjsBsaBfrSubCapa[i] != null)
					model.setHjsBsaBfrSubCapa(hjsBsaBfrSubCapa[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (vvdCd[i] != null)
					model.setVvdCd(vvdCd[i]);
				if (bsaToDt[i] != null)
					model.setBsaToDt(bsaToDt[i]);
				if (dirCd[i] != null)
					model.setDirCd(dirCd[i]);
				if (bsaSeq[i] != null)
					model.setBsaSeq(bsaSeq[i]);
				if (fnlHjsBsaCapa[i] != null)
					model.setFnlHjsBsaCapa(fnlHjsBsaCapa[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (ownrVslWgt[i] != null)
					model.setOwnrVslWgt(ownrVslWgt[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getBsaBudJntOpBzcVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return BsaBudJntOpBzcVO[]
	 */
	public BsaBudJntOpBzcVO[] getBsaBudJntOpBzcVOs(){
		BsaBudJntOpBzcVO[] vos = (BsaBudJntOpBzcVO[])models.toArray(new BsaBudJntOpBzcVO[models.size()]);
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
		this.bsaFmDt = this.bsaFmDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vopCd = this.vopCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trdCd = this.trdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rlaneCd = this.rlaneCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.joDesc = this.joDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslCapa = this.vslCapa .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bsaCapa = this.bsaCapa .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hjsBsaBfrSubCapa = this.hjsBsaBfrSubCapa .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvdCd = this.vvdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bsaToDt = this.bsaToDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dirCd = this.dirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bsaSeq = this.bsaSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fnlHjsBsaCapa = this.fnlHjsBsaCapa .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ownrVslWgt = this.ownrVslWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
