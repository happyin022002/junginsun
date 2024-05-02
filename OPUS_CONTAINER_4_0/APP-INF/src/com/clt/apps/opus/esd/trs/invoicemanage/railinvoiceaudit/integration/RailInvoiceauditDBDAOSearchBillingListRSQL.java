/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : RailInvoiceauditDBDAOSearchBillingListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.03.02
*@LastModifier : 
*@LastVersion : 1.0
* 2011.03.02 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.trs.invoicemanage.railinvoiceaudit.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class RailInvoiceauditDBDAOSearchBillingListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchBillingList SELECT
	  * </pre>
	  */
	public RailInvoiceauditDBDAOSearchBillingListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rail_road_code",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eq_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.trs.invoicemanage.railinvoiceaudit.integration").append("\n"); 
		query.append("FileName : RailInvoiceauditDBDAOSearchBillingListRSQL").append("\n"); 
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
		query.append("       Z.TRSP_SO_OFC_CTY_CD" ).append("\n"); 
		query.append("     , Z.TRSP_SO_SEQ" ).append("\n"); 
		query.append("     , Z.RAIL_CMB_THRU_TP_CD" ).append("\n"); 
		query.append("     , Z.CGO_TP_CD" ).append("\n"); 
		query.append("     , Z.CURR_CD" ).append("\n"); 
		query.append("     , SUM(Z.BZC_AMT)           AS BZC_AMT" ).append("\n"); 
		query.append("     , SUM(Z.FUEL_SCG_AMT)      AS FUEL_SCG_AMT" ).append("\n"); 
		query.append("     , SUM(Z.OVR_WGT_SCG_AMT)   AS OVR_WGT_SCG_AMT" ).append("\n"); 
		query.append("     , SUM(Z.HZD_MTRL_SCG_AMT)  AS HZD_MTRL_SCG_AMT" ).append("\n"); 
		query.append("     , SUM(Z.ETC_ADD_AMT)   	AS ETC_ADD_AMT" ).append("\n"); 
		query.append("     , SUM(Z.NEGO_AMT)          AS NEGO_AMT" ).append("\n"); 
		query.append("     , 0                        AS ETC_ADD_AMT" ).append("\n"); 
		query.append("     , Z.RAIL_BIL_DT" ).append("\n"); 
		query.append("     , Z.EQ_TPSZ_CD" ).append("\n"); 
		query.append("     , Z.FM_NOD_CD" ).append("\n"); 
		query.append("     , SUBSTR(Z.FM_NOD_CD, 1,5) AS FM_NOD_CD1" ).append("\n"); 
		query.append("     , SUBSTR(Z.FM_NOD_CD, 6,2) AS FM_NOD_CD2" ).append("\n"); 
		query.append("     , Z.TO_NOD_CD" ).append("\n"); 
		query.append("     , SUBSTR(Z.TO_NOD_CD, 1,5) AS TO_NOD_CD1" ).append("\n"); 
		query.append("     , SUBSTR(Z.TO_NOD_CD, 6,2) AS TO_NOD_CD2" ).append("\n"); 
		query.append("     , INV_NO" ).append("\n"); 
		query.append("     , TRSP_INV_AUD_STS_CD" ).append("\n"); 
		query.append("     , VNDR_SEQ" ).append("\n"); 
		query.append("     , VNDR_ABBR_NM" ).append("\n"); 
		query.append("     , SPCL_INSTR_RMK" ).append("\n"); 
		query.append("     , 'COM' TRSP_INV_CO_IND_CD" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("    (" ).append("\n"); 
		query.append("	 SELECT" ).append("\n"); 
		query.append("           B.TRSP_SO_OFC_CTY_CD" ).append("\n"); 
		query.append("         , B.TRSP_SO_SEQ" ).append("\n"); 
		query.append("         , A.RAIL_CMB_THRU_TP_CD" ).append("\n"); 
		query.append("         , A.CGO_TP_CD" ).append("\n"); 
		query.append("         , B.CURR_CD" ).append("\n"); 
		query.append("         , B.BZC_AMT" ).append("\n"); 
		query.append("         , B.FUEL_SCG_AMT" ).append("\n"); 
		query.append("         , B.OVR_WGT_SCG_AMT" ).append("\n"); 
		query.append("         , B.HZD_MTRL_SCG_AMT" ).append("\n"); 
		query.append("         , B.ETC_ADD_AMT" ).append("\n"); 
		query.append("         , B.NEGO_AMT" ).append("\n"); 
		query.append("         , TO_CHAR(A.LOCL_CRE_DT,'YYYYMMDD') AS RAIL_BIL_DT" ).append("\n"); 
		query.append("         , A.EQ_NO" ).append("\n"); 
		query.append("         , A.EQ_TPSZ_CD" ).append("\n"); 
		query.append("         , CASE WHEN A.RAIL_CMB_THRU_TP_CD IN('C2T','C2C','C3T') THEN" ).append("\n"); 
		query.append("          (" ).append("\n"); 
		query.append("           SELECT C.FM_NOD_CD" ).append("\n"); 
		query.append("           FROM   TRS_TRSP_RAIL_BIL_VNDR_SET C" ).append("\n"); 
		query.append("           WHERE  C.TRSP_SO_OFC_CTY_CD = B.TRSP_SO_OFC_CTY_CD" ).append("\n"); 
		query.append("           AND    C.TRSP_SO_SEQ        = B.TRSP_SO_SEQ" ).append("\n"); 
		query.append("           AND    C.SUB_RAIL_SEQ       = 1" ).append("\n"); 
		query.append("          )" ).append("\n"); 
		query.append("           WHEN A.RAIL_CMB_THRU_TP_CD IN('C3S') AND B.SUB_RAIL_SEQ IN (1, 2) THEN" ).append("\n"); 
		query.append("          (" ).append("\n"); 
		query.append("           SELECT C.FM_NOD_CD" ).append("\n"); 
		query.append("           FROM   TRS_TRSP_RAIL_BIL_VNDR_SET C" ).append("\n"); 
		query.append("           WHERE  C.TRSP_SO_OFC_CTY_CD = B.TRSP_SO_OFC_CTY_CD" ).append("\n"); 
		query.append("           AND    C.TRSP_SO_SEQ        = B.TRSP_SO_SEQ" ).append("\n"); 
		query.append("           AND    C.SUB_RAIL_SEQ       = 1" ).append("\n"); 
		query.append("          )" ).append("\n"); 
		query.append("           ELSE B.FM_NOD_CD" ).append("\n"); 
		query.append("           END FM_NOD_CD" ).append("\n"); 
		query.append("         , CASE WHEN A.RAIL_CMB_THRU_TP_CD IN('C2T','C2C') THEN" ).append("\n"); 
		query.append("          (" ).append("\n"); 
		query.append("           SELECT C.TO_NOD_CD" ).append("\n"); 
		query.append("           FROM   TRS_TRSP_RAIL_BIL_VNDR_SET C" ).append("\n"); 
		query.append("           WHERE  C.TRSP_SO_OFC_CTY_CD = B.TRSP_SO_OFC_CTY_CD" ).append("\n"); 
		query.append("           AND    C.TRSP_SO_SEQ        = B.TRSP_SO_SEQ" ).append("\n"); 
		query.append("           AND    C.SUB_RAIL_SEQ       = 2" ).append("\n"); 
		query.append("          )" ).append("\n"); 
		query.append("           WHEN A.RAIL_CMB_THRU_TP_CD IN('C3T') THEN" ).append("\n"); 
		query.append("          (" ).append("\n"); 
		query.append("           SELECT C.TO_NOD_CD" ).append("\n"); 
		query.append("           FROM   TRS_TRSP_RAIL_BIL_VNDR_SET C" ).append("\n"); 
		query.append("           WHERE  C.TRSP_SO_OFC_CTY_CD = B.TRSP_SO_OFC_CTY_CD" ).append("\n"); 
		query.append("           AND    C.TRSP_SO_SEQ        = B.TRSP_SO_SEQ" ).append("\n"); 
		query.append("           AND    C.SUB_RAIL_SEQ       = 3" ).append("\n"); 
		query.append("          )" ).append("\n"); 
		query.append("           WHEN A.RAIL_CMB_THRU_TP_CD IN('C3S') AND B.SUB_RAIL_SEQ IN (1,2) THEN" ).append("\n"); 
		query.append("          (" ).append("\n"); 
		query.append("           SELECT C.TO_NOD_CD" ).append("\n"); 
		query.append("           FROM   TRS_TRSP_RAIL_BIL_VNDR_SET C" ).append("\n"); 
		query.append("           WHERE  C.TRSP_SO_OFC_CTY_CD = B.TRSP_SO_OFC_CTY_CD" ).append("\n"); 
		query.append("           AND    C.TRSP_SO_SEQ        = B.TRSP_SO_SEQ" ).append("\n"); 
		query.append("           AND    C.SUB_RAIL_SEQ       = 2" ).append("\n"); 
		query.append("          )" ).append("\n"); 
		query.append("           ELSE B.TO_NOD_CD" ).append("\n"); 
		query.append("           END TO_NOD_CD" ).append("\n"); 
		query.append("         , D.INV_NO" ).append("\n"); 
		query.append("         , D.TRSP_INV_AUD_STS_CD" ).append("\n"); 
		query.append("         , C.VNDR_SEQ" ).append("\n"); 
		query.append("         , C.VNDR_ABBR_NM" ).append("\n"); 
		query.append("         , A.SPCL_INSTR_RMK" ).append("\n"); 
		query.append("         , E.WBL_DT" ).append("\n"); 
		query.append("     FROM  TRS_TRSP_RAIL_BIL_ORD       A" ).append("\n"); 
		query.append("         , TRS_TRSP_RAIL_BIL_VNDR_SET  B" ).append("\n"); 
		query.append("         , MDM_VENDOR                  C" ).append("\n"); 
		query.append("         , TRS_TRSP_RAIL_INV_WRK       D" ).append("\n"); 
		query.append("         , TRS_TRSP_RAIL_INV_DTL       E" ).append("\n"); 
		query.append("     WHERE A.TRSP_SO_OFC_CTY_CD  = B.TRSP_SO_OFC_CTY_CD" ).append("\n"); 
		query.append("     AND   A.TRSP_SO_SEQ         = B.TRSP_SO_SEQ" ).append("\n"); 
		query.append("     AND   A.RAIL_CMB_THRU_TP_CD IS NOT NULL" ).append("\n"); 
		query.append("     AND   B.INV_VNDR_SEQ        IS NULL" ).append("\n"); 
		query.append("     AND   B.PAIR_VNDR_SEQ       = @[rail_road_code]" ).append("\n"); 
		query.append("     AND   A.EQ_NO               = @[eq_no]" ).append("\n"); 
		query.append("     AND   A.TRSP_SO_STS_CD IN ('I','C')" ).append("\n"); 
		query.append("     AND   A.DELT_FLG            ='N'" ).append("\n"); 
		query.append("     AND   A.LOCL_CRE_DT BETWEEN ADD_MONTHS(SYSDATE, -12)" ).append("\n"); 
		query.append("     AND   SYSDATE" ).append("\n"); 
		query.append("     AND   B.PAIR_VNDR_SEQ      = C.VNDR_SEQ" ).append("\n"); 
		query.append("     AND   A.TRSP_SO_OFC_CTY_CD = E.TRSP_SO_OFC_CTY_CD(+)" ).append("\n"); 
		query.append("     AND   A.TRSP_SO_SEQ        = E.TRSP_SO_SEQ(+)	" ).append("\n"); 
		query.append("	 AND   A.EQ_NO            	= E.EQ_NO(+)	" ).append("\n"); 
		query.append("	 AND   @[rail_road_code]    = E.INV_VNDR_SEQ(+)" ).append("\n"); 
		query.append("     AND   E.INV_NO             = D.INV_NO(+)" ).append("\n"); 
		query.append("     AND   E.INV_VNDR_SEQ       = D.INV_VNDR_SEQ(+)" ).append("\n"); 
		query.append("     AND   D.DELT_FLG(+)        ='N'" ).append("\n"); 
		query.append("    ) Z" ).append("\n"); 
		query.append("GROUP BY" ).append("\n"); 
		query.append("      Z.TRSP_SO_OFC_CTY_CD" ).append("\n"); 
		query.append("    , Z.TRSP_SO_SEQ" ).append("\n"); 
		query.append("    , Z.RAIL_CMB_THRU_TP_CD" ).append("\n"); 
		query.append("    , Z.CGO_TP_CD" ).append("\n"); 
		query.append("    , Z.CURR_CD" ).append("\n"); 
		query.append("    , Z.RAIL_BIL_DT" ).append("\n"); 
		query.append("    , Z.EQ_NO" ).append("\n"); 
		query.append("    , Z.EQ_TPSZ_CD" ).append("\n"); 
		query.append("    , Z.FM_NOD_CD" ).append("\n"); 
		query.append("    , Z.TO_NOD_CD" ).append("\n"); 
		query.append("    , Z.INV_NO" ).append("\n"); 
		query.append("    , Z.TRSP_INV_AUD_STS_CD" ).append("\n"); 
		query.append("    , Z.VNDR_SEQ" ).append("\n"); 
		query.append("    , Z.VNDR_ABBR_NM" ).append("\n"); 
		query.append("    , Z.SPCL_INSTR_RMK" ).append("\n"); 

	}
}