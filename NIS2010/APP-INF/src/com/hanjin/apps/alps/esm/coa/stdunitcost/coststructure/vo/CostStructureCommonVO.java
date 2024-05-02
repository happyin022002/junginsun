/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CostStructureCommonVO.java
*@FileTitle : CostStructureCommonVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.10
*@LastModifier : 김기대
*@LastVersion : 1.0
* 2009.07.10 김기대 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.coa.stdunitcost.coststructure.vo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 김기대
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class CostStructureCommonVO {	

	private List createList = null;
	private List updateList = null;
	private List deleteList = null;
	
	public CostStructureCommonVO() {}

	public List getMultiCreateList(){	
		return createList;
	}
	public void setMultiCreateList(List list){	
		createList = list;
	}	
	
	public List getMultiUpdateList(){	
		return updateList;
	}
	public void setMultiUpdateList(List list){	
		updateList = list;
	}		
	
	public List getMultiDeleteList(){		
		return deleteList;
	}
	public void setMultiDeleteList(List list){	
		deleteList = list;
	}		
	
    //추가6############################################################################################# START
    //#####################################################################################################
    //#####################################################################################################
    /*  테이블 컬럼의 값을 저장하는 Hashtable */
    private HashMap<String, String> hashIndirectColumns = new HashMap<String, String>();

    /*  Velocity 변수에  값을 저장하는 Hashtable */
    private HashMap<String, Object> hashIndirectVariables = new HashMap<String, Object>();


    /**
     * ColumnValues Info
     * @return hashIndirectColumns
     */
    public HashMap<String, String> getIndirectColumnValues() {
        return this.hashIndirectColumns;
    }
    /**
     * ColumnValues Info
     * @param hashIndirectColumns
     */
    public void setIndirectColumnValues(HashMap<String, String> hMap) {
        this.hashIndirectColumns = hMap;
    }

    /**
     * VariableValues Info
     * @return hashIndirectVariables
     */
    public HashMap<String, Object> getIndirectVariableValues() {
        return this.hashIndirectVariables;
    }
    /**
     * VariableValues Info
     * @param hashIndirectVariables
     */
    public void setIndirectVariableValues(HashMap<String, Object> hMap) {
        this.hashIndirectVariables = hMap;
    }

    /**
     * 테이블 컬럼에 저장할 값을 Hashtable<"condition_name", "value"> 로 반환
     *  - 쿼리의 매개변수로 셋팅.
     *  - 가변조회 조건에 대한 값.
     *
     * @return Map
     */
    public Map<String, Object> getIndirectQueryParameter(){
        Map<String, Object> param = new HashMap<String, Object>();
        param.putAll(getIndirectColumnValues());
        return param;
    }

    /**
     * Velocity 변수에 저장할 값을 Hashtable<"variable_name", Object> 로 반환
     *  - 쿼리의 매개변수로 셋팅.
     *  - 가변조회 조건에 대한 값.
     *
     * @return Map
     */
    public Map<String, Object> getIndirectVelocityParameter(){
        Map<String, Object> param = new HashMap<String, Object>();
        param.putAll(getIndirectVariableValues());
        return param;
    }
    //추가6############################################################################################## END
    //#####################################################################################################
    //#####################################################################################################	
}
