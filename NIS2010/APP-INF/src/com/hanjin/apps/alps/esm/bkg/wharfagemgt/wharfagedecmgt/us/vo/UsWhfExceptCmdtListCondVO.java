/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : UsWhfExceptCmdtListCondVO.java
*@FileTitle : UsWhfExceptCmdtListCondVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.04.14
*@LastModifier : 
*@LastVersion : 1.0
* 2010.04.14  
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.wharfagemgt.wharfagedecmgt.us.vo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.hanjin.apps.alps.esm.bkg.wharfagemgt.wharfagedecmgt.vo.WhfExceptCmdtListCondVO;
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

public class UsWhfExceptCmdtListCondVO extends WhfExceptCmdtListCondVO {

	private static final long serialVersionUID = 1L;
	
	private Collection<UsWhfExceptCmdtListCondVO> models = new ArrayList<UsWhfExceptCmdtListCondVO>();
	
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String cmdtDesc = null;
	/* Column Info */
	private String kwNm1 = null;
	/* Column Info */
	private String kwNm2 = null;
	/* Column Info */
	private String cmdtSeq = null;
	/* Column Info */
	private String portCd = null;
	/* Column Info */
	private String ioBndCd = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public UsWhfExceptCmdtListCondVO() {}

	public UsWhfExceptCmdtListCondVO(String ibflag, String pagerows, String portCd, String cmdtSeq, String kwNm1, String kwNm2, String cmdtDesc, String ioBndCd) {
		this.ibflag = ibflag;
		this.cmdtDesc = cmdtDesc;
		this.kwNm1 = kwNm1;
		this.kwNm2 = kwNm2;
		this.cmdtSeq = cmdtSeq;
		this.portCd = portCd;
		this.ioBndCd = ioBndCd;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cmdt_desc", getCmdtDesc());
		this.hashColumns.put("kw_nm1", getKwNm1());
		this.hashColumns.put("kw_nm2", getKwNm2());
		this.hashColumns.put("cmdt_seq", getCmdtSeq());
		this.hashColumns.put("port_cd", getPortCd());
		this.hashColumns.put("io_bnd_cd", getIoBndCd());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cmdt_desc", "cmdtDesc");
		this.hashFields.put("kw_nm1", "kwNm1");
		this.hashFields.put("kw_nm2", "kwNm2");
		this.hashFields.put("cmdt_seq", "cmdtSeq");
		this.hashFields.put("port_cd", "portCd");
		this.hashFields.put("io_bnd_cd", "ioBndCd");
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
	 * @return cmdtDesc
	 */
	public String getCmdtDesc() {
		return this.cmdtDesc;
	}
	
	/**
	 * Column Info
	 * @return kwNm1
	 */
	public String getKwNm1() {
		return this.kwNm1;
	}
	
	/**
	 * Column Info
	 * @return kwNm2
	 */
	public String getKwNm2() {
		return this.kwNm2;
	}
	
	/**
	 * Column Info
	 * @return cmdtSeq
	 */
	public String getCmdtSeq() {
		return this.cmdtSeq;
	}
	
	/**
	 * Column Info
	 * @return portCd
	 */
	public String getPortCd() {
		return this.portCd;
	}
	
	/**
	 * Column Info
	 * @return ioBndCd
	 */
	public String getIoBndCd() {
		return this.ioBndCd;
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
	 * @param cmdtDesc
	 */
	public void setCmdtDesc(String cmdtDesc) {
		this.cmdtDesc = cmdtDesc;
	}
	
	/**
	 * Column Info
	 * @param kwNm1
	 */
	public void setKwNm1(String kwNm1) {
		this.kwNm1 = kwNm1;
	}
	
	/**
	 * Column Info
	 * @param kwNm2
	 */
	public void setKwNm2(String kwNm2) {
		this.kwNm2 = kwNm2;
	}
	
	/**
	 * Column Info
	 * @param cmdtSeq
	 */
	public void setCmdtSeq(String cmdtSeq) {
		this.cmdtSeq = cmdtSeq;
	}
	
	/**
	 * Column Info
	 * @param portCd
	 */
	public void setPortCd(String portCd) {
		this.portCd = portCd;
	}
	
	/**
	 * Column Info
	 * @param ioBndCd
	 */
	public void setIoBndCd(String ioBndCd) {
		this.ioBndCd = ioBndCd;
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
		setCmdtDesc(JSPUtil.getParameter(request, prefix + "cmdt_desc", ""));
		setKwNm1(JSPUtil.getParameter(request, prefix + "kw_nm1", ""));
		setKwNm2(JSPUtil.getParameter(request, prefix + "kw_nm2", ""));
		setCmdtSeq(JSPUtil.getParameter(request, prefix + "cmdt_seq", ""));
		setPortCd(JSPUtil.getParameter(request, prefix + "port_cd", ""));
		setIoBndCd(JSPUtil.getParameter(request, prefix + "io_bnd_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return UsWhfExceptCmdtListCondVO[]
	 */
	public UsWhfExceptCmdtListCondVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return UsWhfExceptCmdtListCondVO[]
	 */
	public UsWhfExceptCmdtListCondVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		UsWhfExceptCmdtListCondVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] cmdtDesc = (JSPUtil.getParameter(request, prefix	+ "cmdt_desc", length));
			String[] kwNm1 = (JSPUtil.getParameter(request, prefix	+ "kw_nm1", length));
			String[] kwNm2 = (JSPUtil.getParameter(request, prefix	+ "kw_nm2", length));
			String[] cmdtSeq = (JSPUtil.getParameter(request, prefix	+ "cmdt_seq", length));
			String[] portCd = (JSPUtil.getParameter(request, prefix	+ "port_cd", length));
			String[] ioBndCd = (JSPUtil.getParameter(request, prefix	+ "io_bnd_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new UsWhfExceptCmdtListCondVO();
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (cmdtDesc[i] != null)
					model.setCmdtDesc(cmdtDesc[i]);
				if (kwNm1[i] != null)
					model.setKwNm1(kwNm1[i]);
				if (kwNm2[i] != null)
					model.setKwNm2(kwNm2[i]);
				if (cmdtSeq[i] != null)
					model.setCmdtSeq(cmdtSeq[i]);
				if (portCd[i] != null)
					model.setPortCd(portCd[i]);
				if (ioBndCd[i] != null)
					model.setIoBndCd(ioBndCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getUsWhfExceptCmdtListCondVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return UsWhfExceptCmdtListCondVO[]
	 */
	public UsWhfExceptCmdtListCondVO[] getUsWhfExceptCmdtListCondVOs(){
		UsWhfExceptCmdtListCondVO[] vos = (UsWhfExceptCmdtListCondVO[])models.toArray(new UsWhfExceptCmdtListCondVO[models.size()]);
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
		this.cmdtDesc = this.cmdtDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.kwNm1 = this.kwNm1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.kwNm2 = this.kwNm2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmdtSeq = this.cmdtSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.portCd = this.portCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ioBndCd = this.ioBndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
