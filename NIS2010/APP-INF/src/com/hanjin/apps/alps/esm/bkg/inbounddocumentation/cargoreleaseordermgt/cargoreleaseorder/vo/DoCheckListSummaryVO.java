/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : DoCheckListVO.java
*@FileTitle : DoCheckListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.23
*@LastModifier : 박만건
*@LastVersion : 1.0
* 2009.10.23 박만건 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo;

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
 * @author 박만건
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class DoCheckListSummaryVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<DoCheckListSummaryVO> models = new ArrayList<DoCheckListSummaryVO>();
	
	/* Column Info */
	private String totTeu = null;
	/* Column Info */
	private String totFeu = null;
	/* Column Info */
	private String totWgt = null;
	/* Column Info */
	private String totMea = null;
	/* Column Info */
	private String totCnt = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public DoCheckListSummaryVO() {}

	public DoCheckListSummaryVO(String totTeu, String totFeu, String totWgt, String totMea, String totCnt) {
		this.totTeu = totTeu;
		this.totFeu = totFeu;
		this.totWgt = totWgt;
		this.totMea = totMea;
		this.totCnt = totCnt;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("tot_teu", getTotTeu());
		this.hashColumns.put("tot_feu", getTotFeu());
		this.hashColumns.put("tot_wgt", getTotWgt());
		this.hashColumns.put("tot_mea", getTotMea());
		this.hashColumns.put("tot_cnt", getTotCnt());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("tot_teu", "totTeu");
		this.hashFields.put("tot_feu", "totFeu");
		this.hashFields.put("tot_wgt", "totWgt");
		this.hashFields.put("tot_mea", "totMea");
		this.hashFields.put("tot_cnt", "totCnt");
		
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return vslCd
	 */
	public String getTotTeu() {
		return this.totTeu;
	}
	
	/**
	 * Column Info
	 * @return evntOfcCd
	 */
	public String getTotFeu() {
		return this.totFeu;
	}
	
	/**
	 * Column Info
	 * @return delCd
	 */
	public String getTotWgt() {
		return this.totWgt;
	}
	
	/**
	 * Column Info
	 * @return skdVoyNo
	 */
	public String getTotMea() {
		return this.totMea;
	}
	
	/**
	 * Column Info
	 * @return rowCount
	 */
	public String getTotCnt() {
		return this.totCnt;
	}
	
	
	/**
	 * Column Info
	 * @param delCd
	 */
	public void setTotTeu(String totTeu) {
		this.totTeu = totTeu;
	}
	
	/**
	 * Column Info
	 * @param evntOfcCd
	 */
	public void setTotFeu(String totFeu) {
		this.totFeu = totFeu;
	}
	
	/**
	 * Column Info
	 * @param skdVoyNo
	 */
	public void setTotWgt(String totWgt) {
		this.totWgt = totWgt;
	}
	
	/**
	 * Column Info
	 * @param rowCount
	 */
	public void setTotMea(String totMea) {
		this.totMea = totMea;
	}
	/**
	 * Column Info
	 * @param vslCd
	 */
	public void setTotCnt(String totCnt) {
		this.totCnt = totCnt;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setTotTeu(JSPUtil.getParameter(request, "tot_teu", ""));
		setTotFeu(JSPUtil.getParameter(request, "tot_feu", ""));
		setTotWgt(JSPUtil.getParameter(request, "tot_wgt", ""));
		setTotMea(JSPUtil.getParameter(request, "tot_mea", ""));
		setTotCnt(JSPUtil.getParameter(request, "tot_cnt", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return DoCheckListVO[]
	 */
	public DoCheckListSummaryVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return DoCheckListVO[]
	 */
	public DoCheckListSummaryVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		DoCheckListSummaryVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] totTeu = (JSPUtil.getParameter(request, prefix	+ "tot_teu", length));
			String[] totFeu = (JSPUtil.getParameter(request, prefix	+ "tot_feu", length));
			String[] totWgt = (JSPUtil.getParameter(request, prefix	+ "tot_wgt", length));
			String[] totMea = (JSPUtil.getParameter(request, prefix	+ "tot_mea", length));
			String[] totCnt = (JSPUtil.getParameter(request, prefix	+ "tot_cnt", length));
			
			for (int i = 0; i < length; i++) {
				model = new DoCheckListSummaryVO();
				if (totTeu[i] != null)
					model.setTotTeu(totTeu[i]);
				if (totFeu[i] != null)
					model.setTotFeu(totFeu[i]);
				if (totWgt[i] != null)
					model.setTotWgt(totWgt[i]);
				if (totMea[i] != null)
					model.setTotMea(totMea[i]);
				if (totCnt[i] != null)
					model.setTotCnt(totCnt[i]);
				
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getDoCheckListSummaryVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return DoCheckListVO[]
	 */
	public DoCheckListSummaryVO[] getDoCheckListSummaryVOs(){
		DoCheckListSummaryVO[] vos = (DoCheckListSummaryVO[])models.toArray(new DoCheckListSummaryVO[models.size()]);
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
		this.totTeu = this.totTeu .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totFeu = this.totFeu .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totWgt = this.totWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totMea = this.totMea .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totCnt = this.totCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		
		
	}
}
