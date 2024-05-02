/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : BkgCstmsChnAgnStupVO.java
*@FileTitle : BkgCstmsChnAgnStupVO
*Open Issues :
*Change history :
*@LastModifyDate : 2011.07.14
*@LastModifier : KIM HYUN HWA
*@LastVersion : 1.0
* 2011.07.14 KIM HYUN HWA 
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

public class BkgCstmsChnAgnStupVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<BkgCstmsChnAgnStupVO> models = new ArrayList<BkgCstmsChnAgnStupVO>();
	
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String chnCstmsAgnNm = null;
	/* Column Info */
	private String ediSndId = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String chnCstmsAgnRmk = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String podCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String slanCd = null;
	/* Column Info */
	private String ediRcvId = null;
	/* Column Info */
	private String creOfcCd = null;
	/* Column Info */
	private String agnCtrlOfcCd = null;
	/* Column Info */
	private String chnCstmsAgnCd = null;
	/* Column Info */
	private String updUsrId = null;
	
	/* Column Info */
	private String chnCstmsAgnFullNm = null;
	/* Column Info */
	private String chnCstmsAgnPicNm = null;
	/* Column Info */
	private String chnCstmsAgnPhnNo = null;
	/* Column Info */
	private String chnCstmsAgnEml = null;
	/* Column Info */
	private String chnCstmsAgnAddr = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public BkgCstmsChnAgnStupVO() {}

	public BkgCstmsChnAgnStupVO(String ibflag, String pagerows, String agnCtrlOfcCd, String podCd, String chnCstmsAgnCd, String slanCd, String chnCstmsAgnNm, String ediRcvId, String ediSndId, String chnCstmsAgnRmk, String creUsrId, String creOfcCd, String creDt, String updUsrId, String updDt, String chnCstmsAgnFullNm, String chnCstmsAgnPicNm, String chnCstmsAgnPhnNo, String chnCstmsAgnEml, String chnCstmsAgnAddr) {
		this.updDt = updDt;
		this.chnCstmsAgnNm = chnCstmsAgnNm;
		this.ediSndId = ediSndId;
		this.creDt = creDt;
		this.chnCstmsAgnRmk = chnCstmsAgnRmk;
		this.pagerows = pagerows;
		this.podCd = podCd;
		this.ibflag = ibflag;
		this.creUsrId = creUsrId;
		this.slanCd = slanCd;
		this.ediRcvId = ediRcvId;
		this.creOfcCd = creOfcCd;
		this.agnCtrlOfcCd = agnCtrlOfcCd;
		this.chnCstmsAgnCd = chnCstmsAgnCd;
		this.updUsrId = updUsrId;
		
		this.chnCstmsAgnFullNm = chnCstmsAgnFullNm;
		this.chnCstmsAgnPicNm = chnCstmsAgnPicNm;
		this.chnCstmsAgnPhnNo = chnCstmsAgnPhnNo;
		this.chnCstmsAgnEml = chnCstmsAgnEml;
		this.chnCstmsAgnAddr = chnCstmsAgnAddr;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("chn_cstms_agn_nm", getChnCstmsAgnNm());
		this.hashColumns.put("edi_snd_id", getEdiSndId());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("chn_cstms_agn_rmk", getChnCstmsAgnRmk());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("pod_cd", getPodCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("slan_cd", getSlanCd());
		this.hashColumns.put("edi_rcv_id", getEdiRcvId());
		this.hashColumns.put("cre_ofc_cd", getCreOfcCd());
		this.hashColumns.put("agn_ctrl_ofc_cd", getAgnCtrlOfcCd());
		this.hashColumns.put("chn_cstms_agn_cd", getChnCstmsAgnCd());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		
		this.hashColumns.put("chn_cstms_agn_full_nm", getChnCstmsAgnFullNm());
		this.hashColumns.put("chn_cstms_agn_pic_nm", getChnCstmsAgnPicNm());
		this.hashColumns.put("chn_cstms_agn_phn_no", getChnCstmsAgnPhnNo());
		this.hashColumns.put("chn_cstms_agn_eml", getChnCstmsAgnEml());
		this.hashColumns.put("chn_cstms_agn_addr", getChnCstmsAgnAddr());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("chn_cstms_agn_nm", "chnCstmsAgnNm");
		this.hashFields.put("edi_snd_id", "ediSndId");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("chn_cstms_agn_rmk", "chnCstmsAgnRmk");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("pod_cd", "podCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("slan_cd", "slanCd");
		this.hashFields.put("edi_rcv_id", "ediRcvId");
		this.hashFields.put("cre_ofc_cd", "creOfcCd");
		this.hashFields.put("agn_ctrl_ofc_cd", "agnCtrlOfcCd");
		this.hashFields.put("chn_cstms_agn_cd", "chnCstmsAgnCd");
		this.hashFields.put("upd_usr_id", "updUsrId");
		
		this.hashFields.put("chn_cstms_agn_full_nm", "chnCstmsAgnFullNm");
		this.hashFields.put("chn_cstms_agn_pic_nm", "chnCstmsAgnPicNm");
		this.hashFields.put("chn_cstms_agn_phn_no", "chnCstmsAgnPhnNo");
		this.hashFields.put("chn_cstms_agn_eml", "chnCstmsAgnEml");
		this.hashFields.put("chn_cstms_agn_addr", "chnCstmsAgnAddr");
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
	 * @return chnCstmsAgnNm
	 */
	public String getChnCstmsAgnNm() {
		return this.chnCstmsAgnNm;
	}
	
	/**
	 * Column Info
	 * @return ediSndId
	 */
	public String getEdiSndId() {
		return this.ediSndId;
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
	 * @return chnCstmsAgnRmk
	 */
	public String getChnCstmsAgnRmk() {
		return this.chnCstmsAgnRmk;
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
	 * @return podCd
	 */
	public String getPodCd() {
		return this.podCd;
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
	 * @return slanCd
	 */
	public String getSlanCd() {
		return this.slanCd;
	}
	
	/**
	 * Column Info
	 * @return ediRcvId
	 */
	public String getEdiRcvId() {
		return this.ediRcvId;
	}
	
	/**
	 * Column Info
	 * @return creOfcCd
	 */
	public String getCreOfcCd() {
		return this.creOfcCd;
	}
	
	/**
	 * Column Info
	 * @return agnCtrlOfcCd
	 */
	public String getAgnCtrlOfcCd() {
		return this.agnCtrlOfcCd;
	}
	
	/**
	 * Column Info
	 * @return chnCstmsAgnCd
	 */
	public String getChnCstmsAgnCd() {
		return this.chnCstmsAgnCd;
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
	 * @return chnCstmsAgnFullNm
	 */
	public String getChnCstmsAgnFullNm() {
		return this.chnCstmsAgnFullNm;
	}
	
	/**
	 * Column Info
	 * @return chnCstmsAgnPicNm
	 */
	public String getChnCstmsAgnPicNm() {
		return this.chnCstmsAgnPicNm;
	}
	
	/**
	 * Column Info
	 * @return chnCstmsAgnPhnNo
	 */
	public String getChnCstmsAgnPhnNo() {
		return this.chnCstmsAgnPhnNo;
	}
	
	/**
	 * Column Info
	 * @return chnCstmsAgnEml
	 */
	public String getChnCstmsAgnEml() {
		return this.chnCstmsAgnEml;
	}
	
	/**
	 * Column Info
	 * @return chnCstmsAgnAddr
	 */
	public String getChnCstmsAgnAddr() {
		return this.chnCstmsAgnAddr;
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
	 * @param chnCstmsAgnNm
	 */
	public void setChnCstmsAgnNm(String chnCstmsAgnNm) {
		this.chnCstmsAgnNm = chnCstmsAgnNm;
	}
	
	/**
	 * Column Info
	 * @param ediSndId
	 */
	public void setEdiSndId(String ediSndId) {
		this.ediSndId = ediSndId;
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
	 * @param chnCstmsAgnRmk
	 */
	public void setChnCstmsAgnRmk(String chnCstmsAgnRmk) {
		this.chnCstmsAgnRmk = chnCstmsAgnRmk;
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
	 * @param podCd
	 */
	public void setPodCd(String podCd) {
		this.podCd = podCd;
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
	 * @param slanCd
	 */
	public void setSlanCd(String slanCd) {
		this.slanCd = slanCd;
	}
	
	/**
	 * Column Info
	 * @param ediRcvId
	 */
	public void setEdiRcvId(String ediRcvId) {
		this.ediRcvId = ediRcvId;
	}
	
	/**
	 * Column Info
	 * @param creOfcCd
	 */
	public void setCreOfcCd(String creOfcCd) {
		this.creOfcCd = creOfcCd;
	}
	
	/**
	 * Column Info
	 * @param agnCtrlOfcCd
	 */
	public void setAgnCtrlOfcCd(String agnCtrlOfcCd) {
		this.agnCtrlOfcCd = agnCtrlOfcCd;
	}
	
	/**
	 * Column Info
	 * @param chnCstmsAgnCd
	 */
	public void setChnCstmsAgnCd(String chnCstmsAgnCd) {
		this.chnCstmsAgnCd = chnCstmsAgnCd;
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
	 * @param chnCstmsAgnFullNm
	 */
	public void setChnCstmsAgnFullNm(String chnCstmsAgnFullNm) {
		this.chnCstmsAgnFullNm = chnCstmsAgnFullNm;
	}
	
	/**
	 * Column Info
	 * @param chnCstmsAgnPicNm
	 */
	public void setChnCstmsAgnPicNm(String chnCstmsAgnPicNm) {
		this.chnCstmsAgnPicNm = chnCstmsAgnPicNm;
	}
	
	/**
	 * Column Info
	 * @param chnCstmsAgnPhnNo
	 */
	public void setChnCstmsAgnPhnNo(String chnCstmsAgnPhnNo) {
		this.chnCstmsAgnPhnNo = chnCstmsAgnPhnNo;
	}
	
	/**
	 * Column Info
	 * @param chnCstmsAgnEml
	 */
	public void setChnCstmsAgnEml(String chnCstmsAgnEml) {
		this.chnCstmsAgnEml = chnCstmsAgnEml;
	}
	
	/**
	 * Column Info
	 * @param chnCstmsAgnAddr
	 */
	public void setChnCstmsAgnAddr(String chnCstmsAgnAddr) {
		this.chnCstmsAgnAddr = chnCstmsAgnAddr;
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
		setChnCstmsAgnNm(JSPUtil.getParameter(request, prefix + "chn_cstms_agn_nm", ""));
		setEdiSndId(JSPUtil.getParameter(request, prefix + "edi_snd_id", ""));
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
		setChnCstmsAgnRmk(JSPUtil.getParameter(request, prefix + "chn_cstms_agn_rmk", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setPodCd(JSPUtil.getParameter(request, prefix + "pod_cd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setSlanCd(JSPUtil.getParameter(request, prefix + "slan_cd", ""));
		setEdiRcvId(JSPUtil.getParameter(request, prefix + "edi_rcv_id", ""));
		setCreOfcCd(JSPUtil.getParameter(request, prefix + "cre_ofc_cd", ""));
		setAgnCtrlOfcCd(JSPUtil.getParameter(request, prefix + "agn_ctrl_ofc_cd", ""));
		setChnCstmsAgnCd(JSPUtil.getParameter(request, prefix + "chn_cstms_agn_cd", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		
		setChnCstmsAgnFullNm(JSPUtil.getParameter(request, prefix + "chn_cstms_agn_full_nm", ""));
		setChnCstmsAgnPicNm(JSPUtil.getParameter(request, prefix + "chn_cstms_agn_pic_nm", ""));
		setChnCstmsAgnPhnNo(JSPUtil.getParameter(request, prefix + "chn_cstms_agn_phn_no", ""));
		setChnCstmsAgnEml(JSPUtil.getParameter(request, prefix + "chn_cstms_agn_eml", ""));
		setChnCstmsAgnAddr(JSPUtil.getParameter(request, prefix + "chn_cstms_agn_addr", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return BkgCstmsChnAgnStupVO[]
	 */
	public BkgCstmsChnAgnStupVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return BkgCstmsChnAgnStupVO[]
	 */
	public BkgCstmsChnAgnStupVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		BkgCstmsChnAgnStupVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] chnCstmsAgnNm = (JSPUtil.getParameter(request, prefix	+ "chn_cstms_agn_nm", length));
			String[] ediSndId = (JSPUtil.getParameter(request, prefix	+ "edi_snd_id", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] chnCstmsAgnRmk = (JSPUtil.getParameter(request, prefix	+ "chn_cstms_agn_rmk", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] podCd = (JSPUtil.getParameter(request, prefix	+ "pod_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] slanCd = (JSPUtil.getParameter(request, prefix	+ "slan_cd", length));
			String[] ediRcvId = (JSPUtil.getParameter(request, prefix	+ "edi_rcv_id", length));
			String[] creOfcCd = (JSPUtil.getParameter(request, prefix	+ "cre_ofc_cd", length));
			String[] agnCtrlOfcCd = (JSPUtil.getParameter(request, prefix	+ "agn_ctrl_ofc_cd", length));
			String[] chnCstmsAgnCd = (JSPUtil.getParameter(request, prefix	+ "chn_cstms_agn_cd", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			
			String[] chnCstmsAgnFullNm = (JSPUtil.getParameter(request, prefix	+ "chn_cstms_agn_full_nm", length));
			String[] chnCstmsAgnPicNm = (JSPUtil.getParameter(request, prefix	+ "chn_cstms_agn_pic_nm", length));
			String[] chnCstmsAgnPhnNo = (JSPUtil.getParameter(request, prefix	+ "chn_cstms_agn_phn_no", length));
			String[] chnCstmsAgnEml = (JSPUtil.getParameter(request, prefix	+ "chn_cstms_agn_eml", length));
			String[] chnCstmsAgnAddr = (JSPUtil.getParameter(request, prefix	+ "chn_cstms_agn_addr", length));
			
			for (int i = 0; i < length; i++) {
				model = new BkgCstmsChnAgnStupVO();
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (chnCstmsAgnNm[i] != null)
					model.setChnCstmsAgnNm(chnCstmsAgnNm[i]);
				if (ediSndId[i] != null)
					model.setEdiSndId(ediSndId[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (chnCstmsAgnRmk[i] != null)
					model.setChnCstmsAgnRmk(chnCstmsAgnRmk[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (podCd[i] != null)
					model.setPodCd(podCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (slanCd[i] != null)
					model.setSlanCd(slanCd[i]);
				if (ediRcvId[i] != null)
					model.setEdiRcvId(ediRcvId[i]);
				if (creOfcCd[i] != null)
					model.setCreOfcCd(creOfcCd[i]);
				if (agnCtrlOfcCd[i] != null)
					model.setAgnCtrlOfcCd(agnCtrlOfcCd[i]);
				if (chnCstmsAgnCd[i] != null)
					model.setChnCstmsAgnCd(chnCstmsAgnCd[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				
				if (chnCstmsAgnFullNm[i] != null)
					model.setChnCstmsAgnFullNm(chnCstmsAgnFullNm[i]);
				if (chnCstmsAgnPicNm[i] != null)
					model.setChnCstmsAgnPicNm(chnCstmsAgnPicNm[i]);
				if (chnCstmsAgnPhnNo[i] != null)
					model.setChnCstmsAgnPhnNo(chnCstmsAgnPhnNo[i]);
				if (chnCstmsAgnEml[i] != null)
					model.setChnCstmsAgnEml(chnCstmsAgnEml[i]);
				if (chnCstmsAgnAddr[i] != null)
					model.setChnCstmsAgnAddr(chnCstmsAgnAddr[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getBkgCstmsChnAgnStupVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return BkgCstmsChnAgnStupVO[]
	 */
	public BkgCstmsChnAgnStupVO[] getBkgCstmsChnAgnStupVOs(){
		BkgCstmsChnAgnStupVO[] vos = (BkgCstmsChnAgnStupVO[])models.toArray(new BkgCstmsChnAgnStupVO[models.size()]);
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
		this.chnCstmsAgnNm = this.chnCstmsAgnNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ediSndId = this.ediSndId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chnCstmsAgnRmk = this.chnCstmsAgnRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCd = this.podCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slanCd = this.slanCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ediRcvId = this.ediRcvId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creOfcCd = this.creOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agnCtrlOfcCd = this.agnCtrlOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chnCstmsAgnCd = this.chnCstmsAgnCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		
		this.chnCstmsAgnFullNm = this.chnCstmsAgnFullNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chnCstmsAgnPicNm = this.chnCstmsAgnPicNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chnCstmsAgnPhnNo = this.chnCstmsAgnPhnNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chnCstmsAgnEml = this.chnCstmsAgnEml .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chnCstmsAgnAddr = this.chnCstmsAgnAddr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
