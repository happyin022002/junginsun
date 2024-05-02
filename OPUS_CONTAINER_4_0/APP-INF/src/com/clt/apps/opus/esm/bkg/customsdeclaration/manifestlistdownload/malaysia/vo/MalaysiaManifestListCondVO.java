/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : MalaysiaManifestListCondVO.java
*@FileTitle : MalaysiaManifestListCondVO
*Open Issues :
*Change history :
*@LastModifyDate : 2012.02.08
*@LastModifier : 
*@LastVersion : 1.0
* 2012.02.08  
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.malaysia.vo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.vo.ManifestListCondVO;
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

public class MalaysiaManifestListCondVO extends ManifestListCondVO {

	private static final long serialVersionUID = 1L;
	
	private Collection<MalaysiaManifestListCondVO> models = new ArrayList<MalaysiaManifestListCondVO>();
	
	/* Column Info */
	private String sMode = null;
	/* Column Info */
	private String sPodCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String sTrunkPodCd = null;
	/* Column Info */
	private String sTrunkPorCd = null;
	/* Column Info */
	private String sTrunkPolCd = null;
	/* Column Info */
	private String sPolCd = null;
	/* Column Info */
	private String sStatus = null;
	/* Column Info */
	private String sTrunkDelCd = null;
	/* Column Info */
	private String sVvd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String tsTpCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public MalaysiaManifestListCondVO() {}

