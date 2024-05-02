/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : ActEDISetupInfoVO.java
*@FileTitle : ActEDISetupInfoVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.11
*@LastModifier : 정진우
*@LastVersion : 1.0
* 2010.03.11 정진우 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.vop.vsk.actualschedulemanagement.actualschedulemgt.vo;

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
 * @author 정진우
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class ActEDISetupInfoVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<ActEDISetupInfoVO> models = new ArrayList<ActEDISetupInfoVO>();
	
	/* Column Info */
	private String actDateFlg = null;
	/* Column Info */
	private String vslCdFlg = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String sndrTrdPrnrId = null;
	/* Column Info */
	private String prnrSubLnkCd = null;
	/* Column Info */
	private String mnvrInHrsFlg = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public ActEDISetupInfoVO() {}

	public ActEDISetupInfoVO(String ibflag, String pagerows, String vslCdFlg, String mnvrInHrsFlg, String actDateFlg, String prnrSubLnkCd, String sndrTrdPrnrId) {
		this.actDateFlg = actDateFlg;
		this.vslCdFlg = vslCdFlg;
		this.ibflag = ibflag;
		this.sndrTrdPrnrId = sndrTrdPrnrId;
		this.prnrSubLnkCd = prnrSubLnkCd;
		this.mnvrInHrsFlg = mnvrInHrsFlg;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("act_date_flg", getActDateFlg());
		this.hashColumns.put("vsl_cd_flg", getVslCdFlg());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("sndr_trd_prnr_id", getSndrTrdPrnrId());
		this.hashColumns.put("prnr_sub_lnk_cd", getPrnrSubLnkCd());
		this.hashColumns.put("mnvr_in_hrs_flg", getMnvrInHrsFlg());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("act_date_flg", "actDateFlg");
		this.hashFields.put("vsl_cd_flg", "vslCdFlg");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("sndr_trd_prnr_id", "sndrTrdPrnrId");
		this.hashFields.put("prnr_sub_lnk_cd", "prnrSubLnkCd");
		this.hashFields.put("mnvr_in_hrs_flg", "mnvrInHrsFlg");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return actDateFlg
	 */
	public String getActDateFlg() {
		return this.actDateFlg;
	}
	
	/**
	 * Column Info
	 * @return vslCdFlg
	 */
	public String getVslCdFlg() {
		return this.vslCdFlg;
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
	 * @return sndrTrdPrnrId
	 */
	public String getSndrTrdPrnrId() {
		return this.sndrTrdPrnrId;
	}
	
	/**
	 * Column Info
	 * @return prnrSubLnkCd
	 */
	public String getPrnrSubLnkCd() {
		return this.prnrSubLnkCd;
	}
	
	/**
	 * Column Info
	 * @return mnvrInHrsFlg
	 */
	public String getMnvrInHrsFlg() {
		return this.mnvrInHrsFlg;
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
	 * @param actDateFlg
	 */
	public void setActDateFlg(String actDateFlg) {
		this.actDateFlg = actDateFlg;
	}
	
	/**
	 * Column Info
	 * @param vslCdFlg
	 */
	public void setVslCdFlg(String vslCdFlg) {
		this.vslCdFlg = vslCdFlg;
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
	 * @param sndrTrdPrnrId
	 */
	public void setSndrTrdPrnrId(String sndrTrdPrnrId) {
		this.sndrTrdPrnrId = sndrTrdPrnrId;
	}
	
	/**
	 * Column Info
	 * @param prnrSubLnkCd
	 */
	public void setPrnrSubLnkCd(String prnrSubLnkCd) {
		this.prnrSubLnkCd = prnrSubLnkCd;
	}
	
	/**
	 * Column Info
	 * @param mnvrInHrsFlg
	 */
	public void setMnvrInHrsFlg(String mnvrInHrsFlg) {
		this.mnvrInHrsFlg = mnvrInHrsFlg;
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
		setActDateFlg(JSPUtil.getParameter(request, "act_date_flg", ""));
		setVslCdFlg(JSPUtil.getParameter(request, "vsl_cd_flg", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setSndrTrdPrnrId(JSPUtil.getParameter(request, "sndr_trd_prnr_id", ""));
		setPrnrSubLnkCd(JSPUtil.getParameter(request, "prnr_sub_lnk_cd", ""));
		setMnvrInHrsFlg(JSPUtil.getParameter(request, "mnvr_in_hrs_flg", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return ActEDISetupInfoVO[]
	 */
	public ActEDISetupInfoVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return ActEDISetupInfoVO[]
	 */
	public ActEDISetupInfoVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		ActEDISetupInfoVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] actDateFlg = (JSPUtil.getParameter(request, prefix	+ "act_date_flg", length));
			String[] vslCdFlg = (JSPUtil.getParameter(request, prefix	+ "vsl_cd_flg", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] sndrTrdPrnrId = (JSPUtil.getParameter(request, prefix	+ "sndr_trd_prnr_id", length));
			String[] prnrSubLnkCd = (JSPUtil.getParameter(request, prefix	+ "prnr_sub_lnk_cd", length));
			String[] mnvrInHrsFlg = (JSPUtil.getParameter(request, prefix	+ "mnvr_in_hrs_flg", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new ActEDISetupInfoVO();
				if (actDateFlg[i] != null)
					model.setActDateFlg(actDateFlg[i]);
				if (vslCdFlg[i] != null)
					model.setVslCdFlg(vslCdFlg[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (sndrTrdPrnrId[i] != null)
					model.setSndrTrdPrnrId(sndrTrdPrnrId[i]);
				if (prnrSubLnkCd[i] != null)
					model.setPrnrSubLnkCd(prnrSubLnkCd[i]);
				if (mnvrInHrsFlg[i] != null)
					model.setMnvrInHrsFlg(mnvrInHrsFlg[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getActEDISetupInfoVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return ActEDISetupInfoVO[]
	 */
	public ActEDISetupInfoVO[] getActEDISetupInfoVOs(){
		ActEDISetupInfoVO[] vos = (ActEDISetupInfoVO[])models.toArray(new ActEDISetupInfoVO[models.size()]);
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
		this.actDateFlg = this.actDateFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslCdFlg = this.vslCdFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sndrTrdPrnrId = this.sndrTrdPrnrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prnrSubLnkCd = this.prnrSubLnkCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnvrInHrsFlg = this.mnvrInHrsFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
