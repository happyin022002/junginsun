/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CondSearchFleetStatusVO.java
*@FileTitle : CondSearchFleetStatusVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.04
*@LastModifier : 최우석
*@LastVersion : 1.0
* 2009.06.04 최우석 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.fms.timecharterinoutfleetmanagement.tcharterioinquiry.vo;

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
 * @author 최우석
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class CondSearchFleetStatusVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<CondSearchFleetStatusVO> models = new ArrayList<CondSearchFleetStatusVO>();
	
	/* Column Info */
	private String laneCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String gearWith = null;
	/* Column Info */
	private String ownrSeq = null;
	/* Column Info */
	private String schDt = null;
	/* Column Info */
	private String schDtTo = null;
	/* Column Info */
	private String periodFlag = null;
	/* Column Info */
	private String contractType = null;
	/* Column Info */
	private String vslSizeFlag = null;
	/* Column Info */
	private String vslSize1 = null;
	/* Column Info */
	private String vslSize2 = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public CondSearchFleetStatusVO() {}

	public CondSearchFleetStatusVO(String ibflag, String pagerows, String laneCd, String schDt, String gearWith, String ownrSeq, String periodFlag, String contractType, String vslSize1, String vslSizeFlag, String vslSize2, String schDtTo) {
		this.laneCd = laneCd;
		this.ibflag = ibflag;
		this.gearWith = gearWith;
		this.ownrSeq = ownrSeq;
		this.schDt = schDt;
		this.schDtTo = schDtTo;
		this.periodFlag = periodFlag;
		this.contractType = contractType;
		this.vslSizeFlag = vslSizeFlag;
		this.vslSize1 = vslSize1;
		this.vslSize2 = vslSize2;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("lane_cd", getLaneCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("gear_with", getGearWith());
		this.hashColumns.put("ownr_seq", getOwnrSeq());
		this.hashColumns.put("sch_dt", getSchDt());
		this.hashColumns.put("sch_dt_to", getSchDtTo());
		this.hashColumns.put("period_flag", getPeriodFlag());
		this.hashColumns.put("contract_type", getContractType());
		this.hashColumns.put("vsl_size_flag", getVslSizeFlag());
		this.hashColumns.put("vsl_size1", getVslSize1());
		this.hashColumns.put("vsl_size2", getVslSize2());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("lane_cd", "laneCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("gear_with", "gearWith");
		this.hashFields.put("ownr_seq", "ownrSeq");
		this.hashFields.put("sch_dt", "schDt");
		this.hashFields.put("sch_dt_to", "schDtTo");
		this.hashFields.put("period_flag", "periodFlag");
		this.hashFields.put("contract_type", "contractType");
		this.hashFields.put("vsl_size_flag", "vslSizeFlag");
		this.hashFields.put("vsl_size1", "vslSize1");
		this.hashFields.put("vsl_size2", "vslSize2");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return laneCd
	 */
	public String getLaneCd() {
		return this.laneCd;
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
	 * @return gearWith
	 */
	public String getGearWith() {
		return this.gearWith;
	}
	
	/**
	 * Column Info
	 * @return ownrSeq
	 */
	public String getOwnrSeq() {
		return this.ownrSeq;
	}
	
	/**
	 * Column Info
	 * @return schDt
	 */
	public String getSchDt() {
		return this.schDt;
	}
	
	/**
	 * Column Info
	 * @return schDtTo
	 */
	public String getSchDtTo() {
		return this.schDtTo;
	}
	
	/**
	 * Column Info
	 * @return periodFlag
	 */
	public String getPeriodFlag() {
		return this.periodFlag;
	}
	
	/**
	 * Column Info
	 * @return contractType
	 */
	public String getContractType() {
		return this.contractType;
	}
	
	/**
	 * Column Info
	 * @return vslSizeFlag
	 */
	public String getVslSizeFlag() {
		return this.vslSizeFlag;
	}
	
	/**
	 * Column Info
	 * @return vslSize1
	 */
	public String getVslSize1() {
		return this.vslSize1;
	}
	
	/**
	 * Column Info
	 * @return vslSize2
	 */
	public String getVslSize2() {
		return this.vslSize2;
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
	 * @param laneCd
	 */
	public void setLaneCd(String laneCd) {
		this.laneCd = laneCd;
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
	 * @param gearWith
	 */
	public void setGearWith(String gearWith) {
		this.gearWith = gearWith;
	}
	
	/**
	 * Column Info
	 * @param ownrSeq
	 */
	public void setOwnrSeq(String ownrSeq) {
		this.ownrSeq = ownrSeq;
	}
	
	/**
	 * Column Info
	 * @param schDt
	 */
	public void setSchDt(String schDt) {
		this.schDt = schDt;
	}
	
	/**
	 * Column Info
	 * @param schDtTo
	 */
	public void setSchDtTo(String schDtTo) {
		this.schDtTo = schDtTo;
	}
	
	/**
	 * Column Info
	 * @param periodFlag
	 */
	public void setPeriodFlag(String periodFlag) {
		this.periodFlag = periodFlag;
	}
	
	/**
	 * Column Info
	 * @param contractType
	 */
	public void setContractType(String contractType) {
		this.contractType = contractType;
	}
	
	/**
	 * Column Info
	 * @param vslSizeFlag
	 */
	public void setVslSizeFlag(String vslSizeFlag) {
		this.vslSizeFlag = vslSizeFlag;
	}
	
	/**
	 * Column Info
	 * @param vslSize1
	 */
	public void setVslSize1(String vslSize1) {
		this.vslSize1 = vslSize1;
	}
	
	/**
	 * Column Info
	 * @param vslSize2
	 */
	public void setVslSize2(String vslSize2) {
		this.vslSize2 = vslSize2;
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
		setLaneCd(JSPUtil.getParameter(request, "laneCd", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setGearWith(JSPUtil.getParameter(request, "gearWith", ""));
		setOwnrSeq(JSPUtil.getParameter(request, "ownrSeq", ""));
		setSchDt(JSPUtil.getParameter(request, "schDt", ""));
		setSchDtTo(JSPUtil.getParameter(request, "schDtTo", ""));
		setPeriodFlag(JSPUtil.getParameter(request, "periodFlag", ""));
		setContractType(JSPUtil.getParameter(request, "contractType", ""));
		setVslSizeFlag(JSPUtil.getParameter(request, "vslSizeFlag", ""));
		setVslSize1(JSPUtil.getParameter(request, "vslSize1", ""));
		setVslSize2(JSPUtil.getParameter(request, "vslSize2", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return CondSearchFleetStatusVO[]
	 */
	public CondSearchFleetStatusVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return CondSearchFleetStatusVO[]
	 */
	public CondSearchFleetStatusVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		CondSearchFleetStatusVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] laneCd = (JSPUtil.getParameter(request, prefix	+ "lane_cd".trim(), length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag".trim(), length));
			String[] gearWith = (JSPUtil.getParameter(request, prefix	+ "gear_with".trim(), length));
			String[] ownrSeq = (JSPUtil.getParameter(request, prefix	+ "ownr_seq".trim(), length));
			String[] schDt = (JSPUtil.getParameter(request, prefix	+ "sch_dt".trim(), length));
			String[] schDtTo = (JSPUtil.getParameter(request, prefix	+ "sch_dt_to".trim(), length));
			String[] periodFlag = (JSPUtil.getParameter(request, prefix	+ "period_flag".trim(), length));
			String[] contractType = (JSPUtil.getParameter(request, prefix	+ "contract_type".trim(), length));
			String[] vslSizeFlag = (JSPUtil.getParameter(request, prefix	+ "vsl_size_flag".trim(), length));
			String[] vslSize1 = (JSPUtil.getParameter(request, prefix	+ "vsl_size1".trim(), length));
			String[] vslSize2 = (JSPUtil.getParameter(request, prefix	+ "vsl_size2".trim(), length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows".trim(), length));
			
			for (int i = 0; i < length; i++) {
				model = new CondSearchFleetStatusVO();
				if (laneCd[i] != null)
					model.setLaneCd(laneCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (gearWith[i] != null)
					model.setGearWith(gearWith[i]);
				if (ownrSeq[i] != null)
					model.setOwnrSeq(ownrSeq[i]);
				if (schDt[i] != null)
					model.setSchDt(schDt[i]);
				if (schDtTo[i] != null)
					model.setSchDtTo(schDtTo[i]);
				if (periodFlag[i] != null)
					model.setPeriodFlag(periodFlag[i]);
				if (contractType[i] != null)
					model.setContractType(contractType[i]);
				if (vslSizeFlag[i] != null)
					model.setVslSizeFlag(vslSizeFlag[i]);
				if (vslSize1[i] != null)
					model.setVslSize1(vslSize1[i]);
				if (vslSize2[i] != null)
					model.setVslSize2(vslSize2[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getCondSearchFleetStatusVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return CondSearchFleetStatusVO[]
	 */
	public CondSearchFleetStatusVO[] getCondSearchFleetStatusVOs(){
		CondSearchFleetStatusVO[] vos = (CondSearchFleetStatusVO[])models.toArray(new CondSearchFleetStatusVO[models.size()]);
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
		this.laneCd = this.laneCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.gearWith = this.gearWith .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ownrSeq = this.ownrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.schDt = this.schDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.schDtTo = this.schDtTo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.periodFlag = this.periodFlag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.contractType = this.contractType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslSizeFlag = this.vslSizeFlag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslSize1 = this.vslSize1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslSize2 = this.vslSize2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
