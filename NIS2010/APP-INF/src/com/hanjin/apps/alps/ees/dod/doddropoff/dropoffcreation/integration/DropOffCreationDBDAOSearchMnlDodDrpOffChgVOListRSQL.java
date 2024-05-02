/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : DropOffCreationDBDAOSearchMnlDodDrpOffChgVOListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.12.24
*@LastModifier : 손진환
*@LastVersion : 1.0
* 2015.12.24 손진환
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.dod.doddropoff.dropoffcreation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Son, Jin-Hwan
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class DropOffCreationDBDAOSearchMnlDodDrpOffChgVOListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * BKG 정보중 RTN CY를 알 수없는 booking으로 직접데이터를 생성하기 위한 대상을 가져온다. Manual Invoice Creation화면에서 호출한다. 
	  * </pre>
	  */
	public DropOffCreationDBDAOSearchMnlDodDrpOffChgVOListRSQL(){
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
		params.put("ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.dod.doddropoff.dropoffcreation.integration").append("\n"); 
		query.append("FileName : DropOffCreationDBDAOSearchMnlDodDrpOffChgVOListRSQL").append("\n"); 
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
		query.append("SELECT A.TRO_IB_CFM_OFC_CD," ).append("\n"); 
		query.append("       A.TRO_IB_CFM_DT," ).append("\n"); 
		query.append("       A.CNTR_RTN_DT," ).append("\n"); 
		query.append("       A.BKG_NO BKG_NO," ).append("\n"); 
		query.append("	   A.BL_NO," ).append("\n"); 
		query.append("       A.CNTR_NO CNTR_NO," ).append("\n"); 
		query.append("       A.CNTR_TPSZ_CD CNTR_TPSZ_CD," ).append("\n"); 
		query.append("       A.DEL_CD DEL_CD," ).append("\n"); 
		query.append("        CASE" ).append("\n"); 
		query.append("            WHEN A.CUST_SEQ IS NULL OR A.CUST_CNT_CD IS NULL" ).append("\n"); 
		query.append("            THEN (SELECT U.CUST_CNT_CD" ).append("\n"); 
		query.append("                    FROM BKG_CUSTOMER U" ).append("\n"); 
		query.append("                   WHERE U.BKG_NO = A.BKG_NO" ).append("\n"); 
		query.append("                     AND U.BKG_CUST_TP_CD = 'N' ) " ).append("\n"); 
		query.append("            ELSE" ).append("\n"); 
		query.append("                 A.CUST_CNT_CD" ).append("\n"); 
		query.append("        END CUST_CNT_CD," ).append("\n"); 
		query.append("        CASE" ).append("\n"); 
		query.append("            WHEN A.CUST_SEQ IS NULL OR A.CUST_CNT_CD IS NULL" ).append("\n"); 
		query.append("            THEN (SELECT U.CUST_SEQ" ).append("\n"); 
		query.append("                    FROM BKG_CUSTOMER U" ).append("\n"); 
		query.append("                   WHERE U.BKG_NO = A.BKG_NO" ).append("\n"); 
		query.append("                     AND U.BKG_CUST_TP_CD = 'N' ) " ).append("\n"); 
		query.append("            ELSE" ).append("\n"); 
		query.append("                 A.CUST_SEQ" ).append("\n"); 
		query.append("        END CUST_SEQ," ).append("\n"); 
		query.append("        CASE" ).append("\n"); 
		query.append("            WHEN A.CUST_SEQ IS NULL OR A.CUST_CNT_CD IS NULL" ).append("\n"); 
		query.append("            THEN (SELECT SUBSTR(C.CUST_LGL_ENG_NM, 1, 50)" ).append("\n"); 
		query.append("                    FROM MDM_CUSTOMER C, BKG_CUSTOMER U" ).append("\n"); 
		query.append("                   WHERE C.CUST_CNT_CD = U.CUST_CNT_CD" ).append("\n"); 
		query.append("                     AND C.CUST_SEQ = U.CUST_SEQ" ).append("\n"); 
		query.append("                     AND U.BKG_NO = A.BKG_NO" ).append("\n"); 
		query.append("                     AND U.BKG_CUST_TP_CD = 'N' )" ).append("\n"); 
		query.append("            ELSE" ).append("\n"); 
		query.append("                 A.CUST_LGL_ENG_NM" ).append("\n"); 
		query.append("        END CUST_LGL_ENG_NM," ).append("\n"); 
		query.append("        CASE" ).append("\n"); 
		query.append("            WHEN A.CUST_SEQ IS NULL OR A.CUST_CNT_CD IS NULL" ).append("\n"); 
		query.append("            THEN (SELECT U.CUST_CNT_CD|| LPAD(U.CUST_SEQ, 6, 0)" ).append("\n"); 
		query.append("                    FROM BKG_CUSTOMER U" ).append("\n"); 
		query.append("                   WHERE U.BKG_NO = A.BKG_NO" ).append("\n"); 
		query.append("                     AND U.BKG_CUST_TP_CD = 'N' )" ).append("\n"); 
		query.append("            ELSE" ).append("\n"); 
		query.append("                 A.CUST_CNT_CD|| LPAD(A.CUST_SEQ, 6, 0)" ).append("\n"); 
		query.append("        END CUST_CD_SEQ," ).append("\n"); 
		query.append("        CASE" ).append("\n"); 
		query.append("            WHEN A.CUST_SEQ IS NULL OR A.CUST_CNT_CD IS NULL" ).append("\n"); 
		query.append("            THEN (SELECT U.CUST_CNT_CD" ).append("\n"); 
		query.append("                    FROM BKG_CUSTOMER U" ).append("\n"); 
		query.append("                   WHERE U.BKG_NO = A.BKG_NO" ).append("\n"); 
		query.append("                     AND U.BKG_CUST_TP_CD = 'N' ) " ).append("\n"); 
		query.append("            ELSE" ).append("\n"); 
		query.append("                 A.CUST_CNT_CD" ).append("\n"); 
		query.append("        END TMP_CUST_CNT_CD," ).append("\n"); 
		query.append("        CASE" ).append("\n"); 
		query.append("            WHEN A.CUST_SEQ IS NULL OR A.CUST_CNT_CD IS NULL" ).append("\n"); 
		query.append("            THEN (SELECT U.CUST_SEQ" ).append("\n"); 
		query.append("                    FROM BKG_CUSTOMER U" ).append("\n"); 
		query.append("                   WHERE U.BKG_NO = A.BKG_NO" ).append("\n"); 
		query.append("                     AND U.BKG_CUST_TP_CD = 'N' ) " ).append("\n"); 
		query.append("            ELSE" ).append("\n"); 
		query.append("                 A.CUST_SEQ" ).append("\n"); 
		query.append("        END TMP_CUST_SEQ," ).append("\n"); 
		query.append("        CASE" ).append("\n"); 
		query.append("            WHEN A.CUST_SEQ IS NULL OR A.CUST_CNT_CD IS NULL" ).append("\n"); 
		query.append("            THEN (SELECT SUBSTR(C.CUST_LGL_ENG_NM, 1, 50)" ).append("\n"); 
		query.append("                    FROM MDM_CUSTOMER C, BKG_CUSTOMER U" ).append("\n"); 
		query.append("                   WHERE C.CUST_CNT_CD = U.CUST_CNT_CD" ).append("\n"); 
		query.append("                     AND C.CUST_SEQ = U.CUST_SEQ" ).append("\n"); 
		query.append("                     AND U.BKG_NO = A.BKG_NO" ).append("\n"); 
		query.append("                     AND U.BKG_CUST_TP_CD = 'N' )" ).append("\n"); 
		query.append("            ELSE" ).append("\n"); 
		query.append("                 A.CUST_LGL_ENG_NM" ).append("\n"); 
		query.append("        END TMP_CUST_LGL_ENG_NM," ).append("\n"); 
		query.append("        CASE" ).append("\n"); 
		query.append("            WHEN A.CUST_SEQ IS NULL OR A.CUST_CNT_CD IS NULL" ).append("\n"); 
		query.append("            THEN (SELECT U.CUST_CNT_CD|| LPAD(U.CUST_SEQ, 6, 0)" ).append("\n"); 
		query.append("                    FROM BKG_CUSTOMER U" ).append("\n"); 
		query.append("                   WHERE U.BKG_NO = A.BKG_NO" ).append("\n"); 
		query.append("                     AND U.BKG_CUST_TP_CD = 'N' )" ).append("\n"); 
		query.append("            ELSE" ).append("\n"); 
		query.append("                 A.CUST_CNT_CD|| LPAD(A.CUST_SEQ, 6, 0)" ).append("\n"); 
		query.append("        END TMP_CUST_CD_SEQ," ).append("\n"); 
		query.append("       A.SPCL_CUST_CNT_CD," ).append("\n"); 
		query.append("       A.SPCL_CUST_SEQ," ).append("\n"); 
		query.append("       A.SPCL_CUST_CNT_CD|| LPAD(A.SPCL_CUST_SEQ, 6, 0) SPCL_CD_SEQ," ).append("\n"); 
		query.append("       A.SPCL_CUST_LGL_ENG_NM," ).append("\n"); 
		query.append("       A.RFA_NO," ).append("\n"); 
		query.append("       A.SC_NO" ).append("\n"); 
		query.append("  FROM (SELECT @[ofc_cd] TRO_IB_CFM_OFC_CD," ).append("\n"); 
		query.append("               '' TRO_IB_CFM_DT," ).append("\n"); 
		query.append("               '' CNTR_RTN_DT," ).append("\n"); 
		query.append("               B.BKG_NO BKG_NO," ).append("\n"); 
		query.append("			   B.BL_NO," ).append("\n"); 
		query.append("               C.CNTR_NO CNTR_NO," ).append("\n"); 
		query.append("               C.CNTR_TPSZ_CD CNTR_TPSZ_CD," ).append("\n"); 
		query.append("               B.DEL_CD DEL_CD," ).append("\n"); 
		query.append("               (SELECT U.CUST_CNT_CD" ).append("\n"); 
		query.append("                  FROM BKG_CUSTOMER U" ).append("\n"); 
		query.append("                 WHERE U.BKG_NO = B.BKG_NO" ).append("\n"); 
		query.append("                   AND U.BKG_CUST_TP_CD = 'C' ) CUST_CNT_CD," ).append("\n"); 
		query.append("               (SELECT U.CUST_SEQ" ).append("\n"); 
		query.append("                  FROM BKG_CUSTOMER U" ).append("\n"); 
		query.append("                 WHERE U.BKG_NO = B.BKG_NO" ).append("\n"); 
		query.append("                   AND U.BKG_CUST_TP_CD = 'C' ) CUST_SEQ," ).append("\n"); 
		query.append("               (SELECT U.CUST_CNT_CD" ).append("\n"); 
		query.append("                  FROM BKG_CUSTOMER U" ).append("\n"); 
		query.append("                 WHERE U.BKG_NO = B.BKG_NO" ).append("\n"); 
		query.append("                   AND U.BKG_CUST_TP_CD = 'C' )|| LPAD((SELECT U.CUST_SEQ" ).append("\n"); 
		query.append("                          FROM BKG_CUSTOMER U" ).append("\n"); 
		query.append("                         WHERE U.BKG_NO = B.BKG_NO" ).append("\n"); 
		query.append("                           AND U.BKG_CUST_TP_CD = 'C' ), 6, 0) CUST_CD_SEQ," ).append("\n"); 
		query.append("               (SELECT SUBSTR(C.CUST_LGL_ENG_NM, 1, 50)" ).append("\n"); 
		query.append("                  FROM MDM_CUSTOMER C," ).append("\n"); 
		query.append("                       BKG_CUSTOMER U" ).append("\n"); 
		query.append("                 WHERE C.CUST_CNT_CD = U.CUST_CNT_CD" ).append("\n"); 
		query.append("                   AND C.CUST_SEQ = U.CUST_SEQ" ).append("\n"); 
		query.append("                   AND U.BKG_NO = B.BKG_NO" ).append("\n"); 
		query.append("                   AND U.BKG_CUST_TP_CD = 'C' ) CUST_LGL_ENG_NM," ).append("\n"); 
		query.append("               B.AGMT_ACT_CNT_CD SPCL_CUST_CNT_CD," ).append("\n"); 
		query.append("               DECODE(B.AGMT_ACT_CUST_SEQ, 0, '', B.AGMT_ACT_CUST_SEQ) SPCL_CUST_SEQ," ).append("\n"); 
		query.append("               B.AGMT_ACT_CNT_CD|| LPAD(DECODE(B.AGMT_ACT_CUST_SEQ, 0, '', B.AGMT_ACT_CUST_SEQ), 6, 0) SPCL_CD_SEQ," ).append("\n"); 
		query.append("               (SELECT SUBSTR(C.CUST_LGL_ENG_NM, 1, 50)" ).append("\n"); 
		query.append("                  FROM MDM_CUSTOMER C" ).append("\n"); 
		query.append("                 WHERE C.CUST_CNT_CD = B.AGMT_ACT_CNT_CD" ).append("\n"); 
		query.append("                   AND C.CUST_SEQ = B.AGMT_ACT_CUST_SEQ ) SPCL_CUST_LGL_ENG_NM," ).append("\n"); 
		query.append("               B.RFA_NO," ).append("\n"); 
		query.append("               B.SC_NO" ).append("\n"); 
		query.append("          FROM BKG_BOOKING B," ).append("\n"); 
		query.append("               BKG_CONTAINER C," ).append("\n"); 
		query.append("               (SELECT RANK() OVER (PARTITION BY G.BKG_NO, G.CNTR_NO, G.DEL_CD" ).append("\n"); 
		query.append("                         ORDER BY G.UPD_DT DESC) RNK," ).append("\n"); 
		query.append("                       G.*" ).append("\n"); 
		query.append("                  FROM DOD_DRP_OFF_CHG G ) G" ).append("\n"); 
		query.append("         WHERE 1 = 1" ).append("\n"); 
		query.append("           AND B.BKG_NO = C.BKG_NO" ).append("\n"); 
		query.append("           AND C.BKG_NO = G.BKG_NO(+)" ).append("\n"); 
		query.append("           AND C.CNTR_NO = G.CNTR_NO(+)" ).append("\n"); 
		query.append("           AND 'N' = G.TRO_IB_CXL_FLG(+)" ).append("\n"); 
		query.append("           AND 1 = G.RNK(+)" ).append("\n"); 
		query.append("           AND NOT EXISTS (SELECT 'OK'" ).append("\n"); 
		query.append("                  FROM DOD_DRP_OFF_CHG G" ).append("\n"); 
		query.append("                 WHERE C.BKG_NO = G.BKG_NO" ).append("\n"); 
		query.append("                   AND C.CNTR_NO = G.CNTR_NO" ).append("\n"); 
		query.append("                   AND B.DEL_CD = G.DEL_CD" ).append("\n"); 
		query.append("                   AND 'N' = G.TRO_IB_CXL_FLG" ).append("\n"); 
		query.append("                   AND 1 = G.RNK )" ).append("\n"); 
		query.append("#if (${bkg_no} != '') " ).append("\n"); 
		query.append("                   AND B.BKG_NO IN (" ).append("\n"); 
		query.append("                        #foreach ($user_bkg_no IN ${bkgNos})" ).append("\n"); 
		query.append("                            #if($velocityCount < $bkgNos.size())" ).append("\n"); 
		query.append("                                '$user_bkg_no'," ).append("\n"); 
		query.append("                            #else" ).append("\n"); 
		query.append("                                '$user_bkg_no'" ).append("\n"); 
		query.append("                            #end" ).append("\n"); 
		query.append("                        #end" ).append("\n"); 
		query.append("                        )" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${cntr_no} != '') " ).append("\n"); 
		query.append("                   AND C.CNTR_NO = @[cntr_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(" 				   AND EXISTS (SELECT 'OK'" ).append("\n"); 
		query.append("                        FROM BKG_EUR_TRO T" ).append("\n"); 
		query.append("                       WHERE B.BKG_NO = T.BKG_NO" ).append("\n"); 
		query.append("                         AND T.CFM_FLG = 'Y'" ).append("\n"); 
		query.append("                         AND T.CXL_FLG = 'N'" ).append("\n"); 
		query.append("                         AND T.IO_BND_CD = 'I'" ).append("\n"); 
		query.append("                         AND ((T.HLG_TP_CD = 'M' AND SUBSTR(T.CNTR_RTN_YD_CD, 1, 5) = B.DEL_CD)" ).append("\n"); 
		query.append("                             OR (T.HLG_TP_CD = 'C' AND 1 = 1))" ).append("\n"); 
		query.append("                         AND C.CNTR_NO = T.CNTR_NO)" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("           ) A" ).append("\n"); 
		query.append(" WHERE 1 = 1" ).append("\n"); 

	}
}