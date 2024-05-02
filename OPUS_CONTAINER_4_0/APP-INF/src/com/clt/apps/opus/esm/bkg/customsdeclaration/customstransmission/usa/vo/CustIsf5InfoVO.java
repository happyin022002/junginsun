/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : CustIsf5InfoVO.java
*@FileTitle : CustIsf5InfoVO
*Open Issues :
*Change history :
*@LastModifyDate : 2015.03.05
*@LastModifier : 
*@LastVersion : 1.0
* 2015.03.05 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.usa.vo;

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
public class CustIsf5InfoVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<CustIsf5InfoVO> models = new ArrayList<CustIsf5InfoVO>();
	
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	
	/* Page Number */
	private String pagerows = null;

	/* Column Info */
	private String bkpN00 = null;

	/* Column Info */
	private String bkpN02 = null;

	/* Column Info */
	private String bkpN03 = null;

	/* Column Info */
	private String stN00 = null;

	/* Column Info */
	private String stN02 = null;

	/* Column Info */
	private String stN03 = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public CustIsf5InfoVO() {}

	public CustIsf5InfoVO(String ibflag, String pagerows, String bkpN00, String bkpN02, String bkpN03, String stN00, String stN02, String stN03) {
		this.ibflag = ibflag;
		this.pagerows = pagerows;
		this.bkpN00 = bkpN00;
		this.bkpN02 = bkpN02;
		this.bkpN03 = bkpN03;
		this.stN00 = stN00;
		this.stN02 = stN02;
		this.stN03 = stN03;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("bkp_n00", getBkpN00());
		this.hashColumns.put("bkp_n02", getBkpN02());
		this.hashColumns.put("bkp_n03", getBkpN03());
		this.hashColumns.put("st_n00", getStN00());
		this.hashColumns.put("st_n02", getStN02());
		this.hashColumns.put("st_n03", getStN03());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("bkp_n00", "bkpN00");
		this.hashFields.put("bkp_n02", "bkpN02");
		this.hashFields.put("bkp_n03", "bkpN03");
		this.hashFields.put("st_n00", "stN00");
		this.hashFields.put("st_n02", "stN02");
		this.hashFields.put("st_n03", "stN03");
		return this.hashFields;
	}
	
	/**
	 *
	 * @param String ibflag
	 */
	public void setIbflag(String ibflag) {
		this.ibflag = ibflag;
	}
	
	/**
	 * 
	 * @return String ibflag
	 */
	public String getIbflag() {
		return this.ibflag;
	}
	
	/**
	 *
	 * @param String pagerows
	 */
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
	}
	
	/**
	 * 
	 * @return String pagerows
	 */
	public String getPagerows() {
		return this.pagerows;
	}
	
	/**
	 *
	 * @param String bkpN00
	 */
	public void setBkpN00(String bkpN00) {
		this.bkpN00 = bkpN00;
	}
	
	/**
	 * 
	 * @return String bkpN00
	 */
	public String getBkpN00() {
		return this.bkpN00;
	}
	
	/**
	 *
	 * @param String bkpN02
	 */
	public void setBkpN02(String bkpN02) {
		this.bkpN02 = bkpN02;
	}
	
	/**
	 * 
	 * @return String bkpN02
	 */
	public String getBkpN02() {
		return this.bkpN02;
	}
	
	/**
	 *
	 * @param String bkpN03
	 */
	public void setBkpN03(String bkpN03) {
		this.bkpN03 = bkpN03;
	}
	
	/**
	 * 
	 * @return String bkpN03
	 */
	public String getBkpN03() {
		return this.bkpN03;
	}
	
	/**
	 *
	 * @param String stN00
	 */
	public void setStN00(String stN00) {
		this.stN00 = stN00;
	}
	
	/**
	 * 
	 * @return String stN00
	 */
	public String getStN00() {
		return this.stN00;
	}
	
	/**
	 *
	 * @param String stN02
	 */
	public void setStN02(String stN02) {
		this.stN02 = stN02;
	}
	
	/**
	 * 
	 * @return String stN02
	 */
	public String getStN02() {
		return this.stN02;
	}
	
	/**
	 *
	 * @param String stN03
	 */
	public void setStN03(String stN03) {
		this.stN03 = stN03;
	}
	
	/**
	 * 
	 * @return String stN03
	 */
	public String getStN03() {
		return this.stN03;
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
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setBkpN00(JSPUtil.getParameter(request, prefix + "bkp_n00", ""));
		setBkpN02(JSPUtil.getParameter(request, prefix + "bkp_n02", ""));
		setBkpN03(JSPUtil.getParameter(request, prefix + "bkp_n03", ""));
		setStN00(JSPUtil.getParameter(request, prefix + "st_n00", ""));
		setStN02(JSPUtil.getParameter(request, prefix + "st_n02", ""));
		setStN03(JSPUtil.getParameter(request, prefix + "st_n03", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return CustIsf5InfoVO[]
	 */
	public CustIsf5InfoVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return CustIsf5InfoVO[]
	 */
	public CustIsf5InfoVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		CustIsf5InfoVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] bkpN00 = (JSPUtil.getParameter(request, prefix	+ "bkp_n00", length));
			String[] bkpN02 = (JSPUtil.getParameter(request, prefix	+ "bkp_n02", length));
			String[] bkpN03 = (JSPUtil.getParameter(request, prefix	+ "bkp_n03", length));
			String[] stN00 = (JSPUtil.getParameter(request, prefix	+ "st_n00", length));
			String[] stN02 = (JSPUtil.getParameter(request, prefix	+ "st_n02", length));
			String[] stN03 = (JSPUtil.getParameter(request, prefix	+ "st_n03", length));
			/* Add a field line, do not delete */
			
			for (int i = 0; i < length; i++) {
				model = new CustIsf5InfoVO();
				if (ibflag[i] != null) 
					model.setIbflag(ibflag[i]);
				if (pagerows[i] != null) 
					model.setPagerows(pagerows[i]);
				if (bkpN00[i] != null) 
					model.setBkpN00(bkpN00[i]);
				if (bkpN02[i] != null) 
					model.setBkpN02(bkpN02[i]);
				if (bkpN03[i] != null) 
					model.setBkpN03(bkpN03[i]);
				if (stN00[i] != null) 
					model.setStN00(stN00[i]);
				if (stN02[i] != null) 
					model.setStN02(stN02[i]);
				if (stN03[i] != null) 
					model.setStN03(stN03[i]);
				/* Add a Method line, do not delete */
				
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getCustIsf5InfoVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return CustIsf5InfoVO[]
	 */
	public CustIsf5InfoVO[] getCustIsf5InfoVOs(){
		CustIsf5InfoVO[] vos = (CustIsf5InfoVO[])models.toArray(new CustIsf5InfoVO[models.size()]);
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
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkpN00 = this.bkpN00 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkpN02 = this.bkpN02 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkpN03 = this.bkpN03 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stN00 = this.stN00 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stN02 = this.stN02 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stN03 = this.stN03 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}