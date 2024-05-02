/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : CLLCDLManifestDBDAOsearchWOFlagRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.08.24
*@LastModifier : 김보배
*@LastVersion : 1.0
* 2012.08.24 김보배
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.terminaldocumentation.cllcdlmanifest.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author BOBAE KIM
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CLLCDLManifestDBDAOsearchWOFlagRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Work Order 생성여부 체크
	  * </pre>
	  */
	public CLLCDLManifestDBDAOsearchWOFlagRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("in_pod_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("in_pol_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.terminaldocumentation.cllcdlmanifest.integration").append("\n"); 
		query.append("FileName : CLLCDLManifestDBDAOsearchWOFlagRSQL").append("\n"); 
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
		query.append("SELECT DECODE(NVL(MAX(SO.BKG_NO), 'N'), 'N', 'N', 'Y') AS woFlg" ).append("\n"); 
		query.append("FROM TRS_TRSP_SVC_ORD SO" ).append("\n"); 
		query.append("   , TRS_TRSP_WRK_ORD WO" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("  AND SO.TRSP_WO_OFC_CTY_CD = WO.TRSP_WO_OFC_CTY_CD" ).append("\n"); 
		query.append("  AND SO.TRSP_WO_SEQ = WO.TRSP_WO_SEQ" ).append("\n"); 
		query.append("  AND SO.TRSP_SO_STS_CD = 'I'" ).append("\n"); 
		query.append("  AND NVL(SO.DELT_FLG,'N') = 'N'" ).append("\n"); 
		query.append("  AND SO.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("  AND ROWNUM = 1" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${in_list_type} == 'L') " ).append("\n"); 
		query.append("  AND SO.FM_NOD_CD LIKE @[in_pol_cd]||'%'" ).append("\n"); 
		query.append("#else " ).append("\n"); 
		query.append("  AND SO.TO_NOD_CD LIKE @[in_pod_cd]||'%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}