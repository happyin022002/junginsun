/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : VerifyTariffFileListINVO.java
*@FileTitle : VerifyTariffFileListINVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.11
*@LastModifier : 김완규
*@LastVersion : 1.0
* 2010.03.11 김완규 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.ees.mnr.agreementmanage.tariffmgt.vo;

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
 * @author 김완규
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class VerifyTariffFileListINVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<VerifyTariffFileListINVO> models = new ArrayList<VerifyTariffFileListINVO>();
	
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String programId = null;
	/* Column Info */
	private String stdTrfNo = null;
	/* Column Info */
	private String tmpSeq = null;
	/* Column Info */
	private String eqKndCd = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public VerifyTariffFileListINVO() {}

	public VerifyTariffFileListINVO(String ibflag, String pagerows, String eqKndCd, String tmpSeq, String programId, String stdTrfNo) {
		this.ibflag = ibflag;
		this.programId = programId;
		this.stdTrfNo = stdTrfNo;
		this.tmpSeq = tmpSeq;
		this.eqKndCd = eqKndCd;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("program_id", getProgramId());
		this.hashColumns.put("std_trf_no", getStdTrfNo());
		this.hashColumns.put("tmp_seq", getTmpSeq());
		this.hashColumns.put("eq_knd_cd", getEqKndCd());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("program_id", "programId");
		this.hashFields.put("std_trf_no", "stdTrfNo");
		this.hashFields.put("tmp_seq", "tmpSeq");
		this.hashFields.put("eq_knd_cd", "eqKndCd");
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
	 * @return programId
	 */
	public String getProgramId() {
		return this.programId;
	}
	
	/**
	 * Column Info
	 * @return stdTrfNo
	 */
	public String getStdTrfNo() {
		return this.stdTrfNo;
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
	 * @return eqKndCd
	 */
	public String getEqKndCd() {
		return this.eqKndCd;
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
	 * @param programId
	 */
	public void setProgramId(String programId) {
		this.programId = programId;
	}
	
	/**
	 * Column Info
	 * @param stdTrfNo
	 */
	public void setStdTrfNo(String stdTrfNo) {
		this.stdTrfNo = stdTrfNo;
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
	 * @param eqKndCd
	 */
	public void setEqKndCd(String eqKndCd) {
		this.eqKndCd = eqKndCd;
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
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setProgramId(JSPUtil.getParameter(request, "program_id", ""));
		setStdTrfNo(JSPUtil.getParameter(request, "std_trf_no", ""));
		setTmpSeq(JSPUtil.getParameter(request, "tmp_seq", ""));
		setEqKndCd(JSPUtil.getParameter(request, "eq_knd_cd", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return VerifyTariffFileListINVO[]
	 */
	public VerifyTariffFileListINVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return VerifyTariffFileListINVO[]
	 */
	public VerifyTariffFileListINVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		VerifyTariffFileListINVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] programId = (JSPUtil.getParameter(request, prefix	+ "program_id", length));
			String[] stdTrfNo = (JSPUtil.getParameter(request, prefix	+ "std_trf_no", length));
			String[] tmpSeq = (JSPUtil.getParameter(request, prefix	+ "tmp_seq", length));
			String[] eqKndCd = (JSPUtil.getParameter(request, prefix	+ "eq_knd_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new VerifyTariffFileListINVO();
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (programId[i] != null)
					model.setProgramId(programId[i]);
				if (stdTrfNo[i] != null)
					model.setStdTrfNo(stdTrfNo[i]);
				if (tmpSeq[i] != null)
					model.setTmpSeq(tmpSeq[i]);
				if (eqKndCd[i] != null)
					model.setEqKndCd(eqKndCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getVerifyTariffFileListINVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return VerifyTariffFileListINVO[]
	 */
	public VerifyTariffFileListINVO[] getVerifyTariffFileListINVOs(){
		VerifyTariffFileListINVO[] vos = (VerifyTariffFileListINVO[])models.toArray(new VerifyTariffFileListINVO[models.size()]);
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
		this.programId = this.programId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stdTrfNo = this.stdTrfNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tmpSeq = this.tmpSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqKndCd = this.eqKndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
