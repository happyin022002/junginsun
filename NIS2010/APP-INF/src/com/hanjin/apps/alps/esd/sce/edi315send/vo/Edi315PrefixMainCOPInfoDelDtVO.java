/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : Edi315PrefixMainCOPInfoDelDtVO.java
*@FileTitle : Edi315PrefixMainCOPInfoDelDtVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.18
*@LastModifier : 이윤정
*@LastVersion : 1.0
* 2010.03.18 이윤정 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esd.sce.edi315send.vo;

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
 * @author 이윤정
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class Edi315PrefixMainCOPInfoDelDtVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<Edi315PrefixMainCOPInfoDelDtVO> models = new ArrayList<Edi315PrefixMainCOPInfoDelDtVO>();
	
	/* Column Info */
	private String delAta = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String delAtaGmt = null;
	/* Column Info */
	private String delEtaGmt = null;
	/* Column Info */
	private String delEta = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public Edi315PrefixMainCOPInfoDelDtVO() {}

	public Edi315PrefixMainCOPInfoDelDtVO(String ibflag, String pagerows, String delEta, String delEtaGmt, String delAta, String delAtaGmt) {
		this.delAta = delAta;
		this.ibflag = ibflag;
		this.delAtaGmt = delAtaGmt;
		this.delEtaGmt = delEtaGmt;
		this.delEta = delEta;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("del_ata", getDelAta());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("del_ata_gmt", getDelAtaGmt());
		this.hashColumns.put("del_eta_gmt", getDelEtaGmt());
		this.hashColumns.put("del_eta", getDelEta());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("del_ata", "delAta");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("del_ata_gmt", "delAtaGmt");
		this.hashFields.put("del_eta_gmt", "delEtaGmt");
		this.hashFields.put("del_eta", "delEta");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return delAta
	 */
	public String getDelAta() {
		return this.delAta;
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
	 * @return delAtaGmt
	 */
	public String getDelAtaGmt() {
		return this.delAtaGmt;
	}
	
	/**
	 * Column Info
	 * @return delEtaGmt
	 */
	public String getDelEtaGmt() {
		return this.delEtaGmt;
	}
	
	/**
	 * Column Info
	 * @return delEta
	 */
	public String getDelEta() {
		return this.delEta;
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
	 * @param delAta
	 */
	public void setDelAta(String delAta) {
		this.delAta = delAta;
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
	 * @param delAtaGmt
	 */
	public void setDelAtaGmt(String delAtaGmt) {
		this.delAtaGmt = delAtaGmt;
	}
	
	/**
	 * Column Info
	 * @param delEtaGmt
	 */
	public void setDelEtaGmt(String delEtaGmt) {
		this.delEtaGmt = delEtaGmt;
	}
	
	/**
	 * Column Info
	 * @param delEta
	 */
	public void setDelEta(String delEta) {
		this.delEta = delEta;
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
		setDelAta(JSPUtil.getParameter(request, prefix + "del_ata", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setDelAtaGmt(JSPUtil.getParameter(request, prefix + "del_ata_gmt", ""));
		setDelEtaGmt(JSPUtil.getParameter(request, prefix + "del_eta_gmt", ""));
		setDelEta(JSPUtil.getParameter(request, prefix + "del_eta", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return Edi315PrefixMainCOPInfoDelDtVO[]
	 */
	public Edi315PrefixMainCOPInfoDelDtVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return Edi315PrefixMainCOPInfoDelDtVO[]
	 */
	public Edi315PrefixMainCOPInfoDelDtVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		Edi315PrefixMainCOPInfoDelDtVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] delAta = (JSPUtil.getParameter(request, prefix	+ "del_ata", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] delAtaGmt = (JSPUtil.getParameter(request, prefix	+ "del_ata_gmt", length));
			String[] delEtaGmt = (JSPUtil.getParameter(request, prefix	+ "del_eta_gmt", length));
			String[] delEta = (JSPUtil.getParameter(request, prefix	+ "del_eta", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new Edi315PrefixMainCOPInfoDelDtVO();
				if (delAta[i] != null)
					model.setDelAta(delAta[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (delAtaGmt[i] != null)
					model.setDelAtaGmt(delAtaGmt[i]);
				if (delEtaGmt[i] != null)
					model.setDelEtaGmt(delEtaGmt[i]);
				if (delEta[i] != null)
					model.setDelEta(delEta[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getEdi315PrefixMainCOPInfoDelDtVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return Edi315PrefixMainCOPInfoDelDtVO[]
	 */
	public Edi315PrefixMainCOPInfoDelDtVO[] getEdi315PrefixMainCOPInfoDelDtVOs(){
		Edi315PrefixMainCOPInfoDelDtVO[] vos = (Edi315PrefixMainCOPInfoDelDtVO[])models.toArray(new Edi315PrefixMainCOPInfoDelDtVO[models.size()]);
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
		this.delAta = this.delAta .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delAtaGmt = this.delAtaGmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delEtaGmt = this.delEtaGmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delEta = this.delEta .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
