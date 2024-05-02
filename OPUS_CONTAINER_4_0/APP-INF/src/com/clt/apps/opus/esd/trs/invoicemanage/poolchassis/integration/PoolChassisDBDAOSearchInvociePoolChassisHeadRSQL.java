/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : PoolChassisDBDAOSearchInvociePoolChassisHeadRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.12.26
*@LastModifier : 김성욱
*@LastVersion : 1.0
* 2016.12.26 김성욱
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.trs.invoicemanage.poolchassis.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Sung-Wook Kim
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PoolChassisDBDAOSearchInvociePoolChassisHeadRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Inovice Pool chassis의 Invoice Work  정보를 조회
	  * </pre>
	  */
	public PoolChassisDBDAOSearchInvociePoolChassisHeadRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("paymt_sp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.trs.invoicemanage.poolchassis.integration").append("\n"); 
		query.append("FileName : PoolChassisDBDAOSearchInvociePoolChassisHeadRSQL").append("\n"); 
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
		query.append("SELECT  INV_NO" ).append("\n"); 
		query.append("	    ,INV_VNDR_SEQ" ).append("\n"); 
		query.append("	    ,TRSP_INV_AUD_STS_CD" ).append("\n"); 
		query.append("	    ,INV_CURR_CD" ).append("\n"); 
		query.append("	    ,INV_BZC_AMT" ).append("\n"); 
		query.append("	    ,INV_TTL_AMT" ).append("\n"); 
		query.append("	    ,TO_CHAR(INV_RCV_DT, 'YYYY-MM-DD')INV_RCV_DT" ).append("\n"); 
		query.append("	    ,TO_CHAR(INV_ISS_DT, 'YYYY-MM-DD')INV_ISS_DT" ).append("\n"); 
		query.append("	    ,INV_VAT_AMT" ).append("\n"); 
		query.append("	    ,POOL_CHSS_COST_YRMON" ).append("\n"); 
		query.append("	    ,CHSS_POOL_CD" ).append("\n"); 
		query.append("	    ,DELT_FLG" ).append("\n"); 
		query.append("	    ,CRE_OFC_CD" ).append("\n"); 
		query.append("	    ,CRE_USR_ID" ).append("\n"); 
		query.append("	    ,TO_CHAR(CRE_DT, 'YYYYMMDD') CRE_DT" ).append("\n"); 
		query.append("	    ,RGST_NO" ).append("\n"); 
		query.append("	    ,(SELECT CHSS_POOL_NM FROM TRS_TRSP_CHSS_POOL WHERE CHSS_POOL_CD = W.CHSS_POOL_CD AND NVL(DELT_FLG, 'N') <> 'Y') AS CHSS_POOL_NM" ).append("\n"); 
		query.append("FROM TRS_TRSP_INV_WRK W" ).append("\n"); 
		query.append("WHERE INV_NO = @[inv_no]" ).append("\n"); 
		query.append("AND INV_VNDR_SEQ = @[paymt_sp_cd]" ).append("\n"); 

	}
}