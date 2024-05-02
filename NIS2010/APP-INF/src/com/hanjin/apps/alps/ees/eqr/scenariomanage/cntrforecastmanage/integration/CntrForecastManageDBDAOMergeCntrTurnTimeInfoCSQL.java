/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CntrForecastManageDBDAOMergeCntrTurnTimeInfoCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.13
*@LastModifier : 정은호
*@LastVersion : 1.0
* 2009.08.13 정은호
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.eqr.scenariomanage.cntrforecastmanage.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author ChungEunHo
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CntrForecastManageDBDAOMergeCntrTurnTimeInfoCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * EQR_SCNR_ECC_TURN_TM 테이블 데이터 수정/입력
	  * </pre>
	  */
	public CntrForecastManageDBDAOMergeCntrTurnTimeInfoCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("scnr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("io_bnd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("to_ecc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_tpsz_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("user_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fm_ecc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tt_rto_dys",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("co_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.eqr.scenariomanage.cntrforecastmanage.integration ").append("\n"); 
		query.append("FileName : CntrForecastManageDBDAOMergeCntrTurnTimeInfoCSQL").append("\n"); 
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
		query.append("MERGE INTO EQR_SCNR_ECC_TURN_TM  A" ).append("\n"); 
		query.append("USING" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("@[scnr_id]  AS SCNR_ID" ).append("\n"); 
		query.append(",@[fm_ecc_cd]  AS FM_ECC_CD" ).append("\n"); 
		query.append(",@[to_ecc_cd]  AS TO_ECC_CD" ).append("\n"); 
		query.append(",@[cntr_tpsz_cd]  AS CNTR_TPSZ_CD" ).append("\n"); 
		query.append(",@[io_bnd_cd]  AS IO_BND_CD" ).append("\n"); 
		query.append(",@[co_cd]  AS CO_CD" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("DUAL" ).append("\n"); 
		query.append(") B" ).append("\n"); 
		query.append("ON" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("A.FM_ECC_CD        = B.FM_ECC_CD" ).append("\n"); 
		query.append("AND A.SCNR_ID      = B.SCNR_ID" ).append("\n"); 
		query.append("AND A.TO_ECC_CD    = B.TO_ECC_CD" ).append("\n"); 
		query.append("AND A.CNTR_TPSZ_CD = B.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("AND A.IO_BND_CD    = B.IO_BND_CD" ).append("\n"); 
		query.append("AND A.CO_CD        = B.CO_CD" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("WHEN MATCHED THEN" ).append("\n"); 
		query.append("UPDATE SET" ).append("\n"); 
		query.append("A.TT_RTO_DYS    = @[tt_rto_dys]" ).append("\n"); 
		query.append(",A.UPD_USR_ID   = @[user_id]" ).append("\n"); 
		query.append(",A.UPD_DT       = SYSDATE" ).append("\n"); 
		query.append("WHEN NOT MATCHED THEN" ).append("\n"); 
		query.append("INSERT" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("A.SCNR_ID ," ).append("\n"); 
		query.append("A.FM_ECC_CD ," ).append("\n"); 
		query.append("A.TO_ECC_CD ," ).append("\n"); 
		query.append("A.CNTR_TPSZ_CD ," ).append("\n"); 
		query.append("A.IO_BND_CD ," ).append("\n"); 
		query.append("A.TT_RTO_DYS," ).append("\n"); 
		query.append("A.CO_CD," ).append("\n"); 
		query.append("A.CRE_USR_ID," ).append("\n"); 
		query.append("A.CRE_DT," ).append("\n"); 
		query.append("A.UPD_USR_ID," ).append("\n"); 
		query.append("A.UPD_DT" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("VALUES" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("@[scnr_id]" ).append("\n"); 
		query.append(",@[fm_ecc_cd]" ).append("\n"); 
		query.append(",@[to_ecc_cd]" ).append("\n"); 
		query.append(",@[cntr_tpsz_cd]" ).append("\n"); 
		query.append(",@[io_bnd_cd]" ).append("\n"); 
		query.append(",@[tt_rto_dys]" ).append("\n"); 
		query.append(",@[co_cd]" ).append("\n"); 
		query.append(",@[user_id]" ).append("\n"); 
		query.append(",sysdate" ).append("\n"); 
		query.append(",@[user_id]" ).append("\n"); 
		query.append(",sysdate" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}