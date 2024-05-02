/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : BasicDataDBDAOSearchPolPodPairSectorListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.04.13
*@LastModifier : 
*@LastVersion : 1.0
* 2015.04.13 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.csq.datamanage.basicdata.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BasicDataDBDAOSearchPolPodPairSectorListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Pol Pod Pair 정보를 조회한다.
	  * </pre>
	  */
	public BasicDataDBDAOSearchPolPodPairSectorListRSQL(){
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
		params.put("f_bse_yr",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_sub_trd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_csq_mn_sctr_flg",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.csq.datamanage.basicdata.integration").append("\n"); 
		query.append("FileName : BasicDataDBDAOSearchPolPodPairSectorListRSQL").append("\n"); 
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
		query.append("SELECT DISTINCT" ).append("\n"); 
		query.append("       A1.TRD_CD" ).append("\n"); 
		query.append("      ,A1.SUB_TRD_CD" ).append("\n"); 
		query.append("      ,A1.DIR_CD" ).append("\n"); 
		query.append("      ,A1.RLANE_CD" ).append("\n"); 
		query.append("      ,A1.POL_CD" ).append("\n"); 
		query.append("      ,A1.POD_CD" ).append("\n"); 
		query.append("      ,MIN(A1.POL_CALL_SEQ) OVER (PARTITION BY A1.BSE_TP_CD, A1.BSE_YR, A1.BSE_QTR_CD, A1.RLANE_CD, A1.DIR_CD, A1.POL_CD, A1.POD_CD, A1.TRD_CD, A1.SUB_TRD_CD) POL_CALL_SEQ" ).append("\n"); 
		query.append("      ,MAX(A1.POD_CALL_SEQ) OVER (PARTITION BY A1.BSE_TP_CD, A1.BSE_YR, A1.BSE_QTR_CD, A1.RLANE_CD, A1.DIR_CD, A1.POL_CD, A1.POD_CD, A1.TRD_CD, A1.SUB_TRD_CD) POD_CALL_SEQ" ).append("\n"); 
		query.append("      ,DECODE(A1.CSQ_ACT_FLG, 'Y', 1, 'N', 0) CSQ_ACT_FLG" ).append("\n"); 
		query.append("      ,DECODE(NVL(A1.CSQ_MN_SCTR_FLG, 'N'), 'Y', 1, 'N', 0) CSQ_MN_SCTR_FLG" ).append("\n"); 
		query.append("      ,(" ).append("\n"); 
		query.append("        SELECT DECODE(COUNT(1), 0, 'N', 'Y') " ).append("\n"); 
		query.append("        FROM CSQ_SCTR_LANE_OFC A2" ).append("\n"); 
		query.append("        WHERE 1=1" ).append("\n"); 
		query.append("        AND A1.BSE_TP_CD  = A2.BSE_TP_CD" ).append("\n"); 
		query.append("        AND A1.BSE_YR 	  = A2.BSE_YR" ).append("\n"); 
		query.append("        AND A1.BSE_QTR_CD = A2.BSE_QTR_CD" ).append("\n"); 
		query.append("        AND A1.RLANE_CD   = A2.RLANE_CD" ).append("\n"); 
		query.append("        AND A1.DIR_CD     = A2.DIR_CD" ).append("\n"); 
		query.append("        ) AS SCTR_OFC_CRE_FLG " ).append("\n"); 
		query.append("FROM CSQ_SCTR_PAIR_MGMT A1" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND A1.BSE_TP_CD = @[f_bse_tp_cd]" ).append("\n"); 
		query.append("AND A1.BSE_YR = @[f_bse_yr]" ).append("\n"); 
		query.append("AND A1.BSE_QTR_CD = DECODE(@[f_bse_tp_cd],'Y','00',@[f_bse_qtr_cd])" ).append("\n"); 
		query.append("#if (${f_sub_trd_cd} != '' && ${f_sub_trd_cd} != 'All')" ).append("\n"); 
		query.append("AND A1.SUB_TRD_CD = @[f_sub_trd_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${f_rlane_cd} != '' && ${f_rlane_cd} != 'All')" ).append("\n"); 
		query.append("AND A1.RLANE_CD IN (${f_rlane_cd})" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${f_dir_cd} != '' && ${f_dir_cd} != 'All')" ).append("\n"); 
		query.append("AND A1.DIR_CD = @[f_dir_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${f_csq_mn_sctr_flg} != '' && ${f_csq_mn_sctr_flg} != 'All')" ).append("\n"); 
		query.append("AND NVL(A1.CSQ_MN_SCTR_FLG, 'N') = @[f_csq_mn_sctr_flg]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("ORDER BY A1.TRD_CD, A1.SUB_TRD_CD, A1.RLANE_CD, A1.DIR_CD, POL_CALL_SEQ ,POD_CALL_SEQ" ).append("\n"); 

	}
}