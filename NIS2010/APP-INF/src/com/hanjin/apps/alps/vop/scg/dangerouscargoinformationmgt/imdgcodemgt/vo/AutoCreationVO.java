/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : AutoCreationVO.java
*@FileTitle : AutoCreationVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.07
*@LastModifier : 이도형
*@LastVersion : 1.0
* 2009.10.07 이도형 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.vop.scg.dangerouscargoinformationmgt.imdgcodemgt.vo;

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
 * @author 이도형
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class AutoCreationVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<AutoCreationVO> models = new ArrayList<AutoCreationVO>();
	
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String frmAwayFmImdgClssCd = null;
	/* Column Info */
	private String frmSegrAsForImdgClssCd = null;
	/* Column Info */
	private String frmImdgSubsRskLblCd4 = null;
	/* Column Info */
	private String frmImdgSubsRskLblCd3 = null;
	/* Column Info */
	private String frmImdgSubsRskLblCd2 = null;
	/* Column Info */
	private String frmSprtFmImdgClssCd = null;
	/* Column Info */
	private String frmImdgSubsRskLblCd1 = null;
	/* Column Info */
	private String frmImdgClssCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String frmSprtHldFmImdgClssCd = null;
	/* Column Info */
	private String frmSprtLonFmImdgClssCd = null;
	/* Column Info */
	private String msgFlg = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public AutoCreationVO() {}

	public AutoCreationVO(String ibflag, String pagerows, String frmImdgClssCd, String frmSegrAsForImdgClssCd, String frmAwayFmImdgClssCd, String frmSprtFmImdgClssCd, String frmImdgSubsRskLblCd1, String frmImdgSubsRskLblCd2, String frmImdgSubsRskLblCd3, String frmImdgSubsRskLblCd4, String frmSprtHldFmImdgClssCd, String frmSprtLonFmImdgClssCd, String msgFlg) {
		this.ibflag = ibflag;
		this.frmAwayFmImdgClssCd = frmAwayFmImdgClssCd;
		this.frmSegrAsForImdgClssCd = frmSegrAsForImdgClssCd;
		this.frmImdgSubsRskLblCd4 = frmImdgSubsRskLblCd4;
		this.frmImdgSubsRskLblCd3 = frmImdgSubsRskLblCd3;
		this.frmImdgSubsRskLblCd2 = frmImdgSubsRskLblCd2;
		this.frmSprtFmImdgClssCd = frmSprtFmImdgClssCd;
		this.frmImdgSubsRskLblCd1 = frmImdgSubsRskLblCd1;
		this.frmImdgClssCd = frmImdgClssCd;
		this.pagerows = pagerows;
		this.frmSprtHldFmImdgClssCd = frmSprtHldFmImdgClssCd;
		this.frmSprtLonFmImdgClssCd = frmSprtLonFmImdgClssCd;
		this.msgFlg = msgFlg;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("frm_away_fm_imdg_clss_cd", getFrmAwayFmImdgClssCd());
		this.hashColumns.put("frm_segr_as_for_imdg_clss_cd", getFrmSegrAsForImdgClssCd());
		this.hashColumns.put("frm_imdg_subs_rsk_lbl_cd4", getFrmImdgSubsRskLblCd4());
		this.hashColumns.put("frm_imdg_subs_rsk_lbl_cd3", getFrmImdgSubsRskLblCd3());
		this.hashColumns.put("frm_imdg_subs_rsk_lbl_cd2", getFrmImdgSubsRskLblCd2());
		this.hashColumns.put("frm_sprt_fm_imdg_clss_cd", getFrmSprtFmImdgClssCd());
		this.hashColumns.put("frm_imdg_subs_rsk_lbl_cd1", getFrmImdgSubsRskLblCd1());
		this.hashColumns.put("frm_imdg_clss_cd", getFrmImdgClssCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("frm_sprt_hld_fm_imdg_clss_cd", getFrmSprtHldFmImdgClssCd());
		this.hashColumns.put("frm_sprt_lon_fm_imdg_clss_cd", getFrmSprtLonFmImdgClssCd());
		this.hashColumns.put("msg_flg", getMsgFlg());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("frm_away_fm_imdg_clss_cd", "frmAwayFmImdgClssCd");
		this.hashFields.put("frm_segr_as_for_imdg_clss_cd", "frmSegrAsForImdgClssCd");
		this.hashFields.put("frm_imdg_subs_rsk_lbl_cd4", "frmImdgSubsRskLblCd4");
		this.hashFields.put("frm_imdg_subs_rsk_lbl_cd3", "frmImdgSubsRskLblCd3");
		this.hashFields.put("frm_imdg_subs_rsk_lbl_cd2", "frmImdgSubsRskLblCd2");
		this.hashFields.put("frm_sprt_fm_imdg_clss_cd", "frmSprtFmImdgClssCd");
		this.hashFields.put("frm_imdg_subs_rsk_lbl_cd1", "frmImdgSubsRskLblCd1");
		this.hashFields.put("frm_imdg_clss_cd", "frmImdgClssCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("frm_sprt_hld_fm_imdg_clss_cd", "frmSprtHldFmImdgClssCd");
		this.hashFields.put("frm_sprt_lon_fm_imdg_clss_cd", "frmSprtLonFmImdgClssCd");
		this.hashFields.put("msg_flg", "msgFlg");
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
	 * @return frmAwayFmImdgClssCd
	 */
	public String getFrmAwayFmImdgClssCd() {
		return this.frmAwayFmImdgClssCd;
	}
	
	/**
	 * Column Info
	 * @return frmSegrAsForImdgClssCd
	 */
	public String getFrmSegrAsForImdgClssCd() {
		return this.frmSegrAsForImdgClssCd;
	}
	
	/**
	 * Column Info
	 * @return frmImdgSubsRskLblCd4
	 */
	public String getFrmImdgSubsRskLblCd4() {
		return this.frmImdgSubsRskLblCd4;
	}
	
	/**
	 * Column Info
	 * @return frmImdgSubsRskLblCd3
	 */
	public String getFrmImdgSubsRskLblCd3() {
		return this.frmImdgSubsRskLblCd3;
	}
	
	/**
	 * Column Info
	 * @return frmImdgSubsRskLblCd2
	 */
	public String getFrmImdgSubsRskLblCd2() {
		return this.frmImdgSubsRskLblCd2;
	}
	
	/**
	 * Column Info
	 * @return frmSprtFmImdgClssCd
	 */
	public String getFrmSprtFmImdgClssCd() {
		return this.frmSprtFmImdgClssCd;
	}
	
	/**
	 * Column Info
	 * @return frmImdgSubsRskLblCd1
	 */
	public String getFrmImdgSubsRskLblCd1() {
		return this.frmImdgSubsRskLblCd1;
	}
	
	/**
	 * Column Info
	 * @return frmImdgClssCd
	 */
	public String getFrmImdgClssCd() {
		return this.frmImdgClssCd;
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
	 * @return frmSprtHldFmImdgClssCd
	 */
	public String getFrmSprtHldFmImdgClssCd() {
		return this.frmSprtHldFmImdgClssCd;
	}
	
	/**
	 * Column Info
	 * @return frmSprtLonFmImdgClssCd
	 */
	public String getFrmSprtLonFmImdgClssCd() {
		return this.frmSprtLonFmImdgClssCd;
	}
	
	/**
	 * Column Info
	 * @return msgFlg
	 */
	public String getMsgFlg() {
		return this.msgFlg;
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
	 * @param frmAwayFmImdgClssCd
	 */
	public void setFrmAwayFmImdgClssCd(String frmAwayFmImdgClssCd) {
		this.frmAwayFmImdgClssCd = frmAwayFmImdgClssCd;
	}
	
	/**
	 * Column Info
	 * @param frmSegrAsForImdgClssCd
	 */
	public void setFrmSegrAsForImdgClssCd(String frmSegrAsForImdgClssCd) {
		this.frmSegrAsForImdgClssCd = frmSegrAsForImdgClssCd;
	}
	
	/**
	 * Column Info
	 * @param frmImdgSubsRskLblCd4
	 */
	public void setFrmImdgSubsRskLblCd4(String frmImdgSubsRskLblCd4) {
		this.frmImdgSubsRskLblCd4 = frmImdgSubsRskLblCd4;
	}
	
	/**
	 * Column Info
	 * @param frmImdgSubsRskLblCd3
	 */
	public void setFrmImdgSubsRskLblCd3(String frmImdgSubsRskLblCd3) {
		this.frmImdgSubsRskLblCd3 = frmImdgSubsRskLblCd3;
	}
	
	/**
	 * Column Info
	 * @param frmImdgSubsRskLblCd2
	 */
	public void setFrmImdgSubsRskLblCd2(String frmImdgSubsRskLblCd2) {
		this.frmImdgSubsRskLblCd2 = frmImdgSubsRskLblCd2;
	}
	
	/**
	 * Column Info
	 * @param frmSprtFmImdgClssCd
	 */
	public void setFrmSprtFmImdgClssCd(String frmSprtFmImdgClssCd) {
		this.frmSprtFmImdgClssCd = frmSprtFmImdgClssCd;
	}
	
	/**
	 * Column Info
	 * @param frmImdgSubsRskLblCd1
	 */
	public void setFrmImdgSubsRskLblCd1(String frmImdgSubsRskLblCd1) {
		this.frmImdgSubsRskLblCd1 = frmImdgSubsRskLblCd1;
	}
	
	/**
	 * Column Info
	 * @param frmImdgClssCd
	 */
	public void setFrmImdgClssCd(String frmImdgClssCd) {
		this.frmImdgClssCd = frmImdgClssCd;
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
	 * @param frmSprtHldFmImdgClssCd
	 */
	public void setFrmSprtHldFmImdgClssCd(String frmSprtHldFmImdgClssCd) {
		this.frmSprtHldFmImdgClssCd = frmSprtHldFmImdgClssCd;
	}
	
	/**
	 * Column Info
	 * @param frmSprtLonFmImdgClssCd
	 */
	public void setFrmSprtLonFmImdgClssCd(String frmSprtLonFmImdgClssCd) {
		this.frmSprtLonFmImdgClssCd = frmSprtLonFmImdgClssCd;
	}
	
	/**
	 * Column Info
	 * @param msgFlg
	 */
	public void setMsgFlg(String msgFlg) {
		this.msgFlg = msgFlg;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setFrmAwayFmImdgClssCd(JSPUtil.getParameter(request, "frm_away_fm_imdg_clss_cd", ""));
		setFrmSegrAsForImdgClssCd(JSPUtil.getParameter(request, "frm_segr_as_for_imdg_clss_cd", ""));
		setFrmImdgSubsRskLblCd4(JSPUtil.getParameter(request, "frm_imdg_subs_rsk_lbl_cd4", ""));
		setFrmImdgSubsRskLblCd3(JSPUtil.getParameter(request, "frm_imdg_subs_rsk_lbl_cd3", ""));
		setFrmImdgSubsRskLblCd2(JSPUtil.getParameter(request, "frm_imdg_subs_rsk_lbl_cd2", ""));
		setFrmSprtFmImdgClssCd(JSPUtil.getParameter(request, "frm_sprt_fm_imdg_clss_cd", ""));
		setFrmImdgSubsRskLblCd1(JSPUtil.getParameter(request, "frm_imdg_subs_rsk_lbl_cd1", ""));
		setFrmImdgClssCd(JSPUtil.getParameter(request, "frm_imdg_clss_cd", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setFrmSprtHldFmImdgClssCd(JSPUtil.getParameter(request, "frm_sprt_hld_fm_imdg_clss_cd", ""));
		setFrmSprtLonFmImdgClssCd(JSPUtil.getParameter(request, "frm_sprt_lon_fm_imdg_clss_cd", ""));
		setMsgFlg(JSPUtil.getParameter(request, "msg_flg", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return AutoCreationVO[]
	 */
	public AutoCreationVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return AutoCreationVO[]
	 */
	public AutoCreationVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		AutoCreationVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] frmAwayFmImdgClssCd = (JSPUtil.getParameter(request, prefix	+ "frm_away_fm_imdg_clss_cd", length));
			String[] frmSegrAsForImdgClssCd = (JSPUtil.getParameter(request, prefix	+ "frm_segr_as_for_imdg_clss_cd", length));
			String[] frmImdgSubsRskLblCd4 = (JSPUtil.getParameter(request, prefix	+ "frm_imdg_subs_rsk_lbl_cd4", length));
			String[] frmImdgSubsRskLblCd3 = (JSPUtil.getParameter(request, prefix	+ "frm_imdg_subs_rsk_lbl_cd3", length));
			String[] frmImdgSubsRskLblCd2 = (JSPUtil.getParameter(request, prefix	+ "frm_imdg_subs_rsk_lbl_cd2", length));
			String[] frmSprtFmImdgClssCd = (JSPUtil.getParameter(request, prefix	+ "frm_sprt_fm_imdg_clss_cd", length));
			String[] frmImdgSubsRskLblCd1 = (JSPUtil.getParameter(request, prefix	+ "frm_imdg_subs_rsk_lbl_cd1", length));
			String[] frmImdgClssCd = (JSPUtil.getParameter(request, prefix	+ "frm_imdg_clss_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] frmSprtHldFmImdgClssCd = (JSPUtil.getParameter(request, prefix	+ "frm_sprt_hld_fm_imdg_clss_cd", length));
			String[] frmSprtLonFmImdgClssCd = (JSPUtil.getParameter(request, prefix	+ "frm_sprt_lon_fm_imdg_clss_cd", length));
			String[] msgFlg = (JSPUtil.getParameter(request, prefix	+ "msg_flg", length));
			
			for (int i = 0; i < length; i++) {
				model = new AutoCreationVO();
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (frmAwayFmImdgClssCd[i] != null)
					model.setFrmAwayFmImdgClssCd(frmAwayFmImdgClssCd[i]);
				if (frmSegrAsForImdgClssCd[i] != null)
					model.setFrmSegrAsForImdgClssCd(frmSegrAsForImdgClssCd[i]);
				if (frmImdgSubsRskLblCd4[i] != null)
					model.setFrmImdgSubsRskLblCd4(frmImdgSubsRskLblCd4[i]);
				if (frmImdgSubsRskLblCd3[i] != null)
					model.setFrmImdgSubsRskLblCd3(frmImdgSubsRskLblCd3[i]);
				if (frmImdgSubsRskLblCd2[i] != null)
					model.setFrmImdgSubsRskLblCd2(frmImdgSubsRskLblCd2[i]);
				if (frmSprtFmImdgClssCd[i] != null)
					model.setFrmSprtFmImdgClssCd(frmSprtFmImdgClssCd[i]);
				if (frmImdgSubsRskLblCd1[i] != null)
					model.setFrmImdgSubsRskLblCd1(frmImdgSubsRskLblCd1[i]);
				if (frmImdgClssCd[i] != null)
					model.setFrmImdgClssCd(frmImdgClssCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (frmSprtHldFmImdgClssCd[i] != null)
					model.setFrmSprtHldFmImdgClssCd(frmSprtHldFmImdgClssCd[i]);
				if (frmSprtLonFmImdgClssCd[i] != null)
					model.setFrmSprtLonFmImdgClssCd(frmSprtLonFmImdgClssCd[i]);
				if (msgFlg[i] != null)
					model.setMsgFlg(msgFlg[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getAutoCreationVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return AutoCreationVO[]
	 */
	public AutoCreationVO[] getAutoCreationVOs(){
		AutoCreationVO[] vos = (AutoCreationVO[])models.toArray(new AutoCreationVO[models.size()]);
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
		this.frmAwayFmImdgClssCd = this.frmAwayFmImdgClssCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.frmSegrAsForImdgClssCd = this.frmSegrAsForImdgClssCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.frmImdgSubsRskLblCd4 = this.frmImdgSubsRskLblCd4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.frmImdgSubsRskLblCd3 = this.frmImdgSubsRskLblCd3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.frmImdgSubsRskLblCd2 = this.frmImdgSubsRskLblCd2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.frmSprtFmImdgClssCd = this.frmSprtFmImdgClssCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.frmImdgSubsRskLblCd1 = this.frmImdgSubsRskLblCd1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.frmImdgClssCd = this.frmImdgClssCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.frmSprtHldFmImdgClssCd = this.frmSprtHldFmImdgClssCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.frmSprtLonFmImdgClssCd = this.frmSprtLonFmImdgClssCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.msgFlg = this.msgFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
