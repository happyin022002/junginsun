/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : TesEdiRcvRuleMnVO.java
*@FileTitle : TesEdiRcvRuleMnVO
*Open Issues :
*Change history :
*@LastModifyDate : 2012.06.18
*@LastModifier : 
*@LastVersion : 1.0
* 2012.06.18  
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
 * @author 
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class TesEdiRcvRuleMnVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<TesEdiRcvRuleMnVO> models = new ArrayList<TesEdiRcvRuleMnVO>();
	
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String deltFlg = null;
	/* Column Info */
	private String rcvrId = null;
	/* Column Info */
	private String cfmDt = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String initAllTagValChkFlg = null;
	/* Column Info */
	private String invTagNm = null;
	/* Column Info */
	private String ediRmk = null;
	/* Column Info */
	private String initInvTagValChkFlg = null;
	/* Column Info */
	private String deltDt = null;
	/* Column Info */
	private String cfmFlg = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String creUsrId = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String ediRcvRuleMnSeq = null;
	/* Column Info */
	private String sndrId = null;
	/* Column Info */
	private String updUsrId = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public TesEdiRcvRuleMnVO() {}

	public TesEdiRcvRuleMnVO(String ibflag, String pagerows, String ediRcvRuleMnSeq, String sndrId, String rcvrId, String cfmFlg, String cfmDt, String deltFlg, String deltDt, String invTagNm, String initInvTagValChkFlg, String initAllTagValChkFlg, String ediRmk, String creUsrId, String creDt, String updUsrId, String updDt) {
		this.updDt = updDt;
		this.deltFlg = deltFlg;
		this.rcvrId = rcvrId;
		this.cfmDt = cfmDt;
		this.creDt = creDt;
		this.initAllTagValChkFlg = initAllTagValChkFlg;
		this.invTagNm = invTagNm;
		this.ediRmk = ediRmk;
		this.initInvTagValChkFlg = initInvTagValChkFlg;
		this.deltDt = deltDt;
		this.cfmFlg = cfmFlg;
		this.pagerows = pagerows;
		this.creUsrId = creUsrId;
		this.ibflag = ibflag;
		this.ediRcvRuleMnSeq = ediRcvRuleMnSeq;
		this.sndrId = sndrId;
		this.updUsrId = updUsrId;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("delt_flg", getDeltFlg());
		this.hashColumns.put("rcvr_id", getRcvrId());
		this.hashColumns.put("cfm_dt", getCfmDt());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("init_all_tag_val_chk_flg", getInitAllTagValChkFlg());
		this.hashColumns.put("inv_tag_nm", getInvTagNm());
		this.hashColumns.put("edi_rmk", getEdiRmk());
		this.hashColumns.put("init_inv_tag_val_chk_flg", getInitInvTagValChkFlg());
		this.hashColumns.put("delt_dt", getDeltDt());
		this.hashColumns.put("cfm_flg", getCfmFlg());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("edi_rcv_rule_mn_seq", getEdiRcvRuleMnSeq());
		this.hashColumns.put("sndr_id", getSndrId());
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
		this.hashFields.put("rcvr_id", "rcvrId");
		this.hashFields.put("cfm_dt", "cfmDt");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("init_all_tag_val_chk_flg", "initAllTagValChkFlg");
		this.hashFields.put("inv_tag_nm", "invTagNm");
		this.hashFields.put("edi_rmk", "ediRmk");
		this.hashFields.put("init_inv_tag_val_chk_flg", "initInvTagValChkFlg");
		this.hashFields.put("delt_dt", "deltDt");
		this.hashFields.put("cfm_flg", "cfmFlg");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("edi_rcv_rule_mn_seq", "ediRcvRuleMnSeq");
		this.hashFields.put("sndr_id", "sndrId");
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
	 * @return rcvrId
	 */
	public String getRcvrId() {
		return this.rcvrId;
	}
	
	/**
	 * Column Info
	 * @return cfmDt
	 */
	public String getCfmDt() {
		return this.cfmDt;
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
	 * @return initAllTagValChkFlg
	 */
	public String getInitAllTagValChkFlg() {
		return this.initAllTagValChkFlg;
	}
	
	/**
	 * Column Info
	 * @return invTagNm
	 */
	public String getInvTagNm() {
		return this.invTagNm;
	}
	
	/**
	 * Column Info
	 * @return ediRmk
	 */
	public String getEdiRmk() {
		return this.ediRmk;
	}
	
	/**
	 * Column Info
	 * @return initInvTagValChkFlg
	 */
	public String getInitInvTagValChkFlg() {
		return this.initInvTagValChkFlg;
	}
	
	/**
	 * Column Info
	 * @return deltDt
	 */
	public String getDeltDt() {
		return this.deltDt;
	}
	
	/**
	 * Column Info
	 * @return cfmFlg
	 */
	public String getCfmFlg() {
		return this.cfmFlg;
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
	 * @return ediRcvRuleMnSeq
	 */
	public String getEdiRcvRuleMnSeq() {
		return this.ediRcvRuleMnSeq;
	}
	
	/**
	 * Column Info
	 * @return sndrId
	 */
	public String getSndrId() {
		return this.sndrId;
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
	 * @param rcvrId
	 */
	public void setRcvrId(String rcvrId) {
		this.rcvrId = rcvrId;
	}
	
	/**
	 * Column Info
	 * @param cfmDt
	 */
	public void setCfmDt(String cfmDt) {
		this.cfmDt = cfmDt;
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
	 * @param initAllTagValChkFlg
	 */
	public void setInitAllTagValChkFlg(String initAllTagValChkFlg) {
		this.initAllTagValChkFlg = initAllTagValChkFlg;
	}
	
	/**
	 * Column Info
	 * @param invTagNm
	 */
	public void setInvTagNm(String invTagNm) {
		this.invTagNm = invTagNm;
	}
	
	/**
	 * Column Info
	 * @param ediRmk
	 */
	public void setEdiRmk(String ediRmk) {
		this.ediRmk = ediRmk;
	}
	
	/**
	 * Column Info
	 * @param initInvTagValChkFlg
	 */
	public void setInitInvTagValChkFlg(String initInvTagValChkFlg) {
		this.initInvTagValChkFlg = initInvTagValChkFlg;
	}
	
	/**
	 * Column Info
	 * @param deltDt
	 */
	public void setDeltDt(String deltDt) {
		this.deltDt = deltDt;
	}
	
	/**
	 * Column Info
	 * @param cfmFlg
	 */
	public void setCfmFlg(String cfmFlg) {
		this.cfmFlg = cfmFlg;
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
	 * @param ediRcvRuleMnSeq
	 */
	public void setEdiRcvRuleMnSeq(String ediRcvRuleMnSeq) {
		this.ediRcvRuleMnSeq = ediRcvRuleMnSeq;
	}
	
	/**
	 * Column Info
	 * @param sndrId
	 */
	public void setSndrId(String sndrId) {
		this.sndrId = sndrId;
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
		setRcvrId(JSPUtil.getParameter(request, prefix + "rcvr_id", ""));
		setCfmDt(JSPUtil.getParameter(request, prefix + "cfm_dt", ""));
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
		setInitAllTagValChkFlg(JSPUtil.getParameter(request, prefix + "init_all_tag_val_chk_flg", ""));
		setInvTagNm(JSPUtil.getParameter(request, prefix + "inv_tag_nm", ""));
		setEdiRmk(JSPUtil.getParameter(request, prefix + "edi_rmk", ""));
		setInitInvTagValChkFlg(JSPUtil.getParameter(request, prefix + "init_inv_tag_val_chk_flg", ""));
		setDeltDt(JSPUtil.getParameter(request, prefix + "delt_dt", ""));
		setCfmFlg(JSPUtil.getParameter(request, prefix + "cfm_flg", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setEdiRcvRuleMnSeq(JSPUtil.getParameter(request, prefix + "edi_rcv_rule_mn_seq", ""));
		setSndrId(JSPUtil.getParameter(request, prefix + "sndr_id", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return TesEdiRcvRuleMnVO[]
	 */
	public TesEdiRcvRuleMnVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return TesEdiRcvRuleMnVO[]
	 */
	public TesEdiRcvRuleMnVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		TesEdiRcvRuleMnVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] deltFlg = (JSPUtil.getParameter(request, prefix	+ "delt_flg", length));
			String[] rcvrId = (JSPUtil.getParameter(request, prefix	+ "rcvr_id", length));
			String[] cfmDt = (JSPUtil.getParameter(request, prefix	+ "cfm_dt", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] initAllTagValChkFlg = (JSPUtil.getParameter(request, prefix	+ "init_all_tag_val_chk_flg", length));
			String[] invTagNm = (JSPUtil.getParameter(request, prefix	+ "inv_tag_nm", length));
			String[] ediRmk = (JSPUtil.getParameter(request, prefix	+ "edi_rmk", length));
			String[] initInvTagValChkFlg = (JSPUtil.getParameter(request, prefix	+ "init_inv_tag_val_chk_flg", length));
			String[] deltDt = (JSPUtil.getParameter(request, prefix	+ "delt_dt", length));
			String[] cfmFlg = (JSPUtil.getParameter(request, prefix	+ "cfm_flg", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] ediRcvRuleMnSeq = (JSPUtil.getParameter(request, prefix	+ "edi_rcv_rule_mn_seq", length));
			String[] sndrId = (JSPUtil.getParameter(request, prefix	+ "sndr_id", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			
			for (int i = 0; i < length; i++) {
				model = new TesEdiRcvRuleMnVO();
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (deltFlg[i] != null)
					model.setDeltFlg(deltFlg[i]);
				if (rcvrId[i] != null)
					model.setRcvrId(rcvrId[i]);
				if (cfmDt[i] != null)
					model.setCfmDt(cfmDt[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (initAllTagValChkFlg[i] != null)
					model.setInitAllTagValChkFlg(initAllTagValChkFlg[i]);
				if (invTagNm[i] != null)
					model.setInvTagNm(invTagNm[i]);
				if (ediRmk[i] != null)
					model.setEdiRmk(ediRmk[i]);
				if (initInvTagValChkFlg[i] != null)
					model.setInitInvTagValChkFlg(initInvTagValChkFlg[i]);
				if (deltDt[i] != null)
					model.setDeltDt(deltDt[i]);
				if (cfmFlg[i] != null)
					model.setCfmFlg(cfmFlg[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (ediRcvRuleMnSeq[i] != null)
					model.setEdiRcvRuleMnSeq(ediRcvRuleMnSeq[i]);
				if (sndrId[i] != null)
					model.setSndrId(sndrId[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getTesEdiRcvRuleMnVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return TesEdiRcvRuleMnVO[]
	 */
	public TesEdiRcvRuleMnVO[] getTesEdiRcvRuleMnVOs(){
		TesEdiRcvRuleMnVO[] vos = (TesEdiRcvRuleMnVO[])models.toArray(new TesEdiRcvRuleMnVO[models.size()]);
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
		this.rcvrId = this.rcvrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cfmDt = this.cfmDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.initAllTagValChkFlg = this.initAllTagValChkFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invTagNm = this.invTagNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ediRmk = this.ediRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.initInvTagValChkFlg = this.initInvTagValChkFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.deltDt = this.deltDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cfmFlg = this.cfmFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ediRcvRuleMnSeq = this.ediRcvRuleMnSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sndrId = this.sndrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
