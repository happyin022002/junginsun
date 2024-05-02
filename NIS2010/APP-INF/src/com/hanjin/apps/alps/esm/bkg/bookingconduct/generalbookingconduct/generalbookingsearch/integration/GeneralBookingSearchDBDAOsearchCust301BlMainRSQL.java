/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : GeneralBookingSearchDBDAOsearchCust301BlMainRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.07.04
*@LastModifier : 문동선
*@LastVersion : 1.0
* 2016.07.04 문동선
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Dongsun Moon
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class GeneralBookingSearchDBDAOsearchCust301BlMainRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchCust301BlMain
	  * </pre>
	  */
	public GeneralBookingSearchDBDAOsearchCust301BlMainRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("group_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ref_code",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.integration").append("\n"); 
		query.append("FileName : GeneralBookingSearchDBDAOsearchCust301BlMainRSQL").append("\n"); 
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
		query.append("SELECT 'BKGNBR:'		|| BK.bkg_no                                                || CHR(10)" ).append("\n"); 
		query.append("	|| 'BKG_DT:'		|| TO_CHAR(BK.bkg_cre_dt, 'RRRRMMDDHH24MISS')				|| CHR(10)" ).append("\n"); 
		query.append("	|| 'BRAC:'			|| DECODE(BK.bkg_sts_cd, 'X', 'R', 'U')						|| CHR(10)" ).append("\n"); 
		query.append("	|| 'BL_NO:'			|| BK.BL_NO||BK.BL_TP_cd	                                || CHR(10)" ).append("\n"); 
		query.append("	|| 'BKG_LANE:'		|| bk.slan_cd                                               || CHR(10)" ).append("\n"); 
		query.append("	|| 'BV_LANE:'		|| n1st_vvd.slan_cd                                         || CHR(10)" ).append("\n"); 
		query.append("	|| 'TOVSL:'			|| n1st_vvd.vsl_cd											|| CHR(10)" ).append("\n"); 
		query.append("	|| 'LOYD:'			|| Replace(n1st_vsl.LLOYD_NO, '.', '')						|| CHR(10)" ).append("\n"); 
		query.append("	|| 'VSLNAME:'		|| n1st_vsl.vsl_eng_nm										|| CHR(10)" ).append("\n"); 
		query.append("	|| 'VSL_CALL_SIGN:'	|| Replace(n1st_vsl.CALL_SGN_NO, '.', '')					|| CHR(10)" ).append("\n"); 
		query.append("	|| 'VVD_REF_NO:'	|| n1st_skd.SHP_CALL_NO									    || CHR(10)" ).append("\n"); 
		query.append("	|| 'TOVOY:'			|| n1st_vvd.skd_voy_no										|| CHR(10)" ).append("\n"); 
		query.append("	|| 'TODIR:'			|| n1st_vvd.skd_dir_cd										|| CHR(10)" ).append("\n"); 
		query.append("	|| 'VSLLD:'			|| TO_CHAR(n1st_skd.vps_etd_dt, 'RRRRMMDDHH24MI')			|| CHR(10)" ).append("\n"); 
		query.append("	|| 'VSLD:'			|| TO_CHAR(last_skd.vps_eta_dt, 'RRRRMMDDHH24MI')			|| CHR(10)" ).append("\n"); 
		query.append("	|| 'OLDVSL:'		|| '    '                                                   || CHR(10)" ).append("\n"); 
		query.append("	|| 'OLDLOYD:'       || ''							                            || CHR(10)" ).append("\n"); 
		query.append("	|| 'OLDVSLNAME:'    || ''						                                || CHR(10)" ).append("\n"); 
		query.append("	|| 'OLDVSL_CALL_SIGN:'|| ''				                                        || CHR(10)" ).append("\n"); 
		query.append("	|| 'OLDVOY:'		|| '    '                                                   || CHR(10)" ).append("\n"); 
		query.append("	|| 'OLDDIR:'		|| ' '                                                      || CHR(10)" ).append("\n"); 
		query.append("	|| 'TVSL:'			|| BK.vsl_cd												|| CHR(10)" ).append("\n"); 
		query.append("	|| 'TLOYD:'			|| Replace(TVVD.LLOYD_NO, '.', '')  						|| CHR(10)" ).append("\n"); 
		query.append("	|| 'TVSLNAME:'		|| TVVD.vsl_eng_nm											|| CHR(10)" ).append("\n"); 
		query.append("	|| 'TVSL_CALL_SIGN:'|| Replace(TVVD.CALL_SGN_NO, '.', '')						|| CHR(10)" ).append("\n"); 
		query.append("	|| 'TVOY:'			|| BK.skd_voy_no											|| CHR(10)" ).append("\n"); 
		query.append("	|| 'TDIR:'			|| BK.skd_dir_cd											|| CHR(10)" ).append("\n"); 
		query.append("	|| 'POR_NAME:'		|| POR.LOC_NM												|| CHR(10)" ).append("\n"); 
		query.append("	|| 'POR_QUAL:'		|| DECODE(LENGTH(POR.LOC_AMS_PORT_CD), 4, 'D', 5, 'K', ' ')	|| CHR(10)" ).append("\n"); 
		query.append("	|| 'POR_PORT:'		|| POR.LOC_AMS_PORT_CD										|| CHR(10)" ).append("\n"); 
		query.append("	|| 'POR_UNLC:'		|| POR.LOC_CD												|| CHR(10)" ).append("\n"); 
		query.append("	|| 'POR_ETD:'		|| (SELECT to_char(MIN(ESTM_DT), 'RRRRMMDDHH24MI', 'NLS_DATE_LANGUAGE=ENGLISH') as DEL_EST_ARRIVAL_DATE" ).append("\n"); 
		query.append("							  FROM SCE_COP_HDR HDR, SCE_COP_DTL DTL" ).append("\n"); 
		query.append("							 WHERE BK.BKG_NO  = HDR.BKG_NO" ).append("\n"); 
		query.append("							   AND HDR.COP_NO = DTL.COP_NO" ).append("\n"); 
		query.append("							   AND DTL.NOD_CD = BK.POR_NOD_CD" ).append("\n"); 
		query.append("							   AND HDR.COP_STS_CD IN ('C', 'T', 'F')" ).append("\n"); 
		query.append("							   AND (DTL.ACT_CD LIKE 'FO__L_' OR  DTL.ACT_CD LIKE 'FL__L_' OR DTL.ACT_CD IN ('FORRAD','MOTZAD','FOTSDO') ))				|| CHR(10)" ).append("\n"); 
		query.append("	|| 'POL_NAME:'		|| POL.LOC_NM												|| CHR(10)" ).append("\n"); 
		query.append("	|| 'POL_QUAL:'		|| DECODE(LENGTH(POL.LOC_AMS_PORT_CD), 4, 'D', 5, 'K', ' ')	|| CHR(10)" ).append("\n"); 
		query.append("	|| 'POL_PORT:'		|| POL.LOC_AMS_PORT_CD										|| CHR(10)" ).append("\n"); 
		query.append("	|| 'POL_UNLC:'		|| POL.loc_cd												|| CHR(10)" ).append("\n"); 
		query.append("	|| 'POL_ETA:'		|| TO_CHAR(n1st_skd.vps_eta_dt, 'RRRRMMDDHH24MI')			|| CHR(10)" ).append("\n"); 
		query.append("	|| 'POL_ETD:'		|| TO_CHAR(n1st_skd.vps_etd_dt, 'RRRRMMDDHH24MI')			|| CHR(10)" ).append("\n"); 
		query.append("	|| 'POL_ETD_7:'		|| TO_CHAR(n1st_skd.vps_etd_dt + 7, 'RRRRMMDDHH24MI')		|| CHR(10)" ).append("\n"); 
		query.append("	|| 'BED:'			|| DECODE(n1st_vvd.VSL_CD, 'HJXX', TO_CHAR(ADD_MONTHS(BK.BKG_cre_DT,       1), 'YYYYMMDDHH24MI')" ).append("\n"); 
		query.append("	                                                     , TO_CHAR(ADD_MONTHS(n1st_skd.VPS_ETD_DT, 1), 'YYYYMMDDHH24MI'))|| CHR(10)" ).append("\n"); 
		query.append("	|| 'CCT:'			|| CASE WHEN BK.POR_CD = 'SGSIN' OR BK.POL_CD = 'SGSIN' THEN ''" ).append("\n"); 
		query.append("								ELSE (SELECT TO_CHAR(NVL(MNL_SET_DT, SYS_SET_DT), 'RRRRMMDDHH24MI')" ).append("\n"); 
		query.append("							  			FROM BKG_CLZ_TM CLZ" ).append("\n"); 
		query.append("							 		   WHERE BK.BKG_NO = CLZ.BKG_NO" ).append("\n"); 
		query.append("							   			 AND CLZ_TP_CD = 'T') END										|| CHR(10)" ).append("\n"); 
		query.append("	|| 'DCT:'			|| (SELECT TO_CHAR(NVL(MNL_SET_DT, SYS_SET_DT), 'RRRRMMDDHH24MI')" ).append("\n"); 
		query.append("							  FROM BKG_CLZ_TM CLZ" ).append("\n"); 
		query.append("							 WHERE BK.BKG_NO = CLZ.BKG_NO" ).append("\n"); 
		query.append("							   AND CLZ_TP_CD = 'D')												        || CHR(10)" ).append("\n"); 
		query.append("	|| 'POD_NAME:'		|| POD.LOC_NM												                    || CHR(10)" ).append("\n"); 
		query.append("	|| 'POD_QUAL:'		|| DECODE(LENGTH(POD.LOC_AMS_PORT_CD), 4, 'D', 5, 'K', ' ')		                || CHR(10)" ).append("\n"); 
		query.append("	|| 'POD_PORT:'		|| POD.LOC_AMS_PORT_CD											                || CHR(10)" ).append("\n"); 
		query.append("	|| 'POD_UNLC:'		|| POD.loc_cd												                    || CHR(10)" ).append("\n"); 
		query.append("	|| 'POD_ETA:'       || TO_CHAR(COALESCE( (SELECT MAX(ESTM_DT)" ).append("\n"); 
		query.append("                                                FROM SCE_COP_HDR H, SCE_COP_DTL D" ).append("\n"); 
		query.append("                                               WHERE BK.BKG_NO    = H.BKG_NO" ).append("\n"); 
		query.append("                                                 AND D.COP_NO  = H.COP_NO" ).append("\n"); 
		query.append("                                                 AND H.COP_STS_CD <> 'X'" ).append("\n"); 
		query.append("                                                 AND D.NOD_CD  = H.POD_NOD_CD" ).append("\n"); 
		query.append("                                                 AND D.ACT_CD     = 'FUVMAD')" ).append("\n"); 
		query.append("                                            ,(SELECT MAX(ESTM_DT)" ).append("\n"); 
		query.append("                                                FROM SCE_COP_HDR	H, SCE_COP_DTL	D" ).append("\n"); 
		query.append("                                               WHERE BK.BKG_NO    = H.BKG_NO" ).append("\n"); 
		query.append("                                                 AND D.COP_NO	 = H.COP_NO" ).append("\n"); 
		query.append("                                                 AND H.COP_STS_CD <> 'X'" ).append("\n"); 
		query.append("                                                 AND D.NOD_CD	 = H.POD_NOD_CD" ).append("\n"); 
		query.append("                                                 AND D.ACT_CD     = 'FUWMUD'" ).append("\n"); 
		query.append("                                             )" ).append("\n"); 
		query.append("                                            ,(SELECT MAX(ESTM_DT)" ).append("\n"); 
		query.append("                                                FROM SCE_COP_HDR H, SCE_COP_DTL D" ).append("\n"); 
		query.append("                                               WHERE BK.BKG_NO = H.BKG_NO" ).append("\n"); 
		query.append("                                                 AND H.COP_NO = D.COP_NO" ).append("\n"); 
		query.append("                                                 AND H.COP_STS_CD IN ('C','T','F')" ).append("\n"); 
		query.append("                                                 AND D.ACT_CD = 'FUWMAD'" ).append("\n"); 
		query.append("                                                 AND @[group_id] IN (SELECT ATTR_CTNT1" ).append("\n"); 
		query.append("                                                                       FROM BKG_HRD_CDG_CTNT" ).append("\n"); 
		query.append("                                                                      WHERE HRD_CDG_ID = '301_POD_ETA')" ).append("\n"); 
		query.append("                                            )" ).append("\n"); 
		query.append("                                           ), 'RRRRMMDDHH24MI')                                         || CHR(10)" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	|| 'POD_ETA_1:'		|| TO_CHAR(last_skd.vps_eta_dt + 1, 'RRRRMMDDHH24MI')      	   		 			|| CHR(10)" ).append("\n"); 
		query.append("	|| 'POD_ETD:'		|| TO_CHAR(last_skd.vps_etd_dt,     'RRRRMMDDHH24MI')				            || CHR(10)" ).append("\n"); 
		query.append("	|| 'DEL_NAME:'		|| DEL.LOC_NM												                    || CHR(10)" ).append("\n"); 
		query.append("	|| 'DEL_QUAL:'		|| DECODE(LENGTH(DEL.LOC_AMS_PORT_CD), 4, 'D', 5, 'K', ' ')		                || CHR(10)" ).append("\n"); 
		query.append("	|| 'DEL_PORT:'		|| DEL.LOC_AMS_PORT_CD											                || CHR(10)" ).append("\n"); 
		query.append("	|| 'DEL_UNLC:'		|| DEL.loc_cd												                    || CHR(10)" ).append("\n"); 
		query.append("	|| 'DEL_ETA:'		|| (SELECT to_char(CASE WHEN POD_CD = 'USLAX' AND DEL_CD ='USLGB'  THEN NVL(ESTM_DT_F, ESTM_DT_E)" ).append("\n"); 
		query.append("										WHEN POD_CD = 'USLGB' AND DEL_CD ='USLAX'  THEN NVL(ESTM_DT_F, ESTM_DT_E)" ).append("\n"); 
		query.append("										WHEN DE_TERM_CD <>'D' AND POD_CD = DEL_CD  THEN NVL(ESTM_DT_D, ESTM_DT_E)" ).append("\n"); 
		query.append("										WHEN DE_TERM_CD <>'D' AND POD_CD <>DEL_CD  THEN NVL(ESTM_DT_B, ESTM_DT_E)" ).append("\n"); 
		query.append("										WHEN DE_TERM_CD = 'D'                      THEN NVL(ESTM_DT_A, NVL(ESTM_DT_C, ESTM_DT_E))" ).append("\n"); 
		query.append("										ELSE ESTM_DT_E END, 'YYYYMMDDHH24MI')DEL_EST_ARRIVAL_DATE" ).append("\n"); 
		query.append("							  FROM (SELECT MAX(BK.BKG_NO) BKG_NO" ).append("\n"); 
		query.append("								 , MAX(BK.POD_CD) POD_CD" ).append("\n"); 
		query.append("								 , MAX(BK.DEL_CD) DEL_CD             " ).append("\n"); 
		query.append("								 , MAX(BK.DE_TERM_CD) DE_TERM_CD" ).append("\n"); 
		query.append("								 , MAX(to_date(ESTM_DT_A,'YYYYMMDDHH24MI')) AS ESTM_DT_A --전체 Acitivity가 Arraival 및 아래 로직조건상 가장 마직막 시간 " ).append("\n"); 
		query.append("								 , MAX(to_date(ESTM_DT_B,'YYYYMMDDHH24MI')) AS ESTM_DT_B --ESTM_DT_A와 같은조건에서 ESTM_DT_A 값의 다음 Acitivity중 가장 마직막 시간" ).append("\n"); 
		query.append("								 , MAX(to_date(ESTM_DT_C,'YYYYMMDDHH24MI')) AS ESTM_DT_C --'MITYAD', 'FITZAD'를 뺀 마지막 이전 Acitivity" ).append("\n"); 
		query.append("								 , MAX(to_date(ESTM_DT_D,'YYYYMMDDHH24MI')) AS ESTM_DT_D --Vessel Arrival at POD 값" ).append("\n"); 
		query.append("								 , MAX(to_date(ESTM_DT_E,'YYYYMMDDHH24MI')) AS ESTM_DT_E --Feeder Unloading at POD 값" ).append("\n"); 
		query.append("								 , MAX(to_date(ESTM_DT_F,'YYYYMMDDHH24MI')) AS ESTM_DT_F --POD/DEL이 USLAX/USLGB인 경우의 값" ).append("\n"); 
		query.append("							  FROM BKG_BOOKING BK " ).append("\n"); 
		query.append("								 , (SELECT to_char(ESTM_DT,'YYYYMMDDHH24MI') ESTM_DT_A, '' ESTM_DT_B, '' ESTM_DT_C, '' ESTM_DT_D, '' ESTM_DT_E, '' ESTM_DT_F   " ).append("\n"); 
		query.append("									  FROM (SELECT BK.BKG_NO, D.ACT_CD, ESTM_DT" ).append("\n"); 
		query.append("									 		 FROM BKG_BOOKING BK" ).append("\n"); 
		query.append("									 			 , SCE_COP_HDR H" ).append("\n"); 
		query.append("									 			 , SCE_COP_DTL D" ).append("\n"); 
		query.append("									 		 WHERE BK.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("									 		   AND BK.BKG_NO = H.BKG_NO" ).append("\n"); 
		query.append("									 		   AND D.COP_NO  = H.COP_NO" ).append("\n"); 
		query.append("									 		   AND H.COP_STS_CD <> 'X'" ).append("\n"); 
		query.append("									 		   AND D.NOD_CD	= H.DEL_NOD_CD" ).append("\n"); 
		query.append("									 		   AND D.ACT_CD <> 'MITYAD' --Activity Name : I/B Empty Container Returned" ).append("\n"); 
		query.append("									 		   AND D.ACT_CD <> 'FITZAD' --Activity Name : Truck Full Container Door Delivery" ).append("\n"); 
		query.append("									 		   AND (D.ACT_CD IN ('FITMDO', 'FITRDO') OR SUBSTR(D.ACT_CD, 5, 1) IN('A')) --Activity Name : Truck Gate Out from T/S Terminal, Truck Gate Out from I/B Rail Ramp" ).append("\n"); 
		query.append("									 		 ORDER BY ESTM_DT DESC)" ).append("\n"); 
		query.append("									 WHERE ROWNUM IN (1)" ).append("\n"); 
		query.append("									 UNION ALL  " ).append("\n"); 
		query.append("									SELECT '' ESTM_DT_A, to_char(ESTM_DT,'YYYYMMDDHH24MI') ESTM_DT_B, '' ESTM_DT_C, '' ESTM_DT_D, '' ESTM_DT_E, '' ESTM_DT_F" ).append("\n"); 
		query.append("									  FROM (SELECT ROWNUM SEQ_NO, ACT_CD, ESTM_DT" ).append("\n"); 
		query.append("									 		  FROM (SELECT BK.BKG_NO, D.ACT_CD, ESTM_DT" ).append("\n"); 
		query.append("									 				  FROM BKG_BOOKING BK" ).append("\n"); 
		query.append("									 					 , SCE_COP_HDR H" ).append("\n"); 
		query.append("									 					 , SCE_COP_DTL D" ).append("\n"); 
		query.append("							  				         WHERE BK.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("							  				           AND BK.BKG_NO = H.BKG_NO" ).append("\n"); 
		query.append("							  				           AND D.COP_NO	= H.COP_NO" ).append("\n"); 
		query.append("							  				           AND H.COP_STS_CD <> 'X'" ).append("\n"); 
		query.append("							  				           AND D.NOD_CD	= H.DEL_NOD_CD" ).append("\n"); 
		query.append("							  				           AND D.ACT_CD <> 'MITYAD' --Activity Name : I/B Empty Container Returned" ).append("\n"); 
		query.append("							  				           AND D.ACT_CD <> 'FITZAD' --Activity Name : Truck Full Container Door Delivery" ).append("\n"); 
		query.append("			  				                         ORDER BY ESTM_DT DESC)" ).append("\n"); 
		query.append("							  		        )     " ).append("\n"); 
		query.append("                                     WHERE SEQ_NO IN (SELECT COUNT(1)+1 FROM SCE_COP_HDR WHERE BKG_NO = @[bkg_no]AND COP_STS_CD <> 'X')" ).append("\n"); 
		query.append("                                     UNION ALL  " ).append("\n"); 
		query.append("                                    SELECT '' ESTM_DT_A, '' ESTM_DT_B, to_char(ESTM_DT,'YYYYMMDDHH24MI') ESTM_DT_C, '' ESTM_DT_D, '' ESTM_DT_E, '' ESTM_DT_F   " ).append("\n"); 
		query.append("                                      FROM (SELECT BK.BKG_NO, D.ACT_CD, ESTM_DT" ).append("\n"); 
		query.append("                                              FROM BKG_BOOKING BK" ).append("\n"); 
		query.append("												 , SCE_COP_HDR H" ).append("\n"); 
		query.append("												 , SCE_COP_DTL D" ).append("\n"); 
		query.append("											 WHERE BK.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("											   AND BK.BKG_NO = H.BKG_NO" ).append("\n"); 
		query.append("											   AND D.COP_NO  = H.COP_NO" ).append("\n"); 
		query.append("											   AND H.COP_STS_CD <> 'X'" ).append("\n"); 
		query.append("											   AND D.ACT_CD <> 'MITYAD' --Activity Name : I/B Empty Container Returned" ).append("\n"); 
		query.append("											   AND D.ACT_CD <> 'FITZAD' --Activity Name : Truck Full Container Door Delivery" ).append("\n"); 
		query.append("											   AND (D.ACT_CD IN ('FITMDO', 'FITRDO') OR SUBSTR(D.ACT_CD, 5, 1) IN('A')) --Activity Name : Truck Gate Out from T/S Terminal, Truck Gate Out from I/B Rail Ramp" ).append("\n"); 
		query.append("											 ORDER BY ESTM_DT DESC)" ).append("\n"); 
		query.append("                                     WHERE ROWNUM IN (1)" ).append("\n"); 
		query.append("                                     UNION ALL   " ).append("\n"); 
		query.append("					                SELECT '' ESTM_DT_A, '' ESTM_DT_B, '' ESTM_DT_C, to_char(ESTM_DT,'YYYYMMDDHH24MI') ESTM_DT_D, '' ESTM_DT_E, '' ESTM_DT_F  " ).append("\n"); 
		query.append("					                  FROM (SELECT BK.BKG_NO, D.ACT_CD, ESTM_DT" ).append("\n"); 
		query.append("							                  FROM BKG_BOOKING BK" ).append("\n"); 
		query.append("								                 , SCE_COP_HDR H" ).append("\n"); 
		query.append("								                 , SCE_COP_DTL D" ).append("\n"); 
		query.append("							                 WHERE BK.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("											   AND BK.BKG_NO = H.BKG_NO" ).append("\n"); 
		query.append("											   AND D.COP_NO	= H.COP_NO" ).append("\n"); 
		query.append("											   AND H.COP_STS_CD <> 'X'" ).append("\n"); 
		query.append("											   AND D.NOD_CD	= H.POD_NOD_CD" ).append("\n"); 
		query.append("											   AND D.ACT_CD IN ('FUVMAD') --Activity Name : Vessel Arrival at POD" ).append("\n"); 
		query.append("								             ORDER BY ESTM_DT DESC)" ).append("\n"); 
		query.append("									 WHERE ROWNUM IN (1)" ).append("\n"); 
		query.append("									 UNION ALL   " ).append("\n"); 
		query.append("									SELECT '' ESTM_DT_A, '' ESTM_DT_B, '' ESTM_DT_C, '' ESTM_DT_D, to_char(ESTM_DT,'YYYYMMDDHH24MI') ESTM_DT_E, '' ESTM_DT_F  " ).append("\n"); 
		query.append("									  FROM (SELECT BK.BKG_NO, D.ACT_CD, ESTM_DT" ).append("\n"); 
		query.append("											  FROM BKG_BOOKING BK" ).append("\n"); 
		query.append("											 	 , SCE_COP_HDR H" ).append("\n"); 
		query.append("											 	 , SCE_COP_DTL D" ).append("\n"); 
		query.append("											 WHERE BK.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("											   AND BK.BKG_NO = H.BKG_NO" ).append("\n"); 
		query.append("											   AND D.COP_NO	= H.COP_NO" ).append("\n"); 
		query.append("											   AND H.COP_STS_CD <> 'X'" ).append("\n"); 
		query.append("											   AND D.NOD_CD = H.POD_NOD_CD" ).append("\n"); 
		query.append("											   AND D.ACT_CD IN ('FUWMUD') --Activity Name : Feeder Unloading at POD" ).append("\n"); 
		query.append("											 ORDER BY ESTM_DT DESC)" ).append("\n"); 
		query.append("					                 WHERE ROWNUM IN (1)" ).append("\n"); 
		query.append("					                 UNION ALL   " ).append("\n"); 
		query.append("					                SELECT '' ESTM_DT_A, '' ESTM_DT_B, '' ESTM_DT_C, '' ESTM_DT_D, '' ESTM_DT_E, to_char(ESTM_DT,'YYYYMMDDHH24MI') ESTM_DT_F " ).append("\n"); 
		query.append("									  FROM (SELECT D.ACT_CD, ESTM_DT" ).append("\n"); 
		query.append("									 		  FROM BKG_BOOKING BK" ).append("\n"); 
		query.append("									 			 , SCE_COP_HDR H" ).append("\n"); 
		query.append("									 			 , SCE_COP_DTL D" ).append("\n"); 
		query.append("									 		 WHERE BK.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("									 		   AND BK.BKG_NO = H.BKG_NO" ).append("\n"); 
		query.append("									 		   AND D.COP_NO	= H.COP_NO" ).append("\n"); 
		query.append("									 		   AND H.COP_STS_CD <> 'X'" ).append("\n"); 
		query.append("									 		   AND D.NOD_CD	= H.POD_NOD_CD" ).append("\n"); 
		query.append("									 		   AND D.ACT_CD <> 'MITYAD' --Activity Name : I/B Empty Container Returned" ).append("\n"); 
		query.append("									 		   AND D.ACT_CD <> 'FITZAD' --Activity Name : Truck Full Container Door Delivery" ).append("\n"); 
		query.append("									 		   AND SUBSTR(D.ACT_CD, 5, 1) IN('U')" ).append("\n"); 
		query.append("									 		 ORDER BY ESTM_DT DESC)" ).append("\n"); 
		query.append("									  WHERE ROWNUM IN (1)" ).append("\n"); 
		query.append("									) ETA_LIST" ).append("\n"); 
		query.append("								WHERE BK.BKG_NO =@[bkg_no]))								        	|| CHR(10)" ).append("\n"); 
		query.append("	|| 'RLY_NAME:'		|| rly1.LOC_NM											                        || CHR(10)" ).append("\n"); 
		query.append("	|| 'RLY_QUAL:'		|| DECODE(LENGTH(rly1.LOC_AMS_PORT_CD), 4, 'D', 5, 'K', ' ')	                || CHR(10)" ).append("\n"); 
		query.append("	|| 'RLY_PORT:'		|| rly1.LOC_AMS_PORT_CD										                   	|| CHR(10)" ).append("\n"); 
		query.append("	|| 'RLY_UNLC:'		|| rly1.loc_cd												                    || CHR(10)" ).append("\n"); 
		query.append("	|| 'RLY_ETA:'       || TO_CHAR(rly1.vps_eta_dt, 'RRRRMMDDHH24MI')			                        || CHR(10)    " ).append("\n"); 
		query.append("	|| 'RLY_ETD:'       || TO_CHAR(rly1.vps_etD_dt, 'RRRRMMDDHH24MI')			                        || CHR(10)" ).append("\n"); 
		query.append("	|| 'RLY2_NAME:'     || RLY2.loc_nm                                                                  || CHR(10)" ).append("\n"); 
		query.append("	|| 'RLY2_QUAL:'     || DECODE(LENGTH(RLY2.LOC_AMS_PORT_CD), 4, 'D', 5, 'K', ' ')                    || CHR(10)" ).append("\n"); 
		query.append("	|| 'RLY2_PORT:'     || RLY2.LOC_AMS_PORT_CD                                                         || CHR(10)" ).append("\n"); 
		query.append("	|| 'RLY2_UNLC:'     || RLY2.loc_cd                                                                  || CHR(10)" ).append("\n"); 
		query.append("	|| 'RLY2_ETA:'      || TO_CHAR(rly2.vps_eta_dt, 'RRRRMMDDHH24MI')			                        || CHR(10)                 " ).append("\n"); 
		query.append("	|| 'RLY2_ETD:'      || TO_CHAR(rly2.vps_etD_dt, 'RRRRMMDDHH24MI')			                        || CHR(10) " ).append("\n"); 
		query.append("	|| 'FNLDST_NAME:'   || final_dest.loc_nm                                                            || CHR(10)" ).append("\n"); 
		query.append("	|| 'FNLDST_QUAL:'   || DECODE(LENGTH(final_dest.LOC_AMS_PORT_CD), 4, 'D', 5, 'K', ' ')              || CHR(10)" ).append("\n"); 
		query.append("	|| 'FNLDST_PORT:'   || final_dest.LOC_AMS_PORT_CD                                                   || CHR(10)" ).append("\n"); 
		query.append("	|| 'FNLDST_UNLC:'   || final_dest.loc_cd                                                            || CHR(10)" ).append("\n"); 
		query.append("	|| 'FNLDST_ETA:'      																				|| CHR(10)" ).append("\n"); 
		query.append("	|| 'PUNIT:'			|| bl.pck_tp_cd												                    || CHR(10)" ).append("\n"); 
		query.append("	|| 'PKG:'			|| NVL(bl.pck_qty,0)									                        || CHR(10)" ).append("\n"); 
		query.append("	|| 'WUNIT:'			|| SUBSTR(bl.wgt_ut_cd, 1, 1)							                        || CHR(10)" ).append("\n"); 
		query.append("	|| 'WGT:'			|| NVL(Bl.act_wgt,0)								                            || CHR(10)" ).append("\n"); 
		query.append("	|| 'EWUNIT:'		|| SUBSTR(bl.wgt_ut_cd, 1, 1)							                        || CHR(10)" ).append("\n"); 
		query.append("	|| 'EWGT:'			|| NVL(bl.act_wgt,0)								                            || CHR(10)" ).append("\n"); 
		query.append("	|| 'MUNIT:'			|| SUBSTR(Bl.meas_ut_cd, 3, 1)								                    || CHR(10)" ).append("\n"); 
		query.append("	|| 'MEAS:'			|| NVL(bl.meas_qty,0)									                        || CHR(10)" ).append("\n"); 
		query.append("	|| 'RDTYP:'			|| BK.rcv_term_cd || BK.de_term_cd						                        || CHR(10)" ).append("\n"); 
		query.append("	|| 'SMOD:'			|| BK.dest_trns_svc_mod_cd												        || CHR(10)" ).append("\n"); 
		query.append("	|| 'TRUCK:'			|| (select SYS_AREA_GRP_ID from bkg_pfx_rout where ofc_pfx_cd = substr(BK.BKG_OFC_CD, 1, 3) and rownum = 1)" ).append("\n"); 
		query.append("		FLAT_FILE1," ).append("\n"); 
		query.append("	'REMARK:'			|| REPLACE(REPLACE(REPLACE(REPLACE(REPLACE(BK.xter_rmk, CHR(13)||CHR(10), ' '), CHR(10), ' '), CHR(13), ' '), '*', '-'), ':', '-')" ).append("\n"); 
		query.append("		FLAT_FILE2," ).append("\n"); 
		query.append("	'CMD:'				|| bk.cmdt_cd                                                                   || CHR(10)" ).append("\n"); 
		query.append("	|| 'CMDD:'			|| (select cmdt_nm from mdm_commodity cmdt where cmdt.cmdt_cd = bk.cmdt_cd and rownum = 1)     || CHR(10)" ).append("\n"); 
		query.append("	|| 'EQREL:'			|| BK.mty_pkup_yd_cd					                                        || CHR(10)" ).append("\n"); 
		query.append("	|| 'LC_NO:'         || (select CUST_REF_NO_CTNT from bkg_reference refNo where refNo.bkg_no = bk.bkg_no and bkg_ref_tp_cd = 'LCNO' and rownum = 1) || CHR(10)" ).append("\n"); 
		query.append("	|| 'INV_NO:'        || (select CUST_REF_NO_CTNT from bkg_reference refNo where refNo.bkg_no = bk.bkg_no and bkg_ref_tp_cd = 'FINV' and rownum = 1) || CHR(10)" ).append("\n"); 
		query.append("	|| 'ACI_FILER_NO:'  || bk.cnd_cstms_file_cd                                                         || CHR(10)" ).append("\n"); 
		query.append("	|| 'AMS_FILER_NO:'  || bk.usa_cstms_file_cd                                                         || CHR(10)" ).append("\n"); 
		query.append("	|| 'EX_LICENCE_NO:' || (select xpt_lic_no from bkg_xpt_imp_lic lic where lic.bkg_no = bk.bkg_no and io_bnd_cd = 'O' and cnt_cd = 'KR' and rownum = 1)|| CHR(10)" ).append("\n"); 
		query.append("	|| 'SHN1:'			|| REPLACE(REPLACE(REPLACE(SH.cust_nm, CHR(13)||CHR(10), ' '), '*', '-'), ':', '-')||CHR(10)" ).append("\n"); 
		query.append("	|| 'FFN1:'			|| REPLACE(REPLACE(REPLACE(FW.cust_nm, CHR(13)||CHR(10), ' '), '*', '-'), ':', '-')||CHR(10)" ).append("\n"); 
		query.append("	|| 'CNE1:'			|| REPLACE(REPLACE(REPLACE(CN.cust_nm, CHR(13)||CHR(10), ' '), '*', '-'), ':', '-')||CHR(10)" ).append("\n"); 
		query.append("	|| 'SH_CD1:'		|| SH.cust_cnt_cd||DECODE(SH.cust_seq , '0', null , SH.cust_seq)				|| CHR(10)" ).append("\n"); 
		query.append("	|| 'FF_CD1:'		|| FW.cust_cnt_cd||DECODE(FW.cust_seq , '0', null , FW.cust_seq)				|| CHR(10)" ).append("\n"); 
		query.append("	|| 'CN_CD1:'		|| CN.cust_cnt_cd||DECODE(CN.cust_seq , '0', null , CN.cust_seq)				|| CHR(10)" ).append("\n"); 
		query.append("	|| 'NTFY_CD:'		|| NF.cust_cnt_cd||DECODE(NF.cust_seq , '0', null , NF.cust_seq)				|| CHR(10)" ).append("\n"); 
		query.append("	|| 'ANTFY_CD:'		|| AN.cust_cnt_cd||DECODE(AN.cust_seq , '0', null , AN.cust_seq)				|| CHR(10)" ).append("\n"); 
		query.append("	|| '3RD_NTFY_CD:'	                                         							            || CHR(10)" ).append("\n"); 
		query.append("	|| 'SHPR1:'			|| REPLACE(REPLACE(sce_TOKEN_NL_fnc(SH.cust_nm,   1), '*', '-'), ':', '-')		|| CHR(10)" ).append("\n"); 
		query.append("	|| 'SHPR2:'			|| REPLACE(REPLACE(sce_TOKEN_NL_fnc(SH.cust_nm,   2), '*', '-'), ':', '-')		|| CHR(10)" ).append("\n"); 
		query.append("	|| 'SHPR3:'			|| REPLACE(REPLACE(sce_TOKEN_NL_fnc(SH.cust_addr, 1), '*', '-'), ':', '-')		|| CHR(10)" ).append("\n"); 
		query.append("	|| 'SHPR4:'			|| REPLACE(REPLACE(sce_TOKEN_NL_fnc(SH.cust_addr, 2), '*', '-'), ':', '-')		|| CHR(10)" ).append("\n"); 
		query.append("	|| 'SHPR5:'			|| REPLACE(REPLACE(sce_TOKEN_NL_fnc(SH.cust_addr, 3), '*', '-'), ':', '-')		|| CHR(10)" ).append("\n"); 
		query.append("	|| 'CNEE1:'			|| REPLACE(REPLACE(sce_TOKEN_NL_fnc(CN.cust_nm,   1), '*', '-'), ':', '-')		|| CHR(10)" ).append("\n"); 
		query.append("	|| 'CNEE2:'			|| REPLACE(REPLACE(sce_TOKEN_NL_fnc(CN.cust_nm,   2), '*', '-'), ':', '-')		|| CHR(10)" ).append("\n"); 
		query.append("	|| 'CNEE3:'			|| REPLACE(REPLACE(sce_TOKEN_NL_fnc(CN.cust_addr, 1), '*', '-'), ':', '-')		|| CHR(10)" ).append("\n"); 
		query.append("	|| 'CNEE4:'			|| REPLACE(REPLACE(sce_TOKEN_NL_fnc(CN.cust_addr, 2), '*', '-'), ':', '-')		|| CHR(10)" ).append("\n"); 
		query.append("	|| 'CNEE5:'			|| REPLACE(REPLACE(sce_TOKEN_NL_fnc(CN.cust_addr, 3), '*', '-'), ':', '-')		|| CHR(10)" ).append("\n"); 
		query.append("	|| 'FWDR1:'			|| REPLACE(REPLACE(sce_TOKEN_NL_fnc(FW.cust_nm,   1), '*', '-'), ':', '-')		|| CHR(10)" ).append("\n"); 
		query.append("	|| 'FWDR2:'			|| REPLACE(REPLACE(sce_TOKEN_NL_fnc(FW.cust_nm,   2), '*', '-'), ':', '-')		|| CHR(10)" ).append("\n"); 
		query.append("	|| 'FWDR3:'			|| REPLACE(REPLACE(sce_TOKEN_NL_fnc(FW.cust_nm,   3), '*', '-'), ':', '-')		|| CHR(10)" ).append("\n"); 
		query.append("	|| 'FWDR4:'			|| REPLACE(REPLACE(sce_TOKEN_NL_fnc(FW.cust_nm,   4), '*', '-'), ':', '-')		|| CHR(10)" ).append("\n"); 
		query.append("	|| 'FWDR5:'			|| REPLACE(REPLACE(sce_TOKEN_NL_fnc(FW.cust_nm,   5), '*', '-'), ':', '-')		|| CHR(10)" ).append("\n"); 
		query.append("	|| 'NTFY1:'			|| REPLACE(REPLACE(sce_TOKEN_NL_fnc(NF.cust_nm,   1), '*', '-'), ':', '-')		|| CHR(10)" ).append("\n"); 
		query.append("	|| 'NTFY2:'			|| REPLACE(REPLACE(sce_TOKEN_NL_fnc(NF.cust_nm,   2), '*', '-'), ':', '-')		|| CHR(10)" ).append("\n"); 
		query.append("	|| 'NTFY3:'			|| REPLACE(REPLACE(sce_TOKEN_NL_fnc(NF.cust_addr, 1), '*', '-'), ':', '-')		|| CHR(10)" ).append("\n"); 
		query.append("	|| 'NTFY4:'			|| REPLACE(REPLACE(sce_TOKEN_NL_fnc(NF.cust_addr, 2), '*', '-'), ':', '-')		|| CHR(10)" ).append("\n"); 
		query.append("	|| 'NTFY5:'			|| REPLACE(REPLACE(sce_TOKEN_NL_fnc(NF.cust_addr, 3), '*', '-'), ':', '-')		|| CHR(10)" ).append("\n"); 
		query.append("	|| 'ANTFY1:'		|| REPLACE(REPLACE(sce_TOKEN_NL_fnc(AN.cust_nm,   1), '*', '-'), ':', '-')		|| CHR(10)" ).append("\n"); 
		query.append("	|| 'ANTFY2:'		|| REPLACE(REPLACE(sce_TOKEN_NL_fnc(AN.cust_nm,   2), '*', '-'), ':', '-')		|| CHR(10)" ).append("\n"); 
		query.append("	|| 'ANTFY3:'		|| REPLACE(REPLACE(sce_TOKEN_NL_fnc(AN.cust_nm,   3), '*', '-'), ':', '-')		|| CHR(10)" ).append("\n"); 
		query.append("	|| 'ANTFY4:'		|| REPLACE(REPLACE(sce_TOKEN_NL_fnc(AN.cust_nm,   4), '*', '-'), ':', '-')		|| CHR(10)" ).append("\n"); 
		query.append("	|| 'ANTFY5:'		|| REPLACE(REPLACE(sce_TOKEN_NL_fnc(AN.cust_nm,   5), '*', '-'), ':', '-')		|| CHR(10)" ).append("\n"); 
		query.append("	|| 'CANCEL_BIT:'	|| BK.bkg_sts_cd													            || CHR(10)" ).append("\n"); 
		query.append("	|| 'CARGOTYPE:'		|| BK.bkg_cgo_tp_cd												                || CHR(10)" ).append("\n"); 
		query.append("	|| 'DR_IND:'		|| decode(BK.dcgo_flg,       'Y', '1', '0')										|| CHR(10)" ).append("\n"); 
		query.append("	|| 'RF_IND:'		|| decode(BK.rc_flg,         'Y', '1', '0')										|| CHR(10)" ).append("\n"); 
		query.append("	|| 'AK_IND:'		|| decode(BK.awk_cgo_flg,    'Y', '1', '0')										|| CHR(10)" ).append("\n"); 
		query.append("	|| 'BB_IND:'		|| decode(BK.bb_cgo_flg,     'Y', '1', '0')										|| CHR(10)" ).append("\n"); 
		query.append("	|| 'HD_IND:'		|| decode(BK.spcl_hide_flg,  'Y', '1', '0')										|| CHR(10)" ).append("\n"); 
		query.append("	|| 'UD_IND:'		|| decode(nvl(bk.stwg_cd, '0'), '0', '0', '1')								 	|| CHR(10)" ).append("\n"); 
		query.append("	|| 'UD_CD:'			|| bk.stwg_cd		     										 	            || CHR(10)" ).append("\n"); 
		query.append("	|| 'RD_IND:'		|| decode(BK.rd_cgo_flg,     'Y', '1', '0')										|| CHR(10)" ).append("\n"); 
		query.append("	|| 'RF_CA:'     	|| RF.CTRL_ATMS_FLG													            || CHR(10)" ).append("\n"); 
		query.append("	|| 'RF_MA:'     	|| RF.MODI_ATMS_FLG													            || CHR(10)" ).append("\n"); 
		query.append("	|| 'SOC_IND:'		|| DECODE(BK.soc_flg,'Y','1','0')				 	                            || CHR(10)" ).append("\n"); 
		query.append("	|| 'SALES_OFFICE:'	|| BK.ob_sls_ofc_cd										                        || CHR(10)" ).append("\n"); 
		query.append("	|| 'SALES_NAME:'	|| (select srep_nm from mdm_sls_rep SREP where srep.srep_cd = bk.ob_srep_cd and rownum = 1)    || CHR(10)" ).append("\n"); 
		query.append("	|| 'BKG_STF:'	    || BK.doc_usr_id										                        || CHR(10)" ).append("\n"); 
		query.append("    || 'BKG_STF_NAME:'	|| usr.usr_nm											                        || CHR(10)" ).append("\n"); 
		query.append("    || 'BKG_STF_TEL:'	|| usr.XTN_PHN_NO										                        || CHR(10)" ).append("\n"); 
		query.append("    || 'BKG_STF_FAX:'	|| usr.FAX_NO											                        || CHR(10)" ).append("\n"); 
		query.append("    || 'BKG_STF_EMAIL:'	|| usr.USR_EML											                        || CHR(10)" ).append("\n"); 
		query.append("	|| 'CONTACT_NAME:'	|| cntc.cntc_pson_nm									                        || CHR(10)" ).append("\n"); 
		query.append("	|| 'CONTACT_TEL:'	|| cntc.cntc_pson_phn_no								                        || CHR(10)" ).append("\n"); 
		query.append("	|| 'BOUND_IND:'		|| 'E'															                || CHR(10)" ).append("\n"); 
		query.append("	|| 'REGIONAL_BKGNBR:'||(select CUST_REF_NO_CTNT from bkg_reference refNo where refNo.bkg_no = bk.bkg_no and bkg_ref_tp_cd = 'PSAN' and rownum = 1) || CHR(10)" ).append("\n"); 
		query.append("	|| 'CUST_REF_NO:'	|| (select CUST_REF_NO_CTNT from bkg_reference refNo where refNo.bkg_no = bk.bkg_no and bkg_ref_tp_cd = 'EBRF' and rownum = 1) || CHR(10)" ).append("\n"); 
		query.append("	|| 'REF_VOYAGE:'	                										                               || CHR(10)" ).append("\n"); 
		query.append("	|| 'SO_NO:'			|| BK.twn_so_no                           												|| CHR(10)" ).append("\n"); 
		query.append("	|| 'BLKSTWG:'       || bk.blck_stwg_cd                                                                     || CHR(10)" ).append("\n"); 
		query.append("	|| 'EQPICKDT:'		|| TO_CHAR(bk.mty_PKUP_DT, 'RRRRMMDDHH24MI')				                           || CHR(10)" ).append("\n"); 
		query.append("	|| 'EQRTN:'			|| BK.full_rtn_yd_cd			                                                       || CHR(10)" ).append("\n"); 
		query.append("	|| 'PUCY_CNT:'  	|| PKUP_CY.N1ST_VNDR_CNT_CD                                                       	   || CHR(10)" ).append("\n"); 
		query.append("	|| 'PUCY_CD:'   	|| PKUP_CY.yd_cd                                                                       || CHR(10)" ).append("\n"); 
		query.append("	|| 'PUCY_NM:'   	||                  replace(replace(PKUP_CY.yd_nm,   chr(13), ' '), chr(10), ' ' )     || CHR(10)" ).append("\n"); 
		query.append("	|| 'PUCY_ADDR1:'	|| sce_TOKEN_NL_fnc(replace(replace(PKUP_CY.yd_addr, chr(13), ' '), chr(10), ' ' ), 1) || CHR(10)" ).append("\n"); 
		query.append("	|| 'PUCY_ADDR2:'	|| sce_TOKEN_NL_fnc(replace(replace(PKUP_CY.yd_addr, chr(13), ' '), chr(10), ' ' ), 2) || CHR(10)" ).append("\n"); 
		query.append("	|| 'PUCY_ADDR3:'	|| sce_TOKEN_NL_fnc(replace(replace(PKUP_CY.yd_addr, chr(13), ' '), chr(10), ' ' ), 3) || CHR(10)" ).append("\n"); 
		query.append("	|| 'PUCY_ADDR4:'	|| sce_TOKEN_NL_fnc(replace(replace(PKUP_CY.yd_addr, chr(13), ' '), chr(10), ' ' ), 4) || CHR(10)" ).append("\n"); 
		query.append("	|| 'PUCY_ADDR5:'	|| sce_TOKEN_NL_fnc(replace(replace(PKUP_CY.yd_addr, chr(13), ' '), chr(10), ' ' ), 5) || CHR(10)" ).append("\n"); 
		query.append("	|| 'RTCY_CNT:'  	|| substr(RTN_CY.loc_cd, 1, 2)                                                         || CHR(10)" ).append("\n"); 
		query.append("	|| 'RTCY_CD:'   	|| RTN_CY.yd_cd                                                                        || CHR(10)" ).append("\n"); 
		query.append("	|| 'RTCY_NM:'   	||                  replace(replace(RTN_CY.yd_nm,   chr(13), ' '), chr(10), ' ' )      || CHR(10)" ).append("\n"); 
		query.append("	|| 'RTCY_ADDR1:'	|| sce_TOKEN_NL_fnc(replace(replace(RTN_CY.yd_addr, chr(13), ' '), chr(10), ' ' ), 1)  || CHR(10)" ).append("\n"); 
		query.append("	|| 'RTCY_ADDR2:'	|| sce_TOKEN_NL_fnc(replace(replace(RTN_CY.yd_addr, chr(13), ' '), chr(10), ' ' ), 2)  || CHR(10)" ).append("\n"); 
		query.append("	|| 'RTCY_ADDR3:'	|| sce_TOKEN_NL_fnc(replace(replace(RTN_CY.yd_addr, chr(13), ' '), chr(10), ' ' ), 3)  || CHR(10)" ).append("\n"); 
		query.append("	|| 'RTCY_ADDR4:'	|| sce_TOKEN_NL_fnc(replace(replace(RTN_CY.yd_addr, chr(13), ' '), chr(10), ' ' ), 4)  || CHR(10)" ).append("\n"); 
		query.append("	|| 'RTCY_ADDR5:'	|| sce_TOKEN_NL_fnc(replace(replace(RTN_CY.yd_addr, chr(13), ' '), chr(10), ' ' ), 5)  || CHR(10)" ).append("\n"); 
		query.append("	|| 'BL_PO_NO:'		|| (select CUST_REF_NO_CTNT from bkg_reference refNo where refNo.bkg_no = bk.bkg_no and bkg_ref_tp_cd = 'BKPO' and rownum = 1) || CHR(10)" ).append("\n"); 
		query.append("	|| 'BL_SI_NO:'		|| (select CUST_REF_NO_CTNT from bkg_reference refNo where refNo.bkg_no = bk.bkg_no and bkg_ref_tp_cd = 'ESRF' and rownum = 1) || CHR(10)" ).append("\n"); 
		query.append("	|| 'FRT_TERM:'   	|| (select rt.frt_term_cd from bkg_rate rt where	rt.bkg_no = bk.bkg_no)			   || CHR(10)" ).append("\n"); 
		query.append("	|| 'ONBOARD:'		|| TO_CHAR(Bl.bl_obrd_dt, 'RRRRMMDD')                                                  || CHR(10)" ).append("\n"); 
		query.append("	|| 'BKG_OFC:'   	|| BK.bkg_ofc_cd				                                                       || CHR(10)" ).append("\n"); 
		query.append("	|| 'SC_NO:'   		|| bk.sc_no				                                                               || CHR(10)" ).append("\n"); 
		query.append("	|| 'GROUP_ID:'		|| NVL(@[group_id], ' ')||'/'||NVL(@[ref_code], ' ')	                               || CHR(10)" ).append("\n"); 
		query.append("	|| 'BKG_VIA:'		|| decode(NVL(BK.xter_bkg_rqst_cd, ' '), 'WEB', 'W', 'EDI', 'E', 'GTN', 'G', 'INT', 'I', 'CSM', 'C', 'DSK', 'P', 'DAK', 'D', 'NIS', 'N')||CHR(10)" ).append("\n"); 
		query.append("	|| 'BKG_CUST_REF_NO:'||(select CUST_REF_NO_CTNT from bkg_reference refNo where refNo.bkg_no = bk.bkg_no and bkg_ref_tp_cd = 'EBRF' and rownum = 1) || CHR(10)" ).append("\n"); 
		query.append("	|| 'BKG_SH_REF_NO:' || (select CUST_REF_NO_CTNT from bkg_reference refNo where refNo.bkg_no = bk.bkg_no and bkg_ref_tp_cd = 'EBSH' and rownum = 1) || CHR(10)" ).append("\n"); 
		query.append("	|| 'BKG_FF_REF_NO:' || (select CUST_REF_NO_CTNT from bkg_reference refNo where refNo.bkg_no = bk.bkg_no and bkg_ref_tp_cd = 'EBFF' and rownum = 1) || CHR(10)" ).append("\n"); 
		query.append("	|| 'SI_CUST_REF_NO:'|| (select CUST_REF_NO_CTNT from bkg_reference refNo where refNo.bkg_no = bk.bkg_no and bkg_ref_tp_cd = 'ESRF' and rownum = 1) || CHR(10)" ).append("\n"); 
		query.append("	|| 'SI_SH_REF_NO:'  || (select CUST_REF_NO_CTNT from bkg_reference refNo where refNo.bkg_no = bk.bkg_no and bkg_ref_tp_cd = 'ESSH' and rownum = 1) || CHR(10)" ).append("\n"); 
		query.append("	|| 'SI_FF_REF_NO:'  || (select CUST_REF_NO_CTNT from bkg_reference refNo where refNo.bkg_no = bk.bkg_no and bkg_ref_tp_cd = 'ESFF' and rownum = 1) || CHR(10) " ).append("\n"); 
		query.append("#if (${rcv_id}== 'TRADIANT' || ${rcv_id}== 'WEYERHAEUSER') " ).append("\n"); 
		query.append("	|| 'RAIL_CUTOFF:'  || (SELECT TO_CHAR(NVL(MNL_SET_DT, SYS_SET_DT), 'RRRRMMDDHH24MI')" ).append("\n"); 
		query.append("				             FROM BKG_CLZ_TM CLZ" ).append("\n"); 
		query.append("				            WHERE CLZ.BKG_NO = BK.BKG_NO" ).append("\n"); 
		query.append("				              AND NTC_FLG = 'Y'" ).append("\n"); 
		query.append("				              AND CLZ_TP_CD = 'O')|| CHR(10) " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("	|| 'VGM_CUTOFF:'  || (SELECT NVL(TO_CHAR(NVL(MNL_SET_DT, SYS_SET_DT), 'RRRRMMDDHH24MI'), SYS_SET_DT_DESC)" ).append("\n"); 
		query.append("				             FROM BKG_CLZ_TM CLZ" ).append("\n"); 
		query.append("				            WHERE CLZ.BKG_NO = BK.BKG_NO" ).append("\n"); 
		query.append("				              AND NTC_FLG = 'Y'" ).append("\n"); 
		query.append("				              AND CLZ_TP_CD = 'V')" ).append("\n"); 
		query.append("	 FLAT_FILE3" ).append("\n"); 
		query.append("  FROM	bkg_booking	BK, bkg_bl_doc bl, bkg_cntc_pson cntc" ).append("\n"); 
		query.append("           , (SELECT * " ).append("\n"); 
		query.append("				FROM (select ROWNUM NO, vvd.bkg_no, skd.vps_eta_dt, skd.vps_etd_dt, loc.loc_cd, loc.loc_nm, loc.LOC_AMS_PORT_CD, vvd.vsl_cd" ).append("\n"); 
		query.append("                		from (select vvd.bkg_no, vvd.vsl_cd, vvd.skd_voy_no, vvd.skd_dir_cd" ).append("\n"); 
		query.append("                           			, vvd.pod_cd, vvd.pod_clpt_ind_seq                     " ).append("\n"); 
		query.append("                       			from bkg_booking bk, bkg_vvd vvd" ).append("\n"); 
		query.append("                      			where bk.bkg_no = vvd.bkg_no" ).append("\n"); 
		query.append("                        		and bk.bkg_no = @[bkg_no]" ).append("\n"); 
		query.append("                        		and bk.pod_cd <> vvd.pod_cd" ).append("\n"); 
		query.append("								ORDER BY VVD.VSL_PRE_PST_CD, VVD.VSL_SEQ ) VVD" ).append("\n"); 
		query.append("                     		, vsk_vsl_port_skd skd, mdm_location loc" ).append("\n"); 
		query.append("               			where vvd.pod_cd           = loc.loc_cd" ).append("\n"); 
		query.append("                 		and vvd.vsl_cd           = skd.vsl_cd" ).append("\n"); 
		query.append("                 		and vvd.skd_voy_no       = skd.skd_voy_no" ).append("\n"); 
		query.append("                 		and vvd.skd_dir_cd       = skd.skd_dir_cd" ).append("\n"); 
		query.append("                 		and vvd.pod_cd           = skd.vps_port_cd" ).append("\n"); 
		query.append("                 		and vvd.pod_clpt_ind_seq = skd.clpt_ind_seq ) RLY" ).append("\n"); 
		query.append("				WHERE RLY.NO = 1 ) rly1" ).append("\n"); 
		query.append("            , (SELECT * " ).append("\n"); 
		query.append("				FROM (select ROWNUM NO, vvd.bkg_no, skd.vps_eta_dt, skd.vps_etd_dt, loc.loc_cd, loc.loc_nm, loc.LOC_AMS_PORT_CD, vvd.vsl_cd" ).append("\n"); 
		query.append("                		from (select vvd.bkg_no, vvd.vsl_cd, vvd.skd_voy_no, vvd.skd_dir_cd" ).append("\n"); 
		query.append("                           			, vvd.pod_cd, vvd.pod_clpt_ind_seq                     " ).append("\n"); 
		query.append("                       			from bkg_booking bk, bkg_vvd vvd" ).append("\n"); 
		query.append("                      			where bk.bkg_no = vvd.bkg_no" ).append("\n"); 
		query.append("                        		and bk.bkg_no = @[bkg_no]" ).append("\n"); 
		query.append("                        		and bk.pod_cd <> vvd.pod_cd" ).append("\n"); 
		query.append("								ORDER BY VVD.VSL_PRE_PST_CD, VVD.VSL_SEQ ) VVD" ).append("\n"); 
		query.append("                     		, vsk_vsl_port_skd skd, mdm_location loc" ).append("\n"); 
		query.append("               			where vvd.pod_cd           = loc.loc_cd" ).append("\n"); 
		query.append("                 		and vvd.vsl_cd           = skd.vsl_cd" ).append("\n"); 
		query.append("                 		and vvd.skd_voy_no       = skd.skd_voy_no" ).append("\n"); 
		query.append("                 		and vvd.skd_dir_cd       = skd.skd_dir_cd" ).append("\n"); 
		query.append("                 		and vvd.pod_cd           = skd.vps_port_cd" ).append("\n"); 
		query.append("                 		and vvd.pod_clpt_ind_seq = skd.clpt_ind_seq ) RLY" ).append("\n"); 
		query.append("				WHERE RLY.NO = 2 ) rly2" ).append("\n"); 
		query.append("           , bkg_vvd          n1st_vvd" ).append("\n"); 
		query.append("           , mdm_vsl_cntr     n1st_vsl" ).append("\n"); 
		query.append("	       , vsk_vsl_port_skd n1st_SKD" ).append("\n"); 
		query.append("	       , bkg_vvd          last_vvd" ).append("\n"); 
		query.append("	       , vsk_vsl_port_skd last_skd" ).append("\n"); 
		query.append("	       , bkg_customer SH, bkg_customer CN, bkg_customer FW, bkg_customer NF, bkg_customer AN" ).append("\n"); 
		query.append("	       , mdm_location POR, mdm_location POL, mdm_location POD, mdm_location DEL, mdm_location final_Dest" ).append("\n"); 
		query.append("		   , mdm_yard Pkup_CY, mdm_yard RTN_CY" ).append("\n"); 
		query.append("	       , bkg_rf_cgo 	  RF" ).append("\n"); 
		query.append("	       , mdm_vsl_cntr 	  TVVD" ).append("\n"); 
		query.append("	       , com_user 		  usr" ).append("\n"); 
		query.append(" WHERE BK.bkg_no	   	    = @[bkg_no]" ).append("\n"); 
		query.append("   AND BK.pol_cd			= POL.loc_cd" ).append("\n"); 
		query.append("   AND BK.pod_cd			= POD.loc_cd" ).append("\n"); 
		query.append("   AND BK.por_cd			= POR.loc_cd" ).append("\n"); 
		query.append("   AND BK.del_cd			= DEL.loc_cd" ).append("\n"); 
		query.append("   and bk.fnl_dest_cd       = final_dest.loc_cd(+)" ).append("\n"); 
		query.append("   AND BK.bkg_no			= Bl.bkg_no" ).append("\n"); 
		query.append("   AND BK.bkg_no			= cntc.bkg_no" ).append("\n"); 
		query.append("   and 'BK'                 = cntc.bkg_cntc_pson_tp_cd" ).append("\n"); 
		query.append("   AND BK.bkg_no			= SH.bkg_no        (+)" ).append("\n"); 
		query.append("   AND 'S'                  = SH.bkg_cust_tp_cd(+)" ).append("\n"); 
		query.append("   AND BK.bkg_no			= CN.bkg_no        (+)" ).append("\n"); 
		query.append("   AND 'C'                  = CN.bkg_cust_tp_cd(+)" ).append("\n"); 
		query.append("   AND BK.bkg_no			= FW.bkg_no        (+)" ).append("\n"); 
		query.append("   AND 'F'                  = FW.bkg_cust_tp_cd(+)" ).append("\n"); 
		query.append("   AND BK.bkg_no			= NF.bkg_no        (+)" ).append("\n"); 
		query.append("   AND 'N'                  = NF.bkg_cust_tp_cd(+)" ).append("\n"); 
		query.append("   AND BK.bkg_no			= AN.bkg_no        (+)" ).append("\n"); 
		query.append("   AND 'A'                  = AN.bkg_cust_tp_cd(+)" ).append("\n"); 
		query.append("   AND BK.vsl_cd			= TVVD.vsl_cd" ).append("\n"); 
		query.append("   and bk.bkg_no                = n1st_vvd.bkg_no" ).append("\n"); 
		query.append("   and bk.pol_cd                = n1st_vvd.pol_cd" ).append("\n"); 
		query.append("   and n1st_vvd.vsl_pre_pst_cd  in ('S', 'T')" ).append("\n"); 
		query.append("   AND n1st_vvd.vsl_cd          = n1st_vsl.vsl_cd(+) " ).append("\n"); 
		query.append("   and n1st_vvd.vsl_cd          = n1st_skd.vsl_cd(+) " ).append("\n"); 
		query.append("   and n1st_vvd.skd_voy_no      = n1st_skd.skd_voy_no(+)" ).append("\n"); 
		query.append("   and n1st_vvd.skd_dir_cd      = n1st_skd.skd_dir_cd(+)" ).append("\n"); 
		query.append("   and n1st_vvd.pol_cd          = n1st_skd.vps_port_cd(+)" ).append("\n"); 
		query.append("   and n1st_vvd.pol_clpt_ind_seq= n1st_skd.clpt_ind_seq(+)" ).append("\n"); 
		query.append("   and bk.bkg_no                = last_vvd.bkg_no(+)" ).append("\n"); 
		query.append("   and bk.pod_cd                = last_vvd.pod_cd(+)" ).append("\n"); 
		query.append("   and last_vvd.vsl_pre_pst_cd  in ('T', 'U')" ).append("\n"); 
		query.append("   and last_vvd.vsl_cd          = last_skd.vsl_cd       (+)" ).append("\n"); 
		query.append("   and last_vvd.skd_voy_no      = last_skd.skd_voy_no   (+)" ).append("\n"); 
		query.append("   and last_vvd.skd_dir_cd      = last_skd.skd_dir_cd   (+)" ).append("\n"); 
		query.append("   and last_vvd.pod_cd          = last_skd.vps_port_cd  (+)" ).append("\n"); 
		query.append("   and last_vvd.pod_clpt_ind_seq= last_skd.clpt_ind_seq (+)" ).append("\n"); 
		query.append("   AND BK.bkg_no			= rly1.bkg_no(+)" ).append("\n"); 
		query.append("   AND BK.bkg_no			= rly2.bkg_no(+)" ).append("\n"); 
		query.append("   AND BK.doc_usr_id		= usr.usr_id (+)" ).append("\n"); 
		query.append("   AND BK.mty_pkup_yd_cd    = PKUP_CY.yd_cd(+)" ).append("\n"); 
		query.append("   AND BK.full_rtn_yd_cd    = RTN_CY.yd_cd(+)" ).append("\n"); 
		query.append("   AND BK.bkg_no			= RF.bkg_no(+)" ).append("\n"); 
		query.append("   and 1                    = rf.rc_seq(+)" ).append("\n"); 

	}
}