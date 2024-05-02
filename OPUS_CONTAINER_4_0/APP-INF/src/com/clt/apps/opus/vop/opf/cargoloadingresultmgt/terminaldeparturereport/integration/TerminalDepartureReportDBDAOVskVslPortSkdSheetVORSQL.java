/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : TerminalDepartureReportDBDAOVskVslPortSkdSheetVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.04.09
*@LastModifier : 장강철
*@LastVersion : 1.0
* 2010.04.09 장강철
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.opf.cargoloadingresultmgt.terminaldeparturereport.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author jang kang cheol
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TerminalDepartureReportDBDAOVskVslPortSkdSheetVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  *    
	  * </pre>
	  */
	public TerminalDepartureReportDBDAOVskVslPortSkdSheetVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("skd_voy_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.vop.opf.cargoloadingresultmgt.terminaldeparturereport.integration").append("\n"); 
		query.append("FileName : TerminalDepartureReportDBDAOVskVslPortSkdSheetVORSQL").append("\n"); 
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
		query.append("SELECT A.CLPT_IND_SEQ," ).append("\n"); 
		query.append("TO_CHAR(ACT_ARR_DT,            'YYYYMMDDHH24MI')	AS	FIRST_PILOT_ON," ).append("\n"); 
		query.append("TO_CHAR(BFR_BRTH_ANK_DRP_DT,   'YYYYMMDDHH24MI')	AS	ANCHORAGE_ARR," ).append("\n"); 
		query.append("TO_CHAR(ACT_BRTH_DT,           'YYYYMMDDHH24MI')	AS	BERTH," ).append("\n"); 
		query.append("( SELECT VPS_PORT_CD" ).append("\n"); 
		query.append("FROM   VSK_VSL_PORT_SKD" ).append("\n"); 
		query.append("WHERE  VSL_CD       = P.VSL_CD" ).append("\n"); 
		query.append("AND    SKD_VOY_NO   = P.SKD_VOY_NO" ).append("\n"); 
		query.append("AND    SKD_DIR_CD   = P.SKD_DIR_CD" ).append("\n"); 
		query.append("AND    CLPT_SEQ     = (    SELECT  MIN(CLPT_SEQ)" ).append("\n"); 
		query.append("FROM    VSK_VSL_PORT_SKD" ).append("\n"); 
		query.append("WHERE   VSL_CD       = P.VSL_CD" ).append("\n"); 
		query.append("AND     SKD_VOY_NO   = P.SKD_VOY_NO" ).append("\n"); 
		query.append("AND     SKD_DIR_CD   = P.SKD_DIR_CD" ).append("\n"); 
		query.append("AND     CLPT_SEQ     > P.CLPT_SEQ" ).append("\n"); 
		query.append("AND     NVL(SKD_CNG_STS_CD, '-') != 'S' ) ) 		AS	ETA_NEXT_PORT," ).append("\n"); 
		query.append("( SELECT TO_CHAR(VPS_ETA_DT,  'YYYYMMDDHH24MI')" ).append("\n"); 
		query.append("FROM   VSK_VSL_PORT_SKD" ).append("\n"); 
		query.append("WHERE  VSL_CD       = P.VSL_CD" ).append("\n"); 
		query.append("AND    SKD_VOY_NO   = P.SKD_VOY_NO" ).append("\n"); 
		query.append("AND    SKD_DIR_CD   = P.SKD_DIR_CD" ).append("\n"); 
		query.append("AND    CLPT_SEQ     = (    SELECT  MIN(CLPT_SEQ)" ).append("\n"); 
		query.append("FROM    VSK_VSL_PORT_SKD" ).append("\n"); 
		query.append("WHERE   VSL_CD       = P.VSL_CD" ).append("\n"); 
		query.append("AND     SKD_VOY_NO   = P.SKD_VOY_NO" ).append("\n"); 
		query.append("AND     SKD_DIR_CD   = P.SKD_DIR_CD" ).append("\n"); 
		query.append("AND     CLPT_SEQ     > P.CLPT_SEQ" ).append("\n"); 
		query.append("AND     NVL(SKD_CNG_STS_CD, '-') != 'S' ) ) 		AS	ETA_NEXT_DATE," ).append("\n"); 
		query.append("TO_CHAR(ACT_DEP_DT,            'YYYYMMDDHH24MI') AS	UNBERTH," ).append("\n"); 
		query.append("TO_CHAR(AFT_UNBRTH_ANK_OFF_DT, 'YYYYMMDDHH24MI') AS	ANCHORAGE_DEP," ).append("\n"); 
		query.append("TO_CHAR(PLT_LST_UNLD_DT,       'YYYYMMDDHH24MI') AS	LAST_PILOT_OFF," ).append("\n"); 
		query.append("DECODE(ARR_FWDDR_HGT          , 0, NULL, ARR_FWDDR_HGT          )	AS	ARR_DRAFT_FWD," ).append("\n"); 
		query.append("DECODE(ARR_AFTDR_HGT          , 0, NULL, ARR_AFTDR_HGT          )	AS	ARR_DRAFT_AFT," ).append("\n"); 
		query.append("DECODE(DEP_FWDDR_HGT          , 0, NULL, DEP_FWDDR_HGT          )	AS	DEP_DRAFT_FWD," ).append("\n"); 
		query.append("DECODE(DEP_AFTDR_HGT          , 0, NULL, DEP_AFTDR_HGT          )	AS	DEP_DRAFT_AFT," ).append("\n"); 
		query.append("DECODE(ARR_BLST_WGT           , 0, NULL, ARR_BLST_WGT           )	AS	ARR_BALLAST," ).append("\n"); 
		query.append("DECODE(DEP_BLST_WGT           , 0, NULL, DEP_BLST_WGT           )	AS	DEP_BALLAST," ).append("\n"); 
		query.append("DECODE(ARR_FOIL_WGT           , 0, NULL, ARR_FOIL_WGT           )	AS	ARR_ROB_FO," ).append("\n"); 
		query.append("DECODE(ARR_DOIL_WGT           , 0, NULL, ARR_DOIL_WGT           )	AS	ARR_ROB_DO," ).append("\n"); 
		query.append("DECODE(ARR_FRSH_WTR_WGT       , 0, NULL, ARR_FRSH_WTR_WGT       )	AS	ARR_ROB_FW," ).append("\n"); 
		query.append("DECODE(DEP_FOIL_WGT           , 0, NULL, DEP_FOIL_WGT           )	AS	DEP_ROB_FO," ).append("\n"); 
		query.append("DECODE(DEP_DOIL_WGT           , 0, NULL, DEP_DOIL_WGT           )	AS	DEP_ROB_DO," ).append("\n"); 
		query.append("DECODE(DEP_FRSH_WTR_WGT       , 0, NULL, DEP_FRSH_WTR_WGT       )	AS	DEP_ROB_FW," ).append("\n"); 
		query.append("DECODE(ARR_LOW_SULP_FOIL_WGT  , 0, NULL, ARR_LOW_SULP_FOIL_WGT  )	AS	ARR_LOW_SUL_FO," ).append("\n"); 
		query.append("DECODE(ARR_LOW_SULP_DOIL_WGT  , 0, NULL, ARR_LOW_SULP_DOIL_WGT  )	AS	ARR_LOW_SUL_DO," ).append("\n"); 
		query.append("DECODE(DEP_LOW_SULP_FOIL_WGT  , 0, NULL, DEP_LOW_SULP_FOIL_WGT  )	AS	DEP_LOW_SUL_FO," ).append("\n"); 
		query.append("DECODE(DEP_LOW_SULP_DOIL_WGT  , 0, NULL, DEP_LOW_SULP_DOIL_WGT  )	AS	DEP_LOW_SUL_DO," ).append("\n"); 
		query.append("DECODE(SPL_FOIL_WGT           , 0, NULL, SPL_FOIL_WGT           )	AS	DEP_SLP_FO," ).append("\n"); 
		query.append("DECODE(SPL_DOIL_WGT           , 0, NULL, SPL_DOIL_WGT           )	AS	DEP_SLP_DO," ).append("\n"); 
		query.append("DECODE(SPL_FRSH_WTR_WGT       , 0, NULL, SPL_FRSH_WTR_WGT       )	AS	DEP_SLP_FW," ).append("\n"); 
		query.append("DECODE(SPL_LOW_SULP_FOIL_WGT  , 0, NULL, SPL_LOW_SULP_FOIL_WGT  )	AS	DEP_LOW_SUL_FO_WGT," ).append("\n"); 
		query.append("DECODE(SPL_LOW_SULP_DOIL_WGT  , 0, NULL, SPL_LOW_SULP_DOIL_WGT  )	AS	DEP_LOW_SUL_DO_WGT," ).append("\n"); 
		query.append("DECODE(ARR_FWDDR_HGT          , 0, NULL, ARR_FWDDR_HGT          )	AS	ARR_DWT," ).append("\n"); 
		query.append("DECODE(ARR_AFTDR_HGT          , 0, NULL, ARR_AFTDR_HGT          )	AS	ARR_DISPLT," ).append("\n"); 
		query.append("DECODE(DEP_FWDDR_HGT          , 0, NULL, DEP_FWDDR_HGT          )	AS	DEP_DWT," ).append("\n"); 
		query.append("DECODE(DEP_AFTDR_HGT          , 0, NULL, DEP_AFTDR_HGT          )	AS	DEP_DISPL," ).append("\n"); 
		query.append("DECODE(ARR_GM_HGT             , 0, NULL, ARR_GM_HGT             )	AS	ARR_GM," ).append("\n"); 
		query.append("DECODE(DEP_GM_HGT             , 0, NULL, DEP_GM_HGT             )	AS	DEP_GM," ).append("\n"); 
		query.append("DECODE(ARR_TUG_BOT_KNT        , 0, NULL, ARR_TUG_BOT_KNT        )	AS	ARR_TUGBOAT," ).append("\n"); 
		query.append("DECODE(DEP_TUG_BOT_KNT        , 0, NULL, DEP_TUG_BOT_KNT        )	AS	DEP_TUGBOAT" ).append("\n"); 
		query.append("FROM   VSK_VSL_PORT_SKD P," ).append("\n"); 
		query.append("VSK_ACT_PORT_SKD A" ).append("\n"); 
		query.append("WHERE  P.VSL_CD       = @[vsl_cd]" ).append("\n"); 
		query.append("AND    P.SKD_VOY_NO   = @[skd_voy_no]" ).append("\n"); 
		query.append("AND    P.SKD_DIR_CD   = @[skd_dir_cd]" ).append("\n"); 
		query.append("AND    P.YD_CD        = @[yd_cd]" ).append("\n"); 
		query.append("AND    P.CLPT_IND_SEQ = @[clpt_ind_seq]" ).append("\n"); 
		query.append("AND    P.VSL_CD       = A.VSL_CD" ).append("\n"); 
		query.append("AND    P.SKD_VOY_NO   = A.SKD_VOY_NO" ).append("\n"); 
		query.append("AND    P.SKD_DIR_CD   = A.SKD_DIR_CD" ).append("\n"); 
		query.append("AND    P.VPS_PORT_CD  = A.VPS_PORT_CD" ).append("\n"); 
		query.append("AND    P.CLPT_IND_SEQ = A.CLPT_IND_SEQ" ).append("\n"); 

	}
}