/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : BkgHrdCdgDescVO.java
*@FileTitle : BkgHrdCdgDescVO
*Open Issues :
*Change history :
*@LastModifyDate : 2012.04.17
*@LastModifier : 조정민
*@LastVersion : 1.0
* 2012.04.17 조정민 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.bookingmasterdata.bookingmastermgt.vo;

import java.lang.reflect.Field;
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
 * @author 조정민
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class BkgHrdCdgDescVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<BkgHrdCdgDescVO> models = new ArrayList<BkgHrdCdgDescVO>();
	
	/* Column Info */
	private String frmHrdCdgId = null;
	/* Column Info */
	private String attrNm8 = null;
	/* Column Info */
	private String attrNm9 = null;
	/* Column Info */
	private String hrdCdgDesc = null;
	/* Column Info */
	private String attrNm4 = null;
	/* Column Info */
	private String attrNm5 = null;
	/* Column Info */
	private String attrNm6 = null;
	/* Column Info */
	private String attrNm7 = null;
	/* Column Info */
	private String attrNm1 = null;
	/* Column Info */
	private String attrNm2 = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String attrNm3 = null;
	/* Column Info */
	private String attrNm10 = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String hrdCdgId = null;
	/* Column Info */
	private String userId = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public BkgHrdCdgDescVO() {}

	public BkgHrdCdgDescVO(String ibflag, String pagerows, String hrdCdgId, String hrdCdgDesc, String attrNm1, String attrNm2, String attrNm3, String attrNm4, String attrNm5, String attrNm6, String attrNm7, String attrNm8, String attrNm9, String attrNm10, String frmHrdCdgId, String userId) {
		this.frmHrdCdgId = frmHrdCdgId;
		this.attrNm8 = attrNm8;
		this.attrNm9 = attrNm9;
		this.hrdCdgDesc = hrdCdgDesc;
		this.attrNm4 = attrNm4;
		this.attrNm5 = attrNm5;
		this.attrNm6 = attrNm6;
		this.attrNm7 = attrNm7;
		this.attrNm1 = attrNm1;
		this.attrNm2 = attrNm2;
		this.pagerows = pagerows;
		this.attrNm3 = attrNm3;
		this.attrNm10 = attrNm10;
		this.ibflag = ibflag;
		this.hrdCdgId = hrdCdgId;
		this.userId = userId;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("frm_hrd_cdg_id", getFrmHrdCdgId());
		this.hashColumns.put("attr_nm8", getAttrNm8());
		this.hashColumns.put("attr_nm9", getAttrNm9());
		this.hashColumns.put("hrd_cdg_desc", getHrdCdgDesc());
		this.hashColumns.put("attr_nm4", getAttrNm4());
		this.hashColumns.put("attr_nm5", getAttrNm5());
		this.hashColumns.put("attr_nm6", getAttrNm6());
		this.hashColumns.put("attr_nm7", getAttrNm7());
		this.hashColumns.put("attr_nm1", getAttrNm1());
		this.hashColumns.put("attr_nm2", getAttrNm2());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("attr_nm3", getAttrNm3());
		this.hashColumns.put("attr_nm10", getAttrNm10());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("hrd_cdg_id", getHrdCdgId());
		this.hashColumns.put("user_id", getUserId());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("frm_hrd_cdg_id", "frmHrdCdgId");
		this.hashFields.put("attr_nm8", "attrNm8");
		this.hashFields.put("attr_nm9", "attrNm9");
		this.hashFields.put("hrd_cdg_desc", "hrdCdgDesc");
		this.hashFields.put("attr_nm4", "attrNm4");
		this.hashFields.put("attr_nm5", "attrNm5");
		this.hashFields.put("attr_nm6", "attrNm6");
		this.hashFields.put("attr_nm7", "attrNm7");
		this.hashFields.put("attr_nm1", "attrNm1");
		this.hashFields.put("attr_nm2", "attrNm2");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("attr_nm3", "attrNm3");
		this.hashFields.put("attr_nm10", "attrNm10");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("hrd_cdg_id", "hrdCdgId");
		this.hashFields.put("user_id", "userId");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return frmHrdCdgId
	 */
	public String getFrmHrdCdgId() {
		return this.frmHrdCdgId;
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
	 * Column Info
	 * @return hrdCdgDesc
	 */
	public String getHrdCdgDesc() {
		return this.hrdCdgDesc;
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
	 * @return attrNm5
	 */
	public String getAttrNm5() {
		return this.attrNm5;
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
	 * @return attrNm1
	 */
	public String getAttrNm1() {
		return this.attrNm1;
	}
	
	/**
	 * Column Info
	 * @return attrNm2
	 */
	public String getAttrNm2() {
		return this.attrNm2;
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
	 * @return attrNm3
	 */
	public String getAttrNm3() {
		return this.attrNm3;
	}
	
	/**
	 * Column Info
	 * @return attrNm10
	 */
	public String getAttrNm10() {
		return this.attrNm10;
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
	 * @return hrdCdgId
	 */
	public String getHrdCdgId() {
		return this.hrdCdgId;
	}
	
	/**
	 * Column Info
	 * @return userId
	 */
	public String getUserId() {
		return this.userId;
	}
	

	/**
	 * Column Info
	 * @param frmHrdCdgId
	 */
	public void setFrmHrdCdgId(String frmHrdCdgId) {
		this.frmHrdCdgId = frmHrdCdgId;
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
	 * Column Info
	 * @param hrdCdgDesc
	 */
	public void setHrdCdgDesc(String hrdCdgDesc) {
		this.hrdCdgDesc = hrdCdgDesc;
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
	 * @param attrNm5
	 */
	public void setAttrNm5(String attrNm5) {
		this.attrNm5 = attrNm5;
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
	 * @param attrNm1
	 */
	public void setAttrNm1(String attrNm1) {
		this.attrNm1 = attrNm1;
	}
	
	/**
	 * Column Info
	 * @param attrNm2
	 */
	public void setAttrNm2(String attrNm2) {
		this.attrNm2 = attrNm2;
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
	 * @param attrNm3
	 */
	public void setAttrNm3(String attrNm3) {
		this.attrNm3 = attrNm3;
	}
	
	/**
	 * Column Info
	 * @param attrNm10
	 */
	public void setAttrNm10(String attrNm10) {
		this.attrNm10 = attrNm10;
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
	 * @param hrdCdgId
	 */
	public void setHrdCdgId(String hrdCdgId) {
		this.hrdCdgId = hrdCdgId;
	}
	
	/**
	 * Column Info
	 * @param userId
	 */
	public void setUserId(String userId) {
		this.userId = userId;
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
		setFrmHrdCdgId(JSPUtil.getParameter(request, prefix + "frm_hrd_cdg_id", ""));
		setAttrNm8(JSPUtil.getParameter(request, prefix + "attr_nm8", ""));
		setAttrNm9(JSPUtil.getParameter(request, prefix + "attr_nm9", ""));
		setHrdCdgDesc(JSPUtil.getParameter(request, prefix + "hrd_cdg_desc", ""));
		setAttrNm4(JSPUtil.getParameter(request, prefix + "attr_nm4", ""));
		setAttrNm5(JSPUtil.getParameter(request, prefix + "attr_nm5", ""));
		setAttrNm6(JSPUtil.getParameter(request, prefix + "attr_nm6", ""));
		setAttrNm7(JSPUtil.getParameter(request, prefix + "attr_nm7", ""));
		setAttrNm1(JSPUtil.getParameter(request, prefix + "attr_nm1", ""));
		setAttrNm2(JSPUtil.getParameter(request, prefix + "attr_nm2", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setAttrNm3(JSPUtil.getParameter(request, prefix + "attr_nm3", ""));
		setAttrNm10(JSPUtil.getParameter(request, prefix + "attr_nm10", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setHrdCdgId(JSPUtil.getParameter(request, prefix + "hrd_cdg_id", ""));
		setUserId(JSPUtil.getParameter(request, prefix + "user_id", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return BkgHrdCdgDescVO[]
	 */
	public BkgHrdCdgDescVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return BkgHrdCdgDescVO[]
	 */
	public BkgHrdCdgDescVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		BkgHrdCdgDescVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] frmHrdCdgId = (JSPUtil.getParameter(request, prefix	+ "frm_hrd_cdg_id", length));
			String[] attrNm8 = (JSPUtil.getParameter(request, prefix	+ "attr_nm8", length));
			String[] attrNm9 = (JSPUtil.getParameter(request, prefix	+ "attr_nm9", length));
			String[] hrdCdgDesc = (JSPUtil.getParameter(request, prefix	+ "hrd_cdg_desc", length));
			String[] attrNm4 = (JSPUtil.getParameter(request, prefix	+ "attr_nm4", length));
			String[] attrNm5 = (JSPUtil.getParameter(request, prefix	+ "attr_nm5", length));
			String[] attrNm6 = (JSPUtil.getParameter(request, prefix	+ "attr_nm6", length));
			String[] attrNm7 = (JSPUtil.getParameter(request, prefix	+ "attr_nm7", length));
			String[] attrNm1 = (JSPUtil.getParameter(request, prefix	+ "attr_nm1", length));
			String[] attrNm2 = (JSPUtil.getParameter(request, prefix	+ "attr_nm2", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] attrNm3 = (JSPUtil.getParameter(request, prefix	+ "attr_nm3", length));
			String[] attrNm10 = (JSPUtil.getParameter(request, prefix	+ "attr_nm10", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] hrdCdgId = (JSPUtil.getParameter(request, prefix	+ "hrd_cdg_id", length));
			String[] userId = (JSPUtil.getParameter(request, prefix	+ "user_id", length));
			
			for (int i = 0; i < length; i++) {
				model = new BkgHrdCdgDescVO();
				if (frmHrdCdgId[i] != null)
					model.setFrmHrdCdgId(frmHrdCdgId[i]);
				if (attrNm8[i] != null)
					model.setAttrNm8(attrNm8[i]);
				if (attrNm9[i] != null)
					model.setAttrNm9(attrNm9[i]);
				if (hrdCdgDesc[i] != null)
					model.setHrdCdgDesc(hrdCdgDesc[i]);
				if (attrNm4[i] != null)
					model.setAttrNm4(attrNm4[i]);
				if (attrNm5[i] != null)
					model.setAttrNm5(attrNm5[i]);
				if (attrNm6[i] != null)
					model.setAttrNm6(attrNm6[i]);
				if (attrNm7[i] != null)
					model.setAttrNm7(attrNm7[i]);
				if (attrNm1[i] != null)
					model.setAttrNm1(attrNm1[i]);
				if (attrNm2[i] != null)
					model.setAttrNm2(attrNm2[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (attrNm3[i] != null)
					model.setAttrNm3(attrNm3[i]);
				if (attrNm10[i] != null)
					model.setAttrNm10(attrNm10[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (hrdCdgId[i] != null)
					model.setHrdCdgId(hrdCdgId[i]);
				if (userId[i] != null)
					model.setUserId(userId[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getBkgHrdCdgDescVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return BkgHrdCdgDescVO[]
	 */
	public BkgHrdCdgDescVO[] getBkgHrdCdgDescVOs(){
		BkgHrdCdgDescVO[] vos = (BkgHrdCdgDescVO[])models.toArray(new BkgHrdCdgDescVO[models.size()]);
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
		this.frmHrdCdgId = this.frmHrdCdgId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.attrNm8 = this.attrNm8 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.attrNm9 = this.attrNm9 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hrdCdgDesc = this.hrdCdgDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.attrNm4 = this.attrNm4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.attrNm5 = this.attrNm5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.attrNm6 = this.attrNm6 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.attrNm7 = this.attrNm7 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.attrNm1 = this.attrNm1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.attrNm2 = this.attrNm2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.attrNm3 = this.attrNm3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.attrNm10 = this.attrNm10 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hrdCdgId = this.hrdCdgId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.userId = this.userId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
