/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : PriRpRetroVO.java
*@FileTitle : PriRpRetroVO
*Open Issues :
*Change history :
*@LastModifyDate : 2014.11.27
*@LastModifier : 최성환
*@LastVersion : 1.0
* 2014.11.27 최성환 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.pri.rfaproposal.rfaproposalmain.vo;

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
 * @author 최성환
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class PriRpRetroVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<PriRpRetroVO> models = new ArrayList<PriRpRetroVO>();
	
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String rtroNoteNm = null;
	/* Column Info */
	private String rtroNoteSeq = null;
	/* Column Info */
	private String rtroNoteCreDt = null;
	/* Column Info */
	private String amdtSeq = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String rtroNoteCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String rtroNoteCtnt = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String propNo = null;
	/* Column Info */
	private String updUsrId = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public PriRpRetroVO() {}

	public PriRpRetroVO(String ibflag, String pagerows, String propNo, String amdtSeq, String rtroNoteSeq, String rtroNoteCd, String rtroNoteCtnt, String rtroNoteCreDt, String creUsrId, String creDt, String updUsrId, String updDt, String rtroNoteNm) {
		this.updDt = updDt;
		this.rtroNoteNm = rtroNoteNm;
		this.rtroNoteSeq = rtroNoteSeq;
		this.rtroNoteCreDt = rtroNoteCreDt;
		this.amdtSeq = amdtSeq;
		this.creDt = creDt;
		this.rtroNoteCd = rtroNoteCd;
		this.pagerows = pagerows;
		this.rtroNoteCtnt = rtroNoteCtnt;
		this.ibflag = ibflag;
		this.creUsrId = creUsrId;
		this.propNo = propNo;
		this.updUsrId = updUsrId;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("rtro_note_nm", getRtroNoteNm());
		this.hashColumns.put("rtro_note_seq", getRtroNoteSeq());
		this.hashColumns.put("rtro_note_cre_dt", getRtroNoteCreDt());
		this.hashColumns.put("amdt_seq", getAmdtSeq());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("rtro_note_cd", getRtroNoteCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("rtro_note_ctnt", getRtroNoteCtnt());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("prop_no", getPropNo());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("rtro_note_nm", "rtroNoteNm");
		this.hashFields.put("rtro_note_seq", "rtroNoteSeq");
		this.hashFields.put("rtro_note_cre_dt", "rtroNoteCreDt");
		this.hashFields.put("amdt_seq", "amdtSeq");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("rtro_note_cd", "rtroNoteCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("rtro_note_ctnt", "rtroNoteCtnt");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("prop_no", "propNo");
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
	 * @return rtroNoteNm
	 */
	public String getRtroNoteNm() {
		return this.rtroNoteNm;
	}
	
	/**
	 * Column Info
	 * @return rtroNoteSeq
	 */
	public String getRtroNoteSeq() {
		return this.rtroNoteSeq;
	}
	
	/**
	 * Column Info
	 * @return rtroNoteCreDt
	 */
	public String getRtroNoteCreDt() {
		return this.rtroNoteCreDt;
	}
	
	/**
	 * Column Info
	 * @return amdtSeq
	 */
	public String getAmdtSeq() {
		return this.amdtSeq;
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
	 * @return rtroNoteCd
	 */
	public String getRtroNoteCd() {
		return this.rtroNoteCd;
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
	 * @return rtroNoteCtnt
	 */
	public String getRtroNoteCtnt() {
		return this.rtroNoteCtnt;
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
	 * @return propNo
	 */
	public String getPropNo() {
		return this.propNo;
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
	 * @param rtroNoteNm
	 */
	public void setRtroNoteNm(String rtroNoteNm) {
		this.rtroNoteNm = rtroNoteNm;
	}
	
	/**
	 * Column Info
	 * @param rtroNoteSeq
	 */
	public void setRtroNoteSeq(String rtroNoteSeq) {
		this.rtroNoteSeq = rtroNoteSeq;
	}
	
	/**
	 * Column Info
	 * @param rtroNoteCreDt
	 */
	public void setRtroNoteCreDt(String rtroNoteCreDt) {
		this.rtroNoteCreDt = rtroNoteCreDt;
	}
	
	/**
	 * Column Info
	 * @param amdtSeq
	 */
	public void setAmdtSeq(String amdtSeq) {
		this.amdtSeq = amdtSeq;
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
	 * @param rtroNoteCd
	 */
	public void setRtroNoteCd(String rtroNoteCd) {
		this.rtroNoteCd = rtroNoteCd;
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
	 * @param rtroNoteCtnt
	 */
	public void setRtroNoteCtnt(String rtroNoteCtnt) {
		this.rtroNoteCtnt = rtroNoteCtnt;
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
	 * @param propNo
	 */
	public void setPropNo(String propNo) {
		this.propNo = propNo;
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
		setRtroNoteNm(JSPUtil.getParameter(request, prefix + "rtro_note_nm", ""));
		setRtroNoteSeq(JSPUtil.getParameter(request, prefix + "rtro_note_seq", ""));
		setRtroNoteCreDt(JSPUtil.getParameter(request, prefix + "rtro_note_cre_dt", ""));
		setAmdtSeq(JSPUtil.getParameter(request, prefix + "amdt_seq", ""));
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
		setRtroNoteCd(JSPUtil.getParameter(request, prefix + "rtro_note_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setRtroNoteCtnt(JSPUtil.getParameter(request, prefix + "rtro_note_ctnt", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setPropNo(JSPUtil.getParameter(request, prefix + "prop_no", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return PriRpRetroVO[]
	 */
	public PriRpRetroVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return PriRpRetroVO[]
	 */
	public PriRpRetroVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		PriRpRetroVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] rtroNoteNm = (JSPUtil.getParameter(request, prefix	+ "rtro_note_nm", length));
			String[] rtroNoteSeq = (JSPUtil.getParameter(request, prefix	+ "rtro_note_seq", length));
			String[] rtroNoteCreDt = (JSPUtil.getParameter(request, prefix	+ "rtro_note_cre_dt", length));
			String[] amdtSeq = (JSPUtil.getParameter(request, prefix	+ "amdt_seq", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] rtroNoteCd = (JSPUtil.getParameter(request, prefix	+ "rtro_note_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] rtroNoteCtnt = (JSPUtil.getParameter(request, prefix	+ "rtro_note_ctnt", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] propNo = (JSPUtil.getParameter(request, prefix	+ "prop_no", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			
			for (int i = 0; i < length; i++) {
				model = new PriRpRetroVO();
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (rtroNoteNm[i] != null)
					model.setRtroNoteNm(rtroNoteNm[i]);
				if (rtroNoteSeq[i] != null)
					model.setRtroNoteSeq(rtroNoteSeq[i]);
				if (rtroNoteCreDt[i] != null)
					model.setRtroNoteCreDt(rtroNoteCreDt[i]);
				if (amdtSeq[i] != null)
					model.setAmdtSeq(amdtSeq[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (rtroNoteCd[i] != null)
					model.setRtroNoteCd(rtroNoteCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (rtroNoteCtnt[i] != null)
					model.setRtroNoteCtnt(rtroNoteCtnt[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (propNo[i] != null)
					model.setPropNo(propNo[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getPriRpRetroVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return PriRpRetroVO[]
	 */
	public PriRpRetroVO[] getPriRpRetroVOs(){
		PriRpRetroVO[] vos = (PriRpRetroVO[])models.toArray(new PriRpRetroVO[models.size()]);
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
		this.rtroNoteNm = this.rtroNoteNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rtroNoteSeq = this.rtroNoteSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rtroNoteCreDt = this.rtroNoteCreDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.amdtSeq = this.amdtSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rtroNoteCd = this.rtroNoteCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rtroNoteCtnt = this.rtroNoteCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.propNo = this.propNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
