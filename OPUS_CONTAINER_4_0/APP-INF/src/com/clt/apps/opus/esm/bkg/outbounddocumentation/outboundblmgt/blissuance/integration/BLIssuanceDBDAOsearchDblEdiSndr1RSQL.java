/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : BLIssuanceDBDAOsearchDblEdiSndr1RSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.03.18
*@LastModifier : 
*@LastVersion : 1.0
* 2011.03.18 
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

public class BLIssuanceDBDAOsearchDblEdiSndr1RSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * select
	  * </pre>
	  */
	public BLIssuanceDBDAOsearchDblEdiSndr1RSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("edi_receive_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tmp_cnt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("group_edi_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.integration").append("\n"); 
		query.append("FileName : BLIssuanceDBDAOsearchDblEdiSndr1RSQL").append("\n"); 
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
		query.append("SELECT EC_EDISND_ID" ).append("\n"); 
		query.append("FROM   (SELECT ROWNUM RN, EC_EDISND_ID" ).append("\n"); 
		query.append("        FROM   (SELECT DISTINCT NVL (MCHN_TRD_PRNR_ID, 'OPUSBKG') EC_EDISND_ID" ).append("\n"); 
		query.append("                FROM   BKG_EDI_GRP" ).append("\n"); 
		query.append("                WHERE  CUST_TRD_PRNR_ID = @[edi_receive_id]" ).append("\n"); 
		query.append("                   AND ESVC_GRP_CD = @[group_edi_id]" ).append("\n"); 
		query.append("                   AND ESVC_GRP_DELT_FLG = 'N'))" ).append("\n"); 
		query.append("WHERE  RN = @[tmp_cnt]" ).append("\n"); 
		query.append("AND    ROWNUM = 1" ).append("\n"); 

	}
}