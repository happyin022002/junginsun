/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : BLIssuanceDBDAOSearchEBLMaxBkgSeqRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.04.25
*@LastModifier : 김태경
*@LastVersion : 1.0
* 2011.04.25 김태경
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

public class BLIssuanceDBDAOSearchEBLMaxBkgSeqRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 
	  * </pre>
	  */
	public BLIssuanceDBDAOSearchEBLMaxBkgSeqRSQL(){
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
		query.append("FileName : BLIssuanceDBDAOSearchEBLMaxBkgSeqRSQL").append("\n"); 
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
		query.append("SELECT NVL(MAX(GREATEST(NVL(GEN.BKG_EBL_SEQ,1),AVC.BKG_EBL_SEQ,NVL(DE.BKG_EBL_SEQ,1))) + 1,1) MAX_BKG_EBL_SEQ" ).append("\n"); 
		query.append("  FROM BKG_EBL_AVC AVC, BKG_EBL_GEN_NTC GEN, BKG_EBL_DE_NTC DE" ).append("\n"); 
		query.append(" WHERE AVC.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("   AND AVC.BKG_NO = GEN.BKG_NO(+)" ).append("\n"); 
		query.append("   AND AVC.BKG_NO = DE.BKG_NO(+)" ).append("\n"); 

	}
}