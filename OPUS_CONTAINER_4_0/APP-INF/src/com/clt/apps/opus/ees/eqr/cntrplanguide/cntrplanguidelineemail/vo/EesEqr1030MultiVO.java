/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : EesEqr1030MultiVO.java
*@FileTitle : EesEqr1030MultiVO
*Open Issues :
*Change history :
*@LastModifyDate : 2014.01.07
*@LastModifier : 
*@LastVersion : 1.0
* 2014.01.07  
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.ees.eqr.cntrplanguide.cntrplanguidelineemail.vo;

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
 * 관련 Event 에서 생성, 서버실행시 Data 전달역할을 수행하는 Value Object
 *
 * @author 
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class EesEqr1030MultiVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<EesEqr1030MultiVO> models = new ArrayList<EesEqr1030MultiVO>();
	
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String glineRcptEml = null;
	/* Column Info */
	private String delchk = null;
	/* Column Info */
	private String arHdQtrOfcCd = null;
	/* Column Info */
	private String creDt = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String ofcCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String usrNm = null;
	/* Column Info */
	private String glineRcptUsrId = null;
	/* Column Info */
	private String usrIdVal = null;
	/* Column Info */
	private String updUsrId = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public EesEqr1030MultiVO() {}

	public EesEqr1030MultiVO(String ibflag, String pagerows, String delchk, String glineRcptUsrId, String usrNm, String arHdQtrOfcCd, String ofcCd, String glineRcptEml, String usrIdVal, String creUsrId, String creDt, String updUsrId, String updDt) {
		this.updDt = updDt;
		this.glineRcptEml = glineRcptEml;
		this.delchk = delchk;
		this.arHdQtrOfcCd = arHdQtrOfcCd;
		this.creDt = creDt;
		this.pagerows = pagerows;
		this.ofcCd = ofcCd;
		this.ibflag = ibflag;
		this.creUsrId = creUsrId;
		this.usrNm = usrNm;
		this.glineRcptUsrId = glineRcptUsrId;
		this.usrIdVal = usrIdVal;
		this.updUsrId = updUsrId;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("gline_rcpt_eml", getGlineRcptEml());
		this.hashColumns.put("delchk", getDelchk());
		this.hashColumns.put("ar_hd_qtr_ofc_cd", getArHdQtrOfcCd());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ofc_cd", getOfcCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("usr_nm", getUsrNm());
		this.hashColumns.put("gline_rcpt_usr_id", getGlineRcptUsrId());
		this.hashColumns.put("usr_id_val", getUsrIdVal());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("gline_rcpt_eml", "glineRcptEml");
		this.hashFields.put("delchk", "delchk");
		this.hashFields.put("ar_hd_qtr_ofc_cd", "arHdQtrOfcCd");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ofc_cd", "ofcCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("usr_nm", "usrNm");
		this.hashFields.put("gline_rcpt_usr_id", "glineRcptUsrId");
		this.hashFields.put("usr_id_val", "usrIdVal");
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
	 * @return glineRcptEml
	 */
	public String getGlineRcptEml() {
		return this.glineRcptEml;
	}
	
	/**
	 * Column Info
	 * @return delchk
	 */
	public String getDelchk() {
		return this.delchk;
	}
	
	/**
	 * Column Info
	 * @return arHdQtrOfcCd
	 */
	public String getArHdQtrOfcCd() {
		return this.arHdQtrOfcCd;
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
	 * Column Info
	 * @return ofcCd
	 */
	public String getOfcCd() {
		return this.ofcCd;
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
	 * @return usrNm
	 */
	public String getUsrNm() {
		return this.usrNm;
	}
	
	/**
	 * Column Info
	 * @return glineRcptUsrId
	 */
	public String getGlineRcptUsrId() {
		return this.glineRcptUsrId;
	}
	
	/**
	 * Column Info
	 * @return usrIdVal
	 */
	public String getUsrIdVal() {
		return this.usrIdVal;
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
	 * @param glineRcptEml
	 */
	public void setGlineRcptEml(String glineRcptEml) {
		this.glineRcptEml = glineRcptEml;
	}
	
	/**
	 * Column Info
	 * @param delchk
	 */
	public void setDelchk(String delchk) {
		this.delchk = delchk;
	}
	
	/**
	 * Column Info
	 * @param arHdQtrOfcCd
	 */
	public void setArHdQtrOfcCd(String arHdQtrOfcCd) {
		this.arHdQtrOfcCd = arHdQtrOfcCd;
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
	 * Column Info
	 * @param ofcCd
	 */
	public void setOfcCd(String ofcCd) {
		this.ofcCd = ofcCd;
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
	 * @param usrNm
	 */
	public void setUsrNm(String usrNm) {
		this.usrNm = usrNm;
	}
	
	/**
	 * Column Info
	 * @param glineRcptUsrId
	 */
	public void setGlineRcptUsrId(String glineRcptUsrId) {
		this.glineRcptUsrId = glineRcptUsrId;
	}
	
	/**
	 * Column Info
	 * @param usrIdVal
	 */
	public void setUsrIdVal(String usrIdVal) {
		this.usrIdVal = usrIdVal;
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
		setGlineRcptEml(JSPUtil.getParameter(request, prefix + "gline_rcpt_eml", ""));
		setDelchk(JSPUtil.getParameter(request, prefix + "delchk", ""));
		setArHdQtrOfcCd(JSPUtil.getParameter(request, prefix + "ar_hd_qtr_ofc_cd", ""));
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setOfcCd(JSPUtil.getParameter(request, prefix + "ofc_cd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setUsrNm(JSPUtil.getParameter(request, prefix + "usr_nm", ""));
		setGlineRcptUsrId(JSPUtil.getParameter(request, prefix + "gline_rcpt_usr_id", ""));
		setUsrIdVal(JSPUtil.getParameter(request, prefix + "usr_id_val", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return EesEqr1030MultiVO[]
	 */
	public EesEqr1030MultiVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return EesEqr1030MultiVO[]
	 */
	public EesEqr1030MultiVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		EesEqr1030MultiVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] glineRcptEml = (JSPUtil.getParameter(request, prefix	+ "gline_rcpt_eml", length));
			String[] delchk = (JSPUtil.getParameter(request, prefix	+ "delchk", length));
			String[] arHdQtrOfcCd = (JSPUtil.getParameter(request, prefix	+ "ar_hd_qtr_ofc_cd", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ofcCd = (JSPUtil.getParameter(request, prefix	+ "ofc_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] usrNm = (JSPUtil.getParameter(request, prefix	+ "usr_nm", length));
			String[] glineRcptUsrId = (JSPUtil.getParameter(request, prefix	+ "gline_rcpt_usr_id", length));
			String[] usrIdVal = (JSPUtil.getParameter(request, prefix	+ "usr_id_val", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			
			for (int i = 0; i < length; i++) {
				model = new EesEqr1030MultiVO();
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (glineRcptEml[i] != null)
					model.setGlineRcptEml(glineRcptEml[i]);
				if (delchk[i] != null)
					model.setDelchk(delchk[i]);
				if (arHdQtrOfcCd[i] != null)
					model.setArHdQtrOfcCd(arHdQtrOfcCd[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ofcCd[i] != null)
					model.setOfcCd(ofcCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (usrNm[i] != null)
					model.setUsrNm(usrNm[i]);
				if (glineRcptUsrId[i] != null)
					model.setGlineRcptUsrId(glineRcptUsrId[i]);
				if (usrIdVal[i] != null)
					model.setUsrIdVal(usrIdVal[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getEesEqr1030MultiVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return EesEqr1030MultiVO[]
	 */
	public EesEqr1030MultiVO[] getEesEqr1030MultiVOs(){
		EesEqr1030MultiVO[] vos = (EesEqr1030MultiVO[])models.toArray(new EesEqr1030MultiVO[models.size()]);
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
		this.glineRcptEml = this.glineRcptEml .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delchk = this.delchk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.arHdQtrOfcCd = this.arHdQtrOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcCd = this.ofcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usrNm = this.usrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.glineRcptUsrId = this.glineRcptUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usrIdVal = this.usrIdVal .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
