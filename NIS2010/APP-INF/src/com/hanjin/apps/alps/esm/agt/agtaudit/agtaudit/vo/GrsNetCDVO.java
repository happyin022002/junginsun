/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : GrsNetCDVO.java
*@FileTitle : GrsNetCDVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.22
*@LastModifier : 박성진
*@LastVersion : 1.0
* 2010.03.22 박성진 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.agt.agtaudit.agtaudit.vo;

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
 * @author 박성진
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class GrsNetCDVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<GrsNetCDVO> models = new ArrayList<GrsNetCDVO>();
	
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String frcFlg = null;
	/* Column Info */
	private String grsnetGubun = null;
	/* Column Info */
	private String acTpCd = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public GrsNetCDVO() {}

	public GrsNetCDVO(String ibflag, String pagerows, String grsnetGubun, String acTpCd, String frcFlg) {
		this.ibflag = ibflag;
		this.frcFlg = frcFlg;
		this.grsnetGubun = grsnetGubun;
		this.acTpCd = acTpCd;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("frc_flg", getFrcFlg());
		this.hashColumns.put("grsnet_gubun", getGrsnetGubun());
		this.hashColumns.put("ac_tp_cd", getAcTpCd());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("frc_flg", "frcFlg");
		this.hashFields.put("grsnet_gubun", "grsnetGubun");
		this.hashFields.put("ac_tp_cd", "acTpCd");
		this.hashFields.put("pagerows", "pagerows");
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
	 * @return frcFlg
	 */
	public String getFrcFlg() {
		return this.frcFlg;
	}
	
	/**
	 * Column Info
	 * @return grsnetGubun
	 */
	public String getGrsnetGubun() {
		return this.grsnetGubun;
	}
	
	/**
	 * Column Info
	 * @return acTpCd
	 */
	public String getAcTpCd() {
		return this.acTpCd;
	}
	
	/**
	 * Page Number
	 * @return pagerows
	 */
	public String getPagerows() {
		return this.pagerows;
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
	 * @param frcFlg
	 */
	public void setFrcFlg(String frcFlg) {
		this.frcFlg = frcFlg;
	}
	
	/**
	 * Column Info
	 * @param grsnetGubun
	 */
	public void setGrsnetGubun(String grsnetGubun) {
		this.grsnetGubun = grsnetGubun;
	}
	
	/**
	 * Column Info
	 * @param acTpCd
	 */
	public void setAcTpCd(String acTpCd) {
		this.acTpCd = acTpCd;
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
		setFrcFlg(JSPUtil.getParameter(request, prefix + "frc_flg", ""));
		setGrsnetGubun(JSPUtil.getParameter(request, prefix + "grsnet_gubun", ""));
		setAcTpCd(JSPUtil.getParameter(request, prefix + "ac_tp_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return GrsNetCDVO[]
	 */
	public GrsNetCDVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return GrsNetCDVO[]
	 */
	public GrsNetCDVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		GrsNetCDVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] frcFlg = (JSPUtil.getParameter(request, prefix	+ "frc_flg", length));
			String[] grsnetGubun = (JSPUtil.getParameter(request, prefix	+ "grsnet_gubun", length));
			String[] acTpCd = (JSPUtil.getParameter(request, prefix	+ "ac_tp_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new GrsNetCDVO();
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (frcFlg[i] != null)
					model.setFrcFlg(frcFlg[i]);
				if (grsnetGubun[i] != null)
					model.setGrsnetGubun(grsnetGubun[i]);
				if (acTpCd[i] != null)
					model.setAcTpCd(acTpCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getGrsNetCDVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return GrsNetCDVO[]
	 */
	public GrsNetCDVO[] getGrsNetCDVOs(){
		GrsNetCDVO[] vos = (GrsNetCDVO[])models.toArray(new GrsNetCDVO[models.size()]);
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
		this.frcFlg = this.frcFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.grsnetGubun = this.grsnetGubun .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.acTpCd = this.acTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
