/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : InPrsMQCEstimateVO.java
*@FileTitle : InPrsMQCEstimateVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.05.10
*@LastModifier : 송민석
*@LastVersion : 1.0
* 2010.05.10 송민석 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.pri.scproposal.scproposalmain.vo;

import java.lang.reflect.Field;
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
 * @author 송민석
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class InPrsMQCEstimateVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<InPrsMQCEstimateVO> models = new ArrayList<InPrsMQCEstimateVO>();
	
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String frmPropNo = null;
	/* Column Info */
	private String frmAmdtSeq = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public InPrsMQCEstimateVO() {}

	public InPrsMQCEstimateVO(String ibflag, String pagerows, String frmPropNo, String frmAmdtSeq) {
		this.ibflag = ibflag;
		this.frmPropNo = frmPropNo;
		this.frmAmdtSeq = frmAmdtSeq;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("frm_prop_no", getFrmPropNo());
		this.hashColumns.put("frm_amdt_seq", getFrmAmdtSeq());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("frm_prop_no", "frmPropNo");
		this.hashFields.put("frm_amdt_seq", "frmAmdtSeq");
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
	 * @return frmPropNo
	 */
	public String getFrmPropNo() {
		return this.frmPropNo;
	}
	
	/**
	 * Column Info
	 * @return frmAmdtSeq
	 */
	public String getFrmAmdtSeq() {
		return this.frmAmdtSeq;
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
	 * @param frmPropNo
	 */
	public void setFrmPropNo(String frmPropNo) {
		this.frmPropNo = frmPropNo;
	}
	
	/**
	 * Column Info
	 * @param frmAmdtSeq
	 */
	public void setFrmAmdtSeq(String frmAmdtSeq) {
		this.frmAmdtSeq = frmAmdtSeq;
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
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setFrmPropNo(JSPUtil.getParameter(request, prefix + "frm_prop_no", ""));
		setFrmAmdtSeq(JSPUtil.getParameter(request, prefix + "frm_amdt_seq", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return InPrsMQCEstimateVO[]
	 */
	public InPrsMQCEstimateVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return InPrsMQCEstimateVO[]
	 */
	public InPrsMQCEstimateVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		InPrsMQCEstimateVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] frmPropNo = (JSPUtil.getParameter(request, prefix	+ "frm_prop_no", length));
			String[] frmAmdtSeq = (JSPUtil.getParameter(request, prefix	+ "frm_amdt_seq", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new InPrsMQCEstimateVO();
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (frmPropNo[i] != null)
					model.setFrmPropNo(frmPropNo[i]);
				if (frmAmdtSeq[i] != null)
					model.setFrmAmdtSeq(frmAmdtSeq[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getInPrsMQCEstimateVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return InPrsMQCEstimateVO[]
	 */
	public InPrsMQCEstimateVO[] getInPrsMQCEstimateVOs(){
		InPrsMQCEstimateVO[] vos = (InPrsMQCEstimateVO[])models.toArray(new InPrsMQCEstimateVO[models.size()]);
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
		this.frmPropNo = this.frmPropNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.frmAmdtSeq = this.frmAmdtSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
