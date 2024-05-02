/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : IndonesiaManifestModificationVO.java
*@FileTitle : IndonesiaManifestModificationVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.07
*@LastModifier : 
*@LastVersion : 1.0
* 2009.10.07  
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.indonesia.vo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.vo.ManifestModificationVO;
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

public class IndonesiaManifestModificationVO extends ManifestModificationVO {

	private static final long serialVersionUID = 1L;
	
	private Collection<IndonesiaManifestModificationVO> models = new ArrayList<IndonesiaManifestModificationVO>();
	
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String idXptNoIssDt = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String ioBndCd = null;
	/* Column Info */
	private String xptImpSeq = null;
	/* Column Info */
	private String idOfcCd = null;
	/* Page Number */
	private String pagerows = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String idXptNo = null;
	/* Column Info */
	private String idDeclCd = null;
	/* Column Info */
	private String updUsrId = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public IndonesiaManifestModificationVO() {}

	public IndonesiaManifestModificationVO(String ibflag, String pagerows, String bkgNo, String ioBndCd, String xptImpSeq, String idDeclCd, String idXptNo, String idXptNoIssDt, String idOfcCd, String creUsrId, String creDt, String updUsrId, String updDt) {
		this.updDt = updDt;
		this.idXptNoIssDt = idXptNoIssDt;
		this.creDt = creDt;
		this.ioBndCd = ioBndCd;
		this.xptImpSeq = xptImpSeq;
		this.idOfcCd = idOfcCd;
		this.pagerows = pagerows;
		this.ibflag = ibflag;
		this.bkgNo = bkgNo;
		this.creUsrId = creUsrId;
		this.idXptNo = idXptNo;
		this.idDeclCd = idDeclCd;
		this.updUsrId = updUsrId;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("id_xpt_no_iss_dt", getIdXptNoIssDt());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("io_bnd_cd", getIoBndCd());
		this.hashColumns.put("xpt_imp_seq", getXptImpSeq());
		this.hashColumns.put("id_ofc_cd", getIdOfcCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("id_xpt_no", getIdXptNo());
		this.hashColumns.put("id_decl_cd", getIdDeclCd());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("id_xpt_no_iss_dt", "idXptNoIssDt");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("io_bnd_cd", "ioBndCd");
		this.hashFields.put("xpt_imp_seq", "xptImpSeq");
		this.hashFields.put("id_ofc_cd", "idOfcCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("id_xpt_no", "idXptNo");
		this.hashFields.put("id_decl_cd", "idDeclCd");
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
	 * @return idXptNoIssDt
	 */
	public String getIdXptNoIssDt() {
		return this.idXptNoIssDt;
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
	 * @return ioBndCd
	 */
	public String getIoBndCd() {
		return this.ioBndCd;
	}
	
	/**
	 * Column Info
	 * @return xptImpSeq
	 */
	public String getXptImpSeq() {
		return this.xptImpSeq;
	}
	
	/**
	 * Column Info
	 * @return idOfcCd
	 */
	public String getIdOfcCd() {
		return this.idOfcCd;
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
	 * @return bkgNo
	 */
	public String getBkgNo() {
		return this.bkgNo;
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
	 * @return idXptNo
	 */
	public String getIdXptNo() {
		return this.idXptNo;
	}
	
	/**
	 * Column Info
	 * @return idDeclCd
	 */
	public String getIdDeclCd() {
		return this.idDeclCd;
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
	 * @param idXptNoIssDt
	 */
	public void setIdXptNoIssDt(String idXptNoIssDt) {
		this.idXptNoIssDt = idXptNoIssDt;
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
	 * @param ioBndCd
	 */
	public void setIoBndCd(String ioBndCd) {
		this.ioBndCd = ioBndCd;
	}
	
	/**
	 * Column Info
	 * @param xptImpSeq
	 */
	public void setXptImpSeq(String xptImpSeq) {
		this.xptImpSeq = xptImpSeq;
	}
	
	/**
	 * Column Info
	 * @param idOfcCd
	 */
	public void setIdOfcCd(String idOfcCd) {
		this.idOfcCd = idOfcCd;
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
	 * @param bkgNo
	 */
	public void setBkgNo(String bkgNo) {
		this.bkgNo = bkgNo;
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
	 * @param idXptNo
	 */
	public void setIdXptNo(String idXptNo) {
		this.idXptNo = idXptNo;
	}
	
	/**
	 * Column Info
	 * @param idDeclCd
	 */
	public void setIdDeclCd(String idDeclCd) {
		this.idDeclCd = idDeclCd;
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
		setUpdDt(JSPUtil.getParameter(request, "upd_dt", ""));
		setIdXptNoIssDt(JSPUtil.getParameter(request, "id_xpt_no_iss_dt", ""));
		setCreDt(JSPUtil.getParameter(request, "cre_dt", ""));
		setIoBndCd(JSPUtil.getParameter(request, "io_bnd_cd", ""));
		setXptImpSeq(JSPUtil.getParameter(request, "xpt_imp_seq", ""));
		setIdOfcCd(JSPUtil.getParameter(request, "id_ofc_cd", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setBkgNo(JSPUtil.getParameter(request, "bkg_no", ""));
		setCreUsrId(JSPUtil.getParameter(request, "cre_usr_id", ""));
		setIdXptNo(JSPUtil.getParameter(request, "id_xpt_no", ""));
		setIdDeclCd(JSPUtil.getParameter(request, "id_decl_cd", ""));
		setUpdUsrId(JSPUtil.getParameter(request, "upd_usr_id", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return IndonesiaManifestModificationVO[]
	 */
	public IndonesiaManifestModificationVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return IndonesiaManifestModificationVO[]
	 */
	public IndonesiaManifestModificationVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		IndonesiaManifestModificationVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] idXptNoIssDt = (JSPUtil.getParameter(request, prefix	+ "id_xpt_no_iss_dt", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] ioBndCd = (JSPUtil.getParameter(request, prefix	+ "io_bnd_cd", length));
			String[] xptImpSeq = (JSPUtil.getParameter(request, prefix	+ "xpt_imp_seq", length));
			String[] idOfcCd = (JSPUtil.getParameter(request, prefix	+ "id_ofc_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] idXptNo = (JSPUtil.getParameter(request, prefix	+ "id_xpt_no", length));
			String[] idDeclCd = (JSPUtil.getParameter(request, prefix	+ "id_decl_cd", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			
			for (int i = 0; i < length; i++) {
				model = new IndonesiaManifestModificationVO();
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (idXptNoIssDt[i] != null)
					model.setIdXptNoIssDt(idXptNoIssDt[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (ioBndCd[i] != null)
					model.setIoBndCd(ioBndCd[i]);
				if (xptImpSeq[i] != null)
					model.setXptImpSeq(xptImpSeq[i]);
				if (idOfcCd[i] != null)
					model.setIdOfcCd(idOfcCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (idXptNo[i] != null)
					model.setIdXptNo(idXptNo[i]);
				if (idDeclCd[i] != null)
					model.setIdDeclCd(idDeclCd[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getIndonesiaManifestModificationVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return IndonesiaManifestModificationVO[]
	 */
	public IndonesiaManifestModificationVO[] getIndonesiaManifestModificationVOs(){
		IndonesiaManifestModificationVO[] vos = (IndonesiaManifestModificationVO[])models.toArray(new IndonesiaManifestModificationVO[models.size()]);
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
		this.idXptNoIssDt = this.idXptNoIssDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ioBndCd = this.ioBndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.xptImpSeq = this.xptImpSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.idOfcCd = this.idOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.idXptNo = this.idXptNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.idDeclCd = this.idDeclCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
