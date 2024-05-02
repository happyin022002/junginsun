/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : AccountReceivableEDISendDBDAOSearchEDICustInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.05.13
*@LastModifier : 
*@LastVersion : 1.0
* 2016.05.13 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.accountreceivableedisend.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AccountReceivableEDISendDBDAOSearchEDICustInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchEDICustInfo
	  * </pre>
	  */
	public AccountReceivableEDISendDBDAOSearchEDICustInfoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.accountreceivableedisend.integration").append("\n"); 
		query.append("FileName : AccountReceivableEDISendDBDAOSearchEDICustInfoRSQL").append("\n"); 
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
		query.append("SELECT  EDI.EDI_GRP_CD" ).append("\n"); 
		query.append("      , EDI.CUST_TRD_PRNR_ID AS RECEIVER_ID" ).append("\n"); 
		query.append("      , EDI.PROV_TRD_PRNR_ID AS SENDER_ID" ).append("\n"); 
		query.append("      , NVL(MC.INV_EDI_LVL_CD, 'B') AS EDI_LVL" ).append("\n"); 
		query.append("FROM EDI_GROUP EDI, EDI_GRP_CUST ECUST, MDM_CUSTOMER MC" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND   EDI. EDI_GRP_CD = ECUST.EDI_GRP_CD" ).append("\n"); 
		query.append("AND   ECUST.CUST_CNT_CD = MC.CUST_CNT_CD" ).append("\n"); 
		query.append("AND   ECUST.CUST_SEQ = MC.CUST_SEQ" ).append("\n"); 
		query.append("AND   ECUST.CUST_CNT_CD = @[cust_cnt_cd]" ).append("\n"); 
		query.append("AND   ECUST.CUST_SEQ = @[cust_seq]" ).append("\n"); 
		query.append("AND  (  ( NVL(MC.INV_EDI_LVL_CD, 'B') = 'B' AND  EDI. EDI_GRP_CD IN (  'INVBL001' , 'INVBL002' , 'INVBL003' , 'INVBL004', 'INVBL005', 'INVBL006' , 'INVBL007', 'INVBL008', 'INVBL009'  ) ) " ).append("\n"); 
		query.append("       OR ( NVL(MC.INV_EDI_LVL_CD, 'B') <> 'B' AND  EDI. EDI_GRP_CD IN ( 'INVOIC001', 'INVOIC002' , 'INVOIC003'  )   ) )" ).append("\n"); 
		query.append("GROUP BY EDI.EDI_GRP_CD, EDI.CUST_TRD_PRNR_ID, EDI.PROV_TRD_PRNR_ID, MC.INV_EDI_LVL_CD" ).append("\n"); 

	}
}