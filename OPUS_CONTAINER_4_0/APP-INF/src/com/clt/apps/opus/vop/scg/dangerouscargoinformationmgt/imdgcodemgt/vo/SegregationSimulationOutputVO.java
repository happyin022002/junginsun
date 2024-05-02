/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SegregationSimulationOutputVO.java
*@FileTitle : SegregationSimulationOutputVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.16
*@LastModifier : 김현욱
*@LastVersion : 1.0
* 2009.09.16 김현욱 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.vop.scg.dangerouscargoinformationmgt.imdgcodemgt.vo;

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
 * @author 김현욱
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SegregationSimulationOutputVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SegregationSimulationOutputVO> models = new ArrayList<SegregationSimulationOutputVO>();
	
	/* Column Info */
	private String imdgUnNoSeq2 = null;
	/* Column Info */
	private String conflictDesc = null;
	/* Column Info */
	private String imdgSegrGrpNo1 = null;
	/* Column Info */
	private String imdgUnNoHldFlg1 = null;
	/* Column Info */
	private String imdgUnNoSeq1 = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String imdgClssCd1 = null;
	/* Column Info */
	private String imdgSegrCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String imdgUnNo2 = null;
	/* Column Info */
	private String imdgUnNoHldFlg2 = null;
	/* Column Info */
	private String imdgUnNo1 = null;
	/* Column Info */
	private String imdgSegrGrpNo2 = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SegregationSimulationOutputVO() {}

	public SegregationSimulationOutputVO(String ibflag, String pagerows, String imdgUnNo1, String imdgUnNoSeq1, String imdgClssCd1, String imdgSegrGrpNo1, String imdgUnNoHldFlg1, String imdgSegrCd, String conflictDesc, String imdgUnNo2, String imdgUnNoSeq2, String imdgSegrGrpNo2, String imdgUnNoHldFlg2) {
		this.imdgUnNoSeq2 = imdgUnNoSeq2;
		this.conflictDesc = conflictDesc;
		this.imdgSegrGrpNo1 = imdgSegrGrpNo1;
		this.imdgUnNoHldFlg1 = imdgUnNoHldFlg1;
		this.imdgUnNoSeq1 = imdgUnNoSeq1;
		this.pagerows = pagerows;
		this.imdgClssCd1 = imdgClssCd1;
		this.imdgSegrCd = imdgSegrCd;
		this.ibflag = ibflag;
		this.imdgUnNo2 = imdgUnNo2;
		this.imdgUnNoHldFlg2 = imdgUnNoHldFlg2;
		this.imdgUnNo1 = imdgUnNo1;
		this.imdgSegrGrpNo2 = imdgSegrGrpNo2;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("imdg_un_no_seq2", getImdgUnNoSeq2());
		this.hashColumns.put("conflict_desc", getConflictDesc());
		this.hashColumns.put("imdg_segr_grp_no1", getImdgSegrGrpNo1());
		this.hashColumns.put("imdg_un_no_hld_flg1", getImdgUnNoHldFlg1());
		this.hashColumns.put("imdg_un_no_seq1", getImdgUnNoSeq1());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("imdg_clss_cd1", getImdgClssCd1());
		this.hashColumns.put("imdg_segr_cd", getImdgSegrCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("imdg_un_no2", getImdgUnNo2());
		this.hashColumns.put("imdg_un_no_hld_flg2", getImdgUnNoHldFlg2());
		this.hashColumns.put("imdg_un_no1", getImdgUnNo1());
		this.hashColumns.put("imdg_segr_grp_no2", getImdgSegrGrpNo2());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("imdg_un_no_seq2", "imdgUnNoSeq2");
		this.hashFields.put("conflict_desc", "conflictDesc");
		this.hashFields.put("imdg_segr_grp_no1", "imdgSegrGrpNo1");
		this.hashFields.put("imdg_un_no_hld_flg1", "imdgUnNoHldFlg1");
		this.hashFields.put("imdg_un_no_seq1", "imdgUnNoSeq1");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("imdg_clss_cd1", "imdgClssCd1");
		this.hashFields.put("imdg_segr_cd", "imdgSegrCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("imdg_un_no2", "imdgUnNo2");
		this.hashFields.put("imdg_un_no_hld_flg2", "imdgUnNoHldFlg2");
		this.hashFields.put("imdg_un_no1", "imdgUnNo1");
		this.hashFields.put("imdg_segr_grp_no2", "imdgSegrGrpNo2");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return imdgUnNoSeq2
	 */
	public String getImdgUnNoSeq2() {
		return this.imdgUnNoSeq2;
	}
	
	/**
	 * Column Info
	 * @return conflictDesc
	 */
	public String getConflictDesc() {
		return this.conflictDesc;
	}
	
	/**
	 * Column Info
	 * @return imdgSegrGrpNo1
	 */
	public String getImdgSegrGrpNo1() {
		return this.imdgSegrGrpNo1;
	}
	
	/**
	 * Column Info
	 * @return imdgUnNoHldFlg1
	 */
	public String getImdgUnNoHldFlg1() {
		return this.imdgUnNoHldFlg1;
	}
	
	/**
	 * Column Info
	 * @return imdgUnNoSeq1
	 */
	public String getImdgUnNoSeq1() {
		return this.imdgUnNoSeq1;
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
	 * @return imdgClssCd1
	 */
	public String getImdgClssCd1() {
		return this.imdgClssCd1;
	}
	
	/**
	 * Column Info
	 * @return imdgSegrCd
	 */
	public String getImdgSegrCd() {
		return this.imdgSegrCd;
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
	 * @return imdgUnNo2
	 */
	public String getImdgUnNo2() {
		return this.imdgUnNo2;
	}
	
	/**
	 * Column Info
	 * @return imdgUnNoHldFlg2
	 */
	public String getImdgUnNoHldFlg2() {
		return this.imdgUnNoHldFlg2;
	}
	
	/**
	 * Column Info
	 * @return imdgUnNo1
	 */
	public String getImdgUnNo1() {
		return this.imdgUnNo1;
	}
	
	/**
	 * Column Info
	 * @return imdgSegrGrpNo2
	 */
	public String getImdgSegrGrpNo2() {
		return this.imdgSegrGrpNo2;
	}
	

	/**
	 * Column Info
	 * @param imdgUnNoSeq2
	 */
	public void setImdgUnNoSeq2(String imdgUnNoSeq2) {
		this.imdgUnNoSeq2 = imdgUnNoSeq2;
	}
	
	/**
	 * Column Info
	 * @param conflictDesc
	 */
	public void setConflictDesc(String conflictDesc) {
		this.conflictDesc = conflictDesc;
	}
	
	/**
	 * Column Info
	 * @param imdgSegrGrpNo1
	 */
	public void setImdgSegrGrpNo1(String imdgSegrGrpNo1) {
		this.imdgSegrGrpNo1 = imdgSegrGrpNo1;
	}
	
	/**
	 * Column Info
	 * @param imdgUnNoHldFlg1
	 */
	public void setImdgUnNoHldFlg1(String imdgUnNoHldFlg1) {
		this.imdgUnNoHldFlg1 = imdgUnNoHldFlg1;
	}
	
	/**
	 * Column Info
	 * @param imdgUnNoSeq1
	 */
	public void setImdgUnNoSeq1(String imdgUnNoSeq1) {
		this.imdgUnNoSeq1 = imdgUnNoSeq1;
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
	 * @param imdgClssCd1
	 */
	public void setImdgClssCd1(String imdgClssCd1) {
		this.imdgClssCd1 = imdgClssCd1;
	}
	
	/**
	 * Column Info
	 * @param imdgSegrCd
	 */
	public void setImdgSegrCd(String imdgSegrCd) {
		this.imdgSegrCd = imdgSegrCd;
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
	 * @param imdgUnNo2
	 */
	public void setImdgUnNo2(String imdgUnNo2) {
		this.imdgUnNo2 = imdgUnNo2;
	}
	
	/**
	 * Column Info
	 * @param imdgUnNoHldFlg2
	 */
	public void setImdgUnNoHldFlg2(String imdgUnNoHldFlg2) {
		this.imdgUnNoHldFlg2 = imdgUnNoHldFlg2;
	}
	
	/**
	 * Column Info
	 * @param imdgUnNo1
	 */
	public void setImdgUnNo1(String imdgUnNo1) {
		this.imdgUnNo1 = imdgUnNo1;
	}
	
	/**
	 * Column Info
	 * @param imdgSegrGrpNo2
	 */
	public void setImdgSegrGrpNo2(String imdgSegrGrpNo2) {
		this.imdgSegrGrpNo2 = imdgSegrGrpNo2;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setImdgUnNoSeq2(JSPUtil.getParameter(request, "imdg_un_no_seq2", ""));
		setConflictDesc(JSPUtil.getParameter(request, "conflict_desc", ""));
		setImdgSegrGrpNo1(JSPUtil.getParameter(request, "imdg_segr_grp_no1", ""));
		setImdgUnNoHldFlg1(JSPUtil.getParameter(request, "imdg_un_no_hld_flg1", ""));
		setImdgUnNoSeq1(JSPUtil.getParameter(request, "imdg_un_no_seq1", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setImdgClssCd1(JSPUtil.getParameter(request, "imdg_clss_cd1", ""));
		setImdgSegrCd(JSPUtil.getParameter(request, "imdg_segr_cd", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setImdgUnNo2(JSPUtil.getParameter(request, "imdg_un_no2", ""));
		setImdgUnNoHldFlg2(JSPUtil.getParameter(request, "imdg_un_no_hld_flg2", ""));
		setImdgUnNo1(JSPUtil.getParameter(request, "imdg_un_no1", ""));
		setImdgSegrGrpNo2(JSPUtil.getParameter(request, "imdg_segr_grp_no2", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SegregationSimulationOutputVO[]
	 */
	public SegregationSimulationOutputVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SegregationSimulationOutputVO[]
	 */
	public SegregationSimulationOutputVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SegregationSimulationOutputVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] imdgUnNoSeq2 = (JSPUtil.getParameter(request, prefix	+ "imdg_un_no_seq2", length));
			String[] conflictDesc = (JSPUtil.getParameter(request, prefix	+ "conflict_desc", length));
			String[] imdgSegrGrpNo1 = (JSPUtil.getParameter(request, prefix	+ "imdg_segr_grp_no1", length));
			String[] imdgUnNoHldFlg1 = (JSPUtil.getParameter(request, prefix	+ "imdg_un_no_hld_flg1", length));
			String[] imdgUnNoSeq1 = (JSPUtil.getParameter(request, prefix	+ "imdg_un_no_seq1", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] imdgClssCd1 = (JSPUtil.getParameter(request, prefix	+ "imdg_clss_cd1", length));
			String[] imdgSegrCd = (JSPUtil.getParameter(request, prefix	+ "imdg_segr_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] imdgUnNo2 = (JSPUtil.getParameter(request, prefix	+ "imdg_un_no2", length));
			String[] imdgUnNoHldFlg2 = (JSPUtil.getParameter(request, prefix	+ "imdg_un_no_hld_flg2", length));
			String[] imdgUnNo1 = (JSPUtil.getParameter(request, prefix	+ "imdg_un_no1", length));
			String[] imdgSegrGrpNo2 = (JSPUtil.getParameter(request, prefix	+ "imdg_segr_grp_no2", length));
			
			for (int i = 0; i < length; i++) {
				model = new SegregationSimulationOutputVO();
				if (imdgUnNoSeq2[i] != null)
					model.setImdgUnNoSeq2(imdgUnNoSeq2[i]);
				if (conflictDesc[i] != null)
					model.setConflictDesc(conflictDesc[i]);
				if (imdgSegrGrpNo1[i] != null)
					model.setImdgSegrGrpNo1(imdgSegrGrpNo1[i]);
				if (imdgUnNoHldFlg1[i] != null)
					model.setImdgUnNoHldFlg1(imdgUnNoHldFlg1[i]);
				if (imdgUnNoSeq1[i] != null)
					model.setImdgUnNoSeq1(imdgUnNoSeq1[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (imdgClssCd1[i] != null)
					model.setImdgClssCd1(imdgClssCd1[i]);
				if (imdgSegrCd[i] != null)
					model.setImdgSegrCd(imdgSegrCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (imdgUnNo2[i] != null)
					model.setImdgUnNo2(imdgUnNo2[i]);
				if (imdgUnNoHldFlg2[i] != null)
					model.setImdgUnNoHldFlg2(imdgUnNoHldFlg2[i]);
				if (imdgUnNo1[i] != null)
					model.setImdgUnNo1(imdgUnNo1[i]);
				if (imdgSegrGrpNo2[i] != null)
					model.setImdgSegrGrpNo2(imdgSegrGrpNo2[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSegregationSimulationOutputVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SegregationSimulationOutputVO[]
	 */
	public SegregationSimulationOutputVO[] getSegregationSimulationOutputVOs(){
		SegregationSimulationOutputVO[] vos = (SegregationSimulationOutputVO[])models.toArray(new SegregationSimulationOutputVO[models.size()]);
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
		this.imdgUnNoSeq2 = this.imdgUnNoSeq2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.conflictDesc = this.conflictDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imdgSegrGrpNo1 = this.imdgSegrGrpNo1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imdgUnNoHldFlg1 = this.imdgUnNoHldFlg1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imdgUnNoSeq1 = this.imdgUnNoSeq1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imdgClssCd1 = this.imdgClssCd1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imdgSegrCd = this.imdgSegrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imdgUnNo2 = this.imdgUnNo2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imdgUnNoHldFlg2 = this.imdgUnNoHldFlg2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imdgUnNo1 = this.imdgUnNo1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imdgSegrGrpNo2 = this.imdgSegrGrpNo2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
