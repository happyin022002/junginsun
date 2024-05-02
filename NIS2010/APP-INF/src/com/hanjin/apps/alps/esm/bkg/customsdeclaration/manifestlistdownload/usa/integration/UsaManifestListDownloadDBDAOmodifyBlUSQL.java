/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : UsaManifestListDownloadDBDAOmodifyBlUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.01.31
*@LastModifier : 민정호
*@LastVersion : 1.0
* 2012.01.31 민정호
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.usa.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Min Jung Ho
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class UsaManifestListDownloadDBDAOmodifyBlUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * modifyBl
	  * </pre>
	  */
	public UsaManifestListDownloadDBDAOmodifyBlUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pre_mf_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ams_pck_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cstms_port_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cstms_loc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("usa_lst_loc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("wgt_ut_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cgo_wgt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pck_qty",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("f_pod",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("full_mty_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("hub_loc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("diff_rmk",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("Path : com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.usa.integration").append("\n"); 
		query.append("FileName : UsaManifestListDownloadDBDAOmodifyBlUSQL").append("\n"); 
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
		query.append("MERGE INTO BKG_CSTMS_ADV_BL BL" ).append("\n"); 
		query.append("USING (" ).append("\n"); 
		query.append("SELECT @[cnt_cd] AS CNT_CD, @[bl_no] AS BL_NO FROM DUAL ) TM" ).append("\n"); 
		query.append("ON ( BL.CNT_CD = TM.CNT_CD AND BL.BL_NO = TM.BL_NO )" ).append("\n"); 
		query.append("WHEN MATCHED THEN" ).append("\n"); 
		query.append("UPDATE" ).append("\n"); 
		query.append("SET		UPD_USR_ID = @[upd_usr_id]" ).append("\n"); 
		query.append(",		UPD_DT = SYSDATE" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${origin_bl_flag} == 'origin_bl')" ).append("\n"); 
		query.append(",		PRE_MF_NO = @[pre_mf_no]" ).append("\n"); 
		query.append(",		VSL_CD = @[vsl_cd]" ).append("\n"); 
		query.append(",		SKD_VOY_NO = @[skd_voy_no]" ).append("\n"); 
		query.append(",		SKD_DIR_CD = @[skd_dir_cd]" ).append("\n"); 
		query.append(",		CSTMS_POL_CD = @[pol_cd]" ).append("\n"); 
		query.append(",		CSTMS_POD_CD = @[pod_cd]" ).append("\n"); 
		query.append(",		CSTMS_LOC_CD = @[cstms_loc_cd]" ).append("\n"); 
		query.append(", 		CSTMS_PORT_CD = @[cstms_port_cd]" ).append("\n"); 
		query.append("#if (${f_pod} != '')" ).append("\n"); 
		query.append(",		POD_CD = @[f_pod]" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append(",		POD_CD = (SELECT POD_CD FROM BKG_BOOKING WHERE BL_NO = @[bl_no])" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(",		DEL_CD = @[del_cd]" ).append("\n"); 
		query.append(",		HUB_LOC_CD = @[hub_loc_cd]" ).append("\n"); 
		query.append(",		PCK_QTY = NVL(@[pck_qty],0)" ).append("\n"); 
		query.append(",		AMS_PCK_TP_CD = @[ams_pck_tp_cd]" ).append("\n"); 
		query.append(",		CGO_WGT = NVL(@[cgo_wgt],0)" ).append("\n"); 
		query.append(",		WGT_UT_CD = @[wgt_ut_cd]" ).append("\n"); 
		query.append(",		DIFF_RMK = NVL(@[diff_rmk],'')" ).append("\n"); 
		query.append(",		FULL_MTY_CD = @[full_mty_cd]" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${locl_clr_ipi_mvmt_flg} == 'Y' && ${locl_trns_cd} == 'L')" ).append("\n"); 
		query.append(",		USA_LST_LOC_CD = ''" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append(",		USA_LST_LOC_CD = @[usa_lst_loc_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("#if (${cstms_clr_tp_cd_chg} == 'Y')" ).append("\n"); 
		query.append("#if (${locl_clr_ipi_mvmt_flg} == 'Y' && ${locl_trns_cd} == 'L')" ).append("\n"); 
		query.append(",USA_LST_LOC_CD = ''" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("WHERE	CNT_CD = @[cnt_cd]" ).append("\n"); 
		query.append("AND	BL_NO = @[bl_no]" ).append("\n"); 
		query.append("WHEN NOT MATCHED THEN" ).append("\n"); 
		query.append("INSERT ( CNT_CD" ).append("\n"); 
		query.append(",BL_NO" ).append("\n"); 
		query.append(",BKG_NO" ).append("\n"); 
		query.append(",VSL_CD" ).append("\n"); 
		query.append(",SKD_VOY_NO" ).append("\n"); 
		query.append(",SKD_DIR_CD" ).append("\n"); 
		query.append(",CSTMS_POL_CD" ).append("\n"); 
		query.append(",CSTMS_POD_CD" ).append("\n"); 
		query.append(",CSTMS_PORT_CD" ).append("\n"); 
		query.append("#if (${f_pod} != '')" ).append("\n"); 
		query.append(",POD_CD" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(",DEL_CD" ).append("\n"); 
		query.append(",CSTMS_FILE_TP_CD" ).append("\n"); 
		query.append(",POR_CD" ).append("\n"); 
		query.append(",HUB_LOC_CD" ).append("\n"); 
		query.append(",USA_LST_LOC_CD" ).append("\n"); 
		query.append(",CSTMS_LOC_CD" ).append("\n"); 
		query.append(",PCK_QTY" ).append("\n"); 
		query.append(",AMS_PCK_TP_CD" ).append("\n"); 
		query.append(",CGO_WGT" ).append("\n"); 
		query.append(",WGT_UT_CD" ).append("\n"); 
		query.append(",PRE_MF_NO" ).append("\n"); 
		query.append(",MF_STS_CD" ).append("\n"); 
		query.append(",DIFF_RMK" ).append("\n"); 
		query.append(",FULL_MTY_CD" ).append("\n"); 
		query.append(",CRE_USR_ID" ).append("\n"); 
		query.append(",CRE_DT" ).append("\n"); 
		query.append(",UPD_USR_ID" ).append("\n"); 
		query.append(",UPD_DT )" ).append("\n"); 
		query.append("VALUES ( @[cnt_cd]" ).append("\n"); 
		query.append(",@[bl_no]" ).append("\n"); 
		query.append(",NVL(@[bkg_no],'00')" ).append("\n"); 
		query.append(",@[vsl_cd]" ).append("\n"); 
		query.append(",@[skd_voy_no]" ).append("\n"); 
		query.append(",@[skd_dir_cd]" ).append("\n"); 
		query.append(",@[pol_cd]" ).append("\n"); 
		query.append(",@[pod_cd]" ).append("\n"); 
		query.append(",@[cstms_port_cd]" ).append("\n"); 
		query.append("#if (${f_pod} != '')" ).append("\n"); 
		query.append(",@[f_pod]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(",@[del_cd]" ).append("\n"); 
		query.append(",'3'" ).append("\n"); 
		query.append(",@[pol_cd]" ).append("\n"); 
		query.append(",@[hub_loc_cd]" ).append("\n"); 
		query.append(",@[usa_lst_loc_cd]" ).append("\n"); 
		query.append(",@[cstms_loc_cd]" ).append("\n"); 
		query.append(",NVL(@[pck_qty],0)" ).append("\n"); 
		query.append(",@[ams_pck_tp_cd]" ).append("\n"); 
		query.append(",NVL(@[cgo_wgt],0)" ).append("\n"); 
		query.append(",@[wgt_ut_cd]" ).append("\n"); 
		query.append(",@[pre_mf_no]" ).append("\n"); 
		query.append(",'A'" ).append("\n"); 
		query.append(",@[diff_rmk]" ).append("\n"); 
		query.append(",@[full_mty_cd]" ).append("\n"); 
		query.append(",@[cre_usr_id]" ).append("\n"); 
		query.append(",SYSDATE" ).append("\n"); 
		query.append(",@[upd_usr_id]" ).append("\n"); 
		query.append(",SYSDATE )" ).append("\n"); 

	}
}