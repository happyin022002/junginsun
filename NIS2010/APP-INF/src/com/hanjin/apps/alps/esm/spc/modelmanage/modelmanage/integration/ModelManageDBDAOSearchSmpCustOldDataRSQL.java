/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : ModelManageDBDAOSearchSmpCustOldDataRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.05.23
*@LastModifier : 
*@LastVersion : 1.0
* 2014.05.23 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.spc.modelmanage.modelmanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ModelManageDBDAOSearchSmpCustOldDataRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SMP Cust History를 위해 old 값을 조회합니다.
	  * [CHM-201322502-01] SPC 프로젝트 - 성수기 선복운영 개선을 위한 T/F추진
	  * 2014.02.04 [CHM-201428383-01] RFA 로직 추가
	  * 2014.05.16 [CHM-201430353] SMP / AES 보완요청 - SC 입력 기능 추가
	  * </pre>
	  */
	public ModelManageDBDAOSearchSmpCustOldDataRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("old_ver",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cust_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ver_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cost_yrwk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sc_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_ctrl_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rfa_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("wk_mqc_qty",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.spc.modelmanage.modelmanage.integration").append("\n"); 
		query.append("FileName : ModelManageDBDAOSearchSmpCustOldDataRSQL").append("\n"); 
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
		query.append("SELECT A.TRD_CD" ).append("\n"); 
		query.append("      ,A.COST_YRWK" ).append("\n"); 
		query.append("      ,A.VER_SEQ" ).append("\n"); 
		query.append("      ,A.CUST_CD" ).append("\n"); 
		query.append("      ,A.SC_NO" ).append("\n"); 
		query.append("      ,A.RFA_NO" ).append("\n"); 
		query.append("      ,A.CUST_CTRL_CD" ).append("\n"); 
		query.append("      ,A.WK_MQC_QTY" ).append("\n"); 
		query.append("      ,A.CUST_CD AS OLD_CUST_CD" ).append("\n"); 
		query.append("      ,A.SC_NO   AS OLD_SC_NO" ).append("\n"); 
		query.append("      ,A.RFA_NO  AS OLD_RFA_NO" ).append("\n"); 
		query.append("      ,B.OLD_CUST_CTRL_CD" ).append("\n"); 
		query.append("      ,B.OLD_WK_MQC_QTY" ).append("\n"); 
		query.append("  FROM (SELECT @[trade]        AS TRD_CD" ).append("\n"); 
		query.append("              ,@[cost_yrwk]    AS COST_YRWK" ).append("\n"); 
		query.append("              ,@[ver_seq]      AS VER_SEQ" ).append("\n"); 
		query.append("              ,@[cust_cd]      AS CUST_CD" ).append("\n"); 
		query.append("              ,@[sc_no]        AS SC_NO" ).append("\n"); 
		query.append("              ,@[rfa_no]       AS RFA_NO" ).append("\n"); 
		query.append("              ,@[cust_ctrl_cd] AS CUST_CTRL_CD" ).append("\n"); 
		query.append("              ,@[wk_mqc_qty]   AS WK_MQC_QTY" ).append("\n"); 
		query.append("          FROM DUAL) A," ).append("\n"); 
		query.append("       (SELECT MAX(CUST_CTRL_CD) AS OLD_CUST_CTRL_CD" ).append("\n"); 
		query.append("              ,MAX(WK_MQC_QTY)   AS OLD_WK_MQC_QTY" ).append("\n"); 
		query.append("          FROM SPC_MDL_CUST_CTRL" ).append("\n"); 
		query.append("         WHERE TRD_CD           = @[trade]" ).append("\n"); 
		query.append("           AND COST_YRWK        = @[cost_yrwk]" ).append("\n"); 
		query.append("           AND VER_SEQ          = @[old_ver]" ).append("\n"); 
		query.append("           AND CUST_CNT_CD      = SUBSTR(@[cust_cd], 1, 2)" ).append("\n"); 
		query.append("           AND CUST_SEQ         = SUBSTR(@[cust_cd], 3)" ).append("\n"); 
		query.append("           AND NVL(RFA_NO, ' ') = NVL(@[rfa_no], ' ')" ).append("\n"); 
		query.append("           AND NVL(SC_NO , ' ') = NVL(@[sc_no] , NVL(SC_NO, ' '))" ).append("\n"); 
		query.append("        ) B" ).append("\n"); 

	}
}