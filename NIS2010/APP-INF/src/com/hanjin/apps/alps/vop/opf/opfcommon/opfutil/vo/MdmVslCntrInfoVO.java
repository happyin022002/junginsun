/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : MdmVslCntrInfoVO.java
*@FileTitle : MdmVslCntrInfoVO
*Open Issues :
*Change history :
*@LastModifyDate : 2011.03.25
*@LastModifier : 
*@LastVersion : 1.0
* 2011.03.25  
* 1.0 Creation
* 2011.04.01 공창식 [CHM-201109535-01] SDMS Damage Creation 변경 요청사항
=========================================================*/

package com.hanjin.apps.alps.vop.opf.opfcommon.opfutil.vo;

import java.lang.reflect.Field;
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

public class MdmVslCntrInfoVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<MdmVslCntrInfoVO> models = new ArrayList<MdmVslCntrInfoVO>();
	
	/* Column Info */
	private String vslCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String vslOshpCntrBlkTpCd = null;
	/* Column Info */
	private String vslOshpCntrBlkTpCdDesc = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public MdmVslCntrInfoVO() {}

	public MdmVslCntrInfoVO(String ibflag, String pagerows, String vslCd, String vslOshpCntrBlkTpCd, String vslOshpCntrBlkTpCdDesc) {
		this.vslCd = vslCd;
		this.ibflag = ibflag;
		this.vslOshpCntrBlkTpCd = vslOshpCntrBlkTpCd;
		this.vslOshpCntrBlkTpCdDesc = vslOshpCntrBlkTpCdDesc;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("vsl_cd", getVslCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("vsl_oshp_cntr_blk_tp_cd", getVslOshpCntrBlkTpCd());
		this.hashColumns.put("vsl_oshp_cntr_blk_tp_cd_desc", getVslOshpCntrBlkTpCdDesc());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("vsl_cd", "vslCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("vsl_oshp_cntr_blk_tp_cd", "vslOshpCntrBlkTpCd");
		this.hashFields.put("vsl_oshp_cntr_blk_tp_cd_desc", "vslOshpCntrBlkTpCdDesc");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return vslCd
	 */
	public String getVslCd() {
		return this.vslCd;
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
	 * @return vslOshpCntrBlkTpCd
	 */
	public String getVslOshpCntrBlkTpCd() {
		return this.vslOshpCntrBlkTpCd;
	}
	
	/**
	 * Column Info
	 * @return vslOshpCntrBlkTpCdDesc
	 */
	public String getVslOshpCntrBlkTpCdDesc() {
		return this.vslOshpCntrBlkTpCdDesc;
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
	 * @param vslCd
	 */
	public void setVslCd(String vslCd) {
		this.vslCd = vslCd;
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
	 * @param vslOshpCntrBlkTpCd
	 */
	public void setVslOshpCntrBlkTpCd(String vslOshpCntrBlkTpCd) {
		this.vslOshpCntrBlkTpCd = vslOshpCntrBlkTpCd;
	}
	
	/**
	 * Column Info
	 * @param vslOshpCntrBlkTpCdDesc
	 */
	public void setVslOshpCntrBlkTpCdDesc(String vslOshpCntrBlkTpCdDesc) {
		this.vslOshpCntrBlkTpCdDesc = vslOshpCntrBlkTpCdDesc;
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
		setVslCd(JSPUtil.getParameter(request, prefix + "vsl_cd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setVslOshpCntrBlkTpCd(JSPUtil.getParameter(request, prefix + "vsl_oshp_cntr_blk_tp_cd", ""));
		setVslOshpCntrBlkTpCdDesc(JSPUtil.getParameter(request, prefix + "vsl_oshp_cntr_blk_tp_cd_desc", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return MdmVslCntrInfoVO[]
	 */
	public MdmVslCntrInfoVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return MdmVslCntrInfoVO[]
	 */
	public MdmVslCntrInfoVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		MdmVslCntrInfoVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] vslCd = (JSPUtil.getParameter(request, prefix	+ "vsl_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] vslOshpCntrBlkTpCd = (JSPUtil.getParameter(request, prefix	+ "vsl_oshp_cntr_blk_tp_cd", length));
			String[] vslOshpCntrBlkTpCdDesc = (JSPUtil.getParameter(request, prefix	+ "vsl_oshp_cntr_blk_tp_cd_desc", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new MdmVslCntrInfoVO();
				if (vslCd[i] != null)
					model.setVslCd(vslCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (vslOshpCntrBlkTpCd[i] != null)
					model.setVslOshpCntrBlkTpCd(vslOshpCntrBlkTpCd[i]);
				if (vslOshpCntrBlkTpCdDesc[i] != null)
					model.setVslOshpCntrBlkTpCdDesc(vslOshpCntrBlkTpCdDesc[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getMdmVslCntrInfoVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return MdmVslCntrInfoVO[]
	 */
	public MdmVslCntrInfoVO[] getMdmVslCntrInfoVOs(){
		MdmVslCntrInfoVO[] vos = (MdmVslCntrInfoVO[])models.toArray(new MdmVslCntrInfoVO[models.size()]);
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
		this.vslCd = this.vslCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslOshpCntrBlkTpCd = this.vslOshpCntrBlkTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslOshpCntrBlkTpCdDesc = this.vslOshpCntrBlkTpCdDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
