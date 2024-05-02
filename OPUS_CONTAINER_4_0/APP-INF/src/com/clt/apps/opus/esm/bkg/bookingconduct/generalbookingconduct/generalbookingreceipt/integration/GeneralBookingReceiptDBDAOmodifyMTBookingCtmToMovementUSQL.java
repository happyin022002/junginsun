/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : GeneralBookingReceiptDBDAOmodifyMTBookingCtmToMovementUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.06.27
*@LastModifier : 이주현
*@LastVersion : 1.0
* 2016.06.27 이주현
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

public class GeneralBookingReceiptDBDAOmodifyMTBookingCtmToMovementUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Movement 정보를 Update한다.
	  * </pre>
	  */
	public GeneralBookingReceiptDBDAOmodifyMTBookingCtmToMovementUSQL(){
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
		query.append("FileName : GeneralBookingReceiptDBDAOmodifyMTBookingCtmToMovementUSQL").append("\n"); 
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
		query.append("UPDATE CTM_MOVEMENT MV" ).append("\n"); 
		query.append("SET (MV.BKG_NO, MV.BL_NO" ).append("\n"); 
		query.append("     , MV.CRNT_VSL_CD, MV.CRNT_SKD_VOY_NO, MV.CRNT_SKD_DIR_CD" ).append("\n"); 
		query.append("     , MV.TRNK_VSL_CD, MV.TRNK_SKD_VOY_NO, MV.TRNK_SKD_DIR_CD" ).append("\n"); 
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
		query.append("WHERE (MV.CNTR_NO, MV.CNMV_YR, MV.CNMV_SEQ, MV.CNMV_SPLIT_NO)" ).append("\n"); 
		query.append("IN ( SELECT SUB.CNTR_NO" ).append("\n"); 
		query.append("     	, SUBSTR(SUB.VL_ROW, 1, 4) AS CNMV_YR" ).append("\n"); 
		query.append("        , SUBSTR(SUB.VL_ROW, 5, 5) AS CNMV_SEQ" ).append("\n"); 
		query.append("        , SUBSTR(SUB.VL_ROW, 10, 3) AS CNMV_SPLIT_NO" ).append("\n"); 
		query.append("     FROM" ).append("\n"); 
		query.append("        ( SELECT CM.CNTR_NO" ).append("\n"); 
		query.append("             , ( SELECT /*+ INDEX_DESC(SCM XUK1CTM_MOVEMENT) */" ).append("\n"); 
		query.append("                       SCM.CNMV_YR||TRIM(TO_CHAR(SCM.CNMV_SEQ, '00000'))||SCM.CNMV_SPLIT_NO" ).append("\n"); 
		query.append("                 FROM CTM_MOVEMENT SCM" ).append("\n"); 
		query.append("                 WHERE CM.CNTR_NO = SCM.CNTR_NO" ).append("\n"); 
		query.append("                 AND SCM.MVMT_STS_CD = 'VL'" ).append("\n"); 
		query.append("                 AND SCM.CRNT_VSL_CD = 'XXXX'" ).append("\n"); 
		query.append("                 AND SCM.BKG_CGO_TP_CD = 'P'" ).append("\n"); 
		query.append("                 AND SUBSTR(SCM.ORG_YD_CD, 1, 5)   = BB.POL_CD" ).append("\n"); 
		query.append("                 AND SCM.CNMV_EVNT_DT BETWEEN CM.CNMV_EVNT_DT - 70 AND CM.CNMV_EVNT_DT" ).append("\n"); 
		query.append("                 AND CM.CNMV_EVNT_DT >= SCM.CNMV_EVNT_DT" ).append("\n"); 
		query.append("                 AND ROWNUM = 1) AS VL_ROW" ).append("\n"); 
		query.append("          FROM CTM_MOVEMENT CM" ).append("\n"); 
		query.append("             , BKG_BOOKING BB" ).append("\n"); 
		query.append("          WHERE CM.MVMT_STS_CD = 'VD'" ).append("\n"); 
		query.append("          AND    BB.BKG_NO = CM.BKG_NO" ).append("\n"); 
		query.append("          AND    BB.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("        ) SUB" ).append("\n"); 
		query.append("     WHERE SUB.VL_ROW IS NOT NULL" ).append("\n"); 
		query.append("  )" ).append("\n"); 

	}
}