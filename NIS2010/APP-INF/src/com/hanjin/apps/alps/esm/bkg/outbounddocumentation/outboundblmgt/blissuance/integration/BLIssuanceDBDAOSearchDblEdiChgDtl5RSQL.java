/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : BLIssuanceDBDAOSearchDblEdiChgDtl5RSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.04.08
*@LastModifier : 김태경
*@LastVersion : 1.0
* 2013.04.08 김태경
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author kim tae kyoung
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BLIssuanceDBDAOSearchDblEdiChgDtl5RSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * BLIssuanceDBDAOSearchDblEdiChgDtl5RSQL
	  * </pre>
	  */
	public BLIssuanceDBDAOSearchDblEdiChgDtl5RSQL(){
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
		query.append("Path : com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.integration").append("\n"); 
		query.append("FileName : BLIssuanceDBDAOSearchDblEdiChgDtl5RSQL").append("\n"); 
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
		query.append("        '{CHARGE_TTL' || CHR(10)" ).append("\n"); 
		query.append("       || 'PPD_TOTAL:' || SUM(PPD) || CHR(10) " ).append("\n"); 
		query.append("       || 'CCT_TOTAL:' || SUM(CCT) || CHR(10) " ).append("\n"); 
		query.append("       || 'TOTAL_CUR:' || CURR || CHR(10) " ).append("\n"); 
		query.append("       || 'LCL_TOT_AMT:' || CHR(10) " ).append("\n"); 
		query.append("       || 'CGO_RCV_DT:'  || CHR(10) " ).append("\n"); 
		query.append("       || 'ACT_CUST:' || CHR(10) " ).append("\n"); 
		query.append("       || '}CHARGE_TTL' || CHR(10)" ).append("\n"); 
		query.append("FROM (       " ).append("\n"); 
		query.append("SELECT " ).append("\n"); 
		query.append("       DECODE(IO_BND_CD, 'O', ROUND(CHG.CHG_AMT/DECODE(CHG.CURR_CD,'USD',1,DECODE(NVL(USD_XCH_RT,1),0,1,NVL(USD_XCH_RT,1))),2), 0) PPD," ).append("\n"); 
		query.append("       0 CCT, " ).append("\n"); 
		query.append("       DECODE(NVL(MN.USD_XCH_RT,1),0,CHG.CURR_CD,1,CHG.CURR_CD,'USD') CURR " ).append("\n"); 
		query.append("FROM   INV_AR_MN MN," ).append("\n"); 
		query.append("       INV_AR_CHG CHG" ).append("\n"); 
		query.append("WHERE  MN.AR_IF_NO = CHG.AR_IF_NO" ).append("\n"); 
		query.append("AND    MN.BL_SRC_NO = @[bkg_no]" ).append("\n"); 
		query.append("AND    NVL(MN.INV_DELT_DIV_CD, 'N') <> 'Y'" ).append("\n"); 
		query.append("AND    MN.REV_TP_CD <> 'M'" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("WHERE PPD <> 0 " ).append("\n"); 
		query.append("GROUP BY CURR" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT " ).append("\n"); 
		query.append("        '{CHARGE_TTL' || CHR(10)" ).append("\n"); 
		query.append("       || 'PPD_TOTAL:' || SUM(PPD) || CHR(10) " ).append("\n"); 
		query.append("       || 'CCT_TOTAL:' || SUM(CCT) || CHR(10) " ).append("\n"); 
		query.append("       || 'TOTAL_CUR:' || CURR || CHR(10) " ).append("\n"); 
		query.append("       || 'LCL_TOT_AMT:' || CHR(10) " ).append("\n"); 
		query.append("       || 'CGO_RCV_DT:'  || CHR(10) " ).append("\n"); 
		query.append("       || 'ACT_CUST:' || CHR(10) " ).append("\n"); 
		query.append("       || '}CHARGE_TTL' || CHR(10)" ).append("\n"); 
		query.append("FROM (       " ).append("\n"); 
		query.append("SELECT " ).append("\n"); 
		query.append("       0 PPD," ).append("\n"); 
		query.append("       DECODE(IO_BND_CD, 'I', ROUND(CHG.CHG_AMT/DECODE(CHG.CURR_CD,'USD',1,DECODE(NVL(USD_XCH_RT,1),0,1,NVL(USD_XCH_RT,1))),2), 0) CCT, " ).append("\n"); 
		query.append("       DECODE(NVL(MN.USD_XCH_RT,1),0,CHG.CURR_CD,1,CHG.CURR_CD,'USD') CURR " ).append("\n"); 
		query.append("FROM   INV_AR_MN MN," ).append("\n"); 
		query.append("       INV_AR_CHG CHG" ).append("\n"); 
		query.append("WHERE  MN.AR_IF_NO = CHG.AR_IF_NO" ).append("\n"); 
		query.append("AND    MN.BL_SRC_NO = @[bkg_no]" ).append("\n"); 
		query.append("AND    NVL(MN.INV_DELT_DIV_CD, 'N') <> 'Y'" ).append("\n"); 
		query.append("AND    MN.REV_TP_CD <> 'M'" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("WHERE CCT <> 0 " ).append("\n"); 
		query.append("GROUP BY CURR" ).append("\n"); 

	}
}