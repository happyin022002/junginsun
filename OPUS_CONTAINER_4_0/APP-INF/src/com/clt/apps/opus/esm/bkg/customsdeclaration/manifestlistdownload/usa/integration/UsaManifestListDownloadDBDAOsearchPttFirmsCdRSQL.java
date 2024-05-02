/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : UsaManifestListDownloadDBDAOsearchPttFirmsCdRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.06.11
*@LastModifier : 김민정
*@LastVersion : 1.0
* 2015.06.11 김민정
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.usa.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Minjung Kim
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class UsaManifestListDownloadDBDAOsearchPttFirmsCdRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 
	  * </pre>
	  */
	public UsaManifestListDownloadDBDAOsearchPttFirmsCdRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bl_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.usa.integration").append("\n"); 
		query.append("FileName : UsaManifestListDownloadDBDAOsearchPttFirmsCdRSQL").append("\n"); 
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
		query.append("SELECT NVL(RFA_FIRMS_CD, NVL(TAA_FIRMS_CD, SC_FIRMS_CD)) AS PTT_FRM_CD" ).append("\n"); 
		query.append("  FROM (" ).append("\n"); 
		query.append("SELECT (SELECT AA.ATTR_CTNT3" ).append("\n"); 
		query.append("          FROM BKG_CSTMS_CD_CONV_CTNT AA" ).append("\n"); 
		query.append("         WHERE AA.CNT_CD = 'US'" ).append("\n"); 
		query.append("           AND AA.CSTMS_DIV_ID = 'RFA_FIRMS_CD_MAP_PTT'" ).append("\n"); 
		query.append("           AND AA.ATTR_CTNT1 = B.RFA_NO" ).append("\n"); 
		query.append("           AND (AA.ATTR_CTNT2 = 'ALL' OR AA.ATTR_CTNT2 = A.CSTMS_POD_CD)" ).append("\n"); 
		query.append("           AND ROWNUM = 1" ).append("\n"); 
		query.append("       ) AS RFA_FIRMS_CD" ).append("\n"); 
		query.append("      ,(SELECT AA.ATTR_CTNT3" ).append("\n"); 
		query.append("          FROM BKG_CSTMS_CD_CONV_CTNT AA" ).append("\n"); 
		query.append("         WHERE AA.CNT_CD = 'US'" ).append("\n"); 
		query.append("           AND AA.CSTMS_DIV_ID = 'TAA_FIRMS_CD_MAP_PTT'" ).append("\n"); 
		query.append("           AND AA.ATTR_CTNT1 = B.TAA_NO" ).append("\n"); 
		query.append("           AND (AA.ATTR_CTNT2 = 'ALL' OR AA.ATTR_CTNT2 = A.CSTMS_POD_CD)" ).append("\n"); 
		query.append("           AND ROWNUM = 1" ).append("\n"); 
		query.append("       ) AS TAA_FIRMS_CD" ).append("\n"); 
		query.append("      ,(SELECT AA.ATTR_CTNT3" ).append("\n"); 
		query.append("          FROM BKG_CSTMS_CD_CONV_CTNT AA" ).append("\n"); 
		query.append("         WHERE AA.CNT_CD = 'US'" ).append("\n"); 
		query.append("           AND AA.CSTMS_DIV_ID = 'SC_FIRMS_CD_MAP_PTT'" ).append("\n"); 
		query.append("           AND AA.ATTR_CTNT1 = B.SC_NO" ).append("\n"); 
		query.append("           AND (AA.ATTR_CTNT2 = 'ALL' OR AA.ATTR_CTNT2 = A.CSTMS_POD_CD)" ).append("\n"); 
		query.append("           AND ROWNUM = 1" ).append("\n"); 
		query.append("       ) AS SC_FIRMS_CD" ).append("\n"); 
		query.append("  FROM BKG_BOOKING B" ).append("\n"); 
		query.append("      ,BKG_CSTMS_ADV_BL A" ).append("\n"); 
		query.append(" WHERE B.BKG_NO = A.BKG_NO" ).append("\n"); 
		query.append("   AND A.CNT_CD = 'US'" ).append("\n"); 
		query.append("   AND A.BL_NO  = @[bl_no]" ).append("\n"); 
		query.append("      )" ).append("\n"); 

	}
}