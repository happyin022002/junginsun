/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : SearchBlPrintRcvEmlVO.java
*@FileTitle : SearchBlPrintRcvEmlVO
*Open Issues :
*Change history :
*@LastModifyDate : 2015.02.03
*@LastModifier : Maeda Atsushi
*@LastVersion : 1.0
* 2015.02.03 Maeda Atsushi 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.vo;

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
 * @author Maeda Atsushi
 * @since J2EE 1.6
 * @see AbstractValueObject
 */
 
public class SearchBlPrintRcvEmlVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchBlPrintRcvEmlVO> models = new ArrayList<SearchBlPrintRcvEmlVO>();
	
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String blGrpSeq = null;
	/* Column Info */
	private String usrEml = null;
	/* Column Info */
	private String blVwRtTpCd = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public SearchBlPrintRcvEmlVO() {}

	public SearchBlPrintRcvEmlVO(String ibflag, String pagerows, String blGrpSeq, String blVwRtTpCd, String usrEml) {
		this.ibflag = ibflag;
		this.blGrpSeq = blGrpSeq;
		this.usrEml = usrEml;
		this.blVwRtTpCd = blVwRtTpCd;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("bl_grp_seq", getBlGrpSeq());
		this.hashColumns.put("usr_eml", getUsrEml());
		this.hashColumns.put("bl_vw_rt_tp_cd", getBlVwRtTpCd());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("bl_grp_seq", "blGrpSeq");
		this.hashFields.put("usr_eml", "usrEml");
		this.hashFields.put("bl_vw_rt_tp_cd", "blVwRtTpCd");
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
	 * @return blGrpSeq
	 */
	public String getBlGrpSeq() {
		return this.blGrpSeq;
	}
	
	/**
	 * Column Info
	 * @return usrEml
	 */
	public String getUsrEml() {
		return this.usrEml;
	}
	
	/**
	 * Column Info
	 * @return blVwRtTpCd
	 */
	public String getBlVwRtTpCd() {
		return this.blVwRtTpCd;
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
	 * @param blGrpSeq
	 */
	public void setBlGrpSeq(String blGrpSeq) {
		this.blGrpSeq = blGrpSeq;
	}
	
	/**
	 * Column Info
	 * @param usrEml
	 */
	public void setUsrEml(String usrEml) {
		this.usrEml = usrEml;
	}
	
	/**
	 * Column Info
	 * @param blVwRtTpCd
	 */
	public void setBlVwRtTpCd(String blVwRtTpCd) {
		this.blVwRtTpCd = blVwRtTpCd;
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
		setBlGrpSeq(JSPUtil.getParameter(request, prefix + "bl_grp_seq", ""));
		setUsrEml(JSPUtil.getParameter(request, prefix + "usr_eml", ""));
		setBlVwRtTpCd(JSPUtil.getParameter(request, prefix + "bl_vw_rt_tp_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchBlPrintRcvEmlVO[]
	 */
	public SearchBlPrintRcvEmlVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchBlPrintRcvEmlVO[]
	 */
	public SearchBlPrintRcvEmlVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchBlPrintRcvEmlVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] blGrpSeq = (JSPUtil.getParameter(request, prefix	+ "bl_grp_seq", length));
			String[] usrEml = (JSPUtil.getParameter(request, prefix	+ "usr_eml", length));
			String[] blVwRtTpCd = (JSPUtil.getParameter(request, prefix	+ "bl_vw_rt_tp_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchBlPrintRcvEmlVO();
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (blGrpSeq[i] != null)
					model.setBlGrpSeq(blGrpSeq[i]);
				if (usrEml[i] != null)
					model.setUsrEml(usrEml[i]);
				if (blVwRtTpCd[i] != null)
					model.setBlVwRtTpCd(blVwRtTpCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchBlPrintRcvEmlVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchBlPrintRcvEmlVO[]
	 */
	public SearchBlPrintRcvEmlVO[] getSearchBlPrintRcvEmlVOs(){
		SearchBlPrintRcvEmlVO[] vos = (SearchBlPrintRcvEmlVO[])models.toArray(new SearchBlPrintRcvEmlVO[models.size()]);
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
		this.blGrpSeq = this.blGrpSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usrEml = this.usrEml .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blVwRtTpCd = this.blVwRtTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
