/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : PortPairRouteConditionVO.java
*@FileTitle : PortPairRouteConditionVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.16
*@LastModifier : 김인수
*@LastVersion : 1.0
* 2010.03.16 김인수 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esd.sce.customerscheduleedi.portpairroute.vo;

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
 * @author 김인수
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class PortPairRouteConditionVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<PortPairRouteConditionVO> models = new ArrayList<PortPairRouteConditionVO>();
	
	/* Column Info */
	private String userOfcCd = null;
	/* Column Info */
	private String partnerName = null;
	/* Column Info */
	private String delPortCd = null;
	/* Column Info */
	private String noUseFlag = null;
	/* Column Info */
	private String polPortCd = null;
	/* Column Info */
	private String useFlg = null;
	/* Column Info */
	private String partnerId = null;
	/* Column Info */
	private String porPortCd = null;
	/* Column Info */
	private String pagerows = null;
	/* Column Info */
	private String ibflag = null;
	/* Column Info */
	private String tsType = null;
	/* Column Info */
	private String podPortCd = null;
	/* Column Info */
	private String usrId = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public PortPairRouteConditionVO() {}

	public PortPairRouteConditionVO(String ibflag, String pagerows, String userOfcCd, String delPortCd, String tsType, String podPortCd, String noUseFlag, String usrId, String polPortCd, String useFlg, String partnerId, String partnerName, String porPortCd) {
		this.userOfcCd = userOfcCd;
		this.partnerName = partnerName;
		this.delPortCd = delPortCd;
		this.noUseFlag = noUseFlag;
		this.polPortCd = polPortCd;
		this.useFlg = useFlg;
		this.partnerId = partnerId;
		this.porPortCd = porPortCd;
		this.pagerows = pagerows;
		this.ibflag = ibflag;
		this.tsType = tsType;
		this.podPortCd = podPortCd;
		this.usrId = usrId;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("user_ofc_cd", getUserOfcCd());
		this.hashColumns.put("partner_name", getPartnerName());
		this.hashColumns.put("del_port_cd", getDelPortCd());
		this.hashColumns.put("no_use_flag", getNoUseFlag());
		this.hashColumns.put("pol_port_cd", getPolPortCd());
		this.hashColumns.put("use_flg", getUseFlg());
		this.hashColumns.put("partner_id", getPartnerId());
		this.hashColumns.put("por_port_cd", getPorPortCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("ts_type", getTsType());
		this.hashColumns.put("pod_port_cd", getPodPortCd());
		this.hashColumns.put("usr_id", getUsrId());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("user_ofc_cd", "userOfcCd");
		this.hashFields.put("partner_name", "partnerName");
		this.hashFields.put("del_port_cd", "delPortCd");
		this.hashFields.put("no_use_flag", "noUseFlag");
		this.hashFields.put("pol_port_cd", "polPortCd");
		this.hashFields.put("use_flg", "useFlg");
		this.hashFields.put("partner_id", "partnerId");
		this.hashFields.put("por_port_cd", "porPortCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("ts_type", "tsType");
		this.hashFields.put("pod_port_cd", "podPortCd");
		this.hashFields.put("usr_id", "usrId");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return userOfcCd
	 */
	public String getUserOfcCd() {
		return this.userOfcCd;
	}
	
	/**
	 * Column Info
	 * @return partnerName
	 */
	public String getPartnerName() {
		return this.partnerName;
	}
	
	/**
	 * Column Info
	 * @return delPortCd
	 */
	public String getDelPortCd() {
		return this.delPortCd;
	}
	
	/**
	 * Column Info
	 * @return noUseFlag
	 */
	public String getNoUseFlag() {
		return this.noUseFlag;
	}
	
	/**
	 * Column Info
	 * @return polPortCd
	 */
	public String getPolPortCd() {
		return this.polPortCd;
	}
	
	/**
	 * Column Info
	 * @return useFlg
	 */
	public String getUseFlg() {
		return this.useFlg;
	}
	
	/**
	 * Column Info
	 * @return partnerId
	 */
	public String getPartnerId() {
		return this.partnerId;
	}
	
	/**
	 * Column Info
	 * @return porPortCd
	 */
	public String getPorPortCd() {
		return this.porPortCd;
	}
	
	/**
	 * Column Info
	 * @return pagerows
	 */
	public String getPagerows() {
		return this.pagerows;
	}
	
	/**
	 * Column Info
	 * @return ibflag
	 */
	public String getIbflag() {
		return this.ibflag;
	}
	
	/**
	 * Column Info
	 * @return tsType
	 */
	public String getTsType() {
		return this.tsType;
	}
	
	/**
	 * Column Info
	 * @return podPortCd
	 */
	public String getPodPortCd() {
		return this.podPortCd;
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
	 * @param userOfcCd
	 */
	public void setUserOfcCd(String userOfcCd) {
		this.userOfcCd = userOfcCd;
	}
	
	/**
	 * Column Info
	 * @param partnerName
	 */
	public void setPartnerName(String partnerName) {
		this.partnerName = partnerName;
	}
	
	/**
	 * Column Info
	 * @param delPortCd
	 */
	public void setDelPortCd(String delPortCd) {
		this.delPortCd = delPortCd;
	}
	
	/**
	 * Column Info
	 * @param noUseFlag
	 */
	public void setNoUseFlag(String noUseFlag) {
		this.noUseFlag = noUseFlag;
	}
	
	/**
	 * Column Info
	 * @param polPortCd
	 */
	public void setPolPortCd(String polPortCd) {
		this.polPortCd = polPortCd;
	}
	
	/**
	 * Column Info
	 * @param useFlg
	 */
	public void setUseFlg(String useFlg) {
		this.useFlg = useFlg;
	}
	
	/**
	 * Column Info
	 * @param partnerId
	 */
	public void setPartnerId(String partnerId) {
		this.partnerId = partnerId;
	}
	
	/**
	 * Column Info
	 * @param porPortCd
	 */
	public void setPorPortCd(String porPortCd) {
		this.porPortCd = porPortCd;
	}
	
	/**
	 * Column Info
	 * @param pagerows
	 */
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
	}
	
	/**
	 * Column Info
	 * @param ibflag
	 */
	public void setIbflag(String ibflag) {
		this.ibflag = ibflag;
	}
	
	/**
	 * Column Info
	 * @param tsType
	 */
	public void setTsType(String tsType) {
		this.tsType = tsType;
	}
	
	/**
	 * Column Info
	 * @param podPortCd
	 */
	public void setPodPortCd(String podPortCd) {
		this.podPortCd = podPortCd;
	}
	
	/**
	 * Column Info
	 * @param usrId
	 */
	public void setUsrId(String usrId) {
		this.usrId = usrId;
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
		setUserOfcCd(JSPUtil.getParameter(request, prefix + "user_ofc_cd", ""));
		setPartnerName(JSPUtil.getParameter(request, prefix + "partner_name", ""));
		setDelPortCd(JSPUtil.getParameter(request, prefix + "del_port_cd", ""));
		setNoUseFlag(JSPUtil.getParameter(request, prefix + "no_use_flag", "Y"));
		setPolPortCd(JSPUtil.getParameter(request, prefix + "pol_port_cd", ""));
		setUseFlg(JSPUtil.getParameter(request, prefix + "use_flg", ""));
		setPartnerId(JSPUtil.getParameter(request, prefix + "partner_id", ""));
		setPorPortCd(JSPUtil.getParameter(request, prefix + "por_port_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setTsType(JSPUtil.getParameter(request, prefix + "ts_type", ""));
		setPodPortCd(JSPUtil.getParameter(request, prefix + "pod_port_cd", ""));
		setUsrId(JSPUtil.getParameter(request, prefix + "usr_id", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return PortPairRouteConditionVO[]
	 */
	public PortPairRouteConditionVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return PortPairRouteConditionVO[]
	 */
	public PortPairRouteConditionVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		PortPairRouteConditionVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] userOfcCd = (JSPUtil.getParameter(request, prefix	+ "user_ofc_cd", length));
			String[] partnerName = (JSPUtil.getParameter(request, prefix	+ "partner_name", length));
			String[] delPortCd = (JSPUtil.getParameter(request, prefix	+ "del_port_cd", length));
			String[] noUseFlag = (JSPUtil.getParameter(request, prefix	+ "no_use_flag", length));
			String[] polPortCd = (JSPUtil.getParameter(request, prefix	+ "pol_port_cd", length));
			String[] useFlg = (JSPUtil.getParameter(request, prefix	+ "use_flg", length));
			String[] partnerId = (JSPUtil.getParameter(request, prefix	+ "partner_id", length));
			String[] porPortCd = (JSPUtil.getParameter(request, prefix	+ "por_port_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] tsType = (JSPUtil.getParameter(request, prefix	+ "ts_type", length));
			String[] podPortCd = (JSPUtil.getParameter(request, prefix	+ "pod_port_cd", length));
			String[] usrId = (JSPUtil.getParameter(request, prefix	+ "usr_id", length));
			
			for (int i = 0; i < length; i++) {
				model = new PortPairRouteConditionVO();
				if (userOfcCd[i] != null)
					model.setUserOfcCd(userOfcCd[i]);
				if (partnerName[i] != null)
					model.setPartnerName(partnerName[i]);
				if (delPortCd[i] != null)
					model.setDelPortCd(delPortCd[i]);
				if (noUseFlag[i] != null)
					model.setNoUseFlag(noUseFlag[i]);
				if (polPortCd[i] != null)
					model.setPolPortCd(polPortCd[i]);
				if (useFlg[i] != null)
					model.setUseFlg(useFlg[i]);
				if (partnerId[i] != null)
					model.setPartnerId(partnerId[i]);
				if (porPortCd[i] != null)
					model.setPorPortCd(porPortCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (tsType[i] != null)
					model.setTsType(tsType[i]);
				if (podPortCd[i] != null)
					model.setPodPortCd(podPortCd[i]);
				if (usrId[i] != null)
					model.setUsrId(usrId[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getPortPairRouteConditionVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return PortPairRouteConditionVO[]
	 */
	public PortPairRouteConditionVO[] getPortPairRouteConditionVOs(){
		PortPairRouteConditionVO[] vos = (PortPairRouteConditionVO[])models.toArray(new PortPairRouteConditionVO[models.size()]);
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
		this.userOfcCd = this.userOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.partnerName = this.partnerName .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delPortCd = this.delPortCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.noUseFlag = this.noUseFlag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polPortCd = this.polPortCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.useFlg = this.useFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.partnerId = this.partnerId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.porPortCd = this.porPortCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tsType = this.tsType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podPortCd = this.podPortCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usrId = this.usrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
