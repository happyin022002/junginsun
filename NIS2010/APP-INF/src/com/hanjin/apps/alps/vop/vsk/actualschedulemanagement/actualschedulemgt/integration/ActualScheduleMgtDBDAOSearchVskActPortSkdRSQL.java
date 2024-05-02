/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : ActualScheduleMgtDBDAOSearchVskActPortSkdRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.01.24
*@LastModifier : 
*@LastVersion : 1.0
* 2013.01.24 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.vsk.actualschedulemanagement.actualschedulemgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ActualScheduleMgtDBDAOSearchVskActPortSkdRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Actual Port Schedule 정보를 조회
	  * ------------------------------------------------------------------------------------------
	  * 2011.10.04 김민아 [CHM-201112983-01] Actual SKD Creation 및 Inquiry 화면 및 로직 변경. ATA,ATB,ATD 별 Remark 칼럼 추가
	  * </pre>
	  */
	public ActualScheduleMgtDBDAOSearchVskActPortSkdRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("clpt_ind_seq",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("vps_port_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("Path : com.hanjin.apps.alps.vop.vsk.actualschedulemanagement.actualschedulemgt.integration").append("\n"); 
		query.append("FileName : ActualScheduleMgtDBDAOSearchVskActPortSkdRSQL").append("\n"); 
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
		query.append("SELECT	 VSL_CD" ).append("\n"); 
		query.append("       , SKD_VOY_NO" ).append("\n"); 
		query.append("       , SKD_DIR_CD" ).append("\n"); 
		query.append("       , VPS_PORT_CD" ).append("\n"); 
		query.append("       , CLPT_IND_SEQ" ).append("\n"); 
		query.append("       , PORT_SKD_STS_CD" ).append("\n"); 
		query.append("       , TO_CHAR(LST_ETA_DT            , 'YYYYMMDDHH24MI') AS LST_ETA_DT" ).append("\n"); 
		query.append("       , TO_CHAR(ACT_ARR_DT            , 'YYYYMMDDHH24MI') AS ACT_ARR_DT" ).append("\n"); 
		query.append("       , VSL_ARR_DLAY_RSN_CD" ).append("\n"); 
		query.append("       , TO_CHAR(ACT_ATA_INP_DT        , 'YYYYMMDDHH24MISS') AS ACT_ATA_INP_DT" ).append("\n"); 
		query.append("       , ACT_ATA_INP_USR_ID" ).append("\n"); 
		query.append("       , TO_CHAR(LST_ETB_DT            , 'YYYYMMDDHH24MI') AS LST_ETB_DT" ).append("\n"); 
		query.append("       , TO_CHAR(ACT_BRTH_DT           , 'YYYYMMDDHH24MI') AS ACT_BRTH_DT" ).append("\n"); 
		query.append("       , VSL_BRTH_DLAY_RSN_CD" ).append("\n"); 
		query.append("       , TO_CHAR(ACT_ATB_INP_DT        , 'YYYYMMDDHH24MISS') AS ACT_ATB_INP_DT" ).append("\n"); 
		query.append("       , ACT_ATB_INP_USR_ID" ).append("\n"); 
		query.append("       , TO_CHAR(LST_ETD_DT            , 'YYYYMMDDHH24MI') AS LST_ETD_DT" ).append("\n"); 
		query.append("       , TO_CHAR(ACT_DEP_DT            , 'YYYYMMDDHH24MI') AS ACT_DEP_DT" ).append("\n"); 
		query.append("       , VSL_DEP_DLAY_RSN_CD" ).append("\n"); 
		query.append("       , TO_CHAR(ACT_ATD_INP_DT        , 'YYYYMMDDHH24MISS') AS ACT_ATD_INP_DT" ).append("\n"); 
		query.append("       , ACT_ATD_INP_USR_ID" ).append("\n"); 
		query.append("       , ARR_FOIL_WGT" ).append("\n"); 
		query.append("       , ARR_LOW_SULP_FOIL_WGT" ).append("\n"); 
		query.append("       , ARR_DOIL_WGT" ).append("\n"); 
		query.append("       , ARR_LOW_SULP_DOIL_WGT" ).append("\n"); 
		query.append("       , ARR_FRSH_WTR_WGT" ).append("\n"); 
		query.append("       , ARR_BLST_WGT" ).append("\n"); 
		query.append("       , ARR_FWDDR_HGT" ).append("\n"); 
		query.append("       , ARR_AFTDR_HGT" ).append("\n"); 
		query.append("       , ARR_GM_HGT" ).append("\n"); 
		query.append("       , ARR_TUG_BOT_KNT" ).append("\n"); 
		query.append("       , SPL_FOIL_WGT" ).append("\n"); 
		query.append("       , SPL_LOW_SULP_FOIL_WGT" ).append("\n"); 
		query.append("       , SPL_DOIL_WGT" ).append("\n"); 
		query.append("       , SPL_LOW_SULP_DOIL_WGT" ).append("\n"); 
		query.append("       , SPL_FRSH_WTR_WGT" ).append("\n"); 
		query.append("       , DEP_LOW_SULP_FOIL_WGT" ).append("\n"); 
		query.append("       , DEP_FOIL_WGT" ).append("\n"); 
		query.append("       , DEP_LOW_SULP_DOIL_WGT                       " ).append("\n"); 
		query.append("       , DEP_DOIL_WGT" ).append("\n"); 
		query.append("       , DEP_FRSH_WTR_WGT" ).append("\n"); 
		query.append("       , DEP_BLST_WGT" ).append("\n"); 
		query.append("       , DEP_FWDDR_HGT" ).append("\n"); 
		query.append("       , DEP_AFTDR_HGT" ).append("\n"); 
		query.append("       , DEP_GM_HGT" ).append("\n"); 
		query.append("       , DEP_TUG_BOT_KNT" ).append("\n"); 
		query.append("       , DIFF_RMK" ).append("\n"); 
		query.append("       , ACT_ARR_RMK" ).append("\n"); 
		query.append("       , ACT_BRTH_RMK" ).append("\n"); 
		query.append("       , ACT_DEP_RMK" ).append("\n"); 
		query.append("       , TO_CHAR(PLT_LST_UNLD_DT       , 'YYYYMMDDHH24MI') AS PLT_LST_UNLD_DT" ).append("\n"); 
		query.append("       , TO_CHAR(BFR_BRTH_ANK_DRP_DT   , 'YYYYMMDDHH24MI') AS BFR_BRTH_ANK_DRP_DT" ).append("\n"); 
		query.append("       , TO_CHAR(BFR_BRTH_ANK_OFF_DT   , 'YYYYMMDDHH24MI') AS AFT_UNBRTH_ANK_DRP_DT" ).append("\n"); 
		query.append("       , TO_CHAR(AFT_UNBRTH_ANK_DRP_DT , 'YYYYMMDDHH24MI') AS AFT_UNBRTH_ANK_DRP_DT" ).append("\n"); 
		query.append("       , TO_CHAR(AFT_UNBRTH_ANK_OFF_DT , 'YYYYMMDDHH24MI') AS AFT_UNBRTH_ANK_OFF_DT" ).append("\n"); 
		query.append("       , TTL_SLG_WGT" ).append("\n"); 
		query.append("       , TTL_GBG_QTY" ).append("\n"); 
		query.append("FROM     VSK_ACT_PORT_SKD" ).append("\n"); 
		query.append("WHERE    1 = 1" ).append("\n"); 
		query.append("AND      VSL_CD         = @[vsl_cd]" ).append("\n"); 
		query.append("AND      SKD_VOY_NO     = @[skd_voy_no]              " ).append("\n"); 
		query.append("AND      SKD_DIR_CD     = @[skd_dir_cd]              " ).append("\n"); 
		query.append("AND      VPS_PORT_CD    = @[vps_port_cd]             " ).append("\n"); 
		query.append("AND      CLPT_IND_SEQ   = @[clpt_ind_seq]" ).append("\n"); 

	}
}