/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : UnmatchBLDBDAOCheckRfaCommodityDiscrepancyRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.10.01
*@LastModifier : 김태경
*@LastVersion : 1.0
* 2010.10.01 김태경
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.revenueaudit.unmatchbl.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author kim tae kyoung
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class UnmatchBLDBDAOCheckRfaCommodityDiscrepancyRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * C Commodity Discrepancy
	  * </pre>
	  */
	public UnmatchBLDBDAOCheckRfaCommodityDiscrepancyRSQL(){
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
		query.append("Path : com.clt.apps.opus.esm.bkg.revenueaudit.unmatchbl.integration").append("\n"); 
		query.append("FileName : UnmatchBLDBDAOCheckRfaCommodityDiscrepancyRSQL").append("\n"); 
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
		query.append("RF AS" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("/*******************************************************************************************" ).append("\n"); 
		query.append("계약 정보 조회" ).append("\n"); 
		query.append("*******************************************************************************************/" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SELECT  RS.PROP_NO    ," ).append("\n"); 
		query.append("        RS.AMDT_SEQ   ," ).append("\n"); 
		query.append("        RS.SVC_SCP_CD" ).append("\n"); 
		query.append("FROM    BKG_BOOKING     BK  ," ).append("\n"); 
		query.append("        MDM_LOCATION    L1  ," ).append("\n"); 
		query.append("        MDM_LOCATION    L4  ," ).append("\n"); 
		query.append("        PRI_RP_HDR      RH  ," ).append("\n"); 
		query.append("        PRI_RP_MN       RM  ," ).append("\n"); 
		query.append("        PRI_RP_SCP_MN   RS" ).append("\n"); 
		query.append("WHERE   L1.LOC_CD       = BK.POR_CD" ).append("\n"); 
		query.append("AND     L4.LOC_CD       = BK.DEL_CD" ).append("\n"); 
		query.append("AND     RH.RFA_NO       = BK.RFA_NO" ).append("\n"); 
		query.append("AND     RM.PROP_NO      = RH.PROP_NO" ).append("\n"); 
		query.append("AND     RM.PROP_STS_CD  = 'A'       -- APPROVED RFA" ).append("\n"); 
		query.append("AND     RS.PROP_NO      = RM.PROP_NO" ).append("\n"); 
		query.append("AND     RS.AMDT_SEQ     = RM.AMDT_SEQ" ).append("\n"); 
		query.append("AND     RS.SVC_SCP_CD   = BK.SVC_SCP_CD" ).append("\n"); 
		query.append("AND     ( SELECT BKG_REV_APLY_DT_PKG.BKG_GET_REV_APLY_DT_FNC(@[bkg_no], @[ca_flg]) FROM DUAL )" ).append("\n"); 
		query.append("        BETWEEN RS.EFF_DT AND RS.EXP_DT" ).append("\n"); 
		query.append("AND     BK.BKG_NO       = @[bkg_no]" ).append("\n"); 
		query.append("AND     @[ca_flg]       = 'N'" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SELECT  RS.PROP_NO    ," ).append("\n"); 
		query.append("        RS.AMDT_SEQ   ," ).append("\n"); 
		query.append("        RS.SVC_SCP_CD" ).append("\n"); 
		query.append("FROM    BKG_BKG_HIS     BK  ," ).append("\n"); 
		query.append("        MDM_LOCATION    L1  ," ).append("\n"); 
		query.append("        MDM_LOCATION    L4  ," ).append("\n"); 
		query.append("        PRI_RP_HDR      RH  ," ).append("\n"); 
		query.append("        PRI_RP_MN       RM  ," ).append("\n"); 
		query.append("        PRI_RP_SCP_MN   RS" ).append("\n"); 
		query.append("WHERE   L1.LOC_CD       = BK.POR_CD" ).append("\n"); 
		query.append("AND     L4.LOC_CD       = BK.DEL_CD" ).append("\n"); 
		query.append("AND     RH.RFA_NO       = BK.RFA_NO" ).append("\n"); 
		query.append("AND     RM.PROP_NO      = RH.PROP_NO" ).append("\n"); 
		query.append("AND     RM.PROP_STS_CD  = 'A'       -- APPROVED RFA" ).append("\n"); 
		query.append("AND     RS.PROP_NO      = RM.PROP_NO" ).append("\n"); 
		query.append("AND     RS.AMDT_SEQ     = RM.AMDT_SEQ" ).append("\n"); 
		query.append("AND     RS.SVC_SCP_CD   = BK.SVC_SCP_CD" ).append("\n"); 
		query.append("AND     ( SELECT BKG_REV_APLY_DT_PKG.BKG_GET_REV_APLY_DT_FNC(@[bkg_no], @[ca_flg]) FROM DUAL )" ).append("\n"); 
		query.append("        BETWEEN RS.EFF_DT AND RS.EXP_DT" ).append("\n"); 
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
		query.append("        SELECT  CASE" ).append("\n"); 
		query.append("                WHEN CM.PRC_CMDT_TP_CD = 'C' THEN CM.PRC_CMDT_DEF_CD" ).append("\n"); 
		query.append("                WHEN CM.PRC_CMDT_TP_CD = 'R' THEN C1.CMDT_CD" ).append("\n"); 
		query.append("                WHEN CM.PRC_CMDT_TP_CD = 'G' AND GD.PRC_CMDT_TP_CD = 'C' THEN GD.PRC_CMDT_DEF_CD" ).append("\n"); 
		query.append("                WHEN CM.PRC_CMDT_TP_CD = 'G' AND GD.PRC_CMDT_TP_CD = 'R' THEN C2.CMDT_CD" ).append("\n"); 
		query.append("                END CMDT_CD" ).append("\n"); 
		query.append("        FROM    RF  ," ).append("\n"); 
		query.append("                PRI_RP_SCP_RT_CMDT      CM  ," ).append("\n"); 
		query.append("                MDM_COMMODITY           C1  ," ).append("\n"); 
		query.append("                PRI_RP_SCP_GRP_CMDT     GC  ," ).append("\n"); 
		query.append("                PRI_RP_SCP_GRP_CMDT_DTL GD  ," ).append("\n"); 
		query.append("                MDM_COMMODITY           C2" ).append("\n"); 
		query.append("        WHERE   C1.REP_CMDT_CD(+)     = CM.PRC_CMDT_DEF_CD" ).append("\n"); 
		query.append("        AND     GC.PROP_NO(+)         = CM.PROP_NO" ).append("\n"); 
		query.append("        AND     GC.AMDT_SEQ(+)        = CM.AMDT_SEQ" ).append("\n"); 
		query.append("        AND     GC.SVC_SCP_CD(+)      = CM.SVC_SCP_CD" ).append("\n"); 
		query.append("        AND     GC.PRC_GRP_CMDT_CD(+) = CM.PRC_CMDT_DEF_CD" ).append("\n"); 
		query.append("        AND     GD.PROP_NO(+)         = GC.PROP_NO" ).append("\n"); 
		query.append("        AND     GD.AMDT_SEQ(+)        = GC.AMDT_SEQ" ).append("\n"); 
		query.append("        AND     GD.SVC_SCP_CD(+)      = GC.SVC_SCP_CD" ).append("\n"); 
		query.append("        AND     GD.GRP_CMDT_SEQ(+)    = GC.GRP_CMDT_SEQ" ).append("\n"); 
		query.append("        AND     GD.SRC_INFO_CD(+)     <> 'AD'" ).append("\n"); 
		query.append("        AND     C2.REP_CMDT_CD(+)     = GD.PRC_CMDT_DEF_CD" ).append("\n"); 
		query.append("        AND     CM.PROP_NO            = RF.PROP_NO" ).append("\n"); 
		query.append("        AND     CM.AMDT_SEQ           = RF.AMDT_SEQ" ).append("\n"); 
		query.append("        AND     CM.SVC_SCP_CD         = RF.SVC_SCP_CD" ).append("\n"); 
		query.append("        AND     CM.SRC_INFO_CD        <> 'AD'" ).append("\n"); 
		query.append("        ) RC" ).append("\n"); 
		query.append("WHERE   (" ).append("\n"); 
		query.append("            BC.CMDT_CD  = RC.CMDT_CD" ).append("\n"); 
		query.append("        OR  ( SELECT A.REP_CMDT_CD FROM MDM_COMMODITY A WHERE A.CMDT_CD = RC.CMDT_CD ) = '0000' -- FAK" ).append("\n"); 
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
		query.append("                        FROM    PRI_RP_SCP_RT_CMDT  CM" ).append("\n"); 
		query.append("                        WHERE   ( CM.PROP_NO, CM.AMDT_SEQ, CM.SVC_SCP_CD ) = ( SELECT PROP_NO, AMDT_SEQ, SVC_SCP_CD FROM RF )" ).append("\n"); 
		query.append("                        AND     CM.SRC_INFO_CD  <> 'AD'" ).append("\n"); 
		query.append("                        )" ).append("\n"); 
		query.append("        )" ).append("\n"); 
		query.append("        ||" ).append("\n"); 
		query.append("        (" ).append("\n"); 
		query.append("        SELECT  REPLACE(RTRIM(REPLACE(LTRIM(SYS_CONNECT_BY_PATH(PRC_CMDT_DEF_CD || DECODE(MOD(ROW_NUMBER, 5), 0, '/'), ';'), ';'), '/;', CHR(10)) ,'/'), ';', '')" ).append("\n"); 
		query.append("        FROM    (" ).append("\n"); 
		query.append("                SELECT  '[' || RPAD(PRC_CMDT_DEF_CD, 6, ' ') || ']' PRC_CMDT_DEF_CD ," ).append("\n"); 
		query.append("                        ROW_NUMBER() OVER ( ORDER BY CMDT_HDR_SEQ, CMDT_SEQ ) ROW_NUMBER  ," ).append("\n"); 
		query.append("                        COUNT(1) OVER () CNT" ).append("\n"); 
		query.append("                FROM    PRI_RP_SCP_RT_CMDT  CM" ).append("\n"); 
		query.append("                WHERE   ( CM.PROP_NO, CM.AMDT_SEQ, CM.SVC_SCP_CD ) = ( SELECT PROP_NO, AMDT_SEQ, SVC_SCP_CD FROM RF )" ).append("\n"); 
		query.append("                AND     CM.SRC_INFO_CD        <> 'AD'" ).append("\n"); 
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
		query.append("신규 BKG 만 대상으로 한다." ).append("\n"); 
		query.append("*******************************************************************************************/" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("AND     LENGTH(@[bkg_no]) = 12" ).append("\n"); 

	}
}