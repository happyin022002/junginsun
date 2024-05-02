/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : ComCtrtUsrListVO.java
*@FileTitle : ComCtrtUsrListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2016.05.19
*@LastModifier : 
*@LastVersion : 1.0
* 2016.05.19  
* 1.0 Creation
=========================================================*/

package com.hanjin.bizcommon.agreementnotice.vo;

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

public class ComCtrtUsrListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<ComCtrtUsrListVO> models = new ArrayList<ComCtrtUsrListVO>();
	
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String ntcUsrIdJbCd = null;
	/* Column Info */
	private String agmtNo = null;
	/* Column Info */
	private String creDt = null;
	/* Page Number */
	private String pagerows = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String ctrtOfcCd = null;
	/* Column Info */
	private String sysCd = null;
	/* Column Info */
	private String ntcUsrSeq = null;
	/* Column Info */
	private String usrMaxKnt = null;
	/* Column Info */
	private String ntcUsrId = null;
	/* Column Info */
	private String updUsrId = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public ComCtrtUsrListVO() {}

	public ComCtrtUsrListVO(String ibflag, String pagerows, String sysCd, String ctrtOfcCd, String agmtNo, String ntcUsrSeq, String ntcUsrId, String ntcUsrIdJbCd, String creUsrId, String creDt, String updUsrId, String updDt, String usrMaxKnt) {
		this.updDt = updDt;
		this.ntcUsrIdJbCd = ntcUsrIdJbCd;
		this.agmtNo = agmtNo;
		this.creDt = creDt;
		this.pagerows = pagerows;
		this.ibflag = ibflag;
		this.creUsrId = creUsrId;
		this.ctrtOfcCd = ctrtOfcCd;
		this.sysCd = sysCd;
		this.ntcUsrSeq = ntcUsrSeq;
		this.usrMaxKnt = usrMaxKnt;
		this.ntcUsrId = ntcUsrId;
		this.updUsrId = updUsrId;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("ntc_usr_id_jb_cd", getNtcUsrIdJbCd());
		this.hashColumns.put("agmt_no", getAgmtNo());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("ctrt_ofc_cd", getCtrtOfcCd());
		this.hashColumns.put("sys_cd", getSysCd());
		this.hashColumns.put("ntc_usr_seq", getNtcUsrSeq());
		this.hashColumns.put("usr_max_knt", getUsrMaxKnt());
		this.hashColumns.put("ntc_usr_id", getNtcUsrId());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("ntc_usr_id_jb_cd", "ntcUsrIdJbCd");
		this.hashFields.put("agmt_no", "agmtNo");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("ctrt_ofc_cd", "ctrtOfcCd");
		this.hashFields.put("sys_cd", "sysCd");
		this.hashFields.put("ntc_usr_seq", "ntcUsrSeq");
		this.hashFields.put("usr_max_knt", "usrMaxKnt");
		this.hashFields.put("ntc_usr_id", "ntcUsrId");
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
	 * @return ntcUsrIdJbCd
	 */
	public String getNtcUsrIdJbCd() {
		return this.ntcUsrIdJbCd;
	}
	
	/**
	 * Column Info
	 * @return agmtNo
	 */
	public String getAgmtNo() {
		return this.agmtNo;
	}
	
	/**
	 * Column Info
	 * @return creDt
	 */
	public String getCreDt() {
		return this.creDt;
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
	 * @return creUsrId
	 */
	public String getCreUsrId() {
		return this.creUsrId;
	}
	
	/**
	 * Column Info
	 * @return ctrtOfcCd
	 */
	public String getCtrtOfcCd() {
		return this.ctrtOfcCd;
	}
	
	/**
	 * Column Info
	 * @return sysCd
	 */
	public String getSysCd() {
		return this.sysCd;
	}
	
	/**
	 * Column Info
	 * @return ntcUsrSeq
	 */
	public String getNtcUsrSeq() {
		return this.ntcUsrSeq;
	}
	
	/**
	 * Column Info
	 * @return usrMaxKnt
	 */
	public String getUsrMaxKnt() {
		return this.usrMaxKnt;
	}
	
	/**
	 * Column Info
	 * @return ntcUsrId
	 */
	public String getNtcUsrId() {
		return this.ntcUsrId;
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
	 * @param ntcUsrIdJbCd
	 */
	public void setNtcUsrIdJbCd(String ntcUsrIdJbCd) {
		this.ntcUsrIdJbCd = ntcUsrIdJbCd;
	}
	
	/**
	 * Column Info
	 * @param agmtNo
	 */
	public void setAgmtNo(String agmtNo) {
		this.agmtNo = agmtNo;
	}
	
	/**
	 * Column Info
	 * @param creDt
	 */
	public void setCreDt(String creDt) {
		this.creDt = creDt;
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
	 * @param creUsrId
	 */
	public void setCreUsrId(String creUsrId) {
		this.creUsrId = creUsrId;
	}
	
	/**
	 * Column Info
	 * @param ctrtOfcCd
	 */
	public void setCtrtOfcCd(String ctrtOfcCd) {
		this.ctrtOfcCd = ctrtOfcCd;
	}
	
	/**
	 * Column Info
	 * @param sysCd
	 */
	public void setSysCd(String sysCd) {
		this.sysCd = sysCd;
	}
	
	/**
	 * Column Info
	 * @param ntcUsrSeq
	 */
	public void setNtcUsrSeq(String ntcUsrSeq) {
		this.ntcUsrSeq = ntcUsrSeq;
	}
	
	/**
	 * Column Info
	 * @param usrMaxKnt
	 */
	public void setUsrMaxKnt(String usrMaxKnt) {
		this.usrMaxKnt = usrMaxKnt;
	}
	
	/**
	 * Column Info
	 * @param ntcUsrId
	 */
	public void setNtcUsrId(String ntcUsrId) {
		this.ntcUsrId = ntcUsrId;
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
		setNtcUsrIdJbCd(JSPUtil.getParameter(request, prefix + "ntc_usr_id_jb_cd", ""));
		setAgmtNo(JSPUtil.getParameter(request, prefix + "agmt_no", ""));
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setCtrtOfcCd(JSPUtil.getParameter(request, prefix + "ctrt_ofc_cd", ""));
		setSysCd(JSPUtil.getParameter(request, prefix + "sys_cd", ""));
		setNtcUsrSeq(JSPUtil.getParameter(request, prefix + "ntc_usr_seq", ""));
		setUsrMaxKnt(JSPUtil.getParameter(request, prefix + "usr_max_knt", ""));
		setNtcUsrId(JSPUtil.getParameter(request, prefix + "ntc_usr_id", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return ComCtrtUsrListVO[]
	 */
	public ComCtrtUsrListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return ComCtrtUsrListVO[]
	 */
	public ComCtrtUsrListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		ComCtrtUsrListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] ntcUsrIdJbCd = (JSPUtil.getParameter(request, prefix	+ "ntc_usr_id_jb_cd", length));
			String[] agmtNo = (JSPUtil.getParameter(request, prefix	+ "agmt_no", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] ctrtOfcCd = (JSPUtil.getParameter(request, prefix	+ "ctrt_ofc_cd", length));
			String[] sysCd = (JSPUtil.getParameter(request, prefix	+ "sys_cd", length));
			String[] ntcUsrSeq = (JSPUtil.getParameter(request, prefix	+ "ntc_usr_seq", length));
			String[] usrMaxKnt = (JSPUtil.getParameter(request, prefix	+ "usr_max_knt", length));
			String[] ntcUsrId = (JSPUtil.getParameter(request, prefix	+ "ntc_usr_id", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			
			for (int i = 0; i < length; i++) {
				model = new ComCtrtUsrListVO();
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (ntcUsrIdJbCd[i] != null)
					model.setNtcUsrIdJbCd(ntcUsrIdJbCd[i]);
				if (agmtNo[i] != null)
					model.setAgmtNo(agmtNo[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (ctrtOfcCd[i] != null)
					model.setCtrtOfcCd(ctrtOfcCd[i]);
				if (sysCd[i] != null)
					model.setSysCd(sysCd[i]);
				if (ntcUsrSeq[i] != null)
					model.setNtcUsrSeq(ntcUsrSeq[i]);
				if (usrMaxKnt[i] != null)
					model.setUsrMaxKnt(usrMaxKnt[i]);
				if (ntcUsrId[i] != null)
					model.setNtcUsrId(ntcUsrId[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getComCtrtUsrListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return ComCtrtUsrListVO[]
	 */
	public ComCtrtUsrListVO[] getComCtrtUsrListVOs(){
		ComCtrtUsrListVO[] vos = (ComCtrtUsrListVO[])models.toArray(new ComCtrtUsrListVO[models.size()]);
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
		this.ntcUsrIdJbCd = this.ntcUsrIdJbCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtNo = this.agmtNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrtOfcCd = this.ctrtOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sysCd = this.sysCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ntcUsrSeq = this.ntcUsrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usrMaxKnt = this.usrMaxKnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ntcUsrId = this.ntcUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
