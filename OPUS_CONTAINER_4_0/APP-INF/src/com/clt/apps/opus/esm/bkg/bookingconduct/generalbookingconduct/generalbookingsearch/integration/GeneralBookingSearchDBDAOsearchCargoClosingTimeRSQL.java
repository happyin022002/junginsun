/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : GeneralBookingSearchDBDAOsearchCargoClosingTimeRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.10.10
*@LastModifier : 
*@LastVersion : 1.0
* 2016.10.10 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class GeneralBookingSearchDBDAOsearchCargoClosingTimeRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  *    
	  * </pre>
	  */
	public GeneralBookingSearchDBDAOsearchCargoClosingTimeRSQL(){
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

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.integration").append("\n"); 
		query.append("FileName : GeneralBookingSearchDBDAOsearchCargoClosingTimeRSQL").append("\n"); 
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
		query.append("SELECT   NM," ).append("\n"); 
		query.append("         NMTP," ).append("\n"); 
		query.append("         CLZ_TP_CD," ).append("\n"); 
		query.append("         CLZ_YD_CD," ).append("\n"); 
		query.append("         TO_CHAR(SYS_SET_DT, 'YYYYMMDD') AS SYSTEMDATE," ).append("\n"); 
		query.append("         TO_CHAR(SYS_SET_DT, 'HH24MI') AS SYSTEMTIME," ).append("\n"); 
		query.append("         TO_CHAR(MNL_SET_DT, 'YYYYMMDD') AS MANUALUPDATE," ).append("\n"); 
		query.append("         TO_CHAR(MNL_SET_DT, 'HH24MI') AS MANUALUPDATETIME," ).append("\n"); 
		query.append("         MNL_SET_USR_ID," ).append("\n"); 
		query.append("         NTC_FLG," ).append("\n"); 
		query.append("         UPDATEBYNAME" ).append("\n"); 
		query.append("    FROM (SELECT CODE.INTG_CD_VAL_DP_SEQ," ).append("\n"); 
		query.append("                 CODE.NM," ).append("\n"); 
		query.append("                 CODE.NMTP," ).append("\n"); 
		query.append("                 CODE.CODE AS CLZ_TP_CD," ).append("\n"); 
		query.append("                 CASE" ).append("\n"); 
		query.append("                     WHEN 'M' = CODE.CODE" ).append("\n"); 
		query.append("                     AND CLZ.CLZ_YD_CD IS NULL" ).append("\n"); 
		query.append("                         THEN (SELECT MTY_PKUP_YD_CD" ).append("\n"); 
		query.append("                                 FROM BKG_BOOKING" ).append("\n"); 
		query.append("                                WHERE BKG_NO = @[bkg_no])" ).append("\n"); 
		query.append("                     ELSE CLZ.CLZ_YD_CD" ).append("\n"); 
		query.append("                 END AS CLZ_YD_CD," ).append("\n"); 
		query.append("                 CASE" ).append("\n"); 
		query.append("                     WHEN 'M' = CODE.CODE" ).append("\n"); 
		query.append("                     AND CLZ.SYS_SET_DT IS NULL" ).append("\n"); 
		query.append("                         THEN (SELECT MTY_PKUP_DT" ).append("\n"); 
		query.append("                                 FROM BKG_BOOKING" ).append("\n"); 
		query.append("                                WHERE BKG_NO = @[bkg_no])" ).append("\n"); 
		query.append("                     ELSE CLZ.SYS_SET_DT" ).append("\n"); 
		query.append("                 END AS SYS_SET_DT," ).append("\n"); 
		query.append("                 CLZ.MNL_SET_DT," ).append("\n"); 
		query.append("                 CLZ.MNL_SET_USR_ID," ).append("\n"); 
		query.append("                 CLZ.NTC_FLG," ).append("\n"); 
		query.append("                 (SELECT USR_NM" ).append("\n"); 
		query.append("                    FROM COM_USER" ).append("\n"); 
		query.append("                   WHERE USR_ID = CLZ.MNL_SET_USR_ID) AS UPDATEBYNAME" ).append("\n"); 
		query.append("            FROM BKG_CLZ_TM CLZ," ).append("\n"); 
		query.append("                 (SELECT INTG_CD_VAL_CTNT CODE," ).append("\n"); 
		query.append("                         DECODE(INTG_CD_VAL_CTNT," ).append("\n"); 
		query.append("                                'F', SUBSTR(INTG_CD_VAL_DP_DESC, 0, LENGTH(INTG_CD_VAL_DP_DESC) - 6)," ).append("\n"); 
		query.append("                                'O', SUBSTR(INTG_CD_VAL_DP_DESC, 0, LENGTH(INTG_CD_VAL_DP_DESC) - 4)," ).append("\n"); 
		query.append("                                INTG_CD_VAL_DP_DESC" ).append("\n"); 
		query.append("                               ) NM," ).append("\n"); 
		query.append("                         DECODE(INTG_CD_VAL_CTNT," ).append("\n"); 
		query.append("                                'F', SUBSTR(INTG_CD_VAL_DP_DESC, LENGTH(INTG_CD_VAL_DP_DESC) - 4, 4)," ).append("\n"); 
		query.append("                                'O', SUBSTR(INTG_CD_VAL_DP_DESC, LENGTH(INTG_CD_VAL_DP_DESC) - 2, 2)," ).append("\n"); 
		query.append("                                INTG_CD_VAL_DP_DESC" ).append("\n"); 
		query.append("                               ) NMTP," ).append("\n"); 
		query.append("                         INTG_CD_VAL_DP_SEQ" ).append("\n"); 
		query.append("                    FROM COM_INTG_CD_DTL" ).append("\n"); 
		query.append("                   WHERE INTG_CD_ID = 'CD02112'" ).append("\n"); 
		query.append("				   AND INTG_CD_VAL_CTNT != 'V') CODE" ).append("\n"); 
		query.append("           WHERE CLZ.BKG_NO(+) = @[bkg_no]" ).append("\n"); 
		query.append("             AND CLZ.CLZ_TP_CD(+) = CODE.CODE" ).append("\n"); 
		query.append("	   UNION ALL" ).append("\n"); 
		query.append("          SELECT 8 INTG_CD_VAL_DP_SEQ," ).append("\n"); 
		query.append("                 'VGM Cut-Off' NM," ).append("\n"); 
		query.append("                 'VGM Cut-Off' NMTP," ).append("\n"); 
		query.append("                 'V' CLZ_TP_CD," ).append("\n"); 
		query.append("                 BKG.POL_NOD_CD," ).append("\n"); 
		query.append("                 (SELECT BKG_GET_VGM_CUT_TM_FNC(BKG.BKG_NO)" ).append("\n"); 
		query.append("                 FROM DUAL) SYS_SET_DT," ).append("\n"); 
		query.append("                 NULL," ).append("\n"); 
		query.append("                 ''," ).append("\n"); 
		query.append("                 ''," ).append("\n"); 
		query.append("                 ''" ).append("\n"); 
		query.append("            FROM BKG_BOOKING BKG" ).append("\n"); 
		query.append("             WHERE BKG.BKG_NO(+) = @[bkg_no])" ).append("\n"); 
		query.append("ORDER BY INTG_CD_VAL_DP_SEQ" ).append("\n"); 

	}
}