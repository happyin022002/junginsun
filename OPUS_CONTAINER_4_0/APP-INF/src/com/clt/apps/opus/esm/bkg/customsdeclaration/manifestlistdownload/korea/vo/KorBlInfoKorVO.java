/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : KorBlInfoKorVO.java
*@FileTitle : KorBlInfoKorVO
*Open Issues :
*Change history :
*@LastModifyDate : 2016.03.15
*@LastModifier : 
*@LastVersion : 1.0
* 2016.03.15  
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.korea.vo;

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
 * @author 
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class KorBlInfoKorVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<KorBlInfoKorVO> models = new ArrayList<KorBlInfoKorVO>();
	
	/* Column Info */
	private String smtAmdNo = null;
	/* Column Info */
	private String trnsSeq = null;
	/* Column Info */
	private String bdAreaCd = null;
	/* Column Info */
	private String ioBndCd = null;
	/* Column Info */
	private String polTml = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String vvd = null;
	/* Column Info */
	private String podCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String dmstPortCd = null;
	/* Column Info */
	private String inType = null;
	/* Column Info */
	private String polCd = null;
	/* Column Info */
	private String cstmsBlNo = null;
	/* Column Info */
	private String cstmsDeclTpCd = null;
	/* Column Info */
	private String userId = null;
	/* Column Info */
	private String portCd = null;
	/* Column Info */
	private String cTrnsSeq = null;
	/* Column Info */
	private String podTml = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public KorBlInfoKorVO() {}

	public KorBlInfoKorVO(String ibflag, String pagerows, String bdAreaCd, String bkgNo, String cstmsBlNo, String cstmsDeclTpCd, String cTrnsSeq, String dmstPortCd, String inType, String ioBndCd, String podCd, String podTml, String polCd, String polTml, String portCd, String smtAmdNo, String trnsSeq, String userId, String vvd) {
		this.smtAmdNo = smtAmdNo;
		this.trnsSeq = trnsSeq;
		this.bdAreaCd = bdAreaCd;
		this.ioBndCd = ioBndCd;
		this.polTml = polTml;
		this.pagerows = pagerows;
		this.vvd = vvd;
		this.podCd = podCd;
		this.ibflag = ibflag;
		this.bkgNo = bkgNo;
		this.dmstPortCd = dmstPortCd;
		this.inType = inType;
		this.polCd = polCd;
		this.cstmsBlNo = cstmsBlNo;
		this.cstmsDeclTpCd = cstmsDeclTpCd;
		this.userId = userId;
		this.portCd = portCd;
		this.cTrnsSeq = cTrnsSeq;
		this.podTml = podTml;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("smt_amd_no", getSmtAmdNo());
		this.hashColumns.put("trns_seq", getTrnsSeq());
		this.hashColumns.put("bd_area_cd", getBdAreaCd());
		this.hashColumns.put("io_bnd_cd", getIoBndCd());
		this.hashColumns.put("pol_tml", getPolTml());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("vvd", getVvd());
		this.hashColumns.put("pod_cd", getPodCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("dmst_port_cd", getDmstPortCd());
		this.hashColumns.put("in_type", getInType());
		this.hashColumns.put("pol_cd", getPolCd());
		this.hashColumns.put("cstms_bl_no", getCstmsBlNo());
		this.hashColumns.put("cstms_decl_tp_cd", getCstmsDeclTpCd());
		this.hashColumns.put("user_id", getUserId());
		this.hashColumns.put("port_cd", getPortCd());
		this.hashColumns.put("c_trns_seq", getCTrnsSeq());
		this.hashColumns.put("pod_tml", getPodTml());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("smt_amd_no", "smtAmdNo");
		this.hashFields.put("trns_seq", "trnsSeq");
		this.hashFields.put("bd_area_cd", "bdAreaCd");
		this.hashFields.put("io_bnd_cd", "ioBndCd");
		this.hashFields.put("pol_tml", "polTml");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("vvd", "vvd");
		this.hashFields.put("pod_cd", "podCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("dmst_port_cd", "dmstPortCd");
		this.hashFields.put("in_type", "inType");
		this.hashFields.put("pol_cd", "polCd");
		this.hashFields.put("cstms_bl_no", "cstmsBlNo");
		this.hashFields.put("cstms_decl_tp_cd", "cstmsDeclTpCd");
		this.hashFields.put("user_id", "userId");
		this.hashFields.put("port_cd", "portCd");
		this.hashFields.put("c_trns_seq", "cTrnsSeq");
		this.hashFields.put("pod_tml", "podTml");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return smtAmdNo
	 */
	public String getSmtAmdNo() {
		return this.smtAmdNo;
	}
	
	/**
	 * Column Info
	 * @return trnsSeq
	 */
	public String getTrnsSeq() {
		return this.trnsSeq;
	}
	
	/**
	 * Column Info
	 * @return bdAreaCd
	 */
	public String getBdAreaCd() {
		return this.bdAreaCd;
	}
	
	/**
	 * Column Info
	 * @return ioBndCd
	 */
	public String getIoBndCd() {
		return this.ioBndCd;
	}
	
	/**
	 * Column Info
	 * @return polTml
	 */
	public String getPolTml() {
		return this.polTml;
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
	 * @return vvd
	 */
	public String getVvd() {
		return this.vvd;
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
	 * @return bkgNo
	 */
	public String getBkgNo() {
		return this.bkgNo;
	}
	
	/**
	 * Column Info
	 * @return dmstPortCd
	 */
	public String getDmstPortCd() {
		return this.dmstPortCd;
	}
	
	/**
	 * Column Info
	 * @return inType
	 */
	public String getInType() {
		return this.inType;
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
	 * @return cstmsBlNo
	 */
	public String getCstmsBlNo() {
		return this.cstmsBlNo;
	}
	
	/**
	 * Column Info
	 * @return cstmsDeclTpCd
	 */
	public String getCstmsDeclTpCd() {
		return this.cstmsDeclTpCd;
	}
	
	/**
	 * Column Info
	 * @return userId
	 */
	public String getUserId() {
		return this.userId;
	}
	
	/**
	 * Column Info
	 * @return portCd
	 */
	public String getPortCd() {
		return this.portCd;
	}
	
	/**
	 * Column Info
	 * @return cTrnsSeq
	 */
	public String getCTrnsSeq() {
		return this.cTrnsSeq;
	}
	
	/**
	 * Column Info
	 * @return podTml
	 */
	public String getPodTml() {
		return this.podTml;
	}
	

	/**
	 * Column Info
	 * @param smtAmdNo
	 */
	public void setSmtAmdNo(String smtAmdNo) {
		this.smtAmdNo = smtAmdNo;
	}
	
	/**
	 * Column Info
	 * @param trnsSeq
	 */
	public void setTrnsSeq(String trnsSeq) {
		this.trnsSeq = trnsSeq;
	}
	
	/**
	 * Column Info
	 * @param bdAreaCd
	 */
	public void setBdAreaCd(String bdAreaCd) {
		this.bdAreaCd = bdAreaCd;
	}
	
	/**
	 * Column Info
	 * @param ioBndCd
	 */
	public void setIoBndCd(String ioBndCd) {
		this.ioBndCd = ioBndCd;
	}
	
	/**
	 * Column Info
	 * @param polTml
	 */
	public void setPolTml(String polTml) {
		this.polTml = polTml;
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
	 * @param vvd
	 */
	public void setVvd(String vvd) {
		this.vvd = vvd;
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
	 * @param bkgNo
	 */
	public void setBkgNo(String bkgNo) {
		this.bkgNo = bkgNo;
	}
	
	/**
	 * Column Info
	 * @param dmstPortCd
	 */
	public void setDmstPortCd(String dmstPortCd) {
		this.dmstPortCd = dmstPortCd;
	}
	
	/**
	 * Column Info
	 * @param inType
	 */
	public void setInType(String inType) {
		this.inType = inType;
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
	 * @param cstmsBlNo
	 */
	public void setCstmsBlNo(String cstmsBlNo) {
		this.cstmsBlNo = cstmsBlNo;
	}
	
	/**
	 * Column Info
	 * @param cstmsDeclTpCd
	 */
	public void setCstmsDeclTpCd(String cstmsDeclTpCd) {
		this.cstmsDeclTpCd = cstmsDeclTpCd;
	}
	
	/**
	 * Column Info
	 * @param userId
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	/**
	 * Column Info
	 * @param portCd
	 */
	public void setPortCd(String portCd) {
		this.portCd = portCd;
	}
	
	/**
	 * Column Info
	 * @param cTrnsSeq
	 */
	public void setCTrnsSeq(String cTrnsSeq) {
		this.cTrnsSeq = cTrnsSeq;
	}
	
	/**
	 * Column Info
	 * @param podTml
	 */
	public void setPodTml(String podTml) {
		this.podTml = podTml;
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
		setSmtAmdNo(JSPUtil.getParameter(request, prefix + "smt_amd_no", ""));
		setTrnsSeq(JSPUtil.getParameter(request, prefix + "trns_seq", ""));
		setBdAreaCd(JSPUtil.getParameter(request, prefix + "bd_area_cd", ""));
		setIoBndCd(JSPUtil.getParameter(request, prefix + "io_bnd_cd", ""));
		setPolTml(JSPUtil.getParameter(request, prefix + "pol_tml", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setVvd(JSPUtil.getParameter(request, prefix + "vvd", ""));
		setPodCd(JSPUtil.getParameter(request, prefix + "pod_cd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setBkgNo(JSPUtil.getParameter(request, prefix + "bkg_no", ""));
		setDmstPortCd(JSPUtil.getParameter(request, prefix + "dmst_port_cd", ""));
		setInType(JSPUtil.getParameter(request, prefix + "in_type", ""));
		setPolCd(JSPUtil.getParameter(request, prefix + "pol_cd", ""));
		setCstmsBlNo(JSPUtil.getParameter(request, prefix + "cstms_bl_no", ""));
		setCstmsDeclTpCd(JSPUtil.getParameter(request, prefix + "cstms_decl_tp_cd", ""));
		setUserId(JSPUtil.getParameter(request, prefix + "user_id", ""));
		setPortCd(JSPUtil.getParameter(request, prefix + "port_cd", ""));
		setCTrnsSeq(JSPUtil.getParameter(request, prefix + "c_trns_seq", ""));
		setPodTml(JSPUtil.getParameter(request, prefix + "pod_tml", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return KorBlInfoKorVO[]
	 */
	public KorBlInfoKorVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return KorBlInfoKorVO[]
	 */
	public KorBlInfoKorVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		KorBlInfoKorVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] smtAmdNo = (JSPUtil.getParameter(request, prefix	+ "smt_amd_no", length));
			String[] trnsSeq = (JSPUtil.getParameter(request, prefix	+ "trns_seq", length));
			String[] bdAreaCd = (JSPUtil.getParameter(request, prefix	+ "bd_area_cd", length));
			String[] ioBndCd = (JSPUtil.getParameter(request, prefix	+ "io_bnd_cd", length));
			String[] polTml = (JSPUtil.getParameter(request, prefix	+ "pol_tml", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] vvd = (JSPUtil.getParameter(request, prefix	+ "vvd", length));
			String[] podCd = (JSPUtil.getParameter(request, prefix	+ "pod_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] dmstPortCd = (JSPUtil.getParameter(request, prefix	+ "dmst_port_cd", length));
			String[] inType = (JSPUtil.getParameter(request, prefix	+ "in_type", length));
			String[] polCd = (JSPUtil.getParameter(request, prefix	+ "pol_cd", length));
			String[] cstmsBlNo = (JSPUtil.getParameter(request, prefix	+ "cstms_bl_no", length));
			String[] cstmsDeclTpCd = (JSPUtil.getParameter(request, prefix	+ "cstms_decl_tp_cd", length));
			String[] userId = (JSPUtil.getParameter(request, prefix	+ "user_id", length));
			String[] portCd = (JSPUtil.getParameter(request, prefix	+ "port_cd", length));
			String[] cTrnsSeq = (JSPUtil.getParameter(request, prefix	+ "c_trns_seq", length));
			String[] podTml = (JSPUtil.getParameter(request, prefix	+ "pod_tml", length));
			
			for (int i = 0; i < length; i++) {
				model = new KorBlInfoKorVO();
				if (smtAmdNo[i] != null)
					model.setSmtAmdNo(smtAmdNo[i]);
				if (trnsSeq[i] != null)
					model.setTrnsSeq(trnsSeq[i]);
				if (bdAreaCd[i] != null)
					model.setBdAreaCd(bdAreaCd[i]);
				if (ioBndCd[i] != null)
					model.setIoBndCd(ioBndCd[i]);
				if (polTml[i] != null)
					model.setPolTml(polTml[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (vvd[i] != null)
					model.setVvd(vvd[i]);
				if (podCd[i] != null)
					model.setPodCd(podCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (dmstPortCd[i] != null)
					model.setDmstPortCd(dmstPortCd[i]);
				if (inType[i] != null)
					model.setInType(inType[i]);
				if (polCd[i] != null)
					model.setPolCd(polCd[i]);
				if (cstmsBlNo[i] != null)
					model.setCstmsBlNo(cstmsBlNo[i]);
				if (cstmsDeclTpCd[i] != null)
					model.setCstmsDeclTpCd(cstmsDeclTpCd[i]);
				if (userId[i] != null)
					model.setUserId(userId[i]);
				if (portCd[i] != null)
					model.setPortCd(portCd[i]);
				if (cTrnsSeq[i] != null)
					model.setCTrnsSeq(cTrnsSeq[i]);
				if (podTml[i] != null)
					model.setPodTml(podTml[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getKorBlInfoKorVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return KorBlInfoKorVO[]
	 */
	public KorBlInfoKorVO[] getKorBlInfoKorVOs(){
		KorBlInfoKorVO[] vos = (KorBlInfoKorVO[])models.toArray(new KorBlInfoKorVO[models.size()]);
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
		this.smtAmdNo = this.smtAmdNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trnsSeq = this.trnsSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bdAreaCd = this.bdAreaCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ioBndCd = this.ioBndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polTml = this.polTml .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd = this.vvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCd = this.podCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dmstPortCd = this.dmstPortCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inType = this.inType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCd = this.polCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cstmsBlNo = this.cstmsBlNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cstmsDeclTpCd = this.cstmsDeclTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.userId = this.userId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.portCd = this.portCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cTrnsSeq = this.cTrnsSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podTml = this.podTml .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
