/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SearchVslRgstListVO.java
*@FileTitle : SearchVslRgstListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.06
*@LastModifier : 
*@LastVersion : 1.0
* 2009.11.06  
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.coa.weeklypfmc.opmaster.vo;

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
 * @author 
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SearchVslRgstListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchVslRgstListVO> models = new ArrayList<SearchVslRgstListVO>();
	
	/* Column Info */
	private String vslDzndCapa = null;
	/* Column Info */
	private String vslCd = null;
	/* Column Info */
	private String deltFlg = null;
	/* Column Info */
	private String vslRetnFmDt = null;
	/* Column Info */
	private String vopCd = null;
	/* Column Info */
	private String vslTpCd = null;
	/* Column Info */
	private String vslSeq = null;
	/* Column Info */
	private String stndLdbCapa = null;
	/* Column Info */
	private String vslPrcRto = null;
	/* Column Info */
	private String vslRetnToDt = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String creUsrId = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String lstFlg = null;
	/* Column Info */
	private String vslRgstCntCd = null;
	/* Column Info */
	private String portClssCapa = null;
	/* Column Info */
	private String vslPrc = null;
	/* Column Info */
	private String vslAplyToDt = null;
	/* Column Info */
	private String bsaVslFlg = null;
	/* Column Info */
	private String vslOshpCd = null;
	/* Column Info */
	private String vslClssCapa = null;
	/* Column Info */
	private String vslAplyFmDt = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SearchVslRgstListVO() {}

	public SearchVslRgstListVO(String ibflag, String pagerows, String vslCd, String vslTpCd, String vslOshpCd, String vopCd, String vslRgstCntCd, String vslClssCapa, String portClssCapa, String vslDzndCapa, String stndLdbCapa, String vslPrc, String vslPrcRto, String vslRetnFmDt, String vslRetnToDt, String deltFlg, String bsaVslFlg, String creUsrId, String vslSeq, String lstFlg, String vslAplyToDt, String vslAplyFmDt) {
		this.vslDzndCapa = vslDzndCapa;
		this.vslCd = vslCd;
		this.deltFlg = deltFlg;
		this.vslRetnFmDt = vslRetnFmDt;
		this.vopCd = vopCd;
		this.vslTpCd = vslTpCd;
		this.vslSeq = vslSeq;
		this.stndLdbCapa = stndLdbCapa;
		this.vslPrcRto = vslPrcRto;
		this.vslRetnToDt = vslRetnToDt;
		this.pagerows = pagerows;
		this.creUsrId = creUsrId;
		this.ibflag = ibflag;
		this.lstFlg = lstFlg;
		this.vslRgstCntCd = vslRgstCntCd;
		this.portClssCapa = portClssCapa;
		this.vslPrc = vslPrc;
		this.vslAplyToDt = vslAplyToDt;
		this.bsaVslFlg = bsaVslFlg;
		this.vslOshpCd = vslOshpCd;
		this.vslClssCapa = vslClssCapa;
		this.vslAplyFmDt = vslAplyFmDt;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("vsl_dznd_capa", getVslDzndCapa());
		this.hashColumns.put("vsl_cd", getVslCd());
		this.hashColumns.put("delt_flg", getDeltFlg());
		this.hashColumns.put("vsl_retn_fm_dt", getVslRetnFmDt());
		this.hashColumns.put("vop_cd", getVopCd());
		this.hashColumns.put("vsl_tp_cd", getVslTpCd());
		this.hashColumns.put("vsl_seq", getVslSeq());
		this.hashColumns.put("stnd_ldb_capa", getStndLdbCapa());
		this.hashColumns.put("vsl_prc_rto", getVslPrcRto());
		this.hashColumns.put("vsl_retn_to_dt", getVslRetnToDt());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("lst_flg", getLstFlg());
		this.hashColumns.put("vsl_rgst_cnt_cd", getVslRgstCntCd());		
		this.hashColumns.put("vsl_prc", getVslPrc());
		this.hashColumns.put("vsl_aply_to_dt", getVslAplyToDt());
		this.hashColumns.put("bsa_vsl_flg", getBsaVslFlg());
		this.hashColumns.put("vsl_oshp_cd", getVslOshpCd());
		this.hashColumns.put("vsl_clss_capa", getVslClssCapa());
		this.hashColumns.put("vsl_aply_fm_dt", getVslAplyFmDt());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("vsl_dznd_capa", "vslDzndCapa");
		this.hashFields.put("vsl_cd", "vslCd");
		this.hashFields.put("delt_flg", "deltFlg");
		this.hashFields.put("vsl_retn_fm_dt", "vslRetnFmDt");
		this.hashFields.put("vop_cd", "vopCd");
		this.hashFields.put("vsl_tp_cd", "vslTpCd");
		this.hashFields.put("vsl_seq", "vslSeq");
		this.hashFields.put("stnd_ldb_capa", "stndLdbCapa");
		this.hashFields.put("vsl_prc_rto", "vslPrcRto");
		this.hashFields.put("vsl_retn_to_dt", "vslRetnToDt");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("lst_flg", "lstFlg");
		this.hashFields.put("vsl_rgst_cnt_cd", "vslRgstCntCd");		
		this.hashFields.put("vsl_prc", "vslPrc");
		this.hashFields.put("vsl_aply_to_dt", "vslAplyToDt");
		this.hashFields.put("bsa_vsl_flg", "bsaVslFlg");
		this.hashFields.put("vsl_oshp_cd", "vslOshpCd");
		this.hashFields.put("vsl_clss_capa", "vslClssCapa");
		this.hashFields.put("vsl_aply_fm_dt", "vslAplyFmDt");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return vslDzndCapa
	 */
	public String getVslDzndCapa() {
		return this.vslDzndCapa;
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
	 * @return deltFlg
	 */
	public String getDeltFlg() {
		return this.deltFlg;
	}
	
	/**
	 * Column Info
	 * @return vslRetnFmDt
	 */
	public String getVslRetnFmDt() {
		return this.vslRetnFmDt;
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
	 * @return vslTpCd
	 */
	public String getVslTpCd() {
		return this.vslTpCd;
	}
	
	/**
	 * Column Info
	 * @return vslSeq
	 */
	public String getVslSeq() {
		return this.vslSeq;
	}
	
	/**
	 * Column Info
	 * @return stndLdbCapa
	 */
	public String getStndLdbCapa() {
		return this.stndLdbCapa;
	}
	
	/**
	 * Column Info
	 * @return vslPrcRto
	 */
	public String getVslPrcRto() {
		return this.vslPrcRto;
	}
	
	/**
	 * Column Info
	 * @return vslRetnToDt
	 */
	public String getVslRetnToDt() {
		return this.vslRetnToDt;
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
	 * @return lstFlg
	 */
	public String getLstFlg() {
		return this.lstFlg;
	}
	
	/**
	 * Column Info
	 * @return vslRgstCntCd
	 */
	public String getVslRgstCntCd() {
		return this.vslRgstCntCd;
	}
	
	/**
	 * Column Info
	 * @return portClssCapa
	 */
	public String getPortClssCapa() {
		return this.portClssCapa;
	}
	
	/**
	 * Column Info
	 * @return vslPrc
	 */
	public String getVslPrc() {
		return this.vslPrc;
	}
	
	/**
	 * Column Info
	 * @return vslAplyToDt
	 */
	public String getVslAplyToDt() {
		return this.vslAplyToDt;
	}
	
	/**
	 * Column Info
	 * @return bsaVslFlg
	 */
	public String getBsaVslFlg() {
		return this.bsaVslFlg;
	}
	
	/**
	 * Column Info
	 * @return vslOshpCd
	 */
	public String getVslOshpCd() {
		return this.vslOshpCd;
	}
	
	/**
	 * Column Info
	 * @return vslClssCapa
	 */
	public String getVslClssCapa() {
		return this.vslClssCapa;
	}
	
	/**
	 * Column Info
	 * @return vslAplyFmDt
	 */
	public String getVslAplyFmDt() {
		return this.vslAplyFmDt;
	}
	

	/**
	 * Column Info
	 * @param vslDzndCapa
	 */
	public void setVslDzndCapa(String vslDzndCapa) {
		this.vslDzndCapa = vslDzndCapa;
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
	 * @param deltFlg
	 */
	public void setDeltFlg(String deltFlg) {
		this.deltFlg = deltFlg;
	}
	
	/**
	 * Column Info
	 * @param vslRetnFmDt
	 */
	public void setVslRetnFmDt(String vslRetnFmDt) {
		this.vslRetnFmDt = vslRetnFmDt;
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
	 * @param vslTpCd
	 */
	public void setVslTpCd(String vslTpCd) {
		this.vslTpCd = vslTpCd;
	}
	
	/**
	 * Column Info
	 * @param vslSeq
	 */
	public void setVslSeq(String vslSeq) {
		this.vslSeq = vslSeq;
	}
	
	/**
	 * Column Info
	 * @param stndLdbCapa
	 */
	public void setStndLdbCapa(String stndLdbCapa) {
		this.stndLdbCapa = stndLdbCapa;
	}
	
	/**
	 * Column Info
	 * @param vslPrcRto
	 */
	public void setVslPrcRto(String vslPrcRto) {
		this.vslPrcRto = vslPrcRto;
	}
	
	/**
	 * Column Info
	 * @param vslRetnToDt
	 */
	public void setVslRetnToDt(String vslRetnToDt) {
		this.vslRetnToDt = vslRetnToDt;
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
	 * @param lstFlg
	 */
	public void setLstFlg(String lstFlg) {
		this.lstFlg = lstFlg;
	}
	
	/**
	 * Column Info
	 * @param vslRgstCntCd
	 */
	public void setVslRgstCntCd(String vslRgstCntCd) {
		this.vslRgstCntCd = vslRgstCntCd;
	}
	
	/**
	 * Column Info
	 * @param portClssCapa
	 */
	public void setPortClssCapa(String portClssCapa) {
		this.portClssCapa = portClssCapa;
	}
	
	/**
	 * Column Info
	 * @param vslPrc
	 */
	public void setVslPrc(String vslPrc) {
		this.vslPrc = vslPrc;
	}
	
	/**
	 * Column Info
	 * @param vslAplyToDt
	 */
	public void setVslAplyToDt(String vslAplyToDt) {
		this.vslAplyToDt = vslAplyToDt;
	}
	
	/**
	 * Column Info
	 * @param bsaVslFlg
	 */
	public void setBsaVslFlg(String bsaVslFlg) {
		this.bsaVslFlg = bsaVslFlg;
	}
	
	/**
	 * Column Info
	 * @param vslOshpCd
	 */
	public void setVslOshpCd(String vslOshpCd) {
		this.vslOshpCd = vslOshpCd;
	}
	
	/**
	 * Column Info
	 * @param vslClssCapa
	 */
	public void setVslClssCapa(String vslClssCapa) {
		this.vslClssCapa = vslClssCapa;
	}
	
	/**
	 * Column Info
	 * @param vslAplyFmDt
	 */
	public void setVslAplyFmDt(String vslAplyFmDt) {
		this.vslAplyFmDt = vslAplyFmDt;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setVslDzndCapa(JSPUtil.getParameter(request, "vsl_dznd_capa", ""));
		setVslCd(JSPUtil.getParameter(request, "vsl_cd", ""));
		setDeltFlg(JSPUtil.getParameter(request, "delt_flg", ""));
		setVslRetnFmDt(JSPUtil.getParameter(request, "vsl_retn_fm_dt", ""));
		setVopCd(JSPUtil.getParameter(request, "vop_cd", ""));
		setVslTpCd(JSPUtil.getParameter(request, "vsl_tp_cd", ""));
		setVslSeq(JSPUtil.getParameter(request, "vsl_seq", ""));
		setStndLdbCapa(JSPUtil.getParameter(request, "stnd_ldb_capa", ""));
		setVslPrcRto(JSPUtil.getParameter(request, "vsl_prc_rto", ""));
		setVslRetnToDt(JSPUtil.getParameter(request, "vsl_retn_to_dt", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setCreUsrId(JSPUtil.getParameter(request, "cre_usr_id", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setLstFlg(JSPUtil.getParameter(request, "lst_flg", ""));
		setVslRgstCntCd(JSPUtil.getParameter(request, "vsl_rgst_cnt_cd", ""));		
		setVslPrc(JSPUtil.getParameter(request, "vsl_prc", ""));
		setVslAplyToDt(JSPUtil.getParameter(request, "vsl_aply_to_dt", ""));
		setBsaVslFlg(JSPUtil.getParameter(request, "bsa_vsl_flg", ""));
		setVslOshpCd(JSPUtil.getParameter(request, "vsl_oshp_cd", ""));
		setVslClssCapa(JSPUtil.getParameter(request, "vsl_clss_capa", ""));
		setVslAplyFmDt(JSPUtil.getParameter(request, "vsl_aply_fm_dt", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchVslRgstListVO[]
	 */
	public SearchVslRgstListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchVslRgstListVO[]
	 */
	public SearchVslRgstListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchVslRgstListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] vslDzndCapa = (JSPUtil.getParameter(request, prefix	+ "vsl_dznd_capa", length));
			String[] vslCd = (JSPUtil.getParameter(request, prefix	+ "vsl_cd", length));
			String[] deltFlg = (JSPUtil.getParameter(request, prefix	+ "delt_flg", length));
			String[] vslRetnFmDt = (JSPUtil.getParameter(request, prefix	+ "vsl_retn_fm_dt", length));
			String[] vopCd = (JSPUtil.getParameter(request, prefix	+ "vop_cd", length));
			String[] vslTpCd = (JSPUtil.getParameter(request, prefix	+ "vsl_tp_cd", length));
			String[] vslSeq = (JSPUtil.getParameter(request, prefix	+ "vsl_seq", length));
			String[] stndLdbCapa = (JSPUtil.getParameter(request, prefix	+ "stnd_ldb_capa", length));
			String[] vslPrcRto = (JSPUtil.getParameter(request, prefix	+ "vsl_prc_rto", length));
			String[] vslRetnToDt = (JSPUtil.getParameter(request, prefix	+ "vsl_retn_to_dt", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] lstFlg = (JSPUtil.getParameter(request, prefix	+ "lst_flg", length));
			String[] vslRgstCntCd = (JSPUtil.getParameter(request, prefix	+ "vsl_rgst_cnt_cd", length));			
			String[] vslPrc = (JSPUtil.getParameter(request, prefix	+ "vsl_prc", length));
			String[] vslAplyToDt = (JSPUtil.getParameter(request, prefix	+ "vsl_aply_to_dt", length));
			String[] bsaVslFlg = (JSPUtil.getParameter(request, prefix	+ "bsa_vsl_flg", length));
			String[] vslOshpCd = (JSPUtil.getParameter(request, prefix	+ "vsl_oshp_cd", length));
			String[] vslClssCapa = (JSPUtil.getParameter(request, prefix	+ "vsl_clss_capa", length));
			String[] vslAplyFmDt = (JSPUtil.getParameter(request, prefix	+ "vsl_aply_fm_dt", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchVslRgstListVO();
				if (vslDzndCapa[i] != null)
					model.setVslDzndCapa(vslDzndCapa[i]);
				if (vslCd[i] != null)
					model.setVslCd(vslCd[i]);
				if (deltFlg[i] != null)
					model.setDeltFlg(deltFlg[i]);
				if (vslRetnFmDt[i] != null)
					model.setVslRetnFmDt(vslRetnFmDt[i]);
				if (vopCd[i] != null)
					model.setVopCd(vopCd[i]);
				if (vslTpCd[i] != null)
					model.setVslTpCd(vslTpCd[i]);
				if (vslSeq[i] != null)
					model.setVslSeq(vslSeq[i]);
				if (stndLdbCapa[i] != null)
					model.setStndLdbCapa(stndLdbCapa[i]);
				if (vslPrcRto[i] != null)
					model.setVslPrcRto(vslPrcRto[i]);
				if (vslRetnToDt[i] != null)
					model.setVslRetnToDt(vslRetnToDt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (lstFlg[i] != null)
					model.setLstFlg(lstFlg[i]);
				if (vslRgstCntCd[i] != null)
					model.setVslRgstCntCd(vslRgstCntCd[i]);
				if (vslPrc[i] != null)
					model.setVslPrc(vslPrc[i]);
				if (vslAplyToDt[i] != null)
					model.setVslAplyToDt(vslAplyToDt[i]);
				if (bsaVslFlg[i] != null)
					model.setBsaVslFlg(bsaVslFlg[i]);
				if (vslOshpCd[i] != null)
					model.setVslOshpCd(vslOshpCd[i]);
				if (vslClssCapa[i] != null)
					model.setVslClssCapa(vslClssCapa[i]);
				if (vslAplyFmDt[i] != null)
					model.setVslAplyFmDt(vslAplyFmDt[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchVslRgstListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchVslRgstListVO[]
	 */
	public SearchVslRgstListVO[] getSearchVslRgstListVOs(){
		SearchVslRgstListVO[] vos = (SearchVslRgstListVO[])models.toArray(new SearchVslRgstListVO[models.size()]);
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
		this.vslDzndCapa = this.vslDzndCapa .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslCd = this.vslCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.deltFlg = this.deltFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslRetnFmDt = this.vslRetnFmDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vopCd = this.vopCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslTpCd = this.vslTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslSeq = this.vslSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stndLdbCapa = this.stndLdbCapa .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslPrcRto = this.vslPrcRto .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslRetnToDt = this.vslRetnToDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lstFlg = this.lstFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslRgstCntCd = this.vslRgstCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.portClssCapa = this.portClssCapa .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslPrc = this.vslPrc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslAplyToDt = this.vslAplyToDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bsaVslFlg = this.bsaVslFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslOshpCd = this.vslOshpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslClssCapa = this.vslClssCapa .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslAplyFmDt = this.vslAplyFmDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
