/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : SearchQtaByRhqListVO.java
*@FileTitle : SearchQtaByRhqListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2016.06.29
*@LastModifier : 최성민
*@LastVersion : 1.0
* 2016.06.29 최성민 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.sqm.planning.planning.vo;

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
 * @author 최성민
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SearchQtaByRhqListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchQtaByRhqListVO> models = new ArrayList<SearchQtaByRhqListVO>();
	
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String revPotnRto = null;
	/* Column Info */
	private String obDivCd = null;
	/* Column Info */
	private String rlaneCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String qtaStepCd = null;
	/* Column Info */
	private String bseTpCd = null;
	/* Column Info */
	private String convDirCd = null;
	/* Column Info */
	private String rhqCd = null;
	/* Column Info */
	private String hulBndCd = null;
	/* Column Info */
	private String qtaVerNo = null;
	/* Column Info */
	private String trdCd = null;
	/* Column Info */
	private String rgnOfcCd = null;
	/* Column Info */
	private String ofcVwCd = null;
	/* Column Info */
	private String bseYr = null;
	/* Column Info */
	private String subTrdCd = null;
	/* Column Info */
	private String bseQtrCd = null;
	/* Column Info */
	private String modiFlg = null;
	/* Column Info */
	private String dirCd = null;
	/* Column Info */
	private String lodPotnRto = null;
	/* Column Info */
	private String gidLodPotnRto = null;
	/* Column Info */
	private String gidRevPotnRto = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public SearchQtaByRhqListVO() {}

	public SearchQtaByRhqListVO(String ibflag, String pagerows, String bseTpCd, String bseYr, String bseQtrCd, String ofcVwCd, String obDivCd, String qtaStepCd, String qtaVerNo, String rhqCd, String rgnOfcCd, String trdCd, String rlaneCd, String dirCd, String convDirCd, String subTrdCd, String gidLodPotnRto, String gidRevPotnRto, String lodPotnRto, String revPotnRto, String hulBndCd, String modiFlg) {
		this.pagerows = pagerows;
		this.revPotnRto = revPotnRto;
		this.obDivCd = obDivCd;
		this.rlaneCd = rlaneCd;
		this.ibflag = ibflag;
		this.qtaStepCd = qtaStepCd;
		this.bseTpCd = bseTpCd;
		this.convDirCd = convDirCd;
		this.rhqCd = rhqCd;
		this.hulBndCd = hulBndCd;
		this.qtaVerNo = qtaVerNo;
		this.trdCd = trdCd;
		this.rgnOfcCd = rgnOfcCd;
		this.ofcVwCd = ofcVwCd;
		this.bseYr = bseYr;
		this.subTrdCd = subTrdCd;
		this.bseQtrCd = bseQtrCd;
		this.modiFlg = modiFlg;
		this.dirCd = dirCd;
		this.lodPotnRto = lodPotnRto;
		this.gidLodPotnRto = gidLodPotnRto;
		this.gidRevPotnRto = gidRevPotnRto;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("rev_potn_rto", getRevPotnRto());
		this.hashColumns.put("ob_div_cd", getObDivCd());
		this.hashColumns.put("rlane_cd", getRlaneCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("qta_step_cd", getQtaStepCd());
		this.hashColumns.put("bse_tp_cd", getBseTpCd());
		this.hashColumns.put("conv_dir_cd", getConvDirCd());
		this.hashColumns.put("rhq_cd", getRhqCd());
		this.hashColumns.put("hul_bnd_cd", getHulBndCd());
		this.hashColumns.put("qta_ver_no", getQtaVerNo());
		this.hashColumns.put("trd_cd", getTrdCd());
		this.hashColumns.put("rgn_ofc_cd", getRgnOfcCd());
		this.hashColumns.put("ofc_vw_cd", getOfcVwCd());
		this.hashColumns.put("bse_yr", getBseYr());
		this.hashColumns.put("sub_trd_cd", getSubTrdCd());
		this.hashColumns.put("bse_qtr_cd", getBseQtrCd());
		this.hashColumns.put("modi_flg", getModiFlg());
		this.hashColumns.put("dir_cd", getDirCd());
		this.hashColumns.put("lod_potn_rto", getLodPotnRto());
		this.hashColumns.put("gid_lod_potn_rto", getGidLodPotnRto());
		this.hashColumns.put("gid_rev_potn_rto", getGidRevPotnRto());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("rev_potn_rto", "revPotnRto");
		this.hashFields.put("ob_div_cd", "obDivCd");
		this.hashFields.put("rlane_cd", "rlaneCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("qta_step_cd", "qtaStepCd");
		this.hashFields.put("bse_tp_cd", "bseTpCd");
		this.hashFields.put("conv_dir_cd", "convDirCd");
		this.hashFields.put("rhq_cd", "rhqCd");
		this.hashFields.put("hul_bnd_cd", "hulBndCd");
		this.hashFields.put("qta_ver_no", "qtaVerNo");
		this.hashFields.put("trd_cd", "trdCd");
		this.hashFields.put("rgn_ofc_cd", "rgnOfcCd");
		this.hashFields.put("ofc_vw_cd", "ofcVwCd");
		this.hashFields.put("bse_yr", "bseYr");
		this.hashFields.put("sub_trd_cd", "subTrdCd");
		this.hashFields.put("bse_qtr_cd", "bseQtrCd");
		this.hashFields.put("modi_flg", "modiFlg");
		this.hashFields.put("dir_cd", "dirCd");
		this.hashFields.put("lod_potn_rto", "lodPotnRto");
		this.hashFields.put("gid_lod_potn_rto", "gidLodPotnRto");
		this.hashFields.put("gid_rev_potn_rto", "gidRevPotnRto");
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
	 * @return revPotnRto
	 */
	public String getRevPotnRto() {
		return this.revPotnRto;
	}
	
	/**
	 * Column Info
	 * @return obDivCd
	 */
	public String getObDivCd() {
		return this.obDivCd;
	}
	
	/**
	 * Column Info
	 * @return rlaneCd
	 */
	public String getRlaneCd() {
		return this.rlaneCd;
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
	 * @return qtaStepCd
	 */
	public String getQtaStepCd() {
		return this.qtaStepCd;
	}
	
	/**
	 * Column Info
	 * @return bseTpCd
	 */
	public String getBseTpCd() {
		return this.bseTpCd;
	}
	
	/**
	 * Column Info
	 * @return convDirCd
	 */
	public String getConvDirCd() {
		return this.convDirCd;
	}
	
	/**
	 * Column Info
	 * @return rhqCd
	 */
	public String getRhqCd() {
		return this.rhqCd;
	}
	
	/**
	 * Column Info
	 * @return hulBndCd
	 */
	public String getHulBndCd() {
		return this.hulBndCd;
	}
	
	/**
	 * Column Info
	 * @return qtaVerNo
	 */
	public String getQtaVerNo() {
		return this.qtaVerNo;
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
	 * @return rgnOfcCd
	 */
	public String getRgnOfcCd() {
		return this.rgnOfcCd;
	}
	
	/**
	 * Column Info
	 * @return ofcVwCd
	 */
	public String getOfcVwCd() {
		return this.ofcVwCd;
	}
	
	/**
	 * Column Info
	 * @return bseYr
	 */
	public String getBseYr() {
		return this.bseYr;
	}
	
	/**
	 * Column Info
	 * @return subTrdCd
	 */
	public String getSubTrdCd() {
		return this.subTrdCd;
	}
	
	/**
	 * Column Info
	 * @return bseQtrCd
	 */
	public String getBseQtrCd() {
		return this.bseQtrCd;
	}
	
	/**
	 * Column Info
	 * @return modiFlg
	 */
	public String getModiFlg() {
		return this.modiFlg;
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
	 * @return lodPotnRto
	 */
	public String getLodPotnRto() {
		return this.lodPotnRto;
	}
	
	/**
	 * Column Info
	 * @return gidLodPotnRto
	 */
	public String getGidLodPotnRto() {
		return this.gidLodPotnRto;
	}
	
	/**
	 * Column Info
	 * @return gidRevPotnRto
	 */
	public String getGidRevPotnRto() {
		return this.gidRevPotnRto;
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
	 * @param revPotnRto
	 */
	public void setRevPotnRto(String revPotnRto) {
		this.revPotnRto = revPotnRto;
	}
	
	/**
	 * Column Info
	 * @param obDivCd
	 */
	public void setObDivCd(String obDivCd) {
		this.obDivCd = obDivCd;
	}
	
	/**
	 * Column Info
	 * @param rlaneCd
	 */
	public void setRlaneCd(String rlaneCd) {
		this.rlaneCd = rlaneCd;
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
	 * @param qtaStepCd
	 */
	public void setQtaStepCd(String qtaStepCd) {
		this.qtaStepCd = qtaStepCd;
	}
	
	/**
	 * Column Info
	 * @param bseTpCd
	 */
	public void setBseTpCd(String bseTpCd) {
		this.bseTpCd = bseTpCd;
	}
	
	/**
	 * Column Info
	 * @param convDirCd
	 */
	public void setConvDirCd(String convDirCd) {
		this.convDirCd = convDirCd;
	}
	
	/**
	 * Column Info
	 * @param rhqCd
	 */
	public void setRhqCd(String rhqCd) {
		this.rhqCd = rhqCd;
	}
	
	/**
	 * Column Info
	 * @param hulBndCd
	 */
	public void setHulBndCd(String hulBndCd) {
		this.hulBndCd = hulBndCd;
	}
	
	/**
	 * Column Info
	 * @param qtaVerNo
	 */
	public void setQtaVerNo(String qtaVerNo) {
		this.qtaVerNo = qtaVerNo;
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
	 * @param rgnOfcCd
	 */
	public void setRgnOfcCd(String rgnOfcCd) {
		this.rgnOfcCd = rgnOfcCd;
	}
	
	/**
	 * Column Info
	 * @param ofcVwCd
	 */
	public void setOfcVwCd(String ofcVwCd) {
		this.ofcVwCd = ofcVwCd;
	}
	
	/**
	 * Column Info
	 * @param bseYr
	 */
	public void setBseYr(String bseYr) {
		this.bseYr = bseYr;
	}
	
	/**
	 * Column Info
	 * @param subTrdCd
	 */
	public void setSubTrdCd(String subTrdCd) {
		this.subTrdCd = subTrdCd;
	}
	
	/**
	 * Column Info
	 * @param bseQtrCd
	 */
	public void setBseQtrCd(String bseQtrCd) {
		this.bseQtrCd = bseQtrCd;
	}
	
	/**
	 * Column Info
	 * @param modiFlg
	 */
	public void setModiFlg(String modiFlg) {
		this.modiFlg = modiFlg;
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
	 * @param lodPotnRto
	 */
	public void setLodPotnRto(String lodPotnRto) {
		this.lodPotnRto = lodPotnRto;
	}
	
	/**
	 * Column Info
	 * @param gidLodPotnRto
	 */
	public void setGidLodPotnRto(String gidLodPotnRto) {
		this.gidLodPotnRto = gidLodPotnRto;
	}
	
	/**
	 * Column Info
	 * @param gidRevPotnRto
	 */
	public void setGidRevPotnRto(String gidRevPotnRto) {
		this.gidRevPotnRto = gidRevPotnRto;
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
		setRevPotnRto(JSPUtil.getParameter(request, prefix + "rev_potn_rto", ""));
		setObDivCd(JSPUtil.getParameter(request, prefix + "ob_div_cd", ""));
		setRlaneCd(JSPUtil.getParameter(request, prefix + "rlane_cd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setQtaStepCd(JSPUtil.getParameter(request, prefix + "qta_step_cd", ""));
		setBseTpCd(JSPUtil.getParameter(request, prefix + "bse_tp_cd", ""));
		setConvDirCd(JSPUtil.getParameter(request, prefix + "conv_dir_cd", ""));
		setRhqCd(JSPUtil.getParameter(request, prefix + "rhq_cd", ""));
		setHulBndCd(JSPUtil.getParameter(request, prefix + "hul_bnd_cd", ""));
		setQtaVerNo(JSPUtil.getParameter(request, prefix + "qta_ver_no", ""));
		setTrdCd(JSPUtil.getParameter(request, prefix + "trd_cd", ""));
		setRgnOfcCd(JSPUtil.getParameter(request, prefix + "rgn_ofc_cd", ""));
		setOfcVwCd(JSPUtil.getParameter(request, prefix + "ofc_vw_cd", ""));
		setBseYr(JSPUtil.getParameter(request, prefix + "bse_yr", ""));
		setSubTrdCd(JSPUtil.getParameter(request, prefix + "sub_trd_cd", ""));
		setBseQtrCd(JSPUtil.getParameter(request, prefix + "bse_qtr_cd", ""));
		setModiFlg(JSPUtil.getParameter(request, prefix + "modi_flg", ""));
		setDirCd(JSPUtil.getParameter(request, prefix + "dir_cd", ""));
		setLodPotnRto(JSPUtil.getParameter(request, prefix + "lod_potn_rto", ""));
		setGidLodPotnRto(JSPUtil.getParameter(request, prefix + "gid_lod_potn_rto", ""));
		setGidRevPotnRto(JSPUtil.getParameter(request, prefix + "gid_rev_potn_rto", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchQtaByRhqListVO[]
	 */
	public SearchQtaByRhqListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchQtaByRhqListVO[]
	 */
	public SearchQtaByRhqListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchQtaByRhqListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] revPotnRto = (JSPUtil.getParameter(request, prefix	+ "rev_potn_rto", length));
			String[] obDivCd = (JSPUtil.getParameter(request, prefix	+ "ob_div_cd", length));
			String[] rlaneCd = (JSPUtil.getParameter(request, prefix	+ "rlane_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] qtaStepCd = (JSPUtil.getParameter(request, prefix	+ "qta_step_cd", length));
			String[] bseTpCd = (JSPUtil.getParameter(request, prefix	+ "bse_tp_cd", length));
			String[] convDirCd = (JSPUtil.getParameter(request, prefix	+ "conv_dir_cd", length));
			String[] rhqCd = (JSPUtil.getParameter(request, prefix	+ "rhq_cd", length));
			String[] hulBndCd = (JSPUtil.getParameter(request, prefix	+ "hul_bnd_cd", length));
			String[] qtaVerNo = (JSPUtil.getParameter(request, prefix	+ "qta_ver_no", length));
			String[] trdCd = (JSPUtil.getParameter(request, prefix	+ "trd_cd", length));
			String[] rgnOfcCd = (JSPUtil.getParameter(request, prefix	+ "rgn_ofc_cd", length));
			String[] ofcVwCd = (JSPUtil.getParameter(request, prefix	+ "ofc_vw_cd", length));
			String[] bseYr = (JSPUtil.getParameter(request, prefix	+ "bse_yr", length));
			String[] subTrdCd = (JSPUtil.getParameter(request, prefix	+ "sub_trd_cd", length));
			String[] bseQtrCd = (JSPUtil.getParameter(request, prefix	+ "bse_qtr_cd", length));
			String[] modiFlg = (JSPUtil.getParameter(request, prefix	+ "modi_flg", length));
			String[] dirCd = (JSPUtil.getParameter(request, prefix	+ "dir_cd", length));
			String[] lodPotnRto = (JSPUtil.getParameter(request, prefix	+ "lod_potn_rto", length));
			String[] gidLodPotnRto = (JSPUtil.getParameter(request, prefix	+ "gid_lod_potn_rto", length));
			String[] gidRevPotnRto = (JSPUtil.getParameter(request, prefix	+ "gid_rev_potn_rto", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchQtaByRhqListVO();
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (revPotnRto[i] != null)
					model.setRevPotnRto(revPotnRto[i]);
				if (obDivCd[i] != null)
					model.setObDivCd(obDivCd[i]);
				if (rlaneCd[i] != null)
					model.setRlaneCd(rlaneCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (qtaStepCd[i] != null)
					model.setQtaStepCd(qtaStepCd[i]);
				if (bseTpCd[i] != null)
					model.setBseTpCd(bseTpCd[i]);
				if (convDirCd[i] != null)
					model.setConvDirCd(convDirCd[i]);
				if (rhqCd[i] != null)
					model.setRhqCd(rhqCd[i]);
				if (hulBndCd[i] != null)
					model.setHulBndCd(hulBndCd[i]);
				if (qtaVerNo[i] != null)
					model.setQtaVerNo(qtaVerNo[i]);
				if (trdCd[i] != null)
					model.setTrdCd(trdCd[i]);
				if (rgnOfcCd[i] != null)
					model.setRgnOfcCd(rgnOfcCd[i]);
				if (ofcVwCd[i] != null)
					model.setOfcVwCd(ofcVwCd[i]);
				if (bseYr[i] != null)
					model.setBseYr(bseYr[i]);
				if (subTrdCd[i] != null)
					model.setSubTrdCd(subTrdCd[i]);
				if (bseQtrCd[i] != null)
					model.setBseQtrCd(bseQtrCd[i]);
				if (modiFlg[i] != null)
					model.setModiFlg(modiFlg[i]);
				if (dirCd[i] != null)
					model.setDirCd(dirCd[i]);
				if (lodPotnRto[i] != null)
					model.setLodPotnRto(lodPotnRto[i]);
				if (gidLodPotnRto[i] != null)
					model.setGidLodPotnRto(gidLodPotnRto[i]);
				if (gidRevPotnRto[i] != null)
					model.setGidRevPotnRto(gidRevPotnRto[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchQtaByRhqListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchQtaByRhqListVO[]
	 */
	public SearchQtaByRhqListVO[] getSearchQtaByRhqListVOs(){
		SearchQtaByRhqListVO[] vos = (SearchQtaByRhqListVO[])models.toArray(new SearchQtaByRhqListVO[models.size()]);
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
		this.revPotnRto = this.revPotnRto .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.obDivCd = this.obDivCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rlaneCd = this.rlaneCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.qtaStepCd = this.qtaStepCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bseTpCd = this.bseTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.convDirCd = this.convDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rhqCd = this.rhqCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hulBndCd = this.hulBndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.qtaVerNo = this.qtaVerNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trdCd = this.trdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rgnOfcCd = this.rgnOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcVwCd = this.ofcVwCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bseYr = this.bseYr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.subTrdCd = this.subTrdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bseQtrCd = this.bseQtrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.modiFlg = this.modiFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dirCd = this.dirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lodPotnRto = this.lodPotnRto .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.gidLodPotnRto = this.gidLodPotnRto .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.gidRevPotnRto = this.gidRevPotnRto .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
