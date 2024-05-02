/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : AncsCstmsTransCntrVO.java
*@FileTitle : AncsCstmsTransCntrVO
*Open Issues :
*Change history :
*@LastModifyDate : 2014.12.08
*@LastModifier : 
*@LastVersion : 1.0
* 2014.12.08  
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.ancs.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;

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

public class AncsCstmsTransCntrVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<AncsCstmsTransCntrVO> models = new ArrayList<AncsCstmsTransCntrVO>();
	
	/* Column Info */
	private String cntrWgt = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String cntrNo = null;
	/* Column Info */
	private String rdTerm = null;
	/* Column Info */
	private String cntrFm = null;
	/* Column Info */
	private String cntrTs = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public AncsCstmsTransCntrVO() {}

	public AncsCstmsTransCntrVO(String ibflag, String pagerows, String cntrNo, String cntrTs, String cntrFm, String cntrWgt, String rdTerm) {
		this.cntrWgt = cntrWgt;
		this.ibflag = ibflag;
		this.cntrNo = cntrNo;
		this.rdTerm = rdTerm;
		this.cntrFm = cntrFm;
		this.cntrTs = cntrTs;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("cntr_wgt", getCntrWgt());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cntr_no", getCntrNo());
		this.hashColumns.put("rd_term", getRdTerm());
		this.hashColumns.put("cntr_fm", getCntrFm());
		this.hashColumns.put("cntr_ts", getCntrTs());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("cntr_wgt", "cntrWgt");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cntr_no", "cntrNo");
		this.hashFields.put("rd_term", "rdTerm");
		this.hashFields.put("cntr_fm", "cntrFm");
		this.hashFields.put("cntr_ts", "cntrTs");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return cntrWgt
	 */
	public String getCntrWgt() {
		return this.cntrWgt;
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
	 * @return cntrNo
	 */
	public String getCntrNo() {
		return this.cntrNo;
	}
	
	/**
	 * Column Info
	 * @return rdTerm
	 */
	public String getRdTerm() {
		return this.rdTerm;
	}
	
	/**
	 * Column Info
	 * @return cntrFm
	 */
	public String getCntrFm() {
		return this.cntrFm;
	}
	
	/**
	 * Column Info
	 * @return cntrTs
	 */
	public String getCntrTs() {
		return this.cntrTs;
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
	 * @param cntrWgt
	 */
	public void setCntrWgt(String cntrWgt) {
		this.cntrWgt = cntrWgt;
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
	 * @param cntrNo
	 */
	public void setCntrNo(String cntrNo) {
		this.cntrNo = cntrNo;
	}
	
	/**
	 * Column Info
	 * @param rdTerm
	 */
	public void setRdTerm(String rdTerm) {
		this.rdTerm = rdTerm;
	}
	
	/**
	 * Column Info
	 * @param cntrFm
	 */
	public void setCntrFm(String cntrFm) {
		this.cntrFm = cntrFm;
	}
	
	/**
	 * Column Info
	 * @param cntrTs
	 */
	public void setCntrTs(String cntrTs) {
		this.cntrTs = cntrTs;
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
		setCntrWgt(JSPUtil.getParameter(request, prefix + "cntr_wgt", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setCntrNo(JSPUtil.getParameter(request, prefix + "cntr_no", ""));
		setRdTerm(JSPUtil.getParameter(request, prefix + "rd_term", ""));
		setCntrFm(JSPUtil.getParameter(request, prefix + "cntr_fm", ""));
		setCntrTs(JSPUtil.getParameter(request, prefix + "cntr_ts", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return AncsCstmsTransCntrVO[]
	 */
	public AncsCstmsTransCntrVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return AncsCstmsTransCntrVO[]
	 */
	public AncsCstmsTransCntrVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		AncsCstmsTransCntrVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] cntrWgt = (JSPUtil.getParameter(request, prefix	+ "cntr_wgt", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] cntrNo = (JSPUtil.getParameter(request, prefix	+ "cntr_no", length));
			String[] rdTerm = (JSPUtil.getParameter(request, prefix	+ "rd_term", length));
			String[] cntrFm = (JSPUtil.getParameter(request, prefix	+ "cntr_fm", length));
			String[] cntrTs = (JSPUtil.getParameter(request, prefix	+ "cntr_ts", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new AncsCstmsTransCntrVO();
				if (cntrWgt[i] != null)
					model.setCntrWgt(cntrWgt[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (cntrNo[i] != null)
					model.setCntrNo(cntrNo[i]);
				if (rdTerm[i] != null)
					model.setRdTerm(rdTerm[i]);
				if (cntrFm[i] != null)
					model.setCntrFm(cntrFm[i]);
				if (cntrTs[i] != null)
					model.setCntrTs(cntrTs[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getAncsCstmsTransCntrVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return AncsCstmsTransCntrVO[]
	 */
	public AncsCstmsTransCntrVO[] getAncsCstmsTransCntrVOs(){
		AncsCstmsTransCntrVO[] vos = (AncsCstmsTransCntrVO[])models.toArray(new AncsCstmsTransCntrVO[models.size()]);
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
		this.cntrWgt = this.cntrWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo = this.cntrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rdTerm = this.rdTerm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrFm = this.cntrFm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTs = this.cntrTs .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
