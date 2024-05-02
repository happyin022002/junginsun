/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : LedgerCombinationCondVO.java
*@FileTitle : LedgerCombinationCondVO
*Open Issues :
*Change history :
*@LastModifyDate : 2015.11.27
*@LastModifier : 
*@LastVersion : 1.0
* 2015.11.27  
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.stm.sar.accountreceivableoutstandingmigration.accountreceivableoutstandingmigration.vo;

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

public class LedgerCombinationCondVO extends AbstractValueObject {
 
	private static final long serialVersionUID = 1L;
	
	private Collection<LedgerCombinationCondVO> models = new ArrayList<LedgerCombinationCondVO>();
	
	/* Column Info */
	private String glDt = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String sgmCtnt2 = null;
	/* Column Info */
	private String sgmCtnt3 = null;
	/* Column Info */
	private String sgmCtnt1 = null;
	/* Column Info */
	private String sgmCtnt6 = null;
	/* Column Info */
	private String sgmCtnt4 = null;
	/* Column Info */
	private String sgmCtnt5 = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public LedgerCombinationCondVO() {}

	public LedgerCombinationCondVO(String ibflag, String pagerows, String sgmCtnt1, String sgmCtnt2, String sgmCtnt3, String sgmCtnt4, String sgmCtnt5, String sgmCtnt6, String glDt) {
		this.glDt = glDt;
		this.ibflag = ibflag;
		this.sgmCtnt2 = sgmCtnt2;
		this.sgmCtnt3 = sgmCtnt3;
		this.sgmCtnt1 = sgmCtnt1;
		this.sgmCtnt6 = sgmCtnt6;
		this.sgmCtnt4 = sgmCtnt4;
		this.sgmCtnt5 = sgmCtnt5;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("gl_dt", getGlDt());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("sgm_ctnt2", getSgmCtnt2());
		this.hashColumns.put("sgm_ctnt3", getSgmCtnt3());
		this.hashColumns.put("sgm_ctnt1", getSgmCtnt1());
		this.hashColumns.put("sgm_ctnt6", getSgmCtnt6());
		this.hashColumns.put("sgm_ctnt4", getSgmCtnt4());
		this.hashColumns.put("sgm_ctnt5", getSgmCtnt5());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("gl_dt", "glDt");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("sgm_ctnt2", "sgmCtnt2");
		this.hashFields.put("sgm_ctnt3", "sgmCtnt3");
		this.hashFields.put("sgm_ctnt1", "sgmCtnt1");
		this.hashFields.put("sgm_ctnt6", "sgmCtnt6");
		this.hashFields.put("sgm_ctnt4", "sgmCtnt4");
		this.hashFields.put("sgm_ctnt5", "sgmCtnt5");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return glDt
	 */
	public String getGlDt() {
		return this.glDt;
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
	 * @return sgmCtnt2
	 */
	public String getSgmCtnt2() {
		return this.sgmCtnt2;
	}
	
	/**
	 * Column Info
	 * @return sgmCtnt3
	 */
	public String getSgmCtnt3() {
		return this.sgmCtnt3;
	}
	
	/**
	 * Column Info
	 * @return sgmCtnt1
	 */
	public String getSgmCtnt1() {
		return this.sgmCtnt1;
	}
	
	/**
	 * Column Info
	 * @return sgmCtnt6
	 */
	public String getSgmCtnt6() {
		return this.sgmCtnt6;
	}
	
	/**
	 * Column Info
	 * @return sgmCtnt4
	 */
	public String getSgmCtnt4() {
		return this.sgmCtnt4;
	}
	
	/**
	 * Column Info
	 * @return sgmCtnt5
	 */
	public String getSgmCtnt5() {
		return this.sgmCtnt5;
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
	 * @param glDt
	 */
	public void setGlDt(String glDt) {
		this.glDt = glDt;
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
	 * @param sgmCtnt2
	 */
	public void setSgmCtnt2(String sgmCtnt2) {
		this.sgmCtnt2 = sgmCtnt2;
	}
	
	/**
	 * Column Info
	 * @param sgmCtnt3
	 */
	public void setSgmCtnt3(String sgmCtnt3) {
		this.sgmCtnt3 = sgmCtnt3;
	}
	
	/**
	 * Column Info
	 * @param sgmCtnt1
	 */
	public void setSgmCtnt1(String sgmCtnt1) {
		this.sgmCtnt1 = sgmCtnt1;
	}
	
	/**
	 * Column Info
	 * @param sgmCtnt6
	 */
	public void setSgmCtnt6(String sgmCtnt6) {
		this.sgmCtnt6 = sgmCtnt6;
	}
	
	/**
	 * Column Info
	 * @param sgmCtnt4
	 */
	public void setSgmCtnt4(String sgmCtnt4) {
		this.sgmCtnt4 = sgmCtnt4;
	}
	
	/**
	 * Column Info
	 * @param sgmCtnt5
	 */
	public void setSgmCtnt5(String sgmCtnt5) {
		this.sgmCtnt5 = sgmCtnt5;
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
		setGlDt(JSPUtil.getParameter(request, prefix + "gl_dt", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setSgmCtnt2(JSPUtil.getParameter(request, prefix + "sgm_ctnt2", ""));
		setSgmCtnt3(JSPUtil.getParameter(request, prefix + "sgm_ctnt3", ""));
		setSgmCtnt1(JSPUtil.getParameter(request, prefix + "sgm_ctnt1", ""));
		setSgmCtnt6(JSPUtil.getParameter(request, prefix + "sgm_ctnt6", ""));
		setSgmCtnt4(JSPUtil.getParameter(request, prefix + "sgm_ctnt4", ""));
		setSgmCtnt5(JSPUtil.getParameter(request, prefix + "sgm_ctnt5", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return LedgerCombinationCondVO[]
	 */
	public LedgerCombinationCondVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return LedgerCombinationCondVO[]
	 */
	public LedgerCombinationCondVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		LedgerCombinationCondVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] glDt = (JSPUtil.getParameter(request, prefix	+ "gl_dt", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] sgmCtnt2 = (JSPUtil.getParameter(request, prefix	+ "sgm_ctnt2", length));
			String[] sgmCtnt3 = (JSPUtil.getParameter(request, prefix	+ "sgm_ctnt3", length));
			String[] sgmCtnt1 = (JSPUtil.getParameter(request, prefix	+ "sgm_ctnt1", length));
			String[] sgmCtnt6 = (JSPUtil.getParameter(request, prefix	+ "sgm_ctnt6", length));
			String[] sgmCtnt4 = (JSPUtil.getParameter(request, prefix	+ "sgm_ctnt4", length));
			String[] sgmCtnt5 = (JSPUtil.getParameter(request, prefix	+ "sgm_ctnt5", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new LedgerCombinationCondVO();
				if (glDt[i] != null)
					model.setGlDt(glDt[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (sgmCtnt2[i] != null)
					model.setSgmCtnt2(sgmCtnt2[i]);
				if (sgmCtnt3[i] != null)
					model.setSgmCtnt3(sgmCtnt3[i]);
				if (sgmCtnt1[i] != null)
					model.setSgmCtnt1(sgmCtnt1[i]);
				if (sgmCtnt6[i] != null)
					model.setSgmCtnt6(sgmCtnt6[i]);
				if (sgmCtnt4[i] != null)
					model.setSgmCtnt4(sgmCtnt4[i]);
				if (sgmCtnt5[i] != null)
					model.setSgmCtnt5(sgmCtnt5[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getLedgerCombinationCondVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return LedgerCombinationCondVO[]
	 */
	public LedgerCombinationCondVO[] getLedgerCombinationCondVOs(){
		LedgerCombinationCondVO[] vos = (LedgerCombinationCondVO[])models.toArray(new LedgerCombinationCondVO[models.size()]);
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
		this.glDt = this.glDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sgmCtnt2 = this.sgmCtnt2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sgmCtnt3 = this.sgmCtnt3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sgmCtnt1 = this.sgmCtnt1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sgmCtnt6 = this.sgmCtnt6 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sgmCtnt4 = this.sgmCtnt4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sgmCtnt5 = this.sgmCtnt5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
