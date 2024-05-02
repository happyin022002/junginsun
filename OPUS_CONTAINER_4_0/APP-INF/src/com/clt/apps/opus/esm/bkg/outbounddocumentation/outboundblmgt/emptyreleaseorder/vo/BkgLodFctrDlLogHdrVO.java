/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : BkgLodFctrDlLogHdrVO.java
*@FileTitle : BkgLodFctrDlLogHdrVO
*Open Issues :
*Change history :
*@LastModifyDate : 2015.10.15
*@LastModifier : 이도형
*@LastVersion : 1.0
* 2015.10.15 이도형 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.emptyreleaseorder.vo;

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
 * @author 이도형
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class BkgLodFctrDlLogHdrVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<BkgLodFctrDlLogHdrVO> models = new ArrayList<BkgLodFctrDlLogHdrVO>();
	
	/* Column Info */
	private String bkgOfcCd = null;
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String edwUpdDt = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String bkgFmDt = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String ldfDlDt = null;
	/* Column Info */
	private String fileDlFlg = null;
	/* Column Info */
	private String bkgToDt = null;
	/* Column Info */
	private String fileDlNm = null;
	/* Column Info */
	private String updUsrId = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public BkgLodFctrDlLogHdrVO() {}

	public BkgLodFctrDlLogHdrVO(String ibflag, String pagerows, String ldfDlDt, String bkgOfcCd, String fileDlNm, String fileDlFlg, String bkgFmDt, String bkgToDt, String creUsrId, String creDt, String updUsrId, String updDt, String edwUpdDt) {
		this.bkgOfcCd = bkgOfcCd;
		this.updDt = updDt;
		this.creDt = creDt;
		this.edwUpdDt = edwUpdDt;
		this.pagerows = pagerows;
		this.bkgFmDt = bkgFmDt;
		this.ibflag = ibflag;
		this.creUsrId = creUsrId;
		this.ldfDlDt = ldfDlDt;
		this.fileDlFlg = fileDlFlg;
		this.bkgToDt = bkgToDt;
		this.fileDlNm = fileDlNm;
		this.updUsrId = updUsrId;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("bkg_ofc_cd", getBkgOfcCd());
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("edw_upd_dt", getEdwUpdDt());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("bkg_fm_dt", getBkgFmDt());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("ldf_dl_dt", getLdfDlDt());
		this.hashColumns.put("file_dl_flg", getFileDlFlg());
		this.hashColumns.put("bkg_to_dt", getBkgToDt());
		this.hashColumns.put("file_dl_nm", getFileDlNm());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("bkg_ofc_cd", "bkgOfcCd");
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("edw_upd_dt", "edwUpdDt");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("bkg_fm_dt", "bkgFmDt");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("ldf_dl_dt", "ldfDlDt");
		this.hashFields.put("file_dl_flg", "fileDlFlg");
		this.hashFields.put("bkg_to_dt", "bkgToDt");
		this.hashFields.put("file_dl_nm", "fileDlNm");
		this.hashFields.put("upd_usr_id", "updUsrId");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return bkgOfcCd
	 */
	public String getBkgOfcCd() {
		return this.bkgOfcCd;
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
	 * @return creDt
	 */
	public String getCreDt() {
		return this.creDt;
	}
	
	/**
	 * Column Info
	 * @return edwUpdDt
	 */
	public String getEdwUpdDt() {
		return this.edwUpdDt;
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
	 * @return bkgFmDt
	 */
	public String getBkgFmDt() {
		return this.bkgFmDt;
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
	 * @return ldfDlDt
	 */
	public String getLdfDlDt() {
		return this.ldfDlDt;
	}
	
	/**
	 * Column Info
	 * @return fileDlFlg
	 */
	public String getFileDlFlg() {
		return this.fileDlFlg;
	}
	
	/**
	 * Column Info
	 * @return bkgToDt
	 */
	public String getBkgToDt() {
		return this.bkgToDt;
	}
	
	/**
	 * Column Info
	 * @return fileDlNm
	 */
	public String getFileDlNm() {
		return this.fileDlNm;
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
	 * @param bkgOfcCd
	 */
	public void setBkgOfcCd(String bkgOfcCd) {
		this.bkgOfcCd = bkgOfcCd;
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
	 * @param creDt
	 */
	public void setCreDt(String creDt) {
		this.creDt = creDt;
	}
	
	/**
	 * Column Info
	 * @param edwUpdDt
	 */
	public void setEdwUpdDt(String edwUpdDt) {
		this.edwUpdDt = edwUpdDt;
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
	 * @param bkgFmDt
	 */
	public void setBkgFmDt(String bkgFmDt) {
		this.bkgFmDt = bkgFmDt;
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
	 * @param ldfDlDt
	 */
	public void setLdfDlDt(String ldfDlDt) {
		this.ldfDlDt = ldfDlDt;
	}
	
	/**
	 * Column Info
	 * @param fileDlFlg
	 */
	public void setFileDlFlg(String fileDlFlg) {
		this.fileDlFlg = fileDlFlg;
	}
	
	/**
	 * Column Info
	 * @param bkgToDt
	 */
	public void setBkgToDt(String bkgToDt) {
		this.bkgToDt = bkgToDt;
	}
	
	/**
	 * Column Info
	 * @param fileDlNm
	 */
	public void setFileDlNm(String fileDlNm) {
		this.fileDlNm = fileDlNm;
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
		setBkgOfcCd(JSPUtil.getParameter(request, prefix + "bkg_ofc_cd", ""));
		setUpdDt(JSPUtil.getParameter(request, prefix + "upd_dt", ""));
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
		setEdwUpdDt(JSPUtil.getParameter(request, prefix + "edw_upd_dt", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setBkgFmDt(JSPUtil.getParameter(request, prefix + "bkg_fm_dt", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setLdfDlDt(JSPUtil.getParameter(request, prefix + "ldf_dl_dt", ""));
		setFileDlFlg(JSPUtil.getParameter(request, prefix + "file_dl_flg", ""));
		setBkgToDt(JSPUtil.getParameter(request, prefix + "bkg_to_dt", ""));
		setFileDlNm(JSPUtil.getParameter(request, prefix + "file_dl_nm", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return BkgLodFctrDlLogHdrVO[]
	 */
	public BkgLodFctrDlLogHdrVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return BkgLodFctrDlLogHdrVO[]
	 */
	public BkgLodFctrDlLogHdrVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		BkgLodFctrDlLogHdrVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] bkgOfcCd = (JSPUtil.getParameter(request, prefix	+ "bkg_ofc_cd", length));
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] edwUpdDt = (JSPUtil.getParameter(request, prefix	+ "edw_upd_dt", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] bkgFmDt = (JSPUtil.getParameter(request, prefix	+ "bkg_fm_dt", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] ldfDlDt = (JSPUtil.getParameter(request, prefix	+ "ldf_dl_dt", length));
			String[] fileDlFlg = (JSPUtil.getParameter(request, prefix	+ "file_dl_flg", length));
			String[] bkgToDt = (JSPUtil.getParameter(request, prefix	+ "bkg_to_dt", length));
			String[] fileDlNm = (JSPUtil.getParameter(request, prefix	+ "file_dl_nm", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			
			for (int i = 0; i < length; i++) {
				model = new BkgLodFctrDlLogHdrVO();
				if (bkgOfcCd[i] != null)
					model.setBkgOfcCd(bkgOfcCd[i]);
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (edwUpdDt[i] != null)
					model.setEdwUpdDt(edwUpdDt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (bkgFmDt[i] != null)
					model.setBkgFmDt(bkgFmDt[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (ldfDlDt[i] != null)
					model.setLdfDlDt(ldfDlDt[i]);
				if (fileDlFlg[i] != null)
					model.setFileDlFlg(fileDlFlg[i]);
				if (bkgToDt[i] != null)
					model.setBkgToDt(bkgToDt[i]);
				if (fileDlNm[i] != null)
					model.setFileDlNm(fileDlNm[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getBkgLodFctrDlLogHdrVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return BkgLodFctrDlLogHdrVO[]
	 */
	public BkgLodFctrDlLogHdrVO[] getBkgLodFctrDlLogHdrVOs(){
		BkgLodFctrDlLogHdrVO[] vos = (BkgLodFctrDlLogHdrVO[])models.toArray(new BkgLodFctrDlLogHdrVO[models.size()]);
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
		this.bkgOfcCd = this.bkgOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.edwUpdDt = this.edwUpdDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgFmDt = this.bkgFmDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ldfDlDt = this.ldfDlDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fileDlFlg = this.fileDlFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgToDt = this.bkgToDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fileDlNm = this.fileDlNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
