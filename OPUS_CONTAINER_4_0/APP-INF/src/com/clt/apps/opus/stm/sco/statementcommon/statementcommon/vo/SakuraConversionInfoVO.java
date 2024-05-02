/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : SakuraConversionInfoVO.java
*@FileTitle : SakuraConversionInfoVO
*Open Issues :
*Change history :
*@LastModifyDate : 2014.10.17
*@LastModifier : 
*@LastVersion : 1.0
* 2014.10.17  
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.stm.sco.statementcommon.statementcommon.vo;

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

public class SakuraConversionInfoVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SakuraConversionInfoVO> models = new ArrayList<SakuraConversionInfoVO>();
	
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String luCd = null;
	/* Column Info */
	private String tgtDesc = null;
	/* Column Info */
	private String useFlag = null;
	/* Column Info */
	private String tgtCd = null;
	/* Column Info */
	private String luDesc = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public SakuraConversionInfoVO() {}

	public SakuraConversionInfoVO(String ibflag, String pagerows, String luCd, String luDesc, String tgtCd, String tgtDesc, String useFlag) {
		this.ibflag = ibflag;
		this.luCd = luCd;
		this.tgtDesc = tgtDesc;
		this.useFlag = useFlag;
		this.tgtCd = tgtCd;
		this.luDesc = luDesc;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("lu_cd", getLuCd());
		this.hashColumns.put("tgt_desc", getTgtDesc());
		this.hashColumns.put("use_flag", getUseFlag());
		this.hashColumns.put("tgt_cd", getTgtCd());
		this.hashColumns.put("lu_desc", getLuDesc());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("lu_cd", "luCd");
		this.hashFields.put("tgt_desc", "tgtDesc");
		this.hashFields.put("use_flag", "useFlag");
		this.hashFields.put("tgt_cd", "tgtCd");
		this.hashFields.put("lu_desc", "luDesc");
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
	 * @return luCd
	 */
	public String getLuCd() {
		return this.luCd;
	}
	
	/**
	 * Column Info
	 * @return tgtDesc
	 */
	public String getTgtDesc() {
		return this.tgtDesc;
	}
	
	/**
	 * Column Info
	 * @return useFlag
	 */
	public String getUseFlag() {
		return this.useFlag;
	}
	
	/**
	 * Column Info
	 * @return tgtCd
	 */
	public String getTgtCd() {
		return this.tgtCd;
	}
	
	/**
	 * Column Info
	 * @return luDesc
	 */
	public String getLuDesc() {
		return this.luDesc;
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
	 * @param luCd
	 */
	public void setLuCd(String luCd) {
		this.luCd = luCd;
	}
	
	/**
	 * Column Info
	 * @param tgtDesc
	 */
	public void setTgtDesc(String tgtDesc) {
		this.tgtDesc = tgtDesc;
	}
	
	/**
	 * Column Info
	 * @param useFlag
	 */
	public void setUseFlag(String useFlag) {
		this.useFlag = useFlag;
	}
	
	/**
	 * Column Info
	 * @param tgtCd
	 */
	public void setTgtCd(String tgtCd) {
		this.tgtCd = tgtCd;
	}
	
	/**
	 * Column Info
	 * @param luDesc
	 */
	public void setLuDesc(String luDesc) {
		this.luDesc = luDesc;
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
		setLuCd(JSPUtil.getParameter(request, prefix + "lu_cd", ""));
		setTgtDesc(JSPUtil.getParameter(request, prefix + "tgt_desc", ""));
		setUseFlag(JSPUtil.getParameter(request, prefix + "use_flag", ""));
		setTgtCd(JSPUtil.getParameter(request, prefix + "tgt_cd", ""));
		setLuDesc(JSPUtil.getParameter(request, prefix + "lu_desc", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SakuraConversionInfoVO[]
	 */
	public SakuraConversionInfoVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SakuraConversionInfoVO[]
	 */
	public SakuraConversionInfoVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SakuraConversionInfoVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] luCd = (JSPUtil.getParameter(request, prefix	+ "lu_cd", length));
			String[] tgtDesc = (JSPUtil.getParameter(request, prefix	+ "tgt_desc", length));
			String[] useFlag = (JSPUtil.getParameter(request, prefix	+ "use_flag", length));
			String[] tgtCd = (JSPUtil.getParameter(request, prefix	+ "tgt_cd", length));
			String[] luDesc = (JSPUtil.getParameter(request, prefix	+ "lu_desc", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new SakuraConversionInfoVO();
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (luCd[i] != null)
					model.setLuCd(luCd[i]);
				if (tgtDesc[i] != null)
					model.setTgtDesc(tgtDesc[i]);
				if (useFlag[i] != null)
					model.setUseFlag(useFlag[i]);
				if (tgtCd[i] != null)
					model.setTgtCd(tgtCd[i]);
				if (luDesc[i] != null)
					model.setLuDesc(luDesc[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSakuraConversionInfoVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SakuraConversionInfoVO[]
	 */
	public SakuraConversionInfoVO[] getSakuraConversionInfoVOs(){
		SakuraConversionInfoVO[] vos = (SakuraConversionInfoVO[])models.toArray(new SakuraConversionInfoVO[models.size()]);
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
		this.luCd = this.luCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tgtDesc = this.tgtDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.useFlag = this.useFlag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tgtCd = this.tgtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.luDesc = this.luDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
