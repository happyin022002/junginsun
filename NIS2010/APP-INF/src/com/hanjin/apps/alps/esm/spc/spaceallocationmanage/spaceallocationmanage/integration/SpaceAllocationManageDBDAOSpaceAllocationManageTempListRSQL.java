/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : SpaceAllocationManageDBDAOSpaceAllocationManageTempListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.01.05
*@LastModifier : 최윤성
*@LastVersion : 1.0
* 2011.01.05 최윤성
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.spc.spaceallocationmanage.spaceallocationmanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author CHOI Yun Sung
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SpaceAllocationManageDBDAOSpaceAllocationManageTempListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SpaceAllocationManage의 데이타 모델에 해당되는 값을 불러온다.
	  * 2011.01.04 최윤성 [CHM-201008093-01] Office Level Table 생성
	  *  - SPC_ORGANIZATION_V 대신 SPC_OFC_LVL 로 대체
	  * </pre>
	  */
	public SpaceAllocationManageDBDAOSpaceAllocationManageTempListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("ts_flg",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("pod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("Path : com.hanjin.apps.alps.esm.spc.spaceallocationmanage.spaceallocationmanage.integration").append("\n"); 
		query.append("FileName : SpaceAllocationManageDBDAOSpaceAllocationManageTempListRSQL").append("\n"); 
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
		query.append("SELECT O.OFC_CD," ).append("\n"); 
		query.append("       DECODE(A.RLANE_CD, NULL, 'N', 'Y') AS FLAG" ).append("\n"); 
		query.append("  FROM SPC_OFC_LVL      O," ).append("\n"); 
		query.append("       SPC_ALOC_POL_POD A," ).append("\n"); 
		query.append("       MAS_MON_VVD      C" ).append("\n"); 
		query.append(" WHERE O.N4TH_PRNT_OFC_CD  = @[ofc_cd]" ).append("\n"); 
		query.append("   AND O.N6TH_PRNT_OFC_CD IS NULL" ).append("\n"); 
		query.append("   AND O.OFC_CD           <> O.N4TH_PRNT_OFC_CD" ).append("\n"); 
		query.append("   AND O.OFC_CD            = A.SLS_OFC_CD(+)" ).append("\n"); 
		query.append("   AND A.MNL_FLG   (+)     = 'Y'" ).append("\n"); 
		query.append("   AND A.RLANE_CD  (+)     = @[rlane_cd]" ).append("\n"); 
		query.append("   AND A.DIR_CD    (+)     = @[dir_cd]" ).append("\n"); 
		query.append("   AND A.VSL_CD    (+)     = @[vsl_cd]" ).append("\n"); 
		query.append("   AND A.SKD_VOY_NO(+)     = @[skd_voy_no]" ).append("\n"); 
		query.append("   AND A.SKD_DIR_CD(+)     = @[skd_dir_cd]" ).append("\n"); 
		query.append("   AND A.POL_YD_CD (+)     = @[pol_cd]" ).append("\n"); 
		query.append("   AND A.POD_YD_CD (+)     = @[pod_cd]" ).append("\n"); 
		query.append("   AND A.TS_FLG    (+)     = @[ts_flg]" ).append("\n"); 
		query.append("   AND C.TRD_CD            = @[trd_cd]" ).append("\n"); 
		query.append("   AND C.RLANE_CD          = @[rlane_cd]" ).append("\n"); 
		query.append("   AND C.IOC_CD            = DECODE(@[ioc_cd], 'OCN', 'O', 'I')" ).append("\n"); 
		query.append("   AND C.VSL_CD            = @[vsl_cd]" ).append("\n"); 
		query.append("   AND C.SKD_VOY_NO        = @[skd_voy_no]" ).append("\n"); 
		query.append("   AND C.DIR_CD            = @[skd_dir_cd]" ).append("\n"); 
		query.append("   AND SUBSTR(C.SLS_YRMON, 1, 4) || C.COST_WK BETWEEN O.OFC_APLY_FM_YRWK AND O.OFC_APLY_TO_YRWK" ).append("\n"); 

	}
}
