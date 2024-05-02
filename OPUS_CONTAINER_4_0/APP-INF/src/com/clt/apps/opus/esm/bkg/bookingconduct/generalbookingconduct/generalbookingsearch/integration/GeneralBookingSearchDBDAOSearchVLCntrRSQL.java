/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : GeneralBookingSearchDBDAOSearchVLCntrRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.05.20
*@LastModifier : 이주현
*@LastVersion : 1.0
* 2016.05.20 이주현
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author LEE JU HYUN
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class GeneralBookingSearchDBDAOSearchVLCntrRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchVLCntr
	  * </pre>
	  */
	public GeneralBookingSearchDBDAOSearchVLCntrRSQL(){
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
		query.append("Path : com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.integration").append("\n"); 
		query.append("FileName : GeneralBookingSearchDBDAOSearchVLCntrRSQL").append("\n"); 
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
		query.append("SELECT    /*+ ORDERED */" ).append("\n"); 
		query.append("          SUBSTR(CNTR.CNTR_NO,  1,10) CNTR_NO" ).append("\n"); 
		query.append("        , SUBSTR(CNTR.CNTR_NO,11,1) CNTR_NO_PST" ).append("\n"); 
		query.append("        , CNTR.CNTR_NO          FULL_CNTR_NO" ).append("\n"); 
		query.append("        , CNTR.CNTR_TPSZ_CD     TPSZ_CD" ).append("\n"); 
		query.append("        , MVMT.MVMT_STS_CD      STS_CD" ).append("\n"); 
		query.append("        , EDI.BKG_POD_CD        POD_CD" ).append("\n"); 
		query.append("        , CNTR.PRE_STS_FLG" ).append("\n"); 
		query.append("  FROM MST_CONTAINER CNTR" ).append("\n"); 
		query.append("      , CTM_MOVEMENT MVMT " ).append("\n"); 
		query.append("        , MDM_VSL_CNTR VSL" ).append("\n"); 
		query.append("        , CTM_MVMT_EDI_MSG EDI" ).append("\n"); 
		query.append(" WHERE CNTR.CNTR_NO             = MVMT.CNTR_NO" ).append("\n"); 
		query.append("   AND CNTR.CNMV_YR             = MVMT.CNMV_YR" ).append("\n"); 
		query.append("   AND CNTR.CNMV_ID_NO          = MVMT.CNMV_ID_NO" ).append("\n"); 
		query.append("   AND CNTR.CRNT_YD_CD          LIKE @[yd_cd]||'%'" ).append("\n"); 
		query.append("   AND CNTR.CNMV_STS_CD         = 'VL'" ).append("\n"); 
		query.append("   AND MVMT.BKG_CGO_TP_CD       = 'P'" ).append("\n"); 
		query.append("   AND MVMT.PRE_STS_FLG         = 'Y'" ).append("\n"); 
		query.append("   AND MVMT.MVMT_EDI_TP_CD      = EDI.MVMT_EDI_TP_CD" ).append("\n"); 
		query.append("   AND MVMT.MVMT_EDI_MSG_TP_ID  = EDI.MVMT_EDI_MSG_TP_ID" ).append("\n"); 
		query.append("   AND MVMT.MVMT_EDI_MSG_AREA_CD= EDI.MVMT_EDI_MSG_AREA_CD" ).append("\n"); 
		query.append("   AND MVMT.MVMT_EDI_MSG_YRMONDY= EDI.MVMT_EDI_MSG_YRMONDY" ).append("\n"); 
		query.append("   AND MVMT.MVMT_EDI_MSG_SEQ    = EDI.MVMT_EDI_MSG_SEQ" ).append("\n"); 
		query.append("   AND VSL.VSL_CD            = SUBSTR(@[vvd], 0,4)" ).append("\n"); 
		query.append("   AND CASE WHEN LENGTH(NVL(MVMT.BKG_NO, 'XXXXX')) = 12 THEN" ).append("\n"); 
		query.append("              NVL((SELECT 'N'" ).append("\n"); 
		query.append("                     FROM BKG_CONTAINER BC" ).append("\n"); 
		query.append("                    WHERE MVMT.CNTR_NO   = BC.CNTR_NO" ).append("\n"); 
		query.append("                       AND MVMT.BKG_NO   = BC.BKG_NO" ).append("\n"); 
		query.append("                       AND ROWNUM        = 1), 'Y')" ).append("\n"); 
		query.append("          ELSE " ).append("\n"); 
		query.append("                 'Y'" ).append("\n"); 
		query.append("          END  = 'Y' " ).append("\n"); 
		query.append("   AND ( MVMT.CRNT_VSL_CD    = VSL.VSL_CD " ).append("\n"); 
		query.append("      OR MVMT.CALL_SGN_NO = VSL.CALL_SGN_NO" ).append("\n"); 
		query.append("      OR MVMT.LLOYD_NO    = VSL.LLOYD_NO" ).append("\n"); 
		query.append("        )" ).append("\n"); 
		query.append(" ORDER BY MVMT.CNTR_NO" ).append("\n"); 

	}
}