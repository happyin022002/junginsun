/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : BLIssuanceDBDAOsearchDblEdiAmsInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.04.23
*@LastModifier : 
*@LastVersion : 1.0
* 2010.04.23 
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

public class BLIssuanceDBDAOsearchDblEdiAmsInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * select
	  * </pre>
	  */
	public BLIssuanceDBDAOsearchDblEdiAmsInfoRSQL(){
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
		query.append("FileName : BLIssuanceDBDAOsearchDblEdiAmsInfoRSQL").append("\n"); 
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
		query.append("SELECT '{AMS_INFO' || CHR (10) ||" ).append("\n"); 
		query.append("'HOUSE_BL_NO:' || A1.HBL_NO || CHR (10) ||" ).append("\n"); 
		query.append("'HOUSE_SR_NO:' || A2.SI_NO || CHR (10) ||" ).append("\n"); 
		query.append("'AMS_FILE_NO:' || A1.CNTR_MF_NO || CHR (10) ||" ).append("\n"); 
		query.append("'}AMS_INFO' || CHR (10)" ).append("\n"); 
		query.append("FROM   BKG_HBL A1, BKG_XTER_RQST_MST A2" ).append("\n"); 
		query.append("WHERE  A1.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("AND A1.BKG_NO = A2.BKG_NO (+)" ).append("\n"); 
		query.append("AND A1.HBL_NO = A2.BL_NO_CTNT (+)" ).append("\n"); 
		query.append("AND A2.XTER_BL_TP_CD (+) = 'H'" ).append("\n"); 

	}
}