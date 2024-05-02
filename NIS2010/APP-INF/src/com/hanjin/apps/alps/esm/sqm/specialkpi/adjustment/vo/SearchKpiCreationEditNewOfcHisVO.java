/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : SearchKpiCreationEditNewOfcHisVO.java
*@FileTitle : SearchKpiCreationEditNewOfcHisVO
*Open Issues :
*Change history :
*@LastModifyDate : 2013.09.11
*@LastModifier : 
*@LastVersion : 1.0
* 2013.09.11  
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.sqm.specialkpi.adjustment.vo;

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

public class SearchKpiCreationEditNewOfcHisVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchKpiCreationEditNewOfcHisVO> models = new ArrayList<SearchKpiCreationEditNewOfcHisVO>();
	
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String rhqCd = null;
	/* Column Info */
	private String convDirCd = null;
	/* Column Info */
	private String trdCd = null;
	/* Column Info */
	private String rlaneCd = null;
	/* Column Info */
	private String dirCd = null;
	/* Column Info */
	private String rgnOfcCd = null;
	/* Column Info */
	private String srcRhqCd = null;
	/* Column Info */
	private String qtaFlag = null;
	/* Column Info */
	private String srcRgnOfcCd = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SearchKpiCreationEditNewOfcHisVO() {}

	public SearchKpiCreationEditNewOfcHisVO(String ibflag, String pagerows, String trdCd, String dirCd, String convDirCd, String rlaneCd, String rhqCd, String rgnOfcCd, String srcRhqCd, String srcRgnOfcCd, String qtaFlag) {
		this.ibflag = ibflag;
		this.rhqCd = rhqCd;
		this.convDirCd = convDirCd;
		this.trdCd = trdCd;
		this.rlaneCd = rlaneCd;
		this.dirCd = dirCd;
		this.rgnOfcCd = rgnOfcCd;
		this.srcRhqCd = srcRhqCd;
		this.qtaFlag = qtaFlag;
		this.srcRgnOfcCd = srcRgnOfcCd;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("rhq_cd", getRhqCd());
		this.hashColumns.put("conv_dir_cd", getConvDirCd());
		this.hashColumns.put("trd_cd", getTrdCd());
		this.hashColumns.put("rlane_cd", getRlaneCd());
		this.hashColumns.put("dir_cd", getDirCd());
		this.hashColumns.put("rgn_ofc_cd", getRgnOfcCd());
		this.hashColumns.put("src_rhq_cd", getSrcRhqCd());
		this.hashColumns.put("qta_flag", getQtaFlag());
		this.hashColumns.put("src_rgn_ofc_cd", getSrcRgnOfcCd());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("rhq_cd", "rhqCd");
		this.hashFields.put("conv_dir_cd", "convDirCd");
		this.hashFields.put("trd_cd", "trdCd");
		this.hashFields.put("rlane_cd", "rlaneCd");
		this.hashFields.put("dir_cd", "dirCd");
		this.hashFields.put("rgn_ofc_cd", "rgnOfcCd");
		this.hashFields.put("src_rhq_cd", "srcRhqCd");
		this.hashFields.put("qta_flag", "qtaFlag");
		this.hashFields.put("src_rgn_ofc_cd", "srcRgnOfcCd");
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
	 * @return rhqCd
	 */
	public String getRhqCd() {
		return this.rhqCd;
	}
	
	/**
	 * Column Info
	 * @return convDirCd
	 */
	public String getConvDirCd() {
		return this.convDirCd;
	}
	
	/**
	 * Column Info
	 * @return trdCd
	 */
	public String getTrdCd() {
		return this.trdCd;
	}
	
	/**
	 * Column Info
	 * @return rlaneCd
	 */
	public String getRlaneCd() {
		return this.rlaneCd;
	}
	
	/**
	 * Column Info
	 * @return dirCd
	 */
	public String getDirCd() {
		return this.dirCd;
	}
	
	/**
	 * Column Info
	 * @return rgnOfcCd
	 */
	public String getRgnOfcCd() {
		return this.rgnOfcCd;
	}
	
	/**
	 * Column Info
	 * @return srcRhqCd
	 */
	public String getSrcRhqCd() {
		return this.srcRhqCd;
	}
	
	/**
	 * Column Info
	 * @return qtaFlag
	 */
	public String getQtaFlag() {
		return this.qtaFlag;
	}
	
	/**
	 * Column Info
	 * @return srcRgnOfcCd
	 */
	public String getSrcRgnOfcCd() {
		return this.srcRgnOfcCd;
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
	 * @param rhqCd
	 */
	public void setRhqCd(String rhqCd) {
		this.rhqCd = rhqCd;
	}
	
	/**
	 * Column Info
	 * @param convDirCd
	 */
	public void setConvDirCd(String convDirCd) {
		this.convDirCd = convDirCd;
	}
	
	/**
	 * Column Info
	 * @param trdCd
	 */
	public void setTrdCd(String trdCd) {
		this.trdCd = trdCd;
	}
	
	/**
	 * Column Info
	 * @param rlaneCd
	 */
	public void setRlaneCd(String rlaneCd) {
		this.rlaneCd = rlaneCd;
	}
	
	/**
	 * Column Info
	 * @param dirCd
	 */
	public void setDirCd(String dirCd) {
		this.dirCd = dirCd;
	}
	
	/**
	 * Column Info
	 * @param rgnOfcCd
	 */
	public void setRgnOfcCd(String rgnOfcCd) {
		this.rgnOfcCd = rgnOfcCd;
	}
	
	/**
	 * Column Info
	 * @param srcRhqCd
	 */
	public void setSrcRhqCd(String srcRhqCd) {
		this.srcRhqCd = srcRhqCd;
	}
	
	/**
	 * Column Info
	 * @param qtaFlag
	 */
	public void setQtaFlag(String qtaFlag) {
		this.qtaFlag = qtaFlag;
	}
	
	/**
	 * Column Info
	 * @param srcRgnOfcCd
	 */
	public void setSrcRgnOfcCd(String srcRgnOfcCd) {
		this.srcRgnOfcCd = srcRgnOfcCd;
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
		setRhqCd(JSPUtil.getParameter(request, prefix + "rhq_cd", ""));
		setConvDirCd(JSPUtil.getParameter(request, prefix + "conv_dir_cd", ""));
		setTrdCd(JSPUtil.getParameter(request, prefix + "trd_cd", ""));
		setRlaneCd(JSPUtil.getParameter(request, prefix + "rlane_cd", ""));
		setDirCd(JSPUtil.getParameter(request, prefix + "dir_cd", ""));
		setRgnOfcCd(JSPUtil.getParameter(request, prefix + "rgn_ofc_cd", ""));
		setSrcRhqCd(JSPUtil.getParameter(request, prefix + "src_rhq_cd", ""));
		setQtaFlag(JSPUtil.getParameter(request, prefix + "qta_flag", ""));
		setSrcRgnOfcCd(JSPUtil.getParameter(request, prefix + "src_rgn_ofc_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchKpiCreationEditNewOfcHisVO[]
	 */
	public SearchKpiCreationEditNewOfcHisVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchKpiCreationEditNewOfcHisVO[]
	 */
	public SearchKpiCreationEditNewOfcHisVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchKpiCreationEditNewOfcHisVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] rhqCd = (JSPUtil.getParameter(request, prefix	+ "rhq_cd", length));
			String[] convDirCd = (JSPUtil.getParameter(request, prefix	+ "conv_dir_cd", length));
			String[] trdCd = (JSPUtil.getParameter(request, prefix	+ "trd_cd", length));
			String[] rlaneCd = (JSPUtil.getParameter(request, prefix	+ "rlane_cd", length));
			String[] dirCd = (JSPUtil.getParameter(request, prefix	+ "dir_cd", length));
			String[] rgnOfcCd = (JSPUtil.getParameter(request, prefix	+ "rgn_ofc_cd", length));
			String[] srcRhqCd = (JSPUtil.getParameter(request, prefix	+ "src_rhq_cd", length));
			String[] qtaFlag = (JSPUtil.getParameter(request, prefix	+ "qta_flag", length));
			String[] srcRgnOfcCd = (JSPUtil.getParameter(request, prefix	+ "src_rgn_ofc_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchKpiCreationEditNewOfcHisVO();
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (rhqCd[i] != null)
					model.setRhqCd(rhqCd[i]);
				if (convDirCd[i] != null)
					model.setConvDirCd(convDirCd[i]);
				if (trdCd[i] != null)
					model.setTrdCd(trdCd[i]);
				if (rlaneCd[i] != null)
					model.setRlaneCd(rlaneCd[i]);
				if (dirCd[i] != null)
					model.setDirCd(dirCd[i]);
				if (rgnOfcCd[i] != null)
					model.setRgnOfcCd(rgnOfcCd[i]);
				if (srcRhqCd[i] != null)
					model.setSrcRhqCd(srcRhqCd[i]);
				if (qtaFlag[i] != null)
					model.setQtaFlag(qtaFlag[i]);
				if (srcRgnOfcCd[i] != null)
					model.setSrcRgnOfcCd(srcRgnOfcCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchKpiCreationEditNewOfcHisVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchKpiCreationEditNewOfcHisVO[]
	 */
	public SearchKpiCreationEditNewOfcHisVO[] getSearchKpiCreationEditNewOfcHisVOs(){
		SearchKpiCreationEditNewOfcHisVO[] vos = (SearchKpiCreationEditNewOfcHisVO[])models.toArray(new SearchKpiCreationEditNewOfcHisVO[models.size()]);
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
		this.rhqCd = this.rhqCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.convDirCd = this.convDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trdCd = this.trdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rlaneCd = this.rlaneCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dirCd = this.dirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rgnOfcCd = this.rgnOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.srcRhqCd = this.srcRhqCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.qtaFlag = this.qtaFlag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.srcRgnOfcCd = this.srcRgnOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
