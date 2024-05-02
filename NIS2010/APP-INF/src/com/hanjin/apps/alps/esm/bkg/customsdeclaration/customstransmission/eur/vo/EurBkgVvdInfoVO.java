/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : EurBkgVvdInfoVO.java
*@FileTitle : EurBkgVvdInfoVO
*Open Issues :
*Change history :
*@LastModifyDate : 2011.08.22
*@LastModifier : 
*@LastVersion : 1.0
* 2011.08.22  
* 1.0 Creation
* ------------------------------------------
* 2011.08.25 김보배 [CHM-201112952] [EUR Inbound Manifest] Flat File 보완 - pofe 추가 
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.eur.vo;

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
 * @author 
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class EurBkgVvdInfoVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<EurBkgVvdInfoVO> models = new ArrayList<EurBkgVvdInfoVO>();
	
	/* Column Info */
	private String vvd = null;
	/* Column Info */
	private String eta = null;
	/* Column Info */
	private String vslFullname = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String pofe = null;
	/* Column Info */
	private String vslCallsign = null;
	/* Column Info */
	private String pofeEta = null;
	/* Column Info */
	private String vslLloydcode = null;
	/* Column Info */
	private String vslFlag = null;
	/* Column Info */
	private String etd = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public EurBkgVvdInfoVO() {}

	public EurBkgVvdInfoVO(String ibflag, String pagerows, String vvd, String vslCallsign, String vslLloydcode, String vslFullname, String eta, String etd, String vslFlag, String pofeEta, String pofe) {
		this.vvd = vvd;
		this.eta = eta;
		this.vslFullname = vslFullname;
		this.ibflag = ibflag;
		this.pofe = pofe;
		this.vslCallsign = vslCallsign;
		this.pofeEta = pofeEta;
		this.vslLloydcode = vslLloydcode;
		this.vslFlag = vslFlag;
		this.etd = etd;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("vvd", getVvd());
		this.hashColumns.put("eta", getEta());
		this.hashColumns.put("vsl_fullname", getVslFullname());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("pofe", getPofe());
		this.hashColumns.put("vsl_callsign", getVslCallsign());
		this.hashColumns.put("pofe_eta", getPofeEta());
		this.hashColumns.put("vsl_lloydcode", getVslLloydcode());
		this.hashColumns.put("vsl_flag", getVslFlag());
		this.hashColumns.put("etd", getEtd());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("vvd", "vvd");
		this.hashFields.put("eta", "eta");
		this.hashFields.put("vsl_fullname", "vslFullname");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("pofe", "pofe");
		this.hashFields.put("vsl_callsign", "vslCallsign");
		this.hashFields.put("pofe_eta", "pofeEta");
		this.hashFields.put("vsl_lloydcode", "vslLloydcode");
		this.hashFields.put("vsl_flag", "vslFlag");
		this.hashFields.put("etd", "etd");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
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
	 * @return eta
	 */
	public String getEta() {
		return this.eta;
	}
	
	/**
	 * Column Info
	 * @return vslFullname
	 */
	public String getVslFullname() {
		return this.vslFullname;
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
	 * @return pofe
	 */
	public String getPofe() {
		return this.pofe;
	}
	
	/**
	 * Column Info
	 * @return vslCallsign
	 */
	public String getVslCallsign() {
		return this.vslCallsign;
	}
	
	/**
	 * Column Info
	 * @return pofeEta
	 */
	public String getPofeEta() {
		return this.pofeEta;
	}
	
	/**
	 * Column Info
	 * @return vslLloydcode
	 */
	public String getVslLloydcode() {
		return this.vslLloydcode;
	}
	
	/**
	 * Column Info
	 * @return vslFlag
	 */
	public String getVslFlag() {
		return this.vslFlag;
	}
	
	/**
	 * Column Info
	 * @return etd
	 */
	public String getEtd() {
		return this.etd;
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
	 * @param vvd
	 */
	public void setVvd(String vvd) {
		this.vvd = vvd;
	}
	
	/**
	 * Column Info
	 * @param eta
	 */
	public void setEta(String eta) {
		this.eta = eta;
	}
	
	/**
	 * Column Info
	 * @param vslFullname
	 */
	public void setVslFullname(String vslFullname) {
		this.vslFullname = vslFullname;
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
	 * @param pofe
	 */
	public void setPofe(String pofe) {
		this.pofe = pofe;
	}
	
	/**
	 * Column Info
	 * @param vslCallsign
	 */
	public void setVslCallsign(String vslCallsign) {
		this.vslCallsign = vslCallsign;
	}
	
	/**
	 * Column Info
	 * @param pofeEta
	 */
	public void setPofeEta(String pofeEta) {
		this.pofeEta = pofeEta;
	}
	
	/**
	 * Column Info
	 * @param vslLloydcode
	 */
	public void setVslLloydcode(String vslLloydcode) {
		this.vslLloydcode = vslLloydcode;
	}
	
	/**
	 * Column Info
	 * @param vslFlag
	 */
	public void setVslFlag(String vslFlag) {
		this.vslFlag = vslFlag;
	}
	
	/**
	 * Column Info
	 * @param etd
	 */
	public void setEtd(String etd) {
		this.etd = etd;
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
		setVvd(JSPUtil.getParameter(request, prefix + "vvd", ""));
		setEta(JSPUtil.getParameter(request, prefix + "eta", ""));
		setVslFullname(JSPUtil.getParameter(request, prefix + "vsl_fullname", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setPofe(JSPUtil.getParameter(request, prefix + "pofe", ""));
		setVslCallsign(JSPUtil.getParameter(request, prefix + "vsl_callsign", ""));
		setPofeEta(JSPUtil.getParameter(request, prefix + "pofe_eta", ""));
		setVslLloydcode(JSPUtil.getParameter(request, prefix + "vsl_lloydcode", ""));
		setVslFlag(JSPUtil.getParameter(request, prefix + "vsl_flag", ""));
		setEtd(JSPUtil.getParameter(request, prefix + "etd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return EurBkgVvdInfoVO[]
	 */
	public EurBkgVvdInfoVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return EurBkgVvdInfoVO[]
	 */
	public EurBkgVvdInfoVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		EurBkgVvdInfoVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] vvd = (JSPUtil.getParameter(request, prefix	+ "vvd", length));
			String[] eta = (JSPUtil.getParameter(request, prefix	+ "eta", length));
			String[] vslFullname = (JSPUtil.getParameter(request, prefix	+ "vsl_fullname", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] pofe = (JSPUtil.getParameter(request, prefix	+ "pofe", length));
			String[] vslCallsign = (JSPUtil.getParameter(request, prefix	+ "vsl_callsign", length));
			String[] pofeEta = (JSPUtil.getParameter(request, prefix	+ "pofe_eta", length));
			String[] vslLloydcode = (JSPUtil.getParameter(request, prefix	+ "vsl_lloydcode", length));
			String[] vslFlag = (JSPUtil.getParameter(request, prefix	+ "vsl_flag", length));
			String[] etd = (JSPUtil.getParameter(request, prefix	+ "etd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new EurBkgVvdInfoVO();
				if (vvd[i] != null)
					model.setVvd(vvd[i]);
				if (eta[i] != null)
					model.setEta(eta[i]);
				if (vslFullname[i] != null)
					model.setVslFullname(vslFullname[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (pofe[i] != null)
					model.setPofe(pofe[i]);
				if (vslCallsign[i] != null)
					model.setVslCallsign(vslCallsign[i]);
				if (pofeEta[i] != null)
					model.setPofeEta(pofeEta[i]);
				if (vslLloydcode[i] != null)
					model.setVslLloydcode(vslLloydcode[i]);
				if (vslFlag[i] != null)
					model.setVslFlag(vslFlag[i]);
				if (etd[i] != null)
					model.setEtd(etd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getEurBkgVvdInfoVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return EurBkgVvdInfoVO[]
	 */
	public EurBkgVvdInfoVO[] getEurBkgVvdInfoVOs(){
		EurBkgVvdInfoVO[] vos = (EurBkgVvdInfoVO[])models.toArray(new EurBkgVvdInfoVO[models.size()]);
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
		this.vvd = this.vvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eta = this.eta .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslFullname = this.vslFullname .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pofe = this.pofe .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslCallsign = this.vslCallsign .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pofeEta = this.pofeEta .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslLloydcode = this.vslLloydcode .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslFlag = this.vslFlag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.etd = this.etd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
