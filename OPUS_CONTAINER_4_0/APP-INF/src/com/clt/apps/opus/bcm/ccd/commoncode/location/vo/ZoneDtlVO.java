/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : ZoneDtlVO.java
*@FileTitle : ZoneDtlVO
*Open Issues :
*Change history :
*@LastModifyDate : 2015.12.22
*@LastModifier : 
*@LastVersion : 1.0
* 2015.12.22  
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.bcm.ccd.commoncode.location.vo;

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

public class ZoneDtlVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<ZoneDtlVO> models = new ArrayList<ZoneDtlVO>();
	
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String creUsrId = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String rqstNo = null;
	/* Column Info */
	private String usrId = null;
	/* Column Info */
	private String deltFlg = null;
	/* Column Info */
	private String zipCd = null;
	/* Column Info */
	private String znCd = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String znSeq = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String dstrNm = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public ZoneDtlVO() {}

	public ZoneDtlVO(String ibflag, String pagerows, String znCd, String znSeq, String zipCd, String dstrNm, String deltFlg, String creUsrId, String creDt, String updUsrId, String updDt, String usrId, String rqstNo) {
		this.updDt = updDt;
		this.creUsrId = creUsrId;
		this.ibflag = ibflag;
		this.rqstNo = rqstNo;
		this.usrId = usrId;
		this.deltFlg = deltFlg;
		this.zipCd = zipCd;
		this.znCd = znCd;
		this.creDt = creDt;
		this.znSeq = znSeq;
		this.updUsrId = updUsrId;
		this.dstrNm = dstrNm;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("rqst_no", getRqstNo());
		this.hashColumns.put("usr_id", getUsrId());
		this.hashColumns.put("delt_flg", getDeltFlg());
		this.hashColumns.put("zip_cd", getZipCd());
		this.hashColumns.put("zn_cd", getZnCd());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("zn_seq", getZnSeq());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("dstr_nm", getDstrNm());
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
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("rqst_no", "rqstNo");
		this.hashFields.put("usr_id", "usrId");
		this.hashFields.put("delt_flg", "deltFlg");
		this.hashFields.put("zip_cd", "zipCd");
		this.hashFields.put("zn_cd", "znCd");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("zn_seq", "znSeq");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("dstr_nm", "dstrNm");
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
	 * VO Data Value( C:Creation, U:Update, D:Delete )
	 * @return ibflag
	 */
	public String getIbflag() {
		return this.ibflag;
	}
	
	/**
	 * Column Info
	 * @return rqstNo
	 */
	public String getRqstNo() {
		return this.rqstNo;
	}
	
	/**
	 * Column Info
	 * @return usrId
	 */
	public String getUsrId() {
		return this.usrId;
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
	 * @return zipCd
	 */
	public String getZipCd() {
		return this.zipCd;
	}
	
	/**
	 * Column Info
	 * @return znCd
	 */
	public String getZnCd() {
		return this.znCd;
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
	 * @return znSeq
	 */
	public String getZnSeq() {
		return this.znSeq;
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
	 * @return dstrNm
	 */
	public String getDstrNm() {
		return this.dstrNm;
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
	 * VO Data Value( C:Creation, U:Update, D:Delete )
	 * @param ibflag
	 */
	public void setIbflag(String ibflag) {
		this.ibflag = ibflag;
	}
	
	/**
	 * Column Info
	 * @param rqstNo
	 */
	public void setRqstNo(String rqstNo) {
		this.rqstNo = rqstNo;
	}
	
	/**
	 * Column Info
	 * @param usrId
	 */
	public void setUsrId(String usrId) {
		this.usrId = usrId;
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
	 * @param zipCd
	 */
	public void setZipCd(String zipCd) {
		this.zipCd = zipCd;
	}
	
	/**
	 * Column Info
	 * @param znCd
	 */
	public void setZnCd(String znCd) {
		this.znCd = znCd;
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
	 * @param znSeq
	 */
	public void setZnSeq(String znSeq) {
		this.znSeq = znSeq;
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
	 * @param dstrNm
	 */
	public void setDstrNm(String dstrNm) {
		this.dstrNm = dstrNm;
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
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setRqstNo(JSPUtil.getParameter(request, prefix + "rqst_no", ""));
		setUsrId(JSPUtil.getParameter(request, prefix + "usr_id", ""));
		setDeltFlg(JSPUtil.getParameter(request, prefix + "delt_flg", ""));
		setZipCd(JSPUtil.getParameter(request, prefix + "zip_cd", ""));
		setZnCd(JSPUtil.getParameter(request, prefix + "zn_cd", ""));
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
		setZnSeq(JSPUtil.getParameter(request, prefix + "zn_seq", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setDstrNm(JSPUtil.getParameter(request, prefix + "dstr_nm", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return ZoneDtlVO[]
	 */
	public ZoneDtlVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return ZoneDtlVO[]
	 */
	public ZoneDtlVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		ZoneDtlVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] rqstNo = (JSPUtil.getParameter(request, prefix	+ "rqst_no", length));
			String[] usrId = (JSPUtil.getParameter(request, prefix	+ "usr_id", length));
			String[] deltFlg = (JSPUtil.getParameter(request, prefix	+ "delt_flg", length));
			String[] zipCd = (JSPUtil.getParameter(request, prefix	+ "zip_cd", length));
			String[] znCd = (JSPUtil.getParameter(request, prefix	+ "zn_cd", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] znSeq = (JSPUtil.getParameter(request, prefix	+ "zn_seq", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] dstrNm = (JSPUtil.getParameter(request, prefix	+ "dstr_nm", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new ZoneDtlVO();
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (rqstNo[i] != null)
					model.setRqstNo(rqstNo[i]);
				if (usrId[i] != null)
					model.setUsrId(usrId[i]);
				if (deltFlg[i] != null)
					model.setDeltFlg(deltFlg[i]);
				if (zipCd[i] != null)
					model.setZipCd(zipCd[i]);
				if (znCd[i] != null)
					model.setZnCd(znCd[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (znSeq[i] != null)
					model.setZnSeq(znSeq[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (dstrNm[i] != null)
					model.setDstrNm(dstrNm[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getZoneDtlVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return ZoneDtlVO[]
	 */
	public ZoneDtlVO[] getZoneDtlVOs(){
		ZoneDtlVO[] vos = (ZoneDtlVO[])models.toArray(new ZoneDtlVO[models.size()]);
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
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rqstNo = this.rqstNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usrId = this.usrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.deltFlg = this.deltFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.zipCd = this.zipCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.znCd = this.znCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.znSeq = this.znSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dstrNm = this.dstrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
