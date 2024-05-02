/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CLLCDLManifestEdiTerminalInfoVO.java
*@FileTitle : CLLCDLManifestEdiTerminalInfoVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.24
*@LastModifier : 김승민
*@LastVersion : 1.0
* 2009.11.24 김승민 
* 1.0 Creation
* -------------------------------------------------------
* History
* 2012.08.09 김보배 [CHM-201219500] [BKG] CLL/CDL EDI 전송시 Receiver S/P추가
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.terminaldocumentation.cllcdlmanifest.vo;

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
 * @author 김승민
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class CLLCDLManifestEdiTerminalInfoVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<CLLCDLManifestEdiTerminalInfoVO> models = new ArrayList<CLLCDLManifestEdiTerminalInfoVO>();
	
	/* Column Info */
	private String ediTmlSvrCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String ediSndId = null;
	/* Column Info */
	private String ediRcvId = null;
	/* Column Info */
	private String ydCd = null;
	/* Column Info */
	private String areaId = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String vvdFlg = null;
	/* Column Info */
	private String blFlg = null;
	

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public CLLCDLManifestEdiTerminalInfoVO() {}

	public CLLCDLManifestEdiTerminalInfoVO(String ibflag, String pagerows, String ydCd, String ediRcvId, String ediSndId, String ediTmlSvrCd, String areaId, String vvdFlg, String blFlg) {
		this.ediTmlSvrCd = ediTmlSvrCd;
		this.ibflag = ibflag;
		this.ediSndId = ediSndId;
		this.ediRcvId = ediRcvId;
		this.ydCd = ydCd;
		this.areaId = areaId;
		this.pagerows = pagerows;
		this.vvdFlg = vvdFlg;
		this.blFlg = blFlg;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("edi_tml_svr_cd", getEdiTmlSvrCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("edi_snd_id", getEdiSndId());
		this.hashColumns.put("edi_rcv_id", getEdiRcvId());
		this.hashColumns.put("yd_cd", getYdCd());
		this.hashColumns.put("area_id", getAreaId());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("vvd_flg", getVvdFlg());
		this.hashColumns.put("bl_flg", getBlFlg());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("edi_tml_svr_cd", "ediTmlSvrCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("edi_snd_id", "ediSndId");
		this.hashFields.put("edi_rcv_id", "ediRcvId");
		this.hashFields.put("yd_cd", "ydCd");
		this.hashFields.put("area_id", "areaId");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("vvd_flg", "vvdFlg");
		this.hashFields.put("bl_flg", "blFlg");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return ediTmlSvrCd
	 */
	public String getEdiTmlSvrCd() {
		return this.ediTmlSvrCd;
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
	 * @return ediSndId
	 */
	public String getEdiSndId() {
		return this.ediSndId;
	}
	
	/**
	 * Column Info
	 * @return ediRcvId
	 */
	public String getEdiRcvId() {
		return this.ediRcvId;
	}
	
	/**
	 * Column Info
	 * @return ydCd
	 */
	public String getYdCd() {
		return this.ydCd;
	}
	
	/**
	 * Column Info
	 * @return areaId
	 */
	public String getAreaId() {
		return this.areaId;
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
	 * @return vvdFlg
	 */
	public String getVvdFlg() {
		return this.vvdFlg;
	}
	
	/**
	 * Column Info
	 * @return blFlg
	 */
	public String getBlFlg() {
		return this.blFlg;
	}
	

	/**
	 * Column Info
	 * @param ediTmlSvrCd
	 */
	public void setEdiTmlSvrCd(String ediTmlSvrCd) {
		this.ediTmlSvrCd = ediTmlSvrCd;
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
	 * @param ediSndId
	 */
	public void setEdiSndId(String ediSndId) {
		this.ediSndId = ediSndId;
	}
	
	/**
	 * Column Info
	 * @param ediRcvId
	 */
	public void setEdiRcvId(String ediRcvId) {
		this.ediRcvId = ediRcvId;
	}
	
	/**
	 * Column Info
	 * @param ydCd
	 */
	public void setYdCd(String ydCd) {
		this.ydCd = ydCd;
	}
	
	/**
	 * Column Info
	 * @param areaId
	 */
	public void setAreaId(String areaId) {
		this.areaId = areaId;
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
	 * @param vvdFlg
	 */
	public void setVvdFlg(String vvdFlg) {
		this.vvdFlg = vvdFlg;
	}
	
	/**
	 * Column Info
	 * @param blFlg
	 */
	public void setBlFlg(String blFlg){
		this.blFlg = blFlg;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setEdiTmlSvrCd(JSPUtil.getParameter(request, "edi_tml_svr_cd", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setEdiSndId(JSPUtil.getParameter(request, "edi_snd_id", ""));
		setEdiRcvId(JSPUtil.getParameter(request, "edi_rcv_id", ""));
		setYdCd(JSPUtil.getParameter(request, "yd_cd", ""));
		setAreaId(JSPUtil.getParameter(request, "area_id", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setVvdFlg(JSPUtil.getParameter(request, "vvd_flg", ""));
		setBlFlg(JSPUtil.getParameter(request, "bl_flg", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return CLLCDLManifestEdiTerminalInfoVO[]
	 */
	public CLLCDLManifestEdiTerminalInfoVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return CLLCDLManifestEdiTerminalInfoVO[]
	 */
	public CLLCDLManifestEdiTerminalInfoVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		CLLCDLManifestEdiTerminalInfoVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] ediTmlSvrCd = (JSPUtil.getParameter(request, prefix	+ "edi_tml_svr_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] ediSndId = (JSPUtil.getParameter(request, prefix	+ "edi_snd_id", length));
			String[] ediRcvId = (JSPUtil.getParameter(request, prefix	+ "edi_rcv_id", length));
			String[] ydCd = (JSPUtil.getParameter(request, prefix	+ "yd_cd", length));
			String[] areaId = (JSPUtil.getParameter(request, prefix	+ "area_id", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] vvdFlg = (JSPUtil.getParameter(request, prefix	+ "vvd_flg", length));
			String[] blFlg = (JSPUtil.getParameter(request, prefix	+ "bl_flg", length));
			
			for (int i = 0; i < length; i++) {
				model = new CLLCDLManifestEdiTerminalInfoVO();
				if (ediTmlSvrCd[i] != null)
					model.setEdiTmlSvrCd(ediTmlSvrCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (ediSndId[i] != null)
					model.setEdiSndId(ediSndId[i]);
				if (ediRcvId[i] != null)
					model.setEdiRcvId(ediRcvId[i]);
				if (ydCd[i] != null)
					model.setYdCd(ydCd[i]);
				if (areaId[i] != null)
					model.setAreaId(areaId[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (vvdFlg[i] != null)
					model.setVvdFlg(vvdFlg[i]);
				if (blFlg[i] != null)
					model.setBlFlg(blFlg[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getCLLCDLManifestEdiTerminalInfoVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return CLLCDLManifestEdiTerminalInfoVO[]
	 */
	public CLLCDLManifestEdiTerminalInfoVO[] getCLLCDLManifestEdiTerminalInfoVOs(){
		CLLCDLManifestEdiTerminalInfoVO[] vos = (CLLCDLManifestEdiTerminalInfoVO[])models.toArray(new CLLCDLManifestEdiTerminalInfoVO[models.size()]);
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
		this.ediTmlSvrCd = this.ediTmlSvrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ediSndId = this.ediSndId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ediRcvId = this.ediRcvId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ydCd = this.ydCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.areaId = this.areaId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvdFlg = this.vvdFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blFlg = this.blFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
