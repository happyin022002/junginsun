/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : UnmatchBLDBDAOCheckScNonchargedBlRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.04.20
*@LastModifier : 류선우
*@LastVersion : 1.0
* 2010.04.20 류선우
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.revenueaudit.unmatchbl.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Ryu Sun Woo
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class UnmatchBLDBDAOCheckScNonchargedBlRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * checkScNonchargedBl
	  * </pre>
	  */
	public UnmatchBLDBDAOCheckScNonchargedBlRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ca_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.revenueaudit.unmatchbl.integration").append("\n"); 
		query.append("FileName : UnmatchBLDBDAOCheckScNonchargedBlRSQL").append("\n"); 
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
		query.append("SELECT  'D'   UMCH_TP_CD      ," ).append("\n"); 
		query.append("        NULL  BKG_ITM_LOG     ," ).append("\n"); 
		query.append("        NULL  CTRT_ITM_LOG    ," ).append("\n"); 
		query.append("        'U'   MTCH_UMCH_TP_CD ," ).append("\n"); 
		query.append("        ( SELECT UMCH_TP_DESC FROM BKG_REV_UMCH_TP WHERE UMCH_TP_CD = 'D' ) UMCH_TP_DESC  ," ).append("\n"); 
		query.append("        ( SELECT INTG_CD_VAL_DP_DESC FROM COM_INTG_CD_DTL WHERE INTG_CD_ID = 'CD02456' AND INTG_CD_VAL_CTNT = 'U' ) MTCH_UMCH_TP_DESC" ).append("\n"); 
		query.append("FROM    DUAL" ).append("\n"); 
		query.append("WHERE   NOT EXISTS  (" ).append("\n"); 
		query.append("                    SELECT  'X'" ).append("\n"); 
		query.append("                    FROM    BKG_CHG_RT  CR" ).append("\n"); 
		query.append("                    WHERE   CR.BKG_NO   = @[bkg_no]" ).append("\n"); 
		query.append("                    AND     NVL(CR.FRT_INCL_XCLD_DIV_CD, 'N') = 'N'" ).append("\n"); 
		query.append("                    AND     ROWNUM      = 1" ).append("\n"); 
		query.append("                    AND     @[ca_flg]   = 'N'" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                    UNION ALL" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                    SELECT  'X'" ).append("\n"); 
		query.append("                    FROM    BKG_CHG_RT_HIS  CR" ).append("\n"); 
		query.append("                    WHERE   CR.BKG_NO   = @[bkg_no]" ).append("\n"); 
		query.append("                    AND     CR.CORR_NO  = 'TMP0000001'  -- CORRECTION 중인 DATA 를 나타내는 고정된 상수값" ).append("\n"); 
		query.append("                    AND     NVL(CR.FRT_INCL_XCLD_DIV_CD, 'N') = 'N'" ).append("\n"); 
		query.append("                    AND     ROWNUM      = 1" ).append("\n"); 
		query.append("                    AND     @[ca_flg]   = 'Y'" ).append("\n"); 
		query.append("                    )" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("/*******************************************************************************************" ).append("\n"); 
		query.append("CO-BIZ, COVERED B/L 은 대상에서 제외한다." ).append("\n"); 
		query.append("*******************************************************************************************/" ).append("\n"); 
		query.append("AND     (" ).append("\n"); 
		query.append("        SELECT  NVL(RT_BL_TP_CD, 'N')" ).append("\n"); 
		query.append("        FROM    BKG_RATE" ).append("\n"); 
		query.append("        WHERE   BKG_NO        = @[bkg_no]" ).append("\n"); 
		query.append("        AND     @[ca_flg]     = 'N'" ).append("\n"); 
		query.append("        UNION ALL" ).append("\n"); 
		query.append("        SELECT  NVL(RT_BL_TP_CD, 'N')" ).append("\n"); 
		query.append("        FROM    BKG_RT_HIS" ).append("\n"); 
		query.append("        WHERE   BKG_NO        = @[bkg_no]" ).append("\n"); 
		query.append("        AND     CORR_NO       = 'TMP0000001'  -- CORRECTION 중인 DATA 를 나타내는 고정된 상수값" ).append("\n"); 
		query.append("        AND     @[ca_flg]     = 'Y'" ).append("\n"); 
		query.append("        )" ).append("\n"); 
		query.append("        NOT IN ( 'B', 'C' )" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("/*******************************************************************************************" ).append("\n"); 
		query.append("MEMO B/L 은 대상에서 제외한다." ).append("\n"); 
		query.append("*******************************************************************************************/" ).append("\n"); 
		query.append("AND     NOT EXISTS  (" ).append("\n"); 
		query.append("                    SELECT  'X'" ).append("\n"); 
		query.append("                    FROM    BKG_BOOKING" ).append("\n"); 
		query.append("                    WHERE   BKG_NO        = ( SELECT FM_BKG_NO FROM BKG_BOOKING WHERE BKG_NO = @[bkg_no] )" ).append("\n"); 
		query.append("                    AND     SPLIT_RSN_CD  = 'M'" ).append("\n"); 
		query.append("                    AND     @[ca_flg]     = 'N'" ).append("\n"); 
		query.append("                    UNION ALL" ).append("\n"); 
		query.append("                    SELECT  'X'" ).append("\n"); 
		query.append("                    FROM    BKG_BOOKING" ).append("\n"); 
		query.append("                    WHERE   BKG_NO        = ( SELECT FM_BKG_NO FROM BKG_BKG_HIS WHERE BKG_NO = @[bkg_no] AND CORR_NO = 'TMP0000001' )" ).append("\n"); 
		query.append("                    AND     SPLIT_RSN_CD  = 'M'" ).append("\n"); 
		query.append("                    AND     @[ca_flg]     = 'Y'" ).append("\n"); 
		query.append("                    )" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("/*******************************************************************************************" ).append("\n"); 
		query.append("신규 BKG 만 대상으로 한다." ).append("\n"); 
		query.append("*******************************************************************************************/" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("AND     LENGTH(@[bkg_no]) = 12" ).append("\n"); 

	}
}