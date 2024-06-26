/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SaqCntrSzConvVO.java
*@FileTitle : SaqCntrSzConvVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.23
*@LastModifier : 김민아
*@LastVersion : 1.0
* 2009.07.23 김민아 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.spc.common.common.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.component.common.AbstractValueObject;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 김민아
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SaqCntrSzConvVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SaqCntrSzConvVO> models = new ArrayList<SaqCntrSzConvVO>();
	
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String teu40ftConvRto = null;
	/* Column Info */
	private String ovrTeu20ftConvRto = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String ovrTeu45ftHcConvRto = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String vslOwnIndCd = null;
	/* Column Info */
	private String teu40ftHcConvRto = null;
	/* Column Info */
	private String ovrTeu40ftConvRto = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String teu20ftConvRto = null;
	/* Column Info */
	private String ovrTeu40ftHcConvRto = null;
	/* Column Info */
	private String teu45ftHcConvRto = null;
	/* Column Info */
	private String updUsrId = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SaqCntrSzConvVO() {}

	public SaqCntrSzConvVO(String ibflag, String pagerows, String vslOwnIndCd, String teu20ftConvRto, String teu40ftConvRto, String teu40ftHcConvRto, String teu45ftHcConvRto, String ovrTeu20ftConvRto, String ovrTeu40ftConvRto, String ovrTeu40ftHcConvRto, String ovrTeu45ftHcConvRto, String creUsrId, String creDt, String updUsrId, String updDt) {
		this.updDt = updDt;
		this.teu40ftConvRto = teu40ftConvRto;
		this.ovrTeu20ftConvRto = ovrTeu20ftConvRto;
		this.creDt = creDt;
		this.ovrTeu45ftHcConvRto = ovrTeu45ftHcConvRto;
		this.pagerows = pagerows;
		this.vslOwnIndCd = vslOwnIndCd;
		this.teu40ftHcConvRto = teu40ftHcConvRto;
		this.ovrTeu40ftConvRto = ovrTeu40ftConvRto;
		this.ibflag = ibflag;
		this.creUsrId = creUsrId;
		this.teu20ftConvRto = teu20ftConvRto;
		this.ovrTeu40ftHcConvRto = ovrTeu40ftHcConvRto;
		this.teu45ftHcConvRto = teu45ftHcConvRto;
		this.updUsrId = updUsrId;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("teu_40ft_conv_rto", getTeu40ftConvRto());
		this.hashColumns.put("ovr_teu_20ft_conv_rto", getOvrTeu20ftConvRto());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("ovr_teu_45ft_hc_conv_rto", getOvrTeu45ftHcConvRto());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("vsl_own_ind_cd", getVslOwnIndCd());
		this.hashColumns.put("teu_40ft_hc_conv_rto", getTeu40ftHcConvRto());
		this.hashColumns.put("ovr_teu_40ft_conv_rto", getOvrTeu40ftConvRto());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("teu_20ft_conv_rto", getTeu20ftConvRto());
		this.hashColumns.put("ovr_teu_40ft_hc_conv_rto", getOvrTeu40ftHcConvRto());
		this.hashColumns.put("teu_45ft_hc_conv_rto", getTeu45ftHcConvRto());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("teu_40ft_conv_rto", "teu40ftConvRto");
		this.hashFields.put("ovr_teu_20ft_conv_rto", "ovrTeu20ftConvRto");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("ovr_teu_45ft_hc_conv_rto", "ovrTeu45ftHcConvRto");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("vsl_own_ind_cd", "vslOwnIndCd");
		this.hashFields.put("teu_40ft_hc_conv_rto", "teu40ftHcConvRto");
		this.hashFields.put("ovr_teu_40ft_conv_rto", "ovrTeu40ftConvRto");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("teu_20ft_conv_rto", "teu20ftConvRto");
		this.hashFields.put("ovr_teu_40ft_hc_conv_rto", "ovrTeu40ftHcConvRto");
		this.hashFields.put("teu_45ft_hc_conv_rto", "teu45ftHcConvRto");
		this.hashFields.put("upd_usr_id", "updUsrId");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return updDt
	 */
	public String getUpdDt() {
		return this.updDt;
	}
	
	/**
	 * Column Info
	 * @return teu40ftConvRto
	 */
	public String getTeu40ftConvRto() {
		return this.teu40ftConvRto;
	}
	
	/**
	 * Column Info
	 * @return ovrTeu20ftConvRto
	 */
	public String getOvrTeu20ftConvRto() {
		return this.ovrTeu20ftConvRto;
	}
	
	/**
	 * Column Info
	 * @return creDt
	 */
	public String getCreDt() {
		return this.creDt;
	}
	
	/**
	 * Column Info
	 * @return ovrTeu45ftHcConvRto
	 */
	public String getOvrTeu45ftHcConvRto() {
		return this.ovrTeu45ftHcConvRto;
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
	 * @return vslOwnIndCd
	 */
	public String getVslOwnIndCd() {
		return this.vslOwnIndCd;
	}
	
	/**
	 * Column Info
	 * @return teu40ftHcConvRto
	 */
	public String getTeu40ftHcConvRto() {
		return this.teu40ftHcConvRto;
	}
	
	/**
	 * Column Info
	 * @return ovrTeu40ftConvRto
	 */
	public String getOvrTeu40ftConvRto() {
		return this.ovrTeu40ftConvRto;
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
	 * @return creUsrId
	 */
	public String getCreUsrId() {
		return this.creUsrId;
	}
	
	/**
	 * Column Info
	 * @return teu20ftConvRto
	 */
	public String getTeu20ftConvRto() {
		return this.teu20ftConvRto;
	}
	
	/**
	 * Column Info
	 * @return ovrTeu40ftHcConvRto
	 */
	public String getOvrTeu40ftHcConvRto() {
		return this.ovrTeu40ftHcConvRto;
	}
	
	/**
	 * Column Info
	 * @return teu45ftHcConvRto
	 */
	public String getTeu45ftHcConvRto() {
		return this.teu45ftHcConvRto;
	}
	
	/**
	 * Column Info
	 * @return updUsrId
	 */
	public String getUpdUsrId() {
		return this.updUsrId;
	}
	

	/**
	 * Column Info
	 * @param updDt
	 */
	public void setUpdDt(String updDt) {
		this.updDt = updDt;
	}
	
	/**
	 * Column Info
	 * @param teu40ftConvRto
	 */
	public void setTeu40ftConvRto(String teu40ftConvRto) {
		this.teu40ftConvRto = teu40ftConvRto;
	}
	
	/**
	 * Column Info
	 * @param ovrTeu20ftConvRto
	 */
	public void setOvrTeu20ftConvRto(String ovrTeu20ftConvRto) {
		this.ovrTeu20ftConvRto = ovrTeu20ftConvRto;
	}
	
	/**
	 * Column Info
	 * @param creDt
	 */
	public void setCreDt(String creDt) {
		this.creDt = creDt;
	}
	
	/**
	 * Column Info
	 * @param ovrTeu45ftHcConvRto
	 */
	public void setOvrTeu45ftHcConvRto(String ovrTeu45ftHcConvRto) {
		this.ovrTeu45ftHcConvRto = ovrTeu45ftHcConvRto;
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
	 * @param vslOwnIndCd
	 */
	public void setVslOwnIndCd(String vslOwnIndCd) {
		this.vslOwnIndCd = vslOwnIndCd;
	}
	
	/**
	 * Column Info
	 * @param teu40ftHcConvRto
	 */
	public void setTeu40ftHcConvRto(String teu40ftHcConvRto) {
		this.teu40ftHcConvRto = teu40ftHcConvRto;
	}
	
	/**
	 * Column Info
	 * @param ovrTeu40ftConvRto
	 */
	public void setOvrTeu40ftConvRto(String ovrTeu40ftConvRto) {
		this.ovrTeu40ftConvRto = ovrTeu40ftConvRto;
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
	 * @param creUsrId
	 */
	public void setCreUsrId(String creUsrId) {
		this.creUsrId = creUsrId;
	}
	
	/**
	 * Column Info
	 * @param teu20ftConvRto
	 */
	public void setTeu20ftConvRto(String teu20ftConvRto) {
		this.teu20ftConvRto = teu20ftConvRto;
	}
	
	/**
	 * Column Info
	 * @param ovrTeu40ftHcConvRto
	 */
	public void setOvrTeu40ftHcConvRto(String ovrTeu40ftHcConvRto) {
		this.ovrTeu40ftHcConvRto = ovrTeu40ftHcConvRto;
	}
	
	/**
	 * Column Info
	 * @param teu45ftHcConvRto
	 */
	public void setTeu45ftHcConvRto(String teu45ftHcConvRto) {
		this.teu45ftHcConvRto = teu45ftHcConvRto;
	}
	
	/**
	 * Column Info
	 * @param updUsrId
	 */
	public void setUpdUsrId(String updUsrId) {
		this.updUsrId = updUsrId;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setUpdDt(JSPUtil.getParameter(request, "upd_dt", ""));
		setTeu40ftConvRto(JSPUtil.getParameter(request, "teu_40ft_conv_rto", ""));
		setOvrTeu20ftConvRto(JSPUtil.getParameter(request, "ovr_teu_20ft_conv_rto", ""));
		setCreDt(JSPUtil.getParameter(request, "cre_dt", ""));
		setOvrTeu45ftHcConvRto(JSPUtil.getParameter(request, "ovr_teu_45ft_hc_conv_rto", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setVslOwnIndCd(JSPUtil.getParameter(request, "vsl_own_ind_cd", ""));
		setTeu40ftHcConvRto(JSPUtil.getParameter(request, "teu_40ft_hc_conv_rto", ""));
		setOvrTeu40ftConvRto(JSPUtil.getParameter(request, "ovr_teu_40ft_conv_rto", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setCreUsrId(JSPUtil.getParameter(request, "cre_usr_id", ""));
		setTeu20ftConvRto(JSPUtil.getParameter(request, "teu_20ft_conv_rto", ""));
		setOvrTeu40ftHcConvRto(JSPUtil.getParameter(request, "ovr_teu_40ft_hc_conv_rto", ""));
		setTeu45ftHcConvRto(JSPUtil.getParameter(request, "teu_45ft_hc_conv_rto", ""));
		setUpdUsrId(JSPUtil.getParameter(request, "upd_usr_id", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SaqCntrSzConvVO[]
	 */
	public SaqCntrSzConvVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SaqCntrSzConvVO[]
	 */
	public SaqCntrSzConvVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SaqCntrSzConvVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] teu40ftConvRto = (JSPUtil.getParameter(request, prefix	+ "teu_40ft_conv_rto", length));
			String[] ovrTeu20ftConvRto = (JSPUtil.getParameter(request, prefix	+ "ovr_teu_20ft_conv_rto", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] ovrTeu45ftHcConvRto = (JSPUtil.getParameter(request, prefix	+ "ovr_teu_45ft_hc_conv_rto", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] vslOwnIndCd = (JSPUtil.getParameter(request, prefix	+ "vsl_own_ind_cd", length));
			String[] teu40ftHcConvRto = (JSPUtil.getParameter(request, prefix	+ "teu_40ft_hc_conv_rto", length));
			String[] ovrTeu40ftConvRto = (JSPUtil.getParameter(request, prefix	+ "ovr_teu_40ft_conv_rto", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] teu20ftConvRto = (JSPUtil.getParameter(request, prefix	+ "teu_20ft_conv_rto", length));
			String[] ovrTeu40ftHcConvRto = (JSPUtil.getParameter(request, prefix	+ "ovr_teu_40ft_hc_conv_rto", length));
			String[] teu45ftHcConvRto = (JSPUtil.getParameter(request, prefix	+ "teu_45ft_hc_conv_rto", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			
			for (int i = 0; i < length; i++) {
				model = new SaqCntrSzConvVO();
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (teu40ftConvRto[i] != null)
					model.setTeu40ftConvRto(teu40ftConvRto[i]);
				if (ovrTeu20ftConvRto[i] != null)
					model.setOvrTeu20ftConvRto(ovrTeu20ftConvRto[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (ovrTeu45ftHcConvRto[i] != null)
					model.setOvrTeu45ftHcConvRto(ovrTeu45ftHcConvRto[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (vslOwnIndCd[i] != null)
					model.setVslOwnIndCd(vslOwnIndCd[i]);
				if (teu40ftHcConvRto[i] != null)
					model.setTeu40ftHcConvRto(teu40ftHcConvRto[i]);
				if (ovrTeu40ftConvRto[i] != null)
					model.setOvrTeu40ftConvRto(ovrTeu40ftConvRto[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (teu20ftConvRto[i] != null)
					model.setTeu20ftConvRto(teu20ftConvRto[i]);
				if (ovrTeu40ftHcConvRto[i] != null)
					model.setOvrTeu40ftHcConvRto(ovrTeu40ftHcConvRto[i]);
				if (teu45ftHcConvRto[i] != null)
					model.setTeu45ftHcConvRto(teu45ftHcConvRto[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSaqCntrSzConvVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SaqCntrSzConvVO[]
	 */
	public SaqCntrSzConvVO[] getSaqCntrSzConvVOs(){
		SaqCntrSzConvVO[] vos = (SaqCntrSzConvVO[])models.toArray(new SaqCntrSzConvVO[models.size()]);
		return vos;
	}
	
	/**
	 * VO Class의 내용을 String으로 변환
	 */
	public String toString() {
		StringBuffer ret = new StringBuffer();
		Field[] field = this.getClass().getDeclaredFields();
		String space = "";
		try{
			for(int i = 0; i < field.length; i++){
				String[] arr = null;
				arr = getField(field, i);
				if(arr != null){
					for(int j = 0; j < arr.length; j++) {
						ret.append(field[i].getName().concat(space).substring(0, 30).concat("= ") + arr[j] + "\n");
					}
				} else {
					ret.append(field[i].getName() + " =  null \n");
				}
			}
		} catch (Exception ex) {
			return null;
		}
		return ret.toString();
	}
	
	/**
	 * 필드에 있는 값을 스트링 배열로 반환.
	 * @param field
	 * @param i
	 * @return String[]
	 */
	private String[] getField(Field[] field, int i) {
		String[] arr = null;
		try{
			arr = (String[]) field[i].get(this);
		}catch(Exception ex){
			arr = null;
		}
		return arr;
	}

	/**
	* 포맷팅된 문자열에서 특수문자 제거("-","/",",",":")
	*/
	public void unDataFormat(){
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.teu40ftConvRto = this.teu40ftConvRto .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ovrTeu20ftConvRto = this.ovrTeu20ftConvRto .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ovrTeu45ftHcConvRto = this.ovrTeu45ftHcConvRto .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslOwnIndCd = this.vslOwnIndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.teu40ftHcConvRto = this.teu40ftHcConvRto .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ovrTeu40ftConvRto = this.ovrTeu40ftConvRto .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.teu20ftConvRto = this.teu20ftConvRto .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ovrTeu40ftHcConvRto = this.ovrTeu40ftHcConvRto .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.teu45ftHcConvRto = this.teu45ftHcConvRto .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
