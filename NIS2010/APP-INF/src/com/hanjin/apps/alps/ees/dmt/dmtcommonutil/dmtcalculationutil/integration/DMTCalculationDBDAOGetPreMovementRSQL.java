/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : DMTCalculationDBDAOGetPreMovementRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.03.05
*@LastModifier : 임창빈
*@LastVersion : 1.0
* 2014.03.05 임창빈
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.dmt.dmtcommonutil.dmtcalculationutil.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Lim Chang Bin
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class DMTCalculationDBDAOGetPreMovementRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * getPreMovement
	  * </pre>
	  */
	public DMTCalculationDBDAOGetPreMovementRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cnmv_yy",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cnmv_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cnmv_split",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.dmt.dmtcommonutil.dmtcalculationutil.integration").append("\n"); 
		query.append("FileName : DMTCalculationDBDAOGetPreMovementRSQL").append("\n"); 
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
		query.append("SELECT    PRE_BKG_NO" ).append("\n"); 
		query.append("        , PRE_CNMV_YY" ).append("\n"); 
		query.append("        , PRE_CNMV_SEQ" ).append("\n"); 
		query.append("        , PRE_CNMV_SPLIT" ).append("\n"); 
		query.append("        , PRE_CNMS_CD" ).append("\n"); 
		query.append("        , PRE_ORG_YD_CD" ).append("\n"); 
		query.append("        , PRE_CNMV_DT_TM" ).append("\n"); 
		query.append("        , PRE_FULL_FLG" ).append("\n"); 
		query.append("        , CASE WHEN CUR_MVMT_CNT = 0 AND PRE_OP_CNT = 1 AND PRE_VL_MT_CNT = 0 THEN" ).append("\n"); 
		query.append("               /* CURRENT MVMT에 OP 가 없고, 이전 MVMT에 OP가 존재하고, 이전 MVMT CYCLE 내에 VL, MT가 없을 경우에 */" ).append("\n"); 
		query.append("               /* 이전 OP 정보를 VL과 쌍을 만들어서  COMPLETE 할 수 있도록 한다.                                 */" ).append("\n"); 
		query.append("                PRE_CNMV_CYC_NO - 1" ).append("\n"); 
		query.append("            ELSE" ).append("\n"); 
		query.append("                /* DEFALUT */" ).append("\n"); 
		query.append("                PRE_CNMV_CYC_NO" ).append("\n"); 
		query.append("          END                                   AS PRE_CNMV_CYC_NO" ).append("\n"); 
		query.append("        , PRE_CNMV_CYC_NO                       AS BH_PRE_CNMV_CYC_NO -- (복화 운송(Backhauling)( ID-OC ) :  OC로 이전 ID Cycle No를 찾아 맵핑 )" ).append("\n"); 
		query.append("FROM    (" ).append("\n"); 
		query.append("        SELECT	/*+ INDEX_DESC( M XFN1CTM_MOVEMENT ) */" ).append("\n"); 
		query.append("                M.BKG_NO            PRE_BKG_NO," ).append("\n"); 
		query.append("        		M.CNMV_YR			PRE_CNMV_YY," ).append("\n"); 
		query.append("        		M.CNMV_SEQ			PRE_CNMV_SEQ," ).append("\n"); 
		query.append("        		M.CNMV_SPLIT_NO		PRE_CNMV_SPLIT," ).append("\n"); 
		query.append("        		M.MVMT_STS_CD		PRE_CNMS_CD," ).append("\n"); 
		query.append("        		M.ORG_YD_CD			PRE_ORG_YD_CD," ).append("\n"); 
		query.append("        		TO_CHAR(M.CNMV_EVNT_DT, 'YYYYMMDDHH24MI') PRE_CNMV_DT_TM," ).append("\n"); 
		query.append("        		M.FCNTR_FLG			PRE_FULL_FLG," ).append("\n"); 
		query.append("        		M.CNMV_CYC_NO		PRE_CNMV_CYC_NO, " ).append("\n"); 
		query.append("                (" ).append("\n"); 
		query.append("                    SELECT  COUNT(*)" ).append("\n"); 
		query.append("                    FROM    CTM_MOVEMENT S" ).append("\n"); 
		query.append("                    WHERE   S.CNTR_NO       = M.CNTR_NO" ).append("\n"); 
		query.append("                    AND     S.CNMV_CYC_NO   = M.CNMV_CYC_NO" ).append("\n"); 
		query.append("                    AND     S.MVMT_STS_CD   = 'OP'" ).append("\n"); 
		query.append("                ) CUR_MVMT_CNT," ).append("\n"); 
		query.append("                (" ).append("\n"); 
		query.append("                    SELECT  COUNT(*)" ).append("\n"); 
		query.append("                    FROM    CTM_MOVEMENT S" ).append("\n"); 
		query.append("                    WHERE   S.CNTR_NO       = M.CNTR_NO" ).append("\n"); 
		query.append("                    AND     S.CNMV_CYC_NO   = M.CNMV_CYC_NO - 1" ).append("\n"); 
		query.append("                    AND     S.MVMT_STS_CD   = 'OP'" ).append("\n"); 
		query.append("                ) PRE_OP_CNT," ).append("\n"); 
		query.append("                (" ).append("\n"); 
		query.append("                    SELECT  COUNT(*)" ).append("\n"); 
		query.append("                    FROM    CTM_MOVEMENT S" ).append("\n"); 
		query.append("                    WHERE   S.CNTR_NO       = M.CNTR_NO" ).append("\n"); 
		query.append("                    AND     S.CNMV_CYC_NO   = M.CNMV_CYC_NO - 1" ).append("\n"); 
		query.append("                    AND     S.MVMT_STS_CD   IN ( 'VL', 'MT')" ).append("\n"); 
		query.append("                ) PRE_VL_MT_CNT," ).append("\n"); 
		query.append("                (" ).append("\n"); 
		query.append("                    SELECT  COUNT(*)" ).append("\n"); 
		query.append("                    FROM    CTM_MOVEMENT S" ).append("\n"); 
		query.append("                    WHERE   S.CNTR_NO       = M.CNTR_NO" ).append("\n"); 
		query.append("                    AND     S.CNMV_CYC_NO   = M.CNMV_CYC_NO - 1" ).append("\n"); 
		query.append("                    AND     S.MVMT_STS_CD   NOT IN ( 'VL', 'MT')" ).append("\n"); 
		query.append("                ) PRE_MVMT_NOT_VL_MT_CNT" ).append("\n"); 
		query.append("        FROM   CTM_MOVEMENT   M" ).append("\n"); 
		query.append("        WHERE  M.CNTR_NO        = @[cntr_no]" ).append("\n"); 
		query.append("        AND     M.CNMV_YR||TO_CHAR(M.CNMV_SEQ,'FM0000')||M.CNMV_SPLIT_NO < @[cnmv_yy]||TO_CHAR(TO_NUMBER(@[cnmv_seq]),'FM0000')||@[cnmv_split]  " ).append("\n"); 
		query.append("        AND     ROWNUM          = 1" ).append("\n"); 
		query.append("        )" ).append("\n"); 
		query.append("WHERE   1=1" ).append("\n"); 

	}
}