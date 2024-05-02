/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : CllCondVO.java
*@FileTitle : CllCondVO
*Open Issues :
*Change history :
*@LastModifyDate : 2016.06.27
*@LastModifier : 
*@LastVersion : 1.0
* 2016.06.27  
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.terminaldocumentation.cllcdlmanifest.vo;

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
 * @author 
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class CllCondVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<CllCondVO> models = new ArrayList<CllCondVO>();
	
	/* Column Info */
	private String inLocalTs = null;
	/* Column Info */
	private String cntrVgmOnly = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String tsType = null;
	/* Column Info */
	private String inPolCd = null;
	/* Column Info */
	private String inVvdCd = null;
	/* Column Info */
	private String localType = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String inPolSplitNo = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public CllCondVO() {}

	public CllCondVO(String ibflag, String pagerows, String inLocalTs, String cntrVgmOnly, String inPolCd, String inVvdCd, String inPolSplitNo, String updUsrId, String localType, String tsType) {
		this.inLocalTs = inLocalTs;
		this.cntrVgmOnly = cntrVgmOnly;
		this.ibflag = ibflag;
		this.tsType = tsType;
		this.inPolCd = inPolCd;
		this.inVvdCd = inVvdCd;
		this.localType = localType;
		this.updUsrId = updUsrId;
		this.inPolSplitNo = inPolSplitNo;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("in_local_ts", getInLocalTs());
		this.hashColumns.put("cntr_vgm_only", getCntrVgmOnly());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("ts_type", getTsType());
		this.hashColumns.put("in_pol_cd", getInPolCd());
		this.hashColumns.put("in_vvd_cd", getInVvdCd());
		this.hashColumns.put("local_type", getLocalType());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("in_pol_split_no", getInPolSplitNo());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("in_local_ts", "inLocalTs");
		this.hashFields.put("cntr_vgm_only", "cntrVgmOnly");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("ts_type", "tsType");
		this.hashFields.put("in_pol_cd", "inPolCd");
		this.hashFields.put("in_vvd_cd", "inVvdCd");
		this.hashFields.put("local_type", "localType");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("in_pol_split_no", "inPolSplitNo");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return inLocalTs
	 */
	public String getInLocalTs() {
		return this.inLocalTs;
	}
	
	/**
	 * Column Info
	 * @return cntrVgmOnly
	 */
	public String getCntrVgmOnly() {
		return this.cntrVgmOnly;
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
	 * @return tsType
	 */
	public String getTsType() {
		return this.tsType;
	}
	
	/**
	 * Column Info
	 * @return inPolCd
	 */
	public String getInPolCd() {
		return this.inPolCd;
	}
	
	/**
	 * Column Info
	 * @return inVvdCd
	 */
	public String getInVvdCd() {
		return this.inVvdCd;
	}
	
	/**
	 * Column Info
	 * @return localType
	 */
	public String getLocalType() {
		return this.localType;
	}
	
	/**
	 * Column Info
	 * @return updUsrId
	 */
	public String getUpdUsrId() {
		return this.updUsrId;
	}
	
	/**
	 * Column Info
	 * @return inPolSplitNo
	 */
	public String getInPolSplitNo() {
		return this.inPolSplitNo;
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
	 * @param inLocalTs
	 */
	public void setInLocalTs(String inLocalTs) {
		this.inLocalTs = inLocalTs;
	}
	
	/**
	 * Column Info
	 * @param cntrVgmOnly
	 */
	public void setCntrVgmOnly(String cntrVgmOnly) {
		this.cntrVgmOnly = cntrVgmOnly;
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
	 * @param tsType
	 */
	public void setTsType(String tsType) {
		this.tsType = tsType;
	}
	
	/**
	 * Column Info
	 * @param inPolCd
	 */
	public void setInPolCd(String inPolCd) {
		this.inPolCd = inPolCd;
	}
	
	/**
	 * Column Info
	 * @param inVvdCd
	 */
	public void setInVvdCd(String inVvdCd) {
		this.inVvdCd = inVvdCd;
	}
	
	/**
	 * Column Info
	 * @param localType
	 */
	public void setLocalType(String localType) {
		this.localType = localType;
	}
	
	/**
	 * Column Info
	 * @param updUsrId
	 */
	public void setUpdUsrId(String updUsrId) {
		this.updUsrId = updUsrId;
	}
	
	/**
	 * Column Info
	 * @param inPolSplitNo
	 */
	public void setInPolSplitNo(String inPolSplitNo) {
		this.inPolSplitNo = inPolSplitNo;
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
		setInLocalTs(JSPUtil.getParameter(request, prefix + "in_local_ts", ""));
		setCntrVgmOnly(JSPUtil.getParameter(request, prefix + "cntr_vgm_only", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setTsType(JSPUtil.getParameter(request, prefix + "ts_type", ""));
		setInPolCd(JSPUtil.getParameter(request, prefix + "in_pol_cd", ""));
		setInVvdCd(JSPUtil.getParameter(request, prefix + "in_vvd_cd", ""));
		setLocalType(JSPUtil.getParameter(request, prefix + "local_type", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setInPolSplitNo(JSPUtil.getParameter(request, prefix + "in_pol_split_no", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return CllCondVO[]
	 */
	public CllCondVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return CllCondVO[]
	 */
	public CllCondVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		CllCondVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] inLocalTs = (JSPUtil.getParameter(request, prefix	+ "in_local_ts", length));
			String[] cntrVgmOnly = (JSPUtil.getParameter(request, prefix	+ "cntr_vgm_only", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] tsType = (JSPUtil.getParameter(request, prefix	+ "ts_type", length));
			String[] inPolCd = (JSPUtil.getParameter(request, prefix	+ "in_pol_cd", length));
			String[] inVvdCd = (JSPUtil.getParameter(request, prefix	+ "in_vvd_cd", length));
			String[] localType = (JSPUtil.getParameter(request, prefix	+ "local_type", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] inPolSplitNo = (JSPUtil.getParameter(request, prefix	+ "in_pol_split_no", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new CllCondVO();
				if (inLocalTs[i] != null)
					model.setInLocalTs(inLocalTs[i]);
				if (cntrVgmOnly[i] != null)
					model.setCntrVgmOnly(cntrVgmOnly[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (tsType[i] != null)
					model.setTsType(tsType[i]);
				if (inPolCd[i] != null)
					model.setInPolCd(inPolCd[i]);
				if (inVvdCd[i] != null)
					model.setInVvdCd(inVvdCd[i]);
				if (localType[i] != null)
					model.setLocalType(localType[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (inPolSplitNo[i] != null)
					model.setInPolSplitNo(inPolSplitNo[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getCllCondVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return CllCondVO[]
	 */
	public CllCondVO[] getCllCondVOs(){
		CllCondVO[] vos = (CllCondVO[])models.toArray(new CllCondVO[models.size()]);
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
		this.inLocalTs = this.inLocalTs .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrVgmOnly = this.cntrVgmOnly .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tsType = this.tsType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inPolCd = this.inPolCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inVvdCd = this.inVvdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.localType = this.localType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inPolSplitNo = this.inPolSplitNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
