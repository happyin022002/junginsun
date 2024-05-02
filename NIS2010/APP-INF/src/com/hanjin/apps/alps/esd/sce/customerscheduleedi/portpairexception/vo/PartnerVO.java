/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : PartnerVO.java
*@FileTitle : PartnerVO
*Open Issues :
*Change history :
*@LastModifyDate : 2013.09.25
*@LastModifier : 
*@LastVersion : 1.0
* 2013.09.25  
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esd.sce.customerscheduleedi.portpairexception.vo;

import java.lang.reflect.Field;
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
 * @author  
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class PartnerVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<PartnerVO> models = new ArrayList<PartnerVO>();
	
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String custTrdPrnrNm = null;
	/* Column Info */
	private String custTrdPrnrId = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String comboCd = null;
    /* Column Info */
    private String val = null;
	/* Column Info */
	private String name = null;
	/* Column Info */
	private String desct = null;
	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public PartnerVO() {}

	public PartnerVO(String ibflag, String pagerows, String custTrdPrnrId, String custTrdPrnrNm, String val, String name, String desct, String comboCd) {
		this.ibflag = ibflag;
		this.custTrdPrnrNm = custTrdPrnrNm;
		this.custTrdPrnrId = custTrdPrnrId;
		this.pagerows = pagerows;
		this.comboCd = comboCd;
		this.name = name;
		this.desct = desct;
		this.val = val;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cust_trd_prnr_nm", getCustTrdPrnrNm());
		this.hashColumns.put("cust_trd_prnr_id", getCustTrdPrnrId());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("combo_cd", getComboCd());
		this.hashColumns.put("name", getName());
		this.hashColumns.put("desct", getDesct());
		this.hashColumns.put("val", getVal());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cust_trd_prnr_nm", "custTrdPrnrNm");
		this.hashFields.put("cust_trd_prnr_id", "custTrdPrnrId");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("combo_cd", "comboCd");
		this.hashFields.put("name", "name");
		this.hashFields.put("desct", "desct");
		this.hashFields.put("val", "val");
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
	 * @return custTrdPrnrNm
	 */
	public String getCustTrdPrnrNm() {
		return this.custTrdPrnrNm;
	}
	
	/**
	 * Column Info
	 * @return custTrdPrnrId
	 */
	public String getCustTrdPrnrId() {
		return this.custTrdPrnrId;
	}
	
	/**
	 * Page Number
	 * @return pagerows
	 */
	public String getPagerows() {
		return this.pagerows;
	}
	

	public String getComboCd() {
		return comboCd;
	}

	public void setComboCd(String comboCd) {
		this.comboCd = comboCd;
	}

	public String getVal() {
		return val;
	}

	public void setVal(String val) {
		this.val = val;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDesct() {
		return desct;
	}

	public void setDesct(String desct) {
		this.desct = desct;
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
	 * @param custTrdPrnrNm
	 */
	public void setCustTrdPrnrNm(String custTrdPrnrNm) {
		this.custTrdPrnrNm = custTrdPrnrNm;
	}
	
	/**
	 * Column Info
	 * @param custTrdPrnrId
	 */
	public void setCustTrdPrnrId(String custTrdPrnrId) {
		this.custTrdPrnrId = custTrdPrnrId;
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
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setCustTrdPrnrNm(JSPUtil.getParameter(request, prefix + "cust_trd_prnr_nm", ""));
		setCustTrdPrnrId(JSPUtil.getParameter(request, prefix + "cust_trd_prnr_id", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setComboCd(JSPUtil.getParameter(request, prefix + "combo_cd", ""));
		setName(JSPUtil.getParameter(request, prefix + "name", ""));
		setDesct(JSPUtil.getParameter(request, prefix + "desct", ""));
		setVal(JSPUtil.getParameter(request, prefix + "val", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return PartnerVO[]
	 */
	public PartnerVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return PartnerVO[]
	 */
	public PartnerVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		PartnerVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] custTrdPrnrNm = (JSPUtil.getParameter(request, prefix	+ "cust_trd_prnr_nm", length));
			String[] custTrdPrnrId = (JSPUtil.getParameter(request, prefix	+ "cust_trd_prnr_id", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] comboCd = (JSPUtil.getParameter(request, prefix	+ "combo_cd".trim(), length));
			String[] name = (JSPUtil.getParameter(request, prefix	+ "name".trim(), length));
			String[] desct = (JSPUtil.getParameter(request, prefix	+ "desct".trim(), length));
			String[] val = (JSPUtil.getParameter(request, prefix	+ "val".trim(), length));
			
			for (int i = 0; i < length; i++) {
				model = new PartnerVO();
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (custTrdPrnrNm[i] != null)
					model.setCustTrdPrnrNm(custTrdPrnrNm[i]);
				if (custTrdPrnrId[i] != null)
					model.setCustTrdPrnrId(custTrdPrnrId[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (comboCd[i] != null)
					model.setComboCd(comboCd[i]);
				if (name[i] != null)
					model.setName(name[i]);
				if (desct[i] != null)
					model.setDesct(desct[i]);
				if (val[i] != null)
					model.setVal(val[i]);				
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getPartnerVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return PartnerVO[]
	 */
	public PartnerVO[] getPartnerVOs(){
		PartnerVO[] vos = (PartnerVO[])models.toArray(new PartnerVO[models.size()]);
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
		this.custTrdPrnrNm = this.custTrdPrnrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custTrdPrnrId = this.custTrdPrnrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.comboCd = this.comboCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.name = this.name .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.desct = this.desct .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.val = this.val .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
