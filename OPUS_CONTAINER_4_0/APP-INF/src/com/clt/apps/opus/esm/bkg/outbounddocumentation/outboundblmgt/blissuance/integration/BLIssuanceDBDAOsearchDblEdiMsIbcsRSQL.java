/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : BLIssuanceDBDAOsearchDblEdiMsIbcsRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.01.08
*@LastModifier : 
*@LastVersion : 1.0
* 2015.01.08 
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

public class BLIssuanceDBDAOsearchDblEdiMsIbcsRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * select
	  * </pre>
	  */
	public BLIssuanceDBDAOsearchDblEdiMsIbcsRSQL(){
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

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.integration").append("\n"); 
		query.append("FileName : BLIssuanceDBDAOsearchDblEdiMsIbcsRSQL").append("\n"); 
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
		query.append("SELECT FF" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("SELECT " ).append("\n"); 
		query.append("	   'MS_IBCS_NM1:'   || BKG_TOKEN_NL_FNC(NVL(CUST_NM,''), 1, '')   || CHR(10)||" ).append("\n"); 
		query.append("       'MS_IBCS_NM2:'   || BKG_TOKEN_NL_FNC(NVL(CUST_NM,''), 2, '')   || CHR(10)||" ).append("\n"); 
		query.append("       'MS_IBCS_ADDR1:' || BKG_TOKEN_NL_FNC(NVL(CUST_ADDR,''), 1, '') || CHR(10)||" ).append("\n"); 
		query.append("       'MS_IBCS_ADDR2:' || BKG_TOKEN_NL_FNC(NVL(CUST_ADDR,''), 2, '') || CHR(10)||" ).append("\n"); 
		query.append("       'MS_IBCS_ADDR3:' || BKG_TOKEN_NL_FNC(NVL(CUST_ADDR,''), 3, '') || CHR(10)||" ).append("\n"); 
		query.append("       'MS_CUST_CD:'    || CUST_SEQ  || CHR(10)||" ).append("\n"); 
		query.append("       'MS_CITY_NM:'    || ''  || CHR(10)||" ).append("\n"); 
		query.append("       'MS_STAT_CD:'    || STE_CD  || CHR(10)||" ).append("\n"); 
		query.append("       'MS_ZIP_CD:'    || PST_CTNT  || CHR(10)||" ).append("\n"); 
		query.append("       'MS_CNT_CD:'    || CNT_CD  " ).append("\n"); 
		query.append("        || CHR(10) AS FF" ).append("\n"); 
		query.append(",ROW_NUMBER() OVER(PARTITION BY MST.XTER_SNDR_ID,MST.XTER_RQST_NO ORDER BY MST.UPLD_DT DESC) RNUM " ).append("\n"); 
		query.append(",CUST.*" ).append("\n"); 
		query.append("FROM   BKG_XTER_RQST_MST MST , BKG_XTER_CUST CUST " ).append("\n"); 
		query.append("WHERE MST.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("AND MST.XTER_RQST_NO = CUST.XTER_RQST_NO" ).append("\n"); 
		query.append("AND MST.XTER_RQST_SEQ = CUST.XTER_RQST_SEQ" ).append("\n"); 
		query.append("AND MST.XTER_SNDR_ID = CUST.XTER_SNDR_ID" ).append("\n"); 
		query.append("AND BKG_UPLD_STS_CD ='F'" ).append("\n"); 
		query.append("AND XTER_CUST_TP_CD ='MS'" ).append("\n"); 
		query.append("ORDER BY MST.XTER_RQST_NO DESC" ).append("\n"); 
		query.append(") FF" ).append("\n"); 
		query.append("WHERE RNUM =1" ).append("\n"); 

	}
}