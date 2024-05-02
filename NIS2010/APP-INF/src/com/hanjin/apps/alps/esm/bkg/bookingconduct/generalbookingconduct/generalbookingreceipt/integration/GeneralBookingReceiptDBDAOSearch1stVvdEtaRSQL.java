/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : GeneralBookingReceiptDBDAOSearch1stVvdEtaRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.05.20
*@LastModifier : 
*@LastVersion : 1.0
* 2014.05.20 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class GeneralBookingReceiptDBDAOSearch1stVvdEtaRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  *    
	  * </pre>
	  */
	public GeneralBookingReceiptDBDAOSearch1stVvdEtaRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_vvd_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("pol_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.integration").append("\n"); 
		query.append("FileName : GeneralBookingReceiptDBDAOSearch1stVvdEtaRSQL").append("\n"); 
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
		query.append("SELECT TO_CHAR(N1ST_ETA, 'yyyy-mm-dd hh:mi') n1st_eta" ).append("\n"); 
		query.append("      ,TO_CHAR(N1ST_ETA, 'yyyy-mm-dd') 		 n1st_eta_day" ).append("\n"); 
		query.append("      ,TO_CHAR(N1ST_ETA, 'hh:mi') 			 n1st_eta_time" ).append("\n"); 
		query.append("	  ,TO_CHAR(DEL_ETA,  'yyyy-mm-dd hh:mi') del_eta" ).append("\n"); 
		query.append("      ,TO_CHAR(DEL_ETA,  'yyyy-mm-dd') 		 del_eta_day" ).append("\n"); 
		query.append("      ,TO_CHAR(DEL_ETA,  'hh:mi') 			 del_eta_time" ).append("\n"); 
		query.append("  FROM (SELECT CASE WHEN POD_CD = 'USLAX' AND DEL_CD ='USLGB'  THEN NVL(ESTM_DT_F, ESTM_DT_E)" ).append("\n"); 
		query.append("                    WHEN POD_CD = 'USLGB' AND DEL_CD ='USLAX'  THEN NVL(ESTM_DT_F, ESTM_DT_E)" ).append("\n"); 
		query.append("                    WHEN DE_TERM_CD <>'D' AND POD_CD = DEL_CD  THEN NVL(ESTM_DT_D, ESTM_DT_E)" ).append("\n"); 
		query.append("                    WHEN DE_TERM_CD <>'D' AND POD_CD <>DEL_CD  THEN NVL(ESTM_DT_B, NVL(ESTM_DT_G, ESTM_DT_E))" ).append("\n"); 
		query.append("                    WHEN DE_TERM_CD = 'D'                      THEN NVL(ESTM_DT_A, NVL(ESTM_DT_C, ESTM_DT_E))" ).append("\n"); 
		query.append("                    ELSE ESTM_DT_E END DEL_ETA" ).append("\n"); 
		query.append("          FROM (SELECT MAX(BK.BKG_NO) BKG_NO" ).append("\n"); 
		query.append("                     , MAX(BK.POD_CD) POD_CD" ).append("\n"); 
		query.append("                     , MAX(BK.DEL_CD) DEL_CD             " ).append("\n"); 
		query.append("                     , MAX(BK.DE_TERM_CD) DE_TERM_CD" ).append("\n"); 
		query.append("                     , MAX(to_date(ESTM_DT_A,'YYYYMMDD HH24MISS')) AS ESTM_DT_A --Activity 가 ‘Arrival’인 항목 목록 중 가장 마지막 시간  --전체 Acitivity가 Arraival 및 아래 로직조건상 가장 마직막 시간 " ).append("\n"); 
		query.append("                     , MAX(to_date(ESTM_DT_B,'YYYYMMDD HH24MISS')) AS ESTM_DT_B --ESTM_DT_A 의 한 단계 이전 발생 값 --ESTM_DT_A와 같은조건에서 ESTM_DT_A 값의 다음 Acitivity중 가장 마직막 시간" ).append("\n"); 
		query.append("                     , MAX(to_date(ESTM_DT_C,'YYYYMMDD HH24MISS')) AS ESTM_DT_C --Location 조건 제외 후 ESTM_DT_A 값 --'MITYAD', 'FITZAD'를 뺀 마지막 이전 Acitivity" ).append("\n"); 
		query.append("                     , MAX(to_date(ESTM_DT_D,'YYYYMMDD HH24MISS')) AS ESTM_DT_D --Vessel Arrival at POD 값" ).append("\n"); 
		query.append("                     , MAX(to_date(ESTM_DT_E,'YYYYMMDD HH24MISS')) AS ESTM_DT_E --Feeder Unloading at POD 값" ).append("\n"); 
		query.append("                     , MAX(to_date(ESTM_DT_F,'YYYYMMDD HH24MISS')) AS ESTM_DT_F --POD/DEL이 USLAX/USLGB인 경우의 값" ).append("\n"); 
		query.append("                     , MAX(to_date(ESTM_DT_G,'YYYYMMDD HH24MISS')) AS ESTM_DT_G --Location 조건 제외 후 ESTM_DT_B 값" ).append("\n"); 
		query.append("                  FROM BKG_BOOKING BK " ).append("\n"); 
		query.append("                     , (SELECT to_char(ESTM_DT,'YYYYMMDD HH24MISS') ESTM_DT_A, '' ESTM_DT_B, '' ESTM_DT_C, '' ESTM_DT_D, '' ESTM_DT_E, '' ESTM_DT_F, '' ESTM_DT_G " ).append("\n"); 
		query.append("                          FROM (SELECT BK.BKG_NO, D.ACT_CD, ESTM_DT" ).append("\n"); 
		query.append("                                  FROM BKG_BOOKING BK" ).append("\n"); 
		query.append("                                     , SCE_COP_HDR H" ).append("\n"); 
		query.append("                                     , SCE_COP_DTL D" ).append("\n"); 
		query.append("                                 WHERE BK.BKG_NO = @[bkg_no] " ).append("\n"); 
		query.append("                                   AND BK.BKG_NO = H.BKG_NO" ).append("\n"); 
		query.append("                                   AND D.COP_NO  = H.COP_NO" ).append("\n"); 
		query.append("                                   AND H.COP_STS_CD <> 'X'" ).append("\n"); 
		query.append("                                   AND D.NOD_CD	= H.DEL_NOD_CD" ).append("\n"); 
		query.append("                                   AND D.ACT_CD <> 'MITYAD' --Activity Name : I/B Empty Container Returned" ).append("\n"); 
		query.append("                                   AND D.ACT_CD <> 'FITZAD' --Activity Name : Truck Full Container Door Delivery" ).append("\n"); 
		query.append("                                   AND (D.ACT_CD IN ('FITMDO', 'FITRDO') OR SUBSTR(D.ACT_CD, 5, 1) IN('A')) --Activity Name : Truck Gate Out from T/S Terminal, Truck Gate Out from I/B Rail Ramp" ).append("\n"); 
		query.append("                                 ORDER BY ESTM_DT DESC)" ).append("\n"); 
		query.append("                         WHERE ROWNUM IN (1)" ).append("\n"); 
		query.append("                         UNION ALL  " ).append("\n"); 
		query.append("                        SELECT '' ESTM_DT_A, to_char(ESTM_DT,'YYYYMMDD HH24MISS') ESTM_DT_B, '' ESTM_DT_C, '' ESTM_DT_D, '' ESTM_DT_E, '' ESTM_DT_F, '' ESTM_DT_G" ).append("\n"); 
		query.append("                          FROM (SELECT ROWNUM SEQ_NO, ACT_CD, ESTM_DT" ).append("\n"); 
		query.append("                                  FROM (SELECT BK.BKG_NO, D.ACT_CD, ESTM_DT" ).append("\n"); 
		query.append("                                          FROM BKG_BOOKING BK" ).append("\n"); 
		query.append("                                             , SCE_COP_HDR H" ).append("\n"); 
		query.append("                                             , SCE_COP_DTL D" ).append("\n"); 
		query.append("                                         WHERE BK.BKG_NO = @[bkg_no] " ).append("\n"); 
		query.append("                                           AND BK.BKG_NO = H.BKG_NO" ).append("\n"); 
		query.append("                                           AND D.COP_NO	= H.COP_NO" ).append("\n"); 
		query.append("                                           AND H.COP_STS_CD <> 'X'" ).append("\n"); 
		query.append("                                           AND D.NOD_CD	= H.DEL_NOD_CD" ).append("\n"); 
		query.append("                                           AND D.ACT_CD <> 'MITYAD' --Activity Name : I/B Empty Container Returned" ).append("\n"); 
		query.append("                                           AND D.ACT_CD <> 'FITZAD' --Activity Name : Truck Full Container Door Delivery" ).append("\n"); 
		query.append("                                         ORDER BY ESTM_DT DESC)" ).append("\n"); 
		query.append("                                )     " ).append("\n"); 
		query.append("                         WHERE SEQ_NO IN (SELECT COUNT(1)+1 FROM SCE_COP_HDR WHERE BKG_NO = @[bkg_no] AND COP_STS_CD <> 'X')" ).append("\n"); 
		query.append("                         UNION ALL  " ).append("\n"); 
		query.append("                        SELECT '' ESTM_DT_A, '' ESTM_DT_B, to_char(ESTM_DT,'YYYYMMDD HH24MISS') ESTM_DT_C, '' ESTM_DT_D, '' ESTM_DT_E, '' ESTM_DT_F, '' ESTM_DT_G   " ).append("\n"); 
		query.append("                          FROM (SELECT BK.BKG_NO, D.ACT_CD, ESTM_DT" ).append("\n"); 
		query.append("                                  FROM BKG_BOOKING BK" ).append("\n"); 
		query.append("                                     , SCE_COP_HDR H" ).append("\n"); 
		query.append("                                     , SCE_COP_DTL D" ).append("\n"); 
		query.append("                                 WHERE BK.BKG_NO = @[bkg_no] " ).append("\n"); 
		query.append("                                   AND BK.BKG_NO = H.BKG_NO" ).append("\n"); 
		query.append("                                   AND D.COP_NO  = H.COP_NO" ).append("\n"); 
		query.append("                                   AND H.COP_STS_CD <> 'X'" ).append("\n"); 
		query.append("                                   AND D.ACT_CD <> 'MITYAD' --Activity Name : I/B Empty Container Returned" ).append("\n"); 
		query.append("                                   AND D.ACT_CD <> 'FITZAD' --Activity Name : Truck Full Container Door Delivery" ).append("\n"); 
		query.append("                                   AND (D.ACT_CD IN ('FITMDO', 'FITRDO') OR SUBSTR(D.ACT_CD, 5, 1) IN('A')) --Activity Name : Truck Gate Out from T/S Terminal, Truck Gate Out from I/B Rail Ramp" ).append("\n"); 
		query.append("                                 ORDER BY ESTM_DT DESC)" ).append("\n"); 
		query.append("                         WHERE ROWNUM IN (1)" ).append("\n"); 
		query.append("                         UNION ALL   " ).append("\n"); 
		query.append("                        SELECT '' ESTM_DT_A, '' ESTM_DT_B, '' ESTM_DT_C, to_char(ESTM_DT,'YYYYMMDD HH24MISS') ESTM_DT_D, '' ESTM_DT_E, '' ESTM_DT_F, '' ESTM_DT_G  " ).append("\n"); 
		query.append("                          FROM (SELECT BK.BKG_NO, D.ACT_CD, ESTM_DT" ).append("\n"); 
		query.append("                                  FROM BKG_BOOKING BK" ).append("\n"); 
		query.append("                                     , SCE_COP_HDR H" ).append("\n"); 
		query.append("                                     , SCE_COP_DTL D" ).append("\n"); 
		query.append("                                 WHERE BK.BKG_NO = @[bkg_no] " ).append("\n"); 
		query.append("                                   AND BK.BKG_NO = H.BKG_NO" ).append("\n"); 
		query.append("                                   AND D.COP_NO	= H.COP_NO" ).append("\n"); 
		query.append("                                   AND H.COP_STS_CD <> 'X'" ).append("\n"); 
		query.append("                                   AND D.NOD_CD	= H.POD_NOD_CD" ).append("\n"); 
		query.append("                                   AND D.ACT_CD IN ('FUVMAD') --Activity Name : Vessel Arrival at POD" ).append("\n"); 
		query.append("                                 ORDER BY ESTM_DT DESC)" ).append("\n"); 
		query.append("                         WHERE ROWNUM IN (1)" ).append("\n"); 
		query.append("                         UNION ALL   " ).append("\n"); 
		query.append("                        SELECT '' ESTM_DT_A, '' ESTM_DT_B, '' ESTM_DT_C, '' ESTM_DT_D, to_char(ESTM_DT,'YYYYMMDD HH24MISS') ESTM_DT_E, '' ESTM_DT_F, '' ESTM_DT_G  " ).append("\n"); 
		query.append("                          FROM (SELECT BK.BKG_NO, D.ACT_CD, ESTM_DT" ).append("\n"); 
		query.append("                                  FROM BKG_BOOKING BK" ).append("\n"); 
		query.append("                                     , SCE_COP_HDR H" ).append("\n"); 
		query.append("                                     , SCE_COP_DTL D" ).append("\n"); 
		query.append("                                 WHERE BK.BKG_NO = @[bkg_no] " ).append("\n"); 
		query.append("                                   AND BK.BKG_NO = H.BKG_NO" ).append("\n"); 
		query.append("                                   AND D.COP_NO	= H.COP_NO" ).append("\n"); 
		query.append("                                   AND H.COP_STS_CD <> 'X'" ).append("\n"); 
		query.append("                                   AND D.NOD_CD = H.POD_NOD_CD" ).append("\n"); 
		query.append("                                   AND D.ACT_CD IN ('FUWMUD') --Activity Name : Feeder Unloading at POD" ).append("\n"); 
		query.append("                                 ORDER BY ESTM_DT DESC)" ).append("\n"); 
		query.append("                         WHERE ROWNUM IN (1)" ).append("\n"); 
		query.append("                         UNION ALL   " ).append("\n"); 
		query.append("                        SELECT '' ESTM_DT_A, '' ESTM_DT_B, '' ESTM_DT_C, '' ESTM_DT_D, '' ESTM_DT_E, to_char(ESTM_DT,'YYYYMMDD HH24MISS') ESTM_DT_F, '' ESTM_DT_G " ).append("\n"); 
		query.append("                          FROM (SELECT D.ACT_CD, ESTM_DT" ).append("\n"); 
		query.append("                                 FROM BKG_BOOKING BK" ).append("\n"); 
		query.append("                                    , SCE_COP_HDR H" ).append("\n"); 
		query.append("                                    , SCE_COP_DTL D" ).append("\n"); 
		query.append("                                WHERE BK.BKG_NO = @[bkg_no] " ).append("\n"); 
		query.append("                                  AND BK.BKG_NO = H.BKG_NO" ).append("\n"); 
		query.append("                                  AND D.COP_NO	= H.COP_NO" ).append("\n"); 
		query.append("                                  AND H.COP_STS_CD <> 'X'" ).append("\n"); 
		query.append("                                  AND D.NOD_CD	= H.POD_NOD_CD" ).append("\n"); 
		query.append("                                  AND D.ACT_CD <> 'MITYAD' --Activity Name : I/B Empty Container Returned" ).append("\n"); 
		query.append("                                  AND D.ACT_CD <> 'FITZAD' --Activity Name : Truck Full Container Door Delivery" ).append("\n"); 
		query.append("                                  AND SUBSTR(D.ACT_CD, 5, 1) IN('U')" ).append("\n"); 
		query.append("                                ORDER BY ESTM_DT DESC)" ).append("\n"); 
		query.append("                         WHERE ROWNUM IN (1)" ).append("\n"); 
		query.append("                         UNION ALL  " ).append("\n"); 
		query.append("                        SELECT '' ESTM_DT_A, '' ESTM_DT_B, '' ESTM_DT_C, '' ESTM_DT_D, '' ESTM_DT_E, '' ESTM_DT_F, to_char(ESTM_DT,'YYYYMMDD HH24MISS') ESTM_DT_G" ).append("\n"); 
		query.append("                          FROM (SELECT ROWNUM SEQ_NO, ACT_CD, ESTM_DT" ).append("\n"); 
		query.append("                                  FROM (SELECT BK.BKG_NO, D.ACT_CD, ESTM_DT" ).append("\n"); 
		query.append("                                          FROM BKG_BOOKING BK" ).append("\n"); 
		query.append("                                             , SCE_COP_HDR H" ).append("\n"); 
		query.append("                                             , SCE_COP_DTL D" ).append("\n"); 
		query.append("                                         WHERE BK.BKG_NO = @[bkg_no] " ).append("\n"); 
		query.append("                                           AND BK.BKG_NO = H.BKG_NO" ).append("\n"); 
		query.append("                                           AND D.COP_NO	= H.COP_NO" ).append("\n"); 
		query.append("                                           AND D.ACT_CD <> 'MITYAD' --Activity Name : I/B Empty Container Returned" ).append("\n"); 
		query.append("                                           AND D.ACT_CD <> 'FITZAD' --Activity Name : Truck Full Container Door Delivery" ).append("\n"); 
		query.append("                                         ORDER BY ESTM_DT DESC)" ).append("\n"); 
		query.append("                                )     " ).append("\n"); 
		query.append("                         WHERE SEQ_NO IN (SELECT COUNT(1)+1 FROM SCE_COP_HDR WHERE BKG_NO = @[bkg_no] AND COP_STS_CD <> 'X')" ).append("\n"); 
		query.append("                       ) ETA_LIST" ).append("\n"); 
		query.append("                 WHERE BK.BKG_NO =@[bkg_no]" ).append("\n"); 
		query.append("	            ) ) DEL_ETA" ).append("\n"); 
		query.append("	  ,(SELECT VPS_ETA_DT N1ST_ETA" ).append("\n"); 
		query.append("		  FROM VSK_VSL_PORT_SKD" ).append("\n"); 
		query.append("		 WHERE VPS_PORT_CD  = @[pol_cd]" ).append("\n"); 
		query.append("		   AND CLPT_IND_SEQ = NVL((SELECT VVD.POL_CLPT_IND_SEQ" ).append("\n"); 
		query.append("									 FROM BKG_VVD VVD" ).append("\n"); 
		query.append("								    WHERE VVD.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("									  AND VVD.POL_CD = @[pol_cd]" ).append("\n"); 
		query.append("								      AND VVD.VSL_CD       = substr(@[bkg_vvd_cd], 1, 4)" ).append("\n"); 
		query.append("								      AND VVD.SKD_VOY_NO   = substr(@[bkg_vvd_cd], 5, 4)" ).append("\n"); 
		query.append("								      AND VVD.SKD_DIR_CD   = substr(@[bkg_vvd_cd], 9, 1)" ).append("\n"); 
		query.append("								      AND ROWNUM = 1), '1')" ).append("\n"); 
		query.append("		   AND VSL_CD       = substr(@[bkg_vvd_cd], 1, 4)" ).append("\n"); 
		query.append("		   AND SKD_VOY_NO   = substr(@[bkg_vvd_cd], 5, 4)" ).append("\n"); 
		query.append("		   AND SKD_DIR_CD   = substr(@[bkg_vvd_cd], 9, 1)) N1ST_ETA" ).append("\n"); 

	}
}