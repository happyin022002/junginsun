/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : GeneralBookingSearchDBDAOsearchCargoClosingTimeRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.04.20
*@LastModifier : 
*@LastVersion : 1.0
* 2017.04.20 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

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
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.integration").append("\n"); 
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
		query.append("         UPDATEBYNAME," ).append("\n"); 
		query.append("         SYS_SET_DT_DESC" ).append("\n"); 
		query.append("    FROM (SELECT CODE.INTG_CD_VAL_DP_SEQ," ).append("\n"); 
		query.append("                 CODE.NM," ).append("\n"); 
		query.append("                 CODE.NMTP," ).append("\n"); 
		query.append("                 CODE.CODE AS CLZ_TP_CD," ).append("\n"); 
		query.append("                 CASE" ).append("\n"); 
		query.append("                     WHEN 'M' = CODE.CODE" ).append("\n"); 
		query.append("                     AND CLZ.CLZ_YD_CD IS NULL" ).append("\n"); 
		query.append("                         THEN (SELECT MTY_PKUP_YD_CD FROM BKG_BOOKING WHERE BKG_NO = @[bkg_no])" ).append("\n"); 
		query.append("                     ELSE CLZ.CLZ_YD_CD" ).append("\n"); 
		query.append("                 END AS CLZ_YD_CD," ).append("\n"); 
		query.append("                 CASE" ).append("\n"); 
		query.append("					 WHEN 'V' = CODE.CODE " ).append("\n"); 
		query.append("                     AND (SELECT BKG_GET_VRFD_WGT_CUT_OFF_FNC(VVD.VSL_CD||VVD.SKD_VOY_NO||VVD.SKD_DIR_CD, VVD.POL_CD, TO_CHAR(VVD.POL_CLPT_IND_SEQ), VVD.POD_CD) CCT FROM BKG_VVD VVD WHERE VVD.BKG_NO = @[bkg_no] AND ROWNUM = 1) IS NOT NULL" ).append("\n"); 
		query.append("                         THEN (SELECT BKG_GET_VRFD_WGT_CUT_OFF_FNC(VVD.VSL_CD||VVD.SKD_VOY_NO||VVD.SKD_DIR_CD, VVD.POL_CD, TO_CHAR(VVD.POL_CLPT_IND_SEQ), VVD.POD_CD) CCT FROM BKG_VVD VVD WHERE VVD.BKG_NO = @[bkg_no] AND ROWNUM = 1)" ).append("\n"); 
		query.append("                     WHEN 'M' = CODE.CODE" ).append("\n"); 
		query.append("                     AND CLZ.SYS_SET_DT IS NULL" ).append("\n"); 
		query.append("                         THEN (SELECT MTY_PKUP_DT FROM BKG_BOOKING WHERE BKG_NO = @[bkg_no])" ).append("\n"); 
		query.append("					 WHEN 'D' = CODE.CODE AND 'KR' = (SELECT SUBSTR(POL_CD,1,2) FROM BKG_BOOKING WHERE BKG_NO = @[bkg_no])  " ).append("\n"); 
		query.append("										  AND (SELECT BKG_GET_DCT_CUT_OFF_FNC(VVD.VSL_CD||VVD.SKD_VOY_NO||VVD.SKD_DIR_CD, " ).append("\n"); 
		query.append("																			VVD.POL_CD, " ).append("\n"); 
		query.append("																			TO_CHAR(VVD.POL_CLPT_IND_SEQ), " ).append("\n"); 
		query.append("																			BK.POD_CD) " ).append("\n"); 
		query.append("												 FROM BKG_BOOKING BK, BKG_VVD VVD" ).append("\n"); 
		query.append("												WHERE BK.BKG_NO = VVD.BKG_NO" ).append("\n"); 
		query.append("												  AND BK.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("												  AND VVD.VSL_PRE_PST_CD IN ('S','T')" ).append("\n"); 
		query.append("												  AND BK.POL_CD = VVD.POL_CD" ).append("\n"); 
		query.append("												  AND VVD.VSL_PRE_PST_CD||VVD.VSL_SEQ = (SELECT MIN(VVD2.VSL_PRE_PST_CD||VVD2.VSL_SEQ)" ).append("\n"); 
		query.append("																		                   FROM BKG_VVD VVD2" ).append("\n"); 
		query.append("																		                  WHERE VVD.BKG_NO = VVD2.BKG_NO" ).append("\n"); 
		query.append("																	                        AND VVD.POL_CD = VVD2.POL_CD)) IS NOT NULL" ).append("\n"); 
		query.append("						 THEN (SELECT BKG_GET_DCT_CUT_OFF_FNC(VVD.VSL_CD||VVD.SKD_VOY_NO||VVD.SKD_DIR_CD, " ).append("\n"); 
		query.append("															VVD.POL_CD, " ).append("\n"); 
		query.append("															TO_CHAR(VVD.POL_CLPT_IND_SEQ), " ).append("\n"); 
		query.append("															BK.POD_CD) " ).append("\n"); 
		query.append("								 FROM BKG_BOOKING BK, BKG_VVD VVD" ).append("\n"); 
		query.append("								WHERE BK.BKG_NO = VVD.BKG_NO" ).append("\n"); 
		query.append("								  AND BK.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("								  AND VVD.VSL_PRE_PST_CD IN ('S','T')" ).append("\n"); 
		query.append("								  AND BK.POL_CD = VVD.POL_CD" ).append("\n"); 
		query.append("								  AND VVD.VSL_PRE_PST_CD||VVD.VSL_SEQ = (SELECT MIN(VVD2.VSL_PRE_PST_CD||VVD2.VSL_SEQ)" ).append("\n"); 
		query.append("														                   FROM BKG_VVD VVD2" ).append("\n"); 
		query.append("														                  WHERE VVD.BKG_NO = VVD2.BKG_NO" ).append("\n"); 
		query.append("													                        AND VVD.POL_CD = VVD2.POL_CD)" ).append("\n"); 
		query.append("								)		" ).append("\n"); 
		query.append("                     ELSE CLZ.SYS_SET_DT" ).append("\n"); 
		query.append("                 END AS SYS_SET_DT," ).append("\n"); 
		query.append("                 CLZ.MNL_SET_DT," ).append("\n"); 
		query.append("                 CLZ.MNL_SET_USR_ID," ).append("\n"); 
		query.append("                 CLZ.NTC_FLG," ).append("\n"); 
		query.append("                 (SELECT USR_NM" ).append("\n"); 
		query.append("                    FROM COM_USER" ).append("\n"); 
		query.append("                   WHERE USR_ID = CLZ.MNL_SET_USR_ID) AS UPDATEBYNAME," ).append("\n"); 
		query.append("                 CLZ.SYS_SET_DT_DESC" ).append("\n"); 
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
		query.append("                   WHERE INTG_CD_ID = 'CD02112') CODE" ).append("\n"); 
		query.append("           WHERE CLZ.BKG_NO(+) = @[bkg_no]" ).append("\n"); 
		query.append("             AND CLZ.CLZ_TP_CD(+) = CODE.CODE)" ).append("\n"); 
		query.append("ORDER BY INTG_CD_VAL_DP_SEQ" ).append("\n"); 

	}
}