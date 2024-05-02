/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : SpaceAllocationManageDBDAODeleteTargetCustAllocDSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.02.11
*@LastModifier : 최윤성
*@LastVersion : 1.0
* 2014.02.11 최윤성
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

public class SpaceAllocationManageDBDAODeleteTargetCustAllocDSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Season 내 first version의 적용 시작 주차 이후에 기입력되어 있는 Alloc을 삭제합니다.
	  * 
	  * 2014.01.03 진마리아 [SRM-201341166] Yield Group의 확대
	  * </pre>
	  */
	public SpaceAllocationManageDBDAODeleteTargetCustAllocDSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("ver_st_yrwk",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.spc.spaceallocationmanage.spaceallocationmanage.integration").append("\n"); 
		query.append("FileName : SpaceAllocationManageDBDAODeleteTargetCustAllocDSQL").append("\n"); 
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
		query.append("DELETE" ).append("\n"); 
		query.append("  FROM SPC_ALOC_CUST_POL_POD A" ).append("\n"); 
		query.append(" WHERE (A.RLANE_CD, A.DIR_CD, A.VSL_CD, A.SKD_VOY_NO, A.SKD_DIR_CD, A.IOC_CD) IN (SELECT C.RLANE_CD, C.DIR_CD, C.VSL_CD, C.SKD_VOY_NO, C.DIR_CD, C.IOC_CD" ).append("\n"); 
		query.append("                                                                                    FROM MAS_MON_VVD C" ).append("\n"); 
		query.append("                                                                                   WHERE A.RLANE_CD   = C.RLANE_CD" ).append("\n"); 
		query.append("                                                                                     AND A.DIR_CD     = C.DIR_CD" ).append("\n"); 
		query.append("                                                                                     AND A.VSL_CD     = C.VSL_CD" ).append("\n"); 
		query.append("                                                                                     AND A.SKD_VOY_NO = C.SKD_VOY_NO" ).append("\n"); 
		query.append("                                                                                     AND A.SKD_DIR_CD = C.DIR_CD" ).append("\n"); 
		query.append("                                                                                     AND A.IOC_CD     = C.IOC_CD" ).append("\n"); 
		query.append("                                                                                     AND A.TRD_CD     = C.TRD_CD" ).append("\n"); 
		query.append("                                                                                     AND A.REP_TRD_CD = @[trd_cd]" ).append("\n"); 
		query.append("                                                                                     --AND C.IOC_CD     = 'O'" ).append("\n"); 
		query.append("                                                                                     AND C.DELT_FLG   = 'N'" ).append("\n"); 
		query.append("                                                                                     AND SUBSTR(C.SLS_YRMON,1,4)||C.COST_WK >= @[ver_st_yrwk]" ).append("\n"); 
		query.append("                                                                                 )" ).append("\n"); 
		query.append("   AND NVL(A.CUST_CTRL_CD,' ') <> 'C'" ).append("\n"); 

	}
}
