/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : DubaiManifestListDownloadDBDAOsearchDubaiVesselManifestListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.17
*@LastModifier : 김민정
*@LastVersion : 1.0
* 2010.03.17 김민정
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.dubai.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kim Minjeong
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class DubaiManifestListDownloadDBDAOsearchDubaiVesselManifestListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * DubaiVesselManifestListVO
	  * </pre>
	  */
	public DubaiManifestListDownloadDBDAOsearchDubaiVesselManifestListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vvd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bl_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.dubai.integration").append("\n"); 
		query.append("FileName : DubaiManifestListDownloadDBDAOsearchDubaiVesselManifestListRSQL").append("\n"); 
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
		query.append("SELECT VSL_CD" ).append("\n"); 
		query.append("      ,SKD_VOY_NO" ).append("\n"); 
		query.append("      ,SKD_DIR_CD" ).append("\n"); 
		query.append("      ,POD_CD" ).append("\n"); 
		query.append("      ,CLPT_SEQ" ).append("\n"); 
		query.append("  FROM BKG_CSTMS_DU_VVD V" ).append("\n"); 
		query.append(" WHERE 1=1" ).append("\n"); 
		query.append("#if (${vvd} != '') " ).append("\n"); 
		query.append("   AND V.VSL_CD = SUBSTR(@[vvd],1,4)" ).append("\n"); 
		query.append("   AND V.SKD_VOY_NO = SUBSTR(@[vvd],5,4)" ).append("\n"); 
		query.append("   AND V.SKD_DIR_CD = SUBSTR(@[vvd],9,1)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${pod_cd} != '') " ).append("\n"); 
		query.append("   AND V.POD_CD = @[pod_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${bl_no} != '')" ).append("\n"); 
		query.append("   AND VSL_CD || SKD_VOY_NO || SKD_DIR_CD || POD_CD" ).append("\n"); 
		query.append("       IN (" ).append("\n"); 
		query.append("          SELECT V.VSL_CD || V.SKD_VOY_NO || V.SKD_DIR_CD || V.POD_CD" ).append("\n"); 
		query.append("            FROM BKG_BOOKING B" ).append("\n"); 
		query.append("                ,BKG_VVD V" ).append("\n"); 
		query.append("           WHERE B.BKG_NO = V.BKG_NO" ).append("\n"); 
		query.append("             AND B.BL_NO = @[bl_no]" ).append("\n"); 
		query.append("          UNION" ).append("\n"); 
		query.append("          SELECT V.VSL_CD || V.SKD_VOY_NO || V.SKD_DIR_CD || V.POD_CD" ).append("\n"); 
		query.append("            FROM BKG_BOOKING B" ).append("\n"); 
		query.append("                ,BKG_VVD V" ).append("\n"); 
		query.append("                ,BKG_HBL H" ).append("\n"); 
		query.append("           WHERE B.BKG_NO = V.BKG_NO" ).append("\n"); 
		query.append("             AND B.BKG_NO = H.BKG_NO" ).append("\n"); 
		query.append("             AND H.CNTR_MF_NO = @[bl_no]" ).append("\n"); 
		query.append("          )" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("GROUP BY VSL_CD" ).append("\n"); 
		query.append("      ,SKD_VOY_NO" ).append("\n"); 
		query.append("      ,SKD_DIR_CD" ).append("\n"); 
		query.append("      ,POD_CD" ).append("\n"); 
		query.append("      ,CLPT_SEQ" ).append("\n"); 

	}
}