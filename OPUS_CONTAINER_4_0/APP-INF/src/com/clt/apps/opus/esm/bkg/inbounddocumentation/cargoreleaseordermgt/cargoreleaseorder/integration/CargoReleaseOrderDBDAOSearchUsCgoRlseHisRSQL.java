/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : CargoReleaseOrderDBDAOSearchUsCgoRlseHisRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.04.28
*@LastModifier : 
*@LastVersion : 1.0
* 2010.04.28 
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

public class CargoReleaseOrderDBDAOSearchUsCgoRlseHisRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * UI_BKG_0923 Inbound Cargo Release for POD Office_Popup History 리스트 조회
	  * </pre>
	  */
	public CargoReleaseOrderDBDAOSearchUsCgoRlseHisRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bl_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.integration").append("\n"); 
		query.append("FileName : CargoReleaseOrderDBDAOSearchUsCgoRlseHisRSQL").append("\n"); 
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
		query.append("SELECT RHIS.BL_NO               AS BL_NO" ).append("\n"); 
		query.append("      ,TO_CHAR(RHIS.EVNT_DT, 'YYYY-MM-DD HH24:MI', 'NLS_DATE_LANGUAGE=ENGLISH')  AS EVNT_DT" ).append("\n"); 
		query.append("      ,RHIS.FRT_CLT_FLG         AS FRT_CLT_FLG" ).append("\n"); 
		query.append("      ,RHIS.OBL_RDEM_FLG        AS OBL_RDEM_FLG" ).append("\n"); 
		query.append("      ,RHIS.CSTMS_CLR_CD        AS CSTMS_CLR_CD" ).append("\n"); 
		query.append("      ,RHIS.MRN_TML_EDI_SND_CD  AS MRN_TML_EDI_SND_CD" ).append("\n"); 
		query.append("      ,TMCD.INTG_CD_VAL_DP_DESC AS CGOR_TEAM_CD_DESC" ).append("\n"); 
		query.append("      ,RHIS.CGOR_EVNT_NM        AS CGOR_EVNT_NM " ).append("\n"); 
		query.append("      , EVNT_OFC_CD || '/' || EVNT_USR_ID         AS USR_NM" ).append("\n"); 
		query.append("FROM BKG_CGO_RLSE_HIS RHIS" ).append("\n"); 
		query.append("   , (SELECT INTG_CD_VAL_CTNT" ).append("\n"); 
		query.append("           , INTG_CD_VAL_DP_DESC" ).append("\n"); 
		query.append("        FROM COM_INTG_CD_DTL" ).append("\n"); 
		query.append("       WHERE INTG_CD_ID = 'CD02373' ) TMCD  " ).append("\n"); 
		query.append("WHERE RHIS.BL_NO = @[bl_no]" ).append("\n"); 
		query.append("  AND TMCD.intg_cd_val_ctnt(+) = RHIS.CGOR_TEAM_CD" ).append("\n"); 
		query.append("  AND RHIS.CGOR_EVNT_NM <> 'EDI_CGO_REL_01'  " ).append("\n"); 
		query.append("ORDER BY RHIS.EVNT_DT DESC, RHIS.HIS_SEQ DESC" ).append("\n"); 

	}
}