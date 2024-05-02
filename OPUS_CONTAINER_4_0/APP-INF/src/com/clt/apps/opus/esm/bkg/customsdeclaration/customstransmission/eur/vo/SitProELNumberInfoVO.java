/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SitProELNumberInfoVO.java
*@FileTitle : SitProELNumberInfoVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.27
*@LastModifier : 경종윤
*@LastVersion : 1.0
* 2009.11.27 경종윤 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.eur.vo;

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
 * @author 경종윤
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SitProELNumberInfoVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SitProELNumberInfoVO> models = new ArrayList<SitProELNumberInfoVO>();
	
	/* Column Info */
	private String elpku = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String elwt = null;
	/* Column Info */
	private String elwtu = null;
	/* Column Info */
	private String elpk = null;
	/* Column Info */
	private String elno = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SitProELNumberInfoVO() {}

	public SitProELNumberInfoVO(String ibflag, String pagerows, String elno, String elpk, String elpku, String elwt, String elwtu) {
		this.elpku = elpku;
		this.ibflag = ibflag;
		this.elwt = elwt;
		this.elwtu = elwtu;
		this.elpk = elpk;
		this.elno = elno;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("elpku", getElpku());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("elwt", getElwt());
		this.hashColumns.put("elwtu", getElwtu());
		this.hashColumns.put("elpk", getElpk());
		this.hashColumns.put("elno", getElno());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("elpku", "elpku");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("elwt", "elwt");
		this.hashFields.put("elwtu", "elwtu");
		this.hashFields.put("elpk", "elpk");
		this.hashFields.put("elno", "elno");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return elpku
	 */
	public String getElpku() {
		return this.elpku;
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
	 * @return elwt
	 */
	public String getElwt() {
		return this.elwt;
	}
	
	/**
	 * Column Info
	 * @return elwtu
	 */
	public String getElwtu() {
		return this.elwtu;
	}
	
	/**
	 * Column Info
	 * @return elpk
	 */
	public String getElpk() {
		return this.elpk;
	}
	
	/**
	 * Column Info
	 * @return elno
	 */
	public String getElno() {
		return this.elno;
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
	 * @param elpku
	 */
	public void setElpku(String elpku) {
		this.elpku = elpku;
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
	 * @param elwt
	 */
	public void setElwt(String elwt) {
		this.elwt = elwt;
	}
	
	/**
	 * Column Info
	 * @param elwtu
	 */
	public void setElwtu(String elwtu) {
		this.elwtu = elwtu;
	}
	
	/**
	 * Column Info
	 * @param elpk
	 */
	public void setElpk(String elpk) {
		this.elpk = elpk;
	}
	
	/**
	 * Column Info
	 * @param elno
	 */
	public void setElno(String elno) {
		this.elno = elno;
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
		setElpku(JSPUtil.getParameter(request, "elpku", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setElwt(JSPUtil.getParameter(request, "elwt", ""));
		setElwtu(JSPUtil.getParameter(request, "elwtu", ""));
		setElpk(JSPUtil.getParameter(request, "elpk", ""));
		setElno(JSPUtil.getParameter(request, "elno", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SitProELNumberInfoVO[]
	 */
	public SitProELNumberInfoVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SitProELNumberInfoVO[]
	 */
	public SitProELNumberInfoVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SitProELNumberInfoVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] elpku = (JSPUtil.getParameter(request, prefix	+ "elpku", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] elwt = (JSPUtil.getParameter(request, prefix	+ "elwt", length));
			String[] elwtu = (JSPUtil.getParameter(request, prefix	+ "elwtu", length));
			String[] elpk = (JSPUtil.getParameter(request, prefix	+ "elpk", length));
			String[] elno = (JSPUtil.getParameter(request, prefix	+ "elno", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new SitProELNumberInfoVO();
				if (elpku[i] != null)
					model.setElpku(elpku[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (elwt[i] != null)
					model.setElwt(elwt[i]);
				if (elwtu[i] != null)
					model.setElwtu(elwtu[i]);
				if (elpk[i] != null)
					model.setElpk(elpk[i]);
				if (elno[i] != null)
					model.setElno(elno[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSitProELNumberInfoVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SitProELNumberInfoVO[]
	 */
	public SitProELNumberInfoVO[] getSitProELNumberInfoVOs(){
		SitProELNumberInfoVO[] vos = (SitProELNumberInfoVO[])models.toArray(new SitProELNumberInfoVO[models.size()]);
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
		this.elpku = this.elpku .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.elwt = this.elwt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.elwtu = this.elwtu .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.elpk = this.elpk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.elno = this.elno .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
