/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : BSAManageDBDAOSearchBSATableVvdListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.01.23
*@LastModifier : 
*@LastVersion : 1.0
* 2017.01.23 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bsa.bsamanage.bsamanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BSAManageDBDAOSearchBSATableVvdListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * BSA creation시 조건에 따른 유효한 VVD list 조회
	  * [CHM-201534945] BSA CREATION 화면 / "VVD INQUIRY" 기능 개선 요청
	  * - 기준 날짜의 직전 항차1개, 날짜 이후 항차 5개, 총 6줄만 조회되도록 로직 변경
	  * 2015.06.08 김용습 [CHM-201536164] 주간 MAS Open에 따른 타모듈 프로그램 적용 요청
	  * </pre>
	  */
	public BSAManageDBDAOSearchBSATableVvdListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rdoopcd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("coblane",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("txtsdate",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cobdir",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cobvop",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cobtrade",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cobcapa",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bsa.bsamanage.bsamanage.integration").append("\n"); 
		query.append("FileName : BSAManageDBDAOSearchBSATableVvdListRSQL").append("\n"); 
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
		query.append("SELECT * " ).append("\n"); 
		query.append("    FROM " ).append("\n"); 
		query.append("    (   SELECT *" ).append("\n"); 
		query.append("            FROM" ).append("\n"); 
		query.append("            (   SELECT *" ).append("\n"); 
		query.append("                FROM" ).append("\n"); 
		query.append("                (   SELECT TRD_CD TRADE_CD, " ).append("\n"); 
		query.append("                           RLANE_CD RLAN_CD, " ).append("\n"); 
		query.append("                           VSL_ENG_NM," ).append("\n"); 
		query.append("                           VVD_CD VVD_CODE,  " ).append("\n"); 
		query.append("                           SLAN_CD," ).append("\n"); 
		query.append("                           N1ST_LODG_PORT_ETD_DT  AS N1ST_LODG_ETD," ).append("\n"); 
		query.append("                           DECODE(@[rdoopcd],'J',VSL_CAPA,0) AS VSL_CAPA, " ).append("\n"); 
		query.append("                           VOP_CD OPR_CD," ).append("\n"); 
		query.append("                           CRR_CD " ).append("\n"); 
		query.append("                      FROM (" ).append("\n"); 
		query.append("                                SELECT A.TRD_CD, A.RLANE_CD, M.VSL_ENG_NM,A.VSL_CD||A.SKD_VOY_NO||A.DIR_CD AS VVD_CD,  " ).append("\n"); 
		query.append("                                       A.SLAN_CD," ).append("\n"); 
		query.append("                                       TO_CHAR(A.N1ST_LODG_PORT_ETD_DT, 'YYYY-MM-DD HH24:MI') N1ST_LODG_PORT_ETD_DT,                  " ).append("\n"); 
		query.append("                                       DECODE(NVL(B.SUB_TRD_CAPA,0),0,NVL(E.STND_LDB_CAPA,0),NVL(B.SUB_TRD_CAPA,0)) VSL_CAPA," ).append("\n"); 
		query.append("                                       E.VOP_CD, C.VSL_LANE_TP_CD," ).append("\n"); 
		query.append("                                       DECODE(E.VOP_CD,'SML',E.VOP_CD,M.CRR_CD) CRR_CD           " ).append("\n"); 
		query.append("                                 FROM  MAS_MON_VVD A," ).append("\n"); 
		query.append("                                       (" ).append("\n"); 
		query.append("                                        SELECT DISTINCT  A.VSL_CD ," ).append("\n"); 
		query.append("                                            A.SUB_TRD_CD ," ).append("\n"); 
		query.append("                                            A.SUB_TRD_CAPA ," ).append("\n"); 
		query.append("                                            A.STND_LDB_CAPA ," ).append("\n"); 
		query.append("                                            A.VOP_CD ," ).append("\n"); 
		query.append("                                           TO_CHAR( A.VSL_APLY_FM_DT ,'YYYYMMDD') VSL_APLY_FOM_DT," ).append("\n"); 
		query.append("                                           TO_CHAR( A.VSL_APLY_TO_DT ,'YYYYMMDD')  VSL_APLY_TO_DT" ).append("\n"); 
		query.append("                                      FROM (" ).append("\n"); 
		query.append("                                            SELECT X.VSL_CD, Y.SUB_TRD_CD, Y.SUB_TRD_CAPA, X.STND_LDB_CAPA," ).append("\n"); 
		query.append("                                                   X.VOP_CD, X.VSL_APLY_FM_DT VSL_APLY_FM_DT, X.VSL_APLY_TO_DT VSL_APLY_TO_DT" ).append("\n"); 
		query.append("                                              FROM MAS_VSL_RGST X," ).append("\n"); 
		query.append("                                                   (" ).append("\n"); 
		query.append("                                                    SELECT B.VSL_CD, B.VSL_SEQ, B.SUB_TRD_CD, B.SUB_TRD_CAPA" ).append("\n"); 
		query.append("                                                      FROM MDM_SUB_TRD A, MAS_VSL_SUB_TRD_CAPA B" ).append("\n"); 
		query.append("                                                     WHERE A.DELT_FLG <> 'Y'" ).append("\n"); 
		query.append("                                                       AND A.SUB_TRD_CD      = B.SUB_TRD_CD" ).append("\n"); 
		query.append("                                                   ) Y" ).append("\n"); 
		query.append("                                             WHERE X.VSL_CD             = Y.VSL_CD(+)" ).append("\n"); 
		query.append("                                               AND X.VSL_SEQ            = Y.VSL_SEQ(+)" ).append("\n"); 
		query.append("                                               AND NVL(X.DELT_FLG,'N')  = 'N'" ).append("\n"); 
		query.append("                                               AND X.VSL_TP_CD          = 'C'                   " ).append("\n"); 
		query.append("                                            ) A" ).append("\n"); 
		query.append("                                       ) B," ).append("\n"); 
		query.append("                                       (" ).append("\n"); 
		query.append("                                       SELECT DISTINCT NVL(B.TRD_CD , A.TRD_CD)         TRD_CD," ).append("\n"); 
		query.append("                                              NVL(B.RLANE_CD        , A.RLANE_CD)       RLANE_CD," ).append("\n"); 
		query.append("                                              NVL(B.DIR_CD          , A.DIR_CD)         DIR_CD," ).append("\n"); 
		query.append("                                              NVL(B.IOC_CD          , A.IOC_CD)         IOC_CD," ).append("\n"); 
		query.append("                                              NVL(B.VSL_LANE_TP_CD  , A.VSL_LANE_TP_CD) VSL_LANE_TP_CD," ).append("\n"); 
		query.append("                                              NVL(B.STUP_FLG        , A.STUP_FLG)       STUP_FLG," ).append("\n"); 
		query.append("                                              NVL(B.LANE_APLY_FM_DT, '19000101') LANE_APLY_FOM_DT," ).append("\n"); 
		query.append("                                              NVL(B.LANE_APLY_TO_DT, '99991231') LANE_APLY_TO_DT," ).append("\n"); 
		query.append("                                              TRNK_IPT_FLG" ).append("\n"); 
		query.append("                                         FROM MAS_LANE_RGST A" ).append("\n"); 
		query.append("                                              FULL OUTER JOIN" ).append("\n"); 
		query.append("                                              MAS_LANE_TP_HIS B" ).append("\n"); 
		query.append("                                           ON (    A.TRD_CD   = B.TRD_CD" ).append("\n"); 
		query.append("                                               AND A.RLANE_CD = B.RLANE_CD" ).append("\n"); 
		query.append("                                               AND A.DIR_CD   = B.DIR_CD" ).append("\n"); 
		query.append("                                               AND A.IOC_CD   = B.IOC_CD)" ).append("\n"); 
		query.append("                                        WHERE A.DELT_FLG     <> 'Y'" ).append("\n"); 
		query.append("                                          #if (${cobtrade}!='' && ${cobtrade}!='ALL') " ).append("\n"); 
		query.append("                                          AND A.TRD_CD         = @[cobtrade]    " ).append("\n"); 
		query.append("                                          #end " ).append("\n"); 
		query.append("                                          #if (${coblane}!='' && ${coblane}!='ALL')  " ).append("\n"); 
		query.append("                                          AND A.RLANE_CD       = @[coblane]  " ).append("\n"); 
		query.append("                                          #end" ).append("\n"); 
		query.append("                                          #if (${cobdir}!='' && ${cobdir}!='ALL') " ).append("\n"); 
		query.append("                                          AND  A.DIR_CD 		= @[cobdir]   " ).append("\n"); 
		query.append("                                          #end  " ).append("\n"); 
		query.append("                                          AND A.VSL_LANE_TP_CD = DECODE(@[rdoopcd],'J','JO','SC')        " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                                       ) C," ).append("\n"); 
		query.append("                                       (" ).append("\n"); 
		query.append("                                       SELECT  VSL_CD,    VOP_CD ,  STND_LDB_CAPA ," ).append("\n"); 
		query.append("                                              NVL(TO_CHAR(VSL_APLY_FM_DT,'YYYYMMDD'), '19000101')  VSL_APLY_FM_DT," ).append("\n"); 
		query.append("                                              NVL(TO_CHAR(VSL_APLY_TO_DT,'YYYYMMDD') , '99991231') VSL_APLY_TO_DT," ).append("\n"); 
		query.append("                                              VSL_CLSS_CAPA,  TRD_CHK_FLG,  DELT_FLG, CRR_CD" ).append("\n"); 
		query.append("                                         FROM MAS_VSL_RGST " ).append("\n"); 
		query.append("                                        #if (${cobvop}!='') " ).append("\n"); 
		query.append("                                         WHERE  VOP_CD 		= @[cobvop]   " ).append("\n"); 
		query.append("                                        #end            " ).append("\n"); 
		query.append("                                       ) E," ).append("\n"); 
		query.append("                                       MDM_VSL_CNTR M" ).append("\n"); 
		query.append("                                 WHERE A.VSL_CD             = B.VSL_CD(+)" ).append("\n"); 
		query.append("                                   AND A.VSL_CD             = E.VSL_CD" ).append("\n"); 
		query.append("                                   AND A.SUB_TRD_CD         = B.SUB_TRD_CD(+)" ).append("\n"); 
		query.append("                                   AND A.TRD_CD             = C.TRD_CD" ).append("\n"); 
		query.append("                                   AND A.RLANE_CD           = C.RLANE_CD" ).append("\n"); 
		query.append("                                   AND A.DIR_CD             = C.DIR_CD" ).append("\n"); 
		query.append("                                   AND NVL(A.DELT_FLG,'N') <> 'Y'" ).append("\n"); 
		query.append("                                   AND NVL(E.DELT_FLG,'N') <> 'Y'" ).append("\n"); 
		query.append("                                   AND C.VSL_LANE_TP_CD     IN ('JO','SC')" ).append("\n"); 
		query.append("                                   AND NVL(C.TRNK_IPT_FLG,'N') <> 'Y'" ).append("\n"); 
		query.append("                                   AND TO_CHAR(A.N1ST_LODG_PORT_ETD_DT,'YYYYMMDD') BETWEEN NVL(C.LANE_APLY_FOM_DT,'19000101') AND NVL(C.LANE_APLY_TO_DT, '99991231')" ).append("\n"); 
		query.append("                                   AND TO_CHAR(A.N1ST_LODG_PORT_ETD_DT,'YYYYMMDD') BETWEEN NVL(B.VSL_APLY_FOM_DT ,'19000101') AND NVL(B.VSL_APLY_TO_DT , '99991231')" ).append("\n"); 
		query.append("                                   AND TO_CHAR(A.N1ST_LODG_PORT_ETD_DT,'YYYYMMDD') BETWEEN NVL(E.VSL_APLY_FM_DT ,'19000101') AND NVL(E.VSL_APLY_TO_DT , '99991231')" ).append("\n"); 
		query.append("                                   #if (${txtsdate}!='' && ${txtedate}!='') " ).append("\n"); 
		query.append("                                   AND TO_CHAR(A.N1ST_LODG_PORT_ETD_DT,'YYYY-MM-DD') < @[txtsdate]" ).append("\n"); 
		query.append("                                   #end" ).append("\n"); 
		query.append("                                   #if (${cobtrade}!='' && ${cobtrade}!='ALL') " ).append("\n"); 
		query.append("                                   AND A.TRD_CD             = @[cobtrade]   " ).append("\n"); 
		query.append("                                   #end" ).append("\n"); 
		query.append("                                   #if (${coblane}!='' && ${coblane}!='ALL')" ).append("\n"); 
		query.append("                                   AND A.RLANE_CD           = @[coblane] " ).append("\n"); 
		query.append("                                   #end" ).append("\n"); 
		query.append("                                   #if (${cobdir}!='') " ).append("\n"); 
		query.append("                                   AND  A.DIR_CD 		= @[cobdir]   " ).append("\n"); 
		query.append("                                   #end         " ).append("\n"); 
		query.append("                                   AND A.VSL_CD             = M.VSL_CD" ).append("\n"); 
		query.append("                               )" ).append("\n"); 
		query.append("                            #if (${rdoopcd}=='J') " ).append("\n"); 
		query.append("                            WHERE VSL_CAPA       = @[cobcapa]" ).append("\n"); 
		query.append("                            #end" ).append("\n"); 
		query.append("                    ORDER BY N1ST_LODG_PORT_ETD_DT DESC, VOP_CD" ).append("\n"); 
		query.append("                )" ).append("\n"); 
		query.append("                WHERE ROWNUM < 2" ).append("\n"); 
		query.append("        )" ).append("\n"); 
		query.append("        UNION" ).append("\n"); 
		query.append("        (    SELECT *" ).append("\n"); 
		query.append("                FROM" ).append("\n"); 
		query.append("                (   SELECT TRD_CD TRADE_CD, " ).append("\n"); 
		query.append("                           RLANE_CD RLAN_CD, " ).append("\n"); 
		query.append("                           VSL_ENG_NM," ).append("\n"); 
		query.append("                           VVD_CD VVD_CODE,  " ).append("\n"); 
		query.append("                           SLAN_CD," ).append("\n"); 
		query.append("                           N1ST_LODG_PORT_ETD_DT  AS N1ST_LODG_ETD," ).append("\n"); 
		query.append("                           DECODE(@[rdoopcd],'J',VSL_CAPA,0) AS VSL_CAPA, " ).append("\n"); 
		query.append("                           VOP_CD OPR_CD," ).append("\n"); 
		query.append("                           CRR_CD " ).append("\n"); 
		query.append("                      FROM (" ).append("\n"); 
		query.append("                                SELECT A.TRD_CD, A.RLANE_CD, M.VSL_ENG_NM,A.VSL_CD||A.SKD_VOY_NO||A.DIR_CD AS VVD_CD,  " ).append("\n"); 
		query.append("                                       A.SLAN_CD," ).append("\n"); 
		query.append("                                       TO_CHAR(A.N1ST_LODG_PORT_ETD_DT, 'YYYY-MM-DD HH24:MI') N1ST_LODG_PORT_ETD_DT,                  " ).append("\n"); 
		query.append("                                       DECODE(NVL(B.SUB_TRD_CAPA,0),0,NVL(E.STND_LDB_CAPA,0),NVL(B.SUB_TRD_CAPA,0)) VSL_CAPA," ).append("\n"); 
		query.append("                                       E.VOP_CD, C.VSL_LANE_TP_CD," ).append("\n"); 
		query.append("                                       DECODE(E.VOP_CD,'SML',E.VOP_CD,M.CRR_CD) CRR_CD           " ).append("\n"); 
		query.append("                                 FROM  MAS_MON_VVD A," ).append("\n"); 
		query.append("                                       (" ).append("\n"); 
		query.append("                                        SELECT DISTINCT  A.VSL_CD ," ).append("\n"); 
		query.append("                                            A.SUB_TRD_CD ," ).append("\n"); 
		query.append("                                            A.SUB_TRD_CAPA ," ).append("\n"); 
		query.append("                                            A.STND_LDB_CAPA ," ).append("\n"); 
		query.append("                                            A.VOP_CD ," ).append("\n"); 
		query.append("                                           TO_CHAR( A.VSL_APLY_FM_DT ,'YYYYMMDD') VSL_APLY_FOM_DT," ).append("\n"); 
		query.append("                                           TO_CHAR( A.VSL_APLY_TO_DT ,'YYYYMMDD')  VSL_APLY_TO_DT" ).append("\n"); 
		query.append("                                      FROM (" ).append("\n"); 
		query.append("                                            SELECT X.VSL_CD, Y.SUB_TRD_CD, Y.SUB_TRD_CAPA, X.STND_LDB_CAPA," ).append("\n"); 
		query.append("                                                   X.VOP_CD, X.VSL_APLY_FM_DT VSL_APLY_FM_DT, X.VSL_APLY_TO_DT VSL_APLY_TO_DT" ).append("\n"); 
		query.append("                                              FROM MAS_VSL_RGST X," ).append("\n"); 
		query.append("                                                   (" ).append("\n"); 
		query.append("                                                    SELECT B.VSL_CD, B.VSL_SEQ, B.SUB_TRD_CD, B.SUB_TRD_CAPA" ).append("\n"); 
		query.append("                                                      FROM MDM_SUB_TRD A, MAS_VSL_SUB_TRD_CAPA B" ).append("\n"); 
		query.append("                                                     WHERE A.DELT_FLG <> 'Y'" ).append("\n"); 
		query.append("                                                       AND A.SUB_TRD_CD      = B.SUB_TRD_CD" ).append("\n"); 
		query.append("                                                   ) Y" ).append("\n"); 
		query.append("                                             WHERE X.VSL_CD             = Y.VSL_CD(+)" ).append("\n"); 
		query.append("                                               AND X.VSL_SEQ            = Y.VSL_SEQ(+)" ).append("\n"); 
		query.append("                                               AND NVL(X.DELT_FLG,'N')  = 'N'" ).append("\n"); 
		query.append("                                               AND X.VSL_TP_CD          = 'C'                   " ).append("\n"); 
		query.append("                                            ) A" ).append("\n"); 
		query.append("                                       ) B," ).append("\n"); 
		query.append("                                       (" ).append("\n"); 
		query.append("                                       SELECT DISTINCT NVL(B.TRD_CD , A.TRD_CD)         TRD_CD," ).append("\n"); 
		query.append("                                              NVL(B.RLANE_CD        , A.RLANE_CD)       RLANE_CD," ).append("\n"); 
		query.append("                                              NVL(B.DIR_CD          , A.DIR_CD)         DIR_CD," ).append("\n"); 
		query.append("                                              NVL(B.IOC_CD          , A.IOC_CD)         IOC_CD," ).append("\n"); 
		query.append("                                              NVL(B.VSL_LANE_TP_CD  , A.VSL_LANE_TP_CD) VSL_LANE_TP_CD," ).append("\n"); 
		query.append("                                              NVL(B.STUP_FLG        , A.STUP_FLG)       STUP_FLG," ).append("\n"); 
		query.append("                                              NVL(B.LANE_APLY_FM_DT, '19000101') LANE_APLY_FOM_DT," ).append("\n"); 
		query.append("                                              NVL(B.LANE_APLY_TO_DT, '99991231') LANE_APLY_TO_DT," ).append("\n"); 
		query.append("                                              TRNK_IPT_FLG" ).append("\n"); 
		query.append("                                         FROM MAS_LANE_RGST A" ).append("\n"); 
		query.append("                                              FULL OUTER JOIN" ).append("\n"); 
		query.append("                                              MAS_LANE_TP_HIS B" ).append("\n"); 
		query.append("                                           ON (    A.TRD_CD   = B.TRD_CD" ).append("\n"); 
		query.append("                                               AND A.RLANE_CD = B.RLANE_CD" ).append("\n"); 
		query.append("                                               AND A.DIR_CD   = B.DIR_CD" ).append("\n"); 
		query.append("                                               AND A.IOC_CD   = B.IOC_CD)" ).append("\n"); 
		query.append("                                        WHERE A.DELT_FLG     <> 'Y'" ).append("\n"); 
		query.append("                                          #if (${cobtrade}!='' && ${cobtrade}!='ALL') " ).append("\n"); 
		query.append("                                          AND A.TRD_CD         = @[cobtrade]    " ).append("\n"); 
		query.append("                                          #end " ).append("\n"); 
		query.append("                                          #if (${coblane}!='' && ${coblane}!='ALL')  " ).append("\n"); 
		query.append("                                          AND A.RLANE_CD       = @[coblane]  " ).append("\n"); 
		query.append("                                          #end" ).append("\n"); 
		query.append("                                          #if (${cobdir}!='' && ${cobdir}!='ALL') " ).append("\n"); 
		query.append("                                          AND  A.DIR_CD 		= @[cobdir]   " ).append("\n"); 
		query.append("                                          #end  " ).append("\n"); 
		query.append("                                          AND A.VSL_LANE_TP_CD = DECODE(@[rdoopcd],'J','JO','SC')        " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                                       ) C," ).append("\n"); 
		query.append("                                       (" ).append("\n"); 
		query.append("                                       SELECT  VSL_CD,    VOP_CD ,  STND_LDB_CAPA ," ).append("\n"); 
		query.append("                                              NVL(TO_CHAR(VSL_APLY_FM_DT,'YYYYMMDD'), '19000101')  VSL_APLY_FM_DT," ).append("\n"); 
		query.append("                                              NVL(TO_CHAR(VSL_APLY_TO_DT,'YYYYMMDD') , '99991231') VSL_APLY_TO_DT," ).append("\n"); 
		query.append("                                              VSL_CLSS_CAPA,  TRD_CHK_FLG,  DELT_FLG, CRR_CD" ).append("\n"); 
		query.append("                                         FROM MAS_VSL_RGST " ).append("\n"); 
		query.append("                                        #if (${cobvop}!='') " ).append("\n"); 
		query.append("                                         WHERE  VOP_CD 		= @[cobvop]   " ).append("\n"); 
		query.append("                                        #end            " ).append("\n"); 
		query.append("                                       ) E," ).append("\n"); 
		query.append("                                       MDM_VSL_CNTR M" ).append("\n"); 
		query.append("                                 WHERE A.VSL_CD             = B.VSL_CD(+)" ).append("\n"); 
		query.append("                                   AND A.VSL_CD             = E.VSL_CD" ).append("\n"); 
		query.append("                                   AND A.SUB_TRD_CD         = B.SUB_TRD_CD(+)" ).append("\n"); 
		query.append("                                   AND A.TRD_CD             = C.TRD_CD" ).append("\n"); 
		query.append("                                   AND A.RLANE_CD           = C.RLANE_CD" ).append("\n"); 
		query.append("                                   AND A.DIR_CD             = C.DIR_CD" ).append("\n"); 
		query.append("                                   AND NVL(A.DELT_FLG,'N') <> 'Y'" ).append("\n"); 
		query.append("                                   AND NVL(E.DELT_FLG,'N') <> 'Y'" ).append("\n"); 
		query.append("                                   AND C.VSL_LANE_TP_CD     IN ('JO','SC')" ).append("\n"); 
		query.append("                                   AND NVL(C.TRNK_IPT_FLG,'N') <> 'Y'" ).append("\n"); 
		query.append("                                   AND TO_CHAR(A.N1ST_LODG_PORT_ETD_DT,'YYYYMMDD') BETWEEN NVL(C.LANE_APLY_FOM_DT,'19000101') AND NVL(C.LANE_APLY_TO_DT, '99991231')" ).append("\n"); 
		query.append("                                   AND TO_CHAR(A.N1ST_LODG_PORT_ETD_DT,'YYYYMMDD') BETWEEN NVL(B.VSL_APLY_FOM_DT ,'19000101') AND NVL(B.VSL_APLY_TO_DT , '99991231')" ).append("\n"); 
		query.append("                                   AND TO_CHAR(A.N1ST_LODG_PORT_ETD_DT,'YYYYMMDD') BETWEEN NVL(E.VSL_APLY_FM_DT ,'19000101') AND NVL(E.VSL_APLY_TO_DT , '99991231')" ).append("\n"); 
		query.append("                                   #if (${txtsdate}!='' && ${txtedate}!='') " ).append("\n"); 
		query.append("                                   AND TO_CHAR(A.N1ST_LODG_PORT_ETD_DT,'YYYY-MM-DD') >= @[txtsdate]  " ).append("\n"); 
		query.append("                                   #end" ).append("\n"); 
		query.append("                                   #if (${cobtrade}!='' && ${cobtrade}!='ALL') " ).append("\n"); 
		query.append("                                   AND A.TRD_CD             = @[cobtrade]   " ).append("\n"); 
		query.append("                                   #end" ).append("\n"); 
		query.append("                                   #if (${coblane}!='' && ${coblane}!='ALL')" ).append("\n"); 
		query.append("                                   AND A.RLANE_CD           = @[coblane] " ).append("\n"); 
		query.append("                                   #end" ).append("\n"); 
		query.append("                                   #if (${cobdir}!='') " ).append("\n"); 
		query.append("                                   AND  A.DIR_CD 		= @[cobdir]   " ).append("\n"); 
		query.append("                                   #end         " ).append("\n"); 
		query.append("                                   AND A.VSL_CD             = M.VSL_CD" ).append("\n"); 
		query.append("                               )" ).append("\n"); 
		query.append("                            WHERE 1=1" ).append("\n"); 
		query.append("                            #if (${rdoopcd}=='J') " ).append("\n"); 
		query.append("                            AND VSL_CAPA       = @[cobcapa]" ).append("\n"); 
		query.append("                            #end" ).append("\n"); 
		query.append("                    ORDER BY N1ST_LODG_PORT_ETD_DT, VOP_CD" ).append("\n"); 
		query.append("                )" ).append("\n"); 
		query.append("                WHERE ROWNUM < 6" ).append("\n"); 
		query.append("        )" ).append("\n"); 
		query.append("    )" ).append("\n"); 
		query.append("    ORDER BY N1ST_LODG_ETD, OPR_CD" ).append("\n"); 

	}
}