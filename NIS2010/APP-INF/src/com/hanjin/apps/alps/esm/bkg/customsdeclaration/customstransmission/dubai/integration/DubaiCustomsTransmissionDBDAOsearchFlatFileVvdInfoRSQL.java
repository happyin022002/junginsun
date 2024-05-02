/*=========================================================
*Copyright(c) 2017 SM Line
*@FileName : DubaiCustomsTransmissionDBDAOsearchFlatFileVvdInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.11.14
*@LastModifier : 
*@LastVersion : 1.0
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.dubai.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class DubaiCustomsTransmissionDBDAOsearchFlatFileVvdInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 두바이 FlatFile 배정보 조회
	  * </pre>
	  */
	public DubaiCustomsTransmissionDBDAOsearchFlatFileVvdInfoRSQL(){
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
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.dubai.integration").append("\n"); 
		query.append("FileName : DubaiCustomsTransmissionDBDAOsearchFlatFileVvdInfoRSQL").append("\n"); 
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
		query.append("	VSL_CD" ).append("\n"); 
		query.append(",	SKD_VOY_NO" ).append("\n"); 
		query.append(",	SKD_DIR_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${pod_cd} == 'AEAUH' || ${pod_cd} == 'AEJEA' || ${pod_cd} == 'AESHJ') 	 " ).append("\n"); 
		query.append("	  ,(SELECT NVL(UN_LOC_CD, POL_CD) FROM MDM_LOCATION WHERE LOC_CD = POL_CD) POL_CD " ).append("\n"); 
		query.append("	  ,(SELECT NVL(UN_LOC_CD, POD_CD) FROM MDM_LOCATION WHERE LOC_CD = POD_CD) POD_CD  " ).append("\n"); 
		query.append("#else " ).append("\n"); 
		query.append("	  ,	POL_CD" ).append("\n"); 
		query.append("	  ,	POD_CD" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(",	CLPT_SEQ" ).append("\n"); 
		query.append(",	SUBSTR(VSL_NM, 1, 30) AS VSL_NM" ).append("\n"); 
		query.append(",	DU_LINE_ID" ).append("\n"); 
		query.append(",	DU_VOY_AGN_ID" ).append("\n"); 
		query.append(",	DU_ROTN_NO" ).append("\n"); 
		query.append("#if (${pod_cd} != 'AEAUH') " ).append("\n"); 
		query.append(",	TO_CHAR(ETA_DT, 'DD-MON-YYYY', 'NLS_DATE_LANGUAGE = American') AS ETA_DT" ).append("\n"); 
		query.append("#else " ).append("\n"); 
		query.append(",	TO_CHAR(ETA_DT, 'DD-MM-YYYY', 'NLS_DATE_LANGUAGE = American') AS ETA_DT" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(",	DU_MSG_TP_ID" ).append("\n"); 
		query.append(",	DU_INSTL_NO" ).append("\n"); 
		query.append(",	DU_MF_SEQ_NO" ).append("\n"); 
		query.append(",	CRE_USR_ID" ).append("\n"); 
		query.append(",	CRE_DT" ).append("\n"); 
		query.append(",	UPD_USR_ID" ).append("\n"); 
		query.append(",	UPD_DT" ).append("\n"); 
		query.append("FROM BKG_CSTMS_DU_VVD" ).append("\n"); 
		query.append("WHERE	VSL_CD = @[vsl_cd]" ).append("\n"); 
		query.append("AND	SKD_VOY_NO = @[skd_voy_no]" ).append("\n"); 
		query.append("AND	SKD_DIR_CD = @[skd_dir_cd]" ).append("\n"); 
		query.append("AND	POD_CD = @[pod_cd]" ).append("\n"); 
		query.append("AND CLPT_SEQ = (" ).append("\n"); 
		query.append("                    SELECT MAX(CLPT_SEQ)" ).append("\n"); 
		query.append("                      FROM BKG_CSTMS_DU_VVD" ).append("\n"); 
		query.append("                     WHERE VSL_CD = @[vsl_cd]" ).append("\n"); 
		query.append("                       AND SKD_VOY_NO = @[skd_voy_no]" ).append("\n"); 
		query.append("                       AND SKD_DIR_CD = @[skd_dir_cd]" ).append("\n"); 
		query.append("                       AND POD_CD = @[pod_cd]" ).append("\n"); 
		query.append("                ) " ).append("\n"); 

	}
}