/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : ScgPckGenProviVO.java
*@FileTitle : ScgPckGenProviVO
*Open Issues :
*Change history :
*@LastModifyDate : 2013.02.27
*@LastModifier : 
*@LastVersion : 1.0
* 2013.02.27  
* 1.0 Creation
=========================================================*/

package com.hanjin.syscommon.common.table;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

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

public class ScgPckGenProviVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<ScgPckGenProviVO> models = new ArrayList<ScgPckGenProviVO>();
	
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String deltFlg = null;
	/* Column Info */
	private String proviSubSecCd = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String proviPrtCd = null;
	/* Column Info */
	private String proviPrgrCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String proviDesc = null;
	/* Column Info */
	private String proviChtrCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String proviSubSubSecCd = null;
	/* Column Info */
	private String proviSecCd = null;
	/* Column Info */
	private String updUsrId = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public ScgPckGenProviVO() {}

	public ScgPckGenProviVO(String ibflag, String pagerows, String proviPrtCd, String proviChtrCd, String proviSecCd, String proviSubSecCd, String proviSubSubSecCd, String proviPrgrCd, String proviDesc, String deltFlg, String creUsrId, String creDt, String updUsrId, String updDt) {
		this.updDt = updDt;
		this.deltFlg = deltFlg;
		this.proviSubSecCd = proviSubSecCd;
		this.creDt = creDt;
		this.proviPrtCd = proviPrtCd;
		this.proviPrgrCd = proviPrgrCd;
		this.pagerows = pagerows;
		this.proviDesc = proviDesc;
		this.proviChtrCd = proviChtrCd;
		this.ibflag = ibflag;
		this.creUsrId = creUsrId;
		this.proviSubSubSecCd = proviSubSubSecCd;
		this.proviSecCd = proviSecCd;
		this.updUsrId = updUsrId;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("delt_flg", getDeltFlg());
		this.hashColumns.put("provi_sub_sec_cd", getProviSubSecCd());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("provi_prt_cd", getProviPrtCd());
		this.hashColumns.put("provi_prgr_cd", getProviPrgrCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("provi_desc", getProviDesc());
		this.hashColumns.put("provi_chtr_cd", getProviChtrCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("provi_sub_sub_sec_cd", getProviSubSubSecCd());
		this.hashColumns.put("provi_sec_cd", getProviSecCd());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("delt_flg", "deltFlg");
		this.hashFields.put("provi_sub_sec_cd", "proviSubSecCd");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("provi_prt_cd", "proviPrtCd");
		this.hashFields.put("provi_prgr_cd", "proviPrgrCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("provi_desc", "proviDesc");
		this.hashFields.put("provi_chtr_cd", "proviChtrCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("provi_sub_sub_sec_cd", "proviSubSubSecCd");
		this.hashFields.put("provi_sec_cd", "proviSecCd");
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
	 * @return deltFlg
	 */
	public String getDeltFlg() {
		return this.deltFlg;
	}
	
	/**
	 * Column Info
	 * @return proviSubSecCd
	 */
	public String getProviSubSecCd() {
		return this.proviSubSecCd;
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
	 * @return proviPrtCd
	 */
	public String getProviPrtCd() {
		return this.proviPrtCd;
	}
	
	/**
	 * Column Info
	 * @return proviPrgrCd
	 */
	public String getProviPrgrCd() {
		return this.proviPrgrCd;
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
	 * @return proviDesc
	 */
	public String getProviDesc() {
		return this.proviDesc;
	}
	
	/**
	 * Column Info
	 * @return proviChtrCd
	 */
	public String getProviChtrCd() {
		return this.proviChtrCd;
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
	 * @return proviSubSubSecCd
	 */
	public String getProviSubSubSecCd() {
		return this.proviSubSubSecCd;
	}
	
	/**
	 * Column Info
	 * @return proviSecCd
	 */
	public String getProviSecCd() {
		return this.proviSecCd;
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
	 * @param deltFlg
	 */
	public void setDeltFlg(String deltFlg) {
		this.deltFlg = deltFlg;
	}
	
	/**
	 * Column Info
	 * @param proviSubSecCd
	 */
	public void setProviSubSecCd(String proviSubSecCd) {
		this.proviSubSecCd = proviSubSecCd;
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
	 * @param proviPrtCd
	 */
	public void setProviPrtCd(String proviPrtCd) {
		this.proviPrtCd = proviPrtCd;
	}
	
	/**
	 * Column Info
	 * @param proviPrgrCd
	 */
	public void setProviPrgrCd(String proviPrgrCd) {
		this.proviPrgrCd = proviPrgrCd;
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
	 * @param proviDesc
	 */
	public void setProviDesc(String proviDesc) {
		this.proviDesc = proviDesc;
	}
	
	/**
	 * Column Info
	 * @param proviChtrCd
	 */
	public void setProviChtrCd(String proviChtrCd) {
		this.proviChtrCd = proviChtrCd;
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
	 * @param proviSubSubSecCd
	 */
	public void setProviSubSubSecCd(String proviSubSubSecCd) {
		this.proviSubSubSecCd = proviSubSubSecCd;
	}
	
	/**
	 * Column Info
	 * @param proviSecCd
	 */
	public void setProviSecCd(String proviSecCd) {
		this.proviSecCd = proviSecCd;
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
		setDeltFlg(JSPUtil.getParameter(request, prefix + "delt_flg", ""));
		setProviSubSecCd(JSPUtil.getParameter(request, prefix + "provi_sub_sec_cd", ""));
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
		setProviPrtCd(JSPUtil.getParameter(request, prefix + "provi_prt_cd", ""));
		setProviPrgrCd(JSPUtil.getParameter(request, prefix + "provi_prgr_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setProviDesc(JSPUtil.getParameter(request, prefix + "provi_desc", ""));
		setProviChtrCd(JSPUtil.getParameter(request, prefix + "provi_chtr_cd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setProviSubSubSecCd(JSPUtil.getParameter(request, prefix + "provi_sub_sub_sec_cd", ""));
		setProviSecCd(JSPUtil.getParameter(request, prefix + "provi_sec_cd", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return ScgPckGenProviVO[]
	 */
	public ScgPckGenProviVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return ScgPckGenProviVO[]
	 */
	public ScgPckGenProviVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		ScgPckGenProviVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] deltFlg = (JSPUtil.getParameter(request, prefix	+ "delt_flg", length));
			String[] proviSubSecCd = (JSPUtil.getParameter(request, prefix	+ "provi_sub_sec_cd", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] proviPrtCd = (JSPUtil.getParameter(request, prefix	+ "provi_prt_cd", length));
			String[] proviPrgrCd = (JSPUtil.getParameter(request, prefix	+ "provi_prgr_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] proviDesc = (JSPUtil.getParameter(request, prefix	+ "provi_desc", length));
			String[] proviChtrCd = (JSPUtil.getParameter(request, prefix	+ "provi_chtr_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] proviSubSubSecCd = (JSPUtil.getParameter(request, prefix	+ "provi_sub_sub_sec_cd", length));
			String[] proviSecCd = (JSPUtil.getParameter(request, prefix	+ "provi_sec_cd", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			
			for (int i = 0; i < length; i++) {
				model = new ScgPckGenProviVO();
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (deltFlg[i] != null)
					model.setDeltFlg(deltFlg[i]);
				if (proviSubSecCd[i] != null)
					model.setProviSubSecCd(proviSubSecCd[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (proviPrtCd[i] != null)
					model.setProviPrtCd(proviPrtCd[i]);
				if (proviPrgrCd[i] != null)
					model.setProviPrgrCd(proviPrgrCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (proviDesc[i] != null)
					model.setProviDesc(proviDesc[i]);
				if (proviChtrCd[i] != null)
					model.setProviChtrCd(proviChtrCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (proviSubSubSecCd[i] != null)
					model.setProviSubSubSecCd(proviSubSubSecCd[i]);
				if (proviSecCd[i] != null)
					model.setProviSecCd(proviSecCd[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getScgPckGenProviVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return ScgPckGenProviVO[]
	 */
	public ScgPckGenProviVO[] getScgPckGenProviVOs(){
		ScgPckGenProviVO[] vos = (ScgPckGenProviVO[])models.toArray(new ScgPckGenProviVO[models.size()]);
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
		this.proviSubSecCd = this.proviSubSecCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.proviPrtCd = this.proviPrtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.proviPrgrCd = this.proviPrgrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.proviDesc = this.proviDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.proviChtrCd = this.proviChtrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.proviSubSubSecCd = this.proviSubSubSecCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.proviSecCd = this.proviSecCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
