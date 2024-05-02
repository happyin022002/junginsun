/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : BSAManageDBDAOSearchOverlappedContractInquirySCListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.12.19
*@LastModifier : 
*@LastVersion : 1.0
* 2014.12.19 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bsa.bsamanage.bsamanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BSAManageDBDAOSearchOverlappedContractInquirySCListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 중복 계약 조회 (SPACE CHARTERING)
	  * </pre>
	  */
	public BSAManageDBDAOSearchOverlappedContractInquirySCListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("coblane",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("txtsdate",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cobdir",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cobtrade",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bsa.bsamanage.bsamanage.integration").append("\n"); 
		query.append("FileName : BSAManageDBDAOSearchOverlappedContractInquirySCListRSQL").append("\n"); 
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
		query.append("WITH TARGET_AGREE AS" ).append("\n"); 
		query.append("    (" ).append("\n"); 
		query.append("     SELECT " ).append("\n"); 
		query.append("            DENSE_RANK() OVER(ORDER BY TRD_CD,RLANE_CD,DIR_CD) AS BSA_GROUP," ).append("\n"); 
		query.append("            BSA_SEQ," ).append("\n"); 
		query.append("            TRD_CD," ).append("\n"); 
		query.append("            RLANE_CD," ).append("\n"); 
		query.append("            DIR_CD," ).append("\n"); 
		query.append("            VSL_SEQ," ).append("\n"); 
		query.append("            VVD_CD," ).append("\n"); 
		query.append("            BSA_FM_DT," ).append("\n"); 
		query.append("            BSA_TO_DT," ).append("\n"); 
		query.append("            VSL_CD," ).append("\n"); 
		query.append("            HJS_FNL_BSA_CAPA," ).append("\n"); 
		query.append("            HJS_BSA_BFR_SUB_CAPA," ).append("\n"); 
		query.append("            VSL_BSA_CHK_FLG," ).append("\n"); 
		query.append("            SCHT_DESC," ).append("\n"); 
		query.append("            VSL_MLT_INP_FLG" ).append("\n"); 
		query.append("       FROM BSA_SLT_CHTR_BZC" ).append("\n"); 
		query.append("      WHERE BSA_TO_DT >= NVL( REPLACE(@[txtsdate],'-','') ,'19000101')" ).append("\n"); 
		query.append("        AND VSL_BSA_CHK_FLG = 'N'" ).append("\n"); 
		query.append("--    	AND TRD_CD     = 'IAS'" ).append("\n"); 
		query.append("--        AND RLANE_CD   = 'CHSIA'" ).append("\n"); 
		query.append("    )" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SELECT DISTINCT " ).append("\n"); 
		query.append("       A2.BSA_GROUP ," ).append("\n"); 
		query.append("       A2.BSA_SEQ   ," ).append("\n"); 
		query.append("       A2.VVD_CD    ," ).append("\n"); 
		query.append("       A2.BSA_FM_DT ," ).append("\n"); 
		query.append("       A2.BSA_TO_DT ," ).append("\n"); 
		query.append("       A2.TRD_CD    ," ).append("\n"); 
		query.append("       A2.RLANE_CD  ," ).append("\n"); 
		query.append("       A2.DIR_CD    ," ).append("\n"); 
		query.append("       " ).append("\n"); 
		query.append("       NULL AS VOP_CD     ," ).append("\n"); 
		query.append("       NULL AS VSL_CAPA   ," ).append("\n"); 
		query.append("       --A2.VSL_SEQ   ," ).append("\n"); 
		query.append("       --A2.HJS_FNL_BSA_CAPA    ," ).append("\n"); 
		query.append("       --A2.HJS_BSA_BFR_SUB_CAPA," ).append("\n"); 
		query.append("       --A2.VSL_BSA_CHK_FLG     ," ).append("\n"); 
		query.append("       --A2.SCHT_DESC      ," ).append("\n"); 
		query.append("       --A2.VSL_MLT_INP_FLG," ).append("\n"); 
		query.append("       DECODE(A2.BSA_FM_DT,A2.BSA_TO_DT,'N',DECODE(LEAST(A2.BSA_FM_DT,A2.BSA_TO_DT),A2.BSA_TO_DT,'Y','N')) AS REVERSE_FLG" ).append("\n"); 
		query.append("       " ).append("\n"); 
		query.append("  FROM TARGET_AGREE A1," ).append("\n"); 
		query.append("       TARGET_AGREE A2" ).append("\n"); 
		query.append(" WHERE A1.BSA_GROUP = A2.BSA_GROUP" ).append("\n"); 
		query.append("   AND A1.TRD_CD    = A2.TRD_CD" ).append("\n"); 
		query.append("   AND A1.RLANE_CD  = A2.RLANE_CD" ).append("\n"); 
		query.append("   AND A1.DIR_CD    = A2.DIR_CD" ).append("\n"); 
		query.append("   AND A1.VSL_SEQ   = A2.VSL_SEQ" ).append("\n"); 
		query.append("   AND (A2.BSA_TO_DT BETWEEN A1.BSA_FM_DT AND A1.BSA_TO_DT  " ).append("\n"); 
		query.append("        OR A2.BSA_FM_DT BETWEEN A1.BSA_FM_DT AND A1.BSA_TO_DT)" ).append("\n"); 
		query.append("   AND A1.BSA_SEQ   < A2.BSA_SEQ    " ).append("\n"); 
		query.append("   AND A1.TRD_CD            = NVL( NULLIF(@[cobtrade], 'All') , A1.TRD_CD)" ).append("\n"); 
		query.append("   AND A1.RLANE_CD 		    = NVL( NULLIF(@[coblane], 'All') , A1.RLANE_CD)" ).append("\n"); 
		query.append("   AND A1.DIR_CD            = NVL( NULLIF(@[cobdir], 'All') ,A1.DIR_CD)" ).append("\n"); 
		query.append(" ORDER BY A2.BSA_GROUP,     " ).append("\n"); 
		query.append("       A2.TRD_CD  ," ).append("\n"); 
		query.append("       A2.RLANE_CD," ).append("\n"); 
		query.append("       A2.DIR_CD  ," ).append("\n"); 
		query.append("       --A2.VSL_SEQ ," ).append("\n"); 
		query.append("       A2.BSA_SEQ" ).append("\n"); 

	}
}