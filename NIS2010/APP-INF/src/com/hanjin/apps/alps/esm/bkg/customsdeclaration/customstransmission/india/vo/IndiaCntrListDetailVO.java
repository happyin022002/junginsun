/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : IndiaCntrListDetailVO.java
*@FileTitle : IndiaCntrListDetailVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.01
*@LastModifier : 경종윤
*@LastVersion : 1.0
* 2009.07.01 경종윤 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.india.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.vo.TransmitDetailVO;
import com.hanjin.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 경종윤
 * @since J2EE 1.6
 * @see TransmitDetailVO
 */

public class IndiaCntrListDetailVO extends TransmitDetailVO {

	private static final long serialVersionUID = 1L;
	
	private Collection<IndiaCntrListDetailVO> models = new ArrayList<IndiaCntrListDetailVO>();
	
	/* Column Info */
	private String idaAgnId = null;
	/* Column Info */
	private String vslDeclDt = null;
	/* Column Info */
	private String cntrWgt = null;
	/* Column Info */
	private String idaLineNo = null;
	/* Column Info */
	private String idaTrspCd = null;
	/* Column Info */
	private String crrAgnCd = null;
	/* Column Info */
	private String idaDeclVslNo = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String tmp0 = null;
	/* Column Info */
	private String otrDchgCd = null;
	/* Column Info */
	private String tmp2 = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String tmp1 = null;
	/* Column Info */
	private String tmp4 = null;
	/* Column Info */
	private String tmp3 = null;
	/* Column Info */
	private String tmp5 = null;
	/* Column Info */
	private String wgtUtCd = null;
	/* Column Info */
	private String pckQty = null;
	/* Column Info */
	private String tpFee = null;
	/* Column Info */
	private String ibdNo = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public IndiaCntrListDetailVO() {}

