/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : VerifyEQTypeSizeFlagFileListINVO.java
*@FileTitle : VerifyEQTypeSizeFlagFileListINVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.10
*@LastModifier : 권영법
*@LastVersion : 1.0
* 2010.02.10 권영법 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.ees.mnr.operationmanage.repairmgt.vo;

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
 * @author 권영법
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class VerifyEQTypeSizeFlagFileListINVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<VerifyEQTypeSizeFlagFileListINVO> models = new ArrayList<VerifyEQTypeSizeFlagFileListINVO>();
	
	/* Column Info */
	private String dmgFlag = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String costCd = null;
	/* Column Info */
	private String vndrSeq = null;
	/* Column Info */
	private String costDtlCd = null;
	/* Column Info */
	private String tmpSeq = null;
	/* Column Info */
	private String eqType = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public VerifyEQTypeSizeFlagFileListINVO() {}

	public VerifyEQTypeSizeFlagFileListINVO(String ibflag, String pagerows, String dmgFlag, String tmpSeq, String eqType, String vndrSeq, String costCd, String costDtlCd) {
		this.dmgFlag = dmgFlag;
		this.ibflag = ibflag;
		this.costCd = costCd;
		this.vndrSeq = vndrSeq;
		this.costDtlCd = costDtlCd;
		this.tmpSeq = tmpSeq;
		this.eqType = eqType;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("dmg_flag", getDmgFlag());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cost_cd", getCostCd());
		this.hashColumns.put("vndr_seq", getVndrSeq());
		this.hashColumns.put("cost_dtl_cd", getCostDtlCd());
		this.hashColumns.put("tmp_seq", getTmpSeq());
		this.hashColumns.put("eq_type", getEqType());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("dmg_flag", "dmgFlag");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cost_cd", "costCd");
		this.hashFields.put("vndr_seq", "vndrSeq");
		this.hashFields.put("cost_dtl_cd", "costDtlCd");
		this.hashFields.put("tmp_seq", "tmpSeq");
		this.hashFields.put("eq_type", "eqType");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return dmgFlag
	 */
	public String getDmgFlag() {
		return this.dmgFlag;
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
	 * @return costCd
	 */
	public String getCostCd() {
		return this.costCd;
	}
	
	/**
	 * Column Info
	 * @return vndrSeq
	 */
	public String getVndrSeq() {
		return this.vndrSeq;
	}
	
	/**
	 * Column Info
	 * @return costDtlCd
	 */
	public String getCostDtlCd() {
		return this.costDtlCd;
	}
	
	/**
	 * Column Info
	 * @return tmpSeq
	 */
	public String getTmpSeq() {
		return this.tmpSeq;
	}
	
	/**
	 * Column Info
	 * @return eqType
	 */
	public String getEqType() {
		return this.eqType;
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
	 * @param dmgFlag
	 */
	public void setDmgFlag(String dmgFlag) {
		this.dmgFlag = dmgFlag;
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
	 * @param costCd
	 */
	public void setCostCd(String costCd) {
		this.costCd = costCd;
	}
	
	/**
	 * Column Info
	 * @param vndrSeq
	 */
	public void setVndrSeq(String vndrSeq) {
		this.vndrSeq = vndrSeq;
	}
	
	/**
	 * Column Info
	 * @param costDtlCd
	 */
	public void setCostDtlCd(String costDtlCd) {
		this.costDtlCd = costDtlCd;
	}
	
	/**
	 * Column Info
	 * @param tmpSeq
	 */
	public void setTmpSeq(String tmpSeq) {
		this.tmpSeq = tmpSeq;
	}
	
	/**
	 * Column Info
	 * @param eqType
	 */
	public void setEqType(String eqType) {
		this.eqType = eqType;
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
		setDmgFlag(JSPUtil.getParameter(request, "dmg_flag", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setCostCd(JSPUtil.getParameter(request, "cost_cd", ""));
		setVndrSeq(JSPUtil.getParameter(request, "vndr_seq", ""));
		setCostDtlCd(JSPUtil.getParameter(request, "cost_dtl_cd", ""));
		setTmpSeq(JSPUtil.getParameter(request, "tmp_seq", ""));
		setEqType(JSPUtil.getParameter(request, "eq_type", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return VerifyEQTypeSizeFlagFileListINVO[]
	 */
	public VerifyEQTypeSizeFlagFileListINVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return VerifyEQTypeSizeFlagFileListINVO[]
	 */
	public VerifyEQTypeSizeFlagFileListINVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		VerifyEQTypeSizeFlagFileListINVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] dmgFlag = (JSPUtil.getParameter(request, prefix	+ "dmg_flag", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] costCd = (JSPUtil.getParameter(request, prefix	+ "cost_cd", length));
			String[] vndrSeq = (JSPUtil.getParameter(request, prefix	+ "vndr_seq", length));
			String[] costDtlCd = (JSPUtil.getParameter(request, prefix	+ "cost_dtl_cd", length));
			String[] tmpSeq = (JSPUtil.getParameter(request, prefix	+ "tmp_seq", length));
			String[] eqType = (JSPUtil.getParameter(request, prefix	+ "eq_type", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new VerifyEQTypeSizeFlagFileListINVO();
				if (dmgFlag[i] != null)
					model.setDmgFlag(dmgFlag[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (costCd[i] != null)
					model.setCostCd(costCd[i]);
				if (vndrSeq[i] != null)
					model.setVndrSeq(vndrSeq[i]);
				if (costDtlCd[i] != null)
					model.setCostDtlCd(costDtlCd[i]);
				if (tmpSeq[i] != null)
					model.setTmpSeq(tmpSeq[i]);
				if (eqType[i] != null)
					model.setEqType(eqType[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getVerifyEQTypeSizeFlagFileListINVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return VerifyEQTypeSizeFlagFileListINVO[]
	 */
	public VerifyEQTypeSizeFlagFileListINVO[] getVerifyEQTypeSizeFlagFileListINVOs(){
		VerifyEQTypeSizeFlagFileListINVO[] vos = (VerifyEQTypeSizeFlagFileListINVO[])models.toArray(new VerifyEQTypeSizeFlagFileListINVO[models.size()]);
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
		this.dmgFlag = this.dmgFlag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costCd = this.costCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrSeq = this.vndrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costDtlCd = this.costDtlCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tmpSeq = this.tmpSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqType = this.eqType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
