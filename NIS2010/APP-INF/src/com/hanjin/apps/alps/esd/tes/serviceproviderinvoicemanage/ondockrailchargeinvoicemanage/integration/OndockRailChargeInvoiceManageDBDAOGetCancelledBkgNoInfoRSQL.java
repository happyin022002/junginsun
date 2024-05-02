/*=========================================================
*Copyright(c) 2018 CyberLogitec
*@FileName : OndockRailChargeInvoiceManageDBDAOGetCancelledBkgNoInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2018.03.09
*@LastModifier : 
*@LastVersion : 1.0
* 2018.03.09 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.tes.serviceproviderinvoicemanage.ondockrailchargeinvoicemanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class OndockRailChargeInvoiceManageDBDAOGetCancelledBkgNoInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * GetCancelledBkgNoInfo
	  * </pre>
	  */
	public OndockRailChargeInvoiceManageDBDAOGetCancelledBkgNoInfoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("wrk_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("io_bnd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("yd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_sty_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.tes.serviceproviderinvoicemanage.ondockrailchargeinvoicemanage.integration").append("\n"); 
		query.append("FileName : OndockRailChargeInvoiceManageDBDAOGetCancelledBkgNoInfoRSQL").append("\n"); 
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
		query.append("SELECT * FROM (" ).append("\n"); 
		query.append("   SELECT  B.VSL_CD," ).append("\n"); 
		query.append("     B.SKD_VOY_NO," ).append("\n"); 
		query.append("     B.SKD_DIR_CD," ).append("\n"); 
		query.append("     O.BKG_NO," ).append("\n"); 
		query.append("     B.BL_NO," ).append("\n"); 
		query.append("     O.EQ_NO," ).append("\n"); 
		query.append("     O.EQ_TPSZ_CD," ).append("\n"); 
		query.append("     O.CGO_TP_CD MT," ).append("\n"); 
		query.append("     O.FM_NOD_CD," ).append("\n"); 
		query.append("     O.TO_NOD_CD" ).append("\n"); 
		query.append("   FROM   TRS_TRSP_RAIL_BIL_ORD O, BKG_BOOKING B, BKG_DG_CGO D, SCE_CLM U, SCE_CLM V" ).append("\n"); 
		query.append("                 , SCE_COP_HDR H, SCE_COP_DTL D, MDM_ACTIVITY M" ).append("\n"); 
		query.append("   WHERE  1 = 1" ).append("\n"); 
		query.append("   AND    ( O.FM_NOD_CD = @[yd_cd]  OR O.TO_NOD_CD = @[yd_cd] )" ).append("\n"); 
		query.append("   AND    NVL(D.ACT_DT,D.ESTM_DT) >= TO_DATE(REPLACE(SUBSTR(@[wrk_dt],1,10),'-',''),'YYYYMMDD') - 7" ).append("\n"); 
		query.append("   AND    NVL(D.ACT_DT,D.ESTM_DT) <= TO_DATE(REPLACE(SUBSTR(@[wrk_dt],1,10),'-',''),'YYYYMMDD') + 7" ).append("\n"); 
		query.append("   AND    NVL(O.DELT_FLG,'N')  <> 'Y'" ).append("\n"); 
		query.append("   AND    O.EQ_NO              = @[cntr_no]" ).append("\n"); 
		query.append("   AND    O.BKG_NO             = B.BKG_NO(+)" ).append("\n"); 
		query.append("   AND    B.BKG_STS_CD = 'X'   -- Cancelled 상태인지 확인" ).append("\n"); 
		query.append("   AND    O.BKG_NO             = D.BKG_NO(+)" ).append("\n"); 
		query.append("   AND    O.TRSP_SO_OFC_CTY_CD = U.TRSP_SO_OFC_CTY_CD(+)" ).append("\n"); 
		query.append("   AND    O.TRSP_SO_SEQ        = U.TRSP_SO_SEQ(+)" ).append("\n"); 
		query.append("   AND    O.EQ_NO              = U.CNTR_NO(+)" ).append("\n"); 
		query.append("   AND    U.CLM_SGHT_CD(+)     = 'U'" ).append("\n"); 
		query.append("   AND    O.TRSP_SO_OFC_CTY_CD = V.TRSP_SO_OFC_CTY_CD(+)" ).append("\n"); 
		query.append("   AND    O.TRSP_SO_SEQ        = V.TRSP_SO_SEQ(+)" ).append("\n"); 
		query.append("   AND    O.EQ_NO              = V.CNTR_NO(+)" ).append("\n"); 
		query.append("   AND    V.CLM_SGHT_CD(+)     = 'V'" ).append("\n"); 
		query.append("   AND    O.COP_NO = H.COP_NO" ).append("\n"); 
		query.append("   AND    H.COP_NO = D.COP_NO" ).append("\n"); 
		query.append("   AND    D.NOD_CD = @[yd_cd]" ).append("\n"); 
		query.append("   AND    D.ACT_CD = M.ACT_CD" ).append("\n"); 
		query.append("   AND    M.NOD_TP_CD = 'R' --// RAIL RAMP" ).append("\n"); 
		query.append("   AND    M.BND_VSKD_SEQ_CD = @[io_bnd_cd] --// I/O BND를 받으면 사용가능하다" ).append("\n"); 
		query.append("   --//미주지역인 경우에는 RAIL RAMP ACT중 LOAD/UNLOAD를 사용하고, 미주지역이 아닌 경우에는 Arrival/Departure를 사용한다." ).append("\n"); 
		query.append("   AND    (M.ACT_OP_TP_CD = DECODE(SUBSTR(@[yd_cd], 1, 2),'US','L','CA','L','A') OR M.ACT_OP_TP_CD = DECODE(SUBSTR(@[yd_cd], 1, 2),'US','U','CA','U','D'))         " ).append("\n"); 
		query.append("   AND    O.CGO_TP_CD = @[cntr_sty_cd] " ).append("\n"); 
		query.append("   UNION ALL" ).append("\n"); 
		query.append("SELECT  B.VSL_CD," ).append("\n"); 
		query.append("     B.SKD_VOY_NO," ).append("\n"); 
		query.append("     B.SKD_DIR_CD," ).append("\n"); 
		query.append("     O.BKG_NO," ).append("\n"); 
		query.append("     B.BL_NO," ).append("\n"); 
		query.append("     O.EQ_NO," ).append("\n"); 
		query.append("     O.EQ_TPSZ_CD," ).append("\n"); 
		query.append("     O.CGO_TP_CD MT," ).append("\n"); 
		query.append("     O.FM_NOD_CD," ).append("\n"); 
		query.append("     O.TO_NOD_CD" ).append("\n"); 
		query.append("   FROM   TRS_TRSP_SVC_ORD O, BKG_BOOKING B, BKG_DG_CGO D, SCE_CLM U, SCE_CLM V" ).append("\n"); 
		query.append("                 , SCE_COP_HDR H, SCE_COP_DTL D, MDM_ACTIVITY M, TRS_TRSP_WRK_ORD WO" ).append("\n"); 
		query.append("   WHERE  1 = 1" ).append("\n"); 
		query.append("   AND    ( O.FM_NOD_CD = @[yd_cd]  OR O.TO_NOD_CD = @[yd_cd] )" ).append("\n"); 
		query.append("   AND    NVL(D.ACT_DT,D.ESTM_DT) >= TO_DATE(REPLACE(SUBSTR(@[wrk_dt],1,10),'-',''),'YYYYMMDD') - 7" ).append("\n"); 
		query.append("   AND    NVL(D.ACT_DT,D.ESTM_DT) <= TO_DATE(REPLACE(SUBSTR(@[wrk_dt],1,10),'-',''),'YYYYMMDD') + 7" ).append("\n"); 
		query.append("   AND    NVL(O.DELT_FLG,'N')  <> 'Y'" ).append("\n"); 
		query.append("   AND    O.EQ_NO              = @[cntr_no]" ).append("\n"); 
		query.append("   AND    O.BKG_NO             = B.BKG_NO(+)" ).append("\n"); 
		query.append("   AND    B.BKG_STS_CD = 'X'   -- Cancelled 상태인지 확인" ).append("\n"); 
		query.append("   AND    O.BKG_NO             = D.BKG_NO(+)" ).append("\n"); 
		query.append("   AND    O.TRSP_SO_OFC_CTY_CD = U.TRSP_SO_OFC_CTY_CD(+)" ).append("\n"); 
		query.append("   AND    O.TRSP_SO_SEQ        = U.TRSP_SO_SEQ(+)" ).append("\n"); 
		query.append("   AND    O.EQ_NO              = U.CNTR_NO(+)" ).append("\n"); 
		query.append("   AND    U.CLM_SGHT_CD(+)     = 'U'" ).append("\n"); 
		query.append("   AND    O.TRSP_SO_TP_CD      = 'Y'" ).append("\n"); 
		query.append("   AND    O.TRSP_CRR_MOD_CD    IN ('RD','TR','RT')" ).append("\n"); 
		query.append("   AND    O.TRSP_COST_DTL_MOD_CD IN ('CY','DR')" ).append("\n"); 
		query.append("   AND    O.TRSP_SO_OFC_CTY_CD = V.TRSP_SO_OFC_CTY_CD(+)" ).append("\n"); 
		query.append("   AND    O.TRSP_SO_SEQ        = V.TRSP_SO_SEQ(+)" ).append("\n"); 
		query.append("   AND    O.EQ_NO              = V.CNTR_NO(+)" ).append("\n"); 
		query.append("   AND    V.CLM_SGHT_CD(+)     = 'V'" ).append("\n"); 
		query.append("   AND    O.COP_NO = H.COP_NO" ).append("\n"); 
		query.append("   AND    H.COP_NO = D.COP_NO" ).append("\n"); 
		query.append("   AND    D.NOD_CD = @[yd_cd]" ).append("\n"); 
		query.append("   AND    D.ACT_CD = M.ACT_CD" ).append("\n"); 
		query.append("   AND    WO.TRSP_WO_OFC_CTY_CD = O.TRSP_WO_OFC_CTY_CD(+)" ).append("\n"); 
		query.append("   AND    WO.TRSP_WO_SEQ = O.TRSP_WO_SEQ(+)" ).append("\n"); 
		query.append("   AND    M.NOD_TP_CD = 'R' --// RAIL RAMP" ).append("\n"); 
		query.append("   AND    M.BND_VSKD_SEQ_CD = @[io_bnd_cd] --// I/O BND를 받으면 사용가능하다" ).append("\n"); 
		query.append("   --//미주지역인 경우에는 RAIL RAMP ACT중 LOAD/UNLOAD를 사용하고, 미주지역이 아닌 경우에는 Arrival/Departure를 사용한다." ).append("\n"); 
		query.append("   AND    (M.ACT_OP_TP_CD = DECODE(SUBSTR(@[yd_cd], 1, 2),'US','L','CA','L','A') OR M.ACT_OP_TP_CD = DECODE(SUBSTR(@[yd_cd], 1, 2),'US','U','CA','U','D'))" ).append("\n"); 
		query.append("   AND    O.CGO_TP_CD = @[cntr_sty_cd]" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}