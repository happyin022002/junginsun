/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : QtaAdjustmentDBDAOUpdateCfmQtaSyncUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.05.11
*@LastModifier : 
*@LastVersion : 1.0
* 2016.05.11 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.sqm.adjustment.qtaadjustment.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class QtaAdjustmentDBDAOUpdateCfmQtaSyncUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * IAS Sector Salse 데이터를 OverAll에 적용한다.
	  * 
	  * * 2015.06.15 김용습 [CHM-201536164] 주간 MAS Open에 따른 타모듈 프로그램 적용 요청
	  * 2016.04.22 CHM-201641278 [SQM] IAS Trade 판매목표 수립 Portion 연결 시스템 수정 요청 CSR
	  * </pre>
	  */
	public QtaAdjustmentDBDAOUpdateCfmQtaSyncUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bse_qtr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vvd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bse_yr",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mas_vvd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("usr_id",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("bse_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.sqm.adjustment.qtaadjustment.integration").append("\n"); 
		query.append("FileName : QtaAdjustmentDBDAOUpdateCfmQtaSyncUSQL").append("\n"); 
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
		query.append("INSERT INTO SQM_CFM_QTA(QTA_RLSE_VER_NO, BSE_TP_CD, BSE_YR, BSE_QTR_CD, OFC_VW_CD, QTA_TGT_CD, TRD_CD, RLANE_CD, DIR_CD, VSL_CD, SKD_VOY_NO, SKD_DIR_CD, RGN_OFC_CD, RHQ_CD, AQ_CD, CONV_DIR_CD, LOD_QTY, GRS_RPB_REV, PA_CM_UC_AMT, RA_CM_UC_AMT, SQM_CNG_TP_CD, CRE_USR_ID, CRE_DT, UPD_USR_ID, UPD_DT )" ).append("\n"); 
		query.append("SELECT A1.QTA_RLSE_VER_NO" ).append("\n"); 
		query.append("      ,A1.BSE_TP_CD" ).append("\n"); 
		query.append("      ,A1.BSE_YR" ).append("\n"); 
		query.append("      ,A1.BSE_QTR_CD" ).append("\n"); 
		query.append("      ,A1.OFC_VW_CD" ).append("\n"); 
		query.append("      ,'D' AS QTA_TGT_CD" ).append("\n"); 
		query.append("      ,A1.TRD_CD" ).append("\n"); 
		query.append("      ,A1.RLANE_CD" ).append("\n"); 
		query.append("      ,A1.DIR_CD" ).append("\n"); 
		query.append("      ,A1.VSL_CD" ).append("\n"); 
		query.append("      ,A1.SKD_VOY_NO" ).append("\n"); 
		query.append("      ,A1.SKD_DIR_CD" ).append("\n"); 
		query.append("      ,A1.RGN_OFC_CD" ).append("\n"); 
		query.append("      ,A1.RHQ_CD" ).append("\n"); 
		query.append("      ,A1.AQ_CD" ).append("\n"); 
		query.append("      ,NVL(A2.CONV_DIR_CD, A1.DIR_CD)" ).append("\n"); 
		query.append("      ,SUM(A1.LOD_QTY) AS LOD_QTY" ).append("\n"); 
		query.append("      ,ROUND(DECODE(SUM(A1.LOD_QTY), 0, 0, SUM(A1.LOD_QTY*A1.GRS_RPB_REV)/SUM(A1.LOD_QTY))) AS GRS_RPB_REV" ).append("\n"); 
		query.append("      ,ROUND(DECODE(SUM(A1.LOD_QTY), 0, 0, SUM(A1.LOD_QTY*A1.PA_CM_UC_AMT)/SUM(A1.LOD_QTY))) AS PA_CM_UC_AMT" ).append("\n"); 
		query.append("      ,ROUND(DECODE(SUM(A1.LOD_QTY), 0, 0, SUM(A1.LOD_QTY*A1.RA_CM_UC_AMT)/SUM(A1.LOD_QTY))) AS RA_CM_UC_AMT" ).append("\n"); 
		query.append("      ,'M' AS SQM_CNG_TP_CD" ).append("\n"); 
		query.append("      ,@[usr_id] AS CRE_USR_ID" ).append("\n"); 
		query.append("      ,SYSDATE AS CRE_DT" ).append("\n"); 
		query.append("      ,@[usr_id] AS  UPD_USR_ID" ).append("\n"); 
		query.append("      ,SYSDATE AS UPD_DT" ).append("\n"); 
		query.append("   FROM SQM_SCTR_CFM_QTA A1" ).append("\n"); 
		query.append("       ,SQM_DIR_CONV A2" ).append("\n"); 
		query.append("  WHERE 1=1" ).append("\n"); 
		query.append("    AND A1.BSE_TP_CD       = A2.BSE_TP_CD(+)" ).append("\n"); 
		query.append("    AND A1.BSE_YR          = A2.BSE_YR(+)" ).append("\n"); 
		query.append("    AND A1.BSE_QTR_CD      = A2.BSE_QTR_CD(+)" ).append("\n"); 
		query.append("    AND A1.TRD_CD          = A2.TRD_CD(+)" ).append("\n"); 
		query.append("    AND A1.RLANE_CD        = A2.RLANE_CD(+)" ).append("\n"); 
		query.append("    AND A1.DIR_CD          = A2.DIR_CD(+)" ).append("\n"); 
		query.append("    " ).append("\n"); 
		query.append("    AND A1.QTA_RLSE_VER_NO = SUBSTR(@[bse_yr],-2) ||@[bse_qtr_cd]||'02'" ).append("\n"); 
		query.append("    AND A1.BSE_TP_CD       = @[bse_tp_cd]" ).append("\n"); 
		query.append("    AND A1.BSE_YR          = @[bse_yr]" ).append("\n"); 
		query.append("    AND A1.BSE_QTR_CD      = @[bse_qtr_cd]" ).append("\n"); 
		query.append("    AND A1.RLANE_CD        = @[rlane_cd]" ).append("\n"); 
		query.append("    AND A1.DIR_CD          = @[dir_cd]" ).append("\n"); 
		query.append("    AND A1.VSL_CD          = SUBSTR(NVL(@[mas_vvd],@[vvd]),1,4) -- 신규입력시, QTA=0일 경우동시 사용을 위해" ).append("\n"); 
		query.append("    AND A1.SKD_VOY_NO      = SUBSTR(NVL(@[mas_vvd],@[vvd]),5,4)" ).append("\n"); 
		query.append("    AND A1.SKD_DIR_CD      = SUBSTR(NVL(@[mas_vvd],@[vvd]),9,1)" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	AND (@[bse_yr]||@[bse_qtr_cd] IN ('20161Q', '20162Q') OR @[bse_yr] < '2016') --2016 2Q까지만 작동하게 함. 2016 3Q부터 IAS는 OVERALL, SECTOR 이원화하여 관리" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("  GROUP BY A1.QTA_RLSE_VER_NO" ).append("\n"); 
		query.append("          ,A1.BSE_TP_CD" ).append("\n"); 
		query.append("          ,A1.BSE_YR" ).append("\n"); 
		query.append("          ,A1.BSE_QTR_CD" ).append("\n"); 
		query.append("          ,A1.OFC_VW_CD" ).append("\n"); 
		query.append("          ,A1.TRD_CD" ).append("\n"); 
		query.append("          ,A1.RLANE_CD" ).append("\n"); 
		query.append("          ,A1.DIR_CD" ).append("\n"); 
		query.append("          ,A1.VSL_CD" ).append("\n"); 
		query.append("          ,A1.SKD_VOY_NO" ).append("\n"); 
		query.append("          ,A1.SKD_DIR_CD" ).append("\n"); 
		query.append("          ,A1.RGN_OFC_CD" ).append("\n"); 
		query.append("          ,A1.RHQ_CD" ).append("\n"); 
		query.append("          ,A1.AQ_CD" ).append("\n"); 
		query.append("          ,A2.CONV_DIR_CD" ).append("\n"); 

	}
}