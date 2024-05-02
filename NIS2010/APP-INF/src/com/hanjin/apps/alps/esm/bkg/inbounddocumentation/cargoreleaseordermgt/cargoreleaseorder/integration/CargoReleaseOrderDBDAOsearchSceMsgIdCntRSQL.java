/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : CargoReleaseOrderDBDAOsearchSceMsgIdCntRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.06.03
*@LastModifier : 
*@LastVersion : 1.0
* 2010.06.03 
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

public class CargoReleaseOrderDBDAOsearchSceMsgIdCntRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ....
	  * </pre>
	  */
	public CargoReleaseOrderDBDAOsearchSceMsgIdCntRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("old_cstms_clr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("old_obl_rdem_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bl_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("his_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.integration").append("\n"); 
		query.append("FileName : CargoReleaseOrderDBDAOsearchSceMsgIdCntRSQL").append("\n"); 
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
		query.append("SELECT SCE_LIST.SCE_CF,           " ).append("\n"); 
		query.append("       COUNT(C.BL_NO) SCE_CF_CNT, " ).append("\n"); 
		query.append("       SCE_LIST.SCE_CT," ).append("\n"); 
		query.append("       COUNT(D.BL_NO) SCE_CT_CNT," ).append("\n"); 
		query.append("       SCE_LIST.SCE_CC," ).append("\n"); 
		query.append("       COUNT(E.BL_NO) SCE_CC_CNT," ).append("\n"); 
		query.append("       SCE_LIST.SCE_CR," ).append("\n"); 
		query.append("       COUNT(F.BL_NO) SCE_CR_CNT," ).append("\n"); 
		query.append("       SCE_LIST.SCE_HR," ).append("\n"); 
		query.append("       COUNT(G.BL_NO) SCE_HR_CNT," ).append("\n"); 
		query.append("       SCE_LIST.SCE_PA," ).append("\n"); 
		query.append("       COUNT(H.BL_NO) SCE_PA_CNT," ).append("\n"); 
		query.append("       SCE_LIST.SCE_PQ," ).append("\n"); 
		query.append("       COUNT(I.BL_NO) SCE_PQ_CNT," ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("       SCE_LIST.SCE_FR," ).append("\n"); 
		query.append("       COUNT(J.BL_NO) SCE_FR_CNT," ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("       SCE_LIST.SCE_OB," ).append("\n"); 
		query.append("       COUNT(K.BL_NO) SCE_OB_CNT," ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("       '' AS SCE_KND," ).append("\n"); 
		query.append("       L.EVENT_YD," ).append("\n"); 
		query.append("       TO_CHAR(GLOBALDATE_PKG.TIME_CONV_FNC('KRSEL',TO_DATE(L.EVENT_DT,'YYYYMMDDHH24MISS'),'USNYC'),'YYYYMMDDHH24MISS') AS EVENT_DT" ).append("\n"); 
		query.append("  FROM (SELECT A.BL_NO,      " ).append("\n"); 
		query.append("               B.HIS_SEQ," ).append("\n"); 
		query.append("               B.CUST_EDI_SND_CD," ).append("\n"); 
		query.append("               A.FRT_CLT_FLG," ).append("\n"); 
		query.append("               A.OBL_RDEM_FLG," ).append("\n"); 
		query.append("               A.CSTMS_CLR_CD," ).append("\n"); 
		query.append("               A.MRN_TML_EDI_SND_FLG," ).append("\n"); 
		query.append("               A.MRN_TML_EDI_SND_CD," ).append("\n"); 
		query.append("               CASE WHEN (A.FRT_CLT_FLG = 'Y') THEN 'Y' ELSE 'N' END SCE_FR," ).append("\n"); 
		query.append("               CASE WHEN (A.OBL_RDEM_FLG = 'Y') THEN 'Y' ELSE 'N' END SCE_OB," ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("               CASE WHEN (A.FRT_CLT_FLG = 'Y' AND A.OBL_RDEM_FLG = 'Y') THEN 'Y' ELSE 'N' END SCE_CF," ).append("\n"); 
		query.append("               CASE WHEN A.CSTMS_CLR_CD IN ('Y','E','T','I','W','P')    THEN 'Y' ELSE 'N' END SCE_CT," ).append("\n"); 
		query.append("               CASE WHEN (A.OBL_RDEM_FLG <> @[old_obl_rdem_flg] OR A.CSTMS_CLR_CD <> @[old_cstms_clr_cd]) AND" ).append("\n"); 
		query.append("                         (A.OBL_RDEM_FLG = 'Y' AND A.CSTMS_CLR_CD IN ('Y','E','T','I','W','P')) THEN 'Y' ELSE 'N' END SCE_CC," ).append("\n"); 
		query.append("               CASE WHEN (A.FRT_CLT_FLG = 'Y' AND A.OBL_RDEM_FLG = 'Y' AND " ).append("\n"); 
		query.append("                          A.CSTMS_CLR_CD IN ('Y','E','T','I','W','P')) THEN 'Y' ELSE 'N' END SCE_CR," ).append("\n"); 
		query.append("               CASE WHEN A.CSTMS_CLR_CD = 'H' AND A.CSTMS_DSPO_CD IN ('1F','74','76','80','81','82') THEN 'Y' ELSE 'N' END SCE_HR," ).append("\n"); 
		query.append("               CASE WHEN A.CSTMS_CLR_CD = 'H' AND A.CSTMS_DSPO_CD = '6H' THEN 'Y' ELSE 'N' END SCE_PA," ).append("\n"); 
		query.append("               CASE WHEN A.CSTMS_CLR_CD = 'H' AND " ).append("\n"); 
		query.append("                         A.CSTMS_DSPO_CD IN ('1H','2H','3H','4H','5H','1A','4A','1X','71','72','73') THEN 'Y' ELSE 'N' END SCE_PQ" ).append("\n"); 
		query.append("          FROM BKG_CGO_RLSE     A," ).append("\n"); 
		query.append("               BKG_CGO_RLSE_HIS B," ).append("\n"); 
		query.append("               BKG_CSTMS_ADV_BL C" ).append("\n"); 
		query.append("         WHERE A.BL_NO   = @[bl_no]" ).append("\n"); 
		query.append("           AND A.BL_NO   = B.BL_NO" ).append("\n"); 
		query.append("           AND B.HIS_SEQ = @[his_seq]" ).append("\n"); 
		query.append("           AND C.CNT_CD  = 'US'" ).append("\n"); 
		query.append("           AND C.BL_NO   = A.BL_NO" ).append("\n"); 
		query.append("       ) SCE_LIST," ).append("\n"); 
		query.append("       BKG_CGO_RLSE_EDI_SND_LOG C," ).append("\n"); 
		query.append("       BKG_CGO_RLSE_EDI_SND_LOG D," ).append("\n"); 
		query.append("       BKG_CGO_RLSE_EDI_SND_LOG E," ).append("\n"); 
		query.append("       BKG_CGO_RLSE_EDI_SND_LOG F," ).append("\n"); 
		query.append("       BKG_CGO_RLSE_EDI_SND_LOG G," ).append("\n"); 
		query.append("       BKG_CGO_RLSE_EDI_SND_LOG H," ).append("\n"); 
		query.append("       BKG_CGO_RLSE_EDI_SND_LOG I," ).append("\n"); 
		query.append("       BKG_CGO_RLSE_EDI_SND_LOG J," ).append("\n"); 
		query.append("       BKG_CGO_RLSE_EDI_SND_LOG K," ).append("\n"); 
		query.append("       (SELECT NVL(EVENT_YD,BKG_EVENT_YD) AS EVENT_YD," ).append("\n"); 
		query.append("               NVL(EVENT_DT,BKG_EVENT_DT) AS EVENT_DT" ).append("\n"); 
		query.append("          FROM (       " ).append("\n"); 
		query.append("                SELECT MAX(EVENT_YD) AS EVENT_YD," ).append("\n"); 
		query.append("                       MAX(EVENT_DT) AS EVENT_DT," ).append("\n"); 
		query.append("                       MAX(BKG_EVENT_YD) AS BKG_EVENT_YD," ).append("\n"); 
		query.append("                       MAX(BKG_EVENT_DT) AS BKG_EVENT_DT" ).append("\n"); 
		query.append("                  FROM (       " ).append("\n"); 
		query.append("                        SELECT CSTMS_LOC_CD AS EVENT_YD," ).append("\n"); 
		query.append("                               TO_CHAR(SYSDATE, 'YYYYMMDDHH24MISS') AS EVENT_DT," ).append("\n"); 
		query.append("                               '' AS BKG_EVENT_YD," ).append("\n"); 
		query.append("                               '' AS BKG_EVENT_DT" ).append("\n"); 
		query.append("                          FROM BKG_CSTMS_ADV_BL " ).append("\n"); 
		query.append("                         WHERE BL_NO  = @[bl_no]" ).append("\n"); 
		query.append("                           AND CNT_CD = 'US'" ).append("\n"); 
		query.append("                        UNION ALL" ).append("\n"); 
		query.append("                        SELECT ''," ).append("\n"); 
		query.append("                               ''," ).append("\n"); 
		query.append("                               LOC.SCC_CD," ).append("\n"); 
		query.append("                               TO_CHAR(SYSDATE, 'YYYYMMDDHH24MISS')" ).append("\n"); 
		query.append("                          FROM  BKG_BOOKING BKG,   " ).append("\n"); 
		query.append("                                MDM_LOCATION LOC  " ).append("\n"); 
		query.append("                         WHERE BKG.BL_NO  = @[bl_no]" ).append("\n"); 
		query.append("                           AND BKG.DEL_CD = LOC.LOC_CD" ).append("\n"); 
		query.append("                       )" ).append("\n"); 
		query.append("                )" ).append("\n"); 
		query.append("        ) L" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(" WHERE SCE_LIST.BL_NO           = C.BL_NO(+)" ).append("\n"); 
		query.append("   AND C.CGOR_EDI_RCVR_TP_CD(+) = 'C'" ).append("\n"); 
		query.append("   AND C.CGOR_EDI_MSG_ID(+)     = 'CR'" ).append("\n"); 
		query.append("   " ).append("\n"); 
		query.append("   AND SCE_LIST.BL_NO           = D.BL_NO(+)" ).append("\n"); 
		query.append("   AND D.CGOR_EDI_RCVR_TP_CD(+) = 'C'" ).append("\n"); 
		query.append("   AND D.CGOR_EDI_MSG_ID(+)     = 'CT'" ).append("\n"); 
		query.append("   " ).append("\n"); 
		query.append("   AND SCE_LIST.BL_NO           = E.BL_NO(+)" ).append("\n"); 
		query.append("   AND E.CGOR_EDI_RCVR_TP_CD(+) = 'C'" ).append("\n"); 
		query.append("   AND E.CGOR_EDI_MSG_ID(+)     = 'CC'" ).append("\n"); 
		query.append("   " ).append("\n"); 
		query.append("   AND SCE_LIST.BL_NO           = F.BL_NO(+)" ).append("\n"); 
		query.append("   AND F.CGOR_EDI_RCVR_TP_CD(+) = 'C'" ).append("\n"); 
		query.append("   AND F.CGOR_EDI_MSG_ID(+)     = 'CU'" ).append("\n"); 
		query.append("   " ).append("\n"); 
		query.append("   AND SCE_LIST.BL_NO           = G.BL_NO(+)" ).append("\n"); 
		query.append("   AND G.CGOR_EDI_RCVR_TP_CD(+) = 'C'" ).append("\n"); 
		query.append("   AND G.CGOR_EDI_MSG_ID(+)     = 'HR'" ).append("\n"); 
		query.append("   " ).append("\n"); 
		query.append("   AND SCE_LIST.BL_NO           = H.BL_NO(+)" ).append("\n"); 
		query.append("   AND H.CGOR_EDI_RCVR_TP_CD(+) = 'C'" ).append("\n"); 
		query.append("   AND H.CGOR_EDI_MSG_ID(+)     = 'PA'" ).append("\n"); 
		query.append("   " ).append("\n"); 
		query.append("   AND SCE_LIST.BL_NO           = I.BL_NO(+)" ).append("\n"); 
		query.append("   AND I.CGOR_EDI_RCVR_TP_CD(+) = 'C'" ).append("\n"); 
		query.append("   AND I.CGOR_EDI_MSG_ID(+)     = 'PQ'" ).append("\n"); 
		query.append("   " ).append("\n"); 
		query.append("   AND SCE_LIST.BL_NO           = J.BL_NO(+)" ).append("\n"); 
		query.append("   AND J.CGOR_EDI_RCVR_TP_CD(+) = 'C'" ).append("\n"); 
		query.append("   AND J.CGOR_EDI_MSG_ID(+)     = 'FR'" ).append("\n"); 
		query.append("   " ).append("\n"); 
		query.append("   AND SCE_LIST.BL_NO           = K.BL_NO(+)" ).append("\n"); 
		query.append("   AND K.CGOR_EDI_RCVR_TP_CD(+) = 'C'" ).append("\n"); 
		query.append("   AND K.CGOR_EDI_MSG_ID(+)     = 'OB'" ).append("\n"); 
		query.append("GROUP BY SCE_LIST.SCE_CF," ).append("\n"); 
		query.append("       SCE_LIST.SCE_CT," ).append("\n"); 
		query.append("       SCE_LIST.SCE_CC," ).append("\n"); 
		query.append("       SCE_LIST.SCE_CR," ).append("\n"); 
		query.append("       SCE_LIST.SCE_HR," ).append("\n"); 
		query.append("       SCE_LIST.SCE_PA," ).append("\n"); 
		query.append("       SCE_LIST.SCE_PQ," ).append("\n"); 
		query.append("       L.EVENT_YD," ).append("\n"); 
		query.append("       L.EVENT_DT," ).append("\n"); 
		query.append("       SCE_LIST.BL_NO," ).append("\n"); 
		query.append("       SCE_LIST.FRT_CLT_FLG," ).append("\n"); 
		query.append("       SCE_LIST.OBL_RDEM_FLG" ).append("\n"); 

	}
}