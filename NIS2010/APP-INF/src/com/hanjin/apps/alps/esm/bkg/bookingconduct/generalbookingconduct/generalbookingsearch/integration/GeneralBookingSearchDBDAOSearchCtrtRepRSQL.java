/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : GeneralBookingSearchDBDAOSearchCtrtRepRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.11.15
*@LastModifier : 
*@LastVersion : 1.0
* 2011.11.15 
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

public class GeneralBookingSearchDBDAOSearchCtrtRepRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * GeneralBookingSearchDBDAOSearchCtrtRepRSQL
	  * </pre>
	  */
	public GeneralBookingSearchDBDAOSearchCtrtRepRSQL(){
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
		params.put("sc_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ctrt_rep_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("app_date",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.integration").append("\n"); 
		query.append("FileName : GeneralBookingSearchDBDAOSearchCtrtRepRSQL").append("\n"); 
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
		query.append("SELECT C.CUST_SLS_OFC_CD" ).append("\n"); 
		query.append(",C.CUST_SREP_CD" ).append("\n"); 
		query.append(",E.SREP_NM" ).append("\n"); 
		query.append(",C.CUST_SLS_OFC_CD||C.CUST_SREP_CD as cust_ofc_rep_cd" ).append("\n"); 
		query.append(",decode(C.CUST_SLS_OFC_CD||C.CUST_SREP_CD ,nvl(@[ctrt_rep_cd],(select CTRT_OFC_CD||CTRT_SREP_CD from bkg_booking where bkg_no = @[bkg_no] )) , 'Y','N') compare_cd" ).append("\n"); 
		query.append("FROM PRI_SP_HDR A" ).append("\n"); 
		query.append(",PRI_SP_MN B" ).append("\n"); 
		query.append(",PRI_SP_REAL_CUST C" ).append("\n"); 
		query.append(",(SELECT APPL_DT" ).append("\n"); 
		query.append("FROM (SELECT 0 RANK,TO_DATE(@[app_date],'YYYYMMDD') APPL_DT FROM DUAL" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT 1 RANK, RT_APLY_DT APPL_DT" ).append("\n"); 
		query.append("FROM BKG_RT_HIS R" ).append("\n"); 
		query.append("WHERE BKG_NO = @[bkg_no] --'SEA104071500'" ).append("\n"); 
		query.append("AND CORR_NO = 'TMP0000001'" ).append("\n"); 
		query.append("AND RT_APLY_DT IS NOT NULL" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT 2 RANK, RT_APLY_DT APPL_DT --RATE APPLICABLE" ).append("\n"); 
		query.append("FROM BKG_RATE R" ).append("\n"); 
		query.append("WHERE BKG_NO = @[bkg_no] --'SEA104071500'" ).append("\n"); 
		query.append("AND RT_APLY_DT IS NOT NULL" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("--                UNION ALL" ).append("\n"); 
		query.append("--                SELECT 3 RANK, SKD.VPS_ETD_DT APPL_DT --sheet 에 있는 값" ).append("\n"); 
		query.append("--                  FROM VSK_VSL_PORT_SKD SKD" ).append("\n"); 
		query.append("--" ).append("\n"); 
		query.append("--                 WHERE SKD.VSL_CD= substr(vvd,1,4)" ).append("\n"); 
		query.append("--                   and SKD.SKD_VOY_NO= substr(vvd,5,4)" ).append("\n"); 
		query.append("--                   and SKD.SKD_DIR_CD = substr(vvd,9,1)" ).append("\n"); 
		query.append("--                   AND SKD.VPS_PORT_CD = :POL_CD" ).append("\n"); 
		query.append("--                   AND SKD.CLPT_IND_SEQ = POL_CLPT_IND_SEQ" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT 3 RANK, SKD.VPS_ETD_DT APPL_DT --ONBOARD DATE" ).append("\n"); 
		query.append("FROM BKG_VVD_HIS VVD" ).append("\n"); 
		query.append(",VSK_VSL_PORT_SKD SKD" ).append("\n"); 
		query.append(",BKG_BKG_HIS BK" ).append("\n"); 
		query.append("WHERE BK.BKG_NO = @[bkg_no] --'SEA104071500'" ).append("\n"); 
		query.append("AND BK.CORR_NO = 'TMP0000001'" ).append("\n"); 
		query.append("AND BK.BKG_NO = VVD.BKG_NO" ).append("\n"); 
		query.append("AND BK.CORR_NO = VVD.CORR_NO" ).append("\n"); 
		query.append("AND VVD.VSL_PRE_PST_CD IN ('S','T')" ).append("\n"); 
		query.append("AND VVD.POL_CD = BK.POL_CD" ).append("\n"); 
		query.append("AND VVD.VSL_CD = SKD.VSL_CD" ).append("\n"); 
		query.append("AND VVD.SKD_VOY_NO = SKD.SKD_VOY_NO" ).append("\n"); 
		query.append("AND VVD.SKD_DIR_CD = SKD.SKD_DIR_CD" ).append("\n"); 
		query.append("AND VVD.POL_CD = SKD.VPS_PORT_CD" ).append("\n"); 
		query.append("AND VVD.POL_CLPT_IND_SEQ = SKD.CLPT_IND_SEQ" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT 4 RANK, SKD.VPS_ETD_DT APPL_DT --ONBOARD DATE" ).append("\n"); 
		query.append("FROM BKG_VVD VVD" ).append("\n"); 
		query.append(",VSK_VSL_PORT_SKD SKD" ).append("\n"); 
		query.append(",BKG_BOOKING BK" ).append("\n"); 
		query.append("WHERE BK.BKG_NO = @[bkg_no] --'SEA104071500'" ).append("\n"); 
		query.append("AND BK.BKG_NO = VVD.BKG_NO" ).append("\n"); 
		query.append("AND VVD.VSL_PRE_PST_CD IN ('S','T')" ).append("\n"); 
		query.append("AND VVD.POL_CD = BK.POL_CD" ).append("\n"); 
		query.append("AND VVD.VSL_CD = SKD.VSL_CD" ).append("\n"); 
		query.append("AND VVD.SKD_VOY_NO = SKD.SKD_VOY_NO" ).append("\n"); 
		query.append("AND VVD.SKD_DIR_CD = SKD.SKD_DIR_CD" ).append("\n"); 
		query.append("AND VVD.POL_CD = SKD.VPS_PORT_CD" ).append("\n"); 
		query.append("AND VVD.POL_CLPT_IND_SEQ = SKD.CLPT_IND_SEQ" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT 5 RANK, SYSDATE APPL_DT" ).append("\n"); 
		query.append("FROM DUAL)" ).append("\n"); 
		query.append("WHERE ROWNUM = 1" ).append("\n"); 
		query.append("AND APPL_DT IS NOT NULL" ).append("\n"); 
		query.append(") D" ).append("\n"); 
		query.append(",MDM_SLS_REP E" ).append("\n"); 
		query.append("--      ,BKG_BOOKING F" ).append("\n"); 
		query.append("WHERE --F.BKG_NO = 'SEA104071500'" ).append("\n"); 
		query.append("A.SC_NO = @[sc_no]" ).append("\n"); 
		query.append("--   AND A.SC_NO = F.SC_NO" ).append("\n"); 
		query.append("AND A.PROP_NO = B.PROP_NO" ).append("\n"); 
		query.append("AND B.PROP_NO = C.PROP_NO" ).append("\n"); 
		query.append("AND B.AMDT_SEQ = C.AMDT_SEQ" ).append("\n"); 
		query.append("AND B.EFF_DT - 0.0001 < D.APPL_DT" ).append("\n"); 
		query.append("AND B.EXP_DT + 0.9999 > D.APPL_DT" ).append("\n"); 
		query.append("AND C.CUST_SREP_CD = E.SREP_CD" ).append("\n"); 
		query.append("AND (   (B.AMDT_SEQ = 0 AND B.PROP_STS_CD = 'F')" ).append("\n"); 
		query.append("OR (B.AMDT_SEQ > 0))" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("UNION" ).append("\n"); 
		query.append("SELECT NVL(B.REAL_CUST_SLS_OFC_CD, B.RESPB_SLS_OFC_CD) CUST_SLS_OFC_CD" ).append("\n"); 
		query.append(",NVL(B.REAL_CUST_SREP_CD, B.RESPB_SREP_CD) CUST_SREP_CD" ).append("\n"); 
		query.append(",E.SREP_NM" ).append("\n"); 
		query.append(",NVL(B.REAL_CUST_SLS_OFC_CD, B.RESPB_SLS_OFC_CD) || NVL(B.REAL_CUST_SREP_CD, B.RESPB_SREP_CD) as cust_ofc_rep_cd" ).append("\n"); 
		query.append(",decode(NVL(B.REAL_CUST_SLS_OFC_CD, B.RESPB_SLS_OFC_CD) || NVL(B.REAL_CUST_SREP_CD, B.RESPB_SREP_CD) ,nvl(@[ctrt_rep_cd],(select CTRT_OFC_CD||CTRT_SREP_CD from bkg_booking where bkg_no = @[bkg_no] AND SC_NO = @[sc_no] )) , 'Y','N') compare_cd" ).append("\n"); 
		query.append("FROM PRI_SP_HDR A" ).append("\n"); 
		query.append(",PRI_SP_MN B" ).append("\n"); 
		query.append(",(SELECT APPL_DT" ).append("\n"); 
		query.append("FROM (SELECT 0 RANK,TO_DATE(@[app_date],'YYYYMMDD') APPL_DT FROM DUAL" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT 1 RANK, RT_APLY_DT APPL_DT" ).append("\n"); 
		query.append("FROM BKG_RT_HIS R" ).append("\n"); 
		query.append("WHERE BKG_NO = @[bkg_no] --'SEA104071500'" ).append("\n"); 
		query.append("AND CORR_NO = 'TMP0000001'" ).append("\n"); 
		query.append("AND RT_APLY_DT IS NOT NULL" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT 2 RANK, RT_APLY_DT APPL_DT --RATE APPLICABLE" ).append("\n"); 
		query.append("FROM BKG_RATE R" ).append("\n"); 
		query.append("WHERE BKG_NO = @[bkg_no] --'SEA104071500'" ).append("\n"); 
		query.append("AND RT_APLY_DT IS NOT NULL" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT 3 RANK, SKD.VPS_ETD_DT APPL_DT --ONBOARD DATE" ).append("\n"); 
		query.append("FROM BKG_VVD_HIS VVD" ).append("\n"); 
		query.append(",VSK_VSL_PORT_SKD SKD" ).append("\n"); 
		query.append(",BKG_BKG_HIS BK" ).append("\n"); 
		query.append("WHERE BK.BKG_NO = @[bkg_no] --'SEA104071500'" ).append("\n"); 
		query.append("AND BK.CORR_NO = 'TMP0000001'" ).append("\n"); 
		query.append("AND BK.BKG_NO = VVD.BKG_NO" ).append("\n"); 
		query.append("AND BK.CORR_NO = VVD.CORR_NO" ).append("\n"); 
		query.append("AND VVD.VSL_PRE_PST_CD IN ('S','T')" ).append("\n"); 
		query.append("AND VVD.POL_CD = BK.POL_CD" ).append("\n"); 
		query.append("AND VVD.VSL_CD = SKD.VSL_CD" ).append("\n"); 
		query.append("AND VVD.SKD_VOY_NO = SKD.SKD_VOY_NO" ).append("\n"); 
		query.append("AND VVD.SKD_DIR_CD = SKD.SKD_DIR_CD" ).append("\n"); 
		query.append("AND VVD.POL_CD = SKD.VPS_PORT_CD" ).append("\n"); 
		query.append("AND VVD.POL_CLPT_IND_SEQ = SKD.CLPT_IND_SEQ" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT 4 RANK, SKD.VPS_ETD_DT APPL_DT --ONBOARD DATE" ).append("\n"); 
		query.append("FROM BKG_VVD VVD" ).append("\n"); 
		query.append(",VSK_VSL_PORT_SKD SKD" ).append("\n"); 
		query.append(",BKG_BOOKING BK" ).append("\n"); 
		query.append("WHERE BK.BKG_NO = @[bkg_no] --'SEA104071500'" ).append("\n"); 
		query.append("AND BK.BKG_NO = VVD.BKG_NO" ).append("\n"); 
		query.append("AND VVD.VSL_PRE_PST_CD IN ('S','T')" ).append("\n"); 
		query.append("AND VVD.POL_CD = BK.POL_CD" ).append("\n"); 
		query.append("AND VVD.VSL_CD = SKD.VSL_CD" ).append("\n"); 
		query.append("AND VVD.SKD_VOY_NO = SKD.SKD_VOY_NO" ).append("\n"); 
		query.append("AND VVD.SKD_DIR_CD = SKD.SKD_DIR_CD" ).append("\n"); 
		query.append("AND VVD.POL_CD = SKD.VPS_PORT_CD" ).append("\n"); 
		query.append("AND VVD.POL_CLPT_IND_SEQ = SKD.CLPT_IND_SEQ" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT 5 RANK, SYSDATE APPL_DT" ).append("\n"); 
		query.append("FROM DUAL)" ).append("\n"); 
		query.append("WHERE ROWNUM = 1" ).append("\n"); 
		query.append("AND APPL_DT IS NOT NULL" ).append("\n"); 
		query.append(") D" ).append("\n"); 
		query.append(",MDM_SLS_REP E" ).append("\n"); 
		query.append("--      ,BKG_BOOKING F" ).append("\n"); 
		query.append("WHERE --F.BKG_NO = 'SEA104071500'" ).append("\n"); 
		query.append("A.SC_NO = @[sc_no]" ).append("\n"); 
		query.append("--   AND A.SC_NO = F.SC_NO" ).append("\n"); 
		query.append("AND A.PROP_NO = B.PROP_NO" ).append("\n"); 
		query.append("AND B.EFF_DT - 0.0001 < D.APPL_DT" ).append("\n"); 
		query.append("AND B.EXP_DT + 0.9999 > D.APPL_DT" ).append("\n"); 
		query.append("AND NVL(B.REAL_CUST_SREP_CD, B.RESPB_SREP_CD) = E.SREP_CD" ).append("\n"); 
		query.append("AND (   (B.AMDT_SEQ = 0 AND B.PROP_STS_CD = 'F')" ).append("\n"); 
		query.append("OR (B.AMDT_SEQ > 0))" ).append("\n"); 

	}
}