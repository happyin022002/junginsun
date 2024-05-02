/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : BLIssuanceDBDAODeleteBlPrnAuthUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.01.12
*@LastModifier : 
*@LastVersion : 1.0
* 2017.01.12 
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

public class BLIssuanceDBDAODeleteBlPrnAuthUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * BKG_INET_BL_PRN_AUTH delete flag 처리
	  * </pre>
	  */
	public BLIssuanceDBDAODeleteBlPrnAuthUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.integration").append("\n"); 
		query.append("FileName : BLIssuanceDBDAODeleteBlPrnAuthUSQL").append("\n"); 
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
		query.append("UPDATE BKG_INET_BL_PRN_AUTH" ).append("\n"); 
		query.append("    SET DELT_FLG = 'Y'" ).append("\n"); 
		query.append("        , DELT_USR_ID 	= @[usr_id]" ).append("\n"); 
		query.append("        , DELT_OFC_CD 	= @[ofc_cd]" ).append("\n"); 
		query.append("        , DELT_DT 		= sysdate" ).append("\n"); 
		query.append("        , UPD_USR_ID 	= @[usr_id]" ).append("\n"); 
		query.append("        , UPD_DT 		= sysdate" ).append("\n"); 
		query.append("WHERE BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("AND DELT_FLG = 'N'" ).append("\n"); 

	}
}