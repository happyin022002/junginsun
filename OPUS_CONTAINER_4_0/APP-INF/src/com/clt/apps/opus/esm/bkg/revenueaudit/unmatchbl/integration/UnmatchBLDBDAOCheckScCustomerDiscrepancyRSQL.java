/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : UnmatchBLDBDAOCheckScCustomerDiscrepancyRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.06.07
*@LastModifier : 
*@LastVersion : 1.0
* 2015.06.07 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.revenueaudit.unmatchbl.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class UnmatchBLDBDAOCheckScCustomerDiscrepancyRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * checkScCustomerDiscrepancy
	  * </pre>
	  */
	public UnmatchBLDBDAOCheckScCustomerDiscrepancyRSQL(){
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
		query.append("FileName : UnmatchBLDBDAOCheckScCustomerDiscrepancyRSQL").append("\n"); 
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
		query.append("AND     SS.SVC_SCP_CD   IN (BK.SVC_SCP_CD)" ).append("\n"); 
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
		query.append("AND     SS.SVC_SCP_CD   IN (BK.SVC_SCP_CD)" ).append("\n"); 
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
		query.append("고객 DATA 비교" ).append("\n"); 
		query.append("*******************************************************************************************/" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SELECT  'X'" ).append("\n"); 
		query.append("FROM    (" ).append("\n"); 
		query.append("        /* BKG CUSTOMER */" ).append("\n"); 
		query.append("        SELECT  BC.CUST_CNT_CD  ," ).append("\n"); 
		query.append("                BC.CUST_SEQ     ," ).append("\n"); 
		query.append("                ( SELECT UPPER(SUBSTR(A.CUST_LGL_ENG_NM, 1, 6)) FROM MDM_CUSTOMER A WHERE A.CUST_CNT_CD = BC.CUST_CNT_CD AND A.CUST_SEQ = BC.CUST_SEQ ) CUST_NM" ).append("\n"); 
		query.append("        FROM    BKG_CUSTOMER BC" ).append("\n"); 
		query.append("        WHERE   BC.BKG_NO         = @[bkg_no]" ).append("\n"); 
		query.append("        AND     BC.BKG_CUST_TP_CD IN ( 'S', 'C', 'N', 'F' )" ).append("\n"); 
		query.append("        AND     BC.CUST_CNT_CD    IS NOT NULL" ).append("\n"); 
		query.append("        AND     BC.CUST_SEQ       <> 0" ).append("\n"); 
		query.append("        AND     @[ca_flg]         = 'N'" ).append("\n"); 
		query.append("		UNION" ).append("\n"); 
		query.append("        SELECT  BB.BKG_CTRL_PTY_CUST_CNT_CD ," ).append("\n"); 
		query.append("                BB.BKG_CTRL_PTY_CUST_SEQ    ," ).append("\n"); 
		query.append("                ( SELECT UPPER(SUBSTR(A.CUST_LGL_ENG_NM, 1, 6)) FROM MDM_CUSTOMER A WHERE A.CUST_CNT_CD = BB.BKG_CTRL_PTY_CUST_CNT_CD AND A.CUST_SEQ = BB.BKG_CTRL_PTY_CUST_SEQ ) CUST_NM" ).append("\n"); 
		query.append("        FROM    BKG_BOOKING BB" ).append("\n"); 
		query.append("        WHERE   BB.BKG_NO         = @[bkg_no]" ).append("\n"); 
		query.append("        AND     BB.BKG_CTRL_PTY_CUST_CNT_CD    IS NOT NULL" ).append("\n"); 
		query.append("        AND     BB.BKG_CTRL_PTY_CUST_SEQ       <> 0" ).append("\n"); 
		query.append("        AND     @[ca_flg]         = 'N'" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("        UNION ALL" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("        SELECT  BC.CUST_CNT_CD  ," ).append("\n"); 
		query.append("                BC.CUST_SEQ     ," ).append("\n"); 
		query.append("                ( SELECT UPPER(SUBSTR(A.CUST_LGL_ENG_NM, 1, 6)) FROM MDM_CUSTOMER A WHERE A.CUST_CNT_CD = BC.CUST_CNT_CD AND A.CUST_SEQ = BC.CUST_SEQ ) CUST_NM" ).append("\n"); 
		query.append("        FROM    BKG_CUST_HIS BC" ).append("\n"); 
		query.append("        WHERE   BC.BKG_NO         = @[bkg_no]" ).append("\n"); 
		query.append("        AND     BC.CORR_NO        = 'TMP0000001'  -- CORRECTION 중인 DATA 를 나타내는 고정된 상수값" ).append("\n"); 
		query.append("        AND     BC.BKG_CUST_TP_CD IN ( 'S', 'C', 'N', 'F' )" ).append("\n"); 
		query.append("        AND     BC.CUST_CNT_CD    IS NOT NULL" ).append("\n"); 
		query.append("        AND     BC.CUST_SEQ       <> 0" ).append("\n"); 
		query.append("        AND     @[ca_flg]         = 'Y'" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("        UNION" ).append("\n"); 
		query.append("        SELECT  BB.BKG_CTRL_PTY_CUST_CNT_CD ," ).append("\n"); 
		query.append("                BB.BKG_CTRL_PTY_CUST_SEQ    ," ).append("\n"); 
		query.append("                ( SELECT UPPER(SUBSTR(A.CUST_LGL_ENG_NM, 1, 6)) FROM MDM_CUSTOMER A WHERE A.CUST_CNT_CD = BB.BKG_CTRL_PTY_CUST_CNT_CD AND A.CUST_SEQ = BB.BKG_CTRL_PTY_CUST_SEQ ) CUST_NM" ).append("\n"); 
		query.append("        FROM    BKG_BKG_HIS BB" ).append("\n"); 
		query.append("        WHERE   BB.BKG_NO         = @[bkg_no]" ).append("\n"); 
		query.append("        AND     BB.CORR_NO        = 'TMP0000001'" ).append("\n"); 
		query.append("        AND     BB.BKG_CTRL_PTY_CUST_CNT_CD    IS NOT NULL" ).append("\n"); 
		query.append("        AND     BB.BKG_CTRL_PTY_CUST_SEQ       <> 0" ).append("\n"); 
		query.append("        AND     @[ca_flg]         = 'Y'" ).append("\n"); 
		query.append("        ) BC," ).append("\n"); 
		query.append("        (" ).append("\n"); 
		query.append("        /* CONTRACT CUSTOMER */" ).append("\n"); 
		query.append("        SELECT  CP.CUST_CNT_CD  CUST_CNT_CD ," ).append("\n"); 
		query.append("                CP.CUST_SEQ     CUST_SEQ    ," ).append("\n"); 
		query.append("                ( SELECT UPPER(SUBSTR(A.CUST_LGL_ENG_NM, 1, 6)) FROM MDM_CUSTOMER A WHERE A.CUST_CNT_CD = CP.CUST_CNT_CD AND A.CUST_SEQ = CP.CUST_SEQ ) CUST_NM" ).append("\n"); 
		query.append("        FROM    SC  ," ).append("\n"); 
		query.append("                PRI_SP_CTRT_PTY CP" ).append("\n"); 
		query.append("        WHERE   CP.PROP_NO            = SC.PROP_NO" ).append("\n"); 
		query.append("        AND     CP.AMDT_SEQ           = SC.AMDT_SEQ" ).append("\n"); 
		query.append("        AND     CP.PRC_CTRT_PTY_TP_CD = 'C'" ).append("\n"); 
		query.append("        UNION ALL" ).append("\n"); 
		query.append("        /* AFFILIATE */" ).append("\n"); 
		query.append("        SELECT  SA.CUST_CNT_CD  ," ).append("\n"); 
		query.append("                SA.CUST_SEQ     ," ).append("\n"); 
		query.append("                ( SELECT UPPER(SUBSTR(A.CUST_LGL_ENG_NM, 1, 6)) FROM MDM_CUSTOMER A WHERE A.CUST_CNT_CD = SA.CUST_CNT_CD AND A.CUST_SEQ = SA.CUST_SEQ ) CUST_NM" ).append("\n"); 
		query.append("        FROM    SC  ," ).append("\n"); 
		query.append("                PRI_SP_AFIL SA" ).append("\n"); 
		query.append("        WHERE   SA.PROP_NO  = SC.PROP_NO" ).append("\n"); 
		query.append("        AND     SA.AMDT_SEQ = SC.AMDT_SEQ" ).append("\n"); 
		query.append("        ) SC" ).append("\n"); 
		query.append("WHERE   (" ).append("\n"); 
		query.append("            (" ).append("\n"); 
		query.append("                BC.CUST_CNT_CD  = SC.CUST_CNT_CD" ).append("\n"); 
		query.append("            AND BC.CUST_SEQ     = SC.CUST_SEQ" ).append("\n"); 
		query.append("            )" ).append("\n"); 
		query.append("        OR  BC.CUST_NM  = SC.CUST_NM" ).append("\n"); 
		query.append("        )" ).append("\n"); 
		query.append("AND     ROWNUM      = 1" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("SELECT  'B'   UMCH_TP_CD      ," ).append("\n"); 
		query.append("        '[Shipper]['" ).append("\n"); 
		query.append("          ||  DECODE(@[ca_flg]," ).append("\n"); 
		query.append("                'N', ( SELECT CUST_CNT_CD || LPAD(CUST_SEQ, 6, '0') FROM BKG_CUSTOMER WHERE BKG_NO = @[bkg_no] AND BKG_CUST_TP_CD = 'S' )," ).append("\n"); 
		query.append("                'Y', ( SELECT CUST_CNT_CD || LPAD(CUST_SEQ, 6, '0') FROM BKG_CUST_HIS WHERE BKG_NO = @[bkg_no] AND CORR_NO = 'TMP0000001' AND BKG_CUST_TP_CD = 'S' )" ).append("\n"); 
		query.append("                )" ).append("\n"); 
		query.append("          ||  ']' || CHR(10) || '[Consignee]['" ).append("\n"); 
		query.append("          ||  DECODE(@[ca_flg]," ).append("\n"); 
		query.append("                'N', ( SELECT CUST_CNT_CD || LPAD(CUST_SEQ, 6, '0') FROM BKG_CUSTOMER WHERE BKG_NO = @[bkg_no] AND BKG_CUST_TP_CD = 'C' )," ).append("\n"); 
		query.append("                'Y', ( SELECT CUST_CNT_CD || LPAD(CUST_SEQ, 6, '0') FROM BKG_CUST_HIS WHERE BKG_NO = @[bkg_no] AND CORR_NO = 'TMP0000001' AND BKG_CUST_TP_CD = 'C' )" ).append("\n"); 
		query.append("                )" ).append("\n"); 
		query.append("          ||  ']' || CHR(10) || '[Notify]['" ).append("\n"); 
		query.append("          ||  DECODE(@[ca_flg]," ).append("\n"); 
		query.append("                'N', ( SELECT CUST_CNT_CD || LPAD(CUST_SEQ, 6, '0') FROM BKG_CUSTOMER WHERE BKG_NO = @[bkg_no] AND BKG_CUST_TP_CD = 'N' )," ).append("\n"); 
		query.append("                'Y', ( SELECT CUST_CNT_CD || LPAD(CUST_SEQ, 6, '0') FROM BKG_CUST_HIS WHERE BKG_NO = @[bkg_no] AND CORR_NO = 'TMP0000001' AND BKG_CUST_TP_CD = 'N' )" ).append("\n"); 
		query.append("                )" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("          ||  ']' || CHR(10) || '[F/Forwarder]['" ).append("\n"); 
		query.append("          ||  DECODE(@[ca_flg]," ).append("\n"); 
		query.append("                'N', ( SELECT CUST_CNT_CD || LPAD(CUST_SEQ, 6, '0') FROM BKG_CUSTOMER WHERE BKG_NO = @[bkg_no] AND BKG_CUST_TP_CD = 'F' )," ).append("\n"); 
		query.append("                'Y', ( SELECT CUST_CNT_CD || LPAD(CUST_SEQ, 6, '0') FROM BKG_CUST_HIS WHERE BKG_NO = @[bkg_no] AND CORR_NO = 'TMP0000001' AND BKG_CUST_TP_CD = 'F' )" ).append("\n"); 
		query.append("                )" ).append("\n"); 
		query.append("          ||  ']' || CHR(10) || '[Contract Party]['" ).append("\n"); 
		query.append("          ||  DECODE('N'," ).append("\n"); 
		query.append("                'N', ( SELECT BKG_CTRL_PTY_CUST_CNT_CD || LPAD(BKG_CTRL_PTY_CUST_SEQ, 6, '0') FROM BKG_BOOKING WHERE BKG_NO = @[bkg_no] )," ).append("\n"); 
		query.append("                'Y', ( SELECT BKG_CTRL_PTY_CUST_CNT_CD || LPAD(BKG_CTRL_PTY_CUST_SEQ, 6, '0') FROM BKG_BKG_HIS WHERE BKG_NO = @[bkg_no] AND CORR_NO = 'TMP0000001' )" ).append("\n"); 
		query.append("                )   " ).append("\n"); 
		query.append("          ||  ']' BKG_ITM_LOG ," ).append("\n"); 
		query.append("        (" ).append("\n"); 
		query.append("        SELECT  '[Customer][' || CUST_CNT_CD || LPAD(CUST_SEQ, 6, '0') || ']'" ).append("\n"); 
		query.append("        FROM    PRI_SP_CTRT_PTY CP" ).append("\n"); 
		query.append("        WHERE   ( CP.PROP_NO, CP.AMDT_SEQ ) = ( SELECT PROP_NO, AMDT_SEQ FROM SC )" ).append("\n"); 
		query.append("        AND     PRC_CTRT_PTY_TP_CD  = 'C'" ).append("\n"); 
		query.append("        )" ).append("\n"); 
		query.append("        ||" ).append("\n"); 
		query.append("        (" ).append("\n"); 
		query.append("        SELECT  CHR(10) || '[Affiliate]'" ).append("\n"); 
		query.append("        FROM    DUAL" ).append("\n"); 
		query.append("        WHERE   EXISTS  (" ).append("\n"); 
		query.append("                        SELECT  'X'" ).append("\n"); 
		query.append("                        FROM    PRI_SP_AFIL SA" ).append("\n"); 
		query.append("                        WHERE   ( SA.PROP_NO, SA.AMDT_SEQ ) = ( SELECT PROP_NO, AMDT_SEQ FROM SC )" ).append("\n"); 
		query.append("                        AND     SA.SRC_INFO_CD  <> 'AD'" ).append("\n"); 
		query.append("                        )" ).append("\n"); 
		query.append("        )" ).append("\n"); 
		query.append("        ||" ).append("\n"); 
		query.append("        (" ).append("\n"); 
		query.append("        SELECT  REPLACE(RTRIM(REPLACE(LTRIM(SYS_CONNECT_BY_PATH(CUST_CD || DECODE(MOD(ROW_NUMBER, 5), 0, '/'), ';'), ';'), '/;', CHR(10)) ,'/'), ';', '')" ).append("\n"); 
		query.append("        FROM    (" ).append("\n"); 
		query.append("                SELECT  '[' || CUST_CNT_CD || LPAD(CUST_SEQ, 6, '0') || ']' CUST_CD ," ).append("\n"); 
		query.append("                        ROW_NUMBER() OVER ( ORDER BY AFIL_SEQ ) ROW_NUMBER  ," ).append("\n"); 
		query.append("                        COUNT(1) OVER () CNT" ).append("\n"); 
		query.append("                FROM    PRI_SP_AFIL SA" ).append("\n"); 
		query.append("                WHERE   ( SA.PROP_NO, SA.AMDT_SEQ ) = ( SELECT PROP_NO, AMDT_SEQ FROM SC )" ).append("\n"); 
		query.append("                AND     SA.SRC_INFO_CD  <> 'AD'" ).append("\n"); 
		query.append("                )" ).append("\n"); 
		query.append("        WHERE   LEVEL   = LEAST(CNT, 20)" ).append("\n"); 
		query.append("        START WITH ROW_NUMBER = 1" ).append("\n"); 
		query.append("        CONNECT BY" ).append("\n"); 
		query.append("                ROW_NUMBER        = PRIOR ROW_NUMBER + 1" ).append("\n"); 
		query.append("        )   CTRT_ITM_LOG    ," ).append("\n"); 
		query.append("        'U'   MTCH_UMCH_TP_CD ," ).append("\n"); 
		query.append("        ( SELECT UMCH_TP_DESC FROM BKG_REV_UMCH_TP WHERE UMCH_TP_CD = 'B' ) UMCH_TP_DESC  ," ).append("\n"); 
		query.append("        ( SELECT INTG_CD_VAL_DP_DESC FROM COM_INTG_CD_DTL WHERE INTG_CD_ID = 'CD02456' AND INTG_CD_VAL_CTNT = 'U' ) MTCH_UMCH_TP_DESC" ).append("\n"); 
		query.append("FROM    DUAL" ).append("\n"); 
		query.append("WHERE   NOT EXISTS ( SELECT 'X' FROM C1 )" ).append("\n"); 
		query.append("AND	    NOT EXISTS ( SELECT 'X' --S/C Customer의 Type이 ‘NVOCC’인 경우 Error B 심사대상에서 제외" ).append("\n"); 
		query.append("					 FROM BKG_BOOKING BK, " ).append("\n"); 
		query.append("						  PRI_SP_HDR  SH," ).append("\n"); 
		query.append("						  PRI_SP_MN   SM," ).append("\n"); 
		query.append("						  PRI_SP_SCP_MN SS," ).append("\n"); 
		query.append("						  PRI_SP_CTRT_CUST_TP CT" ).append("\n"); 
		query.append("					 WHERE 1=1" ).append("\n"); 
		query.append("					 AND   SH.SC_NO = BK.SC_NO" ).append("\n"); 
		query.append("					 AND   SM.PROP_NO = SH.PROP_NO" ).append("\n"); 
		query.append("					 AND   SM.PROP_STS_CD ='F'" ).append("\n"); 
		query.append("				     AND   SS.PROP_NO = SM.PROP_NO" ).append("\n"); 
		query.append("					 AND   SS.AMDT_SEQ = SM.AMDT_SEQ" ).append("\n"); 
		query.append("					 AND   SS.SVC_SCP_CD IN (BK.SVC_SCP_CD,DECODE(BK.SVC_SCP_CD,'ACE','TPE','MXE','TPE'))" ).append("\n"); 
		query.append("					 AND   SS.PROP_NO = CT.PROP_NO" ).append("\n"); 
		query.append("					 AND   SS.AMDT_SEQ = CT.AMDT_SEQ" ).append("\n"); 
		query.append("					 AND   CT.PRC_CTRT_PTY_TP_CD ='C'" ).append("\n"); 
		query.append("					 AND   CT.PRC_CTRT_CUST_TP_CD ='N'" ).append("\n"); 
		query.append("					 AND     ( SELECT BKG_REV_APLY_DT_PKG.BKG_GET_REV_APLY_DT_FNC(@[bkg_no], @[ca_flg]) FROM DUAL )" ).append("\n"); 
		query.append("					       BETWEEN SS.EFF_DT AND SS.EXP_DT" ).append("\n"); 
		query.append("					 AND     BK.BKG_NO       = @[bkg_no]" ).append("\n"); 
		query.append("					 AND     @[ca_flg]       = 'N'" ).append("\n"); 
		query.append("					 UNION ALL" ).append("\n"); 
		query.append("					 SELECT 'X' " ).append("\n"); 
		query.append("					 FROM BKG_BKG_HIS BK, " ).append("\n"); 
		query.append("						  PRI_SP_HDR  SH," ).append("\n"); 
		query.append("						  PRI_SP_MN   SM," ).append("\n"); 
		query.append("						  PRI_SP_SCP_MN SS," ).append("\n"); 
		query.append("						  PRI_SP_CTRT_CUST_TP CT" ).append("\n"); 
		query.append("					 WHERE 1=1" ).append("\n"); 
		query.append("					 AND   SH.SC_NO = BK.SC_NO" ).append("\n"); 
		query.append("					 AND   SM.PROP_NO = SH.PROP_NO" ).append("\n"); 
		query.append("					 AND   SM.PROP_STS_CD ='F'" ).append("\n"); 
		query.append("				     AND   SS.PROP_NO = SM.PROP_NO" ).append("\n"); 
		query.append("					 AND   SS.AMDT_SEQ = SM.AMDT_SEQ" ).append("\n"); 
		query.append("					 AND   SS.SVC_SCP_CD IN (BK.SVC_SCP_CD,DECODE(BK.SVC_SCP_CD,'ACE','TPE','MXE','TPE'))" ).append("\n"); 
		query.append("					 AND   SS.PROP_NO = CT.PROP_NO" ).append("\n"); 
		query.append("					 AND   SS.AMDT_SEQ = CT.AMDT_SEQ" ).append("\n"); 
		query.append("					 AND   CT.PRC_CTRT_PTY_TP_CD ='C'" ).append("\n"); 
		query.append("					 AND   CT.PRC_CTRT_CUST_TP_CD ='N'" ).append("\n"); 
		query.append("					 AND     ( SELECT BKG_REV_APLY_DT_PKG.BKG_GET_REV_APLY_DT_FNC(@[bkg_no], @[ca_flg]) FROM DUAL )" ).append("\n"); 
		query.append("					       BETWEEN SS.EFF_DT AND SS.EXP_DT" ).append("\n"); 
		query.append("					 AND     BK.BKG_NO       = @[bkg_no]" ).append("\n"); 
		query.append("					 AND     BK.CORR_NO      = 'TMP0000001'  " ).append("\n"); 
		query.append("					 AND     @[ca_flg]       = 'Y'" ).append("\n"); 
		query.append("					)" ).append("\n"); 
		query.append("/*******************************************************************************************" ).append("\n"); 
		query.append("신규 BKG 만 대상으로 한다." ).append("\n"); 
		query.append("*******************************************************************************************/" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("AND     LENGTH(@[bkg_no]) = 12" ).append("\n"); 

	}
}