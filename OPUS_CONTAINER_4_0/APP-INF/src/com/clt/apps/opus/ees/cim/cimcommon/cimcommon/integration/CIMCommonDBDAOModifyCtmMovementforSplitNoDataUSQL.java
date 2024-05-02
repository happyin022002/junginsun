/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : CIMCommonDBDAOModifyCtmMovementforSplitNoDataUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.10.28
*@LastModifier : 
*@LastVersion : 1.0
* 2015.10.28 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.cim.cimcommon.cimcommon.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CIMCommonDBDAOModifyCtmMovementforSplitNoDataUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ModifyCtmMovementforSplitNoData
	  * </pre>
	  */
	public CIMCommonDBDAOModifyCtmMovementforSplitNoDataUSQL(){
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

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.cim.cimcommon.cimcommon.integration").append("\n"); 
		query.append("FileName : CIMCommonDBDAOModifyCtmMovementforSplitNoDataUSQL").append("\n"); 
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
		query.append("UPDATE CTM_MOVEMENT CM" ).append("\n"); 
		query.append("SET CM.CNMV_SPLIT_NO = ( SELECT DECODE(SUB.CNT, 1, ' ', SUB.NEW_SPLIT_NO) " ).append("\n"); 
		query.append("                                      FROM (" ).append("\n"); 
		query.append("                                                SELECT SCM.CNTR_NO" ).append("\n"); 
		query.append("                                                        , SCM.CNMV_YR" ).append("\n"); 
		query.append("                                                        , SCM.CNMV_ID_NO" ).append("\n"); 
		query.append("                                                        , SCM.CNMV_SEQ" ).append("\n"); 
		query.append("                                                        , SCM.CNMV_SPLIT_NO" ).append("\n"); 
		query.append("                                                        , CHK.CNT" ).append("\n"); 
		query.append("                                                        , DECODE(ROW_NUMBER() OVER (PARTITION BY SCM.CNTR_NO, SCM.CNMV_YR, SCM.CNMV_SEQ" ).append("\n"); 
		query.append("                                                                                                  ORDER BY SCM.CNTR_NO, SCM.CNMV_YR, SCM.CNMV_SEQ, SCM.CNMV_EVNT_DT), 1, 'A'" ).append("\n"); 
		query.append("                                                                                                                                          , 2, 'B'" ).append("\n"); 
		query.append("                                                                                                                                          , 3, 'C'" ).append("\n"); 
		query.append("                                                                                                                                          , 4, 'D'" ).append("\n"); 
		query.append("                                                                                                                                          , 5, 'E'" ).append("\n"); 
		query.append("                                                                                                                                          , 6, 'F'" ).append("\n"); 
		query.append("                                                                                                                                          , 7, 'G'" ).append("\n"); 
		query.append("                                                                                                                                          , 8, 'H'" ).append("\n"); 
		query.append("                                                                                                                                          , 9, 'I'" ).append("\n"); 
		query.append("                                                                                                                                          , 10, 'J'" ).append("\n"); 
		query.append("                                                                                                                                          , 11, 'K'" ).append("\n"); 
		query.append("                                                                                                                                          , 12, 'L'" ).append("\n"); 
		query.append("                                                                                                                                          , 13, 'M'" ).append("\n"); 
		query.append("                                                                                                                                          , 14, 'N'" ).append("\n"); 
		query.append("                                                                                                                                          , 15, 'O'" ).append("\n"); 
		query.append("                                                                                                                                          , 16, 'P'" ).append("\n"); 
		query.append("                                                                                                                                          , 17, 'Q'" ).append("\n"); 
		query.append("                                                                                                                                          , 18, 'R'" ).append("\n"); 
		query.append("                                                                                                                                          , 19, 'S'" ).append("\n"); 
		query.append("                                                                                                                                          , 20, 'T'" ).append("\n"); 
		query.append("                                                                                                                                          , 21, 'U'" ).append("\n"); 
		query.append("                                                                                                                                          , 22, 'V'" ).append("\n"); 
		query.append("                                                                                                                                          , 23, 'W'" ).append("\n"); 
		query.append("                                                                                                                                          , 24, 'X'" ).append("\n"); 
		query.append("                                                                                                                                          , 25, 'Y'" ).append("\n"); 
		query.append("                                                                                                                                          , 26, 'Z')  AS NEW_SPLIT_NO                                                                                  " ).append("\n"); 
		query.append("                                                FROM CTM_MOVEMENT SCM" ).append("\n"); 
		query.append("                                                      , (SELECT CHK.CNTR_NO" ).append("\n"); 
		query.append("                                                               ,  CHK.CNMV_YR" ).append("\n"); 
		query.append("                                                               ,  CHK.CNMV_SEQ" ).append("\n"); 
		query.append("                                                               ,  COUNT(*) AS CNT" ).append("\n"); 
		query.append("                                                          FROM CTM_MOVEMENT CHK" ).append("\n"); 
		query.append("                                                         WHERE CHK.CNTR_NO = @[cntr_no]" ).append("\n"); 
		query.append("                                                     GROUP BY CHK.CNTR_NO, CHK.CNMV_YR, CHK.CNMV_SEQ) CHK                                                     " ).append("\n"); 
		query.append("                                                WHERE CHK.CNTR_NO   = SCM.CNTR_NO" ).append("\n"); 
		query.append("                                                   AND CHK.CNMV_YR   = SCM.CNMV_YR" ).append("\n"); 
		query.append("                                                   AND CHK.CNMV_SEQ = SCM.CNMV_SEQ) SUB" ).append("\n"); 
		query.append("                                    WHERE CM.CNTR_NO          = SUB.CNTR_NO" ).append("\n"); 
		query.append("                                       AND CM.CNMV_YR          = SUB.CNMV_YR" ).append("\n"); 
		query.append("                                       AND CM.CNMV_ID_NO     = SUB.CNMV_ID_NO" ).append("\n"); 
		query.append("                                       AND CM.CNMV_SEQ        = SUB.CNMV_SEQ" ).append("\n"); 
		query.append("                                       AND CM.CNMV_SPLIT_NO  = SUB.CNMV_SPLIT_NO) " ).append("\n"); 
		query.append("WHERE CM.CNTR_NO = @[cntr_no]" ).append("\n"); 
		query.append("AND    EXISTS ( SELECT 'X'" ).append("\n"); 
		query.append("                     FROM  CTM_MOVEMENT SCM" ).append("\n"); 
		query.append("                    WHERE  CM.CNTR_NO = SCM.CNTR_NO" ).append("\n"); 
		query.append("                        AND SCM.CNMV_SPLIT_NO = '1')" ).append("\n"); 

	}
}