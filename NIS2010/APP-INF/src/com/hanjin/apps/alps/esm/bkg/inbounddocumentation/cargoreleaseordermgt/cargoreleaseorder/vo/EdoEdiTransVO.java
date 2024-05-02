/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EdoEdiTransVO.java
*@FileTitle : EdoEdiTransVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.19
*@LastModifier : 임진영
*@LastVersion : 1.0
* 2009.10.19 임진영 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.hanjin.framework.component.common.AbstractValueObject;
import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 임진영
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class EdoEdiTransVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<EdoEdiTransVO> models = new ArrayList<EdoEdiTransVO>();
	
	private SignOnUserAccount acount = null;
	/* Column Info */
	private String bkgNo = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String rejRmk = null;
	/* Column Info */
	private String rqstNo = null;
	/* Column Info */
	private String edoAckCd = null;
	/* Column Info */
	private String edoTpCd = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public EdoEdiTransVO() {}

	public EdoEdiTransVO(String ibflag, String pagerows, String rqstNo, String edoTpCd, String edoAckCd, String rejRmk, String bkgNo) {
		this.bkgNo = bkgNo;
		this.ibflag = ibflag;
		this.rejRmk = rejRmk;
		this.rqstNo = rqstNo;
		this.edoAckCd = edoAckCd;
		this.edoTpCd = edoTpCd;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("rej_rmk", getRejRmk());
		this.hashColumns.put("rqst_no", getRqstNo());
		this.hashColumns.put("edo_ack_cd", getEdoAckCd());
		this.hashColumns.put("edo_tp_cd", getEdoTpCd());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("rej_rmk", "rejRmk");
		this.hashFields.put("rqst_no", "rqstNo");
		this.hashFields.put("edo_ack_cd", "edoAckCd");
		this.hashFields.put("edo_tp_cd", "edoTpCd");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return bkgNo
	 */
	public String getBkgNo() {
		return this.bkgNo;
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
	 * @return rejRmk
	 */
	public String getRejRmk() {
		return this.rejRmk;
	}
	
	/**
	 * Column Info
	 * @return rqstNo
	 */
	public String getRqstNo() {
		return this.rqstNo;
	}
	
	/**
	 * Column Info
	 * @return edoAckCd
	 */
	public String getEdoAckCd() {
		return this.edoAckCd;
	}
	
	/**
	 * Column Info
	 * @return edoTpCd
	 */
	public String getEdoTpCd() {
		return this.edoTpCd;
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
	 * @param bkgNo
	 */
	public void setBkgNo(String bkgNo) {
		this.bkgNo = bkgNo;
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
	 * @param rejRmk
	 */
	public void setRejRmk(String rejRmk) {
		this.rejRmk = rejRmk;
	}
	
	/**
	 * Column Info
	 * @param rqstNo
	 */
	public void setRqstNo(String rqstNo) {
		this.rqstNo = rqstNo;
	}
	
	/**
	 * Column Info
	 * @param edoAckCd
	 */
	public void setEdoAckCd(String edoAckCd) {
		this.edoAckCd = edoAckCd;
	}
	
	/**
	 * Column Info
	 * @param edoTpCd
	 */
	public void setEdoTpCd(String edoTpCd) {
		this.edoTpCd = edoTpCd;
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
		setBkgNo(JSPUtil.getParameter(request, "bkg_no", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setRejRmk(JSPUtil.getParameter(request, "rej_rmk", ""));
		setRqstNo(JSPUtil.getParameter(request, "rqst_no", ""));
		setEdoAckCd(JSPUtil.getParameter(request, "edo_ack_cd", ""));
		setEdoTpCd(JSPUtil.getParameter(request, "edo_tp_cd", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return EdoEdiTransVO[]
	 */
	public EdoEdiTransVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return EdoEdiTransVO[]
	 */
	public EdoEdiTransVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		EdoEdiTransVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] rejRmk = (JSPUtil.getParameter(request, prefix	+ "rej_rmk", length));
			String[] rqstNo = (JSPUtil.getParameter(request, prefix	+ "rqst_no", length));
			String[] edoAckCd = (JSPUtil.getParameter(request, prefix	+ "edo_ack_cd", length));
			String[] edoTpCd = (JSPUtil.getParameter(request, prefix	+ "edo_tp_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new EdoEdiTransVO();
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (rejRmk[i] != null)
					model.setRejRmk(rejRmk[i]);
				if (rqstNo[i] != null)
					model.setRqstNo(rqstNo[i]);
				if (edoAckCd[i] != null)
					model.setEdoAckCd(edoAckCd[i]);
				if (edoTpCd[i] != null)
					model.setEdoTpCd(edoTpCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getEdoEdiTransVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return EdoEdiTransVO[]
	 */
	public EdoEdiTransVO[] getEdoEdiTransVOs(){
		EdoEdiTransVO[] vos = (EdoEdiTransVO[])models.toArray(new EdoEdiTransVO[models.size()]);
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
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rejRmk = this.rejRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rqstNo = this.rqstNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.edoAckCd = this.edoAckCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.edoTpCd = this.edoTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}

	/**
	 * @return the acount
	 */
	public SignOnUserAccount getAcount() {
		return acount;
	}

	/**
	 * @param acount the acount to set
	 */
	public void setAcount(SignOnUserAccount acount) {
		this.acount = acount;
	}
}
