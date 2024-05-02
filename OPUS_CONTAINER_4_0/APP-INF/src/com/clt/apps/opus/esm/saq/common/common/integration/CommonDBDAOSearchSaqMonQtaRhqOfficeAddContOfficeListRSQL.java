/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : CommonDBDAOSearchSaqMonQtaRhqOfficeAddContOfficeListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.03.05
*@LastModifier : 
*@LastVersion : 1.0
* 2015.03.05 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.saq.common.common.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CommonDBDAOSearchSaqMonQtaRhqOfficeAddContOfficeListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Office Add 에 사용할 Area List 조회 
	  * </pre>
	  */
	public CommonDBDAOSearchSaqMonQtaRhqOfficeAddContOfficeListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rhq_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bse_qtr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bse_yr",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rlane_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mqta_step_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mqta_ver_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("area_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.saq.common.common.integration").append("\n"); 
		query.append("FileName : CommonDBDAOSearchSaqMonQtaRhqOfficeAddContOfficeListRSQL").append("\n"); 
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
		query.append("#if (${mqta_step_cd} == '08' ) " ).append("\n"); 
		query.append("	   SELECT OFC_CD AS TEXT, OFC_CD AS CODE                                                                " ).append("\n"); 
		query.append("	     FROM SAQ_ORGANIZATION_V                                                                                                                    " ).append("\n"); 
		query.append("	    WHERE N2ND_PRNT_OFC_CD = @[rhq_cd]" ).append("\n"); 
		query.append("		  #if (${area_cd} != '' ) 	 " ).append("\n"); 
		query.append("		      AND N3RD_PRNT_OFC_CD = @[area_cd]" ).append("\n"); 
		query.append("		  #else" ).append("\n"); 
		query.append("		  	  AND N3RD_PRNT_OFC_CD IS NULL" ).append("\n"); 
		query.append("		  #end                                                              " ).append("\n"); 
		query.append("	      AND LVL              = 4                                                                                                                  " ).append("\n"); 
		query.append("	      AND DELT_FLG         = 'N'                                                                                                                " ).append("\n"); 
		query.append("	      AND OFC_CD NOT IN (                                                                                                                       " ).append("\n"); 
		query.append("	                           SELECT SLS_RGN_OFC_CD                                                                                                " ).append("\n"); 
		query.append("	                             FROM SAQ_MON_QTA_LOD_TGT                                                                                           " ).append("\n"); 
		query.append("	                            WHERE MQTA_STEP_CD = @[mqta_step_cd]                                                                                              " ).append("\n"); 
		query.append("	                              AND BSE_YR       = @[bse_yr]                                                                                              " ).append("\n"); 
		query.append("	                              AND BSE_QTR_CD   = @[bse_qtr_cd]                                                                                              " ).append("\n"); 
		query.append("	                              AND TRD_CD       = @[trd_cd]                                                                                              " ).append("\n"); 
		query.append("	                              AND DIR_CD       = @[dir_cd]                                                                                              " ).append("\n"); 
		query.append("	                              AND MQTA_VER_NO  = @[mqta_ver_no]                                                                                              " ).append("\n"); 
		query.append("	                              AND RLANE_CD     = @[rlane_cd]                                                                                              " ).append("\n"); 
		query.append("	                         GROUP BY SLS_RGN_OFC_CD                                                                                                " ).append("\n"); 
		query.append("	                           HAVING COUNT(DISTINCT BSE_MON||SPRT_GRP_CD||BSA_GRP_CD) = ( SELECT COUNT(DISTINCT BSE_MON||SPRT_GRP_CD||BSA_GRP_CD)  " ).append("\n"); 
		query.append("	                                                                                         FROM SAQ_MON_QTA_LOD_TGT                               " ).append("\n"); 
		query.append("	                                                                                        WHERE MQTA_STEP_CD = @[mqta_step_cd]                                  " ).append("\n"); 
		query.append("	                                                                                          AND BSE_YR       = @[bse_yr]                                  " ).append("\n"); 
		query.append("	                                                                                          AND BSE_QTR_CD   = @[bse_qtr_cd]                                  " ).append("\n"); 
		query.append("	                                                                                          AND TRD_CD       = @[trd_cd]                                  " ).append("\n"); 
		query.append("	                                                                                          AND DIR_CD       = @[dir_cd]                                  " ).append("\n"); 
		query.append("	                                                                                          AND MQTA_VER_NO  = @[mqta_ver_no]                                  " ).append("\n"); 
		query.append("	                                                                                          AND RLANE_CD     = @[rlane_cd]  )  )                            " ).append("\n"); 
		query.append("	 ORDER BY OFC_CD                                                                     	" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("	   SELECT OFC_CD AS TEXT, OFC_CD AS CODE                                                                           " ).append("\n"); 
		query.append("	     FROM SAQ_ORGANIZATION_V                                                                                                                    " ).append("\n"); 
		query.append("	    WHERE N2ND_PRNT_OFC_CD = @[rhq_cd]         " ).append("\n"); 
		query.append("		  #if (${area_cd} != '' ) 	 " ).append("\n"); 
		query.append("		      AND N3RD_PRNT_OFC_CD = @[area_cd]" ).append("\n"); 
		query.append("		  #else" ).append("\n"); 
		query.append("		  	  AND N3RD_PRNT_OFC_CD IS NULL     " ).append("\n"); 
		query.append("		  #end                                                                                                            " ).append("\n"); 
		query.append("	      AND LVL              = 4                                                                                                                  " ).append("\n"); 
		query.append("	      AND DELT_FLG         = 'N'                                                                                                                " ).append("\n"); 
		query.append("	      AND OFC_CD NOT IN (                                                                                                                       " ).append("\n"); 
		query.append("	                           SELECT CTRT_RGN_OFC_CD                                                                                               " ).append("\n"); 
		query.append("	                             FROM SAQ_MON_QTA_RHQ                                                                                               " ).append("\n"); 
		query.append("	                            WHERE MQTA_STEP_CD = @[mqta_step_cd]                                                                                              " ).append("\n"); 
		query.append("	                              AND BSE_YR       = @[bse_yr]                                                                                              " ).append("\n"); 
		query.append("	                              AND BSE_QTR_CD   = @[bse_qtr_cd]                                                                                              " ).append("\n"); 
		query.append("	                              AND TRD_CD       = @[trd_cd]                                                                                              " ).append("\n"); 
		query.append("	                              AND DIR_CD       = @[dir_cd]                                                                                              " ).append("\n"); 
		query.append("	                              AND MQTA_VER_NO  = @[mqta_ver_no]                                                                                              " ).append("\n"); 
		query.append("	                              AND RLANE_CD     = @[rlane_cd]                                                                                              " ).append("\n"); 
		query.append("	                         GROUP BY CTRT_RGN_OFC_CD                                                                                               " ).append("\n"); 
		query.append("	                           HAVING COUNT(DISTINCT BSE_MON||SPRT_GRP_CD||BSA_GRP_CD) = ( SELECT COUNT(DISTINCT BSE_MON||SPRT_GRP_CD||BSA_GRP_CD)  " ).append("\n"); 
		query.append("	                                                                                         FROM SAQ_MON_QTA_RHQ                                   " ).append("\n"); 
		query.append("	                                                                                        WHERE MQTA_STEP_CD = @[mqta_step_cd]                                  " ).append("\n"); 
		query.append("	                                                                                          AND BSE_YR       = @[bse_yr]                                  " ).append("\n"); 
		query.append("	                                                                                          AND BSE_QTR_CD   = @[bse_qtr_cd]                                  " ).append("\n"); 
		query.append("	                                                                                          AND TRD_CD       = @[trd_cd]                                  " ).append("\n"); 
		query.append("	                                                                                          AND DIR_CD       = @[dir_cd]                                  " ).append("\n"); 
		query.append("	                                                                                          AND MQTA_VER_NO  = @[mqta_ver_no]                                  " ).append("\n"); 
		query.append("	                                                                                          AND RLANE_CD     = @[rlane_cd]  )  )                            " ).append("\n"); 
		query.append("	 ORDER BY OFC_CD                                                                     " ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}