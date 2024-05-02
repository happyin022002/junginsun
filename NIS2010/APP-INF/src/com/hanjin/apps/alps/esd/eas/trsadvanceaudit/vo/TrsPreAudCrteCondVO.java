/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : TrsPreAudCrteCondVO.java
*@FileTitle : TrsPreAudCrteCondVO
*Open Issues :
*Change history :
*@LastModifyDate : 2015.06.23
*@LastModifier : 백형인
*@LastVersion : 1.0
* 2015.06.23 백형인 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esd.eas.trsadvanceaudit.vo;

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
 * @author 백형인
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class TrsPreAudCrteCondVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<TrsPreAudCrteCondVO> models = new ArrayList<TrsPreAudCrteCondVO>();
	
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String iExpnAudCrteTpCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String sRhqOfcCd = null;
	/* Column Info */
	private String cnt = null;
	/* Column Info */
	private String sExpnAudTgtFlg = null;
	/* Column Info */
	private String sExpnAudCrteTpCd = null;
	/* Column Info */
	private String iOfcCd = null;
	/* Column Info */
	private String sTrspCrrModCd = null;
	/* Column Info */
	private String iTrspCrrModCd = null;
	/* Column Info */
	private String sCgoTpCd = null;
	/* Column Info */
	private String iCgoTpCd = null;
	/* Column Info */
	private String sOfcCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public TrsPreAudCrteCondVO() {}

	public TrsPreAudCrteCondVO(String ibflag, String pagerows, String sRhqOfcCd, String iTrspCrrModCd, String iCgoTpCd, String sTrspCrrModCd, String sOfcCd, String sExpnAudCrteTpCd, String iOfcCd, String iExpnAudCrteTpCd, String sExpnAudTgtFlg, String sCgoTpCd, String cnt) {
		this.pagerows = pagerows;
		this.iExpnAudCrteTpCd = iExpnAudCrteTpCd;
		this.ibflag = ibflag;
		this.sRhqOfcCd = sRhqOfcCd;
		this.cnt = cnt;
		this.sExpnAudTgtFlg = sExpnAudTgtFlg;
		this.sExpnAudCrteTpCd = sExpnAudCrteTpCd;
		this.iOfcCd = iOfcCd;
		this.sTrspCrrModCd = sTrspCrrModCd;
		this.iTrspCrrModCd = iTrspCrrModCd;
		this.sCgoTpCd = sCgoTpCd;
		this.iCgoTpCd = iCgoTpCd;
		this.sOfcCd = sOfcCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("i_expn_aud_crte_tp_cd", getIExpnAudCrteTpCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("s_rhq_ofc_cd", getSRhqOfcCd());
		this.hashColumns.put("cnt", getCnt());
		this.hashColumns.put("s_expn_aud_tgt_flg", getSExpnAudTgtFlg());
		this.hashColumns.put("s_expn_aud_crte_tp_cd", getSExpnAudCrteTpCd());
		this.hashColumns.put("i_ofc_cd", getIOfcCd());
		this.hashColumns.put("s_trsp_crr_mod_cd", getSTrspCrrModCd());
		this.hashColumns.put("i_trsp_crr_mod_cd", getITrspCrrModCd());
		this.hashColumns.put("s_cgo_tp_cd", getSCgoTpCd());
		this.hashColumns.put("i_cgo_tp_cd", getICgoTpCd());
		this.hashColumns.put("s_ofc_cd", getSOfcCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("i_expn_aud_crte_tp_cd", "iExpnAudCrteTpCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("s_rhq_ofc_cd", "sRhqOfcCd");
		this.hashFields.put("cnt", "cnt");
		this.hashFields.put("s_expn_aud_tgt_flg", "sExpnAudTgtFlg");
		this.hashFields.put("s_expn_aud_crte_tp_cd", "sExpnAudCrteTpCd");
		this.hashFields.put("i_ofc_cd", "iOfcCd");
		this.hashFields.put("s_trsp_crr_mod_cd", "sTrspCrrModCd");
		this.hashFields.put("i_trsp_crr_mod_cd", "iTrspCrrModCd");
		this.hashFields.put("s_cgo_tp_cd", "sCgoTpCd");
		this.hashFields.put("i_cgo_tp_cd", "iCgoTpCd");
		this.hashFields.put("s_ofc_cd", "sOfcCd");
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
	 * @return iExpnAudCrteTpCd
	 */
	public String getIExpnAudCrteTpCd() {
		return this.iExpnAudCrteTpCd;
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
	 * @return sRhqOfcCd
	 */
	public String getSRhqOfcCd() {
		return this.sRhqOfcCd;
	}
	
	/**
	 * Column Info
	 * @return cnt
	 */
	public String getCnt() {
		return this.cnt;
	}
	
	/**
	 * Column Info
	 * @return sExpnAudTgtFlg
	 */
	public String getSExpnAudTgtFlg() {
		return this.sExpnAudTgtFlg;
	}
	
	/**
	 * Column Info
	 * @return sExpnAudCrteTpCd
	 */
	public String getSExpnAudCrteTpCd() {
		return this.sExpnAudCrteTpCd;
	}
	
	/**
	 * Column Info
	 * @return iOfcCd
	 */
	public String getIOfcCd() {
		return this.iOfcCd;
	}
	
	/**
	 * Column Info
	 * @return sTrspCrrModCd
	 */
	public String getSTrspCrrModCd() {
		return this.sTrspCrrModCd;
	}
	
	/**
	 * Column Info
	 * @return iTrspCrrModCd
	 */
	public String getITrspCrrModCd() {
		return this.iTrspCrrModCd;
	}
	
	/**
	 * Column Info
	 * @return sCgoTpCd
	 */
	public String getSCgoTpCd() {
		return this.sCgoTpCd;
	}
	
	/**
	 * Column Info
	 * @return iCgoTpCd
	 */
	public String getICgoTpCd() {
		return this.iCgoTpCd;
	}
	
	/**
	 * Column Info
	 * @return sOfcCd
	 */
	public String getSOfcCd() {
		return this.sOfcCd;
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
	 * @param iExpnAudCrteTpCd
	 */
	public void setIExpnAudCrteTpCd(String iExpnAudCrteTpCd) {
		this.iExpnAudCrteTpCd = iExpnAudCrteTpCd;
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
	 * @param sRhqOfcCd
	 */
	public void setSRhqOfcCd(String sRhqOfcCd) {
		this.sRhqOfcCd = sRhqOfcCd;
	}
	
	/**
	 * Column Info
	 * @param cnt
	 */
	public void setCnt(String cnt) {
		this.cnt = cnt;
	}
	
	/**
	 * Column Info
	 * @param sExpnAudTgtFlg
	 */
	public void setSExpnAudTgtFlg(String sExpnAudTgtFlg) {
		this.sExpnAudTgtFlg = sExpnAudTgtFlg;
	}
	
	/**
	 * Column Info
	 * @param sExpnAudCrteTpCd
	 */
	public void setSExpnAudCrteTpCd(String sExpnAudCrteTpCd) {
		this.sExpnAudCrteTpCd = sExpnAudCrteTpCd;
	}
	
	/**
	 * Column Info
	 * @param iOfcCd
	 */
	public void setIOfcCd(String iOfcCd) {
		this.iOfcCd = iOfcCd;
	}
	
	/**
	 * Column Info
	 * @param sTrspCrrModCd
	 */
	public void setSTrspCrrModCd(String sTrspCrrModCd) {
		this.sTrspCrrModCd = sTrspCrrModCd;
	}
	
	/**
	 * Column Info
	 * @param iTrspCrrModCd
	 */
	public void setITrspCrrModCd(String iTrspCrrModCd) {
		this.iTrspCrrModCd = iTrspCrrModCd;
	}
	
	/**
	 * Column Info
	 * @param sCgoTpCd
	 */
	public void setSCgoTpCd(String sCgoTpCd) {
		this.sCgoTpCd = sCgoTpCd;
	}
	
	/**
	 * Column Info
	 * @param iCgoTpCd
	 */
	public void setICgoTpCd(String iCgoTpCd) {
		this.iCgoTpCd = iCgoTpCd;
	}
	
	/**
	 * Column Info
	 * @param sOfcCd
	 */
	public void setSOfcCd(String sOfcCd) {
		this.sOfcCd = sOfcCd;
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
		setIExpnAudCrteTpCd(JSPUtil.getParameter(request, prefix + "i_expn_aud_crte_tp_cd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setSRhqOfcCd(JSPUtil.getParameter(request, prefix + "s_rhq_ofc_cd", ""));
		setCnt(JSPUtil.getParameter(request, prefix + "cnt", ""));
		setSExpnAudTgtFlg(JSPUtil.getParameter(request, prefix + "s_expn_aud_tgt_flg", ""));
		setSExpnAudCrteTpCd(JSPUtil.getParameter(request, prefix + "s_expn_aud_crte_tp_cd", ""));
		setIOfcCd(JSPUtil.getParameter(request, prefix + "i_ofc_cd", ""));
		setSTrspCrrModCd(JSPUtil.getParameter(request, prefix + "s_trsp_crr_mod_cd", ""));
		setITrspCrrModCd(JSPUtil.getParameter(request, prefix + "i_trsp_crr_mod_cd", ""));
		setSCgoTpCd(JSPUtil.getParameter(request, prefix + "s_cgo_tp_cd", ""));
		setICgoTpCd(JSPUtil.getParameter(request, prefix + "i_cgo_tp_cd", ""));
		setSOfcCd(JSPUtil.getParameter(request, prefix + "s_ofc_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return TrsPreAudCrteCondVO[]
	 */
	public TrsPreAudCrteCondVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return TrsPreAudCrteCondVO[]
	 */
	public TrsPreAudCrteCondVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		TrsPreAudCrteCondVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] iExpnAudCrteTpCd = (JSPUtil.getParameter(request, prefix	+ "i_expn_aud_crte_tp_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] sRhqOfcCd = (JSPUtil.getParameter(request, prefix	+ "s_rhq_ofc_cd", length));
			String[] cnt = (JSPUtil.getParameter(request, prefix	+ "cnt", length));
			String[] sExpnAudTgtFlg = (JSPUtil.getParameter(request, prefix	+ "s_expn_aud_tgt_flg", length));
			String[] sExpnAudCrteTpCd = (JSPUtil.getParameter(request, prefix	+ "s_expn_aud_crte_tp_cd", length));
			String[] iOfcCd = (JSPUtil.getParameter(request, prefix	+ "i_ofc_cd", length));
			String[] sTrspCrrModCd = (JSPUtil.getParameter(request, prefix	+ "s_trsp_crr_mod_cd", length));
			String[] iTrspCrrModCd = (JSPUtil.getParameter(request, prefix	+ "i_trsp_crr_mod_cd", length));
			String[] sCgoTpCd = (JSPUtil.getParameter(request, prefix	+ "s_cgo_tp_cd", length));
			String[] iCgoTpCd = (JSPUtil.getParameter(request, prefix	+ "i_cgo_tp_cd", length));
			String[] sOfcCd = (JSPUtil.getParameter(request, prefix	+ "s_ofc_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new TrsPreAudCrteCondVO();
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (iExpnAudCrteTpCd[i] != null)
					model.setIExpnAudCrteTpCd(iExpnAudCrteTpCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (sRhqOfcCd[i] != null)
					model.setSRhqOfcCd(sRhqOfcCd[i]);
				if (cnt[i] != null)
					model.setCnt(cnt[i]);
				if (sExpnAudTgtFlg[i] != null)
					model.setSExpnAudTgtFlg(sExpnAudTgtFlg[i]);
				if (sExpnAudCrteTpCd[i] != null)
					model.setSExpnAudCrteTpCd(sExpnAudCrteTpCd[i]);
				if (iOfcCd[i] != null)
					model.setIOfcCd(iOfcCd[i]);
				if (sTrspCrrModCd[i] != null)
					model.setSTrspCrrModCd(sTrspCrrModCd[i]);
				if (iTrspCrrModCd[i] != null)
					model.setITrspCrrModCd(iTrspCrrModCd[i]);
				if (sCgoTpCd[i] != null)
					model.setSCgoTpCd(sCgoTpCd[i]);
				if (iCgoTpCd[i] != null)
					model.setICgoTpCd(iCgoTpCd[i]);
				if (sOfcCd[i] != null)
					model.setSOfcCd(sOfcCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getTrsPreAudCrteCondVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return TrsPreAudCrteCondVO[]
	 */
	public TrsPreAudCrteCondVO[] getTrsPreAudCrteCondVOs(){
		TrsPreAudCrteCondVO[] vos = (TrsPreAudCrteCondVO[])models.toArray(new TrsPreAudCrteCondVO[models.size()]);
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
		this.iExpnAudCrteTpCd = this.iExpnAudCrteTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sRhqOfcCd = this.sRhqOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnt = this.cnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sExpnAudTgtFlg = this.sExpnAudTgtFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sExpnAudCrteTpCd = this.sExpnAudCrteTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.iOfcCd = this.iOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sTrspCrrModCd = this.sTrspCrrModCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.iTrspCrrModCd = this.iTrspCrrModCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sCgoTpCd = this.sCgoTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.iCgoTpCd = this.iCgoTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sOfcCd = this.sOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
