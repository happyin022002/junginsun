/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : AdjustmentDBDAOCreateSqmQtaTgtVvdCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.09.11
*@LastModifier : 
*@LastVersion : 1.0
* 2013.09.11 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.sqm.specialkpi.adjustment.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AdjustmentDBDAOCreateSqmQtaTgtVvdCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * CreateSqmQtaTgtVvd
	  * </pre>
	  */
	public AdjustmentDBDAOCreateSqmQtaTgtVvdCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_bse_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_bse_qtr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_bse_yr",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.sqm.specialkpi.adjustment.integration").append("\n"); 
		query.append("FileName : AdjustmentDBDAOCreateSqmQtaTgtVvdCSQL").append("\n"); 
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
		query.append("INSERT INTO SQM_SPCL_TGT_VVD(" ).append("\n"); 
		query.append("             BSE_TP_CD" ).append("\n"); 
		query.append("            ,BSE_YR" ).append("\n"); 
		query.append("            ,BSE_QTR_CD" ).append("\n"); 
		query.append("            ,TRD_CD" ).append("\n"); 
		query.append("            ,RLANE_CD" ).append("\n"); 
		query.append("            ,DIR_CD" ).append("\n"); 
		query.append("            ,VSL_CD" ).append("\n"); 
		query.append("            ,SKD_VOY_NO" ).append("\n"); 
		query.append("            ,SKD_DIR_CD" ).append("\n"); 
		query.append("            ,BSE_MON" ).append("\n"); 
		query.append("            ,BSE_WK" ).append("\n"); 
		query.append("            ,CONV_DIR_CD" ).append("\n"); 
		query.append("            ,SUB_TRD_CD" ).append("\n"); 
		query.append("            ,IOC_CD" ).append("\n"); 
		query.append("            ,FNL_BSA_CAPA" ).append("\n"); 
		query.append("            ,CRE_USR_ID" ).append("\n"); 
		query.append("            ,CRE_DT" ).append("\n"); 
		query.append("            ,UPD_USR_ID" ).append("\n"); 
		query.append("            ,UPD_DT" ).append("\n"); 
		query.append("            )" ).append("\n"); 
		query.append("SELECT BSE_TP_CD" ).append("\n"); 
		query.append("      ,BSE_YR" ).append("\n"); 
		query.append("#if(${f_bse_tp_cd} == 'Q') --분기일때는 그대로" ).append("\n"); 
		query.append("      ,BSE_QTR_CD" ).append("\n"); 
		query.append("#elseif(${f_bse_tp_cd} == 'Y') -- 연간일때는 주차로 구분" ).append("\n"); 
		query.append("      ,CASE WHEN BSE_WK BETWEEN '0' AND '13' THEN '1Q'" ).append("\n"); 
		query.append("            WHEN BSE_WK BETWEEN '14' AND '26' THEN '2Q'" ).append("\n"); 
		query.append("            WHEN BSE_WK BETWEEN '27' AND '39' THEN '3Q'" ).append("\n"); 
		query.append("            WHEN BSE_WK BETWEEN '40' AND '53' THEN '4Q'" ).append("\n"); 
		query.append("      END BSE_QTR_CD" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("      ,TRD_CD" ).append("\n"); 
		query.append("      ,RLANE_CD" ).append("\n"); 
		query.append("      ,DIR_CD" ).append("\n"); 
		query.append("      ,VSL_CD" ).append("\n"); 
		query.append("      ,SKD_VOY_NO" ).append("\n"); 
		query.append("      ,SKD_DIR_CD" ).append("\n"); 
		query.append("      ,BSE_MON" ).append("\n"); 
		query.append("      ,BSE_WK" ).append("\n"); 
		query.append("      ,DIR_CD AS CONV_DIR_CD" ).append("\n"); 
		query.append("      ,SUB_TRD_CD" ).append("\n"); 
		query.append("      ,IOC_CD" ).append("\n"); 
		query.append("      ,NVL(DECODE(SUB_TRD_CD, 'IP', 0, FNL_BSA_CAPA), 0) AS FNL_BSA_CAPA" ).append("\n"); 
		query.append("      ,@[usr_id] AS CRE_USR_ID" ).append("\n"); 
		query.append("      ,SYSDATE" ).append("\n"); 
		query.append("      ,@[usr_id] AS UPD_USR_ID" ).append("\n"); 
		query.append("      ,SYSDATE" ).append("\n"); 
		query.append("  FROM SQM_QTA_TGT_VVD" ).append("\n"); 
		query.append(" WHERE 1=1" ).append("\n"); 
		query.append("   AND BSE_TP_CD  = @[f_bse_tp_cd]   --필수" ).append("\n"); 
		query.append("   AND BSE_YR     = @[f_bse_yr]      --필수" ).append("\n"); 
		query.append("#if(${f_bse_tp_cd} == 'Q')" ).append("\n"); 
		query.append("   AND BSE_QTR_CD = @[f_bse_qtr_cd]  --Quartely일때 필수" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("   AND DELT_FLG   = 'N'" ).append("\n"); 

	}
}