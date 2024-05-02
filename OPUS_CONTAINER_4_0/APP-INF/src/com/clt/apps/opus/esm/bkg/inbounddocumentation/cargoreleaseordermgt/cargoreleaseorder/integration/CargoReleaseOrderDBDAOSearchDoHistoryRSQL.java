/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CargoReleaseOrderDBDAOSearchDoHistoryRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.23
*@LastModifier : 
*@LastVersion : 1.0
* 2009.10.23 
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

public class CargoReleaseOrderDBDAOSearchDoHistoryRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * New Cargo Release Order에서 Update 수정되는 정보를 시간순으로 조회한다.
	  * </pre>
	  */
	public CargoReleaseOrderDBDAOSearchDoHistoryRSQL(){
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
		query.append("FileName : CargoReleaseOrderDBDAOSearchDoHistoryRSQL").append("\n"); 
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
		query.append("SELECT BKG_NO" ).append("\n"); 
		query.append(",DO_SEQ" ).append("\n"); 
		query.append(",DO_CNG_EVNT_CD" ).append("\n"); 
		query.append(",DO_CNG_EVNT_NM" ).append("\n"); 
		query.append(",NVL(PRE_CTNT,'NO') AS PRE_CTNT" ).append("\n"); 
		query.append(",PRE_CTNT_NM" ).append("\n"); 
		query.append(",CRNT_CTNT" ).append("\n"); 
		query.append(",NVL(CRNT_CTNT_NM,CRNT_CTNT) AS CRNT_CTNT_NM" ).append("\n"); 
		query.append(",EVNT_DT" ).append("\n"); 
		query.append(",EVNT_USR_ID" ).append("\n"); 
		query.append(",EVNT_OFC_CD" ).append("\n"); 
		query.append(",CRE_USR_ID" ).append("\n"); 
		query.append(",CRE_DT" ).append("\n"); 
		query.append(",UPD_USR_ID" ).append("\n"); 
		query.append(",UPD_USR_NM" ).append("\n"); 
		query.append(",UPD_DT" ).append("\n"); 
		query.append(",BL_NO" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("SELECT HIS.BKG_NO" ).append("\n"); 
		query.append(", HIS.DO_SEQ" ).append("\n"); 
		query.append(", HIS.DO_CNG_EVNT_CD" ).append("\n"); 
		query.append(", (SELECT INTG_CD_VAL_DP_DESC FROM COM_INTG_CD_DTL A  WHERE INTG_CD_ID = 'CD02096' AND INTG_CD_VAL_CTNT = HIS.DO_CNG_EVNT_CD) AS DO_CNG_EVNT_NM" ).append("\n"); 
		query.append(", HIS.PRE_CTNT" ).append("\n"); 
		query.append(", (SELECT INTG_CD_VAL_DP_DESC FROM COM_INTG_CD_DTL A  WHERE INTG_CD_ID = 'CD02096' AND INTG_CD_VAL_CTNT = HIS.PRE_CTNT) AS PRE_CTNT_NM" ).append("\n"); 
		query.append(", DECODE(DO_CNG_EVNT_CD,'XX','Cancel',HIS.CRNT_CTNT) as CRNT_CTNT" ).append("\n"); 
		query.append(", (SELECT INTG_CD_VAL_DP_DESC FROM COM_INTG_CD_DTL A  WHERE INTG_CD_ID = 'CD02096' AND INTG_CD_VAL_CTNT = HIS.CRNT_CTNT) AS CRNT_CTNT_NM" ).append("\n"); 
		query.append(", HIS.EVNT_DT" ).append("\n"); 
		query.append(", HIS.EVNT_USR_ID" ).append("\n"); 
		query.append(", HIS.EVNT_OFC_CD" ).append("\n"); 
		query.append(", HIS.CRE_USR_ID" ).append("\n"); 
		query.append(", HIS.CRE_DT" ).append("\n"); 
		query.append(", HIS.UPD_USR_ID" ).append("\n"); 
		query.append(", (SELECT USR_NM FROM COM_USER WHERE USR_ID = HIS.UPD_USR_ID) AS UPD_USR_NM" ).append("\n"); 
		query.append(", HIS.UPD_DT" ).append("\n"); 
		query.append(", BKG.BL_NO" ).append("\n"); 
		query.append("FROM BKG_DO_HIS HIS" ).append("\n"); 
		query.append(", BKG_BOOKING BKG" ).append("\n"); 
		query.append("WHERE HIS.BKG_NO = BKG.BKG_NO" ).append("\n"); 
		query.append("AND HIS.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("ORDER BY EVNT_DT ASC" ).append("\n"); 

	}
}