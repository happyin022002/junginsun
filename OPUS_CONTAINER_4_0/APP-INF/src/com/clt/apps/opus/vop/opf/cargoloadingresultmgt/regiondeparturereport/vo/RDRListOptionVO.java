/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : RDRListOptionVO.java
*@FileTitle : RDRListOptionVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.19
*@LastModifier : 장강철
*@LastVersion : 1.0
* 2010.03.19 장강철 
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
 * @author 장강철
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class RDRListOptionVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<RDRListOptionVO> models = new ArrayList<RDRListOptionVO>();
	
	/* Column Info */
	private String qty11 = null;
	/* Column Info */
	private String region = null;
	/* Column Info */
	private String qty12 = null;
	/* Column Info */
	private String vslCd = null;
	/* Column Info */
	private String voyNo = null;
	/* Column Info */
	private String qty10 = null;
	/* Column Info */
	private String qty8 = null;
	/* Column Info */
	private String qty9 = null;
	/* Column Info */
	private String qty6 = null;
	/* Column Info */
	private String qty7 = null;
	/* Column Info */
	private String qty15 = null;
	/* Column Info */
	private String qty13 = null;
	/* Column Info */
	private String qty14 = null;
	/* Page Number */
	private String pagerows = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String oprCd = null;
	/* Column Info */
	private String optOprCd = null;
	/* Column Info */
	private String dirCd = null;
	/* Column Info */
	private String qty1 = null;
	/* Column Info */
	private String portCd = null;
	/* Column Info */
	private String qty3 = null;
	/* Column Info */
	private String qty2 = null;
	/* Column Info */
	private String qty5 = null;
	/* Column Info */
	private String qty4 = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public RDRListOptionVO() {}

	public RDRListOptionVO(String ibflag, String pagerows, String vslCd, String voyNo, String dirCd, String region, String oprCd, String optOprCd, String portCd, String qty1, String qty2, String qty3, String qty4, String qty5, String qty6, String qty7, String qty8, String qty9, String qty10, String qty11, String qty12, String qty13, String qty14, String qty15) {
		this.qty11 = qty11;
		this.region = region;
		this.qty12 = qty12;
		this.vslCd = vslCd;
		this.voyNo = voyNo;
		this.qty10 = qty10;
		this.qty8 = qty8;
		this.qty9 = qty9;
		this.qty6 = qty6;
		this.qty7 = qty7;
		this.qty15 = qty15;
		this.qty13 = qty13;
		this.qty14 = qty14;
		this.pagerows = pagerows;
		this.ibflag = ibflag;
		this.oprCd = oprCd;
		this.optOprCd = optOprCd;
		this.dirCd = dirCd;
		this.qty1 = qty1;
		this.portCd = portCd;
		this.qty3 = qty3;
		this.qty2 = qty2;
		this.qty5 = qty5;
		this.qty4 = qty4;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("qty11", getQty11());
		this.hashColumns.put("region", getRegion());
		this.hashColumns.put("qty12", getQty12());
		this.hashColumns.put("vsl_cd", getVslCd());
		this.hashColumns.put("voy_no", getVoyNo());
		this.hashColumns.put("qty10", getQty10());
		this.hashColumns.put("qty8", getQty8());
		this.hashColumns.put("qty9", getQty9());
		this.hashColumns.put("qty6", getQty6());
		this.hashColumns.put("qty7", getQty7());
		this.hashColumns.put("qty15", getQty15());
		this.hashColumns.put("qty13", getQty13());
		this.hashColumns.put("qty14", getQty14());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("opr_cd", getOprCd());
		this.hashColumns.put("opt_opr_cd", getOptOprCd());
		this.hashColumns.put("dir_cd", getDirCd());
		this.hashColumns.put("qty1", getQty1());
		this.hashColumns.put("port_cd", getPortCd());
		this.hashColumns.put("qty3", getQty3());
		this.hashColumns.put("qty2", getQty2());
		this.hashColumns.put("qty5", getQty5());
		this.hashColumns.put("qty4", getQty4());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("qty11", "qty11");
		this.hashFields.put("region", "region");
		this.hashFields.put("qty12", "qty12");
		this.hashFields.put("vsl_cd", "vslCd");
		this.hashFields.put("voy_no", "voyNo");
		this.hashFields.put("qty10", "qty10");
		this.hashFields.put("qty8", "qty8");
		this.hashFields.put("qty9", "qty9");
		this.hashFields.put("qty6", "qty6");
		this.hashFields.put("qty7", "qty7");
		this.hashFields.put("qty15", "qty15");
		this.hashFields.put("qty13", "qty13");
		this.hashFields.put("qty14", "qty14");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("opr_cd", "oprCd");
		this.hashFields.put("opt_opr_cd", "optOprCd");
		this.hashFields.put("dir_cd", "dirCd");
		this.hashFields.put("qty1", "qty1");
		this.hashFields.put("port_cd", "portCd");
		this.hashFields.put("qty3", "qty3");
		this.hashFields.put("qty2", "qty2");
		this.hashFields.put("qty5", "qty5");
		this.hashFields.put("qty4", "qty4");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return qty11
	 */
	public String getQty11() {
		return this.qty11;
	}
	
	/**
	 * Column Info
	 * @return region
	 */
	public String getRegion() {
		return this.region;
	}
	
	/**
	 * Column Info
	 * @return qty12
	 */
	public String getQty12() {
		return this.qty12;
	}
	
	/**
	 * Column Info
	 * @return vslCd
	 */
	public String getVslCd() {
		return this.vslCd;
	}
	
	/**
	 * Column Info
	 * @return voyNo
	 */
	public String getVoyNo() {
		return this.voyNo;
	}
	
	/**
	 * Column Info
	 * @return qty10
	 */
	public String getQty10() {
		return this.qty10;
	}
	
	/**
	 * Column Info
	 * @return qty8
	 */
	public String getQty8() {
		return this.qty8;
	}
	
	/**
	 * Column Info
	 * @return qty9
	 */
	public String getQty9() {
		return this.qty9;
	}
	
	/**
	 * Column Info
	 * @return qty6
	 */
	public String getQty6() {
		return this.qty6;
	}
	
	/**
	 * Column Info
	 * @return qty7
	 */
	public String getQty7() {
		return this.qty7;
	}
	
	/**
	 * Column Info
	 * @return qty15
	 */
	public String getQty15() {
		return this.qty15;
	}
	
	/**
	 * Column Info
	 * @return qty13
	 */
	public String getQty13() {
		return this.qty13;
	}
	
	/**
	 * Column Info
	 * @return qty14
	 */
	public String getQty14() {
		return this.qty14;
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
	 * @return oprCd
	 */
	public String getOprCd() {
		return this.oprCd;
	}
	
	/**
	 * Column Info
	 * @return optOprCd
	 */
	public String getOptOprCd() {
		return this.optOprCd;
	}
	
	/**
	 * Column Info
	 * @return dirCd
	 */
	public String getDirCd() {
		return this.dirCd;
	}
	
	/**
	 * Column Info
	 * @return qty1
	 */
	public String getQty1() {
		return this.qty1;
	}
	
	/**
	 * Column Info
	 * @return portCd
	 */
	public String getPortCd() {
		return this.portCd;
	}
	
	/**
	 * Column Info
	 * @return qty3
	 */
	public String getQty3() {
		return this.qty3;
	}
	
	/**
	 * Column Info
	 * @return qty2
	 */
	public String getQty2() {
		return this.qty2;
	}
	
	/**
	 * Column Info
	 * @return qty5
	 */
	public String getQty5() {
		return this.qty5;
	}
	
	/**
	 * Column Info
	 * @return qty4
	 */
	public String getQty4() {
		return this.qty4;
	}
	

	/**
	 * Column Info
	 * @param qty11
	 */
	public void setQty11(String qty11) {
		this.qty11 = qty11;
	}
	
	/**
	 * Column Info
	 * @param region
	 */
	public void setRegion(String region) {
		this.region = region;
	}
	
	/**
	 * Column Info
	 * @param qty12
	 */
	public void setQty12(String qty12) {
		this.qty12 = qty12;
	}
	
	/**
	 * Column Info
	 * @param vslCd
	 */
	public void setVslCd(String vslCd) {
		this.vslCd = vslCd;
	}
	
	/**
	 * Column Info
	 * @param voyNo
	 */
	public void setVoyNo(String voyNo) {
		this.voyNo = voyNo;
	}
	
	/**
	 * Column Info
	 * @param qty10
	 */
	public void setQty10(String qty10) {
		this.qty10 = qty10;
	}
	
	/**
	 * Column Info
	 * @param qty8
	 */
	public void setQty8(String qty8) {
		this.qty8 = qty8;
	}
	
	/**
	 * Column Info
	 * @param qty9
	 */
	public void setQty9(String qty9) {
		this.qty9 = qty9;
	}
	
	/**
	 * Column Info
	 * @param qty6
	 */
	public void setQty6(String qty6) {
		this.qty6 = qty6;
	}
	
	/**
	 * Column Info
	 * @param qty7
	 */
	public void setQty7(String qty7) {
		this.qty7 = qty7;
	}
	
	/**
	 * Column Info
	 * @param qty15
	 */
	public void setQty15(String qty15) {
		this.qty15 = qty15;
	}
	
	/**
	 * Column Info
	 * @param qty13
	 */
	public void setQty13(String qty13) {
		this.qty13 = qty13;
	}
	
	/**
	 * Column Info
	 * @param qty14
	 */
	public void setQty14(String qty14) {
		this.qty14 = qty14;
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
	 * @param oprCd
	 */
	public void setOprCd(String oprCd) {
		this.oprCd = oprCd;
	}
	
	/**
	 * Column Info
	 * @param optOprCd
	 */
	public void setOptOprCd(String optOprCd) {
		this.optOprCd = optOprCd;
	}
	
	/**
	 * Column Info
	 * @param dirCd
	 */
	public void setDirCd(String dirCd) {
		this.dirCd = dirCd;
	}
	
	/**
	 * Column Info
	 * @param qty1
	 */
	public void setQty1(String qty1) {
		this.qty1 = qty1;
	}
	
	/**
	 * Column Info
	 * @param portCd
	 */
	public void setPortCd(String portCd) {
		this.portCd = portCd;
	}
	
	/**
	 * Column Info
	 * @param qty3
	 */
	public void setQty3(String qty3) {
		this.qty3 = qty3;
	}
	
	/**
	 * Column Info
	 * @param qty2
	 */
	public void setQty2(String qty2) {
		this.qty2 = qty2;
	}
	
	/**
	 * Column Info
	 * @param qty5
	 */
	public void setQty5(String qty5) {
		this.qty5 = qty5;
	}
	
	/**
	 * Column Info
	 * @param qty4
	 */
	public void setQty4(String qty4) {
		this.qty4 = qty4;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setQty11(JSPUtil.getParameter(request, "qty11", ""));
		setRegion(JSPUtil.getParameter(request, "region", ""));
		setQty12(JSPUtil.getParameter(request, "qty12", ""));
		setVslCd(JSPUtil.getParameter(request, "vsl_cd", ""));
		setVoyNo(JSPUtil.getParameter(request, "voy_no", ""));
		setQty10(JSPUtil.getParameter(request, "qty10", ""));
		setQty8(JSPUtil.getParameter(request, "qty8", ""));
		setQty9(JSPUtil.getParameter(request, "qty9", ""));
		setQty6(JSPUtil.getParameter(request, "qty6", ""));
		setQty7(JSPUtil.getParameter(request, "qty7", ""));
		setQty15(JSPUtil.getParameter(request, "qty15", ""));
		setQty13(JSPUtil.getParameter(request, "qty13", ""));
		setQty14(JSPUtil.getParameter(request, "qty14", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setOprCd(JSPUtil.getParameter(request, "opr_cd", ""));
		setOptOprCd(JSPUtil.getParameter(request, "opt_opr_cd", ""));
		setDirCd(JSPUtil.getParameter(request, "dir_cd", ""));
		setQty1(JSPUtil.getParameter(request, "qty1", ""));
		setPortCd(JSPUtil.getParameter(request, "port_cd", ""));
		setQty3(JSPUtil.getParameter(request, "qty3", ""));
		setQty2(JSPUtil.getParameter(request, "qty2", ""));
		setQty5(JSPUtil.getParameter(request, "qty5", ""));
		setQty4(JSPUtil.getParameter(request, "qty4", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return RDRListOptionVO[]
	 */
	public RDRListOptionVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return RDRListOptionVO[]
	 */
	public RDRListOptionVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		RDRListOptionVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] qty11 = (JSPUtil.getParameter(request, prefix	+ "qty11", length));
			String[] region = (JSPUtil.getParameter(request, prefix	+ "region", length));
			String[] qty12 = (JSPUtil.getParameter(request, prefix	+ "qty12", length));
			String[] vslCd = (JSPUtil.getParameter(request, prefix	+ "vsl_cd", length));
			String[] voyNo = (JSPUtil.getParameter(request, prefix	+ "voy_no", length));
			String[] qty10 = (JSPUtil.getParameter(request, prefix	+ "qty10", length));
			String[] qty8 = (JSPUtil.getParameter(request, prefix	+ "qty8", length));
			String[] qty9 = (JSPUtil.getParameter(request, prefix	+ "qty9", length));
			String[] qty6 = (JSPUtil.getParameter(request, prefix	+ "qty6", length));
			String[] qty7 = (JSPUtil.getParameter(request, prefix	+ "qty7", length));
			String[] qty15 = (JSPUtil.getParameter(request, prefix	+ "qty15", length));
			String[] qty13 = (JSPUtil.getParameter(request, prefix	+ "qty13", length));
			String[] qty14 = (JSPUtil.getParameter(request, prefix	+ "qty14", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] oprCd = (JSPUtil.getParameter(request, prefix	+ "opr_cd", length));
			String[] optOprCd = (JSPUtil.getParameter(request, prefix	+ "opt_opr_cd", length));
			String[] dirCd = (JSPUtil.getParameter(request, prefix	+ "dir_cd", length));
			String[] qty1 = (JSPUtil.getParameter(request, prefix	+ "qty1", length));
			String[] portCd = (JSPUtil.getParameter(request, prefix	+ "port_cd", length));
			String[] qty3 = (JSPUtil.getParameter(request, prefix	+ "qty3", length));
			String[] qty2 = (JSPUtil.getParameter(request, prefix	+ "qty2", length));
			String[] qty5 = (JSPUtil.getParameter(request, prefix	+ "qty5", length));
			String[] qty4 = (JSPUtil.getParameter(request, prefix	+ "qty4", length));
			
			for (int i = 0; i < length; i++) {
				model = new RDRListOptionVO();
				if (qty11[i] != null)
					model.setQty11(qty11[i]);
				if (region[i] != null)
					model.setRegion(region[i]);
				if (qty12[i] != null)
					model.setQty12(qty12[i]);
				if (vslCd[i] != null)
					model.setVslCd(vslCd[i]);
				if (voyNo[i] != null)
					model.setVoyNo(voyNo[i]);
				if (qty10[i] != null)
					model.setQty10(qty10[i]);
				if (qty8[i] != null)
					model.setQty8(qty8[i]);
				if (qty9[i] != null)
					model.setQty9(qty9[i]);
				if (qty6[i] != null)
					model.setQty6(qty6[i]);
				if (qty7[i] != null)
					model.setQty7(qty7[i]);
				if (qty15[i] != null)
					model.setQty15(qty15[i]);
				if (qty13[i] != null)
					model.setQty13(qty13[i]);
				if (qty14[i] != null)
					model.setQty14(qty14[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (oprCd[i] != null)
					model.setOprCd(oprCd[i]);
				if (optOprCd[i] != null)
					model.setOptOprCd(optOprCd[i]);
				if (dirCd[i] != null)
					model.setDirCd(dirCd[i]);
				if (qty1[i] != null)
					model.setQty1(qty1[i]);
				if (portCd[i] != null)
					model.setPortCd(portCd[i]);
				if (qty3[i] != null)
					model.setQty3(qty3[i]);
				if (qty2[i] != null)
					model.setQty2(qty2[i]);
				if (qty5[i] != null)
					model.setQty5(qty5[i]);
				if (qty4[i] != null)
					model.setQty4(qty4[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getRDRListOptionVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return RDRListOptionVO[]
	 */
	public RDRListOptionVO[] getRDRListOptionVOs(){
		RDRListOptionVO[] vos = (RDRListOptionVO[])models.toArray(new RDRListOptionVO[models.size()]);
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
		this.qty11 = this.qty11 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.region = this.region .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.qty12 = this.qty12 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslCd = this.vslCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.voyNo = this.voyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.qty10 = this.qty10 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.qty8 = this.qty8 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.qty9 = this.qty9 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.qty6 = this.qty6 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.qty7 = this.qty7 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.qty15 = this.qty15 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.qty13 = this.qty13 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.qty14 = this.qty14 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oprCd = this.oprCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.optOprCd = this.optOprCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dirCd = this.dirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.qty1 = this.qty1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.portCd = this.portCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.qty3 = this.qty3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.qty2 = this.qty2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.qty5 = this.qty5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.qty4 = this.qty4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
