/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : CommonDBDAOSearchSaqCfmQtaAdjListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.03.04
*@LastModifier : 
*@LastVersion : 1.0
* 2011.03.04 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.saq.common.common.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CommonDBDAOSearchSaqCfmQtaAdjListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 분기 S.Rep : T/B/L/RGN 확정쿼타중 사후 조정된 데이터의 존재 유무를 체크한다.
	  * </pre>
	  */
	public CommonDBDAOSearchSaqCfmQtaAdjListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mqtaRlseVerNo",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("qtaTgtCd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trdCd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rlaneCd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dirCd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rgnOfcCd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.saq.common.common.integration").append("\n"); 
		query.append("FileName : CommonDBDAOSearchSaqCfmQtaAdjListRSQL").append("\n"); 
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
		query.append("" ).append("\n"); 
		query.append("SELECT  DECODE(COUNT(1), 0, 'N', 'Y') AS CODE ,  " ).append("\n"); 
		query.append("        DECODE(COUNT(1), 0, 'N', 'Y') AS TEXT    " ).append("\n"); 
		query.append("FROM    SAQ_MON_CFM_QTA                          " ).append("\n"); 
		query.append("WHERE   1 = 1                                    " ).append("\n"); 
		query.append("AND     MQTA_RLSE_VER_NO    = @[mqtaRlseVerNo]                  " ).append("\n"); 
		query.append("AND     QTA_TGT_CD          = @[qtaTgtCd]                  " ).append("\n"); 
		query.append("AND     TRD_CD              = @[trdCd]                  " ).append("\n"); 
		query.append("AND     RLANE_CD            LIKE @[rlaneCd] || '%'        " ).append("\n"); 
		query.append("AND     DIR_CD              = @[dirCd]                  " ).append("\n"); 
		query.append("AND     RGN_OFC_CD          = @[rgnOfcCd]                  " ).append("\n"); 
		query.append("AND     COST_UPD_FLG        = 'Y'                                                    " ).append("\n"); 

	}
}