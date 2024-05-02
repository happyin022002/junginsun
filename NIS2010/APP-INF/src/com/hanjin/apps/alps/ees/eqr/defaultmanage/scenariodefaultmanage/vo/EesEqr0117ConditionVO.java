/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesEqr0117ConditionVO.java
*@FileTitle : EesEqr0117ConditionVO
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

import com.hanjin.framework.component.common.AbstractValueObject;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 채창호
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class EesEqr0117ConditionVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<EesEqr0117ConditionVO> models = new ArrayList<EesEqr0117ConditionVO>();
	

	/* Condition Info */
	private String row = null;
	
	/* Condition Info */
	private String sfstk_lvl_cd = null;
	
	/* Condition Info */
	private String col = null;
	
	/* Condition Info */
	private String f_cmd = null;
	
	/* Condition Info */
	private String ecc_cd = null;
	
	/* Condition Info */
	private String cntr_tpsz_cd = null;
	
	/* Condition Info */
	private String sfstk_vol_qty = "0"; 
	
	/* Condition Info */
	private String lvl_cd = null; 
	
	
	/**
	 * @return the cntr_tpsz_cd
	 */
	public String getCntr_tpsz_cd() {
		return cntr_tpsz_cd;
	}

	/**
	 * @param cntr_tpsz_cd the cntr_tpsz_cd to set
	 */
	public void setCntr_tpsz_cd(String cntr_tpsz_cd) {
		this.cntr_tpsz_cd = cntr_tpsz_cd;
	}

	/**
	 * @return the ecc_cd
	 */
	public String getEcc_cd() {
		return ecc_cd;
	}

	/**
	 * @param ecc_cd the ecc_cd to set
	 */
	public void setEcc_cd(String ecc_cd) {
		this.ecc_cd = ecc_cd;
	}

	/**
	 * @return the row
	 */
	public String getRow() {
		return row;
	}

	/**
	 * @param row the row to set
	 */
	public void setRow(String row) {
		this.row = row;
	}

	/**
	 * @return the sfstk_lvl_cd
	 */
	public String getSfstk_lvl_cd() {
		return sfstk_lvl_cd;
	}

	/**
	 * @param sfstk_lvl_cd the sfstk_lvl_cd to set
	 */
	public void setSfstk_lvl_cd(String sfstk_lvl_cd) {
		this.sfstk_lvl_cd = sfstk_lvl_cd;
	}

	/**
	 * @return the col
	 */
	public String getCol() {
		return col;
	}

	/**
	 * @param col the col to set
	 */
	public void setCol(String col) {
		this.col = col;
	}

	/**
	 * @return the f_cmd
	 */
	public String getF_cmd() {
		return f_cmd;
	}

	/**
	 * @param f_cmd the f_cmd to set
	 */
	public void setF_cmd(String f_cmd) {
		this.f_cmd = f_cmd;
	}

	
	
	/**
	 * @return the sfstk_vol_qty
	 */
	public String getSfstk_vol_qty() {
		return sfstk_vol_qty;
	}

	/**
	 * @param sfstk_vol_qty the sfstk_vol_qty to set
	 */
	public void setSfstk_vol_qty(String sfstk_vol_qty) {
		this.sfstk_vol_qty = sfstk_vol_qty;
	}



	/**
	 * @return the lvl_cd
	 */
	public String getLvl_cd() {
		return lvl_cd;
	}

	/**
	 * @param lvl_cd the lvl_cd to set
	 */
	public void setLvl_cd(String lvl_cd) {
		this.lvl_cd = lvl_cd;
	}



	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	
	public EesEqr0117ConditionVO() {}

	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("row", getRow());
		this.hashColumns.put("sfstk_lvl_cd", getSfstk_lvl_cd());
		this.hashColumns.put("col", getCol());
		this.hashColumns.put("ecc_cd", getEcc_cd());
		this.hashColumns.put("cntr_tpsz_cd", getCntr_tpsz_cd());
		this.hashColumns.put("sfstk_vol_qty", getSfstk_vol_qty());
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
	public EesEqr0117ConditionVO[] getEesEqr0117ConditionVOs(){
		EesEqr0117ConditionVO[] vos = (EesEqr0117ConditionVO[])models.toArray(new EesEqr0117ConditionVO[models.size()]);
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
