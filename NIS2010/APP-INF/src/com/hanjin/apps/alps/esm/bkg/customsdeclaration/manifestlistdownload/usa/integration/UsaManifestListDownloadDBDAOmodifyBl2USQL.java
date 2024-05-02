/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : UsaManifestListDownloadDBDAOmodifyBl2USQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.08.11
*@LastModifier : 김민정
*@LastVersion : 1.0
* 2010.08.11 김민정
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.usa.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Minjeong Kim
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class UsaManifestListDownloadDBDAOmodifyBl2USQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * modifyBl2
	  * </pre>
	  */
	public UsaManifestListDownloadDBDAOmodifyBl2USQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ibd_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("upd_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ibd_trsp_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("locl_clr_ipi_mvmt_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("free_trd_zn_flg",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("locl_trns_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.usa.integration").append("\n"); 
		query.append("FileName : UsaManifestListDownloadDBDAOmodifyBl2USQL").append("\n"); 
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
		query.append("MERGE INTO BKG_CSTMS_ADV_IBD IBD" ).append("\n"); 
		query.append("USING ( " ).append("\n"); 
		query.append("    SELECT @[cnt_cd] AS CNT_CD, @[bl_no] AS BL_NO FROM DUAL ) TM" ).append("\n"); 
		query.append("ON ( IBD.CNT_CD = TM.CNT_CD AND IBD.BL_NO = TM.BL_NO )" ).append("\n"); 
		query.append("WHEN MATCHED THEN" ).append("\n"); 
		query.append("        UPDATE 	" ).append("\n"); 
		query.append("        SET		UPD_USR_ID = @[upd_usr_id]" ).append("\n"); 
		query.append("        ,		UPD_DT = SYSDATE" ).append("\n"); 
		query.append("	#if (${origin_bl_flag} == 'origin_bl')" ).append("\n"); 
		query.append("		,		IBD_TRSP_NO = DECODE(@[locl_trns_cd], 'L', '', @[ibd_trsp_no]) -- Changed by L, then will be ''" ).append("\n"); 
		query.append("		,		IBD_TRSP_TP_CD = DECODE(@[locl_trns_cd], 'L', '', @[ibd_tp_cd]) -- Changed by L, then will be ''" ).append("\n"); 
		query.append("        #if (${locl_trns_cd} != '') " ).append("\n"); 
		query.append("		,		CSTMS_CLR_TP_CD = @[locl_trns_cd]" ).append("\n"); 
		query.append("        #end	" ).append("\n"); 
		query.append("	#else" ).append("\n"); 
		query.append("		#if (${cstms_clr_tp_cd_chg} == 'Y')" ).append("\n"); 
		query.append("		,		CSTMS_CLR_TP_CD = @[locl_trns_cd]" ).append("\n"); 
		query.append("			#if(${locl_clr_ipi_mvmt_flg} == 'Y' and ${locl_trns_cd} == 'L' )" ).append("\n"); 
		query.append("			,		IBD_TRSP_NO = ''" ).append("\n"); 
		query.append("			,		IBD_TRSP_TP_CD = ''" ).append("\n"); 
		query.append("			#end" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("		#if (${ibd_trsp_tp_cd_chg} == 'Y') " ).append("\n"); 
		query.append("		,		IBD_TRSP_TP_CD = DECODE(@[locl_trns_cd], 'L', '', @[ibd_tp_cd]) -- Changed by L, then will be ''" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	#if (${locl_clr_ipi_mvmt_flg} != '') " ).append("\n"); 
		query.append("		,		LOCL_CLR_IPI_MVMT_FLG = @[locl_clr_ipi_mvmt_flg]" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	#if (${free_trd_zn_flg} != '')" ).append("\n"); 
		query.append("		,		FREE_TRD_ZN_FLG = @[free_trd_zn_flg]" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("WHEN NOT MATCHED THEN" ).append("\n"); 
		query.append("        INSERT ( CNT_CD" ).append("\n"); 
		query.append("                ,BL_NO" ).append("\n"); 
		query.append("				,CSTMS_CLR_TP_CD" ).append("\n"); 
		query.append("				,IBD_TRSP_NO" ).append("\n"); 
		query.append("				,IBD_TRSP_TP_CD" ).append("\n"); 
		query.append("                ,CRE_USR_ID" ).append("\n"); 
		query.append("                ,CRE_DT" ).append("\n"); 
		query.append("                ,UPD_USR_ID" ).append("\n"); 
		query.append("                ,UPD_DT )" ).append("\n"); 
		query.append("        VALUES ( @[cnt_cd]" ).append("\n"); 
		query.append("                ,@[bl_no]" ).append("\n"); 
		query.append("                ,@[locl_trns_cd]" ).append("\n"); 
		query.append("                ,@[ibd_trsp_no]" ).append("\n"); 
		query.append("                ,@[ibd_tp_cd]" ).append("\n"); 
		query.append("                ,@[cre_usr_id]" ).append("\n"); 
		query.append("                ,SYSDATE" ).append("\n"); 
		query.append("                ,@[upd_usr_id]" ).append("\n"); 
		query.append("                ,SYSDATE )" ).append("\n"); 

	}
}