/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ManilaManifestListDownloadDBDAOsearchVvdDtlRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.01
*@LastModifier : 
*@LastVersion : 1.0
* 2009.10.01 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.philippine.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ManilaManifestListDownloadDBDAOsearchVvdDtlRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ManilaSearchVvdDtlVO
	  * </pre>
	  */
	public ManilaManifestListDownloadDBDAOsearchVvdDtlRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("skd_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pol_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("skd_voy_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("reg_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.philippine.integration").append("\n"); 
		query.append("FileName : ManilaManifestListDownloadDBDAOsearchVvdDtlRSQL").append("\n"); 
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
		query.append("SELECT  REG_NUMBER," ).append("\n"); 
		query.append("ETADT," ).append("\n"); 
		query.append("VNAME," ).append("\n"); 
		query.append("POLCD," ).append("\n"); 
		query.append("DISCHARGE," ).append("\n"); 
		query.append("ROWNUM AS SEQ" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("SELECT 	DISTINCT" ).append("\n"); 
		query.append("SUBSTR(BKG.POL_CD,1,2) polcd," ).append("\n"); 
		query.append("TO_CHAR(VPS.VPS_ETA_DT,'YYYY-MM-DD') etadt," ).append("\n"); 
		query.append("'' discharge," ).append("\n"); 
		query.append("SUBSTR(VSL.VSL_ENG_NM,1,10)||BKG.SKD_VOY_NO||BKG.SKD_DIR_CD vname," ).append("\n"); 
		query.append("@[reg_no] reg_number" ).append("\n"); 
		query.append("FROM  VSK_VSL_PORT_SKD VPS," ).append("\n"); 
		query.append("MDM_VSL_CNTR VSL," ).append("\n"); 
		query.append("BKG_VVD BKG" ).append("\n"); 
		query.append("WHERE VSL.VSL_CD       = BKG.VSL_CD" ).append("\n"); 
		query.append("AND VPS.VSL_CD        = BKG.VSL_CD" ).append("\n"); 
		query.append("AND VPS.SKD_VOY_no    = BKG.SKD_VOY_no" ).append("\n"); 
		query.append("AND VPS.SKD_DIR_CD    = BKG.SKD_DIR_CD" ).append("\n"); 
		query.append("#if (${vsl_cd}!= '')" ).append("\n"); 
		query.append("AND BKG.VSL_CD        = @[vsl_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${skd_voy_no}!= '')" ).append("\n"); 
		query.append("AND BKG.SKD_VOY_no    = @[skd_voy_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${skd_dir_cd}!= '')" ).append("\n"); 
		query.append("AND BKG.SKD_DIR_CD    = @[skd_dir_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${pol_cd}!= '')" ).append("\n"); 
		query.append("AND BKG.POL_CD        LIKE @[pol_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${pod_cd}!= '')" ).append("\n"); 
		query.append("AND BKG.POD_CD        LIKE @[pod_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${pod_cd}!= '')" ).append("\n"); 
		query.append("AND VPS.VPS_PORT_CD    LIKE @[pod_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}