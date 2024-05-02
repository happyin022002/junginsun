/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : MarineTerminalInvoiceManageDBDAOSearchTerminalInvoiceATBDtTrunkRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.09.13
*@LastModifier : 
*@LastVersion : 1.0
* 2016.09.13 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.tes.serviceproviderinvoicemanage.marineterminalinvoicemanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class MarineTerminalInvoiceManageDBDAOSearchTerminalInvoiceATBDtTrunkRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchTerminalInvoiceATBDtTrunk
	  * 2016.07.13 VVD, YD_CD가 존재 하지 않을시에 YD_CD의 국가에 걸린 VVD의 ATB 조회 추가.
	  * </pre>
	  */
	public MarineTerminalInvoiceManageDBDAOSearchTerminalInvoiceATBDtTrunkRSQL(){
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
		params.put("yd_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.tes.serviceproviderinvoicemanage.marineterminalinvoicemanage.integration").append("\n"); 
		query.append("FileName : MarineTerminalInvoiceManageDBDAOSearchTerminalInvoiceATBDtTrunkRSQL").append("\n"); 
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
		query.append("SELECT ATB_DT" ).append("\n"); 
		query.append("  FROM (SELECT RNK_TP_CD" ).append("\n"); 
		query.append("             , ATB_DT" ).append("\n"); 
		query.append("          FROM (SELECT 1 AS RNK_TP_CD /*1순위 : 선택된 YD와 VVD의 ATB */" ).append("\n"); 
		query.append("                     , LISTAGG (ATB_DT, '#') WITHIN GROUP (ORDER BY ATB_DT) AS ATB_DT" ).append("\n"); 
		query.append("                  FROM (SELECT (SELECT DECODE(L.VSL_SVC_TP_CD,'O',DECODE((SELECT M.CRR_CD FROM MDM_VSL_CNTR M WHERE M.VSL_CD=S.VSL_CD),'TSG','H','C'),'H')" ).append("\n"); 
		query.append("                                  FROM VSK_VSL_SKD S" ).append("\n"); 
		query.append("                                     , MDM_VSL_SVC_LANE L" ).append("\n"); 
		query.append("                                 WHERE S.VSL_CD         = SUBSTR(@[vvd],1,4)" ).append("\n"); 
		query.append("                                   AND S.SKD_VOY_NO     = SUBSTR(@[vvd],5,4)" ).append("\n"); 
		query.append("                                   AND S.SKD_DIR_CD     = SUBSTR(@[vvd],9,1)" ).append("\n"); 
		query.append("                                   AND S.VSL_SLAN_CD    = L.VSL_SLAN_CD(+) " ).append("\n"); 
		query.append("                                )||'|' ||TO_CHAR(V.VPS_ETB_DT,'YYYY-MM-DD')||'|'||A.REV_YRMON ||'|'||V.CALL_YD_IND_SEQ AS ATB_DT" ).append("\n"); 
		query.append("                                --||TO_CHAR(NVL(V.ACT_BRTH_DT,V.VPS_ETB_DT),'YYYY-MM-DD')||'|'||A.REV_YRMON ATB_DT " ).append("\n"); 
		query.append("                             , ROWNUM ROW_ID" ).append("\n"); 
		query.append("                          FROM VSK_VSL_PORT_SKD V" ).append("\n"); 
		query.append("                             , AR_MST_REV_VVD A" ).append("\n"); 
		query.append("                         WHERE V.VSL_CD         = SUBSTR(@[vvd],1,4)" ).append("\n"); 
		query.append("                           AND V.SKD_VOY_NO     = SUBSTR(@[vvd],5,4)" ).append("\n"); 
		query.append("                           AND V.SKD_DIR_CD     = SUBSTR(@[vvd],9,1)" ).append("\n"); 
		query.append("                           --AND V.VPS_PORT_CD    = SUBSTR([yd_cd],1,5)" ).append("\n"); 
		query.append("                           AND V.YD_CD          = @[yd_cd]" ).append("\n"); 
		query.append("                           AND V.VSL_CD         = A.VSL_CD(+)" ).append("\n"); 
		query.append("                           AND V.SKD_VOY_NO     = A.SKD_VOY_NO(+)" ).append("\n"); 
		query.append("                           AND V.SKD_DIR_CD     = A.SKD_DIR_CD(+)" ).append("\n"); 
		query.append("                         ORDER BY V.CLPT_IND_SEQ " ).append("\n"); 
		query.append("                       )" ).append("\n"); 
		query.append("                 UNION ALL" ).append("\n"); 
		query.append("                SELECT 2 AS RNK_TP_CD /*2순위 : 선택된 YD와 VVD의 ATB + YD의 국가에 속한 VVD의 ATB*/" ).append("\n"); 
		query.append("                     , LISTAGG (ATB_DT, '#') WITHIN GROUP ( ORDER BY ATB_DT) AS ATB_DT" ).append("\n"); 
		query.append("                  FROM (SELECT (SELECT DECODE(L.VSL_SVC_TP_CD,'O',DECODE((SELECT M.CRR_CD FROM MDM_VSL_CNTR M WHERE M.VSL_CD=S.VSL_CD),'TSG','H','C'),'H')" ).append("\n"); 
		query.append("                                  FROM VSK_VSL_SKD S" ).append("\n"); 
		query.append("                                     , MDM_VSL_SVC_LANE L" ).append("\n"); 
		query.append("                                 WHERE S.VSL_CD         = SUBSTR(@[vvd],1,4)" ).append("\n"); 
		query.append("                                   AND S.SKD_VOY_NO     = SUBSTR(@[vvd],5,4)" ).append("\n"); 
		query.append("                                   AND S.SKD_DIR_CD     = SUBSTR(@[vvd],9,1)" ).append("\n"); 
		query.append("                                   AND S.VSL_SLAN_CD    = L.VSL_SLAN_CD(+) " ).append("\n"); 
		query.append("                                )||'|' ||TO_CHAR(V.VPS_ETB_DT,'YYYY-MM-DD')||'|'||A.REV_YRMON ||'|'||V.CALL_YD_IND_SEQ AS ATB_DT" ).append("\n"); 
		query.append("                                 --||TO_CHAR(NVL(V.ACT_BRTH_DT,V.VPS_ETB_DT),'YYYY-MM-DD')||'|'||A.REV_YRMON ATB_DT " ).append("\n"); 
		query.append("                             , ROWNUM ROW_ID" ).append("\n"); 
		query.append("                          FROM VSK_VSL_PORT_SKD V" ).append("\n"); 
		query.append("                             , AR_MST_REV_VVD A" ).append("\n"); 
		query.append("                         WHERE V.VSL_CD         = SUBSTR(@[vvd],1,4)" ).append("\n"); 
		query.append("                           AND V.SKD_VOY_NO     = SUBSTR(@[vvd],5,4)" ).append("\n"); 
		query.append("                           AND V.SKD_DIR_CD     = SUBSTR(@[vvd],9,1)" ).append("\n"); 
		query.append("                           AND (V.VPS_PORT_CD   = SUBSTR(@[yd_cd],1,5) OR SUBSTR(V.VPS_PORT_CD,1,2) = SUBSTR(@[yd_cd],1,2)) /*2016.07.13 존재 하지 않을시 국가에 걸린 VVD의 ATB 조회*/" ).append("\n"); 
		query.append("                           AND V.VSL_CD         = A.VSL_CD(+)" ).append("\n"); 
		query.append("                           AND V.SKD_VOY_NO     = A.SKD_VOY_NO(+)" ).append("\n"); 
		query.append("                           AND V.SKD_DIR_CD     = A.SKD_DIR_CD(+)" ).append("\n"); 
		query.append("                         ORDER BY V.CLPT_IND_SEQ " ).append("\n"); 
		query.append("                      ) " ).append("\n"); 
		query.append("               )" ).append("\n"); 
		query.append("         WHERE 1=1" ).append("\n"); 
		query.append("           AND ATB_DT IS NOT NULL " ).append("\n"); 
		query.append("         ORDER BY RNK_TP_CD /*2016.07.20 RNK_TP_CD 1 > 2 순으로 하기 위해 Ordering*/  " ).append("\n"); 
		query.append("       )" ).append("\n"); 
		query.append(" WHERE 1=1" ).append("\n"); 
		query.append("   AND ROWNUM = 1 /*첫번째의 데이타를 기준으로 한다.*/" ).append("\n"); 

	}
}