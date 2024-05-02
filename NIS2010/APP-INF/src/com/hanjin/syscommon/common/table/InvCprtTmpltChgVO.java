/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : InvCprtTmpltChgVO.java
*@FileTitle : InvCprtTmpltChgVO
*Open Issues :
*Change history :
*@LastModifyDate : 2011.03.07
*@LastModifier : KIM HYUN HWA
*@LastVersion : 1.0
* 2011.03.07 KIM HYUN HWA 
* 1.0 Creation
=========================================================*/

package com.hanjin.syscommon.common.table;

import java.lang.reflect.Field;
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
 * @author KIM HYUN HWA
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class InvCprtTmpltChgVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<InvCprtTmpltChgVO> models = new ArrayList<InvCprtTmpltChgVO>();

	/* Column Info */
	private String arOfcCd = null;
	/* Column Info */
	private String rptTmpltNm = null;
	/* Column Info */
	private String rptItmId = null;
	/* Column Info */
	private String cprtValCtnt = null;
	/* Column Info */
	private String cprtTpCtnt = null;
	/* Column Info */
	private String dpSeq = null;
	/* Column Info */
	private String chgCd = null;
	/* Column Info */
	private String cprtChgGrpFlg = null;
	/* Page Number */
	private String pagerows = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String updDt = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public InvCprtTmpltChgVO() {}

	public InvCprtTmpltChgVO(String ibflag, String pagerows, String arOfcCd, String rptTmpltNm, String rptItmId, String cprtTpCtnt, String cprtValCtnt, String dpSeq, String chgCd, String creUsrId, String creDt, String updUsrId, String updDt, String cprtChgGrpFlg) {
		this.dpSeq = dpSeq;
		this.updDt = updDt;
		this.cprtChgGrpFlg = cprtChgGrpFlg;
		this.rptTmpltNm = rptTmpltNm;
		this.creDt = creDt;
		this.rptItmId = rptItmId;
		this.arOfcCd = arOfcCd;
		this.chgCd = chgCd;
		this.pagerows = pagerows;
		this.ibflag = ibflag;
		this.cprtTpCtnt = cprtTpCtnt;
		this.creUsrId = creUsrId;
		this.cprtValCtnt = cprtValCtnt;
		this.updUsrId = updUsrId;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("dp_seq", getDpSeq());
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("cprt_chg_grp_flg", getCprtChgGrpFlg());
		this.hashColumns.put("rpt_tmplt_nm", getRptTmpltNm());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("rpt_itm_id", getRptItmId());
		this.hashColumns.put("ar_ofc_cd", getArOfcCd());
		this.hashColumns.put("chg_cd", getChgCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cprt_tp_ctnt", getCprtTpCtnt());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("cprt_val_ctnt", getCprtValCtnt());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("dp_seq", "dpSeq");
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("cprt_chg_grp_flg", "cprtChgGrpFlg");
		this.hashFields.put("rpt_tmplt_nm", "rptTmpltNm");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("rpt_itm_id", "rptItmId");
		this.hashFields.put("ar_ofc_cd", "arOfcCd");
		this.hashFields.put("chg_cd", "chgCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cprt_tp_ctnt", "cprtTpCtnt");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("cprt_val_ctnt", "cprtValCtnt");
		this.hashFields.put("upd_usr_id", "updUsrId");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return dpSeq
	 */
	public String getDpSeq() {
		return this.dpSeq;
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
	 * @return cprtChgGrpFlg
	 */
	public String getCprtChgGrpFlg() {
		return this.cprtChgGrpFlg;
	}
	
	/**
	 * Column Info
	 * @return rptTmpltNm
	 */
	public String getRptTmpltNm() {
		return this.rptTmpltNm;
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
	 * @return rptItmId
	 */
	public String getRptItmId() {
		return this.rptItmId;
	}
	
	/**
	 * Column Info
	 * @return arOfcCd
	 */
	public String getArOfcCd() {
		return this.arOfcCd;
	}
	
	/**
	 * Column Info
	 * @return chgCd
	 */
	public String getChgCd() {
		return this.chgCd;
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
	 * @return cprtTpCtnt
	 */
	public String getCprtTpCtnt() {
		return this.cprtTpCtnt;
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
	 * @return cprtValCtnt
	 */
	public String getCprtValCtnt() {
		return this.cprtValCtnt;
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
	 * @param dpSeq
	 */
	public void setDpSeq(String dpSeq) {
		this.dpSeq = dpSeq;
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
	 * @param cprtChgGrpFlg
	 */
	public void setCprtChgGrpFlg(String cprtChgGrpFlg) {
		this.cprtChgGrpFlg = cprtChgGrpFlg;
	}
	
	/**
	 * Column Info
	 * @param rptTmpltNm
	 */
	public void setRptTmpltNm(String rptTmpltNm) {
		this.rptTmpltNm = rptTmpltNm;
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
	 * @param rptItmId
	 */
	public void setRptItmId(String rptItmId) {
		this.rptItmId = rptItmId;
	}
	
	/**
	 * Column Info
	 * @param arOfcCd
	 */
	public void setArOfcCd(String arOfcCd) {
		this.arOfcCd = arOfcCd;
	}
	
	/**
	 * Column Info
	 * @param chgCd
	 */
	public void setChgCd(String chgCd) {
		this.chgCd = chgCd;
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
	 * @param cprtTpCtnt
	 */
	public void setCprtTpCtnt(String cprtTpCtnt) {
		this.cprtTpCtnt = cprtTpCtnt;
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
	 * @param cprtValCtnt
	 */
	public void setCprtValCtnt(String cprtValCtnt) {
		this.cprtValCtnt = cprtValCtnt;
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
		setDpSeq(JSPUtil.getParameter(request, prefix + "dp_seq", ""));
		setUpdDt(JSPUtil.getParameter(request, prefix + "upd_dt", ""));
		setCprtChgGrpFlg(JSPUtil.getParameter(request, prefix + "cprt_chg_grp_flg", ""));
		setRptTmpltNm(JSPUtil.getParameter(request, prefix + "rpt_tmplt_nm", ""));
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
		setRptItmId(JSPUtil.getParameter(request, prefix + "rpt_itm_id", ""));
		setArOfcCd(JSPUtil.getParameter(request, prefix + "ar_ofc_cd", ""));
		setChgCd(JSPUtil.getParameter(request, prefix + "chg_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setCprtTpCtnt(JSPUtil.getParameter(request, prefix + "cprt_tp_ctnt", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setCprtValCtnt(JSPUtil.getParameter(request, prefix + "cprt_val_ctnt", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return InvCprtTmpltChgVO[]
	 */
	public InvCprtTmpltChgVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return InvCprtTmpltChgVO[]
	 */
	public InvCprtTmpltChgVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		InvCprtTmpltChgVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] dpSeq = (JSPUtil.getParameter(request, prefix	+ "dp_seq", length));
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] cprtChgGrpFlg = (JSPUtil.getParameter(request, prefix	+ "cprt_chg_grp_flg", length));
			String[] rptTmpltNm = (JSPUtil.getParameter(request, prefix	+ "rpt_tmplt_nm", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] rptItmId = (JSPUtil.getParameter(request, prefix	+ "rpt_itm_id", length));
			String[] arOfcCd = (JSPUtil.getParameter(request, prefix	+ "ar_ofc_cd", length));
			String[] chgCd = (JSPUtil.getParameter(request, prefix	+ "chg_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] cprtTpCtnt = (JSPUtil.getParameter(request, prefix	+ "cprt_tp_ctnt", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] cprtValCtnt = (JSPUtil.getParameter(request, prefix	+ "cprt_val_ctnt", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			
			for (int i = 0; i < length; i++) {
				model = new InvCprtTmpltChgVO();
				if (dpSeq[i] != null)
					model.setDpSeq(dpSeq[i]);
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (cprtChgGrpFlg[i] != null)
					model.setCprtChgGrpFlg(cprtChgGrpFlg[i]);
				if (rptTmpltNm[i] != null)
					model.setRptTmpltNm(rptTmpltNm[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (rptItmId[i] != null)
					model.setRptItmId(rptItmId[i]);
				if (arOfcCd[i] != null)
					model.setArOfcCd(arOfcCd[i]);
				if (chgCd[i] != null)
					model.setChgCd(chgCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (cprtTpCtnt[i] != null)
					model.setCprtTpCtnt(cprtTpCtnt[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (cprtValCtnt[i] != null)
					model.setCprtValCtnt(cprtValCtnt[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getInvCprtTmpltChgVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return InvCprtTmpltChgVO[]
	 */
	public InvCprtTmpltChgVO[] getInvCprtTmpltChgVOs(){
		InvCprtTmpltChgVO[] vos = (InvCprtTmpltChgVO[])models.toArray(new InvCprtTmpltChgVO[models.size()]);
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
		this.dpSeq = this.dpSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cprtChgGrpFlg = this.cprtChgGrpFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rptTmpltNm = this.rptTmpltNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rptItmId = this.rptItmId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.arOfcCd = this.arOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chgCd = this.chgCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cprtTpCtnt = this.cprtTpCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cprtValCtnt = this.cprtValCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
