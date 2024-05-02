/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : SpaceAllocationManageDBDAOSpcNshwRsltVOCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.03
*@LastModifier : 최윤성
*@LastVersion : 1.0
* 2010.02.03 최윤성
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.spc.spaceallocationmanage.spaceallocationmanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author CHOI Yun Sung
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SpaceAllocationManageDBDAOSpcNshwRsltVOCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  *    
	  * </pre>
	  */
	public SpaceAllocationManageDBDAOSpcNshwRsltVOCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("aloc_lod_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bse_wk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rep_trd_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("trd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("org_aloc_lod_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sls_rhq_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("aloc_ddct_bse_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bse_yrmon",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_lod_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rep_sub_trd_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("sls_rgn_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("sls_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rlane_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sls_aq_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sub_trd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_knd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("org_fcast_lod_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fcast_lod_qty",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("ioc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.spc.spaceallocationmanage.spaceallocationmanage.integration").append("\n"); 
		query.append("FileName : SpaceAllocationManageDBDAOSpcNshwRsltVOCSQL").append("\n"); 
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
		query.append("INSERT INTO SPC_NSHW_RSLT (" ).append("\n"); 
		query.append("    RLANE_CD         ," ).append("\n"); 
		query.append("    DIR_CD           ," ).append("\n"); 
		query.append("    VSL_CD           ," ).append("\n"); 
		query.append("    SKD_VOY_NO       ," ).append("\n"); 
		query.append("    SKD_DIR_CD       ," ).append("\n"); 
		query.append("    SLS_OFC_CD       ," ).append("\n"); 
		query.append("    POL_YD_CD        ," ).append("\n"); 
		query.append("    ALOC_DDCT_BSE_CD ," ).append("\n"); 
		query.append("    FCAST_LOD_QTY    ," ).append("\n"); 
		query.append("    ALOC_LOD_QTY     ," ).append("\n"); 
		query.append("    BKG_LOD_QTY      ," ).append("\n"); 
		query.append("    REP_TRD_CD       ," ).append("\n"); 
		query.append("    REP_SUB_TRD_CD   ," ).append("\n"); 
		query.append("    TRD_CD           ," ).append("\n"); 
		query.append("    SUB_TRD_CD       ," ).append("\n"); 
		query.append("    IOC_CD           ," ).append("\n"); 
		query.append("    SLS_RHQ_CD       ," ).append("\n"); 
		query.append("    SLS_RGN_OFC_CD   ," ).append("\n"); 
		query.append("    OFC_KND_CD       ," ).append("\n"); 
		query.append("    SLS_AQ_CD        ," ).append("\n"); 
		query.append("    BSE_YRMON        ," ).append("\n"); 
		query.append("    BSE_WK           ," ).append("\n"); 
		query.append("    ORG_FCAST_LOD_QTY," ).append("\n"); 
		query.append("    ORG_ALOC_LOD_QTY ," ).append("\n"); 
		query.append("    CRE_USR_ID       ," ).append("\n"); 
		query.append("    CRE_DT           ," ).append("\n"); 
		query.append("    UPD_USR_ID       ," ).append("\n"); 
		query.append("    UPD_DT" ).append("\n"); 
		query.append(") VALUES (" ).append("\n"); 
		query.append("    @[rlane_cd]         ," ).append("\n"); 
		query.append("    @[dir_cd]           ," ).append("\n"); 
		query.append("    @[vsl_cd]           ," ).append("\n"); 
		query.append("    @[skd_voy_no]       ," ).append("\n"); 
		query.append("    @[skd_dir_cd]       ," ).append("\n"); 
		query.append("    @[sls_ofc_cd]       ," ).append("\n"); 
		query.append("    @[pol_yd_cd]        ," ).append("\n"); 
		query.append("    @[aloc_ddct_bse_cd] ," ).append("\n"); 
		query.append("    @[fcast_lod_qty]    ," ).append("\n"); 
		query.append("    @[aloc_lod_qty]     ," ).append("\n"); 
		query.append("    @[bkg_lod_qty]      ," ).append("\n"); 
		query.append("    @[rep_trd_cd]       ," ).append("\n"); 
		query.append("    @[rep_sub_trd_cd]   ," ).append("\n"); 
		query.append("    @[trd_cd]           ," ).append("\n"); 
		query.append("    @[sub_trd_cd]       ," ).append("\n"); 
		query.append("    @[ioc_cd]           ," ).append("\n"); 
		query.append("    @[sls_rhq_cd]       ," ).append("\n"); 
		query.append("    @[sls_rgn_ofc_cd]   ," ).append("\n"); 
		query.append("    @[ofc_knd_cd]       ," ).append("\n"); 
		query.append("    @[sls_aq_cd]        ," ).append("\n"); 
		query.append("    @[bse_yrmon]        ," ).append("\n"); 
		query.append("    @[bse_wk]           ," ).append("\n"); 
		query.append("    @[org_fcast_lod_qty]," ).append("\n"); 
		query.append("    @[org_aloc_lod_qty] ," ).append("\n"); 
		query.append("    @[cre_usr_id]       ," ).append("\n"); 
		query.append("    SYSDATE             ," ).append("\n"); 
		query.append("    @[upd_usr_id]       ," ).append("\n"); 
		query.append("    SYSDATE" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}