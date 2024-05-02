/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : ScgMailTampletVO.java
*@FileTitle : ScgMailTampletVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.22
*@LastModifier : 김현욱
*@LastVersion : 1.0
* 2010.02.22 김현욱 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.vop.scg.specialcargomasterdatamgt.specialcargomasterdatamgt.vo;

import java.lang.reflect.Field;
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
 * @author 김현욱
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class ScgMailTampletVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<ScgMailTampletVO> models = new ArrayList<ScgMailTampletVO>();
	
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String ftrCtnt = null;
	/* Column Info */
	private String ibflag = null;
	/* Column Info */
	private String autoEmlFlg = null;
	/* Column Info */
	private String hdrCtnt = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String spclCgoCd = null;
	/* Column Info */
	private String emlSndUsrId = null;
	/* Column Info */
	private String updUsrId = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public ScgMailTampletVO() {}

	public ScgMailTampletVO(String ibflag, String pagerows, String emlSndUsrId, String spclCgoCd, String hdrCtnt, String ftrCtnt, String autoEmlFlg, String creUsrId, String creDt, String updUsrId, String updDt) {
		this.updDt = updDt;
		this.creUsrId = creUsrId;
		this.ftrCtnt = ftrCtnt;
		this.ibflag = ibflag;
		this.autoEmlFlg = autoEmlFlg;
		this.hdrCtnt = hdrCtnt;
		this.creDt = creDt;
		this.spclCgoCd = spclCgoCd;
		this.emlSndUsrId = emlSndUsrId;
		this.updUsrId = updUsrId;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("ftr_ctnt", getFtrCtnt());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("auto_eml_flg", getAutoEmlFlg());
		this.hashColumns.put("hdr_ctnt", getHdrCtnt());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("spcl_cgo_cd", getSpclCgoCd());
		this.hashColumns.put("eml_snd_usr_id", getEmlSndUsrId());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("ftr_ctnt", "ftrCtnt");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("auto_eml_flg", "autoEmlFlg");
		this.hashFields.put("hdr_ctnt", "hdrCtnt");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("spcl_cgo_cd", "spclCgoCd");
		this.hashFields.put("eml_snd_usr_id", "emlSndUsrId");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("pagerows", "pagerows");
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
	 * @return creUsrId
	 */
	public String getCreUsrId() {
		return this.creUsrId;
	}
	
	/**
	 * Column Info
	 * @return ftrCtnt
	 */
	public String getFtrCtnt() {
		return this.ftrCtnt;
	}
	
	/**
	 * Column Info
	 * @return ibflag
	 */
	public String getIbflag() {
		return this.ibflag;
	}
	
	/**
	 * Column Info
	 * @return autoEmlFlg
	 */
	public String getAutoEmlFlg() {
		return this.autoEmlFlg;
	}
	
	/**
	 * Column Info
	 * @return hdrCtnt
	 */
	public String getHdrCtnt() {
		return this.hdrCtnt;
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
	 * @return spclCgoCd
	 */
	public String getSpclCgoCd() {
		return this.spclCgoCd;
	}
	
	/**
	 * Column Info
	 * @return emlSndUsrId
	 */
	public String getEmlSndUsrId() {
		return this.emlSndUsrId;
	}
	
	/**
	 * Column Info
	 * @return updUsrId
	 */
	public String getUpdUsrId() {
		return this.updUsrId;
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
	 * @param updDt
	 */
	public void setUpdDt(String updDt) {
		this.updDt = updDt;
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
	 * @param ftrCtnt
	 */
	public void setFtrCtnt(String ftrCtnt) {
		this.ftrCtnt = ftrCtnt;
	}
	
	/**
	 * Column Info
	 * @param ibflag
	 */
	public void setIbflag(String ibflag) {
		this.ibflag = ibflag;
	}
	
	/**
	 * Column Info
	 * @param autoEmlFlg
	 */
	public void setAutoEmlFlg(String autoEmlFlg) {
		this.autoEmlFlg = autoEmlFlg;
	}
	
	/**
	 * Column Info
	 * @param hdrCtnt
	 */
	public void setHdrCtnt(String hdrCtnt) {
		this.hdrCtnt = hdrCtnt;
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
	 * @param spclCgoCd
	 */
	public void setSpclCgoCd(String spclCgoCd) {
		this.spclCgoCd = spclCgoCd;
	}
	
	/**
	 * Column Info
	 * @param emlSndUsrId
	 */
	public void setEmlSndUsrId(String emlSndUsrId) {
		this.emlSndUsrId = emlSndUsrId;
	}
	
	/**
	 * Column Info
	 * @param updUsrId
	 */
	public void setUpdUsrId(String updUsrId) {
		this.updUsrId = updUsrId;
	}
	
	/**
	 * Page Number
	 * @param pagerows
	 */
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
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
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setFtrCtnt(JSPUtil.getParameter(request, prefix + "ftr_ctnt", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setAutoEmlFlg(JSPUtil.getParameter(request, prefix + "auto_eml_flg", ""));
		setHdrCtnt(JSPUtil.getParameter(request, prefix + "hdr_ctnt", ""));
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
		setSpclCgoCd(JSPUtil.getParameter(request, prefix + "spcl_cgo_cd", ""));
		setEmlSndUsrId(JSPUtil.getParameter(request, prefix + "eml_snd_usr_id", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return ScgMailTampletVO[]
	 */
	public ScgMailTampletVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return ScgMailTampletVO[]
	 */
	public ScgMailTampletVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		ScgMailTampletVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] ftrCtnt = (JSPUtil.getParameter(request, prefix	+ "ftr_ctnt", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] autoEmlFlg = (JSPUtil.getParameter(request, prefix	+ "auto_eml_flg", length));
			String[] hdrCtnt = (JSPUtil.getParameter(request, prefix	+ "hdr_ctnt", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] spclCgoCd = (JSPUtil.getParameter(request, prefix	+ "spcl_cgo_cd", length));
			String[] emlSndUsrId = (JSPUtil.getParameter(request, prefix	+ "eml_snd_usr_id", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new ScgMailTampletVO();
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (ftrCtnt[i] != null)
					model.setFtrCtnt(ftrCtnt[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (autoEmlFlg[i] != null)
					model.setAutoEmlFlg(autoEmlFlg[i]);
				if (hdrCtnt[i] != null)
					model.setHdrCtnt(hdrCtnt[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (spclCgoCd[i] != null)
					model.setSpclCgoCd(spclCgoCd[i]);
				if (emlSndUsrId[i] != null)
					model.setEmlSndUsrId(emlSndUsrId[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getScgMailTampletVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return ScgMailTampletVO[]
	 */
	public ScgMailTampletVO[] getScgMailTampletVOs(){
		ScgMailTampletVO[] vos = (ScgMailTampletVO[])models.toArray(new ScgMailTampletVO[models.size()]);
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
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ftrCtnt = this.ftrCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.autoEmlFlg = this.autoEmlFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hdrCtnt = this.hdrCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.spclCgoCd = this.spclCgoCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.emlSndUsrId = this.emlSndUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
