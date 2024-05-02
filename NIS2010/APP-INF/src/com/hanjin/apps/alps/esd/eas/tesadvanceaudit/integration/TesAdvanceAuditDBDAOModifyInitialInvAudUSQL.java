/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : TesAdvanceAuditDBDAOModifyInitialInvAudUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.05.11
*@LastModifier : 
*@LastVersion : 1.0
* 2016.05.11 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.eas.tesadvanceaudit.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TesAdvanceAuditDBDAOModifyInitialInvAudUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Auto Audit 결과 초기화
	  * </pre>
	  */
	public TesAdvanceAuditDBDAOModifyInitialInvAudUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("to_datetime",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_to_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_fm_dt",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.eas.tesadvanceaudit.integration").append("\n"); 
		query.append("FileName : TesAdvanceAuditDBDAOModifyInitialInvAudUSQL").append("\n"); 
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
		query.append("UPDATE EAS_TML_AUD K" ).append("\n"); 
		query.append("SET	  	K.CURR_CD = NULL" ).append("\n"); 
		query.append("		, K.INV_AMT = NULL" ).append("\n"); 
		query.append("		, K.EXPN_AUD_ESTM_AMT = NULL" ).append("\n"); 
		query.append("		, K.AMT_AUD_TGT_FLG = NULL" ).append("\n"); 
		query.append("		, K.AUD_LGS_COST_CD_QTY = NULL" ).append("\n"); 
		query.append("		, K.VRFY_RSLT_CD_CTNT = NULL" ).append("\n"); 
		query.append("		, K.VOL_AUD_TGT_QTY = NULL" ).append("\n"); 
		query.append("		, K.AUTO_EXPN_AUD_STS_CD = NULL" ).append("\n"); 
		query.append("		, K.AUD_DTL_TGT_QTY = NULL" ).append("\n"); 
		query.append("		, K.CALC_TP_CD_CTNT = NULL" ).append("\n"); 
		query.append("		, K.BAT_VOL_RSLT_CD_QTY = NULL" ).append("\n"); 
		query.append("		, K.BAT_AMT_RSLT_CD_QTY = NULL" ).append("\n"); 
		query.append("		, K.BAT_ESTM_VOL_RSLT_CD_QTY = NULL" ).append("\n"); 
		query.append("#if(${batch_tp_cd} == 'M')" ).append("\n"); 
		query.append("		, K.EXPN_AUD_STS_CD = NULL" ).append("\n"); 
		query.append("		, K.EXPN_AUD_RSLT_RMK	= NULL" ).append("\n"); 
		query.append("		, K.EXPN_AUD_RSLT_USR_ID = NULL" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("WHERE	1	= 1" ).append("\n"); 
		query.append("AND		(INV_NO, VNDR_SEQ, INV_CFM_DT, TML_INV_TP_CD" ).append("\n"); 
		query.append("		, NVL(VSL_CD, 'X')" ).append("\n"); 
		query.append("		, NVL(SKD_VOY_NO, 'X')" ).append("\n"); 
		query.append("		, NVL(SKD_DIR_CD, 'X')" ).append("\n"); 
		query.append("		, NVL(IO_BND_CD, 'X')) IN (" ).append("\n"); 
		query.append("				SELECT	  H.INV_NO" ).append("\n"); 
		query.append("						, H.VNDR_SEQ" ).append("\n"); 
		query.append("						, H.INV_CFM_DT" ).append("\n"); 
		query.append("						, H.TML_INV_TP_CD" ).append("\n"); 
		query.append("						, NVL((CASE WHEN H.TML_INV_TP_CD = 'TM' THEN D.VSL_CD ELSE NULL END),'X') VSL_CD" ).append("\n"); 
		query.append("						, NVL((CASE WHEN H.TML_INV_TP_CD = 'TM' THEN D.SKD_VOY_NO ELSE NULL END),'X') SKD_VOY_NO" ).append("\n"); 
		query.append("						, NVL((CASE WHEN H.TML_INV_TP_CD = 'TM' THEN D.SKD_DIR_CD ELSE NULL END),'X') SKD_DIR_CD" ).append("\n"); 
		query.append("						, NVL((CASE WHEN H.TML_INV_TP_CD = 'TM' THEN D.IO_BND_CD ELSE NULL END),'X') IO_BND_CD" ).append("\n"); 
		query.append("				FROM	TES_TML_SO_HDR H" ).append("\n"); 
		query.append("						, TES_TML_SO_DTL D" ).append("\n"); 
		query.append("						, TES_TML_SO_COST C" ).append("\n"); 
		query.append("						#if(${batch_tp_cd} == 'M')" ).append("\n"); 
		query.append("						, EAS_AUTO_AUD_BAT X" ).append("\n"); 
		query.append("						#end" ).append("\n"); 
		query.append("				WHERE	H.TML_SO_OFC_CTY_CD	= D.TML_SO_OFC_CTY_CD" ).append("\n"); 
		query.append("				AND		H.TML_SO_SEQ		= D.TML_SO_SEQ" ).append("\n"); 
		query.append("--				AND		NVL(H.DELT_FLG, 'N')	<> 'Y' -- 미심사 된 자료중 삭제된 Invoice는 심사 자료에서도 삭제 처리한다." ).append("\n"); 
		query.append("--				AND		H.TML_INV_STS_CD	<> 'R'" ).append("\n"); 
		query.append("--				AND		H.TML_INV_RJCT_STS_CD	<> 'RJ'" ).append("\n"); 
		query.append("				-- 2시간 배치 -> 1일전으로 수정" ).append("\n"); 
		query.append("				#if(${batch_tp_cd} == 'A')" ).append("\n"); 
		query.append("				AND		H.INV_CFM_DT BETWEEN TO_DATE(@[to_datetime], 'YYYYMMDDHH24MISS') - 1 AND TO_DATE(@[to_datetime], 'YYYYMMDDHH24MISS')" ).append("\n"); 
		query.append("				#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("				-- 실시간(5분) 배치" ).append("\n"); 
		query.append("				#if(${batch_tp_cd} == 'M')" ).append("\n"); 
		query.append("				AND		H.INV_NO			= X.INV_NO" ).append("\n"); 
		query.append("				AND		H.VNDR_SEQ			= X.INV_VNDR_SEQ" ).append("\n"); 
		query.append("				AND		H.INV_CFM_DT		= X.INV_CFM_DT" ).append("\n"); 
		query.append("				AND		(CASE WHEN H.TML_INV_TP_CD = 'TM' THEN D.VSL_CD ELSE 'X' END) = NVL(X.VSL_CD, 'X')" ).append("\n"); 
		query.append("				AND		(CASE WHEN H.TML_INV_TP_CD = 'TM' THEN D.SKD_VOY_NO ELSE 'X' END) = NVL(X.SKD_VOY_NO, 'X')" ).append("\n"); 
		query.append("				AND		(CASE WHEN H.TML_INV_TP_CD = 'TM' THEN D.SKD_DIR_CD ELSE 'X' END) = NVL(X.SKD_DIR_CD, 'X')" ).append("\n"); 
		query.append("				AND		(CASE WHEN H.TML_INV_TP_CD = 'TM' THEN D.IO_BND_CD ELSE 'X' END) = NVL(X.IO_BND_CD, 'X')" ).append("\n"); 
		query.append("				AND		X.BAT_PROG_STS_CD	= 'P'" ).append("\n"); 
		query.append("				AND		X.SUB_SYS_CD		= 'TES'" ).append("\n"); 
		query.append("				#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("				-- 메뉴얼 기간 배치 (Period로 조회)" ).append("\n"); 
		query.append("				#if(${batch_tp_cd} == 'E')" ).append("\n"); 
		query.append("				AND		H.INV_CFM_DT BETWEEN TO_DATE(@[s_fm_dt], 'YYYY-MM-DD') AND TO_DATE(@[s_to_dt], 'YYYY-MM-DD') + 0.99999" ).append("\n"); 
		query.append("				AND		NOT EXISTS (SELECT	'X'" ).append("\n"); 
		query.append("									FROM	EAS_TML_AUD X" ).append("\n"); 
		query.append("									WHERE	X.INV_NO			= H.INV_NO" ).append("\n"); 
		query.append("									AND		X.VNDR_SEQ			= H.VNDR_SEQ" ).append("\n"); 
		query.append("									AND		X.INV_CFM_DT		= H.INV_CFM_DT" ).append("\n"); 
		query.append("									)" ).append("\n"); 
		query.append("				#end" ).append("\n"); 
		query.append("				AND		D.LGS_COST_CD		= C.LGS_COST_CD" ).append("\n"); 
		query.append("				AND		C.EAS_AUD_FLG		= 'Y'" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("				#if(${batch_tp_cd} != 'M')" ).append("\n"); 
		query.append("				AND		NOT EXISTS (" ).append("\n"); 
		query.append("							SELECT	1" ).append("\n"); 
		query.append("							FROM	EAS_TML_AUD A" ).append("\n"); 
		query.append("							WHERE	A.INV_NO				= H.INV_NO" ).append("\n"); 
		query.append("							AND		A.VNDR_SEQ				= H.VNDR_SEQ" ).append("\n"); 
		query.append("							AND		A.INV_CFM_DT			= H.INV_CFM_DT" ).append("\n"); 
		query.append("							AND		NVL(A.VSL_CD,'X')		= (CASE WHEN H.TML_INV_TP_CD = 'TM' THEN D.VSL_CD ELSE 'X' END)" ).append("\n"); 
		query.append("							AND		NVL(A.SKD_VOY_NO,'X')	= (CASE WHEN H.TML_INV_TP_CD = 'TM' THEN D.SKD_VOY_NO ELSE 'X' END)" ).append("\n"); 
		query.append("							AND		NVL(A.SKD_DIR_CD,'X')	= (CASE WHEN H.TML_INV_TP_CD = 'TM' THEN D.SKD_DIR_CD ELSE 'X' END)" ).append("\n"); 
		query.append("							AND		NVL(A.IO_BND_CD,'X')	= (CASE WHEN H.TML_INV_TP_CD = 'TM' THEN D.IO_BND_CD ELSE 'X' END)" ).append("\n"); 
		query.append("							AND		NVL(A.FM_PRD_DT,'X')	= (CASE WHEN H.TML_INV_TP_CD IN ('ST', 'OF') THEN H.FM_PRD_DT ELSE 'X' END)" ).append("\n"); 
		query.append("							AND		NVL(A.TO_PRD_DT,'X')	= (CASE WHEN H.TML_INV_TP_CD IN ('ST', 'OF') THEN H.TO_PRD_DT ELSE 'X' END)" ).append("\n"); 
		query.append("							AND		A.EXPN_AUD_STS_CD IN ('A', 'P', 'E')" ).append("\n"); 
		query.append("							)" ).append("\n"); 
		query.append("				#end" ).append("\n"); 
		query.append("				GROUP BY H.INV_NO, H.VNDR_SEQ, H.INV_CFM_DT, H.TML_INV_TP_CD" ).append("\n"); 
		query.append("						, NVL((CASE WHEN H.TML_INV_TP_CD = 'TM' THEN D.VSL_CD ELSE NULL END),'X')" ).append("\n"); 
		query.append("						, NVL((CASE WHEN H.TML_INV_TP_CD = 'TM' THEN D.SKD_VOY_NO ELSE NULL END),'X')" ).append("\n"); 
		query.append("						, NVL((CASE WHEN H.TML_INV_TP_CD = 'TM' THEN D.SKD_DIR_CD ELSE NULL END),'X')" ).append("\n"); 
		query.append("						, NVL((CASE WHEN H.TML_INV_TP_CD = 'TM' THEN D.IO_BND_CD ELSE NULL END),'X')" ).append("\n"); 
		query.append("				#if(${batch_tp_cd} != 'M')" ).append("\n"); 
		query.append("				UNION" ).append("\n"); 
		query.append("				SELECT	  A.INV_NO" ).append("\n"); 
		query.append("						, A.VNDR_SEQ" ).append("\n"); 
		query.append("						, A.INV_CFM_DT" ).append("\n"); 
		query.append("						, A.TML_INV_TP_CD" ).append("\n"); 
		query.append("						, NVL((CASE WHEN A.TML_INV_TP_CD = 'TM' THEN A.VSL_CD ELSE NULL END),'X') VSL_CD" ).append("\n"); 
		query.append("						, NVL((CASE WHEN A.TML_INV_TP_CD = 'TM' THEN A.SKD_VOY_NO ELSE NULL END),'X') SKD_VOY_NO" ).append("\n"); 
		query.append("						, NVL((CASE WHEN A.TML_INV_TP_CD = 'TM' THEN A.SKD_DIR_CD ELSE NULL END),'X') SKD_DIR_CD" ).append("\n"); 
		query.append("						, NVL((CASE WHEN A.TML_INV_TP_CD = 'TM' THEN A.IO_BND_CD ELSE NULL END),'X') IO_BND_CD" ).append("\n"); 
		query.append("				FROM	TES_TML_SO_HDR H" ).append("\n"); 
		query.append("						, TES_TML_SO_DTL D" ).append("\n"); 
		query.append("						, EAS_TML_AUD A" ).append("\n"); 
		query.append("				WHERE	A.INV_NO			= H.INV_NO" ).append("\n"); 
		query.append("				AND		A.VNDR_SEQ			= H.VNDR_SEQ" ).append("\n"); 
		query.append("				AND		A.INV_CFM_DT		= H.INV_CFM_DT" ).append("\n"); 
		query.append("				AND		A.VSL_CD			= (CASE WHEN H.TML_INV_TP_CD = 'TM' THEN D.VSL_CD ELSE NULL END)" ).append("\n"); 
		query.append("				AND		A.SKD_VOY_NO		= (CASE WHEN H.TML_INV_TP_CD = 'TM' THEN D.SKD_VOY_NO ELSE NULL END)" ).append("\n"); 
		query.append("				AND		A.SKD_DIR_CD		= (CASE WHEN H.TML_INV_TP_CD = 'TM' THEN D.SKD_DIR_CD ELSE NULL END)" ).append("\n"); 
		query.append("				AND		A.IO_BND_CD			= (CASE WHEN H.TML_INV_TP_CD = 'TM' THEN D.IO_BND_CD ELSE NULL END)" ).append("\n"); 
		query.append("				AND		H.TML_SO_OFC_CTY_CD	= D.TML_SO_OFC_CTY_CD" ).append("\n"); 
		query.append("				AND		H.TML_SO_SEQ		= D.TML_SO_SEQ" ).append("\n"); 
		query.append("				AND		(A.BAT_VOL_RSLT_CD = 'F' OR A.BAT_AMT_RSLT_CD = 'F' OR A.BAT_ESTM_VOL_RSLT_CD = 'F')" ).append("\n"); 
		query.append("				AND		A.CRE_DT > TO_DATE(@[to_datetime], 'YYYYMMDDHH24MISS') - 14" ).append("\n"); 
		query.append("				#end" ).append("\n"); 
		query.append("				)" ).append("\n"); 

	}
}