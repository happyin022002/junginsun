/*=========================================================
*Copyright(c) 2017 Hipluscard
*@FileName : BookingStowageVO.java
*@FileTitle : BookingStowageVO
*Open Issues :
*Change history :
*@LastModifyDate : 2017.06.29
*@LastModifier : 송민석
*@LastVersion : 1.0
* 2017.06.29 송민석 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.spc.basicdatamanage.constraintmaster.vo;

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
 * @author 송민석
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class BookingStowageVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<BookingStowageVO> models = new ArrayList<BookingStowageVO>();
	
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String val = null;
	/* Column Info */
	private String intgCdValDpSeq = null;
	/* Column Info */
	private String intgCdId = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String intgCdValDpDesc = null;
	/* Column Info */
	private String chk = null;
	/* Column Info */
	private String name = null;
	/* Column Info */
	private String multidesc = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public BookingStowageVO() {}

	public BookingStowageVO(String ibflag, String pagerows, String intgCdId, String val, String name, String intgCdValDpDesc, String intgCdValDpSeq, String multidesc, String chk) {
		this.pagerows = pagerows;
		this.val = val;
		this.intgCdValDpSeq = intgCdValDpSeq;
		this.intgCdId = intgCdId;
		this.ibflag = ibflag;
		this.intgCdValDpDesc = intgCdValDpDesc;
		this.chk = chk;
		this.name = name;
		this.multidesc = multidesc;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("val", getVal());
		this.hashColumns.put("intg_cd_val_dp_seq", getIntgCdValDpSeq());
		this.hashColumns.put("intg_cd_id", getIntgCdId());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("intg_cd_val_dp_desc", getIntgCdValDpDesc());
		this.hashColumns.put("chk", getChk());
		this.hashColumns.put("name", getName());
		this.hashColumns.put("multidesc", getMultidesc());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("val", "val");
		this.hashFields.put("intg_cd_val_dp_seq", "intgCdValDpSeq");
		this.hashFields.put("intg_cd_id", "intgCdId");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("intg_cd_val_dp_desc", "intgCdValDpDesc");
		this.hashFields.put("chk", "chk");
		this.hashFields.put("name", "name");
		this.hashFields.put("multidesc", "multidesc");
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
	 * @return val
	 */
	public String getVal() {
		return this.val;
	}
	
	/**
	 * Column Info
	 * @return intgCdValDpSeq
	 */
	public String getIntgCdValDpSeq() {
		return this.intgCdValDpSeq;
	}
	
	/**
	 * Column Info
	 * @return intgCdId
	 */
	public String getIntgCdId() {
		return this.intgCdId;
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
	 * @return intgCdValDpDesc
	 */
	public String getIntgCdValDpDesc() {
		return this.intgCdValDpDesc;
	}
	
	/**
	 * Column Info
	 * @return chk
	 */
	public String getChk() {
		return this.chk;
	}
	
	/**
	 * Column Info
	 * @return name
	 */
	public String getName() {
		return this.name;
	}
	
	/**
	 * Column Info
	 * @return multidesc
	 */
	public String getMultidesc() {
		return this.multidesc;
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
	 * @param val
	 */
	public void setVal(String val) {
		this.val = val;
	}
	
	/**
	 * Column Info
	 * @param intgCdValDpSeq
	 */
	public void setIntgCdValDpSeq(String intgCdValDpSeq) {
		this.intgCdValDpSeq = intgCdValDpSeq;
	}
	
	/**
	 * Column Info
	 * @param intgCdId
	 */
	public void setIntgCdId(String intgCdId) {
		this.intgCdId = intgCdId;
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
	 * @param intgCdValDpDesc
	 */
	public void setIntgCdValDpDesc(String intgCdValDpDesc) {
		this.intgCdValDpDesc = intgCdValDpDesc;
	}
	
	/**
	 * Column Info
	 * @param chk
	 */
	public void setChk(String chk) {
		this.chk = chk;
	}
	
	/**
	 * Column Info
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * Column Info
	 * @param multidesc
	 */
	public void setMultidesc(String multidesc) {
		this.multidesc = multidesc;
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
		setVal(JSPUtil.getParameter(request, prefix + "val", ""));
		setIntgCdValDpSeq(JSPUtil.getParameter(request, prefix + "intg_cd_val_dp_seq", ""));
		setIntgCdId(JSPUtil.getParameter(request, prefix + "intg_cd_id", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setIntgCdValDpDesc(JSPUtil.getParameter(request, prefix + "intg_cd_val_dp_desc", ""));
		setChk(JSPUtil.getParameter(request, prefix + "chk", ""));
		setName(JSPUtil.getParameter(request, prefix + "name", ""));
		setMultidesc(JSPUtil.getParameter(request, prefix + "multidesc", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return BookingStowageVO[]
	 */
	public BookingStowageVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return BookingStowageVO[]
	 */
	public BookingStowageVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		BookingStowageVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] val = (JSPUtil.getParameter(request, prefix	+ "val", length));
			String[] intgCdValDpSeq = (JSPUtil.getParameter(request, prefix	+ "intg_cd_val_dp_seq", length));
			String[] intgCdId = (JSPUtil.getParameter(request, prefix	+ "intg_cd_id", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] intgCdValDpDesc = (JSPUtil.getParameter(request, prefix	+ "intg_cd_val_dp_desc", length));
			String[] chk = (JSPUtil.getParameter(request, prefix	+ "chk", length));
			String[] name = (JSPUtil.getParameter(request, prefix	+ "name", length));
			String[] multidesc = (JSPUtil.getParameter(request, prefix	+ "multidesc", length));
			
			for (int i = 0; i < length; i++) {
				model = new BookingStowageVO();
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (val[i] != null)
					model.setVal(val[i]);
				if (intgCdValDpSeq[i] != null)
					model.setIntgCdValDpSeq(intgCdValDpSeq[i]);
				if (intgCdId[i] != null)
					model.setIntgCdId(intgCdId[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (intgCdValDpDesc[i] != null)
					model.setIntgCdValDpDesc(intgCdValDpDesc[i]);
				if (chk[i] != null)
					model.setChk(chk[i]);
				if (name[i] != null)
					model.setName(name[i]);
				if (multidesc[i] != null)
					model.setMultidesc(multidesc[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getBookingStowageVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return BookingStowageVO[]
	 */
	public BookingStowageVO[] getBookingStowageVOs(){
		BookingStowageVO[] vos = (BookingStowageVO[])models.toArray(new BookingStowageVO[models.size()]);
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
		this.val = this.val .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.intgCdValDpSeq = this.intgCdValDpSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.intgCdId = this.intgCdId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.intgCdValDpDesc = this.intgCdValDpDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chk = this.chk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.name = this.name .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.multidesc = this.multidesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
