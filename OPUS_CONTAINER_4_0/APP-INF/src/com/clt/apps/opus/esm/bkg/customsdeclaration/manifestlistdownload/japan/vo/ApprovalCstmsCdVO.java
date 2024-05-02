/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : ApprovalCstmsCdVO.java
*@FileTitle : ApprovalCstmsCdVO
*Open Issues :
*Change history :
*@LastModifyDate : 2015.02.25
*@LastModifier : 
*@LastVersion : 1.0
* 2015.02.25  
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.japan.vo;

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

public class ApprovalCstmsCdVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<ApprovalCstmsCdVO> models = new ArrayList<ApprovalCstmsCdVO>();
	
	/* Column Info */
	private String aproNo = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String usrId = null;
	/* Column Info */
	private String deltFlg = null;
	/* Column Info */
	private String cstmsCd = null;
	/* Column Info */
	private String podBnd = null;
	/* Column Info */
	private String delBnd = null;
	/* Column Info */
	private String blNo = null;
	/* Column Info */
	private String trspModCd = null;
	/* Column Info */
	private String whNm = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public ApprovalCstmsCdVO() {}

	public ApprovalCstmsCdVO(String ibflag, String pagerows, String blNo, String podBnd, String delBnd, String aproNo, String cstmsCd, String whNm, String trspModCd, String deltFlg, String usrId) {
		this.aproNo = aproNo;
		this.ibflag = ibflag;
		this.usrId = usrId;
		this.deltFlg = deltFlg;
		this.cstmsCd = cstmsCd;
		this.podBnd = podBnd;
		this.delBnd = delBnd;
		this.blNo = blNo;
		this.trspModCd = trspModCd;
		this.whNm = whNm;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("apro_no", getAproNo());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("usr_id", getUsrId());
		this.hashColumns.put("delt_flg", getDeltFlg());
		this.hashColumns.put("cstms_cd", getCstmsCd());
		this.hashColumns.put("pod_bnd", getPodBnd());
		this.hashColumns.put("del_bnd", getDelBnd());
		this.hashColumns.put("bl_no", getBlNo());
		this.hashColumns.put("trsp_mod_cd", getTrspModCd());
		this.hashColumns.put("wh_nm", getWhNm());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("apro_no", "aproNo");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("usr_id", "usrId");
		this.hashFields.put("delt_flg", "deltFlg");
		this.hashFields.put("cstms_cd", "cstmsCd");
		this.hashFields.put("pod_bnd", "podBnd");
		this.hashFields.put("del_bnd", "delBnd");
		this.hashFields.put("bl_no", "blNo");
		this.hashFields.put("trsp_mod_cd", "trspModCd");
		this.hashFields.put("wh_nm", "whNm");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return aproNo
	 */
	public String getAproNo() {
		return this.aproNo;
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
	 * @return usrId
	 */
	public String getUsrId() {
		return this.usrId;
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
	 * @return cstmsCd
	 */
	public String getCstmsCd() {
		return this.cstmsCd;
	}
	
	/**
	 * Column Info
	 * @return podBnd
	 */
	public String getPodBnd() {
		return this.podBnd;
	}
	
	/**
	 * Column Info
	 * @return delBnd
	 */
	public String getDelBnd() {
		return this.delBnd;
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
	 * @return trspModCd
	 */
	public String getTrspModCd() {
		return this.trspModCd;
	}
	
	/**
	 * Column Info
	 * @return whNm
	 */
	public String getWhNm() {
		return this.whNm;
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
	 * @param aproNo
	 */
	public void setAproNo(String aproNo) {
		this.aproNo = aproNo;
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
	 * @param usrId
	 */
	public void setUsrId(String usrId) {
		this.usrId = usrId;
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
	 * @param cstmsCd
	 */
	public void setCstmsCd(String cstmsCd) {
		this.cstmsCd = cstmsCd;
	}
	
	/**
	 * Column Info
	 * @param podBnd
	 */
	public void setPodBnd(String podBnd) {
		this.podBnd = podBnd;
	}
	
	/**
	 * Column Info
	 * @param delBnd
	 */
	public void setDelBnd(String delBnd) {
		this.delBnd = delBnd;
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
	 * @param trspModCd
	 */
	public void setTrspModCd(String trspModCd) {
		this.trspModCd = trspModCd;
	}
	
	/**
	 * Column Info
	 * @param whNm
	 */
	public void setWhNm(String whNm) {
		this.whNm = whNm;
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
		setAproNo(JSPUtil.getParameter(request, prefix + "apro_no", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setUsrId(JSPUtil.getParameter(request, prefix + "usr_id", ""));
		setDeltFlg(JSPUtil.getParameter(request, prefix + "delt_flg", ""));
		setCstmsCd(JSPUtil.getParameter(request, prefix + "cstms_cd", ""));
		setPodBnd(JSPUtil.getParameter(request, prefix + "pod_bnd", ""));
		setDelBnd(JSPUtil.getParameter(request, prefix + "del_bnd", ""));
		setBlNo(JSPUtil.getParameter(request, prefix + "bl_no", ""));
		setTrspModCd(JSPUtil.getParameter(request, prefix + "trsp_mod_cd", ""));
		setWhNm(JSPUtil.getParameter(request, prefix + "wh_nm", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return ApprovalCstmsCdVO[]
	 */
	public ApprovalCstmsCdVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return ApprovalCstmsCdVO[]
	 */
	public ApprovalCstmsCdVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		ApprovalCstmsCdVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] aproNo = (JSPUtil.getParameter(request, prefix	+ "apro_no", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] usrId = (JSPUtil.getParameter(request, prefix	+ "usr_id", length));
			String[] deltFlg = (JSPUtil.getParameter(request, prefix	+ "delt_flg", length));
			String[] cstmsCd = (JSPUtil.getParameter(request, prefix	+ "cstms_cd", length));
			String[] podBnd = (JSPUtil.getParameter(request, prefix	+ "pod_bnd", length));
			String[] delBnd = (JSPUtil.getParameter(request, prefix	+ "del_bnd", length));
			String[] blNo = (JSPUtil.getParameter(request, prefix	+ "bl_no", length));
			String[] trspModCd = (JSPUtil.getParameter(request, prefix	+ "trsp_mod_cd", length));
			String[] whNm = (JSPUtil.getParameter(request, prefix	+ "wh_nm", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new ApprovalCstmsCdVO();
				if (aproNo[i] != null)
					model.setAproNo(aproNo[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (usrId[i] != null)
					model.setUsrId(usrId[i]);
				if (deltFlg[i] != null)
					model.setDeltFlg(deltFlg[i]);
				if (cstmsCd[i] != null)
					model.setCstmsCd(cstmsCd[i]);
				if (podBnd[i] != null)
					model.setPodBnd(podBnd[i]);
				if (delBnd[i] != null)
					model.setDelBnd(delBnd[i]);
				if (blNo[i] != null)
					model.setBlNo(blNo[i]);
				if (trspModCd[i] != null)
					model.setTrspModCd(trspModCd[i]);
				if (whNm[i] != null)
					model.setWhNm(whNm[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getApprovalCstmsCdVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return ApprovalCstmsCdVO[]
	 */
	public ApprovalCstmsCdVO[] getApprovalCstmsCdVOs(){
		ApprovalCstmsCdVO[] vos = (ApprovalCstmsCdVO[])models.toArray(new ApprovalCstmsCdVO[models.size()]);
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
		this.aproNo = this.aproNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usrId = this.usrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.deltFlg = this.deltFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cstmsCd = this.cstmsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podBnd = this.podBnd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delBnd = this.delBnd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo = this.blNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trspModCd = this.trspModCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.whNm = this.whNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
