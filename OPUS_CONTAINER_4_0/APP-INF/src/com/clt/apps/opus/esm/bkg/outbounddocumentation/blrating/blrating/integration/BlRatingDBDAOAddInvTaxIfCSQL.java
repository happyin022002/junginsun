/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : BlRatingDBDAOAddInvTaxIfCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.03.07
*@LastModifier : 
*@LastVersion : 1.0
* 2016.03.07 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.outbounddocumentation.blrating.blrating.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BlRatingDBDAOAddInvTaxIfCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * DESC Enter..
	  * </pre>
	  */
	public BlRatingDBDAOAddInvTaxIfCSQL(){
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
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("if_rmk",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.outbounddocumentation.blrating.blrating.integration").append("\n"); 
		query.append("FileName : BlRatingDBDAOAddInvTaxIfCSQL").append("\n"); 
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
		query.append("INSERT INTO BKG_INV_TAX_IF (" ).append("\n"); 
		query.append("	   BKG_NO," ).append("\n"); 
		query.append("	   BKG_SEQ," ).append("\n"); 
		query.append("	   IF_RMK," ).append("\n"); 
		query.append("	   BAT_CMPL_FLG," ).append("\n"); 
		query.append("	   CRE_USR_ID," ).append("\n"); 
		query.append("	   CRE_DT, " ).append("\n"); 
		query.append("	   UPD_USR_ID," ).append("\n"); 
		query.append("	   UPD_DT) " ).append("\n"); 
		query.append("	VALUES (" ).append("\n"); 
		query.append("	   @[bkg_no]," ).append("\n"); 
		query.append("	   (SELECT  NVL(MAX(BKG_SEQ),0)+1 AS SEQ FROM BKG_INV_TAX_IF WHERE BKG_NO = @[bkg_no]) , " ).append("\n"); 
		query.append("	   @[if_rmk]," ).append("\n"); 
		query.append("	   'N'," ).append("\n"); 
		query.append("	   @[cre_usr_id]," ).append("\n"); 
		query.append("	   sysdate," ).append("\n"); 
		query.append("	   @[cre_usr_id]," ).append("\n"); 
		query.append("	   sysdate" ).append("\n"); 
		query.append("	   )" ).append("\n"); 

	}
}