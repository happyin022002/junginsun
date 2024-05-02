/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : GeneralBookingSearchDBDAOaddCustAdvisoryNoticeHistoryCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.05.13
*@LastModifier : 
*@LastVersion : 1.0
* 2015.05.13 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class GeneralBookingSearchDBDAOaddCustAdvisoryNoticeHistoryCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Customer Advice Notice 내역 정보를 저장한다.
	  * </pre>
	  */
	public GeneralBookingSearchDBDAOaddCustAdvisoryNoticeHistoryCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ntc_eml",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ntc_snd_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ntc_via_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("fax_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ntc_snd_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_cust_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("src_dat_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("del_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ntc_snd_usr_id",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("pod_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("skd_voy_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.integration").append("\n"); 
		query.append("FileName : GeneralBookingSearchDBDAOaddCustAdvisoryNoticeHistoryCSQL").append("\n"); 
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
		query.append("INSERT INTO BKG_CUST_AVC_NTC_HIS" ).append("\n"); 
		query.append("	SELECT " ).append("\n"); 
		query.append("		  @[vsl_cd]																				AS VSL_CD" ).append("\n"); 
		query.append("		  , @[skd_voy_no]																		AS SKD_VOY_NO" ).append("\n"); 
		query.append("		  , @[skd_dir_cd]																		AS SKD_DIR_CD" ).append("\n"); 
		query.append("	      , @[bl_no]                                                                            AS BL_NO                              " ).append("\n"); 
		query.append("	      ,( SELECT NVL(MAX(NTC_HIS_SEQ)+ 1, 1) " ).append("\n"); 
		query.append("	         FROM BKG_CUST_AVC_NTC_HIS " ).append("\n"); 
		query.append("	         WHERE BL_NO = @[bl_no]" ).append("\n"); 
		query.append("			  AND VSL_CD = @[vsl_cd]" ).append("\n"); 
		query.append("			  AND SKD_VOY_NO = @[skd_voy_no]" ).append("\n"); 
		query.append("			  AND SKD_DIR_CD = @[skd_dir_cd])                                                   AS NTC_VIA_CD                                       " ).append("\n"); 
		query.append("	      ,@[ntc_via_cd]                                                                        AS NTC_VIA_CD     -- 'F': Fax.,'E':Email" ).append("\n"); 
		query.append("	      ,@[bkg_cust_tp_cd]                                                                    AS BKG_CUST_TP_CD     " ).append("\n"); 
		query.append("		  ,@[pol_cd]																			AS POL_CD" ).append("\n"); 
		query.append("		  ,@[pod_cd]																			AS POD_CD" ).append("\n"); 
		query.append("		  ,@[del_cd]                             												AS DEL_CD" ).append("\n"); 
		query.append("	      ,@[fax_no]                                                                            AS FAX_NO                               " ).append("\n"); 
		query.append("	      ,@[ntc_eml]                                                                           AS NTC_EML                              " ).append("\n"); 
		query.append("	      ,@[ntc_snd_id]                                                                        AS NTC_SND_ID                                   " ).append("\n"); 
		query.append("	      ,NULL                                                                                 AS NTC_SND_RSLT_CD                                    " ).append("\n"); 
		query.append("	      ,@[ntc_snd_ofc_cd]                                                                    AS NTC_SND_OFC_CD                                    " ).append("\n"); 
		query.append("	      ,@[ntc_snd_usr_id]                                                                    AS NTC_SND_USR_ID                                   " ).append("\n"); 
		query.append("	      ,GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC(@[ntc_snd_ofc_cd]) 							    AS NTC_SND_RQST_DT                                    " ).append("\n"); 
		query.append("	      ,GLOBALDATE_PKG.TIME_CONV_FNC('KRSEL', SYSDATE, 'GMT' ) 								AS NTC_SND_RQST_GDT                                    " ).append("\n"); 
		query.append("	      ,NULL                                                          			    		AS NTC_SND_DT                                " ).append("\n"); 
		query.append("	      ,NULL                                						    						AS NTC_SND_GDT                                " ).append("\n"); 
		query.append("	                                        " ).append("\n"); 
		query.append("	      ,@[cre_usr_id]                                                                        AS CRE_USR_ID" ).append("\n"); 
		query.append("	      ,SYSDATE                                                                              AS CRE_DT" ).append("\n"); 
		query.append("	      ,@[upd_usr_id]                                                                        AS UPD_USR_ID" ).append("\n"); 
		query.append("	      ,SYSDATE                                                                              AS UPD_DT   " ).append("\n"); 
		query.append("		  ,@[src_dat_tp_cd]																		AS SRC_DAT_TP_CD  " ).append("\n"); 
		query.append("  		,(	SELECT IMPT_NTC_RMK FROM BKG_CUST_AVC_NTC_RMK" ).append("\n"); 
		query.append("     			WHERE VSL_CD = @[vsl_cd]" ).append("\n"); 
		query.append("			  	AND SKD_VOY_NO = @[skd_voy_no]" ).append("\n"); 
		query.append("			  	AND SKD_DIR_CD = @[skd_dir_cd]" ).append("\n"); 
		query.append("              	AND RMK_USE_FLG = 'Y'" ).append("\n"); 
		query.append("				AND ROWNUM = 1)                                				            			AS IMPT_NTC_RMK                                                                        " ).append("\n"); 
		query.append("	FROM DUAL" ).append("\n"); 

	}
}