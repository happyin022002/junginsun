/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : AccountPayableInvoiceDBDAOSearchInvoiceInterfaceAccountAndVVDLevelCheckRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.05.12
*@LastModifier : 차상영
*@LastVersion : 1.0
* 2014.05.12 차상영
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.stm.sap.accountpayableinvoice.accountpayableinvoice.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author SANGYOUNG CHA
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AccountPayableInvoiceDBDAOSearchInvoiceInterfaceAccountAndVVDLevelCheckRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * AccountPayableInvoiceDBDAOSearchInvoiceInterfaceAccountAndVVDLevelCheckRSQL
	  * </pre>
	  */
	public AccountPayableInvoiceDBDAOSearchInvoiceInterfaceAccountAndVVDLevelCheckRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("liab_coa_vvd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("liab_coa_acct_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.stm.sap.accountpayableinvoice.accountpayableinvoice.integration ").append("\n"); 
		query.append("FileName : AccountPayableInvoiceDBDAOSearchInvoiceInterfaceAccountAndVVDLevelCheckRSQL").append("\n"); 
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
		query.append("SELECT   MA.VVD_LVL_FLG1      AS VVD_LEVEL_1" ).append("\n"); 
		query.append("       , MA.VVD_LVL_FLG2      AS VVD_LEVEL_2" ).append("\n"); 
		query.append("       , MA.VVD_LVL_FLG3      AS VVD_LEVEL_3" ).append("\n"); 
		query.append("       , MA.VVD_LVL_FLG4      AS VVD_LEVEL_4" ).append("\n"); 
		query.append("       , MA.VVD_LVL_FLG5      AS VVD_LEVEL_5" ).append("\n"); 
		query.append("       , MA.VVD_LVL_FLG6      AS VVD_LEVEL_6" ).append("\n"); 
		query.append("       , MA.ACCT_CD           AS ACCT_CD" ).append("\n"); 
		query.append("       , VVD.VVD_CD           AS VVD_CD" ).append("\n"); 
		query.append("       , VVD.VVD_COM_LVL      AS VVD_COMMON_LEVEL" ).append("\n"); 
		query.append("FROM     MDM_ACCOUNT MA," ).append("\n"); 
		query.append("         (SELECT  AMRV.VSL_CD || AMRV.SKD_VOY_NO || AMRV.SKD_DIR_CD || AMRV.RLANE_DIR_CD AS VVD_CD," ).append("\n"); 
		query.append("                  AMRV.VVD_COM_LVL AS VVD_COM_LVL" ).append("\n"); 
		query.append("          FROM    AR_MST_REV_VVD AMRV" ).append("\n"); 
		query.append("          WHERE   NVL(AMRV.DELT_FLG, 'N') <> 'Y'" ).append("\n"); 
		query.append("          UNION ALL" ).append("\n"); 
		query.append("          SELECT  SLD.lU_CD        AS VVD_CD" ).append("\n"); 
		query.append("                , ''               AS VVD_COM_LVL" ).append("\n"); 
		query.append("          FROM    SCO_LU_HDR SLH" ).append("\n"); 
		query.append("                , SCO_LU_DTL SLD" ).append("\n"); 
		query.append("          WHERE   SLH.LU_TP_CD = SLD.LU_TP_CD" ).append("\n"); 
		query.append("          AND     SLH.LU_TP_CD = 'GL VVD'" ).append("\n"); 
		query.append("          AND     NVL(SLD.ENBL_FLG, 'Y') = 'Y'" ).append("\n"); 
		query.append("          AND     NVL(SLD.LU_ST_DT, SYSDATE) >= SYSDATE" ).append("\n"); 
		query.append("          AND     SLH.LU_APPL_CD = 'SCO' ) VVD" ).append("\n"); 
		query.append("WHERE    NVL(MA.DELT_FLG, 'N') <> 'Y'" ).append("\n"); 
		query.append("AND      MA.ACCT_CD = @[liab_coa_acct_no]" ).append("\n"); 
		query.append("AND      VVD.VVD_CD = @[liab_coa_vvd_cd]" ).append("\n"); 

	}
}