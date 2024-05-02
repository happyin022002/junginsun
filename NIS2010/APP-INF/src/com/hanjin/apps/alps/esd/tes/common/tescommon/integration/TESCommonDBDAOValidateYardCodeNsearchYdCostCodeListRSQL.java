/*=========================================================
*Copyright(c) 2018 CyberLogitec
*@FileName : TESCommonDBDAOValidateYardCodeNsearchYdCostCodeListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2018.01.11
*@LastModifier : 
*@LastVersion : 1.0
* 2018.01.11 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.tes.common.tescommon.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TESCommonDBDAOValidateYardCodeNsearchYdCostCodeListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Yard Code, Yard Cost Code Inquiry
	  * </pre>
	  */
	public TESCommonDBDAOValidateYardCodeNsearchYdCostCodeListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("lgs_cost_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.tes.common.tescommon.integration").append("\n"); 
		query.append("FileName : TESCommonDBDAOValidateYardCodeNsearchYdCostCodeListRSQL").append("\n"); 
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
		query.append("SELECT" ).append("\n"); 
		query.append("		CASE WHEN COUNT(YD_CD)>0 THEN 'Y' ELSE 'N' END YD_CD_EXISTING" ).append("\n"); 
		query.append("		, YD_CD" ).append("\n"); 
		query.append("		, YD_NM" ).append("\n"); 
		query.append("		, YD_CHR_CD" ).append("\n"); 
		query.append("		, YD_FCTY_TP_MRN_TML_FLG" ).append("\n"); 
		query.append("		, YD_FCTY_TP_CY_FLG" ).append("\n"); 
		query.append("		, YD_FCTY_TP_CFS_FLG" ).append("\n"); 
		query.append("		, YD_FCTY_TP_RAIL_RMP_FLG" ).append("\n"); 
		query.append("		, YD_OSHP_CD" ).append("\n"); 
		query.append("		, (" ).append("\n"); 
		query.append("		SELECT	LTRIM(MAX(SYS_CONNECT_BY_PATH(LGS_COST_CD,'|')),'|')" ).append("\n"); 
		query.append("		FROM	(" ).append("\n"); 
		query.append("				SELECT	C.LGS_COST_CD" ).append("\n"); 
		query.append("					, ROWNUM ROW_ID" ).append("\n"); 
		query.append("				FROM	TES_TML_SO_COST C" ).append("\n"); 
		query.append("					, MDM_YARD Y" ).append("\n"); 
		query.append("				WHERE	DECODE('MT','MT',MRN_TML_FLG,'ON',ODCK_RAIL_CHG_FLG,'OT',FDCK_CY_TML_FLG," ).append("\n"); 
		query.append("									'OS',FDCK_CY_STO_FLG,'ST',STO_INV_FLG)  = 'Y'" ).append("\n"); 
		query.append("				AND		CFS_FLG      IN (DECODE(Y.YD_FCTY_TP_CFS_FLG,'N','N','Y'),'N')" ).append("\n"); 
		query.append("				AND		RAIL_RMP_FLG IN (DECODE(Y.YD_FCTY_TP_RAIL_RMP_FLG,'N','N','Y'),'N')" ).append("\n"); 
		query.append("				AND		XCLD_TML_FLG IN (DECODE(Y.YD_OSHP_CD,'O','Y','N'),'N')" ).append("\n"); 
		query.append("				AND		Y.YD_CD		= @[yd_cd]" ).append("\n"); 
		query.append("				-- // CHM-201432861 TMRFGR 사용국가제한_ US, CA 북미 2국가에서만 발생가능하도록 조치 - 4347-11-20" ).append("\n"); 
		query.append("				#if (${genset_flg} != 'Y') " ).append("\n"); 
		query.append("				AND		C.LGS_COST_CD	<> @[lgs_cost_cd]" ).append("\n"); 
		query.append("				#end" ).append("\n"); 
		query.append("				ORDER BY C.LGS_COST_CD ASC" ).append("\n"); 
		query.append("				)" ).append("\n"); 
		query.append("		CONNECT BY PRIOR ROW_ID = ROW_ID - 1" ).append("\n"); 
		query.append("		START WITH ROW_ID = 1" ).append("\n"); 
		query.append("		) COST_CD_MT" ).append("\n"); 
		query.append("		, (" ).append("\n"); 
		query.append("		SELECT	LTRIM(MAX(SYS_CONNECT_BY_PATH(LGS_COST_CD,'|')),'|')" ).append("\n"); 
		query.append("		FROM	(" ).append("\n"); 
		query.append("				SELECT	C.LGS_COST_CD" ).append("\n"); 
		query.append("					, ROWNUM ROW_ID" ).append("\n"); 
		query.append("				FROM	TES_TML_SO_COST C" ).append("\n"); 
		query.append("					, MDM_YARD Y" ).append("\n"); 
		query.append("				WHERE  DECODE('ON','MT',MRN_TML_FLG,'ON',ODCK_RAIL_CHG_FLG,'OT',FDCK_CY_TML_FLG," ).append("\n"); 
		query.append("									'OS',FDCK_CY_STO_FLG,'ST',STO_INV_FLG)  = 'Y'" ).append("\n"); 
		query.append("				AND		CFS_FLG      IN (DECODE(Y.YD_FCTY_TP_CFS_FLG,'N','N','Y'),'N')" ).append("\n"); 
		query.append("				--##ON-Dock Manual Cost Code 수정" ).append("\n"); 
		query.append("				--##Manual Cost Code에 TMNDRF, TMNDRM을 불러오기 위해 일시적으로 SQL막아줌. 2007.07.17" ).append("\n"); 
		query.append("				--##AND		RAIL_RMP_FLG IN (DECODE(Y.YD_FCTY_TP_RAIL_RMP_FLG,'N','N','Y'),'N')" ).append("\n"); 
		query.append("				AND		XCLD_TML_FLG IN (DECODE(Y.YD_OSHP_CD,'O','Y','N'),'N')" ).append("\n"); 
		query.append("				AND		Y.YD_CD		= @[yd_cd]" ).append("\n"); 
		query.append("				-- // CHM-201432861 TMRFGR 사용국가제한_ US, CA 북미 2국가에서만 발생가능하도록 조치 - 4347-11-20" ).append("\n"); 
		query.append("				#if (${genset_flg} != 'Y') " ).append("\n"); 
		query.append("				AND		C.LGS_COST_CD	<> @[lgs_cost_cd]" ).append("\n"); 
		query.append("				#end" ).append("\n"); 
		query.append("				ORDER BY C.LGS_COST_CD ASC" ).append("\n"); 
		query.append("				)" ).append("\n"); 
		query.append("		CONNECT BY PRIOR ROW_ID = ROW_ID - 1" ).append("\n"); 
		query.append("		START WITH ROW_ID = 1" ).append("\n"); 
		query.append("		) COST_CD_ON" ).append("\n"); 
		query.append("		, (" ).append("\n"); 
		query.append("		SELECT	LTRIM(MAX(SYS_CONNECT_BY_PATH(LGS_COST_CD,'|')),'|')" ).append("\n"); 
		query.append("		FROM	(" ).append("\n"); 
		query.append("				SELECT	C.LGS_COST_CD" ).append("\n"); 
		query.append("					, ROWNUM ROW_ID" ).append("\n"); 
		query.append("				FROM	TES_TML_SO_COST C" ).append("\n"); 
		query.append("					, MDM_YARD Y" ).append("\n"); 
		query.append("				WHERE	DECODE('OT','MT',MRN_TML_FLG,'ON',ODCK_RAIL_CHG_FLG,'OT',FDCK_CY_TML_FLG," ).append("\n"); 
		query.append("									'OS',FDCK_CY_STO_FLG,'ST',STO_INV_FLG)  = 'Y'" ).append("\n"); 
		query.append("				AND		CFS_FLG      IN (DECODE(Y.YD_FCTY_TP_CFS_FLG,'N','N','Y'),'N')" ).append("\n"); 
		query.append("				AND		RAIL_RMP_FLG IN (DECODE(Y.YD_FCTY_TP_RAIL_RMP_FLG,'N','N','Y'),'N')" ).append("\n"); 
		query.append("				AND		XCLD_TML_FLG IN (DECODE(Y.YD_OSHP_CD,'O','Y','N'),'N')" ).append("\n"); 
		query.append("				AND		Y.YD_CD		= @[yd_cd]" ).append("\n"); 
		query.append("				#if (${genset_flg} != 'Y') " ).append("\n"); 
		query.append("				AND		C.LGS_COST_CD	<> @[lgs_cost_cd]" ).append("\n"); 
		query.append("				#end" ).append("\n"); 
		query.append("				ORDER BY C.LGS_COST_CD ASC" ).append("\n"); 
		query.append("				)" ).append("\n"); 
		query.append("		CONNECT BY PRIOR ROW_ID = ROW_ID - 1" ).append("\n"); 
		query.append("		START WITH ROW_ID = 1" ).append("\n"); 
		query.append("		) COST_CD_OT" ).append("\n"); 
		query.append("		, (" ).append("\n"); 
		query.append("		SELECT	LTRIM(MAX(SYS_CONNECT_BY_PATH(LGS_COST_CD,'|')),'|')" ).append("\n"); 
		query.append("		FROM	(" ).append("\n"); 
		query.append("				SELECT	C.LGS_COST_CD" ).append("\n"); 
		query.append("					, ROWNUM ROW_ID" ).append("\n"); 
		query.append("				FROM	TES_TML_SO_COST C" ).append("\n"); 
		query.append("					, MDM_YARD Y" ).append("\n"); 
		query.append("				WHERE	DECODE('OS','MT',MRN_TML_FLG,'ON',ODCK_RAIL_CHG_FLG,'OT',FDCK_CY_TML_FLG," ).append("\n"); 
		query.append("									'OS',FDCK_CY_STO_FLG,'ST',STO_INV_FLG)  = 'Y'" ).append("\n"); 
		query.append("				AND		CFS_FLG      IN (DECODE(Y.YD_FCTY_TP_CFS_FLG,'N','N','Y'),'N')" ).append("\n"); 
		query.append("				AND		RAIL_RMP_FLG IN (DECODE(Y.YD_FCTY_TP_RAIL_RMP_FLG,'N','N','Y'),'N')" ).append("\n"); 
		query.append("				AND		XCLD_TML_FLG IN (DECODE(Y.YD_OSHP_CD,'O','Y','N'),'N')" ).append("\n"); 
		query.append("				AND		Y.YD_CD		= @[yd_cd]" ).append("\n"); 
		query.append("				-- // CHM-201432861 TMRFGR 사용국가제한_ US, CA 북미 2국가에서만 발생가능하도록 조치 - 4347-11-20" ).append("\n"); 
		query.append("				#if (${genset_flg} != 'Y') " ).append("\n"); 
		query.append("				AND		C.LGS_COST_CD	<> @[lgs_cost_cd]" ).append("\n"); 
		query.append("				#end" ).append("\n"); 
		query.append("				ORDER BY C.LGS_COST_CD ASC" ).append("\n"); 
		query.append("				)" ).append("\n"); 
		query.append("		CONNECT BY PRIOR ROW_ID = ROW_ID - 1" ).append("\n"); 
		query.append("		START WITH ROW_ID = 1" ).append("\n"); 
		query.append("		) COST_CD_OS" ).append("\n"); 
		query.append("		, (" ).append("\n"); 
		query.append("		SELECT	LTRIM(MAX(SYS_CONNECT_BY_PATH(LGS_COST_CD,'|')),'|')" ).append("\n"); 
		query.append("		FROM	(" ).append("\n"); 
		query.append("				SELECT C.LGS_COST_CD" ).append("\n"); 
		query.append("					, ROWNUM ROW_ID" ).append("\n"); 
		query.append("				FROM	TES_TML_SO_COST C" ).append("\n"); 
		query.append("					, MDM_YARD Y" ).append("\n"); 
		query.append("				WHERE  DECODE('ST','MT',MRN_TML_FLG,'ON',ODCK_RAIL_CHG_FLG,'OT',FDCK_CY_TML_FLG," ).append("\n"); 
		query.append("									'OS',FDCK_CY_STO_FLG,'ST',STO_INV_FLG)  = 'Y'" ).append("\n"); 
		query.append("				AND		CFS_FLG      IN (DECODE(Y.YD_FCTY_TP_CFS_FLG,'N','N','Y'),'N')" ).append("\n"); 
		query.append("				AND		RAIL_RMP_FLG IN (DECODE(Y.YD_FCTY_TP_RAIL_RMP_FLG,'N','N','Y'),'N')" ).append("\n"); 
		query.append("				AND		XCLD_TML_FLG IN (DECODE(Y.YD_OSHP_CD,'O','Y','N'),'N')" ).append("\n"); 
		query.append("				AND		Y.YD_CD		= @[yd_cd]" ).append("\n"); 
		query.append("				-- // CHM-201432861 TMRFGR 사용국가제한_ US, CA 북미 2국가에서만 발생가능하도록 조치 - 4347-11-20" ).append("\n"); 
		query.append("				#if (${genset_flg} != 'Y') " ).append("\n"); 
		query.append("				AND		C.LGS_COST_CD	<> @[lgs_cost_cd]" ).append("\n"); 
		query.append("				#end" ).append("\n"); 
		query.append("				ORDER BY C.LGS_COST_CD ASC" ).append("\n"); 
		query.append("				)" ).append("\n"); 
		query.append("		CONNECT BY PRIOR ROW_ID = ROW_ID - 1" ).append("\n"); 
		query.append("		START WITH ROW_ID = 1" ).append("\n"); 
		query.append("		) COST_CD_ST" ).append("\n"); 
		query.append("		-- // [CHM-201642291]Agreement/invoice에서 Cost Code Description 추가 2016-06-28" ).append("\n"); 
		query.append("		, (" ).append("\n"); 
		query.append("		SELECT	LTRIM(MAX(SYS_CONNECT_BY_PATH(LGS_COST_CD||'\t'||TES_GET_LGS_COST_ABBR_NM_FNC(LGS_COST_CD),'|')),'|')" ).append("\n"); 
		query.append("		FROM	(" ).append("\n"); 
		query.append("				SELECT	C.LGS_COST_CD" ).append("\n"); 
		query.append("					, ROWNUM ROW_ID" ).append("\n"); 
		query.append("				FROM	TES_TML_SO_COST C" ).append("\n"); 
		query.append("					, MDM_YARD Y" ).append("\n"); 
		query.append("				WHERE	DECODE('MT','MT',MRN_TML_FLG,'ON',ODCK_RAIL_CHG_FLG,'OT',FDCK_CY_TML_FLG," ).append("\n"); 
		query.append("									'OS',FDCK_CY_STO_FLG,'ST',STO_INV_FLG)  = 'Y'" ).append("\n"); 
		query.append("				AND		CFS_FLG      IN (DECODE(Y.YD_FCTY_TP_CFS_FLG,'N','N','Y'),'N')" ).append("\n"); 
		query.append("				AND		RAIL_RMP_FLG IN (DECODE(Y.YD_FCTY_TP_RAIL_RMP_FLG,'N','N','Y'),'N')" ).append("\n"); 
		query.append("				AND		XCLD_TML_FLG IN (DECODE(Y.YD_OSHP_CD,'O','Y','N'),'N')" ).append("\n"); 
		query.append("				AND		Y.YD_CD		= @[yd_cd]" ).append("\n"); 
		query.append("				-- // CHM-201432861 TMRFGR 사용국가제한_ US, CA 북미 2국가에서만 발생가능하도록 조치 - 4347-11-20" ).append("\n"); 
		query.append("				#if (${genset_flg} != 'Y') " ).append("\n"); 
		query.append("				AND		C.LGS_COST_CD	<> @[lgs_cost_cd]" ).append("\n"); 
		query.append("				#end" ).append("\n"); 
		query.append("				ORDER BY C.LGS_COST_CD ASC" ).append("\n"); 
		query.append("				)" ).append("\n"); 
		query.append("		CONNECT BY PRIOR ROW_ID = ROW_ID - 1" ).append("\n"); 
		query.append("		START WITH ROW_ID = 1" ).append("\n"); 
		query.append("		) COST_CD_NM_MT" ).append("\n"); 
		query.append("		, (" ).append("\n"); 
		query.append("		SELECT	LTRIM(MAX(SYS_CONNECT_BY_PATH(LGS_COST_CD||'\t'||TES_GET_LGS_COST_ABBR_NM_FNC(LGS_COST_CD),'|')),'|')" ).append("\n"); 
		query.append("		FROM	(" ).append("\n"); 
		query.append("				SELECT	C.LGS_COST_CD" ).append("\n"); 
		query.append("					, ROWNUM ROW_ID" ).append("\n"); 
		query.append("				FROM	TES_TML_SO_COST C" ).append("\n"); 
		query.append("					, MDM_YARD Y" ).append("\n"); 
		query.append("				WHERE  DECODE('ON','MT',MRN_TML_FLG,'ON',ODCK_RAIL_CHG_FLG,'OT',FDCK_CY_TML_FLG," ).append("\n"); 
		query.append("									'OS',FDCK_CY_STO_FLG,'ST',STO_INV_FLG)  = 'Y'" ).append("\n"); 
		query.append("				AND		CFS_FLG      IN (DECODE(Y.YD_FCTY_TP_CFS_FLG,'N','N','Y'),'N')" ).append("\n"); 
		query.append("				--##ON-Dock Manual Cost Code 수정" ).append("\n"); 
		query.append("				--##Manual Cost Code에 TMNDRF, TMNDRM을 불러오기 위해 일시적으로 SQL막아줌. 2007.07.17" ).append("\n"); 
		query.append("				--##AND		RAIL_RMP_FLG IN (DECODE(Y.YD_FCTY_TP_RAIL_RMP_FLG,'N','N','Y'),'N')" ).append("\n"); 
		query.append("				AND		XCLD_TML_FLG IN (DECODE(Y.YD_OSHP_CD,'O','Y','N'),'N')" ).append("\n"); 
		query.append("				AND		Y.YD_CD		= @[yd_cd]" ).append("\n"); 
		query.append("				-- // CHM-201432861 TMRFGR 사용국가제한_ US, CA 북미 2국가에서만 발생가능하도록 조치 - 4347-11-20" ).append("\n"); 
		query.append("				#if (${genset_flg} != 'Y') " ).append("\n"); 
		query.append("				AND		C.LGS_COST_CD	<> @[lgs_cost_cd]" ).append("\n"); 
		query.append("				#end" ).append("\n"); 
		query.append("				ORDER BY C.LGS_COST_CD ASC" ).append("\n"); 
		query.append("				)" ).append("\n"); 
		query.append("		CONNECT BY PRIOR ROW_ID = ROW_ID - 1" ).append("\n"); 
		query.append("		START WITH ROW_ID = 1" ).append("\n"); 
		query.append("		) COST_CD_NM_ON" ).append("\n"); 
		query.append("		, (" ).append("\n"); 
		query.append("		SELECT	LTRIM(MAX(SYS_CONNECT_BY_PATH(LGS_COST_CD||'\t'||TES_GET_LGS_COST_ABBR_NM_FNC(LGS_COST_CD),'|')),'|')" ).append("\n"); 
		query.append("		FROM	(" ).append("\n"); 
		query.append("				SELECT	C.LGS_COST_CD" ).append("\n"); 
		query.append("					, ROWNUM ROW_ID" ).append("\n"); 
		query.append("				FROM	TES_TML_SO_COST C" ).append("\n"); 
		query.append("					, MDM_YARD Y" ).append("\n"); 
		query.append("				WHERE	DECODE('OT','MT',MRN_TML_FLG,'ON',ODCK_RAIL_CHG_FLG,'OT',FDCK_CY_TML_FLG," ).append("\n"); 
		query.append("									'OS',FDCK_CY_STO_FLG,'ST',STO_INV_FLG)  = 'Y'" ).append("\n"); 
		query.append("				AND		CFS_FLG      IN (DECODE(Y.YD_FCTY_TP_CFS_FLG,'N','N','Y'),'N')" ).append("\n"); 
		query.append("				AND		RAIL_RMP_FLG IN (DECODE(Y.YD_FCTY_TP_RAIL_RMP_FLG,'N','N','Y'),'N')" ).append("\n"); 
		query.append("				AND		XCLD_TML_FLG IN (DECODE(Y.YD_OSHP_CD,'O','Y','N'),'N')" ).append("\n"); 
		query.append("				AND		Y.YD_CD		= @[yd_cd]" ).append("\n"); 
		query.append("				#if (${genset_flg} != 'Y') " ).append("\n"); 
		query.append("				AND		C.LGS_COST_CD	<> @[lgs_cost_cd]" ).append("\n"); 
		query.append("				#end" ).append("\n"); 
		query.append("				ORDER BY C.LGS_COST_CD ASC" ).append("\n"); 
		query.append("				)" ).append("\n"); 
		query.append("		CONNECT BY PRIOR ROW_ID = ROW_ID - 1" ).append("\n"); 
		query.append("		START WITH ROW_ID = 1" ).append("\n"); 
		query.append("		) COST_CD_NM_OT" ).append("\n"); 
		query.append("		, (" ).append("\n"); 
		query.append("		SELECT	LTRIM(MAX(SYS_CONNECT_BY_PATH(LGS_COST_CD||'\t'||TES_GET_LGS_COST_ABBR_NM_FNC(LGS_COST_CD),'|')),'|')" ).append("\n"); 
		query.append("		FROM	(" ).append("\n"); 
		query.append("				SELECT	C.LGS_COST_CD" ).append("\n"); 
		query.append("					, ROWNUM ROW_ID" ).append("\n"); 
		query.append("				FROM	TES_TML_SO_COST C" ).append("\n"); 
		query.append("					, MDM_YARD Y" ).append("\n"); 
		query.append("				WHERE	DECODE('OS','MT',MRN_TML_FLG,'ON',ODCK_RAIL_CHG_FLG,'OT',FDCK_CY_TML_FLG," ).append("\n"); 
		query.append("									'OS',FDCK_CY_STO_FLG,'ST',STO_INV_FLG)  = 'Y'" ).append("\n"); 
		query.append("				AND		CFS_FLG      IN (DECODE(Y.YD_FCTY_TP_CFS_FLG,'N','N','Y'),'N')" ).append("\n"); 
		query.append("				AND		RAIL_RMP_FLG IN (DECODE(Y.YD_FCTY_TP_RAIL_RMP_FLG,'N','N','Y'),'N')" ).append("\n"); 
		query.append("				AND		XCLD_TML_FLG IN (DECODE(Y.YD_OSHP_CD,'O','Y','N'),'N')" ).append("\n"); 
		query.append("				AND		Y.YD_CD		= @[yd_cd]" ).append("\n"); 
		query.append("				-- // CHM-201432861 TMRFGR 사용국가제한_ US, CA 북미 2국가에서만 발생가능하도록 조치 - 4347-11-20" ).append("\n"); 
		query.append("				#if (${genset_flg} != 'Y') " ).append("\n"); 
		query.append("				AND		C.LGS_COST_CD	<> @[lgs_cost_cd]" ).append("\n"); 
		query.append("				#end" ).append("\n"); 
		query.append("				ORDER BY C.LGS_COST_CD ASC" ).append("\n"); 
		query.append("				)" ).append("\n"); 
		query.append("		CONNECT BY PRIOR ROW_ID = ROW_ID - 1" ).append("\n"); 
		query.append("		START WITH ROW_ID = 1" ).append("\n"); 
		query.append("		) COST_CD_NM_OS" ).append("\n"); 
		query.append("		, (" ).append("\n"); 
		query.append("		SELECT	LTRIM(MAX(SYS_CONNECT_BY_PATH(LGS_COST_CD||'\t'||TES_GET_LGS_COST_ABBR_NM_FNC(LGS_COST_CD),'|')),'|')" ).append("\n"); 
		query.append("		FROM	(" ).append("\n"); 
		query.append("				SELECT C.LGS_COST_CD" ).append("\n"); 
		query.append("					, ROWNUM ROW_ID" ).append("\n"); 
		query.append("				FROM	TES_TML_SO_COST C" ).append("\n"); 
		query.append("					, MDM_YARD Y" ).append("\n"); 
		query.append("				WHERE  DECODE('ST','MT',MRN_TML_FLG,'ON',ODCK_RAIL_CHG_FLG,'OT',FDCK_CY_TML_FLG," ).append("\n"); 
		query.append("									'OS',FDCK_CY_STO_FLG,'ST',STO_INV_FLG)  = 'Y'" ).append("\n"); 
		query.append("				AND		CFS_FLG      IN (DECODE(Y.YD_FCTY_TP_CFS_FLG,'N','N','Y'),'N')" ).append("\n"); 
		query.append("				AND		RAIL_RMP_FLG IN (DECODE(Y.YD_FCTY_TP_RAIL_RMP_FLG,'N','N','Y'),'N')" ).append("\n"); 
		query.append("				AND		XCLD_TML_FLG IN (DECODE(Y.YD_OSHP_CD,'O','Y','N'),'N')" ).append("\n"); 
		query.append("				AND		Y.YD_CD		= @[yd_cd]" ).append("\n"); 
		query.append("				-- // CHM-201432861 TMRFGR 사용국가제한_ US, CA 북미 2국가에서만 발생가능하도록 조치 - 4347-11-20" ).append("\n"); 
		query.append("				#if (${genset_flg} != 'Y') " ).append("\n"); 
		query.append("				AND		C.LGS_COST_CD	<> @[lgs_cost_cd]" ).append("\n"); 
		query.append("				#end" ).append("\n"); 
		query.append("				ORDER BY C.LGS_COST_CD ASC" ).append("\n"); 
		query.append("				)" ).append("\n"); 
		query.append("		CONNECT BY PRIOR ROW_ID = ROW_ID - 1" ).append("\n"); 
		query.append("		START WITH ROW_ID = 1" ).append("\n"); 
		query.append("		) COST_CD_NM_ST" ).append("\n"); 
		query.append("FROM	MDM_YARD" ).append("\n"); 
		query.append("WHERE	YD_CD	= @[yd_cd]" ).append("\n"); 
		query.append("AND		DELT_FLG = 'N'" ).append("\n"); 
		query.append("GROUP BY YD_CD" ).append("\n"); 
		query.append("	, YD_NM" ).append("\n"); 
		query.append("	, YD_CHR_CD" ).append("\n"); 
		query.append("	, YD_OSHP_CD" ).append("\n"); 
		query.append("	, YD_FCTY_TP_MRN_TML_FLG" ).append("\n"); 
		query.append("	, YD_FCTY_TP_CY_FLG" ).append("\n"); 
		query.append("	, YD_FCTY_TP_CFS_FLG, YD_FCTY_TP_RAIL_RMP_FLG" ).append("\n"); 

	}
}