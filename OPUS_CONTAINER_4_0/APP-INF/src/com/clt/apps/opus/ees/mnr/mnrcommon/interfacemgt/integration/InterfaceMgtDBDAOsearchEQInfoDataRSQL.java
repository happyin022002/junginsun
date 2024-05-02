/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : InterfaceMgtDBDAOsearchEQInfoDataRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.12.15
*@LastModifier : 
*@LastVersion : 1.0
* 2016.12.15 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.mnr.mnrcommon.interfacemgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class InterfaceMgtDBDAOsearchEQInfoDataRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * DESC Enter..
	  * </pre>
	  */
	public InterfaceMgtDBDAOsearchEQInfoDataRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("total_loss_date",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eq_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.mnr.mnrcommon.interfacemgt.integration").append("\n"); 
		query.append("FileName : InterfaceMgtDBDAOsearchEQInfoDataRSQL").append("\n"); 
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
		query.append("SELECT ACT_IND," ).append("\n"); 
		query.append("       EQ_TYPE," ).append("\n"); 
		query.append("       EQ_TPSZ_CD," ).append("\n"); 
		query.append("       EQ_NO," ).append("\n"); 
		query.append("       (SELECT NVL(DECODE(FULL_FLG, 'Y', 'F', 'E'), '')" ).append("\n"); 
		query.append("          FROM MST_CONTAINER" ).append("\n"); 
		query.append("         WHERE CNTR_NO = @[eq_no]) CNTR_STS_CD" ).append("\n"); 
		query.append("  FROM MNR_EQ_STS_V" ).append("\n"); 
		query.append(" WHERE 1=1" ).append("\n"); 
		query.append("   AND EQ_NO = @[eq_no]" ).append("\n"); 
		query.append("#if(${knd_cd} == 'S')" ).append("\n"); 
		query.append("   AND CASE WHEN    " ).append("\n"); 
		query.append("            (SELECT LSTM_CD " ).append("\n"); 
		query.append("               FROM LSE_AGREEMENT" ).append("\n"); 
		query.append("              WHERE (AGMT_CTY_CD, AGMT_SEQ) = ( SELECT /*+ INDEX_DESC (A XAK1MST_CNTR_STS_HIS) */ AGMT_CTY_CD, AGMT_SEQ" ).append("\n"); 
		query.append("                                                  FROM MST_CNTR_STS_HIS A" ).append("\n"); 
		query.append("                                                 WHERE A.CNTR_NO = @[eq_no]" ).append("\n"); 
		query.append("                                                   AND A.CNTR_STS_EVNT_DT <= TO_DATE(@[total_loss_date], 'YYYYMMDD')" ).append("\n"); 
		query.append("                                                   AND ROWNUM = 1)) = 'SH' THEN CASE WHEN " ).append("\n"); 
		query.append("                                                                                  EXISTS (SELECT 'X'" ).append("\n"); 
		query.append("                                                                                            FROM MST_CNTR_STS_HIS A" ).append("\n"); 
		query.append("                                                                                           WHERE A.CNTR_NO = @[eq_no]" ).append("\n"); 
		query.append("                                                                                             AND A.CNTR_STS_EVNT_DT = TO_DATE(@[total_loss_date], 'YYYYMMDD')" ).append("\n"); 
		query.append("                                                                                             AND A.CNTR_STS_CD = 'SBO' " ).append("\n"); 
		query.append("                                                                                          ) THEN 'HH' ELSE 'SH' END" ).append("\n"); 
		query.append("                                                                    ELSE CASE WHEN " ).append("\n"); 
		query.append("                                                                         (SELECT /*+ INDEX_DESC (A XAK1MST_CNTR_STS_HIS) */ CNTR_STS_CD" ).append("\n"); 
		query.append("                                                                            FROM MST_CNTR_STS_HIS A" ).append("\n"); 
		query.append("                                                                           WHERE A.CNTR_NO = @[eq_no]" ).append("\n"); 
		query.append("                                                                             AND A.CNTR_STS_EVNT_DT <= TO_DATE(@[total_loss_date], 'YYYYMMDD')" ).append("\n"); 
		query.append("                                                                             AND ROWNUM = 1) IN ('LSO', 'SBO', 'MUO') THEN CASE WHEN " ).append("\n"); 
		query.append("                                                                                                                           (SELECT /*+ INDEX_DESC (A XAK1MST_CNTR_STS_HIS) */ CNTR_STS_CD" ).append("\n"); 
		query.append("                                                                                                                              FROM MST_CNTR_STS_HIS A" ).append("\n"); 
		query.append("                                                                                                                             WHERE A.CNTR_NO = @[eq_no]" ).append("\n"); 
		query.append("                                                                                                                               AND A.CNTR_STS_EVNT_DT = TO_DATE(@[total_loss_date], 'YYYYMMDD')" ).append("\n"); 
		query.append("                                                                                                                               AND ROWNUM = 1" ).append("\n"); 
		query.append("                                                                                                                               ) IN ('LSO', 'SBO', 'MUO') THEN 'HH' ELSE 'SH' END ELSE 'HH' END END <> 'SH'" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("AND 'XX' <> (CASE WHEN (SELECT /*+ INDEX_ASC (A XUK1CTM_MOVEMENT) */" ).append("\n"); 
		query.append("                                MVMT_STS_CD" ).append("\n"); 
		query.append("                            FROM CTM_MOVEMENT A" ).append("\n"); 
		query.append("                           WHERE CNTR_NO = @[eq_no]" ).append("\n"); 
		query.append("                             AND TO_CHAR(CNMV_EVNT_DT, 'YYYYMMDD') = @[total_loss_date]" ).append("\n"); 
		query.append("                             AND ROWNUM = 1) = 'XX' THEN 'XX'" ).append("\n"); 
		query.append("                    ELSE CASE WHEN (SELECT /*+ INDEX_DESC (A XUK1CTM_MOVEMENT) */" ).append("\n"); 
		query.append("                                           MVMT_STS_CD" ).append("\n"); 
		query.append("                                       FROM CTM_MOVEMENT A" ).append("\n"); 
		query.append("                                      WHERE CNTR_NO = @[eq_no]" ).append("\n"); 
		query.append("                                        AND TO_CHAR(CNMV_EVNT_DT, 'YYYYMMDD') <= @[total_loss_date]" ).append("\n"); 
		query.append("                                        AND ROWNUM = 1) = 'XX' THEN 'XX' ELSE 'HH' END END)" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}