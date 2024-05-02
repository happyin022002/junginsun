/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : UsaCustomsReportDBDAOsearchMiTransmitHistoryForIERSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.04
*@LastModifier : 
*@LastVersion : 1.0
* 2010.02.04 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.customsreport.usa.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class UsaCustomsReportDBDAOsearchMiTransmitHistoryForIERSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 조회
	  * </pre>
	  */
	public UsaCustomsReportDBDAOsearchMiTransmitHistoryForIERSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vvd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tod",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fromd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tot",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pol",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fromt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pod",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.customsdeclaration.customsreport.usa.integration").append("\n"); 
		query.append("FileName : UsaCustomsReportDBDAOsearchMiTransmitHistoryForIERSQL").append("\n"); 
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
		query.append("SELECT S.SND_DT, S.TRSM_MSG_TP_ID, S.SND_USR_OFC_CD, S.SND_USR_ID," ).append("\n"); 
		query.append("       S.VSL_CD||S.SKD_VOY_NO||S.SKD_DIR_CD VVD," ).append("\n"); 
		query.append("       S.POL_CD, S.POD_CD, " ).append("\n"); 
		query.append("       COUNT(B.BL_NO) TOT_BL," ).append("\n"); 
		query.append("       SUM(" ).append("\n"); 
		query.append("           CASE WHEN NVL(I.IBD_TRSP_TP_CD, 'X') = '63'THEN 1 ELSE 0 END" ).append("\n"); 
		query.append("       ) IE_BL," ).append("\n"); 
		query.append("       SUM(" ).append("\n"); 
		query.append("           CASE WHEN NVL(I.IBD_TRSP_TP_CD, 'X') = '63' AND I.IBD_TRSP_NO IS NOT NULL THEN 1 ELSE 0 END" ).append("\n"); 
		query.append("       ) MIB_BL    " ).append("\n"); 
		query.append("FROM BKG_CSTMS_ADV_SND_LOG S" ).append("\n"); 
		query.append("   , BKG_CSTMS_ADV_BL B" ).append("\n"); 
		query.append("   , BKG_CSTMS_ADV_IBD I" ).append("\n"); 
		query.append("WHERE S.CNT_CD = 'US' " ).append("\n"); 
		query.append("  AND S.CNT_CD = B.CNT_CD" ).append("\n"); 
		query.append("  AND S.VSL_CD = B.VSL_CD" ).append("\n"); 
		query.append("  AND S.SKD_VOY_NO = B.SKD_VOY_NO" ).append("\n"); 
		query.append("  AND S.SKD_DIR_CD = B.SKD_DIR_CD" ).append("\n"); 
		query.append("  AND S.POL_CD = B.CSTMS_POL_CD" ).append("\n"); 
		query.append("  AND S.POD_CD = B.CSTMS_POD_CD" ).append("\n"); 
		query.append("  AND B.MF_STS_CD = 'A'" ).append("\n"); 
		query.append("  AND B.CNT_CD = I.CNT_CD(+)" ).append("\n"); 
		query.append("  AND B.BL_NO = I.BL_NO(+)" ).append("\n"); 
		query.append("  AND S.TRSM_MSG_TP_ID = 'MI'" ).append("\n"); 
		query.append("  AND S.IO_BND_CD = 'I'" ).append("\n"); 
		query.append("  AND S.DELT_FLG = 'N'" ).append("\n"); 
		query.append("#if (${fromd} != '') " ).append("\n"); 
		query.append("	AND S.SND_DT >= TO_DATE(REPLACE(REPLACE(@[fromd], '-', ''), '/', '') ||' '|| REPLACE(REPLACE(@[fromt], ':', ''), '-',''),'YYYYMMDD HH24:MI')" ).append("\n"); 
		query.append("#end " ).append("\n"); 
		query.append("#if (${tod} != '') " ).append("\n"); 
		query.append("	AND S.SND_DT <= TO_DATE(REPLACE(REPLACE(@[tod], '-', ''), '/', '') ||' '|| REPLACE(REPLACE(@[tot], ':', ''), '-',''),'YYYYMMDD HH24:MI')" ).append("\n"); 
		query.append("#end " ).append("\n"); 
		query.append("#if (${vvd} != '') " ).append("\n"); 
		query.append("	AND S.VSL_CD     = SUBSTR(@[vvd],1,4)" ).append("\n"); 
		query.append("	AND	S.SKD_VOY_NO = SUBSTR(@[vvd],5,4)" ).append("\n"); 
		query.append("	AND	S.SKD_DIR_CD = SUBSTR(@[vvd],9,1)" ).append("\n"); 
		query.append("#end " ).append("\n"); 
		query.append("#if (${pol} != '') " ).append("\n"); 
		query.append("	AND S.POL_CD like '%' || @[pol] || '%'" ).append("\n"); 
		query.append("#end " ).append("\n"); 
		query.append("#if (${pod} != '') " ).append("\n"); 
		query.append("	AND S.POD_CD like '%' || @[pod] || '%'" ).append("\n"); 
		query.append("#end " ).append("\n"); 
		query.append("GROUP BY   S.SND_DT, S.TRSM_MSG_TP_ID, S.SND_USR_OFC_CD, S.SND_USR_ID," ).append("\n"); 
		query.append("       S.VSL_CD, S.SKD_VOY_NO, S.SKD_DIR_CD," ).append("\n"); 
		query.append("       S.POL_CD, S.POD_CD" ).append("\n"); 

	}
}