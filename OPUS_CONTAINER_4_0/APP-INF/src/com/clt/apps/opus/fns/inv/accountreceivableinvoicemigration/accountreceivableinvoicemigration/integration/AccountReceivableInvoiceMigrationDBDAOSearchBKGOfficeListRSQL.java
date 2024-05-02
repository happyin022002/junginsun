/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : AccountReceivableInvoiceMigrationDBDAOSearchBKGOfficeListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.03.08
*@LastModifier : 
*@LastVersion : 1.0
* 2016.03.08 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.fns.inv.accountreceivableinvoicemigration.accountreceivableinvoicemigration.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AccountReceivableInvoiceMigrationDBDAOSearchBKGOfficeListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Search BKG Office List
	  * </pre>
	  */
	public AccountReceivableInvoiceMigrationDBDAOSearchBKGOfficeListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.fns.inv.accountreceivableinvoicemigration.accountreceivableinvoicemigration.integration").append("\n"); 
		query.append("FileName : AccountReceivableInvoiceMigrationDBDAOSearchBKGOfficeListRSQL").append("\n"); 
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
		query.append("SELECT MAX(OFC.IO_BND_CD) IO_BND_CD," ).append("\n"); 
		query.append("       SUBSTR(MIN(OFC.CUST_CNT_CD||OFC.CUST_SEQ),1,2) CUST_CNT_CD," ).append("\n"); 
		query.append("       SUBSTR(MIN(OFC.CUST_CNT_CD||OFC.CUST_SEQ),3) CUST_SEQ," ).append("\n"); 
		query.append("       ORG.AR_HD_QTR_OFC_CD," ).append("\n"); 
		query.append("       ORG.AR_OFC_CD M_AR_OFC_CD," ).append("\n"); 
		query.append("       MIN(OFC.N3RD_FLG) N3RD_FLG," ).append("\n"); 
		query.append("       MIN(OFC.OFC_CD) OFC_CD" ).append("\n"); 
		query.append("  FROM MIGADM.MIG_INV_BKG_IF_CHG OFC," ).append("\n"); 
		query.append("       (SELECT OFC_CD," ).append("\n"); 
		query.append("               IO_BND_CD," ).append("\n"); 
		query.append("               BKG_NO, BKG_SEQ," ).append("\n"); 
		query.append("               MIN(N3RD_FLG) N3RD_FLG" ).append("\n"); 
		query.append("          FROM MIGADM.MIG_INV_BKG_IF_CHG" ).append("\n"); 
		query.append("         WHERE BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("           AND BKG_SEQ = @[bkg_seq]" ).append("\n"); 
		query.append("           AND CUST_SEQ IS NOT NULL" ).append("\n"); 
		query.append("		   AND CHG_AMT <> 0 " ).append("\n"); 
		query.append("         group by OFC_CD, IO_BND_CD, BKG_NO, BKG_SEQ) B," ).append("\n"); 
		query.append("       MDM_ORGANIZATION ORG" ).append("\n"); 
		query.append(" WHERE OFC.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("   AND OFC.BKG_SEQ = @[bkg_seq]" ).append("\n"); 
		query.append("   AND OFC.OFC_CD = ORG.OFC_CD" ).append("\n"); 
		query.append("   AND OFC.CUST_SEQ IS NOT NULL" ).append("\n"); 
		query.append("   AND B.OFC_CD = OFC.OFC_CD" ).append("\n"); 
		query.append("   AND B.IO_BND_CD = OFC.IO_BND_CD" ).append("\n"); 
		query.append("   AND B.BKG_NO = OFC.BKG_NO" ).append("\n"); 
		query.append("   AND B.BKG_SEQ = OFC.BKG_SEQ" ).append("\n"); 
		query.append("   AND B.N3RD_FLG = OFC.N3RD_FLG" ).append("\n"); 
		query.append("GROUP BY ORG.AR_HD_QTR_OFC_CD, ORG.AR_OFC_CD" ).append("\n"); 

	}
}