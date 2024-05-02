/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : KorMsnInfoVO.java
*@FileTitle : KorMsnInfoVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.17
*@LastModifier : 박상훈
*@LastVersion : 1.0
* 2009.11.17 박상훈 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.customsdeclaration.customsreport.korea.vo;

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
 * @author 박상훈
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class KorMsnInfoVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<KorMsnInfoVO> models = new ArrayList<KorMsnInfoVO>();
	
	/* Column Info */
	private String cstmsClrLocCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String cstmsClrTpCd = null;
	/* Column Info */
	private String krCstmsBlTpCd = null;
	/* Column Info */
	private String cstmsDhgLocWhCd = null;
	/* Column Info */
	private String mrnBlTsCd = null;
	/* Column Info */
	private String cstmsClrWhCd = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public KorMsnInfoVO() {}

	public KorMsnInfoVO(String ibflag, String pagerows, String krCstmsBlTpCd, String mrnBlTsCd, String cstmsClrTpCd, String cstmsDhgLocWhCd, String cstmsClrLocCd, String cstmsClrWhCd) {
		this.cstmsClrLocCd = cstmsClrLocCd;
		this.ibflag = ibflag;
		this.cstmsClrTpCd = cstmsClrTpCd;
		this.krCstmsBlTpCd = krCstmsBlTpCd;
		this.cstmsDhgLocWhCd = cstmsDhgLocWhCd;
		this.mrnBlTsCd = mrnBlTsCd;
		this.cstmsClrWhCd = cstmsClrWhCd;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("cstms_clr_loc_cd", getCstmsClrLocCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cstms_clr_tp_cd", getCstmsClrTpCd());
		this.hashColumns.put("kr_cstms_bl_tp_cd", getKrCstmsBlTpCd());
		this.hashColumns.put("cstms_dhg_loc_wh_cd", getCstmsDhgLocWhCd());
		this.hashColumns.put("mrn_bl_ts_cd", getMrnBlTsCd());
		this.hashColumns.put("cstms_clr_wh_cd", getCstmsClrWhCd());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("cstms_clr_loc_cd", "cstmsClrLocCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cstms_clr_tp_cd", "cstmsClrTpCd");
		this.hashFields.put("kr_cstms_bl_tp_cd", "krCstmsBlTpCd");
		this.hashFields.put("cstms_dhg_loc_wh_cd", "cstmsDhgLocWhCd");
		this.hashFields.put("mrn_bl_ts_cd", "mrnBlTsCd");
		this.hashFields.put("cstms_clr_wh_cd", "cstmsClrWhCd");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return cstmsClrLocCd
	 */
	public String getCstmsClrLocCd() {
		return this.cstmsClrLocCd;
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
	 * @return cstmsClrTpCd
	 */
	public String getCstmsClrTpCd() {
		return this.cstmsClrTpCd;
	}
	
	/**
	 * Column Info
	 * @return krCstmsBlTpCd
	 */
	public String getKrCstmsBlTpCd() {
		return this.krCstmsBlTpCd;
	}
	
	/**
	 * Column Info
	 * @return cstmsDhgLocWhCd
	 */
	public String getCstmsDhgLocWhCd() {
		return this.cstmsDhgLocWhCd;
	}
	
	/**
	 * Column Info
	 * @return mrnBlTsCd
	 */
	public String getMrnBlTsCd() {
		return this.mrnBlTsCd;
	}
	
	/**
	 * Column Info
	 * @return cstmsClrWhCd
	 */
	public String getCstmsClrWhCd() {
		return this.cstmsClrWhCd;
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
	 * @param cstmsClrLocCd
	 */
	public void setCstmsClrLocCd(String cstmsClrLocCd) {
		this.cstmsClrLocCd = cstmsClrLocCd;
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
	 * @param cstmsClrTpCd
	 */
	public void setCstmsClrTpCd(String cstmsClrTpCd) {
		this.cstmsClrTpCd = cstmsClrTpCd;
	}
	
	/**
	 * Column Info
	 * @param krCstmsBlTpCd
	 */
	public void setKrCstmsBlTpCd(String krCstmsBlTpCd) {
		this.krCstmsBlTpCd = krCstmsBlTpCd;
	}
	
	/**
	 * Column Info
	 * @param cstmsDhgLocWhCd
	 */
	public void setCstmsDhgLocWhCd(String cstmsDhgLocWhCd) {
		this.cstmsDhgLocWhCd = cstmsDhgLocWhCd;
	}
	
	/**
	 * Column Info
	 * @param mrnBlTsCd
	 */
	public void setMrnBlTsCd(String mrnBlTsCd) {
		this.mrnBlTsCd = mrnBlTsCd;
	}
	
	/**
	 * Column Info
	 * @param cstmsClrWhCd
	 */
	public void setCstmsClrWhCd(String cstmsClrWhCd) {
		this.cstmsClrWhCd = cstmsClrWhCd;
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
		setCstmsClrLocCd(JSPUtil.getParameter(request, "cstms_clr_loc_cd", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setCstmsClrTpCd(JSPUtil.getParameter(request, "cstms_clr_tp_cd", ""));
		setKrCstmsBlTpCd(JSPUtil.getParameter(request, "kr_cstms_bl_tp_cd", ""));
		setCstmsDhgLocWhCd(JSPUtil.getParameter(request, "cstms_dhg_loc_wh_cd", ""));
		setMrnBlTsCd(JSPUtil.getParameter(request, "mrn_bl_ts_cd", ""));
		setCstmsClrWhCd(JSPUtil.getParameter(request, "cstms_clr_wh_cd", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return KorMsnInfoVO[]
	 */
	public KorMsnInfoVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return KorMsnInfoVO[]
	 */
	public KorMsnInfoVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		KorMsnInfoVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] cstmsClrLocCd = (JSPUtil.getParameter(request, prefix	+ "cstms_clr_loc_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] cstmsClrTpCd = (JSPUtil.getParameter(request, prefix	+ "cstms_clr_tp_cd", length));
			String[] krCstmsBlTpCd = (JSPUtil.getParameter(request, prefix	+ "kr_cstms_bl_tp_cd", length));
			String[] cstmsDhgLocWhCd = (JSPUtil.getParameter(request, prefix	+ "cstms_dhg_loc_wh_cd", length));
			String[] mrnBlTsCd = (JSPUtil.getParameter(request, prefix	+ "mrn_bl_ts_cd", length));
			String[] cstmsClrWhCd = (JSPUtil.getParameter(request, prefix	+ "cstms_clr_wh_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new KorMsnInfoVO();
				if (cstmsClrLocCd[i] != null)
					model.setCstmsClrLocCd(cstmsClrLocCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (cstmsClrTpCd[i] != null)
					model.setCstmsClrTpCd(cstmsClrTpCd[i]);
				if (krCstmsBlTpCd[i] != null)
					model.setKrCstmsBlTpCd(krCstmsBlTpCd[i]);
				if (cstmsDhgLocWhCd[i] != null)
					model.setCstmsDhgLocWhCd(cstmsDhgLocWhCd[i]);
				if (mrnBlTsCd[i] != null)
					model.setMrnBlTsCd(mrnBlTsCd[i]);
				if (cstmsClrWhCd[i] != null)
					model.setCstmsClrWhCd(cstmsClrWhCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getKorMsnInfoVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return KorMsnInfoVO[]
	 */
	public KorMsnInfoVO[] getKorMsnInfoVOs(){
		KorMsnInfoVO[] vos = (KorMsnInfoVO[])models.toArray(new KorMsnInfoVO[models.size()]);
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
		this.cstmsClrLocCd = this.cstmsClrLocCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cstmsClrTpCd = this.cstmsClrTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.krCstmsBlTpCd = this.krCstmsBlTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cstmsDhgLocWhCd = this.cstmsDhgLocWhCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mrnBlTsCd = this.mrnBlTsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cstmsClrWhCd = this.cstmsClrWhCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
