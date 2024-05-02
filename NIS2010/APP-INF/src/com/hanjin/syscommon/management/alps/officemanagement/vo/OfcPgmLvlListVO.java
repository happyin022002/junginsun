/*=========================================================
*Copyright(c) 2011 CyberLogitec 
*@FileName : OfcPgmLvlListVO.java
*@FileTitle : OfcPgmLvlListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2011.12.16
*@LastModifier : 
*@LastVersion : 1.0
* 2011.12.16  
* 1.0 Creation
=========================================================*/

package com.hanjin.syscommon.management.alps.officemanagement.vo;

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

public class OfcPgmLvlListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<OfcPgmLvlListVO> models = new ArrayList<OfcPgmLvlListVO>();
	
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String pgmOfcLvlCd = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public OfcPgmLvlListVO() {}

	public OfcPgmLvlListVO(String ibflag, String pagerows, String pgmOfcLvlCd) {
		this.ibflag = ibflag;
		this.pgmOfcLvlCd = pgmOfcLvlCd;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("pgm_ofc_lvl_cd", getPgmOfcLvlCd());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("pgm_ofc_lvl_cd", "pgmOfcLvlCd");
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
	 * @return pgmOfcLvlCd
	 */
	public String getPgmOfcLvlCd() {
		return this.pgmOfcLvlCd;
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
	 * @param pgmOfcLvlCd
	 */
	public void setPgmOfcLvlCd(String pgmOfcLvlCd) {
		this.pgmOfcLvlCd = pgmOfcLvlCd;
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
	 * @param HttpServletRequest request
	 * @param String prefix
	 */
	public void fromRequest(HttpServletRequest request, String prefix) {
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setPgmOfcLvlCd(JSPUtil.getParameter(request, prefix + "pgm_ofc_lvl_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return OfcPgmLvlListVO[]
	 */
	public OfcPgmLvlListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return OfcPgmLvlListVO[]
	 */
	public OfcPgmLvlListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		OfcPgmLvlListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] pgmOfcLvlCd = (JSPUtil.getParameter(request, prefix	+ "pgm_ofc_lvl_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new OfcPgmLvlListVO();
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (pgmOfcLvlCd[i] != null)
					model.setPgmOfcLvlCd(pgmOfcLvlCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getOfcPgmLvlListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return OfcPgmLvlListVO[]
	 */
	public OfcPgmLvlListVO[] getOfcPgmLvlListVOs(){
		OfcPgmLvlListVO[] vos = (OfcPgmLvlListVO[])models.toArray(new OfcPgmLvlListVO[models.size()]);
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
		this.pgmOfcLvlCd = this.pgmOfcLvlCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
