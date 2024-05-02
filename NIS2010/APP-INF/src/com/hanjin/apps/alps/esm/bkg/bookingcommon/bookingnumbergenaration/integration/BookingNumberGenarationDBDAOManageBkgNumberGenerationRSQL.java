/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : BookingNumberGenarationDBDAOManageBkgNumberGenerationRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.07.19
*@LastModifier : 조원주
*@LastVersion : 1.0
* 2011.07.19 조원주
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingnumbergenaration.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author CHO WON-JOO
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BookingNumberGenarationDBDAOManageBkgNumberGenerationRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * booking number조회
	  * </pre>
	  */
	public BookingNumberGenarationDBDAOManageBkgNumberGenerationRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("upd_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no_gen_div_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingnumbergenaration.integration").append("\n"); 
		query.append("FileName : BookingNumberGenarationDBDAOManageBkgNumberGenerationRSQL").append("\n"); 
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
		query.append("SELECT 	CASE WHEN @[bkg_no_gen_div_cd] = 'BKG' THEN BKG_COMMON_PKG.BKG_NO_GEN_FNC(@[bkg_no_gen_div_cd],@[cre_ofc_cd],@[upd_usr_id]) ELSE '' END bkg_no" ).append("\n"); 
		query.append(",		CASE WHEN @[bkg_no_gen_div_cd] = 'NCB' THEN BKG_COMMON_PKG.BKG_NO_GEN_FNC(@[bkg_no_gen_div_cd],@[cre_ofc_cd],@[upd_usr_id]) ELSE '' END ncb_no" ).append("\n"); 
		query.append(",		CASE WHEN @[bkg_no_gen_div_cd] = 'C/A' THEN BKG_COMMON_PKG.BKG_NO_GEN_FNC(@[bkg_no_gen_div_cd],@[cre_ofc_cd],@[upd_usr_id]) ELSE '' END ca_no" ).append("\n"); 
		query.append(",		'' BL_NO" ).append("\n"); 
		query.append(",		'' CA_FLG" ).append("\n"); 
		query.append(",		'' BDR_FLG" ).append("\n"); 
		query.append(",		'' PCTL_NO" ).append("\n"); 
		query.append(",		'' BL_NO_CHK" ).append("\n"); 
		query.append(",		'' BKG_STS_CD" ).append("\n"); 
		query.append(",		'' BL_TP_CD" ).append("\n"); 
		query.append(",		'' CA_EXIST_FLG" ).append("\n"); 
		query.append("FROM DUAL                       " ).append("\n"); 

	}
}