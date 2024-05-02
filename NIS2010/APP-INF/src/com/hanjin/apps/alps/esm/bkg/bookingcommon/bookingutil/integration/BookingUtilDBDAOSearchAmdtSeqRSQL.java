/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : BookingUtilDBDAOSearchAmdtSeqRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.10.28
*@LastModifier : 조원주
*@LastVersion : 1.0
* 2011.10.28 조원주
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author CHO WON-JOO
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BookingUtilDBDAOSearchAmdtSeqRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * AmdtSeq를 조회한다.
	  * </pre>
	  */
	public BookingUtilDBDAOSearchAmdtSeqRSQL(){
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
		params.put("ctrt_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.integration ").append("\n"); 
		query.append("FileName : BookingUtilDBDAOSearchAmdtSeqRSQL").append("\n"); 
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
		query.append("--BookingUtilDBDAOSearchAmdtSeqRSQL.Query" ).append("\n"); 
		query.append("SELECT  MAIN.AMDT_SEQ" ).append("\n"); 
		query.append("  FROM  " ).append("\n"); 
		query.append("#if( ${ctrt_type} == 'sc')" ).append("\n"); 
		query.append("		PRI_SP_HDR HDR" ).append("\n"); 
		query.append("       ,PRI_SP_MN MAIN" ).append("\n"); 
		query.append("#elseif( ${ctrt_type} == 'rfa')" ).append("\n"); 
		query.append("		PRI_RP_HDR HDR" ).append("\n"); 
		query.append("       ,PRI_RP_MN MAIN" ).append("\n"); 
		query.append("#elseif( ${ctrt_type} == 'taa')" ).append("\n"); 
		query.append("		PRI_TAA_HDR HDR" ).append("\n"); 
		query.append("	   ,PRI_TAA_MN MAIN" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("       ,(SELECT APPL_DT" ).append("\n"); 
		query.append("           FROM (" ).append("\n"); 
		query.append("           #if (${bkg_no} != '') " ).append("\n"); 
		query.append("                SELECT 1 RANK, RT_APLY_DT APPL_DT " ).append("\n"); 
		query.append("                  FROM BKG_RT_HIS R" ).append("\n"); 
		query.append("                 WHERE BKG_NO     = @[bkg_no]" ).append("\n"); 
		query.append("                   AND CORR_NO    = 'TMP0000001'" ).append("\n"); 
		query.append("                   AND RT_APLY_DT IS NOT NULL" ).append("\n"); 
		query.append("                UNION ALL" ).append("\n"); 
		query.append("                SELECT 2 RANK, RT_APLY_DT APPL_DT --RATE APPLICABLE" ).append("\n"); 
		query.append("                  FROM BKG_RATE R" ).append("\n"); 
		query.append("                 WHERE BKG_NO     = @[bkg_no]" ).append("\n"); 
		query.append("                   AND RT_APLY_DT IS NOT NULL" ).append("\n"); 
		query.append("                UNION ALL" ).append("\n"); 
		query.append("                SELECT 3 RANK, SKD.VPS_ETD_DT APPL_DT --ONBOARD DATE" ).append("\n"); 
		query.append("                  FROM BKG_VVD_HIS VVD, VSK_VSL_PORT_SKD SKD, BKG_BKG_HIS BK" ).append("\n"); 
		query.append("                 WHERE BK.BKG_NO          = @[bkg_no]" ).append("\n"); 
		query.append("                   AND BK.CORR_NO 		  = 'TMP0000001'" ).append("\n"); 
		query.append("                   AND VVD.CORR_NO 		  = 'TMP0000001'" ).append("\n"); 
		query.append("                   AND BK.BKG_NO          = VVD.BKG_NO" ).append("\n"); 
		query.append("                   AND VVD.VSL_PRE_PST_CD IN ('S', 'T')" ).append("\n"); 
		query.append("                   AND VVD.POL_CD         = BK.POL_CD" ).append("\n"); 
		query.append("                   AND VVD.VSL_CD         = SKD.VSL_CD" ).append("\n"); 
		query.append("                   AND VVD.SKD_VOY_NO     = SKD.SKD_VOY_NO" ).append("\n"); 
		query.append("                   AND VVD.SKD_DIR_CD     = SKD.SKD_DIR_CD" ).append("\n"); 
		query.append("                   AND VVD.POL_CD         = SKD.VPS_PORT_CD" ).append("\n"); 
		query.append("                   AND VVD.POL_CLPT_IND_SEQ = SKD.CLPT_IND_SEQ" ).append("\n"); 
		query.append("                UNION ALL" ).append("\n"); 
		query.append("                SELECT 4 RANK, SKD.VPS_ETD_DT APPL_DT --ONBOARD DATE" ).append("\n"); 
		query.append("                  FROM BKG_VVD VVD, VSK_VSL_PORT_SKD SKD, BKG_BOOKING BK" ).append("\n"); 
		query.append("                 WHERE BK.BKG_NO          = @[bkg_no]" ).append("\n"); 
		query.append("                   AND BK.BKG_NO          = VVD.BKG_NO" ).append("\n"); 
		query.append("                   AND VVD.VSL_PRE_PST_CD IN ('S', 'T')" ).append("\n"); 
		query.append("                   AND VVD.POL_CD         = BK.POL_CD" ).append("\n"); 
		query.append("                   AND VVD.VSL_CD         = SKD.VSL_CD" ).append("\n"); 
		query.append("                   AND VVD.SKD_VOY_NO     = SKD.SKD_VOY_NO" ).append("\n"); 
		query.append("                   AND VVD.SKD_DIR_CD     = SKD.SKD_DIR_CD" ).append("\n"); 
		query.append("                   AND VVD.POL_CD         = SKD.VPS_PORT_CD" ).append("\n"); 
		query.append("                   AND VVD.POL_CLPT_IND_SEQ = SKD.CLPT_IND_SEQ" ).append("\n"); 
		query.append("                UNION ALL " ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("                SELECT 5 RANK, SYSDATE APPL_DT" ).append("\n"); 
		query.append("                  FROM DUAL)   " ).append("\n"); 
		query.append("            WHERE ROWNUM = 1) APPL" ).append("\n"); 
		query.append(" WHERE 1=1" ).append("\n"); 
		query.append("#if( ${ctrt_type} == 'taa')" ).append("\n"); 
		query.append("   AND HDR.TAA_PROP_NO = MAIN.TAA_PROP_NO" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("   AND HDR.PROP_NO = MAIN.PROP_NO" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("   AND MAIN.EFF_DT - 0.0001 < APPL.APPL_DT" ).append("\n"); 
		query.append("   AND MAIN.EXP_DT + 0.9999 > APPL.APPL_DT" ).append("\n"); 
		query.append("#if( ${ctrt_type} == 'sc')" ).append("\n"); 
		query.append("   AND MAIN.PROP_STS_CD ='F'" ).append("\n"); 
		query.append("   AND HDR.SC_NO = @[ctrt_no]" ).append("\n"); 
		query.append("#elseif( ${ctrt_type} == 'rfa')" ).append("\n"); 
		query.append("   AND MAIN.PROP_STS_CD ='A'" ).append("\n"); 
		query.append("   AND HDR.RFA_NO = @[ctrt_no]" ).append("\n"); 
		query.append("#elseif( ${ctrt_type} == 'taa')" ).append("\n"); 
		query.append("   AND CFM_FLG = 'Y'" ).append("\n"); 
		query.append("   AND HDR.TAA_NO = @[ctrt_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}