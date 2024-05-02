/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : RepoThresholdManageDBDAOUpdateCntrFcstRLSThresholdVolUSQL.java
*@FileTitle : Red Light Alert 기준 조회/수정---컨테이너 수급 예측
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.22
*@LastModifier : 
*@LastVersion : 1.0
* 2009.07.22 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.eqr.defaultmanage.repothresholdmanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class RepoThresholdManageDBDAOUpdateCntrFcstRLSThresholdVolUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * EQR_OB_FCAST_RED_LGT_ALT 테이블에 vol 수정
	  * </pre>
	  */
	public RepoThresholdManageDBDAOUpdateCntrFcstRLSThresholdVolUSQL(){
		setQuery();
		
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rla_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rcc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("upd_usr_id",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("rla_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("UPDATE EQR_OB_FCAST_RED_LGT_ALT SET" ).append("\n"); 
		query.append("RLA_QTY          = @[rla_qty]," ).append("\n"); 
		query.append("UPD_USR_ID       = @[upd_usr_id]," ).append("\n"); 
		query.append("UPD_DT           = SYSDATE" ).append("\n"); 
		query.append("WHERE RCC_CD         = @[rcc_cd]" ).append("\n"); 
		query.append("AND   RLA_TP_CD      = @[rla_tp_cd]" ).append("\n"); 
		query.append("AND   CNTR_TPSZ_CD   = @[cntr_tpsz_cd]" ).append("\n"); 

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.nis2010.ees.eqr.defaultmanage.repothresholdmanage.integration").append("\n"); 
		query.append("FileName : RepoThresholdManageDBDAOUpdateCntrFcstRLSThresholdVolUSQL").append("\n"); 
		query.append("*/").append("\n"); 
	}
}