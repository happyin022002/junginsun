/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : SvcRouteModeVO.java
*@FileTitle : SvcRouteModeVO
*Open Issues :
*Change history :
*@LastModifyDate : 2015.06.05
*@LastModifier : 
*@LastVersion : 1.0
* 2015.06.05  
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.hanjin.framework.component.common.AbstractValueObject;
import com.hanjin.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SvcRouteModeVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SvcRouteModeVO> models = new ArrayList<SvcRouteModeVO>();
	
	/* Column Info */
	private String destTrnsSvcModCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String orgTrnsSvcModCd = null;
	/* Column Info */
	private String orgScontiCd = null;
	/* Column Info */
	private String blckStwgCd = null;
	/* Column Info */
	private String estmIbMtyRtnYdCd = null;
	/* Column Info */
	private String destScontiCd = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public SvcRouteModeVO() {}

	public SvcRouteModeVO(String ibflag, String pagerows, String orgScontiCd, String destScontiCd, String orgTrnsSvcModCd, String destTrnsSvcModCd, String blckStwgCd, String estmIbMtyRtnYdCd) {
		this.destTrnsSvcModCd = destTrnsSvcModCd;
		this.ibflag = ibflag;
		this.orgTrnsSvcModCd = orgTrnsSvcModCd;
		this.orgScontiCd = orgScontiCd;
		this.blckStwgCd = blckStwgCd;
		this.estmIbMtyRtnYdCd = estmIbMtyRtnYdCd;
		this.destScontiCd = destScontiCd;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("dest_trns_svc_mod_cd", getDestTrnsSvcModCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("org_trns_svc_mod_cd", getOrgTrnsSvcModCd());
		this.hashColumns.put("org_sconti_cd", getOrgScontiCd());
		this.hashColumns.put("blck_stwg_cd", getBlckStwgCd());
		this.hashColumns.put("estm_ib_mty_rtn_yd_cd", getEstmIbMtyRtnYdCd());
		this.hashColumns.put("dest_sconti_cd", getDestScontiCd());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("dest_trns_svc_mod_cd", "destTrnsSvcModCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("org_trns_svc_mod_cd", "orgTrnsSvcModCd");
		this.hashFields.put("org_sconti_cd", "orgScontiCd");
		this.hashFields.put("blck_stwg_cd", "blckStwgCd");
		this.hashFields.put("estm_ib_mty_rtn_yd_cd", "estmIbMtyRtnYdCd");
		this.hashFields.put("dest_sconti_cd", "destScontiCd");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return destTrnsSvcModCd
	 */
	public String getDestTrnsSvcModCd() {
		return this.destTrnsSvcModCd;
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
	 * @return orgTrnsSvcModCd
	 */
	public String getOrgTrnsSvcModCd() {
		return this.orgTrnsSvcModCd;
	}
	
	/**
	 * Column Info
	 * @return orgScontiCd
	 */
	public String getOrgScontiCd() {
		return this.orgScontiCd;
	}
	
	/**
	 * Column Info
	 * @return blckStwgCd
	 */
	public String getBlckStwgCd() {
		return this.blckStwgCd;
	}
	
	/**
	 * Column Info
	 * @return estmIbMtyRtnYdCd
	 */
	public String getEstmIbMtyRtnYdCd() {
		return this.estmIbMtyRtnYdCd;
	}
	
	/**
	 * Column Info
	 * @return destScontiCd
	 */
	public String getDestScontiCd() {
		return this.destScontiCd;
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
	 * @param destTrnsSvcModCd
	 */
	public void setDestTrnsSvcModCd(String destTrnsSvcModCd) {
		this.destTrnsSvcModCd = destTrnsSvcModCd;
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
	 * @param orgTrnsSvcModCd
	 */
	public void setOrgTrnsSvcModCd(String orgTrnsSvcModCd) {
		this.orgTrnsSvcModCd = orgTrnsSvcModCd;
	}
	
	/**
	 * Column Info
	 * @param orgScontiCd
	 */
	public void setOrgScontiCd(String orgScontiCd) {
		this.orgScontiCd = orgScontiCd;
	}
	
	/**
	 * Column Info
	 * @param blckStwgCd
	 */
	public void setBlckStwgCd(String blckStwgCd) {
		this.blckStwgCd = blckStwgCd;
	}
	
	/**
	 * Column Info
	 * @param estmIbMtyRtnYdCd
	 */
	public void setEstmIbMtyRtnYdCd(String estmIbMtyRtnYdCd) {
		this.estmIbMtyRtnYdCd = estmIbMtyRtnYdCd;
	}
	
	/**
	 * Column Info
	 * @param destScontiCd
	 */
	public void setDestScontiCd(String destScontiCd) {
		this.destScontiCd = destScontiCd;
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
		setDestTrnsSvcModCd(JSPUtil.getParameter(request, prefix + "dest_trns_svc_mod_cd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setOrgTrnsSvcModCd(JSPUtil.getParameter(request, prefix + "org_trns_svc_mod_cd", ""));
		setOrgScontiCd(JSPUtil.getParameter(request, prefix + "org_sconti_cd", ""));
		setBlckStwgCd(JSPUtil.getParameter(request, prefix + "blck_stwg_cd", ""));
		setEstmIbMtyRtnYdCd(JSPUtil.getParameter(request, prefix + "estm_ib_mty_rtn_yd_cd", ""));
		setDestScontiCd(JSPUtil.getParameter(request, prefix + "dest_sconti_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SvcRouteModeVO[]
	 */
	public SvcRouteModeVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SvcRouteModeVO[]
	 */
	public SvcRouteModeVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SvcRouteModeVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] destTrnsSvcModCd = (JSPUtil.getParameter(request, prefix	+ "dest_trns_svc_mod_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] orgTrnsSvcModCd = (JSPUtil.getParameter(request, prefix	+ "org_trns_svc_mod_cd", length));
			String[] orgScontiCd = (JSPUtil.getParameter(request, prefix	+ "org_sconti_cd", length));
			String[] blckStwgCd = (JSPUtil.getParameter(request, prefix	+ "blck_stwg_cd", length));
			String[] estmIbMtyRtnYdCd = (JSPUtil.getParameter(request, prefix	+ "estm_ib_mty_rtn_yd_cd", length));
			String[] destScontiCd = (JSPUtil.getParameter(request, prefix	+ "dest_sconti_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new SvcRouteModeVO();
				if (destTrnsSvcModCd[i] != null)
					model.setDestTrnsSvcModCd(destTrnsSvcModCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (orgTrnsSvcModCd[i] != null)
					model.setOrgTrnsSvcModCd(orgTrnsSvcModCd[i]);
				if (orgScontiCd[i] != null)
					model.setOrgScontiCd(orgScontiCd[i]);
				if (blckStwgCd[i] != null)
					model.setBlckStwgCd(blckStwgCd[i]);
				if (estmIbMtyRtnYdCd[i] != null)
					model.setEstmIbMtyRtnYdCd(estmIbMtyRtnYdCd[i]);
				if (destScontiCd[i] != null)
					model.setDestScontiCd(destScontiCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSvcRouteModeVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SvcRouteModeVO[]
	 */
	public SvcRouteModeVO[] getSvcRouteModeVOs(){
		SvcRouteModeVO[] vos = (SvcRouteModeVO[])models.toArray(new SvcRouteModeVO[models.size()]);
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
		this.destTrnsSvcModCd = this.destTrnsSvcModCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgTrnsSvcModCd = this.orgTrnsSvcModCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgScontiCd = this.orgScontiCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blckStwgCd = this.blckStwgCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.estmIbMtyRtnYdCd = this.estmIbMtyRtnYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.destScontiCd = this.destScontiCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
