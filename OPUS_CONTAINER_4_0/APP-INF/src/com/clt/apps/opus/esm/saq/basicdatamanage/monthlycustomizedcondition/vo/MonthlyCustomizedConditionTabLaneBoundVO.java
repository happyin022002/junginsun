/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName       : MonthlyCustomizedConditionTabLaneBoundVO.java
*@FileTitle      : MonthlyCustomizedConditionTabLaneBoundVO
*Open Issues     :
*Change history  :
*@LastModifyDate : 
*@LastModifier   : 
*@LastVersion    : 1.0
* 1.0 최초 생성
=========================================================*/

package com.clt.apps.opus.esm.saq.basicdatamanage.monthlycustomizedcondition.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 김태호
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class MonthlyCustomizedConditionTabLaneBoundVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<MonthlyCustomizedConditionTabLaneBoundVO> models = new ArrayList<MonthlyCustomizedConditionTabLaneBoundVO>();
	
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String convDirCd = null;
	/* Column Info */
	private String trdCd = null;
	/* Column Info */
	private String dirCd = null;
	/* Column Info */
	private String rlaneCd = null;
	/* Column Info */
	private String tradeGroup = null;
	/* Column Info */
	private String subTrdCd = null;
	/* Page Number */
	private String pagerows = null;
	/* 추가구성 시작 */
	private Object xVO = null;
	private List<DBRowSet> rsList = new ArrayList<DBRowSet>();
	private DBRowSet dbRowset = null;
	/* 추가구성 끝 */

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public MonthlyCustomizedConditionTabLaneBoundVO() {}

	public MonthlyCustomizedConditionTabLaneBoundVO(String ibflag, String pagerows, String tradeGroup, String trdCd, String subTrdCd, String rlaneCd, String dirCd, String convDirCd) {
		this.ibflag = ibflag;
		this.convDirCd = convDirCd;
		this.trdCd = trdCd;
		this.dirCd = dirCd;
		this.rlaneCd = rlaneCd;
		this.tradeGroup = tradeGroup;
		this.subTrdCd = subTrdCd;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("conv_dir_cd", getConvDirCd());
		this.hashColumns.put("trd_cd", getTrdCd());
		this.hashColumns.put("dir_cd", getDirCd());
		this.hashColumns.put("rlane_cd", getRlaneCd());
		this.hashColumns.put("trade_group", getTradeGroup());
		this.hashColumns.put("sub_trd_cd", getSubTrdCd());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("conv_dir_cd", "convDirCd");
		this.hashFields.put("trd_cd", "trdCd");
		this.hashFields.put("dir_cd", "dirCd");
		this.hashFields.put("rlane_cd", "rlaneCd");
		this.hashFields.put("trade_group", "tradeGroup");
		this.hashFields.put("sub_trd_cd", "subTrdCd");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
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
	 * @return convDirCd
	 */
	public String getConvDirCd() {
		return this.convDirCd;
	}
	
	/**
	 * Column Info
	 * @return trdCd
	 */
	public String getTrdCd() {
		return this.trdCd;
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
	 * @return rlaneCd
	 */
	public String getRlaneCd() {
		return this.rlaneCd;
	}
	
	/**
	 * Column Info
	 * @return tradeGroup
	 */
	public String getTradeGroup() {
		return this.tradeGroup;
	}
	
	/**
	 * Column Info
	 * @return subTrdCd
	 */
	public String getSubTrdCd() {
		return this.subTrdCd;
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
	 * @param ibflag
	 */
	public void setIbflag(String ibflag) {
		this.ibflag = ibflag;
	}
	
	/**
	 * Column Info
	 * @param convDirCd
	 */
	public void setConvDirCd(String convDirCd) {
		this.convDirCd = convDirCd;
	}
	
	/**
	 * Column Info
	 * @param trdCd
	 */
	public void setTrdCd(String trdCd) {
		this.trdCd = trdCd;
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
	 * @param rlaneCd
	 */
	public void setRlaneCd(String rlaneCd) {
		this.rlaneCd = rlaneCd;
	}
	
	/**
	 * Column Info
	 * @param tradeGroup
	 */
	public void setTradeGroup(String tradeGroup) {
		this.tradeGroup = tradeGroup;
	}
	
	/**
	 * Column Info
	 * @param subTrdCd
	 */
	public void setSubTrdCd(String subTrdCd) {
		this.subTrdCd = subTrdCd;
	}
	
	/**
	 * Page Number
	 * @param pagerows
	 */
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
	}
	
	/* 추가구성 시작 */
	/**
	 * @return the dbRowset
	 */
	public DBRowSet getDbRowset() {
		return dbRowset;
	}

	/**
	 * @param dbRowset the dbRowset to set
	 */
	public void setDbRowset(DBRowSet dbRowset) {
		this.dbRowset = dbRowset;
	}
	
	/**
	 * @return the rsList
	 */
	public List<DBRowSet> getRsList() {
		return rsList;
	}

	/**
	 * @param rsList the rsList to set
	 */
	public void setRsList(List<DBRowSet> rsList) {
		this.rsList = rsList;
	}
		
	/**
	 * @return the Object
	 */
	public Object getConditionVO() {
		return xVO;
	}

	/**
	 * @param conditionVO the conditionVO to set
	 */
	public void setConditionVO(Object xVO) {
		this.xVO = xVO;
	}
	/* 추가구성 끝 */
		
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setConvDirCd(JSPUtil.getParameter(request, "conv_dir_cd", ""));
		setTrdCd(JSPUtil.getParameter(request, "trd_cd", ""));
		setDirCd(JSPUtil.getParameter(request, "dir_cd", ""));
		setRlaneCd(JSPUtil.getParameter(request, "rlane_cd", ""));
		setTradeGroup(JSPUtil.getParameter(request, "trade_group", ""));
		setSubTrdCd(JSPUtil.getParameter(request, "sub_trd_cd", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return MonthlyCustomizedConditionTabLaneBoundVO[]
	 */
	public MonthlyCustomizedConditionTabLaneBoundVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return MonthlyCustomizedConditionTabLaneBoundVO[]
	 */
	public MonthlyCustomizedConditionTabLaneBoundVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		MonthlyCustomizedConditionTabLaneBoundVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] convDirCd = (JSPUtil.getParameter(request, prefix	+ "conv_dir_cd", length));
			String[] trdCd = (JSPUtil.getParameter(request, prefix	+ "trd_cd", length));
			String[] dirCd = (JSPUtil.getParameter(request, prefix	+ "dir_cd", length));
			String[] rlaneCd = (JSPUtil.getParameter(request, prefix	+ "rlane_cd", length));
			String[] tradeGroup = (JSPUtil.getParameter(request, prefix	+ "trade_group", length));
			String[] subTrdCd = (JSPUtil.getParameter(request, prefix	+ "sub_trd_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new MonthlyCustomizedConditionTabLaneBoundVO();
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (convDirCd[i] != null)
					model.setConvDirCd(convDirCd[i]);
				if (trdCd[i] != null)
					model.setTrdCd(trdCd[i]);
				if (dirCd[i] != null)
					model.setDirCd(dirCd[i]);
				if (rlaneCd[i] != null)
					model.setRlaneCd(rlaneCd[i]);
				if (tradeGroup[i] != null)
					model.setTradeGroup(tradeGroup[i]);
				if (subTrdCd[i] != null)
					model.setSubTrdCd(subTrdCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getMonthlyCustomizedConditionTabLaneBoundVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return MonthlyCustomizedConditionTabLaneBoundVO[]
	 */
	public MonthlyCustomizedConditionTabLaneBoundVO[] getMonthlyCustomizedConditionTabLaneBoundVOs(){
		MonthlyCustomizedConditionTabLaneBoundVO[] vos = (MonthlyCustomizedConditionTabLaneBoundVO[])models.toArray(new MonthlyCustomizedConditionTabLaneBoundVO[models.size()]);
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
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.convDirCd = this.convDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trdCd = this.trdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dirCd = this.dirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rlaneCd = this.rlaneCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tradeGroup = this.tradeGroup .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.subTrdCd = this.subTrdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
