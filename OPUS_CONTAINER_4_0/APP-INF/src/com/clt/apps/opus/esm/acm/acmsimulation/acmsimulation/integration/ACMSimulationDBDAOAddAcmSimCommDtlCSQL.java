/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : ACMSimulationDBDAOAddAcmSimCommDtlCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.03.23
*@LastModifier : 
*@LastVersion : 1.0
* 2015.03.23 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.acm.acmsimulation.acmsimulation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ACMSimulationDBDAOAddAcmSimCommDtlCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * AddAcmSimCommDtl
	  * </pre>
	  */
	public ACMSimulationDBDAOAddAcmSimCommDtlCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sim_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.acm.acmsimulation.acmsimulation.integration").append("\n"); 
		query.append("FileName : ACMSimulationDBDAOAddAcmSimCommDtlCSQL").append("\n"); 
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
		query.append("INSERT INTO ACM_SIM_COMM_DTL" ).append("\n"); 
		query.append("(SIM_NO, BKG_NO, AGN_CD, IO_BND_CD, AC_TP_CD, AC_SEQ, CNTR_TPSZ_CD, BKG_VOL_QTY, IF_DTRB_AMT, CURR_CD, PAY_IF_DTRB_AMT, CRE_USR_ID, CRE_DT, UPD_USR_ID, UPD_DT)" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append(" H.SIM_NO" ).append("\n"); 
		query.append(",H.BKG_NO" ).append("\n"); 
		query.append(",H.AGN_CD" ).append("\n"); 
		query.append(",H.IO_BND_CD" ).append("\n"); 
		query.append(",H.AC_TP_CD" ).append("\n"); 
		query.append(",H.AC_SEQ" ).append("\n"); 
		query.append(",Q.CNTR_TPSZ_CD" ).append("\n"); 
		query.append(",Q.OP_CNTR_QTY AS BKG_VOL_QTY" ).append("\n"); 
		query.append(",ROUND(H.IF_AMT     * (Q.IND/Q.TTL),2)  AS IF_DTRB_AMT" ).append("\n"); 
		query.append(",H.CURR_CD" ).append("\n"); 
		query.append(",ROUND(H.PAY_IF_AMT * (Q.IND/Q.TTL),2)  AS PAY_IF_DTRB_AMT" ).append("\n"); 
		query.append(",@[usr_id]" ).append("\n"); 
		query.append(",SYSDATE" ).append("\n"); 
		query.append(",@[usr_id]" ).append("\n"); 
		query.append(",SYSDATE" ).append("\n"); 
		query.append("FROM ACM_SIM_COMM H, " ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("    SELECT QTY.BKG_NO " ).append("\n"); 
		query.append("         , QTY.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("         , QTY.OP_CNTR_QTY" ).append("\n"); 
		query.append("         , DECODE(SUBSTR(QTY.CNTR_TPSZ_CD,2,1),2,QTY.OP_CNTR_QTY,QTY.OP_CNTR_QTY*2) AS IND" ).append("\n"); 
		query.append("         , SUM(DECODE(SUBSTR(QTY.CNTR_TPSZ_CD,2,1),2,QTY.OP_CNTR_QTY,QTY.OP_CNTR_QTY*2))OVER (PARTITION BY QTY.BKG_NO) AS TTL" ).append("\n"); 
		query.append("    FROM  BKG_QUANTITY QTY" ).append("\n"); 
		query.append("    WHERE QTY.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("      AND QTY.CNTR_TPSZ_CD NOT LIKE 'Q%' " ).append("\n"); 
		query.append(") Q" ).append("\n"); 
		query.append("WHERE Q.BKG_NO = H.BKG_NO" ).append("\n"); 
		query.append("  AND H.COMM_FX_AMT = 0" ).append("\n"); 
		query.append("  AND H.SIM_NO = @[sim_no]" ).append("\n"); 

	}
}