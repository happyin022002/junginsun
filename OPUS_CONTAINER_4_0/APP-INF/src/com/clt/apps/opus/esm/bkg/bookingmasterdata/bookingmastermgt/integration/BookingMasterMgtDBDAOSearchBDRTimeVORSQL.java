/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : BookingMasterMgtDBDAOSearchBDRTimeVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.06.10
*@LastModifier : 
*@LastVersion : 1.0
* 2015.06.10 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingmasterdata.bookingmastermgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BookingMasterMgtDBDAOSearchBDRTimeVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Manual로 BDR을 처리
	  * </pre>
	  */
	public BookingMasterMgtDBDAOSearchBDRTimeVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rdo_trunk_feeder",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vvd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bdr_flg",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("Path : com.clt.apps.opus.esm.bkg.bookingmasterdata.bookingmastermgt.integration").append("\n"); 
		query.append("FileName : BookingMasterMgtDBDAOSearchBDRTimeVORSQL").append("\n"); 
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
		query.append("SELECT	T.BKG_NO" ).append("\n"); 
		query.append(",		T.BL_NO" ).append("\n"); 
		query.append(",       T.VSL_CD" ).append("\n"); 
		query.append(",       T.SKD_VOY_NO" ).append("\n"); 
		query.append(",       T.SKD_DIR_CD" ).append("\n"); 
		query.append(",		T.VVD_CD" ).append("\n"); 
		query.append(",       T.SLAN_CD" ).append("\n"); 
		query.append(",       T.POL_CD" ).append("\n"); 
		query.append(",       T.POD_CD" ).append("\n"); 
		query.append(",       T.VPS_PORT_CD" ).append("\n"); 
		query.append(",       T.BDR_DYS" ).append("\n"); 
		query.append(",       T.ETD_DT" ).append("\n"); 
		query.append(",       T.BDR_DATE" ).append("\n"); 
		query.append(",       T.BDR_FLG" ).append("\n"); 
		query.append(",		T.BKG_STS_CD" ).append("\n"); 
		query.append(",		T.CRE_USR_ID" ).append("\n"); 
		query.append(",		T.CRE_DT" ).append("\n"); 
		query.append(",		T.UPD_USR_ID" ).append("\n"); 
		query.append(",		T.USR_NM" ).append("\n"); 
		query.append(",   	T.OFC_CD" ).append("\n"); 
		query.append(",		T.UPD_DT" ).append("\n"); 
		query.append(",		T.RDO_TRUNK_FEEDER" ).append("\n"); 
		query.append(",		T.TOT_BOOKING_CNT" ).append("\n"); 
		query.append(",       T.VVD_BDR" ).append("\n"); 
		query.append(",       CASE WHEN T.BDR_FLG != 'Y' THEN T.TOT_BOOKING_CNT - T.BTR_BOOKING_CNT ELSE T.BTR_BOOKING_CNT END BTR_BOOKING_CNT" ).append("\n"); 
		query.append(",       'B' cgor_team_cd" ).append("\n"); 
		query.append(",       'B/L BDR' cgo_evnt_nm" ).append("\n"); 
		query.append(",       to_char(sysdate,'yyyymmddhh24mmss') evnt_dt" ).append("\n"); 
		query.append(",       'SYS' evnt_ofc_cd" ).append("\n"); 
		query.append(",       'BDRBookingSetting' evnt_usr_id" ).append("\n"); 
		query.append(",       'N' obl_chk" ).append("\n"); 
		query.append(",      (SELECT CASE WHEN (A.BL_TP_CD||B.OBL_RLSE_FLG) = 'WY' THEN 'Y' " ).append("\n"); 
		query.append("                                     WHEN B.OBL_SRND_FLG = 'Y'	THEN 'Y' " ).append("\n"); 
		query.append("                                     ELSE 'N' END" ).append("\n"); 
		query.append("       	FROM 	BKG_BOOKING A," ).append("\n"); 
		query.append("        		BKG_BL_ISS B" ).append("\n"); 
		query.append("        WHERE 	A.BKG_NO = B.BKG_NO" ).append("\n"); 
		query.append("        AND 	A.BKG_NO = T.BKG_NO) AS OBL_ISS_FLAG" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("--,       (SELECT ISS.OBL_ISS_FLG FROM BKG_BL_ISS ISS WHERE ISS.BKG_NO = T.BKG_NO ) AS OBL_ISS_FLAG" ).append("\n"); 
		query.append(",		T.BKG_BDR_USR_ID" ).append("\n"); 
		query.append(", 		T.BKG_MNL_BDR_UPD_DT" ).append("\n"); 
		query.append(",		T.BKG_OFC_CD" ).append("\n"); 
		query.append(",		T.VVD_BDR_USR_ID" ).append("\n"); 
		query.append(", 		T.VVD_MNL_BDR_UPD_DT" ).append("\n"); 
		query.append(",		T.VVD_OFC_CD" ).append("\n"); 
		query.append("FROM 	(" ).append("\n"); 
		query.append("SELECT 	A.BKG_NO" ).append("\n"); 
		query.append(",		A.BL_NO" ).append("\n"); 
		query.append(",       B.VSL_CD" ).append("\n"); 
		query.append(",       B.SKD_VOY_NO" ).append("\n"); 
		query.append(",       B.SKD_DIR_CD" ).append("\n"); 
		query.append(",		B.VSL_CD || B.SKD_VOY_NO || B.SKD_DIR_CD VVD_CD" ).append("\n"); 
		query.append(",       B.SLAN_CD" ).append("\n"); 
		query.append(",       B.POL_CD" ).append("\n"); 
		query.append(",       B.POD_CD" ).append("\n"); 
		query.append(",       D.VPS_PORT_CD" ).append("\n"); 
		query.append(",       DECODE(@[rdo_trunk_feeder], 'T', C.TRNK_BDR_DYS, C.FDR_BDR_DYS) BDR_DYS" ).append("\n"); 
		query.append(",		TO_CHAR(D.VPS_ETD_DT, 'YYYY-MM-DD HH24:MI') ETD_DT" ).append("\n"); 
		query.append(",       (SELECT BDR_DT FROM BKG_BL_DOC K WHERE K.BKG_NO = A.BKG_NO) AS BDR_DATE" ).append("\n"); 
		query.append(",       G.BDR_FLG" ).append("\n"); 
		query.append(",		A.BKG_STS_CD" ).append("\n"); 
		query.append(",		G.CRE_USR_ID" ).append("\n"); 
		query.append(",		G.CRE_DT" ).append("\n"); 
		query.append(",		G.UPD_USR_ID" ).append("\n"); 
		query.append(",   	U.USR_NM" ).append("\n"); 
		query.append(",   	U.OFC_CD" ).append("\n"); 
		query.append(",		G.UPD_DT" ).append("\n"); 
		query.append(",		'' RDO_TRUNK_FEEDER" ).append("\n"); 
		query.append(",       CASE WHEN  TRNK_AUTO_BDR_FLG = 'Y' OR TRNK_MNL_BDR_FLG = 'Y' OR TRNK_BDR_FLG = 'Y'" ).append("\n"); 
		query.append("                           OR FDR_AUTO_BDR_FLG = 'Y' OR FDR_MNL_BDR_FLG = 'Y' OR FDR_BDR_FLG = 'Y' THEN" ).append("\n"); 
		query.append("                           'Yes' ELSE 'No' END  AS VVD_BDR" ).append("\n"); 
		query.append(",		COUNT(*) OVER() TOT_BOOKING_CNT" ).append("\n"); 
		query.append(",       COUNT(*) OVER(PARTITION BY G.BDR_FLG) BTR_BOOKING_CNT" ).append("\n"); 
		query.append(",		F.BDR_USR_ID VVD_BDR_USR_ID" ).append("\n"); 
		query.append(",		F.MNL_BDR_UPD_DT VVD_MNL_BDR_UPD_DT" ).append("\n"); 
		query.append(",		V.OFC_CD VVD_OFC_CD" ).append("\n"); 
		query.append(",		G.BDR_USR_ID BKG_BDR_USR_ID" ).append("\n"); 
		query.append(",		G.MNL_BDR_UPD_DT BKG_MNL_BDR_UPD_DT " ).append("\n"); 
		query.append(",		W.OFC_CD BKG_OFC_CD" ).append("\n"); 
		query.append("  FROM BKG_BOOKING A," ).append("\n"); 
		query.append("       BKG_VVD B," ).append("\n"); 
		query.append("       BKG_BDR_TM C," ).append("\n"); 
		query.append("       VSK_VSL_PORT_SKD D" ).append("\n"); 
		query.append("#if (${bkg_no} != '') " ).append("\n"); 
		query.append("		,VSK_VSL_PORT_SKD E," ).append("\n"); 
		query.append("#else " ).append("\n"); 
		query.append("	," ).append("\n"); 
		query.append("       (SELECT VSL_CD," ).append("\n"); 
		query.append("               SKD_VOY_NO," ).append("\n"); 
		query.append("               SKD_DIR_CD," ).append("\n"); 
		query.append("               VPS_PORT_CD," ).append("\n"); 
		query.append("               CLPT_IND_SEQ" ).append("\n"); 
		query.append("          FROM VSK_VSL_PORT_SKD" ).append("\n"); 
		query.append("         WHERE 1=1" ).append("\n"); 
		query.append("#if (${vvd_cd} != '') 	" ).append("\n"); 
		query.append("		 AND   VSL_CD = SUBSTR(@[vvd_cd],1,4)" ).append("\n"); 
		query.append("         AND   SKD_VOY_NO = SUBSTR(@[vvd_cd],5,4)" ).append("\n"); 
		query.append("         AND   SKD_DIR_CD = SUBSTR(@[vvd_cd],9,1)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("         ) E," ).append("\n"); 
		query.append("#end	" ).append("\n"); 
		query.append("       BKG_VVD_BDR_LOG F," ).append("\n"); 
		query.append("       BKG_BL_DOC G," ).append("\n"); 
		query.append("	   COM_USER U," ).append("\n"); 
		query.append("	   COM_USER V," ).append("\n"); 
		query.append("	   COM_USER W			" ).append("\n"); 
		query.append(" WHERE 1=1" ).append("\n"); 
		query.append(" AND    A.BKG_STS_CD <> 'X'" ).append("\n"); 
		query.append(" --AND	A.BKG_STS_CD IN ('F','S')   " ).append("\n"); 
		query.append(" AND   A.BKG_CGO_TP_CD != 'P'" ).append("\n"); 
		query.append(" AND   B.BKG_NO = A.BKG_NO " ).append("\n"); 
		query.append(" AND   B.VSL_PRE_PST_CD = DECODE(@[rdo_trunk_feeder], 'T', 'T', 'S') " ).append("\n"); 
		query.append(" AND   B.VSL_SEQ = DECODE(@[rdo_trunk_feeder], 'T', '0', '1') " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${vvd_cd} != '') " ).append("\n"); 
		query.append(" AND   B.VSL_CD = SUBSTR(@[vvd_cd],1,4)" ).append("\n"); 
		query.append(" AND   B.SKD_VOY_NO = SUBSTR(@[vvd_cd],5,4)" ).append("\n"); 
		query.append(" AND   B.SKD_DIR_CD = SUBSTR(@[vvd_cd],9,1)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${pol_cd} != '') " ).append("\n"); 
		query.append(" AND   B.POL_CD = @[pol_cd]" ).append("\n"); 
		query.append(" AND   B.POD_CD = NVL(@[pod_cd], B.POD_CD) " ).append("\n"); 
		query.append("#end " ).append("\n"); 
		query.append(" " ).append("\n"); 
		query.append("#if (${bkg_no} != '') " ).append("\n"); 
		query.append(" AND   A.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(" AND   C.SLAN_CD(+) = B.SLAN_CD " ).append("\n"); 
		query.append(" AND   C.SKD_DIR_CD(+) = B.SKD_DIR_CD " ).append("\n"); 
		query.append(" AND   C.POL_CD(+) = B.POL_CD " ).append("\n"); 
		query.append(" AND   C.POD_CD(+) = B.POD_CD " ).append("\n"); 
		query.append(" AND   D.VSL_CD = B.VSL_CD " ).append("\n"); 
		query.append(" AND   D.SKD_VOY_NO = B.SKD_VOY_NO " ).append("\n"); 
		query.append(" AND   D.SKD_DIR_CD = B.SKD_DIR_CD " ).append("\n"); 
		query.append(" AND   D.VPS_PORT_CD = B.POL_CD " ).append("\n"); 
		query.append(" AND   D.CLPT_IND_SEQ = B.POL_CLPT_IND_SEQ " ).append("\n"); 
		query.append(" AND   D.VSL_CD = E.VSL_CD " ).append("\n"); 
		query.append(" AND   D.SKD_VOY_NO = E.SKD_VOY_NO " ).append("\n"); 
		query.append(" AND   D.SKD_DIR_CD = E.SKD_DIR_CD" ).append("\n"); 
		query.append(" AND   D.VPS_PORT_CD = E.VPS_PORT_CD " ).append("\n"); 
		query.append(" AND   D.CLPT_IND_SEQ = E.CLPT_IND_SEQ " ).append("\n"); 
		query.append(" AND   B.VSL_CD = F.VSL_CD(+) " ).append("\n"); 
		query.append(" AND   B.SKD_VOY_NO = F.SKD_VOY_NO(+) " ).append("\n"); 
		query.append(" AND   B.SKD_DIR_CD = F.SKD_DIR_CD(+) " ).append("\n"); 
		query.append(" AND   B.POL_CLPT_IND_SEQ = F.POL_CLPT_IND_SEQ(+) " ).append("\n"); 
		query.append(" AND   B.POD_CLPT_IND_SEQ = F.POD_CLPT_IND_SEQ(+) " ).append("\n"); 
		query.append(" AND   B.POL_CD = F.POL_CD(+) " ).append("\n"); 
		query.append(" AND   B.POD_CD = F.POD_CD(+)" ).append("\n"); 
		query.append(" AND   A.BKG_NO = G.BKG_NO" ).append("\n"); 
		query.append(" AND   G.UPD_USR_ID = U.USR_ID(+)" ).append("\n"); 
		query.append(" AND   F.BDR_USR_ID = V.USR_ID(+)" ).append("\n"); 
		query.append(" AND   G.BDR_USR_ID = W.USR_ID(+)" ).append("\n"); 
		query.append(") T" ).append("\n"); 
		query.append("WHERE  1=1" ).append("\n"); 
		query.append("#if (${bdr_flg} != '') " ).append("\n"); 
		query.append("AND BDR_FLG  = 	 @[bdr_flg] " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("ORDER BY T.BKG_NO" ).append("\n"); 
		query.append(",		T.BL_NO" ).append("\n"); 
		query.append(",       T.VSL_CD" ).append("\n"); 
		query.append(",       T.SKD_VOY_NO" ).append("\n"); 
		query.append(",       T.SKD_DIR_CD" ).append("\n"); 
		query.append(",		T.VVD_CD" ).append("\n"); 

	}
}