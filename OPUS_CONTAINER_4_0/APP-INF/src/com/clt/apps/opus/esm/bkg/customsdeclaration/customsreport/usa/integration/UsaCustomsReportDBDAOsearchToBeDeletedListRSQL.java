/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : UsaCustomsReportDBDAOsearchToBeDeletedListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.02.18
*@LastModifier : 
*@LastVersion : 1.0
* 2016.02.18 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.customsreport.usa.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class UsaCustomsReportDBDAOsearchToBeDeletedListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * dwkim, 0233 B/L to be deleted 조회용
	  * </pre>
	  */
	public UsaCustomsReportDBDAOsearchToBeDeletedListRSQL(){
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
		params.put("min_seq",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("pod",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.customsreport.usa.integration").append("\n"); 
		query.append("FileName : UsaCustomsReportDBDAOsearchToBeDeletedListRSQL").append("\n"); 
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
		query.append("--2009.12.18, hadi, D.CSTMSS_POD_CD => A.CSTMS_POD_CD로 변경" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SELECT A.BL_NO ams_file_no," ).append("\n"); 
		query.append("	DECODE(NVL(A.MF_NO, 'X'), 'X', 'M', 'H') m_f," ).append("\n"); 
		query.append("	DECODE(A.MF_NO, NULL, NVL(A.CSTMS_FILE_TP_CD, '3'), '0') AS filer," ).append("\n"); 
		query.append("	NVL(A.MF_NO, A.BL_NO) mbl_no," ).append("\n"); 
		query.append("	A.VSL_CD || A.SKD_VOY_NO || A.SKD_DIR_CD t_vvd," ).append("\n"); 
		query.append("	A.POL_CD o_pol, " ).append("\n"); 
		query.append("	A.CSTMS_POL_CD t_pol," ).append("\n"); 
		query.append("	A.CSTMS_POD_CD t_pod,           " ).append("\n"); 
		query.append("	A.MF_STS_CD mf_sts, " ).append("\n"); 
		query.append("	A.CSTMS_MF_TP_CD curr_stage," ).append("\n"); 
		query.append("	DECODE(A.CSTMS_MF_TP_CD, 'MI', TO_CHAR(A.MF_SND_DT, 'YYYY-MM-DD HH24:MI'), 'AI', TO_CHAR(A.AMDT_SND_DT, 'YYYY-MM-DD HH24:MI')) update_dt," ).append("\n"); 
		query.append("	B.BKG_STS_CD sts," ).append("\n"); 
		query.append("	B.VSL_CD || B.SKD_VOY_NO || B.SKD_DIR_CD t_vvd2, " ).append("\n"); 
		query.append("	D.POL_CD t_pol2," ).append("\n"); 
		query.append("	B.USA_CSTMS_FILE_CD filer2," ).append("\n"); 
		query.append("	'Delete' user_action" ).append("\n"); 
		query.append("FROM BKG_CSTMS_ADV_BL A, BKG_BOOKING B, BKG_BL_DOC C, BKG_VVD D, VSK_VSL_PORT_SKD SKD" ).append("\n"); 
		query.append("WHERE A.CNT_CD 				= 'US' AND" ).append("\n"); 
		query.append("	(A.BL_NO) 				IN " ).append("\n"); 
		query.append("	(" ).append("\n"); 
		query.append("		SELECT A.BL_NO" ).append("\n"); 
		query.append("		FROM BKG_CSTMS_ADV_BL A, BKG_BOOKING B, BKG_VVD C" ).append("\n"); 
		query.append("		WHERE A.VSL_CD					= SUBSTR(@[vvd], 1, 4)" ).append("\n"); 
		query.append("			AND A.SKD_VOY_NO			= SUBSTR(@[vvd], 5, 4)" ).append("\n"); 
		query.append("			AND A.SKD_DIR_CD			= SUBSTR(@[vvd], 9, 1)" ).append("\n"); 
		query.append("#if (${pol} != '') " ).append("\n"); 
		query.append("			AND A.CSTMS_POL_CD				= @[pol]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("			AND A.CNT_CD 				= 'US'" ).append("\n"); 
		query.append("	        AND A.BL_NO 				= B.BL_NO" ).append("\n"); 
		query.append("			AND A.MF_STS_CD 			IN ('A', 'F')" ).append("\n"); 
		query.append("			AND NVL(A.AMDT_SND_DT, A.MF_SND_DT) IS NOT NULL" ).append("\n"); 
		query.append("			AND B.BKG_NO 				= C.BKG_NO" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("		MINUS" ).append("\n"); 
		query.append("		(" ).append("\n"); 
		query.append("			SELECT B.BL_NO" ).append("\n"); 
		query.append("			FROM BKG_VVD A, BKG_BOOKING B, BKG_BL_DOC C, BKG_CSTMS_ADV_BL D" ).append("\n"); 
		query.append("			WHERE A.VSL_CD					= SUBSTR(@[vvd], 1, 4)" ).append("\n"); 
		query.append("				AND A.SKD_VOY_NO			= SUBSTR(@[vvd], 5, 4)" ).append("\n"); 
		query.append("				AND A.SKD_DIR_CD			= SUBSTR(@[vvd], 9, 1)" ).append("\n"); 
		query.append("#if (${pol} != '') " ).append("\n"); 
		query.append("				AND A.POL_CD				= @[pol]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("				AND B.BKG_NO 				= A.BKG_NO" ).append("\n"); 
		query.append("				AND B.BKG_CGO_TP_CD 		IN ('R', 'F')" ).append("\n"); 
		query.append("				AND B.BKG_STS_CD 			NOT IN ('S', 'X')" ).append("\n"); 
		query.append("				AND C.BKG_NO 				= B.BKG_NO" ).append("\n"); 
		query.append("				AND D.CNT_CD 				= 'US'" ).append("\n"); 
		query.append("				AND B.BL_NO					= D.BL_NO" ).append("\n"); 
		query.append("				AND A.VSL_CD 				= D.VSL_CD" ).append("\n"); 
		query.append("				AND A.SKD_VOY_NO			= D.SKD_VOY_NO" ).append("\n"); 
		query.append("				AND A.SKD_DIR_CD			= D.SKD_DIR_CD" ).append("\n"); 
		query.append("			UNION ALL" ).append("\n"); 
		query.append("			SELECT G.CNTR_MF_NO" ).append("\n"); 
		query.append("			FROM BKG_VVD A, BKG_BOOKING B, BKG_BL_DOC C, BKG_HBL G, BKG_CSTMS_ADV_BL D" ).append("\n"); 
		query.append("			WHERE A.VSL_CD					= SUBSTR(@[vvd], 1, 4)" ).append("\n"); 
		query.append("				AND A.SKD_VOY_NO			= SUBSTR(@[vvd], 5, 4)" ).append("\n"); 
		query.append("				AND A.SKD_DIR_CD			= SUBSTR(@[vvd], 9, 1)" ).append("\n"); 
		query.append("#if (${pol} != '') " ).append("\n"); 
		query.append("				AND A.POL_CD				= @[pol]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("				AND B.BKG_NO 				= A.BKG_NO" ).append("\n"); 
		query.append("				AND B.BKG_CGO_TP_CD 		IN ('R', 'F')" ).append("\n"); 
		query.append("				AND B.BKG_STS_CD 			NOT IN ('S', 'X')" ).append("\n"); 
		query.append("				AND C.BKG_NO 				= B.BKG_NO" ).append("\n"); 
		query.append("				AND NVL(B.USA_CSTMS_FILE_CD, '3') = '1'" ).append("\n"); 
		query.append("				AND G.BKG_NO 				= C.BKG_NO" ).append("\n"); 
		query.append("				AND D.CNT_CD 				= 'US'" ).append("\n"); 
		query.append("				AND G.CNTR_MF_NO			= D.BL_NO" ).append("\n"); 
		query.append("				AND A.VSL_CD 				= D.VSL_CD" ).append("\n"); 
		query.append("				AND A.SKD_VOY_NO			= D.SKD_VOY_NO" ).append("\n"); 
		query.append("				AND A.SKD_DIR_CD			= D.SKD_DIR_CD" ).append("\n"); 
		query.append("		)" ).append("\n"); 
		query.append("	)" ).append("\n"); 
		query.append("	AND B.BKG_NO 				= A.BKG_NO     " ).append("\n"); 
		query.append("	AND C.BKG_NO 				= A.BKG_NO" ).append("\n"); 
		query.append("	AND D.BKG_NO 				= A.BKG_NO" ).append("\n"); 
		query.append("#if (${pod} != '') " ).append("\n"); 
		query.append("	AND A.CSTMS_POD_CD			= @[pod]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("    AND D.VSL_CD = SKD.VSL_CD" ).append("\n"); 
		query.append("    AND D.SKD_VOY_NO = SKD.SKD_VOY_NO" ).append("\n"); 
		query.append("    AND D.SKD_DIR_CD = SKD.SKD_DIR_CD" ).append("\n"); 
		query.append("    AND D.POD_CD = SKD.VPS_PORT_CD" ).append("\n"); 
		query.append("    AND SKD.CLPT_IND_SEQ = 1" ).append("\n"); 
		query.append("    AND SKD.CLPT_SEQ >= @[min_seq]" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	AND NOT EXISTS (" ).append("\n"); 
		query.append("                    SELECT 'Y'" ).append("\n"); 
		query.append("                    FROM BKG_BOOKING " ).append("\n"); 
		query.append("                    WHERE FM_BKG_NO = B.BKG_NO" ).append("\n"); 
		query.append("                    AND BL_NO_TP = '9'" ).append("\n"); 
		query.append("                )" ).append("\n"); 

	}
}