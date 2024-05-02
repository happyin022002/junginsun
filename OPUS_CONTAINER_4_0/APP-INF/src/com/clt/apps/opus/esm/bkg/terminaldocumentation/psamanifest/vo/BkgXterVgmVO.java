/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : BkgXterVgmVO.java
*@FileTitle : BkgXterVgmVO
*Open Issues :
*Change history :
*@LastModifyDate : 2016.06.24
*@LastModifier : 
*@LastVersion : 1.0
* 2016.06.24  
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.terminaldocumentation.psamanifest.vo;

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

public class BkgXterVgmVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<BkgXterVgmVO> models = new ArrayList<BkgXterVgmVO>();
	
	/* Column Info */
	private String vgmDocTp = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String measTp = null;
	/* Column Info */
	private String custCntcNm = null;
	/* Column Info */
	private String docId = null;
	/* Column Info */
	private String xterVgmWgt = null;
	/* Column Info */
	private String custCntcTp = null;
	/* Column Info */
	private String vgmHndlDt = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public BkgXterVgmVO() {}

	public BkgXterVgmVO(String ibflag, String pagerows, String docId, String measTp, String vgmHndlDt, String xterVgmWgt, String vgmDocTp, String custCntcTp, String custCntcNm) {
		this.vgmDocTp = vgmDocTp;
		this.ibflag = ibflag;
		this.measTp = measTp;
		this.custCntcNm = custCntcNm;
		this.docId = docId;
		this.xterVgmWgt = xterVgmWgt;
		this.custCntcTp = custCntcTp;
		this.vgmHndlDt = vgmHndlDt;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("vgm_doc_tp", getVgmDocTp());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("meas_tp", getMeasTp());
		this.hashColumns.put("cust_cntc_nm", getCustCntcNm());
		this.hashColumns.put("doc_id", getDocId());
		this.hashColumns.put("xter_vgm_wgt", getXterVgmWgt());
		this.hashColumns.put("cust_cntc_tp", getCustCntcTp());
		this.hashColumns.put("vgm_hndl_dt", getVgmHndlDt());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("vgm_doc_tp", "vgmDocTp");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("meas_tp", "measTp");
		this.hashFields.put("cust_cntc_nm", "custCntcNm");
		this.hashFields.put("doc_id", "docId");
		this.hashFields.put("xter_vgm_wgt", "xterVgmWgt");
		this.hashFields.put("cust_cntc_tp", "custCntcTp");
		this.hashFields.put("vgm_hndl_dt", "vgmHndlDt");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return vgmDocTp
	 */
	public String getVgmDocTp() {
		return this.vgmDocTp;
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
	 * @return measTp
	 */
	public String getMeasTp() {
		return this.measTp;
	}
	
	/**
	 * Column Info
	 * @return custCntcNm
	 */
	public String getCustCntcNm() {
		return this.custCntcNm;
	}
	
	/**
	 * Column Info
	 * @return docId
	 */
	public String getDocId() {
		return this.docId;
	}
	
	/**
	 * Column Info
	 * @return xterVgmWgt
	 */
	public String getXterVgmWgt() {
		return this.xterVgmWgt;
	}
	
	/**
	 * Column Info
	 * @return custCntcTp
	 */
	public String getCustCntcTp() {
		return this.custCntcTp;
	}
	
	/**
	 * Column Info
	 * @return vgmHndlDt
	 */
	public String getVgmHndlDt() {
		return this.vgmHndlDt;
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
	 * @param vgmDocTp
	 */
	public void setVgmDocTp(String vgmDocTp) {
		this.vgmDocTp = vgmDocTp;
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
	 * @param measTp
	 */
	public void setMeasTp(String measTp) {
		this.measTp = measTp;
	}
	
	/**
	 * Column Info
	 * @param custCntcNm
	 */
	public void setCustCntcNm(String custCntcNm) {
		this.custCntcNm = custCntcNm;
	}
	
	/**
	 * Column Info
	 * @param docId
	 */
	public void setDocId(String docId) {
		this.docId = docId;
	}
	
	/**
	 * Column Info
	 * @param xterVgmWgt
	 */
	public void setXterVgmWgt(String xterVgmWgt) {
		this.xterVgmWgt = xterVgmWgt;
	}
	
	/**
	 * Column Info
	 * @param custCntcTp
	 */
	public void setCustCntcTp(String custCntcTp) {
		this.custCntcTp = custCntcTp;
	}
	
	/**
	 * Column Info
	 * @param vgmHndlDt
	 */
	public void setVgmHndlDt(String vgmHndlDt) {
		this.vgmHndlDt = vgmHndlDt;
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
		setVgmDocTp(JSPUtil.getParameter(request, prefix + "vgm_doc_tp", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setMeasTp(JSPUtil.getParameter(request, prefix + "meas_tp", ""));
		setCustCntcNm(JSPUtil.getParameter(request, prefix + "cust_cntc_nm", ""));
		setDocId(JSPUtil.getParameter(request, prefix + "doc_id", ""));
		setXterVgmWgt(JSPUtil.getParameter(request, prefix + "xter_vgm_wgt", ""));
		setCustCntcTp(JSPUtil.getParameter(request, prefix + "cust_cntc_tp", ""));
		setVgmHndlDt(JSPUtil.getParameter(request, prefix + "vgm_hndl_dt", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return BkgXterVgmVO[]
	 */
	public BkgXterVgmVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return BkgXterVgmVO[]
	 */
	public BkgXterVgmVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		BkgXterVgmVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] vgmDocTp = (JSPUtil.getParameter(request, prefix	+ "vgm_doc_tp", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] measTp = (JSPUtil.getParameter(request, prefix	+ "meas_tp", length));
			String[] custCntcNm = (JSPUtil.getParameter(request, prefix	+ "cust_cntc_nm", length));
			String[] docId = (JSPUtil.getParameter(request, prefix	+ "doc_id", length));
			String[] xterVgmWgt = (JSPUtil.getParameter(request, prefix	+ "xter_vgm_wgt", length));
			String[] custCntcTp = (JSPUtil.getParameter(request, prefix	+ "cust_cntc_tp", length));
			String[] vgmHndlDt = (JSPUtil.getParameter(request, prefix	+ "vgm_hndl_dt", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new BkgXterVgmVO();
				if (vgmDocTp[i] != null)
					model.setVgmDocTp(vgmDocTp[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (measTp[i] != null)
					model.setMeasTp(measTp[i]);
				if (custCntcNm[i] != null)
					model.setCustCntcNm(custCntcNm[i]);
				if (docId[i] != null)
					model.setDocId(docId[i]);
				if (xterVgmWgt[i] != null)
					model.setXterVgmWgt(xterVgmWgt[i]);
				if (custCntcTp[i] != null)
					model.setCustCntcTp(custCntcTp[i]);
				if (vgmHndlDt[i] != null)
					model.setVgmHndlDt(vgmHndlDt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getBkgXterVgmVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return BkgXterVgmVO[]
	 */
	public BkgXterVgmVO[] getBkgXterVgmVOs(){
		BkgXterVgmVO[] vos = (BkgXterVgmVO[])models.toArray(new BkgXterVgmVO[models.size()]);
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
		this.vgmDocTp = this.vgmDocTp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.measTp = this.measTp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custCntcNm = this.custCntcNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.docId = this.docId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.xterVgmWgt = this.xterVgmWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custCntcTp = this.custCntcTp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vgmHndlDt = this.vgmHndlDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
