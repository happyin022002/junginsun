/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : ControlOfficeExceptionCaseManageDBDAOSearchListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.06.13
*@LastModifier : 김성욱
*@LastVersion : 1.0
* 2016.06.13 김성욱
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.trs.codemanage.controlofficeexceptioncasemanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Sung-Wook Kim
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ControlOfficeExceptionCaseManageDBDAOSearchListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Control Office Exception Case를 조회
	  * </pre>
	  */
	public ControlOfficeExceptionCaseManageDBDAOSearchListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("search_via_yard",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("search_door_loc",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("search_cgo_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("search_fm_loc",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("search_via_loc",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("search_fm_yard",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("search_door_yard",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("input_office",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("search_trs_cost_md_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("search_to_loc",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("search_to_yard",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("search_trs_md_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.trs.codemanage.controlofficeexceptioncasemanage.integration").append("\n"); 
		query.append("FileName : ControlOfficeExceptionCaseManageDBDAOSearchListRSQL").append("\n"); 
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
		query.append("SELECT	SUBSTR(FM_NOD_CD,1,5)				AS FM_LOC_VALUE" ).append("\n"); 
		query.append("	  ,	SUBSTR(FM_NOD_CD,6,2)				AS FM_YARD_VALUE" ).append("\n"); 
		query.append("	  , SUBSTR(TO_NOD_CD,1,5)				AS TO_LOC_VALUE" ).append("\n"); 
		query.append("	  ,	SUBSTR(TO_NOD_CD,6,2)				AS TO_YARD_VALUE" ).append("\n"); 
		query.append("	  ,	SUBSTR(VIA_NOD_CD,1,5)				AS VIA_LOC_VALUE" ).append("\n"); 
		query.append("	  ,	SUBSTR(VIA_NOD_CD,6,2)				AS VIA_YARD_VALUE" ).append("\n"); 
		query.append("	  ,	SUBSTR(DOR_NOD_CD,1,5)				AS DOR_LOC_VALUE" ).append("\n"); 
		query.append("	  ,	SUBSTR(DOR_NOD_CD,6,2)				AS DOR_YARD_VALUE" ).append("\n"); 
		query.append("	  ,	CTRL_OFC_DIV_CD" ).append("\n"); 
		query.append("	  ,	CTRL_OFC_CD" ).append("\n"); 
		query.append("	  ,	CGO_TP_CD" ).append("\n"); 
		query.append("	  ,	NVL(A.DELT_FLG, 'N')				AS DELT_FLG" ).append("\n"); 
		query.append("	  ,	DELT_FLG							AS ORG_DELT_FLG" ).append("\n"); 
		query.append("	  ,	CRE_OFC_CD" ).append("\n"); 
		query.append("	  ,	CRE_USR_ID" ).append("\n"); 
		query.append("	  ,	TO_CHAR(A.CRE_DT,'YYYYMMDD')		AS CRE_DT" ).append("\n"); 
		query.append("	  ,	DECODE(DELT_FLG,'Y','1','0')		AS DELCHECK" ).append("\n"); 
		query.append("	  ,	DECODE(DELT_FLG,'Y',UPD_USR_ID, '')	AS UPD_USR_ID" ).append("\n"); 
		query.append("	  ,	DECODE(DELT_FLG,'Y',TO_CHAR(UPD_DT,'YYYYMMDD'), '')	AS UPD_DT" ).append("\n"); 
		query.append("	  ,	FM_NOD_CD" ).append("\n"); 
		query.append("	  ,	TO_NOD_CD" ).append("\n"); 
		query.append("	  ,	VIA_NOD_CD" ).append("\n"); 
		query.append("	  ,	DOR_NOD_CD" ).append("\n"); 
		query.append("	  ,	TRSP_COST_DTL_MOD_CD" ).append("\n"); 
		query.append("	  ,	TRSP_CRR_MOD_CD" ).append("\n"); 
		query.append("	  ,	CNTR_TP_CD" ).append("\n"); 
		query.append("	  ,	CNTR_SZ_CD" ).append("\n"); 
		query.append("  FROM	TRS_TRSP_OFC_EXPT_RULE A" ).append("\n"); 
		query.append(" WHERE 1=1" ).append("\n"); 
		query.append("#if(${search_cgo_tp_cd} != '')" ).append("\n"); 
		query.append("   AND CGO_TP_CD = @[search_cgo_tp_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${search_trs_cost_md_cd} != '')" ).append("\n"); 
		query.append("   AND TRSP_COST_DTL_MOD_CD = @[search_trs_cost_md_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${search_trs_md_cd} != '')" ).append("\n"); 
		query.append("   AND TRSP_CRR_MOD_CD = @[search_trs_md_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${input_office} != '')" ).append("\n"); 
		query.append("   AND CTRL_OFC_CD = @[input_office]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${search_fm_loc} != '')" ).append("\n"); 
		query.append("   AND FM_NOD_CD = @[search_fm_loc]||@[search_fm_yard]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${search_via_loc} != '')" ).append("\n"); 
		query.append("   AND VIA_NOD_CD = @[search_via_loc]||@[search_via_yard]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${search_to_loc} != '')" ).append("\n"); 
		query.append("   AND TO_NOD_CD = @[search_to_loc]||@[search_to_yard]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${search_door_loc} != '')" ).append("\n"); 
		query.append("   AND DOR_NOD_CD = @[search_door_loc]||@[search_door_yard]" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}