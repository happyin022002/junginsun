/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : RDRLoadVO.java
*@FileTitle : RDRLoadVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.07
*@LastModifier : 김종옥
*@LastVersion : 1.0
* 2009.10.07 김종옥 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.vop.opf.cargoloadingresultmgt.regiondeparturereport.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 김종옥
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class RDRLoadVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<RDRLoadVO> models = new ArrayList<RDRLoadVO>();
	
	/* Column Info */
	private String polQty09 = null;
	/* Column Info */
	private String polQty15 = null;
	/* Column Info */
	private String polQty08 = null;
	/* Column Info */
	private String polQty14 = null;
	/* Column Info */
	private String polQty07 = null;
	/* Column Info */
	private String polQty13 = null;
	/* Column Info */
	private String polQty12 = null;
	/* Column Info */
	private String polQty11 = null;
	/* Column Info */
	private String polQty10 = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String cntrType = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String cntrSize = null;
	/* Column Info */
	private String oprCd = null;
	/* Column Info */
	private String totalVol = null;
	/* Column Info */
	private String polQty01 = null;
	/* Column Info */
	private String polQty02 = null;
	/* Column Info */
	private String totalWgt = null;
	/* Column Info */
	private String polQty05 = null;
	/* Column Info */
	private String polQty06 = null;
	/* Column Info */
	private String polQty03 = null;
	/* Column Info */
	private String pod = null;
	/* Column Info */
	private String polQty04 = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public RDRLoadVO() {}

	public RDRLoadVO(String ibflag, String pagerows, String oprCd, String totalWgt, String totalVol, String pod, String cntrSize, String cntrType, String polQty01, String polQty02, String polQty03, String polQty04, String polQty05, String polQty06, String polQty07, String polQty08, String polQty09, String polQty10, String polQty11, String polQty12, String polQty13, String polQty14, String polQty15) {
		this.polQty09 = polQty09;
		this.polQty15 = polQty15;
		this.polQty08 = polQty08;
		this.polQty14 = polQty14;
		this.polQty07 = polQty07;
		this.polQty13 = polQty13;
		this.polQty12 = polQty12;
		this.polQty11 = polQty11;
		this.polQty10 = polQty10;
		this.pagerows = pagerows;
		this.cntrType = cntrType;
		this.ibflag = ibflag;
		this.cntrSize = cntrSize;
		this.oprCd = oprCd;
		this.totalVol = totalVol;
		this.polQty01 = polQty01;
		this.polQty02 = polQty02;
		this.totalWgt = totalWgt;
		this.polQty05 = polQty05;
		this.polQty06 = polQty06;
		this.polQty03 = polQty03;
		this.pod = pod;
		this.polQty04 = polQty04;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("pol_qty_09", getPolQty09());
		this.hashColumns.put("pol_qty_15", getPolQty15());
		this.hashColumns.put("pol_qty_08", getPolQty08());
		this.hashColumns.put("pol_qty_14", getPolQty14());
		this.hashColumns.put("pol_qty_07", getPolQty07());
		this.hashColumns.put("pol_qty_13", getPolQty13());
		this.hashColumns.put("pol_qty_12", getPolQty12());
		this.hashColumns.put("pol_qty_11", getPolQty11());
		this.hashColumns.put("pol_qty_10", getPolQty10());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("cntr_type", getCntrType());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cntr_size", getCntrSize());
		this.hashColumns.put("opr_cd", getOprCd());
		this.hashColumns.put("total_vol", getTotalVol());
		this.hashColumns.put("pol_qty_01", getPolQty01());
		this.hashColumns.put("pol_qty_02", getPolQty02());
		this.hashColumns.put("total_wgt", getTotalWgt());
		this.hashColumns.put("pol_qty_05", getPolQty05());
		this.hashColumns.put("pol_qty_06", getPolQty06());
		this.hashColumns.put("pol_qty_03", getPolQty03());
		this.hashColumns.put("pod", getPod());
		this.hashColumns.put("pol_qty_04", getPolQty04());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("pol_qty_09", "polQty09");
		this.hashFields.put("pol_qty_15", "polQty15");
		this.hashFields.put("pol_qty_08", "polQty08");
		this.hashFields.put("pol_qty_14", "polQty14");
		this.hashFields.put("pol_qty_07", "polQty07");
		this.hashFields.put("pol_qty_13", "polQty13");
		this.hashFields.put("pol_qty_12", "polQty12");
		this.hashFields.put("pol_qty_11", "polQty11");
		this.hashFields.put("pol_qty_10", "polQty10");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("cntr_type", "cntrType");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cntr_size", "cntrSize");
		this.hashFields.put("opr_cd", "oprCd");
		this.hashFields.put("total_vol", "totalVol");
		this.hashFields.put("pol_qty_01", "polQty01");
		this.hashFields.put("pol_qty_02", "polQty02");
		this.hashFields.put("total_wgt", "totalWgt");
		this.hashFields.put("pol_qty_05", "polQty05");
		this.hashFields.put("pol_qty_06", "polQty06");
		this.hashFields.put("pol_qty_03", "polQty03");
		this.hashFields.put("pod", "pod");
		this.hashFields.put("pol_qty_04", "polQty04");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return polQty09
	 */
	public String getPolQty09() {
		return this.polQty09;
	}
	
	/**
	 * Column Info
	 * @return polQty15
	 */
	public String getPolQty15() {
		return this.polQty15;
	}
	
	/**
	 * Column Info
	 * @return polQty08
	 */
	public String getPolQty08() {
		return this.polQty08;
	}
	
	/**
	 * Column Info
	 * @return polQty14
	 */
	public String getPolQty14() {
		return this.polQty14;
	}
	
	/**
	 * Column Info
	 * @return polQty07
	 */
	public String getPolQty07() {
		return this.polQty07;
	}
	
	/**
	 * Column Info
	 * @return polQty13
	 */
	public String getPolQty13() {
		return this.polQty13;
	}
	
	/**
	 * Column Info
	 * @return polQty12
	 */
	public String getPolQty12() {
		return this.polQty12;
	}
	
	/**
	 * Column Info
	 * @return polQty11
	 */
	public String getPolQty11() {
		return this.polQty11;
	}
	
	/**
	 * Column Info
	 * @return polQty10
	 */
	public String getPolQty10() {
		return this.polQty10;
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
	 * @return cntrType
	 */
	public String getCntrType() {
		return this.cntrType;
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
	 * @return cntrSize
	 */
	public String getCntrSize() {
		return this.cntrSize;
	}
	
	/**
	 * Column Info
	 * @return oprCd
	 */
	public String getOprCd() {
		return this.oprCd;
	}
	
	/**
	 * Column Info
	 * @return totalVol
	 */
	public String getTotalVol() {
		return this.totalVol;
	}
	
	/**
	 * Column Info
	 * @return polQty01
	 */
	public String getPolQty01() {
		return this.polQty01;
	}
	
	/**
	 * Column Info
	 * @return polQty02
	 */
	public String getPolQty02() {
		return this.polQty02;
	}
	
	/**
	 * Column Info
	 * @return totalWgt
	 */
	public String getTotalWgt() {
		return this.totalWgt;
	}
	
	/**
	 * Column Info
	 * @return polQty05
	 */
	public String getPolQty05() {
		return this.polQty05;
	}
	
	/**
	 * Column Info
	 * @return polQty06
	 */
	public String getPolQty06() {
		return this.polQty06;
	}
	
	/**
	 * Column Info
	 * @return polQty03
	 */
	public String getPolQty03() {
		return this.polQty03;
	}
	
	/**
	 * Column Info
	 * @return pod
	 */
	public String getPod() {
		return this.pod;
	}
	
	/**
	 * Column Info
	 * @return polQty04
	 */
	public String getPolQty04() {
		return this.polQty04;
	}
	

	/**
	 * Column Info
	 * @param polQty09
	 */
	public void setPolQty09(String polQty09) {
		this.polQty09 = polQty09;
	}
	
	/**
	 * Column Info
	 * @param polQty15
	 */
	public void setPolQty15(String polQty15) {
		this.polQty15 = polQty15;
	}
	
	/**
	 * Column Info
	 * @param polQty08
	 */
	public void setPolQty08(String polQty08) {
		this.polQty08 = polQty08;
	}
	
	/**
	 * Column Info
	 * @param polQty14
	 */
	public void setPolQty14(String polQty14) {
		this.polQty14 = polQty14;
	}
	
	/**
	 * Column Info
	 * @param polQty07
	 */
	public void setPolQty07(String polQty07) {
		this.polQty07 = polQty07;
	}
	
	/**
	 * Column Info
	 * @param polQty13
	 */
	public void setPolQty13(String polQty13) {
		this.polQty13 = polQty13;
	}
	
	/**
	 * Column Info
	 * @param polQty12
	 */
	public void setPolQty12(String polQty12) {
		this.polQty12 = polQty12;
	}
	
	/**
	 * Column Info
	 * @param polQty11
	 */
	public void setPolQty11(String polQty11) {
		this.polQty11 = polQty11;
	}
	
	/**
	 * Column Info
	 * @param polQty10
	 */
	public void setPolQty10(String polQty10) {
		this.polQty10 = polQty10;
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
	 * @param cntrType
	 */
	public void setCntrType(String cntrType) {
		this.cntrType = cntrType;
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
	 * @param cntrSize
	 */
	public void setCntrSize(String cntrSize) {
		this.cntrSize = cntrSize;
	}
	
	/**
	 * Column Info
	 * @param oprCd
	 */
	public void setOprCd(String oprCd) {
		this.oprCd = oprCd;
	}
	
	/**
	 * Column Info
	 * @param totalVol
	 */
	public void setTotalVol(String totalVol) {
		this.totalVol = totalVol;
	}
	
	/**
	 * Column Info
	 * @param polQty01
	 */
	public void setPolQty01(String polQty01) {
		this.polQty01 = polQty01;
	}
	
	/**
	 * Column Info
	 * @param polQty02
	 */
	public void setPolQty02(String polQty02) {
		this.polQty02 = polQty02;
	}
	
	/**
	 * Column Info
	 * @param totalWgt
	 */
	public void setTotalWgt(String totalWgt) {
		this.totalWgt = totalWgt;
	}
	
	/**
	 * Column Info
	 * @param polQty05
	 */
	public void setPolQty05(String polQty05) {
		this.polQty05 = polQty05;
	}
	
	/**
	 * Column Info
	 * @param polQty06
	 */
	public void setPolQty06(String polQty06) {
		this.polQty06 = polQty06;
	}
	
	/**
	 * Column Info
	 * @param polQty03
	 */
	public void setPolQty03(String polQty03) {
		this.polQty03 = polQty03;
	}
	
	/**
	 * Column Info
	 * @param pod
	 */
	public void setPod(String pod) {
		this.pod = pod;
	}
	
	/**
	 * Column Info
	 * @param polQty04
	 */
	public void setPolQty04(String polQty04) {
		this.polQty04 = polQty04;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setPolQty09(JSPUtil.getParameter(request, "pol_qty_09", ""));
		setPolQty15(JSPUtil.getParameter(request, "pol_qty_15", ""));
		setPolQty08(JSPUtil.getParameter(request, "pol_qty_08", ""));
		setPolQty14(JSPUtil.getParameter(request, "pol_qty_14", ""));
		setPolQty07(JSPUtil.getParameter(request, "pol_qty_07", ""));
		setPolQty13(JSPUtil.getParameter(request, "pol_qty_13", ""));
		setPolQty12(JSPUtil.getParameter(request, "pol_qty_12", ""));
		setPolQty11(JSPUtil.getParameter(request, "pol_qty_11", ""));
		setPolQty10(JSPUtil.getParameter(request, "pol_qty_10", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setCntrType(JSPUtil.getParameter(request, "cntr_type", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setCntrSize(JSPUtil.getParameter(request, "cntr_size", ""));
		setOprCd(JSPUtil.getParameter(request, "opr_cd", ""));
		setTotalVol(JSPUtil.getParameter(request, "total_vol", ""));
		setPolQty01(JSPUtil.getParameter(request, "pol_qty_01", ""));
		setPolQty02(JSPUtil.getParameter(request, "pol_qty_02", ""));
		setTotalWgt(JSPUtil.getParameter(request, "total_wgt", ""));
		setPolQty05(JSPUtil.getParameter(request, "pol_qty_05", ""));
		setPolQty06(JSPUtil.getParameter(request, "pol_qty_06", ""));
		setPolQty03(JSPUtil.getParameter(request, "pol_qty_03", ""));
		setPod(JSPUtil.getParameter(request, "pod", ""));
		setPolQty04(JSPUtil.getParameter(request, "pol_qty_04", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return RDRLoadVO[]
	 */
	public RDRLoadVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return RDRLoadVO[]
	 */
	public RDRLoadVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		RDRLoadVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] polQty09 = (JSPUtil.getParameter(request, prefix	+ "pol_qty_09", length));
			String[] polQty15 = (JSPUtil.getParameter(request, prefix	+ "pol_qty_15", length));
			String[] polQty08 = (JSPUtil.getParameter(request, prefix	+ "pol_qty_08", length));
			String[] polQty14 = (JSPUtil.getParameter(request, prefix	+ "pol_qty_14", length));
			String[] polQty07 = (JSPUtil.getParameter(request, prefix	+ "pol_qty_07", length));
			String[] polQty13 = (JSPUtil.getParameter(request, prefix	+ "pol_qty_13", length));
			String[] polQty12 = (JSPUtil.getParameter(request, prefix	+ "pol_qty_12", length));
			String[] polQty11 = (JSPUtil.getParameter(request, prefix	+ "pol_qty_11", length));
			String[] polQty10 = (JSPUtil.getParameter(request, prefix	+ "pol_qty_10", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] cntrType = (JSPUtil.getParameter(request, prefix	+ "cntr_type", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] cntrSize = (JSPUtil.getParameter(request, prefix	+ "cntr_size", length));
			String[] oprCd = (JSPUtil.getParameter(request, prefix	+ "opr_cd", length));
			String[] totalVol = (JSPUtil.getParameter(request, prefix	+ "total_vol", length));
			String[] polQty01 = (JSPUtil.getParameter(request, prefix	+ "pol_qty_01", length));
			String[] polQty02 = (JSPUtil.getParameter(request, prefix	+ "pol_qty_02", length));
			String[] totalWgt = (JSPUtil.getParameter(request, prefix	+ "total_wgt", length));
			String[] polQty05 = (JSPUtil.getParameter(request, prefix	+ "pol_qty_05", length));
			String[] polQty06 = (JSPUtil.getParameter(request, prefix	+ "pol_qty_06", length));
			String[] polQty03 = (JSPUtil.getParameter(request, prefix	+ "pol_qty_03", length));
			String[] pod = (JSPUtil.getParameter(request, prefix	+ "pod", length));
			String[] polQty04 = (JSPUtil.getParameter(request, prefix	+ "pol_qty_04", length));
			
			for (int i = 0; i < length; i++) {
				model = new RDRLoadVO();
				if (polQty09[i] != null)
					model.setPolQty09(polQty09[i]);
				if (polQty15[i] != null)
					model.setPolQty15(polQty15[i]);
				if (polQty08[i] != null)
					model.setPolQty08(polQty08[i]);
				if (polQty14[i] != null)
					model.setPolQty14(polQty14[i]);
				if (polQty07[i] != null)
					model.setPolQty07(polQty07[i]);
				if (polQty13[i] != null)
					model.setPolQty13(polQty13[i]);
				if (polQty12[i] != null)
					model.setPolQty12(polQty12[i]);
				if (polQty11[i] != null)
					model.setPolQty11(polQty11[i]);
				if (polQty10[i] != null)
					model.setPolQty10(polQty10[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (cntrType[i] != null)
					model.setCntrType(cntrType[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (cntrSize[i] != null)
					model.setCntrSize(cntrSize[i]);
				if (oprCd[i] != null)
					model.setOprCd(oprCd[i]);
				if (totalVol[i] != null)
					model.setTotalVol(totalVol[i]);
				if (polQty01[i] != null)
					model.setPolQty01(polQty01[i]);
				if (polQty02[i] != null)
					model.setPolQty02(polQty02[i]);
				if (totalWgt[i] != null)
					model.setTotalWgt(totalWgt[i]);
				if (polQty05[i] != null)
					model.setPolQty05(polQty05[i]);
				if (polQty06[i] != null)
					model.setPolQty06(polQty06[i]);
				if (polQty03[i] != null)
					model.setPolQty03(polQty03[i]);
				if (pod[i] != null)
					model.setPod(pod[i]);
				if (polQty04[i] != null)
					model.setPolQty04(polQty04[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getRDRLoadVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return RDRLoadVO[]
	 */
	public RDRLoadVO[] getRDRLoadVOs(){
		RDRLoadVO[] vos = (RDRLoadVO[])models.toArray(new RDRLoadVO[models.size()]);
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
		this.polQty09 = this.polQty09 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polQty15 = this.polQty15 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polQty08 = this.polQty08 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polQty14 = this.polQty14 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polQty07 = this.polQty07 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polQty13 = this.polQty13 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polQty12 = this.polQty12 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polQty11 = this.polQty11 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polQty10 = this.polQty10 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrType = this.cntrType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrSize = this.cntrSize .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oprCd = this.oprCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totalVol = this.totalVol .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polQty01 = this.polQty01 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polQty02 = this.polQty02 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totalWgt = this.totalWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polQty05 = this.polQty05 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polQty06 = this.polQty06 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polQty03 = this.polQty03 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pod = this.pod .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polQty04 = this.polQty04 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
