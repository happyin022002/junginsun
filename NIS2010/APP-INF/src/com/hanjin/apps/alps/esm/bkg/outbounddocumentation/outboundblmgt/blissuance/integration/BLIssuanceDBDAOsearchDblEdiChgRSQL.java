/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : BLIssuanceDBDAOsearchDblEdiChgRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.22
*@LastModifier : 
*@LastVersion : 1.0
* 2010.02.22 
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

public class BLIssuanceDBDAOsearchDblEdiChgRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * select
	  * </pre>
	  */
	public BLIssuanceDBDAOsearchDblEdiChgRSQL(){
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
		query.append("FileName : BLIssuanceDBDAOsearchDblEdiChgRSQL").append("\n"); 
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
		query.append("SELECT '{CHARGE' || CHR(10)" ).append("\n"); 
		query.append("|| 'FCTYPE:' || CHG_CD || CHR(10)" ).append("\n"); 
		query.append("|| 'RATE:' || CHG_UT_AMT || CHR(10)" ).append("\n"); 
		query.append("|| 'RATED_AS:' || RAT_AS_QTY || CHR(10)" ).append("\n"); 
		query.append("|| 'REVENUETON:' || RAT_AS_QTY || CHR(10)" ).append("\n"); 
		query.append("|| 'DIF_AMT:' || CHR(10)" ).append("\n"); 
		query.append("|| 'PPD:' || DECODE(FRT_TERM_CD, 'P', CHG_AMT, 0.0) || CHR(10)" ).append("\n"); 
		query.append("|| 'CCT:' || DECODE(FRT_TERM_CD, 'C', CHG_AMT, 0.0) || CHR(10)" ).append("\n"); 
		query.append("|| 'CURRENCYCODE:' || CURR_CD || CHR(10)" ).append("\n"); 
		query.append("|| 'TARIFF:' || TRF_ITM_NO || CHR(10)" ).append("\n"); 
		query.append("|| 'PERTYPE:' || RAT_UT_CD || CHR(10)" ).append("\n"); 
		query.append("|| 'EXRATE:' || CHR(10)" ).append("\n"); 
		query.append("|| 'FRT_IND:' || FRT_TERM_CD || CHR(10)" ).append("\n"); 
		query.append("|| '}CHARGE' || CHR(10)" ).append("\n"); 
		query.append("FROM   BKG_CHG_RT" ).append("\n"); 
		query.append("WHERE  BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("AND    FRT_INCL_XCLD_DIV_CD= 'N'" ).append("\n"); 
		query.append("ORDER BY RT_SEQ" ).append("\n"); 

	}
}