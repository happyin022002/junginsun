/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : OpfCodDvsFeeViewVO.java
*@FileTitle : OpfCodDvsFeeViewVO
*Open Issues :
*Change history :
*@LastModifyDate : 2014.04.22
*@LastModifier : 권혁정
*@LastVersion : 1.0
* 2014.04.22 권혁정 
* 1.0 Creation
*=========================================================
* History
* 2015.03.06 이병훈 [CHM-201534196] COD charges DVC 비용 관련 로직 수정
=========================================================*/

package com.hanjin.apps.alps.vop.opf.changeofdestinationmgt.changeofdestinationmgt.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.hanjin.framework.component.common.AbstractValueObject;
import com.hanjin.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 권혁정
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class OpfCodDvsFeeViewVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<OpfCodDvsFeeViewVO> models = new ArrayList<OpfCodDvsFeeViewVO>();
	
	/* Column Info */
	private String tbl = null;
	/* Column Info */
	private String contiCd = null;
	/* Column Info */
	private String t20ft = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String t40ft = null;
	/* Column Info */
	private String contiNm = null;
	/* Column Info */
	private String tbox = null;
	/* Column Info */
	private String tport = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String tboxE = null;
	/* Column Info */
	private String tboxW = null;
	/* Column Info */
	private String tblE = null;
	/* Column Info */
	private String tblW = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public OpfCodDvsFeeViewVO() {}

	public OpfCodDvsFeeViewVO(String ibflag, String pagerows, String contiNm, String contiCd, String t20ft, String t40ft, String tport, String tbox, String tbl, String tboxE, String tboxW, String tblE, String tblW) {
		this.tbl = tbl;
		this.contiCd = contiCd;
		this.t20ft = t20ft;
		this.ibflag = ibflag;
		this.t40ft = t40ft;
		this.contiNm = contiNm;
		this.tbox = tbox;
		this.tport = tport;
		this.pagerows = pagerows;
		this.tboxE = tboxE;
		this.tboxW = tboxW;
		this.tblE = tblE;
		this.tblW = tblW;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("tbl", getTbl());
		this.hashColumns.put("conti_cd", getContiCd());
		this.hashColumns.put("t20ft", getT20ft());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("t40ft", getT40ft());
		this.hashColumns.put("conti_nm", getContiNm());
		this.hashColumns.put("tbox", getTbox());
		this.hashColumns.put("tport", getTport());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("tbox_e", getTboxE());
		this.hashColumns.put("tbox_w", getTboxW());
		this.hashColumns.put("tbl_e", getTblE());
		this.hashColumns.put("tbl_w", getTblW());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("tbl", "tbl");
		this.hashFields.put("conti_cd", "contiCd");
		this.hashFields.put("t20ft", "t20ft");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("t40ft", "t40ft");
		this.hashFields.put("conti_nm", "contiNm");
		this.hashFields.put("tbox", "tbox");
		this.hashFields.put("tport", "tport");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("tbox_e", "tboxE");
		this.hashFields.put("tbox_w", "tboxW");
		this.hashFields.put("tbl_e", "tblE");
		this.hashFields.put("tbl_w", "tblW");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return tbl
	 */
	public String getTbl() {
		return this.tbl;
	}
	
	/**
	 * Column Info
	 * @return contiCd
	 */
	public String getContiCd() {
		return this.contiCd;
	}
	
	/**
	 * Column Info
	 * @return t20ft
	 */
	public String getT20ft() {
		return this.t20ft;
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
	 * @return t40ft
	 */
	public String getT40ft() {
		return this.t40ft;
	}
	
	/**
	 * Column Info
	 * @return contiNm
	 */
	public String getContiNm() {
		return this.contiNm;
	}
	
	/**
	 * Column Info
	 * @return tbox
	 */
	public String getTbox() {
		return this.tbox;
	}
	
	/**
	 * Column Info
	 * @return tport
	 */
	public String getTport() {
		return this.tport;
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
	 * @return tboxE
	 */
	public String getTboxE() {
		return this.tboxE;
	}
	
	/**
	 * Column Info
	 * @return tboxW
	 */
	public String getTboxW() {
		return this.tboxW;
	}
	
	/**
	 * Column Info
	 * @return tblE
	 */
	public String getTblE() {
		return this.tblE;
	}
	
	/**
	 * Column Info
	 * @return tblW
	 */
	public String getTblW() {
		return this.tblW;
	}
	

	/**
	 * Column Info
	 * @param tbl
	 */
	public void setTbl(String tbl) {
		this.tbl = tbl;
	}
	
	/**
	 * Column Info
	 * @param contiCd
	 */
	public void setContiCd(String contiCd) {
		this.contiCd = contiCd;
	}
	
	/**
	 * Column Info
	 * @param t20ft
	 */
	public void setT20ft(String t20ft) {
		this.t20ft = t20ft;
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
	 * @param t40ft
	 */
	public void setT40ft(String t40ft) {
		this.t40ft = t40ft;
	}
	
	/**
	 * Column Info
	 * @param contiNm
	 */
	public void setContiNm(String contiNm) {
		this.contiNm = contiNm;
	}
	
	/**
	 * Column Info
	 * @param tbox
	 */
	public void setTbox(String tbox) {
		this.tbox = tbox;
	}
	
	/**
	 * Column Info
	 * @param tport
	 */
	public void setTport(String tport) {
		this.tport = tport;
	}
	
	/**
	 * Page Number
	 * @param pagerows
	 */
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
	}
	
	/**
	 * Column Info
	 * @param tboxE
	 */
	public void setTboxE(String tboxE) {
		this.tboxE = tboxE;
	}
	
	/**
	 * Column Info
	 * @param tboxW
	 */
	public void setTboxW(String tboxW) {
		this.tboxW = tboxW;
	}
	
	/**
	 * Column Info
	 * @param tblE
	 */
	public void setTblE(String tblE) {
		this.tblE = tblE;
	}
	
	/**
	 * Column Info
	 * @param tblW
	 */
	public void setTblW(String tblW) {
		this.tblW = tblW;
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
		setTbl(JSPUtil.getParameter(request, prefix + "tbl", ""));
		setContiCd(JSPUtil.getParameter(request, prefix + "conti_cd", ""));
		setT20ft(JSPUtil.getParameter(request, prefix + "t20ft", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setT40ft(JSPUtil.getParameter(request, prefix + "t40ft", ""));
		setContiNm(JSPUtil.getParameter(request, prefix + "conti_nm", ""));
		setTbox(JSPUtil.getParameter(request, prefix + "tbox", ""));
		setTport(JSPUtil.getParameter(request, prefix + "tport", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setTboxE(JSPUtil.getParameter(request, prefix + "tbox_e", ""));
		setTboxW(JSPUtil.getParameter(request, prefix + "tbox_w", ""));
		setTblE(JSPUtil.getParameter(request, prefix + "tbl_e", ""));
		setTblW(JSPUtil.getParameter(request, prefix + "tbl_w", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return OpfCodDvsFeeViewVO[]
	 */
	public OpfCodDvsFeeViewVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return OpfCodDvsFeeViewVO[]
	 */
	public OpfCodDvsFeeViewVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		OpfCodDvsFeeViewVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] tbl = (JSPUtil.getParameter(request, prefix	+ "tbl", length));
			String[] contiCd = (JSPUtil.getParameter(request, prefix	+ "conti_cd", length));
			String[] t20ft = (JSPUtil.getParameter(request, prefix	+ "t20ft", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] t40ft = (JSPUtil.getParameter(request, prefix	+ "t40ft", length));
			String[] contiNm = (JSPUtil.getParameter(request, prefix	+ "conti_nm", length));
			String[] tbox = (JSPUtil.getParameter(request, prefix	+ "tbox", length));
			String[] tport = (JSPUtil.getParameter(request, prefix	+ "tport", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] tboxE = (JSPUtil.getParameter(request, prefix	+ "tbox_e", length));
			String[] tboxW = (JSPUtil.getParameter(request, prefix	+ "tbox_w", length));
			String[] tblE = (JSPUtil.getParameter(request, prefix	+ "tbl_e", length));
			String[] tblW = (JSPUtil.getParameter(request, prefix	+ "tbl_w", length));
			
			for (int i = 0; i < length; i++) {
				model = new OpfCodDvsFeeViewVO();
				if (tbl[i] != null)
					model.setTbl(tbl[i]);
				if (contiCd[i] != null)
					model.setContiCd(contiCd[i]);
				if (t20ft[i] != null)
					model.setT20ft(t20ft[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (t40ft[i] != null)
					model.setT40ft(t40ft[i]);
				if (contiNm[i] != null)
					model.setContiNm(contiNm[i]);
				if (tbox[i] != null)
					model.setTbox(tbox[i]);
				if (tport[i] != null)
					model.setTport(tport[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (tboxE[i] != null)
					model.setTboxE(tboxE[i]);
				if (tboxW[i] != null)
					model.setTboxW(tboxW[i]);
				if (tblE[i] != null)
					model.setTblE(tblE[i]);
				if (tblW[i] != null)
					model.setTblW(tblW[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getOpfCodDvsFeeViewVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return OpfCodDvsFeeViewVO[]
	 */
	public OpfCodDvsFeeViewVO[] getOpfCodDvsFeeViewVOs(){
		OpfCodDvsFeeViewVO[] vos = (OpfCodDvsFeeViewVO[])models.toArray(new OpfCodDvsFeeViewVO[models.size()]);
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
		this.tbl = this.tbl .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.contiCd = this.contiCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.t20ft = this.t20ft .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.t40ft = this.t40ft .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.contiNm = this.contiNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tbox = this.tbox .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tport = this.tport .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tboxE = this.tboxE .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tboxW = this.tboxW .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tblE = this.tblE .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tblW = this.tblW .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
