/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : BLIssuanceDBDAOsearchDblEdiChgDtl2RSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.25
*@LastModifier : 
*@LastVersion : 1.0
* 2010.02.25 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BLIssuanceDBDAOsearchDblEdiChgDtl2RSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * select
	  * </pre>
	  */
	public BLIssuanceDBDAOsearchDblEdiChgDtl2RSQL(){
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
		params.put("bl_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.integration").append("\n"); 
		query.append("FileName : BLIssuanceDBDAOsearchDblEdiChgDtl2RSQL").append("\n"); 
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
		query.append("SELECT '{CHARGE_TTL'                      || CHR(10)" ).append("\n"); 
		query.append("|| 'PPD_TOTAL:'                   || CHR(10)" ).append("\n"); 
		query.append("|| 'CCT_TOTAL:'                   || CHR(10)" ).append("\n"); 
		query.append("|| 'TOTAL_CUR:'                   || CHR(10)" ).append("\n"); 
		query.append("|| 'LCL_TOT_AMT:' || S.TOT        || CHR(10)" ).append("\n"); 
		query.append("|| 'CGO_RCV_DT:'  || (SELECT TO_CHAR(RT_APLY_DT, 'YYYYMMDD') FROM BKG_RATE WHERE BKG_NO = @[bkg_no]) || CHR(10)" ).append("\n"); 
		query.append("|| 'ACT_CUST:'    || T.CUST       || CHR(10)" ).append("\n"); 
		query.append("|| '}CHARGE_TTL'                  || CHR(10)" ).append("\n"); 
		query.append("FROM   (SELECT SUM (INV_TTL_LOCL_AMT) TOT" ).append("\n"); 
		query.append("FROM   INV_AR_MN" ).append("\n"); 
		query.append("WHERE  BL_INV_CFM_DT IS NOT NULL" ).append("\n"); 
		query.append("AND BL_SRC_NO = @[bl_no]" ).append("\n"); 
		query.append("AND ( (AR_OFC_CD = 'SINBB')" ).append("\n"); 
		query.append("OR (AR_OFC_CD = 'SHAAS'))" ).append("\n"); 
		query.append("AND NVL (INV_DELT_DIV_CD, 'N') <> 'Y') S," ).append("\n"); 
		query.append("(SELECT ACT_CUST_CNT_CD || TO_CHAR (ACT_CUST_SEQ, 'FM000000') CUST" ).append("\n"); 
		query.append("FROM   INV_AR_MN" ).append("\n"); 
		query.append("WHERE  AR_IF_NO = (SELECT MAX (AR_IF_NO) IF_NO" ).append("\n"); 
		query.append("FROM   INV_AR_MN" ).append("\n"); 
		query.append("WHERE  BL_INV_CFM_DT IS NOT NULL" ).append("\n"); 
		query.append("AND BL_SRC_NO = @[bl_no]" ).append("\n"); 
		query.append("AND ( (AR_OFC_CD = 'SINBB')" ).append("\n"); 
		query.append("OR (AR_OFC_CD = 'SHAAS'))" ).append("\n"); 
		query.append("AND NVL (INV_DELT_DIV_CD, 'N') <> 'Y')) T" ).append("\n"); 

	}
}