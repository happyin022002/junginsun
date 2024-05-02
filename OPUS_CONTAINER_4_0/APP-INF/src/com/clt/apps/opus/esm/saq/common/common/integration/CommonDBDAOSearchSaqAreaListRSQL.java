/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : CommonDBDAOSearchSaqAreaListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.03.07
*@LastModifier : 
*@LastVersion : 1.0
* 2011.03.07 
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

public class CommonDBDAOSearchSaqAreaListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Office Add 에 사용할 Area List 조회 
	  * </pre>
	  */
	public CommonDBDAOSearchSaqAreaListRSQL(){
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
		params.put("rlane_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("qta_tgt_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("bse_year",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("rlse_ver_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.saq.common.common.integration").append("\n"); 
		query.append("FileName : CommonDBDAOSearchSaqAreaListRSQL").append("\n"); 
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
		query.append("SELECT DISTINCT N3RD_PRNT_OFC_CD AS TEXT, N3RD_PRNT_OFC_CD AS CODE                        " ).append("\n"); 
		query.append("FROM SAQ_ORGANIZATION_V                                                                 " ).append("\n"); 
		query.append("WHERE N2ND_PRNT_OFC_CD = @[rhq_cd]                                                               " ).append("\n"); 
		query.append("AND LVL              = 4                                                               " ).append("\n"); 
		query.append("AND DELT_FLG         = 'N'                                                             " ).append("\n"); 
		query.append("AND N3RD_PRNT_OFC_CD IS NOT NULL                                                       " ).append("\n"); 
		query.append("#if (${app_tp_cd} == 'O' )" ).append("\n"); 
		query.append("	AND OFC_CD NOT IN (                                                                    " ).append("\n"); 
		query.append("                      SELECT RGN_OFC_CD                                                  " ).append("\n"); 
		query.append("                        FROM SAQ_MON_CFM_QTA                                             " ).append("\n"); 
		query.append("                       WHERE MQTA_RLSE_VER_NO = @[rlse_ver_no]                                        " ).append("\n"); 
		query.append("                         AND BSE_YR           = @[bse_year]                                        " ).append("\n"); 
		query.append("                         AND BSE_QTR_CD       = @[bse_qtr_cd]                                        " ).append("\n"); 
		query.append("                         AND QTA_TGT_CD       = @[qta_tgt_cd]                                        " ).append("\n"); 
		query.append("                         AND TRD_CD           = @[trd_cd]                                        " ).append("\n"); 
		query.append("                         AND RLANE_CD         = @[rlane_cd]                                        " ).append("\n"); 
		query.append("                         AND DIR_CD           = @[dir_cd]                                        " ).append("\n"); 
		query.append("                         AND RHQ_CD           = @[rhq_cd]                                        " ).append("\n"); 
		query.append("                    GROUP BY RGN_OFC_CD                                                  " ).append("\n"); 
		query.append("                      HAVING COUNT(DISTINCT BSE_MON) = ( SELECT COUNT(DISTINCT BSE_MON)  " ).append("\n"); 
		query.append("                                                           FROM SAQ_MON_CFM_QTA          " ).append("\n"); 
		query.append("                                                          WHERE MQTA_RLSE_VER_NO = @[rlse_ver_no]     " ).append("\n"); 
		query.append("                                                            AND BSE_YR           = @[bse_year]     " ).append("\n"); 
		query.append("                                                            AND BSE_QTR_CD       = @[bse_qtr_cd]     " ).append("\n"); 
		query.append("                                                            AND QTA_TGT_CD       = @[qta_tgt_cd]     " ).append("\n"); 
		query.append("                                                            AND TRD_CD           = @[trd_cd]     " ).append("\n"); 
		query.append("                                                            AND RLANE_CD         = @[rlane_cd]     " ).append("\n"); 
		query.append("                                                            AND DIR_CD           = @[dir_cd]     " ).append("\n"); 
		query.append("                                                            AND RHQ_CD           = @[rhq_cd]  )  " ).append("\n"); 
		query.append("                       UNION                                                             " ).append("\n"); 
		query.append("                      SELECT RGN_OFC_CD                                                  " ).append("\n"); 
		query.append("                        FROM SAQ_MON_CFM_QTA_OFC_ADD                                     " ).append("\n"); 
		query.append("                       WHERE MQTA_RLSE_VER_NO = @[rlse_ver_no]                                        " ).append("\n"); 
		query.append("                         AND BSE_YR           = @[bse_year]                                        " ).append("\n"); 
		query.append("                         AND BSE_QTR_CD       = @[bse_qtr_cd]                                        " ).append("\n"); 
		query.append("                         AND QTA_TGT_CD       = @[qta_tgt_cd]                                        " ).append("\n"); 
		query.append("                         AND TRD_CD           = @[trd_cd]                                        " ).append("\n"); 
		query.append("                         AND RLANE_CD         = @[rlane_cd]                                        " ).append("\n"); 
		query.append("                         AND DIR_CD           = @[dir_cd]                                        " ).append("\n"); 
		query.append("                         AND RHQ_CD           = @[rhq_cd]    )                                   " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("ORDER BY DECODE(NVL(N3RD_PRNT_OFC_CD, 99), '99', 99, 11)||N3RD_PRNT_OFC_CD                      	--SAQ_GET_AQ_DP_SEQ_FNC 삭제" ).append("\n"); 

	}
}