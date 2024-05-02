/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : BlCluzStupVO.java
*@FileTitle : BlCluzStupVO
*Open Issues :
*Change history :
*@LastModifyDate : 2015.07.24
*@LastModifier : Maeda Atsushi
*@LastVersion : 1.0
* 2015.07.24 Maeda Atsushi 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.bookingmasterdata.usersetupmgt.vo;

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
 * @author Maeda Atsushi
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class BlCluzStupVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<BlCluzStupVO> models = new ArrayList<BlCluzStupVO>();
	
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String deltFlg = null;
	/* Column Info */
	private String porApplFlg = null;
	/* Column Info */
	private String creDt = null;
	/* Page Number */
	private String pagerows = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String orgCntCd = null;
	/* Column Info */
	private String itmSeq = null;
	/* Column Info */
	private String cmdtDesc = null;
	/* Column Info */
	private String delApplFlg = null;
	/* Column Info */
	private String polApplFlg = null;
	/* Column Info */
	private String podApplFlg = null;
	/* Column Info */
	private String updUsrId = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public BlCluzStupVO() {}

	public BlCluzStupVO(String ibflag, String pagerows, String itmSeq, String orgCntCd, String porApplFlg, String polApplFlg, String podApplFlg, String delApplFlg, String cmdtDesc, String deltFlg, String creUsrId, String creDt, String updUsrId, String updDt) {
		this.updDt = updDt;
		this.deltFlg = deltFlg;
		this.porApplFlg = porApplFlg;
		this.creDt = creDt;
		this.pagerows = pagerows;
		this.ibflag = ibflag;
		this.creUsrId = creUsrId;
		this.orgCntCd = orgCntCd;
		this.itmSeq = itmSeq;
		this.cmdtDesc = cmdtDesc;
		this.delApplFlg = delApplFlg;
		this.polApplFlg = polApplFlg;
		this.podApplFlg = podApplFlg;
		this.updUsrId = updUsrId;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("delt_flg", getDeltFlg());
		this.hashColumns.put("por_appl_flg", getPorApplFlg());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("org_cnt_cd", getOrgCntCd());
		this.hashColumns.put("itm_seq", getItmSeq());
		this.hashColumns.put("cmdt_desc", getCmdtDesc());
		this.hashColumns.put("del_appl_flg", getDelApplFlg());
		this.hashColumns.put("pol_appl_flg", getPolApplFlg());
		this.hashColumns.put("pod_appl_flg", getPodApplFlg());
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
		this.hashFields.put("por_appl_flg", "porApplFlg");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("org_cnt_cd", "orgCntCd");
		this.hashFields.put("itm_seq", "itmSeq");
		this.hashFields.put("cmdt_desc", "cmdtDesc");
		this.hashFields.put("del_appl_flg", "delApplFlg");
		this.hashFields.put("pol_appl_flg", "polApplFlg");
		this.hashFields.put("pod_appl_flg", "podApplFlg");
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
	 * @return porApplFlg
	 */
	public String getPorApplFlg() {
		return this.porApplFlg;
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
	 * @return orgCntCd
	 */
	public String getOrgCntCd() {
		return this.orgCntCd;
	}
	
	/**
	 * Column Info
	 * @return itmSeq
	 */
	public String getItmSeq() {
		return this.itmSeq;
	}
	
	/**
	 * Column Info
	 * @return cmdtDesc
	 */
	public String getCmdtDesc() {
		return this.cmdtDesc;
	}
	
	/**
	 * Column Info
	 * @return delApplFlg
	 */
	public String getDelApplFlg() {
		return this.delApplFlg;
	}
	
	/**
	 * Column Info
	 * @return polApplFlg
	 */
	public String getPolApplFlg() {
		return this.polApplFlg;
	}
	
	/**
	 * Column Info
	 * @return podApplFlg
	 */
	public String getPodApplFlg() {
		return this.podApplFlg;
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
	 * @param porApplFlg
	 */
	public void setPorApplFlg(String porApplFlg) {
		this.porApplFlg = porApplFlg;
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
	 * @param orgCntCd
	 */
	public void setOrgCntCd(String orgCntCd) {
		this.orgCntCd = orgCntCd;
	}
	
	/**
	 * Column Info
	 * @param itmSeq
	 */
	public void setItmSeq(String itmSeq) {
		this.itmSeq = itmSeq;
	}
	
	/**
	 * Column Info
	 * @param cmdtDesc
	 */
	public void setCmdtDesc(String cmdtDesc) {
		this.cmdtDesc = cmdtDesc;
	}
	
	/**
	 * Column Info
	 * @param delApplFlg
	 */
	public void setDelApplFlg(String delApplFlg) {
		this.delApplFlg = delApplFlg;
	}
	
	/**
	 * Column Info
	 * @param polApplFlg
	 */
	public void setPolApplFlg(String polApplFlg) {
		this.polApplFlg = polApplFlg;
	}
	
	/**
	 * Column Info
	 * @param podApplFlg
	 */
	public void setPodApplFlg(String podApplFlg) {
		this.podApplFlg = podApplFlg;
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
		setPorApplFlg(JSPUtil.getParameter(request, prefix + "por_appl_flg", ""));
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setOrgCntCd(JSPUtil.getParameter(request, prefix + "org_cnt_cd", ""));
		setItmSeq(JSPUtil.getParameter(request, prefix + "itm_seq", ""));
		setCmdtDesc(JSPUtil.getParameter(request, prefix + "cmdt_desc", ""));
		setDelApplFlg(JSPUtil.getParameter(request, prefix + "del_appl_flg", ""));
		setPolApplFlg(JSPUtil.getParameter(request, prefix + "pol_appl_flg", ""));
		setPodApplFlg(JSPUtil.getParameter(request, prefix + "pod_appl_flg", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return BlCluzStupVO[]
	 */
	public BlCluzStupVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return BlCluzStupVO[]
	 */
	public BlCluzStupVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		BlCluzStupVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] deltFlg = (JSPUtil.getParameter(request, prefix	+ "delt_flg", length));
			String[] porApplFlg = (JSPUtil.getParameter(request, prefix	+ "por_appl_flg", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] orgCntCd = (JSPUtil.getParameter(request, prefix	+ "org_cnt_cd", length));
			String[] itmSeq = (JSPUtil.getParameter(request, prefix	+ "itm_seq", length));
			String[] cmdtDesc = (JSPUtil.getParameter(request, prefix	+ "cmdt_desc", length));
			String[] delApplFlg = (JSPUtil.getParameter(request, prefix	+ "del_appl_flg", length));
			String[] polApplFlg = (JSPUtil.getParameter(request, prefix	+ "pol_appl_flg", length));
			String[] podApplFlg = (JSPUtil.getParameter(request, prefix	+ "pod_appl_flg", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			
			for (int i = 0; i < length; i++) {
				model = new BlCluzStupVO();
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (deltFlg[i] != null)
					model.setDeltFlg(deltFlg[i]);
				if (porApplFlg[i] != null)
					model.setPorApplFlg(porApplFlg[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (orgCntCd[i] != null)
					model.setOrgCntCd(orgCntCd[i]);
				if (itmSeq[i] != null)
					model.setItmSeq(itmSeq[i]);
				if (cmdtDesc[i] != null)
					model.setCmdtDesc(cmdtDesc[i]);
				if (delApplFlg[i] != null)
					model.setDelApplFlg(delApplFlg[i]);
				if (polApplFlg[i] != null)
					model.setPolApplFlg(polApplFlg[i]);
				if (podApplFlg[i] != null)
					model.setPodApplFlg(podApplFlg[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getBlCluzStupVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return BlCluzStupVO[]
	 */
	public BlCluzStupVO[] getBlCluzStupVOs(){
		BlCluzStupVO[] vos = (BlCluzStupVO[])models.toArray(new BlCluzStupVO[models.size()]);
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
		this.porApplFlg = this.porApplFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgCntCd = this.orgCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.itmSeq = this.itmSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmdtDesc = this.cmdtDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delApplFlg = this.delApplFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polApplFlg = this.polApplFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podApplFlg = this.podApplFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
