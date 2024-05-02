/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : AccountReceivableEDISendDBDAOSearchHPEDIMakefileCustomerRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.01.27
*@LastModifier : 최도순
*@LastVersion : 1.0
* 2011.01.27 최도순
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.accountreceivableedisend.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Choi Do Soon
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AccountReceivableEDISendDBDAOSearchHPEDIMakefileCustomerRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 
	  * </pre>
	  */
	public AccountReceivableEDISendDBDAOSearchHPEDIMakefileCustomerRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("max_if_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.accountreceivableedisend.integration").append("\n"); 
		query.append("FileName : AccountReceivableEDISendDBDAOSearchHPEDIMakefileCustomerRSQL").append("\n"); 
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
		query.append("SELECT DECODE(CUST.BKG_CUST_TP_CD,'C','ST','S','SF') AS CUST_TP_CD" ).append("\n"); 
		query.append("      ,CUST.CUST_CNT_CD||LPAD(TO_CHAR(CUST.CUST_SEQ),6,'0') AS CUST_CD" ).append("\n"); 
		query.append("      ,REPLACE(CUST.CUST_NM,chr(13)||chr(10),' ') AS CUST_NAME" ).append("\n"); 
		query.append("      ,'' AS CUST_NAME1" ).append("\n"); 
		query.append("      ,'' AS CUST_NAME2" ).append("\n"); 
		query.append("      ,REPLACE(CUST.CUST_ADDR,chr(13)||chr(10),' ') AS CUST_ADDR" ).append("\n"); 
		query.append("      ,'' AS CUST_ADDR1" ).append("\n"); 
		query.append("      ,CUST.CUST_CTY_NM AS CUST_CITY" ).append("\n"); 
		query.append("      ,CUST.CUST_STE_CD AS CUST_STATE" ).append("\n"); 
		query.append("      ,CUST.CUST_ZIP_ID AS CUST_POSTAL" ).append("\n"); 
		query.append("      ,CUST.CUST_CNT_CD AS CUST_CNT_CD" ).append("\n"); 
		query.append(" FROM  BKG_CUSTOMER CUST" ).append("\n"); 
		query.append("WHERE CUST.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("  AND CUST.BKG_CUST_TP_CD IN ('C','S')" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT 'BT' AS CUST_TP_CD" ).append("\n"); 
		query.append("      ,ACT.ACT_CUST_CNT_CD||LPAD(TO_CHAR(ACT.ACT_CUST_SEQ),6,'0') AS CUST_CD" ).append("\n"); 
		query.append("      ,REPLACE(MC.CUST_LGL_ENG_NM,chr(13)||chr(10),' ') AS CUST_NAME" ).append("\n"); 
		query.append("      ,'' AS CUST_NAME1" ).append("\n"); 
		query.append("      ,'' AS CUST_NAME2" ).append("\n"); 
		query.append("      ,NVL(REPLACE(MD.LOCL_ADDR1,chr(13)||chr(10),' ')||REPLACE(MD.LOCL_ADDR2,chr(13)||chr(10),' ')||REPLACE(MD.LOCL_ADDR3,chr(13)||chr(10),' ')||REPLACE(MD.LOCL_ADDR4,chr(13)||chr(10),' '),CR.LOCL_ADDR1) AS CUST_ADDR" ).append("\n"); 
		query.append("      ,'' AS CUST_ADDR1" ).append("\n"); 
		query.append("      ,MD.CTY_NM AS CUST_CITY" ).append("\n"); 
		query.append("      ,MD.STE_CD AS CUST_STATE" ).append("\n"); 
		query.append("      ,MD.ZIP_CD AS CUST_POSTAL" ).append("\n"); 
		query.append("     ,ACT.ACT_CUST_CNT_CD AS CUST_CNT_CD" ).append("\n"); 
		query.append("FROM INV_AR_MN ACT, MDM_CUSTOMER MC, MDM_CUST_ADDR MD, MDM_CR_CUST CR" ).append("\n"); 
		query.append("WHERE ACT.AR_IF_NO =  @[max_if_no]" ).append("\n"); 
		query.append("AND ACT.ACT_CUST_CNT_CD = MC.CUST_CNT_CD" ).append("\n"); 
		query.append("AND ACT.ACT_CUST_SEQ = MC.CUST_SEQ" ).append("\n"); 
		query.append("AND ACT.ACT_CUST_CNT_CD = MD.CUST_CNT_CD" ).append("\n"); 
		query.append("AND ACT.ACT_CUST_SEQ = MD.CUST_SEQ" ).append("\n"); 
		query.append("AND ACT.ACT_CUST_CNT_CD = CR.CUST_CNT_CD(+)" ).append("\n"); 
		query.append("AND ACT.ACT_CUST_SEQ = CR.CUST_SEQ(+)" ).append("\n"); 

	}
}