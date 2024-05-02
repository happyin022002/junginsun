/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : UnmatchBLDBDAOCheckScCommodityDiscrepancyRSQL.java
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

public class UnmatchBLDBDAOCheckScCommodityDiscrepancyRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * checkScCommodityDiscrepancy
	  * </pre>
	  */
	public UnmatchBLDBDAOCheckScCommodityDiscrepancyRSQL(){
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
		query.append("FileName : UnmatchBLDBDAOCheckScCommodityDiscrepancyRSQL").append("\n"); 
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
		query.append("SC AS" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("/*******************************************************************************************" ).append("\n"); 
		query.append("계약 정보 조회" ).append("\n"); 
		query.append("*******************************************************************************************/" ).append("\n"); 
		query.append("SELECT * FROM (" ).append("\n"); 
		query.append("SELECT  SS.PROP_NO    ," ).append("\n"); 
		query.append("        SS.AMDT_SEQ   ," ).append("\n"); 
		query.append("        SS.SVC_SCP_CD" ).append("\n"); 
		query.append("FROM    BKG_BOOKING     BK  ," ).append("\n"); 
		query.append("        MDM_LOCATION    L1  ," ).append("\n"); 
		query.append("        MDM_LOCATION    L4  ," ).append("\n"); 
		query.append("        PRI_SP_HDR      SH  ," ).append("\n"); 
		query.append("        PRI_SP_MN       SM  ," ).append("\n"); 
		query.append("        PRI_SP_SCP_MN   SS" ).append("\n"); 
		query.append("WHERE   L1.LOC_CD       = BK.POR_CD" ).append("\n"); 
		query.append("AND     L4.LOC_CD       = BK.DEL_CD" ).append("\n"); 
		query.append("AND     SH.SC_NO        = BK.SC_NO" ).append("\n"); 
		query.append("AND     SM.PROP_NO      = SH.PROP_NO" ).append("\n"); 
		query.append("AND     SM.PROP_STS_CD  = 'F'       -- FILED S/C" ).append("\n"); 
		query.append("AND     SS.PROP_NO      = SM.PROP_NO" ).append("\n"); 
		query.append("AND     SS.AMDT_SEQ     = SM.AMDT_SEQ" ).append("\n"); 
		query.append("AND     SS.SVC_SCP_CD   IN (BK.SVC_SCP_CD,DECODE(BK.SVC_SCP_CD,'ACE','TPE','MXE','TPE'))" ).append("\n"); 
		query.append("AND     ( SELECT BKG_REV_APLY_DT_PKG.BKG_GET_REV_APLY_DT_FNC(@[bkg_no], @[ca_flg]) FROM DUAL )" ).append("\n"); 
		query.append("        BETWEEN SS.EFF_DT AND SS.EXP_DT" ).append("\n"); 
		query.append("AND     BK.BKG_NO       = @[bkg_no]" ).append("\n"); 
		query.append("AND     @[ca_flg]       = 'N'" ).append("\n"); 
		query.append("ORDER BY DECODE(SS.SVC_SCP_CD,'ACE',1,'MXE',2,'TPE',3)" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("WHERE ROWNUM = 1" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SELECT * FROM (" ).append("\n"); 
		query.append("SELECT  SS.PROP_NO    ," ).append("\n"); 
		query.append("        SS.AMDT_SEQ   ," ).append("\n"); 
		query.append("        SS.SVC_SCP_CD" ).append("\n"); 
		query.append("FROM    BKG_BKG_HIS     BK  ," ).append("\n"); 
		query.append("        MDM_LOCATION    L1  ," ).append("\n"); 
		query.append("        MDM_LOCATION    L4  ," ).append("\n"); 
		query.append("        PRI_SP_HDR      SH  ," ).append("\n"); 
		query.append("        PRI_SP_MN       SM  ," ).append("\n"); 
		query.append("        PRI_SP_SCP_MN   SS" ).append("\n"); 
		query.append("WHERE   L1.LOC_CD       = BK.POR_CD" ).append("\n"); 
		query.append("AND     L4.LOC_CD       = BK.DEL_CD" ).append("\n"); 
		query.append("AND     SH.SC_NO        = BK.SC_NO" ).append("\n"); 
		query.append("AND     SM.PROP_NO      = SH.PROP_NO" ).append("\n"); 
		query.append("AND     SM.PROP_STS_CD  = 'F'       -- FILED S/C" ).append("\n"); 
		query.append("AND     SS.PROP_NO      = SM.PROP_NO" ).append("\n"); 
		query.append("AND     SS.AMDT_SEQ     = SM.AMDT_SEQ" ).append("\n"); 
		query.append("AND     SS.SVC_SCP_CD   IN (BK.SVC_SCP_CD,DECODE(BK.SVC_SCP_CD,'ACE','TPE','MXE','TPE'))" ).append("\n"); 
		query.append("AND     ( SELECT BKG_REV_APLY_DT_PKG.BKG_GET_REV_APLY_DT_FNC(@[bkg_no], @[ca_flg]) FROM DUAL )" ).append("\n"); 
		query.append("        BETWEEN SS.EFF_DT AND SS.EXP_DT" ).append("\n"); 
		query.append("AND     BK.BKG_NO       = @[bkg_no]" ).append("\n"); 
		query.append("AND     BK.CORR_NO      = 'TMP0000001'  -- CORRECTION 중인 DATA 를 나타내는 고정된 상수값" ).append("\n"); 
		query.append("AND     @[ca_flg]       = 'Y'" ).append("\n"); 
		query.append("ORDER BY DECODE(SS.SVC_SCP_CD,'ACE',1,'MXE',2,'TPE',3)" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("WHERE ROWNUM = 1" ).append("\n"); 
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
		query.append("        FROM    SC  ," ).append("\n"); 
		query.append("                PRI_SP_SCP_RT_CMDT      CM  ," ).append("\n"); 
		query.append("                MDM_COMMODITY           C1  ," ).append("\n"); 
		query.append("                PRI_SP_SCP_GRP_CMDT     GC  ," ).append("\n"); 
		query.append("                PRI_SP_SCP_GRP_CMDT_DTL GD  ," ).append("\n"); 
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
		query.append("        AND     CM.PROP_NO            = SC.PROP_NO" ).append("\n"); 
		query.append("        AND     CM.AMDT_SEQ           = SC.AMDT_SEQ" ).append("\n"); 
		query.append("        AND     CM.SVC_SCP_CD         = SC.SVC_SCP_CD" ).append("\n"); 
		query.append("        AND     CM.SRC_INFO_CD        <> 'AD'" ).append("\n"); 
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
		query.append("                        FROM    PRI_SP_SCP_RT_CMDT  CM" ).append("\n"); 
		query.append("                        WHERE   ( CM.PROP_NO, CM.AMDT_SEQ, CM.SVC_SCP_CD ) = ( SELECT PROP_NO, AMDT_SEQ, SVC_SCP_CD FROM SC )" ).append("\n"); 
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
		query.append("                FROM    PRI_SP_SCP_RT_CMDT  CM" ).append("\n"); 
		query.append("                WHERE   ( CM.PROP_NO, CM.AMDT_SEQ, CM.SVC_SCP_CD ) = ( SELECT PROP_NO, AMDT_SEQ, SVC_SCP_CD FROM SC )" ).append("\n"); 
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
		query.append("" ).append("\n"); 
		query.append("/*******************************************************************************************" ).append("\n"); 
		query.append("신규 BKG 만 대상으로 한다." ).append("\n"); 
		query.append("*******************************************************************************************/" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("AND     LENGTH(@[bkg_no]) = 12" ).append("\n"); 
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