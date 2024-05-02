/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : InboundNoticeBackEndDBDAOmodifyArrNtcUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.05.29
*@LastModifier : 
*@LastVersion : 1.0
* 2015.05.29 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class InboundNoticeBackEndDBDAOmodifyArrNtcUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * match case에 대한 Arrival Notice Master를 merge 한다.
	  * </pre>
	  */
	public InboundNoticeBackEndDBDAOmodifyArrNtcUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("val_usr_id",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("vps_eta_dt_end",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("del_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
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
		params.put("bl_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pol_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vps_eta_dt_start",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.integration").append("\n"); 
		query.append("FileName : InboundNoticeBackEndDBDAOmodifyArrNtcUSQL").append("\n"); 
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
		query.append("INSERT INTO BKG_ARR_NTC " ).append("\n"); 
		query.append("       (BKG_NO" ).append("\n"); 
		query.append("      , VSL_CD" ).append("\n"); 
		query.append("      , SKD_VOY_NO" ).append("\n"); 
		query.append("      , SKD_DIR_CD" ).append("\n"); 
		query.append("      , CRE_USR_ID" ).append("\n"); 
		query.append("      , CRE_DT  " ).append("\n"); 
		query.append("      , UPD_USR_ID -- 15" ).append("\n"); 
		query.append("      , UPD_DT " ).append("\n"); 
		query.append("      )" ).append("\n"); 
		query.append("SELECT SUBQ.BKG_NO" ).append("\n"); 
		query.append("     , MAX(SUBQ.VSL_CD     ) VSL_CD" ).append("\n"); 
		query.append("     , MAX(SUBQ.SKD_VOY_NO ) SKD_VOY_NO" ).append("\n"); 
		query.append("     , MAX(SUBQ.SKD_DIR_CD ) SKD_DIR_CD" ).append("\n"); 
		query.append("     , @[val_usr_id] CRE_USR_ID" ).append("\n"); 
		query.append("     , SYSDATE       CRE_DT  " ).append("\n"); 
		query.append("     , @[val_usr_id] UPD_USR_ID" ).append("\n"); 
		query.append("     , SYSDATE       UPD_DT  " ).append("\n"); 
		query.append("  FROM( " ).append("\n"); 
		query.append("       SELECT BKGM.BKG_NO" ).append("\n"); 
		query.append("            , BCST.BKG_CUST_TP_CD" ).append("\n"); 
		query.append("            , BVVD.VSL_CD     " ).append("\n"); 
		query.append("            , BVVD.SKD_VOY_NO " ).append("\n"); 
		query.append("            , BVVD.SKD_DIR_CD" ).append("\n"); 
		query.append("        FROM BKG_BOOKING BKGM" ).append("\n"); 
		query.append("            JOIN BKG_VVD BVVD ON" ).append("\n"); 
		query.append("            ( BVVD.BKG_NO = BKGM.BKG_NO" ).append("\n"); 
		query.append("#if ( ${ts_flg} != 'Y')     " ).append("\n"); 
		query.append("              AND BVVD.POD_CD = BKGM.POD_CD" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("              AND BVVD.POD_CD = BKGM.PST_RLY_PORT_CD" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("              AND BKGM.BKG_STS_CD NOT IN ('X', 'S') -- 무효한 bkg제거 -- AS IS와 동일하게 하기위해 추가 20091124" ).append("\n"); 
		query.append("              AND BKGM.BL_NO IS NOT NULL  -- AS IS와 동일하게 하기위해 추가 20091124" ).append("\n"); 
		query.append("              AND BKGM.BKG_CGO_TP_CD IN ('F', 'R') -- full, revenue empty container" ).append("\n"); 
		query.append("            ) " ).append("\n"); 
		query.append("#if ( ${sch_tp} == 'D') " ).append("\n"); 
		query.append("            JOIN VSK_VSL_PORT_SKD VSKD ON" ).append("\n"); 
		query.append("            ( BVVD.VSL_PRE_PST_CD IN ('T', 'U') -- 입항 VVD (S는 제거)" ).append("\n"); 
		query.append("              AND BVVD.VSL_CD = VSKD.VSL_CD " ).append("\n"); 
		query.append("              AND BVVD.SKD_VOY_NO = VSKD.SKD_VOY_NO" ).append("\n"); 
		query.append("              AND BVVD.SKD_DIR_CD = VSKD.SKD_DIR_CD" ).append("\n"); 
		query.append("              AND BVVD.POD_CD = VSKD.VPS_PORT_CD" ).append("\n"); 
		query.append("              AND BVVD.POD_CLPT_IND_SEQ = VSKD.CLPT_IND_SEQ " ).append("\n"); 
		query.append("            )" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("            JOIN BKG_CUSTOMER BCST ON -- BOOKING CUSTOMER" ).append("\n"); 
		query.append("                 ( BKGM.BKG_NO = BCST.BKG_NO" ).append("\n"); 
		query.append("                  AND BCST.BKG_CUST_TP_CD IN ( 'C', 'N' )" ).append("\n"); 
		query.append("                  AND BCST.AN_SND_FLG = 'Y' -- Arrival Notice를 보내는 경우에 대해서만 Arrival Notice Master를 생성한다." ).append("\n"); 
		query.append("                 )  " ).append("\n"); 
		query.append("            JOIN MDM_LOCATION MLOC" ).append("\n"); 
		query.append("              ON (MLOC.LOC_CD = BKGM.DEL_CD)" ).append("\n"); 
		query.append("       WHERE 1 = 1" ).append("\n"); 
		query.append("#if (${sch_tp} == 'V') " ).append("\n"); 
		query.append("         AND BVVD.VSL_CD  = substr(@[vvd],1,4)      -- VVD (OPTIONAL 1)" ).append("\n"); 
		query.append("         AND BVVD.SKD_VOY_NO = substr(@[vvd],5,4)   -- VVD (OPTIONAL 1)" ).append("\n"); 
		query.append("         AND BVVD.SKD_DIR_CD = substr(@[vvd],9,1)   -- VVD (OPTIONAL 1)" ).append("\n"); 
		query.append("         AND BVVD.POD_CD IN (${pod_cd}) -- CodeValidationBackEndJob IN 처리" ).append("\n"); 
		query.append("#elseif (${sch_tp} == 'D') " ).append("\n"); 
		query.append("         AND VSKD.VPS_ETA_DT BETWEEN TO_DATE(@[vps_eta_dt_start], 'YYYYMMDD') AND (TO_DATE(@[vps_eta_dt_end], 'YYYYMMDD') +1)  -- DURATION (OPTIONAL 2)" ).append("\n"); 
		query.append("         AND VSKD.VPS_PORT_CD = @[pod_cd] -- (OPTIONAL 3)" ).append("\n"); 
		query.append("#elseif (${sch_tp} == 'B') " ).append("\n"); 
		query.append("         AND BKGM.BL_NO = @[bl_no]  -- BL NO (OPTIONAL 5-1)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${sch_tp} != 'B' && ${del_cd} != '') " ).append("\n"); 
		query.append("         AND BKGM.DEL_CD LIKE @[del_cd] || '%'  -- DELIVERY PORT CD (OPTIONAL 4)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${sch_tp} != 'B' && ${pol_cd} != '') " ).append("\n"); 
		query.append("         AND BKGM.POL_CD = @[pol_cd] -- (OPTIONAL)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("           ) SUBQ" ).append("\n"); 
		query.append(" WHERE NOT EXISTS ( SELECT 1 " ).append("\n"); 
		query.append("                      FROM BKG_ARR_NTC ANTC" ).append("\n"); 
		query.append("                     WHERE ANTC.BKG_NO = SUBQ.BKG_NO" ).append("\n"); 
		query.append("                  )" ).append("\n"); 
		query.append(" GROUP BY SUBQ.BKG_NO" ).append("\n"); 

	}
}