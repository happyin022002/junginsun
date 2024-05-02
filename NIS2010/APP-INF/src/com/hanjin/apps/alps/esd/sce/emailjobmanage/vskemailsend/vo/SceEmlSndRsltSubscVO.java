/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : SceEmlSndRsltSubscVO.java
*@FileTitle : SceEmlSndRsltSubscVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.07.27
*@LastModifier : 박준용
*@LastVersion : 1.0
* 2010.07.27 박준용 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esd.sce.emailjobmanage.vskemailsend.vo;

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
 * @author 박준용
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SceEmlSndRsltSubscVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SceEmlSndRsltSubscVO> models = new ArrayList<SceEmlSndRsltSubscVO>();
	
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String subscTpCd = null;
	/* Column Info */
	private String deltFlg = null;
	/* Column Info */
	private String emlEvntMnt = null;
	/* Column Info */
	private String subscEml = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String emlEvntHr = null;
	/* Column Info */
	private String svcEndDt = null;
	/* Column Info */
	private String subscSeq = null;
	/* Column Info */
	private String emlCtnt = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String emlEvntDt = null;
	/* Column Info */
	private String emlGrpId = null;
	/* Column Info */
	private String creUsrId = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String svcStDt = null;
	/* Column Info */
	private String emlJbId = null;
	/* Column Info */
	private String emlSndRsltRmk = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String emlSndRsltFlg = null;
	/* Column Info */
	private String sysDt = null;
	/* Column Info */
	private String vslSlanCd = null;
	/* Column Info */
	private String toPortCd = null;
	

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SceEmlSndRsltSubscVO() {}

	public SceEmlSndRsltSubscVO(String ibflag, String pagerows, String emlJbId, String svcStDt, String svcEndDt, String emlGrpId, String subscSeq, String emlEvntDt, String emlEvntHr, String emlEvntMnt, String emlCtnt, String emlSndRsltFlg, String emlSndRsltRmk, String creUsrId, String creDt, String updUsrId, String updDt, String subscTpCd, String subscEml, String deltFlg, String sysDt, String vslSlanCd, String toPortCd) {
		this.updDt = updDt;
		this.subscTpCd = subscTpCd;
		this.deltFlg = deltFlg;
		this.emlEvntMnt = emlEvntMnt;
		this.subscEml = subscEml;
		this.creDt = creDt;
		this.emlEvntHr = emlEvntHr;
		this.svcEndDt = svcEndDt;
		this.subscSeq = subscSeq;
		this.emlCtnt = emlCtnt;
		this.pagerows = pagerows;
		this.emlEvntDt = emlEvntDt;
		this.emlGrpId = emlGrpId;
		this.creUsrId = creUsrId;
		this.ibflag = ibflag;
		this.svcStDt = svcStDt;
		this.emlJbId = emlJbId;
		this.emlSndRsltRmk = emlSndRsltRmk;
		this.updUsrId = updUsrId;
		this.emlSndRsltFlg = emlSndRsltFlg;
		this.sysDt = sysDt;
		this.vslSlanCd = vslSlanCd;
		this.toPortCd = toPortCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("subsc_tp_cd", getSubscTpCd());
		this.hashColumns.put("delt_flg", getDeltFlg());
		this.hashColumns.put("eml_evnt_mnt", getEmlEvntMnt());
		this.hashColumns.put("subsc_eml", getSubscEml());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("eml_evnt_hr", getEmlEvntHr());
		this.hashColumns.put("svc_end_dt", getSvcEndDt());
		this.hashColumns.put("subsc_seq", getSubscSeq());
		this.hashColumns.put("eml_ctnt", getEmlCtnt());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("eml_evnt_dt", getEmlEvntDt());
		this.hashColumns.put("eml_grp_id", getEmlGrpId());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("svc_st_dt", getSvcStDt());
		this.hashColumns.put("eml_jb_id", getEmlJbId());
		this.hashColumns.put("eml_snd_rslt_rmk", getEmlSndRsltRmk());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("eml_snd_rslt_flg", getEmlSndRsltFlg());
		this.hashColumns.put("sys_dt", getSysDt());
		this.hashColumns.put("vsl_slan_cd", getVslSlanCd());
		this.hashColumns.put("to_port_cd", getToPortCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("subsc_tp_cd", "subscTpCd");
		this.hashFields.put("delt_flg", "deltFlg");
		this.hashFields.put("eml_evnt_mnt", "emlEvntMnt");
		this.hashFields.put("subsc_eml", "subscEml");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("eml_evnt_hr", "emlEvntHr");
		this.hashFields.put("svc_end_dt", "svcEndDt");
		this.hashFields.put("subsc_seq", "subscSeq");
		this.hashFields.put("eml_ctnt", "emlCtnt");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("eml_evnt_dt", "emlEvntDt");
		this.hashFields.put("eml_grp_id", "emlGrpId");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("svc_st_dt", "svcStDt");
		this.hashFields.put("eml_jb_id", "emlJbId");
		this.hashFields.put("eml_snd_rslt_rmk", "emlSndRsltRmk");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("eml_snd_rslt_flg", "emlSndRsltFlg");
		this.hashFields.put("sys_dt", "sysDt");
		this.hashFields.put("vsl_slan_cd", "vslSlanCd");
		this.hashFields.put("to_port_cd", "toPortCd");
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
	 * @return subscTpCd
	 */
	public String getSubscTpCd() {
		return this.subscTpCd;
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
	 * @return emlEvntMnt
	 */
	public String getEmlEvntMnt() {
		return this.emlEvntMnt;
	}
	
	/**
	 * Column Info
	 * @return subscEml
	 */
	public String getSubscEml() {
		return this.subscEml;
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
	 * @return emlEvntHr
	 */
	public String getEmlEvntHr() {
		return this.emlEvntHr;
	}
	
	/**
	 * Column Info
	 * @return svcEndDt
	 */
	public String getSvcEndDt() {
		return this.svcEndDt;
	}
	
	/**
	 * Column Info
	 * @return subscSeq
	 */
	public String getSubscSeq() {
		return this.subscSeq;
	}
	
	/**
	 * Column Info
	 * @return emlCtnt
	 */
	public String getEmlCtnt() {
		return this.emlCtnt;
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
	 * @return emlEvntDt
	 */
	public String getEmlEvntDt() {
		return this.emlEvntDt;
	}
	
	/**
	 * Column Info
	 * @return emlGrpId
	 */
	public String getEmlGrpId() {
		return this.emlGrpId;
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
	 * @return svcStDt
	 */
	public String getSvcStDt() {
		return this.svcStDt;
	}
	
	/**
	 * Column Info
	 * @return emlJbId
	 */
	public String getEmlJbId() {
		return this.emlJbId;
	}
	
	/**
	 * Column Info
	 * @return emlSndRsltRmk
	 */
	public String getEmlSndRsltRmk() {
		return this.emlSndRsltRmk;
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
	 * @return emlSndRsltFlg
	 */
	public String getEmlSndRsltFlg() {
		return this.emlSndRsltFlg;
	}
	
	/**
	 * Column Info
	 * @return sysDt
	 */
	public String getSysDt() {
		return this.sysDt;
	}
	
	/**
	 * Column Info
	 * @return vslSlanCd
	 */
	public String getVslSlanCd() {
		return vslSlanCd;
	}

	/**
	 * Column Info
	 * @return toPortCd
	 */
	public String getToPortCd() {
		return toPortCd;
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
	 * @param subscTpCd
	 */
	public void setSubscTpCd(String subscTpCd) {
		this.subscTpCd = subscTpCd;
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
	 * @param emlEvntMnt
	 */
	public void setEmlEvntMnt(String emlEvntMnt) {
		this.emlEvntMnt = emlEvntMnt;
	}
	
	/**
	 * Column Info
	 * @param subscEml
	 */
	public void setSubscEml(String subscEml) {
		this.subscEml = subscEml;
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
	 * @param emlEvntHr
	 */
	public void setEmlEvntHr(String emlEvntHr) {
		this.emlEvntHr = emlEvntHr;
	}
	
	/**
	 * Column Info
	 * @param svcEndDt
	 */
	public void setSvcEndDt(String svcEndDt) {
		this.svcEndDt = svcEndDt;
	}
	
	/**
	 * Column Info
	 * @param subscSeq
	 */
	public void setSubscSeq(String subscSeq) {
		this.subscSeq = subscSeq;
	}
	
	/**
	 * Column Info
	 * @param emlCtnt
	 */
	public void setEmlCtnt(String emlCtnt) {
		this.emlCtnt = emlCtnt;
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
	 * @param emlEvntDt
	 */
	public void setEmlEvntDt(String emlEvntDt) {
		this.emlEvntDt = emlEvntDt;
	}
	
	/**
	 * Column Info
	 * @param emlGrpId
	 */
	public void setEmlGrpId(String emlGrpId) {
		this.emlGrpId = emlGrpId;
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
	 * @param svcStDt
	 */
	public void setSvcStDt(String svcStDt) {
		this.svcStDt = svcStDt;
	}
	
	/**
	 * Column Info
	 * @param emlJbId
	 */
	public void setEmlJbId(String emlJbId) {
		this.emlJbId = emlJbId;
	}
	
	/**
	 * Column Info
	 * @param emlSndRsltRmk
	 */
	public void setEmlSndRsltRmk(String emlSndRsltRmk) {
		this.emlSndRsltRmk = emlSndRsltRmk;
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
	 * @param emlSndRsltFlg
	 */
	public void setEmlSndRsltFlg(String emlSndRsltFlg) {
		this.emlSndRsltFlg = emlSndRsltFlg;
	}
	
	/**
	 * Column Info
	 * @param sysDt
	 */
	public void setSysDt(String sysDt) {
		this.sysDt = sysDt;
	}
	
	/**
	 * Column Info
	 * @param vslSlanCd
	 */
	public void setVslSlanCd(String vslSlanCd) {
		this.vslSlanCd = vslSlanCd;
	}

	/**
	 * Column Info
	 * @param toPortCd
	 */
	public void setToPortCd(String toPortCd) {
		this.toPortCd = toPortCd;
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
		setSubscTpCd(JSPUtil.getParameter(request, prefix + "subsc_tp_cd", ""));
		setDeltFlg(JSPUtil.getParameter(request, prefix + "delt_flg", ""));
		setEmlEvntMnt(JSPUtil.getParameter(request, prefix + "eml_evnt_mnt", ""));
		setSubscEml(JSPUtil.getParameter(request, prefix + "subsc_eml", ""));
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
		setEmlEvntHr(JSPUtil.getParameter(request, prefix + "eml_evnt_hr", ""));
		setSvcEndDt(JSPUtil.getParameter(request, prefix + "svc_end_dt", ""));
		setSubscSeq(JSPUtil.getParameter(request, prefix + "subsc_seq", ""));
		setEmlCtnt(JSPUtil.getParameter(request, prefix + "eml_ctnt", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setEmlEvntDt(JSPUtil.getParameter(request, prefix + "eml_evnt_dt", ""));
		setEmlGrpId(JSPUtil.getParameter(request, prefix + "eml_grp_id", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setSvcStDt(JSPUtil.getParameter(request, prefix + "svc_st_dt", ""));
		setEmlJbId(JSPUtil.getParameter(request, prefix + "eml_jb_id", ""));
		setEmlSndRsltRmk(JSPUtil.getParameter(request, prefix + "eml_snd_rslt_rmk", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setEmlSndRsltFlg(JSPUtil.getParameter(request, prefix + "eml_snd_rslt_flg", ""));
		setSysDt(JSPUtil.getParameter(request, prefix + "sys_dt", ""));
		setVslSlanCd(JSPUtil.getParameter(request, prefix + "vsl_slan_cd", ""));
		setToPortCd(JSPUtil.getParameter(request, prefix + "to_port_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SceEmlSndRsltSubscVO[]
	 */
	public SceEmlSndRsltSubscVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SceEmlSndRsltSubscVO[]
	 */
	public SceEmlSndRsltSubscVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SceEmlSndRsltSubscVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] subscTpCd = (JSPUtil.getParameter(request, prefix	+ "subsc_tp_cd", length));
			String[] deltFlg = (JSPUtil.getParameter(request, prefix	+ "delt_flg", length));
			String[] emlEvntMnt = (JSPUtil.getParameter(request, prefix	+ "eml_evnt_mnt", length));
			String[] subscEml = (JSPUtil.getParameter(request, prefix	+ "subsc_eml", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] emlEvntHr = (JSPUtil.getParameter(request, prefix	+ "eml_evnt_hr", length));
			String[] svcEndDt = (JSPUtil.getParameter(request, prefix	+ "svc_end_dt", length));
			String[] subscSeq = (JSPUtil.getParameter(request, prefix	+ "subsc_seq", length));
			String[] emlCtnt = (JSPUtil.getParameter(request, prefix	+ "eml_ctnt", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] emlEvntDt = (JSPUtil.getParameter(request, prefix	+ "eml_evnt_dt", length));
			String[] emlGrpId = (JSPUtil.getParameter(request, prefix	+ "eml_grp_id", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] svcStDt = (JSPUtil.getParameter(request, prefix	+ "svc_st_dt", length));
			String[] emlJbId = (JSPUtil.getParameter(request, prefix	+ "eml_jb_id", length));
			String[] emlSndRsltRmk = (JSPUtil.getParameter(request, prefix	+ "eml_snd_rslt_rmk", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] emlSndRsltFlg = (JSPUtil.getParameter(request, prefix	+ "eml_snd_rslt_flg", length));
			String[] sysDt = (JSPUtil.getParameter(request, prefix	+ "sys_dt", length));
			String[] vslSlanCd = (JSPUtil.getParameter(request, prefix	+ "vsl_slan_cd", length));
			String[] toPortCd = (JSPUtil.getParameter(request, prefix	+ "to_port_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new SceEmlSndRsltSubscVO();
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (subscTpCd[i] != null)
					model.setSubscTpCd(subscTpCd[i]);
				if (deltFlg[i] != null)
					model.setDeltFlg(deltFlg[i]);
				if (emlEvntMnt[i] != null)
					model.setEmlEvntMnt(emlEvntMnt[i]);
				if (subscEml[i] != null)
					model.setSubscEml(subscEml[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (emlEvntHr[i] != null)
					model.setEmlEvntHr(emlEvntHr[i]);
				if (svcEndDt[i] != null)
					model.setSvcEndDt(svcEndDt[i]);
				if (subscSeq[i] != null)
					model.setSubscSeq(subscSeq[i]);
				if (emlCtnt[i] != null)
					model.setEmlCtnt(emlCtnt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (emlEvntDt[i] != null)
					model.setEmlEvntDt(emlEvntDt[i]);
				if (emlGrpId[i] != null)
					model.setEmlGrpId(emlGrpId[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (svcStDt[i] != null)
					model.setSvcStDt(svcStDt[i]);
				if (emlJbId[i] != null)
					model.setEmlJbId(emlJbId[i]);
				if (emlSndRsltRmk[i] != null)
					model.setEmlSndRsltRmk(emlSndRsltRmk[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (emlSndRsltFlg[i] != null)
					model.setEmlSndRsltFlg(emlSndRsltFlg[i]);
				if (sysDt[i] != null)
					model.setSysDt(sysDt[i]);
				if (vslSlanCd[i] != null)
					model.setVslSlanCd(vslSlanCd[i]);
				if (toPortCd[i] != null)
					model.setToPortCd(toPortCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSceEmlSndRsltSubscVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SceEmlSndRsltSubscVO[]
	 */
	public SceEmlSndRsltSubscVO[] getSceEmlSndRsltSubscVOs(){
		SceEmlSndRsltSubscVO[] vos = (SceEmlSndRsltSubscVO[])models.toArray(new SceEmlSndRsltSubscVO[models.size()]);
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
		this.subscTpCd = this.subscTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.deltFlg = this.deltFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.emlEvntMnt = this.emlEvntMnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.subscEml = this.subscEml .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.emlEvntHr = this.emlEvntHr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.svcEndDt = this.svcEndDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.subscSeq = this.subscSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.emlCtnt = this.emlCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.emlEvntDt = this.emlEvntDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.emlGrpId = this.emlGrpId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.svcStDt = this.svcStDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.emlJbId = this.emlJbId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.emlSndRsltRmk = this.emlSndRsltRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.emlSndRsltFlg = this.emlSndRsltFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sysDt = this.sysDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslSlanCd = this.vslSlanCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toPortCd = this.toPortCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
