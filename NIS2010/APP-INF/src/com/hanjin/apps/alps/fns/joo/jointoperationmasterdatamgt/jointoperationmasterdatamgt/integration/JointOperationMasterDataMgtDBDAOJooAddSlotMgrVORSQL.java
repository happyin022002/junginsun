/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : JointOperationMasterDataMgtDBDAOJooAddSlotMgrVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.06.08
*@LastModifier : 박정민
*@LastVersion : 1.0
* 2016.06.08 박정민
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.joo.jointoperationmasterdatamgt.jointoperationmasterdatamgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Jeong Min Park
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class JointOperationMasterDataMgtDBDAOJooAddSlotMgrVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Additional Slot 조회
	  * </pre>
	  */
	public JointOperationMasterDataMgtDBDAOJooAddSlotMgrVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("re_divr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("jo_crr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_dt_fr",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vvd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_dt_to",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rlane_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("delt_flg",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.fns.joo.jointoperationmasterdatamgt.jointoperationmasterdatamgt.integration").append("\n"); 
		query.append("FileName : JointOperationMasterDataMgtDBDAOJooAddSlotMgrVORSQL").append("\n"); 
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
		query.append("SELECT FA.JO_CRR_CD AS ACCTG_CRR_CD" ).append("\n"); 
		query.append(", FA.TRD_CD AS TRD_CD" ).append("\n"); 
		query.append(", FA.RLANE_CD AS RLANE_CD" ).append("\n"); 
		query.append(", FA.RE_DIVR_CD AS REV_DIVR" ).append("\n"); 
		query.append(", FX_AGMT_SEQ AS AGMT_SEQ" ).append("\n"); 
		query.append(", FA.OFC_CD AS OFC_CD" ).append("\n"); 
		query.append(", FA.AGMT_OFC_CD AS REL_OFC_CD" ).append("\n"); 
		query.append(", FA.AGMT_TERM_CD AS TERM" ).append("\n"); 
		query.append(", FA.FX_AGMT_DT AS DATE_DT" ).append("\n"); 
		query.append(", FA.VSL_CD || FA.SKD_VOY_NO || FA.SKD_DIR_CD AS VVD_CD" ).append("\n"); 
		query.append(", FA.FM_PORT_CD AS LEG_FPORT" ).append("\n"); 
		query.append(", FA.TO_PORT_CD AS LEG_TPORT" ).append("\n"); 
		query.append(", FA.BSA_QTY AS JO_BSA" ).append("\n"); 
		query.append(", FA.BSA_PER_WGT AS JO_WEIGHT" ).append("\n"); 
		query.append(", FA.BSA_SLT_PRC AS JO_PRICE" ).append("\n"); 
		query.append(", DECODE(FA.ATCH_FILE_ID,NULL,'N','Y') AS ATTACH_FLG " ).append("\n"); 
		query.append(", FA.ATCH_FILE_ID" ).append("\n"); 
		query.append(", FA.FX_AGMT_RMK AS JO_REMARK" ).append("\n"); 
		query.append(", FA.STL_FLG AS STL_FLG" ).append("\n"); 
		query.append(", FA.STL_DT AS SETTLE_DT" ).append("\n"); 
		query.append(", FA.ACT_OVR_USD_QTY AS OUS_QTY" ).append("\n"); 
		query.append(", FA.DELT_FLG" ).append("\n"); 
		query.append(", FA.CRE_USR_ID" ).append("\n"); 
		query.append(", FA.UPD_USR_ID" ).append("\n"); 
		query.append(", TO_CHAR(FA.CRE_DT, 'YYYY-MM-DD') CRE_DT" ).append("\n"); 
		query.append(", FA.PIC_USR_ID" ).append("\n"); 
		query.append(", (SELECT USR_NM FROM COM_USER WHERE USR_ID = FA.PIC_USR_ID) AS PIC_USR_NM" ).append("\n"); 
		query.append("FROM JOO_FX_AGMT FA" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("#if (${trd_cd} != '') " ).append("\n"); 
		query.append("AND trd_cd = @[trd_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${rlane_cd} != '') " ).append("\n"); 
		query.append("AND rlane_cd = @[rlane_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${jo_crr_cd} != '') " ).append("\n"); 
		query.append("AND JO_CRR_CD = @[jo_crr_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${vvd_cd} != '')" ).append("\n"); 
		query.append("AND VSL_CD || SKD_VOY_NO || SKD_DIR_CD = @[vvd_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${cre_dt_fr} != '' && ${cre_dt_to} != '')" ).append("\n"); 
		query.append("AND NVL(SUBSTR(FX_AGMT_DT,1,6),REPLACE(@[cre_dt_to],'-','')) BETWEEN REPLACE(@[cre_dt_fr],'-','') AND REPLACE(@[cre_dt_to],'-','')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${stl_flg} == 'Y')" ).append("\n"); 
		query.append("AND STL_DT IS NOT NULL" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${stl_flg} == 'N')" ).append("\n"); 
		query.append("AND STL_DT IS NULL" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${delt_flg} != '')" ).append("\n"); 
		query.append("AND DELT_FLG = @[delt_flg]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${re_divr_cd} != '')" ).append("\n"); 
		query.append("AND RE_DIVR_CD = @[re_divr_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("ORDER BY fa.rlane_cd, fa.jo_crr_cd" ).append("\n"); 

	}
}