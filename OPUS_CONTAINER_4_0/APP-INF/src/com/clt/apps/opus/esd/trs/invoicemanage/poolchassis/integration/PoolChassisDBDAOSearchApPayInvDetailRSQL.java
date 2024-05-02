/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : PoolChassisDBDAOSearchApPayInvDetailRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.03.09
*@LastModifier : 
*@LastVersion : 1.0
* 2011.03.09 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.trs.invoicemanage.poolchassis.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PoolChassisDBDAOSearchApPayInvDetailRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * AP_PAY_INV_DTL detail insert
	  * </pre>
	  */
	public PoolChassisDBDAOSearchApPayInvDetailRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.trs.invoicemanage.poolchassis.integration").append("\n"); 
		query.append("FileName : PoolChassisDBDAOSearchApPayInvDetailRSQL").append("\n"); 
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
		query.append("SELECT " ).append("\n"); 
		query.append("      'EQCZCP' AS LGS_COST_CD" ).append("\n"); 
		query.append("      ,'512333' AS ACCT_CD" ).append("\n"); 
		query.append("      ,SUBSTR(NVL(FINC_VVD_CD,'0000000000'), 1,4) VSL_CD" ).append("\n"); 
		query.append("      ,SUBSTR(NVL(FINC_VVD_CD,'0000000000'), 5,4) SKD_VOY_NO" ).append("\n"); 
		query.append("      ,SUBSTR(NVL(FINC_VVD_CD,'0000000000'), 9,1) SKD_DIR_CD" ).append("\n"); 
		query.append("      ,SUBSTR(NVL(FINC_VVD_CD,'0000000000'),10,1) REV_DIR_CD" ).append("\n"); 
		query.append("      ,'' SLAN_CD" ).append("\n"); 
		query.append("      ,'' ACT_VVD_CD" ).append("\n"); 
		query.append("      ,'' CNTR_TPSZ_CD" ).append("\n"); 
		query.append("      ,TRSP_POOL_CHSS_INV_AMT AS INV_AMT" ).append("\n"); 
		query.append("      ,'' SO_OFC_CTY_CD" ).append("\n"); 
		query.append("      ,'' SO_SEQ" ).append("\n"); 
		query.append("      ,'I' IBFLAG" ).append("\n"); 
		query.append("  FROM TRS_TRSP_POOL_CHSS_INV S" ).append("\n"); 
		query.append(" WHERE INV_NO = @[inv_no] -- 파라메터로 받음 (Confirm 한 invoice no)" ).append("\n"); 

	}
}