	public IndiaCntrListDetailVO(String ibflag, String pagerows, String idaAgnId, String idaDeclVslNo, String vslDeclDt, String idaLineNo, String tmp0, String otrDchgCd, String idaTrspCd, String pckQty, String cntrWgt, String wgtUtCd, String tmp1, String tmp2, String tmp3, String tmp4, String tmp5, String ibdNo, String tpFee, String crrAgnCd) {
		this.idaAgnId = idaAgnId;
		this.vslDeclDt = vslDeclDt;
		this.cntrWgt = cntrWgt;
		this.idaLineNo = idaLineNo;
		this.idaTrspCd = idaTrspCd;
		this.crrAgnCd = crrAgnCd;
		this.idaDeclVslNo = idaDeclVslNo;
		this.pagerows = pagerows;
		this.tmp0 = tmp0;
		this.otrDchgCd = otrDchgCd;
		this.tmp2 = tmp2;
		this.ibflag = ibflag;
		this.tmp1 = tmp1;
		this.tmp4 = tmp4;
		this.tmp3 = tmp3;
		this.tmp5 = tmp5;
		this.wgtUtCd = wgtUtCd;
		this.pckQty = pckQty;
		this.tpFee = tpFee;
		this.ibdNo = ibdNo;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ida_agn_id", getIdaAgnId());
		this.hashColumns.put("vsl_decl_dt", getVslDeclDt());
		this.hashColumns.put("cntr_wgt", getCntrWgt());
		this.hashColumns.put("ida_line_no", getIdaLineNo());
		this.hashColumns.put("ida_trsp_cd", getIdaTrspCd());
		this.hashColumns.put("crr_agn_cd", getCrrAgnCd());
		this.hashColumns.put("ida_decl_vsl_no", getIdaDeclVslNo());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("tmp0", getTmp0());
		this.hashColumns.put("otr_dchg_cd", getOtrDchgCd());
		this.hashColumns.put("tmp2", getTmp2());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("tmp1", getTmp1());
		this.hashColumns.put("tmp4", getTmp4());
		this.hashColumns.put("tmp3", getTmp3());
		this.hashColumns.put("tmp5", getTmp5());
		this.hashColumns.put("wgt_ut_cd", getWgtUtCd());
		this.hashColumns.put("pck_qty", getPckQty());
		this.hashColumns.put("tp_fee", getTpFee());
		this.hashColumns.put("ibd_no", getIbdNo());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("ida_agn_id", "idaAgnId");
		this.hashFields.put("vsl_decl_dt", "vslDeclDt");
		this.hashFields.put("cntr_wgt", "cntrWgt");
		this.hashFields.put("ida_line_no", "idaLineNo");
		this.hashFields.put("ida_trsp_cd", "idaTrspCd");
		this.hashFields.put("crr_agn_cd", "crrAgnCd");
		this.hashFields.put("ida_decl_vsl_no", "idaDeclVslNo");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("tmp0", "tmp0");
		this.hashFields.put("otr_dchg_cd", "otrDchgCd");
		this.hashFields.put("tmp2", "tmp2");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("tmp1", "tmp1");
		this.hashFields.put("tmp4", "tmp4");
		this.hashFields.put("tmp3", "tmp3");
		this.hashFields.put("tmp5", "tmp5");
		this.hashFields.put("wgt_ut_cd", "wgtUtCd");
		this.hashFields.put("pck_qty", "pckQty");
		this.hashFields.put("tp_fee", "tpFee");
		this.hashFields.put("ibd_no", "ibdNo");
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
	 * @return vslDeclDt
	 */
	public String getVslDeclDt() {
		return this.vslDeclDt;
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
	 * @return idaLineNo
	 */
	public String getIdaLineNo() {
		return this.idaLineNo;
	}
	
	/**
	 * Column Info
	 * @return idaTrspCd
	 */
	public String getIdaTrspCd() {
		return this.idaTrspCd;
	}
	
	/**
	 * Column Info
	 * @return crrAgnCd
	 */
	public String getCrrAgnCd() {
		return this.crrAgnCd;
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
	 * @return tmp0
	 */
	public String getTmp0() {
		return this.tmp0;
	}
	
	/**
	 * Column Info
	 * @return otrDchgCd
	 */
	public String getOtrDchgCd() {
		return this.otrDchgCd;
	}
	
	/**
	 * Column Info
	 * @return tmp2
	 */
	public String getTmp2() {
		return this.tmp2;
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
	 * @return tmp1
	 */
	public String getTmp1() {
		return this.tmp1;
	}
	
	/**
	 * Column Info
	 * @return tmp4
	 */
	public String getTmp4() {
		return this.tmp4;
	}
	
	/**
	 * Column Info
	 * @return tmp3
	 */
	public String getTmp3() {
		return this.tmp3;
	}
	
	/**
	 * Column Info
	 * @return tmp5
	 */
	public String getTmp5() {
		return this.tmp5;
	}
	
	/**
	 * Column Info
	 * @return wgtUtCd
	 */
	public String getWgtUtCd() {
		return this.wgtUtCd;
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
	 * @return tpFee
	 */
	public String getTpFee() {
		return this.tpFee;
	}
	
	/**
	 * Column Info
	 * @return ibdNo
	 */
	public String getIbdNo() {
		return this.ibdNo;
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
	 * @param vslDeclDt
	 */
	public void setVslDeclDt(String vslDeclDt) {
		this.vslDeclDt = vslDeclDt;
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
	 * @param idaLineNo
	 */
	public void setIdaLineNo(String idaLineNo) {
		this.idaLineNo = idaLineNo;
	}
	
	/**
	 * Column Info
	 * @param idaTrspCd
	 */
	public void setIdaTrspCd(String idaTrspCd) {
		this.idaTrspCd = idaTrspCd;
	}
	
	/**
	 * Column Info
	 * @param crrAgnCd
	 */
	public void setCrrAgnCd(String crrAgnCd) {
		this.crrAgnCd = crrAgnCd;
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
	 * @param tmp0
	 */
	public void setTmp0(String tmp0) {
		this.tmp0 = tmp0;
	}
	
	/**
	 * Column Info
	 * @param otrDchgCd
	 */
	public void setOtrDchgCd(String otrDchgCd) {
		this.otrDchgCd = otrDchgCd;
	}
	
	/**
	 * Column Info
	 * @param tmp2
	 */
	public void setTmp2(String tmp2) {
		this.tmp2 = tmp2;
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
	 * @param tmp1
	 */
	public void setTmp1(String tmp1) {
		this.tmp1 = tmp1;
	}
	
	/**
	 * Column Info
	 * @param tmp4
	 */
	public void setTmp4(String tmp4) {
		this.tmp4 = tmp4;
	}
	
	/**
	 * Column Info
	 * @param tmp3
	 */
	public void setTmp3(String tmp3) {
		this.tmp3 = tmp3;
	}
	
	/**
	 * Column Info
	 * @param tmp5
	 */
	public void setTmp5(String tmp5) {
		this.tmp5 = tmp5;
	}
	
	/**
	 * Column Info
	 * @param wgtUtCd
	 */
	public void setWgtUtCd(String wgtUtCd) {
		this.wgtUtCd = wgtUtCd;
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
	 * @param tpFee
	 */
	public void setTpFee(String tpFee) {
		this.tpFee = tpFee;
	}
	
	/**
	 * Column Info
	 * @param ibdNo
	 */
	public void setIbdNo(String ibdNo) {
		this.ibdNo = ibdNo;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setIdaAgnId(JSPUtil.getParameter(request, "ida_agn_id", ""));
		setVslDeclDt(JSPUtil.getParameter(request, "vsl_decl_dt", ""));
		setCntrWgt(JSPUtil.getParameter(request, "cntr_wgt", ""));
		setIdaLineNo(JSPUtil.getParameter(request, "ida_line_no", ""));
		setIdaTrspCd(JSPUtil.getParameter(request, "ida_trsp_cd", ""));
		setCrrAgnCd(JSPUtil.getParameter(request, "crr_agn_cd", ""));
		setIdaDeclVslNo(JSPUtil.getParameter(request, "ida_decl_vsl_no", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setTmp0(JSPUtil.getParameter(request, "tmp0", ""));
		setOtrDchgCd(JSPUtil.getParameter(request, "otr_dchg_cd", ""));
		setTmp2(JSPUtil.getParameter(request, "tmp2", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setTmp1(JSPUtil.getParameter(request, "tmp1", ""));
		setTmp4(JSPUtil.getParameter(request, "tmp4", ""));
		setTmp3(JSPUtil.getParameter(request, "tmp3", ""));
		setTmp5(JSPUtil.getParameter(request, "tmp5", ""));
		setWgtUtCd(JSPUtil.getParameter(request, "wgt_ut_cd", ""));
		setPckQty(JSPUtil.getParameter(request, "pck_qty", ""));
		setTpFee(JSPUtil.getParameter(request, "tp_fee", ""));
		setIbdNo(JSPUtil.getParameter(request, "ibd_no", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return IndiaCntrListDetailVO[]
	 */
	public IndiaCntrListDetailVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return IndiaCntrListDetailVO[]
	 */
	public IndiaCntrListDetailVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		IndiaCntrListDetailVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] idaAgnId = (JSPUtil.getParameter(request, prefix	+ "ida_agn_id", length));
			String[] vslDeclDt = (JSPUtil.getParameter(request, prefix	+ "vsl_decl_dt", length));
			String[] cntrWgt = (JSPUtil.getParameter(request, prefix	+ "cntr_wgt", length));
			String[] idaLineNo = (JSPUtil.getParameter(request, prefix	+ "ida_line_no", length));
			String[] idaTrspCd = (JSPUtil.getParameter(request, prefix	+ "ida_trsp_cd", length));
			String[] crrAgnCd = (JSPUtil.getParameter(request, prefix	+ "crr_agn_cd", length));
			String[] idaDeclVslNo = (JSPUtil.getParameter(request, prefix	+ "ida_decl_vsl_no", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] tmp0 = (JSPUtil.getParameter(request, prefix	+ "tmp0", length));
			String[] otrDchgCd = (JSPUtil.getParameter(request, prefix	+ "otr_dchg_cd", length));
			String[] tmp2 = (JSPUtil.getParameter(request, prefix	+ "tmp2", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] tmp1 = (JSPUtil.getParameter(request, prefix	+ "tmp1", length));
			String[] tmp4 = (JSPUtil.getParameter(request, prefix	+ "tmp4", length));
			String[] tmp3 = (JSPUtil.getParameter(request, prefix	+ "tmp3", length));
			String[] tmp5 = (JSPUtil.getParameter(request, prefix	+ "tmp5", length));
			String[] wgtUtCd = (JSPUtil.getParameter(request, prefix	+ "wgt_ut_cd", length));
			String[] pckQty = (JSPUtil.getParameter(request, prefix	+ "pck_qty", length));
			String[] tpFee = (JSPUtil.getParameter(request, prefix	+ "tp_fee", length));
			String[] ibdNo = (JSPUtil.getParameter(request, prefix	+ "ibd_no", length));
			
			for (int i = 0; i < length; i++) {
				model = new IndiaCntrListDetailVO();
				if (idaAgnId[i] != null)
					model.setIdaAgnId(idaAgnId[i]);
				if (vslDeclDt[i] != null)
					model.setVslDeclDt(vslDeclDt[i]);
				if (cntrWgt[i] != null)
					model.setCntrWgt(cntrWgt[i]);
				if (idaLineNo[i] != null)
					model.setIdaLineNo(idaLineNo[i]);
				if (idaTrspCd[i] != null)
					model.setIdaTrspCd(idaTrspCd[i]);
				if (crrAgnCd[i] != null)
					model.setCrrAgnCd(crrAgnCd[i]);
				if (idaDeclVslNo[i] != null)
					model.setIdaDeclVslNo(idaDeclVslNo[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (tmp0[i] != null)
					model.setTmp0(tmp0[i]);
				if (otrDchgCd[i] != null)
					model.setOtrDchgCd(otrDchgCd[i]);
				if (tmp2[i] != null)
					model.setTmp2(tmp2[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (tmp1[i] != null)
					model.setTmp1(tmp1[i]);
				if (tmp4[i] != null)
					model.setTmp4(tmp4[i]);
				if (tmp3[i] != null)
					model.setTmp3(tmp3[i]);
				if (tmp5[i] != null)
					model.setTmp5(tmp5[i]);
				if (wgtUtCd[i] != null)
					model.setWgtUtCd(wgtUtCd[i]);
				if (pckQty[i] != null)
					model.setPckQty(pckQty[i]);
				if (tpFee[i] != null)
					model.setTpFee(tpFee[i]);
				if (ibdNo[i] != null)
					model.setIbdNo(ibdNo[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getIndiaCntrListDetailVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return IndiaCntrListDetailVO[]
	 */
	public IndiaCntrListDetailVO[] getIndiaCntrListDetailVOs(){
		IndiaCntrListDetailVO[] vos = (IndiaCntrListDetailVO[])models.toArray(new IndiaCntrListDetailVO[models.size()]);
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
		this.vslDeclDt = this.vslDeclDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrWgt = this.cntrWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.idaLineNo = this.idaLineNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.idaTrspCd = this.idaTrspCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.crrAgnCd = this.crrAgnCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.idaDeclVslNo = this.idaDeclVslNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tmp0 = this.tmp0 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.otrDchgCd = this.otrDchgCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tmp2 = this.tmp2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tmp1 = this.tmp1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tmp4 = this.tmp4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tmp3 = this.tmp3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tmp5 = this.tmp5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wgtUtCd = this.wgtUtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pckQty = this.pckQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tpFee = this.tpFee .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibdNo = this.ibdNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
