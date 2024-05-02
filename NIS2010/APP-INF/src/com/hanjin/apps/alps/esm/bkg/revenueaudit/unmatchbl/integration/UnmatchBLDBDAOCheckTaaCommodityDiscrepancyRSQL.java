/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : UnmatchBLDBDAOCheckTaaCommodityDiscrepancyRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.08.11
*@LastModifier : 김진주
*@LastVersion : 1.0
* 2014.08.11 김진주
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.revenueaudit.unmatchbl.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kim Jin Joo
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class UnmatchBLDBDAOCheckTaaCommodityDiscrepancyRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * checkTaaCommodityDiscrepancy
	  * </pre>
	  */
	public UnmatchBLDBDAOCheckTaaCommodityDiscrepancyRSQL(){
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
		query.append("FileName : UnmatchBLDBDAOCheckTaaCommodityDiscrepancyRSQL").append("\n"); 
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
		query.append("WITH" ).append("\n"); 
		query.append("TA AS" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("/*******************************************************************************************" ).append("\n"); 
		query.append("계약 정보 조회" ).append("\n"); 
		query.append("*******************************************************************************************/" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SELECT  TM.TAA_PROP_NO  PROP_NO ," ).append("\n"); 
		query.append("        TM.AMDT_SEQ             ," ).append("\n"); 
		query.append("        TM.SVC_SCP_CD" ).append("\n"); 
		query.append("FROM    BKG_BOOKING     BK  ," ).append("\n"); 
		query.append("        MDM_LOCATION    L1  ," ).append("\n"); 
		query.append("        MDM_LOCATION    L4  ," ).append("\n"); 
		query.append("        PRI_TAA_HDR     TH  ," ).append("\n"); 
		query.append("        PRI_TAA_MN      TM" ).append("\n"); 
		query.append("WHERE   L1.LOC_CD       = BK.POR_CD" ).append("\n"); 
		query.append("AND     L4.LOC_CD       = BK.DEL_CD" ).append("\n"); 
		query.append("AND     TH.TAA_NO       = BK.TAA_NO" ).append("\n"); 
		query.append("AND     TM.TAA_PROP_NO  = TH.TAA_PROP_NO" ).append("\n"); 
		query.append("AND     TM.SVC_SCP_CD   IN (BK.SVC_SCP_CD, DECODE(BK.SVC_SCP_CD, 'ACE','TPE','MXE','TPE'))" ).append("\n"); 
		query.append("AND     TM.CFM_FLG      = 'Y'       -- CONFIRMED TAA" ).append("\n"); 
		query.append("AND     ( SELECT BKG_REV_APLY_DT_PKG.BKG_GET_REV_APLY_DT_FNC(@[bkg_no], @[ca_flg]) FROM DUAL )" ).append("\n"); 
		query.append("        BETWEEN TM.EFF_DT AND TM.EXP_DT" ).append("\n"); 
		query.append("AND     BK.BKG_NO       = @[bkg_no]" ).append("\n"); 
		query.append("AND     @[ca_flg]       = 'N'" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SELECT  TM.TAA_PROP_NO  PROP_NO ," ).append("\n"); 
		query.append("        TM.AMDT_SEQ             ," ).append("\n"); 
		query.append("        TM.SVC_SCP_CD" ).append("\n"); 
		query.append("FROM    BKG_BKG_HIS     BK  ," ).append("\n"); 
		query.append("        MDM_LOCATION    L1  ," ).append("\n"); 
		query.append("        MDM_LOCATION    L4  ," ).append("\n"); 
		query.append("        PRI_TAA_HDR     TH  ," ).append("\n"); 
		query.append("        PRI_TAA_MN      TM" ).append("\n"); 
		query.append("WHERE   L1.LOC_CD       = BK.POR_CD" ).append("\n"); 
		query.append("AND     L4.LOC_CD       = BK.DEL_CD" ).append("\n"); 
		query.append("AND     TH.TAA_NO       = BK.TAA_NO" ).append("\n"); 
		query.append("AND     TM.TAA_PROP_NO  = TH.TAA_PROP_NO" ).append("\n"); 
		query.append("AND     TM.SVC_SCP_CD   IN (BK.SVC_SCP_CD, DECODE(BK.SVC_SCP_CD, 'ACE','TPE','MXE','TPE'))" ).append("\n"); 
		query.append("AND     TM.CFM_FLG      = 'Y'       -- CONFIRMED TAA" ).append("\n"); 
		query.append("AND     ( SELECT BKG_REV_APLY_DT_PKG.BKG_GET_REV_APLY_DT_FNC(@[bkg_no], @[ca_flg]) FROM DUAL )" ).append("\n"); 
		query.append("        BETWEEN TM.EFF_DT AND TM.EXP_DT" ).append("\n"); 
		query.append("AND     BK.BKG_NO       = @[bkg_no]" ).append("\n"); 
		query.append("AND     BK.CORR_NO      = 'TMP0000001'  -- CORRECTION 중인 DATA 를 나타내는 고정된 상수값" ).append("\n"); 
		query.append("AND     @[ca_flg]       = 'Y'" ).append("\n"); 
		query.append(") ," ).append("\n"); 
		query.append("C1 AS" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("/*******************************************************************************************" ).append("\n"); 
		query.append("COMMODITY DATA 비교" ).append("\n"); 
		query.append("*******************************************************************************************/" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SELECT  'X'" ).append("\n"); 
		query.append("FROM    (" ).append("\n"); 
		query.append("        /* BKG COMMODITY */" ).append("\n"); 
		query.append("        SELECT  CMDT_CD" ).append("\n"); 
		query.append("        FROM    BKG_BOOKING BK" ).append("\n"); 
		query.append("        WHERE   BK.BKG_NO   = @[bkg_no]" ).append("\n"); 
		query.append("        AND     @[ca_flg]   = 'N'" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("        UNION ALL" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("        SELECT  CMDT_CD" ).append("\n"); 
		query.append("        FROM    BKG_BKG_HIS BK" ).append("\n"); 
		query.append("        WHERE   BK.BKG_NO   = @[bkg_no]" ).append("\n"); 
		query.append("        AND     BK.CORR_NO  = 'TMP0000001'  -- CORRECTION 중인 DATA 를 나타내는 고정된 상수값" ).append("\n"); 
		query.append("        AND     @[ca_flg]   = 'Y'" ).append("\n"); 
		query.append("        ) BC  ," ).append("\n"); 
		query.append("        (" ).append("\n"); 
		query.append("        SELECT  TM.CMDT_CD" ).append("\n"); 
		query.append("        FROM    TA  ," ).append("\n"); 
		query.append("                PRI_TAA_TRI_LIST  TL  ," ).append("\n"); 
		query.append("                PRI_TRI_MN        TM" ).append("\n"); 
		query.append("        WHERE   TL.TAA_PROP_NO    = TA.PROP_NO" ).append("\n"); 
		query.append("        AND     TL.AMDT_SEQ       = TA.AMDT_SEQ" ).append("\n"); 
		query.append("        AND     TM.TRI_PROP_NO    = TL.TRI_PROP_NO" ).append("\n"); 
		query.append("        ) RC" ).append("\n"); 
		query.append("WHERE   (" ).append("\n"); 
		query.append("            BC.CMDT_CD  = RC.CMDT_CD" ).append("\n"); 
		query.append("        OR  ( SELECT A.REP_CMDT_CD FROM MDM_COMMODITY A WHERE A.CMDT_CD = RC.CMDT_CD ) = '0000' -- FAK" ).append("\n"); 
		query.append("        OR  ( SELECT A.REP_CMDT_CD FROM MDM_COMMODITY A WHERE A.CMDT_CD = RC.CMDT_CD ) = '9901' -- GDSM" ).append("\n"); 
		query.append("        )" ).append("\n"); 
		query.append("AND     ROWNUM  = 1" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("SELECT  'C'   UMCH_TP_CD      ," ).append("\n"); 
		query.append("        '[Commodity]['" ).append("\n"); 
		query.append("          ||  DECODE(@[ca_flg]," ).append("\n"); 
		query.append("                'N', ( SELECT CMDT_CD FROM BKG_BOOKING WHERE BKG_NO = @[bkg_no] )," ).append("\n"); 
		query.append("                'Y', ( SELECT CMDT_CD FROM BKG_BKG_HIS WHERE BKG_NO = @[bkg_no] AND CORR_NO = 'TMP0000001' )" ).append("\n"); 
		query.append("                )" ).append("\n"); 
		query.append("          ||  ']' BKG_ITM_LOG ," ).append("\n"); 
		query.append("        (" ).append("\n"); 
		query.append("        SELECT  '[Commodity]'" ).append("\n"); 
		query.append("        FROM    DUAL" ).append("\n"); 
		query.append("        WHERE   EXISTS  (" ).append("\n"); 
		query.append("                        SELECT  'X'" ).append("\n"); 
		query.append("                        FROM    PRI_TAA_TRI_LIST  TL  ," ).append("\n"); 
		query.append("                                PRI_TRI_MN        TM" ).append("\n"); 
		query.append("                        WHERE   ( TL.TAA_PROP_NO, TL.AMDT_SEQ ) = ( SELECT PROP_NO, AMDT_SEQ FROM TA )" ).append("\n"); 
		query.append("                        AND     TM.TRI_PROP_NO    = TL.TRI_PROP_NO" ).append("\n"); 
		query.append("                        )" ).append("\n"); 
		query.append("        )" ).append("\n"); 
		query.append("        ||" ).append("\n"); 
		query.append("        (" ).append("\n"); 
		query.append("        SELECT  REPLACE(RTRIM(REPLACE(LTRIM(SYS_CONNECT_BY_PATH(CMDT_CD || DECODE(MOD(ROW_NUMBER, 5), 0, '/'), ';'), ';'), '/;', CHR(10)) ,'/'), ';', '')" ).append("\n"); 
		query.append("        FROM    (" ).append("\n"); 
		query.append("                SELECT  '[' || TM.CMDT_CD || ']' CMDT_CD  ," ).append("\n"); 
		query.append("                        ROW_NUMBER() OVER ( ORDER BY TM.TRI_PROP_NO ) ROW_NUMBER  ," ).append("\n"); 
		query.append("                        COUNT(1) OVER () CNT" ).append("\n"); 
		query.append("                FROM    PRI_TAA_TRI_LIST  TL  ," ).append("\n"); 
		query.append("                        PRI_TRI_MN        TM" ).append("\n"); 
		query.append("                WHERE   ( TL.TAA_PROP_NO, TL.AMDT_SEQ ) = ( SELECT PROP_NO, AMDT_SEQ FROM TA )" ).append("\n"); 
		query.append("                AND     TM.TRI_PROP_NO    = TL.TRI_PROP_NO" ).append("\n"); 
		query.append("                )" ).append("\n"); 
		query.append("        WHERE   LEVEL   = LEAST(CNT, 20)" ).append("\n"); 
		query.append("        START WITH ROW_NUMBER = 1" ).append("\n"); 
		query.append("        CONNECT BY" ).append("\n"); 
		query.append("                ROW_NUMBER        = PRIOR ROW_NUMBER + 1" ).append("\n"); 
		query.append("        )   CTRT_ITM_LOG    ," ).append("\n"); 
		query.append("        'U'   MTCH_UMCH_TP_CD ," ).append("\n"); 
		query.append("        ( SELECT UMCH_TP_DESC FROM BKG_REV_UMCH_TP WHERE UMCH_TP_CD = 'C' ) UMCH_TP_DESC  ," ).append("\n"); 
		query.append("        ( SELECT INTG_CD_VAL_DP_DESC FROM COM_INTG_CD_DTL WHERE INTG_CD_ID = 'CD02456' AND INTG_CD_VAL_CTNT = 'U' ) MTCH_UMCH_TP_DESC" ).append("\n"); 
		query.append("FROM    DUAL" ).append("\n"); 
		query.append("WHERE   NOT EXISTS ( SELECT 'X' FROM C1 )" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("/*******************************************************************************************" ).append("\n"); 
		query.append("CO-BIZ은 대상에서 제외한다." ).append("\n"); 
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
		query.append("        NOT IN ( 'B' )" ).append("\n"); 

	}
}