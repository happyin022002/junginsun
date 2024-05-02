/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : UsaManifestListDownloadDBDAOmodifyOldCntrByCntrUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.22
*@LastModifier : 
*@LastVersion : 1.0
* 2010.02.22 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.usa.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class UsaManifestListDownloadDBDAOmodifyOldCntrByCntrUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * modifyOldCntrByCntr
	  * </pre>
	  */
	public UsaManifestListDownloadDBDAOmodifyOldCntrByCntrUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("prior_ntc_snd_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("hamo_cmdt_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cntr_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bl_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cmdt_gds_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.usa.integration").append("\n"); 
		query.append("FileName : UsaManifestListDownloadDBDAOmodifyOldCntrByCntrUSQL").append("\n"); 
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
		query.append("UPDATE BKG_CSTMS_ADV_CNTR_MF X" ).append("\n"); 
		query.append("   SET X.HAMO_CMDT_CD = @[hamo_cmdt_cd]," ).append("\n"); 
		query.append("       X.PRIOR_NTC_SND_FLG = @[prior_ntc_snd_flg]" ).append("\n"); 
		query.append(" WHERE X.CNT_CD    = NVL(@[cnt_cd],'US')" ).append("\n"); 
		query.append("   AND X.BL_NO     = @[bl_no]" ).append("\n"); 
		query.append("   AND X.CNTR_NO   = @[cntr_no]" ).append("\n"); 
		query.append("   AND X.CMDT_GDS_SEQ = @[cmdt_gds_seq]" ).append("\n"); 
		query.append("--   AND EXISTS (SELECT '*' FROM BKG_CSTMS_ADV_CNTR_MF Y" ).append("\n"); 
		query.append("--                WHERE Y.CNT_CD    = NVL([cnt_cd],'US')" ).append("\n"); 
		query.append("--				  AND Y.BL_NO     = X.BL_NO" ).append("\n"); 
		query.append("--                  AND Y.CNTR_NO   = X.CNTR_NO" ).append("\n"); 
		query.append("--                  AND Y.CMDT_GDS_SEQ = X.CMDT_GDS_SEQ)" ).append("\n"); 

	}
}