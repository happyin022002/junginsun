/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : SpecialManifestDBDAOsearchEdiSentStatusRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.04.11
*@LastModifier : 
*@LastVersion : 1.0
* 2016.04.11 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.terminaldocumentation.specialmanifest.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SpecialManifestDBDAOsearchEdiSentStatusRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * EDI전송 결과를 조회 해 온다.
	  * </pre>
	  */
	public SpecialManifestDBDAOsearchEdiSentStatusRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vvd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("d_type",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("port_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.terminaldocumentation.specialmanifest.integration").append("\n"); 
		query.append("FileName : SpecialManifestDBDAOsearchEdiSentStatusRSQL").append("\n"); 
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
		query.append("SELECT" ).append("\n"); 
		query.append("#if (${ui_type} == 'ESM_BKG_0965') " ).append("\n"); 
		query.append("       (SELECT CASE WHEN TOT.SND_TOT_CNT > 0" ).append("\n"); 
		query.append("                    THEN DECODE(TOT.SND_TOT_CNT, TOT.RCV_ACP_CNT, 'SUCCESS', 'FAIL')" ).append("\n"); 
		query.append("                    ELSE ''" ).append("\n"); 
		query.append("                END ACK_RCV_STS_CD" ).append("\n"); 
		query.append("          FROM (SELECT COUNT(B.EDI_RSPN_SEQ) AS SND_TOT_CNT" ).append("\n"); 
		query.append("                      ,COUNT(C.RCV_LOG_SEQ)  AS RCV_ACP_CNT" ).append("\n"); 
		query.append("                  FROM BKG_CSTMS_EUR_DG_SND      A" ).append("\n"); 
		query.append("                      ,BKG_CSTMS_EUR_DG_EDI_RSPN B" ).append("\n"); 
		query.append("                      ,BKG_CSTMS_EUR_DG_RCV      C" ).append("\n"); 
		query.append("                 WHERE A.EUR_EDI_MSG_TP_ID = 'IFD'" ).append("\n"); 
		query.append("                   AND A.EUR_DG_DECL_TP_CD = @[d_type]" ).append("\n"); 
		query.append("                   AND A.VSL_CD            = SUBSTR(@[vvd_cd], 1, 4)" ).append("\n"); 
		query.append("                   AND A.SKD_VOY_NO        = SUBSTR(@[vvd_cd], 5, 4)" ).append("\n"); 
		query.append("                   AND A.SKD_DIR_CD        = SUBSTR(@[vvd_cd], 9, 1)" ).append("\n"); 
		query.append("                   AND A.PORT_CD           = @[port_cd]" ).append("\n"); 
		query.append("                   AND A.EUR_EDI_MSG_TP_ID = B.EUR_EDI_MSG_TP_ID" ).append("\n"); 
		query.append("                   AND A.MSG_SND_NO        = B.MSG_SND_NO" ).append("\n"); 
		query.append("                   AND B.EUR_EDI_MSG_TP_ID = C.EUR_EDI_MSG_TP_ID(+)" ).append("\n"); 
		query.append("                   AND B.MSG_SND_NO        = C.MSG_RCV_NO(+)" ).append("\n"); 
		query.append("                   AND C.ACK_RCV_STS_CD(+) = 'A'" ).append("\n"); 
		query.append("                   AND A.MSG_SND_NO        = (SELECT MAX(A.MSG_SND_NO)" ).append("\n"); 
		query.append("                                                FROM BKG_CSTMS_EUR_DG_SND A" ).append("\n"); 
		query.append("                                               WHERE A.EUR_EDI_MSG_TP_ID = 'IFD'" ).append("\n"); 
		query.append("                                                 AND A.EUR_DG_DECL_TP_CD = @[d_type]" ).append("\n"); 
		query.append("                                                 AND A.VSL_CD            = SUBSTR(@[vvd_cd], 1, 4)" ).append("\n"); 
		query.append("                                                 AND A.SKD_VOY_NO        = SUBSTR(@[vvd_cd], 5, 4)" ).append("\n"); 
		query.append("                                                 AND A.SKD_DIR_CD        = SUBSTR(@[vvd_cd], 9, 1)" ).append("\n"); 
		query.append("                                                 AND A.PORT_CD           = @[port_cd]" ).append("\n"); 
		query.append("                                             )" ).append("\n"); 
		query.append("               ) TOT" ).append("\n"); 
		query.append("       ) ACK_RCV_STS_CD" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("       (SELECT CASE WHEN S.MSG_SND_NO IS NULL THEN ''" ).append("\n"); 
		query.append("                    WHEN S.MSG_SND_NO IS NOT NULL AND R.MSG_RCV_NO IS NULL THEN 'P'" ).append("\n"); 
		query.append("                    ELSE R.ACK_RCV_STS_CD" ).append("\n"); 
		query.append("                 END ACK_RCV_STS_CD" ).append("\n"); 
		query.append("          FROM BKG_CSTMS_EUR_DG_SND S" ).append("\n"); 
		query.append("              ,BKG_CSTMS_EUR_DG_RCV R" ).append("\n"); 
		query.append("         WHERE S.MSG_SND_NO = R.MSG_RCV_NO(+)" ).append("\n"); 
		query.append("           AND S.EUR_EDI_MSG_TP_ID = 'IFD'" ).append("\n"); 
		query.append("           AND (S.MSG_SND_NO, R.RCV_LOG_SEQ) = (SELECT MSG_RCV_NO, MAX(RCV_LOG_SEQ)" ).append("\n"); 
		query.append("                                                  FROM BKG_CSTMS_EUR_DG_RCV" ).append("\n"); 
		query.append("                                                 WHERE MSG_RCV_NO = (SELECT MAX(MSG_SND_NO)" ).append("\n"); 
		query.append("                                                                       FROM BKG_CSTMS_EUR_DG_SND" ).append("\n"); 
		query.append("                                                                      WHERE EUR_DG_DECL_TP_CD = @[d_type]" ).append("\n"); 
		query.append("                                                                        AND VSL_CD            = SUBSTR(@[vvd_cd], 1, 4)" ).append("\n"); 
		query.append("                                                                        AND SKD_VOY_NO        = SUBSTR(@[vvd_cd], 5, 4)" ).append("\n"); 
		query.append("                                                                        AND SKD_DIR_CD        = SUBSTR(@[vvd_cd], 9, 1)" ).append("\n"); 
		query.append("                                                                        AND PORT_CD           = @[port_cd]" ).append("\n"); 
		query.append("                                                                        AND EUR_EDI_MSG_TP_ID ='IFD'" ).append("\n"); 
		query.append("                                                                    )" ).append("\n"); 
		query.append("                                                 GROUP BY MSG_RCV_NO" ).append("\n"); 
		query.append("                                               )" ).append("\n"); 
		query.append("       ) ACK_RCV_STS_CD" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("  FROM DUAL" ).append("\n"); 

	}
}