/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : BLIssuanceDBDAOsearchDblEdiChgDtl3RSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.18
*@LastModifier : 
*@LastVersion : 1.0
* 2010.02.18 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BLIssuanceDBDAOsearchDblEdiChgDtl3RSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * select
	  * </pre>
	  */
	public BLIssuanceDBDAOsearchDblEdiChgDtl3RSQL(){
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
		query.append("FileName : BLIssuanceDBDAOsearchDblEdiChgDtl3RSQL").append("\n"); 
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
		query.append("SELECT '{CHARGE_TTL' || CHR(10)" ).append("\n"); 
		query.append("|| 'PPD_TOTAL:' || SUM(DECODE(FRT_TERM_CD, 'P', CHG_AMT, 0)) || CHR(10)" ).append("\n"); 
		query.append("|| 'CCT_TOTAL:' || SUM(DECODE(FRT_TERM_CD, 'C', CHG_AMT, 0)) || CHR(10)" ).append("\n"); 
		query.append("|| 'TOTAL_CUR:' || CURR_CD || CHR(10)" ).append("\n"); 
		query.append("|| 'LCL_TOT_AMT:' || CHR(10)" ).append("\n"); 
		query.append("|| 'CGO_RCV_DT:'  || CHR(10)" ).append("\n"); 
		query.append("|| 'ACT_CUST:' || CHR(10)" ).append("\n"); 
		query.append("|| '}CHARGE_TTL' || CHR(10)" ).append("\n"); 
		query.append("FROM   BKG_CHG_RT" ).append("\n"); 
		query.append("WHERE  BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("AND FRT_INCL_XCLD_DIV_CD = 'N'" ).append("\n"); 
		query.append("GROUP BY FRT_TERM_CD, CURR_CD" ).append("\n"); 

	}
}