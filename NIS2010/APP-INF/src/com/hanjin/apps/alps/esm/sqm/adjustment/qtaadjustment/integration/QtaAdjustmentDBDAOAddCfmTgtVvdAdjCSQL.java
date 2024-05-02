/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : QtaAdjustmentDBDAOAddCfmTgtVvdAdjCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.11.04
*@LastModifier : 
*@LastVersion : 1.0
* 2015.11.04 
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

public class QtaAdjustmentDBDAOAddCfmTgtVvdAdjCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * QTA Adjustment by VVD 화면의 정보를 추가 한다.
	  * 
	  * * 2014.07.21 이혜민 FNL_BSA_CAPA,LOD_QTY,GRS_REV 조건에 nvl 추가
	  * * 2015.04.14 이혜민 [CHM-201535051] VVD History 관리를 위해 Creation 로직 변경
	  * * 2015.06.15 김용습 [CHM-201536164] 주간 MAS Open에 따른 타모듈 프로그램 적용 요청
	  * * 2015.10.29 김용습 [CHM-201538492] [CSR 전환건] QTA Adjustment by VVD for IAS Sector 화면 보완 (Adjusting VVD Select, BSA Flag 칼럼 추가)
	  * </pre>
	  */
	public QtaAdjustmentDBDAOAddCfmTgtVvdAdjCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("grs_rev",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bse_wk",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("mas_bse_wk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mas_bse_mon",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("bse_mon",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lod_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dir_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("adj_vvd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("qta_rlse_ver_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ibflag",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("bse_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ioc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fnl_bsa_capa",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.sqm.adjustment.qtaadjustment.integration").append("\n"); 
		query.append("FileName : QtaAdjustmentDBDAOAddCfmTgtVvdAdjCSQL").append("\n"); 
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
		query.append("INSERT INTO SQM_CFM_TGT_VVD_ADJ (" ).append("\n"); 
		query.append("       QTA_RLSE_VER_NO" ).append("\n"); 
		query.append("      ,BSE_TP_CD" ).append("\n"); 
		query.append("      ,BSE_YR" ).append("\n"); 
		query.append("      ,BSE_QTR_CD" ).append("\n"); 
		query.append("      ,TRD_CD" ).append("\n"); 
		query.append("      ,RLANE_CD" ).append("\n"); 
		query.append("      ,DIR_CD" ).append("\n"); 
		query.append("      ,VSL_CD" ).append("\n"); 
		query.append("      ,SKD_VOY_NO" ).append("\n"); 
		query.append("      ,SKD_DIR_CD" ).append("\n"); 
		query.append("      ,HIS_SEQ" ).append("\n"); 
		query.append("      ,BSE_MON" ).append("\n"); 
		query.append("      ,BSE_WK" ).append("\n"); 
		query.append("      ,BFR_VSL_CD" ).append("\n"); 
		query.append("      ,BFR_SKD_VOY_NO" ).append("\n"); 
		query.append("      ,BFR_SKD_DIR_CD" ).append("\n"); 
		query.append("      ,BFR_BSE_MON" ).append("\n"); 
		query.append("      ,BFR_BSE_WK" ).append("\n"); 
		query.append("      ,IOC_CD" ).append("\n"); 
		query.append("      ,FNL_BSA_CAPA" ).append("\n"); 
		query.append("      ,LOD_QTY" ).append("\n"); 
		query.append("      ,GRS_REV" ).append("\n"); 
		query.append("      ,CRE_USR_ID" ).append("\n"); 
		query.append("      ,CRE_DT" ).append("\n"); 
		query.append("      ,UPD_USR_ID" ).append("\n"); 
		query.append("      ,UPD_DT" ).append("\n"); 
		query.append("      ,SQM_VVD_HIS_TP_CD" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("SELECT @[qta_rlse_ver_no]       AS QTA_RLSE_VER_NO" ).append("\n"); 
		query.append("      ,@[bse_tp_cd]             AS BSE_TP_CD" ).append("\n"); 
		query.append("      ,@[bse_yr]                AS BSE_YR" ).append("\n"); 
		query.append("      ,@[bse_qtr_cd]            AS BSE_QTR_CD" ).append("\n"); 
		query.append("      ,@[trd_cd]                AS TRD_CD" ).append("\n"); 
		query.append("      ,@[rlane_cd]              AS RLANE_CD" ).append("\n"); 
		query.append("      ,@[dir_cd]                AS DIR_CD" ).append("\n"); 
		query.append("      ,SUBSTR(DECODE(@[ibflag], 'D', @[vvd], DECODE(@[adj_vvd], 'Y', @[vvd], @[mas_vvd])), 1, 4) AS VSL_CD" ).append("\n"); 
		query.append("      ,SUBSTR(DECODE(@[ibflag], 'D', @[vvd], DECODE(@[adj_vvd], 'Y', @[vvd], @[mas_vvd])), 5, 4) AS SKD_VOY_NO" ).append("\n"); 
		query.append("      ,SUBSTR(DECODE(@[ibflag], 'D', @[vvd], DECODE(@[adj_vvd], 'Y', @[vvd], @[mas_vvd])), 9, 1) AS SKD_DIR_CD" ).append("\n"); 
		query.append("      ,(" ).append("\n"); 
		query.append("         SELECT NVL(MAX(HIS_SEQ), 0) + 1" ).append("\n"); 
		query.append("           FROM SQM_CFM_TGT_VVD_ADJ" ).append("\n"); 
		query.append("          WHERE QTA_RLSE_VER_NO = @[qta_rlse_ver_no]" ).append("\n"); 
		query.append("            AND BSE_TP_CD       = @[bse_tp_cd]" ).append("\n"); 
		query.append("            AND BSE_YR          = @[bse_yr]" ).append("\n"); 
		query.append("            AND BSE_QTR_CD      = @[bse_qtr_cd]" ).append("\n"); 
		query.append("            AND TRD_CD          = @[trd_cd]" ).append("\n"); 
		query.append("            AND RLANE_CD        = @[rlane_cd]" ).append("\n"); 
		query.append("            AND DIR_CD          = @[dir_cd]" ).append("\n"); 
		query.append("            AND VSL_CD          = SUBSTR(DECODE(@[ibflag], 'D', @[vvd], DECODE(@[adj_vvd], 'Y', @[vvd], @[mas_vvd])), 1, 4)" ).append("\n"); 
		query.append("            AND SKD_VOY_NO      = SUBSTR(DECODE(@[ibflag], 'D', @[vvd], DECODE(@[adj_vvd], 'Y', @[vvd], @[mas_vvd])), 5, 4)" ).append("\n"); 
		query.append("            AND SKD_DIR_CD      = SUBSTR(DECODE(@[ibflag], 'D', @[vvd], DECODE(@[adj_vvd], 'Y', @[vvd], @[mas_vvd])), 9, 1)" ).append("\n"); 
		query.append("       ) AS HIS_SEQ" ).append("\n"); 
		query.append("      ,DECODE(@[ibflag], 'D', @[bse_mon], DECODE(@[adj_vvd], 'Y', @[bse_mon], @[mas_bse_mon])) AS BSE_MON" ).append("\n"); 
		query.append("      ,DECODE(@[ibflag], 'D', @[bse_wk] , DECODE(@[adj_vvd], 'Y', @[bse_wk], @[mas_bse_wk]))  AS BSE_WK" ).append("\n"); 
		query.append("      ,DECODE(@[ibflag], 'I', '', SUBSTR(@[vvd], 1, 4)) AS BFR_VSL_CD" ).append("\n"); 
		query.append("      ,DECODE(@[ibflag], 'I', '', SUBSTR(@[vvd], 5, 4)) AS BFR_SKD_VOY_NO" ).append("\n"); 
		query.append("      ,DECODE(@[ibflag], 'I', '', SUBSTR(@[vvd], 9, 1)) AS BFR_SKD_DIR_CD" ).append("\n"); 
		query.append("      ,DECODE(@[ibflag], 'I', '', @[bse_mon]) AS BFR_BSE_MON" ).append("\n"); 
		query.append("      ,DECODE(@[ibflag], 'I', '', @[bse_wk])  AS BFR_BSE_WK" ).append("\n"); 
		query.append("      ,@[ioc_cd] AS IOC_CD" ).append("\n"); 
		query.append("      ,NVL(DECODE(@[ibflag], 'I', '0', @[fnl_bsa_capa]),0) AS FNL_BSA_CAPA" ).append("\n"); 
		query.append("      ,NVL(DECODE(@[ibflag], 'I', '0', @[lod_qty]),0) AS LOD_QTY" ).append("\n"); 
		query.append("      ,NVL(DECODE(@[ibflag], 'I', '0', @[grs_rev]),0) AS GRS_REV" ).append("\n"); 
		query.append("      ,@[usr_id] AS CRE_USR_ID" ).append("\n"); 
		query.append("      ,SYSDATE       AS CRE_DT" ).append("\n"); 
		query.append("      ,@[usr_id] AS UPD_USR_ID" ).append("\n"); 
		query.append("      ,SYSDATE       AS UPD_DT" ).append("\n"); 
		query.append("      ,@[ibflag] AS SQM_VVD_HIS_TP_CD" ).append("\n"); 
		query.append("  FROM DUAL" ).append("\n"); 

	}
}