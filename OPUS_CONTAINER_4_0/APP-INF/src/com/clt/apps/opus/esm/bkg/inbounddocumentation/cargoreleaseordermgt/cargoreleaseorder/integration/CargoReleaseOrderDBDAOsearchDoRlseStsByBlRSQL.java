/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CargoReleaseOrderDBDAOsearchDoRlseStsByBlRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.06
*@LastModifier : 
*@LastVersion : 1.0
* 2009.11.06 
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

public class CargoReleaseOrderDBDAOsearchDoRlseStsByBlRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * B/L별 D/O의 STATUS(ASSIGN, RELEASE, ISSUE)별 상세 정보를 조회한다.
	  * </pre>
	  */
	public CargoReleaseOrderDBDAOsearchDoRlseStsByBlRSQL(){
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
		query.append("FileName : CargoReleaseOrderDBDAOsearchDoRlseStsByBlRSQL").append("\n"); 
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
		query.append("SELECT DOTL.RLSE_STS_CD" ).append("\n"); 
		query.append(",(SELECT INTG_CD_VAL_DP_DESC FROM COM_INTG_CD_DTL WHERE INTG_CD_ID = 'CD02152' AND INTG_CD_VAL_CTNT = DOTL.RLSE_STS_CD) AS RLSE_STS_NM" ).append("\n"); 
		query.append(", RSTS.RLSE_STS_CTNT" ).append("\n"); 
		query.append(", DECODE(BKDO.DO_NO_SPLIT, '00', BKDO.DO_NO, BKDO.DO_NO || BKDO.DO_NO_SPLIT) DO_NO" ).append("\n"); 
		query.append(", TO_CHAR(DOTL.EVNT_DT, 'YYYY/MM/DD HH24:MI', 'NLS_DATE_LANGUAGE=ENGLISH') EVNT_DT" ).append("\n"); 
		query.append(", DOTL.EVNT_USR_ID" ).append("\n"); 
		query.append(", CUSR.USR_NM   AS UPD_USR_NM" ).append("\n"); 
		query.append(", DOTL.EVNT_OFC_CD" ).append("\n"); 
		query.append(", DOTL.BKG_NO" ).append("\n"); 
		query.append("FROM BKG_DO BKDO" ).append("\n"); 
		query.append(", (SELECT INTG_CD_VAL_CTNT" ).append("\n"); 
		query.append(", INTG_CD_VAL_DP_DESC AS RLSE_STS_CTNT" ).append("\n"); 
		query.append("FROM COM_INTG_CD_DTL" ).append("\n"); 
		query.append("WHERE INTG_CD_ID = 'CD02152' ) RSTS  -- release ststus code" ).append("\n"); 
		query.append(", BKG_DO_DTL DOTL" ).append("\n"); 
		query.append(", COM_USER CUSR" ).append("\n"); 
		query.append("WHERE BKDO.BKG_NO = @[bkg_no]    --'SHAZCR00355'" ).append("\n"); 
		query.append("AND BKDO.DO_NO_SPLIT = '00'" ).append("\n"); 
		query.append("AND DOTL.BKG_NO = BKDO.BKG_NO" ).append("\n"); 
		query.append("AND DOTL.RLSE_SEQ = BKDO.RLSE_SEQ" ).append("\n"); 
		query.append("AND CUSR.USR_ID(+) = DOTL.EVNT_USR_ID" ).append("\n"); 
		query.append("AND RSTS.INTG_CD_VAL_CTNT(+) = DOTL.RLSE_STS_CD" ).append("\n"); 

	}
}