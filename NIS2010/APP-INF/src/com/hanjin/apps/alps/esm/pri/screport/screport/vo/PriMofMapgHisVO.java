/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : PriMofMapgHisVO.java
*@FileTitle : PriMofMapgHisVO
*Open Issues :
*Change history :
*@LastModifyDate : 2016.09.20
*@LastModifier : 
*@LastVersion : 1.0
* 2016.09.20  
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

public class PriMofMapgHisVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<PriMofMapgHisVO> models = new ArrayList<PriMofMapgHisVO>();
	
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String deltFlg = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String updTpNm = null;
	/* Column Info */
	private String mapgRmk = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String mapgTpCd = null;
	/* Column Info */
	private String creUsrId = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String hjsId = null;
	/* Column Info */
	private String creOfcCd = null;
	/* Column Info */
	private String lstEvntDt = null;
	/* Column Info */
	private String fileUseOnyFlg = null;
	/* Column Info */
	private String mapgSeq = null;
	/* Column Info */
	private String hisSeq = null;
	/* Column Info */
	private String mofId = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String updOfcCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public PriMofMapgHisVO() {}

	public PriMofMapgHisVO(String ibflag, String pagerows, String mapgTpCd, String mapgSeq, String hisSeq, String updTpNm, String lstEvntDt, String mofId, String hjsId, String mapgRmk, String fileUseOnyFlg, String deltFlg, String creOfcCd, String updOfcCd, String creUsrId, String creDt, String updUsrId, String updDt) {
		this.updDt = updDt;
		this.deltFlg = deltFlg;
		this.creDt = creDt;
		this.updTpNm = updTpNm;
		this.mapgRmk = mapgRmk;
		this.pagerows = pagerows;
		this.mapgTpCd = mapgTpCd;
		this.creUsrId = creUsrId;
		this.ibflag = ibflag;
		this.hjsId = hjsId;
		this.creOfcCd = creOfcCd;
		this.lstEvntDt = lstEvntDt;
		this.fileUseOnyFlg = fileUseOnyFlg;
		this.mapgSeq = mapgSeq;
		this.hisSeq = hisSeq;
		this.mofId = mofId;
		this.updUsrId = updUsrId;
		this.updOfcCd = updOfcCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("delt_flg", getDeltFlg());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("upd_tp_nm", getUpdTpNm());
		this.hashColumns.put("mapg_rmk", getMapgRmk());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("mapg_tp_cd", getMapgTpCd());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("hjs_id", getHjsId());
		this.hashColumns.put("cre_ofc_cd", getCreOfcCd());
		this.hashColumns.put("lst_evnt_dt", getLstEvntDt());
		this.hashColumns.put("file_use_ony_flg", getFileUseOnyFlg());
		this.hashColumns.put("mapg_seq", getMapgSeq());
		this.hashColumns.put("his_seq", getHisSeq());
		this.hashColumns.put("mof_id", getMofId());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("upd_ofc_cd", getUpdOfcCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("delt_flg", "deltFlg");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("upd_tp_nm", "updTpNm");
		this.hashFields.put("mapg_rmk", "mapgRmk");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("mapg_tp_cd", "mapgTpCd");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("hjs_id", "hjsId");
		this.hashFields.put("cre_ofc_cd", "creOfcCd");
		this.hashFields.put("lst_evnt_dt", "lstEvntDt");
		this.hashFields.put("file_use_ony_flg", "fileUseOnyFlg");
		this.hashFields.put("mapg_seq", "mapgSeq");
		this.hashFields.put("his_seq", "hisSeq");
		this.hashFields.put("mof_id", "mofId");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("upd_ofc_cd", "updOfcCd");
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
	 * @return updTpNm
	 */
	public String getUpdTpNm() {
		return this.updTpNm;
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
	 * @return mapgTpCd
	 */
	public String getMapgTpCd() {
		return this.mapgTpCd;
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
	 * @return hjsId
	 */
	public String getHjsId() {
		return this.hjsId;
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
	 * @return lstEvntDt
	 */
	public String getLstEvntDt() {
		return this.lstEvntDt;
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
	 * @return hisSeq
	 */
	public String getHisSeq() {
		return this.hisSeq;
	}
	
	/**
	 * Column Info
	 * @return mofId
	 */
	public String getMofId() {
		return this.mofId;
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
	 * @param updDt
	 */
	public void setUpdDt(String updDt) {
		this.updDt = updDt;
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
	 * @param updTpNm
	 */
	public void setUpdTpNm(String updTpNm) {
		this.updTpNm = updTpNm;
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
	 * @param mapgTpCd
	 */
	public void setMapgTpCd(String mapgTpCd) {
		this.mapgTpCd = mapgTpCd;
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
	 * @param hjsId
	 */
	public void setHjsId(String hjsId) {
		this.hjsId = hjsId;
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
	 * @param lstEvntDt
	 */
	public void setLstEvntDt(String lstEvntDt) {
		this.lstEvntDt = lstEvntDt;
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
	 * @param hisSeq
	 */
	public void setHisSeq(String hisSeq) {
		this.hisSeq = hisSeq;
	}
	
	/**
	 * Column Info
	 * @param mofId
	 */
	public void setMofId(String mofId) {
		this.mofId = mofId;
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
		setDeltFlg(JSPUtil.getParameter(request, prefix + "delt_flg", ""));
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
		setUpdTpNm(JSPUtil.getParameter(request, prefix + "upd_tp_nm", ""));
		setMapgRmk(JSPUtil.getParameter(request, prefix + "mapg_rmk", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setMapgTpCd(JSPUtil.getParameter(request, prefix + "mapg_tp_cd", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setHjsId(JSPUtil.getParameter(request, prefix + "hjs_id", ""));
		setCreOfcCd(JSPUtil.getParameter(request, prefix + "cre_ofc_cd", ""));
		setLstEvntDt(JSPUtil.getParameter(request, prefix + "lst_evnt_dt", ""));
		setFileUseOnyFlg(JSPUtil.getParameter(request, prefix + "file_use_ony_flg", ""));
		setMapgSeq(JSPUtil.getParameter(request, prefix + "mapg_seq", ""));
		setHisSeq(JSPUtil.getParameter(request, prefix + "his_seq", ""));
		setMofId(JSPUtil.getParameter(request, prefix + "mof_id", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setUpdOfcCd(JSPUtil.getParameter(request, prefix + "upd_ofc_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return PriMofMapgHisVO[]
	 */
	public PriMofMapgHisVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return PriMofMapgHisVO[]
	 */
	public PriMofMapgHisVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		PriMofMapgHisVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] deltFlg = (JSPUtil.getParameter(request, prefix	+ "delt_flg", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] updTpNm = (JSPUtil.getParameter(request, prefix	+ "upd_tp_nm", length));
			String[] mapgRmk = (JSPUtil.getParameter(request, prefix	+ "mapg_rmk", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] mapgTpCd = (JSPUtil.getParameter(request, prefix	+ "mapg_tp_cd", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] hjsId = (JSPUtil.getParameter(request, prefix	+ "hjs_id", length));
			String[] creOfcCd = (JSPUtil.getParameter(request, prefix	+ "cre_ofc_cd", length));
			String[] lstEvntDt = (JSPUtil.getParameter(request, prefix	+ "lst_evnt_dt", length));
			String[] fileUseOnyFlg = (JSPUtil.getParameter(request, prefix	+ "file_use_ony_flg", length));
			String[] mapgSeq = (JSPUtil.getParameter(request, prefix	+ "mapg_seq", length));
			String[] hisSeq = (JSPUtil.getParameter(request, prefix	+ "his_seq", length));
			String[] mofId = (JSPUtil.getParameter(request, prefix	+ "mof_id", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] updOfcCd = (JSPUtil.getParameter(request, prefix	+ "upd_ofc_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new PriMofMapgHisVO();
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (deltFlg[i] != null)
					model.setDeltFlg(deltFlg[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (updTpNm[i] != null)
					model.setUpdTpNm(updTpNm[i]);
				if (mapgRmk[i] != null)
					model.setMapgRmk(mapgRmk[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (mapgTpCd[i] != null)
					model.setMapgTpCd(mapgTpCd[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (hjsId[i] != null)
					model.setHjsId(hjsId[i]);
				if (creOfcCd[i] != null)
					model.setCreOfcCd(creOfcCd[i]);
				if (lstEvntDt[i] != null)
					model.setLstEvntDt(lstEvntDt[i]);
				if (fileUseOnyFlg[i] != null)
					model.setFileUseOnyFlg(fileUseOnyFlg[i]);
				if (mapgSeq[i] != null)
					model.setMapgSeq(mapgSeq[i]);
				if (hisSeq[i] != null)
					model.setHisSeq(hisSeq[i]);
				if (mofId[i] != null)
					model.setMofId(mofId[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (updOfcCd[i] != null)
					model.setUpdOfcCd(updOfcCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getPriMofMapgHisVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return PriMofMapgHisVO[]
	 */
	public PriMofMapgHisVO[] getPriMofMapgHisVOs(){
		PriMofMapgHisVO[] vos = (PriMofMapgHisVO[])models.toArray(new PriMofMapgHisVO[models.size()]);
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
		this.deltFlg = this.deltFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updTpNm = this.updTpNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mapgRmk = this.mapgRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mapgTpCd = this.mapgTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hjsId = this.hjsId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creOfcCd = this.creOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lstEvntDt = this.lstEvntDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fileUseOnyFlg = this.fileUseOnyFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mapgSeq = this.mapgSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hisSeq = this.hisSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mofId = this.mofId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updOfcCd = this.updOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