	public MalaysiaManifestListCondVO(String ibflag, String pagerows, String tsTpCd, String sMode, String sVvd, String sPolCd, String sPodCd, String sTrunkPorCd, String sTrunkPolCd, String sTrunkPodCd, String sTrunkDelCd, String sStatus) {
		this.sMode = sMode;
		this.sPodCd = sPodCd;
		this.ibflag = ibflag;
		this.sTrunkPodCd = sTrunkPodCd;
		this.sTrunkPorCd = sTrunkPorCd;
		this.sTrunkPolCd = sTrunkPolCd;
		this.sPolCd = sPolCd;
		this.sStatus = sStatus;
		this.sTrunkDelCd = sTrunkDelCd;
		this.sVvd = sVvd;
		this.pagerows = pagerows;
		this.tsTpCd = tsTpCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("s_mode", getSMode());
		this.hashColumns.put("s_pod_cd", getSPodCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("s_trunk_pod_cd", getSTrunkPodCd());
		this.hashColumns.put("s_trunk_por_cd", getSTrunkPorCd());
		this.hashColumns.put("s_trunk_pol_cd", getSTrunkPolCd());
		this.hashColumns.put("s_pol_cd", getSPolCd());
		this.hashColumns.put("s_status", getSStatus());
		this.hashColumns.put("s_trunk_del_cd", getSTrunkDelCd());
		this.hashColumns.put("s_vvd", getSVvd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ts_tp_cd", getTsTpCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("s_mode", "sMode");
		this.hashFields.put("s_pod_cd", "sPodCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("s_trunk_pod_cd", "sTrunkPodCd");
		this.hashFields.put("s_trunk_por_cd", "sTrunkPorCd");
		this.hashFields.put("s_trunk_pol_cd", "sTrunkPolCd");
		this.hashFields.put("s_pol_cd", "sPolCd");
		this.hashFields.put("s_status", "sStatus");
		this.hashFields.put("s_trunk_del_cd", "sTrunkDelCd");
		this.hashFields.put("s_vvd", "sVvd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ts_tp_cd", "tsTpCd");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return sMode
	 */
	public String getSMode() {
		return this.sMode;
	}
	
	/**
	 * Column Info
	 * @return sPodCd
	 */
	public String getSPodCd() {
		return this.sPodCd;
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
	 * @return sTrunkPodCd
	 */
	public String getSTrunkPodCd() {
		return this.sTrunkPodCd;
	}
	
	/**
	 * Column Info
	 * @return sTrunkPorCd
	 */
	public String getSTrunkPorCd() {
		return this.sTrunkPorCd;
	}
	
	/**
	 * Column Info
	 * @return sTrunkPolCd
	 */
	public String getSTrunkPolCd() {
		return this.sTrunkPolCd;
	}
	
	/**
	 * Column Info
	 * @return sPolCd
	 */
	public String getSPolCd() {
		return this.sPolCd;
	}
	
	/**
	 * Column Info
	 * @return sStatus
	 */
	public String getSStatus() {
		return this.sStatus;
	}
	
	/**
	 * Column Info
	 * @return sTrunkDelCd
	 */
	public String getSTrunkDelCd() {
		return this.sTrunkDelCd;
	}
	
	/**
	 * Column Info
	 * @return sVvd
	 */
	public String getSVvd() {
		return this.sVvd;
	}
	
	/**
	 * Page Number
	 * @return pagerows
	 */
	public String getPagerows() {
		return this.pagerows;
	}
	
	/**
	 * Page Number
	 * @return tsTpCd
	 */
	public String getTsTpCd() {
		return this.tsTpCd;
	}

	/**
	 * Column Info
	 * @param sMode
	 */
	public void setSMode(String sMode) {
		this.sMode = sMode;
	}
	
	/**
	 * Column Info
	 * @param sPodCd
	 */
	public void setSPodCd(String sPodCd) {
		this.sPodCd = sPodCd;
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
	 * @param sTrunkPodCd
	 */
	public void setSTrunkPodCd(String sTrunkPodCd) {
		this.sTrunkPodCd = sTrunkPodCd;
	}
	
	/**
	 * Column Info
	 * @param sTrunkPorCd
	 */
	public void setSTrunkPorCd(String sTrunkPorCd) {
		this.sTrunkPorCd = sTrunkPorCd;
	}
	
	/**
	 * Column Info
	 * @param sTrunkPolCd
	 */
	public void setSTrunkPolCd(String sTrunkPolCd) {
		this.sTrunkPolCd = sTrunkPolCd;
	}
	
	/**
	 * Column Info
	 * @param sPolCd
	 */
	public void setSPolCd(String sPolCd) {
		this.sPolCd = sPolCd;
	}
	
	/**
	 * Column Info
	 * @param sStatus
	 */
	public void setSStatus(String sStatus) {
		this.sStatus = sStatus;
	}
	
	/**
	 * Column Info
	 * @param sTrunkDelCd
	 */
	public void setSTrunkDelCd(String sTrunkDelCd) {
		this.sTrunkDelCd = sTrunkDelCd;
	}
	
	/**
	 * Column Info
	 * @param sVvd
	 */
	public void setSVvd(String sVvd) {
		this.sVvd = sVvd;
	}
	
	/**
	 * Page Number
	 * @param pagerows
	 */
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
	}
	
	/**
	 * Page Number
	 * @param tsTpCd
	 */
	public void setTsTpCd(String tsTpCd) {
		this.tsTpCd = tsTpCd;
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
		setSMode(JSPUtil.getParameter(request, prefix + "s_mode", ""));
		setSPodCd(JSPUtil.getParameter(request, prefix + "s_pod_cd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setSTrunkPodCd(JSPUtil.getParameter(request, prefix + "s_trunk_pod_cd", ""));
		setSTrunkPorCd(JSPUtil.getParameter(request, prefix + "s_trunk_por_cd", ""));
		setSTrunkPolCd(JSPUtil.getParameter(request, prefix + "s_trunk_pol_cd", ""));
		setSPolCd(JSPUtil.getParameter(request, prefix + "s_pol_cd", ""));
		setSStatus(JSPUtil.getParameter(request, prefix + "s_status", ""));
		setSTrunkDelCd(JSPUtil.getParameter(request, prefix + "s_trunk_del_cd", ""));
		setSVvd(JSPUtil.getParameter(request, prefix + "s_vvd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setTsTpCd(JSPUtil.getParameter(request, prefix + "ts_tp_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return MalaysiaManifestListCondVO[]
	 */
	public MalaysiaManifestListCondVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return MalaysiaManifestListCondVO[]
	 */
	public MalaysiaManifestListCondVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		MalaysiaManifestListCondVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] sMode = (JSPUtil.getParameter(request, prefix	+ "s_mode", length));
			String[] sPodCd = (JSPUtil.getParameter(request, prefix	+ "s_pod_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] sTrunkPodCd = (JSPUtil.getParameter(request, prefix	+ "s_trunk_pod_cd", length));
			String[] sTrunkPorCd = (JSPUtil.getParameter(request, prefix	+ "s_trunk_por_cd", length));
			String[] sTrunkPolCd = (JSPUtil.getParameter(request, prefix	+ "s_trunk_pol_cd", length));
			String[] sPolCd = (JSPUtil.getParameter(request, prefix	+ "s_pol_cd", length));
			String[] sStatus = (JSPUtil.getParameter(request, prefix	+ "s_status", length));
			String[] sTrunkDelCd = (JSPUtil.getParameter(request, prefix	+ "s_trunk_del_cd", length));
			String[] sVvd = (JSPUtil.getParameter(request, prefix	+ "s_vvd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] tsTpCd = (JSPUtil.getParameter(request, prefix	+ "ts_tp_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new MalaysiaManifestListCondVO();
				if (sMode[i] != null)
					model.setSMode(sMode[i]);
				if (sPodCd[i] != null)
					model.setSPodCd(sPodCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (sTrunkPodCd[i] != null)
					model.setSTrunkPodCd(sTrunkPodCd[i]);
				if (sTrunkPorCd[i] != null)
					model.setSTrunkPorCd(sTrunkPorCd[i]);
				if (sTrunkPolCd[i] != null)
					model.setSTrunkPolCd(sTrunkPolCd[i]);
				if (sPolCd[i] != null)
					model.setSPolCd(sPolCd[i]);
				if (sStatus[i] != null)
					model.setSStatus(sStatus[i]);
				if (sTrunkDelCd[i] != null)
					model.setSTrunkDelCd(sTrunkDelCd[i]);
				if (sVvd[i] != null)
					model.setSVvd(sVvd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (tsTpCd[i] != null)
					model.setTsTpCd(tsTpCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getMalaysiaManifestListCondVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return MalaysiaManifestListCondVO[]
	 */
	public MalaysiaManifestListCondVO[] getMalaysiaManifestListCondVOs(){
		MalaysiaManifestListCondVO[] vos = (MalaysiaManifestListCondVO[])models.toArray(new MalaysiaManifestListCondVO[models.size()]);
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
		this.sMode = this.sMode .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sPodCd = this.sPodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sTrunkPodCd = this.sTrunkPodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sTrunkPorCd = this.sTrunkPorCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sTrunkPolCd = this.sTrunkPolCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sPolCd = this.sPolCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sStatus = this.sStatus .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sTrunkDelCd = this.sTrunkDelCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sVvd = this.sVvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tsTpCd = this.tsTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
