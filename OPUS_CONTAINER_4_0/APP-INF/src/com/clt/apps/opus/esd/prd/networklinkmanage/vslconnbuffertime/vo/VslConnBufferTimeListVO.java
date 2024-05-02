/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : SearchVslConnBufferTimeListVO.java
*@FileTitle : SearchVslConnBufferTimeListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2016.05.02
*@LastModifier : 
*@LastVersion : 1.0
* 2016.05.02  
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esd.prd.networklinkmanage.vslconnbuffertime.vo;

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

public class VslConnBufferTimeListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<VslConnBufferTimeListVO> models = new ArrayList<VslConnBufferTimeListVO>();
	
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String vslCnnRmk = null;
	/* Column Info */
	private String dchgSlanCd = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String dchgTmlCd = null;
	/* Column Info */
	private String ioBndCd = null;
	/* Column Info */
	private String cnnBufHrs = null;
	/* Column Info */
	private String lodCntCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String dchgCntCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String lodTmlCd = null;
	/* Column Info */
	private String lodSlanCd = null;
	/* Column Info */
	private String vslCnnTpCd = null;
	/* Column Info */
	private String updUsrId = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public VslConnBufferTimeListVO() {}

	public VslConnBufferTimeListVO(String ibflag, String pagerows, String dchgCntCd, String dchgTmlCd, String dchgSlanCd, String ioBndCd, String lodCntCd, String lodTmlCd, String lodSlanCd, String cnnBufHrs, String vslCnnTpCd, String vslCnnRmk, String creUsrId, String creDt, String updUsrId, String updDt) {
		this.updDt = updDt;
		this.vslCnnRmk = vslCnnRmk;
		this.dchgSlanCd = dchgSlanCd;
		this.creDt = creDt;
		this.dchgTmlCd = dchgTmlCd;
		this.ioBndCd = ioBndCd;
		this.cnnBufHrs = cnnBufHrs;
		this.lodCntCd = lodCntCd;
		this.pagerows = pagerows;
		this.dchgCntCd = dchgCntCd;
		this.ibflag = ibflag;
		this.creUsrId = creUsrId;
		this.lodTmlCd = lodTmlCd;
		this.lodSlanCd = lodSlanCd;
		this.vslCnnTpCd = vslCnnTpCd;
		this.updUsrId = updUsrId;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("vsl_cnn_rmk", getVslCnnRmk());
		this.hashColumns.put("dchg_slan_cd", getDchgSlanCd());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("dchg_tml_cd", getDchgTmlCd());
		this.hashColumns.put("io_bnd_cd", getIoBndCd());
		this.hashColumns.put("cnn_buf_hrs", getCnnBufHrs());
		this.hashColumns.put("lod_cnt_cd", getLodCntCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("dchg_cnt_cd", getDchgCntCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("lod_tml_cd", getLodTmlCd());
		this.hashColumns.put("lod_slan_cd", getLodSlanCd());
		this.hashColumns.put("vsl_cnn_tp_cd", getVslCnnTpCd());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("vsl_cnn_rmk", "vslCnnRmk");
		this.hashFields.put("dchg_slan_cd", "dchgSlanCd");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("dchg_tml_cd", "dchgTmlCd");
		this.hashFields.put("io_bnd_cd", "ioBndCd");
		this.hashFields.put("cnn_buf_hrs", "cnnBufHrs");
		this.hashFields.put("lod_cnt_cd", "lodCntCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("dchg_cnt_cd", "dchgCntCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("lod_tml_cd", "lodTmlCd");
		this.hashFields.put("lod_slan_cd", "lodSlanCd");
		this.hashFields.put("vsl_cnn_tp_cd", "vslCnnTpCd");
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
	 * @return vslCnnRmk
	 */
	public String getVslCnnRmk() {
		return this.vslCnnRmk;
	}
	
	/**
	 * Column Info
	 * @return dchgSlanCd
	 */
	public String getDchgSlanCd() {
		return this.dchgSlanCd;
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
	 * @return dchgTmlCd
	 */
	public String getDchgTmlCd() {
		return this.dchgTmlCd;
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
	 * @return cnnBufHrs
	 */
	public String getCnnBufHrs() {
		return this.cnnBufHrs;
	}
	
	/**
	 * Column Info
	 * @return lodCntCd
	 */
	public String getLodCntCd() {
		return this.lodCntCd;
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
	 * @return dchgCntCd
	 */
	public String getDchgCntCd() {
		return this.dchgCntCd;
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
	 * @return lodTmlCd
	 */
	public String getLodTmlCd() {
		return this.lodTmlCd;
	}
	
	/**
	 * Column Info
	 * @return lodSlanCd
	 */
	public String getLodSlanCd() {
		return this.lodSlanCd;
	}
	
	/**
	 * Column Info
	 * @return vslCnnTpCd
	 */
	public String getVslCnnTpCd() {
		return this.vslCnnTpCd;
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
	 * @param vslCnnRmk
	 */
	public void setVslCnnRmk(String vslCnnRmk) {
		this.vslCnnRmk = vslCnnRmk;
	}
	
	/**
	 * Column Info
	 * @param dchgSlanCd
	 */
	public void setDchgSlanCd(String dchgSlanCd) {
		this.dchgSlanCd = dchgSlanCd;
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
	 * @param dchgTmlCd
	 */
	public void setDchgTmlCd(String dchgTmlCd) {
		this.dchgTmlCd = dchgTmlCd;
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
	 * @param cnnBufHrs
	 */
	public void setCnnBufHrs(String cnnBufHrs) {
		this.cnnBufHrs = cnnBufHrs;
	}
	
	/**
	 * Column Info
	 * @param lodCntCd
	 */
	public void setLodCntCd(String lodCntCd) {
		this.lodCntCd = lodCntCd;
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
	 * @param dchgCntCd
	 */
	public void setDchgCntCd(String dchgCntCd) {
		this.dchgCntCd = dchgCntCd;
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
	 * @param lodTmlCd
	 */
	public void setLodTmlCd(String lodTmlCd) {
		this.lodTmlCd = lodTmlCd;
	}
	
	/**
	 * Column Info
	 * @param lodSlanCd
	 */
	public void setLodSlanCd(String lodSlanCd) {
		this.lodSlanCd = lodSlanCd;
	}
	
	/**
	 * Column Info
	 * @param vslCnnTpCd
	 */
	public void setVslCnnTpCd(String vslCnnTpCd) {
		this.vslCnnTpCd = vslCnnTpCd;
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
		setVslCnnRmk(JSPUtil.getParameter(request, prefix + "vsl_cnn_rmk", ""));
		setDchgSlanCd(JSPUtil.getParameter(request, prefix + "dchg_slan_cd", ""));
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
		setDchgTmlCd(JSPUtil.getParameter(request, prefix + "dchg_tml_cd", ""));
		setIoBndCd(JSPUtil.getParameter(request, prefix + "io_bnd_cd", ""));
		setCnnBufHrs(JSPUtil.getParameter(request, prefix + "cnn_buf_hrs", ""));
		setLodCntCd(JSPUtil.getParameter(request, prefix + "lod_cnt_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setDchgCntCd(JSPUtil.getParameter(request, prefix + "dchg_cnt_cd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setLodTmlCd(JSPUtil.getParameter(request, prefix + "lod_tml_cd", ""));
		setLodSlanCd(JSPUtil.getParameter(request, prefix + "lod_slan_cd", ""));
		setVslCnnTpCd(JSPUtil.getParameter(request, prefix + "vsl_cnn_tp_cd", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchVslConnBufferTimeListVO[]
	 */
	public VslConnBufferTimeListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchVslConnBufferTimeListVO[]
	 */
	public VslConnBufferTimeListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		VslConnBufferTimeListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] vslCnnRmk = (JSPUtil.getParameter(request, prefix	+ "vsl_cnn_rmk", length));
			String[] dchgSlanCd = (JSPUtil.getParameter(request, prefix	+ "dchg_slan_cd", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] dchgTmlCd = (JSPUtil.getParameter(request, prefix	+ "dchg_tml_cd", length));
			String[] ioBndCd = (JSPUtil.getParameter(request, prefix	+ "io_bnd_cd", length));
			String[] cnnBufHrs = (JSPUtil.getParameter(request, prefix	+ "cnn_buf_hrs", length));
			String[] lodCntCd = (JSPUtil.getParameter(request, prefix	+ "lod_cnt_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] dchgCntCd = (JSPUtil.getParameter(request, prefix	+ "dchg_cnt_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] lodTmlCd = (JSPUtil.getParameter(request, prefix	+ "lod_tml_cd", length));
			String[] lodSlanCd = (JSPUtil.getParameter(request, prefix	+ "lod_slan_cd", length));
			String[] vslCnnTpCd = (JSPUtil.getParameter(request, prefix	+ "vsl_cnn_tp_cd", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			
			for (int i = 0; i < length; i++) {
				model = new VslConnBufferTimeListVO();
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (vslCnnRmk[i] != null)
					model.setVslCnnRmk(vslCnnRmk[i]);
				if (dchgSlanCd[i] != null)
					model.setDchgSlanCd(dchgSlanCd[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (dchgTmlCd[i] != null)
					model.setDchgTmlCd(dchgTmlCd[i]);
				if (ioBndCd[i] != null)
					model.setIoBndCd(ioBndCd[i]);
				if (cnnBufHrs[i] != null)
					model.setCnnBufHrs(cnnBufHrs[i]);
				if (lodCntCd[i] != null)
					model.setLodCntCd(lodCntCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (dchgCntCd[i] != null)
					model.setDchgCntCd(dchgCntCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (lodTmlCd[i] != null)
					model.setLodTmlCd(lodTmlCd[i]);
				if (lodSlanCd[i] != null)
					model.setLodSlanCd(lodSlanCd[i]);
				if (vslCnnTpCd[i] != null)
					model.setVslCnnTpCd(vslCnnTpCd[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchVslConnBufferTimeListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchVslConnBufferTimeListVO[]
	 */
	public VslConnBufferTimeListVO[] getSearchVslConnBufferTimeListVOs(){
		VslConnBufferTimeListVO[] vos = (VslConnBufferTimeListVO[])models.toArray(new VslConnBufferTimeListVO[models.size()]);
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
		this.vslCnnRmk = this.vslCnnRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dchgSlanCd = this.dchgSlanCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dchgTmlCd = this.dchgTmlCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ioBndCd = this.ioBndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnnBufHrs = this.cnnBufHrs .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lodCntCd = this.lodCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dchgCntCd = this.dchgCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lodTmlCd = this.lodTmlCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lodSlanCd = this.lodSlanCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslCnnTpCd = this.vslCnnTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
