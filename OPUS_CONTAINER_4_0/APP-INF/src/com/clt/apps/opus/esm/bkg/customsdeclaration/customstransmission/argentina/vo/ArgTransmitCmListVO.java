/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : ArgTransmitCmListVO.java
*@FileTitle : ArgTransmitCmListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2015.01.02
*@LastModifier : 김민정
*@LastVersion : 1.0
* 2015.01.02 김민정 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.argentina.vo;

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
 * @author 김민정
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class ArgTransmitCmListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<ArgTransmitCmListVO> models = new ArrayList<ArgTransmitCmListVO>();
	
	/* Column Info */
	private String cmMarkno = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String cmDesc = null;
	/* Column Info */
	private String cmCntrnbr = null;
	/* Column Info */
	private String cmCntrsize = null;
	/* Column Info */
	private String cmHscode = null;
	/* Column Info */
	private String cmWgtUnit = null;
	/* Column Info */
	private String cmWgt = null;
	/* Column Info */
	private String cmPkg = null;
	/* Column Info */
	private String cmPkgu = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public ArgTransmitCmListVO() {}

	public ArgTransmitCmListVO(String ibflag, String pagerows, String cmPkg, String cmPkgu, String cmWgt, String cmWgtUnit, String cmHscode, String cmDesc, String cmMarkno, String cmCntrnbr, String cmCntrsize) {
		this.cmMarkno = cmMarkno;
		this.ibflag = ibflag;
		this.cmDesc = cmDesc;
		this.cmCntrnbr = cmCntrnbr;
		this.cmCntrsize = cmCntrsize;
		this.cmHscode = cmHscode;
		this.cmWgtUnit = cmWgtUnit;
		this.cmWgt = cmWgt;
		this.cmPkg = cmPkg;
		this.cmPkgu = cmPkgu;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("cm_markno", getCmMarkno());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cm_desc", getCmDesc());
		this.hashColumns.put("cm_cntrnbr", getCmCntrnbr());
		this.hashColumns.put("cm_cntrsize", getCmCntrsize());
		this.hashColumns.put("cm_hscode", getCmHscode());
		this.hashColumns.put("cm_wgt_unit", getCmWgtUnit());
		this.hashColumns.put("cm_wgt", getCmWgt());
		this.hashColumns.put("cm_pkg", getCmPkg());
		this.hashColumns.put("cm_pkgu", getCmPkgu());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("cm_markno", "cmMarkno");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cm_desc", "cmDesc");
		this.hashFields.put("cm_cntrnbr", "cmCntrnbr");
		this.hashFields.put("cm_cntrsize", "cmCntrsize");
		this.hashFields.put("cm_hscode", "cmHscode");
		this.hashFields.put("cm_wgt_unit", "cmWgtUnit");
		this.hashFields.put("cm_wgt", "cmWgt");
		this.hashFields.put("cm_pkg", "cmPkg");
		this.hashFields.put("cm_pkgu", "cmPkgu");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return cmMarkno
	 */
	public String getCmMarkno() {
		return this.cmMarkno;
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
	 * @return cmDesc
	 */
	public String getCmDesc() {
		return this.cmDesc;
	}
	
	/**
	 * Column Info
	 * @return cmCntrnbr
	 */
	public String getCmCntrnbr() {
		return this.cmCntrnbr;
	}
	
	/**
	 * Column Info
	 * @return cmCntrsize
	 */
	public String getCmCntrsize() {
		return this.cmCntrsize;
	}
	
	/**
	 * Column Info
	 * @return cmHscode
	 */
	public String getCmHscode() {
		return this.cmHscode;
	}
	
	/**
	 * Column Info
	 * @return cmWgtUnit
	 */
	public String getCmWgtUnit() {
		return this.cmWgtUnit;
	}
	
	/**
	 * Column Info
	 * @return cmWgt
	 */
	public String getCmWgt() {
		return this.cmWgt;
	}
	
	/**
	 * Column Info
	 * @return cmPkg
	 */
	public String getCmPkg() {
		return this.cmPkg;
	}
	
	/**
	 * Column Info
	 * @return cmPkgu
	 */
	public String getCmPkgu() {
		return this.cmPkgu;
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
	 * @param cmMarkno
	 */
	public void setCmMarkno(String cmMarkno) {
		this.cmMarkno = cmMarkno;
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
	 * @param cmDesc
	 */
	public void setCmDesc(String cmDesc) {
		this.cmDesc = cmDesc;
	}
	
	/**
	 * Column Info
	 * @param cmCntrnbr
	 */
	public void setCmCntrnbr(String cmCntrnbr) {
		this.cmCntrnbr = cmCntrnbr;
	}
	
	/**
	 * Column Info
	 * @param cmCntrsize
	 */
	public void setCmCntrsize(String cmCntrsize) {
		this.cmCntrsize = cmCntrsize;
	}
	
	/**
	 * Column Info
	 * @param cmHscode
	 */
	public void setCmHscode(String cmHscode) {
		this.cmHscode = cmHscode;
	}
	
	/**
	 * Column Info
	 * @param cmWgtUnit
	 */
	public void setCmWgtUnit(String cmWgtUnit) {
		this.cmWgtUnit = cmWgtUnit;
	}
	
	/**
	 * Column Info
	 * @param cmWgt
	 */
	public void setCmWgt(String cmWgt) {
		this.cmWgt = cmWgt;
	}
	
	/**
	 * Column Info
	 * @param cmPkg
	 */
	public void setCmPkg(String cmPkg) {
		this.cmPkg = cmPkg;
	}
	
	/**
	 * Column Info
	 * @param cmPkgu
	 */
	public void setCmPkgu(String cmPkgu) {
		this.cmPkgu = cmPkgu;
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
		setCmMarkno(JSPUtil.getParameter(request, prefix + "cm_markno", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setCmDesc(JSPUtil.getParameter(request, prefix + "cm_desc", ""));
		setCmCntrnbr(JSPUtil.getParameter(request, prefix + "cm_cntrnbr", ""));
		setCmCntrsize(JSPUtil.getParameter(request, prefix + "cm_cntrsize", ""));
		setCmHscode(JSPUtil.getParameter(request, prefix + "cm_hscode", ""));
		setCmWgtUnit(JSPUtil.getParameter(request, prefix + "cm_wgt_unit", ""));
		setCmWgt(JSPUtil.getParameter(request, prefix + "cm_wgt", ""));
		setCmPkg(JSPUtil.getParameter(request, prefix + "cm_pkg", ""));
		setCmPkgu(JSPUtil.getParameter(request, prefix + "cm_pkgu", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return ArgTransmitCmListVO[]
	 */
	public ArgTransmitCmListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return ArgTransmitCmListVO[]
	 */
	public ArgTransmitCmListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		ArgTransmitCmListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] cmMarkno = (JSPUtil.getParameter(request, prefix	+ "cm_markno", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] cmDesc = (JSPUtil.getParameter(request, prefix	+ "cm_desc", length));
			String[] cmCntrnbr = (JSPUtil.getParameter(request, prefix	+ "cm_cntrnbr", length));
			String[] cmCntrsize = (JSPUtil.getParameter(request, prefix	+ "cm_cntrsize", length));
			String[] cmHscode = (JSPUtil.getParameter(request, prefix	+ "cm_hscode", length));
			String[] cmWgtUnit = (JSPUtil.getParameter(request, prefix	+ "cm_wgt_unit", length));
			String[] cmWgt = (JSPUtil.getParameter(request, prefix	+ "cm_wgt", length));
			String[] cmPkg = (JSPUtil.getParameter(request, prefix	+ "cm_pkg", length));
			String[] cmPkgu = (JSPUtil.getParameter(request, prefix	+ "cm_pkgu", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new ArgTransmitCmListVO();
				if (cmMarkno[i] != null)
					model.setCmMarkno(cmMarkno[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (cmDesc[i] != null)
					model.setCmDesc(cmDesc[i]);
				if (cmCntrnbr[i] != null)
					model.setCmCntrnbr(cmCntrnbr[i]);
				if (cmCntrsize[i] != null)
					model.setCmCntrsize(cmCntrsize[i]);
				if (cmHscode[i] != null)
					model.setCmHscode(cmHscode[i]);
				if (cmWgtUnit[i] != null)
					model.setCmWgtUnit(cmWgtUnit[i]);
				if (cmWgt[i] != null)
					model.setCmWgt(cmWgt[i]);
				if (cmPkg[i] != null)
					model.setCmPkg(cmPkg[i]);
				if (cmPkgu[i] != null)
					model.setCmPkgu(cmPkgu[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getArgTransmitCmListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return ArgTransmitCmListVO[]
	 */
	public ArgTransmitCmListVO[] getArgTransmitCmListVOs(){
		ArgTransmitCmListVO[] vos = (ArgTransmitCmListVO[])models.toArray(new ArgTransmitCmListVO[models.size()]);
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
		this.cmMarkno = this.cmMarkno .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmDesc = this.cmDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmCntrnbr = this.cmCntrnbr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmCntrsize = this.cmCntrsize .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmHscode = this.cmHscode .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmWgtUnit = this.cmWgtUnit .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmWgt = this.cmWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmPkg = this.cmPkg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmPkgu = this.cmPkgu .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
