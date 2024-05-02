/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : PSAManifestDBDAOsearchPSAHeadFlatFileRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.11
*@LastModifier : 박상훈
*@LastVersion : 1.0
* 2009.09.11 박상훈
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.terminaldocumentation.psamanifest.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author SANGHUN PARK
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PSAManifestDBDAOsearchPSAHeadFlatFileRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * PSA Data로 Flat File Header를 조회해서 만든다.
	  * </pre>
	  */
	public PSAManifestDBDAOsearchPSAHeadFlatFileRSQL(){
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
		query.append("Path : com.hanjin.apps.alps.esm.bkg.terminaldocumentation.psamanifest.integration ").append("\n"); 
		query.append("FileName : PSAManifestDBDAOsearchPSAHeadFlatFileRSQL").append("\n"); 
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
		query.append("SELECT UPPER(PV.PSA_VSL_NM) PSA_VSL_NM" ).append("\n"); 
		query.append(", PV.SKD_VOY_NO SKD_VOY_NO" ).append("\n"); 
		query.append(", PV.SKD_DIR_CD SKD_DIR_CD" ).append("\n"); 
		query.append(", PV.PSA_VOY_DIR_CD PSA_VOY_DIR_CD" ).append("\n"); 
		query.append(", NVL(VSL.VSL_ENG_NM,'') VSL_ENG_NM" ).append("\n"); 
		query.append(", VPS.SKD_VOY_NO SKD_VOY_NO" ).append("\n"); 
		query.append(", VPS.SKD_DIR_CD SKD_DIR_CD" ).append("\n"); 
		query.append(", @[vsl_cd] VSL_CD" ).append("\n"); 
		query.append("FROM   BKG_CSTMS_PSA_VVD PV, VSK_VSL_PORT_SKD VPS, MDM_VSL_CNTR VSL" ).append("\n"); 
		query.append("WHERE  PV.VSL_CD        = @[vsl_cd]" ).append("\n"); 
		query.append("AND    PV.SKD_VOY_NO    = @[skd_voy_no]" ).append("\n"); 
		query.append("AND    PV.SKD_DIR_CD    = @[skd_dir_cd]" ).append("\n"); 
		query.append("AND    PV.VSL_CD        = VPS.VSL_CD" ).append("\n"); 
		query.append("AND    PV.SKD_VOY_NO    = VPS.SKD_VOY_NO" ).append("\n"); 
		query.append("AND    PV.SKD_DIR_CD    = VPS.SKD_DIR_CD" ).append("\n"); 
		query.append("AND    PV.VSL_CD        = VSL.VSL_CD" ).append("\n"); 
		query.append("AND    ROWNUM =1" ).append("\n"); 

	}
}