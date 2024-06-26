/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : BLIssuanceDBDAOsearchDblEdiHpSwaRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.04.13
*@LastModifier : 
*@LastVersion : 1.0
* 2016.04.13 
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

public class BLIssuanceDBDAOsearchDblEdiHpSwaRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * select
	  * </pre>
	  */
	public BLIssuanceDBDAOsearchDblEdiHpSwaRSQL(){
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
		query.append("FileName : BLIssuanceDBDAOsearchDblEdiHpSwaRSQL").append("\n"); 
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
		query.append("SELECT '{HPSWA_INFO' || CHR (10) || " ).append("\n"); 
		query.append("       'SHIP_ID:' || NVL (DE_NO, '') || CHR (10) || " ).append("\n"); 
		query.append("       'PART_NO:' || NVL (PRT_NO, '') || CHR (10) || " ).append("\n"); 
		query.append("       'SHIP_REF_NO:' || NVL (SHP_REF_NO, '') || CHR (10) ||" ).append("\n"); 
		query.append("       '}HPSWA_INFO' || CHR (10)" ).append("\n"); 
		query.append("FROM   BKG_REF_DTL" ).append("\n"); 
		query.append("WHERE  BKG_NO = @[bkg_no]" ).append("\n"); 

	}
}