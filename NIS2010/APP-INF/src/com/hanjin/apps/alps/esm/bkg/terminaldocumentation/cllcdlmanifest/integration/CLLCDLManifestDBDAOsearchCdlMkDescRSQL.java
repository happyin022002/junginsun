/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : CLLCDLManifestDBDAOsearchCdlMkDescRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.01.26
*@LastModifier : 
*@LastVersion : 1.0
* 2010.01.26 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.terminaldocumentation.cllcdlmanifest.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CLLCDLManifestDBDAOsearchCdlMkDescRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchCdlMkDesc
	  * </pre>
	  */
	public CLLCDLManifestDBDAOsearchCdlMkDescRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("in_bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.terminaldocumentation.cllcdlmanifest.integration").append("\n"); 
		query.append("FileName : CLLCDLManifestDBDAOsearchCdlMkDescRSQL").append("\n"); 
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
		query.append("SELECT	REPLACE(DOC.PCK_CMDT_DESC,'*','-')||CHR(10)||" ).append("\n"); 
		query.append("REPLACE(DOC.CNTR_CMDT_DESC,'*','-')||CHR(10)||" ).append("\n"); 
		query.append("REPLACE(BMD.CMDT_DESC,'*','-') CMDT_DESC," ).append("\n"); 
		query.append("REPLACE(BMD.MK_DESC,'*','-') MK_DESC" ).append("\n"); 
		query.append("FROM BKG_BL_MK_DESC BMD, BKG_BL_DOC DOC" ).append("\n"); 
		query.append("WHERE	DOC.BKG_NO = @[in_bkg_no]" ).append("\n"); 
		query.append("AND     DOC.BKG_NO = BMD.BKG_NO" ).append("\n"); 

	}
}