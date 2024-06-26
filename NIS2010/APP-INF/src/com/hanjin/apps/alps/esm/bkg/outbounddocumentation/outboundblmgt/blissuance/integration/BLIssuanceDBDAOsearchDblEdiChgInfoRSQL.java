/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : BLIssuanceDBDAOsearchDblEdiChgInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.19
*@LastModifier : 
*@LastVersion : 1.0
* 2010.02.19 
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

public class BLIssuanceDBDAOsearchDblEdiChgInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * select
	  * </pre>
	  */
	public BLIssuanceDBDAOsearchDblEdiChgInfoRSQL(){
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
		query.append("FileName : BLIssuanceDBDAOsearchDblEdiChgInfoRSQL").append("\n"); 
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
		query.append("SELECT '{CHARGE_INFO' ||CHR(10) ||" ).append("\n"); 
		query.append("'CHG_APPL_DT:' ||NVL(TO_CHAR(RT_APLY_DT, 'YYYYMMDD'), ' ') ||CHR(10) ||" ).append("\n"); 
		query.append("'}CHARGE_INFO' ||CHR(10)" ).append("\n"); 
		query.append("FROM   BKG_RATE" ).append("\n"); 
		query.append("WHERE  BKG_NO = @[bkg_no]" ).append("\n"); 

	}
}