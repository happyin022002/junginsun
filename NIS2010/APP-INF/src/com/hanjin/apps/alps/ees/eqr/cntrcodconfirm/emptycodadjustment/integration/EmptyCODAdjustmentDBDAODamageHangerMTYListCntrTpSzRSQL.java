/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : EmptyCODAdjustmentDBDAODamageHangerMTYListCntrTpSzRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.01.19
*@LastModifier : 
*@LastVersion : 1.0
* 2017.01.19 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.eqr.cntrcodconfirm.emptycodadjustment.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class EmptyCODAdjustmentDBDAODamageHangerMTYListCntrTpSzRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * MTY 양하 계획 조정
	  * EES_CIM_1058
	  * HR/ DMG MTY CNTR List
	  * 
	  * 2011.06.13 나상보 [CHM-201111555-01] [EQR] R9 코드 생성에 따른 EQR 모듈 보완 작업 요청
	  * 2012.10.17 문동선 [CHM-201220651-01] [EQR] EQR O5 Type Size 추가
	  * </pre>
	  */
	public EmptyCODAdjustmentDBDAODamageHangerMTYListCntrTpSzRSQL(){
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
		params.put("pod",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.eqr.cntrcodconfirm.emptycodadjustment.integration").append("\n"); 
		query.append("FileName : EmptyCODAdjustmentDBDAODamageHangerMTYListCntrTpSzRSQL").append("\n"); 
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
		query.append("        SUM ( DECODE( CM.CNTR_TPSZ_CD , 'D2' , 1 , 0 ) ) AS D2," ).append("\n"); 
		query.append("        SUM ( DECODE( CM.CNTR_TPSZ_CD , 'D4' , 1 , 0 ) ) AS D4," ).append("\n"); 
		query.append("        SUM ( DECODE( CM.CNTR_TPSZ_CD , 'D5' , 1 , 0 ) ) AS D5," ).append("\n"); 
		query.append("        SUM ( DECODE( CM.CNTR_TPSZ_CD , 'D7' , 1 , 0 ) ) AS D7," ).append("\n"); 
		query.append("        SUM ( DECODE( CM.CNTR_TPSZ_CD , 'R2' , 1 , 0 ) ) AS R2," ).append("\n"); 
		query.append("        SUM ( DECODE( CM.CNTR_TPSZ_CD , 'R5' , 1 , 0 ) ) AS R5," ).append("\n"); 
		query.append("        SUM ( DECODE( CM.CNTR_TPSZ_CD , 'R9' , 1 , 0 ) ) AS R9," ).append("\n"); 
		query.append("        SUM ( DECODE( CM.CNTR_TPSZ_CD , 'O2' , 1 , 0 ) ) AS O2," ).append("\n"); 
		query.append("        SUM ( DECODE( CM.CNTR_TPSZ_CD , 'S2' , 1 , 0 ) ) AS S2," ).append("\n"); 
		query.append("        SUM ( DECODE( CM.CNTR_TPSZ_CD , 'O4' , 1 , 0 ) ) AS O4," ).append("\n"); 
		query.append("        SUM ( DECODE( CM.CNTR_TPSZ_CD , 'S4' , 1 , 0 ) ) AS S4," ).append("\n"); 
		query.append("		SUM ( DECODE( CM.CNTR_TPSZ_CD , 'O5' , 1 , 0 ) ) AS O5," ).append("\n"); 
		query.append("        SUM ( DECODE( CM.CNTR_TPSZ_CD , 'F2' , 1 , 0 ) ) AS F2," ).append("\n"); 
		query.append("        SUM ( DECODE( CM.CNTR_TPSZ_CD , 'A2' , 1 , 0 ) ) AS A2," ).append("\n"); 
		query.append("        SUM ( DECODE( CM.CNTR_TPSZ_CD , 'F4' , 1 , 0 ) ) AS F4," ).append("\n"); 
		query.append("        SUM ( DECODE( CM.CNTR_TPSZ_CD , 'A4' , 1 , 0 ) ) AS A4," ).append("\n"); 
		query.append("        SUM ( DECODE( CM.CNTR_TPSZ_CD , 'F5' , 1 , 0 ) ) AS F5," ).append("\n"); 
		query.append("        SUM ( DECODE( CM.CNTR_TPSZ_CD , 'A5' , 1 , 0 ) ) AS A5" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("        OPF_BAY_PLN_LDIS    BP," ).append("\n"); 
		query.append("        BKG_VVD             BV," ).append("\n"); 
		query.append("        BKG_BOOKING         BK," ).append("\n"); 
		query.append("        BKG_CONTAINER       BC," ).append("\n"); 
		query.append("        MST_CONTAINER       CM" ).append("\n"); 
		query.append("WHERE   BP.VSL_CD               =   SUBSTR(@[vvd],1,4)" ).append("\n"); 
		query.append("AND     BP.SKD_VOY_NO           =   SUBSTR(@[vvd],5,4)" ).append("\n"); 
		query.append("AND     BP.SKD_DIR_CD           =   SUBSTR(@[vvd],9,1)" ).append("\n"); 
		query.append("AND     BP.POD_CD               =   DECODE(@[pod],'',BP.POD_CD,@[pod])" ).append("\n"); 
		query.append("AND     BP.LODG_DCHG_IND_CD     =   'C'" ).append("\n"); 
		query.append("AND     BP.FULL_MTY_CD          =   'E'" ).append("\n"); 
		query.append("AND     BP.CRR_CD    =   'SML'" ).append("\n"); 
		query.append("AND     BP.VSL_CD           =   BV.VSL_CD" ).append("\n"); 
		query.append("AND     BP.SKD_VOY_NO       =   BV.SKD_VOY_NO" ).append("\n"); 
		query.append("AND     BP.SKD_DIR_CD       =   BV.SKD_DIR_CD" ).append("\n"); 
		query.append("AND     BV.BKG_NO           =   BK.BKG_NO" ).append("\n"); 
		query.append("AND     BK.BKG_NO           =   BC.BKG_NO" ).append("\n"); 
		query.append("AND     BC.CNTR_NO          =   BP.CNTR_REF_NO" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if ( ${version} == 'H' )" ).append("\n"); 
		query.append("AND     CM.CNTR_HNGR_RCK_CD IS NOT NULL             /* 2010.03.15 By SBKIM */" ).append("\n"); 
		query.append("--AND     NVL(CM.CNTR_HNGR_BAR_ATCH_KNT,0)  > 0" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if ( ${version} == 'D' )" ).append("\n"); 
		query.append("AND     CM.DMG_FLG          =   'Y'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("AND     BC.CNTR_NO          =   CM.CNTR_NO" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SELECT  /*+ ORDERED INDEX( BV XAK1BKG_VVD ) */" ).append("\n"); 
		query.append("        SUM ( DECODE( CM.CNTR_TPSZ_CD , 'D2' , 1 , 0 ) ) AS D2," ).append("\n"); 
		query.append("        SUM ( DECODE( CM.CNTR_TPSZ_CD , 'D4' , 1 , 0 ) ) AS D4," ).append("\n"); 
		query.append("        SUM ( DECODE( CM.CNTR_TPSZ_CD , 'D5' , 1 , 0 ) ) AS D5," ).append("\n"); 
		query.append("        SUM ( DECODE( CM.CNTR_TPSZ_CD , 'D7' , 1 , 0 ) ) AS D7," ).append("\n"); 
		query.append("        SUM ( DECODE( CM.CNTR_TPSZ_CD , 'R2' , 1 , 0 ) ) AS R2," ).append("\n"); 
		query.append("        SUM ( DECODE( CM.CNTR_TPSZ_CD , 'R5' , 1 , 0 ) ) AS R5," ).append("\n"); 
		query.append("        SUM ( DECODE( CM.CNTR_TPSZ_CD , 'R9' , 1 , 0 ) ) AS R9," ).append("\n"); 
		query.append("        SUM ( DECODE( CM.CNTR_TPSZ_CD , 'O2' , 1 , 0 ) ) AS O2," ).append("\n"); 
		query.append("        SUM ( DECODE( CM.CNTR_TPSZ_CD , 'S2' , 1 , 0 ) ) AS S2," ).append("\n"); 
		query.append("        SUM ( DECODE( CM.CNTR_TPSZ_CD , 'O4' , 1 , 0 ) ) AS O4," ).append("\n"); 
		query.append("        SUM ( DECODE( CM.CNTR_TPSZ_CD , 'S4' , 1 , 0 ) ) AS S4," ).append("\n"); 
		query.append("		SUM ( DECODE( CM.CNTR_TPSZ_CD , 'O5' , 1 , 0 ) ) AS O5," ).append("\n"); 
		query.append("        SUM ( DECODE( CM.CNTR_TPSZ_CD , 'F2' , 1 , 0 ) ) AS F2," ).append("\n"); 
		query.append("        SUM ( DECODE( CM.CNTR_TPSZ_CD , 'A2' , 1 , 0 ) ) AS A2," ).append("\n"); 
		query.append("        SUM ( DECODE( CM.CNTR_TPSZ_CD , 'F4' , 1 , 0 ) ) AS F4," ).append("\n"); 
		query.append("        SUM ( DECODE( CM.CNTR_TPSZ_CD , 'A4' , 1 , 0 ) ) AS A4," ).append("\n"); 
		query.append("        SUM ( DECODE( CM.CNTR_TPSZ_CD , 'F5' , 1 , 0 ) ) AS F5," ).append("\n"); 
		query.append("        SUM ( DECODE( CM.CNTR_TPSZ_CD , 'A5' , 1 , 0 ) ) AS A4" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("FROM    (" ).append("\n"); 
		query.append("            SELECT  BPN.CNTR_REF_NO             CNTR_NO," ).append("\n"); 
		query.append("                    BPN.POL_CD                  POL_CD," ).append("\n"); 
		query.append("                    BPN.POD_CD                  POD_CD," ).append("\n"); 
		query.append("                    BPN.VSL_BAY_NO||BPN.VSL_ROW_NO||BPN.VSL_TR_NO        BAY_NO" ).append("\n"); 
		query.append("            FROM    OPF_BAY_PLN_LDIS    BPN" ).append("\n"); 
		query.append("            WHERE   BPN.VSL_CD              =   SUBSTR(@[vvd],1,4)" ).append("\n"); 
		query.append("            AND     BPN.SKD_VOY_NO          =   SUBSTR(@[vvd],5,4)" ).append("\n"); 
		query.append("            AND     BPN.SKD_DIR_CD          =   SUBSTR(@[vvd],9,1)" ).append("\n"); 
		query.append("            AND     BPN.LODG_DCHG_IND_CD    =   'C'" ).append("\n"); 
		query.append("            AND     BPN.FULL_MTY_CD         =   'E'" ).append("\n"); 
		query.append("            AND     BPN.CRR_CD   =   'SML'" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("        )                   BP," ).append("\n"); 
		query.append("        BKG_VVD             BV," ).append("\n"); 
		query.append("        BKG_BOOKING         BK," ).append("\n"); 
		query.append("        BKG_CONTAINER       BC," ).append("\n"); 
		query.append("        MST_CONTAINER       CM" ).append("\n"); 
		query.append("WHERE   BV.VSL_CD           =   SUBSTR(@[vvd],1,4)" ).append("\n"); 
		query.append("AND     BV.SKD_VOY_NO       =   SUBSTR(@[vvd],5,4)" ).append("\n"); 
		query.append("AND     BV.SKD_DIR_CD       =   SUBSTR(@[vvd],9,1)" ).append("\n"); 
		query.append("AND     BV.POD_CD           =   DECODE(@[pod],'',BV.POD_CD,@[pod])" ).append("\n"); 
		query.append("AND     BV.BKG_NO           =   BK.BKG_NO" ).append("\n"); 
		query.append("AND     BK.BKG_CGO_TP_CD    =   'P'" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if ( ${version} == 'H' )" ).append("\n"); 
		query.append("AND     BK.MTY_BKG_STS_CD   =   'H'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if ( ${version} == 'D' )" ).append("\n"); 
		query.append("AND     BK.MTY_BKG_STS_CD   =   'D'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("AND     BK.BKG_NO           =   BC.BKG_NO" ).append("\n"); 
		query.append("AND     BC.CNTR_NO          =   BP.CNTR_NO  (+)" ).append("\n"); 
		query.append("AND     BC.CNTR_NO          =   CM.CNTR_NO" ).append("\n"); 

	}
}