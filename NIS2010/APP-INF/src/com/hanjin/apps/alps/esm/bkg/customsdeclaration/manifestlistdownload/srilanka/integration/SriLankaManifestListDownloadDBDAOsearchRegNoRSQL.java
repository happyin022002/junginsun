/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : SriLankaManifestListDownloadDBDAOsearchRegNoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.01.27
*@LastModifier : 
*@LastVersion : 1.0
* 2015.01.27 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.srilanka.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SriLankaManifestListDownloadDBDAOsearchRegNoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 스리랑카세관 Vessel Registration No 정보를 조회한다.
	  * </pre>
	  */
	public SriLankaManifestListDownloadDBDAOsearchRegNoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("io_bnd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("port_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("Path : com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.srilanka.integration").append("\n"); 
		query.append("FileName : SriLankaManifestListDownloadDBDAOsearchRegNoRSQL").append("\n"); 
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
		query.append("SELECT VSL_RGST_NO" ).append("\n"); 
		query.append("  FROM (" ).append("\n"); 
		query.append("  SELECT" ).append("\n"); 
		query.append("(CASE WHEN (DECODE(SND_DT,NULL,'N','Y') = 'Y' OR DECODE(VSL_RGST_NO,NULL,'N','Y') = 'Y') THEN VSL_RGST_NO" ).append("\n"); 
		query.append("WHEN (DECODE(SND_DT,NULL,'N','Y') = 'N' OR DECODE(VSL_RGST_NO,NULL,'N','Y') = 'N')  THEN" ).append("\n"); 
		query.append("(SELECT 'V'||DECODE(SIGN(10 - YY), 1, TO_CHAR(YY), CHR(YY+55))||DECODE(MM,10,'A',11,'B',12,'C', TO_CHAR(MM))||DD||TO_CHAR(SYSDATE,'HH24MISS')" ).append("\n"); 
		query.append("FROM   (SELECT TO_NUMBER(SUBSTR(TO_CHAR(SYSDATE,'YYYYMMDD'),3,2))YY," ).append("\n"); 
		query.append("TO_NUMBER(SUBSTR(TO_CHAR(SYSDATE,'YYYYMMDD'),5,2))MM," ).append("\n"); 
		query.append("SUBSTR(TO_CHAR(SYSDATE,'YYYYMMDD'),7,2) DD" ).append("\n"); 
		query.append("FROM   DUAL)) END) VSL_RGST_NO, RANK() OVER(PARTITION BY VSL_CD, SKD_VOY_NO, SKD_DIR_CD, PORT_CD ORDER BY CRE_DT DESC) RN" ).append("\n"); 
		query.append("FROM   BKG_CSTMS_SRI_VVD" ).append("\n"); 
		query.append("WHERE  VSL_CD        = @[vsl_cd]" ).append("\n"); 
		query.append("	    AND    SKD_VOY_NO = @[skd_voy_no]" ).append("\n"); 
		query.append("	    AND    SKD_DIR_CD    = @[skd_dir_cd]" ).append("\n"); 
		query.append("	    AND    PORT_CD       = @[port_cd]" ).append("\n"); 
		query.append("		AND		IO_BND_CD = @[io_bnd_cd]" ).append("\n"); 
		query.append(") WHERE RN = 1" ).append("\n"); 

	}
}