/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : CommonDBDAOSearchSaqCfmTgtRhqListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.03.03
*@LastModifier : 
*@LastVersion : 1.0
* 2011.03.03 
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

public class CommonDBDAOSearchSaqCfmTgtRhqListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SAQ_MON_CFM_TGT_VVD의 Rlane List 조회 
	  * </pre>
	  */
	public CommonDBDAOSearchSaqCfmTgtRhqListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.saq.common.common.integration").append("\n"); 
		query.append("FileName : CommonDBDAOSearchSaqCfmTgtRhqListRSQL").append("\n"); 
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
		query.append("#if (${qta_tgt_cd} == 'T' )" ).append("\n"); 
		query.append("   SELECT SLS_RHQ_CD AS TEXT,                            " ).append("\n"); 
		query.append("          SLS_RHQ_CD AS CODE                             " ).append("\n"); 
		query.append("     FROM SAQ_MON_LOD_TGT_OFC LOD ,                      " ).append("\n"); 
		query.append("          SAQ_MON_DIR_CONV    CONV                       " ).append("\n"); 
		query.append("    WHERE 1=1                                            " ).append("\n"); 
		query.append("      AND LOD.BSE_YR          = @[bse_year]                        " ).append("\n"); 
		query.append("      AND LOD.BSE_QTR_CD      = @[bse_qtr_cd]                        " ).append("\n"); 
		query.append("      AND LOD.TRD_CD          = @[trd_cd]                        " ).append("\n"); 
		query.append("      AND LOD.DIR_CD          = NVL(CONV.CONV_DIR_CD, @[dir_cd]) " ).append("\n"); 
		query.append("      AND CONV.BSE_YR     (+) = LOD.BSE_YR               " ).append("\n"); 
		query.append("      AND CONV.BSE_QTR_CD (+) = LOD.BSE_QTR_CD           " ).append("\n"); 
		query.append("      AND CONV.TRD_CD     (+) = LOD.TRD_CD               " ).append("\n"); 
		query.append("      AND CONV.DIR_CD     (+) = @[dir_cd]                        " ).append("\n"); 
		query.append("      AND CONV.RLANE_CD   (+) = @[rlane_cd]                        " ).append("\n"); 
		query.append(" ORDER BY SLS_RHQ_CD                                     " ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("   SELECT OFC_CD AS TEXT, OFC_CD AS CODE          " ).append("\n"); 
		query.append("     FROM SAQ_ORGANIZATION_V                      " ).append("\n"); 
		query.append("    WHERE LVL      = '2'                          " ).append("\n"); 
		query.append("      AND DELT_FLG = 'N'                          " ).append("\n"); 
		query.append(" ORDER BY OFC_CD                                  " ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}