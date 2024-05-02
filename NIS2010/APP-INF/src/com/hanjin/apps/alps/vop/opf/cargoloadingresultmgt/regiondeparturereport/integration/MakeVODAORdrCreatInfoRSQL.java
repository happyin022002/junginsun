/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : MakeVODAORdrCreatInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.11
*@LastModifier : 장강철
*@LastVersion : 1.0
* 2010.03.11 장강철
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.opf.cargoloadingresultmgt.regiondeparturereport.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author jang kang cheol
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class MakeVODAORdrCreatInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * DESC Enter..
	  * </pre>
	  */
	public MakeVODAORdrCreatInfoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.opf.cargoloadingresultmgt.regiondeparturereport.integration").append("\n"); 
		query.append("FileName : MakeVODAORdrCreatInfoRSQL").append("\n"); 
		query.append("*/").append("\n"); 
	}
	
	public String getSQL(){
		return query.toString();
	}
	
	public HashMap<String,String[]> getParams() {
		return params;
	}

	/**
	 * Query 생성
	 */
	public void setQuery(){
		query.append("SELECT '' PORT_CD" ).append("\n"); 
		query.append(",      '' ARR_TIME" ).append("\n"); 
		query.append(",      '' BERTH_TIME" ).append("\n"); 
		query.append(",      '' UNBERTH_TIME" ).append("\n"); 
		query.append(",      '' DEP_TIME" ).append("\n"); 
		query.append(",      '' CRE_USR_ID" ).append("\n"); 
		query.append(",      '' CRE_DT" ).append("\n"); 
		query.append(",      '' VSL_CD" ).append("\n"); 
		query.append(",      '' VOY_NO" ).append("\n"); 
		query.append(",      '' DIR_CD" ).append("\n"); 
		query.append(",      '' RDR_DATE" ).append("\n"); 
		query.append(",      '' RDR_USER" ).append("\n"); 
		query.append(",      '' NIS_DATE" ).append("\n"); 
		query.append(",      '' REMARK" ).append("\n"); 
		query.append(",      '' UPDATE_USER" ).append("\n"); 
		query.append(",      '' UPDATE_TIME" ).append("\n"); 
		query.append(",      '' NEXT_PORT" ).append("\n"); 
		query.append(",      '' ETA" ).append("\n"); 
		query.append(",      '' NEXT_CANAL" ).append("\n"); 
		query.append(",      '' ETA_CANAL" ).append("\n"); 
		query.append(",      '' UPDATE_SYS" ).append("\n"); 
		query.append(",      '' REGION" ).append("\n"); 
		query.append(",      '' CALL_IND" ).append("\n"); 
		query.append(",      '' HEAD_PORT_CD" ).append("\n"); 
		query.append(",      '' OPR_CD" ).append("\n"); 
		query.append(",      '' TYPE" ).append("\n"); 
		query.append(",      '' SLOT_QTY" ).append("\n"); 
		query.append(",      '' WEIGHT" ).append("\n"); 
		query.append(",      '' SLOT_HC" ).append("\n"); 
		query.append(",      '' SLOT_45" ).append("\n"); 
		query.append(",      '' SLOT_ADD" ).append("\n"); 
		query.append(",      '' SLOT_HC20" ).append("\n"); 
		query.append(",      '' FULL" ).append("\n"); 
		query.append(",      '' EMPTY" ).append("\n"); 
		query.append(",      '' AKBB" ).append("\n"); 
		query.append(",      '' HC45" ).append("\n"); 
		query.append(",      '' TOTAL_SLOT" ).append("\n"); 
		query.append(",      '' TOTAL_WGT" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(", ''	LOAD_20" ).append("\n"); 
		query.append(", ''	HC20_QTY" ).append("\n"); 
		query.append(", ''	HC20_RATE" ).append("\n"); 
		query.append(", ''	ADD_20" ).append("\n"); 
		query.append(", ''	LOAD_40" ).append("\n"); 
		query.append(", ''	HC40_QTY" ).append("\n"); 
		query.append(", ''	HC40_RAT" ).append("\n"); 
		query.append(", ''	ADD_40" ).append("\n"); 
		query.append(", ''	LOAD_45" ).append("\n"); 
		query.append(", ''	BSA_45" ).append("\n"); 
		query.append(", ''	UN_RAT_45" ).append("\n"); 
		query.append(", ''	OV_RAT_45" ).append("\n"); 
		query.append(", ''	ADD_45" ).append("\n"); 
		query.append(", ''	RATIO_TYPE" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(",''    POL" ).append("\n"); 
		query.append(",''    POD" ).append("\n"); 
		query.append(",''    QTY_20" ).append("\n"); 
		query.append(",''    QTY_40" ).append("\n"); 
		query.append(",''    CNTR_TYPE" ).append("\n"); 
		query.append(",''    CNTR_SIZE" ).append("\n"); 
		query.append(",''    QTY" ).append("\n"); 
		query.append(",''    SLOT_ADD" ).append("\n"); 
		query.append(",''    POD_ISO" ).append("\n"); 
		query.append(",''    WEIGHT" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(",'' BASIC_SLOT" ).append("\n"); 
		query.append(",'' SWAP_SLOT" ).append("\n"); 
		query.append(",'' RELEASE_SLOT" ).append("\n"); 
		query.append(",'' TOT_ALLOC" ).append("\n"); 
		query.append(",'' BASIC_WGT" ).append("\n"); 
		query.append(",'' RELEASE_WGT" ).append("\n"); 
		query.append(",'' SWAP_WGT" ).append("\n"); 
		query.append(",'' TOT_WGT" ).append("\n"); 
		query.append(",'' TEU_WGT" ).append("\n"); 
		query.append(",'' BSA_TYPE" ).append("\n"); 
		query.append(",'' SEGMENT" ).append("\n"); 
		query.append(",'' RATIO_TYPE" ).append("\n"); 
		query.append("FROM    DUAL" ).append("\n"); 

	}
}