/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : BlckKwListVO.java
*@FileTitle : BlckKwListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2016.03.25
*@LastModifier : 
*@LastVersion : 1.0
* 2016.03.25  
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.bookingmasterdata.usersetupmgt.vo;

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

public class BlckKwListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<BlckKwListVO> models = new ArrayList<BlckKwListVO>();
	
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String creUsrId = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String blckKwCtnt = null;
	/* Column Info */
	private String blckKwTpCd = null;
	/* Column Info */
	private String blckKwRmk = null;
	/* Column Info */
	private String blckKwTpSeq = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String blckKwNm = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public BlckKwListVO() {}

	public BlckKwListVO(String ibflag, String pagerows, String blckKwTpCd, String blckKwTpSeq, String blckKwNm, String blckKwCtnt, String blckKwRmk, String creUsrId, String creDt, String updUsrId, String updDt) {
		this.updDt = updDt;
		this.creUsrId = creUsrId;
		this.ibflag = ibflag;
		this.creDt = creDt;
		this.blckKwCtnt = blckKwCtnt;
		this.blckKwTpCd = blckKwTpCd;
		this.blckKwRmk = blckKwRmk;
		this.blckKwTpSeq = blckKwTpSeq;
		this.updUsrId = updUsrId;
		this.blckKwNm = blckKwNm;
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
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("blck_kw_ctnt", getBlckKwCtnt());
		this.hashColumns.put("blck_kw_tp_cd", getBlckKwTpCd());
		this.hashColumns.put("blck_kw_rmk", getBlckKwRmk());
		this.hashColumns.put("blck_kw_tp_seq", getBlckKwTpSeq());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("blck_kw_nm", getBlckKwNm());
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
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("blck_kw_ctnt", "blckKwCtnt");
		this.hashFields.put("blck_kw_tp_cd", "blckKwTpCd");
		this.hashFields.put("blck_kw_rmk", "blckKwRmk");
		this.hashFields.put("blck_kw_tp_seq", "blckKwTpSeq");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("blck_kw_nm", "blckKwNm");
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
	 * @return creDt
	 */
	public String getCreDt() {
		return this.creDt;
	}
	
	/**
	 * Column Info
	 * @return blckKwCntn
	 */
	public String getBlckKwCtnt() {
		return this.blckKwCtnt;
	}
	
	/**
	 * Column Info
	 * @return blckKwTpCd
	 */
	public String getBlckKwTpCd() {
		return this.blckKwTpCd;
	}
	
	/**
	 * Column Info
	 * @return blckKwRmk
	 */
	public String getBlckKwRmk() {
		return this.blckKwRmk;
	}
	
	/**
	 * Column Info
	 * @return blckKwTpSeq
	 */
	public String getBlckKwTpSeq() {
		return this.blckKwTpSeq;
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
	 * @return blckKwNm
	 */
	public String getBlckKwNm() {
		return this.blckKwNm;
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
	 * @param creDt
	 */
	public void setCreDt(String creDt) {
		this.creDt = creDt;
	}
	
	/**
	 * Column Info
	 * @param blckKwCntn
	 */
	public void setBlckKwCtnt(String blckKwCtnt) {
		this.blckKwCtnt = blckKwCtnt;
	}
	
	/**
	 * Column Info
	 * @param blckKwTpCd
	 */
	public void setBlckKwTpCd(String blckKwTpCd) {
		this.blckKwTpCd = blckKwTpCd;
	}
	
	/**
	 * Column Info
	 * @param blckKwRmk
	 */
	public void setBlckKwRmk(String blckKwRmk) {
		this.blckKwRmk = blckKwRmk;
	}
	
	/**
	 * Column Info
	 * @param blckKwTpSeq
	 */
	public void setBlckKwTpSeq(String blckKwTpSeq) {
		this.blckKwTpSeq = blckKwTpSeq;
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
	 * @param blckKwNm
	 */
	public void setBlckKwNm(String blckKwNm) {
		this.blckKwNm = blckKwNm;
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
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
		setBlckKwCtnt(JSPUtil.getParameter(request, prefix + "blck_kw_ctnt", ""));
		setBlckKwTpCd(JSPUtil.getParameter(request, prefix + "blck_kw_tp_cd", ""));
		setBlckKwRmk(JSPUtil.getParameter(request, prefix + "blck_kw_rmk", ""));
		setBlckKwTpSeq(JSPUtil.getParameter(request, prefix + "blck_kw_tp_seq", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setBlckKwNm(JSPUtil.getParameter(request, prefix + "blck_kw_nm", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return BlckKwListVO[]
	 */
	public BlckKwListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return BlckKwListVO[]
	 */
	public BlckKwListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		BlckKwListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] blckKwCtnt = (JSPUtil.getParameter(request, prefix	+ "blck_kw_ctnt", length));
			String[] blckKwTpCd = (JSPUtil.getParameter(request, prefix	+ "blck_kw_tp_cd", length));
			String[] blckKwRmk = (JSPUtil.getParameter(request, prefix	+ "blck_kw_rmk", length));
			String[] blckKwTpSeq = (JSPUtil.getParameter(request, prefix	+ "blck_kw_tp_seq", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] blckKwNm = (JSPUtil.getParameter(request, prefix	+ "blck_kw_nm", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new BlckKwListVO();
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (blckKwCtnt[i] != null)
					model.setBlckKwCtnt(blckKwCtnt[i]);
				if (blckKwTpCd[i] != null)
					model.setBlckKwTpCd(blckKwTpCd[i]);
				if (blckKwRmk[i] != null)
					model.setBlckKwRmk(blckKwRmk[i]);
				if (blckKwTpSeq[i] != null)
					model.setBlckKwTpSeq(blckKwTpSeq[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (blckKwNm[i] != null)
					model.setBlckKwNm(blckKwNm[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getBlckKwListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return BlckKwListVO[]
	 */
	public BlckKwListVO[] getBlckKwListVOs(){
		BlckKwListVO[] vos = (BlckKwListVO[])models.toArray(new BlckKwListVO[models.size()]);
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
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blckKwCtnt = this.blckKwCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blckKwTpCd = this.blckKwTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blckKwRmk = this.blckKwRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blckKwTpSeq = this.blckKwTpSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blckKwNm = this.blckKwNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
