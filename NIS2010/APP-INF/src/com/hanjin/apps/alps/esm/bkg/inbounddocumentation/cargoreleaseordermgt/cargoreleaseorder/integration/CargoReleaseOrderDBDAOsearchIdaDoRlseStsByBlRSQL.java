/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CargoReleaseOrderDBDAOsearchIdaDoRlseStsByBlRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.02
*@LastModifier : 박만건
*@LastVersion : 1.0
* 2009.11.02 박만건
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Park Mangeon
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CargoReleaseOrderDBDAOsearchIdaDoRlseStsByBlRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * UI-BKG-0680 india cargo release DO release status by bl
	  * </pre>
	  */
	public CargoReleaseOrderDBDAOsearchIdaDoRlseStsByBlRSQL(){
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
		query.append("Path : com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.integration").append("\n"); 
		query.append("FileName : CargoReleaseOrderDBDAOsearchIdaDoRlseStsByBlRSQL").append("\n"); 
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
		query.append("/* IdaDoRlseStsVO */" ).append("\n"); 
		query.append("SELECT DOTL.RLSE_STS_CD" ).append("\n"); 
		query.append(", RSTS.RLSE_STS_CTNT" ).append("\n"); 
		query.append(", BKDO.DO_NO" ).append("\n"); 
		query.append(", BKDO.DO_NO_SPLIT" ).append("\n"); 
		query.append(", TO_CHAR(DOTL.EVNT_DT, 'YYYY-MM-DD HH24:MI') EVNT_DT" ).append("\n"); 
		query.append(", TO_CHAR(BKDO.IDA_DO_VTY_DT, 'YYYY-MM-DD') AS DO_VTY_DT" ).append("\n"); 
		query.append(", BKDO.IDA_DO_DMDT_PAY_TP_CD           AS DO_DMDT_PAY_TP_CD" ).append("\n"); 
		query.append(", DPAY.IDA_DO_DMDT_PAY_TP_CTNT         AS DO_DMDT_PAY_TP_CTNT" ).append("\n"); 
		query.append(", DOTL.EVNT_USR_ID" ).append("\n"); 
		query.append(", CUSR.USR_NM AS EVNT_USR_NM" ).append("\n"); 
		query.append(", DOTL.EVNT_OFC_CD" ).append("\n"); 
		query.append("FROM BKG_DO BKDO" ).append("\n"); 
		query.append(", (SELECT INTG_CD_VAL_CTNT" ).append("\n"); 
		query.append(", INTG_CD_VAL_DP_DESC AS IDA_DO_DMDT_PAY_TP_CTNT" ).append("\n"); 
		query.append("FROM COM_INTG_CD_DTL" ).append("\n"); 
		query.append("WHERE INTG_CD_ID = 'CD02209' ) DPAY  -- dem det payment type" ).append("\n"); 
		query.append(", (SELECT INTG_CD_VAL_CTNT" ).append("\n"); 
		query.append(", INTG_CD_VAL_DP_DESC AS RLSE_STS_CTNT" ).append("\n"); 
		query.append("FROM COM_INTG_CD_DTL" ).append("\n"); 
		query.append("WHERE INTG_CD_ID = 'CD02152' ) RSTS  -- release ststus code" ).append("\n"); 
		query.append(", BKG_DO_DTL DOTL" ).append("\n"); 
		query.append(", COM_USER CUSR" ).append("\n"); 
		query.append("WHERE BKDO.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("AND BKDO.DO_NO_SPLIT = '00' -- add by mgpark 20091006 split된 것은 목록에서 제외시킴" ).append("\n"); 
		query.append("AND DPAY.INTG_CD_VAL_CTNT(+) = BKDO.IDA_DO_DMDT_PAY_TP_CD" ).append("\n"); 
		query.append("AND DOTL.BKG_NO = BKDO.BKG_NO" ).append("\n"); 
		query.append("AND DOTL.RLSE_SEQ = BKDO.RLSE_SEQ" ).append("\n"); 
		query.append("AND DOTL.RLSE_STS_SEQ = (SELECT /*+ INDEX_DESC (DOTL XPKBKG_DO_DTL) */" ).append("\n"); 
		query.append("IDTL.RLSE_STS_SEQ" ).append("\n"); 
		query.append("FROM BKG_DO_DTL IDTL" ).append("\n"); 
		query.append("WHERE IDTL.BKG_NO = BKDO.BKG_NO" ).append("\n"); 
		query.append("AND IDTL.RLSE_SEQ = BKDO.RLSE_SEQ" ).append("\n"); 
		query.append("AND ROWNUM = 1 )" ).append("\n"); 
		query.append("AND CUSR.USR_ID(+) = DOTL.EVNT_USR_ID" ).append("\n"); 
		query.append("AND RSTS.INTG_CD_VAL_CTNT(+) = DOTL.RLSE_STS_CD" ).append("\n"); 

	}
}