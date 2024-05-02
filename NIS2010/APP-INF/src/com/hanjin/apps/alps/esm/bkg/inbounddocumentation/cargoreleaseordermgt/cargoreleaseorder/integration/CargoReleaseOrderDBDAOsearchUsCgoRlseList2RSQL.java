/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : CargoReleaseOrderDBDAOsearchUsCgoRlseList2RSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.03.28
*@LastModifier : 
*@LastVersion : 1.0
* 2016.03.28 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CargoReleaseOrderDBDAOsearchUsCgoRlseList2RSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ...
	  * </pre>
	  */
	public CargoReleaseOrderDBDAOsearchUsCgoRlseList2RSQL(){
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
		params.put("end_date",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("del_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("end_time",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("obl_rdem_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mrn_tml_edi_snd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cstms_clr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("start_time",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("hub_loc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("start_date",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("frt_clt_flg",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.integration").append("\n"); 
		query.append("FileName : CargoReleaseOrderDBDAOsearchUsCgoRlseList2RSQL").append("\n"); 
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
		query.append("SELECT /*+ LEADING(M) USE_NL(M N O P Q R) */  M.BL_NO," ).append("\n"); 
		query.append("       P.BKG_NO," ).append("\n"); 
		query.append("       N.PCK_QTY PCS_QTY," ).append("\n"); 
		query.append("       N.VSL_CD||N.SKD_VOY_NO||N.SKD_DIR_CD VVD_CD," ).append("\n"); 
		query.append("       N.CSTMS_PORT_CD AS POD_CD," ).append("\n"); 
		query.append("       P.POD_CD AS ACT_POD_CD," ).append("\n"); 
		query.append("       N.DEL_CD," ).append("\n"); 
		query.append("       N.HUB_LOC_CD HUB_CD," ).append("\n"); 
		query.append("       M.LAST_UP_DT," ).append("\n"); 
		query.append("       M.FRT_CLT_FLG," ).append("\n"); 
		query.append("       M.F_LAST_DT," ).append("\n"); 
		query.append("       M.OBL_RDEM_FLG," ).append("\n"); 
		query.append("       M.O_LAST_DT," ).append("\n"); 
		query.append("       M.CSTMS_CLR_CD," ).append("\n"); 
		query.append("       M.C_LAST_DT," ).append("\n"); 
		query.append("       M.MRN_TML_EDI_SND_CD TML_SND," ).append("\n"); 
		query.append("       M.TML_LAST_DT," ).append("\n"); 
		query.append("       ' '  PRT_IND," ).append("\n"); 
		query.append("           SUBSTR(REPLACE(REPLACE(O.CUST_NM, CHR(34), CHR(34)||CHR(34)), CHR(13)||CHR(10), ' '), 1, 20) CUST_NM," ).append("\n"); 
		query.append("       Q.INTER_RMK," ).append("\n"); 
		query.append("       NVL(Q.DO_HLD_FLG,'N') AS DO_HLD_FLG," ).append("\n"); 
		query.append("       R.BL_CPY_KNT AS OBL_TTL_KNT" ).append("\n"); 
		query.append("  FROM" ).append("\n"); 
		query.append("      (" ).append("\n"); 
		query.append("             SELECT  /*+ USE_NL(A C) */" ).append("\n"); 
		query.append("               C.BL_NO," ).append("\n"); 
		query.append("               TO_CHAR(GREATEST(NVL(C.FRT_CLT_LST_DT,TO_DATE('00010101000001','YYYYMMDDHH24MISS'))," ).append("\n"); 
		query.append("                                NVL(C.OBL_RDEM_LST_DT,TO_DATE('00010101000001','YYYYMMDDHH24MISS'))," ).append("\n"); 
		query.append("                                NVL(C.CSTMS_CLR_LST_DT,TO_DATE('00010101000001','YYYYMMDDHH24MISS'))),'DDMonRR HH24:MI', 'NLS_DATE_LANGUAGE=ENGLISH') LAST_UP_DT," ).append("\n"); 
		query.append("               C.FRT_CLT_FLG," ).append("\n"); 
		query.append("               TO_CHAR(C.FRT_CLT_LST_DT, 'DDMonRR HH24:MI', 'NLS_DATE_LANGUAGE=ENGLISH') F_LAST_DT," ).append("\n"); 
		query.append("               C.OBL_RDEM_FLG," ).append("\n"); 
		query.append("               TO_CHAR(C.OBL_RDEM_LST_DT, 'DDMonRR HH24:MI', 'NLS_DATE_LANGUAGE=ENGLISH') O_LAST_DT," ).append("\n"); 
		query.append("               C.CSTMS_CLR_CD," ).append("\n"); 
		query.append("               TO_CHAR(C.CSTMS_CLR_LST_DT, 'DDMonRR HH24:MI', 'NLS_DATE_LANGUAGE=ENGLISH') C_LAST_DT," ).append("\n"); 
		query.append("               C.MRN_TML_EDI_SND_CD," ).append("\n"); 
		query.append("               TO_CHAR(C.MRN_TML_EDI_LST_SND_DT, 'DDMonRR HH24:MI', 'NLS_DATE_LANGUAGE=ENGLISH') TML_LAST_DT," ).append("\n"); 
		query.append("               ROWNUM" ).append("\n"); 
		query.append("       FROM (SELECT  RID" ).append("\n"); 
		query.append("             FROM   (SELECT  ROWID  RID" ).append("\n"); 
		query.append("                     FROM    BKG_CGO_RLSE" ).append("\n"); 
		query.append("                     WHERE   FRT_CLT_LST_DT BETWEEN TO_DATE(@[start_date] || @[start_time] , 'YYYY-MM-DDHH24:MI') AND TO_DATE(@[end_date] || @[end_time] , 'YYYY-MM-DDHH24:MI')" ).append("\n"); 
		query.append("                     UNION ALL" ).append("\n"); 
		query.append("                     SELECT  ROWID  RID" ).append("\n"); 
		query.append("                     FROM    BKG_CGO_RLSE" ).append("\n"); 
		query.append("                     WHERE   OBL_RDEM_LST_DT BETWEEN TO_DATE(@[start_date] || @[start_time] , 'YYYY-MM-DDHH24:MI') AND TO_DATE(@[end_date] || @[end_time] , 'YYYY-MM-DDHH24:MI')" ).append("\n"); 
		query.append("                     UNION ALL" ).append("\n"); 
		query.append("                     SELECT  ROWID  RID" ).append("\n"); 
		query.append("                     FROM    BKG_CGO_RLSE" ).append("\n"); 
		query.append("                     WHERE   CSTMS_CLR_LST_DT BETWEEN TO_DATE(@[start_date] || @[start_time] , 'YYYY-MM-DDHH24:MI') AND TO_DATE(@[end_date] || @[end_time] , 'YYYY-MM-DDHH24:MI')" ).append("\n"); 
		query.append("                    )" ).append("\n"); 
		query.append("             GROUP BY RID" ).append("\n"); 
		query.append("            )  A," ).append("\n"); 
		query.append("             BKG_CGO_RLSE C" ).append("\n"); 
		query.append("       WHERE A.RID = C.ROWID" ).append("\n"); 
		query.append("      ) M," ).append("\n"); 
		query.append("       BKG_CSTMS_ADV_BL   N," ).append("\n"); 
		query.append("       BKG_CSTMS_ADV_CUST O," ).append("\n"); 
		query.append("       BKG_BOOKING        P," ).append("\n"); 
		query.append("       BKG_DO_REF         Q," ).append("\n"); 
		query.append("       BKG_BL_ISS         R" ).append("\n"); 
		query.append(" WHERE N.CNT_CD(+)     = 'US'" ).append("\n"); 
		query.append(" " ).append("\n"); 
		query.append(" " ).append("\n"); 
		query.append("#if (${vvd} != '') " ).append("\n"); 
		query.append("   AND N.VSL_CD     = SUBSTR(@[vvd], 1,4)" ).append("\n"); 
		query.append("   AND N.SKD_VOY_NO = SUBSTR(@[vvd], 5,4)" ).append("\n"); 
		query.append("   AND N.SKD_DIR_CD = SUBSTR(@[vvd], 9,1)" ).append("\n"); 
		query.append(" " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${pod_cd} != '')   " ).append("\n"); 
		query.append("   AND N.POD_CD     = @[pod_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${del_cd} != '')" ).append("\n"); 
		query.append("   AND N.DEL_CD     = @[del_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("   " ).append("\n"); 
		query.append("#if (${hub_loc_cd} != '')" ).append("\n"); 
		query.append("   AND N.HUB_LOC_CD = @[hub_loc_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${mrn_tml_edi_snd_cd} != '')" ).append("\n"); 
		query.append("   AND DECODE(NVL(M.MRN_TML_EDI_SND_CD,'N'), 'Y', 'Y', 'N') = @[mrn_tml_edi_snd_cd] " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${frt_clt_flg} != '')" ).append("\n"); 
		query.append("   AND DECODE(NVL(M.FRT_CLT_FLG       ,'N'), 'Y', 'Y', 'N') = @[frt_clt_flg]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${obl_rdem_flg} != '')" ).append("\n"); 
		query.append("   AND DECODE(NVL(M.OBL_RDEM_FLG      ,'N'), 'Y', 'Y', 'N') = @[obl_rdem_flg]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${cstms_clr_cd} != '')" ).append("\n"); 
		query.append("   AND (CASE WHEN @[cstms_clr_cd] = 'J' THEN M.CSTMS_CLR_CD" ).append("\n"); 
		query.append("          ELSE DECODE(M.CSTMS_CLR_CD,'E','Y','J','Y','T','Y','I','Y','W','Y','Y','Y','N') " ).append("\n"); 
		query.append("     END) = @[cstms_clr_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(" " ).append("\n"); 
		query.append("   AND M.BL_NO  = N.BL_NO(+)" ).append("\n"); 
		query.append("   AND O.CNT_CD(+) = 'US'" ).append("\n"); 
		query.append("   AND M.BL_NO  = O.BL_NO(+)" ).append("\n"); 
		query.append("   AND O.BKG_CUST_TP_CD = 'C'" ).append("\n"); 
		query.append("   AND M.BL_NO  = P.BL_NO" ).append("\n"); 
		query.append("   AND P.BKG_NO = Q.BKG_NO(+)" ).append("\n"); 
		query.append("   AND R.BKG_NO(+) = P.BKG_NO" ).append("\n"); 
		query.append("ORDER BY 1" ).append("\n"); 

	}
}