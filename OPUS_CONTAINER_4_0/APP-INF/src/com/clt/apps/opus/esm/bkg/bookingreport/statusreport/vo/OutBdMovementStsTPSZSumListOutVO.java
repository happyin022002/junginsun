/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : OutBdMovementStsTPSZSumListOutVO.java
*@FileTitle : OutBdMovementStsTPSZSumListOutVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.03
*@LastModifier : 김기종
*@LastVersion : 1.0
* 2009.09.03 김기종 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.bookingreport.statusreport.vo;

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
 * @author 김기종
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class OutBdMovementStsTPSZSumListOutVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<OutBdMovementStsTPSZSumListOutVO> models = new ArrayList<OutBdMovementStsTPSZSumListOutVO>();
	
	/* Column Info */
	private String vl = null;
	/* Column Info */
	private String ot = null;
	/* Column Info */
	private String cntrTpszCdMv = null;
	/* Column Info */
	private String op = null;
	/* Column Info */
	private String mt = null;
	/* Column Info */
	private String cy = null;
	/* Column Info */
	private String etn = null;
	/* Column Info */
	private String ttl = null;
	/* Page Number */
	private String pagerows = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String oc = null;
	/* Column Info */
	private String bkgQty = null;
	/* Column Info */
	private String diffQty = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public OutBdMovementStsTPSZSumListOutVO() {}

	public OutBdMovementStsTPSZSumListOutVO(String ibflag, String pagerows, String cntrTpszCdMv, String bkgQty, String op, String oc, String etn, String cy, String vl, String mt, String ot, String ttl, String diffQty) {
		this.vl = vl;
		this.ot = ot;
		this.cntrTpszCdMv = cntrTpszCdMv;
		this.op = op;
		this.mt = mt;
		this.cy = cy;
		this.etn = etn;
		this.ttl = ttl;
		this.pagerows = pagerows;
		this.ibflag = ibflag;
		this.oc = oc;
		this.bkgQty = bkgQty;
		this.diffQty = diffQty;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("vl", getVl());
		this.hashColumns.put("ot", getOt());
		this.hashColumns.put("cntr_tpsz_cd_mv", getCntrTpszCdMv());
		this.hashColumns.put("op", getOp());
		this.hashColumns.put("mt", getMt());
		this.hashColumns.put("cy", getCy());
		this.hashColumns.put("etn", getEtn());
		this.hashColumns.put("ttl", getTtl());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("oc", getOc());
		this.hashColumns.put("bkg_qty", getBkgQty());
		this.hashColumns.put("diff_qty", getDiffQty());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("vl", "vl");
		this.hashFields.put("ot", "ot");
		this.hashFields.put("cntr_tpsz_cd_mv", "cntrTpszCdMv");
		this.hashFields.put("op", "op");
		this.hashFields.put("mt", "mt");
		this.hashFields.put("cy", "cy");
		this.hashFields.put("etn", "etn");
		this.hashFields.put("ttl", "ttl");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("oc", "oc");
		this.hashFields.put("bkg_qty", "bkgQty");
		this.hashFields.put("diff_qty", "diffQty");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return vl
	 */
	public String getVl() {
		return this.vl;
	}
	
	/**
	 * Column Info
	 * @return ot
	 */
	public String getOt() {
		return this.ot;
	}
	
	/**
	 * Column Info
	 * @return cntrTpszCdMv
	 */
	public String getCntrTpszCdMv() {
		return this.cntrTpszCdMv;
	}
	
	/**
	 * Column Info
	 * @return op
	 */
	public String getOp() {
		return this.op;
	}
	
	/**
	 * Column Info
	 * @return mt
	 */
	public String getMt() {
		return this.mt;
	}
	
	/**
	 * Column Info
	 * @return cy
	 */
	public String getCy() {
		return this.cy;
	}
	
	/**
	 * Column Info
	 * @return etn
	 */
	public String getEtn() {
		return this.etn;
	}
	
	/**
	 * Column Info
	 * @return ttl
	 */
	public String getTtl() {
		return this.ttl;
	}
	
	/**
	 * Page Number
	 * @return pagerows
	 */
	public String getPagerows() {
		return this.pagerows;
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
	 * @return oc
	 */
	public String getOc() {
		return this.oc;
	}
	
	/**
	 * Column Info
	 * @return bkgQty
	 */
	public String getBkgQty() {
		return this.bkgQty;
	}
	
	/**
	 * Column Info
	 * @return diffQty
	 */
	public String getDiffQty() {
		return this.diffQty;
	}
	

	/**
	 * Column Info
	 * @param vl
	 */
	public void setVl(String vl) {
		this.vl = vl;
	}
	
	/**
	 * Column Info
	 * @param ot
	 */
	public void setOt(String ot) {
		this.ot = ot;
	}
	
	/**
	 * Column Info
	 * @param cntrTpszCdMv
	 */
	public void setCntrTpszCdMv(String cntrTpszCdMv) {
		this.cntrTpszCdMv = cntrTpszCdMv;
	}
	
	/**
	 * Column Info
	 * @param op
	 */
	public void setOp(String op) {
		this.op = op;
	}
	
	/**
	 * Column Info
	 * @param mt
	 */
	public void setMt(String mt) {
		this.mt = mt;
	}
	
	/**
	 * Column Info
	 * @param cy
	 */
	public void setCy(String cy) {
		this.cy = cy;
	}
	
	/**
	 * Column Info
	 * @param etn
	 */
	public void setEtn(String etn) {
		this.etn = etn;
	}
	
	/**
	 * Column Info
	 * @param ttl
	 */
	public void setTtl(String ttl) {
		this.ttl = ttl;
	}
	
	/**
	 * Page Number
	 * @param pagerows
	 */
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
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
	 * @param oc
	 */
	public void setOc(String oc) {
		this.oc = oc;
	}
	
	/**
	 * Column Info
	 * @param bkgQty
	 */
	public void setBkgQty(String bkgQty) {
		this.bkgQty = bkgQty;
	}
	
	/**
	 * Column Info
	 * @param diffQty
	 */
	public void setDiffQty(String diffQty) {
		this.diffQty = diffQty;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setVl(JSPUtil.getParameter(request, "vl", ""));
		setOt(JSPUtil.getParameter(request, "ot", ""));
		setCntrTpszCdMv(JSPUtil.getParameter(request, "cntr_tpsz_cd_mv", ""));
		setOp(JSPUtil.getParameter(request, "op", ""));
		setMt(JSPUtil.getParameter(request, "mt", ""));
		setCy(JSPUtil.getParameter(request, "cy", ""));
		setEtn(JSPUtil.getParameter(request, "etn", ""));
		setTtl(JSPUtil.getParameter(request, "ttl", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setOc(JSPUtil.getParameter(request, "oc", ""));
		setBkgQty(JSPUtil.getParameter(request, "bkg_qty", ""));
		setDiffQty(JSPUtil.getParameter(request, "diff_qty", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return OutBdMovementStsTPSZSumListOutVO[]
	 */
	public OutBdMovementStsTPSZSumListOutVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return OutBdMovementStsTPSZSumListOutVO[]
	 */
	public OutBdMovementStsTPSZSumListOutVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		OutBdMovementStsTPSZSumListOutVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] vl = (JSPUtil.getParameter(request, prefix	+ "vl", length));
			String[] ot = (JSPUtil.getParameter(request, prefix	+ "ot", length));
			String[] cntrTpszCdMv = (JSPUtil.getParameter(request, prefix	+ "cntr_tpsz_cd_mv", length));
			String[] op = (JSPUtil.getParameter(request, prefix	+ "op", length));
			String[] mt = (JSPUtil.getParameter(request, prefix	+ "mt", length));
			String[] cy = (JSPUtil.getParameter(request, prefix	+ "cy", length));
			String[] etn = (JSPUtil.getParameter(request, prefix	+ "etn", length));
			String[] ttl = (JSPUtil.getParameter(request, prefix	+ "ttl", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] oc = (JSPUtil.getParameter(request, prefix	+ "oc", length));
			String[] bkgQty = (JSPUtil.getParameter(request, prefix	+ "bkg_qty", length));
			String[] diffQty = (JSPUtil.getParameter(request, prefix	+ "diff_qty", length));
			
			for (int i = 0; i < length; i++) {
				model = new OutBdMovementStsTPSZSumListOutVO();
				if (vl[i] != null)
					model.setVl(vl[i]);
				if (ot[i] != null)
					model.setOt(ot[i]);
				if (cntrTpszCdMv[i] != null)
					model.setCntrTpszCdMv(cntrTpszCdMv[i]);
				if (op[i] != null)
					model.setOp(op[i]);
				if (mt[i] != null)
					model.setMt(mt[i]);
				if (cy[i] != null)
					model.setCy(cy[i]);
				if (etn[i] != null)
					model.setEtn(etn[i]);
				if (ttl[i] != null)
					model.setTtl(ttl[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (oc[i] != null)
					model.setOc(oc[i]);
				if (bkgQty[i] != null)
					model.setBkgQty(bkgQty[i]);
				if (diffQty[i] != null)
					model.setDiffQty(diffQty[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getOutBdMovementStsTPSZSumListOutVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return OutBdMovementStsTPSZSumListOutVO[]
	 */
	public OutBdMovementStsTPSZSumListOutVO[] getOutBdMovementStsTPSZSumListOutVOs(){
		OutBdMovementStsTPSZSumListOutVO[] vos = (OutBdMovementStsTPSZSumListOutVO[])models.toArray(new OutBdMovementStsTPSZSumListOutVO[models.size()]);
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
		this.vl = this.vl .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ot = this.ot .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCdMv = this.cntrTpszCdMv .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.op = this.op .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mt = this.mt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cy = this.cy .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.etn = this.etn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ttl = this.ttl .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oc = this.oc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgQty = this.bkgQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.diffQty = this.diffQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
