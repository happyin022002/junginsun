/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : IndonesiaCustomsTransmissionDBDAOSearchManifestHeaderRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.09.26
*@LastModifier : 이종길
*@LastVersion : 1.0
* 2016.09.26 이종길
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.indonesia.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Jong-Kil LEE
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class IndonesiaCustomsTransmissionDBDAOSearchManifestHeaderRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Indonesia 세관에 Manifest 신고할 내용을 download 받을 File로 생성하기 위해
	  * Header 정보를 조회한다. -- UI_BKG-0310, UI_BKG-0311
	  * </pre>
	  */
	public IndonesiaCustomsTransmissionDBDAOSearchManifestHeaderRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("vvd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bound_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pol_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.indonesia.integration").append("\n"); 
		query.append("FileName : IndonesiaCustomsTransmissionDBDAOSearchManifestHeaderRSQL").append("\n"); 
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
		query.append("SELECT A.VSL_ENG_NM," ).append("\n"); 
		query.append("       A.CALL_SGN_NO," ).append("\n"); 
		query.append("       A.VSL_RGST_CNT_CD," ).append("\n"); 
		query.append("       C.SKD_VOY_NO," ).append("\n"); 
		query.append("       C.SKD_DIR_CD," ).append("\n"); 
		query.append("       B.FIRST_CLPT_SEQ," ).append("\n"); 
		query.append("       MAX(DECODE(C.CLPT_SEQ, B.FIRST_CLPT_SEQ, C.VPS_PORT_CD, NULL)) AS FIRST_CLPT_PORT_CD," ).append("\n"); 
		query.append("       B.PORT_CLPT_SEQ," ).append("\n"); 
		query.append("       MAX(DECODE(C.CLPT_SEQ, CASE WHEN B.FIRST_CLPT_SEQ = B.PORT_CLPT_SEQ THEN B.FIRST_CLPT_SEQ" ).append("\n"); 
		query.append("                                   ELSE B.PORT_CLPT_SEQ - 1" ).append("\n"); 
		query.append("                              END, C.VPS_PORT_CD, NULL)) AS PREVIOUS_CLPT_PORT_CD," ).append("\n"); 
		query.append("       MAX(DECODE(C.CLPT_SEQ, CASE WHEN B.LAST_CLPT_SEQ = B.PORT_CLPT_SEQ THEN B.LAST_CLPT_SEQ" ).append("\n"); 
		query.append("                                   ELSE B.PORT_CLPT_SEQ + 1" ).append("\n"); 
		query.append("                              END, C.VPS_PORT_CD, NULL)) AS NEXT_CLPT_PORT_CD," ).append("\n"); 
		query.append("       B.LAST_CLPT_SEQ," ).append("\n"); 
		query.append("       MAX(DECODE(C.CLPT_SEQ, B.PORT_CLPT_SEQ, TO_CHAR(C.VPS_ETA_DT, 'YYYYMMDDHH24MISS'), NULL)) AS LAST_CLPT_ETA_DT" ).append("\n"); 
		query.append("  FROM MDM_VSL_CNTR A, " ).append("\n"); 
		query.append("       (SELECT MIN(B.CLPT_SEQ) FIRST_CLPT_SEQ," ).append("\n"); 
		query.append("               MAX(B.CLPT_SEQ) LAST_CLPT_SEQ," ).append("\n"); 
		query.append("               MIN(DECODE(B.VPS_PORT_CD, (SELECT DECODE(@[bound_cd], 'I', C.POD_CD, C.POL_CD)" ).append("\n"); 
		query.append("                                            FROM BKG_VVD C" ).append("\n"); 
		query.append("                                           WHERE B.VSL_CD = C.VSL_CD" ).append("\n"); 
		query.append("                                             AND B.SKD_VOY_NO = C.SKD_VOY_NO" ).append("\n"); 
		query.append("                                             AND B.SKD_DIR_CD = C.SKD_DIR_CD" ).append("\n"); 
		query.append("  											 #if (${bound_cd} == 'I') " ).append("\n"); 
		query.append("                                             AND POD_CD = @[pod_cd]" ).append("\n"); 
		query.append("										     #else" ).append("\n"); 
		query.append("                                             AND POL_CD = @[pol_cd]                                             " ).append("\n"); 
		query.append("											 #end" ).append("\n"); 
		query.append("                                             AND ROWNUM = 1)" ).append("\n"); 
		query.append("                                       , B.CLPT_SEQ, NULL)) AS PORT_CLPT_SEQ" ).append("\n"); 
		query.append("          FROM VSK_VSL_PORT_SKD B" ).append("\n"); 
		query.append("         WHERE 1 = 1" ).append("\n"); 
		query.append("#if (${bound_cd} == 'I') " ).append("\n"); 
		query.append("           AND B.VSL_CD = SUBSTR(@[vvd], 1, 4)" ).append("\n"); 
		query.append("           AND B.SKD_VOY_NO = SUBSTR(@[vvd], 5, 4)" ).append("\n"); 
		query.append("           AND B.SKD_DIR_CD = SUBSTR(@[vvd], 9, 1)) B," ).append("\n"); 
		query.append("#elseif (${bound_cd} == 'O') " ).append("\n"); 
		query.append("           AND B.VSL_CD(+) = SUBSTR(@[vvd], 1, 4)" ).append("\n"); 
		query.append("           AND B.SKD_VOY_NO(+) = SUBSTR(@[vvd], 5, 4)" ).append("\n"); 
		query.append("           AND B.SKD_DIR_CD(+) = SUBSTR(@[vvd], 9, 1)) B," ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("       VSK_VSL_PORT_SKD C" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(" WHERE A.VSL_CD = SUBSTR(@[vvd], 1, 4)" ).append("\n"); 
		query.append("   AND C.VSL_CD = SUBSTR(@[vvd], 1, 4)" ).append("\n"); 
		query.append("   AND C.SKD_VOY_NO = SUBSTR(@[vvd], 5, 4)" ).append("\n"); 
		query.append("   AND C.SKD_DIR_CD = SUBSTR(@[vvd], 9, 1)" ).append("\n"); 
		query.append(" GROUP BY A.VSL_ENG_NM," ).append("\n"); 
		query.append("       A.CALL_SGN_NO," ).append("\n"); 
		query.append("       A.VSL_RGST_CNT_CD," ).append("\n"); 
		query.append("       C.SKD_VOY_NO," ).append("\n"); 
		query.append("       C.SKD_DIR_CD," ).append("\n"); 
		query.append("       B.FIRST_CLPT_SEQ," ).append("\n"); 
		query.append("       B.PORT_CLPT_SEQ," ).append("\n"); 
		query.append("       B.LAST_CLPT_SEQ" ).append("\n"); 

	}
}