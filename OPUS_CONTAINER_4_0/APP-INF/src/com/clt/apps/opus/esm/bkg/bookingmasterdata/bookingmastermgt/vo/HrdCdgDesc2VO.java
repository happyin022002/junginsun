/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : SearchHrdCdgDesc2VO.java
*@FileTitle : SearchHrdCdgDesc2VO
*Open Issues :
*Change history :
*@LastModifyDate : 2015.06.24
*@LastModifier : 
*@LastVersion : 1.0
* 2015.06.24  
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.bookingmasterdata.bookingmastermgt.vo;

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

public class HrdCdgDesc2VO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<HrdCdgDesc2VO> models = new ArrayList<HrdCdgDesc2VO>();
	
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String attrNm6 = null;
	/* Column Info */
	private String attrNm7 = null;
	/* Column Info */
	private String attrNm4 = null;
	/* Column Info */
	private String hrdCdgId = null;
	/* Column Info */
	private String attrNm5 = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String attrNm2 = null;
	/* Column Info */
	private String attrNm3 = null;
	/* Column Info */
	private String attrNm1 = null;
	/* Column Info */
	private String hrdCdgDesc = null;
	/* Column Info */
	private String attrNm10 = null;
	/* Column Info */
	private String attrNm8 = null;
	/* Column Info */
	private String attrNm9 = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public HrdCdgDesc2VO() {}

	public HrdCdgDesc2VO(String ibflag, String pagerows, String hrdCdgId, String hrdCdgDesc, String attrNm1, String attrNm2, String attrNm3, String attrNm4, String attrNm5, String attrNm6, String attrNm7, String attrNm8, String attrNm9, String attrNm10) {
		this.pagerows = pagerows;
		this.attrNm6 = attrNm6;
		this.attrNm7 = attrNm7;
		this.attrNm4 = attrNm4;
		this.hrdCdgId = hrdCdgId;
		this.attrNm5 = attrNm5;
		this.ibflag = ibflag;
		this.attrNm2 = attrNm2;
		this.attrNm3 = attrNm3;
		this.attrNm1 = attrNm1;
		this.hrdCdgDesc = hrdCdgDesc;
		this.attrNm10 = attrNm10;
		this.attrNm8 = attrNm8;
		this.attrNm9 = attrNm9;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("attr_nm6", getAttrNm6());
		this.hashColumns.put("attr_nm7", getAttrNm7());
		this.hashColumns.put("attr_nm4", getAttrNm4());
		this.hashColumns.put("hrd_cdg_id", getHrdCdgId());
		this.hashColumns.put("attr_nm5", getAttrNm5());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("attr_nm2", getAttrNm2());
		this.hashColumns.put("attr_nm3", getAttrNm3());
		this.hashColumns.put("attr_nm1", getAttrNm1());
		this.hashColumns.put("hrd_cdg_desc", getHrdCdgDesc());
		this.hashColumns.put("attr_nm10", getAttrNm10());
		this.hashColumns.put("attr_nm8", getAttrNm8());
		this.hashColumns.put("attr_nm9", getAttrNm9());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("attr_nm6", "attrNm6");
		this.hashFields.put("attr_nm7", "attrNm7");
		this.hashFields.put("attr_nm4", "attrNm4");
		this.hashFields.put("hrd_cdg_id", "hrdCdgId");
		this.hashFields.put("attr_nm5", "attrNm5");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("attr_nm2", "attrNm2");
		this.hashFields.put("attr_nm3", "attrNm3");
		this.hashFields.put("attr_nm1", "attrNm1");
		this.hashFields.put("hrd_cdg_desc", "hrdCdgDesc");
		this.hashFields.put("attr_nm10", "attrNm10");
		this.hashFields.put("attr_nm8", "attrNm8");
		this.hashFields.put("attr_nm9", "attrNm9");
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
	 * @return attrNm6
	 */
	public String getAttrNm6() {
		return this.attrNm6;
	}
	
	/**
	 * Column Info
	 * @return attrNm7
	 */
	public String getAttrNm7() {
		return this.attrNm7;
	}
	
	/**
	 * Column Info
	 * @return attrNm4
	 */
	public String getAttrNm4() {
		return this.attrNm4;
	}
	
	/**
	 * Column Info
	 * @return hrdCdgId
	 */
	public String getHrdCdgId() {
		return this.hrdCdgId;
	}
	
	/**
	 * Column Info
	 * @return attrNm5
	 */
	public String getAttrNm5() {
		return this.attrNm5;
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
	 * @return attrNm2
	 */
	public String getAttrNm2() {
		return this.attrNm2;
	}
	
	/**
	 * Column Info
	 * @return attrNm3
	 */
	public String getAttrNm3() {
		return this.attrNm3;
	}
	
	/**
	 * Column Info
	 * @return attrNm1
	 */
	public String getAttrNm1() {
		return this.attrNm1;
	}
	
	/**
	 * Column Info
	 * @return hrdCdgDesc
	 */
	public String getHrdCdgDesc() {
		return this.hrdCdgDesc;
	}
	
	/**
	 * Column Info
	 * @return attrNm10
	 */
	public String getAttrNm10() {
		return this.attrNm10;
	}
	
	/**
	 * Column Info
	 * @return attrNm8
	 */
	public String getAttrNm8() {
		return this.attrNm8;
	}
	
	/**
	 * Column Info
	 * @return attrNm9
	 */
	public String getAttrNm9() {
		return this.attrNm9;
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
	 * @param attrNm6
	 */
	public void setAttrNm6(String attrNm6) {
		this.attrNm6 = attrNm6;
	}
	
	/**
	 * Column Info
	 * @param attrNm7
	 */
	public void setAttrNm7(String attrNm7) {
		this.attrNm7 = attrNm7;
	}
	
	/**
	 * Column Info
	 * @param attrNm4
	 */
	public void setAttrNm4(String attrNm4) {
		this.attrNm4 = attrNm4;
	}
	
	/**
	 * Column Info
	 * @param hrdCdgId
	 */
	public void setHrdCdgId(String hrdCdgId) {
		this.hrdCdgId = hrdCdgId;
	}
	
	/**
	 * Column Info
	 * @param attrNm5
	 */
	public void setAttrNm5(String attrNm5) {
		this.attrNm5 = attrNm5;
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
	 * @param attrNm2
	 */
	public void setAttrNm2(String attrNm2) {
		this.attrNm2 = attrNm2;
	}
	
	/**
	 * Column Info
	 * @param attrNm3
	 */
	public void setAttrNm3(String attrNm3) {
		this.attrNm3 = attrNm3;
	}
	
	/**
	 * Column Info
	 * @param attrNm1
	 */
	public void setAttrNm1(String attrNm1) {
		this.attrNm1 = attrNm1;
	}
	
	/**
	 * Column Info
	 * @param hrdCdgDesc
	 */
	public void setHrdCdgDesc(String hrdCdgDesc) {
		this.hrdCdgDesc = hrdCdgDesc;
	}
	
	/**
	 * Column Info
	 * @param attrNm10
	 */
	public void setAttrNm10(String attrNm10) {
		this.attrNm10 = attrNm10;
	}
	
	/**
	 * Column Info
	 * @param attrNm8
	 */
	public void setAttrNm8(String attrNm8) {
		this.attrNm8 = attrNm8;
	}
	
	/**
	 * Column Info
	 * @param attrNm9
	 */
	public void setAttrNm9(String attrNm9) {
		this.attrNm9 = attrNm9;
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
		setAttrNm6(JSPUtil.getParameter(request, prefix + "attr_nm6", ""));
		setAttrNm7(JSPUtil.getParameter(request, prefix + "attr_nm7", ""));
		setAttrNm4(JSPUtil.getParameter(request, prefix + "attr_nm4", ""));
		setHrdCdgId(JSPUtil.getParameter(request, prefix + "hrd_cdg_id", ""));
		setAttrNm5(JSPUtil.getParameter(request, prefix + "attr_nm5", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setAttrNm2(JSPUtil.getParameter(request, prefix + "attr_nm2", ""));
		setAttrNm3(JSPUtil.getParameter(request, prefix + "attr_nm3", ""));
		setAttrNm1(JSPUtil.getParameter(request, prefix + "attr_nm1", ""));
		setHrdCdgDesc(JSPUtil.getParameter(request, prefix + "hrd_cdg_desc", ""));
		setAttrNm10(JSPUtil.getParameter(request, prefix + "attr_nm10", ""));
		setAttrNm8(JSPUtil.getParameter(request, prefix + "attr_nm8", ""));
		setAttrNm9(JSPUtil.getParameter(request, prefix + "attr_nm9", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return searchHrdCdgDesc2VO[]
	 */
	public HrdCdgDesc2VO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return searchHrdCdgDesc2VO[]
	 */
	public HrdCdgDesc2VO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		HrdCdgDesc2VO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] attrNm6 = (JSPUtil.getParameter(request, prefix	+ "attr_nm6", length));
			String[] attrNm7 = (JSPUtil.getParameter(request, prefix	+ "attr_nm7", length));
			String[] attrNm4 = (JSPUtil.getParameter(request, prefix	+ "attr_nm4", length));
			String[] hrdCdgId = (JSPUtil.getParameter(request, prefix	+ "hrd_cdg_id", length));
			String[] attrNm5 = (JSPUtil.getParameter(request, prefix	+ "attr_nm5", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] attrNm2 = (JSPUtil.getParameter(request, prefix	+ "attr_nm2", length));
			String[] attrNm3 = (JSPUtil.getParameter(request, prefix	+ "attr_nm3", length));
			String[] attrNm1 = (JSPUtil.getParameter(request, prefix	+ "attr_nm1", length));
			String[] hrdCdgDesc = (JSPUtil.getParameter(request, prefix	+ "hrd_cdg_desc", length));
			String[] attrNm10 = (JSPUtil.getParameter(request, prefix	+ "attr_nm10", length));
			String[] attrNm8 = (JSPUtil.getParameter(request, prefix	+ "attr_nm8", length));
			String[] attrNm9 = (JSPUtil.getParameter(request, prefix	+ "attr_nm9", length));
			
			for (int i = 0; i < length; i++) {
				model = new HrdCdgDesc2VO();
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (attrNm6[i] != null)
					model.setAttrNm6(attrNm6[i]);
				if (attrNm7[i] != null)
					model.setAttrNm7(attrNm7[i]);
				if (attrNm4[i] != null)
					model.setAttrNm4(attrNm4[i]);
				if (hrdCdgId[i] != null)
					model.setHrdCdgId(hrdCdgId[i]);
				if (attrNm5[i] != null)
					model.setAttrNm5(attrNm5[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (attrNm2[i] != null)
					model.setAttrNm2(attrNm2[i]);
				if (attrNm3[i] != null)
					model.setAttrNm3(attrNm3[i]);
				if (attrNm1[i] != null)
					model.setAttrNm1(attrNm1[i]);
				if (hrdCdgDesc[i] != null)
					model.setHrdCdgDesc(hrdCdgDesc[i]);
				if (attrNm10[i] != null)
					model.setAttrNm10(attrNm10[i]);
				if (attrNm8[i] != null)
					model.setAttrNm8(attrNm8[i]);
				if (attrNm9[i] != null)
					model.setAttrNm9(attrNm9[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getHrdCdgDesc2VOs();
	}

	/**
	 * VO 배열을 반환
	 * @return searchHrdCdgDesc2VO[]
	 */
	public HrdCdgDesc2VO[] getHrdCdgDesc2VOs(){
		HrdCdgDesc2VO[] vos = (HrdCdgDesc2VO[])models.toArray(new HrdCdgDesc2VO[models.size()]);
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
		this.attrNm6 = this.attrNm6 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.attrNm7 = this.attrNm7 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.attrNm4 = this.attrNm4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hrdCdgId = this.hrdCdgId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.attrNm5 = this.attrNm5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.attrNm2 = this.attrNm2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.attrNm3 = this.attrNm3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.attrNm1 = this.attrNm1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hrdCdgDesc = this.hrdCdgDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.attrNm10 = this.attrNm10 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.attrNm8 = this.attrNm8 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.attrNm9 = this.attrNm9 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
