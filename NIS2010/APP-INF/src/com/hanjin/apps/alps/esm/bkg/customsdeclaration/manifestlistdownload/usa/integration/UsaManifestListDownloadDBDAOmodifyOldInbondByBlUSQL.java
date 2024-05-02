/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : UsaManifestListDownloadDBDAOmodifyOldInbondByBlUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.07.14
*@LastModifier : 
*@LastVersion : 1.0
* 2015.07.14 
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

public class UsaManifestListDownloadDBDAOmodifyOldInbondByBlUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * modifyOldInbondByBl
	  * </pre>
	  */
	public UsaManifestListDownloadDBDAOmodifyOldInbondByBlUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ibd_dir_de_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ibd_trsp_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ibd_free_trd_zn_flg",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("ibd_trsp_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("bl_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ibd_clr_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.usa.integration").append("\n"); 
		query.append("FileName : UsaManifestListDownloadDBDAOmodifyOldInbondByBlUSQL").append("\n"); 
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
		query.append("MERGE INTO BKG_CSTMS_ADV_IBD IB" ).append("\n"); 
		query.append("USING ( " ).append("\n"); 
		query.append("    SELECT NVL(@[cnt_cd],'US') AS CNT_CD, @[bl_no] AS BL_NO FROM DUAL ) TM" ).append("\n"); 
		query.append("ON ( IB.CNT_CD = TM.CNT_CD AND IB.BL_NO = TM.BL_NO )" ).append("\n"); 
		query.append("WHEN MATCHED THEN" ).append("\n"); 
		query.append("        UPDATE " ).append("\n"); 
		query.append("           SET IBD_TRSP_TP_CD = decode(@[ibd_clr_tp_cd], 'L', '', @[ibd_trsp_tp_cd])," ).append("\n"); 
		query.append("               IBD_TRSP_NO    = @[ibd_trsp_no]," ).append("\n"); 
		query.append("        	   CSTMS_CLR_TP_CD = @[ibd_clr_tp_cd]," ).append("\n"); 
		query.append("        	   FREE_TRD_ZN_FLG = NVL(@[ibd_free_trd_zn_flg], 'N')," ).append("\n"); 
		query.append("               DIR_DE_FLG = @[ibd_dir_de_flg]," ).append("\n"); 
		query.append("			   UPD_USR_ID = @[upd_usr_id]," ).append("\n"); 
		query.append("			   UPD_DT = SYSDATE" ).append("\n"); 
		query.append("WHEN NOT MATCHED THEN" ).append("\n"); 
		query.append("        INSERT ( CNT_CD" ).append("\n"); 
		query.append("                ,BL_NO" ).append("\n"); 
		query.append("                ,IBD_TRSP_TP_CD" ).append("\n"); 
		query.append("                ,IBD_TRSP_NO" ).append("\n"); 
		query.append("                ,CSTMS_CLR_TP_CD" ).append("\n"); 
		query.append("                ,FREE_TRD_ZN_FLG" ).append("\n"); 
		query.append("                ,LOCL_CLR_IPI_MVMT_FLG" ).append("\n"); 
		query.append("                ,IBD_TRSP_ARR_SND_FLG" ).append("\n"); 
		query.append("                ,IBD_TRSP_XPT_SND_FLG" ).append("\n"); 
		query.append("                ,DIR_DE_FLG" ).append("\n"); 
		query.append("                ,CRE_USR_ID" ).append("\n"); 
		query.append("                ,CRE_DT" ).append("\n"); 
		query.append("                ,UPD_USR_ID" ).append("\n"); 
		query.append("                ,UPD_DT )" ).append("\n"); 
		query.append("        VALUES ( NVL(@[cnt_cd],'US')" ).append("\n"); 
		query.append("                ,@[bl_no]" ).append("\n"); 
		query.append("                ,decode(@[ibd_clr_tp_cd], 'L', '', @[ibd_trsp_tp_cd])" ).append("\n"); 
		query.append("                ,@[ibd_trsp_no]" ).append("\n"); 
		query.append("                ,@[ibd_clr_tp_cd]" ).append("\n"); 
		query.append("                ,NVL(@[ibd_free_trd_zn_flg], 'N')" ).append("\n"); 
		query.append("                ,'N'" ).append("\n"); 
		query.append("                ,'N'" ).append("\n"); 
		query.append("                ,'N'" ).append("\n"); 
		query.append("                ,@[ibd_dir_de_flg]" ).append("\n"); 
		query.append("                ,@[cre_usr_id]" ).append("\n"); 
		query.append("                ,SYSDATE" ).append("\n"); 
		query.append("                ,@[upd_usr_id]" ).append("\n"); 
		query.append("                ,SYSDATE )" ).append("\n"); 

	}
}