/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : MnrGeneralCodeVO.java
*@FileTitle : MnrGeneralCodeVO
*Open Issues :
*Change history :
*@LastModifyDate : 2015.04.20
*@LastModifier : 박정민
*@LastVersion : 1.0
* 2015.04.20 박정민 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esd.eas.mnradvanceaudit.vo;

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
 * @author 박정민
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class MnrGeneralCodeVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<MnrGeneralCodeVO> models = new ArrayList<MnrGeneralCodeVO>();
	
	/* Page Number */
	private String pagerows = null; 
	/* Column Info */
	private String mnrCdDpSeq2 = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String codeCd = null;
	/* Column Info */
	private String codeNm = null;
	/* Column Info */
	private String mnrCdDpSeq = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public MnrGeneralCodeVO() {}

	public MnrGeneralCodeVO(String ibflag, String pagerows, String codeCd, String codeNm, String mnrCdDpSeq, String mnrCdDpSeq2) {
		this.pagerows = pagerows;
		this.mnrCdDpSeq2 = mnrCdDpSeq2;
		this.ibflag = ibflag;
		this.codeCd = codeCd;
		this.codeNm = codeNm;
		this.mnrCdDpSeq = mnrCdDpSeq;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("mnr_cd_dp_seq2", getMnrCdDpSeq2());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("code_cd", getCodeCd());
		this.hashColumns.put("code_nm", getCodeNm());
		this.hashColumns.put("mnr_cd_dp_seq", getMnrCdDpSeq());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("mnr_cd_dp_seq2", "mnrCdDpSeq2");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("code_cd", "codeCd");
		this.hashFields.put("code_nm", "codeNm");
		this.hashFields.put("mnr_cd_dp_seq", "mnrCdDpSeq");
		return this.hashFields;
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
	 * @return mnrCdDpSeq2
	 */
	public String getMnrCdDpSeq2() {
		return this.mnrCdDpSeq2;
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
	 * @return codeCd
	 */
	public String getCodeCd() {
		return this.codeCd;
	}
	
	/**
	 * Column Info
	 * @return codeNm
	 */
	public String getCodeNm() {
		return this.codeNm;
	}
	
	/**
	 * Column Info
	 * @return mnrCdDpSeq
	 */
	public String getMnrCdDpSeq() {
		return this.mnrCdDpSeq;
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
	 * @param mnrCdDpSeq2
	 */
	public void setMnrCdDpSeq2(String mnrCdDpSeq2) {
		this.mnrCdDpSeq2 = mnrCdDpSeq2;
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
	 * @param codeCd
	 */
	public void setCodeCd(String codeCd) {
		this.codeCd = codeCd;
	}
	
	/**
	 * Column Info
	 * @param codeNm
	 */
	public void setCodeNm(String codeNm) {
		this.codeNm = codeNm;
	}
	
	/**
	 * Column Info
	 * @param mnrCdDpSeq
	 */
	public void setMnrCdDpSeq(String mnrCdDpSeq) {
		this.mnrCdDpSeq = mnrCdDpSeq;
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
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setMnrCdDpSeq2(JSPUtil.getParameter(request, prefix + "mnr_cd_dp_seq2", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setCodeCd(JSPUtil.getParameter(request, prefix + "code_cd", ""));
		setCodeNm(JSPUtil.getParameter(request, prefix + "code_nm", ""));
		setMnrCdDpSeq(JSPUtil.getParameter(request, prefix + "mnr_cd_dp_seq", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return MnrGeneralCodeVO[]
	 */
	public MnrGeneralCodeVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return MnrGeneralCodeVO[]
	 */
	public MnrGeneralCodeVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		MnrGeneralCodeVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] mnrCdDpSeq2 = (JSPUtil.getParameter(request, prefix	+ "mnr_cd_dp_seq2", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] codeCd = (JSPUtil.getParameter(request, prefix	+ "code_cd", length));
			String[] codeNm = (JSPUtil.getParameter(request, prefix	+ "code_nm", length));
			String[] mnrCdDpSeq = (JSPUtil.getParameter(request, prefix	+ "mnr_cd_dp_seq", length));
			
			for (int i = 0; i < length; i++) {
				model = new MnrGeneralCodeVO();
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (mnrCdDpSeq2[i] != null)
					model.setMnrCdDpSeq2(mnrCdDpSeq2[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (codeCd[i] != null)
					model.setCodeCd(codeCd[i]);
				if (codeNm[i] != null)
					model.setCodeNm(codeNm[i]);
				if (mnrCdDpSeq[i] != null)
					model.setMnrCdDpSeq(mnrCdDpSeq[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getMnrGeneralCodeVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return MnrGeneralCodeVO[]
	 */
	public MnrGeneralCodeVO[] getMnrGeneralCodeVOs(){
		MnrGeneralCodeVO[] vos = (MnrGeneralCodeVO[])models.toArray(new MnrGeneralCodeVO[models.size()]);
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
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnrCdDpSeq2 = this.mnrCdDpSeq2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.codeCd = this.codeCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.codeNm = this.codeNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnrCdDpSeq = this.mnrCdDpSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
