/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : OrganizationChartVO.java
*@FileTitle : OrganizationChartVO
*Open Issues :
*Change history :
*@LastModifyDate : 2015.01.13
*@LastModifier : 김진주
*@LastVersion : 1.0
* 2015.01.13 김진주 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.outbounddocumentation.blrating.blrating.vo;

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
 * @author 김진주
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class OrganizationChartVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<OrganizationChartVO> models = new ArrayList<OrganizationChartVO>();
	
	/* Column Info */
	private String authFlg = null;
	/* Column Info */
	private String typeFlg = null;
	/* Column Info */
	private String amdtSeq = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String nodeNm = null;
	/* Column Info */
	private String ofcCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String nodeId = null;
	/* Column Info */
	private String level = null;
	/* Column Info */
	private String usrNm = null;
	/* Column Info */
	private String usrId = null;
	/* Column Info */
	private String usrEml = null;
	/* Column Info */
	private String haveChild = null;
	/* Column Info */
	private String propNo = null;
	/* Column Info */
	private String pnodeId = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public OrganizationChartVO() {}

	public OrganizationChartVO(String ibflag, String pagerows, String level, String pnodeId, String nodeId, String nodeNm, String ofcCd, String usrId, String usrEml, String typeFlg, String authFlg, String haveChild, String propNo, String amdtSeq, String usrNm) {
		this.authFlg = authFlg;
		this.typeFlg = typeFlg;
		this.amdtSeq = amdtSeq;
		this.pagerows = pagerows;
		this.nodeNm = nodeNm;
		this.ofcCd = ofcCd;
		this.ibflag = ibflag;
		this.nodeId = nodeId;
		this.level = level;
		this.usrNm = usrNm;
		this.usrId = usrId;
		this.usrEml = usrEml;
		this.haveChild = haveChild;
		this.propNo = propNo;
		this.pnodeId = pnodeId;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("auth_flg", getAuthFlg());
		this.hashColumns.put("type_flg", getTypeFlg());
		this.hashColumns.put("amdt_seq", getAmdtSeq());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("node_nm", getNodeNm());
		this.hashColumns.put("ofc_cd", getOfcCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("node_id", getNodeId());
		this.hashColumns.put("level", getLevel());
		this.hashColumns.put("usr_nm", getUsrNm());
		this.hashColumns.put("usr_id", getUsrId());
		this.hashColumns.put("usr_eml", getUsrEml());
		this.hashColumns.put("have_child", getHaveChild());
		this.hashColumns.put("prop_no", getPropNo());
		this.hashColumns.put("pnode_id", getPnodeId());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("auth_flg", "authFlg");
		this.hashFields.put("type_flg", "typeFlg");
		this.hashFields.put("amdt_seq", "amdtSeq");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("node_nm", "nodeNm");
		this.hashFields.put("ofc_cd", "ofcCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("node_id", "nodeId");
		this.hashFields.put("level", "level");
		this.hashFields.put("usr_nm", "usrNm");
		this.hashFields.put("usr_id", "usrId");
		this.hashFields.put("usr_eml", "usrEml");
		this.hashFields.put("have_child", "haveChild");
		this.hashFields.put("prop_no", "propNo");
		this.hashFields.put("pnode_id", "pnodeId");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return authFlg
	 */
	public String getAuthFlg() {
		return this.authFlg;
	}
	
	/**
	 * Column Info
	 * @return typeFlg
	 */
	public String getTypeFlg() {
		return this.typeFlg;
	}
	
	/**
	 * Column Info
	 * @return amdtSeq
	 */
	public String getAmdtSeq() {
		return this.amdtSeq;
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
	 * @return nodeNm
	 */
	public String getNodeNm() {
		return this.nodeNm;
	}
	
	/**
	 * Column Info
	 * @return ofcCd
	 */
	public String getOfcCd() {
		return this.ofcCd;
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
	 * @return nodeId
	 */
	public String getNodeId() {
		return this.nodeId;
	}
	
	/**
	 * Column Info
	 * @return level
	 */
	public String getLevel() {
		return this.level;
	}
	
	/**
	 * Column Info
	 * @return usrNm
	 */
	public String getUsrNm() {
		return this.usrNm;
	}
	
	/**
	 * Column Info
	 * @return usrId
	 */
	public String getUsrId() {
		return this.usrId;
	}
	
	/**
	 * Column Info
	 * @return usrEml
	 */
	public String getUsrEml() {
		return this.usrEml;
	}
	
	/**
	 * Column Info
	 * @return haveChild
	 */
	public String getHaveChild() {
		return this.haveChild;
	}
	
	/**
	 * Column Info
	 * @return propNo
	 */
	public String getPropNo() {
		return this.propNo;
	}
	
	/**
	 * Column Info
	 * @return pnodeId
	 */
	public String getPnodeId() {
		return this.pnodeId;
	}
	

	/**
	 * Column Info
	 * @param authFlg
	 */
	public void setAuthFlg(String authFlg) {
		this.authFlg = authFlg;
	}
	
	/**
	 * Column Info
	 * @param typeFlg
	 */
	public void setTypeFlg(String typeFlg) {
		this.typeFlg = typeFlg;
	}
	
	/**
	 * Column Info
	 * @param amdtSeq
	 */
	public void setAmdtSeq(String amdtSeq) {
		this.amdtSeq = amdtSeq;
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
	 * @param nodeNm
	 */
	public void setNodeNm(String nodeNm) {
		this.nodeNm = nodeNm;
	}
	
	/**
	 * Column Info
	 * @param ofcCd
	 */
	public void setOfcCd(String ofcCd) {
		this.ofcCd = ofcCd;
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
	 * @param nodeId
	 */
	public void setNodeId(String nodeId) {
		this.nodeId = nodeId;
	}
	
	/**
	 * Column Info
	 * @param level
	 */
	public void setLevel(String level) {
		this.level = level;
	}
	
	/**
	 * Column Info
	 * @param usrNm
	 */
	public void setUsrNm(String usrNm) {
		this.usrNm = usrNm;
	}
	
	/**
	 * Column Info
	 * @param usrId
	 */
	public void setUsrId(String usrId) {
		this.usrId = usrId;
	}
	
	/**
	 * Column Info
	 * @param usrEml
	 */
	public void setUsrEml(String usrEml) {
		this.usrEml = usrEml;
	}
	
	/**
	 * Column Info
	 * @param haveChild
	 */
	public void setHaveChild(String haveChild) {
		this.haveChild = haveChild;
	}
	
	/**
	 * Column Info
	 * @param propNo
	 */
	public void setPropNo(String propNo) {
		this.propNo = propNo;
	}
	
	/**
	 * Column Info
	 * @param pnodeId
	 */
	public void setPnodeId(String pnodeId) {
		this.pnodeId = pnodeId;
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
		setAuthFlg(JSPUtil.getParameter(request, prefix + "auth_flg", ""));
		setTypeFlg(JSPUtil.getParameter(request, prefix + "type_flg", ""));
		setAmdtSeq(JSPUtil.getParameter(request, prefix + "amdt_seq", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setNodeNm(JSPUtil.getParameter(request, prefix + "node_nm", ""));
		setOfcCd(JSPUtil.getParameter(request, prefix + "ofc_cd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setNodeId(JSPUtil.getParameter(request, prefix + "node_id", ""));
		setLevel(JSPUtil.getParameter(request, prefix + "level", ""));
		setUsrNm(JSPUtil.getParameter(request, prefix + "usr_nm", ""));
		setUsrId(JSPUtil.getParameter(request, prefix + "usr_id", ""));
		setUsrEml(JSPUtil.getParameter(request, prefix + "usr_eml", ""));
		setHaveChild(JSPUtil.getParameter(request, prefix + "have_child", ""));
		setPropNo(JSPUtil.getParameter(request, prefix + "prop_no", ""));
		setPnodeId(JSPUtil.getParameter(request, prefix + "pnode_id", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return OrganizationChartVO[]
	 */
	public OrganizationChartVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return OrganizationChartVO[]
	 */
	public OrganizationChartVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		OrganizationChartVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] authFlg = (JSPUtil.getParameter(request, prefix	+ "auth_flg", length));
			String[] typeFlg = (JSPUtil.getParameter(request, prefix	+ "type_flg", length));
			String[] amdtSeq = (JSPUtil.getParameter(request, prefix	+ "amdt_seq", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] nodeNm = (JSPUtil.getParameter(request, prefix	+ "node_nm", length));
			String[] ofcCd = (JSPUtil.getParameter(request, prefix	+ "ofc_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] nodeId = (JSPUtil.getParameter(request, prefix	+ "node_id", length));
			String[] level = (JSPUtil.getParameter(request, prefix	+ "level", length));
			String[] usrNm = (JSPUtil.getParameter(request, prefix	+ "usr_nm", length));
			String[] usrId = (JSPUtil.getParameter(request, prefix	+ "usr_id", length));
			String[] usrEml = (JSPUtil.getParameter(request, prefix	+ "usr_eml", length));
			String[] haveChild = (JSPUtil.getParameter(request, prefix	+ "have_child", length));
			String[] propNo = (JSPUtil.getParameter(request, prefix	+ "prop_no", length));
			String[] pnodeId = (JSPUtil.getParameter(request, prefix	+ "pnode_id", length));
			
			for (int i = 0; i < length; i++) {
				model = new OrganizationChartVO();
				if (authFlg[i] != null)
					model.setAuthFlg(authFlg[i]);
				if (typeFlg[i] != null)
					model.setTypeFlg(typeFlg[i]);
				if (amdtSeq[i] != null)
					model.setAmdtSeq(amdtSeq[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (nodeNm[i] != null)
					model.setNodeNm(nodeNm[i]);
				if (ofcCd[i] != null)
					model.setOfcCd(ofcCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (nodeId[i] != null)
					model.setNodeId(nodeId[i]);
				if (level[i] != null)
					model.setLevel(level[i]);
				if (usrNm[i] != null)
					model.setUsrNm(usrNm[i]);
				if (usrId[i] != null)
					model.setUsrId(usrId[i]);
				if (usrEml[i] != null)
					model.setUsrEml(usrEml[i]);
				if (haveChild[i] != null)
					model.setHaveChild(haveChild[i]);
				if (propNo[i] != null)
					model.setPropNo(propNo[i]);
				if (pnodeId[i] != null)
					model.setPnodeId(pnodeId[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getOrganizationChartVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return OrganizationChartVO[]
	 */
	public OrganizationChartVO[] getOrganizationChartVOs(){
		OrganizationChartVO[] vos = (OrganizationChartVO[])models.toArray(new OrganizationChartVO[models.size()]);
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
		this.authFlg = this.authFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.typeFlg = this.typeFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.amdtSeq = this.amdtSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.nodeNm = this.nodeNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcCd = this.ofcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.nodeId = this.nodeId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.level = this.level .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usrNm = this.usrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usrId = this.usrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usrEml = this.usrEml .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.haveChild = this.haveChild .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.propNo = this.propNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pnodeId = this.pnodeId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
