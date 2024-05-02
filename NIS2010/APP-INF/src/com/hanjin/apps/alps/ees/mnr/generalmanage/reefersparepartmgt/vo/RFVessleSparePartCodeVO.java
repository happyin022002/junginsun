/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : RFVessleSparePartCodeVO.java
*@FileTitle : RFVessleSparePartCodeVO
*Open Issues :
*Change history :
*@LastModifyDate : 2014.12.03
*@LastModifier : 
*@LastVersion : 1.0
* 2014.12.03  
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.ees.mnr.generalmanage.reefersparepartmgt.vo;

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
 * @author 노영현
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class RFVessleSparePartCodeVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<RFVessleSparePartCodeVO> models = new ArrayList<RFVessleSparePartCodeVO>();
	
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String sprPrtTpCd = null;
	/* Column Info */
	private String newYn = null;
	/* Column Info */
	private String sprPrtSeq = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String sprUtMdlNm = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String vndrNm = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String sprPrtDeltFlg = null;
	/* Column Info */
	private String sprPrtCrntAmt = null;
	/* Column Info */
	private String sprPrtLstAmt = null;
	/* Column Info */
	private String sprPrtRmk = null;
	/* Column Info */
	private String sprPrtVndrSeq = null;
	/* Column Info */
	private String sprPrtVerSeq = null;
	/* Column Info */
	private String updUsrId = null;
	
	private String sprPrtDpSeq = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public RFVessleSparePartCodeVO() {}

	public RFVessleSparePartCodeVO(String ibflag, String pagerows, String sprPrtSeq, String sprPrtVerSeq, String sprPrtVndrSeq, String vndrNm, String sprUtMdlNm, String sprPrtTpCd, String sprPrtLstAmt, String sprPrtCrntAmt, String sprPrtRmk, String sprPrtDeltFlg, String creUsrId, String creDt, String updUsrId, String updDt, String newYn, String sprPrtDpSeq) {
		this.updDt = updDt;
		this.sprPrtTpCd = sprPrtTpCd;
		this.newYn = newYn;
		this.sprPrtSeq = sprPrtSeq;
		this.creDt = creDt;
		this.sprUtMdlNm = sprUtMdlNm;
		this.pagerows = pagerows;
		this.vndrNm = vndrNm;
		this.ibflag = ibflag;
		this.creUsrId = creUsrId;
		this.sprPrtDeltFlg = sprPrtDeltFlg;
		this.sprPrtCrntAmt = sprPrtCrntAmt;
		this.sprPrtLstAmt = sprPrtLstAmt;
		this.sprPrtRmk = sprPrtRmk;
		this.sprPrtVndrSeq = sprPrtVndrSeq;
		this.sprPrtVerSeq = sprPrtVerSeq;
		this.updUsrId = updUsrId;
		this.sprPrtDpSeq = sprPrtDpSeq;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("spr_prt_tp_cd", getSprPrtTpCd());
		this.hashColumns.put("new_yn", getNewYn());
		this.hashColumns.put("spr_prt_seq", getSprPrtSeq());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("spr_ut_mdl_nm", getSprUtMdlNm());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("vndr_nm", getVndrNm());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("spr_prt_delt_flg", getSprPrtDeltFlg());
		this.hashColumns.put("spr_prt_crnt_amt", getSprPrtCrntAmt());
		this.hashColumns.put("spr_prt_lst_amt", getSprPrtLstAmt());
		this.hashColumns.put("spr_prt_rmk", getSprPrtRmk());
		this.hashColumns.put("spr_prt_vndr_seq", getSprPrtVndrSeq());
		this.hashColumns.put("spr_prt_ver_seq", getSprPrtVerSeq());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("spr_prt_dp_seq", getSprPrtDpSeq());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("spr_prt_tp_cd", "sprPrtTpCd");
		this.hashFields.put("new_yn", "newYn");
		this.hashFields.put("spr_prt_seq", "sprPrtSeq");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("spr_ut_mdl_nm", "sprUtMdlNm");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("vndr_nm", "vndrNm");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("spr_prt_delt_flg", "sprPrtDeltFlg");
		this.hashFields.put("spr_prt_crnt_amt", "sprPrtCrntAmt");
		this.hashFields.put("spr_prt_lst_amt", "sprPrtLstAmt");
		this.hashFields.put("spr_prt_rmk", "sprPrtRmk");
		this.hashFields.put("spr_prt_vndr_seq", "sprPrtVndrSeq");
		this.hashFields.put("spr_prt_ver_seq", "sprPrtVerSeq");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("spr_prt_dp_seq", "sprPrtDpSeq");
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
	 * @return sprPrtTpCd
	 */
	public String getSprPrtTpCd() {
		return this.sprPrtTpCd;
	}
	
	/**
	 * Column Info
	 * @return newYn
	 */
	public String getNewYn() {
		return this.newYn;
	}
	
	/**
	 * Column Info
	 * @return sprPrtSeq
	 */
	public String getSprPrtSeq() {
		return this.sprPrtSeq;
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
	 * @return sprUtMdlNm
	 */
	public String getSprUtMdlNm() {
		return this.sprUtMdlNm;
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
	 * @return vndrNm
	 */
	public String getVndrNm() {
		return this.vndrNm;
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
	 * @return sprPrtDeltFlg
	 */
	public String getSprPrtDeltFlg() {
		return this.sprPrtDeltFlg;
	}
	
	/**
	 * Column Info
	 * @return sprPrtCrntAmt
	 */
	public String getSprPrtCrntAmt() {
		return this.sprPrtCrntAmt;
	}
	
	/**
	 * Column Info
	 * @return sprPrtLstAmt
	 */
	public String getSprPrtLstAmt() {
		return this.sprPrtLstAmt;
	}
	
	/**
	 * Column Info
	 * @return sprPrtRmk
	 */
	public String getSprPrtRmk() {
		return this.sprPrtRmk;
	}
	
	/**
	 * Column Info
	 * @return sprPrtVndrSeq
	 */
	public String getSprPrtVndrSeq() {
		return this.sprPrtVndrSeq;
	}
	
	/**
	 * Column Info
	 * @return sprPrtVerSeq
	 */
	public String getSprPrtVerSeq() {
		return this.sprPrtVerSeq;
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
	 * @param sprPrtTpCd
	 */
	public void setSprPrtTpCd(String sprPrtTpCd) {
		this.sprPrtTpCd = sprPrtTpCd;
	}
	
	/**
	 * Column Info
	 * @param newYn
	 */
	public void setNewYn(String newYn) {
		this.newYn = newYn;
	}
	
	/**
	 * Column Info
	 * @param sprPrtSeq
	 */
	public void setSprPrtSeq(String sprPrtSeq) {
		this.sprPrtSeq = sprPrtSeq;
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
	 * @param sprUtMdlNm
	 */
	public void setSprUtMdlNm(String sprUtMdlNm) {
		this.sprUtMdlNm = sprUtMdlNm;
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
	 * @param vndrNm
	 */
	public void setVndrNm(String vndrNm) {
		this.vndrNm = vndrNm;
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
	 * @param sprPrtDeltFlg
	 */
	public void setSprPrtDeltFlg(String sprPrtDeltFlg) {
		this.sprPrtDeltFlg = sprPrtDeltFlg;
	}
	
	/**
	 * Column Info
	 * @param sprPrtCrntAmt
	 */
	public void setSprPrtCrntAmt(String sprPrtCrntAmt) {
		this.sprPrtCrntAmt = sprPrtCrntAmt;
	}
	
	/**
	 * Column Info
	 * @param sprPrtLstAmt
	 */
	public void setSprPrtLstAmt(String sprPrtLstAmt) {
		this.sprPrtLstAmt = sprPrtLstAmt;
	}
	
	/**
	 * Column Info
	 * @param sprPrtRmk
	 */
	public void setSprPrtRmk(String sprPrtRmk) {
		this.sprPrtRmk = sprPrtRmk;
	}
	
	/**
	 * Column Info
	 * @param sprPrtVndrSeq
	 */
	public void setSprPrtVndrSeq(String sprPrtVndrSeq) {
		this.sprPrtVndrSeq = sprPrtVndrSeq;
	}
	
	/**
	 * Column Info
	 * @param sprPrtVerSeq
	 */
	public void setSprPrtVerSeq(String sprPrtVerSeq) {
		this.sprPrtVerSeq = sprPrtVerSeq;
	}
	
	/**
	 * Column Info
	 * @param updUsrId
	 */
	public void setUpdUsrId(String updUsrId) {
		this.updUsrId = updUsrId;
	}
	
	public String getSprPrtDpSeq() {
		return sprPrtDpSeq;
	}

	public void setSprPrtDpSeq(String sprPrtDpSeq) {
		this.sprPrtDpSeq = sprPrtDpSeq;
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
		setSprPrtTpCd(JSPUtil.getParameter(request, prefix + "spr_prt_tp_cd", ""));
		setNewYn(JSPUtil.getParameter(request, prefix + "new_yn", ""));
		setSprPrtSeq(JSPUtil.getParameter(request, prefix + "spr_prt_seq", ""));
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
		setSprUtMdlNm(JSPUtil.getParameter(request, prefix + "spr_ut_mdl_nm", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setVndrNm(JSPUtil.getParameter(request, prefix + "vndr_nm", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setSprPrtDeltFlg(JSPUtil.getParameter(request, prefix + "spr_prt_delt_flg", ""));
		setSprPrtCrntAmt(JSPUtil.getParameter(request, prefix + "spr_prt_crnt_amt", ""));
		setSprPrtLstAmt(JSPUtil.getParameter(request, prefix + "spr_prt_lst_amt", ""));
		setSprPrtRmk(JSPUtil.getParameter(request, prefix + "spr_prt_rmk", ""));
		setSprPrtVndrSeq(JSPUtil.getParameter(request, prefix + "spr_prt_vndr_seq", ""));
		setSprPrtVerSeq(JSPUtil.getParameter(request, prefix + "spr_prt_ver_seq", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setSprPrtDpSeq(JSPUtil.getParameter(request, prefix + "spr_prt_dp_seq", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return RFVessleSparePartCodeVO[]
	 */
	public RFVessleSparePartCodeVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return RFVessleSparePartCodeVO[]
	 */
	public RFVessleSparePartCodeVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		RFVessleSparePartCodeVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] sprPrtTpCd = (JSPUtil.getParameter(request, prefix	+ "spr_prt_tp_cd", length));
			String[] newYn = (JSPUtil.getParameter(request, prefix	+ "new_yn", length));
			String[] sprPrtSeq = (JSPUtil.getParameter(request, prefix	+ "spr_prt_seq", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] sprUtMdlNm = (JSPUtil.getParameter(request, prefix	+ "spr_ut_mdl_nm", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] vndrNm = (JSPUtil.getParameter(request, prefix	+ "vndr_nm", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] sprPrtDeltFlg = (JSPUtil.getParameter(request, prefix	+ "spr_prt_delt_flg", length));
			String[] sprPrtCrntAmt = (JSPUtil.getParameter(request, prefix	+ "spr_prt_crnt_amt", length));
			String[] sprPrtLstAmt = (JSPUtil.getParameter(request, prefix	+ "spr_prt_lst_amt", length));
			String[] sprPrtRmk = (JSPUtil.getParameter(request, prefix	+ "spr_prt_rmk", length));
			String[] sprPrtVndrSeq = (JSPUtil.getParameter(request, prefix	+ "spr_prt_vndr_seq", length));
			String[] sprPrtVerSeq = (JSPUtil.getParameter(request, prefix	+ "spr_prt_ver_seq", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] sprPrtDpSeq = (JSPUtil.getParameter(request, prefix	+ "spr_prt_dp_seq", length));
			
			for (int i = 0; i < length; i++) {
				model = new RFVessleSparePartCodeVO();
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (sprPrtTpCd[i] != null)
					model.setSprPrtTpCd(sprPrtTpCd[i]);
				if (newYn[i] != null)
					model.setNewYn(newYn[i]);
				if (sprPrtSeq[i] != null)
					model.setSprPrtSeq(sprPrtSeq[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (sprUtMdlNm[i] != null)
					model.setSprUtMdlNm(sprUtMdlNm[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (vndrNm[i] != null)
					model.setVndrNm(vndrNm[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (sprPrtDeltFlg[i] != null)
					model.setSprPrtDeltFlg(sprPrtDeltFlg[i]);
				if (sprPrtCrntAmt[i] != null)
					model.setSprPrtCrntAmt(sprPrtCrntAmt[i]);
				if (sprPrtLstAmt[i] != null)
					model.setSprPrtLstAmt(sprPrtLstAmt[i]);
				if (sprPrtRmk[i] != null)
					model.setSprPrtRmk(sprPrtRmk[i]);
				if (sprPrtVndrSeq[i] != null)
					model.setSprPrtVndrSeq(sprPrtVndrSeq[i]);
				if (sprPrtVerSeq[i] != null)
					model.setSprPrtVerSeq(sprPrtVerSeq[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (sprPrtDpSeq[i] != null)
					model.setSprPrtDpSeq(sprPrtDpSeq[i]);
				
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getRFVessleSparePartCodeVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return RFVessleSparePartCodeVO[]
	 */
	public RFVessleSparePartCodeVO[] getRFVessleSparePartCodeVOs(){
		RFVessleSparePartCodeVO[] vos = (RFVessleSparePartCodeVO[])models.toArray(new RFVessleSparePartCodeVO[models.size()]);
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
		this.sprPrtTpCd = this.sprPrtTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.newYn = this.newYn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sprPrtSeq = this.sprPrtSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sprUtMdlNm = this.sprUtMdlNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrNm = this.vndrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sprPrtDeltFlg = this.sprPrtDeltFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sprPrtCrntAmt = this.sprPrtCrntAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sprPrtLstAmt = this.sprPrtLstAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sprPrtRmk = this.sprPrtRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sprPrtVndrSeq = this.sprPrtVndrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sprPrtVerSeq = this.sprPrtVerSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sprPrtDpSeq = this.sprPrtDpSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
