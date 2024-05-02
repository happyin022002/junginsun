/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : SearchBlESignatureListVO.java
*@FileTitle : SearchBlESignatureListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2014.11.10
*@LastModifier : 
*@LastVersion : 1.0
* 2014.11.10  
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.bookingmasterdata.usersetupmgt.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;

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

public class BlESignatureVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<BlESignatureVO> models = new ArrayList<BlESignatureVO>();
	
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String esigFilePathRmk = null;
	/* Column Info */
	private String blEsigSeq = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String esigFileNm = null;
	/* Column Info */
	private String esigFileSavId = null;
	/* Column Info */
	private String esigLstNm = null;
	/* Column Info */
	private String initFileNm = null;
	/* Column Info */
	private String esigServerPath = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String initServerPath = null;
	/* Column Info */
	private String creUsrId = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String actFlg = null;
	/* Column Info */
	private String cntCd = null;
	/* Column Info */
	private String esigDesc = null;
	/* Column Info */
	private String initFileSavId = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String esigN1stNm = null;
	/* Column Info */
	private String initFilePathRmk = null;
	//SJH.20141114.ADD
	/* Column Info */
	private String regionNm = null;	

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public BlESignatureVO() {}

	public BlESignatureVO(String ibflag, String pagerows, String blEsigSeq, String esigN1stNm, String esigLstNm, String cntCd, String actFlg, String esigFileNm, String esigFilePathRmk, String esigFileSavId, String initFileNm, String initFilePathRmk, String initFileSavId, String esigDesc, String creUsrId, String creDt, String updUsrId, String updDt, String esigServerPath, String initServerPath, String regionNm) {
		this.updDt = updDt;
		this.esigFilePathRmk = esigFilePathRmk;
		this.blEsigSeq = blEsigSeq;
		this.creDt = creDt;
		this.esigFileNm = esigFileNm;
		this.esigFileSavId = esigFileSavId;
		this.esigLstNm = esigLstNm;
		this.initFileNm = initFileNm;
		this.esigServerPath = esigServerPath;
		this.pagerows = pagerows;
		this.initServerPath = initServerPath;
		this.creUsrId = creUsrId;
		this.ibflag = ibflag;
		this.actFlg = actFlg;
		this.cntCd = cntCd;
		this.esigDesc = esigDesc;
		this.initFileSavId = initFileSavId;
		this.updUsrId = updUsrId;
		this.esigN1stNm = esigN1stNm;
		this.initFilePathRmk = initFilePathRmk;
		this.regionNm = regionNm;		//SJH.20141114.ADD
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("esig_file_path_rmk", getEsigFilePathRmk());
		this.hashColumns.put("bl_esig_seq", getBlEsigSeq());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("esig_file_nm", getEsigFileNm());
		this.hashColumns.put("esig_file_sav_id", getEsigFileSavId());
		this.hashColumns.put("esig_lst_nm", getEsigLstNm());
		this.hashColumns.put("init_file_nm", getInitFileNm());
		this.hashColumns.put("esig_server_path", getEsigServerPath());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("init_server_path", getInitServerPath());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("act_flg", getActFlg());
		this.hashColumns.put("cnt_cd", getCntCd());
		this.hashColumns.put("esig_desc", getEsigDesc());
		this.hashColumns.put("init_file_sav_id", getInitFileSavId());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("esig_n1st_nm", getEsigN1stNm());
		this.hashColumns.put("init_file_path_rmk", getInitFilePathRmk());
		this.hashColumns.put("region_nm", getRegionNm());		//SJH.20141114.ADD 
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("esig_file_path_rmk", "esigFilePathRmk");
		this.hashFields.put("bl_esig_seq", "blEsigSeq");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("esig_file_nm", "esigFileNm");
		this.hashFields.put("esig_file_sav_id", "esigFileSavId");
		this.hashFields.put("esig_lst_nm", "esigLstNm");
		this.hashFields.put("init_file_nm", "initFileNm");
		this.hashFields.put("esig_server_path", "esigServerPath");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("init_server_path", "initServerPath");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("act_flg", "actFlg");
		this.hashFields.put("cnt_cd", "cntCd");
		this.hashFields.put("esig_desc", "esigDesc");
		this.hashFields.put("init_file_sav_id", "initFileSavId");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("esig_n1st_nm", "esigN1stNm");
		this.hashFields.put("init_file_path_rmk", "initFilePathRmk");
		this.hashFields.put("region_nm", "regionNm");			//SJH.20141114.ADD
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
	 * @return esigFilePathRmk
	 */
	public String getEsigFilePathRmk() {
		return this.esigFilePathRmk;
	}
	
	/**
	 * Column Info
	 * @return blEsigSeq
	 */
	public String getBlEsigSeq() {
		return this.blEsigSeq;
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
	 * @return esigFileNm
	 */
	public String getEsigFileNm() {
		return this.esigFileNm;
	}
	
	/**
	 * Column Info
	 * @return esigFileSavId
	 */
	public String getEsigFileSavId() {
		return this.esigFileSavId;
	}
	
	/**
	 * Column Info
	 * @return esigLstNm
	 */
	public String getEsigLstNm() {
		return this.esigLstNm;
	}
	
	/**
	 * Column Info
	 * @return initFileNm
	 */
	public String getInitFileNm() {
		return this.initFileNm;
	}
	
	/**
	 * Column Info
	 * @return esigServerPath
	 */
	public String getEsigServerPath() {
		return this.esigServerPath;
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
	 * @return initServerPath
	 */
	public String getInitServerPath() {
		return this.initServerPath;
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
	 * @return actFlg
	 */
	public String getActFlg() {
		return this.actFlg;
	}
	
	/**
	 * Column Info
	 * @return cntCd
	 */
	public String getCntCd() {
		return this.cntCd;
	}
	
	/**
	 * Column Info
	 * @return esigDesc
	 */
	public String getEsigDesc() {
		return this.esigDesc;
	}
	
	/**
	 * Column Info
	 * @return initFileSavId
	 */
	public String getInitFileSavId() {
		return this.initFileSavId;
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
	 * @return esigN1stNm
	 */
	public String getEsigN1stNm() {
		return this.esigN1stNm;
	}
	
	/**
	 * Column Info
	 * @return initFilePathRmk
	 */
	public String getInitFilePathRmk() {
		return this.initFilePathRmk;
	}
	
	/**
	 * Column Info
	 * @return regionNm
	 * @author SJH.20141114.ADD
	 */
	public String getRegionNm() {
		return this.regionNm;
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
	 * @param esigFilePathRmk
	 */
	public void setEsigFilePathRmk(String esigFilePathRmk) {
		this.esigFilePathRmk = esigFilePathRmk;
	}
	
	/**
	 * Column Info
	 * @param blEsigSeq
	 */
	public void setBlEsigSeq(String blEsigSeq) {
		this.blEsigSeq = blEsigSeq;
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
	 * @param esigFileNm
	 */
	public void setEsigFileNm(String esigFileNm) {
		this.esigFileNm = esigFileNm;
	}
	
	/**
	 * Column Info
	 * @param esigFileSavId
	 */
	public void setEsigFileSavId(String esigFileSavId) {
		this.esigFileSavId = esigFileSavId;
	}
	
	/**
	 * Column Info
	 * @param esigLstNm
	 */
	public void setEsigLstNm(String esigLstNm) {
		this.esigLstNm = esigLstNm;
	}
	
	/**
	 * Column Info
	 * @param initFileNm
	 */
	public void setInitFileNm(String initFileNm) {
		this.initFileNm = initFileNm;
	}
	
	/**
	 * Column Info
	 * @param esigServerPath
	 */
	public void setEsigServerPath(String esigServerPath) {
		this.esigServerPath = esigServerPath;
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
	 * @param initServerPath
	 */
	public void setInitServerPath(String initServerPath) {
		this.initServerPath = initServerPath;
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
	 * @param actFlg
	 */
	public void setActFlg(String actFlg) {
		this.actFlg = actFlg;
	}
	
	/**
	 * Column Info
	 * @param cntCd
	 */
	public void setCntCd(String cntCd) {
		this.cntCd = cntCd;
	}
	
	/**
	 * Column Info
	 * @param esigDesc
	 */
	public void setEsigDesc(String esigDesc) {
		this.esigDesc = esigDesc;
	}
	
	/**
	 * Column Info
	 * @param initFileSavId
	 */
	public void setInitFileSavId(String initFileSavId) {
		this.initFileSavId = initFileSavId;
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
	 * @param esigN1stNm
	 */
	public void setEsigN1stNm(String esigN1stNm) {
		this.esigN1stNm = esigN1stNm;
	}
	
	/**
	 * Column Info
	 * @param initFilePathRmk
	 */
	public void setInitFilePathRmk(String initFilePathRmk) {
		this.initFilePathRmk = initFilePathRmk;
	}
	
	/**
	 * Column Info
	 * @param regionNm
	 * @author SJH.20141114.ADD
	 */
	public void setRegionNm(String regionNm) {
		this.regionNm = regionNm;
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
		setEsigFilePathRmk(JSPUtil.getParameter(request, prefix + "esig_file_path_rmk", ""));
		setBlEsigSeq(JSPUtil.getParameter(request, prefix + "bl_esig_seq", ""));
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
		setEsigFileNm(JSPUtil.getParameter(request, prefix + "esig_file_nm", ""));
		setEsigFileSavId(JSPUtil.getParameter(request, prefix + "esig_file_sav_id", ""));
		setEsigLstNm(JSPUtil.getParameter(request, prefix + "esig_lst_nm", ""));
		setInitFileNm(JSPUtil.getParameter(request, prefix + "init_file_nm", ""));
		setEsigServerPath(JSPUtil.getParameter(request, prefix + "esig_server_path", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setInitServerPath(JSPUtil.getParameter(request, prefix + "init_server_path", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setActFlg(JSPUtil.getParameter(request, prefix + "act_flg", ""));
		setCntCd(JSPUtil.getParameter(request, prefix + "cnt_cd", ""));
		setEsigDesc(JSPUtil.getParameter(request, prefix + "esig_desc", ""));
		setInitFileSavId(JSPUtil.getParameter(request, prefix + "init_file_sav_id", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setEsigN1stNm(JSPUtil.getParameter(request, prefix + "esig_n1st_nm", ""));
		setInitFilePathRmk(JSPUtil.getParameter(request, prefix + "init_file_path_rmk", ""));
		setRegionNm(JSPUtil.getParameter(request, prefix + "init_file_path_rmk", ""));		//SJH.20141114.ADD
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchBlESignatureListVO[]
	 */
	public BlESignatureVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return BlESignatureVO[]
	 */
	public BlESignatureVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		BlESignatureVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] esigFilePathRmk = (JSPUtil.getParameter(request, prefix	+ "esig_file_path_rmk", length));
			String[] blEsigSeq = (JSPUtil.getParameter(request, prefix	+ "bl_esig_seq", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] esigFileNm = (JSPUtil.getParameter(request, prefix	+ "esig_file_nm", length));
			String[] esigFileSavId = (JSPUtil.getParameter(request, prefix	+ "esig_file_sav_id", length));
			String[] esigLstNm = (JSPUtil.getParameter(request, prefix	+ "esig_lst_nm", length));
			String[] initFileNm = (JSPUtil.getParameter(request, prefix	+ "init_file_nm", length));
			String[] esigServerPath = (JSPUtil.getParameter(request, prefix	+ "esig_server_path", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] initServerPath = (JSPUtil.getParameter(request, prefix	+ "init_server_path", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] actFlg = (JSPUtil.getParameter(request, prefix	+ "act_flg", length));
			String[] cntCd = (JSPUtil.getParameter(request, prefix	+ "cnt_cd", length));
			String[] esigDesc = (JSPUtil.getParameter(request, prefix	+ "esig_desc", length));
			String[] initFileSavId = (JSPUtil.getParameter(request, prefix	+ "init_file_sav_id", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] esigN1stNm = (JSPUtil.getParameter(request, prefix	+ "esig_n1st_nm", length));
			String[] initFilePathRmk = (JSPUtil.getParameter(request, prefix	+ "init_file_path_rmk", length));
			String[] regionNm = (JSPUtil.getParameter(request, prefix	+ "region_nm", length));		//SJH.20141114.ADD
				
			for (int i = 0; i < length; i++) {
				model = new BlESignatureVO();
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (esigFilePathRmk[i] != null)
					model.setEsigFilePathRmk(esigFilePathRmk[i]);
				if (blEsigSeq[i] != null)
					model.setBlEsigSeq(blEsigSeq[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (esigFileNm[i] != null)
					model.setEsigFileNm(esigFileNm[i]);
				if (esigFileSavId[i] != null)
					model.setEsigFileSavId(esigFileSavId[i]);
				if (esigLstNm[i] != null)
					model.setEsigLstNm(esigLstNm[i]);
				if (initFileNm[i] != null)
					model.setInitFileNm(initFileNm[i]);
				if (esigServerPath[i] != null)
					model.setEsigServerPath(esigServerPath[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (initServerPath[i] != null)
					model.setInitServerPath(initServerPath[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (actFlg[i] != null)
					model.setActFlg(actFlg[i]);
				if (cntCd[i] != null)
					model.setCntCd(cntCd[i]);
				if (esigDesc[i] != null)
					model.setEsigDesc(esigDesc[i]);
				if (initFileSavId[i] != null)
					model.setInitFileSavId(initFileSavId[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (esigN1stNm[i] != null)
					model.setEsigN1stNm(esigN1stNm[i]);
				if (initFilePathRmk[i] != null)
					model.setInitFilePathRmk(initFilePathRmk[i]);
				if (regionNm[i] != null)
					model.setRegionNm(regionNm[i]);					//SJH.20141114.ADD
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchBlESignatureListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return BlESignatureVO[]
	 */
	public BlESignatureVO[] getSearchBlESignatureListVOs(){
		BlESignatureVO[] vos = (BlESignatureVO[])models.toArray(new BlESignatureVO[models.size()]);
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
		this.esigFilePathRmk = this.esigFilePathRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blEsigSeq = this.blEsigSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.esigFileNm = this.esigFileNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.esigFileSavId = this.esigFileSavId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.esigLstNm = this.esigLstNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.initFileNm = this.initFileNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.esigServerPath = this.esigServerPath .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.initServerPath = this.initServerPath .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actFlg = this.actFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntCd = this.cntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.esigDesc = this.esigDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.initFileSavId = this.initFileSavId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.esigN1stNm = this.esigN1stNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.initFilePathRmk = this.initFilePathRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.regionNm = this.regionNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");	//SJH.20141114.ADD
	}
}
