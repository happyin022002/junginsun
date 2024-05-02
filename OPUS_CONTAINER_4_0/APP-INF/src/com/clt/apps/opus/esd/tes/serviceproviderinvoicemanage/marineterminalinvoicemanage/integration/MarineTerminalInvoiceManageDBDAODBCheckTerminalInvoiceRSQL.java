/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : MarineTerminalInvoiceManageDBDAODBCheckTerminalInvoiceRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.12.29
*@LastModifier : 
*@LastVersion : 1.0
* 2015.12.29 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.tes.serviceproviderinvoicemanage.marineterminalinvoicemanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class MarineTerminalInvoiceManageDBDAODBCheckTerminalInvoiceRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * DBCheckTerminalInvoice
	  * </pre>
	  */
	public MarineTerminalInvoiceManageDBDAODBCheckTerminalInvoiceRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("vndr_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("atb_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("io_bnd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tml_so_ofc_cty_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tml_so_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("to_prd_dt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("fm_prd_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("min_wrk_dt",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.tes.serviceproviderinvoicemanage.marineterminalinvoicemanage.integration").append("\n"); 
		query.append("FileName : MarineTerminalInvoiceManageDBDAODBCheckTerminalInvoiceRSQL").append("\n"); 
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
		query.append("SELECT  MAX(BB.INV_NO) INV_NO, BB.CNTR_NO" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("    SELECT A.COST_CODE, C.CNTR_NO " ).append("\n"); 
		query.append("    FROM(" ).append("\n"); 
		query.append("        SELECT DISTINCT DECODE(1,0,C.LGS_COST_CD,DECODE(C.LGS_COST_CD,CD,TP,C.LGS_COST_CD)) COST_CODE" ).append("\n"); 
		query.append("        FROM ( SELECT COUNT(T.LGS_COST_CD) CNT," ).append("\n"); 
		query.append("             T.LGS_COST_CD TP," ).append("\n"); 
		query.append("             T.THRP_LGS_COST_CD CD," ).append("\n"); 
		query.append("             H.TML_AGMT_OFC_CTY_CD CTY," ).append("\n"); 
		query.append("             H.TML_AGMT_SEQ SEQ," ).append("\n"); 
		query.append("             H.TML_AGMT_VER_NO NO" ).append("\n"); 
		query.append("            FROM   TES_TML_AGMT_HDR H, TES_TML_AGMT_THRP_COST T" ).append("\n"); 
		query.append("            WHERE  H.YD_CD            = @[yd_cd]" ).append("\n"); 
		query.append("            AND    H.VNDR_SEQ         = @[vndr_seq]" ).append("\n"); 
		query.append("            AND    H.TML_AGMT_STS_CD = 'C'" ).append("\n"); 
		query.append("            AND    H.DELT_FLG        = 'N'" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${agmt_ftr_inv_tp_cd} == 'MT') " ).append("\n"); 
		query.append("    AND    TO_CHAR(H.EFF_FM_DT,'YYYYMMDD') <= REPLACE(@[atb_dt],'-') -- ATB Date([atb_dt]) ==> Marine Terminal Invoice" ).append("\n"); 
		query.append("    AND    TO_CHAR(H.EFF_TO_DT,'YYYYMMDD') >= REPLACE(@[atb_dt],'-') -- ATB Date([atb_dt]) ==> Marine Terminal Invoice" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#elseif (${agmt_ftr_inv_tp_cd} == 'ST' || ${agmt_ftr_inv_tp_cd} == 'OS')" ).append("\n"); 
		query.append("       AND    TO_CHAR(H.EFF_FM_DT,'YYYYMMDD') <= REPLACE(@[fm_prd_dt],'-') -- From Period Date([fm_prd_dt]) ==> Marine Storage/OFF Dock Sotrage Invoice " ).append("\n"); 
		query.append("       AND    TO_CHAR(H.EFF_TO_DT,'YYYYMMDD') >= REPLACE(@[fm_prd_dt],'-') -- From Period Date([fm_prd_dt]) ==> Marine Storage/OFF Dock Sotrage Invoice " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#elseif (${agmt_ftr_inv_tp_cd} == 'OT' || ${agmt_ftr_inv_tp_cd} == 'OFON' || ${agmt_ftr_inv_tp_cd} == 'OTOS')" ).append("\n"); 
		query.append("       AND    TO_CHAR(H.EFF_FM_DT,'YYYYMMDD') <= REPLACE(@[to_prd_dt],'-') -- To Period Date([to_prd_dt]) ==> OFF Dock Terminal Invoice (ON Dock 비용계산시)" ).append("\n"); 
		query.append("       AND    TO_CHAR(H.EFF_TO_DT,'YYYYMMDD') >= REPLACE(@[to_prd_dt],'-') -- To Period Date([to_prd_dt]) ==> OFF Dock Terminal Invoice (ON Dock 비용계산시)" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#elseif (${agmt_ftr_inv_tp_cd} == 'ON')" ).append("\n"); 
		query.append("    AND    TO_CHAR(H.EFF_FM_DT,'YYYYMMDD') <= REPLACE(@[min_wrk_dt],'-') -- Min Work Date([min_wrk_dt]) ==> OnDock Rail Invoice" ).append("\n"); 
		query.append("    AND    TO_CHAR(H.EFF_TO_DT,'YYYYMMDD') >= REPLACE(@[min_wrk_dt],'-') -- Max Work Date([max_wrk_dt]) ==> OnDock Rail Invoice" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("            AND    H.TML_AGMT_VER_NO = ( SELECT MAX(M.TML_AGMT_VER_NO)" ).append("\n"); 
		query.append("                 FROM   TES_TML_AGMT_HDR M" ).append("\n"); 
		query.append("                 WHERE  M.YD_CD               = @[yd_cd]" ).append("\n"); 
		query.append("                 AND    M.VNDR_SEQ            = @[vndr_seq]" ).append("\n"); 
		query.append("                 AND    M.TML_AGMT_STS_CD     = 'C'" ).append("\n"); 
		query.append("                 AND    M.DELT_FLG            = 'N'" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${agmt_ftr_inv_tp_cd} == 'MT') " ).append("\n"); 
		query.append("            AND    TO_CHAR(M.EFF_FM_DT,'YYYYMMDD') <= REPLACE(@[atb_dt],'-') -- ATB Date([atb_dt]) ==> Marine Terminal Invoice" ).append("\n"); 
		query.append("            AND    TO_CHAR(M.EFF_TO_DT,'YYYYMMDD') >= REPLACE(@[atb_dt],'-')) -- ATB Date([atb_dt]) ==> Marine Terminal Invoice" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#elseif (${agmt_ftr_inv_tp_cd} == 'ST' || ${agmt_ftr_inv_tp_cd} == 'OS')" ).append("\n"); 
		query.append("            AND    TO_CHAR(M.EFF_FM_DT,'YYYYMMDD') <= REPLACE(@[fm_prd_dt],'-') -- From Period Date([fm_prd_dt]) ==> Marine Storage/OFF Dock Sotrage Invoice " ).append("\n"); 
		query.append("            AND    TO_CHAR(M.EFF_TO_DT,'YYYYMMDD') >= REPLACE(@[fm_prd_dt],'-')) -- From Period Date([fm_prd_dt]) ==> Marine Storage/OFF Dock Sotrage Invoice " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#elseif (${agmt_ftr_inv_tp_cd} == 'OT' || ${agmt_ftr_inv_tp_cd} == 'OFON' || ${agmt_ftr_inv_tp_cd} == 'OTOS')" ).append("\n"); 
		query.append("            AND    TO_CHAR(M.EFF_FM_DT,'YYYYMMDD') <= REPLACE(@[to_prd_dt],'-') -- To Period Date([to_prd_dt]) ==> OFF Dock Terminal Invoice (ON Dock 비용계산시)" ).append("\n"); 
		query.append("            AND    TO_CHAR(M.EFF_TO_DT,'YYYYMMDD') >= REPLACE(@[to_prd_dt],'-')) -- To Period Date([to_prd_dt]) ==> OFF Dock Terminal Invoice (ON Dock 비용계산시)" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#elseif (${agmt_ftr_inv_tp_cd} == 'ON')" ).append("\n"); 
		query.append("            AND    TO_CHAR(M.EFF_FM_DT,'YYYYMMDD') <= REPLACE(@[min_wrk_dt],'-') -- Min Work Date([min_wrk_dt]) ==> OnDock Rail Invoice" ).append("\n"); 
		query.append("            AND    TO_CHAR(M.EFF_TO_DT,'YYYYMMDD') >= REPLACE(@[min_wrk_dt],'-')) -- Max Work Date([max_wrk_dt]) ==> OnDock Rail Invoice" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("			AND 1=2 )" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("            AND    H.TML_AGMT_OFC_CTY_CD = T.TML_AGMT_OFC_CTY_CD(+)" ).append("\n"); 
		query.append("            AND    H.TML_AGMT_SEQ        = T.TML_AGMT_SEQ(+)" ).append("\n"); 
		query.append("            AND    H.TML_AGMT_VER_NO     = T.TML_AGMT_VER_NO(+)" ).append("\n"); 
		query.append("            GROUP BY H.TML_AGMT_OFC_CTY_CD, H.TML_AGMT_SEQ, H.TML_AGMT_VER_NO," ).append("\n"); 
		query.append("            T.LGS_COST_CD, T.THRP_LGS_COST_CD ) A, TES_TML_SO_COST C, TES_TML_AGMT_DTL D" ).append("\n"); 
		query.append("        WHERE  C.COST_CALC_MZD_CD = 'A'" ).append("\n"); 
		query.append("        AND    C.TML_AGMT_MGMT_CD = 'A'" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${agmt_ftr_inv_tp_cd} == 'MT')" ).append("\n"); 
		query.append("AND    C.MRN_TML_FLG = 'Y'  -- Marine Terminal Invoice" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#elseif (${agmt_ftr_inv_tp_cd} == 'ON')" ).append("\n"); 
		query.append("AND    C.ODCK_RAIL_CHG_FLG = 'Y' -- OnDock Rail Invoice" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#elseif (${agmt_ftr_inv_tp_cd} == 'OT' || ${agmt_ftr_inv_tp_cd} == 'OTOS' )" ).append("\n"); 
		query.append("AND    C.FDCK_CY_TML_FLG = 'Y' -- OFF Dock Terminal Invoice" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#elseif (${agmt_ftr_inv_tp_cd} == 'OS')" ).append("\n"); 
		query.append("AND    C.FDCK_CY_STO_FLG = 'Y' -- OFF Dock Storage Invoice" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#elseif (${agmt_ftr_inv_tp_cd} == 'OFON')" ).append("\n"); 
		query.append("AND    C.MRN_TML_FLG = 'Y' AND C.LGS_COST_CD LIKE 'TMND%'  -- OFF Dock 화면에서 ON Dock 비용계산시" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#elseif (${agmt_ftr_inv_tp_cd} == 'ST')" ).append("\n"); 
		query.append("AND    C.STO_INV_FLG = 'Y'  -- Marine Storage Invoice " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("        AND    D.TML_AGMT_OFC_CTY_CD = A.CTY" ).append("\n"); 
		query.append("        AND    D.TML_AGMT_SEQ = A.SEQ" ).append("\n"); 
		query.append("        AND    D.TML_AGMT_VER_NO  = A.NO" ).append("\n"); 
		query.append("        AND    C.LGS_COST_CD = D.LGS_COST_CD" ).append("\n"); 
		query.append("        AND    DECODE(A.CNT,0,DECODE(SUBSTR(C.LGS_COST_CD,1,2),'TP','N','Y'),'Y') = 'Y' " ).append("\n"); 
		query.append("        AND    D.THRP_COST_CD_FLG IS NULL" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("--OTOS이면 OS용" ).append("\n"); 
		query.append("#if (${agmt_ftr_inv_tp_cd} == 'OTOS') " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("    SELECT DISTINCT DECODE(1,0,C.LGS_COST_CD,DECODE(C.LGS_COST_CD,CD,TP,C.LGS_COST_CD)) COST_CODE" ).append("\n"); 
		query.append("    FROM ( SELECT COUNT(T.LGS_COST_CD) CNT," ).append("\n"); 
		query.append("         T.LGS_COST_CD TP," ).append("\n"); 
		query.append("         T.THRP_LGS_COST_CD CD," ).append("\n"); 
		query.append("         H.TML_AGMT_OFC_CTY_CD CTY," ).append("\n"); 
		query.append("         H.TML_AGMT_SEQ SEQ," ).append("\n"); 
		query.append("         H.TML_AGMT_VER_NO NO" ).append("\n"); 
		query.append("        FROM   TES_TML_AGMT_HDR H, TES_TML_AGMT_THRP_COST T" ).append("\n"); 
		query.append("        WHERE  H.YD_CD            = @[yd_cd]" ).append("\n"); 
		query.append("        AND    H.VNDR_SEQ         = @[vndr_seq]" ).append("\n"); 
		query.append("        AND    H.TML_AGMT_STS_CD = 'C'" ).append("\n"); 
		query.append("        AND    H.DELT_FLG        = 'N'" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("        AND    TO_CHAR(H.EFF_FM_DT,'YYYYMMDD') <= REPLACE(@[fm_prd_dt],'-') -- From Period Date([fm_prd_dt]) ==> Marine Storage/OFF Dock Sotrage Invoice " ).append("\n"); 
		query.append("        AND    TO_CHAR(H.EFF_TO_DT,'YYYYMMDD') >= REPLACE(@[fm_prd_dt],'-') -- From Period Date([fm_prd_dt]) ==> Marine Storage/OFF Dock Sotrage Invoice " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("        AND    H.TML_AGMT_VER_NO = ( SELECT MAX(M.TML_AGMT_VER_NO)" ).append("\n"); 
		query.append("             FROM   TES_TML_AGMT_HDR M" ).append("\n"); 
		query.append("             WHERE  M.YD_CD               = @[yd_cd]" ).append("\n"); 
		query.append("             AND    M.VNDR_SEQ            = @[vndr_seq]" ).append("\n"); 
		query.append("             AND    M.TML_AGMT_STS_CD     = 'C'" ).append("\n"); 
		query.append("             AND    M.DELT_FLG            = 'N'" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("             AND    TO_CHAR(M.EFF_FM_DT,'YYYYMMDD') <= REPLACE(@[fm_prd_dt],'-') -- From Period Date([fm_prd_dt]) ==> Marine Storage/OFF Dock Sotrage Invoice " ).append("\n"); 
		query.append("             AND    TO_CHAR(M.EFF_TO_DT,'YYYYMMDD') >= REPLACE(@[fm_prd_dt],'-')) -- From Period Date([fm_prd_dt]) ==> Marine Storage/OFF Dock Sotrage Invoice " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("        AND    H.TML_AGMT_OFC_CTY_CD = T.TML_AGMT_OFC_CTY_CD(+)" ).append("\n"); 
		query.append("        AND    H.TML_AGMT_SEQ        = T.TML_AGMT_SEQ(+)" ).append("\n"); 
		query.append("        AND    H.TML_AGMT_VER_NO     = T.TML_AGMT_VER_NO(+)" ).append("\n"); 
		query.append("        GROUP BY H.TML_AGMT_OFC_CTY_CD, H.TML_AGMT_SEQ, H.TML_AGMT_VER_NO," ).append("\n"); 
		query.append("        T.LGS_COST_CD, T.THRP_LGS_COST_CD ) A, TES_TML_SO_COST C, TES_TML_AGMT_DTL D" ).append("\n"); 
		query.append("    WHERE  C.COST_CALC_MZD_CD = 'A'" ).append("\n"); 
		query.append("    AND    C.TML_AGMT_MGMT_CD = 'A'" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("    AND    C.FDCK_CY_STO_FLG = 'Y' -- OFF Dock Storage Invoice" ).append("\n"); 
		query.append("    AND    D.TML_AGMT_OFC_CTY_CD = A.CTY" ).append("\n"); 
		query.append("    AND    D.TML_AGMT_SEQ = A.SEQ" ).append("\n"); 
		query.append("    AND    D.TML_AGMT_VER_NO  = A.NO" ).append("\n"); 
		query.append("    AND    C.LGS_COST_CD = D.LGS_COST_CD" ).append("\n"); 
		query.append("    AND    DECODE(A.CNT,0,DECODE(SUBSTR(C.LGS_COST_CD,1,2),'TP','N','Y'),'Y') = 'Y' " ).append("\n"); 
		query.append("    AND    D.THRP_COST_CD_FLG IS NULL" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("    ) A," ).append("\n"); 
		query.append("    (" ).append("\n"); 
		query.append("        SELECT ltrim(regexp_substr((select COST_CD_FTR_RMK" ).append("\n"); 
		query.append("                                      from tes_tml_so_hdr" ).append("\n"); 
		query.append("                                     where TML_SO_OFC_CTY_CD=@[tml_so_ofc_cty_cd] AND TML_SO_SEQ=@[tml_so_seq]), '[^|]+', 1, level ) ,'|') as COST_CODE" ).append("\n"); 
		query.append("         FROM dual" ).append("\n"); 
		query.append("         connect by level<= ( length((select COST_CD_FTR_RMK" ).append("\n"); 
		query.append("                                        from tes_tml_so_hdr" ).append("\n"); 
		query.append("                                       where TML_SO_OFC_CTY_CD=@[tml_so_ofc_cty_cd] AND TML_SO_SEQ=@[tml_so_seq]))+1 - length(replace((select COST_CD_FTR_RMK" ).append("\n"); 
		query.append("                                                                                        from tes_tml_so_hdr" ).append("\n"); 
		query.append("                                                                                       where TML_SO_OFC_CTY_CD=@[tml_so_ofc_cty_cd] AND TML_SO_SEQ=@[tml_so_seq]), '|')) ) / length('|')" ).append("\n"); 
		query.append("    )B," ).append("\n"); 
		query.append("    (" ).append("\n"); 
		query.append("        SELECT * FROM TES_TML_SO_CNTR_LIST" ).append("\n"); 
		query.append("        WHERE 1=1" ).append("\n"); 
		query.append("        AND TML_SO_OFC_CTY_CD=@[tml_so_ofc_cty_cd] AND TML_SO_SEQ=@[tml_so_seq]" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${agmt_ftr_inv_tp_cd} == 'MT')" ).append("\n"); 
		query.append("         AND    VSL_CD             = SUBSTR(@[vvd],1,4)" ).append("\n"); 
		query.append("         AND    SKD_VOY_NO         = SUBSTR(@[vvd],5,4)" ).append("\n"); 
		query.append("         AND    SKD_DIR_CD         = SUBSTR(@[vvd],9,1)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("    ) C" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${cost_cd_ftr_rmk} == '') " ).append("\n"); 
		query.append("	WHERE A.COST_CODE=B.COST_CODE(+)" ).append("\n"); 
		query.append("#else " ).append("\n"); 
		query.append("	WHERE A.COST_CODE=B.COST_CODE -- hdr정보에 데이터 있으면 inner 없음 outter" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(") AA," ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT DISTINCT H.INV_NO, H.YD_CD, H.VNDR_SEQ, D.LGS_COST_CD, L.CNTR_NO" ).append("\n"); 
		query.append(" FROM   TES_TML_SO_HDR H, TES_TML_SO_DTL D, TES_TML_SO_CNTR_LIST L" ).append("\n"); 
		query.append(" WHERE  H.YD_CD             = @[yd_cd]" ).append("\n"); 
		query.append(" AND    H.VNDR_SEQ           = @[vndr_seq]" ).append("\n"); 
		query.append(" AND    H.TML_SO_OFC_CTY_CD   = D.TML_SO_OFC_CTY_CD" ).append("\n"); 
		query.append(" AND    H.TML_SO_SEQ          = D.TML_SO_SEQ" ).append("\n"); 
		query.append(" AND    H.TML_SO_OFC_CTY_CD   = L.TML_SO_OFC_CTY_CD" ).append("\n"); 
		query.append(" AND    H.TML_SO_SEQ          = L.TML_SO_SEQ" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${agmt_ftr_inv_tp_cd} == 'MT')" ).append("\n"); 
		query.append(" AND    L.VSL_CD             = SUBSTR(@[vvd],1,4)" ).append("\n"); 
		query.append(" AND    L.SKD_VOY_NO         = SUBSTR(@[vvd],5,4)" ).append("\n"); 
		query.append(" AND    L.SKD_DIR_CD         = SUBSTR(@[vvd],9,1)" ).append("\n"); 
		query.append(" AND    L.IO_BND_CD          = @[io_bnd_cd] -- ? hdr정보있는 값" ).append("\n"); 
		query.append(" AND    H.TML_INV_TP_CD      = 'TM'" ).append("\n"); 
		query.append(" AND   (DECODE(L.STV_RVIS_IND_FLG,'Y','','SV') LIKE SUBSTR(D.LGS_COST_CD,1,2)||'%' OR DECODE(L.TML_RVIS_IND_FLG,'Y','','TM') LIKE SUBSTR(D.LGS_COST_CD,1,2)||'%'" ).append("\n"); 
		query.append(" 		OR DECODE(L.RVIS_IND_FLG,'Y','','TP') LIKE SUBSTR(D.LGS_COST_CD,1,2)||'%' OR DECODE(L.CGO_RVIS_IND_FLG,'Y','','CG') LIKE SUBSTR(D.LGS_COST_CD,1,2)||'%'" ).append("\n"); 
		query.append(" 		)" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#elseif (${agmt_ftr_inv_tp_cd} == 'ON')" ).append("\n"); 
		query.append("AND    H.TML_INV_TP_CD      = 'ON' -- OnDock Rail Invoice" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#elseif (${agmt_ftr_inv_tp_cd} == 'OT' || ${agmt_ftr_inv_tp_cd} == 'OTOS' || ${agmt_ftr_inv_tp_cd} == 'OS' || ${agmt_ftr_inv_tp_cd} == 'OFON' )" ).append("\n"); 
		query.append("AND    H.TML_INV_TP_CD      = 'OF'-- OFF Dock" ).append("\n"); 
		query.append("AND    H.TML_INV_RJCT_STS_CD <> 'RJ' " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#elseif (${agmt_ftr_inv_tp_cd} == 'ST')" ).append("\n"); 
		query.append("AND    H.TML_INV_TP_CD      = 'ST'" ).append("\n"); 
		query.append("AND    H.TML_INV_RJCT_STS_CD <> 'RJ'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(" AND    NVL(H.DELT_FLG,'N')   <> 'Y'" ).append("\n"); 
		query.append(" AND    D.CALC_TP_CD          = 'A'" ).append("\n"); 
		query.append(" AND    L.VRFY_RSLT_IND_CD    = 'CO'" ).append("\n"); 
		query.append(" AND    NVL(L.CNTR_TPSZ_CD,'N')  = NVL(D.CNTR_TPSZ_CD,'N')" ).append("\n"); 
		query.append(" AND    DECODE(H.TML_INV_TP_CD,'TM',NVL(L.IO_BND_CD,'N'),'ON',NVL(L.IO_BND_CD,'N'),'OF','N','ST','N')" ).append("\n"); 
		query.append("     = DECODE(H.TML_INV_TP_CD,'TM',NVL(D.IO_BND_CD,'N'),'ON',NVL(D.IO_BND_CD,'N'),'OF','N','ST','N')" ).append("\n"); 
		query.append(" AND    DECODE(H.TML_INV_TP_CD,'TM',NVL(L.IOC_CD,'N'),'ON',NVL(L.IOC_CD,'N'),'OF','N','ST','N')" ).append("\n"); 
		query.append("     = DECODE(H.TML_INV_TP_CD,'TM',NVL(D.IOC_CD,'N'),'ON',NVL(D.IOC_CD,'N'),'OF','N','ST','N')" ).append("\n"); 
		query.append(" AND    DECODE(H.TML_INV_TP_CD,'TM',NVL(L.LANE_CD,'N'),'ON',NVL(L.LANE_CD,'N'),'OF','N','ST','N')" ).append("\n"); 
		query.append("     = DECODE(H.TML_INV_TP_CD,'TM',NVL(D.LANE_CD,'N'),'ON',NVL(D.LANE_CD,'N'),'OF','N','ST','N')" ).append("\n"); 
		query.append(" AND    DECODE(H.TML_INV_TP_CD,'TM'," ).append("\n"); 
		query.append("    DECODE(L.BB_CGO_FLG,'Y','BB',DECODE(L.LOCL_TS_IND_CD,'T',DECODE(L.CNTR_STY_CD,'F','TS','TM'),DECODE(L.CNTR_STY_CD,'F','FL','MT')))," ).append("\n"); 
		query.append("    'ON',DECODE(L.CNTR_STY_CD,'F','F','M'),'OF',DECODE(L.CNTR_STY_CD,'F','FL','MT'),'ST',DECODE(L.LOCL_TS_IND_CD,'T','TS',DECODE(L.CNTR_STY_CD,'F','FL','MT')))" ).append("\n"); 
		query.append("     = DECODE(H.TML_INV_TP_CD,'TM',SUBSTR(D.LGS_COST_CD,5,2),'ON',SUBSTR(D.LGS_COST_CD,6,1),'OF',SUBSTR(D.LGS_COST_CD,5,2)," ).append("\n"); 
		query.append("    'ST',SUBSTR(D.LGS_COST_CD,5,2))" ).append("\n"); 
		query.append(" AND    DECODE(H.TML_INV_TP_CD,'TM',NVL(L.DCGO_CLSS_CD,'N'),'ON',NVL(L.DCGO_CLSS_CD,'N'),'OF','N','ST','N')" ).append("\n"); 
		query.append("     = DECODE(H.TML_INV_TP_CD,'TM',NVL(D.DCGO_IND_CD,'N'),'ON',NVL(D.DCGO_IND_CD,'N'),'OF','N','ST','N')" ).append("\n"); 
		query.append(" AND    DECODE(H.TML_INV_TP_CD,'TM',DECODE(D.TML_TRNS_MOD_CD,'','S','S','S',NVL(L.TML_TRNS_MOD_CD,'S')),'N')" ).append("\n"); 
		query.append("     = DECODE(H.TML_INV_TP_CD,'TM',NVL(D.TML_TRNS_MOD_CD,'S'),'N')" ).append("\n"); 
		query.append(" AND    DECODE(H.TML_INV_TP_CD,'TM',DECODE(SUBSTR(D.LGS_COST_CD,5,2),'TS','F','N'),'N')" ).append("\n"); 
		query.append("     = DECODE(H.TML_INV_TP_CD,'TM',DECODE(SUBSTR(D.LGS_COST_CD,5,2),'TS',L.CNTR_STY_CD,'N'),'N')" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${agmt_ftr_inv_tp_cd} == 'MT') " ).append("\n"); 
		query.append(" AND    DECODE(H.TML_INV_TP_CD,'TM','Y',L.VSL_CD) <> DECODE(H.TML_INV_TP_CD,'TM','N','CNTC')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(") BB" ).append("\n"); 
		query.append("WHERE AA.CNTR_NO = BB.CNTR_NO" ).append("\n"); 
		query.append("AND AA.COST_CODE = BB.LGS_COST_CD" ).append("\n"); 
		query.append("GROUP BY BB.CNTR_NO" ).append("\n"); 

	}
}