/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : ChinaCustmsAgnVO.java
*@FileTitle : ChinaCustmsAgnVO
*Open Issues :
*Change history :
*@LastModifyDate : 2011.08.05
*@LastModifier : 박성진
*@LastVersion : 1.0
* 2011.08.05 박성진 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.china.vo;

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
 * @author 박성진
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class ChinaCustmsAgnVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<ChinaCustmsAgnVO> models = new ArrayList<ChinaCustmsAgnVO>();
	
	/* Column Info */
	private String podCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String ediSndId = null;
	/* Column Info */
	private String chnCstmsAgnNm = null;
	/* Column Info */
	private String slanCd = null;
	/* Column Info */
	private String ediRcvId = null;
	/* Column Info */
	private String agnCtrlOfcCd = null;
	/* Column Info */
	private String chnCstmsAgnCd = null;
	/* Column Info */
	private String chnCstmsAgnRmk = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public ChinaCustmsAgnVO() {}

	public ChinaCustmsAgnVO(String ibflag, String pagerows, String agnCtrlOfcCd, String podCd, String chnCstmsAgnCd, String slanCd, String chnCstmsAgnNm, String ediRcvId, String ediSndId, String chnCstmsAgnRmk) {
		this.podCd = podCd;
		this.ibflag = ibflag;
		this.ediSndId = ediSndId;
		this.chnCstmsAgnNm = chnCstmsAgnNm;
		this.slanCd = slanCd;
		this.ediRcvId = ediRcvId;
		this.agnCtrlOfcCd = agnCtrlOfcCd;
		this.chnCstmsAgnCd = chnCstmsAgnCd;
		this.chnCstmsAgnRmk = chnCstmsAgnRmk;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("pod_cd", getPodCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("edi_snd_id", getEdiSndId());
		this.hashColumns.put("chn_cstms_agn_nm", getChnCstmsAgnNm());
		this.hashColumns.put("slan_cd", getSlanCd());
		this.hashColumns.put("edi_rcv_id", getEdiRcvId());
		this.hashColumns.put("agn_ctrl_ofc_cd", getAgnCtrlOfcCd());
		this.hashColumns.put("chn_cstms_agn_cd", getChnCstmsAgnCd());
		this.hashColumns.put("chn_cstms_agn_rmk", getChnCstmsAgnRmk());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("pod_cd", "podCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("edi_snd_id", "ediSndId");
		this.hashFields.put("chn_cstms_agn_nm", "chnCstmsAgnNm");
		this.hashFields.put("slan_cd", "slanCd");
		this.hashFields.put("edi_rcv_id", "ediRcvId");
		this.hashFields.put("agn_ctrl_ofc_cd", "agnCtrlOfcCd");
		this.hashFields.put("chn_cstms_agn_cd", "chnCstmsAgnCd");
		this.hashFields.put("chn_cstms_agn_rmk", "chnCstmsAgnRmk");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
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
	 * @return ediSndId
	 */
	public String getEdiSndId() {
		return this.ediSndId;
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
	 * @param ediSndId
	 */
	public void setEdiSndId(String ediSndId) {
		this.ediSndId = ediSndId;
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
		setPodCd(JSPUtil.getParameter(request, prefix + "pod_cd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setEdiSndId(JSPUtil.getParameter(request, prefix + "edi_snd_id", ""));
		setChnCstmsAgnNm(JSPUtil.getParameter(request, prefix + "chn_cstms_agn_nm", ""));
		setSlanCd(JSPUtil.getParameter(request, prefix + "slan_cd", ""));
		setEdiRcvId(JSPUtil.getParameter(request, prefix + "edi_rcv_id", ""));
		setAgnCtrlOfcCd(JSPUtil.getParameter(request, prefix + "agn_ctrl_ofc_cd", ""));
		setChnCstmsAgnCd(JSPUtil.getParameter(request, prefix + "chn_cstms_agn_cd", ""));
		setChnCstmsAgnRmk(JSPUtil.getParameter(request, prefix + "chn_cstms_agn_rmk", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return ChinaCustmsAgnVO[]
	 */
	public ChinaCustmsAgnVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return ChinaCustmsAgnVO[]
	 */
	public ChinaCustmsAgnVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		ChinaCustmsAgnVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] podCd = (JSPUtil.getParameter(request, prefix	+ "pod_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] ediSndId = (JSPUtil.getParameter(request, prefix	+ "edi_snd_id", length));
			String[] chnCstmsAgnNm = (JSPUtil.getParameter(request, prefix	+ "chn_cstms_agn_nm", length));
			String[] slanCd = (JSPUtil.getParameter(request, prefix	+ "slan_cd", length));
			String[] ediRcvId = (JSPUtil.getParameter(request, prefix	+ "edi_rcv_id", length));
			String[] agnCtrlOfcCd = (JSPUtil.getParameter(request, prefix	+ "agn_ctrl_ofc_cd", length));
			String[] chnCstmsAgnCd = (JSPUtil.getParameter(request, prefix	+ "chn_cstms_agn_cd", length));
			String[] chnCstmsAgnRmk = (JSPUtil.getParameter(request, prefix	+ "chn_cstms_agn_rmk", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new ChinaCustmsAgnVO();
				if (podCd[i] != null)
					model.setPodCd(podCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (ediSndId[i] != null)
					model.setEdiSndId(ediSndId[i]);
				if (chnCstmsAgnNm[i] != null)
					model.setChnCstmsAgnNm(chnCstmsAgnNm[i]);
				if (slanCd[i] != null)
					model.setSlanCd(slanCd[i]);
				if (ediRcvId[i] != null)
					model.setEdiRcvId(ediRcvId[i]);
				if (agnCtrlOfcCd[i] != null)
					model.setAgnCtrlOfcCd(agnCtrlOfcCd[i]);
				if (chnCstmsAgnCd[i] != null)
					model.setChnCstmsAgnCd(chnCstmsAgnCd[i]);
				if (chnCstmsAgnRmk[i] != null)
					model.setChnCstmsAgnRmk(chnCstmsAgnRmk[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getChinaCustmsAgnVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return ChinaCustmsAgnVO[]
	 */
	public ChinaCustmsAgnVO[] getChinaCustmsAgnVOs(){
		ChinaCustmsAgnVO[] vos = (ChinaCustmsAgnVO[])models.toArray(new ChinaCustmsAgnVO[models.size()]);
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
		this.podCd = this.podCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ediSndId = this.ediSndId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chnCstmsAgnNm = this.chnCstmsAgnNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slanCd = this.slanCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ediRcvId = this.ediRcvId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agnCtrlOfcCd = this.agnCtrlOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chnCstmsAgnCd = this.chnCstmsAgnCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chnCstmsAgnRmk = this.chnCstmsAgnRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
