/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : ArrNtcMrdVO.java
*@FileTitle : ArrNtcMrdVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.08.03
*@LastModifier : 김민정
*@LastVersion : 1.0
* 2010.08.03 김민정 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.vo;

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
 * @author 김민정
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class ArrNtcMrdVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<ArrNtcMrdVO> models = new ArrayList<ArrNtcMrdVO>();
	
	/* Column Info */
	private String arrPrvFomCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String loclLangFlg = null;
	/* Column Info */
	private String comParam = null;
	/* Column Info */
	private String eclzBlCpyFlg = null;
	/* Column Info */
	private String mrdId = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public ArrNtcMrdVO() {}

	public ArrNtcMrdVO(String ibflag, String pagerows, String mrdId, String comParam, String arrPrvFomCd, String loclLangFlg, String eclzBlCpyFlg) {
		this.arrPrvFomCd = arrPrvFomCd;
		this.ibflag = ibflag;
		this.loclLangFlg = loclLangFlg;
		this.comParam = comParam;
		this.eclzBlCpyFlg = eclzBlCpyFlg;
		this.mrdId = mrdId;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("arr_prv_fom_cd", getArrPrvFomCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("locl_lang_flg", getLoclLangFlg());
		this.hashColumns.put("com_param", getComParam());
		this.hashColumns.put("eclz_bl_cpy_flg", getEclzBlCpyFlg());
		this.hashColumns.put("mrd_id", getMrdId());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("arr_prv_fom_cd", "arrPrvFomCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("locl_lang_flg", "loclLangFlg");
		this.hashFields.put("com_param", "comParam");
		this.hashFields.put("eclz_bl_cpy_flg", "eclzBlCpyFlg");
		this.hashFields.put("mrd_id", "mrdId");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return arrPrvFomCd
	 */
	public String getArrPrvFomCd() {
		return this.arrPrvFomCd;
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
	 * @return loclLangFlg
	 */
	public String getLoclLangFlg() {
		return this.loclLangFlg;
	}
	
	/**
	 * Column Info
	 * @return comParam
	 */
	public String getComParam() {
		return this.comParam;
	}
	
	/**
	 * Column Info
	 * @return eclzBlCpyFlg
	 */
	public String getEclzBlCpyFlg() {
		return this.eclzBlCpyFlg;
	}
	
	/**
	 * Column Info
	 * @return mrdId
	 */
	public String getMrdId() {
		return this.mrdId;
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
	 * @param arrPrvFomCd
	 */
	public void setArrPrvFomCd(String arrPrvFomCd) {
		this.arrPrvFomCd = arrPrvFomCd;
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
	 * @param loclLangFlg
	 */
	public void setLoclLangFlg(String loclLangFlg) {
		this.loclLangFlg = loclLangFlg;
	}
	
	/**
	 * Column Info
	 * @param comParam
	 */
	public void setComParam(String comParam) {
		this.comParam = comParam;
	}
	
	/**
	 * Column Info
	 * @param eclzBlCpyFlg
	 */
	public void setEclzBlCpyFlg(String eclzBlCpyFlg) {
		this.eclzBlCpyFlg = eclzBlCpyFlg;
	}
	
	/**
	 * Column Info
	 * @param mrdId
	 */
	public void setMrdId(String mrdId) {
		this.mrdId = mrdId;
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
		setArrPrvFomCd(JSPUtil.getParameter(request, prefix + "arr_prv_fom_cd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setLoclLangFlg(JSPUtil.getParameter(request, prefix + "locl_lang_flg", ""));
		setComParam(JSPUtil.getParameter(request, prefix + "com_param", ""));
		setEclzBlCpyFlg(JSPUtil.getParameter(request, prefix + "eclz_bl_cpy_flg", ""));
		setMrdId(JSPUtil.getParameter(request, prefix + "mrd_id", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return ArrNtcMrdVO[]
	 */
	public ArrNtcMrdVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return ArrNtcMrdVO[]
	 */
	public ArrNtcMrdVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		ArrNtcMrdVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] arrPrvFomCd = (JSPUtil.getParameter(request, prefix	+ "arr_prv_fom_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] loclLangFlg = (JSPUtil.getParameter(request, prefix	+ "locl_lang_flg", length));
			String[] comParam = (JSPUtil.getParameter(request, prefix	+ "com_param", length));
			String[] eclzBlCpyFlg = (JSPUtil.getParameter(request, prefix	+ "eclz_bl_cpy_flg", length));
			String[] mrdId = (JSPUtil.getParameter(request, prefix	+ "mrd_id", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new ArrNtcMrdVO();
				if (arrPrvFomCd[i] != null)
					model.setArrPrvFomCd(arrPrvFomCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (loclLangFlg[i] != null)
					model.setLoclLangFlg(loclLangFlg[i]);
				if (comParam[i] != null)
					model.setComParam(comParam[i]);
				if (eclzBlCpyFlg[i] != null)
					model.setEclzBlCpyFlg(eclzBlCpyFlg[i]);
				if (mrdId[i] != null)
					model.setMrdId(mrdId[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getArrNtcMrdVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return ArrNtcMrdVO[]
	 */
	public ArrNtcMrdVO[] getArrNtcMrdVOs(){
		ArrNtcMrdVO[] vos = (ArrNtcMrdVO[])models.toArray(new ArrNtcMrdVO[models.size()]);
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
		this.arrPrvFomCd = this.arrPrvFomCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.loclLangFlg = this.loclLangFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.comParam = this.comParam .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eclzBlCpyFlg = this.eclzBlCpyFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mrdId = this.mrdId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
