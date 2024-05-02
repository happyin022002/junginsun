/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : IndiaManifestListDownloadDBDAOsearchBondListByCdNmRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.03
*@LastModifier : 
*@LastVersion : 1.0
* 2010.03.03 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.india.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class IndiaManifestListDownloadDBDAOsearchBondListByCdNmRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Bond(warehouse)정보를 조회해 온다.
	  * </pre>
	  */
	public IndiaManifestListDownloadDBDAOsearchBondListByCdNmRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("loc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("wh_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cstms_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("wh_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.india.integration").append("\n"); 
		query.append("FileName : IndiaManifestListDownloadDBDAOsearchBondListByCdNmRSQL").append("\n"); 
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
		query.append("A.CNT_CD" ).append("\n"); 
		query.append(",A.LOC_CD" ).append("\n"); 
		query.append(",A.WH_CD" ).append("\n"); 
		query.append(",A.CSTMS_CD" ).append("\n"); 
		query.append(",A.WH_NM" ).append("\n"); 
		query.append(",A.WH_CD" ).append("\n"); 
		query.append(",A.WH_ADDR" ).append("\n"); 
		query.append(",A.CSTMS_CD" ).append("\n"); 
		query.append(",A.BD_AREA_CD" ).append("\n"); 
		query.append(",A.LOC_CD" ).append("\n"); 
		query.append(",(SELECT B.LOC_NM FROM MDM_LOCATION B WHERE B.LOC_CD = A.LOC_CD) LOC_NM" ).append("\n"); 
		query.append(",A.PHN_NO" ).append("\n"); 
		query.append(",A.PSON_NM" ).append("\n"); 
		query.append(",A.FAX_NO" ).append("\n"); 
		query.append(",A.DIFF_RMK" ).append("\n"); 
		query.append("FROM BKG_WAREHOUSE A" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${cnt_cd} != '')" ).append("\n"); 
		query.append("AND A.CNT_CD 	= @[cnt_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${loc_cd} != '')" ).append("\n"); 
		query.append("AND   A.LOC_CD 	= @[loc_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${wh_cd} != '')" ).append("\n"); 
		query.append("AND   A.WH_CD  	= @[wh_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${cstms_cd} != '')" ).append("\n"); 
		query.append("AND   A.CSTMS_CD 	 LIKE '%' || @[cstms_cd]  || '%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${wh_nm} != '')" ).append("\n"); 
		query.append("AND   A.WH_NM     LIKE '%' || @[wh_nm] || '%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("ORDER BY A.WH_CD" ).append("\n"); 

	}
}