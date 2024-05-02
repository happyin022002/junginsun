/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SitProMsnInfoVO.java
*@FileTitle : SitProMsnInfoVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.12
*@LastModifier : 경종윤
*@LastVersion : 1.0
* 2009.10.12 경종윤 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.eur.vo;

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
 * @author 경종윤
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SitProMsnInfoVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SitProMsnInfoVO> models = new ArrayList<SitProMsnInfoVO>();
	
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String msncfm = null;
	/* Column Info */
	private String blts = null;
	/* Column Info */
	private String bltp = null;
	/* Column Info */
	private String msnNbr = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SitProMsnInfoVO() {}

	public SitProMsnInfoVO(String ibflag, String pagerows, String blts, String bltp, String msnNbr, String msncfm) {
		this.ibflag = ibflag;
		this.msncfm = msncfm;
		this.blts = blts;
		this.bltp = bltp;
		this.msnNbr = msnNbr;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("msncfm", getMsncfm());
		this.hashColumns.put("blts", getBlts());
		this.hashColumns.put("bltp", getBltp());
		this.hashColumns.put("msn_nbr", getMsnNbr());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("msncfm", "msncfm");
		this.hashFields.put("blts", "blts");
		this.hashFields.put("bltp", "bltp");
		this.hashFields.put("msn_nbr", "msnNbr");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
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
	 * @return msncfm
	 */
	public String getMsncfm() {
		return this.msncfm;
	}
	
	/**
	 * Column Info
	 * @return blts
	 */
	public String getBlts() {
		return this.blts;
	}
	
	/**
	 * Column Info
	 * @return bltp
	 */
	public String getBltp() {
		return this.bltp;
	}
	
	/**
	 * Column Info
	 * @return msnNbr
	 */
	public String getMsnNbr() {
		return this.msnNbr;
	}
	
	/**
	 * Page Number
	 * @return pagerows
	 */
	public String getPagerows() {
		return this.pagerows;
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
	 * @param msncfm
	 */
	public void setMsncfm(String msncfm) {
		this.msncfm = msncfm;
	}
	
	/**
	 * Column Info
	 * @param blts
	 */
	public void setBlts(String blts) {
		this.blts = blts;
	}
	
	/**
	 * Column Info
	 * @param bltp
	 */
	public void setBltp(String bltp) {
		this.bltp = bltp;
	}
	
	/**
	 * Column Info
	 * @param msnNbr
	 */
	public void setMsnNbr(String msnNbr) {
		this.msnNbr = msnNbr;
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
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setMsncfm(JSPUtil.getParameter(request, "msncfm", ""));
		setBlts(JSPUtil.getParameter(request, "blts", ""));
		setBltp(JSPUtil.getParameter(request, "bltp", ""));
		setMsnNbr(JSPUtil.getParameter(request, "msn_nbr", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SitProMsnInfoVO[]
	 */
	public SitProMsnInfoVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SitProMsnInfoVO[]
	 */
	public SitProMsnInfoVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SitProMsnInfoVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] msncfm = (JSPUtil.getParameter(request, prefix	+ "msncfm", length));
			String[] blts = (JSPUtil.getParameter(request, prefix	+ "blts", length));
			String[] bltp = (JSPUtil.getParameter(request, prefix	+ "bltp", length));
			String[] msnNbr = (JSPUtil.getParameter(request, prefix	+ "msn_nbr", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new SitProMsnInfoVO();
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (msncfm[i] != null)
					model.setMsncfm(msncfm[i]);
				if (blts[i] != null)
					model.setBlts(blts[i]);
				if (bltp[i] != null)
					model.setBltp(bltp[i]);
				if (msnNbr[i] != null)
					model.setMsnNbr(msnNbr[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSitProMsnInfoVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SitProMsnInfoVO[]
	 */
	public SitProMsnInfoVO[] getSitProMsnInfoVOs(){
		SitProMsnInfoVO[] vos = (SitProMsnInfoVO[])models.toArray(new SitProMsnInfoVO[models.size()]);
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
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.msncfm = this.msncfm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blts = this.blts .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bltp = this.bltp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.msnNbr = this.msnNbr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
