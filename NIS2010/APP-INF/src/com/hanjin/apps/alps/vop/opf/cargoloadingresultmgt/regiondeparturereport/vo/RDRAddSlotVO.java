/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : RDRAddSlotVO.java
*@FileTitle : RDRAddSlotVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.06
*@LastModifier : 김종옥
*@LastVersion : 1.0
* 2009.10.06 김종옥 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.vop.opf.cargoloadingresultmgt.regiondeparturereport.vo;

import java.lang.reflect.Field;
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
 * @author 김종옥
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class RDRAddSlotVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<RDRAddSlotVO> models = new ArrayList<RDRAddSlotVO>();
	
	/* Column Info */
	private String total = null;
	/* Column Info */
	private String oprQty13 = null;
	/* Column Info */
	private String oprQty12 = null;
	/* Column Info */
	private String oprQty11 = null;
	/* Column Info */
	private String oprQty02 = null;
	/* Column Info */
	private String oprQty10 = null;
	/* Column Info */
	private String oprQty01 = null;
	/* Column Info */
	private String oprQty04 = null;
	/* Column Info */
	private String oprQty03 = null;
	/* Column Info */
	private String oprQty15 = null;
	/* Column Info */
	private String oprQty06 = null;
	/* Column Info */
	private String oprQty14 = null;
	/* Column Info */
	private String oprQty05 = null;
	/* Column Info */
	private String oprQty08 = null;
	/* Column Info */
	private String oprQty07 = null;
	/* Column Info */
	private String oprQty09 = null;
	/* Page Number */
	private String pagerows = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String pol = null;
	/* Column Info */
	private String pod = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public RDRAddSlotVO() {}

	public RDRAddSlotVO(String ibflag, String pagerows, String total, String pol, String pod, String oprQty01, String oprQty02, String oprQty03, String oprQty04, String oprQty05, String oprQty06, String oprQty07, String oprQty08, String oprQty09, String oprQty10, String oprQty11, String oprQty12, String oprQty13, String oprQty14, String oprQty15) {
		this.total = total;
		this.oprQty13 = oprQty13;
		this.oprQty12 = oprQty12;
		this.oprQty11 = oprQty11;
		this.oprQty02 = oprQty02;
		this.oprQty10 = oprQty10;
		this.oprQty01 = oprQty01;
		this.oprQty04 = oprQty04;
		this.oprQty03 = oprQty03;
		this.oprQty15 = oprQty15;
		this.oprQty06 = oprQty06;
		this.oprQty14 = oprQty14;
		this.oprQty05 = oprQty05;
		this.oprQty08 = oprQty08;
		this.oprQty07 = oprQty07;
		this.oprQty09 = oprQty09;
		this.pagerows = pagerows;
		this.ibflag = ibflag;
		this.pol = pol;
		this.pod = pod;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("total", getTotal());
		this.hashColumns.put("opr_qty_13", getOprQty13());
		this.hashColumns.put("opr_qty_12", getOprQty12());
		this.hashColumns.put("opr_qty_11", getOprQty11());
		this.hashColumns.put("opr_qty_02", getOprQty02());
		this.hashColumns.put("opr_qty_10", getOprQty10());
		this.hashColumns.put("opr_qty_01", getOprQty01());
		this.hashColumns.put("opr_qty_04", getOprQty04());
		this.hashColumns.put("opr_qty_03", getOprQty03());
		this.hashColumns.put("opr_qty_15", getOprQty15());
		this.hashColumns.put("opr_qty_06", getOprQty06());
		this.hashColumns.put("opr_qty_14", getOprQty14());
		this.hashColumns.put("opr_qty_05", getOprQty05());
		this.hashColumns.put("opr_qty_08", getOprQty08());
		this.hashColumns.put("opr_qty_07", getOprQty07());
		this.hashColumns.put("opr_qty_09", getOprQty09());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("pol", getPol());
		this.hashColumns.put("pod", getPod());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("total", "total");
		this.hashFields.put("opr_qty_13", "oprQty13");
		this.hashFields.put("opr_qty_12", "oprQty12");
		this.hashFields.put("opr_qty_11", "oprQty11");
		this.hashFields.put("opr_qty_02", "oprQty02");
		this.hashFields.put("opr_qty_10", "oprQty10");
		this.hashFields.put("opr_qty_01", "oprQty01");
		this.hashFields.put("opr_qty_04", "oprQty04");
		this.hashFields.put("opr_qty_03", "oprQty03");
		this.hashFields.put("opr_qty_15", "oprQty15");
		this.hashFields.put("opr_qty_06", "oprQty06");
		this.hashFields.put("opr_qty_14", "oprQty14");
		this.hashFields.put("opr_qty_05", "oprQty05");
		this.hashFields.put("opr_qty_08", "oprQty08");
		this.hashFields.put("opr_qty_07", "oprQty07");
		this.hashFields.put("opr_qty_09", "oprQty09");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("pol", "pol");
		this.hashFields.put("pod", "pod");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return total
	 */
	public String getTotal() {
		return this.total;
	}
	
	/**
	 * Column Info
	 * @return oprQty13
	 */
	public String getOprQty13() {
		return this.oprQty13;
	}
	
	/**
	 * Column Info
	 * @return oprQty12
	 */
	public String getOprQty12() {
		return this.oprQty12;
	}
	
	/**
	 * Column Info
	 * @return oprQty11
	 */
	public String getOprQty11() {
		return this.oprQty11;
	}
	
	/**
	 * Column Info
	 * @return oprQty02
	 */
	public String getOprQty02() {
		return this.oprQty02;
	}
	
	/**
	 * Column Info
	 * @return oprQty10
	 */
	public String getOprQty10() {
		return this.oprQty10;
	}
	
	/**
	 * Column Info
	 * @return oprQty01
	 */
	public String getOprQty01() {
		return this.oprQty01;
	}
	
	/**
	 * Column Info
	 * @return oprQty04
	 */
	public String getOprQty04() {
		return this.oprQty04;
	}
	
	/**
	 * Column Info
	 * @return oprQty03
	 */
	public String getOprQty03() {
		return this.oprQty03;
	}
	
	/**
	 * Column Info
	 * @return oprQty15
	 */
	public String getOprQty15() {
		return this.oprQty15;
	}
	
	/**
	 * Column Info
	 * @return oprQty06
	 */
	public String getOprQty06() {
		return this.oprQty06;
	}
	
	/**
	 * Column Info
	 * @return oprQty14
	 */
	public String getOprQty14() {
		return this.oprQty14;
	}
	
	/**
	 * Column Info
	 * @return oprQty05
	 */
	public String getOprQty05() {
		return this.oprQty05;
	}
	
	/**
	 * Column Info
	 * @return oprQty08
	 */
	public String getOprQty08() {
		return this.oprQty08;
	}
	
	/**
	 * Column Info
	 * @return oprQty07
	 */
	public String getOprQty07() {
		return this.oprQty07;
	}
	
	/**
	 * Column Info
	 * @return oprQty09
	 */
	public String getOprQty09() {
		return this.oprQty09;
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
	 * @return pol
	 */
	public String getPol() {
		return this.pol;
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
	 * @param total
	 */
	public void setTotal(String total) {
		this.total = total;
	}
	
	/**
	 * Column Info
	 * @param oprQty13
	 */
	public void setOprQty13(String oprQty13) {
		this.oprQty13 = oprQty13;
	}
	
	/**
	 * Column Info
	 * @param oprQty12
	 */
	public void setOprQty12(String oprQty12) {
		this.oprQty12 = oprQty12;
	}
	
	/**
	 * Column Info
	 * @param oprQty11
	 */
	public void setOprQty11(String oprQty11) {
		this.oprQty11 = oprQty11;
	}
	
	/**
	 * Column Info
	 * @param oprQty02
	 */
	public void setOprQty02(String oprQty02) {
		this.oprQty02 = oprQty02;
	}
	
	/**
	 * Column Info
	 * @param oprQty10
	 */
	public void setOprQty10(String oprQty10) {
		this.oprQty10 = oprQty10;
	}
	
	/**
	 * Column Info
	 * @param oprQty01
	 */
	public void setOprQty01(String oprQty01) {
		this.oprQty01 = oprQty01;
	}
	
	/**
	 * Column Info
	 * @param oprQty04
	 */
	public void setOprQty04(String oprQty04) {
		this.oprQty04 = oprQty04;
	}
	
	/**
	 * Column Info
	 * @param oprQty03
	 */
	public void setOprQty03(String oprQty03) {
		this.oprQty03 = oprQty03;
	}
	
	/**
	 * Column Info
	 * @param oprQty15
	 */
	public void setOprQty15(String oprQty15) {
		this.oprQty15 = oprQty15;
	}
	
	/**
	 * Column Info
	 * @param oprQty06
	 */
	public void setOprQty06(String oprQty06) {
		this.oprQty06 = oprQty06;
	}
	
	/**
	 * Column Info
	 * @param oprQty14
	 */
	public void setOprQty14(String oprQty14) {
		this.oprQty14 = oprQty14;
	}
	
	/**
	 * Column Info
	 * @param oprQty05
	 */
	public void setOprQty05(String oprQty05) {
		this.oprQty05 = oprQty05;
	}
	
	/**
	 * Column Info
	 * @param oprQty08
	 */
	public void setOprQty08(String oprQty08) {
		this.oprQty08 = oprQty08;
	}
	
	/**
	 * Column Info
	 * @param oprQty07
	 */
	public void setOprQty07(String oprQty07) {
		this.oprQty07 = oprQty07;
	}
	
	/**
	 * Column Info
	 * @param oprQty09
	 */
	public void setOprQty09(String oprQty09) {
		this.oprQty09 = oprQty09;
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
	 * @param pol
	 */
	public void setPol(String pol) {
		this.pol = pol;
	}
	
	/**
	 * Column Info
	 * @param pod
	 */
	public void setPod(String pod) {
		this.pod = pod;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setTotal(JSPUtil.getParameter(request, "total", ""));
		setOprQty13(JSPUtil.getParameter(request, "opr_qty_13", ""));
		setOprQty12(JSPUtil.getParameter(request, "opr_qty_12", ""));
		setOprQty11(JSPUtil.getParameter(request, "opr_qty_11", ""));
		setOprQty02(JSPUtil.getParameter(request, "opr_qty_02", ""));
		setOprQty10(JSPUtil.getParameter(request, "opr_qty_10", ""));
		setOprQty01(JSPUtil.getParameter(request, "opr_qty_01", ""));
		setOprQty04(JSPUtil.getParameter(request, "opr_qty_04", ""));
		setOprQty03(JSPUtil.getParameter(request, "opr_qty_03", ""));
		setOprQty15(JSPUtil.getParameter(request, "opr_qty_15", ""));
		setOprQty06(JSPUtil.getParameter(request, "opr_qty_06", ""));
		setOprQty14(JSPUtil.getParameter(request, "opr_qty_14", ""));
		setOprQty05(JSPUtil.getParameter(request, "opr_qty_05", ""));
		setOprQty08(JSPUtil.getParameter(request, "opr_qty_08", ""));
		setOprQty07(JSPUtil.getParameter(request, "opr_qty_07", ""));
		setOprQty09(JSPUtil.getParameter(request, "opr_qty_09", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setPol(JSPUtil.getParameter(request, "pol", ""));
		setPod(JSPUtil.getParameter(request, "pod", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return RDRAddSlotVO[]
	 */
	public RDRAddSlotVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return RDRAddSlotVO[]
	 */
	public RDRAddSlotVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		RDRAddSlotVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] total = (JSPUtil.getParameter(request, prefix	+ "total", length));
			String[] oprQty13 = (JSPUtil.getParameter(request, prefix	+ "opr_qty_13", length));
			String[] oprQty12 = (JSPUtil.getParameter(request, prefix	+ "opr_qty_12", length));
			String[] oprQty11 = (JSPUtil.getParameter(request, prefix	+ "opr_qty_11", length));
			String[] oprQty02 = (JSPUtil.getParameter(request, prefix	+ "opr_qty_02", length));
			String[] oprQty10 = (JSPUtil.getParameter(request, prefix	+ "opr_qty_10", length));
			String[] oprQty01 = (JSPUtil.getParameter(request, prefix	+ "opr_qty_01", length));
			String[] oprQty04 = (JSPUtil.getParameter(request, prefix	+ "opr_qty_04", length));
			String[] oprQty03 = (JSPUtil.getParameter(request, prefix	+ "opr_qty_03", length));
			String[] oprQty15 = (JSPUtil.getParameter(request, prefix	+ "opr_qty_15", length));
			String[] oprQty06 = (JSPUtil.getParameter(request, prefix	+ "opr_qty_06", length));
			String[] oprQty14 = (JSPUtil.getParameter(request, prefix	+ "opr_qty_14", length));
			String[] oprQty05 = (JSPUtil.getParameter(request, prefix	+ "opr_qty_05", length));
			String[] oprQty08 = (JSPUtil.getParameter(request, prefix	+ "opr_qty_08", length));
			String[] oprQty07 = (JSPUtil.getParameter(request, prefix	+ "opr_qty_07", length));
			String[] oprQty09 = (JSPUtil.getParameter(request, prefix	+ "opr_qty_09", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] pol = (JSPUtil.getParameter(request, prefix	+ "pol", length));
			String[] pod = (JSPUtil.getParameter(request, prefix	+ "pod", length));
			
			for (int i = 0; i < length; i++) {
				model = new RDRAddSlotVO();
				if (total[i] != null)
					model.setTotal(total[i]);
				if (oprQty13[i] != null)
					model.setOprQty13(oprQty13[i]);
				if (oprQty12[i] != null)
					model.setOprQty12(oprQty12[i]);
				if (oprQty11[i] != null)
					model.setOprQty11(oprQty11[i]);
				if (oprQty02[i] != null)
					model.setOprQty02(oprQty02[i]);
				if (oprQty10[i] != null)
					model.setOprQty10(oprQty10[i]);
				if (oprQty01[i] != null)
					model.setOprQty01(oprQty01[i]);
				if (oprQty04[i] != null)
					model.setOprQty04(oprQty04[i]);
				if (oprQty03[i] != null)
					model.setOprQty03(oprQty03[i]);
				if (oprQty15[i] != null)
					model.setOprQty15(oprQty15[i]);
				if (oprQty06[i] != null)
					model.setOprQty06(oprQty06[i]);
				if (oprQty14[i] != null)
					model.setOprQty14(oprQty14[i]);
				if (oprQty05[i] != null)
					model.setOprQty05(oprQty05[i]);
				if (oprQty08[i] != null)
					model.setOprQty08(oprQty08[i]);
				if (oprQty07[i] != null)
					model.setOprQty07(oprQty07[i]);
				if (oprQty09[i] != null)
					model.setOprQty09(oprQty09[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (pol[i] != null)
					model.setPol(pol[i]);
				if (pod[i] != null)
					model.setPod(pod[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getRDRAddSlotVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return RDRAddSlotVO[]
	 */
	public RDRAddSlotVO[] getRDRAddSlotVOs(){
		RDRAddSlotVO[] vos = (RDRAddSlotVO[])models.toArray(new RDRAddSlotVO[models.size()]);
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
		this.total = this.total .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oprQty13 = this.oprQty13 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oprQty12 = this.oprQty12 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oprQty11 = this.oprQty11 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oprQty02 = this.oprQty02 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oprQty10 = this.oprQty10 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oprQty01 = this.oprQty01 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oprQty04 = this.oprQty04 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oprQty03 = this.oprQty03 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oprQty15 = this.oprQty15 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oprQty06 = this.oprQty06 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oprQty14 = this.oprQty14 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oprQty05 = this.oprQty05 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oprQty08 = this.oprQty08 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oprQty07 = this.oprQty07 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oprQty09 = this.oprQty09 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pol = this.pol .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pod = this.pod .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
