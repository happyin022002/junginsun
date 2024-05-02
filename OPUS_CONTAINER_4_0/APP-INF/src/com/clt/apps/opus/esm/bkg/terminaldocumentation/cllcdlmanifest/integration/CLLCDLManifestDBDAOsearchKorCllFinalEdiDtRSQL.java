/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : CLLCDLManifestDBDAOsearchKorCllFinalEdiDtRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.02.02
*@LastModifier : 문경일
*@LastVersion : 1.0
* 2016.02.02 문경일
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.terminaldocumentation.cllcdlmanifest.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author KYOUNGIL MOON
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CLLCDLManifestDBDAOsearchKorCllFinalEdiDtRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchKorCllFinalEdiDt
	  * </pre>
	  */
	public CLLCDLManifestDBDAOsearchKorCllFinalEdiDtRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("skd_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pol_yd_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("Path : com.clt.apps.opus.esm.bkg.terminaldocumentation.cllcdlmanifest.integration").append("\n"); 
		query.append("FileName : CLLCDLManifestDBDAOsearchKorCllFinalEdiDtRSQL").append("\n"); 
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
		query.append("SELECT TO_CHAR(MAX(EDI_SND_DT),'YYYY-MM-DD HH24:MI') EDI_SND_DT" ).append("\n"); 
		query.append("FROM BKG_CSTMS_TML_EDI_SND_LOG" ).append("\n"); 
		query.append("WHERE CNTR_LIST_NO = @[vsl_cd]||SUBSTR(@[skd_voy_no],2,3)||@[skd_dir_cd]||SUBSTR(@[pol_cd],3,3)" ).append("\n"); 
		query.append("#if (${pol_yd_cd} != '') " ).append("\n"); 
		query.append(" AND  POL_YD_CD = @[pol_yd_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(" AND  FNL_EDI_SND_FLG = 'Y'" ).append("\n"); 
		query.append(" AND  DELT_FLG = 'N'" ).append("\n"); 
		query.append("#if (${in_cll_type} == 'LOCAL')" ).append("\n"); 
		query.append(" AND  KR_CLL_TS_CD IS NULL" ).append("\n"); 
		query.append("#elseif (${in_cll_type} == 'TS')" ).append("\n"); 
		query.append(" AND  KR_CLL_TS_CD IS NOT NULL" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}