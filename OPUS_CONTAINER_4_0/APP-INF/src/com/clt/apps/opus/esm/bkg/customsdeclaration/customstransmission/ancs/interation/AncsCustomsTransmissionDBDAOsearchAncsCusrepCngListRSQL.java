/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : AncsCustomsTransmissionDBDAOsearchAncsCusrepCngListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.22
*@LastModifier : 
*@LastVersion : 1.0
* 2010.02.22 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.ancs.interation;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AncsCustomsTransmissionDBDAOsearchAncsCusrepCngListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * S
	  * </pre>
	  */
	public AncsCustomsTransmissionDBDAOsearchAncsCusrepCngListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("anr_decl_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.ancs.interation").append("\n"); 
		query.append("FileName : AncsCustomsTransmissionDBDAOsearchAncsCusrepCngListRSQL").append("\n"); 
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
		query.append("SELECT A.ITEM_NO, C.ITEM_DESC, DECODE(A.EDI_MSG, B.EDI_MSG, 'N', 'Y') AS CNG_FLG, " ).append("\n"); 
		query.append("       A.EDI_MSG AS NEW_EDI_MSG, B.EDI_MSG AS LST_EDI_MSG" ).append("\n"); 
		query.append("  FROM ( SELECT B.ITEM_NO AS ITEM_NO," ).append("\n"); 
		query.append("            DECODE(B.ITEM_DESC, 'BEGIN_PORT:', B.ITEM_DESC || A.DEP_LOC_CD," ).append("\n"); 
		query.append("                                'DISCHARGE_IND:', B.ITEM_DESC || 'Y'," ).append("\n"); 
		query.append("                                'BERTH:', B.ITEM_DESC  || A.BRTH_DESC," ).append("\n"); 
		query.append("                                'VESSELNAME:', B.ITEM_DESC || A.VVD_NM," ).append("\n"); 
		query.append("                                'VESSELFLAG:', B.ITEM_DESC || A.VSL_CNT_CD," ).append("\n"); 
		query.append("                                'ETA:', B.ITEM_DESC || TO_CHAR(A.ETA_DT, 'YYYYMMDD'), 'ERROR') AS EDI_MSG" ).append("\n"); 
		query.append("  FROM BKG_CSTMS_ANR_VVD A, " ).append("\n"); 
		query.append("      ( SELECT '1' AS ITEM_NO, 'BEGIN_PORT:' AS ITEM_DESC FROM DUAL" ).append("\n"); 
		query.append("	UNION ALL SELECT '2' AS ITEM_NO, 'DISCHARGE_IND:' AS ITEM_DESC FROM DUAL" ).append("\n"); 
		query.append("	UNION ALL SELECT '3' AS ITEM_NO, 'BERTH:' AS ITEM_DESC FROM DUAL" ).append("\n"); 
		query.append("	UNION ALL SELECT '4' AS ITEM_NO, 'VESSELNAME:' AS ITEM_DESC FROM DUAL" ).append("\n"); 
		query.append("	UNION ALL SELECT '5' AS ITEM_NO, 'VESSELFLAG:' AS ITEM_DESC FROM DUAL" ).append("\n"); 
		query.append("	UNION ALL SELECT '6' AS ITEM_NO, 'ETA:' AS ITEM_DESC FROM DUAL ) B" ).append("\n"); 
		query.append(" WHERE A.VSL_CD = @[vsl_cd]" ).append("\n"); 
		query.append("   AND A.SKD_VOY_NO = @[skd_voy_no]" ).append("\n"); 
		query.append("   AND A.SKD_DIR_CD = @[skd_dir_cd] ) A, " ).append("\n"); 
		query.append("      ( SELECT B.ITEM_NO, A.EDI_MSG, A.ANR_DECL_NO, C.ITEM_DESC, A.REF_SEQ" ).append("\n"); 
		query.append("  FROM BKG_CSTMS_ANR_EDI_MSG A, " ).append("\n"); 
		query.append("      ( SELECT A.ANR_DECL_NO AS ANR_DECL_NO, C.ITEM_NO AS ITEM_NO, MAX(A.REF_SEQ) AS MAX_REF_SEQ" ).append("\n"); 
		query.append("	  FROM BKG_CSTMS_ANR_EDI_HIS A, BKG_CSTMS_ANR_EDI_MSG B, " ).append("\n"); 
		query.append("	      ( SELECT '1' AS ITEM_NO, 'BEGIN_PORT:' AS ITEM_DESC FROM DUAL" ).append("\n"); 
		query.append("		UNION ALL SELECT '2' AS ITEM_NO, 'DISCHARGE_IND:' AS ITEM_DESC FROM DUAL" ).append("\n"); 
		query.append("		UNION ALL SELECT '3' AS ITEM_NO, 'BERTH:' AS ITEM_DESC FROM DUAL" ).append("\n"); 
		query.append("		UNION ALL SELECT '4' AS ITEM_NO, 'VESSELNAME:' AS ITEM_DESC FROM DUAL" ).append("\n"); 
		query.append("		UNION ALL SELECT '5' AS ITEM_NO, 'VESSELFLAG:' AS ITEM_DESC FROM DUAL" ).append("\n"); 
		query.append("		UNION ALL SELECT '6' AS ITEM_NO, 'ETA:' AS ITEM_DESC FROM DUAL ) C" ).append("\n"); 
		query.append("	 WHERE A.MSG_TP_CD = 'R'    " ).append("\n"); 
		query.append("	   AND A.ANR_DECL_NO = @[anr_decl_no]" ).append("\n"); 
		query.append("	   AND A.EDI_SND_STS_CD IN ('O', 'R')" ).append("\n"); 
		query.append("	   AND A.EDI_RCV_STS_CD = 'A'" ).append("\n"); 
		query.append("	   AND B.MSG_TP_CD = A.MSG_TP_CD" ).append("\n"); 
		query.append("	   AND B.RCV_SND_DIV_CD = 'S'" ).append("\n"); 
		query.append("	   AND B.ANR_DECL_NO = A.ANR_DECL_NO" ).append("\n"); 
		query.append("	   AND B.REF_SEQ = A.REF_SEQ" ).append("\n"); 
		query.append("	   AND B.EDI_MSG LIKE C.ITEM_DESC || '%'" ).append("\n"); 
		query.append("	 GROUP BY A.ANR_DECL_NO, C.ITEM_NO ) B, " ).append("\n"); 
		query.append("      ( SELECT '1' AS ITEM_NO, 'BEGIN_PORT:' AS ITEM_DESC FROM DUAL" ).append("\n"); 
		query.append("	UNION ALL SELECT '2' AS ITEM_NO, 'DISCHARGE_IND:' AS ITEM_DESC FROM DUAL" ).append("\n"); 
		query.append("	UNION ALL SELECT '3' AS ITEM_NO, 'BERTH:' AS ITEM_DESC FROM DUAL" ).append("\n"); 
		query.append("	UNION ALL SELECT '4' AS ITEM_NO, 'VESSELNAME:' AS ITEM_DESC FROM DUAL" ).append("\n"); 
		query.append("	UNION ALL SELECT '5' AS ITEM_NO, 'VESSELFLAG:' AS ITEM_DESC FROM DUAL" ).append("\n"); 
		query.append("	UNION ALL SELECT '6' AS ITEM_NO, 'ETA:' AS ITEM_DESC FROM DUAL ) C" ).append("\n"); 
		query.append(" WHERE A.MSG_TP_CD = 'R'" ).append("\n"); 
		query.append("   AND A.ANR_DECL_NO = B.ANR_DECL_NO" ).append("\n"); 
		query.append("   AND A.REF_SEQ = B.MAX_REF_SEQ" ).append("\n"); 
		query.append("   AND C.ITEM_NO = B.ITEM_NO" ).append("\n"); 
		query.append("   AND A.EDI_MSG LIKE C.ITEM_DESC || '%'" ).append("\n"); 
		query.append("ORDER BY ITEM_NO ) B, " ).append("\n"); 
		query.append("      ( SELECT '1' AS ITEM_NO, 'BEGIN_PORT:' AS ITEM_DESC FROM DUAL" ).append("\n"); 
		query.append("	UNION ALL SELECT '2' AS ITEM_NO, 'DISCHARGE_IND:' AS ITEM_DESC FROM DUAL" ).append("\n"); 
		query.append("	UNION ALL SELECT '3' AS ITEM_NO, 'BERTH:' AS ITEM_DESC FROM DUAL" ).append("\n"); 
		query.append("	UNION ALL SELECT '4' AS ITEM_NO, 'VESSELNAME:' AS ITEM_DESC FROM DUAL" ).append("\n"); 
		query.append("	UNION ALL SELECT '5' AS ITEM_NO, 'VESSELFLAG:' AS ITEM_DESC FROM DUAL" ).append("\n"); 
		query.append("	UNION ALL SELECT '6' AS ITEM_NO, 'ETA:' AS ITEM_DESC FROM DUAL ) C" ).append("\n"); 
		query.append(" WHERE A.ITEM_NO = B.ITEM_NO" ).append("\n"); 
		query.append("   AND C.ITEM_NO = A.ITEM_NO" ).append("\n"); 
		query.append("   --AND DECODE(A.EDI_MSG, B.EDI_MSG, 'N', 'Y') = 'Y'" ).append("\n"); 

	}
}