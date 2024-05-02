/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CntrRepoExecutionPlanEstablishDBDAOCheckBkgVolumeChangeRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.17
*@LastModifier : 이행지
*@LastVersion : 1.0
* 2009.11.17 이행지
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.eqr.repoplanmanage.cntrrepoexecutionplanestablish.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Haeng-ji,Lee
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CntrRepoExecutionPlanEstablishDBDAOCheckBkgVolumeChangeRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * BKG_QUANTITY 의 수량과 EQR_VSL_EXE_PLN_QTY 와의 수량 차이
	  * </pre>
	  */
	public CntrRepoExecutionPlanEstablishDBDAOCheckBkgVolumeChangeRSQL(){
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
		query.append("Path : com.clt.apps.opus.ees.eqr.repoplanmanage.cntrrepoexecutionplanestablish.integration").append("\n"); 
		query.append("FileName : CntrRepoExecutionPlanEstablishDBDAOCheckBkgVolumeChangeRSQL").append("\n"); 
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
		query.append("SELECT	 EQR.CNTR_TPSZ_CD	AS CNTR_TPSZ_CD" ).append("\n"); 
		query.append(",BKG.CNTR_QTY		AS CNTR_QTY" ).append("\n"); 
		query.append("FROM	(" ).append("\n"); 
		query.append("SELECT	 A.MTY_BKG_NO" ).append("\n"); 
		query.append(",B.INTG_CD_VAL_CTNT CNTR_TPSZ_CD" ).append("\n"); 
		query.append(",NVL(A.CNTR_QTY, 0) CNTR_QTY" ).append("\n"); 
		query.append("FROM	(" ).append("\n"); 
		query.append("SELECT	EXE.MTY_BKG_NO" ).append("\n"); 
		query.append(",QTY.CNTR_TPSZ_CD" ).append("\n"); 
		query.append(",QTY.CNTR_QTY" ).append("\n"); 
		query.append("FROM	 ${exeTable} EXE" ).append("\n"); 
		query.append(",${qtyTable} QTY" ).append("\n"); 
		query.append("WHERE	EXE.REPO_PLN_ID	= QTY.REPO_PLN_ID" ).append("\n"); 
		query.append("AND	EXE.PLN_YRWK	= QTY.PLN_YRWK" ).append("\n"); 
		query.append("AND	EXE.PLN_SEQ		= QTY.PLN_SEQ" ).append("\n"); 
		query.append("AND	EXE.REF_ID		= QTY.REF_ID" ).append("\n"); 
		query.append("AND MTY_BKG_NO		= @[bkg_no]" ).append("\n"); 
		query.append(") A," ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT	INTG_CD_VAL_CTNT" ).append("\n"); 
		query.append("FROM	COM_INTG_CD_DTL" ).append("\n"); 
		query.append("WHERE	INTG_CD_ID = 'CD00830'" ).append("\n"); 
		query.append(") B" ).append("\n"); 
		query.append("WHERE	A.CNTR_TPSZ_CD(+) = B.INTG_CD_VAL_CTNT" ).append("\n"); 
		query.append(") EQR," ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT	 A.MTY_BKG_NO" ).append("\n"); 
		query.append(",B.INTG_CD_VAL_CTNT CNTR_TPSZ_CD" ).append("\n"); 
		query.append(",NVL(A.CNTR_QTY, 0) CNTR_QTY" ).append("\n"); 
		query.append("FROM	(" ).append("\n"); 
		query.append("SELECT   BKG_NO MTY_BKG_NO" ).append("\n"); 
		query.append(",CNTR_TPSZ_CD" ).append("\n"); 
		query.append(",OP_CNTR_QTY CNTR_QTY" ).append("\n"); 
		query.append("FROM	BKG_QUANTITY" ).append("\n"); 
		query.append("WHERE	BKG_NO	= @[bkg_no]" ).append("\n"); 
		query.append(") A," ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT	INTG_CD_VAL_CTNT" ).append("\n"); 
		query.append("FROM	COM_INTG_CD_DTL" ).append("\n"); 
		query.append("WHERE	INTG_CD_ID = 'CD00830'" ).append("\n"); 
		query.append(") B" ).append("\n"); 
		query.append("WHERE	A.CNTR_TPSZ_CD(+) = B.INTG_CD_VAL_CTNT" ).append("\n"); 
		query.append(") BKG" ).append("\n"); 
		query.append("WHERE	EQR.CNTR_TPSZ_CD = BKG.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("AND	BKG.CNTR_QTY - EQR.CNTR_QTY <> 0" ).append("\n"); 

	}
}