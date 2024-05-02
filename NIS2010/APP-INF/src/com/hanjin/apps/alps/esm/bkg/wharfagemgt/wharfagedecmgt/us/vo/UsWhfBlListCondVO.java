/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : UsWhfBlListCondVO.java
*@FileTitle : UsWhfBlListCondVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.20
*@LastModifier : 김민정
*@LastVersion : 1.0
* 2009.08.20 김민정 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.wharfagemgt.wharfagedecmgt.us.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.apps.alps.esm.bkg.wharfagemgt.wharfagedecmgt.vo.WhfBlListCondVO;
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

public class UsWhfBlListCondVO extends WhfBlListCondVO {

	private static final long serialVersionUID = 1L;
	
	private Collection<UsWhfBlListCondVO> models = new ArrayList<UsWhfBlListCondVO>();
	
	/* Column Info */
	private String port = null;
	/* Column Info */
	private String usaWhfExptFlg = null;
	/* Column Info */
	private String ft45 = null;
	/* Column Info */
	private String delCd = null;
	/* Column Info */
	private String blNo = null;
	/* Column Info */
	private String ft40 = null;
	/* Column Info */
	private String typeRail = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String ft20 = null;
	/* Column Info */
	private String vvd = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String whfFlg = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String fm = null;
	/* Column Info */
	private String term = null;
	/* Column Info */
	private String cntrNo = null;
	/* Column Info */
	private String cstmsDesc = null;
	/* Column Info */
	private String usaWhfTpCd = null;
	/* Column Info */
	private String bound = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public UsWhfBlListCondVO() {}

