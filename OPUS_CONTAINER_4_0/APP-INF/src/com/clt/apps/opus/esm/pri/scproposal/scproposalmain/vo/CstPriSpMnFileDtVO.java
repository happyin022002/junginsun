/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : CstPriSpMnFileDtVO.java
*@FileTitle : CstPriSpMnFileDtVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.04.02
*@LastModifier : 공백진
*@LastVersion : 1.0
* 2010.04.02 공백진 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.pri.scproposal.scproposalmain.vo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 공백진
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class CstPriSpMnFileDtVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<CstPriSpMnFileDtVO> models = new ArrayList<CstPriSpMnFileDtVO>();
	
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String propOfcCd = null;
	/* Column Info */
	private String fileDt = null;
	/* Column Info */
	private String preEffDt = null;
	/* Column Info */
	private String amdtSeq = null;
	/* Column Info */
	private String propNo = null;
	/* Column Info */
	private String sysDt = null;
	/* Column Info */
	private String lastFileDt = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public CstPriSpMnFileDtVO() {}

	public CstPriSpMnFileDtVO(String ibflag, String pagerows, String lastFileDt, String fileDt, String sysDt, String preEffDt, String propNo, String amdtSeq, String propOfcCd) {
		this.ibflag = ibflag;
		this.propOfcCd = propOfcCd;
		this.fileDt = fileDt;
		this.preEffDt = preEffDt;
		this.amdtSeq = amdtSeq;
		this.propNo = propNo;
		this.sysDt = sysDt;
		this.lastFileDt = lastFileDt;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("prop_ofc_cd", getPropOfcCd());
		this.hashColumns.put("file_dt", getFileDt());
		this.hashColumns.put("pre_eff_dt", getPreEffDt());
		this.hashColumns.put("amdt_seq", getAmdtSeq());
		this.hashColumns.put("prop_no", getPropNo());
		this.hashColumns.put("sys_dt", getSysDt());
		this.hashColumns.put("last_file_dt", getLastFileDt());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("prop_ofc_cd", "propOfcCd");
		this.hashFields.put("file_dt", "fileDt");
		this.hashFields.put("pre_eff_dt", "preEffDt");
		this.hashFields.put("amdt_seq", "amdtSeq");
		this.hashFields.put("prop_no", "propNo");
		this.hashFields.put("sys_dt", "sysDt");
		this.hashFields.put("last_file_dt", "lastFileDt");
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
	 * @return propOfcCd
	 */
	public String getPropOfcCd() {
		return this.propOfcCd;
	}
	
	/**
	 * Column Info
	 * @return fileDt
	 */
	public String getFileDt() {
		return this.fileDt;
	}
	
	/**
	 * Column Info
	 * @return preEffDt
	 */
	public String getPreEffDt() {
		return this.preEffDt;
	}
	
	/**
	 * Column Info
	 * @return amdtSeq
	 */
	public String getAmdtSeq() {
		return this.amdtSeq;
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
	 * @return sysDt
	 */
	public String getSysDt() {
		return this.sysDt;
	}
	
	/**
	 * Column Info
	 * @return lastFileDt
	 */
	public String getLastFileDt() {
		return this.lastFileDt;
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
	 * @param propOfcCd
	 */
	public void setPropOfcCd(String propOfcCd) {
		this.propOfcCd = propOfcCd;
	}
	
	/**
	 * Column Info
	 * @param fileDt
	 */
	public void setFileDt(String fileDt) {
		this.fileDt = fileDt;
	}
	
	/**
	 * Column Info
	 * @param preEffDt
	 */
	public void setPreEffDt(String preEffDt) {
		this.preEffDt = preEffDt;
	}
	
	/**
	 * Column Info
	 * @param amdtSeq
	 */
	public void setAmdtSeq(String amdtSeq) {
		this.amdtSeq = amdtSeq;
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
	 * @param sysDt
	 */
	public void setSysDt(String sysDt) {
		this.sysDt = sysDt;
	}
	
	/**
	 * Column Info
	 * @param lastFileDt
	 */
	public void setLastFileDt(String lastFileDt) {
		this.lastFileDt = lastFileDt;
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
		setPropOfcCd(JSPUtil.getParameter(request, prefix + "prop_ofc_cd", ""));
		setFileDt(JSPUtil.getParameter(request, prefix + "file_dt", ""));
		setPreEffDt(JSPUtil.getParameter(request, prefix + "pre_eff_dt", ""));
		setAmdtSeq(JSPUtil.getParameter(request, prefix + "amdt_seq", ""));
		setPropNo(JSPUtil.getParameter(request, prefix + "prop_no", ""));
		setSysDt(JSPUtil.getParameter(request, prefix + "sys_dt", ""));
		setLastFileDt(JSPUtil.getParameter(request, prefix + "last_file_dt", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return CstPriSpMnFileDtVO[]
	 */
	public CstPriSpMnFileDtVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return CstPriSpMnFileDtVO[]
	 */
	public CstPriSpMnFileDtVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		CstPriSpMnFileDtVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] propOfcCd = (JSPUtil.getParameter(request, prefix	+ "prop_ofc_cd", length));
			String[] fileDt = (JSPUtil.getParameter(request, prefix	+ "file_dt", length));
			String[] preEffDt = (JSPUtil.getParameter(request, prefix	+ "pre_eff_dt", length));
			String[] amdtSeq = (JSPUtil.getParameter(request, prefix	+ "amdt_seq", length));
			String[] propNo = (JSPUtil.getParameter(request, prefix	+ "prop_no", length));
			String[] sysDt = (JSPUtil.getParameter(request, prefix	+ "sys_dt", length));
			String[] lastFileDt = (JSPUtil.getParameter(request, prefix	+ "last_file_dt", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new CstPriSpMnFileDtVO();
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (propOfcCd[i] != null)
					model.setPropOfcCd(propOfcCd[i]);
				if (fileDt[i] != null)
					model.setFileDt(fileDt[i]);
				if (preEffDt[i] != null)
					model.setPreEffDt(preEffDt[i]);
				if (amdtSeq[i] != null)
					model.setAmdtSeq(amdtSeq[i]);
				if (propNo[i] != null)
					model.setPropNo(propNo[i]);
				if (sysDt[i] != null)
					model.setSysDt(sysDt[i]);
				if (lastFileDt[i] != null)
					model.setLastFileDt(lastFileDt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getCstPriSpMnFileDtVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return CstPriSpMnFileDtVO[]
	 */
	public CstPriSpMnFileDtVO[] getCstPriSpMnFileDtVOs(){
		CstPriSpMnFileDtVO[] vos = (CstPriSpMnFileDtVO[])models.toArray(new CstPriSpMnFileDtVO[models.size()]);
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
		this.propOfcCd = this.propOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fileDt = this.fileDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.preEffDt = this.preEffDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.amdtSeq = this.amdtSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.propNo = this.propNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sysDt = this.sysDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lastFileDt = this.lastFileDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
