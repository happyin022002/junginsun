/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : PanamaManifestListDownloadDBDAOsearchVslInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.02.15
*@LastModifier : 
*@LastVersion : 1.0
* 2016.02.15 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.panama.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PanamaManifestListDownloadDBDAOsearchVslInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchVslInfo
	  * </pre>
	  */
	public PanamaManifestListDownloadDBDAOsearchVslInfoRSQL(){
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
		params.put("skd_voy_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.panama.integration").append("\n"); 
		query.append("FileName : PanamaManifestListDownloadDBDAOsearchVslInfoRSQL").append("\n"); 
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
		query.append("SELECT" ).append("\n"); 
		query.append("	A.SLAN_CD SLAN_CD, " ).append("\n"); 
		query.append("	TO_CHAR(A.VPS_ETA_DT, 'YYYY-MM-DD hh24:mi:ss') VPS_ETA_DT," ).append("\n"); 
		query.append("	SUBSTR(MAX(LPAD(B.CLPT_SEQ, 2, '0')||B.VPS_PORT_CD), 3) POD_CD," ).append("\n"); 
		query.append("	SUBSTR(MIN(LPAD(C.CLPT_SEQ, 2, '0')||C.VPS_PORT_CD), 3) POL_CD," ).append("\n"); 
		query.append("	D.SHP_ID_NO SHP_ID_NO, " ).append("\n"); 
		query.append("	D.VST_NO VST_NO, " ).append("\n"); 
		query.append("	D.MVMT_SEQ MVMT_SEQ, " ).append("\n"); 
		query.append("	D.PNM_VSL_OPR_CD PNM_VSL_OPR_CD, " ).append("\n"); 
		query.append("	D.PNM_ORG_CD PNM_ORG_CD, " ).append("\n"); 
		query.append("	D.PNM_DEST_CD PNM_DEST_CD," ).append("\n"); 
		query.append("	TO_CHAR(D.EDI_SND_DT, 'YYYY-MM-DD hh24:mi') EDI_SND_DT," ).append("\n"); 
		query.append("	D.EDI_SND_SEQ," ).append("\n"); 
		query.append("	D.EDI_SND_USR_ID" ).append("\n"); 
		query.append("FROM " ).append("\n"); 
		query.append("	VSK_VSL_PORT_SKD A, " ).append("\n"); 
		query.append("	VSK_VSL_PORT_SKD B, " ).append("\n"); 
		query.append("	VSK_VSL_PORT_SKD C, " ).append("\n"); 
		query.append("	BKG_CSTMS_PNM_VVD D" ).append("\n"); 
		query.append("WHERE A.VSL_CD          =  @[vsl_cd]" ).append("\n"); 
		query.append("AND A.SKD_VOY_NO        =  @[skd_voy_no]" ).append("\n"); 
		query.append("AND A.SKD_DIR_CD        =  @[skd_dir_cd]" ).append("\n"); 
		query.append("AND A.VPS_PORT_CD       IN ('PAPAC','PABLB')" ).append("\n"); 
		query.append("AND NVL(A.SKD_CNG_STS_CD, ' ') <> 'S'" ).append("\n"); 
		query.append("AND B.VSL_CD            =  A.VSL_CD" ).append("\n"); 
		query.append("AND B.SKD_VOY_NO        =  A.SKD_VOY_NO" ).append("\n"); 
		query.append("AND B.SKD_DIR_CD        =  A.SKD_DIR_CD" ).append("\n"); 
		query.append("AND B.CLPT_SEQ          <  A.CLPT_SEQ" ).append("\n"); 
		query.append("AND NVL(B.SKD_CNG_STS_CD, ' ') <> 'S'" ).append("\n"); 
		query.append("AND C.VSL_CD            =  A.VSL_CD" ).append("\n"); 
		query.append("AND C.SKD_VOY_NO        =  A.SKD_VOY_NO" ).append("\n"); 
		query.append("AND C.SKD_DIR_CD        =  A.SKD_DIR_CD" ).append("\n"); 
		query.append("AND C.CLPT_SEQ          >  A.CLPT_SEQ" ).append("\n"); 
		query.append("AND D.VSL_CD(+)         =  A.VSL_CD" ).append("\n"); 
		query.append("AND D.SKD_VOY_NO(+)        =  A.SKD_VOY_NO" ).append("\n"); 
		query.append("AND D.SKD_DIR_CD(+)        =  A.SKD_DIR_CD" ).append("\n"); 
		query.append("GROUP BY A.SLAN_CD, A.VPS_ETA_DT, D.SHP_ID_NO, D.VST_NO, D.MVMT_SEQ, D.PNM_VSL_OPR_CD, D.PNM_ORG_CD, D.PNM_DEST_CD,	D.EDI_SND_DT, D.EDI_SND_SEQ, D.EDI_SND_USR_ID" ).append("\n"); 

	}
}