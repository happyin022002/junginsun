/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : SpecialManifestDBDAOSearchEurDgEmailSendRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.07.12
*@LastModifier : 이종길
*@LastVersion : 1.0
* 2016.07.12 이종길
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.terminaldocumentation.specialmanifest.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Jong-Kil LEE
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SpecialManifestDBDAOSearchEurDgEmailSendRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Eur Dg Email 전송 시 필요한 데이터를 추출하기 위해서 사용한다.
	  * </pre>
	  */
	public SpecialManifestDBDAOSearchEurDgEmailSendRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("vvd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pol_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.terminaldocumentation.specialmanifest.integration").append("\n"); 
		query.append("FileName : SpecialManifestDBDAOSearchEurDgEmailSendRSQL").append("\n"); 
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
		query.append(" (SELECT VSL_ENG_NM FROM MDM_VSL_CNTR WHERE 1=1 AND VSL_CD LIKE A.VSL_CD || '%' AND DELT_FLG = 'N') AS VSL_NM" ).append("\n"); 
		query.append(",(SELECT OB_CSSM_VOY_NO  FROM VSK_VSL_PORT_SKD WHERE VSL_CD =A.VSL_CD AND SKD_VOY_NO =A.SKD_VOY_NO AND SKD_DIR_CD=A.SKD_DIR_CD AND VPS_PORT_CD = A.POL_CD) OB_CSSM_VOY_NO" ).append("\n"); 
		query.append(",(SELECT IB_CSSM_VOY_NO  FROM VSK_VSL_PORT_SKD WHERE VSL_CD =A.VSL_CD AND SKD_VOY_NO =A.SKD_VOY_NO AND SKD_DIR_CD=A.SKD_DIR_CD AND VPS_PORT_CD = A.POD_CD) IB_CSSM_VOY_NO" ).append("\n"); 
		query.append("FROM (SELECT VSL_CD, SKD_VOY_NO, SKD_DIR_CD, POL_CD, POD_CD" ).append("\n"); 
		query.append("      FROM BKG_CSTMS_EUR_DG" ).append("\n"); 
		query.append("      WHERE 1=1    " ).append("\n"); 
		query.append("      AND VSL_CD = SUBSTR(@[vvd_cd], 1, 4)" ).append("\n"); 
		query.append("      AND SKD_VOY_NO = SUBSTR(@[vvd_cd], 5, 4)" ).append("\n"); 
		query.append("      AND SKD_DIR_CD = SUBSTR(@[vvd_cd], 9, 4)" ).append("\n"); 
		query.append("	  #if (${list_type} == 'T')" ).append("\n"); 
		query.append("	     #if (${pol_cd} != '') " ).append("\n"); 
		query.append("         AND PORT_CD = @[pol_cd]" ).append("\n"); 
		query.append("         #end " ).append("\n"); 
		query.append("         #if (${pod_cd} != '') " ).append("\n"); 
		query.append("         AND POD_CD = @[pod_cd]" ).append("\n"); 
		query.append("         #end  " ).append("\n"); 
		query.append("      #elseif (${list_type} == 'B')" ).append("\n"); 
		query.append("	     #if (${pol_cd} != '') " ).append("\n"); 
		query.append("         AND PORT_CD = @[pol_cd]" ).append("\n"); 
		query.append("         #end " ).append("\n"); 
		query.append("         #if (${pod_cd} != '') " ).append("\n"); 
		query.append("         AND POD_CD = @[pod_cd]" ).append("\n"); 
		query.append("         #end   " ).append("\n"); 
		query.append("      #elseif (${list_type} == 'BE')" ).append("\n"); 
		query.append("	     #if (${pol_cd} != '') " ).append("\n"); 
		query.append("         AND PORT_CD = @[pol_cd]" ).append("\n"); 
		query.append("         #end " ).append("\n"); 
		query.append("         #if (${pod_cd} != '') " ).append("\n"); 
		query.append("         AND POD_CD = @[pod_cd]" ).append("\n"); 
		query.append("         #end   " ).append("\n"); 
		query.append("      #elseif (${list_type} == 'SE')" ).append("\n"); 
		query.append("	     #if (${pol_cd} != '') " ).append("\n"); 
		query.append("         AND PORT_CD = @[pol_cd]" ).append("\n"); 
		query.append("         #end " ).append("\n"); 
		query.append("         #if (${pod_cd} != '') " ).append("\n"); 
		query.append("         AND POD_CD = @[pod_cd]" ).append("\n"); 
		query.append("         #end   " ).append("\n"); 
		query.append("	   #else" ).append("\n"); 
		query.append("	     #if (${pol_cd} != '') " ).append("\n"); 
		query.append("         AND POL_CD = @[pol_cd]" ).append("\n"); 
		query.append("         #end " ).append("\n"); 
		query.append("         #if (${pod_cd} != '') " ).append("\n"); 
		query.append("         AND POD_CD = @[pod_cd]" ).append("\n"); 
		query.append("         #end  " ).append("\n"); 
		query.append("	  #end  " ).append("\n"); 
		query.append("      ) A" ).append("\n"); 

	}
}