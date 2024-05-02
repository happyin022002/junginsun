/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : UsaManifestListDownloadDBDAOsearchDispositionCdListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.09
*@LastModifier : 김민정
*@LastVersion : 1.0
* 2010.02.09 김민정
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.usa.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kim Minjeong
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class UsaManifestListDownloadDBDAOsearchDispositionCdListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * DispoCdDetailVO
	  * </pre>
	  */
	public UsaManifestListDownloadDBDAOsearchDispositionCdListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dspo_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cstms_dspo_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.usa.integration").append("\n"); 
		query.append("FileName : UsaManifestListDownloadDBDAOsearchDispositionCdListRSQL").append("\n"); 
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
		query.append("SELECT  A.CNT_CD" ).append("\n"); 
		query.append("       ,A.CSTMS_DSPO_CD" ).append("\n"); 
		query.append("       ,A.CSTMS_DSPO_NM" ).append("\n"); 
		query.append("       ,A.DSPO_TP_CD" ).append("\n"); 
		query.append("       ,A.DSPO_DESC" ).append("\n"); 
		query.append("       ,B.ATTR_CTNT4 AS CSTMS_PAIR_DSPO_CD" ).append("\n"); 
		query.append("       ,A.AUTO_NTC_FLG" ).append("\n"); 
		query.append("       ,A.OB_NTC_FLG" ).append("\n"); 
		query.append("       ,A.DIFF_RMK" ).append("\n"); 
		query.append("       ,TO_CHAR(A.UPD_DT, 'YYYYMMDDHH24MISS') AS UPD_DT" ).append("\n"); 
		query.append("       ,A.UPD_USR_ID" ).append("\n"); 
		query.append("       ,A.CRE_USR_ID" ).append("\n"); 
		query.append("       ,DECODE(B.CNT_CD, NULL, 'N', 'Y') AS HOLD" ).append("\n"); 
		query.append("  FROM  BKG_CSTMS_ADV_DSPO A" ).append("\n"); 
		query.append("       ,BKG_CSTMS_CD_CONV_CTNT B" ).append("\n"); 
		query.append(" WHERE  A.CNT_CD = B.CNT_CD(+)" ).append("\n"); 
		query.append("   AND  A.CSTMS_DSPO_CD = B.ATTR_CTNT3(+)" ).append("\n"); 
		query.append("   AND  B.CSTMS_DIV_ID(+) = 'CARGO_RLS_H_CD'" ).append("\n"); 
		query.append("#if (${cnt_cd} != '') " ).append("\n"); 
		query.append("   AND  A.CNT_CD = @[cnt_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${cstms_dspo_cd} != '') " ).append("\n"); 
		query.append("   AND  A.CSTMS_DSPO_CD = @[cstms_dspo_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${dspo_tp_cd} != '') " ).append("\n"); 
		query.append("   AND  A.DSPO_TP_CD = @[dspo_tp_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("ORDER BY A.CNT_CD, A.CSTMS_DSPO_CD" ).append("\n"); 

	}
}