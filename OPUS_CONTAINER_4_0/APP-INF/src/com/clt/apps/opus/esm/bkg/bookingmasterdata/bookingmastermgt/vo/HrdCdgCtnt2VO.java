/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : HrdCdgCtnt2VO.java
*@FileTitle : HrdCdgCtnt2VO
*Open Issues :
*Change history :
*@LastModifyDate : 2015.06.25
*@LastModifier : 
*@LastVersion : 1.0
* 2015.06.25  
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

public class HrdCdgCtnt2VO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<HrdCdgCtnt2VO> models = new ArrayList<HrdCdgCtnt2VO>();
	
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String hrdCdgId = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String attrCtnt8 = null;
	/* Column Info */
	private String attrCtnt10 = null;
	/* Column Info */
	private String attrCtnt9 = null;
	/* Column Info */
	private String attrCtnt1 = null;
	/* Column Info */
	private String attrCtnt2 = null;
	/* Column Info */
	private String attrCtnt3 = null;
	/* Column Info */
	private String hrdCdgIdSeq = null;
	/* Column Info */
	private String attrCtnt4 = null;
	/* Column Info */
	private String attrCtnt5 = null;
	/* Column Info */
	private String attrCtnt6 = null;
	/* Column Info */
	private String attrCtnt7 = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public HrdCdgCtnt2VO() {}

	public HrdCdgCtnt2VO(String ibflag, String pagerows, String hrdCdgId, String hrdCdgIdSeq, String attrCtnt1, String attrCtnt2, String attrCtnt3, String attrCtnt4, String attrCtnt5, String attrCtnt6, String attrCtnt7, String attrCtnt8, String attrCtnt9, String attrCtnt10) {
		this.pagerows = pagerows;
		this.hrdCdgId = hrdCdgId;
		this.ibflag = ibflag;
		this.attrCtnt8 = attrCtnt8;
		this.attrCtnt10 = attrCtnt10;
		this.attrCtnt9 = attrCtnt9;
		this.attrCtnt1 = attrCtnt1;
		this.attrCtnt2 = attrCtnt2;
		this.attrCtnt3 = attrCtnt3;
		this.hrdCdgIdSeq = hrdCdgIdSeq;
		this.attrCtnt4 = attrCtnt4;
		this.attrCtnt5 = attrCtnt5;
		this.attrCtnt6 = attrCtnt6;
		this.attrCtnt7 = attrCtnt7;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("hrd_cdg_id", getHrdCdgId());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("attr_ctnt8", getAttrCtnt8());
		this.hashColumns.put("attr_ctnt10", getAttrCtnt10());
		this.hashColumns.put("attr_ctnt9", getAttrCtnt9());
		this.hashColumns.put("attr_ctnt1", getAttrCtnt1());
		this.hashColumns.put("attr_ctnt2", getAttrCtnt2());
		this.hashColumns.put("attr_ctnt3", getAttrCtnt3());
		this.hashColumns.put("hrd_cdg_id_seq", getHrdCdgIdSeq());
		this.hashColumns.put("attr_ctnt4", getAttrCtnt4());
		this.hashColumns.put("attr_ctnt5", getAttrCtnt5());
		this.hashColumns.put("attr_ctnt6", getAttrCtnt6());
		this.hashColumns.put("attr_ctnt7", getAttrCtnt7());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("hrd_cdg_id", "hrdCdgId");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("attr_ctnt8", "attrCtnt8");
		this.hashFields.put("attr_ctnt10", "attrCtnt10");
		this.hashFields.put("attr_ctnt9", "attrCtnt9");
		this.hashFields.put("attr_ctnt1", "attrCtnt1");
		this.hashFields.put("attr_ctnt2", "attrCtnt2");
		this.hashFields.put("attr_ctnt3", "attrCtnt3");
		this.hashFields.put("hrd_cdg_id_seq", "hrdCdgIdSeq");
		this.hashFields.put("attr_ctnt4", "attrCtnt4");
		this.hashFields.put("attr_ctnt5", "attrCtnt5");
		this.hashFields.put("attr_ctnt6", "attrCtnt6");
		this.hashFields.put("attr_ctnt7", "attrCtnt7");
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
	 * @return hrdCdgId
	 */
	public String getHrdCdgId() {
		return this.hrdCdgId;
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
	 * @return attrCtnt8
	 */
	public String getAttrCtnt8() {
		return this.attrCtnt8;
	}
	
	/**
	 * Column Info
	 * @return attrCtnt10
	 */
	public String getAttrCtnt10() {
		return this.attrCtnt10;
	}
	
	/**
	 * Column Info
	 * @return attrCtnt9
	 */
	public String getAttrCtnt9() {
		return this.attrCtnt9;
	}
	
	/**
	 * Column Info
	 * @return attrCtnt1
	 */
	public String getAttrCtnt1() {
		return this.attrCtnt1;
	}
	
	/**
	 * Column Info
	 * @return attrCtnt2
	 */
	public String getAttrCtnt2() {
		return this.attrCtnt2;
	}
	
	/**
	 * Column Info
	 * @return attrCtnt3
	 */
	public String getAttrCtnt3() {
		return this.attrCtnt3;
	}
	
	/**
	 * Column Info
	 * @return hrdCdgIdSeq
	 */
	public String getHrdCdgIdSeq() {
		return this.hrdCdgIdSeq;
	}
	
	/**
	 * Column Info
	 * @return attrCtnt4
	 */
	public String getAttrCtnt4() {
		return this.attrCtnt4;
	}
	
	/**
	 * Column Info
	 * @return attrCtnt5
	 */
	public String getAttrCtnt5() {
		return this.attrCtnt5;
	}
	
	/**
	 * Column Info
	 * @return attrCtnt6
	 */
	public String getAttrCtnt6() {
		return this.attrCtnt6;
	}
	
	/**
	 * Column Info
	 * @return attrCtnt7
	 */
	public String getAttrCtnt7() {
		return this.attrCtnt7;
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
	 * @param hrdCdgId
	 */
	public void setHrdCdgId(String hrdCdgId) {
		this.hrdCdgId = hrdCdgId;
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
	 * @param attrCtnt8
	 */
	public void setAttrCtnt8(String attrCtnt8) {
		this.attrCtnt8 = attrCtnt8;
	}
	
	/**
	 * Column Info
	 * @param attrCtnt10
	 */
	public void setAttrCtnt10(String attrCtnt10) {
		this.attrCtnt10 = attrCtnt10;
	}
	
	/**
	 * Column Info
	 * @param attrCtnt9
	 */
	public void setAttrCtnt9(String attrCtnt9) {
		this.attrCtnt9 = attrCtnt9;
	}
	
	/**
	 * Column Info
	 * @param attrCtnt1
	 */
	public void setAttrCtnt1(String attrCtnt1) {
		this.attrCtnt1 = attrCtnt1;
	}
	
	/**
	 * Column Info
	 * @param attrCtnt2
	 */
	public void setAttrCtnt2(String attrCtnt2) {
		this.attrCtnt2 = attrCtnt2;
	}
	
	/**
	 * Column Info
	 * @param attrCtnt3
	 */
	public void setAttrCtnt3(String attrCtnt3) {
		this.attrCtnt3 = attrCtnt3;
	}
	
	/**
	 * Column Info
	 * @param hrdCdgIdSeq
	 */
	public void setHrdCdgIdSeq(String hrdCdgIdSeq) {
		this.hrdCdgIdSeq = hrdCdgIdSeq;
	}
	
	/**
	 * Column Info
	 * @param attrCtnt4
	 */
	public void setAttrCtnt4(String attrCtnt4) {
		this.attrCtnt4 = attrCtnt4;
	}
	
	/**
	 * Column Info
	 * @param attrCtnt5
	 */
	public void setAttrCtnt5(String attrCtnt5) {
		this.attrCtnt5 = attrCtnt5;
	}
	
	/**
	 * Column Info
	 * @param attrCtnt6
	 */
	public void setAttrCtnt6(String attrCtnt6) {
		this.attrCtnt6 = attrCtnt6;
	}
	
	/**
	 * Column Info
	 * @param attrCtnt7
	 */
	public void setAttrCtnt7(String attrCtnt7) {
		this.attrCtnt7 = attrCtnt7;
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
		setHrdCdgId(JSPUtil.getParameter(request, prefix + "hrd_cdg_id", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setAttrCtnt8(JSPUtil.getParameter(request, prefix + "attr_ctnt8", ""));
		setAttrCtnt10(JSPUtil.getParameter(request, prefix + "attr_ctnt10", ""));
		setAttrCtnt9(JSPUtil.getParameter(request, prefix + "attr_ctnt9", ""));
		setAttrCtnt1(JSPUtil.getParameter(request, prefix + "attr_ctnt1", ""));
		setAttrCtnt2(JSPUtil.getParameter(request, prefix + "attr_ctnt2", ""));
		setAttrCtnt3(JSPUtil.getParameter(request, prefix + "attr_ctnt3", ""));
		setHrdCdgIdSeq(JSPUtil.getParameter(request, prefix + "hrd_cdg_id_seq", ""));
		setAttrCtnt4(JSPUtil.getParameter(request, prefix + "attr_ctnt4", ""));
		setAttrCtnt5(JSPUtil.getParameter(request, prefix + "attr_ctnt5", ""));
		setAttrCtnt6(JSPUtil.getParameter(request, prefix + "attr_ctnt6", ""));
		setAttrCtnt7(JSPUtil.getParameter(request, prefix + "attr_ctnt7", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return HrdCdgCtnt2VO[]
	 */
	public HrdCdgCtnt2VO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return HrdCdgCtnt2VO[]
	 */
	public HrdCdgCtnt2VO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		HrdCdgCtnt2VO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] hrdCdgId = (JSPUtil.getParameter(request, prefix	+ "hrd_cdg_id", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] attrCtnt8 = (JSPUtil.getParameter(request, prefix	+ "attr_ctnt8", length));
			String[] attrCtnt10 = (JSPUtil.getParameter(request, prefix	+ "attr_ctnt10", length));
			String[] attrCtnt9 = (JSPUtil.getParameter(request, prefix	+ "attr_ctnt9", length));
			String[] attrCtnt1 = (JSPUtil.getParameter(request, prefix	+ "attr_ctnt1", length));
			String[] attrCtnt2 = (JSPUtil.getParameter(request, prefix	+ "attr_ctnt2", length));
			String[] attrCtnt3 = (JSPUtil.getParameter(request, prefix	+ "attr_ctnt3", length));
			String[] hrdCdgIdSeq = (JSPUtil.getParameter(request, prefix	+ "hrd_cdg_id_seq", length));
			String[] attrCtnt4 = (JSPUtil.getParameter(request, prefix	+ "attr_ctnt4", length));
			String[] attrCtnt5 = (JSPUtil.getParameter(request, prefix	+ "attr_ctnt5", length));
			String[] attrCtnt6 = (JSPUtil.getParameter(request, prefix	+ "attr_ctnt6", length));
			String[] attrCtnt7 = (JSPUtil.getParameter(request, prefix	+ "attr_ctnt7", length));
			
			for (int i = 0; i < length; i++) {
				model = new HrdCdgCtnt2VO();
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (hrdCdgId[i] != null)
					model.setHrdCdgId(hrdCdgId[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (attrCtnt8[i] != null)
					model.setAttrCtnt8(attrCtnt8[i]);
				if (attrCtnt10[i] != null)
					model.setAttrCtnt10(attrCtnt10[i]);
				if (attrCtnt9[i] != null)
					model.setAttrCtnt9(attrCtnt9[i]);
				if (attrCtnt1[i] != null)
					model.setAttrCtnt1(attrCtnt1[i]);
				if (attrCtnt2[i] != null)
					model.setAttrCtnt2(attrCtnt2[i]);
				if (attrCtnt3[i] != null)
					model.setAttrCtnt3(attrCtnt3[i]);
				if (hrdCdgIdSeq[i] != null)
					model.setHrdCdgIdSeq(hrdCdgIdSeq[i]);
				if (attrCtnt4[i] != null)
					model.setAttrCtnt4(attrCtnt4[i]);
				if (attrCtnt5[i] != null)
					model.setAttrCtnt5(attrCtnt5[i]);
				if (attrCtnt6[i] != null)
					model.setAttrCtnt6(attrCtnt6[i]);
				if (attrCtnt7[i] != null)
					model.setAttrCtnt7(attrCtnt7[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getHrdCdgCtnt2VOs();
	}

	/**
	 * VO 배열을 반환
	 * @return HrdCdgCtnt2VO[]
	 */
	public HrdCdgCtnt2VO[] getHrdCdgCtnt2VOs(){
		HrdCdgCtnt2VO[] vos = (HrdCdgCtnt2VO[])models.toArray(new HrdCdgCtnt2VO[models.size()]);
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
		this.hrdCdgId = this.hrdCdgId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.attrCtnt8 = this.attrCtnt8 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.attrCtnt10 = this.attrCtnt10 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.attrCtnt9 = this.attrCtnt9 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.attrCtnt1 = this.attrCtnt1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.attrCtnt2 = this.attrCtnt2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.attrCtnt3 = this.attrCtnt3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hrdCdgIdSeq = this.hrdCdgIdSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.attrCtnt4 = this.attrCtnt4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.attrCtnt5 = this.attrCtnt5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.attrCtnt6 = this.attrCtnt6 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.attrCtnt7 = this.attrCtnt7 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
