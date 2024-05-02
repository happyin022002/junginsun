/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : SearchRcvEmlVO.java
*@FileTitle : SearchRcvEmlVO
*Open Issues :
*Change history :
*@LastModifyDate : 2014.11.27
*@LastModifier : Maeda Atsushi
*@LastVersion : 1.0
* 2014.11.27 Maeda Atsushi 
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

public class SearchRcvEmlVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchRcvEmlVO> models = new ArrayList<SearchRcvEmlVO>();
	
	/* Column Info */
	private String bkgNo = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String ntfyPrnFlg = null;
	/* Column Info */
	private String blGrpSeq = null;
	/* Column Info */
	private String usrEml = null;
	/* Column Info */
	private String ntfyPrfFlg = null;
	/* Column Info */
	private String blVwRtTpCd = null;
	/* Column Info */
	private String ntfyAutoWblFlg = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public SearchRcvEmlVO() {}

	public SearchRcvEmlVO(String ibflag, String pagerows, String blGrpSeq, String blVwRtTpCd, String usrEml, String ntfyPrfFlg, String ntfyPrnFlg, String ntfyAutoWblFlg, String bkgNo) {
		this.bkgNo = bkgNo;
		this.ibflag = ibflag;
		this.ntfyPrnFlg = ntfyPrnFlg;
		this.blGrpSeq = blGrpSeq;
		this.usrEml = usrEml;
		this.ntfyPrfFlg = ntfyPrfFlg;
		this.blVwRtTpCd = blVwRtTpCd;
		this.ntfyAutoWblFlg = ntfyAutoWblFlg;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("ntfy_prn_flg", getNtfyPrnFlg());
		this.hashColumns.put("bl_grp_seq", getBlGrpSeq());
		this.hashColumns.put("usr_eml", getUsrEml());
		this.hashColumns.put("ntfy_prf_flg", getNtfyPrfFlg());
		this.hashColumns.put("bl_vw_rt_tp_cd", getBlVwRtTpCd());
		this.hashColumns.put("ntfy_auto_wbl_flg", getNtfyAutoWblFlg());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("ntfy_prn_flg", "ntfyPrnFlg");
		this.hashFields.put("bl_grp_seq", "blGrpSeq");
		this.hashFields.put("usr_eml", "usrEml");
		this.hashFields.put("ntfy_prf_flg", "ntfyPrfFlg");
		this.hashFields.put("bl_vw_rt_tp_cd", "blVwRtTpCd");
		this.hashFields.put("ntfy_auto_wbl_flg", "ntfyAutoWblFlg");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return bkgNo
	 */
	public String getBkgNo() {
		return this.bkgNo;
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
	 * @return ntfyPrnFlg
	 */
	public String getNtfyPrnFlg() {
		return this.ntfyPrnFlg;
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
	 * @return ntfyPrfFlg
	 */
	public String getNtfyPrfFlg() {
		return this.ntfyPrfFlg;
	}
	
	/**
	 * Column Info
	 * @return blVwRtTpCd
	 */
	public String getBlVwRtTpCd() {
		return this.blVwRtTpCd;
	}
	
	/**
	 * Column Info
	 * @return ntfyAutoWblFlg
	 */
	public String getNtfyAutoWblFlg() {
		return this.ntfyAutoWblFlg;
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
	 * @param bkgNo
	 */
	public void setBkgNo(String bkgNo) {
		this.bkgNo = bkgNo;
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
	 * @param ntfyPrnFlg
	 */
	public void setNtfyPrnFlg(String ntfyPrnFlg) {
		this.ntfyPrnFlg = ntfyPrnFlg;
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
	 * @param ntfyPrfFlg
	 */
	public void setNtfyPrfFlg(String ntfyPrfFlg) {
		this.ntfyPrfFlg = ntfyPrfFlg;
	}
	
	/**
	 * Column Info
	 * @param blVwRtTpCd
	 */
	public void setBlVwRtTpCd(String blVwRtTpCd) {
		this.blVwRtTpCd = blVwRtTpCd;
	}
	
	/**
	 * Column Info
	 * @param ntfyAutoWblFlg
	 */
	public void setNtfyAutoWblFlg(String ntfyAutoWblFlg) {
		this.ntfyAutoWblFlg = ntfyAutoWblFlg;
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
		setBkgNo(JSPUtil.getParameter(request, prefix + "bkg_no", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setNtfyPrnFlg(JSPUtil.getParameter(request, prefix + "ntfy_prn_flg", ""));
		setBlGrpSeq(JSPUtil.getParameter(request, prefix + "bl_grp_seq", ""));
		setUsrEml(JSPUtil.getParameter(request, prefix + "usr_eml", ""));
		setNtfyPrfFlg(JSPUtil.getParameter(request, prefix + "ntfy_prf_flg", ""));
		setBlVwRtTpCd(JSPUtil.getParameter(request, prefix + "bl_vw_rt_tp_cd", ""));
		setNtfyAutoWblFlg(JSPUtil.getParameter(request, prefix + "ntfy_auto_wbl_flg", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchRcvEmlVO[]
	 */
	public SearchRcvEmlVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchRcvEmlVO[]
	 */
	public SearchRcvEmlVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchRcvEmlVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] ntfyPrnFlg = (JSPUtil.getParameter(request, prefix	+ "ntfy_prn_flg", length));
			String[] blGrpSeq = (JSPUtil.getParameter(request, prefix	+ "bl_grp_seq", length));
			String[] usrEml = (JSPUtil.getParameter(request, prefix	+ "usr_eml", length));
			String[] ntfyPrfFlg = (JSPUtil.getParameter(request, prefix	+ "ntfy_prf_flg", length));
			String[] blVwRtTpCd = (JSPUtil.getParameter(request, prefix	+ "bl_vw_rt_tp_cd", length));
			String[] ntfyAutoWblFlg = (JSPUtil.getParameter(request, prefix	+ "ntfy_auto_wbl_flg", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchRcvEmlVO();
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (ntfyPrnFlg[i] != null)
					model.setNtfyPrnFlg(ntfyPrnFlg[i]);
				if (blGrpSeq[i] != null)
					model.setBlGrpSeq(blGrpSeq[i]);
				if (usrEml[i] != null)
					model.setUsrEml(usrEml[i]);
				if (ntfyPrfFlg[i] != null)
					model.setNtfyPrfFlg(ntfyPrfFlg[i]);
				if (blVwRtTpCd[i] != null)
					model.setBlVwRtTpCd(blVwRtTpCd[i]);
				if (ntfyAutoWblFlg[i] != null)
					model.setNtfyAutoWblFlg(ntfyAutoWblFlg[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchRcvEmlVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchRcvEmlVO[]
	 */
	public SearchRcvEmlVO[] getSearchRcvEmlVOs(){
		SearchRcvEmlVO[] vos = (SearchRcvEmlVO[])models.toArray(new SearchRcvEmlVO[models.size()]);
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
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ntfyPrnFlg = this.ntfyPrnFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blGrpSeq = this.blGrpSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usrEml = this.usrEml .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ntfyPrfFlg = this.ntfyPrfFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blVwRtTpCd = this.blVwRtTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ntfyAutoWblFlg = this.ntfyAutoWblFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
