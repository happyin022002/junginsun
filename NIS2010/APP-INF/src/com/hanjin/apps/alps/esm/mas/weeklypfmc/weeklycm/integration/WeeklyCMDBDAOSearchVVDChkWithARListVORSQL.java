/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : WeeklyCMDBDAOSearchVVDChkWithARListVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.15
*@LastModifier : 박수훈
*@LastVersion : 1.0
* 2009.10.15 박수훈
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.mas.weeklypfmc.weeklycm.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author SOO HOON PARK
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class WeeklyCMDBDAOSearchVVDChkWithARListVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * mas_mon_vvd 테이블에서 Month VVD 정보를 조회   
	  * </pre>
	  */
	public WeeklyCMDBDAOSearchVVDChkWithARListVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_cost_fm_mon",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_cost_yr",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.mas.weeklypfmc.weeklycm.integration").append("\n"); 
		query.append("FileName : WeeklyCMDBDAOSearchVVDChkWithARListVORSQL").append("\n"); 
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
		query.append("SELECT   DECODE(A.TRD_CD    ,NULL, 'A', DECODE(B.TRD_CD, NULL, 'C' ,'B'   ) ) RSLT_CD /* C:MAS ONLY, B:BOTH */" ).append("\n"); 
		query.append(",DECODE(A.TRD_CD    ,NULL, 'AR Only', DECODE(B.TRD_CD, NULL, 'MAS Only', 'BOTH') ) RSLT" ).append("\n"); 
		query.append(",NVL(A.TRD_CD       , B.TRD_CD                  ) TRD_CD" ).append("\n"); 
		query.append(",NVL(A.RLANE_CD     , B.RLANE_CD                ) RLANE_CD" ).append("\n"); 
		query.append(",NVL(A.IOC_CD       , B.IOC_CD                  ) IOC_CD" ).append("\n"); 
		query.append(",NVL(A.VSL_CD       , B.VSL_CD                  ) VSL_CD" ).append("\n"); 
		query.append(",NVL(A.SKD_VOY_NO   , B.SKD_VOY_NO              ) SKD_VOY_NO" ).append("\n"); 
		query.append(",NVL(A.DIR_CD       , B.DIR_CD                  ) DIR_CD" ).append("\n"); 
		query.append(",NVL(A.VSL_CD       , B.VSL_CD                  )||" ).append("\n"); 
		query.append("NVL(A.SKD_VOY_NO   , B.SKD_VOY_NO              )||" ).append("\n"); 
		query.append("NVL(A.DIR_CD       , B.DIR_CD                  ) VVD" ).append("\n"); 
		query.append(",NVL(A.SLAN_CD      , B.SLAN_CD                 ) SLAN_CD" ).append("\n"); 
		query.append(",NVL(A.MON_TGT_FLG  , NULL                      ) MON_TGT_FLG" ).append("\n"); 
		query.append(",NVL(A.DELT_FLG     , NULL                      ) DELT_FLG" ).append("\n"); 
		query.append(",NVL(A.COST_YRMON   , NULL                      ) COST_YRMON" ).append("\n"); 
		query.append(",NVL(A.COST_WK      , NULL                      ) COST_WK" ).append("\n"); 
		query.append(",NVL(A.LST_LODG_PORT_CD, B.LST_LODG_PORT_CD  ) LST_LODG_PORT_CD" ).append("\n"); 
		query.append("FROM  (SELECT TRD_CD     		, RLANE_CD  	, IOC_CD" ).append("\n"); 
		query.append(",VSL_CD     		, SKD_VOY_NO	, DIR_CD" ).append("\n"); 
		query.append(",COST_YRMON 		, COST_WK   	, SLAN_CD" ).append("\n"); 
		query.append(",LST_LODG_PORT_CD, MON_TGT_FLG	, DELT_FLG" ).append("\n"); 
		query.append("FROM  MAS_MON_VVD" ).append("\n"); 
		query.append("WHERE  RLANE_CD   <>      'RBCCO'" ).append("\n"); 
		query.append(") A" ).append("\n"); 
		query.append("RIGHT OUTER JOIN  /* AR ONLY 찾기 위해(MAS_MON_VVD_IF 에만 있는 항차)*/" ).append("\n"); 
		query.append("(SELECT TRD_CD     , RLANE_CD  , IOC_CD" ).append("\n"); 
		query.append(",VSL_CD     , SKD_VOY_NO, DIR_CD" ).append("\n"); 
		query.append(",COST_YRMON , COST_WK   , SLAN_CD" ).append("\n"); 
		query.append(",LST_LODG_PORT_CD" ).append("\n"); 
		query.append("FROM MAS_MON_VVD_IF" ).append("\n"); 
		query.append("WHERE RLANE_CD   <>      'RBCCO'" ).append("\n"); 
		query.append("AND COST_YRMON = @[f_cost_yr]||@[f_cost_fm_mon]" ).append("\n"); 
		query.append(") B" ).append("\n"); 
		query.append("ON (    A.TRD_CD     = B.TRD_CD" ).append("\n"); 
		query.append("AND A.RLANE_CD   = B.RLANE_CD" ).append("\n"); 
		query.append("AND A.IOC_CD     = B.IOC_CD" ).append("\n"); 
		query.append("AND A.VSL_CD     = B.VSL_CD" ).append("\n"); 
		query.append("AND A.SKD_VOY_NO = B.SKD_VOY_NO" ).append("\n"); 
		query.append("AND A.DIR_CD     = B.DIR_CD     )" ).append("\n"); 
		query.append("UNION	 /* MAS ONLY를 위해 */" ).append("\n"); 
		query.append("SELECT  DECODE(A.TRD_CD    , NULL, 'A'       ," ).append("\n"); 
		query.append("DECODE(B.TRD_CD    , NULL, 'C'       , 'B'   ) ) RSLT_CD" ).append("\n"); 
		query.append(",DECODE(A.TRD_CD    , NULL, 'AR Only' ," ).append("\n"); 
		query.append("DECODE(B.TRD_CD    , NULL, 'MAS Only', 'BOTH') ) RSLT" ).append("\n"); 
		query.append(",NVL(A.TRD_CD       , B.TRD_CD                  ) TRD_CD" ).append("\n"); 
		query.append(",NVL(A.RLANE_CD     , B.RLANE_CD                ) RLANE_CD" ).append("\n"); 
		query.append(",NVL(A.IOC_CD       , B.IOC_CD                  ) IOC_CD" ).append("\n"); 
		query.append(",NVL(A.VSL_CD       , B.VSL_CD                  ) VSL_CD" ).append("\n"); 
		query.append(",NVL(A.SKD_VOY_NO   , B.SKD_VOY_NO              ) SKD_VOY_NO" ).append("\n"); 
		query.append(",NVL(A.DIR_CD       , B.DIR_CD                  ) DIR_CD" ).append("\n"); 
		query.append(",NVL(A.VSL_CD       , B.VSL_CD                  )||" ).append("\n"); 
		query.append("NVL(A.SKD_VOY_NO   , B.SKD_VOY_NO              )||" ).append("\n"); 
		query.append("NVL(A.DIR_CD       , B.DIR_CD                  ) VVD" ).append("\n"); 
		query.append(",NVL(A.SLAN_CD      , B.SLAN_CD                 ) SLAN_CD" ).append("\n"); 
		query.append(",NVL(A.MON_TGT_FLG  , NULL                      ) MON_TGT_FLG" ).append("\n"); 
		query.append(",NVL(A.DELT_FLG     , NULL                      ) DELT_FLG" ).append("\n"); 
		query.append(",NVL(A.COST_YRMON   , NULL                      ) COST_YRMON" ).append("\n"); 
		query.append(",NVL(A.COST_WK      , NULL                      ) COST_WK" ).append("\n"); 
		query.append(",NVL(A.LST_LODG_PORT_CD, B.LST_LODG_PORT_CD  ) LST_LODG_PORT_CD" ).append("\n"); 
		query.append("FROM   (SELECT TRD_CD     		, RLANE_CD  	, IOC_CD" ).append("\n"); 
		query.append(",VSL_CD     		, SKD_VOY_NO	, DIR_CD" ).append("\n"); 
		query.append(",COST_YRMON 		, COST_WK   	, SLAN_CD" ).append("\n"); 
		query.append(",LST_LODG_PORT_CD, MON_TGT_FLG	, DELT_FLG" ).append("\n"); 
		query.append("FROM MAS_MON_VVD" ).append("\n"); 
		query.append("WHERE RLANE_CD   <>      'RBCCO'" ).append("\n"); 
		query.append("AND COST_YRMON = @[f_cost_yr]||@[f_cost_fm_mon]" ).append("\n"); 
		query.append("AND DELT_FLG   =       'N'" ).append("\n"); 
		query.append(") A" ).append("\n"); 
		query.append("LEFT OUTER JOIN" ).append("\n"); 
		query.append("(SELECT TRD_CD     , RLANE_CD  , IOC_CD" ).append("\n"); 
		query.append(",VSL_CD     , SKD_VOY_NO, DIR_CD" ).append("\n"); 
		query.append(",COST_YRMON , COST_WK   , SLAN_CD" ).append("\n"); 
		query.append(",LST_LODG_PORT_CD" ).append("\n"); 
		query.append("FROM MAS_MON_VVD_IF" ).append("\n"); 
		query.append("WHERE RLANE_CD   <>      'RBCCO'" ).append("\n"); 
		query.append("AND COST_YRMON = @[f_cost_yr]||@[f_cost_fm_mon]" ).append("\n"); 
		query.append(") B" ).append("\n"); 
		query.append("ON (    A.TRD_CD     = B.TRD_CD" ).append("\n"); 
		query.append("AND A.RLANE_CD   = B.RLANE_CD" ).append("\n"); 
		query.append("AND A.IOC_CD     = B.IOC_CD" ).append("\n"); 
		query.append("AND A.VSL_CD     = B.VSL_CD" ).append("\n"); 
		query.append("AND A.SKD_VOY_NO = B.SKD_VOY_NO" ).append("\n"); 
		query.append("AND A.DIR_CD     = B.DIR_CD     )" ).append("\n"); 
		query.append("ORDER BY RSLT_CD" ).append("\n"); 

	}
}