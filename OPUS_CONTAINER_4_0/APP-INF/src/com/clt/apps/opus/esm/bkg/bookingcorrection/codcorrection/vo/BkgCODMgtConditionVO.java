/*=========================================================
 *Copyright(c) 2010 CyberLogitec
 *@FileName : ChangeOfDestinationMgtConditionVO.java
 *@FileTitle : ChangeOfDestinationMgtConditionVO
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2015.10.13
 *@LastModifier : 문경일
 *@LastVersion : 1.0
 * 2015.10.13 문경일 
 * 1.0 Creation
 * =========================================================
 * History
 * 2015.10.13 LHJ [Ticket ID: ]- COD Approval 화면변경으로 인한 검색조건 추가 및 수정
 =========================================================*/


package com.clt.apps.opus.esm.bkg.bookingcorrection.codcorrection.vo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 장석현
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class BkgCODMgtConditionVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<BkgCODMgtConditionVO> models = new ArrayList<BkgCODMgtConditionVO>();
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String vvd = null;
	/* Column Info */
	private String oldPolCd = null;
	/* Column Info */
	private String oldPodCd = null;
	/* Column Info */
	private String newPodCd = null;
	/* Column Info */
	private String codRqstSeq = null;
	/* Column Info */
	private String rso = null;
	/* Column Info */
	private String slanCd = null;
	/* Column Info */
	private String ntcKndCd = null;
	

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public BkgCODMgtConditionVO() {}

	public BkgCODMgtConditionVO(String bkgNo, String vvd, String oldPolCd, String oldPodCd, String newPodCd, String codRqstSeq, String rso, String slanCd, String cntrTpszCd, String ntcKndCd) {
		this.bkgNo = bkgNo;
		this.vvd = vvd;
		this.oldPolCd = oldPolCd;
		this.oldPodCd = oldPodCd;
		this.newPodCd = newPodCd;
		this.codRqstSeq = codRqstSeq;
		this.rso = rso;
		this.slanCd = slanCd;
		this.ntcKndCd = ntcKndCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("vvd", getVvd());
		this.hashColumns.put("old_pol_cd", getOldPolCd());
		this.hashColumns.put("old_pod_cd", getOldPodCd());
		this.hashColumns.put("new_pod_cd", getNewPodCd());
		this.hashColumns.put("cod_rqst_seq", getCodRqstSeq());
		this.hashColumns.put("rso", getRso());
		this.hashColumns.put("slan_cd", getSlanCd());
		this.hashColumns.put("ntc_knd_cd", getNtcKndCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("vvd", "vvd");
		this.hashFields.put("old_pol_cd", "oldPolCd");
		this.hashFields.put("old_pod_cd", "oldPodCd");
		this.hashFields.put("new_pod_cd", "newPodCd");
		this.hashFields.put("cod_rqst_seq", "codRqstSeq");
		this.hashFields.put("rso", "rso");
		this.hashFields.put("slan_cd", "slanCd");
		this.hashFields.put("ntc_knd_cd", "ntcKndCd");
		return this.hashFields;
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
	 * @return vvd
	 */
	public String getVvd() {
		return this.vvd;
	}
	
	/**
	 * Column Info
	 * @return oldPolCd
	 */
	public String getOldPolCd() {
		return this.oldPolCd;
	}
	
	/**
	 * Column Info
	 * @return oldPodCd
	 */
	public String getOldPodCd() {
		return this.oldPodCd;
	}
	
	/**
	 * Column Info
	 * @return newPodCd
	 */
	public String getNewPodCd() {
		return this.newPodCd;
	}
	
	/**
	 * Column Info
	 * @return codRqstSeq
	 */
	public String getCodRqstSeq() {
		return this.codRqstSeq;
	}
	
	/**
	 * Column Info
	 * @return rso
	 */
	public String getRso() {
		return this.rso;
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
	 * @return ntcKndCd
	 */
	public String getNtcKndCd() {
		return this.ntcKndCd;
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
	 * @param vvd
	 */
	public void setVvd(String vvd) {
		this.vvd = vvd;
	}
	
	/**
	 * Column Info
	 * @param oldPolCd
	 */
	public void setOldPolCd(String oldPolCd) {
		this.oldPolCd = oldPolCd;
	}
	
	/**
	 * Column Info
	 * @param oldPodCd
	 */
	public void setOldPodCd(String oldPodCd) {
		this.oldPodCd = oldPodCd;
	}
	
	/**
	 * Column Info
	 * @param newPodCd
	 */
	public void setNewPodCd(String newPodCd) {
		this.newPodCd = newPodCd;
	}
	
	/**
	 * Column Info
	 * @param codRqstSeq
	 */
	public void setCodRqstSeq(String codRqstSeq) {
		this.codRqstSeq = codRqstSeq;
	}
	
	/**
	 * Column Info
	 * @param rso
	 */
	public void setRso(String rso) {
		this.rso = rso;
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
	 * @param ntcKndCd
	 */
	public void setNtcKndCd(String ntcKndCd) {
		this.ntcKndCd = ntcKndCd;
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
		setBkgNo(JSPUtil.getParameter(request, prefix + "bkg_no", ""));
		setVvd(JSPUtil.getParameter(request, prefix + "vvd", ""));
		setOldPolCd(JSPUtil.getParameter(request, prefix + "old_pol_cd", ""));
		setOldPodCd(JSPUtil.getParameter(request, prefix + "old_pod_cd", ""));
		setNewPodCd(JSPUtil.getParameter(request, prefix + "new_pod_cd", ""));
		setCodRqstSeq(JSPUtil.getParameter(request, prefix + "cod_rqst_seq", ""));
		setRso(JSPUtil.getParameter(request, prefix + "rso", ""));
		setSlanCd(JSPUtil.getParameter(request, prefix + "slan_cd", ""));
		setNtcKndCd(JSPUtil.getParameter(request, prefix + "ntc_knd_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return ChangeOfDestinationMgtConditionVO[]
	 */
	public BkgCODMgtConditionVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return ChangeOfDestinationMgtConditionVO[]
	 */
	public BkgCODMgtConditionVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		BkgCODMgtConditionVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] vvd = (JSPUtil.getParameter(request, prefix	+ "vvd", length));
			String[] oldPolCd = (JSPUtil.getParameter(request, prefix	+ "old_pol_cd", length));
			String[] oldPodCd = (JSPUtil.getParameter(request, prefix	+ "old_pod_cd", length));
			String[] newPodCd = (JSPUtil.getParameter(request, prefix	+ "new_pod_cd", length));
			String[] codRqstSeq	= (JSPUtil.getParameter(request, prefix + "cod_rqst_seq", length));
			String[] rso = (JSPUtil.getParameter(request, prefix + "rso", length));
			String[] slanCd = (JSPUtil.getParameter(request, prefix + "slan_cd", length));
			String[] ntcKndCd = (JSPUtil.getParameter(request, prefix + "ntc_knd_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new BkgCODMgtConditionVO();
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (vvd[i] != null)
					model.setVvd(vvd[i]);
				if (oldPolCd[i] != null)
					model.setOldPolCd(oldPolCd[i]);
				if (oldPodCd[i] != null)
					model.setOldPodCd(oldPodCd[i]);
				if (newPodCd[i] != null)
					model.setNewPodCd(newPodCd[i]);
				if (codRqstSeq[i] != null)
					model.setCodRqstSeq(codRqstSeq[i]);
				if (rso[i] != null)
					model.setRso(rso[i]);
				if (slanCd[i] != null)
					model.setSlanCd(slanCd[i]);
				if (ntcKndCd[i] != null)
					model.setNtcKndCd(ntcKndCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getBkgCODMgtConditionVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return ChangeOfDestinationMgtConditionVO[]
	 */
	public BkgCODMgtConditionVO[] getBkgCODMgtConditionVOs(){
		BkgCODMgtConditionVO[] vos = (BkgCODMgtConditionVO[])models.toArray(new BkgCODMgtConditionVO[models.size()]);
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
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd = this.vvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oldPolCd = this.oldPolCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oldPodCd = this.oldPodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.newPodCd = this.newPodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.codRqstSeq = this.codRqstSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rso = this.rso .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slanCd = this.slanCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ntcKndCd = this.ntcKndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
