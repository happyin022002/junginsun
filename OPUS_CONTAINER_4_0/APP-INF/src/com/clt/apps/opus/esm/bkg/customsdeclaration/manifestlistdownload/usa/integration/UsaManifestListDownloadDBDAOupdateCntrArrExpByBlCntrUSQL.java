/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : UsaManifestListDownloadDBDAOupdateCntrArrExpByBlCntrUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.11.02
*@LastModifier : 
*@LastVersion : 1.0
* 2016.11.02 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.usa.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class UsaManifestListDownloadDBDAOupdateCntrArrExpByBlCntrUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * dwkim Arrival 정보 갱신 at Cntr
	  * </pre>
	  */
	public UsaManifestListDownloadDBDAOupdateCntrArrExpByBlCntrUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("arr_time",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("arr_dt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("trans_gubun",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.usa.integration").append("\n"); 
		query.append("FileName : UsaManifestListDownloadDBDAOupdateCntrArrExpByBlCntrUSQL").append("\n"); 
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
		query.append("UPDATE BKG_CSTMS_ADV_CNTR" ).append("\n"); 
		query.append("    SET ARR_FLG = DECODE(@[trans_gubun], 'Arr', 'Y', ARR_FLG)" ).append("\n"); 
		query.append("       ,XPT_FLG = DECODE(@[trans_gubun], 'Arr', XPT_FLG, 'Y')" ).append("\n"); 
		query.append("#if (${trans_gubun} == 'Arr')" ).append("\n"); 
		query.append("       ,ARR_DT = DECODE(@[arr_dt], NULL, TO_DATE(NULL, 'YYYYMMDD HH24MI'), TO_DATE(REPLACE(REPLACE(@[arr_dt], '-', ''), '/', '')||' '||REPLACE(REPLACE(@[arr_time], ':', ''), '-',''),'YYYYMMDD HH24MI'))" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("       ,XPT_DT = DECODE(@[arr_dt], null, TO_DATE(NULL, 'YYYYMMDD HH24MI'), TO_DATE(REPLACE(REPLACE(@[arr_dt], '-', ''), '/', '')||' '||REPLACE(REPLACE(@[arr_time], ':', ''), '-',''),'YYYYMMDD HH24MI'))" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("  AND CNT_CD = NVL(@[cnt_cd], 'US')" ).append("\n"); 
		query.append("  AND BL_NO = @[bl_no]" ).append("\n"); 
		query.append("  AND CNTR_NO LIKE NVL(@[cntr_no], '%')" ).append("\n"); 

	}
}