/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : CargoReleaseOrderDBDAOsearchSceMsgIdCntForCaRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.01.20
*@LastModifier : 
*@LastVersion : 1.0
* 2017.01.20 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CargoReleaseOrderDBDAOsearchSceMsgIdCntForCaRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Canada Customer 315관련 SCE 모듈 조회 쿼리
	  * </pre>
	  */
	public CargoReleaseOrderDBDAOsearchSceMsgIdCntForCaRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		query.append("Path : com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.integration").append("\n"); 
		query.append("FileName : CargoReleaseOrderDBDAOsearchSceMsgIdCntForCaRSQL").append("\n"); 
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
		query.append("" ).append("\n"); 
		query.append("       SCE_LIST.SCE_FR," ).append("\n"); 
		query.append("       COUNT(J.BL_NO) SCE_FR_CNT," ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("       SCE_LIST.SCE_OB," ).append("\n"); 
		query.append("       COUNT(K.BL_NO) SCE_OB_CNT," ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("       '' AS SCE_KND," ).append("\n"); 
		query.append("       L.EVENT_YD," ).append("\n"); 
		query.append("       TO_CHAR(GLOBALDATE_PKG.TIME_CONV_FNC(COM_ConstantMgr_PKG.COM_getBaseLocationCode_FNC,TO_DATE(L.EVENT_DT,'YYYYMMDDHH24MISS'),L.EVENT_YD),'YYYYMMDDHH24MI') AS EVENT_DT" ).append("\n"); 
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
		query.append("               CASE WHEN (A.FRT_CLT_FLG = 'Y' AND A.OBL_RDEM_FLG = 'Y') THEN 'Y' ELSE 'N' END SCE_CF" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("          FROM BKG_CGO_RLSE     A," ).append("\n"); 
		query.append("               BKG_CGO_RLSE_HIS B" ).append("\n"); 
		query.append("         WHERE A.BL_NO   = @[bl_no]" ).append("\n"); 
		query.append("           AND A.BL_NO   = B.BL_NO" ).append("\n"); 
		query.append("           AND B.HIS_SEQ = @[his_seq]" ).append("\n"); 
		query.append("       ) SCE_LIST," ).append("\n"); 
		query.append("       BKG_CGO_RLSE_EDI_SND_LOG C," ).append("\n"); 
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
		query.append("                           AND CNT_CD = 'CA'" ).append("\n"); 
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
		query.append("         " ).append("\n"); 
		query.append("   AND SCE_LIST.BL_NO           = J.BL_NO(+)" ).append("\n"); 
		query.append("   AND J.CGOR_EDI_RCVR_TP_CD(+) = 'C'" ).append("\n"); 
		query.append("   AND J.CGOR_EDI_MSG_ID(+)     = 'FR'" ).append("\n"); 
		query.append("   " ).append("\n"); 
		query.append("   AND SCE_LIST.BL_NO           = K.BL_NO(+)" ).append("\n"); 
		query.append("   AND K.CGOR_EDI_RCVR_TP_CD(+) = 'C'" ).append("\n"); 
		query.append("   AND K.CGOR_EDI_MSG_ID(+)     = 'OB'" ).append("\n"); 
		query.append("GROUP BY SCE_LIST.SCE_CF," ).append("\n"); 
		query.append("       L.EVENT_YD," ).append("\n"); 
		query.append("       L.EVENT_DT," ).append("\n"); 
		query.append("       SCE_LIST.BL_NO," ).append("\n"); 
		query.append("       SCE_LIST.FRT_CLT_FLG," ).append("\n"); 
		query.append("       SCE_LIST.OBL_RDEM_FLG" ).append("\n"); 

	}
}