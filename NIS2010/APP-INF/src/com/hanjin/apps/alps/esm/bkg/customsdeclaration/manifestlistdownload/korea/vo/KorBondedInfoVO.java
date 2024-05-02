/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : KorBondedInfoVO.java
*@FileTitle : KorBondedInfoVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.27
*@LastModifier : 박상훈
*@LastVersion : 1.0
* 2009.10.27 박상훈 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.korea.vo;

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
 * @author 박상훈
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class KorBondedInfoVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<KorBondedInfoVO> models = new ArrayList<KorBondedInfoVO>();
	
	/* Column Info */
	private String vvd = null;
	/* Column Info */
	private String mrnMode = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String yard = null;
	/* Column Info */
	private String pol = null;
	/* Column Info */
	private String mrnNo = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String pod = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public KorBondedInfoVO() {}

	public KorBondedInfoVO(String ibflag, String pagerows, String mrnNo, String mrnMode, String vvd, String pod, String pol, String yard, String bkgNo) {
		this.vvd = vvd;
		this.mrnMode = mrnMode;
		this.ibflag = ibflag;
		this.yard = yard;
		this.pol = pol;
		this.mrnNo = mrnNo;
		this.pod = pod;
		this.bkgNo = bkgNo;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("vvd", getVvd());
		this.hashColumns.put("mrn_mode", getMrnMode());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("yard", getYard());
		this.hashColumns.put("pol", getPol());
		this.hashColumns.put("mrn_no", getMrnNo());
		this.hashColumns.put("pod", getPod());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("vvd", "vvd");
		this.hashFields.put("mrn_mode", "mrnMode");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("yard", "yard");
		this.hashFields.put("pol", "pol");
		this.hashFields.put("mrn_no", "mrnNo");
		this.hashFields.put("pod", "pod");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * @return the bkgNo
	 */
	public String getBkgNo() {
		return bkgNo;
	}

	/**
	 * @param bkgNo the bkgNo to set
	 */
	public void setBkgNo(String bkgNo) {
		this.bkgNo = bkgNo;
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
	 * @return mrnMode
	 */
	public String getMrnMode() {
		return this.mrnMode;
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
	 * @return yard
	 */
	public String getYard() {
		return this.yard;
	}
	
	/**
	 * Column Info
	 * @return pol
	 */
	public String getPol() {
		return this.pol;
	}
	
	/**
	 * Column Info
	 * @return mrnNo
	 */
	public String getMrnNo() {
		return this.mrnNo;
	}
	
	/**
	 * Column Info
	 * @return pod
	 */
	public String getPod() {
		return this.pod;
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
	 * @param mrnMode
	 */
	public void setMrnMode(String mrnMode) {
		this.mrnMode = mrnMode;
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
	 * @param yard
	 */
	public void setYard(String yard) {
		this.yard = yard;
	}
	
	/**
	 * Column Info
	 * @param pol
	 */
	public void setPol(String pol) {
		this.pol = pol;
	}
	
	/**
	 * Column Info
	 * @param mrnNo
	 */
	public void setMrnNo(String mrnNo) {
		this.mrnNo = mrnNo;
	}
	
	/**
	 * Column Info
	 * @param pod
	 */
	public void setPod(String pod) {
		this.pod = pod;
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
		setVvd(JSPUtil.getParameter(request, "vvd", ""));
		setMrnMode(JSPUtil.getParameter(request, "mrn_mode", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setYard(JSPUtil.getParameter(request, "yard", ""));
		setPol(JSPUtil.getParameter(request, "pol", ""));
		setMrnNo(JSPUtil.getParameter(request, "mrn_no", ""));
		setPod(JSPUtil.getParameter(request, "pod", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return KorBondedInfoVO[]
	 */
	public KorBondedInfoVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return KorBondedInfoVO[]
	 */
	public KorBondedInfoVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		KorBondedInfoVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] vvd = (JSPUtil.getParameter(request, prefix	+ "vvd", length));
			String[] mrnMode = (JSPUtil.getParameter(request, prefix	+ "mrn_mode", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] yard = (JSPUtil.getParameter(request, prefix	+ "yard", length));
			String[] pol = (JSPUtil.getParameter(request, prefix	+ "pol", length));
			String[] mrnNo = (JSPUtil.getParameter(request, prefix	+ "mrn_no", length));
			String[] pod = (JSPUtil.getParameter(request, prefix	+ "pod", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new KorBondedInfoVO();
				if (vvd[i] != null)
					model.setVvd(vvd[i]);
				if (mrnMode[i] != null)
					model.setMrnMode(mrnMode[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (yard[i] != null)
					model.setYard(yard[i]);
				if (pol[i] != null)
					model.setPol(pol[i]);
				if (mrnNo[i] != null)
					model.setMrnNo(mrnNo[i]);
				if (pod[i] != null)
					model.setPod(pod[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getKorBondedInfoVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return KorBondedInfoVO[]
	 */
	public KorBondedInfoVO[] getKorBondedInfoVOs(){
		KorBondedInfoVO[] vos = (KorBondedInfoVO[])models.toArray(new KorBondedInfoVO[models.size()]);
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
		this.mrnMode = this.mrnMode .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.yard = this.yard .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pol = this.pol .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mrnNo = this.mrnNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pod = this.pod .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
