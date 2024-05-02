/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : InterfaceScheduleToExternalDBDAOCreateVipsIfDtlfromOldPortListCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.12.03
*@LastModifier : 
*@LastVersion : 1.0
* 2015.12.03 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.vsk.vskcommon.interfaceskedtoexternal.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class InterfaceScheduleToExternalDBDAOCreateVipsIfDtlfromOldPortListCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * VIPS I/F를 위한 DELETED VVD PORT LIST 일괄 INSERT
	  * </pre>
	  */
	public InterfaceScheduleToExternalDBDAOCreateVipsIfDtlfromOldPortListCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("old_vips_if_seq",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("skd_voy_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.vop.vsk.vskcommon.interfaceskedtoexternal.integration").append("\n"); 
		query.append("FileName : InterfaceScheduleToExternalDBDAOCreateVipsIfDtlfromOldPortListCSQL").append("\n"); 
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
		query.append("INSERT INTO VSK_VSL_SKD_VIPS_IF_DTL  " ).append("\n"); 
		query.append("          ( VSL_CD" ).append("\n"); 
		query.append("          , SKD_VOY_NO" ).append("\n"); 
		query.append("          , SKD_DIR_CD" ).append("\n"); 
		query.append("          , VIPS_IF_SEQ" ).append("\n"); 
		query.append("          , VPS_PORT_CD" ).append("\n"); 
		query.append("          , CLPT_IND_SEQ" ).append("\n"); 
		query.append("          , CLPT_SEQ" ).append("\n"); 
		query.append("          , PORT_SKD_STS_CD" ).append("\n"); 
		query.append("          , YD_CD" ).append("\n"); 
		query.append("          , CALL_YD_IND_SEQ" ).append("\n"); 
		query.append("          , SKD_CNG_STS_CD" ).append("\n"); 
		query.append("          , VIPS_MODI_LOC_CD" ).append("\n"); 
		query.append("          , VIPS_IB_CONSORTIUM_VOY_NO" ).append("\n"); 
		query.append("          , VIPS_OB_CONSORTIUM_VOY_NO" ).append("\n"); 
		query.append("          , PF_ETA_DT" ).append("\n"); 
		query.append("          , PF_ETB_DT" ).append("\n"); 
		query.append("          , PF_ETD_DT" ).append("\n"); 
		query.append("          , INIT_ETA_DT" ).append("\n"); 
		query.append("          , INIT_ETB_DT" ).append("\n"); 
		query.append("          , INIT_ETD_DT" ).append("\n"); 
		query.append("          , VIPS_VPS_ETA_DT" ).append("\n"); 
		query.append("          , VIPS_VPS_ETB_DT" ).append("\n"); 
		query.append("          , VIPS_VPS_ETD_DT" ).append("\n"); 
		query.append("          , VIPS_ACT_ARR_DT" ).append("\n"); 
		query.append("          , VIPS_ACT_BRTH_DT" ).append("\n"); 
		query.append("          , VIPS_ACT_DEP_DT" ).append("\n"); 
		query.append("          , TURN_PORT_FLG" ).append("\n"); 
		query.append("          , TURN_PORT_IND_CD" ).append("\n"); 
		query.append("          , TURN_SKD_VOY_NO" ).append("\n"); 
		query.append("          , TURN_SKD_DIR_CD" ).append("\n"); 
		query.append("          , TURN_CLPT_IND_SEQ" ).append("\n"); 
		query.append("          , VIPS_LOD_IND_CD" ).append("\n"); 
		query.append("          , VIPS_DCHG_IND_CD" ).append("\n"); 
		query.append("          , VIPS_PASS_IND_CD" ).append("\n"); 
		query.append("          , SKD_UPD_USR_ID" ).append("\n"); 
		query.append("          , SKD_UPD_USR_NM" ).append("\n"); 
		query.append("          , SKD_UPD_DT" ).append("\n"); 
		query.append("          , ADD_CALL_FLG" ).append("\n"); 
		query.append("          , VT_ADD_CALL_FLG" ).append("\n"); 
		query.append("          ,	CRE_USR_ID" ).append("\n"); 
		query.append("          ,	CRE_DT" ).append("\n"); 
		query.append("          ,	UPD_USR_ID" ).append("\n"); 
		query.append("          ,	UPD_DT" ).append("\n"); 
		query.append("          )" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SELECT		D.VSL_CD" ).append("\n"); 
		query.append("          ,	D.SKD_VOY_NO" ).append("\n"); 
		query.append("          ,	D.SKD_DIR_CD" ).append("\n"); 
		query.append("          ,	D.VIPS_IF_SEQ" ).append("\n"); 
		query.append("          ,	D.VPS_PORT_CD" ).append("\n"); 
		query.append("          ,	D.CLPT_IND_SEQ" ).append("\n"); 
		query.append("          ,	D.CLPT_SEQ" ).append("\n"); 
		query.append("          ,	D.PORT_SKD_STS_CD" ).append("\n"); 
		query.append("          ,	D.YD_CD" ).append("\n"); 
		query.append("          ,	D.CALL_YD_IND_SEQ" ).append("\n"); 
		query.append("          ,	D.SKD_CNG_STS_CD" ).append("\n"); 
		query.append("          ,	D.VIPS_MODI_LOC_CD" ).append("\n"); 
		query.append("          ,	D.VIPS_IB_CONSORTIUM_VOY_NO" ).append("\n"); 
		query.append("          ,	D.VIPS_OB_CONSORTIUM_VOY_NO" ).append("\n"); 
		query.append("          ,	D.PF_ETA_DT" ).append("\n"); 
		query.append("          ,	D.PF_ETB_DT" ).append("\n"); 
		query.append("          ,	D.PF_ETD_DT" ).append("\n"); 
		query.append("          ,	D.INIT_ETA_DT" ).append("\n"); 
		query.append("          ,	D.INIT_ETB_DT" ).append("\n"); 
		query.append("          ,	D.INIT_ETD_DT" ).append("\n"); 
		query.append("          ,	D.VIPS_VPS_ETA_DT" ).append("\n"); 
		query.append("          ,	D.VIPS_VPS_ETB_DT" ).append("\n"); 
		query.append("          ,	D.VIPS_VPS_ETD_DT" ).append("\n"); 
		query.append("          ,	D.VIPS_ACT_ARR_DT" ).append("\n"); 
		query.append("          ,	D.VIPS_ACT_BRTH_DT" ).append("\n"); 
		query.append("          ,	D.VIPS_ACT_DEP_DT" ).append("\n"); 
		query.append("          ,	D.TURN_PORT_FLG" ).append("\n"); 
		query.append("          ,	D.TURN_PORT_IND_CD" ).append("\n"); 
		query.append("          ,	D.TURN_SKD_VOY_NO" ).append("\n"); 
		query.append("          ,	D.TURN_SKD_DIR_CD" ).append("\n"); 
		query.append("          ,	D.TURN_CLPT_IND_SEQ" ).append("\n"); 
		query.append("          ,	D.VIPS_LOD_IND_CD" ).append("\n"); 
		query.append("          ,	D.VIPS_DCHG_IND_CD" ).append("\n"); 
		query.append("          ,	D.VIPS_PASS_IND_CD" ).append("\n"); 
		query.append("          ,	D.SKD_UPD_USR_ID" ).append("\n"); 
		query.append("          ,	D.SKD_UPD_USR_NM" ).append("\n"); 
		query.append("          ,	D.SKD_UPD_DT" ).append("\n"); 
		query.append("          ,	D.ADD_CALL_FLG" ).append("\n"); 
		query.append("          ,	D.VT_ADD_CALL_FLG" ).append("\n"); 
		query.append("          ,	D.CRE_USR_ID" ).append("\n"); 
		query.append("          ,	D.CRE_DT" ).append("\n"); 
		query.append("          ,	D.UPD_USR_ID" ).append("\n"); 
		query.append("          ,	D.UPD_DT" ).append("\n"); 
		query.append("FROM        VSK_VSL_SKD_VIPS_IF_DTL D" ).append("\n"); 
		query.append("WHERE       D.VSL_CD                = @[vsl_cd]" ).append("\n"); 
		query.append("AND         D.SKD_VOY_NO            = @[skd_voy_no]" ).append("\n"); 
		query.append("AND         D.SKD_DIR_CD            = @[skd_dir_cd] " ).append("\n"); 
		query.append("AND         D.VIPS_IF_SEQ           = @[old_vips_if_seq] " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("ORDER BY    D.CLPT_SEQ              ASC" ).append("\n"); 

	}
}