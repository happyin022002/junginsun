/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : BlRatingDBDAORemoveChgTaxRateALLDSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.03.11
*@LastModifier : 
*@LastVersion : 1.0
* 2016.03.11 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.outbounddocumentation.blrating.blrating.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BlRatingDBDAORemoveChgTaxRateALLDSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * BlRatingDB  DAO  RemoveChgRateALL  DSQL.Query
	  * </pre>
	  */
	public BlRatingDBDAORemoveChgTaxRateALLDSQL(){
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
		query.append("Path : com.clt.apps.opus.esm.bkg.outbounddocumentation.blrating.blrating.integration ").append("\n"); 
		query.append("FileName : BlRatingDBDAORemoveChgTaxRateALLDSQL").append("\n"); 
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
		query.append("#if (${caflag} == 'Y') " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("		DELETE BKG_CHG_TAX_RT_HIS" ).append("\n"); 
		query.append("		WHERE  BKG_NO            = @[bkg_no]" ).append("\n"); 
		query.append("		AND    CORR_NO = 'TMP0000001'" ).append("\n"); 
		query.append("	" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#else " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("		DELETE BKG_CHG_TAX_RT" ).append("\n"); 
		query.append("		WHERE  BKG_NO            = @[bkg_no]" ).append("\n"); 
		query.append("	" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}