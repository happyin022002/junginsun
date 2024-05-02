/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : ARInvoiceCorrectionDBDAOModifySysClearMainByIFNoUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.06.14
*@LastModifier : 
*@LastVersion : 1.0
* 2016.06.14 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.arinvoicecorrection.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ARInvoiceCorrectionDBDAOModifySysClearMainByIFNoUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Modify Sys Clear Main By IF No
	  * </pre>
	  */
	public ARInvoiceCorrectionDBDAOModifySysClearMainByIFNoUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("upd_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ar_if_no1",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ar_if_no2",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.arinvoicecorrection.integration").append("\n"); 
		query.append("FileName : ARInvoiceCorrectionDBDAOModifySysClearMainByIFNoUSQL").append("\n"); 
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
		query.append("UPDATE INV_AR_MN" ).append("\n"); 
		query.append("SET INV_ISS_FLG = 'Y'," ).append("\n"); 
		query.append("    INV_CLR_FLG = 'Y'," ).append("\n"); 
		query.append("    ISS_DT = TO_CHAR( SYSDATE, 'YYYYMMDD' )," ).append("\n"); 
		query.append("    UPD_USR_ID = @[upd_usr_id]," ).append("\n"); 
		query.append("    UPD_DT = SYSDATE" ).append("\n"); 
		query.append("WHERE AR_IF_NO IN (@[ar_if_no1], @[ar_if_no2])" ).append("\n"); 
		query.append("AND INV_ISS_FLG = 'N'" ).append("\n"); 
		query.append("AND INV_CLR_FLG = 'N'" ).append("\n"); 
		query.append("AND EXISTS (SELECT  'X'" ).append("\n"); 
		query.append("            FROM   (SELECT  /*+ ORDERED USE_NL(A B) INDEX(B XAK3INV_AR_CHG) */" ).append("\n"); 
		query.append("                            A.AR_OFC_CD, A.BL_SRC_NO, A.ACT_CUST_CNT_CD, A.ACT_CUST_SEQ, A.VSL_CD, A.SKD_VOY_NO, A.SKD_DIR_CD, DECODE(A.REV_TP_CD,'M','M','B','B','C','B') REV_TP_CD, A.BFR_INV_CURR_CD, B.CURR_CD," ).append("\n"); 
		query.append("                            SUM(B.CHG_AMT)              SUM_CHG_AMT," ).append("\n"); 
		query.append("                            COUNT(DISTINCT A.AR_IF_NO)  CNT_AR_IF_NO" ).append("\n"); 
		query.append("                    FROM    INV_AR_MN   A," ).append("\n"); 
		query.append("                            INV_AR_CHG  B" ).append("\n"); 
		query.append("                    WHERE   A.AR_IF_NO = B.AR_IF_NO" ).append("\n"); 
		query.append("                    AND     A.AR_IF_NO IN (@[ar_if_no1], @[ar_if_no2])" ).append("\n"); 
		query.append("					AND     A.INV_ISS_FLG = 'N'" ).append("\n"); 
		query.append("                    AND     A.INV_CLR_FLG = 'N'" ).append("\n"); 
		query.append("                    GROUP BY A.AR_OFC_CD, A.BL_SRC_NO, A.ACT_CUST_CNT_CD, A.ACT_CUST_SEQ, A.VSL_CD, A.SKD_VOY_NO, A.SKD_DIR_CD, DECODE(A.REV_TP_CD,'M','M','B','B','C','B'), A.BFR_INV_CURR_CD, B.CURR_CD, B.INV_XCH_RT" ).append("\n"); 
		query.append("                    )" ).append("\n"); 
		query.append("            GROUP BY AR_OFC_CD, BL_SRC_NO, ACT_CUST_CNT_CD, ACT_CUST_SEQ, VSL_CD, SKD_VOY_NO, SKD_DIR_CD, REV_TP_CD, BFR_INV_CURR_CD" ).append("\n"); 
		query.append("            HAVING MIN(CNT_AR_IF_NO) > 1  AND  MAX(ABS(SUM_CHG_AMT)) = 0)" ).append("\n"); 

	}
}