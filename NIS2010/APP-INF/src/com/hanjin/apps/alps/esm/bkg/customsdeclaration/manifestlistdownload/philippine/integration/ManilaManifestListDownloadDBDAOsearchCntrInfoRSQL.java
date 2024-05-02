/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : ManilaManifestListDownloadDBDAOsearchCntrInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.01.19
*@LastModifier : 
*@LastVersion : 1.0
* 2017.01.19 
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

public class ManilaManifestListDownloadDBDAOsearchCntrInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Manila 세관에 신고할 대상 Container 정보를 조회한다.
	  * </pre>
	  */
	public ManilaManifestListDownloadDBDAOsearchCntrInfoRSQL(){
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
		params.put("pol_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("skd_voy_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.philippine.integration").append("\n"); 
		query.append("FileName : ManilaManifestListDownloadDBDAOsearchCntrInfoRSQL").append("\n"); 
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
		query.append("SELECT  REG_NUMBER3," ).append("\n"); 
		query.append("        BL_NO2," ).append("\n"); 
		query.append("        CONTAINER_NO," ).append("\n"); 
		query.append("        TYPE_SIZE," ).append("\n"); 
		query.append("        CNTR_REAL_NO," ).append("\n"); 
		query.append("        DELIVERY_TYPE," ).append("\n"); 
		query.append("        ROWNUM AS SEQ" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("        SELECT @[reg_no]  reg_number3," ).append("\n"); 
		query.append("               'SMLM'||BKG.BL_NO bl_no2," ).append("\n"); 
		query.append("               NVL(BC.CNTR_NO,' ') container_no," ).append("\n"); 
		query.append("               NVL(DECODE(SUBSTR(BC.CNTR_TPSZ_CD,2,1),'2',BC.CNTR_TPSZ_CD,SUBSTR(BC.CNTR_TPSZ_CD,1,1)||'4'),' ') type_size," ).append("\n"); 
		query.append("			(  SELECT NVL(MIN(CNTR_SEAL_NO),' ') " ).append("\n"); 
		query.append("			   FROM BKG_CNTR_SEAL_NO" ).append("\n"); 
		query.append("			   WHERE BKG_NO = BC.BKG_NO" ).append("\n"); 
		query.append("				AND CNTR_NO = BC.CNTR_NO ) cntr_real_no," ).append("\n"); 
		query.append("               NVL(BKG.RCV_TERM_CD||BKG.DE_TERM_CD,0) delivery_type" ).append("\n"); 
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