/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : MdmVslSvcLaneListVO.java
*@FileTitle : MdmVslSvcLaneListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.20
*@LastModifier : 장강철
*@LastVersion : 1.0
* 2009.10.20 장강철 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.vop.scg.specialcargomasterdatamgt.specialcargomasterdatamgt.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 장강철
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class MdmVslSvcLaneListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<MdmVslSvcLaneListVO> models = new ArrayList<MdmVslSvcLaneListVO>();
	
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String svcTypeName = null;
	/* Column Info */
	private String vslSvcTpCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String tmlProdRptFlg = null;
	/* Column Info */
	private String vslSlanNm = null;
	/* Column Info */
	private String spclCgoRqstTgtLaneFlg = null;
	/* Column Info */
	private String vslSlanCd = null;
	/* Column Info */
	private String updUsrId = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public MdmVslSvcLaneListVO() {}

	public MdmVslSvcLaneListVO(String ibflag, String pagerows, String vslSlanCd, String vslSlanNm, String vslSvcTpCd, String spclCgoRqstTgtLaneFlg, String tmlProdRptFlg, String updUsrId, String updDt, String svcTypeName) {
		this.updDt = updDt;
		this.svcTypeName = svcTypeName;
		this.vslSvcTpCd = vslSvcTpCd;
		this.ibflag = ibflag;
		this.tmlProdRptFlg = tmlProdRptFlg;
		this.vslSlanNm = vslSlanNm;
		this.spclCgoRqstTgtLaneFlg = spclCgoRqstTgtLaneFlg;
		this.vslSlanCd = vslSlanCd;
		this.updUsrId = updUsrId;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("svc_type_name", getSvcTypeName());
		this.hashColumns.put("vsl_svc_tp_cd", getVslSvcTpCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("tml_prod_rpt_flg", getTmlProdRptFlg());
		this.hashColumns.put("vsl_slan_nm", getVslSlanNm());
		this.hashColumns.put("spcl_cgo_rqst_tgt_lane_flg", getSpclCgoRqstTgtLaneFlg());
		this.hashColumns.put("vsl_slan_cd", getVslSlanCd());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("svc_type_name", "svcTypeName");
		this.hashFields.put("vsl_svc_tp_cd", "vslSvcTpCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("tml_prod_rpt_flg", "tmlProdRptFlg");
		this.hashFields.put("vsl_slan_nm", "vslSlanNm");
		this.hashFields.put("spcl_cgo_rqst_tgt_lane_flg", "spclCgoRqstTgtLaneFlg");
		this.hashFields.put("vsl_slan_cd", "vslSlanCd");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("pagerows", "pagerows");
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
	 * @return svcTypeName
	 */
	public String getSvcTypeName() {
		return this.svcTypeName;
	}
	
	/**
	 * Column Info
	 * @return vslSvcTpCd
	 */
	public String getVslSvcTpCd() {
		return this.vslSvcTpCd;
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
	 * @return tmlProdRptFlg
	 */
	public String getTmlProdRptFlg() {
		return this.tmlProdRptFlg;
	}
	
	/**
	 * Column Info
	 * @return vslSlanNm
	 */
	public String getVslSlanNm() {
		return this.vslSlanNm;
	}
	
	/**
	 * Column Info
	 * @return spclCgoRqstTgtLaneFlg
	 */
	public String getSpclCgoRqstTgtLaneFlg() {
		return this.spclCgoRqstTgtLaneFlg;
	}
	
	/**
	 * Column Info
	 * @return vslSlanCd
	 */
	public String getVslSlanCd() {
		return this.vslSlanCd;
	}
	
	/**
	 * Column Info
	 * @return updUsrId
	 */
	public String getUpdUsrId() {
		return this.updUsrId;
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
	 * @param updDt
	 */
	public void setUpdDt(String updDt) {
		this.updDt = updDt;
	}
	
	/**
	 * Column Info
	 * @param svcTypeName
	 */
	public void setSvcTypeName(String svcTypeName) {
		this.svcTypeName = svcTypeName;
	}
	
	/**
	 * Column Info
	 * @param vslSvcTpCd
	 */
	public void setVslSvcTpCd(String vslSvcTpCd) {
		this.vslSvcTpCd = vslSvcTpCd;
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
	 * @param tmlProdRptFlg
	 */
	public void setTmlProdRptFlg(String tmlProdRptFlg) {
		this.tmlProdRptFlg = tmlProdRptFlg;
	}
	
	/**
	 * Column Info
	 * @param vslSlanNm
	 */
	public void setVslSlanNm(String vslSlanNm) {
		this.vslSlanNm = vslSlanNm;
	}
	
	/**
	 * Column Info
	 * @param spclCgoRqstTgtLaneFlg
	 */
	public void setSpclCgoRqstTgtLaneFlg(String spclCgoRqstTgtLaneFlg) {
		this.spclCgoRqstTgtLaneFlg = spclCgoRqstTgtLaneFlg;
	}
	
	/**
	 * Column Info
	 * @param vslSlanCd
	 */
	public void setVslSlanCd(String vslSlanCd) {
		this.vslSlanCd = vslSlanCd;
	}
	
	/**
	 * Column Info
	 * @param updUsrId
	 */
	public void setUpdUsrId(String updUsrId) {
		this.updUsrId = updUsrId;
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
		setUpdDt(JSPUtil.getParameter(request, "upd_dt", ""));
		setSvcTypeName(JSPUtil.getParameter(request, "svc_type_name", ""));
		setVslSvcTpCd(JSPUtil.getParameter(request, "vsl_svc_tp_cd", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setTmlProdRptFlg(JSPUtil.getParameter(request, "tml_prod_rpt_flg", ""));
		setVslSlanNm(JSPUtil.getParameter(request, "vsl_slan_nm", ""));
		setSpclCgoRqstTgtLaneFlg(JSPUtil.getParameter(request, "spcl_cgo_rqst_tgt_lane_flg", ""));
		setVslSlanCd(JSPUtil.getParameter(request, "vsl_slan_cd", ""));
		setUpdUsrId(JSPUtil.getParameter(request, "upd_usr_id", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return MdmVslSvcLaneListVO[]
	 */
	public MdmVslSvcLaneListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return MdmVslSvcLaneListVO[]
	 */
	public MdmVslSvcLaneListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		MdmVslSvcLaneListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] svcTypeName = (JSPUtil.getParameter(request, prefix	+ "svc_type_name", length));
			String[] vslSvcTpCd = (JSPUtil.getParameter(request, prefix	+ "vsl_svc_tp_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] tmlProdRptFlg = (JSPUtil.getParameter(request, prefix	+ "tml_prod_rpt_flg", length));
			String[] vslSlanNm = (JSPUtil.getParameter(request, prefix	+ "vsl_slan_nm", length));
			String[] spclCgoRqstTgtLaneFlg = (JSPUtil.getParameter(request, prefix	+ "spcl_cgo_rqst_tgt_lane_flg", length));
			String[] vslSlanCd = (JSPUtil.getParameter(request, prefix	+ "vsl_slan_cd", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new MdmVslSvcLaneListVO();
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (svcTypeName[i] != null)
					model.setSvcTypeName(svcTypeName[i]);
				if (vslSvcTpCd[i] != null)
					model.setVslSvcTpCd(vslSvcTpCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (tmlProdRptFlg[i] != null)
					model.setTmlProdRptFlg(tmlProdRptFlg[i]);
				if (vslSlanNm[i] != null)
					model.setVslSlanNm(vslSlanNm[i]);
				if (spclCgoRqstTgtLaneFlg[i] != null)
					model.setSpclCgoRqstTgtLaneFlg(spclCgoRqstTgtLaneFlg[i]);
				if (vslSlanCd[i] != null)
					model.setVslSlanCd(vslSlanCd[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getMdmVslSvcLaneListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return MdmVslSvcLaneListVO[]
	 */
	public MdmVslSvcLaneListVO[] getMdmVslSvcLaneListVOs(){
		MdmVslSvcLaneListVO[] vos = (MdmVslSvcLaneListVO[])models.toArray(new MdmVslSvcLaneListVO[models.size()]);
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
		this.svcTypeName = this.svcTypeName .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslSvcTpCd = this.vslSvcTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tmlProdRptFlg = this.tmlProdRptFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslSlanNm = this.vslSlanNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.spclCgoRqstTgtLaneFlg = this.spclCgoRqstTgtLaneFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslSlanCd = this.vslSlanCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
