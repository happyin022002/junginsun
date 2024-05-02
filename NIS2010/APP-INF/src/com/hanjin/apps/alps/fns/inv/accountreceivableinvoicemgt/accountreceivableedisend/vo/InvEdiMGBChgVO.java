/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : InvEdiMGBChgVO.java
*@FileTitle : InvEdiMGBChgVO
*Open Issues :
*Change history :
*@LastModifyDate : 2015.12.22
*@LastModifier : 
*@LastVersion : 1.0
* 2015.12.22  
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.accountreceivableedisend.vo;

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

public class InvEdiMGBChgVO extends AbstractValueObject {
 
	private static final long serialVersionUID = 1L;
	
	private Collection<InvEdiMGBChgVO> models = new ArrayList<InvEdiMGBChgVO>();
	
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String chHawbno = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String chOdno = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String chCur = null;
	/* Column Info */
	private String chgTp = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String chBlno = null;
	/* Column Info */
	private String chCntrno = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String chAmnt = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public InvEdiMGBChgVO() {}

	public InvEdiMGBChgVO(String ibflag, String pagerows, String chgTp, String chAmnt, String chCur, String chHawbno, String chCntrno, String chOdno, String chBlno, String creUsrId, String creDt, String updUsrId, String updDt) {
		this.updDt = updDt;
		this.chHawbno = chHawbno;
		this.creUsrId = creUsrId;
		this.chOdno = chOdno;
		this.ibflag = ibflag;
		this.chCur = chCur;
		this.chgTp = chgTp;
		this.creDt = creDt;
		this.chBlno = chBlno;
		this.chCntrno = chCntrno;
		this.updUsrId = updUsrId;
		this.chAmnt = chAmnt;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("ch_hawbno", getChHawbno());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("ch_odno", getChOdno());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("ch_cur", getChCur());
		this.hashColumns.put("chg_tp", getChgTp());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("ch_blno", getChBlno());
		this.hashColumns.put("ch_cntrno", getChCntrno());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("ch_amnt", getChAmnt());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("ch_hawbno", "chHawbno");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("ch_odno", "chOdno");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("ch_cur", "chCur");
		this.hashFields.put("chg_tp", "chgTp");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("ch_blno", "chBlno");
		this.hashFields.put("ch_cntrno", "chCntrno");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("ch_amnt", "chAmnt");
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
	 * @return chHawbno
	 */
	public String getChHawbno() {
		return this.chHawbno;
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
	 * @return chOdno
	 */
	public String getChOdno() {
		return this.chOdno;
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
	 * @return chCur
	 */
	public String getChCur() {
		return this.chCur;
	}
	
	/**
	 * Column Info
	 * @return chgTp
	 */
	public String getChgTp() {
		return this.chgTp;
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
	 * @return chBlno
	 */
	public String getChBlno() {
		return this.chBlno;
	}
	
	/**
	 * Column Info
	 * @return chCntrno
	 */
	public String getChCntrno() {
		return this.chCntrno;
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
	 * @return chAmnt
	 */
	public String getChAmnt() {
		return this.chAmnt;
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
	 * @param chHawbno
	 */
	public void setChHawbno(String chHawbno) {
		this.chHawbno = chHawbno;
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
	 * @param chOdno
	 */
	public void setChOdno(String chOdno) {
		this.chOdno = chOdno;
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
	 * @param chCur
	 */
	public void setChCur(String chCur) {
		this.chCur = chCur;
	}
	
	/**
	 * Column Info
	 * @param chgTp
	 */
	public void setChgTp(String chgTp) {
		this.chgTp = chgTp;
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
	 * @param chBlno
	 */
	public void setChBlno(String chBlno) {
		this.chBlno = chBlno;
	}
	
	/**
	 * Column Info
	 * @param chCntrno
	 */
	public void setChCntrno(String chCntrno) {
		this.chCntrno = chCntrno;
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
	 * @param chAmnt
	 */
	public void setChAmnt(String chAmnt) {
		this.chAmnt = chAmnt;
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
		setChHawbno(JSPUtil.getParameter(request, prefix + "ch_hawbno", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setChOdno(JSPUtil.getParameter(request, prefix + "ch_odno", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setChCur(JSPUtil.getParameter(request, prefix + "ch_cur", ""));
		setChgTp(JSPUtil.getParameter(request, prefix + "chg_tp", ""));
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
		setChBlno(JSPUtil.getParameter(request, prefix + "ch_blno", ""));
		setChCntrno(JSPUtil.getParameter(request, prefix + "ch_cntrno", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setChAmnt(JSPUtil.getParameter(request, prefix + "ch_amnt", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return InvEdiMGBChgVO[]
	 */
	public InvEdiMGBChgVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return InvEdiMGBChgVO[]
	 */
	public InvEdiMGBChgVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		InvEdiMGBChgVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] chHawbno = (JSPUtil.getParameter(request, prefix	+ "ch_hawbno", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] chOdno = (JSPUtil.getParameter(request, prefix	+ "ch_odno", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] chCur = (JSPUtil.getParameter(request, prefix	+ "ch_cur", length));
			String[] chgTp = (JSPUtil.getParameter(request, prefix	+ "chg_tp", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] chBlno = (JSPUtil.getParameter(request, prefix	+ "ch_blno", length));
			String[] chCntrno = (JSPUtil.getParameter(request, prefix	+ "ch_cntrno", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] chAmnt = (JSPUtil.getParameter(request, prefix	+ "ch_amnt", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new InvEdiMGBChgVO();
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (chHawbno[i] != null)
					model.setChHawbno(chHawbno[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (chOdno[i] != null)
					model.setChOdno(chOdno[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (chCur[i] != null)
					model.setChCur(chCur[i]);
				if (chgTp[i] != null)
					model.setChgTp(chgTp[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (chBlno[i] != null)
					model.setChBlno(chBlno[i]);
				if (chCntrno[i] != null)
					model.setChCntrno(chCntrno[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (chAmnt[i] != null)
					model.setChAmnt(chAmnt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getInvEdiMGBChgVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return InvEdiMGBChgVO[]
	 */
	public InvEdiMGBChgVO[] getInvEdiMGBChgVOs(){
		InvEdiMGBChgVO[] vos = (InvEdiMGBChgVO[])models.toArray(new InvEdiMGBChgVO[models.size()]);
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
		this.chHawbno = this.chHawbno .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chOdno = this.chOdno .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chCur = this.chCur .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chgTp = this.chgTp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chBlno = this.chBlno .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chCntrno = this.chCntrno .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chAmnt = this.chAmnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
