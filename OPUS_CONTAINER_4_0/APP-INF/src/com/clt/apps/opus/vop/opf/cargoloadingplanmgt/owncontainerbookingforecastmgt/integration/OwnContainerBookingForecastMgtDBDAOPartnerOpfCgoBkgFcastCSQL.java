/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : OwnContainerBookingForecastMgtDBDAOPartnerOpfCgoBkgFcastCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.04.09
*@LastModifier : 김현욱
*@LastVersion : 1.0
* 2010.04.09 김현욱
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.opf.cargoloadingplanmgt.owncontainerbookingforecastmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kim Hyun Uk
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class OwnContainerBookingForecastMgtDBDAOPartnerOpfCgoBkgFcastCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Partner OpfCgoBkgFcast 입력
	  * </pre>
	  */
	public OwnContainerBookingForecastMgtDBDAOPartnerOpfCgoBkgFcastCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_shpr_ownr_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pol_clpt_ind_seq",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("yd_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("crr_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("Path : com.clt.apps.opus.vop.opf.cargoloadingplanmgt.owncontainerbookingforecastmgt.integration").append("\n"); 
		query.append("FileName : OwnContainerBookingForecastMgtDBDAOPartnerOpfCgoBkgFcastCSQL").append("\n"); 
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
		query.append("MERGE INTO OPF_CGO_BKG_FCAST" ).append("\n"); 
		query.append("USING DUAL" ).append("\n"); 
		query.append("ON (VSL_CD = @[vsl_cd]" ).append("\n"); 
		query.append("AND SKD_VOY_NO = @[skd_voy_no]" ).append("\n"); 
		query.append("AND SKD_DIR_CD = @[skd_dir_cd]" ).append("\n"); 
		query.append("AND BKG_SHPR_OWNR_FLG = NVL(@[bkg_shpr_ownr_flg],'N')" ).append("\n"); 
		query.append("AND CRR_CD = @[crr_cd]" ).append("\n"); 
		query.append("AND YD_CD = @[yd_cd]" ).append("\n"); 
		query.append("AND POL_CLPT_IND_SEQ = @[pol_clpt_ind_seq])" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("WHEN MATCHED THEN" ).append("\n"); 
		query.append("UPDATE SET" ).append("\n"); 
		query.append("SLAN_CD = (SELECT vsl_slan_cd FROM vsk_vsl_skd WHERE vsl_cd = @[vsl_cd] AND   skd_voy_no = @[skd_voy_no] AND   skd_dir_cd = @[skd_dir_cd])" ).append("\n"); 
		query.append(",	UPD_USR_ID = NVL(@[upd_usr_id],' ')" ).append("\n"); 
		query.append(",	UPD_DT = SYSDATE" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("WHEN NOT MATCHED THEN" ).append("\n"); 
		query.append("INSERT (VSL_CD, SKD_VOY_NO, SKD_DIR_CD, BKG_SHPR_OWNR_FLG," ).append("\n"); 
		query.append("CRR_CD, YD_CD, POL_CLPT_IND_SEQ, CBF_IND_FLG, SLAN_CD, CRE_USR_ID, CRE_DT, UPD_USR_ID, UPD_DT)" ).append("\n"); 
		query.append("VALUES(" ).append("\n"); 
		query.append("@[vsl_cd]" ).append("\n"); 
		query.append(",    @[skd_voy_no]" ).append("\n"); 
		query.append(",    @[skd_dir_cd]" ).append("\n"); 
		query.append(",    NVL(@[bkg_shpr_ownr_flg],'N')" ).append("\n"); 
		query.append(",    @[crr_cd]" ).append("\n"); 
		query.append(",    @[yd_cd]" ).append("\n"); 
		query.append(",    @[pol_clpt_ind_seq]" ).append("\n"); 
		query.append(",    'N'" ).append("\n"); 
		query.append(",    (SELECT vsl_slan_cd FROM vsk_vsl_skd WHERE vsl_cd = @[vsl_cd] AND   skd_voy_no = @[skd_voy_no] AND   skd_dir_cd = @[skd_dir_cd])" ).append("\n"); 
		query.append(",    @[cre_usr_id]" ).append("\n"); 
		query.append(",    SYSDATE" ).append("\n"); 
		query.append(",    NVL(@[upd_usr_id],' ')" ).append("\n"); 
		query.append(",    SYSDATE" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}