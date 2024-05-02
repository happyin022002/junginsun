/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : DOFChgTrfmanageDBDAOmultiDrffChgTrfTpSzCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.04.03
*@LastModifier : 민정호
*@LastVersion : 1.0
* 2012.04.03 민정호
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.eas.transportmanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Min Jung Ho
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class DOFChgTrfmanageDBDAOmultiDrffChgTrfTpSzCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Drop Off Charge Tariff 등록
	  * </pre>
	  */
	public DOFChgTrfmanageDBDAOmultiDrffChgTrfTpSzCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("drff_chg_trf_dtl_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("d2",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("drff_chg_trf_ver_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("r9",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("d5",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("r2",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("d4",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("drff_chg_trf_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("r5",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.eas.transportmanage.integration").append("\n"); 
		query.append("FileName : DOFChgTrfmanageDBDAOmultiDrffChgTrfTpSzCSQL").append("\n"); 
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
		query.append("INSERT INTO EAS_DRFF_CHG_TRF_TP_SZ (" ).append("\n"); 
		query.append("DRFF_CHG_TRF_SEQ" ).append("\n"); 
		query.append(",DRFF_CHG_TRF_VER_NO" ).append("\n"); 
		query.append(",DRFF_CHG_TRF_DTL_SEQ" ).append("\n"); 
		query.append(",CNTR_TPSZ_CD" ).append("\n"); 
		query.append(",CHRR_FRT_TAX_VAL" ).append("\n"); 
		query.append(",CRE_USR_ID" ).append("\n"); 
		query.append(",CRE_DT" ).append("\n"); 
		query.append(",UPD_USR_ID" ).append("\n"); 
		query.append(",UPD_DT" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("@[drff_chg_trf_seq] AS DRFF_CHG_TRF_SEQ" ).append("\n"); 
		query.append(",@[drff_chg_trf_ver_no] AS DRFF_CHG_TRF_VER_NO" ).append("\n"); 
		query.append(",@[drff_chg_trf_dtl_seq] AS DRFF_CHG_TRF_DTL_SEQ" ).append("\n"); 
		query.append(",DECODE(LEVEL,1,'D2',2,'D4',3,'D5',4,'R2',5,'R5',6,'R9') AS CNTR_TPSZ_CD" ).append("\n"); 
		query.append(",DECODE(LEVEL,1,DECODE(@[d2],'E',0,REPLACE(@[d2],',',''))," ).append("\n"); 
		query.append("2,DECODE(@[d4],'E',0,REPLACE(@[d4],',',''))," ).append("\n"); 
		query.append("3,DECODE(@[d5],'E',0,REPLACE(@[d5],',',''))," ).append("\n"); 
		query.append("4,DECODE(@[r2],'E',0,REPLACE(@[r2],',',''))," ).append("\n"); 
		query.append("5,DECODE(@[r5],'E',0,REPLACE(@[r5],',',''))," ).append("\n"); 
		query.append("6,DECODE(@[r9],'E',0,REPLACE(@[r9],',',''))) AS CHRR_FRT_TAX_VAL" ).append("\n"); 
		query.append(",@[cre_usr_id] AS CRE_USR_ID" ).append("\n"); 
		query.append(",SYSDATE AS CRE_DT" ).append("\n"); 
		query.append(",@[upd_usr_id] AS UPD_USR_ID" ).append("\n"); 
		query.append(",SYSDATE AS UPD_DT" ).append("\n"); 
		query.append("FROM DUAL CONNECT BY LEVEL <=6" ).append("\n"); 

	}
}