/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : CmdMarkVO.java
*@FileTitle : CmdMarkVO
*Open Issues :
*Change history :
*@LastModifyDate : 2014.12.18
*@LastModifier : 
*@LastVersion : 1.0
* 2014.12.18  
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.usa.vo;

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

public class CmdMarkVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<CmdMarkVO> models = new ArrayList<CmdMarkVO>();
	
	/* Column Info */
	private String cmdMarkLen = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String mkDesc = null;
	/* Column Info */
	private String cmdMarkAll = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public CmdMarkVO() {}

	public CmdMarkVO(String ibflag, String pagerows, String cmdMarkAll, String cmdMarkLen, String mkDesc) {
		this.cmdMarkLen = cmdMarkLen;
		this.ibflag = ibflag;
		this.mkDesc = mkDesc;
		this.cmdMarkAll = cmdMarkAll;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("cmd_mark_len", getCmdMarkLen());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("mk_desc", getMkDesc());
		this.hashColumns.put("cmd_mark_all", getCmdMarkAll());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("cmd_mark_len", "cmdMarkLen");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("mk_desc", "mkDesc");
		this.hashFields.put("cmd_mark_all", "cmdMarkAll");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return cmdMarkLen
	 */
	public String getCmdMarkLen() {
		return this.cmdMarkLen;
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
	 * @return mkDesc
	 */
	public String getMkDesc() {
		return this.mkDesc;
	}
	
	/**
	 * Column Info
	 * @return cmdMarkAll
	 */
	public String getCmdMarkAll() {
		return this.cmdMarkAll;
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
	 * @param cmdMarkLen
	 */
	public void setCmdMarkLen(String cmdMarkLen) {
		this.cmdMarkLen = cmdMarkLen;
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
	 * @param mkDesc
	 */
	public void setMkDesc(String mkDesc) {
		this.mkDesc = mkDesc;
	}
	
	/**
	 * Column Info
	 * @param cmdMarkAll
	 */
	public void setCmdMarkAll(String cmdMarkAll) {
		this.cmdMarkAll = cmdMarkAll;
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
		setCmdMarkLen(JSPUtil.getParameter(request, prefix + "cmd_mark_len", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setMkDesc(JSPUtil.getParameter(request, prefix + "mk_desc", ""));
		setCmdMarkAll(JSPUtil.getParameter(request, prefix + "cmd_mark_all", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return CmdMarkVO[]
	 */
	public CmdMarkVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return CmdMarkVO[]
	 */
	public CmdMarkVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		CmdMarkVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] cmdMarkLen = (JSPUtil.getParameter(request, prefix	+ "cmd_mark_len", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] mkDesc = (JSPUtil.getParameter(request, prefix	+ "mk_desc", length));
			String[] cmdMarkAll = (JSPUtil.getParameter(request, prefix	+ "cmd_mark_all", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new CmdMarkVO();
				if (cmdMarkLen[i] != null)
					model.setCmdMarkLen(cmdMarkLen[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (mkDesc[i] != null)
					model.setMkDesc(mkDesc[i]);
				if (cmdMarkAll[i] != null)
					model.setCmdMarkAll(cmdMarkAll[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getCmdMarkVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return CmdMarkVO[]
	 */
	public CmdMarkVO[] getCmdMarkVOs(){
		CmdMarkVO[] vos = (CmdMarkVO[])models.toArray(new CmdMarkVO[models.size()]);
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
		this.cmdMarkLen = this.cmdMarkLen .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mkDesc = this.mkDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmdMarkAll = this.cmdMarkAll .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
