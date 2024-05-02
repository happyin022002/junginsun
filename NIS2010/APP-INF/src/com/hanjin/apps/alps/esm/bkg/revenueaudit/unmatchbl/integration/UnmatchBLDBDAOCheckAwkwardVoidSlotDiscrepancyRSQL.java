/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : UnmatchBLDBDAOCheckAwkwardVoidSlotDiscrepancyRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.09.01
*@LastModifier : 
*@LastVersion : 1.0
* 2015.09.01 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.revenueaudit.unmatchbl.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class UnmatchBLDBDAOCheckAwkwardVoidSlotDiscrepancyRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Self Audit - Void Qty Discrepancy 를 조회한다.
	  * </pre>
	  */
	public UnmatchBLDBDAOCheckAwkwardVoidSlotDiscrepancyRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ca_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.revenueaudit.unmatchbl.integration").append("\n"); 
		query.append("FileName : UnmatchBLDBDAOCheckAwkwardVoidSlotDiscrepancyRSQL").append("\n"); 
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
		query.append("WITH" ).append("\n"); 
		query.append("AK AS" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT SUM(AK.OVR_VOID_SLT_QTY * CNTR_VOL_QTY) OVR_VOID_SLT_QTY" ).append("\n"); 
		query.append("FROM   BKG_AWK_CGO AK" ).append("\n"); 
		query.append("WHERE  AK.BKG_NO       = @[bkg_no]" ).append("\n"); 
		query.append("AND    @[ca_flg]         = 'N'" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT SUM(AK.OVR_VOID_SLT_QTY * CNTR_VOL_QTY) OVR_VOID_SLT_QTY" ).append("\n"); 
		query.append("FROM   BKG_AWK_CGO_HIS AK" ).append("\n"); 
		query.append("WHERE  AK.BKG_NO       = @[bkg_no]" ).append("\n"); 
		query.append("AND    AK.CORR_NO      = 'TMP0000001'" ).append("\n"); 
		query.append("AND    @[ca_flg]         = 'Y'" ).append("\n"); 
		query.append(")," ).append("\n"); 
		query.append("VQ AS" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT VQ.CNTR_TPSZ_CD AK_CNTR_TPSZ_CD," ).append("\n"); 
		query.append("       VQ.OP_CNTR_QTY OP_CNTR_QTY," ).append("\n"); 
		query.append("       ROW_NUMBER() OVER (PARTITION BY 1 ORDER BY CNTR_TPSZ_CD) RNUM," ).append("\n"); 
		query.append("       SUM(DECODE(SUBSTR(CNTR_TPSZ_CD,2,1),2,0.5,1) * OP_CNTR_QTY) OVER () VOID_QTY" ).append("\n"); 
		query.append("FROM   BKG_QTY_DTL VQ" ).append("\n"); 
		query.append("WHERE  VQ.BKG_NO       = @[bkg_no]" ).append("\n"); 
		query.append("AND    VQ.AWK_CGO_FLG  = 'Y'" ).append("\n"); 
		query.append("AND    VQ.CNTR_TPSZ_CD LIKE 'Q%'" ).append("\n"); 
		query.append("AND    @[ca_flg]         = 'N'" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT VQ.CNTR_TPSZ_CD AK_CNTR_TPSZ_CD," ).append("\n"); 
		query.append("       VQ.OP_CNTR_QTY OP_CNTR_QTY," ).append("\n"); 
		query.append("       ROW_NUMBER() OVER (PARTITION BY 1 ORDER BY CNTR_TPSZ_CD) RNUM," ).append("\n"); 
		query.append("       SUM(DECODE(SUBSTR(CNTR_TPSZ_CD,2,1),2,0.5,1) * OP_CNTR_QTY) OVER () VOID_QTY" ).append("\n"); 
		query.append("FROM   BKG_QTY_DTL_HIS VQ" ).append("\n"); 
		query.append("WHERE  VQ.BKG_NO       = @[bkg_no]" ).append("\n"); 
		query.append("AND    VQ.CORR_NO      = 'TMP0000001'" ).append("\n"); 
		query.append("AND    VQ.AWK_CGO_FLG  = 'Y'" ).append("\n"); 
		query.append("AND    VQ.CNTR_TPSZ_CD LIKE 'Q%'" ).append("\n"); 
		query.append("AND    @[ca_flg]         = 'Y'" ).append("\n"); 
		query.append(")," ).append("\n"); 
		query.append("D1 AS" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT MAX(REPLACE(LTRIM(" ).append("\n"); 
		query.append("       SYS_CONNECT_BY_PATH(" ).append("\n"); 
		query.append("       '['||AK_CNTR_TPSZ_CD||'] : '" ).append("\n"); 
		query.append("          ||SUBSTR(TO_CHAR(OP_CNTR_QTY, '999.00'), 2),'^|^'), '^|^'), '^|^', CHR(10))) BKG_ITM_LOG" ).append("\n"); 
		query.append("FROM   VQ" ).append("\n"); 
		query.append("START WITH RNUM       = 1" ).append("\n"); 
		query.append("CONNECT BY PRIOR RNUM = RNUM -1" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("SELECT 'G' UMCH_TP_CD," ).append("\n"); 
		query.append("       'Void Space : '||AK.OVR_VOID_SLT_QTY||' FEU'||CHR(10)" ).append("\n"); 
		query.append("       ||D1.BKG_ITM_LOG BKG_ITM_LOG," ).append("\n"); 
		query.append("       '' CTRT_ITM_LOG," ).append("\n"); 
		query.append("       'U' MTCH_UMCH_TP_CD," ).append("\n"); 
		query.append("       ( SELECT UMCH_TP_DESC FROM BKG_REV_UMCH_TP WHERE UMCH_TP_CD = 'G' ) UMCH_TP_DESC  ," ).append("\n"); 
		query.append("       ( SELECT INTG_CD_VAL_DP_DESC FROM COM_INTG_CD_DTL WHERE INTG_CD_ID = 'CD02456' AND INTG_CD_VAL_CTNT = 'U' ) MTCH_UMCH_TP_DESC" ).append("\n"); 
		query.append("FROM  AK, VQ, D1" ).append("\n"); 
		query.append("WHERE AK.OVR_VOID_SLT_QTY > VQ.VOID_QTY" ).append("\n"); 
		query.append("AND ROWNUM = 1" ).append("\n"); 

	}
}