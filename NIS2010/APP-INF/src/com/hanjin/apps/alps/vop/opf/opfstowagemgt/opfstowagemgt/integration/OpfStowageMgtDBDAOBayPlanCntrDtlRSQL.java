/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : OpfStowageMgtDBDAOBayPlanCntrDtlRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.12.28
*@LastModifier : 
*@LastVersion : 1.0
* 2015.12.28 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.opf.opfstowagemgt.opfstowagemgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class OpfStowageMgtDBDAOBayPlanCntrDtlRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * OpfStowageMgtDBDAOBayPlanCntrDtl
	  * </pre>
	  */
	public OpfStowageMgtDBDAOBayPlanCntrDtlRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("port_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("skd_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("skd_voy_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bay_idx",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("call_ind",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.opf.opfstowagemgt.opfstowagemgt.integration").append("\n"); 
		query.append("FileName : OpfStowageMgtDBDAOBayPlanCntrDtlRSQL").append("\n"); 
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
		query.append("SELECT" ).append("\n"); 
		query.append("		VSL_CD" ).append("\n"); 
		query.append("        , VOY_NO" ).append("\n"); 
		query.append("        , DIR_CD" ).append("\n"); 
		query.append("        , PORT_CD" ).append("\n"); 
		query.append("        , ID" ).append("\n"); 
		query.append("        , CALL_IND" ).append("\n"); 
		query.append("        , BAY" ).append("\n"); 
		query.append("        , ROWW" ).append("\n"); 
		query.append("        , TIER" ).append("\n"); 
		query.append("        , OPR_CD" ).append("\n"); 
		query.append("        , FE" ).append("\n"); 
		query.append("        , POR" ).append("\n"); 
		query.append("        , POL" ).append("\n"); 
		query.append("        , POD" ).append("\n"); 
		query.append("        , POD2" ).append("\n"); 
		query.append("        , FPOD" ).append("\n"); 
		query.append("        , FDEST" ).append("\n"); 
		query.append("        , SZTP" ).append("\n"); 
		query.append("        , SZTP_ISO" ).append("\n"); 
		query.append("        , WEIGHT" ).append("\n"); 
		query.append("        , DELV_CD" ).append("\n"); 
		query.append("        , GROUP_CD" ).append("\n"); 
		query.append("        , SPECIAL" ).append("\n"); 
		query.append("        , TEMP" ).append("\n"); 
		query.append("        , IMDG" ).append("\n"); 
		query.append("        , IMDG2" ).append("\n"); 
		query.append("        , IMDG3" ).append("\n"); 
		query.append("        , IMDG4" ).append("\n"); 
		query.append("        , UNNO" ).append("\n"); 
		query.append("        , OVH" ).append("\n"); 
		query.append("        , OVF" ).append("\n"); 
		query.append("        , OVA" ).append("\n"); 
		query.append("        , OVP" ).append("\n"); 
		query.append("        , OVS" ).append("\n"); 
		query.append("        , OVH_SLOT" ).append("\n"); 
		query.append("        , OVP_SLOT" ).append("\n"); 
		query.append("        , OVS_SLOT" ).append("\n"); 
		query.append("        , OVF_SLOT" ).append("\n"); 
		query.append("        , OVA_SLOT" ).append("\n"); 
		query.append("        , REMARK" ).append("\n"); 
		query.append("        , REMARK2" ).append("\n"); 
		query.append("        , COD" ).append("\n"); 
		query.append("        , COD_RSN" ).append("\n"); 
		query.append("        , PRE_POSITION" ).append("\n"); 
		query.append("        , SHIFT_PORT" ).append("\n"); 
		query.append("        , SHIFT_RSN" ).append("\n"); 
		query.append("        , SHIFT_ACCT" ).append("\n"); 
		query.append("        , SHIFT_RES" ).append("\n"); 
		query.append("        , SHIFT_TYPE" ).append("\n"); 
		query.append("        , SHIFT_LOC" ).append("\n"); 
		query.append("        , BL_NO" ).append("\n"); 
		query.append("        , BOOKING_NO" ).append("\n"); 
		query.append("        , HI1" ).append("\n"); 
		query.append("        , HI2" ).append("\n"); 
		query.append("        , CARGO_TYPE" ).append("\n"); 
		query.append("        , CNTR_TYPE" ).append("\n"); 
		query.append("        , CNTR_SIZE" ).append("\n"); 
		query.append("        , PCOD" ).append("\n"); 
		query.append("        , ONDECK_CHK" ).append("\n"); 
		query.append("        , HATCH" ).append("\n"); 
		query.append("        , ACT_SLOT" ).append("\n"); 
		query.append("        , SLOT_OVER" ).append("\n"); 
		query.append("        , STATUS" ).append("\n"); 
		query.append("        , WGT_GROUP" ).append("\n"); 
		query.append("        , PLAN_TYPE" ).append("\n"); 
		query.append("        , UPDATE_USER" ).append("\n"); 
		query.append("        , UPDATE_TIME" ).append("\n"); 
		query.append("        , CO_LOADED" ).append("\n"); 
		query.append("        , DG_REMARK" ).append("\n"); 
		query.append("        , POD_ISO" ).append("\n"); 
		query.append("        , POD2_ISO" ).append("\n"); 
		query.append("        , POL_ISO" ).append("\n"); 
		query.append("        , PACKING_GRP" ).append("\n"); 
		query.append("        , FLASHPOINT" ).append("\n"); 
		query.append("        , CO_PACKING_GRP" ).append("\n"); 
		query.append("        , CO_FLASHPOINT" ).append("\n"); 
		query.append("        , CARGO_LENGTH" ).append("\n"); 
		query.append("        , CARGO_BREADTH" ).append("\n"); 
		query.append("        , CARGO_HEIGHT" ).append("\n"); 
		query.append("        , CARGO_UNIT" ).append("\n"); 
		query.append("        , IMDG_SEQ" ).append("\n"); 
		query.append("        , IMDG_GRP" ).append("\n"); 
		query.append("        , CO_IMDG_SEQ" ).append("\n"); 
		query.append("        , CO_IMDG_GRP" ).append("\n"); 
		query.append("		, CASE WHEN TIER < 50 THEN 'UNDER' ELSE 'ON' END AS DECK_PSN" ).append("\n"); 
		query.append("		, BAY||'-'||ROWW||'-'||TIER AS CNTR_PSN" ).append("\n"); 
		query.append("FROM BAY_PLAN" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND (VSL_CD, VOY_NO, DIR_CD, PORT_CD, ID, CALL_IND, PLAN_TYPE) IN (SELECT VSL_CD, VOY_NO, DIR_CD, PORT_CD, ID, CALL_IND" ).append("\n"); 
		query.append("                                                                           , CASE WHEN COUNT(PLAN_TYPE) > 1 THEN 'E' ELSE 'F' END AS PLAN_TYPE" ).append("\n"); 
		query.append("                                                                    FROM BAY_PLAN A" ).append("\n"); 
		query.append("                                                                    WHERE 1=1" ).append("\n"); 
		query.append("                                                                    AND VSL_CD = @[vsl_cd]" ).append("\n"); 
		query.append("                                                                    AND VOY_NO = @[skd_voy_no]" ).append("\n"); 
		query.append("                                                                    AND DIR_CD = @[skd_dir_cd]" ).append("\n"); 
		query.append("                                                                    AND PORT_CD = @[port_cd]" ).append("\n"); 
		query.append("																    AND BAY = @[bay_idx]" ).append("\n"); 
		query.append("																	AND CALL_IND = @[call_ind]" ).append("\n"); 
		query.append("                                                                    GROUP BY VSL_CD, VOY_NO, DIR_CD, PORT_CD, ID, CALL_IND" ).append("\n"); 
		query.append("                                                                    )" ).append("\n"); 

	}
}