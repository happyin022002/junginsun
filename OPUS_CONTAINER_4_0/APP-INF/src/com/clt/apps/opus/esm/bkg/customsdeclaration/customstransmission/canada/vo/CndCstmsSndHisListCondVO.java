/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CndCstmsSndHisListCondVO.java
*@FileTitle : CndCstmsSndHisListCondVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.24
*@LastModifier : 김민정
*@LastVersion : 1.0
* 2009.11.24 김민정 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.canada.vo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.vo.CstmsSndHisListCondVO;
import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 김민정
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class CndCstmsSndHisListCondVO extends CstmsSndHisListCondVO {

	private static final long serialVersionUID = 1L;
	
	private Collection<CndCstmsSndHisListCondVO> models = new ArrayList<CndCstmsSndHisListCondVO>();
	
	/* Column Info */
	private String office = null;
	/* Column Info */
	private String sndDtFlg = null;
	/* Column Info */
	private String eSndTm = null;
	/* Column Info */
	private String blNo = null;
	/* Column Info */
	private String sSndDt = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String podCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String polCd = null;
	/* Column Info */
	private String trsmMsgTpId = null;
	/* Column Info */
	private String vvdCd = null;
	/* Column Info */
	private String usrId = null;
	/* Column Info */
	private String sSndTm = null;
	/* Column Info */
	private String eSndDt = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public CndCstmsSndHisListCondVO() {}

	public CndCstmsSndHisListCondVO(String ibflag, String pagerows, String office, String usrId, String podCd, String polCd, String vvdCd, String trsmMsgTpId, String sndDtFlg, String sSndDt, String eSndDt, String blNo, String sSndTm, String eSndTm) {
		this.office = office;
		this.sndDtFlg = sndDtFlg;
		this.eSndTm = eSndTm;
		this.blNo = blNo;
		this.sSndDt = sSndDt;
		this.pagerows = pagerows;
		this.podCd = podCd;
		this.ibflag = ibflag;
		this.polCd = polCd;
		this.trsmMsgTpId = trsmMsgTpId;
		this.vvdCd = vvdCd;
		this.usrId = usrId;
		this.sSndTm = sSndTm;
		this.eSndDt = eSndDt;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("office", getOffice());
		this.hashColumns.put("snd_dt_flg", getSndDtFlg());
		this.hashColumns.put("e_snd_tm", getESndTm());
		this.hashColumns.put("bl_no", getBlNo());
		this.hashColumns.put("s_snd_dt", getSSndDt());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("pod_cd", getPodCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("pol_cd", getPolCd());
		this.hashColumns.put("trsm_msg_tp_id", getTrsmMsgTpId());
		this.hashColumns.put("vvd_cd", getVvdCd());
		this.hashColumns.put("usr_id", getUsrId());
		this.hashColumns.put("s_snd_tm", getSSndTm());
		this.hashColumns.put("e_snd_dt", getESndDt());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("office", "office");
		this.hashFields.put("snd_dt_flg", "sndDtFlg");
		this.hashFields.put("e_snd_tm", "eSndTm");
		this.hashFields.put("bl_no", "blNo");
		this.hashFields.put("s_snd_dt", "sSndDt");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("pod_cd", "podCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("pol_cd", "polCd");
		this.hashFields.put("trsm_msg_tp_id", "trsmMsgTpId");
		this.hashFields.put("vvd_cd", "vvdCd");
		this.hashFields.put("usr_id", "usrId");
		this.hashFields.put("s_snd_tm", "sSndTm");
		this.hashFields.put("e_snd_dt", "eSndDt");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return office
	 */
	public String getOffice() {
		return this.office;
	}
	
	/**
	 * Column Info
	 * @return sndDtFlg
	 */
	public String getSndDtFlg() {
		return this.sndDtFlg;
	}
	
	/**
	 * Column Info
	 * @return eSndTm
	 */
	public String getESndTm() {
		return this.eSndTm;
	}
	
	/**
	 * Column Info
	 * @return blNo
	 */
	public String getBlNo() {
		return this.blNo;
	}
	
	/**
	 * Column Info
	 * @return sSndDt
	 */
	public String getSSndDt() {
		return this.sSndDt;
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
	 * @return polCd
	 */
	public String getPolCd() {
		return this.polCd;
	}
	
	/**
	 * Column Info
	 * @return trsmMsgTpId
	 */
	public String getTrsmMsgTpId() {
		return this.trsmMsgTpId;
	}
	
	/**
	 * Column Info
	 * @return vvdCd
	 */
	public String getVvdCd() {
		return this.vvdCd;
	}
	
	/**
	 * Column Info
	 * @return usrId
	 */
	public String getUsrId() {
		return this.usrId;
	}
	
	/**
	 * Column Info
	 * @return sSndTm
	 */
	public String getSSndTm() {
		return this.sSndTm;
	}
	
	/**
	 * Column Info
	 * @return eSndDt
	 */
	public String getESndDt() {
		return this.eSndDt;
	}
	

	/**
	 * Column Info
	 * @param office
	 */
	public void setOffice(String office) {
		this.office = office;
	}
	
	/**
	 * Column Info
	 * @param sndDtFlg
	 */
	public void setSndDtFlg(String sndDtFlg) {
		this.sndDtFlg = sndDtFlg;
	}
	
	/**
	 * Column Info
	 * @param eSndTm
	 */
	public void setESndTm(String eSndTm) {
		this.eSndTm = eSndTm;
	}
	
	/**
	 * Column Info
	 * @param blNo
	 */
	public void setBlNo(String blNo) {
		this.blNo = blNo;
	}
	
	/**
	 * Column Info
	 * @param sSndDt
	 */
	public void setSSndDt(String sSndDt) {
		this.sSndDt = sSndDt;
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
	 * @param polCd
	 */
	public void setPolCd(String polCd) {
		this.polCd = polCd;
	}
	
	/**
	 * Column Info
	 * @param trsmMsgTpId
	 */
	public void setTrsmMsgTpId(String trsmMsgTpId) {
		this.trsmMsgTpId = trsmMsgTpId;
	}
	
	/**
	 * Column Info
	 * @param vvdCd
	 */
	public void setVvdCd(String vvdCd) {
		this.vvdCd = vvdCd;
	}
	
	/**
	 * Column Info
	 * @param usrId
	 */
	public void setUsrId(String usrId) {
		this.usrId = usrId;
	}
	
	/**
	 * Column Info
	 * @param sSndTm
	 */
	public void setSSndTm(String sSndTm) {
		this.sSndTm = sSndTm;
	}
	
	/**
	 * Column Info
	 * @param eSndDt
	 */
	public void setESndDt(String eSndDt) {
		this.eSndDt = eSndDt;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setOffice(JSPUtil.getParameter(request, "office", ""));
		setSndDtFlg(JSPUtil.getParameter(request, "snd_dt_flg", ""));
		setESndTm(JSPUtil.getParameter(request, "e_snd_tm", ""));
		setBlNo(JSPUtil.getParameter(request, "bl_no", ""));
		setSSndDt(JSPUtil.getParameter(request, "s_snd_dt", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setPodCd(JSPUtil.getParameter(request, "pod_cd", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setPolCd(JSPUtil.getParameter(request, "pol_cd", ""));
		setTrsmMsgTpId(JSPUtil.getParameter(request, "trsm_msg_tp_id", ""));
		setVvdCd(JSPUtil.getParameter(request, "vvd_cd", ""));
		setUsrId(JSPUtil.getParameter(request, "usr_id", ""));
		setSSndTm(JSPUtil.getParameter(request, "s_snd_tm", ""));
		setESndDt(JSPUtil.getParameter(request, "e_snd_dt", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return CndCstmsSndHisListCondVO[]
	 */
	public CndCstmsSndHisListCondVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return CndCstmsSndHisListCondVO[]
	 */
	public CndCstmsSndHisListCondVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		CndCstmsSndHisListCondVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] office = (JSPUtil.getParameter(request, prefix	+ "office", length));
			String[] sndDtFlg = (JSPUtil.getParameter(request, prefix	+ "snd_dt_flg", length));
			String[] eSndTm = (JSPUtil.getParameter(request, prefix	+ "e_snd_tm", length));
			String[] blNo = (JSPUtil.getParameter(request, prefix	+ "bl_no", length));
			String[] sSndDt = (JSPUtil.getParameter(request, prefix	+ "s_snd_dt", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] podCd = (JSPUtil.getParameter(request, prefix	+ "pod_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] polCd = (JSPUtil.getParameter(request, prefix	+ "pol_cd", length));
			String[] trsmMsgTpId = (JSPUtil.getParameter(request, prefix	+ "trsm_msg_tp_id", length));
			String[] vvdCd = (JSPUtil.getParameter(request, prefix	+ "vvd_cd", length));
			String[] usrId = (JSPUtil.getParameter(request, prefix	+ "usr_id", length));
			String[] sSndTm = (JSPUtil.getParameter(request, prefix	+ "s_snd_tm", length));
			String[] eSndDt = (JSPUtil.getParameter(request, prefix	+ "e_snd_dt", length));
			
			for (int i = 0; i < length; i++) {
				model = new CndCstmsSndHisListCondVO();
				if (office[i] != null)
					model.setOffice(office[i]);
				if (sndDtFlg[i] != null)
					model.setSndDtFlg(sndDtFlg[i]);
				if (eSndTm[i] != null)
					model.setESndTm(eSndTm[i]);
				if (blNo[i] != null)
					model.setBlNo(blNo[i]);
				if (sSndDt[i] != null)
					model.setSSndDt(sSndDt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (podCd[i] != null)
					model.setPodCd(podCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (polCd[i] != null)
					model.setPolCd(polCd[i]);
				if (trsmMsgTpId[i] != null)
					model.setTrsmMsgTpId(trsmMsgTpId[i]);
				if (vvdCd[i] != null)
					model.setVvdCd(vvdCd[i]);
				if (usrId[i] != null)
					model.setUsrId(usrId[i]);
				if (sSndTm[i] != null)
					model.setSSndTm(sSndTm[i]);
				if (eSndDt[i] != null)
					model.setESndDt(eSndDt[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getCndCstmsSndHisListCondVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return CndCstmsSndHisListCondVO[]
	 */
	public CndCstmsSndHisListCondVO[] getCndCstmsSndHisListCondVOs(){
		CndCstmsSndHisListCondVO[] vos = (CndCstmsSndHisListCondVO[])models.toArray(new CndCstmsSndHisListCondVO[models.size()]);
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
		this.office = this.office .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sndDtFlg = this.sndDtFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eSndTm = this.eSndTm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo = this.blNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sSndDt = this.sSndDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCd = this.podCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCd = this.polCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trsmMsgTpId = this.trsmMsgTpId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvdCd = this.vvdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usrId = this.usrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sSndTm = this.sSndTm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eSndDt = this.eSndDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
