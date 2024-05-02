/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : ClaimMainDBDAOSearchTransferListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.08.31
*@LastModifier : 표준희
*@LastVersion : 1.0
* 2011.08.31 표준희
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.cps.cni.containercargoclaim.claimmain.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author pyojunhee
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ClaimMainDBDAOSearchTransferListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * TransferList 조회
	  * </pre>
	  */
	public ClaimMainDBDAOSearchTransferListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sch_trns_auth_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sch_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sch_date_from",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sch_date_to",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sch_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.cps.cni.containercargoclaim.claimmain.integration").append("\n"); 
		query.append("FileName : ClaimMainDBDAOSearchTransferListRSQL").append("\n"); 
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
		query.append("    DIV" ).append("\n"); 
		query.append("  , CGO_CLM_NO" ).append("\n"); 
		query.append("  , TRNS_SEQ" ).append("\n"); 
		query.append("  , CLM_AREA_CD" ).append("\n"); 
		query.append("  , CLM_MISC_NM          --STATUS" ).append("\n"); 
		query.append("  , CLM_MISC_CD" ).append("\n"); 
		query.append("  , TRNS_KNT AS TRNS_KNT --Frequency" ).append("\n"); 
		query.append("  , TRNS_FM_OFC_CD" ).append("\n"); 
		query.append("  , TRNS_FM_USR_ID" ).append("\n"); 
		query.append("  , TRNS_FM_DT" ).append("\n"); 
		query.append("  , CLM_TRNS_AUTH_CD" ).append("\n"); 
		query.append("  , CLM_TRNS_AUTH_NM" ).append("\n"); 
		query.append("  , TRNS_TO_OFC_CD" ).append("\n"); 
		query.append("  , TRNS_TO_USR_ID" ).append("\n"); 
		query.append("  , TRNS_TO_DT" ).append("\n"); 
		query.append("  , TRNS_RMK" ).append("\n"); 
		query.append("  , HDLR_USR_ID" ).append("\n"); 
		query.append("  , HDLR_OFC_CD" ).append("\n"); 
		query.append("  , ROW_NUM" ).append("\n"); 
		query.append("  , TOTAL" ).append("\n"); 
		query.append("  , TRNS_AREA_CD" ).append("\n"); 
		query.append("  , UPD_USR_ID" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("    (" ).append("\n"); 
		query.append("        SELECT" ).append("\n"); 
		query.append("            DIV" ).append("\n"); 
		query.append("          , CGO_CLM_NO" ).append("\n"); 
		query.append("          , TRNS_SEQ" ).append("\n"); 
		query.append("          , CLM_AREA_CD" ).append("\n"); 
		query.append("          , CLM_MISC_NM" ).append("\n"); 
		query.append("          , CLM_MISC_CD          " ).append("\n"); 
		query.append("          , TRNS_KNT AS TRNS_KNT " ).append("\n"); 
		query.append("          , TRNS_FM_OFC_CD" ).append("\n"); 
		query.append("          , TRNS_FM_USR_ID" ).append("\n"); 
		query.append("          , TRNS_FM_DT" ).append("\n"); 
		query.append("          , CLM_TRNS_AUTH_CD" ).append("\n"); 
		query.append("          , CLM_TRNS_AUTH_NM" ).append("\n"); 
		query.append("          , TRNS_TO_OFC_CD" ).append("\n"); 
		query.append("          , TRNS_TO_USR_ID" ).append("\n"); 
		query.append("          , TRNS_TO_DT" ).append("\n"); 
		query.append("          , TRNS_RMK" ).append("\n"); 
		query.append("          , HDLR_USR_ID" ).append("\n"); 
		query.append("          , HDLR_OFC_CD" ).append("\n"); 
		query.append("          , ROW_NUMBER () OVER (ORDER BY DIV, CGO_CLM_NO DESC) ROW_NUM" ).append("\n"); 
		query.append("          , COUNT ( *) OVER () TOTAL" ).append("\n"); 
		query.append("		  , TRNS_AREA_CD" ).append("\n"); 
		query.append("          , UPD_USR_ID" ).append("\n"); 
		query.append("        FROM" ).append("\n"); 
		query.append("            (" ).append("\n"); 
		query.append("                SELECT" ).append("\n"); 
		query.append("                    DIV" ).append("\n"); 
		query.append("                  , CGO_CLM_NO" ).append("\n"); 
		query.append("                  , TRNS_SEQ" ).append("\n"); 
		query.append("                  , CLM_AREA_CD" ).append("\n"); 
		query.append("                  , CLM_MISC_NM  " ).append("\n"); 
		query.append("				  , CLM_MISC_CD        " ).append("\n"); 
		query.append("                  , TRNS_KNT AS TRNS_KNT " ).append("\n"); 
		query.append("                  , TRNS_FM_OFC_CD" ).append("\n"); 
		query.append("                  , TRNS_FM_USR_ID" ).append("\n"); 
		query.append("                  , TRNS_FM_DT" ).append("\n"); 
		query.append("                  , CLM_TRNS_AUTH_CD" ).append("\n"); 
		query.append("				  , CLM_TRNS_AUTH_NM" ).append("\n"); 
		query.append("                  , TRNS_TO_OFC_CD" ).append("\n"); 
		query.append("                  , TRNS_TO_USR_ID" ).append("\n"); 
		query.append("                  , TRNS_TO_DT" ).append("\n"); 
		query.append("                  , TRNS_RMK" ).append("\n"); 
		query.append("				  , HDLR_USR_ID" ).append("\n"); 
		query.append("                  , HDLR_OFC_CD" ).append("\n"); 
		query.append(" 				  , TRNS_AREA_CD" ).append("\n"); 
		query.append("				  , UPD_USR_ID" ).append("\n"); 
		query.append("                FROM" ).append("\n"); 
		query.append("                    (" ).append("\n"); 
		query.append("                        SELECT" ).append("\n"); 
		query.append("                            'FROM' DIV" ).append("\n"); 
		query.append("                          , CLM.CGO_CLM_NO" ).append("\n"); 
		query.append("                          , TRNS.TRNS_SEQ" ).append("\n"); 
		query.append("                          , CLM.CLM_AREA_CD" ).append("\n"); 
		query.append("                          , MISC.CLM_MISC_NM" ).append("\n"); 
		query.append("						  , MISC.CLM_MISC_CD" ).append("\n"); 
		query.append("                          , TRNS.TRNS_KNT" ).append("\n"); 
		query.append("                          , TRNS.TRNS_FM_OFC_CD" ).append("\n"); 
		query.append("                          , TRNS.TRNS_FM_USR_ID" ).append("\n"); 
		query.append("                          , TRNS.TRNS_FM_DT" ).append("\n"); 
		query.append("                          , TRNS.CLM_TRNS_AUTH_CD" ).append("\n"); 
		query.append("						  , DECODE(TRNS.CLM_TRNS_AUTH_CD,'W','Waiting','A','Accepted','R','Rejected') AS CLM_TRNS_AUTH_NM" ).append("\n"); 
		query.append("                          , TRNS.TRNS_TO_OFC_CD" ).append("\n"); 
		query.append("                          , TRNS.TRNS_TO_USR_ID" ).append("\n"); 
		query.append("                          , TRNS.TRNS_TO_DT" ).append("\n"); 
		query.append("                          , TRNS.TRNS_RMK" ).append("\n"); 
		query.append("                          , CLM.HDLR_USR_ID" ).append("\n"); 
		query.append("                          , CLM.HDLR_OFC_CD" ).append("\n"); 
		query.append("						  , '' TRNS_AREA_CD" ).append("\n"); 
		query.append("						  , TRNS.UPD_USR_ID" ).append("\n"); 
		query.append("                        FROM" ).append("\n"); 
		query.append("                            CNI_CGO_CLM_TRNS TRNS" ).append("\n"); 
		query.append("                          , CNI_CLM_V CLM" ).append("\n"); 
		query.append("                          , (" ).append("\n"); 
		query.append("                                SELECT" ).append("\n"); 
		query.append("                                    CLM_MISC_CD" ).append("\n"); 
		query.append("                                  , CLM_MISC_NM" ).append("\n"); 
		query.append("                                FROM" ).append("\n"); 
		query.append("                                    CNI_MISC_CD" ).append("\n"); 
		query.append("                                WHERE" ).append("\n"); 
		query.append("                                    CLSS_CLM_MISC_CD = '08'" ).append("\n"); 
		query.append("                            )" ).append("\n"); 
		query.append("                            MISC" ).append("\n"); 
		query.append("                        WHERE" ).append("\n"); 
		query.append("                           1=1" ).append("\n"); 
		query.append("#if (${sch_usr_id} != '')" ).append("\n"); 
		query.append("                            AND TRNS_FM_USR_ID             = @[sch_usr_id]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${sch_ofc_cd} != '')" ).append("\n"); 
		query.append("                            AND TRNS_FM_OFC_CD         = @[sch_ofc_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${sch_trns_auth_cd} != '') " ).append("\n"); 
		query.append("                            AND TRNS.CLM_TRNS_AUTH_CD  = @[sch_trns_auth_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${sch_date_div} == 'T') " ).append("\n"); 
		query.append("                            AND TRNS.TRNS_FM_DT BETWEEN @[sch_date_from] AND @[sch_date_to]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${sch_date_div} == 'P') " ).append("\n"); 
		query.append("                            AND TRNS.TRNS_TO_DT BETWEEN @[sch_date_from] AND @[sch_date_to]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("                            AND TRNS_TO_OFC_CD        IS NULL" ).append("\n"); 
		query.append("                            AND CLM.CGO_CLM_STS_CD     = MISC.CLM_MISC_CD(+)" ).append("\n"); 
		query.append("                            AND CLM.CGO_CLM_NO         = TRNS.CGO_CLM_NO" ).append("\n"); 
		query.append("                        ORDER BY" ).append("\n"); 
		query.append("                            CLM.CGO_CLM_NO DESC" ).append("\n"); 
		query.append("                    )                " ).append("\n"); 
		query.append("                UNION ALL                " ).append("\n"); 
		query.append("                SELECT" ).append("\n"); 
		query.append("                    DIV" ).append("\n"); 
		query.append("                  , CGO_CLM_NO" ).append("\n"); 
		query.append("                  , TRNS_SEQ" ).append("\n"); 
		query.append("                  , CLM_AREA_CD" ).append("\n"); 
		query.append("                  , CLM_MISC_NM" ).append("\n"); 
		query.append("				  , CLM_MISC_CD         " ).append("\n"); 
		query.append("                  , TRNS_KNT AS TRNS_KNT " ).append("\n"); 
		query.append("                  , TRNS_FM_OFC_CD" ).append("\n"); 
		query.append("                  , TRNS_FM_USR_ID" ).append("\n"); 
		query.append("                  , TRNS_FM_DT" ).append("\n"); 
		query.append("                  , CLM_TRNS_AUTH_CD" ).append("\n"); 
		query.append("				  , CLM_TRNS_AUTH_NM" ).append("\n"); 
		query.append("                  , TRNS_TO_OFC_CD" ).append("\n"); 
		query.append("                  , TRNS_TO_USR_ID" ).append("\n"); 
		query.append("                  , TRNS_TO_DT" ).append("\n"); 
		query.append("                  , TRNS_RMK" ).append("\n"); 
		query.append("                  , HDLR_USR_ID" ).append("\n"); 
		query.append("                  , HDLR_OFC_CD" ).append("\n"); 
		query.append("				  , TRNS_AREA_CD" ).append("\n"); 
		query.append("				  , UPD_USR_ID" ).append("\n"); 
		query.append("                FROM" ).append("\n"); 
		query.append("                    (" ).append("\n"); 
		query.append("                        SELECT" ).append("\n"); 
		query.append("                            'TO' DIV" ).append("\n"); 
		query.append("                          , CLM.CGO_CLM_NO" ).append("\n"); 
		query.append("                          , TRNS.TRNS_SEQ" ).append("\n"); 
		query.append("                          , CLM.CLM_AREA_CD" ).append("\n"); 
		query.append("                          , MISC.CLM_MISC_NM" ).append("\n"); 
		query.append("						  , MISC.CLM_MISC_CD" ).append("\n"); 
		query.append("                          , TRNS.TRNS_KNT" ).append("\n"); 
		query.append("                          , TRNS.TRNS_FM_OFC_CD" ).append("\n"); 
		query.append("                          , TRNS.TRNS_FM_USR_ID" ).append("\n"); 
		query.append("                          , TRNS.TRNS_FM_DT" ).append("\n"); 
		query.append("                          , TRNS.CLM_TRNS_AUTH_CD" ).append("\n"); 
		query.append(" 						  , DECODE(TRNS.CLM_TRNS_AUTH_CD,'W','Waiting','A','Accepted','R','Rejected') AS CLM_TRNS_AUTH_NM" ).append("\n"); 
		query.append("                          , TRNS.TRNS_TO_OFC_CD" ).append("\n"); 
		query.append("                          , TRNS.TRNS_TO_USR_ID" ).append("\n"); 
		query.append("                          , TRNS.TRNS_TO_DT" ).append("\n"); 
		query.append("                          , TRNS.TRNS_RMK" ).append("\n"); 
		query.append("                          , CLM.HDLR_USR_ID" ).append("\n"); 
		query.append("                          , CLM.HDLR_OFC_CD" ).append("\n"); 
		query.append("						  , (SELECT CLM_AREA_CD" ).append("\n"); 
		query.append("                               FROM CNI_AREA_OFC" ).append("\n"); 
		query.append("                              WHERE OFC_CD = TRNS.TRNS_TO_OFC_CD) TRNS_AREA_CD" ).append("\n"); 
		query.append("						  , TRNS.UPD_USR_ID" ).append("\n"); 
		query.append("                        FROM" ).append("\n"); 
		query.append("                            CNI_CGO_CLM_TRNS TRNS" ).append("\n"); 
		query.append("                          , CNI_CLM_V CLM" ).append("\n"); 
		query.append("                          , (" ).append("\n"); 
		query.append("                                SELECT" ).append("\n"); 
		query.append("                                    CLM_MISC_CD" ).append("\n"); 
		query.append("                                  , CLM_MISC_NM" ).append("\n"); 
		query.append("                                FROM" ).append("\n"); 
		query.append("                                    CNI_MISC_CD" ).append("\n"); 
		query.append("                                WHERE" ).append("\n"); 
		query.append("                                    CLSS_CLM_MISC_CD = '08'" ).append("\n"); 
		query.append("                            )" ).append("\n"); 
		query.append("                            MISC" ).append("\n"); 
		query.append("                        WHERE" ).append("\n"); 
		query.append("                            1=1" ).append("\n"); 
		query.append("#if (${sch_ofc_cd} != '')" ).append("\n"); 
		query.append("                            AND TRNS_TO_OFC_CD             = @[sch_ofc_cd]" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("							AND TRNS_TO_OFC_CD IS NOT NULL" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${sch_trns_auth_cd} != '') " ).append("\n"); 
		query.append("                            AND TRNS.CLM_TRNS_AUTH_CD  = @[sch_trns_auth_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${sch_date_div} == 'T') " ).append("\n"); 
		query.append("                            AND TRNS.TRNS_FM_DT BETWEEN @[sch_date_from] AND @[sch_date_to]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${sch_date_div} == 'P') " ).append("\n"); 
		query.append("                            AND TRNS.TRNS_TO_DT BETWEEN @[sch_date_from] AND @[sch_date_to]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("                            AND CLM.CGO_CLM_STS_CD     = MISC.CLM_MISC_CD(+)" ).append("\n"); 
		query.append("                            AND CLM.CGO_CLM_NO         = TRNS.CGO_CLM_NO" ).append("\n"); 
		query.append("                        ORDER BY" ).append("\n"); 
		query.append("                            CLM.CGO_CLM_NO DESC" ).append("\n"); 
		query.append("                    )" ).append("\n"); 
		query.append("            )" ).append("\n"); 
		query.append("    )" ).append("\n"); 
		query.append("#if (${start_page} != '') " ).append("\n"); 
		query.append("WHERE ROW_NUM BETWEEN ${start_page} AND ${end_page}" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}