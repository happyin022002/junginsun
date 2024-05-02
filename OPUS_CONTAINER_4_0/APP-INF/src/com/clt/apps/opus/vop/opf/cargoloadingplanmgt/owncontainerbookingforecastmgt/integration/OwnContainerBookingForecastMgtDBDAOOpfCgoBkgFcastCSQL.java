/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : OwnContainerBookingForecastMgtDBDAOOpfCgoBkgFcastCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.02.18
*@LastModifier : 장영석
*@LastVersion : 1.0
* 2011.02.18 장영석
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.opf.cargoloadingplanmgt.owncontainerbookingforecastmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author JangYeongSeok
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class OwnContainerBookingForecastMgtDBDAOOpfCgoBkgFcastCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * OpfCgoBkgFcast 입력
	  * </pre>
	  */
	public OwnContainerBookingForecastMgtDBDAOOpfCgoBkgFcastCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cbf_ind_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cbf_bkg_sts_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("FileName : OwnContainerBookingForecastMgtDBDAOOpfCgoBkgFcastCSQL").append("\n"); 
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
		query.append("AND BKG_SHPR_OWNR_FLG = @[bkg_shpr_ownr_flg]" ).append("\n"); 
		query.append("AND CRR_CD = NVL(@[crr_cd], COM_ConstantMgr_PKG.COM_getCompanyCode_FNC())" ).append("\n"); 
		query.append("AND YD_CD = @[yd_cd])" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("WHEN MATCHED THEN" ).append("\n"); 
		query.append("UPDATE SET" ).append("\n"); 
		query.append("CBF_IND_FLG = NVL(@[cbf_ind_flg],'P')" ).append("\n"); 
		query.append(",   CBF_BKG_STS_CD = NVL(@[cbf_bkg_sts_cd],'A')" ).append("\n"); 
		query.append(",	SLAN_CD = (SELECT vsl_slan_cd FROM vsk_vsl_skd WHERE vsl_cd = @[vsl_cd] AND   skd_voy_no = @[skd_voy_no] AND   skd_dir_cd = @[skd_dir_cd])" ).append("\n"); 
		query.append(",	UPD_USR_ID = @[cre_usr_id]" ).append("\n"); 
		query.append(",	UPD_DT = SYSDATE" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("WHEN NOT MATCHED THEN" ).append("\n"); 
		query.append("INSERT (VSL_CD, SKD_VOY_NO, SKD_DIR_CD, BKG_SHPR_OWNR_FLG," ).append("\n"); 
		query.append("CRR_CD, YD_CD, CBF_IND_FLG, CBF_BKG_STS_CD, SLAN_CD, CRE_USR_ID, CRE_DT, UPD_USR_ID, UPD_DT)" ).append("\n"); 
		query.append("VALUES(" ).append("\n"); 
		query.append("@[vsl_cd]" ).append("\n"); 
		query.append(",    @[skd_voy_no]" ).append("\n"); 
		query.append(",    @[skd_dir_cd]" ).append("\n"); 
		query.append(",    NVL(@[bkg_shpr_ownr_flg],'Y')" ).append("\n"); 
		query.append(",    NVL(@[crr_cd],COM_ConstantMgr_PKG.COM_getCompanyCode_FNC())" ).append("\n"); 
		query.append(",    @[yd_cd]" ).append("\n"); 
		query.append(",    NVL(@[cbf_ind_flg],'P')" ).append("\n"); 
		query.append(",    NVL(@[cbf_bkg_sts_cd],'A')" ).append("\n"); 
		query.append(",    (SELECT vsl_slan_cd FROM vsk_vsl_skd WHERE vsl_cd = @[vsl_cd] AND   skd_voy_no = @[skd_voy_no] AND   skd_dir_cd = @[skd_dir_cd])" ).append("\n"); 
		query.append(",    @[cre_usr_id]" ).append("\n"); 
		query.append(",    SYSDATE" ).append("\n"); 
		query.append(",    @[cre_usr_id]" ).append("\n"); 
		query.append(",    SYSDATE" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}