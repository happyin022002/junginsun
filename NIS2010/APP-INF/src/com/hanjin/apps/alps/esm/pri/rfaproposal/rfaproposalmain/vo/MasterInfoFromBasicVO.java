/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : MasterInfoFromBasicVO.java
*@FileTitle : MasterInfoFromBasicVO
*Open Issues :
*Change history :
*@LastModifyDate : 2017.06.15
*@LastModifier : 
*@LastVersion : 1.0
* 2017.06.15  
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.pri.rfaproposal.rfaproposalmain.vo;

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

public class MasterInfoFromBasicVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<MasterInfoFromBasicVO> models = new ArrayList<MasterInfoFromBasicVO>();
	
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String mstRfaNo = null;
	/* Column Info */
	private String mstAmdtSeq = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String mstPropNo = null;
	/* Column Info */
	private String propNo = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public MasterInfoFromBasicVO() {}

	public MasterInfoFromBasicVO(String ibflag, String pagerows, String propNo, String mstPropNo, String mstRfaNo, String mstAmdtSeq) {
		this.pagerows = pagerows;
		this.mstRfaNo = mstRfaNo;
		this.mstAmdtSeq = mstAmdtSeq;
		this.ibflag = ibflag;
		this.mstPropNo = mstPropNo;
		this.propNo = propNo;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("mst_rfa_no", getMstRfaNo());
		this.hashColumns.put("mst_amdt_seq", getMstAmdtSeq());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("mst_prop_no", getMstPropNo());
		this.hashColumns.put("prop_no", getPropNo());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("mst_rfa_no", "mstRfaNo");
		this.hashFields.put("mst_amdt_seq", "mstAmdtSeq");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("mst_prop_no", "mstPropNo");
		this.hashFields.put("prop_no", "propNo");
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
	 * @return mstRfaNo
	 */
	public String getMstRfaNo() {
		return this.mstRfaNo;
	}
	
	/**
	 * Column Info
	 * @return mstAmdtSeq
	 */
	public String getMstAmdtSeq() {
		return this.mstAmdtSeq;
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
	 * @return mstPropNo
	 */
	public String getMstPropNo() {
		return this.mstPropNo;
	}
	
	/**
	 * Column Info
	 * @return propNo
	 */
	public String getPropNo() {
		return this.propNo;
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
	 * @param mstRfaNo
	 */
	public void setMstRfaNo(String mstRfaNo) {
		this.mstRfaNo = mstRfaNo;
	}
	
	/**
	 * Column Info
	 * @param mstAmdtSeq
	 */
	public void setMstAmdtSeq(String mstAmdtSeq) {
		this.mstAmdtSeq = mstAmdtSeq;
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
	 * @param mstPropNo
	 */
	public void setMstPropNo(String mstPropNo) {
		this.mstPropNo = mstPropNo;
	}
	
	/**
	 * Column Info
	 * @param propNo
	 */
	public void setPropNo(String propNo) {
		this.propNo = propNo;
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
		setMstRfaNo(JSPUtil.getParameter(request, prefix + "mst_rfa_no", ""));
		setMstAmdtSeq(JSPUtil.getParameter(request, prefix + "mst_amdt_seq", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setMstPropNo(JSPUtil.getParameter(request, prefix + "mst_prop_no", ""));
		setPropNo(JSPUtil.getParameter(request, prefix + "prop_no", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return MasterInfoFromBasicVO[]
	 */
	public MasterInfoFromBasicVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return MasterInfoFromBasicVO[]
	 */
	public MasterInfoFromBasicVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		MasterInfoFromBasicVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] mstRfaNo = (JSPUtil.getParameter(request, prefix	+ "mst_rfa_no", length));
			String[] mstAmdtSeq = (JSPUtil.getParameter(request, prefix	+ "mst_amdt_seq", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] mstPropNo = (JSPUtil.getParameter(request, prefix	+ "mst_prop_no", length));
			String[] propNo = (JSPUtil.getParameter(request, prefix	+ "prop_no", length));
			
			for (int i = 0; i < length; i++) {
				model = new MasterInfoFromBasicVO();
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (mstRfaNo[i] != null)
					model.setMstRfaNo(mstRfaNo[i]);
				if (mstAmdtSeq[i] != null)
					model.setMstAmdtSeq(mstAmdtSeq[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (mstPropNo[i] != null)
					model.setMstPropNo(mstPropNo[i]);
				if (propNo[i] != null)
					model.setPropNo(propNo[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getMasterInfoFromBasicVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return MasterInfoFromBasicVO[]
	 */
	public MasterInfoFromBasicVO[] getMasterInfoFromBasicVOs(){
		MasterInfoFromBasicVO[] vos = (MasterInfoFromBasicVO[])models.toArray(new MasterInfoFromBasicVO[models.size()]);
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
		this.mstRfaNo = this.mstRfaNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mstAmdtSeq = this.mstAmdtSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mstPropNo = this.mstPropNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.propNo = this.propNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
