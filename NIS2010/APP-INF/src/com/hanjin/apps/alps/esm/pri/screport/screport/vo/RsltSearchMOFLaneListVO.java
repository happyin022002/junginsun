/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : RsltSearchMOFLaneListVO.java
*@FileTitle : RsltSearchMOFLaneListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2016.09.19
*@LastModifier : 
*@LastVersion : 1.0
* 2016.09.19  
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.pri.screport.screport.vo;

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

public class RsltSearchMOFLaneListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<RsltSearchMOFLaneListVO> models = new ArrayList<RsltSearchMOFLaneListVO>();
	
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String mofLocId = null;
	/* Column Info */
	private String deltFlg = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String orgDestTpCd = null;
	/* Column Info */
	private String mofLaneCd = null;
	/* Column Info */
	private String mofLocNm = null;
	/* Column Info */
	private String creUsrNm = null;
	/* Column Info */
	private String mapgRmk = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String creUsrId = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String locCd = null;
	/* Column Info */
	private String creOfcCd = null;
	/* Column Info */
	private String fileUseOnyFlg = null;
	/* Column Info */
	private String mapgSeq = null;
	/* Column Info */
	private String updUsrNm = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String updOfcCd = null;
	/* Column Info */
	private String mofLaneNm = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public RsltSearchMOFLaneListVO() {}

	public RsltSearchMOFLaneListVO(String ibflag, String pagerows, String orgDestTpCd, String mapgSeq, String locCd, String mofLaneCd, String mofLaneNm, String mofLocId, String mofLocNm, String mapgRmk, String fileUseOnyFlg, String deltFlg, String creOfcCd, String creUsrId, String creUsrNm, String creDt, String updOfcCd, String updUsrId, String updUsrNm, String updDt) {
		this.updDt = updDt;
		this.mofLocId = mofLocId;
		this.deltFlg = deltFlg;
		this.creDt = creDt;
		this.orgDestTpCd = orgDestTpCd;
		this.mofLaneCd = mofLaneCd;
		this.mofLocNm = mofLocNm;
		this.creUsrNm = creUsrNm;
		this.mapgRmk = mapgRmk;
		this.pagerows = pagerows;
		this.creUsrId = creUsrId;
		this.ibflag = ibflag;
		this.locCd = locCd;
		this.creOfcCd = creOfcCd;
		this.fileUseOnyFlg = fileUseOnyFlg;
		this.mapgSeq = mapgSeq;
		this.updUsrNm = updUsrNm;
		this.updUsrId = updUsrId;
		this.updOfcCd = updOfcCd;
		this.mofLaneNm = mofLaneNm;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("mof_loc_id", getMofLocId());
		this.hashColumns.put("delt_flg", getDeltFlg());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("org_dest_tp_cd", getOrgDestTpCd());
		this.hashColumns.put("mof_lane_cd", getMofLaneCd());
		this.hashColumns.put("mof_loc_nm", getMofLocNm());
		this.hashColumns.put("cre_usr_nm", getCreUsrNm());
		this.hashColumns.put("mapg_rmk", getMapgRmk());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("loc_cd", getLocCd());
		this.hashColumns.put("cre_ofc_cd", getCreOfcCd());
		this.hashColumns.put("file_use_ony_flg", getFileUseOnyFlg());
		this.hashColumns.put("mapg_seq", getMapgSeq());
		this.hashColumns.put("upd_usr_nm", getUpdUsrNm());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("upd_ofc_cd", getUpdOfcCd());
		this.hashColumns.put("mof_lane_nm", getMofLaneNm());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("mof_loc_id", "mofLocId");
		this.hashFields.put("delt_flg", "deltFlg");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("org_dest_tp_cd", "orgDestTpCd");
		this.hashFields.put("mof_lane_cd", "mofLaneCd");
		this.hashFields.put("mof_loc_nm", "mofLocNm");
		this.hashFields.put("cre_usr_nm", "creUsrNm");
		this.hashFields.put("mapg_rmk", "mapgRmk");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("loc_cd", "locCd");
		this.hashFields.put("cre_ofc_cd", "creOfcCd");
		this.hashFields.put("file_use_ony_flg", "fileUseOnyFlg");
		this.hashFields.put("mapg_seq", "mapgSeq");
		this.hashFields.put("upd_usr_nm", "updUsrNm");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("upd_ofc_cd", "updOfcCd");
		this.hashFields.put("mof_lane_nm", "mofLaneNm");
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
	 * @return mofLocId
	 */
	public String getMofLocId() {
		return this.mofLocId;
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
	 * @return creDt
	 */
	public String getCreDt() {
		return this.creDt;
	}
	
	/**
	 * Column Info
	 * @return orgDestTpCd
	 */
	public String getOrgDestTpCd() {
		return this.orgDestTpCd;
	}
	
	/**
	 * Column Info
	 * @return mofLaneCd
	 */
	public String getMofLaneCd() {
		return this.mofLaneCd;
	}
	
	/**
	 * Column Info
	 * @return mofLocNm
	 */
	public String getMofLocNm() {
		return this.mofLocNm;
	}
	
	/**
	 * Column Info
	 * @return creUsrNm
	 */
	public String getCreUsrNm() {
		return this.creUsrNm;
	}
	
	/**
	 * Column Info
	 * @return mapgRmk
	 */
	public String getMapgRmk() {
		return this.mapgRmk;
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
	 * @return locCd
	 */
	public String getLocCd() {
		return this.locCd;
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
	 * @return fileUseOnyFlg
	 */
	public String getFileUseOnyFlg() {
		return this.fileUseOnyFlg;
	}
	
	/**
	 * Column Info
	 * @return mapgSeq
	 */
	public String getMapgSeq() {
		return this.mapgSeq;
	}
	
	/**
	 * Column Info
	 * @return updUsrNm
	 */
	public String getUpdUsrNm() {
		return this.updUsrNm;
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
	 * @return updOfcCd
	 */
	public String getUpdOfcCd() {
		return this.updOfcCd;
	}
	
	/**
	 * Column Info
	 * @return mofLaneNm
	 */
	public String getMofLaneNm() {
		return this.mofLaneNm;
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
	 * @param mofLocId
	 */
	public void setMofLocId(String mofLocId) {
		this.mofLocId = mofLocId;
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
	 * @param creDt
	 */
	public void setCreDt(String creDt) {
		this.creDt = creDt;
	}
	
	/**
	 * Column Info
	 * @param orgDestTpCd
	 */
	public void setOrgDestTpCd(String orgDestTpCd) {
		this.orgDestTpCd = orgDestTpCd;
	}
	
	/**
	 * Column Info
	 * @param mofLaneCd
	 */
	public void setMofLaneCd(String mofLaneCd) {
		this.mofLaneCd = mofLaneCd;
	}
	
	/**
	 * Column Info
	 * @param mofLocNm
	 */
	public void setMofLocNm(String mofLocNm) {
		this.mofLocNm = mofLocNm;
	}
	
	/**
	 * Column Info
	 * @param creUsrNm
	 */
	public void setCreUsrNm(String creUsrNm) {
		this.creUsrNm = creUsrNm;
	}
	
	/**
	 * Column Info
	 * @param mapgRmk
	 */
	public void setMapgRmk(String mapgRmk) {
		this.mapgRmk = mapgRmk;
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
	 * @param locCd
	 */
	public void setLocCd(String locCd) {
		this.locCd = locCd;
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
	 * @param fileUseOnyFlg
	 */
	public void setFileUseOnyFlg(String fileUseOnyFlg) {
		this.fileUseOnyFlg = fileUseOnyFlg;
	}
	
	/**
	 * Column Info
	 * @param mapgSeq
	 */
	public void setMapgSeq(String mapgSeq) {
		this.mapgSeq = mapgSeq;
	}
	
	/**
	 * Column Info
	 * @param updUsrNm
	 */
	public void setUpdUsrNm(String updUsrNm) {
		this.updUsrNm = updUsrNm;
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
	 * @param updOfcCd
	 */
	public void setUpdOfcCd(String updOfcCd) {
		this.updOfcCd = updOfcCd;
	}
	
	/**
	 * Column Info
	 * @param mofLaneNm
	 */
	public void setMofLaneNm(String mofLaneNm) {
		this.mofLaneNm = mofLaneNm;
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
		setMofLocId(JSPUtil.getParameter(request, prefix + "mof_loc_id", ""));
		setDeltFlg(JSPUtil.getParameter(request, prefix + "delt_flg", ""));
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
		setOrgDestTpCd(JSPUtil.getParameter(request, prefix + "org_dest_tp_cd", ""));
		setMofLaneCd(JSPUtil.getParameter(request, prefix + "mof_lane_cd", ""));
		setMofLocNm(JSPUtil.getParameter(request, prefix + "mof_loc_nm", ""));
		setCreUsrNm(JSPUtil.getParameter(request, prefix + "cre_usr_nm", ""));
		setMapgRmk(JSPUtil.getParameter(request, prefix + "mapg_rmk", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setLocCd(JSPUtil.getParameter(request, prefix + "loc_cd", ""));
		setCreOfcCd(JSPUtil.getParameter(request, prefix + "cre_ofc_cd", ""));
		setFileUseOnyFlg(JSPUtil.getParameter(request, prefix + "file_use_ony_flg", ""));
		setMapgSeq(JSPUtil.getParameter(request, prefix + "mapg_seq", ""));
		setUpdUsrNm(JSPUtil.getParameter(request, prefix + "upd_usr_nm", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setUpdOfcCd(JSPUtil.getParameter(request, prefix + "upd_ofc_cd", ""));
		setMofLaneNm(JSPUtil.getParameter(request, prefix + "mof_lane_nm", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return RsltSearchMOFLaneListVO[]
	 */
	public RsltSearchMOFLaneListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return RsltSearchMOFLaneListVO[]
	 */
	public RsltSearchMOFLaneListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		RsltSearchMOFLaneListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] mofLocId = (JSPUtil.getParameter(request, prefix	+ "mof_loc_id", length));
			String[] deltFlg = (JSPUtil.getParameter(request, prefix	+ "delt_flg", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] orgDestTpCd = (JSPUtil.getParameter(request, prefix	+ "org_dest_tp_cd", length));
			String[] mofLaneCd = (JSPUtil.getParameter(request, prefix	+ "mof_lane_cd", length));
			String[] mofLocNm = (JSPUtil.getParameter(request, prefix	+ "mof_loc_nm", length));
			String[] creUsrNm = (JSPUtil.getParameter(request, prefix	+ "cre_usr_nm", length));
			String[] mapgRmk = (JSPUtil.getParameter(request, prefix	+ "mapg_rmk", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] locCd = (JSPUtil.getParameter(request, prefix	+ "loc_cd", length));
			String[] creOfcCd = (JSPUtil.getParameter(request, prefix	+ "cre_ofc_cd", length));
			String[] fileUseOnyFlg = (JSPUtil.getParameter(request, prefix	+ "file_use_ony_flg", length));
			String[] mapgSeq = (JSPUtil.getParameter(request, prefix	+ "mapg_seq", length));
			String[] updUsrNm = (JSPUtil.getParameter(request, prefix	+ "upd_usr_nm", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] updOfcCd = (JSPUtil.getParameter(request, prefix	+ "upd_ofc_cd", length));
			String[] mofLaneNm = (JSPUtil.getParameter(request, prefix	+ "mof_lane_nm", length));
			
			for (int i = 0; i < length; i++) {
				model = new RsltSearchMOFLaneListVO();
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (mofLocId[i] != null)
					model.setMofLocId(mofLocId[i]);
				if (deltFlg[i] != null)
					model.setDeltFlg(deltFlg[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (orgDestTpCd[i] != null)
					model.setOrgDestTpCd(orgDestTpCd[i]);
				if (mofLaneCd[i] != null)
					model.setMofLaneCd(mofLaneCd[i]);
				if (mofLocNm[i] != null)
					model.setMofLocNm(mofLocNm[i]);
				if (creUsrNm[i] != null)
					model.setCreUsrNm(creUsrNm[i]);
				if (mapgRmk[i] != null)
					model.setMapgRmk(mapgRmk[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (locCd[i] != null)
					model.setLocCd(locCd[i]);
				if (creOfcCd[i] != null)
					model.setCreOfcCd(creOfcCd[i]);
				if (fileUseOnyFlg[i] != null)
					model.setFileUseOnyFlg(fileUseOnyFlg[i]);
				if (mapgSeq[i] != null)
					model.setMapgSeq(mapgSeq[i]);
				if (updUsrNm[i] != null)
					model.setUpdUsrNm(updUsrNm[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (updOfcCd[i] != null)
					model.setUpdOfcCd(updOfcCd[i]);
				if (mofLaneNm[i] != null)
					model.setMofLaneNm(mofLaneNm[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getRsltSearchMOFLaneListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return RsltSearchMOFLaneListVO[]
	 */
	public RsltSearchMOFLaneListVO[] getRsltSearchMOFLaneListVOs(){
		RsltSearchMOFLaneListVO[] vos = (RsltSearchMOFLaneListVO[])models.toArray(new RsltSearchMOFLaneListVO[models.size()]);
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
		this.mofLocId = this.mofLocId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.deltFlg = this.deltFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgDestTpCd = this.orgDestTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mofLaneCd = this.mofLaneCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mofLocNm = this.mofLocNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrNm = this.creUsrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mapgRmk = this.mapgRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.locCd = this.locCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creOfcCd = this.creOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fileUseOnyFlg = this.fileUseOnyFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mapgSeq = this.mapgSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrNm = this.updUsrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updOfcCd = this.updOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mofLaneNm = this.mofLaneNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
