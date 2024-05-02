/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : BLDocumentationBLDBDAOSearchCmdtDescKHPNHRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.06.16
*@LastModifier : 
*@LastVersion : 1.0
* 2014.06.16 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BLDocumentationBLDBDAOSearchCmdtDescKHPNHRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchCmdtDescKHPNH
	  * </pre>
	  */
	public BLDocumentationBLDBDAOSearchCmdtDescKHPNHRSQL(){
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
		query.append("Path : com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.integration").append("\n"); 
		query.append("FileName : BLDocumentationBLDBDAOSearchCmdtDescKHPNHRSQL").append("\n"); 
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
		query.append("#if (${ca_flg} == 'Y') " ).append("\n"); 
		query.append("SELECT BKG_NO," ).append("\n"); 
		query.append("	   MK_SEQ," ).append("\n"); 
		query.append("	   MK_DESC," ).append("\n"); 
		query.append("	   CMDT_DESC," ).append("\n"); 
		query.append("       NVL(AUTO_CLUZ_DP_CD,'N') AUTO_CLUZ_DP_CD" ).append("\n"); 
		query.append("  FROM BKG_BL_MK_DESC_HIS" ).append("\n"); 
		query.append(" WHERE BKG_NO= @[bkg_no]" ).append("\n"); 
		query.append("   AND MK_SEQ=1" ).append("\n"); 
		query.append("   AND CORR_NO='TMP0000001'" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("SELECT BKG_NO," ).append("\n"); 
		query.append("	   MK_SEQ," ).append("\n"); 
		query.append("	   MK_DESC," ).append("\n"); 
		query.append("	   CMDT_DESC," ).append("\n"); 
		query.append("       NVL(AUTO_CLUZ_DP_CD,'N') AUTO_CLUZ_DP_CD" ).append("\n"); 
		query.append("  FROM BKG_BL_MK_DESC" ).append("\n"); 
		query.append(" WHERE BKG_NO= @[bkg_no]" ).append("\n"); 
		query.append("   AND MK_SEQ=1" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}