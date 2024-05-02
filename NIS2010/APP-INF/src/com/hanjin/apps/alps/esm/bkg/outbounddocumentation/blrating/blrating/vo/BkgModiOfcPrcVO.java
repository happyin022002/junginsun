/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : BkgModiOfcPrcVO.java
*@FileTitle : BkgModiOfcPrcVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.11.22
*@LastModifier : 
*@LastVersion : 1.0
* 2010.11.22  
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.outbounddocumentation.blrating.blrating.vo;

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

public class BkgModiOfcPrcVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<BkgModiOfcPrcVO> models = new ArrayList<BkgModiOfcPrcVO>();
	
	/* Column Info */
	private String inCctFlg = null;
	/* Column Info */
	private String inPpdFlg = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String inBkgNo = null;
	/* Column Info */
	private String outResult = null;
	/* Column Info */
	private String inCaFlg = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public BkgModiOfcPrcVO() {}

	public BkgModiOfcPrcVO(String ibflag, String pagerows, String inBkgNo, String inCaFlg, String inPpdFlg, String inCctFlg, String outResult) {
		this.inCctFlg = inCctFlg;
		this.inPpdFlg = inPpdFlg;
		this.ibflag = ibflag;
		this.inBkgNo = inBkgNo;
		this.outResult = outResult;
		this.inCaFlg = inCaFlg;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("in_cct_flg", getInCctFlg());
		this.hashColumns.put("in_ppd_flg", getInPpdFlg());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("in_bkg_no", getInBkgNo());
		this.hashColumns.put("out_result", getOutResult());
		this.hashColumns.put("in_ca_flg", getInCaFlg());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("in_cct_flg", "inCctFlg");
		this.hashFields.put("in_ppd_flg", "inPpdFlg");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("in_bkg_no", "inBkgNo");
		this.hashFields.put("out_result", "outResult");
		this.hashFields.put("in_ca_flg", "inCaFlg");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return inCctFlg
	 */
	public String getInCctFlg() {
		return this.inCctFlg;
	}
	
	/**
	 * Column Info
	 * @return inPpdFlg
	 */
	public String getInPpdFlg() {
		return this.inPpdFlg;
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
	 * @return inBkgNo
	 */
	public String getInBkgNo() {
		return this.inBkgNo;
	}
	
	/**
	 * Column Info
	 * @return outResult
	 */
	public String getOutResult() {
		return this.outResult;
	}
	
	/**
	 * Column Info
	 * @return inCaFlg
	 */
	public String getInCaFlg() {
		return this.inCaFlg;
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
	 * @param inCctFlg
	 */
	public void setInCctFlg(String inCctFlg) {
		this.inCctFlg = inCctFlg;
	}
	
	/**
	 * Column Info
	 * @param inPpdFlg
	 */
	public void setInPpdFlg(String inPpdFlg) {
		this.inPpdFlg = inPpdFlg;
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
	 * @param inBkgNo
	 */
	public void setInBkgNo(String inBkgNo) {
		this.inBkgNo = inBkgNo;
	}
	
	/**
	 * Column Info
	 * @param outResult
	 */
	public void setOutResult(String outResult) {
		this.outResult = outResult;
	}
	
	/**
	 * Column Info
	 * @param inCaFlg
	 */
	public void setInCaFlg(String inCaFlg) {
		this.inCaFlg = inCaFlg;
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
		setInCctFlg(JSPUtil.getParameter(request, prefix + "in_cct_flg", ""));
		setInPpdFlg(JSPUtil.getParameter(request, prefix + "in_ppd_flg", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setInBkgNo(JSPUtil.getParameter(request, prefix + "in_bkg_no", ""));
		setOutResult(JSPUtil.getParameter(request, prefix + "out_result", ""));
		setInCaFlg(JSPUtil.getParameter(request, prefix + "in_ca_flg", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return BkgModiOfcPrcVO[]
	 */
	public BkgModiOfcPrcVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return BkgModiOfcPrcVO[]
	 */
	public BkgModiOfcPrcVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		BkgModiOfcPrcVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] inCctFlg = (JSPUtil.getParameter(request, prefix	+ "in_cct_flg", length));
			String[] inPpdFlg = (JSPUtil.getParameter(request, prefix	+ "in_ppd_flg", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] inBkgNo = (JSPUtil.getParameter(request, prefix	+ "in_bkg_no", length));
			String[] outResult = (JSPUtil.getParameter(request, prefix	+ "out_result", length));
			String[] inCaFlg = (JSPUtil.getParameter(request, prefix	+ "in_ca_flg", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new BkgModiOfcPrcVO();
				if (inCctFlg[i] != null)
					model.setInCctFlg(inCctFlg[i]);
				if (inPpdFlg[i] != null)
					model.setInPpdFlg(inPpdFlg[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (inBkgNo[i] != null)
					model.setInBkgNo(inBkgNo[i]);
				if (outResult[i] != null)
					model.setOutResult(outResult[i]);
				if (inCaFlg[i] != null)
					model.setInCaFlg(inCaFlg[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getBkgModiOfcPrcVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return BkgModiOfcPrcVO[]
	 */
	public BkgModiOfcPrcVO[] getBkgModiOfcPrcVOs(){
		BkgModiOfcPrcVO[] vos = (BkgModiOfcPrcVO[])models.toArray(new BkgModiOfcPrcVO[models.size()]);
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
		this.inCctFlg = this.inCctFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inPpdFlg = this.inPpdFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inBkgNo = this.inBkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.outResult = this.outResult .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inCaFlg = this.inCaFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
