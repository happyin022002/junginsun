/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : KorSubNoVO.java
*@FileTitle : KorSubNoVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.01.13
*@LastModifier : 박상훈
*@LastVersion : 1.0
* 2010.01.13 박상훈 
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

public class KorSubNoVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<KorSubNoVO> models = new ArrayList<KorSubNoVO>();
	
	/* Column Info */
	private String inVvd = null;
	/* Column Info */
	private String podTmlCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String subNo = null;
	/* Column Info */
	private String ibPort = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public KorSubNoVO() {}

	public KorSubNoVO(String ibflag, String pagerows, String subNo, String inVvd, String ibPort, String podTmlCd) {
		this.inVvd = inVvd;
		this.podTmlCd = podTmlCd;
		this.ibflag = ibflag;
		this.subNo = subNo;
		this.ibPort = ibPort;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("in_vvd", getInVvd());
		this.hashColumns.put("pod_tml_cd", getPodTmlCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("sub_no", getSubNo());
		this.hashColumns.put("ib_port", getIbPort());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("in_vvd", "inVvd");
		this.hashFields.put("pod_tml_cd", "podTmlCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("sub_no", "subNo");
		this.hashFields.put("ib_port", "ibPort");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return inVvd
	 */
	public String getInVvd() {
		return this.inVvd;
	}
	
	/**
	 * Column Info
	 * @return podTmlCd
	 */
	public String getPodTmlCd() {
		return this.podTmlCd;
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
	 * @return subNo
	 */
	public String getSubNo() {
		return this.subNo;
	}
	
	/**
	 * Column Info
	 * @return ibPort
	 */
	public String getIbPort() {
		return this.ibPort;
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
	 * @param inVvd
	 */
	public void setInVvd(String inVvd) {
		this.inVvd = inVvd;
	}
	
	/**
	 * Column Info
	 * @param podTmlCd
	 */
	public void setPodTmlCd(String podTmlCd) {
		this.podTmlCd = podTmlCd;
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
	 * @param subNo
	 */
	public void setSubNo(String subNo) {
		this.subNo = subNo;
	}
	
	/**
	 * Column Info
	 * @param ibPort
	 */
	public void setIbPort(String ibPort) {
		this.ibPort = ibPort;
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
		setInVvd(JSPUtil.getParameter(request, prefix + "in_vvd", ""));
		setPodTmlCd(JSPUtil.getParameter(request, prefix + "pod_tml_cd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setSubNo(JSPUtil.getParameter(request, prefix + "sub_no", ""));
		setIbPort(JSPUtil.getParameter(request, prefix + "ib_port", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return KorSubNoVO[]
	 */
	public KorSubNoVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return KorSubNoVO[]
	 */
	public KorSubNoVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		KorSubNoVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] inVvd = (JSPUtil.getParameter(request, prefix	+ "in_vvd", length));
			String[] podTmlCd = (JSPUtil.getParameter(request, prefix	+ "pod_tml_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] subNo = (JSPUtil.getParameter(request, prefix	+ "sub_no", length));
			String[] ibPort = (JSPUtil.getParameter(request, prefix	+ "ib_port", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new KorSubNoVO();
				if (inVvd[i] != null)
					model.setInVvd(inVvd[i]);
				if (podTmlCd[i] != null)
					model.setPodTmlCd(podTmlCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (subNo[i] != null)
					model.setSubNo(subNo[i]);
				if (ibPort[i] != null)
					model.setIbPort(ibPort[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getKorSubNoVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return KorSubNoVO[]
	 */
	public KorSubNoVO[] getKorSubNoVOs(){
		KorSubNoVO[] vos = (KorSubNoVO[])models.toArray(new KorSubNoVO[models.size()]);
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
		this.inVvd = this.inVvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podTmlCd = this.podTmlCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.subNo = this.subNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibPort = this.ibPort .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
