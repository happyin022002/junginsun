/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : SpaceAllocationManageDBDAOSearchSpaceAllocationControlFlagListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.07.22
*@LastModifier : Arie
*@LastVersion : 1.0
* 2015.07.22 Arie
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.spc.spaceallocationmanage.spaceallocationmanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Arie
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SpaceAllocationManageDBDAOSearchSpaceAllocationControlFlagListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * - VVD 별 Control Option 을 Port별,type size별,  weight별로  관리한다
	  *    port별 관리는 office,pol,pod가 있는데 pod로 선택되어지면 ctrl_port_flag = 'Y'가 되고  ctrl_lvl_cd = 'D'가 된다.
	  *    pod를 제외하고 office나 pol로 선택되어지면  ctrl_port_flag = 'N'으로 되고, ctrl_lvl_cd = 'O'(office), ctrl_lvl_cd = 'L' (pol)로 셋팅되어진다.
	  * - CHOI.Y.S - [프로젝트] Ticket ID : CHM-201004171 - 53FT 관련 필드 추가
	  * [CHM-201322502-01] SPC 프로젝트 - 성수기 선복운영 개선을 위한 T/F추진
	  * 2015.07.24 Arie [CHM-201537010] Control Option Management 및 VVD별 EDIT기능 보완  - Sync/Desync 빼고 Yield Group, Fixed Edit 추가
	  * </pre>
	  */
	public SpaceAllocationManageDBDAOSearchSpaceAllocationControlFlagListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vvd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trade",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bound",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lane",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.spc.spaceallocationmanage.spaceallocationmanage.integration").append("\n"); 
		query.append("FileName : SpaceAllocationManageDBDAOSearchSpaceAllocationControlFlagListRSQL").append("\n"); 
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
		query.append("SELECT NVL(MIN(T.CTRL_LVL_CD)      , 'L') AS POL_POD," ).append("\n"); 
		query.append("       NVL(MIN(T.CTRL_40FT_HC_FLG) , 'N') AS HC40   ," ).append("\n"); 
		query.append("       NVL(MIN(T.CTRL_45FT_HC_FLG) , 'N') AS HC45   ," ).append("\n"); 
		query.append("       NVL(MIN(T.CTRL_53FT_FLG)    , 'N') AS HC53   ," ).append("\n"); 
		query.append("       NVL(MIN(T.CTRL_RF_FLG)      , 'N') AS REEFER ," ).append("\n"); 
		query.append("       NVL(MIN(T.CTRL_WGT_FLG)     , 'N') AS WEIGHT ," ).append("\n"); 
		query.append("       NVL(MIN(T.CTRL_SPC_FLG)     , 'N') AS VOLUME ," ).append("\n"); 
		query.append("       NVL(MIN(DECODE(T.REP_TRD_CD, @[trade], T.ACCT_GRP_CTRL_FLG)), 'N') AS ACCT, --smp" ).append("\n"); 
		query.append("       -- 2014.08.01 control option 추가" ).append("\n"); 
		query.append("       NVL(MIN(T.CTRL_D2_FLG)      , 'N') AS D2     ," ).append("\n"); 
		query.append("       NVL(MIN(T.CTRL_D4_FLG)      , 'N') AS D4     ," ).append("\n"); 
		query.append("       NVL(MIN(T.CTRL_RD_FLG)      , 'N') AS RD     ," ).append("\n"); 
		query.append("       NVL(MIN(T.CTRL_USA_SVC_MOD_FLG), 'N') AS USA ," ).append("\n"); 
		query.append("       NVL(MIN(T.CTRL_ACCT_FLG), 'N') AS ACCOUNT    , -- account/commodity" ).append("\n"); 
		query.append("       NVL(MIN(DECODE(T.CTRL_ECC_FLG, 'Y', 'E', DECODE(T.CTRL_ECC_GRP_FLG, 'Y', 'G', 'N'))), 'N') AS CTRL_DEST," ).append("\n"); 
		query.append("       NVL(MIN(T.CTRL_DEST_LVL_CD), 'N') AS CTRL_DEST_LVL" ).append("\n"); 
		query.append("       , NVL(MIN(T.CTRL_FX_RT_FLG), 'N') AS CTRL_FX_RT_FLG" ).append("\n"); 
		query.append("  FROM SPC_ALOC_CTRL_OPT T" ).append("\n"); 
		query.append(" WHERE T.RLANE_CD   = @[lane]" ).append("\n"); 
		query.append("   AND T.DIR_CD     = @[bound]" ).append("\n"); 
		query.append("   AND T.VSL_CD     = SUBSTR(@[vvd], 0, 4)" ).append("\n"); 
		query.append("   AND T.SKD_VOY_NO = SUBSTR(@[vvd], 5, 4)" ).append("\n"); 
		query.append("   AND T.SKD_DIR_CD = SUBSTR(@[vvd], 9)" ).append("\n"); 

	}
}