	public UsWhfBlListCondVO(String ibflag, String pagerows, String blNo, String bkgNo, String cntrNo, String fm, String cstmsDesc, String usaWhfExptFlg, String delCd, String term, String usaWhfTpCd, String ft20, String ft40, String ft45, String whfFlg, String port, String vvd, String bound, String typeRail, String creUsrId) {
		this.port = port;
		this.usaWhfExptFlg = usaWhfExptFlg;
		this.ft45 = ft45;
		this.delCd = delCd;
		this.blNo = blNo;
		this.ft40 = ft40;
		this.typeRail = typeRail;
		this.pagerows = pagerows;
		this.ft20 = ft20;
		this.vvd = vvd;
		this.creUsrId = creUsrId;
		this.whfFlg = whfFlg;
		this.ibflag = ibflag;
		this.bkgNo = bkgNo;
		this.fm = fm;
		this.term = term;
		this.cntrNo = cntrNo;
		this.cstmsDesc = cstmsDesc;
		this.usaWhfTpCd = usaWhfTpCd;
		this.bound = bound;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("port", getPort());
		this.hashColumns.put("usa_whf_expt_flg", getUsaWhfExptFlg());
		this.hashColumns.put("ft45", getFt45());
		this.hashColumns.put("del_cd", getDelCd());
		this.hashColumns.put("bl_no", getBlNo());
		this.hashColumns.put("ft40", getFt40());
		this.hashColumns.put("type_rail", getTypeRail());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ft20", getFt20());
		this.hashColumns.put("vvd", getVvd());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("whf_flg", getWhfFlg());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("fm", getFm());
		this.hashColumns.put("term", getTerm());
		this.hashColumns.put("cntr_no", getCntrNo());
		this.hashColumns.put("cstms_desc", getCstmsDesc());
		this.hashColumns.put("usa_whf_tp_cd", getUsaWhfTpCd());
		this.hashColumns.put("bound", getBound());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("port", "port");
		this.hashFields.put("usa_whf_expt_flg", "usaWhfExptFlg");
		this.hashFields.put("ft45", "ft45");
		this.hashFields.put("del_cd", "delCd");
		this.hashFields.put("bl_no", "blNo");
		this.hashFields.put("ft40", "ft40");
		this.hashFields.put("type_rail", "typeRail");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ft20", "ft20");
		this.hashFields.put("vvd", "vvd");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("whf_flg", "whfFlg");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("fm", "fm");
		this.hashFields.put("term", "term");
		this.hashFields.put("cntr_no", "cntrNo");
		this.hashFields.put("cstms_desc", "cstmsDesc");
		this.hashFields.put("usa_whf_tp_cd", "usaWhfTpCd");
		this.hashFields.put("bound", "bound");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return port
	 */
	public String getPort() {
		return this.port;
	}
	
	/**
	 * Column Info
	 * @return usaWhfExptFlg
	 */
	public String getUsaWhfExptFlg() {
		return this.usaWhfExptFlg;
	}
	
	/**
	 * Column Info
	 * @return ft45
	 */
	public String getFt45() {
		return this.ft45;
	}
	
	/**
	 * Column Info
	 * @return delCd
	 */
	public String getDelCd() {
		return this.delCd;
	}
	
	/**
	 * Column Info
	 * @return blNo
	 */
	public String getBlNo() {
		return this.blNo;
	}
	
	/**
	 * Column Info
	 * @return ft40
	 */
	public String getFt40() {
		return this.ft40;
	}
	
	/**
	 * Column Info
	 * @return typeRail
	 */
	public String getTypeRail() {
		return this.typeRail;
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
	 * @return ft20
	 */
	public String getFt20() {
		return this.ft20;
	}
	
	/**
	 * Column Info
	 * @return vvd
	 */
	public String getVvd() {
		return this.vvd;
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
	 * @return whfFlg
	 */
	public String getWhfFlg() {
		return this.whfFlg;
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
	 * @return bkgNo
	 */
	public String getBkgNo() {
		return this.bkgNo;
	}
	
	/**
	 * Column Info
	 * @return fm
	 */
	public String getFm() {
		return this.fm;
	}
	
	/**
	 * Column Info
	 * @return term
	 */
	public String getTerm() {
		return this.term;
	}
	
	/**
	 * Column Info
	 * @return cntrNo
	 */
	public String getCntrNo() {
		return this.cntrNo;
	}
	
	/**
	 * Column Info
	 * @return cstmsDesc
	 */
	public String getCstmsDesc() {
		return this.cstmsDesc;
	}
	
	/**
	 * Column Info
	 * @return usaWhfTpCd
	 */
	public String getUsaWhfTpCd() {
		return this.usaWhfTpCd;
	}
	
	/**
	 * Column Info
	 * @return bound
	 */
	public String getBound() {
		return this.bound;
	}
	

	/**
	 * Column Info
	 * @param port
	 */
	public void setPort(String port) {
		this.port = port;
	}
	
	/**
	 * Column Info
	 * @param usaWhfExptFlg
	 */
	public void setUsaWhfExptFlg(String usaWhfExptFlg) {
		this.usaWhfExptFlg = usaWhfExptFlg;
	}
	
	/**
	 * Column Info
	 * @param ft45
	 */
	public void setFt45(String ft45) {
		this.ft45 = ft45;
	}
	
	/**
	 * Column Info
	 * @param delCd
	 */
	public void setDelCd(String delCd) {
		this.delCd = delCd;
	}
	
	/**
	 * Column Info
	 * @param blNo
	 */
	public void setBlNo(String blNo) {
		this.blNo = blNo;
	}
	
	/**
	 * Column Info
	 * @param ft40
	 */
	public void setFt40(String ft40) {
		this.ft40 = ft40;
	}
	
	/**
	 * Column Info
	 * @param typeRail
	 */
	public void setTypeRail(String typeRail) {
		this.typeRail = typeRail;
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
	 * @param ft20
	 */
	public void setFt20(String ft20) {
		this.ft20 = ft20;
	}
	
	/**
	 * Column Info
	 * @param vvd
	 */
	public void setVvd(String vvd) {
		this.vvd = vvd;
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
	 * @param whfFlg
	 */
	public void setWhfFlg(String whfFlg) {
		this.whfFlg = whfFlg;
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
	 * @param bkgNo
	 */
	public void setBkgNo(String bkgNo) {
		this.bkgNo = bkgNo;
	}
	
	/**
	 * Column Info
	 * @param fm
	 */
	public void setFm(String fm) {
		this.fm = fm;
	}
	
	/**
	 * Column Info
	 * @param term
	 */
	public void setTerm(String term) {
		this.term = term;
	}
	
	/**
	 * Column Info
	 * @param cntrNo
	 */
	public void setCntrNo(String cntrNo) {
		this.cntrNo = cntrNo;
	}
	
	/**
	 * Column Info
	 * @param cstmsDesc
	 */
	public void setCstmsDesc(String cstmsDesc) {
		this.cstmsDesc = cstmsDesc;
	}
	
	/**
	 * Column Info
	 * @param usaWhfTpCd
	 */
	public void setUsaWhfTpCd(String usaWhfTpCd) {
		this.usaWhfTpCd = usaWhfTpCd;
	}
	
	/**
	 * Column Info
	 * @param bound
	 */
	public void setBound(String bound) {
		this.bound = bound;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setPort(JSPUtil.getParameter(request, "port", ""));
		setUsaWhfExptFlg(JSPUtil.getParameter(request, "usa_whf_expt_flg", ""));
		setFt45(JSPUtil.getParameter(request, "ft45", ""));
		setDelCd(JSPUtil.getParameter(request, "del_cd", ""));
		setBlNo(JSPUtil.getParameter(request, "bl_no", ""));
		setFt40(JSPUtil.getParameter(request, "ft40", ""));
		setTypeRail(JSPUtil.getParameter(request, "type_rail", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setFt20(JSPUtil.getParameter(request, "ft20", ""));
		setVvd(JSPUtil.getParameter(request, "vvd", ""));
		setCreUsrId(JSPUtil.getParameter(request, "cre_usr_id", ""));
		setWhfFlg(JSPUtil.getParameter(request, "whf_flg", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setBkgNo(JSPUtil.getParameter(request, "bkg_no", ""));
		setFm(JSPUtil.getParameter(request, "fm", ""));
		setTerm(JSPUtil.getParameter(request, "term", ""));
		setCntrNo(JSPUtil.getParameter(request, "cntr_no", ""));
		setCstmsDesc(JSPUtil.getParameter(request, "cstms_desc", ""));
		setUsaWhfTpCd(JSPUtil.getParameter(request, "usa_whf_tp_cd", ""));
		setBound(JSPUtil.getParameter(request, "bound", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return UsWhfBlListCondVO[]
	 */
	public UsWhfBlListCondVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return UsWhfBlListCondVO[]
	 */
	public UsWhfBlListCondVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		UsWhfBlListCondVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] port = (JSPUtil.getParameter(request, prefix	+ "port", length));
			String[] usaWhfExptFlg = (JSPUtil.getParameter(request, prefix	+ "usa_whf_expt_flg", length));
			String[] ft45 = (JSPUtil.getParameter(request, prefix	+ "ft45", length));
			String[] delCd = (JSPUtil.getParameter(request, prefix	+ "del_cd", length));
			String[] blNo = (JSPUtil.getParameter(request, prefix	+ "bl_no", length));
			String[] ft40 = (JSPUtil.getParameter(request, prefix	+ "ft40", length));
			String[] typeRail = (JSPUtil.getParameter(request, prefix	+ "type_rail", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ft20 = (JSPUtil.getParameter(request, prefix	+ "ft20", length));
			String[] vvd = (JSPUtil.getParameter(request, prefix	+ "vvd", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] whfFlg = (JSPUtil.getParameter(request, prefix	+ "whf_flg", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] fm = (JSPUtil.getParameter(request, prefix	+ "fm", length));
			String[] term = (JSPUtil.getParameter(request, prefix	+ "term", length));
			String[] cntrNo = (JSPUtil.getParameter(request, prefix	+ "cntr_no", length));
			String[] cstmsDesc = (JSPUtil.getParameter(request, prefix	+ "cstms_desc", length));
			String[] usaWhfTpCd = (JSPUtil.getParameter(request, prefix	+ "usa_whf_tp_cd", length));
			String[] bound = (JSPUtil.getParameter(request, prefix	+ "bound", length));
			
			for (int i = 0; i < length; i++) {
				model = new UsWhfBlListCondVO();
				if (port[i] != null)
					model.setPort(port[i]);
				if (usaWhfExptFlg[i] != null)
					model.setUsaWhfExptFlg(usaWhfExptFlg[i]);
				if (ft45[i] != null)
					model.setFt45(ft45[i]);
				if (delCd[i] != null)
					model.setDelCd(delCd[i]);
				if (blNo[i] != null)
					model.setBlNo(blNo[i]);
				if (ft40[i] != null)
					model.setFt40(ft40[i]);
				if (typeRail[i] != null)
					model.setTypeRail(typeRail[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ft20[i] != null)
					model.setFt20(ft20[i]);
				if (vvd[i] != null)
					model.setVvd(vvd[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (whfFlg[i] != null)
					model.setWhfFlg(whfFlg[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (fm[i] != null)
					model.setFm(fm[i]);
				if (term[i] != null)
					model.setTerm(term[i]);
				if (cntrNo[i] != null)
					model.setCntrNo(cntrNo[i]);
				if (cstmsDesc[i] != null)
					model.setCstmsDesc(cstmsDesc[i]);
				if (usaWhfTpCd[i] != null)
					model.setUsaWhfTpCd(usaWhfTpCd[i]);
				if (bound[i] != null)
					model.setBound(bound[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getUsWhfBlListCondVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return UsWhfBlListCondVO[]
	 */
	public UsWhfBlListCondVO[] getUsWhfBlListCondVOs(){
		UsWhfBlListCondVO[] vos = (UsWhfBlListCondVO[])models.toArray(new UsWhfBlListCondVO[models.size()]);
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
		this.port = this.port .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usaWhfExptFlg = this.usaWhfExptFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ft45 = this.ft45 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delCd = this.delCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo = this.blNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ft40 = this.ft40 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.typeRail = this.typeRail .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ft20 = this.ft20 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd = this.vvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.whfFlg = this.whfFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fm = this.fm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.term = this.term .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo = this.cntrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cstmsDesc = this.cstmsDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usaWhfTpCd = this.usaWhfTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bound = this.bound .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
