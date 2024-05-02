/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesEqr0122ConditionVO.java
*@FileTitle : EesEqr0122ConditionVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.08
*@LastModifier : 채창호
*@LastVersion : 1.0
* 2009.07.08 채창호 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.ees.eqr.defaultmanage.scenariodefaultmanage.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

import com.hanjin.framework.component.common.AbstractValueObject;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 채창호
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class EesEqr0122ConditionVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<EesEqr0122ConditionVO> models = new ArrayList<EesEqr0122ConditionVO>();

	// Month
	private List<String> month = null;
	
	// 구분
	private String fmToAt     = "";
	
 	// FM/TO
 	private String fmType     = "";
 	private String fmEccCd    = "";
 	private String fmTypeBy   = "";
    private String fmPlnYr    = "";
 	private String toType     = "";
 	private String toEccCd    = "";
 	private String toTypeBy   = "";
	    	
 	// At
 	private String atType     = "";
 	private String atEccCd    = "";
 	private String atTypeBy   = "";
 	private String atPlnYr    = "";
 	
	// TP/SZ
	private String cntrTpszCd = "";	
	private String monthWeek  = "";
	
	public EesEqr0122ConditionVO() {}
	
	

	/**
	 * @return the month
	 */
	public List<String> getMonth() {
		return month;
	}

	/**
	 * @param month the month to set
	 */
	public void setMonth(List<String> month) {
		this.month = month;
	}

	/**
	 * @return the fmToAt
	 */
	public String getFmToAt() {
		return fmToAt;
	}

	/**
	 * @param fmToAt the fmToAt to set
	 */
	public void setFmToAt(String fmToAt) {
		this.fmToAt = fmToAt;
	}

	/**
	 * @return the fmType
	 */
	public String getFmType() {
		return fmType;
	}

	/**
	 * @param fmType the fmType to set
	 */
	public void setFmType(String fmType) {
		this.fmType = fmType;
	}

	/**
	 * @return the fmEccCd
	 */
	public String getFmEccCd() {
		return fmEccCd;
	}

	/**
	 * @param fmEccCd the fmEccCd to set
	 */
	public void setFmEccCd(String fmEccCd) {
		this.fmEccCd = fmEccCd;
	}

	/**
	 * @return the fmTypeBy
	 */
	public String getFmTypeBy() {
		return fmTypeBy;
	}

	/**
	 * @param fmTypeBy the fmTypeBy to set
	 */
	public void setFmTypeBy(String fmTypeBy) {
		this.fmTypeBy = fmTypeBy;
	}

	/**
	 * @return the fmPlnYr
	 */
	public String getFmPlnYr() {
		return fmPlnYr;
	}

	/**
	 * @param fmPlnYr the fmPlnYr to set
	 */
	public void setFmPlnYr(String fmPlnYr) {
		this.fmPlnYr = fmPlnYr;
	}

	/**
	 * @return the toType
	 */
	public String getToType() {
		return toType;
	}

	/**
	 * @param toType the toType to set
	 */
	public void setToType(String toType) {
		this.toType = toType;
	}

	/**
	 * @return the toEccCd
	 */
	public String getToEccCd() {
		return toEccCd;
	}

	/**
	 * @param toEccCd the toEccCd to set
	 */
	public void setToEccCd(String toEccCd) {
		this.toEccCd = toEccCd;
	}

	/**
	 * @return the toTypeBy
	 */
	public String getToTypeBy() {
		return toTypeBy;
	}

	/**
	 * @param toTypeBy the toTypeBy to set
	 */
	public void setToTypeBy(String toTypeBy) {
		this.toTypeBy = toTypeBy;
	}

	/**
	 * @return the atType
	 */
	public String getAtType() {
		return atType;
	}

	/**
	 * @param atType the atType to set
	 */
	public void setAtType(String atType) {
		this.atType = atType;
	}

	/**
	 * @return the atEccCd
	 */
	public String getAtEccCd() {
		return atEccCd;
	}

	/**
	 * @param atEccCd the atEccCd to set
	 */
	public void setAtEccCd(String atEccCd) {
		this.atEccCd = atEccCd;
	}

	/**
	 * @return the atTypeBy
	 */
	public String getAtTypeBy() {
		return atTypeBy;
	}

	/**
	 * @param atTypeBy the atTypeBy to set
	 */
	public void setAtTypeBy(String atTypeBy) {
		this.atTypeBy = atTypeBy;
	}

	/**
	 * @return the atPlnYr
	 */
	public String getAtPlnYr() {
		return atPlnYr;
	}

	/**
	 * @param atPlnYr the atPlnYr to set
	 */
	public void setAtPlnYr(String atPlnYr) {
		this.atPlnYr = atPlnYr;
	}

	/**
	 * @return the cntrTpszCd
	 */
	public String getCntrTpszCd() {
		return cntrTpszCd;
	}

	/**
	 * @param cntrTpszCd the cntrTpszCd to set
	 */
	public void setCntrTpszCd(String cntrTpszCd) {
		this.cntrTpszCd = cntrTpszCd;
	}

	/**
	 * @return the monthWeek
	 */
	public String getMonthWeek() {
		return monthWeek;
	}

	/**
	 * @param monthWeek the monthWeek to set
	 */
	public void setMonthWeek(String monthWeek) {
		this.monthWeek = monthWeek;
	}



	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
//		this.hashColumns.put("row", getRow());
//		this.hashColumns.put("fmeccCd", getSfstk_lvl_cd());
//		this.hashColumns.put("col", getCol());
//		this.hashColumns.put("ecc_cd", getEcc_cd());
//		this.hashColumns.put("cntr_tpsz_cd", getCntr_tpsz_cd());
//		this.hashColumns.put("sfstk_vol_qty", getSfstk_vol_qty());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("row", "row");
		this.hashFields.put("sfstk_lvl_cd", "sfstk_lvl_cd");
		this.hashFields.put("col", "col");
		this.hashFields.put("ecc_cd", "ecc_cd");
		this.hashFields.put("cntr_tpsz_cd", "cntr_tpsz_cd");
		this.hashFields.put("sfstk_vol_qty", "sfstk_vol_qty");
		return this.hashFields;
	}
	
	/**
	 * VO 배열을 반환
	 * @return SearchSafetyStockVO[]
	 */
	public EesEqr0122ConditionVO[] getEesEqr117ConditionVOs(){
		EesEqr0122ConditionVO[] vos = (EesEqr0122ConditionVO[])models.toArray(new EesEqr0122ConditionVO[models.size()]);
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
}
