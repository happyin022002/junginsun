/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : IndiaCntrMtDetailVO.java
*@FileTitle : IndiaCntrMtDetailVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.24
*@LastModifier : 경종윤
*@LastVersion : 1.0
* 2009.06.24 경종윤 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.india.vo;

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
 * @author 경종윤
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class IndiaCntrMtDetailVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<IndiaCntrMtDetailVO> models = new ArrayList<IndiaCntrMtDetailVO>();
	
	/* Column Info */
	private String idaAgnId = null;
	/* Column Info */
	private String cntrWgt = null;
	/* Column Info */
	private String vslDeclDt = null;
	/* Column Info */
	private String callSgnNo = null;
	/* Column Info */
	private String idaLineNo = null;
	/* Column Info */
	private String skdVoyNo = null;
	/* Column Info */
	private String idaDeclVslNo = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String socFlg = null;
	/* Column Info */
	private String tmp0 = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String cnmvStsCd = null;
	/* Column Info */
	private String cntrNo = null;
	/* Column Info */
	private String cntrTpszCd = null;
	/* Column Info */
	private String pckQty = null;
	/* Column Info */
	private String cntrSealNo = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public IndiaCntrMtDetailVO() {}

	public IndiaCntrMtDetailVO(String ibflag, String pagerows, String callSgnNo, String skdVoyNo, String idaDeclVslNo, String vslDeclDt, String idaLineNo, String tmp0, String cntrNo, String cntrSealNo, String idaAgnId, String cnmvStsCd, String pckQty, String cntrWgt, String cntrTpszCd, String socFlg) {
		this.idaAgnId = idaAgnId;
		this.cntrWgt = cntrWgt;
		this.vslDeclDt = vslDeclDt;
		this.callSgnNo = callSgnNo;
		this.idaLineNo = idaLineNo;
		this.skdVoyNo = skdVoyNo;
		this.idaDeclVslNo = idaDeclVslNo;
		this.pagerows = pagerows;
		this.socFlg = socFlg;
		this.tmp0 = tmp0;
		this.ibflag = ibflag;
		this.cnmvStsCd = cnmvStsCd;
		this.cntrNo = cntrNo;
		this.cntrTpszCd = cntrTpszCd;
		this.pckQty = pckQty;
		this.cntrSealNo = cntrSealNo;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ida_agn_id", getIdaAgnId());
		this.hashColumns.put("cntr_wgt", getCntrWgt());
		this.hashColumns.put("vsl_decl_dt", getVslDeclDt());
		this.hashColumns.put("call_sgn_no", getCallSgnNo());
		this.hashColumns.put("ida_line_no", getIdaLineNo());
		this.hashColumns.put("skd_voy_no", getSkdVoyNo());
		this.hashColumns.put("ida_decl_vsl_no", getIdaDeclVslNo());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("soc_flg", getSocFlg());
		this.hashColumns.put("tmp0", getTmp0());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cnmv_sts_cd", getCnmvStsCd());
		this.hashColumns.put("cntr_no", getCntrNo());
		this.hashColumns.put("cntr_tpsz_cd", getCntrTpszCd());
		this.hashColumns.put("pck_qty", getPckQty());
		this.hashColumns.put("cntr_seal_no", getCntrSealNo());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("ida_agn_id", "idaAgnId");
		this.hashFields.put("cntr_wgt", "cntrWgt");
		this.hashFields.put("vsl_decl_dt", "vslDeclDt");
		this.hashFields.put("call_sgn_no", "callSgnNo");
		this.hashFields.put("ida_line_no", "idaLineNo");
		this.hashFields.put("skd_voy_no", "skdVoyNo");
		this.hashFields.put("ida_decl_vsl_no", "idaDeclVslNo");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("soc_flg", "socFlg");
		this.hashFields.put("tmp0", "tmp0");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cnmv_sts_cd", "cnmvStsCd");
		this.hashFields.put("cntr_no", "cntrNo");
		this.hashFields.put("cntr_tpsz_cd", "cntrTpszCd");
		this.hashFields.put("pck_qty", "pckQty");
		this.hashFields.put("cntr_seal_no", "cntrSealNo");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return idaAgnId
	 */
	public String getIdaAgnId() {
		return this.idaAgnId;
	}
	
	/**
	 * Column Info
	 * @return cntrWgt
	 */
	public String getCntrWgt() {
		return this.cntrWgt;
	}
	
	/**
	 * Column Info
	 * @return vslDeclDt
	 */
	public String getVslDeclDt() {
		return this.vslDeclDt;
	}
	
	/**
	 * Column Info
	 * @return callSgnNo
	 */
	public String getCallSgnNo() {
		return this.callSgnNo;
	}
	
	/**
	 * Column Info
	 * @return idaLineNo
	 */
	public String getIdaLineNo() {
		return this.idaLineNo;
	}
	
	/**
	 * Column Info
	 * @return skdVoyNo
	 */
	public String getSkdVoyNo() {
		return this.skdVoyNo;
	}
	
	/**
	 * Column Info
	 * @return idaDeclVslNo
	 */
	public String getIdaDeclVslNo() {
		return this.idaDeclVslNo;
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
	 * @return socFlg
	 */
	public String getSocFlg() {
		return this.socFlg;
	}
	
	/**
	 * Column Info
	 * @return tmp0
	 */
	public String getTmp0() {
		return this.tmp0;
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
	 * @return cnmvStsCd
	 */
	public String getCnmvStsCd() {
		return this.cnmvStsCd;
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
	 * @return cntrTpszCd
	 */
	public String getCntrTpszCd() {
		return this.cntrTpszCd;
	}
	
	/**
	 * Column Info
	 * @return pckQty
	 */
	public String getPckQty() {
		return this.pckQty;
	}
	
	/**
	 * Column Info
	 * @return cntrSealNo
	 */
	public String getCntrSealNo() {
		return this.cntrSealNo;
	}
	

	/**
	 * Column Info
	 * @param idaAgnId
	 */
	public void setIdaAgnId(String idaAgnId) {
		this.idaAgnId = idaAgnId;
	}
	
	/**
	 * Column Info
	 * @param cntrWgt
	 */
	public void setCntrWgt(String cntrWgt) {
		this.cntrWgt = cntrWgt;
	}
	
	/**
	 * Column Info
	 * @param vslDeclDt
	 */
	public void setVslDeclDt(String vslDeclDt) {
		this.vslDeclDt = vslDeclDt;
	}
	
	/**
	 * Column Info
	 * @param callSgnNo
	 */
	public void setCallSgnNo(String callSgnNo) {
		this.callSgnNo = callSgnNo;
	}
	
	/**
	 * Column Info
	 * @param idaLineNo
	 */
	public void setIdaLineNo(String idaLineNo) {
		this.idaLineNo = idaLineNo;
	}
	
	/**
	 * Column Info
	 * @param skdVoyNo
	 */
	public void setSkdVoyNo(String skdVoyNo) {
		this.skdVoyNo = skdVoyNo;
	}
	
	/**
	 * Column Info
	 * @param idaDeclVslNo
	 */
	public void setIdaDeclVslNo(String idaDeclVslNo) {
		this.idaDeclVslNo = idaDeclVslNo;
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
	 * @param socFlg
	 */
	public void setSocFlg(String socFlg) {
		this.socFlg = socFlg;
	}
	
	/**
	 * Column Info
	 * @param tmp0
	 */
	public void setTmp0(String tmp0) {
		this.tmp0 = tmp0;
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
	 * @param cnmvStsCd
	 */
	public void setCnmvStsCd(String cnmvStsCd) {
		this.cnmvStsCd = cnmvStsCd;
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
	 * @param cntrTpszCd
	 */
	public void setCntrTpszCd(String cntrTpszCd) {
		this.cntrTpszCd = cntrTpszCd;
	}
	
	/**
	 * Column Info
	 * @param pckQty
	 */
	public void setPckQty(String pckQty) {
		this.pckQty = pckQty;
	}
	
	/**
	 * Column Info
	 * @param cntrSealNo
	 */
	public void setCntrSealNo(String cntrSealNo) {
		this.cntrSealNo = cntrSealNo;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setIdaAgnId(JSPUtil.getParameter(request, "ida_agn_id", ""));
		setCntrWgt(JSPUtil.getParameter(request, "cntr_wgt", ""));
		setVslDeclDt(JSPUtil.getParameter(request, "vsl_decl_dt", ""));
		setCallSgnNo(JSPUtil.getParameter(request, "call_sgn_no", ""));
		setIdaLineNo(JSPUtil.getParameter(request, "ida_line_no", ""));
		setSkdVoyNo(JSPUtil.getParameter(request, "skd_voy_no", ""));
		setIdaDeclVslNo(JSPUtil.getParameter(request, "ida_decl_vsl_no", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setSocFlg(JSPUtil.getParameter(request, "soc_flg", ""));
		setTmp0(JSPUtil.getParameter(request, "tmp0", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setCnmvStsCd(JSPUtil.getParameter(request, "cnmv_sts_cd", ""));
		setCntrNo(JSPUtil.getParameter(request, "cntr_no", ""));
		setCntrTpszCd(JSPUtil.getParameter(request, "cntr_tpsz_cd", ""));
		setPckQty(JSPUtil.getParameter(request, "pck_qty", ""));
		setCntrSealNo(JSPUtil.getParameter(request, "cntr_seal_no", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return IndiaCntrMtDetailVO[]
	 */
	public IndiaCntrMtDetailVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return IndiaCntrMtDetailVO[]
	 */
	public IndiaCntrMtDetailVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		IndiaCntrMtDetailVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] idaAgnId = (JSPUtil.getParameter(request, prefix	+ "ida_agn_id", length));
			String[] cntrWgt = (JSPUtil.getParameter(request, prefix	+ "cntr_wgt", length));
			String[] vslDeclDt = (JSPUtil.getParameter(request, prefix	+ "vsl_decl_dt", length));
			String[] callSgnNo = (JSPUtil.getParameter(request, prefix	+ "call_sgn_no", length));
			String[] idaLineNo = (JSPUtil.getParameter(request, prefix	+ "ida_line_no", length));
			String[] skdVoyNo = (JSPUtil.getParameter(request, prefix	+ "skd_voy_no", length));
			String[] idaDeclVslNo = (JSPUtil.getParameter(request, prefix	+ "ida_decl_vsl_no", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] socFlg = (JSPUtil.getParameter(request, prefix	+ "soc_flg", length));
			String[] tmp0 = (JSPUtil.getParameter(request, prefix	+ "tmp0", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] cnmvStsCd = (JSPUtil.getParameter(request, prefix	+ "cnmv_sts_cd", length));
			String[] cntrNo = (JSPUtil.getParameter(request, prefix	+ "cntr_no", length));
			String[] cntrTpszCd = (JSPUtil.getParameter(request, prefix	+ "cntr_tpsz_cd", length));
			String[] pckQty = (JSPUtil.getParameter(request, prefix	+ "pck_qty", length));
			String[] cntrSealNo = (JSPUtil.getParameter(request, prefix	+ "cntr_seal_no", length));
			
			for (int i = 0; i < length; i++) {
				model = new IndiaCntrMtDetailVO();
				if (idaAgnId[i] != null)
					model.setIdaAgnId(idaAgnId[i]);
				if (cntrWgt[i] != null)
					model.setCntrWgt(cntrWgt[i]);
				if (vslDeclDt[i] != null)
					model.setVslDeclDt(vslDeclDt[i]);
				if (callSgnNo[i] != null)
					model.setCallSgnNo(callSgnNo[i]);
				if (idaLineNo[i] != null)
					model.setIdaLineNo(idaLineNo[i]);
				if (skdVoyNo[i] != null)
					model.setSkdVoyNo(skdVoyNo[i]);
				if (idaDeclVslNo[i] != null)
					model.setIdaDeclVslNo(idaDeclVslNo[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (socFlg[i] != null)
					model.setSocFlg(socFlg[i]);
				if (tmp0[i] != null)
					model.setTmp0(tmp0[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (cnmvStsCd[i] != null)
					model.setCnmvStsCd(cnmvStsCd[i]);
				if (cntrNo[i] != null)
					model.setCntrNo(cntrNo[i]);
				if (cntrTpszCd[i] != null)
					model.setCntrTpszCd(cntrTpszCd[i]);
				if (pckQty[i] != null)
					model.setPckQty(pckQty[i]);
				if (cntrSealNo[i] != null)
					model.setCntrSealNo(cntrSealNo[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getIndiaCntrMtDetailVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return IndiaCntrMtDetailVO[]
	 */
	public IndiaCntrMtDetailVO[] getIndiaCntrMtDetailVOs(){
		IndiaCntrMtDetailVO[] vos = (IndiaCntrMtDetailVO[])models.toArray(new IndiaCntrMtDetailVO[models.size()]);
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
		this.idaAgnId = this.idaAgnId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrWgt = this.cntrWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslDeclDt = this.vslDeclDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.callSgnNo = this.callSgnNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.idaLineNo = this.idaLineNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdVoyNo = this.skdVoyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.idaDeclVslNo = this.idaDeclVslNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.socFlg = this.socFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tmp0 = this.tmp0 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnmvStsCd = this.cnmvStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo = this.cntrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd = this.cntrTpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pckQty = this.pckQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrSealNo = this.cntrSealNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
