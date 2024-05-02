/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : CanalTransitFeeInvoiceDBDAOSearchAtchFileListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.04.09
*@LastModifier : 진마리아
*@LastVersion : 1.0
* 2012.04.09 진마리아
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.pso.estimateinvoiceaudit.canaltransitfeeinvoice.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Maria Chin
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CanalTransitFeeInvoiceDBDAOSearchAtchFileListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Requested Actual Invoice 관련 atch file retrieve - cost 가 없는 경우 invoice list atch file.
	  * 
	  * History
	  * 2012.04.09 진마리아 CHM-201217036-01 SPP-Port SO/ Actual Invoice 화면 변경 및 기능, 로직 추가 - file download는 전도금이 아닌 invoice 화면으로 수정
	  * </pre>
	  */
	public CanalTransitFeeInvoiceDBDAOSearchAtchFileListRSQL(){
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
		params.put("call_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lgs_cost_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("yd_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.pso.estimateinvoiceaudit.canaltransitfeeinvoice.integration").append("\n"); 
		query.append("FileName : CanalTransitFeeInvoiceDBDAOSearchAtchFileListRSQL").append("\n"); 
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
		query.append("SELECT T1.FILE_SAV_ID," ).append("\n"); 
		query.append("       T2.FILE_UPLD_NM," ).append("\n"); 
		query.append("       T1.UPD_USR_ID," ).append("\n"); 
		query.append("       T1.UPD_DT" ).append("\n"); 
		query.append("FROM PSO_CNL_TZ_ATCH_FILE T1, COM_UPLD_FILE T2" ).append("\n"); 
		query.append("WHERE T1.FILE_SAV_ID = T2.FILE_SAV_ID" ).append("\n"); 
		query.append("AND T1.VSL_CD = SUBSTR(@[vvd],1,4)" ).append("\n"); 
		query.append("AND T1.SKD_VOY_NO = SUBSTR(@[vvd],5,4)" ).append("\n"); 
		query.append("AND T1.SKD_DIR_CD = SUBSTR(@[vvd],9,1)" ).append("\n"); 
		query.append("AND T1.YD_CD = @[yd_cd]" ).append("\n"); 
		query.append("AND T1.CALL_SEQ = @[call_seq]" ).append("\n"); 
		query.append("#if (${lgs_cost_cd} != '') " ).append("\n"); 
		query.append("AND T1.LGS_COST_CD = @[lgs_cost_cd]" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("AND T1.LGS_COST_CD IS NULL" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}