/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : GeneralBookingReceiptDBDAOmodifyMTBookingNoToMovementUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.06.23
*@LastModifier : 이주현
*@LastVersion : 1.0
* 2016.06.23 이주현
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author LEE JU HYUN
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class GeneralBookingReceiptDBDAOmodifyMTBookingNoToMovementUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * CTM Movement내 Booking No를 Update 하는 Query
	  * </pre>
	  */
	public GeneralBookingReceiptDBDAOmodifyMTBookingNoToMovementUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("upd_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.integration").append("\n"); 
		query.append("FileName : GeneralBookingReceiptDBDAOmodifyMTBookingNoToMovementUSQL").append("\n"); 
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
		query.append("UPDATE CTM_MOVEMENT MN" ).append("\n"); 
		query.append("SET  (MN.BKG_NO, MN.BL_NO" ).append("\n"); 
		query.append("     , MN.CRNT_VSL_CD, MN.CRNT_SKD_VOY_NO, MN.CRNT_SKD_DIR_CD" ).append("\n"); 
		query.append("     , MN.TRNK_VSL_CD, MN.TRNK_SKD_VOY_NO, MN.TRNK_SKD_DIR_CD" ).append("\n"); 
		query.append("     ) = ( SELECT BB.BKG_NO, BB.BKG_NO" ).append("\n"); 
		query.append("                   , BB.VSL_CD, BB.SKD_VOY_NO, BB.SKD_DIR_CD" ).append("\n"); 
		query.append("                   , BB.VSL_CD, BB.SKD_VOY_NO, BB.SKD_DIR_CD" ).append("\n"); 
		query.append("             FROM BKG_BOOKING BB" ).append("\n"); 
		query.append("            WHERE BB.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("              AND ROWNUM    = 1" ).append("\n"); 
		query.append("          )" ).append("\n"); 
		query.append("     , BKG_KNT  = 1" ).append("\n"); 
		query.append("     , MTY_REPO_VL_RMK = 'UPDATED BY BKG UPDATE SCREEN('||TO_CHAR(SYSDATE, 'YYYY.MM.DD HH24:MI:SS')||')'" ).append("\n"); 
		query.append("     , UPD_DT   = SYSDATE" ).append("\n"); 
		query.append("     , UPD_USR_ID = @[upd_usr_id]" ).append("\n"); 
		query.append("WHERE (MN.CNTR_NO, MN.CNMV_YR, MN.CNMV_ID_NO)" ).append("\n"); 
		query.append("IN (     " ).append("\n"); 
		query.append("        SELECT CM.CNTR_NO, CM.CNMV_YR, CM.CNMV_ID_NO" ).append("\n"); 
		query.append("        FROM CTM_MOVEMENT CM" ).append("\n"); 
		query.append("        WHERE CM.MVMT_STS_CD        = 'VL'" ).append("\n"); 
		query.append("        AND   CM.BKG_CGO_TP_CD      = 'P'" ).append("\n"); 
		query.append("        AND   NVL(CM.BKG_NO, 'XX') != @[bkg_no]" ).append("\n"); 
		query.append("        AND   (CM.CNTR_NO, CM.ORG_YD_CD, CM.CRNT_VSL_CD) IN (SELECT BC.CNTR_NO" ).append("\n"); 
		query.append("                                                                  , BB.POL_NOD_CD" ).append("\n"); 
		query.append("                                                                  , BB.VSL_CD" ).append("\n"); 
		query.append("                                                               FROM BKG_BOOKING BB" ).append("\n"); 
		query.append("                                                                 ,  BKG_CONTAINER BC" ).append("\n"); 
		query.append("                                                              WHERE BB.BKG_NO = BC.BKG_NO" ).append("\n"); 
		query.append("                                                                AND BB.BKG_STS_CD      = 'F'" ).append("\n"); 
		query.append("                                                                AND BB.BKG_CGO_TP_CD   = 'P'" ).append("\n"); 
		query.append("                                                                AND BB.BKG_NO          = @[bkg_no])" ).append("\n"); 
		query.append("        AND EXISTS (SELECT 'Y'" ).append("\n"); 
		query.append("                      FROM VSK_VSL_PORT_SKD SK" ).append("\n"); 
		query.append("                         , BKG_BOOKING BB" ).append("\n"); 
		query.append("                     WHERE BB.BKG_NO     = @[bkg_no]" ).append("\n"); 
		query.append("                       AND BB.VSL_CD     = SK.VSL_CD" ).append("\n"); 
		query.append("                       AND BB.SKD_VOY_NO = SK.SKD_VOY_NO" ).append("\n"); 
		query.append("                       AND BB.SKD_DIR_CD = SK.SKD_DIR_CD" ).append("\n"); 
		query.append("                       AND BB.POL_CD     = SK.VPS_PORT_CD" ).append("\n"); 
		query.append("                       AND SK.VPS_ETD_DT BETWEEN CM.CNMV_EVNT_DT - 14  AND CM.CNMV_EVNT_DT + 14" ).append("\n"); 
		query.append("                       AND ROWNUM        = 1)" ).append("\n"); 
		query.append("        UNION ALL" ).append("\n"); 
		query.append("        SELECT CM.CNTR_NO, CM.CNMV_YR, CM.CNMV_ID_NO" ).append("\n"); 
		query.append("        FROM CTM_MOVEMENT CM" ).append("\n"); 
		query.append("        WHERE CM.MVMT_STS_CD        = 'VD'" ).append("\n"); 
		query.append("        AND   CM.BKG_CGO_TP_CD      = 'P'" ).append("\n"); 
		query.append("        AND   NVL(CM.BKG_NO, 'XX') != @[bkg_no]" ).append("\n"); 
		query.append("        AND   (CM.CNTR_NO, CM.ORG_YD_CD, CM.CRNT_VSL_CD) IN (SELECT BC.CNTR_NO" ).append("\n"); 
		query.append("                                                                  , BB.POD_NOD_CD" ).append("\n"); 
		query.append("                                                                  , BB.VSL_CD" ).append("\n"); 
		query.append("                                                               FROM BKG_BOOKING BB" ).append("\n"); 
		query.append("                                                                 ,  BKG_CONTAINER BC" ).append("\n"); 
		query.append("                                                              WHERE BB.BKG_NO = BC.BKG_NO" ).append("\n"); 
		query.append("                                                                AND BB.BKG_STS_CD      = 'F'" ).append("\n"); 
		query.append("                                                                AND BB.BKG_CGO_TP_CD   = 'P'" ).append("\n"); 
		query.append("                                                                AND BB.BKG_NO          = @[bkg_no])" ).append("\n"); 
		query.append("        AND EXISTS (SELECT 'Y'" ).append("\n"); 
		query.append("                      FROM VSK_VSL_PORT_SKD SK" ).append("\n"); 
		query.append("                         , BKG_BOOKING BB" ).append("\n"); 
		query.append("                     WHERE BB.BKG_NO     = @[bkg_no]" ).append("\n"); 
		query.append("                       AND BB.VSL_CD     = SK.VSL_CD" ).append("\n"); 
		query.append("                       AND BB.SKD_VOY_NO = SK.SKD_VOY_NO" ).append("\n"); 
		query.append("                       AND BB.SKD_DIR_CD = SK.SKD_DIR_CD" ).append("\n"); 
		query.append("                       AND BB.POD_CD     = SK.VPS_PORT_CD" ).append("\n"); 
		query.append("                       AND SK.VPS_ETA_DT BETWEEN CM.CNMV_EVNT_DT - 14  AND CM.CNMV_EVNT_DT + 14" ).append("\n"); 
		query.append("                       AND ROWNUM        = 1)  " ).append("\n"); 
		query.append("        UNION ALL" ).append("\n"); 
		query.append("        SELECT CM.CNTR_NO, CM.CNMV_YR, CM.CNMV_ID_NO" ).append("\n"); 
		query.append("        FROM CTM_MOVEMENT CM" ).append("\n"); 
		query.append("        WHERE CM.MVMT_STS_CD        = 'MT'" ).append("\n"); 
		query.append("        AND   CM.BKG_CGO_TP_CD      = 'P'" ).append("\n"); 
		query.append("        AND   NVL(CM.BKG_NO, 'XX') != @[bkg_no]" ).append("\n"); 
		query.append("        AND   (CM.CNTR_NO, CM.CNMV_EVNT_DT, CM.ORG_YD_CD, CM.TRNK_VSL_CD, CM.TRNK_SKD_VOY_NO, CM.TRNK_SKD_DIR_CD)" ).append("\n"); 
		query.append("             IN (SELECT SM.CNTR_NO, SM.CNMV_EVNT_DT, SM.ORG_YD_CD, SM.TRNK_VSL_CD, SM.TRNK_SKD_VOY_NO, SM.TRNK_SKD_DIR_CD" ).append("\n"); 
		query.append("                   FROM CTM_MOVEMENT SM" ).append("\n"); 
		query.append("                  WHERE SM.MVMT_STS_CD      = 'VD'" ).append("\n"); 
		query.append("                    AND SM.BKG_CGO_TP_CD   = 'P'" ).append("\n"); 
		query.append("                    AND (SM.CNTR_NO, SM.ORG_YD_CD, SM.CRNT_VSL_CD) IN (SELECT BC.CNTR_NO" ).append("\n"); 
		query.append("                                                                            , BB.POD_NOD_CD" ).append("\n"); 
		query.append("                                                                            , BB.VSL_CD" ).append("\n"); 
		query.append("                                                                         FROM BKG_BOOKING BB" ).append("\n"); 
		query.append("                                                                           ,  BKG_CONTAINER BC" ).append("\n"); 
		query.append("                                                                        WHERE BB.BKG_NO = BC.BKG_NO" ).append("\n"); 
		query.append("                                                                          AND BB.BKG_STS_CD      = 'F'" ).append("\n"); 
		query.append("                                                                          AND BB.BKG_CGO_TP_CD   = 'P'" ).append("\n"); 
		query.append("                                                                          AND BB.BKG_NO          = @[bkg_no])" ).append("\n"); 
		query.append("                    AND EXISTS (SELECT 'Y'" ).append("\n"); 
		query.append("                                  FROM VSK_VSL_PORT_SKD SK" ).append("\n"); 
		query.append("                                     , BKG_BOOKING BB" ).append("\n"); 
		query.append("                                 WHERE BB.BKG_NO     = @[bkg_no]" ).append("\n"); 
		query.append("                                   AND BB.VSL_CD     = SK.VSL_CD" ).append("\n"); 
		query.append("                                   AND BB.SKD_VOY_NO = SK.SKD_VOY_NO" ).append("\n"); 
		query.append("                                   AND BB.SKD_DIR_CD = SK.SKD_DIR_CD" ).append("\n"); 
		query.append("                                   AND BB.POD_CD     = SK.VPS_PORT_CD" ).append("\n"); 
		query.append("                                   AND SK.VPS_ETA_DT BETWEEN SM.CNMV_EVNT_DT - 14  AND SM.CNMV_EVNT_DT + 14" ).append("\n"); 
		query.append("                                   AND ROWNUM        = 1)  " ).append("\n"); 
		query.append("               )" ).append("\n"); 
		query.append("   )" ).append("\n"); 

	}
}