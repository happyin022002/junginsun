/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : GuaranteeManageDBDAOSearchUSGuaranteeListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.08.04
*@LastModifier : 
*@LastVersion : 1.0
* 2015.08.04 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.tes.guaranteemanage.guaranteemanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class GuaranteeManageDBDAOSearchUSGuaranteeListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Guarantee 목록 조회
	  * </pre>
	  */
	public GuaranteeManageDBDAOSearchUSGuaranteeListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("gnte_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("gnte_cust_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vndr_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("to_cre_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("gnte_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("delt_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fm_cre_dt",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.tes.guaranteemanage.guaranteemanage.integration").append("\n"); 
		query.append("FileName : GuaranteeManageDBDAOSearchUSGuaranteeListRSQL").append("\n"); 
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
		query.append("SELECT " ).append("\n"); 
		query.append("		GH.GNTE_NO" ).append("\n"); 
		query.append("		, GL.CNTR_NO" ).append("\n"); 
		query.append("		, GL.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("		, CASE	WHEN GH.GNTE_TP_CD = 'ST'	THEN 'Storage'" ).append("\n"); 
		query.append("				WHEN GH.GNTE_TP_CD = 'FL'	THEN 'Flip'" ).append("\n"); 
		query.append("				WHEN GH.GNTE_TP_CD = 'CY'	THEN 'Other'" ).append("\n"); 
		query.append("		END GNTE_TP_CD" ).append("\n"); 
		query.append("		, CASE	WHEN GL.TML_IF_OFC_CD IS NOT NULL AND GL.TML_IF_SEQ IS NOT NULL " ).append("\n"); 
		query.append("				THEN 'Y'" ).append("\n"); 
		query.append("				ELSE 'N'" ).append("\n"); 
		query.append("		END CHK_TPB_IF" ).append("\n"); 
		query.append("		, CASE	WHEN GL.IRR_NO IS NOT NULL" ).append("\n"); 
		query.append("				THEN 'IRR'" ).append("\n"); 
		query.append("				ELSE 'Cost'" ).append("\n"); 
		query.append("		END CHK_IRR" ).append("\n"); 
		query.append("		, GL.BKG_NO" ).append("\n"); 
		query.append("		, GL.BL_NO" ).append("\n"); 
		query.append("		, GL.SC_NO" ).append("\n"); 
		query.append("        , TO_CHAR(GL.FM_DT, 'YYYY-MM-DD') FM_DT		" ).append("\n"); 
		query.append("        , TO_CHAR(GL.TO_DT, 'YYYY-MM-DD') TO_DT		" ).append("\n"); 
		query.append("		, NVL(GL.GNTE_AMT, 0) GNTE_AMT" ).append("\n"); 
		query.append("		, (" ).append("\n"); 
		query.append("		SELECT	I.N3PTY_INV_NO" ).append("\n"); 
		query.append("		FROM	TPB_OTS_DTL D" ).append("\n"); 
		query.append("				, TPB_OTS_GRP M" ).append("\n"); 
		query.append("				, TPB_INV_RVIS I" ).append("\n"); 
		query.append("		WHERE	1   = 1" ).append("\n"); 
		query.append("		AND		D.N3PTY_NO		= M.N3PTY_NO" ).append("\n"); 
		query.append("		AND		M.N3PTY_INV_NO	= I.N3PTY_INV_NO" ).append("\n"); 
		query.append("		AND		I.N3PTY_INV_RVIS_SEQ	= 1" ).append("\n"); 
		query.append("		AND		D.N3PTY_EXPN_TP_CD		= 'TES'" ).append("\n"); 
		query.append("		AND		N3PTY_IF_TP_CD			= 'S'   -- TPB로 자동으로 넘어온 건" ).append("\n"); 
		query.append("		AND		D.MNL_INP_TP_CD			= 'G'" ).append("\n"); 
		query.append("		AND		D.IF_OFC_CD		= GL.TML_IF_OFC_CD" ).append("\n"); 
		query.append("		AND		D.SRC_IF_SEQ_NO	= GL.TML_IF_SEQ" ).append("\n"); 
		query.append("		) TPB_INV_NO" ).append("\n"); 
		query.append("		, GH.DELT_FLG" ).append("\n"); 
		query.append("		, CASE	WHEN NVL(DELT_FLG, 'N') <> 'Y' " ).append("\n"); 
		query.append("				THEN GH.CRE_USR_ID" ).append("\n"); 
		query.append("				ELSE GH.UPD_USR_ID" ).append("\n"); 
		query.append("		END CRE_USR_ID" ).append("\n"); 
		query.append("		, CASE	WHEN NVL(DELT_FLG, 'N') <> 'Y' " ).append("\n"); 
		query.append("				THEN (SELECT USR_NM FROM COM_USER WHERE USR_ID = GH.CRE_USR_ID)" ).append("\n"); 
		query.append("				ELSE (SELECT USR_NM FROM COM_USER WHERE USR_ID = GH.UPD_USR_ID)" ).append("\n"); 
		query.append("		END USR_NM" ).append("\n"); 
		query.append("		, CASE	WHEN NVL(DELT_FLG, 'N') <> 'Y' " ).append("\n"); 
		query.append("				THEN TO_CHAR(GLOBALDATE_PKG.TIME_CONV_OFC_FNC('SELOPA', GH.CRE_DT, GH.OFC_CD), 'YYYY-MM-DD') -- 2015-08-03 그룹사 조직 코드 변경 (SELCOT->SELOPA)" ).append("\n"); 
		query.append("				ELSE TO_CHAR(GLOBALDATE_PKG.TIME_CONV_OFC_FNC('SELOPA', GH.UPD_DT, GH.OFC_CD), 'YYYY-MM-DD') -- 2015-08-03 그룹사 조직 코드 변경 (SELCOT->SELOPA)" ).append("\n"); 
		query.append("		END CRE_DT" ).append("\n"); 
		query.append("		, GH.YD_CD" ).append("\n"); 
		query.append("		, LPAD(GH.VNDR_SEQ, 6, '0') VNDR_SEQ" ).append("\n"); 
		query.append("		, (SELECT VNDR_LGL_ENG_NM FROM MDM_VENDOR" ).append("\n"); 
		query.append("			WHERE VNDR_SEQ = GH.VNDR_SEQ) VNDR_SEQ_NAME" ).append("\n"); 
		query.append("FROM	TES_GNTE_HDR GH" ).append("\n"); 
		query.append("		, TES_GNTE_CNTR_LIST GL" ).append("\n"); 
		query.append("WHERE	1	= 1" ).append("\n"); 
		query.append("AND		NVL(GH.DMY_FLG,'N') <> 'Y'" ).append("\n"); 
		query.append("AND		GH.GNTE_NO			= GL.GNTE_NO(+)" ).append("\n"); 
		query.append("#if (${gnte_no} != '')" ).append("\n"); 
		query.append("AND		GH.GNTE_NO		= @[gnte_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${ofc_cd} != '') " ).append("\n"); 
		query.append("AND		GH.OFC_CD		= @[ofc_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${cre_usr_id} != '') " ).append("\n"); 
		query.append("AND		GH.CRE_USR_ID	= @[cre_usr_id]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${gnte_tp_cd} != '') " ).append("\n"); 
		query.append("AND		GH.GNTE_TP_CD	= @[gnte_tp_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${gnte_cust_cd} != '') " ).append("\n"); 
		query.append("AND		GH.GNTE_CUST_CD		= @[gnte_cust_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${delt_flg} != '') " ).append("\n"); 
		query.append("AND		NVL(GH.DELT_FLG, 'N')	= @[delt_flg]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${vndr_seq} != '') " ).append("\n"); 
		query.append("AND		GH.VNDR_SEQ		= @[vndr_seq]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${ofc_cd} == '') " ).append("\n"); 
		query.append("AND GH.CRE_DT BETWEEN TO_DATE(@[fm_cre_dt], 'YYYY-MM-DD') AND TO_DATE(@[to_cre_dt], 'YYYY-MM-DD')" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("AND		GH.CRE_DT BETWEEN TO_DATE(@[fm_cre_dt], 'YYYY-MM-DD') + (540/24/60 - GLOBALDATE_PKG.GET_GMTHRS_FNC(@[ofc_cd])/24/60 ) AND TO_DATE(@[to_cre_dt], 'YYYY-MM-DD') + (540/24/60 - GLOBALDATE_PKG.GET_GMTHRS_FNC(@[ofc_cd])/24/60) + 0.99999" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("ORDER BY GH.GNTE_NO" ).append("\n"); 

	}
}