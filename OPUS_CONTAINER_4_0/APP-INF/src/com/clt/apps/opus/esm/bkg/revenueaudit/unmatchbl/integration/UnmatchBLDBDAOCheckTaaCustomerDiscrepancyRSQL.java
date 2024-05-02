/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : UnmatchBLDBDAOCheckTaaCustomerDiscrepancyRSQL.java
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

public class UnmatchBLDBDAOCheckTaaCustomerDiscrepancyRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * checkTaaCustomerDiscrepancy
	  * </pre>
	  */
	public UnmatchBLDBDAOCheckTaaCustomerDiscrepancyRSQL(){
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
		query.append("FileName : UnmatchBLDBDAOCheckTaaCustomerDiscrepancyRSQL").append("\n"); 
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
		query.append("AND     TM.SVC_SCP_CD   = BK.SVC_SCP_CD" ).append("\n"); 
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
		query.append("AND     TM.SVC_SCP_CD   = BK.SVC_SCP_CD" ).append("\n"); 
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
		query.append("" ).append("\n"); 
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
		query.append("		UNION" ).append("\n"); 
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
		query.append("        SELECT  TM.CTRT_CUST_CNT_CD CUST_CNT_CD ," ).append("\n"); 
		query.append("                TM.CTRT_CUST_SEQ    CUST_SEQ    ," ).append("\n"); 
		query.append("                ( SELECT UPPER(SUBSTR(A.CUST_LGL_ENG_NM, 1, 6)) FROM MDM_CUSTOMER A WHERE A.CUST_CNT_CD = TM.CTRT_CUST_CNT_CD AND A.CUST_SEQ = TM.CTRT_CUST_SEQ ) CUST_NM" ).append("\n"); 
		query.append("        FROM    TA  ," ).append("\n"); 
		query.append("                PRI_TAA_MN  TM" ).append("\n"); 
		query.append("        WHERE   TM.TAA_PROP_NO  = TA.PROP_NO" ).append("\n"); 
		query.append("        AND     TM.AMDT_SEQ     = TA.AMDT_SEQ" ).append("\n"); 
		query.append("        ) RC" ).append("\n"); 
		query.append("WHERE   (" ).append("\n"); 
		query.append("            (" ).append("\n"); 
		query.append("                BC.CUST_CNT_CD  = RC.CUST_CNT_CD" ).append("\n"); 
		query.append("            AND BC.CUST_SEQ     = RC.CUST_SEQ" ).append("\n"); 
		query.append("            )" ).append("\n"); 
		query.append("        OR  BC.CUST_NM  = RC.CUST_NM" ).append("\n"); 
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
		query.append("		  ||  ']' || CHR(10) || '[Contract Party]['" ).append("\n"); 
		query.append("          ||  DECODE('N'," ).append("\n"); 
		query.append("                'N', ( SELECT BKG_CTRL_PTY_CUST_CNT_CD || LPAD(BKG_CTRL_PTY_CUST_SEQ, 6, '0') FROM BKG_BOOKING WHERE BKG_NO = @[bkg_no] )," ).append("\n"); 
		query.append("                'Y', ( SELECT BKG_CTRL_PTY_CUST_CNT_CD || LPAD(BKG_CTRL_PTY_CUST_SEQ, 6, '0') FROM BKG_BKG_HIS WHERE BKG_NO = @[bkg_no] AND CORR_NO = 'TMP0000001' )" ).append("\n"); 
		query.append("                ) " ).append("\n"); 
		query.append("          ||  ']' BKG_ITM_LOG ," ).append("\n"); 
		query.append("        (" ).append("\n"); 
		query.append("        SELECT  '[Customer][' || CTRT_CUST_CNT_CD || LPAD(CTRT_CUST_SEQ, 6, '0') || ']'" ).append("\n"); 
		query.append("        FROM    PRI_TAA_MN TM" ).append("\n"); 
		query.append("        WHERE   ( TM.TAA_PROP_NO, TM.AMDT_SEQ ) = ( SELECT PROP_NO, AMDT_SEQ FROM TA )" ).append("\n"); 
		query.append("        )   CTRT_ITM_LOG    ," ).append("\n"); 
		query.append("        'U'   MTCH_UMCH_TP_CD ," ).append("\n"); 
		query.append("        ( SELECT UMCH_TP_DESC FROM BKG_REV_UMCH_TP WHERE UMCH_TP_CD = 'B' ) UMCH_TP_DESC  ," ).append("\n"); 
		query.append("        ( SELECT INTG_CD_VAL_DP_DESC FROM COM_INTG_CD_DTL WHERE INTG_CD_ID = 'CD02456' AND INTG_CD_VAL_CTNT = 'U' ) MTCH_UMCH_TP_DESC" ).append("\n"); 
		query.append("FROM    DUAL" ).append("\n"); 
		query.append("WHERE   NOT EXISTS ( SELECT 'X' FROM C1 )" ).append("\n"); 

	}
}