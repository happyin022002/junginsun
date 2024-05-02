/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : US204EDISetupDBDAOSearchUSEDISetupVndrRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.04.19
*@LastModifier : 
*@LastVersion : 1.0
* 2013.04.19 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.trs.codemanage.us204edisetup.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class US204EDISetupDBDAOSearchUSEDISetupVndrRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * US EDI Setup List Vendor 조회
	  * </pre>
	  */
	public US204EDISetupDBDAOSearchUSEDISetupVndrRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vndrSeq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.trs.codemanage.us204edisetup.integration").append("\n"); 
		query.append("FileName : US204EDISetupDBDAOSearchUSEDISetupVndrRSQL").append("\n"); 
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
		query.append("SELECT A.VNDR_SEQ AS VNDR_NO" ).append("\n"); 
		query.append("      ,A.VNDR_LGL_ENG_NM AS VNDR_NM_ENG" ).append("\n"); 
		query.append("  FROM MDM_VENDOR A" ).append("\n"); 
		query.append(" WHERE A.VNDR_CNT_CD = 'US'" ).append("\n"); 
		query.append("   AND A.WO_EDI_USE_FLG = 'Y'" ).append("\n"); 
		query.append("   AND A.USA_EDI_CD IS NOT NULL " ).append("\n"); 
		query.append("   AND A.DELT_FLG = 'N'" ).append("\n"); 
		query.append("   AND A.VNDR_SEQ = @[vndrSeq]" ).append("\n"); 

	}
}