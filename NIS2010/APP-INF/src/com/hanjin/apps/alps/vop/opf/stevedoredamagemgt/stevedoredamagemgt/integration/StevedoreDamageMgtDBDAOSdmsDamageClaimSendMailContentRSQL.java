/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : StevedoreDamageMgtDBDAOSdmsDamageClaimSendMailContentRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.11.14
*@LastModifier : 
*@LastVersion : 1.0
* 2011.11.14 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.opf.stevedoredamagemgt.stevedoredamagemgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class StevedoreDamageMgtDBDAOSdmsDamageClaimSendMailContentRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * mail을 보내기 위한 Stevedore Damage 정보를 조회 합니다.
	  * -------------------------------------------------------------------------------------------
	  * 2011.10.21 김민아 [CHM-201113609-01] SDMS 신속 처리를 위한 Auto mailing 기능 추가
	  * 2011.11.08 김민아 [CHM-201114487-01] SDMS내 과거 SDR 입력 불가 관련 기능 개선 요청
	  * </pre>
	  */
	public StevedoreDamageMgtDBDAOSdmsDamageClaimSendMailContentRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("stv_dmg_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.opf.stevedoredamagemgt.stevedoredamagemgt.integration").append("\n"); 
		query.append("FileName : StevedoreDamageMgtDBDAOSdmsDamageClaimSendMailContentRSQL").append("\n"); 
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
		query.append("SELECT   (SELECT   MAX(PS.VSL_SLAN_CD)" ).append("\n"); 
		query.append("           FROM     VSK_VSL_SKD  PS" ).append("\n"); 
		query.append("           WHERE    PS.VSL_CD         = H.VSL_CD" ).append("\n"); 
		query.append("           AND      PS.SKD_VOY_NO     = H.SKD_VOY_NO" ).append("\n"); 
		query.append("           AND      PS.SKD_DIR_CD     = H.SKD_DIR_CD" ).append("\n"); 
		query.append("--           AND      PS.VPS_PORT_CD    = H.VPS_PORT_CD" ).append("\n"); 
		query.append("           )                                       AS SLAN_CD" ).append("\n"); 
		query.append("      ,   H.VSL_CD||H.SKD_VOY_NO||H.SKD_DIR_CD     AS VVD" ).append("\n"); 
		query.append("      ,   H.VPS_PORT_CD   " ).append("\n"); 
		query.append("      ,   H.STV_DMG_NO                              " ).append("\n"); 
		query.append("      ,   H.CLM_HNDL_OFC_CD" ).append("\n"); 
		query.append("      ,   TO_CHAR(H.STV_DMG_EVNT_DT, 'YYYY/MM/DD') AS STV_DMG_EVNT_DT" ).append("\n"); 
		query.append("            " ).append("\n"); 
		query.append("          /*  CD01890              " ).append("\n"); 
		query.append("              BEN  : Bent  " ).append("\n"); 
		query.append("              BRO  : Broken " ).append("\n"); 
		query.append("              CRA  : Crack " ).append("\n"); 
		query.append("              DEN  : Dent " ).append("\n"); 
		query.append("              HOL  : Hole " ).append("\n"); 
		query.append("              HULL : Hull " ).append("\n"); 
		query.append("              MIS  : Missing  " ).append("\n"); 
		query.append("              SPILL : Spill  " ).append("\n"); 
		query.append("              FOL  : Fold   " ).append("\n"); 
		query.append("              PLL  : Pollution " ).append("\n"); 
		query.append("          */" ).append("\n"); 
		query.append("      ,   CASE D.STV_DMG_TP_CD  WHEN 'BEN'  THEN 'Bent'  " ).append("\n"); 
		query.append("                                WHEN 'BRO'  THEN 'Broken' " ).append("\n"); 
		query.append("                                WHEN 'CRA'  THEN 'Crack' " ).append("\n"); 
		query.append("                                WHEN 'DEN'  THEN 'Dent' " ).append("\n"); 
		query.append("                                WHEN 'HOL'  THEN 'Hole' " ).append("\n"); 
		query.append("                                WHEN 'HULL' THEN 'Hull' " ).append("\n"); 
		query.append("                                WHEN 'MIS'  THEN 'Missing'  " ).append("\n"); 
		query.append("                                WHEN 'SPILL' THEN 'Spill'  " ).append("\n"); 
		query.append("                                WHEN 'FOL'  THEN 'Fold'   " ).append("\n"); 
		query.append("                                WHEN 'PLL'  THEN 'Pollution'  " ).append("\n"); 
		query.append("                                ELSE ''" ).append("\n"); 
		query.append("           END                  STV_DMG_TP_CD     " ).append("\n"); 
		query.append("      " ).append("\n"); 
		query.append("          /*  CD02809" ).append("\n"); 
		query.append("              T : Terminal " ).append("\n"); 
		query.append("              S : Stevedore Company " ).append("\n"); 
		query.append("              U : Unknown " ).append("\n"); 
		query.append("          */" ).append("\n"); 
		query.append("      ,   CASE D.STV_DMG_RESPB_PTY_KWN_CD WHEN 'T' THEN 'Terminal'       " ).append("\n"); 
		query.append("                                          WHEN 'S' THEN 'Stevedore Company'" ).append("\n"); 
		query.append("                                          WHEN 'U' THEN 'Unknown'" ).append("\n"); 
		query.append("                                          ELSE ''" ).append("\n"); 
		query.append("          END                             STV_DMG_RESPB_PTY_KWN_CD   " ).append("\n"); 
		query.append("          " ).append("\n"); 
		query.append("      ,   'Pls refer to SDMS in ALPS'     AS DTL_INFO" ).append("\n"); 
		query.append("      ,   (SELECT TO_CHAR(SYSDATE, 'YYYY.MM.DD') FROM DUAL) AS TODAY" ).append("\n"); 
		query.append("FROM      OPF_STV_DMG       H" ).append("\n"); 
		query.append("      ,   OPF_STV_DMG_DTL   D" ).append("\n"); 
		query.append("WHERE     H.STV_DMG_NO      = D.STV_DMG_NO" ).append("\n"); 
		query.append("AND       H.STV_DMG_NO      = @[stv_dmg_no]" ).append("\n"); 

	}
}