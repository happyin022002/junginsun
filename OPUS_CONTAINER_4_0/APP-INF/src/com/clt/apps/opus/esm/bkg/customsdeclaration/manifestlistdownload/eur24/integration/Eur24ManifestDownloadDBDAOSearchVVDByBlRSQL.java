/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : Eur24ManifestDownloadDBDAOSearchVVDByBlRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.12.23
*@LastModifier : 김경섭
*@LastVersion : 1.0
* 2010.12.23 김경섭
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.eur24.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kim Gyoung Sub
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class Eur24ManifestDownloadDBDAOSearchVVDByBlRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * BL No.로 VVD정보(Vessel name, Lloyd No.포함)
	  * </pre>
	  */
	public Eur24ManifestDownloadDBDAOSearchVVDByBlRSQL(){
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
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.eur24.integration").append("\n"); 
		query.append("FileName : Eur24ManifestDownloadDBDAOSearchVVDByBlRSQL").append("\n"); 
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
		query.append("SELECT BKG.VSL_CD," ).append("\n"); 
		query.append("BKG.SKD_VOY_NO," ).append("\n"); 
		query.append("BKG.SKD_DIR_CD," ).append("\n"); 
		query.append("BKG.VSL_CD||BKG.SKD_VOY_NO||BKG.SKD_DIR_CD VVD," ).append("\n"); 
		query.append("VSL.VSL_ENG_NM," ).append("\n"); 
		query.append("VSL.LLOYD_NO," ).append("\n"); 
		query.append("BKG.CSTMS_YD_CD" ).append("\n"); 
		query.append("FROM BKG_CSTMS_EUR_BL BKG, MDM_VSL_CNTR VSL" ).append("\n"); 
		query.append("WHERE BL_NO = @[bl_no]" ).append("\n"); 
		query.append("AND BKG.VSL_CD = VSL.VSL_CD" ).append("\n"); 

	}
}