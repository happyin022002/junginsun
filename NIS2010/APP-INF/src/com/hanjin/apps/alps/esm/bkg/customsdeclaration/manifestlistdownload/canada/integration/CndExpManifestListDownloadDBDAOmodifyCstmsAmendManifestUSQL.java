/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : CndExpManifestListDownloadDBDAOmodifyCstmsAmendManifestUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.11.24
*@LastModifier : 
*@LastVersion : 1.0
* 2017.11.24 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.canada.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CndExpManifestListDownloadDBDAOmodifyCstmsAmendManifestUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  *  
	  * </pre>
	  */
	public CndExpManifestListDownloadDBDAOmodifyCstmsAmendManifestUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ibd_loc_gds_desc",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bl_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cstms_port_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("hub_loc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_pod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("t_vvd_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.canada.integration").append("\n"); 
		query.append("FileName : CndExpManifestListDownloadDBDAOmodifyCstmsAmendManifestUSQL").append("\n"); 
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
		query.append("UPDATE BKG_CSTMS_AMER_BL" ).append("\n"); 
		query.append("   SET" ).append("\n"); 
		query.append("#if (${ai_div} == 'DEL')" ).append("\n"); 
		query.append("       VSL_CD = SUBSTR(@[t_vvd_cd], 1, 4)," ).append("\n"); 
		query.append("       SKD_VOY_NO = SUBSTR(@[t_vvd_cd], 5, 4)," ).append("\n"); 
		query.append("       SKD_DIR_CD = SUBSTR(@[t_vvd_cd], 9, 1)," ).append("\n"); 
		query.append("       CSTMS_POD_CD = @[bkg_pod_cd]," ).append("\n"); 
		query.append("       CSTMS_PORT_CD = @[cstms_port_cd]," ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("       HUB_LOC_CD = @[hub_loc_cd]," ).append("\n"); 
		query.append("       IBD_LOC_GDS_DESC = @[ibd_loc_gds_desc]" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(" WHERE CNT_CD = @[cnt_cd]" ).append("\n"); 
		query.append("   AND BL_NO = @[bl_no]" ).append("\n"); 

	}
}