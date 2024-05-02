/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : SpecialManifestDBDAOsearchEdiSentStatusRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.08.12
*@LastModifier : 
*@LastVersion : 1.0
* 2010.08.12 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.terminaldocumentation.specialmanifest.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

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
		params.put("ui_type",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("Path : com.hanjin.apps.alps.esm.bkg.terminaldocumentation.specialmanifest.integration").append("\n"); 
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
		query.append("    CASE" ).append("\n"); 
		query.append("        WHEN 'ESM_BKG_0965' = @[ui_type] THEN /* ANRBS */" ).append("\n"); 
		query.append("            (" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                SELECT" ).append("\n"); 
		query.append("                    CASE" ).append("\n"); 
		query.append("                        WHEN TOT.TOT_CNT > 0 THEN" ).append("\n"); 
		query.append("                            CASE" ).append("\n"); 
		query.append("                                WHEN TOT.TOT_CNT = RCV.RCV_ACP_CNT THEN 'SUCCESS'" ).append("\n"); 
		query.append("                                ELSE 'FAIL'" ).append("\n"); 
		query.append("                            END" ).append("\n"); 
		query.append("                        " ).append("\n"); 
		query.append("                        ELSE ''" ).append("\n"); 
		query.append("                        " ).append("\n"); 
		query.append("                    END  ACK_RCV_STS_CD" ).append("\n"); 
		query.append("                FROM (" ).append("\n"); 
		query.append("	                    SELECT" ).append("\n"); 
		query.append("                            COUNT(*) TOT_CNT" ).append("\n"); 
		query.append("                        FROM  BKG_CSTMS_EUR_DG_SND  A" ).append("\n"); 
		query.append("                              , BKG_CSTMS_EUR_DG_EDI_RSPN B" ).append("\n"); 
		query.append("                        WHERE A.EUR_EDI_MSG_TP_ID = 'IFD'" ).append("\n"); 
		query.append("						AND   A.MSG_SND_NO > ' '" ).append("\n"); 
		query.append("						AND   A.EUR_DG_DECL_TP_CD = @[d_type]" ).append("\n"); 
		query.append("                        AND   A.VSL_CD      = SUBSTR(@[vvd_cd], 1, 4)" ).append("\n"); 
		query.append("                        AND   A.SKD_VOY_NO  = SUBSTR(@[vvd_cd], 5, 4)" ).append("\n"); 
		query.append("                        AND   A.SKD_DIR_CD  = SUBSTR(@[vvd_cd], 9, 1)" ).append("\n"); 
		query.append("                        AND   A.PORT_CD     = @[port_cd]" ).append("\n"); 
		query.append("                        AND   A.EUR_EDI_MSG_TP_ID = B.EUR_EDI_MSG_TP_ID" ).append("\n"); 
		query.append("                        AND   A.MSG_SND_NO = B.MSG_SND_NO" ).append("\n"); 
		query.append("                        AND   A.UPD_DT = (" ).append("\n"); 
		query.append("                                            SELECT MAX(A.UPD_DT)" ).append("\n"); 
		query.append("                                            FROM BKG_CSTMS_EUR_DG_SND A" ).append("\n"); 
		query.append("                                            WHERE A.EUR_EDI_MSG_TP_ID = 'IFD'" ).append("\n"); 
		query.append("											AND   A.MSG_SND_NO > ' '" ).append("\n"); 
		query.append("											AND   A.EUR_DG_DECL_TP_CD = @[d_type]" ).append("\n"); 
		query.append("                                            AND   A.VSL_CD      = SUBSTR(@[vvd_cd], 1, 4)" ).append("\n"); 
		query.append("                                            AND   A.SKD_VOY_NO  = SUBSTR(@[vvd_cd], 5, 4)" ).append("\n"); 
		query.append("                                            AND   A.SKD_DIR_CD  = SUBSTR(@[vvd_cd], 9, 1)" ).append("\n"); 
		query.append("                                            AND   A.PORT_CD     = @[port_cd]" ).append("\n"); 
		query.append("                                        )" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                        " ).append("\n"); 
		query.append("                    ) TOT" ).append("\n"); 
		query.append("                    ,(" ).append("\n"); 
		query.append("                " ).append("\n"); 
		query.append("                        SELECT" ).append("\n"); 
		query.append("                            COUNT(*) RCV_ACP_CNT" ).append("\n"); 
		query.append("                        FROM  BKG_CSTMS_EUR_DG_EDI_RSPN B" ).append("\n"); 
		query.append("                             , BKG_CSTMS_EUR_DG_RCV C" ).append("\n"); 
		query.append("                        WHERE 1=1" ).append("\n"); 
		query.append("                        AND   B.MSG_SND_NO = ( " ).append("\n"); 
		query.append("                                        SELECT MIN(MSG_SND_NO)" ).append("\n"); 
		query.append("                                        FROM BKG_CSTMS_EUR_DG_SND A" ).append("\n"); 
		query.append("                                        WHERE A.EUR_EDI_MSG_TP_ID = 'IFD'" ).append("\n"); 
		query.append("                                        AND   A.EUR_DG_DECL_TP_CD = @[d_type]" ).append("\n"); 
		query.append("                       					AND   A.VSL_CD      = SUBSTR(@[vvd_cd], 1, 4)" ).append("\n"); 
		query.append("                        				AND   A.SKD_VOY_NO  = SUBSTR(@[vvd_cd], 5, 4)" ).append("\n"); 
		query.append("                        				AND   A.SKD_DIR_CD  = SUBSTR(@[vvd_cd], 9, 1)" ).append("\n"); 
		query.append("                        				AND   A.PORT_CD     = @[port_cd]" ).append("\n"); 
		query.append("                                        AND   A.UPD_DT = (" ).append("\n"); 
		query.append("                                        " ).append("\n"); 
		query.append("                                                            SELECT MAX(UPD_DT)" ).append("\n"); 
		query.append("                                                            FROM BKG_CSTMS_EUR_DG_SND A" ).append("\n"); 
		query.append("                                                            WHERE A.EUR_EDI_MSG_TP_ID = 'IFD'" ).append("\n"); 
		query.append("                                        					AND   A.EUR_DG_DECL_TP_CD = @[d_type]" ).append("\n"); 
		query.append("                       										AND   A.VSL_CD      = SUBSTR(@[vvd_cd], 1, 4)" ).append("\n"); 
		query.append("                        									AND   A.SKD_VOY_NO  = SUBSTR(@[vvd_cd], 5, 4)" ).append("\n"); 
		query.append("                        									AND   A.SKD_DIR_CD  = SUBSTR(@[vvd_cd], 9, 1)" ).append("\n"); 
		query.append("                        									AND   A.PORT_CD     = @[port_cd]" ).append("\n"); 
		query.append("                                        " ).append("\n"); 
		query.append("                                                        )" ).append("\n"); 
		query.append("                                        )" ).append("\n"); 
		query.append("                        AND  B.EUR_EDI_MSG_TP_ID = C.EUR_EDI_MSG_TP_ID" ).append("\n"); 
		query.append("                        AND  B.MSG_SND_NO = C.MSG_RCV_NO" ).append("\n"); 
		query.append("                        AND C.ACK_RCV_STS_CD = 'A'" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                    ) RCV                                " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("            )" ).append("\n"); 
		query.append("        WHEN 'ESM_BKG_0966' = @[ui_type] THEN /* ETC */" ).append("\n"); 
		query.append("            (" ).append("\n"); 
		query.append("            	SELECT /*+ INDEX_DESC(BKG_CSTMS_EUR_DG_RCV XPKBKG_CSTMS_EUR_DG_RCV)*/ " ).append("\n"); 
		query.append("                        CASE" ).append("\n"); 
		query.append("                			WHEN MSG_RCV_NO IS NULL AND ACK_RCV_STS_CD IS NULL THEN ''" ).append("\n"); 
		query.append("                			WHEN MSG_RCV_NO IS NOT NULL AND ACK_RCV_STS_CD IS NULL THEN 'P'" ).append("\n"); 
		query.append("                			ELSE ACK_RCV_STS_CD" ).append("\n"); 
		query.append("            			END ACK_RCV_STS_CD" ).append("\n"); 
		query.append(" " ).append("\n"); 
		query.append("                FROM BKG_CSTMS_EUR_DG_RCV" ).append("\n"); 
		query.append("                WHERE EUR_EDI_MSG_TP_ID = 'IFD'" ).append("\n"); 
		query.append("                AND MSG_RCV_NO = (" ).append("\n"); 
		query.append("                                    SELECT MAX(A.MSG_SND_NO)" ).append("\n"); 
		query.append("                                    FROM BKG_CSTMS_EUR_DG_SND A" ).append("\n"); 
		query.append("                                    WHERE A.EUR_DG_DECL_TP_CD = @[d_type]" ).append("\n"); 
		query.append("                                    AND   A.VSL_CD      = SUBSTR(@[vvd_cd], 1, 4)" ).append("\n"); 
		query.append("                                    AND   A.SKD_VOY_NO  = SUBSTR(@[vvd_cd], 5, 4)" ).append("\n"); 
		query.append("                                    AND   A.SKD_DIR_CD  = SUBSTR(@[vvd_cd], 9, 1)" ).append("\n"); 
		query.append("                                    AND   A.PORT_CD     = @[port_cd]" ).append("\n"); 
		query.append("                                    AND   A.EUR_EDI_MSG_TP_ID ='IFD'" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                                )" ).append("\n"); 
		query.append("                AND ROWNUM = 1" ).append("\n"); 
		query.append("            )            " ).append("\n"); 
		query.append("    END ACK_RCV_STS_CD" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 

	}
}