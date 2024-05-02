/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : JapCstmsVO.java
*@FileTitle : JapCstmsVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.05
*@LastModifier : 
*@LastVersion : 1.0
* 2009.10.05  
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo;

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
 * @author
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class JapCstmsVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<JapCstmsVO> models = new ArrayList<JapCstmsVO>();
	
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String cyOpCd = null;
	/* Column Info */
	private String infoCgoFlg = null;
	/* Column Info */
	private String fullMtyCd = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public JapCstmsVO() {}

	public JapCstmsVO(String ibflag, String pagerows, String cyOpCd, String infoCgoFlg, String fullMtyCd) {
		this.ibflag = ibflag;
		this.cyOpCd = cyOpCd;
		this.infoCgoFlg = infoCgoFlg;
		this.fullMtyCd = fullMtyCd;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cy_op_cd", getCyOpCd());
		this.hashColumns.put("info_cgo_flg", getInfoCgoFlg());
		this.hashColumns.put("full_mty_cd", getFullMtyCd());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cy_op_cd", "cyOpCd");
		this.hashFields.put("info_cgo_flg", "infoCgoFlg");
		this.hashFields.put("full_mty_cd", "fullMtyCd");
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
	 * @return cyOpCd
	 */
	public String getCyOpCd() {
		return this.cyOpCd;
	}
	
	/**
	 * Column Info
	 * @return infoCgoFlg
	 */
	public String getInfoCgoFlg() {
		return this.infoCgoFlg;
	}
	
	/**
	 * Column Info
	 * @return fullMtyCd
	 */
	public String getFullMtyCd() {
		return this.fullMtyCd;
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
	 * @param cyOpCd
	 */
	public void setCyOpCd(String cyOpCd) {
		this.cyOpCd = cyOpCd;
	}
	
	/**
	 * Column Info
	 * @param infoCgoFlg
	 */
	public void setInfoCgoFlg(String infoCgoFlg) {
		this.infoCgoFlg = infoCgoFlg;
	}
	
	/**
	 * Column Info
	 * @param fullMtyCd
	 */
	public void setFullMtyCd(String fullMtyCd) {
		this.fullMtyCd = fullMtyCd;
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
		setCyOpCd(JSPUtil.getParameter(request, "cy_op_cd", ""));
		setInfoCgoFlg(JSPUtil.getParameter(request, "info_cgo_flg", ""));
		setFullMtyCd(JSPUtil.getParameter(request, "full_mty_cd", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return JapCstmsVO[]
	 */
	public JapCstmsVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return JapCstmsVO[]
	 */
	public JapCstmsVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		JapCstmsVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] cyOpCd = (JSPUtil.getParameter(request, prefix	+ "cy_op_cd", length));
			String[] infoCgoFlg = (JSPUtil.getParameter(request, prefix	+ "info_cgo_flg", length));
			String[] fullMtyCd = (JSPUtil.getParameter(request, prefix	+ "full_mty_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new JapCstmsVO();
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (cyOpCd[i] != null)
					model.setCyOpCd(cyOpCd[i]);
				if (infoCgoFlg[i] != null)
					model.setInfoCgoFlg(infoCgoFlg[i]);
				if (fullMtyCd[i] != null)
					model.setFullMtyCd(fullMtyCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getJapCstmsVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return JapCstmsVO[]
	 */
	public JapCstmsVO[] getJapCstmsVOs(){
		JapCstmsVO[] vos = (JapCstmsVO[])models.toArray(new JapCstmsVO[models.size()]);
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
		this.cyOpCd = this.cyOpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.infoCgoFlg = this.infoCgoFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fullMtyCd = this.fullMtyCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
