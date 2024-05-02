/*=========================================================
*Copyright(c) 2018 SM Line
*@FileName : ManilaManifestListDownloadDBDAOsearchCtnRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2018.05.24
*@LastModifier : 
*@LastVersion : 1.0
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

public class ManilaManifestListDownloadDBDAOsearchCtnRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Philippines Customs Manifest 화면의 CTN 탭 정보 조회
	  * </pre>
	  */
	public ManilaManifestListDownloadDBDAOsearchCtnRSQL(){
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
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("pol_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.philippine.integration").append("\n"); 
		query.append("FileName : ManilaManifestListDownloadDBDAOsearchCtnRSQL").append("\n"); 
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
		query.append("SELECT  REG_NO," ).append("\n"); 
		query.append("        BL_NO," ).append("\n"); 
		query.append("        CNTR_NO," ).append("\n"); 
		query.append("        CNTR_TPSZ," ).append("\n"); 
		query.append("		CGO_TP," ).append("\n"); 
		query.append("        CNTR_SEAL_NO," ).append("\n"); 
		query.append("		CNTR_SEAL_NO2," ).append("\n"); 
		query.append("		CNTR_SEAL_NO3," ).append("\n"); 
		query.append("		SEAL_PTY_CD," ).append("\n"); 
		query.append("        ROWNUM AS SEQ" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("        SELECT @[reg_no]||'-'||SUBSTR(TO_CHAR(SYSDATE, 'YYYYMMDD'), 3, 2) REG_NO," ).append("\n"); 
		query.append("               BKG.BL_NO BL_NO," ).append("\n"); 
		query.append("               NVL(BC.CNTR_NO,' ') CNTR_NO," ).append("\n"); 
		query.append("               NVL(DECODE(SUBSTR(BC.CNTR_TPSZ_CD,2,1),'2',BC.CNTR_TPSZ_CD,SUBSTR(BC.CNTR_TPSZ_CD,1,1)||'4'),' ') CNTR_TPSZ," ).append("\n"); 
		query.append("			   NVL(DECODE(NVL(BKG.BKG_CGO_TP_CD,'F'),'F','FCL','B','Break Bulk',DECODE(NVL(BKG.RCV_TERM_CD,'Y'),'S','LCL','')),'') CGO_TP," ).append("\n"); 
		query.append("			   (SELECT NVL(MIN(CNTR_SEAL_NO),' ') " ).append("\n"); 
		query.append("			      FROM BKG_CNTR_SEAL_NO" ).append("\n"); 
		query.append("			     WHERE BKG_NO = BC.BKG_NO" ).append("\n"); 
		query.append("				   AND CNTR_NO = BC.CNTR_NO ) CNTR_SEAL_NO," ).append("\n"); 
		query.append("		 	   '' CNTR_SEAL_NO2," ).append("\n"); 
		query.append("			   '' CNTR_SEAL_NO3," ).append("\n"); 
		query.append("			   '' SEAL_PTY_CD" ).append("\n"); 
		query.append("        FROM BKG_BOOKING BKG, BKG_CONTAINER BC, BKG_VVD BV" ).append("\n"); 
		query.append("        WHERE BKG.BKG_NO       = BC.BKG_NO " ).append("\n"); 
		query.append("          AND BKG.BKG_NO       = BV.BKG_NO " ).append("\n"); 
		query.append("          AND BV.VSL_CD        = @[vsl_cd]" ).append("\n"); 
		query.append("          AND BV.SKD_VOY_NO    = @[skd_voy_no]" ).append("\n"); 
		query.append("          AND BV.SKD_DIR_CD    = @[skd_dir_cd]" ).append("\n"); 
		query.append("		  #if (${pol_cd}!= '') " ).append("\n"); 
		query.append("		  AND BV.POL_CD          LIKE @[pol_cd] " ).append("\n"); 
		query.append("		  #end" ).append("\n"); 
		query.append("		  #if (${pod_cd}!= '') " ).append("\n"); 
		query.append("		  AND BV.POD_CD          LIKE @[pod_cd] " ).append("\n"); 
		query.append("		  #end" ).append("\n"); 
		query.append("          AND BKG.BKG_STS_CD   IN ('F','W')" ).append("\n"); 
		query.append("          AND BKG.BL_NO        > ' '" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}