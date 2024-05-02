/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CargoReleaseOrderDBDAOSearchIdaDoRlseStsByCntrRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.25
*@LastModifier : 
*@LastVersion : 1.0
* 2009.11.25 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CargoReleaseOrderDBDAOSearchIdaDoRlseStsByCntrRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * UI-BKG-0680 india cargo release order search DO release status by container
	  * </pre>
	  */
	public CargoReleaseOrderDBDAOSearchIdaDoRlseStsByCntrRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.integration").append("\n"); 
		query.append("FileName : CargoReleaseOrderDBDAOSearchIdaDoRlseStsByCntrRSQL").append("\n"); 
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
		query.append("/* IdaDoCntrRlseStsVO */" ).append("\n"); 
		query.append("SELECT SUBQ.BKG_NO                               AS BKG_NO" ).append("\n"); 
		query.append(", SUBQ.RLSE_SEQ                             AS RLSE_SEQ" ).append("\n"); 
		query.append(", SUBQ.RLSE_STS_SEQ                         AS RLSE_STS_SEQ" ).append("\n"); 
		query.append(", SUBQ.CNTR_NO                              AS CNTR_NO" ).append("\n"); 
		query.append(", DOTL.RLSE_STS_CD                          AS RLSE_STS_CD" ).append("\n"); 
		query.append(", RSTS.RLSE_STS_CTNT                        AS RLSE_STS_CTNT" ).append("\n"); 
		query.append(", BKDO.DO_NO || BKDO.DO_NO_SPLIT            AS DO_NO" ).append("\n"); 
		query.append(", TO_CHAR(BKDO.IDA_DO_VTY_DT,'YYYY-MM-DD') AS DO_VTY_DT" ).append("\n"); 
		query.append(", BKDO.IDA_DO_DMDT_PAY_TP_CD                AS DMDT_PAY_TP_CD" ).append("\n"); 
		query.append(", DPAY.IDA_DO_DMDT_PAY_TP_CTNT              AS DO_DMDT_PAY_TP_CTNT" ).append("\n"); 
		query.append(", TO_CHAR(DOTL.EVNT_DT,'YYYY-MM-DD HH24:MI') EVNT_DT" ).append("\n"); 
		query.append(", DOTL.EVNT_USR_ID                          AS EVNT_USR_ID" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("SELECT BCNT.BKG_NO" ).append("\n"); 
		query.append(", BCNT.CNTR_NO" ).append("\n"); 
		query.append(", DCNT.RLSE_SEQ" ).append("\n"); 
		query.append(", (SELECT /*+ INDEX_DESC (DOTL XPKBKG_DO_DTL) */" ).append("\n"); 
		query.append("IDTL.RLSE_STS_SEQ" ).append("\n"); 
		query.append("FROM BKG_DO_DTL IDTL" ).append("\n"); 
		query.append("WHERE IDTL.BKG_NO = BCNT.BKG_NO" ).append("\n"); 
		query.append("AND IDTL.RLSE_SEQ = DCNT.RLSE_SEQ" ).append("\n"); 
		query.append("AND ROWNUM = 1 ) RLSE_STS_SEQ" ).append("\n"); 
		query.append("FRom BKG_CONTAINER BCNT" ).append("\n"); 
		query.append(", (SELECT DCNT.CNTR_NO" ).append("\n"); 
		query.append(", MAX(DCNT.RLSE_SEQ) AS RLSE_SEQ" ).append("\n"); 
		query.append("FROM BKG_DO      BKDO" ).append("\n"); 
		query.append(", BKG_DO_CNTR DCNT" ).append("\n"); 
		query.append("WHERE BKDO.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("AND BKDO.DO_NO_SPLIT <> '00'" ).append("\n"); 
		query.append("AND DCNT.BKG_NO = BKDO.BKG_NO" ).append("\n"); 
		query.append("AND DCNT.RLSE_SEQ = BKDO.RLSE_SEQ" ).append("\n"); 
		query.append("GROUP BY DCNT.CNTR_NO" ).append("\n"); 
		query.append(") DCNT" ).append("\n"); 
		query.append("WHERE BCNT.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("AND BCNT.CNTR_NO  = DCNT.CNTR_NO(+)" ).append("\n"); 
		query.append(") SUBQ" ).append("\n"); 
		query.append(", BKG_DO BKDO" ).append("\n"); 
		query.append(", BKG_DO_DTL DOTL" ).append("\n"); 
		query.append(", (SELECT INTG_CD_VAL_CTNT" ).append("\n"); 
		query.append(", INTG_CD_VAL_DP_DESC AS IDA_DO_DMDT_PAY_TP_CTNT" ).append("\n"); 
		query.append("FROM COM_INTG_CD_DTL" ).append("\n"); 
		query.append("WHERE INTG_CD_ID = 'CD02209' ) DPAY  -- dem det payment type" ).append("\n"); 
		query.append(", (SELECT INTG_CD_VAL_CTNT" ).append("\n"); 
		query.append(", INTG_CD_VAL_DP_DESC AS RLSE_STS_CTNT" ).append("\n"); 
		query.append("FROM COM_INTG_CD_DTL" ).append("\n"); 
		query.append("WHERE INTG_CD_ID = 'CD02152' ) RSTS  -- release ststus code" ).append("\n"); 
		query.append("WHERE 1 = 1" ).append("\n"); 
		query.append("AND BKDO.BKG_NO(+)       = SUBQ.BKG_NO" ).append("\n"); 
		query.append("AND BKDO.RLSE_SEQ(+)     = SUBQ.RLSE_SEQ" ).append("\n"); 
		query.append("AND DOTL.BKG_NO(+)       = SUBQ.BKG_NO" ).append("\n"); 
		query.append("AND DOTL.RLSE_SEQ(+)     = SUBQ.RLSE_SEQ" ).append("\n"); 
		query.append("AND DOTL.RLSE_STS_SEQ(+) = SUBQ.RLSE_STS_SEQ" ).append("\n"); 
		query.append("AND RSTS.INTG_CD_VAL_CTNT(+) = DOTL.RLSE_STS_CD" ).append("\n"); 
		query.append("AND DPAY.INTG_CD_VAL_CTNT(+) = BKDO.IDA_DO_DMDT_PAY_TP_CD" ).append("\n"); 
		query.append("ORDER BY SUBQ.CNTR_NO" ).append("\n"); 

	}
}