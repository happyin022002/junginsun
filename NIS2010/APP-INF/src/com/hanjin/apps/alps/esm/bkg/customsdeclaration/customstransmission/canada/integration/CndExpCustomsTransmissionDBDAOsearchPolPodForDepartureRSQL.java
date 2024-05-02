/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : CndExpCustomsTransmissionDBDAOsearchPolPodForDepartureRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.12.13
*@LastModifier : 
*@LastVersion : 1.0
* 2017.12.13 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.canada.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CndExpCustomsTransmissionDBDAOsearchPolPodForDepartureRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchPolPod(단건)
	  * </pre>
	  */
	public CndExpCustomsTransmissionDBDAOsearchPolPodForDepartureRSQL(){
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
		query.append("Path : com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.canada.integration").append("\n"); 
		query.append("FileName : CndExpCustomsTransmissionDBDAOsearchPolPodForDepartureRSQL").append("\n"); 
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
		query.append("SELECT  " ).append("\n"); 
		query.append("       MIN(S3.YD_CD)                                     AS POD_CD     -- CANADA 포트      " ).append("\n"); 
		query.append("     , MIN(NVL(TO_CHAR(S3.VPS_ETD_DT,'YYYYMMDD'),' '))   AS VPS_ETD_DT -- CANADA 포트 출발일" ).append("\n"); 
		query.append("     , SUBSTR(MIN(LPAD(S4.CLPT_SEQ,2,'0')|| S4.YD_CD),3) AS POL_CD -- 해외 포트" ).append("\n"); 
		query.append("     , MAX(NVL(TO_CHAR(S4.VPS_ETA_DT,'YYYYMMDD'),' '))   AS VPS_ETA_DT     " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("       ,@[vsl_cd]     VSL_CD" ).append("\n"); 
		query.append("       ,@[skd_voy_no] SKD_VOY_NO" ).append("\n"); 
		query.append("       ,@[skd_dir_cd] SKD_DIR_CD" ).append("\n"); 
		query.append("  FROM   VSK_VSL_PORT_SKD S3" ).append("\n"); 
		query.append("        ,VSK_VSL_PORT_SKD S4" ).append("\n"); 
		query.append("  WHERE 1=1" ).append("\n"); 
		query.append("   AND  S3.VSL_CD         = @[vsl_cd]" ).append("\n"); 
		query.append("   AND  S3.SKD_VOY_NO     = @[skd_voy_no]" ).append("\n"); 
		query.append("   AND  S3.SKD_DIR_CD     = @[skd_dir_cd]" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("   AND  S4.VSL_CD         = @[vsl_cd]" ).append("\n"); 
		query.append("   AND  S4.SKD_VOY_NO     = @[skd_voy_no]" ).append("\n"); 
		query.append("   AND  S4.SKD_DIR_CD     = @[skd_dir_cd]  " ).append("\n"); 
		query.append("   AND  S3.CLPT_IND_SEQ   =  '1'" ).append("\n"); 
		query.append("  AND   S3.CLPT_SEQ = (" ).append("\n"); 
		query.append("                       SELECT MIN(S01.CLPT_SEQ)" ).append("\n"); 
		query.append("                         FROM VSK_VSL_PORT_SKD S01" ).append("\n"); 
		query.append("                        WHERE S01.VSL_CD                   = 'HNSG'" ).append("\n"); 
		query.append("                          AND S01.SKD_VOY_NO               = '0036'" ).append("\n"); 
		query.append("                          AND S01.SKD_DIR_CD               = 'W'" ).append("\n"); 
		query.append("                          AND NVL(S01.SKD_CNG_STS_CD, 'N') <> 'S'" ).append("\n"); 
		query.append("                          AND S01.VPS_PORT_CD              LIKE 'CA%'" ).append("\n"); 
		query.append("                      )" ).append("\n"); 
		query.append("   AND  S4.CLPT_IND_SEQ   = '1'" ).append("\n"); 
		query.append("   AND   S4.CLPT_SEQ > (" ).append("\n"); 
		query.append("                       SELECT MAX(S02.CLPT_SEQ)" ).append("\n"); 
		query.append("                         FROM VSK_VSL_PORT_SKD S02" ).append("\n"); 
		query.append("                        WHERE S02.VSL_CD                   = 'HNSG'" ).append("\n"); 
		query.append("                          AND S02.SKD_VOY_NO               = '0036'" ).append("\n"); 
		query.append("                          AND S02.SKD_DIR_CD               = 'W'" ).append("\n"); 
		query.append("                          AND NVL(S02.SKD_CNG_STS_CD, 'N') <> 'S'" ).append("\n"); 
		query.append("                          AND S02.VPS_PORT_CD              LIKE 'CA%'" ).append("\n"); 
		query.append("                      )" ).append("\n"); 
		query.append("   " ).append("\n"); 

	}
}