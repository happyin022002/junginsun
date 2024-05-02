/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : KorManifestListDBDAOsearchSummaryInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.03.31
*@LastModifier : 
*@LastVersion : 1.0
* 2016.03.31 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.korea.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class KorManifestListDBDAOsearchSummaryInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Container Summary 정보 조회
	  * </pre>
	  */
	public KorManifestListDBDAOsearchSummaryInfoRSQL(){
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
		params.put("port_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("in_type",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pol_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pod_tml",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pol_tml",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.korea.integration").append("\n"); 
		query.append("FileName : KorManifestListDBDAOsearchSummaryInfoRSQL").append("\n"); 
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
		query.append("SELECT SUM(DECODE(KR_CSTMS_BL_TP_CD,'E',0,DECODE(CSTMS_DECL_TP_CD,'I',DECODE(SUBSTR(CNTR_TPSZ_CD,2,1),'2',1,0)," ).append("\n"); 
		query.append("                                            'E',DECODE(SUBSTR(CNTR_TPSZ_CD,2,1),'2',1,0),0))) CNT_LC_20" ).append("\n"); 
		query.append("     , SUM(DECODE(KR_CSTMS_BL_TP_CD,'E',0,DECODE(CSTMS_DECL_TP_CD,'I',DECODE(SUBSTR(CNTR_TPSZ_CD,2,1),'4',1,'5',1,'8',1,'9',1,0)," ).append("\n"); 
		query.append("                                            'E',DECODE(SUBSTR(CNTR_TPSZ_CD,2,1),'4',1,'5',1,'8',1,'9',1,0),0))) CNT_LC_40" ).append("\n"); 
		query.append("     , SUM(DECODE(KR_CSTMS_BL_TP_CD,'E',0,DECODE(CSTMS_DECL_TP_CD,'I',DECODE(SUBSTR(CNTR_TPSZ_CD,2,1),'7',1,0)," ).append("\n"); 
		query.append("                                            'E',DECODE(SUBSTR(CNTR_TPSZ_CD,2,1),'7',1,0),0))) CNT_LC_45" ).append("\n"); 
		query.append("     , SUM(DECODE(KR_CSTMS_BL_TP_CD,'E',0,DECODE(CSTMS_DECL_TP_CD,'T',DECODE(SUBSTR(CNTR_TPSZ_CD,2,1),'2',1,0)," ).append("\n"); 
		query.append("                                            'R',DECODE(SUBSTR(CNTR_TPSZ_CD,2,1),'2',1,0),0))) CNT_TS_20" ).append("\n"); 
		query.append("     , SUM(DECODE(KR_CSTMS_BL_TP_CD,'E',0,DECODE(CSTMS_DECL_TP_CD,'T',DECODE(SUBSTR(CNTR_TPSZ_CD,2,1),'4',1,'5',1,'8',1,'9',1,0)," ).append("\n"); 
		query.append("                                            'R',DECODE(SUBSTR(CNTR_TPSZ_CD,2,1),'4',1,'5',1,'8',1,'9',1,0),0))) CNT_TS_40" ).append("\n"); 
		query.append("     , SUM(DECODE(KR_CSTMS_BL_TP_CD,'E',0,DECODE(CSTMS_DECL_TP_CD,'T',DECODE(SUBSTR(CNTR_TPSZ_CD,2,1),'7',1,0)," ).append("\n"); 
		query.append("                                            'R',DECODE(SUBSTR(CNTR_TPSZ_CD,2,1),'7',1,0),0))) CNT_TS_45" ).append("\n"); 
		query.append("	 , SUM(DECODE(KR_CSTMS_BL_TP_CD,'E',DECODE(CSTMS_DECL_TP_CD,'T',0,'R',0,DECODE(SUBSTR(CNTR_TPSZ_CD,2,1),'2',1,0)),0)) CNT_EC_20       " ).append("\n"); 
		query.append("	 , SUM(DECODE(KR_CSTMS_BL_TP_CD,'E',DECODE(CSTMS_DECL_TP_CD,'T',0,'R',0,DECODE(SUBSTR(CNTR_TPSZ_CD,2,1),'4',1,'5',1,'8',1,'9',1,0)),0)) CNT_EC_40 " ).append("\n"); 
		query.append("	 , SUM(DECODE(KR_CSTMS_BL_TP_CD,'E',DECODE(CSTMS_DECL_TP_CD,'T',0,'R',0,DECODE(SUBSTR(CNTR_TPSZ_CD,2,1),'7',1,0)),0)) CNT_EC_45       " ).append("\n"); 
		query.append("	 , SUM(DECODE(KR_CSTMS_BL_TP_CD,'E',DECODE(CSTMS_DECL_TP_CD,'T',DECODE(SUBSTR(CNTR_TPSZ_CD,2,1),'2',1,0),'R',DECODE(SUBSTR(CNTR_TPSZ_CD,2,1),'2',1,0),0),0)) CNT_TS_EC_20  " ).append("\n"); 
		query.append("	 , SUM(DECODE(KR_CSTMS_BL_TP_CD,'E',DECODE(CSTMS_DECL_TP_CD,'T',DECODE(SUBSTR(CNTR_TPSZ_CD,2,1),'4',1,'5',1,'8',1,'9',1,0),'R',DECODE(SUBSTR(CNTR_TPSZ_CD,2,1),'4',1,'5',1,'8',1,'9',1,0),0),0)) CNT_TS_EC_40  " ).append("\n"); 
		query.append("	 , SUM(DECODE(KR_CSTMS_BL_TP_CD,'E',DECODE(CSTMS_DECL_TP_CD,'T',DECODE(SUBSTR(CNTR_TPSZ_CD,2,1),'7',1,0),'R',DECODE(SUBSTR(CNTR_TPSZ_CD,2,1),'7',1,0),0),0)) CNT_TS_EC_45  " ).append("\n"); 
		query.append(" FROM (SELECT " ).append("\n"); 
		query.append("			T.CSTMS_DECL_TP_CD, DECODE(T2.KR_CSTMS_BL_TP_CD, 'E', 'E', 'X') KR_CSTMS_BL_TP_CD, C.CNTR_TPSZ_CD, C.CNTR_NO" ).append("\n"); 
		query.append("       FROM  (SELECT BKG_NO, CSTMS_BL_NO, CSTMS_DECL_TP_CD, DMST_PORT_CD, MAX(TRNS_SEQ) SEQ" ).append("\n"); 
		query.append("                FROM BKG_CSTMS_KR_BL A" ).append("\n"); 
		query.append("               WHERE VSL_CD      = SUBSTR(@[vvd], 1, 4)" ).append("\n"); 
		query.append("                 AND SKD_VOY_NO  = SUBSTR(@[vvd], 5, 4)" ).append("\n"); 
		query.append("                 AND SKD_DIR_CD  = SUBSTR(@[vvd], 9, 1)" ).append("\n"); 
		query.append("                 AND DMST_PORT_CD = @[port_cd]" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${in_type} != 'D' && ${in_type} != '') " ).append("\n"); 
		query.append("				AND KR_CSTMS_BND_CD = @[in_type]" ).append("\n"); 
		query.append("#else " ).append("\n"); 
		query.append("				AND KR_CSTMS_BND_CD IN ('A','B','C')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${io_bnd_cd} == 'I') " ).append("\n"); 
		query.append("                 AND CSTMS_DECL_TP_CD IN ('I', 'T')" ).append("\n"); 
		query.append("                 AND TS_POD_CD = @[pod_cd]" ).append("\n"); 
		query.append("				 #if (${pod_tml} != '') " ).append("\n"); 
		query.append("                 AND PORT_TML_CD = @[pod_tml]" ).append("\n"); 
		query.append("				#else" ).append("\n"); 
		query.append("				AND Length(NVL(PORT_TML_CD, 'aa')) <> 7" ).append("\n"); 
		query.append("                #end" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("                 AND CSTMS_DECL_TP_CD IN ('E', 'R')" ).append("\n"); 
		query.append("                 AND TS_POL_CD = @[pol_cd]" ).append("\n"); 
		query.append("				#if (${pol_tml} != '') " ).append("\n"); 
		query.append("                 AND EVNT_YD_CD = @[pol_tml]" ).append("\n"); 
		query.append("				#else" ).append("\n"); 
		query.append("				AND Length(NVL(EVNT_YD_CD, 'aa')) <> 7" ).append("\n"); 
		query.append("				" ).append("\n"); 
		query.append("				 #end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("AND TRNS_SEQ = (" ).append("\n"); 
		query.append("    SELECT MAX(TRNS_SEQ)" ).append("\n"); 
		query.append("    FROM BKG_CSTMS_KR_BL" ).append("\n"); 
		query.append("    WHERE BKG_NO = A.BKG_NO" ).append("\n"); 
		query.append("      AND DMST_PORT_CD = A.DMST_PORT_CD" ).append("\n"); 
		query.append("      AND VSL_CD = A.VSL_CD" ).append("\n"); 
		query.append("      AND SKD_VOY_NO = A.SKD_VOY_NO" ).append("\n"); 
		query.append("      AND SKD_DIR_CD = A.SKD_DIR_CD)" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("               GROUP BY BKG_NO, CSTMS_BL_NO, CSTMS_DECL_TP_CD, DMST_PORT_CD" ).append("\n"); 
		query.append("              HAVING SUBSTR(MAX(TO_CHAR(TRNS_SEQ, '00')||NVL(DELT_FLG, 'N')), 4) != 'Y') T, BKG_CSTMS_KR_BL T2, BKG_CSTMS_KR_CNTR C" ).append("\n"); 
		query.append("        WHERE T.BKG_NO = C.BKG_NO" ).append("\n"); 
		query.append("          AND T.CSTMS_DECL_TP_CD = C.CSTMS_DECL_TP_CD" ).append("\n"); 
		query.append("          AND T.DMST_PORT_CD = C.DMST_PORT_CD" ).append("\n"); 
		query.append("          AND T.SEQ = C.TRNS_SEQ" ).append("\n"); 
		query.append("          AND T.BKG_NO = T2.BKG_NO" ).append("\n"); 
		query.append("          AND T.CSTMS_DECL_TP_CD = T2.CSTMS_DECL_TP_CD" ).append("\n"); 
		query.append("          AND T.DMST_PORT_CD = T2.DMST_PORT_CD" ).append("\n"); 
		query.append("          AND T.SEQ = T2.TRNS_SEQ" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("      	  AND T.CSTMS_BL_NO = T2.CSTMS_BL_NO" ).append("\n"); 
		query.append("          AND T2.CSTMS_BL_NO = C.CSTMS_BL_NO" ).append("\n"); 
		query.append("         	  " ).append("\n"); 
		query.append("        GROUP BY T.CSTMS_DECL_TP_CD, DECODE(T2.KR_CSTMS_BL_TP_CD, 'E', 'E', 'X'), C.CNTR_TPSZ_CD, C.CNTR_NO" ).append("\n"); 
		query.append("		)" ).append("\n"); 

	}
}