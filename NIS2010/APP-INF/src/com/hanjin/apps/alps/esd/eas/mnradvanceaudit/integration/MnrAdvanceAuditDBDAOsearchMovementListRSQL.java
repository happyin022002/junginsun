/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : MnrAdvanceAuditDBDAOsearchMovementListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.11.21
*@LastModifier : 
*@LastVersion : 1.0
* 2017.11.21 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.eas.mnradvanceaudit.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class MnrAdvanceAuditDBDAOsearchMovementListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 20160329 [ESD_EAS_0369] Futile Trip Container
	  * </pre>
	  */
	public MnrAdvanceAuditDBDAOsearchMovementListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mvmt_sts_cd1",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tdate",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("loc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mvmt_sts_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fdate",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fcntr_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("yd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("id_cnt",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.eas.mnradvanceaudit.integration").append("\n"); 
		query.append("FileName : MnrAdvanceAuditDBDAOsearchMovementListRSQL").append("\n"); 
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
		query.append("SELECT   CTM.CNTR_NO" ).append("\n"); 
		query.append("       , CTM.BKG_CGO_TP_CD" ).append("\n"); 
		query.append("       , CTM.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("       , CTM.MVMT_STS_CD" ).append("\n"); 
		query.append("       , CTM.CNMV_EVNT_DT" ).append("\n"); 
		query.append("       , CTM.UPD_LOCL_DT" ).append("\n"); 
		query.append("       , CTM.UPD_DT" ).append("\n"); 
		query.append("       , CTM.CNMV_CYC_NO" ).append("\n"); 
		query.append("       , CTM.FCNTR_FLG" ).append("\n"); 
		query.append("       , CTM.VVD" ).append("\n"); 
		query.append("       , CTM.BKG_NO" ).append("\n"); 
		query.append("       , CTM.ORG_YD_CD" ).append("\n"); 
		query.append("       , CTM.USR_NM" ).append("\n"); 
		query.append("       , CTM.OFC_CD" ).append("\n"); 
		query.append("       , CTM.CNMV_RMK" ).append("\n"); 
		query.append("FROM     (" ).append("\n"); 
		query.append("           SELECT   /*+ USE_NL(MOV, CTM) INDEX_ASC(CTM XFN1CTM_MOVEMENT) */" ).append("\n"); 
		query.append("                    CTM.CNTR_NO" ).append("\n"); 
		query.append("                  , CTM.BKG_CGO_TP_CD" ).append("\n"); 
		query.append("                  , CTM.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("                  , CTM.MVMT_STS_CD" ).append("\n"); 
		query.append("                  , CTM.CNMV_EVNT_DT" ).append("\n"); 
		query.append("                  , CTM.UPD_LOCL_DT" ).append("\n"); 
		query.append("                  , CTM.UPD_DT" ).append("\n"); 
		query.append("                  , CTM.CNMV_CYC_NO" ).append("\n"); 
		query.append("                  , DECODE(CTM.FCNTR_FLG,'Y','F','M') AS FCNTR_FLG" ).append("\n"); 
		query.append("                  , CTM.TRNK_VSL_CD || CTM.TRNK_SKD_VOY_NO || CTM.TRNK_SKD_DIR_CD AS VVD" ).append("\n"); 
		query.append("                  , CTM.BKG_NO" ).append("\n"); 
		query.append("                  , CTM.ORG_YD_CD" ).append("\n"); 
		query.append("                  , CTM.USR_NM" ).append("\n"); 
		query.append("                  , CTM.OFC_CD" ).append("\n"); 
		query.append("                  , CTM.CNMV_RMK" ).append("\n"); 
		query.append("                  , ROW_NUMBER() OVER(PARTITION BY CTM.CNTR_NO ORDER BY CTM.CNMV_YR, CTM.CNMV_SEQ, CTM.CNMV_SPLIT_NO) RN" ).append("\n"); 
		query.append("           FROM     CTM_MOVEMENT CTM" ).append("\n"); 
		query.append("                  , (" ).append("\n"); 
		query.append("                      SELECT   MOV.CNTR_NO" ).append("\n"); 
		query.append("                             , MOV.CNMV_YR" ).append("\n"); 
		query.append("                             , MOV.CNMV_ID_NO" ).append("\n"); 
		query.append("                             , MOV.CNMV_SEQ" ).append("\n"); 
		query.append("                             , MOV.CNMV_SPLIT_NO" ).append("\n"); 
		query.append("                             , MOV.CNMV_CYC_NO" ).append("\n"); 
		query.append("                      FROM     CTM_MOVEMENT MOV" ).append("\n"); 
		query.append("                      WHERE    1 = 1" ).append("\n"); 
		query.append("                      AND      MOV.CNMV_EVNT_DT BETWEEN TO_DATE(@[fdate], 'YYYY-MM-DD') AND TO_DATE(@[tdate], 'YYYY-MM-DD') + 0.99999" ).append("\n"); 
		query.append("                      AND      MOV.MVMT_STS_CD = @[mvmt_sts_cd1] -- id 1번" ).append("\n"); 
		query.append("                      AND      MOV.ORG_YD_CD = @[loc_cd] || @[yd_cd]" ).append("\n"); 
		query.append("#if(${cntr_no} != '')" ).append("\n"); 
		query.append("                      AND      MOV.CNTR_NO IN" ).append("\n"); 
		query.append("                               (" ).append("\n"); 
		query.append("	#foreach ($cntrNo IN ${cntrNos})" ).append("\n"); 
		query.append("		#if($velocityCount < $cntrNos.size())" ).append("\n"); 
		query.append("                                 '$cntrNo'," ).append("\n"); 
		query.append("		#else" ).append("\n"); 
		query.append("                                 '$cntrNo'" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("                               )" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${cntr_tpsz_cd} != '')" ).append("\n"); 
		query.append("                      AND      MOV.CNTR_TPSZ_CD IN" ).append("\n"); 
		query.append("                               (" ).append("\n"); 
		query.append("	#foreach ($tpszCd IN ${eqTpSzCds})" ).append("\n"); 
		query.append("		#if($velocityCount < $eqTpSzCds.size())" ).append("\n"); 
		query.append("                                 '$tpszCd'," ).append("\n"); 
		query.append("		#else" ).append("\n"); 
		query.append("                                 '$tpszCd'" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("                               )" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${fcntr_flg} != '')" ).append("\n"); 
		query.append("                      AND      ( MOV.FCNTR_FLG = @[fcntr_flg] OR MOV.FCNTR_FLG = (CASE WHEN @[fcntr_flg] = 'Y' THEN 'F' ELSE 'M' END) )" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("                      AND      TO_CHAR(" ).append("\n"); 
		query.append("                               (" ).append("\n"); 
		query.append("                                 SELECT   XMLAGG(XMLELEMENT(A, M.MVMT_STS_CD || ',') ORDER BY M.CNMV_YR ASC, M.CNMV_SEQ ASC, M.CNMV_SPLIT_NO ASC).EXTRACT('//text()').GETCLOBVAL() STS_CD_LIST" ).append("\n"); 
		query.append("                                 FROM     CTM_MOVEMENT M" ).append("\n"); 
		query.append("                                 WHERE    1 = 1" ).append("\n"); 
		query.append("                                 AND      M.CNTR_NO = MOV.CNTR_NO" ).append("\n"); 
		query.append("                                 AND      M.CNMV_CYC_NO <= MOV.CNMV_CYC_NO + 2" ).append("\n"); 
		query.append("                                 AND      M.CNMV_YR || TO_CHAR(M.CNMV_SEQ, '00000') || M.CNMV_SPLIT_NO >= MOV.CNMV_YR || TO_CHAR(MOV.CNMV_SEQ, '00000') || MOV.CNMV_SPLIT_NO" ).append("\n"); 
		query.append("                               )" ).append("\n"); 
		query.append("                               ) LIKE @[mvmt_sts_cd] || '%' -- id 전체" ).append("\n"); 
		query.append("                    ) MOV" ).append("\n"); 
		query.append("           WHERE    1 = 1" ).append("\n"); 
		query.append("           AND      CTM.CNTR_NO = MOV.CNTR_NO" ).append("\n"); 
		query.append("           AND      CTM.CNMV_CYC_NO <= MOV.CNMV_CYC_NO + 2" ).append("\n"); 
		query.append("           AND      CTM.CNMV_YR || TO_CHAR(CTM.CNMV_SEQ, '00000') || CTM.CNMV_SPLIT_NO >= MOV.CNMV_YR || TO_CHAR(MOV.CNMV_SEQ, '00000') || MOV.CNMV_SPLIT_NO" ).append("\n"); 
		query.append("         ) CTM" ).append("\n"); 
		query.append("WHERE    1 = 1" ).append("\n"); 
		query.append("AND      RN < @[id_cnt] --idCount" ).append("\n"); 

	}
}