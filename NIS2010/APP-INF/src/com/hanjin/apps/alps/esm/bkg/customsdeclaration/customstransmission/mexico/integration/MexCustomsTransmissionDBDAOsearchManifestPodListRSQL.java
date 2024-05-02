/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : MexCustomsTransmissionDBDAOsearchManifestPodListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.09.03
*@LastModifier : 
*@LastVersion : 1.0
* 2015.09.03 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.mexico.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class MexCustomsTransmissionDBDAOsearchManifestPodListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchManifestPodList
	  * </pre>
	  */
	public MexCustomsTransmissionDBDAOsearchManifestPodListRSQL(){
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
		params.put("pol_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.mexico.integration").append("\n"); 
		query.append("FileName : MexCustomsTransmissionDBDAOsearchManifestPodListRSQL").append("\n"); 
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
		query.append("SELECT " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("DISTINCT BV.POD_CD val" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("FROM BKG_BOOKING BKG," ).append("\n"); 
		query.append("  BKG_VVD BV" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("  AND BV.VSL_CD = SUBSTR( @[vvd], 1, 4)" ).append("\n"); 
		query.append("  AND BV.SKD_VOY_NO = SUBSTR(@[vvd] , 5, 4)" ).append("\n"); 
		query.append("  AND BV.SKD_DIR_CD = SUBSTR(@[vvd] , 9, 1)" ).append("\n"); 
		query.append("  AND BKG.BKG_NO = BV.BKG_NO" ).append("\n"); 
		query.append("  AND BV.POL_CD = NVL( @[pol_cd] , BV.POL_CD) " ).append("\n"); 
		query.append("  AND (BKG.BKG_STS_CD ='F' OR BKG.BKG_STS_CD = 'W')" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if(${search_cargo} == 'F')" ).append("\n"); 
		query.append("  AND BKG.BKG_CGO_TP_CD <> 'P'" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("  AND BKG.BKG_CGO_TP_CD = 'P'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if(${search_flg} == 'O')" ).append("\n"); 
		query.append("	AND BV.POL_CD LIKE 'MX%'" ).append("\n"); 
		query.append("	AND BV.VSL_PRE_PST_CD = 'T'" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("	#if(${search_flg} == 'I')" ).append("\n"); 
		query.append("		AND BV.POD_CD LIKE 'MX%'" ).append("\n"); 
		query.append("		AND BV.VSL_PRE_PST_CD = 'T'" ).append("\n"); 
		query.append("	#else" ).append("\n"); 
		query.append("		AND (BV.POD_CD LIKE 'MX%' OR BV.POL_CD LIKE 'MX%')" ).append("\n"); 
		query.append("		AND BV.VSL_PRE_PST_CD <> 'T'" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}