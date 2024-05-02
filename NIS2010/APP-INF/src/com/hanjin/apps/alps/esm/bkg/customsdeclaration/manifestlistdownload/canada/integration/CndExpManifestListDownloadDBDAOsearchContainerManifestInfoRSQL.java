/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : CndExpManifestListDownloadDBDAOsearchContainerManifestInfoRSQL.java
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

public class CndExpManifestListDownloadDBDAOsearchContainerManifestInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 
	  * </pre>
	  */
	public CndExpManifestListDownloadDBDAOsearchContainerManifestInfoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.canada.integration").append("\n"); 
		query.append("FileName : CndExpManifestListDownloadDBDAOsearchContainerManifestInfoRSQL").append("\n"); 
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
		query.append("SELECT   B.BL_NO" ).append("\n"); 
		query.append("        ,B.VSL_CD || B.SKD_VOY_NO || B.SKD_DIR_CD AS VVD" ).append("\n"); 
		query.append("        --,B.POD_CD" ).append("\n"); 
		query.append("        --,B.POL_CD" ).append("\n"); 
		query.append("		,B.CSTMS_POD_CD POD_CD" ).append("\n"); 
		query.append("		,B.CSTMS_POL_CD POL_CD" ).append("\n"); 
		query.append("        ,B.DEL_CD" ).append("\n"); 
		query.append("        ,B.USA_LST_LOC_CD" ).append("\n"); 
		query.append("        ,B.PCK_QTY" ).append("\n"); 
		query.append("        ,B.AMS_PCK_TP_CD" ).append("\n"); 
		query.append("        ,B.CGO_WGT" ).append("\n"); 
		query.append("        ,B.WGT_UT_CD" ).append("\n"); 
		query.append("        ,I.IBD_TRSP_NO" ).append("\n"); 
		query.append("        ,I.IBD_TRSP_TP_CD" ).append("\n"); 
		query.append("        ,DECODE(I.CSTMS_CLR_TP_CD, 'L', 'LOCAL', 'I', 'P/MIB') AS CSTMS_CLR_TP_CD" ).append("\n"); 
		query.append("        ,DECODE(B.MF_STS_CD, 'A', 'Active', 'D', 'Deleted') AS MF_STS" ).append("\n"); 
		query.append("        ,NVL(R.FRT_CLT_FLG,'N') AS F_FLG" ).append("\n"); 
		query.append("        ,NVL(R.OBL_RDEM_FLG,'N') AS O_FLG" ).append("\n"); 
		query.append("        ,NVL(R.CSTMS_CLR_CD,'N') AS C_FLG" ).append("\n"); 
		query.append("        ,B.CSTMS_MF_TP_CD" ).append("\n"); 
		query.append("        ,TO_CHAR(V.VPS_ETA_DT, 'YYYY-MM-DD') AS VPS_ETA_DT" ).append("\n"); 
		query.append("FROM     BKG_CSTMS_AMER_BL B" ).append("\n"); 
		query.append("        ,BKG_CSTMS_ADV_IBD I" ).append("\n"); 
		query.append("        ,BKG_CGO_RLSE R" ).append("\n"); 
		query.append("        ,VSK_VSL_PORT_SKD V" ).append("\n"); 
		query.append("WHERE    1=1 " ).append("\n"); 
		query.append("AND      B.CNT_CD = @[cnt_cd]" ).append("\n"); 
		query.append("AND      B.BL_NO = @[bl_no]" ).append("\n"); 
		query.append("AND      B.CNT_CD = I.CNT_CD(+)" ).append("\n"); 
		query.append("AND      B.BL_NO = I.BL_NO(+)" ).append("\n"); 
		query.append("AND      B.BL_NO = R.BL_NO(+)" ).append("\n"); 
		query.append("AND      B.VSL_CD = V.VSL_CD(+)" ).append("\n"); 
		query.append("AND      B.SKD_VOY_NO = V.SKD_VOY_NO(+)" ).append("\n"); 
		query.append("AND      B.SKD_DIR_CD = V.SKD_DIR_CD(+)" ).append("\n"); 
		query.append("AND      B.CSTMS_POD_CD = V.VPS_PORT_CD(+)" ).append("\n"); 
		query.append("AND      V.CLPT_IND_SEQ(+) = '1'" ).append("\n"); 

	}
}